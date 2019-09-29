package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Table.Cell;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

@GwtCompatible
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] iterationOrderColumn;
    private final int[] iterationOrderRow;
    private final ImmutableMap<R, Map<C, V>> rowMap;

    SparseImmutableTable(ImmutableList<Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        HashMap newHashMap = Maps.newHashMap();
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            newHashMap.put(next, Integer.valueOf(newLinkedHashMap.size()));
            newLinkedHashMap.put(next, new LinkedHashMap());
        }
        LinkedHashMap newLinkedHashMap2 = Maps.newLinkedHashMap();
        Iterator it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            newLinkedHashMap2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        int i = 0;
        while (i < immutableList.size()) {
            Cell cell = (Cell) immutableList.get(i);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            Object value = cell.getValue();
            iArr[i] = ((Integer) newHashMap.get(rowKey)).intValue();
            Map map = (Map) newLinkedHashMap.get(rowKey);
            iArr2[i] = map.size();
            Object put = map.put(columnKey, value);
            if (put == null) {
                ((Map) newLinkedHashMap2.get(columnKey)).put(rowKey, value);
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Duplicate value for row=");
                sb.append(rowKey);
                sb.append(", column=");
                sb.append(columnKey);
                sb.append(": ");
                sb.append(value);
                sb.append(", ");
                sb.append(put);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.iterationOrderRow = iArr;
        this.iterationOrderColumn = iArr2;
        Builder builder = ImmutableMap.builder();
        for (Entry entry : newLinkedHashMap.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = builder.build();
        Builder builder2 = ImmutableMap.builder();
        for (Entry entry2 : newLinkedHashMap2.entrySet()) {
            builder2.put(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = builder2.build();
    }

    public ImmutableMap<C, Map<R, V>> columnMap() {
        return this.columnMap;
    }

    public ImmutableMap<R, Map<C, V>> rowMap() {
        return this.rowMap;
    }

    public int size() {
        return this.iterationOrderRow.length;
    }

    /* access modifiers changed from: 0000 */
    public Cell<R, C, V> getCell(int i) {
        Entry entry = (Entry) this.rowMap.entrySet().asList().get(this.iterationOrderRow[i]);
        ImmutableMap immutableMap = (ImmutableMap) entry.getValue();
        Entry entry2 = (Entry) immutableMap.entrySet().asList().get(this.iterationOrderColumn[i]);
        return cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* access modifiers changed from: 0000 */
    public V getValue(int i) {
        ImmutableMap immutableMap = (ImmutableMap) this.rowMap.values().asList().get(this.iterationOrderRow[i]);
        return immutableMap.values().asList().get(this.iterationOrderColumn[i]);
    }
}
