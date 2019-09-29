package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtCompatible(emulated = true)
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient BiMap<V, K> inverse;
    private transient int mask;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient int size;

    private static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        BiEntry<K, V> nextInKToVBucket;
        BiEntry<K, V> nextInVToKBucket;
        final int valueHash;

        BiEntry(K k, int i, V v, int i2) {
            super(k, v);
            this.keyHash = i;
            this.valueHash = i2;
        }
    }

    private final class EntrySet extends EntrySet<K, V> {
        private EntrySet() {
        }

        /* access modifiers changed from: 0000 */
        public Map<K, V> map() {
            return HashBiMap.this;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new Itr<Entry<K, V>>() {

                /* renamed from: com.google.common.collect.HashBiMap$EntrySet$1$MapEntry */
                class MapEntry extends AbstractMapEntry<K, V> {
                    BiEntry<K, V> delegate;

                    MapEntry(BiEntry<K, V> biEntry) {
                        this.delegate = biEntry;
                    }

                    public K getKey() {
                        return this.delegate.key;
                    }

                    public V getValue() {
                        return this.delegate.value;
                    }

                    public V setValue(V v) {
                        V v2 = this.delegate.value;
                        int access$300 = HashBiMap.hash(v);
                        if (access$300 == this.delegate.valueHash && Objects.equal(v, v2)) {
                            return v;
                        }
                        Preconditions.checkArgument(HashBiMap.this.seekByValue(v, access$300) == null, "value already present: %s", v);
                        HashBiMap.this.delete(this.delegate);
                        BiEntry<K, V> biEntry = new BiEntry<>(this.delegate.key, this.delegate.keyHash, v, access$300);
                        HashBiMap.this.insert(biEntry);
                        C24541.this.expectedModCount = HashBiMap.this.modCount;
                        if (C24541.this.toRemove == this.delegate) {
                            C24541.this.toRemove = biEntry;
                        }
                        this.delegate = biEntry;
                        return v2;
                    }
                }

                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                /* access modifiers changed from: 0000 */
                public Entry<K, V> output(BiEntry<K, V> biEntry) {
                    return new MapEntry(biEntry);
                }
            };
        }
    }

    private final class Inverse extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {

        private final class InverseKeySet extends KeySet<V, K> {
            InverseKeySet() {
                super(Inverse.this);
            }

            public boolean remove(Object obj) {
                BiEntry access$600 = HashBiMap.this.seekByValue(obj, HashBiMap.hash(obj));
                if (access$600 == null) {
                    return false;
                }
                HashBiMap.this.delete(access$600);
                return true;
            }

            public Iterator<V> iterator() {
                return new Itr<V>() {
                    {
                        HashBiMap hashBiMap = HashBiMap.this;
                    }

                    /* access modifiers changed from: 0000 */
                    public V output(BiEntry<K, V> biEntry) {
                        return biEntry.value;
                    }
                };
            }
        }

        private Inverse() {
        }

        /* access modifiers changed from: 0000 */
        public BiMap<K, V> forward() {
            return HashBiMap.this;
        }

        public int size() {
            return HashBiMap.this.size;
        }

        public void clear() {
            forward().clear();
        }

        public boolean containsKey(Object obj) {
            return forward().containsValue(obj);
        }

        public K get(Object obj) {
            BiEntry access$600 = HashBiMap.this.seekByValue(obj, HashBiMap.hash(obj));
            if (access$600 == null) {
                return null;
            }
            return access$600.key;
        }

        public K put(V v, K k) {
            return HashBiMap.this.putInverse(v, k, false);
        }

        public K forcePut(V v, K k) {
            return HashBiMap.this.putInverse(v, k, true);
        }

        public K remove(Object obj) {
            BiEntry access$600 = HashBiMap.this.seekByValue(obj, HashBiMap.hash(obj));
            if (access$600 == null) {
                return null;
            }
            HashBiMap.this.delete(access$600);
            return access$600.key;
        }

        public BiMap<K, V> inverse() {
            return forward();
        }

        public Set<V> keySet() {
            return new InverseKeySet();
        }

        public Set<K> values() {
            return forward().keySet();
        }

        public Set<Entry<V, K>> entrySet() {
            return new EntrySet<V, K>() {
                /* access modifiers changed from: 0000 */
                public Map<V, K> map() {
                    return Inverse.this;
                }

                public Iterator<Entry<V, K>> iterator() {
                    return new Itr<Entry<V, K>>() {

                        /* renamed from: com.google.common.collect.HashBiMap$Inverse$1$1$InverseEntry */
                        class InverseEntry extends AbstractMapEntry<V, K> {
                            BiEntry<K, V> delegate;

                            InverseEntry(BiEntry<K, V> biEntry) {
                                this.delegate = biEntry;
                            }

                            public V getKey() {
                                return this.delegate.value;
                            }

                            public K getValue() {
                                return this.delegate.key;
                            }

                            public K setValue(K k) {
                                K k2 = this.delegate.key;
                                int access$300 = HashBiMap.hash(k);
                                if (access$300 == this.delegate.keyHash && Objects.equal(k, k2)) {
                                    return k;
                                }
                                Preconditions.checkArgument(HashBiMap.this.seekByKey(k, access$300) == null, "value already present: %s", k);
                                HashBiMap.this.delete(this.delegate);
                                HashBiMap.this.insert(new BiEntry(k, access$300, this.delegate.value, this.delegate.valueHash));
                                C24561.this.expectedModCount = HashBiMap.this.modCount;
                                return k2;
                            }
                        }

                        {
                            HashBiMap hashBiMap = HashBiMap.this;
                        }

                        /* access modifiers changed from: 0000 */
                        public Entry<V, K> output(BiEntry<K, V> biEntry) {
                            return new InverseEntry(biEntry);
                        }
                    };
                }
            };
        }

        /* access modifiers changed from: 0000 */
        public Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }
    }

    private static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> hashBiMap) {
            this.bimap = hashBiMap;
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return this.bimap.inverse();
        }
    }

    abstract class Itr<T> implements Iterator<T> {
        int expectedModCount = HashBiMap.this.modCount;
        BiEntry<K, V> next = null;
        int nextBucket = 0;
        BiEntry<K, V> toRemove = null;

        /* access modifiers changed from: 0000 */
        public abstract T output(BiEntry<K, V> biEntry);

        Itr() {
        }

        private void checkForConcurrentModification() {
            if (HashBiMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.next != null) {
                return true;
            }
            while (this.nextBucket < HashBiMap.this.hashTableKToV.length) {
                if (HashBiMap.this.hashTableKToV[this.nextBucket] != null) {
                    BiEntry<K, V>[] access$100 = HashBiMap.this.hashTableKToV;
                    int i = this.nextBucket;
                    this.nextBucket = i + 1;
                    this.next = access$100[i];
                    return true;
                }
                this.nextBucket++;
            }
            return false;
        }

        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                BiEntry<K, V> biEntry = this.next;
                this.next = biEntry.nextInKToVBucket;
                this.toRemove = biEntry;
                return output(biEntry);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != null);
            HashBiMap.this.delete(this.toRemove);
            this.expectedModCount = HashBiMap.this.modCount;
            this.toRemove = null;
        }
    }

    private final class KeySet extends KeySet<K, V> {
        KeySet() {
            super(HashBiMap.this);
        }

        public Iterator<K> iterator() {
            return new Itr<K>() {
                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                /* access modifiers changed from: 0000 */
                public K output(BiEntry<K, V> biEntry) {
                    return biEntry.key;
                }
            };
        }

        public boolean remove(Object obj) {
            BiEntry access$400 = HashBiMap.this.seekByKey(obj, HashBiMap.hash(obj));
            if (access$400 == null) {
                return false;
            }
            HashBiMap.this.delete(access$400);
            return true;
        }
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    private HashBiMap(int i) {
        init(i);
    }

    private void init(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i, LOAD_FACTOR);
        this.hashTableKToV = createTable(closedTableSize);
        this.hashTableVToK = createTable(closedTableSize);
        this.mask = closedTableSize - 1;
        this.modCount = 0;
        this.size = 0;
    }

    /* access modifiers changed from: private */
    public void delete(BiEntry<K, V> biEntry) {
        BiEntry<K, V> biEntry2;
        int i = biEntry.keyHash & this.mask;
        BiEntry<K, V> biEntry3 = null;
        BiEntry<K, V> biEntry4 = null;
        for (BiEntry<K, V> biEntry5 = this.hashTableKToV[i]; biEntry5 != biEntry; biEntry5 = biEntry5.nextInKToVBucket) {
            biEntry4 = biEntry5;
        }
        if (biEntry4 == null) {
            this.hashTableKToV[i] = biEntry.nextInKToVBucket;
        } else {
            biEntry4.nextInKToVBucket = biEntry.nextInKToVBucket;
        }
        int i2 = biEntry.valueHash & this.mask;
        BiEntry<K, V> biEntry6 = this.hashTableVToK[i2];
        while (true) {
            BiEntry<K, V> biEntry7 = biEntry3;
            biEntry3 = biEntry6;
            biEntry2 = biEntry7;
            if (biEntry3 == biEntry) {
                break;
            }
            biEntry6 = biEntry3.nextInVToKBucket;
        }
        if (biEntry2 == null) {
            this.hashTableVToK[i2] = biEntry.nextInVToKBucket;
        } else {
            biEntry2.nextInVToKBucket = biEntry.nextInVToKBucket;
        }
        this.size--;
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public void insert(BiEntry<K, V> biEntry) {
        int i = biEntry.keyHash & this.mask;
        biEntry.nextInKToVBucket = this.hashTableKToV[i];
        this.hashTableKToV[i] = biEntry;
        int i2 = biEntry.valueHash & this.mask;
        biEntry.nextInVToKBucket = this.hashTableVToK[i2];
        this.hashTableVToK[i2] = biEntry;
        this.size++;
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public static int hash(Object obj) {
        return Hashing.smear(obj == null ? 0 : obj.hashCode());
    }

    /* access modifiers changed from: private */
    public BiEntry<K, V> seekByKey(Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.hashTableKToV[this.mask & i]; biEntry != null; biEntry = biEntry.nextInKToVBucket) {
            if (i == biEntry.keyHash && Objects.equal(obj, biEntry.key)) {
                return biEntry;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public BiEntry<K, V> seekByValue(Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.hashTableVToK[this.mask & i]; biEntry != null; biEntry = biEntry.nextInVToKBucket) {
            if (i == biEntry.valueHash && Objects.equal(obj, biEntry.value)) {
                return biEntry;
            }
        }
        return null;
    }

    public boolean containsKey(Object obj) {
        return seekByKey(obj, hash(obj)) != null;
    }

    public boolean containsValue(Object obj) {
        return seekByValue(obj, hash(obj)) != null;
    }

    public V get(Object obj) {
        BiEntry seekByKey = seekByKey(obj, hash(obj));
        if (seekByKey == null) {
            return null;
        }
        return seekByKey.value;
    }

    public V put(K k, V v) {
        return put(k, v, false);
    }

    public V forcePut(K k, V v) {
        return put(k, v, true);
    }

    private V put(K k, V v, boolean z) {
        V v2;
        int hash = hash(k);
        int hash2 = hash(v);
        BiEntry seekByKey = seekByKey(k, hash);
        if (seekByKey != null && hash2 == seekByKey.valueHash && Objects.equal(v, seekByKey.value)) {
            return v;
        }
        BiEntry seekByValue = seekByValue(v, hash2);
        if (seekByValue != null) {
            if (z) {
                delete(seekByValue);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("value already present: ");
                sb.append(v);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (seekByKey != null) {
            delete(seekByKey);
        }
        insert(new BiEntry(k, hash, v, hash2));
        rehashIfNecessary();
        if (seekByKey == null) {
            v2 = null;
        } else {
            v2 = seekByKey.value;
        }
        return v2;
    }

    /* access modifiers changed from: private */
    public K putInverse(V v, K k, boolean z) {
        K k2;
        int hash = hash(v);
        int hash2 = hash(k);
        BiEntry seekByValue = seekByValue(v, hash);
        if (seekByValue != null && hash2 == seekByValue.keyHash && Objects.equal(k, seekByValue.key)) {
            return k;
        }
        BiEntry seekByKey = seekByKey(k, hash2);
        if (seekByKey != null) {
            if (z) {
                delete(seekByKey);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("value already present: ");
                sb.append(k);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (seekByValue != null) {
            delete(seekByValue);
        }
        insert(new BiEntry(k, hash2, v, hash));
        rehashIfNecessary();
        if (seekByValue == null) {
            k2 = null;
        } else {
            k2 = seekByValue.key;
        }
        return k2;
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] biEntryArr = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, biEntryArr.length, LOAD_FACTOR)) {
            int length = biEntryArr.length * 2;
            this.hashTableKToV = createTable(length);
            this.hashTableVToK = createTable(length);
            this.mask = length - 1;
            this.size = 0;
            for (BiEntry<K, V> biEntry : biEntryArr) {
                while (biEntry != null) {
                    BiEntry<K, V> biEntry2 = biEntry.nextInKToVBucket;
                    insert(biEntry);
                    biEntry = biEntry2;
                }
            }
            this.modCount++;
        }
    }

    private BiEntry<K, V>[] createTable(int i) {
        return new BiEntry[i];
    }

    public V remove(Object obj) {
        BiEntry seekByKey = seekByKey(obj, hash(obj));
        if (seekByKey == null) {
            return null;
        }
        delete(seekByKey);
        return seekByKey.value;
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        this.modCount++;
    }

    public int size() {
        return this.size;
    }

    public Set<K> keySet() {
        return new KeySet();
    }

    public Set<V> values() {
        return inverse().keySet();
    }

    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    public BiMap<V, K> inverse() {
        if (this.inverse != null) {
            return this.inverse;
        }
        Inverse inverse2 = new Inverse();
        this.inverse = inverse2;
        return inverse2;
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(readCount);
        Serialization.populateMap(this, objectInputStream, readCount);
    }
}