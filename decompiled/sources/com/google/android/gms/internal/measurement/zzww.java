package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzww implements Iterator<Entry<K, V>> {
    private int pos;
    private Iterator<Entry<K, V>> zzcbx;
    private final /* synthetic */ zzwo zzcby;
    private boolean zzccc;

    private zzww(zzwo zzwo) {
        this.zzcby = zzwo;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzcby.zzcbs.size() || (!this.zzcby.zzcbt.isEmpty() && zzyh().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzccc) {
            this.zzccc = false;
            this.zzcby.zzyf();
            if (this.pos < this.zzcby.zzcbs.size()) {
                zzwo zzwo = this.zzcby;
                int i = this.pos;
                this.pos = i - 1;
                zzwo.zzby(i);
                return;
            }
            zzyh().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Entry<K, V>> zzyh() {
        if (this.zzcbx == null) {
            this.zzcbx = this.zzcby.zzcbt.entrySet().iterator();
        }
        return this.zzcbx;
    }

    public final /* synthetic */ Object next() {
        this.zzccc = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzcby.zzcbs.size()) {
            return (Entry) this.zzcby.zzcbs.get(this.pos);
        }
        return (Entry) zzyh().next();
    }

    /* synthetic */ zzww(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
