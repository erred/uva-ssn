package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map.Entry;

@GwtCompatible(emulated = true)
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Entry<K, V>> {

    @GwtIncompatible("serialization")
    private static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, V> map;

        EntrySetSerializedForm(ImmutableMap<K, V> immutableMap) {
            this.map = immutableMap;
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return this.map.entrySet();
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract ImmutableMap<K, V> map();

    ImmutableMapEntrySet() {
    }

    public int size() {
        return map().size();
    }

    public boolean contains(Object obj) {
        boolean z = false;
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object obj2 = map().get(entry.getKey());
        if (obj2 != null && obj2.equals(entry.getValue())) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return map().isPartialView();
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("serialization")
    public Object writeReplace() {
        return new EntrySetSerializedForm(map());
    }
}
