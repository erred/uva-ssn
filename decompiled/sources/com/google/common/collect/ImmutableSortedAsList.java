package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Comparator;

@GwtCompatible(emulated = true)
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
    ImmutableSortedAsList(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super((ImmutableCollection<E>) immutableSortedSet, immutableList);
    }

    /* access modifiers changed from: 0000 */
    public ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet) super.delegateCollection();
    }

    public Comparator<? super E> comparator() {
        return delegateCollection().comparator();
    }

    @GwtIncompatible("ImmutableSortedSet.indexOf")
    public int indexOf(Object obj) {
        int indexOf = delegateCollection().indexOf(obj);
        if (indexOf < 0 || !get(indexOf).equals(obj)) {
            return -1;
        }
        return indexOf;
    }

    @GwtIncompatible("ImmutableSortedSet.indexOf")
    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("super.subListUnchecked does not exist; inherited subList is valid if slow")
    public ImmutableList<E> subListUnchecked(int i, int i2) {
        return new RegularImmutableSortedSet(super.subListUnchecked(i, i2), comparator()).asList();
    }
}
