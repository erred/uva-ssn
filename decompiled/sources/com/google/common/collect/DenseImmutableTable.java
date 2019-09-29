package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Table.Cell;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@GwtCompatible
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    /* access modifiers changed from: private */
    public final int[] columnCounts = new int[this.columnKeyToIndex.size()];
    /* access modifiers changed from: private */
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] iterationOrderColumn;
    private final int[] iterationOrderRow;
    /* access modifiers changed from: private */
    public final int[] rowCounts = new int[this.rowKeyToIndex.size()];
    /* access modifiers changed from: private */
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, Map<C, V>> rowMap;
    /* access modifiers changed from: private */
    public final V[][] values;

    private final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;

        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return true;
        }

        Column(int i) {
            super(DenseImmutableTable.this.columnCounts[i]);
            this.columnIndex = i;
        }

        /* access modifiers changed from: 0000 */
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        /* access modifiers changed from: 0000 */
        public V getValue(int i) {
            return DenseImmutableTable.this.values[i][this.columnIndex];
        }
    }

    private final class ColumnMap extends ImmutableArrayMap<C, Map<R, V>> {
        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return false;
        }

        private ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }

        /* access modifiers changed from: 0000 */
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        /* access modifiers changed from: 0000 */
        public Map<R, V> getValue(int i) {
            return new Column(i);
        }
    }

    private static abstract class ImmutableArrayMap<K, V> extends ImmutableMap<K, V> {
        private final int size;

        /* access modifiers changed from: 0000 */
        public abstract V getValue(int i);

        /* access modifiers changed from: 0000 */
        public abstract ImmutableMap<K, Integer> keyToIndex();

        ImmutableArrayMap(int i) {
            this.size = i;
        }

        private boolean isFull() {
            return this.size == keyToIndex().size();
        }

        /* access modifiers changed from: 0000 */
        public K getKey(int i) {
            return keyToIndex().keySet().asList().get(i);
        }

        /* access modifiers changed from: 0000 */
        public ImmutableSet<K> createKeySet() {
            return isFull() ? keyToIndex().keySet() : super.createKeySet();
        }

        public int size() {
            return this.size;
        }

        public V get(Object obj) {
            Integer num = (Integer) keyToIndex().get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        /* access modifiers changed from: 0000 */
        public ImmutableSet<Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() {
                /* access modifiers changed from: 0000 */
                public ImmutableMap<K, V> map() {
                    return ImmutableArrayMap.this;
                }

                public UnmodifiableIterator<Entry<K, V>> iterator() {
                    return new AbstractIterator<Entry<K, V>>() {
                        private int index = -1;
                        private final int maxIndex = ImmutableArrayMap.this.keyToIndex().size();

                        /* access modifiers changed from: protected */
                        public Entry<K, V> computeNext() {
                            int i = this.index;
                            while (true) {
                                this.index = i + 1;
                                if (this.index >= this.maxIndex) {
                                    return (Entry) endOfData();
                                }
                                Object value = ImmutableArrayMap.this.getValue(this.index);
                                if (value != null) {
                                    return Maps.immutableEntry(ImmutableArrayMap.this.getKey(this.index), value);
                                }
                                i = this.index;
                            }
                        }
                    };
                }
            };
        }
    }

    private final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;

        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return true;
        }

        Row(int i) {
            super(DenseImmutableTable.this.rowCounts[i]);
            this.rowIndex = i;
        }

        /* access modifiers changed from: 0000 */
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        /* access modifiers changed from: 0000 */
        public V getValue(int i) {
            return DenseImmutableTable.this.values[this.rowIndex][i];
        }
    }

    private final class RowMap extends ImmutableArrayMap<R, Map<C, V>> {
        /* access modifiers changed from: 0000 */
        public boolean isPartialView() {
            return false;
        }

        private RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }

        /* access modifiers changed from: 0000 */
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        /* access modifiers changed from: 0000 */
        public Map<C, V> getValue(int i) {
            return new Row(i);
        }
    }

    private static <E> ImmutableMap<E, Integer> makeIndex(ImmutableSet<E> immutableSet) {
        Builder builder = ImmutableMap.builder();
        Iterator it = immutableSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            builder.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return builder.build();
    }

    DenseImmutableTable(ImmutableList<Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        this.values = (Object[][]) Array.newInstance(Object.class, new int[]{immutableSet.size(), immutableSet2.size()});
        this.rowKeyToIndex = makeIndex(immutableSet);
        this.columnKeyToIndex = makeIndex(immutableSet2);
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Cell cell = (Cell) immutableList.get(i);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            int intValue = ((Integer) this.rowKeyToIndex.get(rowKey)).intValue();
            int intValue2 = ((Integer) this.columnKeyToIndex.get(columnKey)).intValue();
            Preconditions.checkArgument(this.values[intValue][intValue2] == null, "duplicate key: (%s, %s)", rowKey, columnKey);
            this.values[intValue][intValue2] = cell.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i] = intValue;
            iArr2[i] = intValue2;
        }
        this.iterationOrderRow = iArr;
        this.iterationOrderColumn = iArr2;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    public ImmutableMap<C, Map<R, V>> columnMap() {
        return this.columnMap;
    }

    public ImmutableMap<R, Map<C, V>> rowMap() {
        return this.rowMap;
    }

    public V get(Object obj, Object obj2) {
        Integer num = (Integer) this.rowKeyToIndex.get(obj);
        Integer num2 = (Integer) this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    public int size() {
        return this.iterationOrderRow.length;
    }

    /* access modifiers changed from: 0000 */
    public Cell<R, C, V> getCell(int i) {
        int i2 = this.iterationOrderRow[i];
        int i3 = this.iterationOrderColumn[i];
        return cellOf(rowKeySet().asList().get(i2), columnKeySet().asList().get(i3), this.values[i2][i3]);
    }

    /* access modifiers changed from: 0000 */
    public V getValue(int i) {
        return this.values[this.iterationOrderRow[i]][this.iterationOrderColumn[i]];
    }
}