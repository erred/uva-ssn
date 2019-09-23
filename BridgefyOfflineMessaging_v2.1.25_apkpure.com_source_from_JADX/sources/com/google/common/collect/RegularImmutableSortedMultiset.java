package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;

final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient int[] counts;
    private final transient long[] cumulativeCounts;
    private final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, int[] iArr, long[] jArr, int i, int i2) {
        this.elementSet = regularImmutableSortedSet;
        this.counts = iArr;
        this.cumulativeCounts = jArr;
        this.offset = i;
        this.length = i2;
    }

    /* access modifiers changed from: 0000 */
    public Entry<E> getEntry(int i) {
        return Multisets.immutableEntry(this.elementSet.asList().get(i), this.counts[this.offset + i]);
    }

    public Entry<E> firstEntry() {
        return getEntry(0);
    }

    public Entry<E> lastEntry() {
        return getEntry(this.length - 1);
    }

    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        return this.counts[indexOf + this.offset];
    }

    public int size() {
        return Ints.saturatedCast(this.cumulativeCounts[this.offset + this.length] - this.cumulativeCounts[this.offset]);
    }

    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }

    /* access modifiers changed from: 0000 */
    public ImmutableSortedMultiset<E> getSubMultiset(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, this.length);
        if (i == i2) {
            return emptyMultiset(comparator());
        }
        if (i == 0 && i2 == this.length) {
            return this;
        }
        RegularImmutableSortedMultiset regularImmutableSortedMultiset = new RegularImmutableSortedMultiset((RegularImmutableSortedSet) this.elementSet.getSubSet(i, i2), this.counts, this.cumulativeCounts, this.offset + i, i2 - i);
        return regularImmutableSortedMultiset;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return this.offset > 0 || this.length < this.counts.length;
    }
}
