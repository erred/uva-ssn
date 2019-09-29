package com.google.android.gms.measurement.internal;

final class zzdd implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ long zzarf;
    private final /* synthetic */ Object zzarj;

    zzdd(zzda zzda, String str, String str2, Object obj, long j) {
        this.zzare = zzda;
        this.zzads = str;
        this.val$name = str2;
        this.zzarj = obj;
        this.zzarf = j;
    }

    public final void run() {
        this.zzare.zza(this.zzads, this.val$name, this.zzarj, this.zzarf);
    }
}
