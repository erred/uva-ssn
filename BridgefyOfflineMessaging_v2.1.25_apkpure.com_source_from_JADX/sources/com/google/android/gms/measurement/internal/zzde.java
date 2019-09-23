package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzde implements Runnable {
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ AtomicReference zzard;
    private final /* synthetic */ zzda zzare;

    zzde(zzda zzda, AtomicReference atomicReference, boolean z) {
        this.zzare = zzda;
        this.zzard = atomicReference;
        this.zzaeg = z;
    }

    public final void run() {
        this.zzare.zzgl().zza(this.zzard, this.zzaeg);
    }
}
