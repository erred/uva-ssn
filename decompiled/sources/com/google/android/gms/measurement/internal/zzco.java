package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzco implements Callable<List<zzfx>> {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzco(zzby zzby, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzaql.zzamv.zzme();
        return this.zzaql.zzamv.zzjt().zzbl(this.zzaqk.packageName);
    }
}
