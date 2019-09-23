package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Map;

@GwtCompatible(serializable = true)
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    private final transient ImmutableMap<E, Integer> map;
    private final transient int size;

    RegularImmutableMultiset(ImmutableMap<E, Integer> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    public int count(Object obj) {
        Integer num = (Integer) this.map.get(obj);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int size() {
        return this.size;
    }

    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    public ImmutableSet<E> elementSet() {
        return this.map.keySet();
    }

    /* access modifiers changed from: 0000 */
    public Entry<E> getEntry(int i) {
        Map.Entry entry = (Map.Entry) this.map.entrySet().asList().get(i);
        return Multisets.immutableEntry(entry.getKey(), ((Integer) entry.getValue()).intValue());
    }

    public int hashCode() {
        return this.map.hashCode();
    }
}
