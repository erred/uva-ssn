package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzii extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzhz zzabf;

    private zzii(zzhz zzhz) {
        this.zzabf = zzhz;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzih(this.zzabf, null);
    }

    public int size() {
        return this.zzabf.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzabf.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzabf.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzabf.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzabf.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzii(zzhz zzhz, zzia zzia) {
        this(zzhz);
    }
}
