package com.google.android.gms.measurement.internal;

final class zzfl extends zzy {
    private final /* synthetic */ zzfo zzasx;
    private final /* synthetic */ zzfk zzatf;

    zzfl(zzfk zzfk, zzct zzct, zzfo zzfo) {
        this.zzatf = zzfk;
        this.zzasx = zzfo;
        super(zzct);
    }

    public final void run() {
        this.zzatf.cancel();
        this.zzatf.zzgt().zzjo().zzby("Starting upload from DelayedRunnable");
        this.zzasx.zzlz();
    }
}
