package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzed implements Runnable {
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzed(zzeb zzeb, AtomicReference atomicReference, zzk zzk, boolean z) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzaqk = zzk;
        this.zzaeg = z;
    }

    public final void run() {
        synchronized (this.zzasj) {
            try {
                zzaj zzd = this.zzasi.zzasc;
                if (zzd == null) {
                    this.zzasi.zzgt().zzjg().zzby("Failed to get user properties");
                    this.zzasj.notify();
                    return;
                }
                this.zzasj.set(zzd.zza(this.zzaqk, this.zzaeg));
                this.zzasi.zzcy();
                this.zzasj.notify();
            } catch (RemoteException e) {
                try {
                    this.zzasi.zzgt().zzjg().zzg("Failed to get user properties", e);
                    this.zzasj.notify();
                } catch (Throwable th) {
                    this.zzasj.notify();
                    throw th;
                }
            }
        }
    }
}
