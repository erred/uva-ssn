package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;

@GwtCompatible(emulated = true)
final class EmptyImmutableBiMap extends ImmutableBiMap<Object, Object> {
    static final EmptyImmutableBiMap INSTANCE = new EmptyImmutableBiMap();

    public Object get(Object obj) {
        return null;
    }

    public ImmutableBiMap<Object, Object> inverse() {
        return this;
    }

    public boolean isEmpty() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 0;
    }

    private EmptyImmutableBiMap() {
    }

    public ImmutableSet<Entry<Object, Object>> entrySet() {
        return ImmutableSet.m8706of();
    }

    /* access modifiers changed from: 0000 */
    public ImmutableSet<Entry<Object, Object>> createEntrySet() {
        throw new AssertionError("should never be called");
    }

    public ImmutableSetMultimap<Object, Object> asMultimap() {
        return ImmutableSetMultimap.m8713of();
    }

    public ImmutableSet<Object> keySet() {
        return ImmutableSet.m8706of();
    }

    /* access modifiers changed from: 0000 */
    public Object readResolve() {
        return INSTANCE;
    }
}
