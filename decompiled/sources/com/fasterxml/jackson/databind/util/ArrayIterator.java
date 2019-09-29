package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterable<T>, Iterator<T> {

    /* renamed from: _a */
    private final T[] f6156_a;
    private int _index = 0;

    public Iterator<T> iterator() {
        return this;
    }

    public ArrayIterator(T[] tArr) {
        this.f6156_a = tArr;
    }

    public boolean hasNext() {
        return this._index < this.f6156_a.length;
    }

    public T next() {
        if (this._index < this.f6156_a.length) {
            T[] tArr = this.f6156_a;
            int i = this._index;
            this._index = i + 1;
            return tArr[i];
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
