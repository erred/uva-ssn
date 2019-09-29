package com.google.android.gms.measurement.internal;

final class zzcq implements Runnable {
    private final /* synthetic */ String zzaeb;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ String zzaqo;
    private final /* synthetic */ long zzaqp;

    zzcq(zzby zzby, String str, String str2, String str3, long j) {
        this.zzaql = zzby;
        this.zzaqo = str;
        this.zzagj = str2;
        this.zzaeb = str3;
        this.zzaqp = j;
    }

    public final void run() {
        if (this.zzaqo == null) {
            this.zzaql.zzamv.zzmh().zzgm().zza(this.zzagj, (zzdx) null);
            return;
        }
        this.zzaql.zzamv.zzmh().zzgm().zza(this.zzagj, new zzdx(this.zzaeb, this.zzaqo, this.zzaqp));
    }
}
