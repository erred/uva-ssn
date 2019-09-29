package com.google.android.gms.measurement.internal;

final class zzfh implements Runnable {
    private final /* synthetic */ long zzafg;
    private final /* synthetic */ zzfd zzatd;

    zzfh(zzfd zzfd, long j) {
        this.zzatd = zzfd;
        this.zzafg = j;
    }

    public final void run() {
        this.zzatd.zzai(this.zzafg);
    }
}
