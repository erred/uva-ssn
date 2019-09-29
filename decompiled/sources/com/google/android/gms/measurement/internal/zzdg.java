package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdg implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ long zzark;

    zzdg(zzda zzda, long j) {
        this.zzare = zzda;
        this.zzark = j;
    }

    public final void run() {
        zzda zzda = this.zzare;
        long j = this.zzark;
        zzda.zzaf();
        zzda.zzgg();
        zzda.zzcl();
        zzda.zzgt().zzjn().zzby("Resetting analytics data (FE)");
        zzda.zzgo().zzln();
        if (zzda.zzgv().zzbc(zzda.zzgk().zzal())) {
            zzda.zzgu().zzanf.set(j);
        }
        boolean isEnabled = zzda.zzada.isEnabled();
        if (!zzda.zzgv().zzhz()) {
            zzda.zzgu().zzi(!isEnabled);
        }
        zzda.zzgl().resetAnalyticsData();
        zzda.zzarc = !isEnabled;
        if (this.zzare.zzgv().zza(zzai.zzalb)) {
            this.zzare.zzgl().zza(new AtomicReference<>());
        }
    }
}
