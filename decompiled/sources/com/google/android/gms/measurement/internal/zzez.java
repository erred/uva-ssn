package com.google.android.gms.measurement.internal;

import android.content.Intent;

final /* synthetic */ class zzez implements Runnable {
    private final int zzacb;
    private final zzey zzast;
    private final zzas zzasu;
    private final Intent zzasv;

    zzez(zzey zzey, int i, zzas zzas, Intent intent) {
        this.zzast = zzey;
        this.zzacb = i;
        this.zzasu = zzas;
        this.zzasv = intent;
    }

    public final void run() {
        this.zzast.zza(this.zzacb, this.zzasu, this.zzasv);
    }
}
