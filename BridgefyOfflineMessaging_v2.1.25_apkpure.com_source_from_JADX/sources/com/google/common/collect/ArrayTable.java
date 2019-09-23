package com.google.common.collect;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Table.Cell;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible(emulated = true)
@Beta
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    /* access modifiers changed from: private */
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    /* access modifiers changed from: private */
    public final ImmutableList<C> columnList;
    private transient ColumnMap columnMap;
    /* access modifiers changed from: private */
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    /* access modifiers changed from: private */
    public final ImmutableList<R> rowList;
    private transient RowMap rowMap;

    private static abstract class ArrayMap<K, V> extends ImprovedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        /* access modifiers changed from: 0000 */
        public abstract String getKeyRole();

        /* access modifiers changed from: 0000 */
        public abstract V getValue(int i);

        /* access modifiers changed from: 0000 */
        public abstract V setValue(int i, V v);

        private ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.keyIndex = immutableMap;
        }

        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        /* access modifiers changed from: 0000 */
        public K getKey(int i) {
            return this.keyIndex.keySet().asList().get(i);
        }

        public int size() {
            return this.keyIndex.size();
        }

        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        /* access modifiers changed from: protected */
        public Set<Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>() {
                /* access modifiers changed from: 0000 */
                public Map<K, V> map() {
                    return ArrayMap.this;
                }

                public Iterator<Entry<K, V>> iterator() {
                    return new AbstractIndexedListIterator<Entry<K, V>>(size()) {
                        /* access modifiers changed from: protected */
                        public Entry<K, V> get(final int i) {
                            return new AbstractMapEntry<K, V>() {
                                public K getKey() {
                                    return ArrayMap.this.getKey(i);
                                }

                                public V getValue() {
                                    return ArrayMap.this.getValue(i);
                                }

                                public V setValue(V v) {
                                    return ArrayMap.this.setValue(i, v);
                                }
                            };
                        }
                    };
                }
            };
        }

        public boolean containsKey(Object obj) {
            return this.keyIndex.containsKey(obj);
        }

        public V get(Object obj) {
            Integer num = (Integer) this.keyIndex.get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public V put(K k, V v) {
            Integer num = (Integer) this.keyIndex.get(k);
            if (num != null) {
                return setValue(num.intValue(), v);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getKeyRole());
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(k);
            sb.append(" not in ");
            sb.append(this.keyIndex.keySet());
            throw new IllegalArgumentException(sb.toString());
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    private class Column extends ArrayMap<R, V> {
        final int columnIndex;

        /* access modifiers changed from: 0000 */
        public String getKeyRole() {
            return "Row";
        }

        Column(int i) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = i;
        }

        /* access modifiers changed from: 0000 */
        public V getValue(int i) {
            return ArrayTable.this.mo22116at(i, this.columnIndex);
        }

        /* access modifiers changed from: 0000 */
        public V setValue(int i, V v) {
            return ArrayTable.this.set(i, this.columnIndex, v);
        }
    }

    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        /* access modifiers changed from: 0000 */
        public String getKeyRole() {
            return "Column";
        }

        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        /* access modifiers changed from: 0000 */
        public Map<R, V> getValue(int i) {
            return new Column(i);
        }

        /* access modifiers changed from: 0000 */
        public Map<R, V> setValue(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private class Row extends ArrayMap<C, V> {
        final int rowIndex;

        /* access modifiers changed from: 0000 */
        public String getKeyRole() {
            return "Column";
        }

        Row(int i) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = i;
        }

        /* access modifiers changed from: 0000 */
        public V getValue(int i) {
            return ArrayTable.this.mo22116at(this.rowIndex, i);
        }

        /* access modifiers changed from: 0000 */
        public V setValue(int i, V v) {
            return ArrayTable.this.set(this.rowIndex, i, v);
        }
    }

    private class RowMap extends ArrayMap<R, Map<C, V>> {
        /* access modifiers changed from: 0000 */
        public String getKeyRole() {
            return "Row";
        }

        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        /* access modifiers changed from: 0000 */
        public Map<C, V> getValue(int i) {
            return new Row(i);
        }

        /* access modifiers changed from: 0000 */
        public Map<C, V> setValue(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean isEmpty() {
        return false;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.checkArgument(!this.rowList.isEmpty());
        Preconditions.checkArgument(!this.columnList.isEmpty());
        this.rowKeyToIndex = index(this.rowList);
        this.columnKeyToIndex = index(this.columnList);
        this.array = (Object[][]) Array.newInstance(Object.class, new int[]{this.rowList.size(), this.columnList.size()});
        eraseAll();
    }

    private static <E> ImmutableMap<E, Integer> index(List<E> list) {
        Builder builder = ImmutableMap.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.put(list.get(i), Integer.valueOf(i));
        }
        return builder.build();
    }

    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        this.rowList = arrayTable.rowList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (Object[][]) Array.newInstance(Object.class, new int[]{this.rowList.size(), this.columnList.size()});
        this.array = vArr;
        eraseAll();
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(arrayTable.array[i], 0, vArr[i], 0, arrayTable.array[i].length);
        }
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    /* renamed from: at */
    public V mo22116at(int i, int i2) {
        Preconditions.checkElementIndex(i, this.rowList.size());
        Preconditions.checkElementIndex(i2, this.columnList.size());
        return this.array[i][i2];
    }

    public V set(int i, int i2, V v) {
        Preconditions.checkElementIndex(i, this.rowList.size());
        Preconditions.checkElementIndex(i2, this.columnList.size());
        V v2 = this.array[i][i2];
        this.array[i][i2] = v;
        return v2;
    }

    @GwtIncompatible("reflection")
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (Object[][]) Array.newInstance(cls, new int[]{this.rowList.size(), this.columnList.size()});
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(this.array[i], 0, vArr[i], 0, this.array[i].length);
        }
        return vArr;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        for (V[] fill : this.array) {
            Arrays.fill(fill, null);
        }
    }

    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        V[][] vArr;
        for (V[] vArr2 : this.array) {
            for (V equal : vArr[r3]) {
                if (Objects.equal(obj, equal)) {
                    return true;
                }
            }
        }
        return false;
    }

    public V get(Object obj, Object obj2) {
        Integer num = (Integer) this.rowKeyToIndex.get(obj);
        Integer num2 = (Integer) this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return mo22116at(num.intValue(), num2.intValue());
    }

    public V put(R r, C c, V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Integer num = (Integer) this.rowKeyToIndex.get(r);
        Preconditions.checkArgument(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = (Integer) this.columnKeyToIndex.get(c);
        Preconditions.checkArgument(num2 != null, "Column %s not in %s", c, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public V erase(Object obj, Object obj2) {
        Integer num = (Integer) this.rowKeyToIndex.get(obj);
        Integer num2 = (Integer) this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public Set<Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    /* access modifiers changed from: 0000 */
    public Iterator<Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Cell<R, C, V>>(size()) {
            /* access modifiers changed from: protected */
            public Cell<R, C, V> get(final int i) {
                return new AbstractCell<R, C, V>() {
                    final int columnIndex = (i % ArrayTable.this.columnList.size());
                    final int rowIndex = (i / ArrayTable.this.columnList.size());

                    public R getRowKey() {
                        return ArrayTable.this.rowList.get(this.rowIndex);
                    }

                    public C getColumnKey() {
                        return ArrayTable.this.columnList.get(this.columnIndex);
                    }

                    public V getValue() {
                        return ArrayTable.this.mo22116at(this.rowIndex, this.columnIndex);
                    }
                };
            }
        };
    }

    public Map<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        Integer num = (Integer) this.columnKeyToIndex.get(c);
        return num == null ? ImmutableMap.m8687of() : new Column(num.intValue());
    }

    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        ColumnMap columnMap2 = this.columnMap;
        if (columnMap2 != null) {
            return columnMap2;
        }
        ColumnMap columnMap3 = new ColumnMap<>();
        this.columnMap = columnMap3;
        return columnMap3;
    }

    public Map<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        Integer num = (Integer) this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.m8687of() : new Row(num.intValue());
    }

    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        RowMap rowMap2 = this.rowMap;
        if (rowMap2 != null) {
            return rowMap2;
        }
        RowMap rowMap3 = new RowMap<>();
        this.rowMap = rowMap3;
        return rowMap3;
    }

    public Collection<V> values() {
        return super.values();
    }
}
