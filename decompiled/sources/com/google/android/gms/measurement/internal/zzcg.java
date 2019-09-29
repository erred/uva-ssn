package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzcg implements Callable<List<zzo>> {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzcg(zzby zzby, zzk zzk, String str, String str2) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
        this.zzads = str;
        this.zzadz = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzaql.zzamv.zzme();
        return this.zzaql.zzamv.zzjt().zzc(this.zzaqk.packageName, this.zzads, this.zzadz);
    }
}
