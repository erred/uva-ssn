package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

final class zzdj implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ ConditionalUserProperty zzarl;

    zzdj(zzda zzda, ConditionalUserProperty conditionalUserProperty) {
        this.zzare = zzda;
        this.zzarl = conditionalUserProperty;
    }

    public final void run() {
        this.zzare.zzc(this.zzarl);
    }
}
