package com.google.android.gms.measurement.internal;

final class zzcd implements Runnable {
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ zzo zzaqm;

    zzcd(zzby zzby, zzo zzo) {
        this.zzaql = zzby;
        this.zzaqm = zzo;
    }

    public final void run() {
        this.zzaql.zzamv.zzme();
        this.zzaql.zzamv.zze(this.zzaqm);
    }
}
