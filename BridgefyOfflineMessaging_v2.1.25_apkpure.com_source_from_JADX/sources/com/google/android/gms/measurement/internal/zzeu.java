package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class zzeu implements Runnable {
    private final /* synthetic */ ComponentName val$name;
    private final /* synthetic */ zzes zzasr;

    zzeu(zzes zzes, ComponentName componentName) {
        this.zzasr = zzes;
        this.val$name = componentName;
    }

    public final void run() {
        this.zzasr.zzasi.onServiceDisconnected(this.val$name);
    }
}
