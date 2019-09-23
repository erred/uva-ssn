package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

final class zzxh implements ListIterator<String> {
    private ListIterator<String> zzcci = this.zzcck.zzcch.listIterator(this.zzccj);
    private final /* synthetic */ int zzccj;
    private final /* synthetic */ zzxg zzcck;

    zzxh(zzxg zzxg, int i) {
        this.zzcck = zzxg;
        this.zzccj = i;
    }

    public final boolean hasNext() {
        return this.zzcci.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzcci.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzcci.nextIndex();
    }

    public final int previousIndex() {
        return this.zzcci.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.zzcci.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzcci.next();
    }
}
