package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzih implements Iterator<Entry<K, V>> {
    private int pos;
    private Iterator<Entry<K, V>> zzabe;
    private final /* synthetic */ zzhz zzabf;
    private boolean zzabj;

    private zzih(zzhz zzhz) {
        this.zzabf = zzhz;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzabf.zzaaz.size() || (!this.zzabf.zzaba.isEmpty() && zzjk().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzabj) {
            this.zzabj = false;
            this.zzabf.zzji();
            if (this.pos < this.zzabf.zzaaz.size()) {
                zzhz zzhz = this.zzabf;
                int i = this.pos;
                this.pos = i - 1;
                zzhz.zzbd(i);
                return;
            }
            zzjk().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Entry<K, V>> zzjk() {
        if (this.zzabe == null) {
            this.zzabe = this.zzabf.zzaba.entrySet().iterator();
        }
        return this.zzabe;
    }

    public final /* synthetic */ Object next() {
        this.zzabj = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzabf.zzaaz.size()) {
            return (Entry) this.zzabf.zzaaz.get(this.pos);
        }
        return (Entry) zzjk().next();
    }

    /* synthetic */ zzih(zzhz zzhz, zzia zzia) {
        this(zzhz);
    }
}
