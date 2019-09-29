package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible("unnecessary")
abstract class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    static final class TerminalEntry<K, V> extends ImmutableMapEntry<K, V> {
        /* access modifiers changed from: 0000 */
        public ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return null;
        }

        /* access modifiers changed from: 0000 */
        public ImmutableMapEntry<K, V> getNextInValueBucket() {
            return null;
        }

        TerminalEntry(ImmutableMapEntry<K, V> immutableMapEntry) {
            super(immutableMapEntry);
        }

        TerminalEntry(K k, V v) {
            super(k, v);
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract ImmutableMapEntry<K, V> getNextInKeyBucket();

    /* access modifiers changed from: 0000 */
    public abstract ImmutableMapEntry<K, V> getNextInValueBucket();

    ImmutableMapEntry(K k, V v) {
        super(k, v);
        CollectPreconditions.checkEntryNotNull(k, v);
    }

    ImmutableMapEntry(ImmutableMapEntry<K, V> immutableMapEntry) {
        super(immutableMapEntry.getKey(), immutableMapEntry.getValue());
    }
}
