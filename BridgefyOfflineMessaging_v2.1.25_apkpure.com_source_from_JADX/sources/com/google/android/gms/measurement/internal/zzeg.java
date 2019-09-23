package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

final class zzeg implements Runnable {
    private final /* synthetic */ zzdq zzagg;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;

    zzeg(zzeb zzeb, zzk zzk, zzdq zzdq) {
        this.zzasi = zzeb;
        this.zzaqk = zzk;
        this.zzagg = zzdq;
    }

    public final void run() {
        String str;
        Object e;
        try {
            zzaj zzd = this.zzasi.zzasc;
            if (zzd == null) {
                this.zzasi.zzgt().zzjg().zzby("Failed to get app instance id");
                this.zzasi.zzgr().zzb(this.zzagg, null);
                return;
            }
            str = zzd.zzc(this.zzaqk);
            if (str != null) {
                try {
                    this.zzasi.zzgj().zzcp(str);
                    this.zzasi.zzgu().zzanh.zzcd(str);
                } catch (RemoteException e2) {
                    e = e2;
                    try {
                        this.zzasi.zzgt().zzjg().zzg("Failed to get app instance id", e);
                        this.zzasi.zzgr().zzb(this.zzagg, str);
                    } catch (Throwable th) {
                        th = th;
                        this.zzasi.zzgr().zzb(this.zzagg, str);
                        throw th;
                    }
                }
            }
            this.zzasi.zzcy();
            this.zzasi.zzgr().zzb(this.zzagg, str);
        } catch (RemoteException e3) {
            Object obj = e3;
            str = null;
            e = obj;
            this.zzasi.zzgt().zzjg().zzg("Failed to get app instance id", e);
            this.zzasi.zzgr().zzb(this.zzagg, str);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            str = null;
            th = th3;
            this.zzasi.zzgr().zzb(this.zzagg, str);
            throw th;
        }
    }
}
