package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
final class SortedMultisets {

    static class ElementSet<E> extends ElementSet<E> implements SortedSet<E> {
        private final SortedMultiset<E> multiset;

        ElementSet(SortedMultiset<E> sortedMultiset) {
            this.multiset = sortedMultiset;
        }

        /* access modifiers changed from: 0000 */
        public final SortedMultiset<E> multiset() {
            return this.multiset;
        }

        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        public SortedSet<E> subSet(E e, E e2) {
            return multiset().subMultiset(e, BoundType.CLOSED, e2, BoundType.OPEN).elementSet();
        }

        public SortedSet<E> headSet(E e) {
            return multiset().headMultiset(e, BoundType.OPEN).elementSet();
        }

        public SortedSet<E> tailSet(E e) {
            return multiset().tailMultiset(e, BoundType.CLOSED).elementSet();
        }

        public E first() {
            return SortedMultisets.getElementOrThrow(multiset().firstEntry());
        }

        public E last() {
            return SortedMultisets.getElementOrThrow(multiset().lastEntry());
        }
    }

    private SortedMultisets() {
    }

    /* access modifiers changed from: private */
    public static <E> E getElementOrThrow(Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }

    private static <E> E getElementOrNull(Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }
}
