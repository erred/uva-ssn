package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

final class zziv implements Iterator<String> {
    private final /* synthetic */ zzit zzabu;
    private Iterator<String> zzabv = this.zzabu.zzabr.iterator();

    zziv(zzit zzit) {
        this.zzabu = zzit;
    }

    public final boolean hasNext() {
        return this.zzabv.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzabv.next();
    }
}
