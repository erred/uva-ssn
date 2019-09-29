package com.google.android.gms.internal.firebase_auth;

import java.util.ListIterator;

final class zziu implements ListIterator<String> {
    private ListIterator<String> zzabs = this.zzabu.zzabr.listIterator(this.zzabt);
    private final /* synthetic */ int zzabt;
    private final /* synthetic */ zzit zzabu;

    zziu(zzit zzit, int i) {
        this.zzabu = zzit;
        this.zzabt = i;
    }

    public final boolean hasNext() {
        return this.zzabs.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzabs.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzabs.nextIndex();
    }

    public final int previousIndex() {
        return this.zzabs.previousIndex();
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
        return (String) this.zzabs.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzabs.next();
    }
}
