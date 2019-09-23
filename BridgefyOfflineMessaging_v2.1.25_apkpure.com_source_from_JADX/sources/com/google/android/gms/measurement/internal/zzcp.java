package com.google.android.gms.measurement.internal;

final class zzcp implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzcp(zzby zzby, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
    }

    public final void run() {
        this.zzaql.zzamv.zzme();
        this.zzaql.zzamv.zzf(this.zzaqk);
    }
}
