package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzwq implements Iterator<Entry<K, V>> {
    private int pos;
    private Iterator<Entry<K, V>> zzcbx;
    private final /* synthetic */ zzwo zzcby;

    private zzwq(zzwo zzwo) {
        this.zzcby = zzwo;
        this.pos = this.zzcby.zzcbs.size();
    }

    public final boolean hasNext() {
        return (this.pos > 0 && this.pos <= this.zzcby.zzcbs.size()) || zzyh().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Entry<K, V>> zzyh() {
        if (this.zzcbx == null) {
            this.zzcbx = this.zzcby.zzcbv.entrySet().iterator();
        }
        return this.zzcbx;
    }

    public final /* synthetic */ Object next() {
        if (zzyh().hasNext()) {
            return (Entry) zzyh().next();
        }
        List zzb = this.zzcby.zzcbs;
        int i = this.pos - 1;
        this.pos = i;
        return (Entry) zzb.get(i);
    }

    /* synthetic */ zzwq(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
