package com.google.android.gms.measurement.internal;

final class zzdt implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ long zzarm;

    zzdt(zzda zzda, long j) {
        this.zzare = zzda;
        this.zzarm = j;
    }

    public final void run() {
        this.zzare.zzgu().zzanm.set(this.zzarm);
        this.zzare.zzgt().zzjn().zzg("Session timeout duration set", Long.valueOf(this.zzarm));
    }
}
