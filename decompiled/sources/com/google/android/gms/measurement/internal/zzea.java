package com.google.android.gms.measurement.internal;

final class zzea implements Runnable {
    private final /* synthetic */ zzdy zzarz;
    private final /* synthetic */ zzdx zzasa;

    zzea(zzdy zzdy, zzdx zzdx) {
        this.zzarz = zzdy;
        this.zzasa = zzdx;
    }

    public final void run() {
        this.zzarz.zza(this.zzasa, false);
        this.zzarz.zzarq = null;
        this.zzarz.zzgl().zza((zzdx) null);
    }
}
