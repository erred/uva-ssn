package com.google.android.gms.measurement.internal;

final class zzcb implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ zzo zzaqm;

    zzcb(zzby zzby, zzo zzo, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqm = zzo;
        this.zzaqk = zzk;
    }

    public final void run() {
        this.zzaql.zzamv.zzme();
        this.zzaql.zzamv.zzb(this.zzaqm, this.zzaqk);
    }
}
