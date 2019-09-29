package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

public abstract class zzad<E> implements Iterator<E> {
    protected zzad() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
