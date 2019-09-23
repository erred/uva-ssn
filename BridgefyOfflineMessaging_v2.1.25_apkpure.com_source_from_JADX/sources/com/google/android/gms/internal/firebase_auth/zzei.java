package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

final class zzei extends zzek {
    private final int limit = this.zzss.size();
    private int position = 0;
    private final /* synthetic */ zzeh zzss;

    zzei(zzeh zzeh) {
        this.zzss = zzeh;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzss.zzl(i);
        }
        throw new NoSuchElementException();
    }
}
