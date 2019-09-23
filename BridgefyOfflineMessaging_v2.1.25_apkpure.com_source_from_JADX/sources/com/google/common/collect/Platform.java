package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps.EntryTransformer;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
final class Platform {
    static <T> T[] newArray(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }

    static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Sets.newSetFromMap(map);
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    static <K, V1, V2> SortedMap<K, V2> mapsTransformEntriesSortedMap(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return Maps.transformEntriesIgnoreNavigable(sortedMap, entryTransformer);
    }

    static <K, V> SortedMap<K, V> mapsAsMapSortedSet(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return Maps.asMapSortedIgnoreNavigable(sortedSet, function);
    }

    static <E> SortedSet<E> setsFilterSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return Sets.filterSortedIgnoreNavigable(sortedSet, predicate);
    }

    static <K, V> SortedMap<K, V> mapsFilterSortedMap(SortedMap<K, V> sortedMap, Predicate<? super Entry<K, V>> predicate) {
        return Maps.filterSortedIgnoreNavigable(sortedMap, predicate);
    }

    private Platform() {
    }
}
