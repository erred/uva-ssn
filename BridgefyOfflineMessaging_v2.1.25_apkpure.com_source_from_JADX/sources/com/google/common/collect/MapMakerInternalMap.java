package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class MapMakerInternalMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final Queue<? extends Object> DISCARDING_QUEUE = new AbstractQueue<Object>() {
        public boolean offer(Object obj) {
            return true;
        }

        public Object peek() {
            return null;
        }

        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }

        public Iterator<Object> iterator() {
            return Iterators.emptyIterator();
        }
    };
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final ValueReference<Object, Object> UNSET = new ValueReference<Object, Object>() {
        public void clear(ValueReference<Object, Object> valueReference) {
        }

        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public Object get() {
            return null;
        }

        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        public boolean isComputingReference() {
            return false;
        }

        public Object waitForValue() {
            return null;
        }
    };
    private static final Logger logger = Logger.getLogger(MapMakerInternalMap.class.getName());
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient EntryFactory entryFactory;
    transient Set<Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final Strength keyStrength;
    final int maximumSize;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence = this.valueStrength.defaultEquivalence();
    final Strength valueStrength;
    transient Collection<V> values;

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            throw new UnsupportedOperationException();
        }

        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final int maximumSize;
        final RemovalListener<? super K, ? super V> removalListener;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, RemovalListener<? super K, ? super V> removalListener2, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maximumSize = i;
            this.concurrencyLevel = i2;
            this.removalListener = removalListener2;
            this.delegate = concurrentMap;
        }

        /* access modifiers changed from: protected */
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        /* access modifiers changed from: 0000 */
        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Entry entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* access modifiers changed from: 0000 */
        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            MapMaker concurrencyLevel2 = new MapMaker().initialCapacity(objectInputStream.readInt()).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence((Equivalence) this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
            concurrencyLevel2.removalListener(this.removalListener);
            if (this.expireAfterWriteNanos > 0) {
                concurrencyLevel2.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
            }
            if (this.expireAfterAccessNanos > 0) {
                concurrencyLevel2.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
            }
            if (this.maximumSize != -1) {
                concurrencyLevel2.maximumSize(this.maximumSize);
            }
            return concurrencyLevel2;
        }

        /* access modifiers changed from: 0000 */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.delegate.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }
    }

    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?> mapMakerInternalMap) {
            this.mapReference = new WeakReference<>(mapMakerInternalMap);
        }

        public void run() {
            MapMakerInternalMap mapMakerInternalMap = (MapMakerInternalMap) this.mapReference.get();
            if (mapMakerInternalMap != null) {
                for (Segment<K, V> runCleanup : mapMakerInternalMap.segments) {
                    runCleanup.runCleanup();
                }
                return;
            }
            throw new CancellationException();
        }
    }

    enum EntryFactory {
        STRONG {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k, i, referenceEntry);
            }
        },
        STRONG_EXPIRABLE {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongExpirableEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_EVICTABLE {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongEvictableEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        STRONG_EXPIRABLE_EVICTABLE {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new StrongExpirableEvictableEntry(k, i, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }
        },
        WEAK_EXPIRABLE {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakExpirableEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_EVICTABLE {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakEvictableEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        },
        WEAK_EXPIRABLE_EVICTABLE {
            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return new WeakExpirableEvictableEntry(segment.keyReferenceQueue, k, i, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyExpirableEntry(referenceEntry, copyEntry);
                copyEvictableEntry(referenceEntry, copyEntry);
                return copyEntry;
            }
        };
        
        static final int EVICTABLE_MASK = 2;
        static final int EXPIRABLE_MASK = 1;
        static final EntryFactory[][] factories = null;

        /* access modifiers changed from: 0000 */
        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, ReferenceEntry<K, V> referenceEntry);

        static {
            factories = new EntryFactory[][]{new EntryFactory[]{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE}, new EntryFactory[0], new EntryFactory[]{WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE}};
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[strength.ordinal()][z | (z2 ? (char) 2 : 0)];
        }

        /* access modifiers changed from: 0000 */
        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        /* access modifiers changed from: 0000 */
        public <K, V> void copyExpirableEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setExpirationTime(referenceEntry.getExpirationTime());
            MapMakerInternalMap.connectExpirables(referenceEntry.getPreviousExpirable(), referenceEntry2);
            MapMakerInternalMap.connectExpirables(referenceEntry2, referenceEntry.getNextExpirable());
            MapMakerInternalMap.nullifyExpirable(referenceEntry);
        }

        /* access modifiers changed from: 0000 */
        public <K, V> void copyEvictableEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            MapMakerInternalMap.connectEvictables(referenceEntry.getPreviousEvictable(), referenceEntry2);
            MapMakerInternalMap.connectEvictables(referenceEntry2, referenceEntry.getNextEvictable());
            MapMakerInternalMap.nullifyEvictable(referenceEntry);
        }
    }

    final class EntryIterator extends HashIterator<Entry<K, V>> {
        EntryIterator() {
            super();
        }

        public Entry<K, V> next() {
            return nextEntry();
        }
    }

    final class EntrySet extends AbstractSet<Entry<K, V>> {
        EntrySet() {
        }

        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null) {
                return false;
            }
            Object obj2 = MapMakerInternalMap.this.get(key);
            if (obj2 != null && MapMakerInternalMap.this.valueEquivalence.equivalent(entry.getValue(), obj2)) {
                z = true;
            }
            return z;
        }

        public boolean remove(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key != null && MapMakerInternalMap.this.remove(key, entry.getValue())) {
                z = true;
            }
            return z;
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    static final class EvictionQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>() {
            ReferenceEntry<K, V> nextEvictable = this;
            ReferenceEntry<K, V> previousEvictable = this;

            public ReferenceEntry<K, V> getNextEvictable() {
                return this.nextEvictable;
            }

            public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
                this.nextEvictable = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousEvictable() {
                return this.previousEvictable;
            }

            public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
                this.previousEvictable = referenceEntry;
            }
        };

        EvictionQueue() {
        }

        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            MapMakerInternalMap.connectEvictables(referenceEntry.getPreviousEvictable(), referenceEntry.getNextEvictable());
            MapMakerInternalMap.connectEvictables(this.head.getPreviousEvictable(), referenceEntry);
            MapMakerInternalMap.connectEvictables(referenceEntry, this.head);
            return true;
        }

        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextEvictable = this.head.getNextEvictable();
            if (nextEvictable == this.head) {
                return null;
            }
            return nextEvictable;
        }

        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextEvictable = this.head.getNextEvictable();
            if (nextEvictable == this.head) {
                return null;
            }
            remove(nextEvictable);
            return nextEvictable;
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousEvictable = referenceEntry.getPreviousEvictable();
            ReferenceEntry nextEvictable = referenceEntry.getNextEvictable();
            MapMakerInternalMap.connectEvictables(previousEvictable, nextEvictable);
            MapMakerInternalMap.nullifyEvictable(referenceEntry);
            return nextEvictable != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextEvictable() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.head.getNextEvictable() == this.head;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextEvictable = this.head.getNextEvictable(); nextEvictable != this.head; nextEvictable = nextEvictable.getNextEvictable()) {
                i++;
            }
            return i;
        }

        public void clear() {
            ReferenceEntry<K, V> nextEvictable = this.head.getNextEvictable();
            while (nextEvictable != this.head) {
                ReferenceEntry nextEvictable2 = nextEvictable.getNextEvictable();
                MapMakerInternalMap.nullifyEvictable(nextEvictable);
                nextEvictable = nextEvictable2;
            }
            this.head.setNextEvictable(this.head);
            this.head.setPreviousEvictable(this.head);
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* access modifiers changed from: protected */
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextEvictable = referenceEntry.getNextEvictable();
                    if (nextEvictable == EvictionQueue.this.head) {
                        return null;
                    }
                    return nextEvictable;
                }
            };
        }
    }

    static final class ExpirationQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>() {
            ReferenceEntry<K, V> nextExpirable = this;
            ReferenceEntry<K, V> previousExpirable = this;

            public long getExpirationTime() {
                return Long.MAX_VALUE;
            }

            public void setExpirationTime(long j) {
            }

            public ReferenceEntry<K, V> getNextExpirable() {
                return this.nextExpirable;
            }

            public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
                this.nextExpirable = referenceEntry;
            }

            public ReferenceEntry<K, V> getPreviousExpirable() {
                return this.previousExpirable;
            }

            public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
                this.previousExpirable = referenceEntry;
            }
        };

        ExpirationQueue() {
        }

        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            MapMakerInternalMap.connectExpirables(referenceEntry.getPreviousExpirable(), referenceEntry.getNextExpirable());
            MapMakerInternalMap.connectExpirables(this.head.getPreviousExpirable(), referenceEntry);
            MapMakerInternalMap.connectExpirables(referenceEntry, this.head);
            return true;
        }

        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextExpirable = this.head.getNextExpirable();
            if (nextExpirable == this.head) {
                return null;
            }
            return nextExpirable;
        }

        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextExpirable = this.head.getNextExpirable();
            if (nextExpirable == this.head) {
                return null;
            }
            remove(nextExpirable);
            return nextExpirable;
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousExpirable = referenceEntry.getPreviousExpirable();
            ReferenceEntry nextExpirable = referenceEntry.getNextExpirable();
            MapMakerInternalMap.connectExpirables(previousExpirable, nextExpirable);
            MapMakerInternalMap.nullifyExpirable(referenceEntry);
            return nextExpirable != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextExpirable() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.head.getNextExpirable() == this.head;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextExpirable = this.head.getNextExpirable(); nextExpirable != this.head; nextExpirable = nextExpirable.getNextExpirable()) {
                i++;
            }
            return i;
        }

        public void clear() {
            ReferenceEntry<K, V> nextExpirable = this.head.getNextExpirable();
            while (nextExpirable != this.head) {
                ReferenceEntry nextExpirable2 = nextExpirable.getNextExpirable();
                MapMakerInternalMap.nullifyExpirable(nextExpirable);
                nextExpirable = nextExpirable2;
            }
            this.head.setNextExpirable(this.head);
            this.head.setPreviousExpirable(this.head);
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* access modifiers changed from: protected */
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextExpirable = referenceEntry.getNextExpirable();
                    if (nextExpirable == ExpirationQueue.this.head) {
                        return null;
                    }
                    return nextExpirable;
                }
            };
        }
    }

    abstract class HashIterator<E> implements Iterator<E> {
        Segment<K, V> currentSegment;
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;
        WriteThroughEntry lastReturned;
        ReferenceEntry<K, V> nextEntry;
        WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        public abstract E next();

        HashIterator() {
            this.nextSegmentIndex = MapMakerInternalMap.this.segments.length - 1;
            advance();
        }

        /* access modifiers changed from: 0000 */
        public final void advance() {
            this.nextExternal = null;
            if (!nextInChain() && !nextInTable()) {
                while (this.nextSegmentIndex >= 0) {
                    Segment<K, V>[] segmentArr = MapMakerInternalMap.this.segments;
                    int i = this.nextSegmentIndex;
                    this.nextSegmentIndex = i - 1;
                    this.currentSegment = segmentArr[i];
                    if (this.currentSegment.count != 0) {
                        this.currentTable = this.currentSegment.table;
                        this.nextTableIndex = this.currentTable.length() - 1;
                        if (nextInTable()) {
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean nextInChain() {
            if (this.nextEntry != null) {
                do {
                    this.nextEntry = this.nextEntry.getNext();
                    if (this.nextEntry != null) {
                    }
                } while (!advanceTo(this.nextEntry));
                return true;
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean nextInTable() {
            while (this.nextTableIndex >= 0) {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.currentTable;
                int i = this.nextTableIndex;
                this.nextTableIndex = i - 1;
                ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i);
                this.nextEntry = referenceEntry;
                if (referenceEntry != null && (advanceTo(this.nextEntry) || nextInChain())) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean advanceTo(ReferenceEntry<K, V> referenceEntry) {
            boolean z;
            try {
                Object key = referenceEntry.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(referenceEntry);
                if (liveValue != null) {
                    this.nextExternal = new WriteThroughEntry<>(key, liveValue);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.currentSegment.postReadCleanup();
            }
        }

        public boolean hasNext() {
            return this.nextExternal != null;
        }

        /* access modifiers changed from: 0000 */
        public WriteThroughEntry nextEntry() {
            if (this.nextExternal != null) {
                this.lastReturned = this.nextExternal;
                advance();
                return this.lastReturned;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.lastReturned != null);
            MapMakerInternalMap.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    final class KeyIterator extends HashIterator<K> {
        KeyIterator() {
            super();
        }

        public K next() {
            return nextEntry().getKey();
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        public long getExpirationTime() {
            return 0;
        }

        public int getHash() {
            return 0;
        }

        public Object getKey() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNextEvictable() {
            return this;
        }

        public ReferenceEntry<Object, Object> getNextExpirable() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousEvictable() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousExpirable() {
            return this;
        }

        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        public void setExpirationTime(long j) {
        }

        public void setNextEvictable(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setNextExpirable(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousEvictable(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousExpirable(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }
    }

    interface ReferenceEntry<K, V> {
        long getExpirationTime();

        int getHash();

        K getKey();

        ReferenceEntry<K, V> getNext();

        ReferenceEntry<K, V> getNextEvictable();

        ReferenceEntry<K, V> getNextExpirable();

        ReferenceEntry<K, V> getPreviousEvictable();

        ReferenceEntry<K, V> getPreviousExpirable();

        ValueReference<K, V> getValueReference();

        void setExpirationTime(long j);

        void setNextEvictable(ReferenceEntry<K, V> referenceEntry);

        void setNextExpirable(ReferenceEntry<K, V> referenceEntry);

        void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry);

        void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry);

        void setValueReference(ValueReference<K, V> valueReference);
    }

    static class Segment<K, V> extends ReentrantLock {
        volatile int count;
        final Queue<ReferenceEntry<K, V>> evictionQueue;
        final Queue<ReferenceEntry<K, V>> expirationQueue;
        final ReferenceQueue<K> keyReferenceQueue;
        final MapMakerInternalMap<K, V> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        final ReferenceQueue<V> valueReferenceQueue;

        Segment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
            ReferenceQueue<V> referenceQueue = null;
            this.keyReferenceQueue = mapMakerInternalMap.usesKeyReferences() ? new ReferenceQueue<>() : null;
            if (mapMakerInternalMap.usesValueReferences()) {
                referenceQueue = new ReferenceQueue<>();
            }
            this.valueReferenceQueue = referenceQueue;
            this.recencyQueue = (mapMakerInternalMap.evictsBySize() || mapMakerInternalMap.expiresAfterAccess()) ? new ConcurrentLinkedQueue<>() : MapMakerInternalMap.discardingQueue();
            this.evictionQueue = mapMakerInternalMap.evictsBySize() ? new EvictionQueue<>() : MapMakerInternalMap.discardingQueue();
            this.expirationQueue = mapMakerInternalMap.expires() ? new ExpirationQueue<>() : MapMakerInternalMap.discardingQueue();
        }

        /* access modifiers changed from: 0000 */
        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        /* access modifiers changed from: 0000 */
        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (this.threshold == this.maxSegmentSize) {
                this.threshold++;
            }
            this.table = atomicReferenceArray;
        }

        /* access modifiers changed from: 0000 */
        public ReferenceEntry<K, V> newEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            return this.map.entryFactory.newEntry(this, k, i, referenceEntry);
        }

        /* access modifiers changed from: 0000 */
        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference valueReference = referenceEntry.getValueReference();
            Object obj = valueReference.get();
            if (obj == null && !valueReference.isComputingReference()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.entryFactory.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, obj, copyEntry));
            return copyEntry;
        }

        /* access modifiers changed from: 0000 */
        public void setValue(ReferenceEntry<K, V> referenceEntry, V v) {
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, v));
            recordWrite(referenceEntry);
        }

        /* access modifiers changed from: 0000 */
        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimKey((ReferenceEntry) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: 0000 */
        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimValue((ValueReference) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: 0000 */
        public void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        /* access modifiers changed from: 0000 */
        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: 0000 */
        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: 0000 */
        public void recordRead(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.expiresAfterAccess()) {
                recordExpirationTime(referenceEntry, this.map.expireAfterAccessNanos);
            }
            this.recencyQueue.add(referenceEntry);
        }

        /* access modifiers changed from: 0000 */
        public void recordLockedRead(ReferenceEntry<K, V> referenceEntry) {
            this.evictionQueue.add(referenceEntry);
            if (this.map.expiresAfterAccess()) {
                recordExpirationTime(referenceEntry, this.map.expireAfterAccessNanos);
                this.expirationQueue.add(referenceEntry);
            }
        }

        /* access modifiers changed from: 0000 */
        public void recordWrite(ReferenceEntry<K, V> referenceEntry) {
            drainRecencyQueue();
            this.evictionQueue.add(referenceEntry);
            if (this.map.expires()) {
                recordExpirationTime(referenceEntry, this.map.expiresAfterAccess() ? this.map.expireAfterAccessNanos : this.map.expireAfterWriteNanos);
                this.expirationQueue.add(referenceEntry);
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainRecencyQueue() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.recencyQueue.poll();
                if (referenceEntry != null) {
                    if (this.evictionQueue.contains(referenceEntry)) {
                        this.evictionQueue.add(referenceEntry);
                    }
                    if (this.map.expiresAfterAccess() && this.expirationQueue.contains(referenceEntry)) {
                        this.expirationQueue.add(referenceEntry);
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void recordExpirationTime(ReferenceEntry<K, V> referenceEntry, long j) {
            referenceEntry.setExpirationTime(this.map.ticker.read() + j);
        }

        /* access modifiers changed from: 0000 */
        public void tryExpireEntries() {
            if (tryLock()) {
                try {
                    expireEntries();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void expireEntries() {
            ReferenceEntry referenceEntry;
            drainRecencyQueue();
            if (!this.expirationQueue.isEmpty()) {
                long read = this.map.ticker.read();
                do {
                    referenceEntry = (ReferenceEntry) this.expirationQueue.peek();
                    if (referenceEntry == null || !this.map.isExpired(referenceEntry, read)) {
                        return;
                    }
                } while (removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: 0000 */
        public void enqueueNotification(ReferenceEntry<K, V> referenceEntry, RemovalCause removalCause) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), removalCause);
        }

        /* access modifiers changed from: 0000 */
        public void enqueueNotification(K k, int i, V v, RemovalCause removalCause) {
            if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(new RemovalNotification(k, v, removalCause));
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean evictEntries() {
            if (!this.map.evictsBySize() || this.count < this.maxSegmentSize) {
                return false;
            }
            drainRecencyQueue();
            ReferenceEntry referenceEntry = (ReferenceEntry) this.evictionQueue.remove();
            if (removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                return true;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: 0000 */
        public ReferenceEntry<K, V> getFirst(int i) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return (ReferenceEntry) atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: 0000 */
        public ReferenceEntry<K, V> getEntry(Object obj, int i) {
            if (this.count != 0) {
                for (ReferenceEntry<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                    if (first.getHash() == i) {
                        Object key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public ReferenceEntry<K, V> getLiveEntry(Object obj, int i) {
            ReferenceEntry<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.expires() || !this.map.isExpired(entry)) {
                return entry;
            }
            tryExpireEntries();
            return null;
        }

        /* access modifiers changed from: 0000 */
        public V get(Object obj, int i) {
            try {
                ReferenceEntry liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V v = liveEntry.getValueReference().get();
                if (v != null) {
                    recordRead(liveEntry);
                } else {
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return v;
            } finally {
                postReadCleanup();
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    ReferenceEntry liveEntry = getLiveEntry(obj, i);
                    if (liveEntry == null) {
                        return false;
                    }
                    if (liveEntry.getValueReference().get() != null) {
                        z = true;
                    }
                    postReadCleanup();
                    return z;
                }
                postReadCleanup();
                return false;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: 0000 */
        @VisibleForTesting
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            Object liveValue = getLiveValue(referenceEntry);
                            if (liveValue != null) {
                                if (this.map.valueEquivalence.equivalent(obj, liveValue)) {
                                    postReadCleanup();
                                    return true;
                                }
                            }
                        }
                    }
                }
                postReadCleanup();
                return false;
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            r1 = r4.getValueReference();
            r2 = r1.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
            if (r2 != null) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
            r8.modCount++;
            setValue(r4, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            if (r1.isComputingReference() != false) goto L_0x005f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
            enqueueNotification(r9, r10, r2, com.google.common.collect.MapMaker.RemovalCause.COLLECTED);
            r0 = r8.count;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
            if (evictEntries() == false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
            r0 = r8.count + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
            r8.count = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
            if (r12 == false) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            recordLockedRead(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r8.modCount++;
            enqueueNotification(r9, r10, r2, com.google.common.collect.MapMaker.RemovalCause.REPLACED);
            setValue(r4, r11);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V put(K r9, int r10, V r11, boolean r12) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch:{ all -> 0x00af }
                int r0 = r8.count     // Catch:{ all -> 0x00af }
                int r0 = r0 + 1
                int r1 = r8.threshold     // Catch:{ all -> 0x00af }
                if (r0 <= r1) goto L_0x0015
                r8.expand()     // Catch:{ all -> 0x00af }
                int r0 = r8.count     // Catch:{ all -> 0x00af }
                int r0 = r0 + 1
            L_0x0015:
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$ReferenceEntry<K, V>> r1 = r8.table     // Catch:{ all -> 0x00af }
                int r2 = r1.length()     // Catch:{ all -> 0x00af }
                int r2 = r2 + -1
                r2 = r2 & r10
                java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00af }
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r3 = (com.google.common.collect.MapMakerInternalMap.ReferenceEntry) r3     // Catch:{ all -> 0x00af }
                r4 = r3
            L_0x0025:
                r5 = 0
                if (r4 == 0) goto L_0x0092
                java.lang.Object r6 = r4.getKey()     // Catch:{ all -> 0x00af }
                int r7 = r4.getHash()     // Catch:{ all -> 0x00af }
                if (r7 != r10) goto L_0x008d
                if (r6 == 0) goto L_0x008d
                com.google.common.collect.MapMakerInternalMap<K, V> r7 = r8.map     // Catch:{ all -> 0x00af }
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch:{ all -> 0x00af }
                boolean r6 = r7.equivalent(r9, r6)     // Catch:{ all -> 0x00af }
                if (r6 == 0) goto L_0x008d
                com.google.common.collect.MapMakerInternalMap$ValueReference r1 = r4.getValueReference()     // Catch:{ all -> 0x00af }
                java.lang.Object r2 = r1.get()     // Catch:{ all -> 0x00af }
                if (r2 != 0) goto L_0x0072
                int r12 = r8.modCount     // Catch:{ all -> 0x00af }
                int r12 = r12 + 1
                r8.modCount = r12     // Catch:{ all -> 0x00af }
                r8.setValue(r4, r11)     // Catch:{ all -> 0x00af }
                boolean r11 = r1.isComputingReference()     // Catch:{ all -> 0x00af }
                if (r11 != 0) goto L_0x005f
                com.google.common.collect.MapMaker$RemovalCause r11 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch:{ all -> 0x00af }
                r8.enqueueNotification(r9, r10, r2, r11)     // Catch:{ all -> 0x00af }
                int r0 = r8.count     // Catch:{ all -> 0x00af }
                goto L_0x0069
            L_0x005f:
                boolean r9 = r8.evictEntries()     // Catch:{ all -> 0x00af }
                if (r9 == 0) goto L_0x0069
                int r9 = r8.count     // Catch:{ all -> 0x00af }
                int r0 = r9 + 1
            L_0x0069:
                r8.count = r0     // Catch:{ all -> 0x00af }
            L_0x006b:
                r8.unlock()
                r8.postWriteCleanup()
                return r5
            L_0x0072:
                if (r12 == 0) goto L_0x007e
                r8.recordLockedRead(r4)     // Catch:{ all -> 0x00af }
            L_0x0077:
                r8.unlock()
                r8.postWriteCleanup()
                return r2
            L_0x007e:
                int r12 = r8.modCount     // Catch:{ all -> 0x00af }
                int r12 = r12 + 1
                r8.modCount = r12     // Catch:{ all -> 0x00af }
                com.google.common.collect.MapMaker$RemovalCause r12 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch:{ all -> 0x00af }
                r8.enqueueNotification(r9, r10, r2, r12)     // Catch:{ all -> 0x00af }
                r8.setValue(r4, r11)     // Catch:{ all -> 0x00af }
                goto L_0x0077
            L_0x008d:
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r4 = r4.getNext()     // Catch:{ all -> 0x00af }
                goto L_0x0025
            L_0x0092:
                int r12 = r8.modCount     // Catch:{ all -> 0x00af }
                int r12 = r12 + 1
                r8.modCount = r12     // Catch:{ all -> 0x00af }
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r9 = r8.newEntry(r9, r10, r3)     // Catch:{ all -> 0x00af }
                r8.setValue(r9, r11)     // Catch:{ all -> 0x00af }
                r1.set(r2, r9)     // Catch:{ all -> 0x00af }
                boolean r9 = r8.evictEntries()     // Catch:{ all -> 0x00af }
                if (r9 == 0) goto L_0x00ac
                int r9 = r8.count     // Catch:{ all -> 0x00af }
                int r0 = r9 + 1
            L_0x00ac:
                r8.count = r0     // Catch:{ all -> 0x00af }
                goto L_0x006b
            L_0x00af:
                r9 = move-exception
                r8.unlock()
                r8.postWriteCleanup()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        /* access modifiers changed from: 0000 */
        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
                this.threshold = (newEntryArray.length() * 3) / 4;
                int length2 = newEntryArray.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2);
                    if (referenceEntry != null) {
                        ReferenceEntry next = referenceEntry.getNext();
                        int hash = referenceEntry.getHash() & length2;
                        if (next == null) {
                            newEntryArray.set(hash, referenceEntry);
                        } else {
                            ReferenceEntry referenceEntry2 = referenceEntry;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    referenceEntry2 = next;
                                    hash = hash2;
                                }
                                next = next.getNext();
                            }
                            newEntryArray.set(hash, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int hash3 = referenceEntry.getHash() & length2;
                                ReferenceEntry copyEntry = copyEntry(referenceEntry, (ReferenceEntry) newEntryArray.get(hash3));
                                if (copyEntry != null) {
                                    newEntryArray.set(hash3, copyEntry);
                                } else {
                                    removeCollectedEntry(referenceEntry);
                                    i--;
                                }
                                referenceEntry = referenceEntry.getNext();
                            }
                        }
                    }
                }
                this.table = newEntryArray;
                this.count = i;
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
            r7 = r4.getValueReference();
            r8 = r7.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
            if (r8 != null) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
            if (isCollected(r7) == false) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            r10 = r9.count;
            r9.modCount++;
            enqueueNotification(r6, r11, r8, com.google.common.collect.MapMaker.RemovalCause.COLLECTED);
            r11 = r9.count - 1;
            r0.set(r1, removeFromChain(r3, r4));
            r9.count = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
            if (r9.map.valueEquivalence.equivalent(r12, r8) == false) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
            r9.modCount++;
            enqueueNotification(r10, r11, r8, com.google.common.collect.MapMaker.RemovalCause.REPLACED);
            setValue(r4, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            recordLockedRead(r4);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean replace(K r10, int r11, V r12, V r13) {
            /*
                r9 = this;
                r9.lock()
                r9.preWriteCleanup()     // Catch:{ all -> 0x0085 }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$ReferenceEntry<K, V>> r0 = r9.table     // Catch:{ all -> 0x0085 }
                int r1 = r0.length()     // Catch:{ all -> 0x0085 }
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r11
                java.lang.Object r3 = r0.get(r1)     // Catch:{ all -> 0x0085 }
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r3 = (com.google.common.collect.MapMakerInternalMap.ReferenceEntry) r3     // Catch:{ all -> 0x0085 }
                r4 = r3
            L_0x0016:
                r5 = 0
                if (r4 == 0) goto L_0x0057
                java.lang.Object r6 = r4.getKey()     // Catch:{ all -> 0x0085 }
                int r7 = r4.getHash()     // Catch:{ all -> 0x0085 }
                if (r7 != r11) goto L_0x0080
                if (r6 == 0) goto L_0x0080
                com.google.common.collect.MapMakerInternalMap<K, V> r7 = r9.map     // Catch:{ all -> 0x0085 }
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch:{ all -> 0x0085 }
                boolean r7 = r7.equivalent(r10, r6)     // Catch:{ all -> 0x0085 }
                if (r7 == 0) goto L_0x0080
                com.google.common.collect.MapMakerInternalMap$ValueReference r7 = r4.getValueReference()     // Catch:{ all -> 0x0085 }
                java.lang.Object r8 = r7.get()     // Catch:{ all -> 0x0085 }
                if (r8 != 0) goto L_0x005e
                boolean r10 = r9.isCollected(r7)     // Catch:{ all -> 0x0085 }
                if (r10 == 0) goto L_0x0057
                int r10 = r9.count     // Catch:{ all -> 0x0085 }
                int r10 = r9.modCount     // Catch:{ all -> 0x0085 }
                int r10 = r10 + r2
                r9.modCount = r10     // Catch:{ all -> 0x0085 }
                com.google.common.collect.MapMaker$RemovalCause r10 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch:{ all -> 0x0085 }
                r9.enqueueNotification(r6, r11, r8, r10)     // Catch:{ all -> 0x0085 }
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r10 = r9.removeFromChain(r3, r4)     // Catch:{ all -> 0x0085 }
                int r11 = r9.count     // Catch:{ all -> 0x0085 }
                int r11 = r11 - r2
                r0.set(r1, r10)     // Catch:{ all -> 0x0085 }
                r9.count = r11     // Catch:{ all -> 0x0085 }
            L_0x0057:
                r9.unlock()
                r9.postWriteCleanup()
                return r5
            L_0x005e:
                com.google.common.collect.MapMakerInternalMap<K, V> r0 = r9.map     // Catch:{ all -> 0x0085 }
                com.google.common.base.Equivalence<java.lang.Object> r0 = r0.valueEquivalence     // Catch:{ all -> 0x0085 }
                boolean r12 = r0.equivalent(r12, r8)     // Catch:{ all -> 0x0085 }
                if (r12 == 0) goto L_0x007c
                int r12 = r9.modCount     // Catch:{ all -> 0x0085 }
                int r12 = r12 + r2
                r9.modCount = r12     // Catch:{ all -> 0x0085 }
                com.google.common.collect.MapMaker$RemovalCause r12 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch:{ all -> 0x0085 }
                r9.enqueueNotification(r10, r11, r8, r12)     // Catch:{ all -> 0x0085 }
                r9.setValue(r4, r13)     // Catch:{ all -> 0x0085 }
                r9.unlock()
                r9.postWriteCleanup()
                return r2
            L_0x007c:
                r9.recordLockedRead(r4)     // Catch:{ all -> 0x0085 }
                goto L_0x0057
            L_0x0080:
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r4 = r4.getNext()     // Catch:{ all -> 0x0085 }
                goto L_0x0016
            L_0x0085:
                r10 = move-exception
                r9.unlock()
                r9.postWriteCleanup()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
            r6 = r3.getValueReference();
            r7 = r6.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
            if (r7 != null) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
            if (isCollected(r6) == false) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            r9 = r8.count;
            r8.modCount++;
            enqueueNotification(r5, r10, r7, com.google.common.collect.MapMaker.RemovalCause.COLLECTED);
            r10 = r8.count - 1;
            r0.set(r1, removeFromChain(r2, r3));
            r8.count = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r8.modCount++;
            enqueueNotification(r9, r10, r7, com.google.common.collect.MapMaker.RemovalCause.REPLACED);
            setValue(r3, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
            return r7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V replace(K r9, int r10, V r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch:{ all -> 0x007a }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$ReferenceEntry<K, V>> r0 = r8.table     // Catch:{ all -> 0x007a }
                int r1 = r0.length()     // Catch:{ all -> 0x007a }
                int r1 = r1 + -1
                r1 = r1 & r10
                java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x007a }
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r2 = (com.google.common.collect.MapMakerInternalMap.ReferenceEntry) r2     // Catch:{ all -> 0x007a }
                r3 = r2
            L_0x0016:
                r4 = 0
                if (r3 == 0) goto L_0x0059
                java.lang.Object r5 = r3.getKey()     // Catch:{ all -> 0x007a }
                int r6 = r3.getHash()     // Catch:{ all -> 0x007a }
                if (r6 != r10) goto L_0x0075
                if (r5 == 0) goto L_0x0075
                com.google.common.collect.MapMakerInternalMap<K, V> r6 = r8.map     // Catch:{ all -> 0x007a }
                com.google.common.base.Equivalence<java.lang.Object> r6 = r6.keyEquivalence     // Catch:{ all -> 0x007a }
                boolean r6 = r6.equivalent(r9, r5)     // Catch:{ all -> 0x007a }
                if (r6 == 0) goto L_0x0075
                com.google.common.collect.MapMakerInternalMap$ValueReference r6 = r3.getValueReference()     // Catch:{ all -> 0x007a }
                java.lang.Object r7 = r6.get()     // Catch:{ all -> 0x007a }
                if (r7 != 0) goto L_0x0060
                boolean r9 = r8.isCollected(r6)     // Catch:{ all -> 0x007a }
                if (r9 == 0) goto L_0x0059
                int r9 = r8.count     // Catch:{ all -> 0x007a }
                int r9 = r8.modCount     // Catch:{ all -> 0x007a }
                int r9 = r9 + 1
                r8.modCount = r9     // Catch:{ all -> 0x007a }
                com.google.common.collect.MapMaker$RemovalCause r9 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch:{ all -> 0x007a }
                r8.enqueueNotification(r5, r10, r7, r9)     // Catch:{ all -> 0x007a }
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r9 = r8.removeFromChain(r2, r3)     // Catch:{ all -> 0x007a }
                int r10 = r8.count     // Catch:{ all -> 0x007a }
                int r10 = r10 + -1
                r0.set(r1, r9)     // Catch:{ all -> 0x007a }
                r8.count = r10     // Catch:{ all -> 0x007a }
            L_0x0059:
                r8.unlock()
                r8.postWriteCleanup()
                return r4
            L_0x0060:
                int r0 = r8.modCount     // Catch:{ all -> 0x007a }
                int r0 = r0 + 1
                r8.modCount = r0     // Catch:{ all -> 0x007a }
                com.google.common.collect.MapMaker$RemovalCause r0 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch:{ all -> 0x007a }
                r8.enqueueNotification(r9, r10, r7, r0)     // Catch:{ all -> 0x007a }
                r8.setValue(r3, r11)     // Catch:{ all -> 0x007a }
                r8.unlock()
                r8.postWriteCleanup()
                return r7
            L_0x0075:
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r3 = r3.getNext()     // Catch:{ all -> 0x007a }
                goto L_0x0016
            L_0x007a:
                r9 = move-exception
                r8.unlock()
                r8.postWriteCleanup()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }

        /* access modifiers changed from: 0000 */
        public V remove(Object obj, int i) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (isCollected(valueReference)) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        enqueueNotification(key, i, v, removalCause);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain(referenceEntry, referenceEntry2));
                        this.count = i3;
                        return v;
                    }
                }
                unlock();
                postWriteCleanup();
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean remove(Object obj, int i, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (this.map.valueEquivalence.equivalent(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (isCollected(valueReference)) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        enqueueNotification(key, i, obj3, removalCause);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain(referenceEntry, referenceEntry2));
                        this.count = i3;
                        if (removalCause != RemovalCause.EXPLICIT) {
                            z = false;
                        }
                        return z;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: 0000 */
        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                        for (int i = 0; i < atomicReferenceArray.length(); i++) {
                            for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                                if (!referenceEntry.getValueReference().isComputingReference()) {
                                    enqueueNotification(referenceEntry, RemovalCause.EXPLICIT);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.evictionQueue.clear();
                    this.expirationQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public ReferenceEntry<K, V> removeFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            this.evictionQueue.remove(referenceEntry2);
            this.expirationQueue.remove(referenceEntry2);
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        /* access modifiers changed from: 0000 */
        public void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry, RemovalCause.COLLECTED);
            this.evictionQueue.remove(referenceEntry);
            this.expirationQueue.remove(referenceEntry);
        }

        /* access modifiers changed from: 0000 */
        public boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        enqueueNotification(referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), RemovalCause.COLLECTED);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain(referenceEntry2, referenceEntry3));
                        this.count = i3;
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean reclaimValue(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == valueReference) {
                        this.modCount++;
                        enqueueNotification(k, i, valueReference.get(), RemovalCause.COLLECTED);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain(referenceEntry, referenceEntry2));
                        this.count = i3;
                        return true;
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean clearValue(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == valueReference) {
                        atomicReferenceArray.set(length, removeFromChain(referenceEntry, referenceEntry2));
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            int i2 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    enqueueNotification(referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), removalCause);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain(referenceEntry2, referenceEntry3));
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public boolean isCollected(ValueReference<K, V> valueReference) {
            boolean z = false;
            if (valueReference.isComputingReference()) {
                return false;
            }
            if (valueReference.get() == null) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public V getLiveValue(ReferenceEntry<K, V> referenceEntry) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (!this.map.expires() || !this.map.isExpired(referenceEntry)) {
                return v;
            } else {
                tryExpireEntries();
                return null;
            }
        }

        /* access modifiers changed from: 0000 */
        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        /* access modifiers changed from: 0000 */
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* access modifiers changed from: 0000 */
        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        /* access modifiers changed from: 0000 */
        public void runCleanup() {
            runLockedCleanup();
            runUnlockedCleanup();
        }

        /* access modifiers changed from: 0000 */
        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.processPendingNotifications();
            }
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, removalListener, concurrentMap);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).makeMap();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }
    }

    static class SoftEntry<K, V> extends SoftReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = MapMakerInternalMap.unset();

        SoftEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.hash = i;
            this.next = referenceEntry;
        }

        public K getKey() {
            return get();
        }

        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            ValueReference<K, V> valueReference3 = this.valueReference;
            this.valueReference = valueReference2;
            valueReference3.clear(valueReference2);
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class SoftEvictableEntry<K, V> extends SoftEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        SoftEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    static final class SoftExpirableEntry<K, V> extends SoftEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        volatile long time = Long.MAX_VALUE;

        SoftExpirableEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getExpirationTime() {
            return this.time;
        }

        public void setExpirationTime(long j) {
            this.time = j;
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }
    }

    static final class SoftExpirableEvictableEntry<K, V> extends SoftEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        volatile long time = Long.MAX_VALUE;

        SoftExpirableEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getExpirationTime() {
            return this.time;
        }

        public void setExpirationTime(long j) {
            this.time = j;
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    static final class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public boolean isComputingReference() {
            return false;
        }

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        public void clear(ValueReference<K, V> valueReference) {
            clear();
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v, referenceEntry);
        }

        public V waitForValue() {
            return get();
        }
    }

    enum Strength {
        STRONG {
            /* access modifiers changed from: 0000 */
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new StrongValueReference(v);
            }

            /* access modifiers changed from: 0000 */
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT {
            /* access modifiers changed from: 0000 */
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new SoftValueReference(segment.valueReferenceQueue, v, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK {
            /* access modifiers changed from: 0000 */
            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v) {
                return new WeakValueReference(segment.valueReferenceQueue, v, referenceEntry);
            }

            /* access modifiers changed from: 0000 */
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* access modifiers changed from: 0000 */
        public abstract Equivalence<Object> defaultEquivalence();

        /* access modifiers changed from: 0000 */
        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v);
    }

    static class StrongEntry<K, V> implements ReferenceEntry<K, V> {
        final int hash;
        final K key;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = MapMakerInternalMap.unset();

        StrongEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            this.key = k;
            this.hash = i;
            this.next = referenceEntry;
        }

        public K getKey() {
            return this.key;
        }

        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            ValueReference<K, V> valueReference3 = this.valueReference;
            this.valueReference = valueReference2;
            valueReference3.clear(valueReference2);
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class StrongEvictableEntry<K, V> extends StrongEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        StrongEvictableEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    static final class StrongExpirableEntry<K, V> extends StrongEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        volatile long time = Long.MAX_VALUE;

        StrongExpirableEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getExpirationTime() {
            return this.time;
        }

        public void setExpirationTime(long j) {
            this.time = j;
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }
    }

    static final class StrongExpirableEvictableEntry<K, V> extends StrongEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        volatile long time = Long.MAX_VALUE;

        StrongExpirableEvictableEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        public long getExpirationTime() {
            return this.time;
        }

        public void setExpirationTime(long j) {
            this.time = j;
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    static final class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        public void clear(ValueReference<K, V> valueReference) {
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public boolean isComputingReference() {
            return false;
        }

        StrongValueReference(V v) {
            this.referent = v;
        }

        public V get() {
            return this.referent;
        }

        public V waitForValue() {
            return get();
        }
    }

    final class ValueIterator extends HashIterator<V> {
        ValueIterator() {
            super();
        }

        public V next() {
            return nextEntry().getValue();
        }
    }

    interface ValueReference<K, V> {
        void clear(ValueReference<K, V> valueReference);

        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry);

        V get();

        ReferenceEntry<K, V> getEntry();

        boolean isComputingReference();

        V waitForValue() throws ExecutionException;
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = MapMakerInternalMap.unset();

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.hash = i;
            this.next = referenceEntry;
        }

        public K getKey() {
            return get();
        }

        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            ValueReference<K, V> valueReference3 = this.valueReference;
            this.valueReference = valueReference2;
            valueReference3.clear(valueReference2);
        }

        public int getHash() {
            return this.hash;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class WeakEvictableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();

        WeakEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    static final class WeakExpirableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        volatile long time = Long.MAX_VALUE;

        WeakExpirableEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getExpirationTime() {
            return this.time;
        }

        public void setExpirationTime(long j) {
            this.time = j;
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }
    }

    static final class WeakExpirableEvictableEntry<K, V> extends WeakEntry<K, V> implements ReferenceEntry<K, V> {
        ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
        ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
        volatile long time = Long.MAX_VALUE;

        WeakExpirableEvictableEntry(ReferenceQueue<K> referenceQueue, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        public long getExpirationTime() {
            return this.time;
        }

        public void setExpirationTime(long j) {
            this.time = j;
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.nextExpirable;
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.nextExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.previousExpirable;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.previousExpirable = referenceEntry;
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.nextEvictable;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.nextEvictable = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.previousEvictable;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.previousEvictable = referenceEntry;
        }
    }

    static final class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        public boolean isComputingReference() {
            return false;
        }

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.entry = referenceEntry;
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        public void clear(ValueReference<K, V> valueReference) {
            clear();
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v, referenceEntry);
        }

        public V waitForValue() {
            return get();
        }
    }

    final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        final K key;
        V value;

        WriteThroughEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        public V setValue(V v) {
            V put = MapMakerInternalMap.this.put(this.key, v);
            this.value = v;
            return put;
        }
    }

    static int rehash(int i) {
        int i2 = i + ((i << 15) ^ -12931);
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    MapMakerInternalMap(MapMaker mapMaker) {
        this.concurrencyLevel = Math.min(mapMaker.getConcurrencyLevel(), MAX_SEGMENTS);
        this.keyStrength = mapMaker.getKeyStrength();
        this.valueStrength = mapMaker.getValueStrength();
        this.keyEquivalence = mapMaker.getKeyEquivalence();
        this.maximumSize = mapMaker.maximumSize;
        this.expireAfterAccessNanos = mapMaker.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = mapMaker.getExpireAfterWriteNanos();
        this.entryFactory = EntryFactory.getFactory(this.keyStrength, expires(), evictsBySize());
        this.ticker = mapMaker.getTicker();
        this.removalListener = mapMaker.getRemovalListener();
        this.removalNotificationQueue = this.removalListener == NullListener.INSTANCE ? discardingQueue() : new ConcurrentLinkedQueue<>();
        int min = Math.min(mapMaker.getInitialCapacity(), 1073741824);
        if (evictsBySize()) {
            min = Math.min(min, this.maximumSize);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i2 < this.concurrencyLevel && (!evictsBySize() || i2 * 2 <= this.maximumSize)) {
            i3++;
            i2 <<= 1;
        }
        this.segmentShift = 32 - i3;
        this.segmentMask = i2 - 1;
        this.segments = newSegmentArray(i2);
        int i4 = min / i2;
        if (i4 * i2 < min) {
            i4++;
        }
        int i5 = 1;
        while (i5 < i4) {
            i5 <<= 1;
        }
        if (evictsBySize()) {
            int i6 = (this.maximumSize / i2) + 1;
            int i7 = this.maximumSize % i2;
            while (i < this.segments.length) {
                if (i == i7) {
                    i6--;
                }
                this.segments[i] = createSegment(i5, i6);
                i++;
            }
            return;
        }
        while (i < this.segments.length) {
            this.segments[i] = createSegment(i5, -1);
            i++;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean evictsBySize() {
        return this.maximumSize != -1;
    }

    /* access modifiers changed from: 0000 */
    public boolean expires() {
        return expiresAfterWrite() || expiresAfterAccess();
    }

    /* access modifiers changed from: 0000 */
    public boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    /* access modifiers changed from: 0000 */
    public boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    static <K, V> ValueReference<K, V> unset() {
        return UNSET;
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return DISCARDING_QUEUE;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public ReferenceEntry<K, V> newEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
        return segmentFor(i).newEntry(k, i, referenceEntry);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return segmentFor(referenceEntry.getHash()).copyEntry(referenceEntry, referenceEntry2);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public ValueReference<K, V> newValueReference(ReferenceEntry<K, V> referenceEntry, V v) {
        return this.valueStrength.referenceValue(segmentFor(referenceEntry.getHash()), referenceEntry, v);
    }

    /* access modifiers changed from: 0000 */
    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    /* access modifiers changed from: 0000 */
    public void reclaimValue(ValueReference<K, V> valueReference) {
        ReferenceEntry entry = valueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    /* access modifiers changed from: 0000 */
    public void reclaimKey(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        segmentFor(hash).reclaimKey(referenceEntry, hash);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public boolean isLive(ReferenceEntry<K, V> referenceEntry) {
        return segmentFor(referenceEntry.getHash()).getLiveValue(referenceEntry) != null;
    }

    /* access modifiers changed from: 0000 */
    public Segment<K, V> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    /* access modifiers changed from: 0000 */
    public Segment<K, V> createSegment(int i, int i2) {
        return new Segment<>(this, i, i2);
    }

    /* access modifiers changed from: 0000 */
    public V getLiveValue(ReferenceEntry<K, V> referenceEntry) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        if (v == null) {
            return null;
        }
        if (!expires() || !isExpired(referenceEntry)) {
            return v;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public boolean isExpired(ReferenceEntry<K, V> referenceEntry) {
        return isExpired(referenceEntry, this.ticker.read());
    }

    /* access modifiers changed from: 0000 */
    public boolean isExpired(ReferenceEntry<K, V> referenceEntry, long j) {
        return j - referenceEntry.getExpirationTime() > 0;
    }

    static <K, V> void connectExpirables(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextExpirable(referenceEntry2);
        referenceEntry2.setPreviousExpirable(referenceEntry);
    }

    static <K, V> void nullifyExpirable(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry nullEntry = nullEntry();
        referenceEntry.setNextExpirable(nullEntry);
        referenceEntry.setPreviousExpirable(nullEntry);
    }

    /* access modifiers changed from: 0000 */
    public void processPendingNotifications() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.removalNotificationQueue.poll();
            if (removalNotification != null) {
                try {
                    this.removalListener.onRemoval(removalNotification);
                } catch (Exception e) {
                    logger.log(Level.WARNING, "Exception thrown by removal listener", e);
                }
            } else {
                return;
            }
        }
    }

    static <K, V> void connectEvictables(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextEvictable(referenceEntry2);
        referenceEntry2.setPreviousEvictable(referenceEntry);
    }

    static <K, V> void nullifyEvictable(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry nullEntry = nullEntry();
        referenceEntry.setNextEvictable(nullEntry);
        referenceEntry.setPreviousEvictable(nullEntry);
    }

    /* access modifiers changed from: 0000 */
    public final Segment<K, V>[] newSegmentArray(int i) {
        return new Segment[i];
    }

    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += (long) segmentArr[i].modCount;
        }
        if (j != 0) {
            for (int i2 = 0; i2 < segmentArr.length; i2++) {
                if (segmentArr[i2].count != 0) {
                    return false;
                }
                j -= (long) segmentArr[i2].modCount;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        long j = 0;
        for (Segment<K, V> segment : this.segments) {
            j += (long) segment.count;
        }
        return Ints.saturatedCast(j);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    /* access modifiers changed from: 0000 */
    public ReferenceEntry<K, V> getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    public boolean containsValue(Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return false;
        }
        Segment<K, V>[] segmentArr = this.segments;
        long j = -1;
        int i = 0;
        while (i < 3) {
            long j2 = 0;
            for (Segment<K, V> segment : segmentArr) {
                int i2 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i3); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                        Object liveValue = segment.getLiveValue(referenceEntry);
                        if (liveValue != null && this.valueEquivalence.equivalent(obj2, liveValue)) {
                            return true;
                        }
                    }
                }
                j2 += (long) segment.modCount;
            }
            if (j2 == j) {
                break;
            }
            i++;
            j = j2;
        }
        return false;
    }

    public V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, false);
    }

    public V putIfAbsent(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, true);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    public boolean replace(K k, V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v, v2);
    }

    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v);
    }

    public void clear() {
        for (Segment<K, V> clear : this.segments) {
            clear.clear();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values2 = new Values();
        this.values = values2;
        return values2;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        SerializationProxy serializationProxy = new SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
        return serializationProxy;
    }
}
