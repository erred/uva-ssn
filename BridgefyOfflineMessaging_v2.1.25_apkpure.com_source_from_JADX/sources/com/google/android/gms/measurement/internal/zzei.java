package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzei implements Runnable {
    private final /* synthetic */ zzdx zzasa;
    private final /* synthetic */ zzeb zzasi;

    zzei(zzeb zzeb, zzdx zzdx) {
        this.zzasi = zzeb;
        this.zzasa = zzdx;
    }

    public final void run() {
        zzaj zzd = this.zzasi.zzasc;
        if (zzd == null) {
            this.zzasi.zzgt().zzjg().zzby("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zzasa == null) {
                zzd.zza(0, (String) null, (String) null, this.zzasi.getContext().getPackageName());
            } else {
                zzd.zza(this.zzasa.zzaro, this.zzasa.zzuw, this.zzasa.zzarn, this.zzasi.getContext().getPackageName());
            }
            this.zzasi.zzcy();
        } catch (RemoteException e) {
            this.zzasi.zzgt().zzjg().zzg("Failed to send current screen to the service", e);
        }
    }
}
