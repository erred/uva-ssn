package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.Serializable;
import java.util.Map.Entry;

@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final double MAX_LOAD_FACTOR = 1.2d;
    /* access modifiers changed from: private */
    public final transient ImmutableMapEntry<K, V>[] entries;
    /* access modifiers changed from: private */
    public final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    /* access modifiers changed from: private */
    public final transient int mask;
    /* access modifiers changed from: private */
    public final transient ImmutableMapEntry<K, V>[] valueTable;

    private final class Inverse extends ImmutableBiMap<V, K> {

        final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            /* access modifiers changed from: 0000 */
            public boolean isHashCodeFast() {
                return true;
            }

            InverseEntrySet() {
            }

            /* access modifiers changed from: 0000 */
            public ImmutableMap<V, K> map() {
                return Inverse.this;
            }

            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }

            public UnmodifiableIterator<Entry<V, K>> iterator() {
                return asList().iterator();
            }

            /* access modifiers changed from: 0000 */
            public ImmutableList<Entry<V, K>> createAsList() {
                return new ImmutableAsList<Entry<V, K>>() {
                    public Entry<V, K> get(int i) {
                        ImmutableMapEntry immutableMapEntry = RegularImmutableBiMap.this.entries[i];
                        return Maps.immutableEntry(immutableMapEntry.getValue(), immutableMapEntry.getKey());
                    }

                    /* access modifiers changed from: 0000 */
                    public ImmutableCollection<Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }
                };
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return false;
        }

        private Inverse() {
        }

        public int size() {
            return inverse().size();
        }

        public ImmutableBiMap<K, V> inverse() {
            return RegularImmutableBiMap.this;
        }

        public K get(Object obj) {
            if (obj == null) {
                return null;
            }
            for (ImmutableMapEntry immutableMapEntry = RegularImmutableBiMap.this.valueTable[Hashing.smear(obj.hashCode()) & RegularImmutableBiMap.this.mask]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInValueBucket()) {
                if (obj.equals(immutableMapEntry.getValue())) {
                    return immutableMapEntry.getKey();
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        public ImmutableSet<Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        /* access modifiers changed from: 0000 */
        public Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }
    }

    private static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> forward;

        InverseSerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            this.forward = immutableBiMap;
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return this.forward.inverse();
        }
    }

    private static final class NonTerminalBiMapEntry<K, V> extends ImmutableMapEntry<K, V> {
        private final ImmutableMapEntry<K, V> nextInKeyBucket;
        private final ImmutableMapEntry<K, V> nextInValueBucket;

        NonTerminalBiMapEntry(K k, V v, ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2) {
            super(k, v);
            this.nextInKeyBucket = immutableMapEntry;
            this.nextInValueBucket = immutableMapEntry2;
        }

        NonTerminalBiMapEntry(ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2, ImmutableMapEntry<K, V> immutableMapEntry3) {
            super(immutableMapEntry);
            this.nextInKeyBucket = immutableMapEntry2;
            this.nextInValueBucket = immutableMapEntry3;
        }

        /* access modifiers changed from: 0000 */
        public ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        /* access modifiers changed from: 0000 */
        public ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return false;
    }

    RegularImmutableBiMap(TerminalEntry<?, ?>... terminalEntryArr) {
        this(terminalEntryArr.length, terminalEntryArr);
    }

    /* JADX WARNING: type inference failed for: r15v1, types: [com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.Map$Entry, com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARNING: type inference failed for: r1v4, types: [com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.util.Map$Entry, com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3, types: [com.google.common.collect.RegularImmutableBiMap$NonTerminalBiMapEntry] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v5, types: [com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARNING: type inference failed for: r1v7, types: [com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    RegularImmutableBiMap(int r19, com.google.common.collect.ImmutableMapEntry.TerminalEntry<?, ?>[] r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r18.<init>()
            r2 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            int r2 = com.google.common.collect.Hashing.closedTableSize(r1, r2)
            int r3 = r2 + -1
            r0.mask = r3
            com.google.common.collect.ImmutableMapEntry[] r3 = createEntryArray(r2)
            com.google.common.collect.ImmutableMapEntry[] r2 = createEntryArray(r2)
            com.google.common.collect.ImmutableMapEntry[] r4 = createEntryArray(r19)
            r5 = 0
            r6 = 0
        L_0x0022:
            if (r5 >= r1) goto L_0x0097
            r8 = r20[r5]
            java.lang.Object r9 = r8.getKey()
            java.lang.Object r10 = r8.getValue()
            int r11 = r9.hashCode()
            int r12 = r10.hashCode()
            int r13 = com.google.common.collect.Hashing.smear(r11)
            int r14 = r0.mask
            r13 = r13 & r14
            int r14 = com.google.common.collect.Hashing.smear(r12)
            int r15 = r0.mask
            r14 = r14 & r15
            r15 = r3[r13]
            r1 = r15
        L_0x0047:
            if (r1 == 0) goto L_0x0061
            java.lang.Object r7 = r1.getKey()
            boolean r7 = r9.equals(r7)
            r7 = r7 ^ 1
            r16 = r9
            java.lang.String r9 = "key"
            checkNoConflict(r7, r9, r8, r1)
            com.google.common.collect.ImmutableMapEntry r1 = r1.getNextInKeyBucket()
            r9 = r16
            goto L_0x0047
        L_0x0061:
            r1 = r2[r14]
            r7 = r1
        L_0x0064:
            if (r7 == 0) goto L_0x007e
            java.lang.Object r9 = r7.getValue()
            boolean r9 = r10.equals(r9)
            r9 = r9 ^ 1
            r17 = r10
            java.lang.String r10 = "value"
            checkNoConflict(r9, r10, r8, r7)
            com.google.common.collect.ImmutableMapEntry r7 = r7.getNextInValueBucket()
            r10 = r17
            goto L_0x0064
        L_0x007e:
            if (r15 != 0) goto L_0x0084
            if (r1 != 0) goto L_0x0084
            r7 = r8
            goto L_0x0089
        L_0x0084:
            com.google.common.collect.RegularImmutableBiMap$NonTerminalBiMapEntry r7 = new com.google.common.collect.RegularImmutableBiMap$NonTerminalBiMapEntry
            r7.<init>(r8, r15, r1)
        L_0x0089:
            r3[r13] = r7
            r2[r14] = r7
            r4[r5] = r7
            r1 = r11 ^ r12
            int r6 = r6 + r1
            int r5 = r5 + 1
            r1 = r19
            goto L_0x0022
        L_0x0097:
            r0.keyTable = r3
            r0.valueTable = r2
            r0.entries = r4
            r0.hashCode = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableBiMap.<init>(int, com.google.common.collect.ImmutableMapEntry$TerminalEntry[]):void");
    }

    RegularImmutableBiMap(Entry<?, ?>[] entryArr) {
        RegularImmutableBiMap regularImmutableBiMap = this;
        Entry<?, ?>[] entryArr2 = entryArr;
        int length = entryArr2.length;
        int closedTableSize = Hashing.closedTableSize(length, MAX_LOAD_FACTOR);
        regularImmutableBiMap.mask = closedTableSize - 1;
        ImmutableMapEntry<K, V>[] createEntryArray = createEntryArray(closedTableSize);
        ImmutableMapEntry<K, V>[] createEntryArray2 = createEntryArray(closedTableSize);
        ImmutableMapEntry<K, V>[] createEntryArray3 = createEntryArray(length);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Entry<?, ?> entry = entryArr2[i];
            Object key = entry.getKey();
            Object value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            int hashCode2 = key.hashCode();
            int hashCode3 = value.hashCode();
            int smear = Hashing.smear(hashCode2) & regularImmutableBiMap.mask;
            int smear2 = Hashing.smear(hashCode3) & regularImmutableBiMap.mask;
            ImmutableMapEntry<K, V> immutableMapEntry = createEntryArray[smear];
            ImmutableMapEntry<K, V> immutableMapEntry2 = immutableMapEntry;
            while (immutableMapEntry2 != null) {
                int i3 = length;
                checkNoConflict(!key.equals(immutableMapEntry2.getKey()), "key", entry, immutableMapEntry2);
                immutableMapEntry2 = immutableMapEntry2.getNextInKeyBucket();
                length = i3;
            }
            int i4 = length;
            ImmutableMapEntry<K, V> immutableMapEntry3 = createEntryArray2[smear2];
            ImmutableMapEntry<K, V> immutableMapEntry4 = immutableMapEntry3;
            while (immutableMapEntry4 != null) {
                int i5 = i2;
                checkNoConflict(!value.equals(immutableMapEntry4.getValue()), Param.VALUE, entry, immutableMapEntry4);
                immutableMapEntry4 = immutableMapEntry4.getNextInValueBucket();
                i2 = i5;
            }
            int i6 = i2;
            ImmutableMapEntry<K, V> terminalEntry = (immutableMapEntry == null && immutableMapEntry3 == null) ? new TerminalEntry<>(key, value) : new NonTerminalBiMapEntry<>(key, value, immutableMapEntry, immutableMapEntry3);
            createEntryArray[smear] = terminalEntry;
            createEntryArray2[smear2] = terminalEntry;
            createEntryArray3[i] = terminalEntry;
            i2 = i6 + (hashCode2 ^ hashCode3);
            i++;
            length = i4;
            regularImmutableBiMap = this;
            entryArr2 = entryArr;
        }
        int i7 = i2;
        regularImmutableBiMap.keyTable = createEntryArray;
        regularImmutableBiMap.valueTable = createEntryArray2;
        regularImmutableBiMap.entries = createEntryArray3;
        regularImmutableBiMap.hashCode = i7;
    }

    private static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int i) {
        return new ImmutableMapEntry[i];
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        for (ImmutableMapEntry<K, V> immutableMapEntry = this.keyTable[Hashing.smear(obj.hashCode()) & this.mask]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInKeyBucket()) {
            if (obj.equals(immutableMapEntry.getKey())) {
                return immutableMapEntry.getValue();
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public ImmutableSet<Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet<K, V>() {
            /* access modifiers changed from: 0000 */
            public boolean isHashCodeFast() {
                return true;
            }

            /* access modifiers changed from: 0000 */
            public ImmutableMap<K, V> map() {
                return RegularImmutableBiMap.this;
            }

            public UnmodifiableIterator<Entry<K, V>> iterator() {
                return asList().iterator();
            }

            /* access modifiers changed from: 0000 */
            public ImmutableList<Entry<K, V>> createAsList() {
                return new RegularImmutableAsList((ImmutableCollection<E>) this, (Object[]) RegularImmutableBiMap.this.entries);
            }

            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }
        };
    }

    public int size() {
        return this.entries.length;
    }

    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> immutableBiMap = this.inverse;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        Inverse inverse2 = new Inverse();
        this.inverse = inverse2;
        return inverse2;
    }
}
