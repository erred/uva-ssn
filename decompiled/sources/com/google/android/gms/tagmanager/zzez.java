package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zzre;

final class zzez implements Runnable {
    private final /* synthetic */ zzex zzbex;
    private final /* synthetic */ zzre zzbey;

    zzez(zzex zzex, zzre zzre) {
        this.zzbex = zzex;
        this.zzbey = zzre;
    }

    public final void run() {
        this.zzbex.zzb(this.zzbey);
    }
}
