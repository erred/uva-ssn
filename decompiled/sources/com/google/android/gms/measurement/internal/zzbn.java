package com.google.android.gms.measurement.internal;

final class zzbn implements Runnable {
    private final /* synthetic */ zzbw zzaoe;
    private final /* synthetic */ zzas zzaof;

    zzbn(zzbm zzbm, zzbw zzbw, zzas zzas) {
        this.zzaoe = zzbw;
        this.zzaof = zzas;
    }

    public final void run() {
        if (this.zzaoe.zzkk() == null) {
            this.zzaof.zzjg().zzby("Install Referrer Reporter is null");
            return;
        }
        zzbj zzkk = this.zzaoe.zzkk();
        zzkk.zzada.zzgg();
        zzkk.zzce(zzkk.zzada.getContext().getPackageName());
    }
}
