package com.google.android.gms.measurement.internal;

final class zzbx implements Runnable {
    private final /* synthetic */ zzcz zzaqg;
    private final /* synthetic */ zzbw zzaqh;

    zzbx(zzbw zzbw, zzcz zzcz) {
        this.zzaqh = zzbw;
        this.zzaqg = zzcz;
    }

    public final void run() {
        this.zzaqh.zza(this.zzaqg);
        this.zzaqh.start();
    }
}
