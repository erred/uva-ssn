package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzcl implements Callable<byte[]> {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaql;

    zzcl(zzby zzby, zzag zzag, String str) {
        this.zzaql = zzby;
        this.zzagi = zzag;
        this.zzagj = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzaql.zzamv.zzme();
        return this.zzaql.zzamv.zzlw().zzb(this.zzagi, this.zzagj);
    }
}
