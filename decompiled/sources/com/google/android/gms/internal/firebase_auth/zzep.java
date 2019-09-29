package com.google.android.gms.internal.firebase_auth;

final class zzep {
    private final byte[] buffer;
    private final zzfa zzsv;

    private zzep(int i) {
        this.buffer = new byte[i];
        this.zzsv = zzfa.zzb(this.buffer);
    }

    public final zzeh zzfg() {
        this.zzsv.zzgj();
        return new zzer(this.buffer);
    }

    public final zzfa zzfh() {
        return this.zzsv;
    }

    /* synthetic */ zzep(int i, zzei zzei) {
        this(i);
    }
}
