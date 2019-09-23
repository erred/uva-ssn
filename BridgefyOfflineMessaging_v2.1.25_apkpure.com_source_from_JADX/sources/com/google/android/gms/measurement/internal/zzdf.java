package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdf implements Runnable {
    private final /* synthetic */ AtomicReference zzard;
    private final /* synthetic */ zzda zzare;

    zzdf(zzda zzda, AtomicReference atomicReference) {
        this.zzare = zzda;
        this.zzard = atomicReference;
    }

    public final void run() {
        this.zzare.zzgl().zza(this.zzard);
    }
}
