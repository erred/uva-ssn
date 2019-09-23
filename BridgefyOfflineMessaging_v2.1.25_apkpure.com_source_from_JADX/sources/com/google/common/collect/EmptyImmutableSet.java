package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
final class EmptyImmutableSet extends ImmutableSet<Object> {
    static final EmptyImmutableSet INSTANCE = new EmptyImmutableSet();
    private static final long serialVersionUID = 0;

    public boolean contains(Object obj) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public int copyIntoArray(Object[] objArr, int i) {
        return i;
    }

    public final int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean isHashCodeFast() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 0;
    }

    public String toString() {
        return "[]";
    }

    private EmptyImmutableSet() {
    }

    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    public UnmodifiableIterator<Object> iterator() {
        return Iterators.emptyIterator();
    }

    public ImmutableList<Object> asList() {
        return ImmutableList.m8668of();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public Object readResolve() {
        return INSTANCE;
    }
}
