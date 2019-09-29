package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzxi implements Iterator<String> {
    private final /* synthetic */ zzxg zzcck;
    private Iterator<String> zzccl = this.zzcck.zzcch.iterator();

    zzxi(zzxg zzxg) {
        this.zzcck = zzxg;
    }

    public final boolean hasNext() {
        return this.zzccl.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzccl.next();
    }
}
