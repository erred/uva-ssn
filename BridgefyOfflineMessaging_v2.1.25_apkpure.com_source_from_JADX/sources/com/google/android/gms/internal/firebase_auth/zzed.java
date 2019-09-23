package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzed<E> extends AbstractList<E> implements zzgb<E> {
    private boolean zzsh = true;

    zzed() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzew();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzew();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzew();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzew();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzew();
        super.clear();
    }

    public boolean zzeu() {
        return this.zzsh;
    }

    public final void zzev() {
        this.zzsh = false;
    }

    public E remove(int i) {
        zzew();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzew();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzew();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzew();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzew();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzew() {
        if (!this.zzsh) {
            throw new UnsupportedOperationException();
        }
    }
}
