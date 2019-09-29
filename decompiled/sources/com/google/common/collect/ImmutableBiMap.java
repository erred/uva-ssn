package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Map.Entry;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
    private static final Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Entry[0];

    public static final class Builder<K, V> extends com.google.common.collect.ImmutableMap.Builder<K, V> {
        public Builder<K, V> put(K k, V v) {
            super.put(k, v);
            return this;
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll(map);
            return this;
        }

        public ImmutableBiMap<K, V> build() {
            switch (this.size) {
                case 0:
                    return ImmutableBiMap.m8662of();
                case 1:
                    return ImmutableBiMap.m8663of(this.entries[0].getKey(), this.entries[0].getValue());
                default:
                    return new RegularImmutableBiMap(this.size, this.entries);
            }
        }
    }

    private static class SerializedForm extends SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return createMap(new Builder());
        }
    }

    public abstract ImmutableBiMap<V, K> inverse();

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m8662of() {
        return EmptyImmutableBiMap.INSTANCE;
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m8663of(K k, V v) {
        return new SingletonImmutableBiMap(k, v);
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m8664of(K k, V v, K k2, V v2) {
        return new RegularImmutableBiMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m8665of(K k, V v, K k2, V v2, K k3, V v3) {
        return new RegularImmutableBiMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m8666of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableBiMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m8667of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableBiMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5)});
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        Entry[] entryArr = (Entry[]) map.entrySet().toArray(EMPTY_ENTRY_ARRAY);
        switch (entryArr.length) {
            case 0:
                return m8662of();
            case 1:
                Entry entry = entryArr[0];
                return m8663of(entry.getKey(), entry.getValue());
            default:
                return new RegularImmutableBiMap((Entry<?, ?>[]) entryArr);
        }
    }

    ImmutableBiMap() {
    }

    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
