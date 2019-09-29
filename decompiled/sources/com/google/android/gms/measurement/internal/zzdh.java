package com.google.android.gms.measurement.internal;

final class zzdh implements Runnable {
    private final /* synthetic */ zzcx zzaef;
    private final /* synthetic */ zzda zzare;

    zzdh(zzda zzda, zzcx zzcx) {
        this.zzare = zzda;
        this.zzaef = zzcx;
    }

    public final void run() {
        this.zzare.zza(this.zzaef);
    }
}
