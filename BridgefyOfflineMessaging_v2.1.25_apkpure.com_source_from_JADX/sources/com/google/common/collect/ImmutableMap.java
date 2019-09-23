package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    private static final Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Entry[0];
    private transient ImmutableSet<Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    public static class Builder<K, V> {
        TerminalEntry<K, V>[] entries;
        int size;

        public Builder() {
            this(4);
        }

        Builder(int i) {
            this.entries = new TerminalEntry[i];
            this.size = 0;
        }

        private void ensureCapacity(int i) {
            if (i > this.entries.length) {
                this.entries = (TerminalEntry[]) ObjectArrays.arraysCopyOf(this.entries, com.google.common.collect.ImmutableCollection.Builder.expandedCapacity(this.entries.length, i));
            }
        }

        public Builder<K, V> put(K k, V v) {
            ensureCapacity(this.size + 1);
            TerminalEntry<K, V> entryOf = ImmutableMap.entryOf(k, v);
            TerminalEntry<K, V>[] terminalEntryArr = this.entries;
            int i = this.size;
            this.size = i + 1;
            terminalEntryArr[i] = entryOf;
            return this;
        }

        public Builder<K, V> put(Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            ensureCapacity(this.size + map.size());
            for (Entry put : map.entrySet()) {
                put(put);
            }
            return this;
        }

        public ImmutableMap<K, V> build() {
            switch (this.size) {
                case 0:
                    return ImmutableMap.m8687of();
                case 1:
                    return ImmutableMap.m8688of(this.entries[0].getKey(), this.entries[0].getValue());
                default:
                    return new RegularImmutableMap(this.size, this.entries);
            }
        }
    }

    private static final class MapViewOfValuesAsSingletonSets<K, V> extends ImmutableMap<K, ImmutableSet<V>> {
        /* access modifiers changed from: private */
        public final ImmutableMap<K, V> delegate;

        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return false;
        }

        public /* bridge */ /* synthetic */ Set entrySet() {
            return ImmutableMap.super.entrySet();
        }

        public /* bridge */ /* synthetic */ Set keySet() {
            return ImmutableMap.super.keySet();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return ImmutableMap.super.values();
        }

        MapViewOfValuesAsSingletonSets(ImmutableMap<K, V> immutableMap) {
            this.delegate = (ImmutableMap) Preconditions.checkNotNull(immutableMap);
        }

        public int size() {
            return this.delegate.size();
        }

        public boolean containsKey(Object obj) {
            return this.delegate.containsKey(obj);
        }

        public ImmutableSet<V> get(Object obj) {
            Object obj2 = this.delegate.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.m8707of(obj2);
        }

        /* access modifiers changed from: 0000 */
        public ImmutableSet<Entry<K, ImmutableSet<V>>> createEntrySet() {
            return new ImmutableMapEntrySet<K, ImmutableSet<V>>() {
                /* access modifiers changed from: 0000 */
                public ImmutableMap<K, ImmutableSet<V>> map() {
                    return MapViewOfValuesAsSingletonSets.this;
                }

                public UnmodifiableIterator<Entry<K, ImmutableSet<V>>> iterator() {
                    final UnmodifiableIterator it = MapViewOfValuesAsSingletonSets.this.delegate.entrySet().iterator();
                    return new UnmodifiableIterator<Entry<K, ImmutableSet<V>>>() {
                        public boolean hasNext() {
                            return it.hasNext();
                        }

                        public Entry<K, ImmutableSet<V>> next() {
                            final Entry entry = (Entry) it.next();
                            return new AbstractMapEntry<K, ImmutableSet<V>>() {
                                public K getKey() {
                                    return entry.getKey();
                                }

                                public ImmutableSet<V> getValue() {
                                    return ImmutableSet.m8707of(entry.getValue());
                                }
                            };
                        }
                    };
                }
            };
        }
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            Iterator it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.keys[i] = entry.getKey();
                this.values[i] = entry.getValue();
                i++;
            }
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return createMap(new Builder());
        }

        /* access modifiers changed from: 0000 */
        public Object createMap(Builder<Object, Object> builder) {
            for (int i = 0; i < this.keys.length; i++) {
                builder.put(this.keys[i], this.values[i]);
            }
            return builder.build();
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract ImmutableSet<Entry<K, V>> createEntrySet();

    public abstract V get(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract boolean isPartialView();

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m8687of() {
        return ImmutableBiMap.m8662of();
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m8688of(K k, V v) {
        return ImmutableBiMap.m8663of(k, v);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m8689of(K k, V v, K k2, V v2) {
        return new RegularImmutableMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m8690of(K k, V v, K k2, V v2, K k3, V v3) {
        return new RegularImmutableMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m8691of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m8692of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableMap((TerminalEntry<?, ?>[]) new TerminalEntry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5)});
    }

    static <K, V> TerminalEntry<K, V> entryOf(K k, V v) {
        CollectPreconditions.checkEntryNotNull(k, v);
        return new TerminalEntry<>(k, v);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    static void checkNoConflict(boolean z, String str, Entry<?, ?> entry, Entry<?, ?> entry2) {
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Multiple entries with same ");
            sb.append(str);
            sb.append(": ");
            sb.append(entry);
            sb.append(" and ");
            sb.append(entry2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof ImmutableSortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        } else if (map instanceof EnumMap) {
            return copyOfEnumMapUnsafe(map);
        }
        Entry[] entryArr = (Entry[]) map.entrySet().toArray(EMPTY_ENTRY_ARRAY);
        switch (entryArr.length) {
            case 0:
                return m8687of();
            case 1:
                Entry entry = entryArr[0];
                return m8688of(entry.getKey(), entry.getValue());
            default:
                return new RegularImmutableMap((Entry<?, ?>[]) entryArr);
        }
    }

    private static <K, V> ImmutableMap<K, V> copyOfEnumMapUnsafe(Map<? extends K, ? extends V> map) {
        return copyOfEnumMap((EnumMap) map);
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(Map<K, ? extends V> map) {
        EnumMap enumMap = new EnumMap(map);
        for (Entry entry : enumMap.entrySet()) {
            CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    ImmutableMap() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    /* access modifiers changed from: 0000 */
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableMapValues immutableMapValues = new ImmutableMapValues(this);
        this.values = immutableMapValues;
        return immutableMapValues;
    }

    @Beta
    public ImmutableSetMultimap<K, V> asMultimap() {
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> createMultimapView = createMultimapView();
        this.multimapView = createMultimapView;
        return createMultimapView;
    }

    private ImmutableSetMultimap<K, V> createMultimapView() {
        ImmutableMap viewMapValuesAsSingletonSets = viewMapValuesAsSingletonSets();
        return new ImmutableSetMultimap<>(viewMapValuesAsSingletonSets, viewMapValuesAsSingletonSets.size(), null);
    }

    private ImmutableMap<K, ImmutableSet<V>> viewMapValuesAsSingletonSets() {
        return new MapViewOfValuesAsSingletonSets(this);
    }

    public boolean equals(Object obj) {
        return Maps.equalsImpl(this, obj);
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
