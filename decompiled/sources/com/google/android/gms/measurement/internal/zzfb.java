package com.google.android.gms.measurement.internal;

final class zzfb implements Runnable {
    private final /* synthetic */ Runnable zzacf;
    private final /* synthetic */ zzfo zzasx;

    zzfb(zzey zzey, zzfo zzfo, Runnable runnable) {
        this.zzasx = zzfo;
        this.zzacf = runnable;
    }

    public final void run() {
        this.zzasx.zzme();
        this.zzasx.zzg(this.zzacf);
        this.zzasx.zzlz();
    }
}
