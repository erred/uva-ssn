package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzew implements Runnable {
    private final /* synthetic */ zzes zzasr;

    zzew(zzes zzes) {
        this.zzasr = zzes;
    }

    public final void run() {
        zzeb zzeb = this.zzasr.zzasi;
        Context context = this.zzasr.zzasi.getContext();
        this.zzasr.zzasi.zzgw();
        zzeb.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
