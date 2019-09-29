package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdn implements Runnable {
    private final /* synthetic */ AtomicReference zzard;
    private final /* synthetic */ zzda zzare;

    zzdn(zzda zzda, AtomicReference atomicReference) {
        this.zzare = zzda;
        this.zzard = atomicReference;
    }

    public final void run() {
        synchronized (this.zzard) {
            try {
                this.zzard.set(Long.valueOf(this.zzare.zzgv().zza(this.zzare.zzgk().zzal(), zzai.zzakd)));
                this.zzard.notify();
            } catch (Throwable th) {
                this.zzard.notify();
                throw th;
            }
        }
    }
}
