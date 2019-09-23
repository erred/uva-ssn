package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzit extends AbstractList<String> implements zzgl, RandomAccess {
    /* access modifiers changed from: private */
    public final zzgl zzabr;

    public zzit(zzgl zzgl) {
        this.zzabr = zzgl;
    }

    public final zzgl zzid() {
        return this;
    }

    public final Object zzat(int i) {
        return this.zzabr.zzat(i);
    }

    public final int size() {
        return this.zzabr.size();
    }

    public final void zzc(zzeh zzeh) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zziu(this, i);
    }

    public final Iterator<String> iterator() {
        return new zziv(this);
    }

    public final List<?> zzic() {
        return this.zzabr.zzic();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzabr.get(i);
    }
}
