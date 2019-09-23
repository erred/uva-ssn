package com.google.android.gms.measurement.internal;

final class zzdq implements Runnable {
    private final /* synthetic */ boolean zzaed;
    private final /* synthetic */ zzda zzare;

    zzdq(zzda zzda, boolean z) {
        this.zzare = zzda;
        this.zzaed = z;
    }

    public final void run() {
        this.zzare.zzj(this.zzaed);
    }
}
