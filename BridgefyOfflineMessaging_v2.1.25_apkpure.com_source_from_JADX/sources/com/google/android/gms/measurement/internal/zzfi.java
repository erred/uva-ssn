package com.google.android.gms.measurement.internal;

final class zzfi implements Runnable {
    private final /* synthetic */ long zzafg;
    private final /* synthetic */ zzfd zzatd;

    zzfi(zzfd zzfd, long j) {
        this.zzatd = zzfd;
        this.zzafg = j;
    }

    public final void run() {
        this.zzatd.zzak(this.zzafg);
    }
}
