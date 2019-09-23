package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzdc implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ boolean zzaer;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ long zzarf;
    private final /* synthetic */ Bundle zzarg;
    private final /* synthetic */ boolean zzarh;
    private final /* synthetic */ boolean zzari;

    zzdc(zzda zzda, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.zzare = zzda;
        this.zzads = str;
        this.val$name = str2;
        this.zzarf = j;
        this.zzarg = bundle;
        this.zzaer = z;
        this.zzarh = z2;
        this.zzari = z3;
        this.zzagj = str3;
    }

    public final void run() {
        this.zzare.zza(this.zzads, this.val$name, this.zzarf, this.zzarg, this.zzaer, this.zzarh, this.zzari, this.zzagj);
    }
}
