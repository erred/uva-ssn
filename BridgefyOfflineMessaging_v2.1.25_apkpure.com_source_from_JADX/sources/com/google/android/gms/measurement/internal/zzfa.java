package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class zzfa implements Runnable {
    private final JobParameters zzace;
    private final zzey zzast;
    private final zzas zzasw;

    zzfa(zzey zzey, zzas zzas, JobParameters jobParameters) {
        this.zzast = zzey;
        this.zzasw = zzas;
        this.zzace = jobParameters;
    }

    public final void run() {
        this.zzast.zza(this.zzasw, this.zzace);
    }
}
