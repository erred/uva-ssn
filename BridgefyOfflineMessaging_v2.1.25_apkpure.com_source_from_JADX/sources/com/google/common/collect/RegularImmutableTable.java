package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Table.Cell;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    private final class CellSet extends ImmutableSet<Cell<R, C, V>> {
        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return false;
        }

        private CellSet() {
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        public UnmodifiableIterator<Cell<R, C, V>> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: 0000 */
        public ImmutableList<Cell<R, C, V>> createAsList() {
            return new ImmutableAsList<Cell<R, C, V>>() {
                public Cell<R, C, V> get(int i) {
                    return RegularImmutableTable.this.getCell(i);
                }

                /* access modifiers changed from: 0000 */
                public ImmutableCollection<Cell<R, C, V>> delegateCollection() {
                    return CellSet.this;
                }
            };
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof Cell)) {
                return false;
            }
            Cell cell = (Cell) obj;
            Object obj2 = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
            if (obj2 != null && obj2.equals(cell.getValue())) {
                z = true;
            }
            return z;
        }
    }

    private final class Values extends ImmutableList<V> {
        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return true;
        }

        private Values() {
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        public V get(int i) {
            return RegularImmutableTable.this.getValue(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract Cell<R, C, V> getCell(int i);

    /* access modifiers changed from: 0000 */
    public abstract V getValue(int i);

    RegularImmutableTable() {
    }

    /* access modifiers changed from: 0000 */
    public final ImmutableSet<Cell<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.m8706of() : new CellSet();
    }

    /* access modifiers changed from: 0000 */
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.m8668of() : new Values();
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Cell<R, C, V>> list, final Comparator<? super R> comparator, final Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(list);
        if (!(comparator == null && comparator2 == null)) {
            Collections.sort(list, new Comparator<Cell<R, C, V>>() {
                public int compare(Cell<R, C, V> cell, Cell<R, C, V> cell2) {
                    int i = 0;
                    int compare = comparator == null ? 0 : comparator.compare(cell.getRowKey(), cell2.getRowKey());
                    if (compare != 0) {
                        return compare;
                    }
                    if (comparator2 != null) {
                        i = comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
                    }
                    return i;
                }
            });
        }
        return forCellsInternal(list, comparator, comparator2);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }

    private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Cell<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Builder builder = ImmutableSet.builder();
        Builder builder2 = ImmutableSet.builder();
        ImmutableList copyOf = ImmutableList.copyOf(iterable);
        Iterator it = copyOf.iterator();
        while (it.hasNext()) {
            Cell cell = (Cell) it.next();
            builder.add(cell.getRowKey());
            builder2.add(cell.getColumnKey());
        }
        ImmutableSet build = builder.build();
        if (comparator != null) {
            ArrayList newArrayList = Lists.newArrayList((Iterable<? extends E>) build);
            Collections.sort(newArrayList, comparator);
            build = ImmutableSet.copyOf((Collection<? extends E>) newArrayList);
        }
        ImmutableSet build2 = builder2.build();
        if (comparator2 != null) {
            ArrayList newArrayList2 = Lists.newArrayList((Iterable<? extends E>) build2);
            Collections.sort(newArrayList2, comparator2);
            build2 = ImmutableSet.copyOf((Collection<? extends E>) newArrayList2);
        }
        return ((long) copyOf.size()) > (((long) build.size()) * ((long) build2.size())) / 2 ? new DenseImmutableTable(copyOf, build, build2) : new SparseImmutableTable(copyOf, build, build2);
    }
}
