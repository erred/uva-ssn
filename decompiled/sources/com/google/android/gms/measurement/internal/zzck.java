package com.google.android.gms.measurement.internal;

final class zzck implements Runnable {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaql;

    zzck(zzby zzby, zzag zzag, String str) {
        this.zzaql = zzby;
        this.zzagi = zzag;
        this.zzagj = str;
    }

    public final void run() {
        this.zzaql.zzamv.zzme();
        this.zzaql.zzamv.zzd(this.zzagi, this.zzagj);
    }
}
