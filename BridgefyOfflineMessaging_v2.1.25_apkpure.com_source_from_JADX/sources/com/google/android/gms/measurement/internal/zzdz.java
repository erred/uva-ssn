package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzdz implements Runnable {
    private final /* synthetic */ boolean zzarw;
    private final /* synthetic */ zzdx zzarx;
    private final /* synthetic */ zzdx zzary;
    private final /* synthetic */ zzdy zzarz;

    zzdz(zzdy zzdy, boolean z, zzdx zzdx, zzdx zzdx2) {
        this.zzarz = zzdy;
        this.zzarw = z;
        this.zzarx = zzdx;
        this.zzary = zzdx2;
    }

    public final void run() {
        boolean z;
        boolean z2 = false;
        if (this.zzarz.zzgv().zzbk(this.zzarz.zzgk().zzal())) {
            z = this.zzarw && this.zzarz.zzarq != null;
            if (z) {
                this.zzarz.zza(this.zzarz.zzarq, true);
            }
        } else {
            if (this.zzarw && this.zzarz.zzarq != null) {
                this.zzarz.zza(this.zzarz.zzarq, true);
            }
            z = false;
        }
        if (this.zzarx == null || this.zzarx.zzaro != this.zzary.zzaro || !zzfy.zzv(this.zzarx.zzarn, this.zzary.zzarn) || !zzfy.zzv(this.zzarx.zzuw, this.zzary.zzuw)) {
            z2 = true;
        }
        if (z2) {
            Bundle bundle = new Bundle();
            zzdy.zza(this.zzary, bundle, true);
            if (this.zzarx != null) {
                if (this.zzarx.zzuw != null) {
                    bundle.putString("_pn", this.zzarx.zzuw);
                }
                bundle.putString("_pc", this.zzarx.zzarn);
                bundle.putLong("_pi", this.zzarx.zzaro);
            }
            if (this.zzarz.zzgv().zzbk(this.zzarz.zzgk().zzal()) && z) {
                long zzlp = this.zzarz.zzgo().zzlp();
                if (zzlp > 0) {
                    this.zzarz.zzgr().zza(bundle, zzlp);
                }
            }
            this.zzarz.zzgj().zza("auto", "_vs", bundle);
        }
        this.zzarz.zzarq = this.zzary;
        this.zzarz.zzgl().zza(this.zzary);
    }
}
