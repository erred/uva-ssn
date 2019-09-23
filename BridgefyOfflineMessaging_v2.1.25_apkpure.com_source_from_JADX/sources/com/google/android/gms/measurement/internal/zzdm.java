package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdm implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ AtomicReference zzard;
    private final /* synthetic */ zzda zzare;

    zzdm(zzda zzda, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzare = zzda;
        this.zzard = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
        this.zzaeg = z;
    }

    public final void run() {
        this.zzare.zzada.zzgl().zza(this.zzard, this.zzagj, this.zzads, this.zzadz, this.zzaeg);
    }
}
