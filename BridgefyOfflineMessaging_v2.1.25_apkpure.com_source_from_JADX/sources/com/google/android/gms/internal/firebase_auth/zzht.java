package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

final class zzht extends zzek {
    private final zzhv zzaao = new zzhv(this.zzaaq, null);
    private zzeo zzaap = zziz();
    private final /* synthetic */ zzhs zzaaq;

    zzht(zzhs zzhs) {
        this.zzaaq = zzhs;
    }

    private final zzeo zziz() {
        if (this.zzaao.hasNext()) {
            return (zzeo) ((zzeq) this.zzaao.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzaap != null;
    }

    public final byte nextByte() {
        if (this.zzaap != null) {
            byte nextByte = this.zzaap.nextByte();
            if (!this.zzaap.hasNext()) {
                this.zzaap = zziz();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
