package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map.Entry;

@GwtCompatible(emulated = true)
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    @GwtIncompatible("serialization")
    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return this.map.values();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return true;
    }

    ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public int size() {
        return this.map.size();
    }

    public UnmodifiableIterator<V> iterator() {
        return Maps.valueIterator(this.map.entrySet().iterator());
    }

    public boolean contains(Object obj) {
        return obj != null && Iterators.contains(iterator(), obj);
    }

    /* access modifiers changed from: 0000 */
    public ImmutableList<V> createAsList() {
        final ImmutableList asList = this.map.entrySet().asList();
        return new ImmutableAsList<V>() {
            public V get(int i) {
                return ((Entry) asList.get(i)).getValue();
            }

            /* access modifiers changed from: 0000 */
            public ImmutableCollection<V> delegateCollection() {
                return ImmutableMapValues.this;
            }
        };
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("serialization")
    public Object writeReplace() {
        return new SerializedForm(this.map);
    }
}
