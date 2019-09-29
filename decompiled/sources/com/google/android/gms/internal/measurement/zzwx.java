package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzwx extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzwo zzcby;

    private zzwx(zzwo zzwo) {
        this.zzcby = zzwo;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzww(this.zzcby, null);
    }

    public int size() {
        return this.zzcby.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzcby.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzcby.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzcby.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzcby.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzwx(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
