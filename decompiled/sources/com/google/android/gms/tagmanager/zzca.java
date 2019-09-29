package com.google.android.gms.tagmanager;

final class zzca implements Runnable {
    private final /* synthetic */ zzby zzbcq;
    private final /* synthetic */ long zzbcr;
    private final /* synthetic */ String zzbcs;
    private final /* synthetic */ zzbz zzbct;

    zzca(zzbz zzbz, zzby zzby, long j, String str) {
        this.zzbct = zzbz;
        this.zzbcq = zzby;
        this.zzbcr = j;
        this.zzbcs = str;
    }

    public final void run() {
        if (this.zzbct.zzbcp == null) {
            zzfn zzqe = zzfn.zzqe();
            zzqe.zza(this.zzbct.zzri, this.zzbcq);
            this.zzbct.zzbcp = zzqe.zzqf();
        }
        this.zzbct.zzbcp.zzb(this.zzbcr, this.zzbcs);
    }
}
