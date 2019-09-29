package com.google.firebase.auth.internal;

public final class zzx {
    private static zzx zzrk;
    private boolean zzrj = false;

    private zzx() {
    }

    public static zzx zzek() {
        if (zzrk == null) {
            zzrk = new zzx();
        }
        return zzrk;
    }
}
