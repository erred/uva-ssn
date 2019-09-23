package com.google.android.gms.measurement.internal;

final class zzcj implements Runnable {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzcj(zzby zzby, zzag zzag, zzk zzk) {
        this.zzaql = zzby;
        this.zzagi = zzag;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzag zzb = this.zzaql.zzb(this.zzagi, this.zzaqk);
        this.zzaql.zzamv.zzme();
        this.zzaql.zzamv.zzc(zzb, this.zzaqk);
    }
}
