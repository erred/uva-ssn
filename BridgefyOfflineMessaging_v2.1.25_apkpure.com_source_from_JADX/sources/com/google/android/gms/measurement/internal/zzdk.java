package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdk implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ AtomicReference zzard;
    private final /* synthetic */ zzda zzare;

    zzdk(zzda zzda, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzare = zzda;
        this.zzard = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
    }

    public final void run() {
        this.zzare.zzada.zzgl().zza(this.zzard, this.zzagj, this.zzads, this.zzadz);
    }
}
