package com.google.android.gms.measurement.internal;

final class zzds implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ long zzarm;

    zzds(zzda zzda, long j) {
        this.zzare = zzda;
        this.zzarm = j;
    }

    public final void run() {
        this.zzare.zzgu().zzanl.set(this.zzarm);
        this.zzare.zzgt().zzjn().zzg("Minimum session duration set", Long.valueOf(this.zzarm));
    }
}
