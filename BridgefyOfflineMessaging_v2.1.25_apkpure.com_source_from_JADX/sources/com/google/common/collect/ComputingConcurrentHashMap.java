package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

class ComputingConcurrentHashMap<K, V> extends MapMakerInternalMap<K, V> {
    private static final long serialVersionUID = 4;
    final Function<? super K, ? extends V> computingFunction;

    private static final class ComputationExceptionReference<K, V> implements ValueReference<K, V> {

        /* renamed from: t */
        final Throwable f6762t;

        public void clear(ValueReference<K, V> valueReference) {
        }

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public V get() {
            return null;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public boolean isComputingReference() {
            return false;
        }

        ComputationExceptionReference(Throwable th) {
            this.f6762t = th;
        }

        public V waitForValue() throws ExecutionException {
            throw new ExecutionException(this.f6762t);
        }
    }

    private static final class ComputedReference<K, V> implements ValueReference<K, V> {
        final V value;

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

        ComputedReference(V v) {
            this.value = v;
        }

        public V get() {
            return this.value;
        }

        public V waitForValue() {
            return get();
        }
    }

    static final class ComputingSegment<K, V> extends Segment<K, V> {
        ComputingSegment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            if (r0.getValueReference().isComputingReference() == false) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
            if (r6.getValueReference().isComputingReference() == false) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
            r8 = r6.getValueReference().get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
            if (r8 != null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
            enqueueNotification(r7, r12, r8, com.google.common.collect.MapMaker.RemovalCause.COLLECTED);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0073, code lost:
            if (r10.map.expires() == false) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x007b, code lost:
            if (r10.map.isExpired(r6) == false) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x007d, code lost:
            enqueueNotification(r7, r12, r8, com.google.common.collect.MapMaker.RemovalCause.EXPIRED);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
            r10.evictionQueue.remove(r6);
            r10.expirationQueue.remove(r6);
            r10.count = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
            recordLockedRead(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
            postReadCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x009b, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a1, code lost:
            r2 = true;
         */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V getOrCompute(K r11, int r12, com.google.common.base.Function<? super K, ? extends V> r13) throws java.util.concurrent.ExecutionException {
            /*
                r10 = this;
            L_0x0000:
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r0 = r10.getEntry(r11, r12)     // Catch:{ all -> 0x00f0 }
                if (r0 == 0) goto L_0x0013
                java.lang.Object r1 = r10.getLiveValue(r0)     // Catch:{ all -> 0x00f0 }
                if (r1 == 0) goto L_0x0013
                r10.recordRead(r0)     // Catch:{ all -> 0x00f0 }
                r10.postReadCleanup()
                return r1
            L_0x0013:
                r1 = 1
                if (r0 == 0) goto L_0x0020
                com.google.common.collect.MapMakerInternalMap$ValueReference r2 = r0.getValueReference()     // Catch:{ all -> 0x00f0 }
                boolean r2 = r2.isComputingReference()     // Catch:{ all -> 0x00f0 }
                if (r2 != 0) goto L_0x00cd
            L_0x0020:
                r0 = 0
                r10.lock()     // Catch:{ all -> 0x00f0 }
                r10.preWriteCleanup()     // Catch:{ all -> 0x00e8 }
                int r2 = r10.count     // Catch:{ all -> 0x00e8 }
                int r2 = r2 - r1
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r10.table     // Catch:{ all -> 0x00e8 }
                int r4 = r3.length()     // Catch:{ all -> 0x00e8 }
                int r4 = r4 - r1
                r4 = r4 & r12
                java.lang.Object r5 = r3.get(r4)     // Catch:{ all -> 0x00e8 }
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r5 = (com.google.common.collect.MapMakerInternalMap.ReferenceEntry) r5     // Catch:{ all -> 0x00e8 }
                r6 = r5
            L_0x0039:
                if (r6 == 0) goto L_0x00a1
                java.lang.Object r7 = r6.getKey()     // Catch:{ all -> 0x00e8 }
                int r8 = r6.getHash()     // Catch:{ all -> 0x00e8 }
                if (r8 != r12) goto L_0x009c
                if (r7 == 0) goto L_0x009c
                com.google.common.collect.MapMakerInternalMap r8 = r10.map     // Catch:{ all -> 0x00e8 }
                com.google.common.base.Equivalence<java.lang.Object> r8 = r8.keyEquivalence     // Catch:{ all -> 0x00e8 }
                boolean r8 = r8.equivalent(r11, r7)     // Catch:{ all -> 0x00e8 }
                if (r8 == 0) goto L_0x009c
                com.google.common.collect.MapMakerInternalMap$ValueReference r8 = r6.getValueReference()     // Catch:{ all -> 0x00e8 }
                boolean r8 = r8.isComputingReference()     // Catch:{ all -> 0x00e8 }
                if (r8 == 0) goto L_0x005d
                r2 = 0
                goto L_0x00a2
            L_0x005d:
                com.google.common.collect.MapMakerInternalMap$ValueReference r8 = r6.getValueReference()     // Catch:{ all -> 0x00e8 }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x00e8 }
                if (r8 != 0) goto L_0x006d
                com.google.common.collect.MapMaker$RemovalCause r9 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch:{ all -> 0x00e8 }
                r10.enqueueNotification(r7, r12, r8, r9)     // Catch:{ all -> 0x00e8 }
                goto L_0x0082
            L_0x006d:
                com.google.common.collect.MapMakerInternalMap r9 = r10.map     // Catch:{ all -> 0x00e8 }
                boolean r9 = r9.expires()     // Catch:{ all -> 0x00e8 }
                if (r9 == 0) goto L_0x008f
                com.google.common.collect.MapMakerInternalMap r9 = r10.map     // Catch:{ all -> 0x00e8 }
                boolean r9 = r9.isExpired(r6)     // Catch:{ all -> 0x00e8 }
                if (r9 == 0) goto L_0x008f
                com.google.common.collect.MapMaker$RemovalCause r9 = com.google.common.collect.MapMaker.RemovalCause.EXPIRED     // Catch:{ all -> 0x00e8 }
                r10.enqueueNotification(r7, r12, r8, r9)     // Catch:{ all -> 0x00e8 }
            L_0x0082:
                java.util.Queue r7 = r10.evictionQueue     // Catch:{ all -> 0x00e8 }
                r7.remove(r6)     // Catch:{ all -> 0x00e8 }
                java.util.Queue r7 = r10.expirationQueue     // Catch:{ all -> 0x00e8 }
                r7.remove(r6)     // Catch:{ all -> 0x00e8 }
                r10.count = r2     // Catch:{ all -> 0x00e8 }
                goto L_0x00a1
            L_0x008f:
                r10.recordLockedRead(r6)     // Catch:{ all -> 0x00e8 }
                r10.unlock()     // Catch:{ all -> 0x00f0 }
                r10.postWriteCleanup()     // Catch:{ all -> 0x00f0 }
                r10.postReadCleanup()
                return r8
            L_0x009c:
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r6 = r6.getNext()     // Catch:{ all -> 0x00e8 }
                goto L_0x0039
            L_0x00a1:
                r2 = 1
            L_0x00a2:
                if (r2 == 0) goto L_0x00bb
                com.google.common.collect.ComputingConcurrentHashMap$ComputingValueReference r0 = new com.google.common.collect.ComputingConcurrentHashMap$ComputingValueReference     // Catch:{ all -> 0x00e8 }
                r0.<init>(r13)     // Catch:{ all -> 0x00e8 }
                if (r6 != 0) goto L_0x00b8
                com.google.common.collect.MapMakerInternalMap$ReferenceEntry r5 = r10.newEntry(r11, r12, r5)     // Catch:{ all -> 0x00e8 }
                r5.setValueReference(r0)     // Catch:{ all -> 0x00e8 }
                r3.set(r4, r5)     // Catch:{ all -> 0x00e8 }
                r3 = r0
                r0 = r5
                goto L_0x00bd
            L_0x00b8:
                r6.setValueReference(r0)     // Catch:{ all -> 0x00e8 }
            L_0x00bb:
                r3 = r0
                r0 = r6
            L_0x00bd:
                r10.unlock()     // Catch:{ all -> 0x00f0 }
                r10.postWriteCleanup()     // Catch:{ all -> 0x00f0 }
                if (r2 == 0) goto L_0x00cd
                java.lang.Object r11 = r10.compute(r11, r12, r0, r3)     // Catch:{ all -> 0x00f0 }
                r10.postReadCleanup()
                return r11
            L_0x00cd:
                boolean r2 = java.lang.Thread.holdsLock(r0)     // Catch:{ all -> 0x00f0 }
                r1 = r1 ^ r2
                java.lang.String r2 = "Recursive computation"
                com.google.common.base.Preconditions.checkState(r1, r2)     // Catch:{ all -> 0x00f0 }
                com.google.common.collect.MapMakerInternalMap$ValueReference r1 = r0.getValueReference()     // Catch:{ all -> 0x00f0 }
                java.lang.Object r1 = r1.waitForValue()     // Catch:{ all -> 0x00f0 }
                if (r1 == 0) goto L_0x0000
                r10.recordRead(r0)     // Catch:{ all -> 0x00f0 }
                r10.postReadCleanup()
                return r1
            L_0x00e8:
                r11 = move-exception
                r10.unlock()     // Catch:{ all -> 0x00f0 }
                r10.postWriteCleanup()     // Catch:{ all -> 0x00f0 }
                throw r11     // Catch:{ all -> 0x00f0 }
            L_0x00f0:
                r11 = move-exception
                r10.postReadCleanup()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment.getOrCompute(java.lang.Object, int, com.google.common.base.Function):java.lang.Object");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
            if (put(r8, r9, r3, true) == null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
            enqueueNotification(r8, r9, r3, com.google.common.collect.MapMaker.RemovalCause.REPLACED);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
            if (r4 != 0) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
            java.lang.System.nanoTime();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r3 != null) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            clearValue(r8, r9, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0035, code lost:
            r10 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
            if (r3 == null) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V compute(K r8, int r9, com.google.common.collect.MapMakerInternalMap.ReferenceEntry<K, V> r10, com.google.common.collect.ComputingConcurrentHashMap.ComputingValueReference<K, V> r11) throws java.util.concurrent.ExecutionException {
            /*
                r7 = this;
                java.lang.System.nanoTime()
                r0 = 0
                r2 = 0
                monitor-enter(r10)     // Catch:{ all -> 0x0039 }
                java.lang.Object r3 = r11.compute(r8, r9)     // Catch:{ all -> 0x002e }
                long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002b }
                monitor-exit(r10)     // Catch:{ all -> 0x0037 }
                if (r3 == 0) goto L_0x001e
                r10 = 1
                java.lang.Object r10 = r7.put(r8, r9, r3, r10)     // Catch:{ all -> 0x0035 }
                if (r10 == 0) goto L_0x001e
                com.google.common.collect.MapMaker$RemovalCause r10 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch:{ all -> 0x0035 }
                r7.enqueueNotification(r8, r9, r3, r10)     // Catch:{ all -> 0x0035 }
            L_0x001e:
                int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r10 != 0) goto L_0x0025
                java.lang.System.nanoTime()
            L_0x0025:
                if (r3 != 0) goto L_0x002a
                r7.clearValue(r8, r9, r11)
            L_0x002a:
                return r3
            L_0x002b:
                r2 = move-exception
                r4 = r0
                goto L_0x0033
            L_0x002e:
                r3 = move-exception
                r4 = r0
                r6 = r3
                r3 = r2
                r2 = r6
            L_0x0033:
                monitor-exit(r10)     // Catch:{ all -> 0x0037 }
                throw r2     // Catch:{ all -> 0x0035 }
            L_0x0035:
                r10 = move-exception
                goto L_0x003c
            L_0x0037:
                r2 = move-exception
                goto L_0x0033
            L_0x0039:
                r10 = move-exception
                r4 = r0
                r3 = r2
            L_0x003c:
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 != 0) goto L_0x0043
                java.lang.System.nanoTime()
            L_0x0043:
                if (r3 != 0) goto L_0x0048
                r7.clearValue(r8, r9, r11)
            L_0x0048:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment.compute(java.lang.Object, int, com.google.common.collect.MapMakerInternalMap$ReferenceEntry, com.google.common.collect.ComputingConcurrentHashMap$ComputingValueReference):java.lang.Object");
        }
    }

    static final class ComputingSerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 4;
        final Function<? super K, ? extends V> computingFunction;

        ComputingSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap, Function<? super K, ? extends V> function) {
            super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, removalListener, concurrentMap);
            this.computingFunction = function;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).makeComputingMap(this.computingFunction);
            readEntries(objectInputStream);
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return this.delegate;
        }
    }

    private static final class ComputingValueReference<K, V> implements ValueReference<K, V> {
        volatile ValueReference<K, V> computedReference = MapMakerInternalMap.unset();
        final Function<? super K, ? extends V> computingFunction;

        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public V get() {
            return null;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public boolean isComputingReference() {
            return true;
        }

        public ComputingValueReference(Function<? super K, ? extends V> function) {
            this.computingFunction = function;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0023, code lost:
            r0 = th;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V waitForValue() throws java.util.concurrent.ExecutionException {
            /*
                r3 = this;
                com.google.common.collect.MapMakerInternalMap$ValueReference<K, V> r0 = r3.computedReference
                com.google.common.collect.MapMakerInternalMap$ValueReference<java.lang.Object, java.lang.Object> r1 = com.google.common.collect.MapMakerInternalMap.UNSET
                if (r0 != r1) goto L_0x0032
                r0 = 0
                monitor-enter(r3)     // Catch:{ all -> 0x0025 }
                r1 = 0
            L_0x0009:
                com.google.common.collect.MapMakerInternalMap$ValueReference<K, V> r0 = r3.computedReference     // Catch:{ all -> 0x0020 }
                com.google.common.collect.MapMakerInternalMap$ValueReference<java.lang.Object, java.lang.Object> r2 = com.google.common.collect.MapMakerInternalMap.UNSET     // Catch:{ all -> 0x0020 }
                if (r0 != r2) goto L_0x0015
                r3.wait()     // Catch:{ InterruptedException -> 0x0013 }
                goto L_0x0009
            L_0x0013:
                r1 = 1
                goto L_0x0009
            L_0x0015:
                monitor-exit(r3)     // Catch:{ all -> 0x0020 }
                if (r1 == 0) goto L_0x0032
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
                goto L_0x0032
            L_0x0020:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0020 }
                throw r0     // Catch:{ all -> 0x0023 }
            L_0x0023:
                r0 = move-exception
                goto L_0x0028
            L_0x0025:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0028:
                if (r1 == 0) goto L_0x0031
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L_0x0031:
                throw r0
            L_0x0032:
                com.google.common.collect.MapMakerInternalMap$ValueReference<K, V> r0 = r3.computedReference
                java.lang.Object r0 = r0.waitForValue()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ComputingConcurrentHashMap.ComputingValueReference.waitForValue():java.lang.Object");
        }

        public void clear(ValueReference<K, V> valueReference) {
            setValueReference(valueReference);
        }

        /* access modifiers changed from: 0000 */
        public V compute(K k, int i) throws ExecutionException {
            try {
                V apply = this.computingFunction.apply(k);
                setValueReference(new ComputedReference(apply));
                return apply;
            } catch (Throwable th) {
                setValueReference(new ComputationExceptionReference(th));
                throw new ExecutionException(th);
            }
        }

        /* access modifiers changed from: 0000 */
        public void setValueReference(ValueReference<K, V> valueReference) {
            synchronized (this) {
                if (this.computedReference == MapMakerInternalMap.UNSET) {
                    this.computedReference = valueReference;
                    notifyAll();
                }
            }
        }
    }

    ComputingConcurrentHashMap(MapMaker mapMaker, Function<? super K, ? extends V> function) {
        super(mapMaker);
        this.computingFunction = (Function) Preconditions.checkNotNull(function);
    }

    /* access modifiers changed from: 0000 */
    public Segment<K, V> createSegment(int i, int i2) {
        return new ComputingSegment(this, i, i2);
    }

    /* access modifiers changed from: 0000 */
    public ComputingSegment<K, V> segmentFor(int i) {
        return (ComputingSegment) super.segmentFor(i);
    }

    /* access modifiers changed from: 0000 */
    public V getOrCompute(K k) throws ExecutionException {
        int hash = hash(Preconditions.checkNotNull(k));
        return segmentFor(hash).getOrCompute(k, hash, this.computingFunction);
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        ComputingSerializationProxy computingSerializationProxy = new ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
        return computingSerializationProxy;
    }
}
