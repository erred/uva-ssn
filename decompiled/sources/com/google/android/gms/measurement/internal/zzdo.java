package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdo implements Runnable {
    private final /* synthetic */ AtomicReference zzard;
    private final /* synthetic */ zzda zzare;

    zzdo(zzda zzda, AtomicReference atomicReference) {
        this.zzare = zzda;
        this.zzard = atomicReference;
    }

    public final void run() {
        synchronized (this.zzard) {
            try {
                this.zzard.set(Integer.valueOf(this.zzare.zzgv().zzb(this.zzare.zzgk().zzal(), zzai.zzake)));
                this.zzard.notify();
            } catch (Throwable th) {
                this.zzard.notify();
                throw th;
            }
        }
    }
}
