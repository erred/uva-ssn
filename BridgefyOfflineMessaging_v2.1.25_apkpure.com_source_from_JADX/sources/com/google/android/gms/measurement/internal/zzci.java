package com.google.android.gms.measurement.internal;

final class zzci implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzci(zzby zzby, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
    }

    public final void run() {
        this.zzaql.zzamv.zzme();
        this.zzaql.zzamv.zzd(this.zzaqk);
    }
}
