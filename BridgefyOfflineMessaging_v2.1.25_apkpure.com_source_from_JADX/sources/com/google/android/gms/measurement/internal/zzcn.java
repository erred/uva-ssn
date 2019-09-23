package com.google.android.gms.measurement.internal;

final class zzcn implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ zzfv zzaqn;

    zzcn(zzby zzby, zzfv zzfv, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqn = zzfv;
        this.zzaqk = zzk;
    }

    public final void run() {
        this.zzaql.zzamv.zzme();
        this.zzaql.zzamv.zzb(this.zzaqn, this.zzaqk);
    }
}
