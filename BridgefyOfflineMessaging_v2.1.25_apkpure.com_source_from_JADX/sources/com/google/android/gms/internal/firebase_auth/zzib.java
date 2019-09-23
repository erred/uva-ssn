package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzib implements Iterator<Entry<K, V>> {
    private int pos;
    private Iterator<Entry<K, V>> zzabe;
    private final /* synthetic */ zzhz zzabf;

    private zzib(zzhz zzhz) {
        this.zzabf = zzhz;
        this.pos = this.zzabf.zzaaz.size();
    }

    public final boolean hasNext() {
        return (this.pos > 0 && this.pos <= this.zzabf.zzaaz.size()) || zzjk().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Entry<K, V>> zzjk() {
        if (this.zzabe == null) {
            this.zzabe = this.zzabf.zzabc.entrySet().iterator();
        }
        return this.zzabe;
    }

    public final /* synthetic */ Object next() {
        if (zzjk().hasNext()) {
            return (Entry) zzjk().next();
        }
        List zzb = this.zzabf.zzaaz;
        int i = this.pos - 1;
        this.pos = i;
        return (Entry) zzb.get(i);
    }

    /* synthetic */ zzib(zzhz zzhz, zzia zzia) {
        this(zzhz);
    }
}
