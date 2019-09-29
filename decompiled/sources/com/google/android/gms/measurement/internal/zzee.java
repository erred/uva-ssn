package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzee implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;

    zzee(zzeb zzeb, zzk zzk) {
        this.zzasi = zzeb;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzaj zzd = this.zzasi.zzasc;
        if (zzd == null) {
            this.zzasi.zzgt().zzjg().zzby("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzd.zzd(this.zzaqk);
        } catch (RemoteException e) {
            this.zzasi.zzgt().zzjg().zzg("Failed to reset data on the service", e);
        }
        this.zzasi.zzcy();
    }
}
