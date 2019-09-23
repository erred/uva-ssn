package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdp implements Runnable {
    private final /* synthetic */ AtomicReference zzard;
    private final /* synthetic */ zzda zzare;

    zzdp(zzda zzda, AtomicReference atomicReference) {
        this.zzare = zzda;
        this.zzard = atomicReference;
    }

    public final void run() {
        synchronized (this.zzard) {
            try {
                this.zzard.set(Double.valueOf(this.zzare.zzgv().zzc(this.zzare.zzgk().zzal(), zzai.zzakf)));
                this.zzard.notify();
            } catch (Throwable th) {
                this.zzard.notify();
                throw th;
            }
        }
    }
}
