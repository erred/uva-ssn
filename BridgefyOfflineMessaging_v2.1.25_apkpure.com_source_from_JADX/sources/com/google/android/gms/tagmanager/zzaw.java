package com.google.android.gms.tagmanager;

final class zzaw implements Runnable {
    private final /* synthetic */ zzat zzbbp;
    private final /* synthetic */ String zzbbr;

    zzaw(zzat zzat, String str) {
        this.zzbbp = zzat;
        this.zzbbr = str;
    }

    public final void run() {
        this.zzbbp.zzdk(this.zzbbr);
    }
}
