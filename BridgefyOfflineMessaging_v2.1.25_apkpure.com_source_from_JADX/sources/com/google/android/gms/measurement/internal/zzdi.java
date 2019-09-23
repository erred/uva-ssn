package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

final class zzdi implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ ConditionalUserProperty zzarl;

    zzdi(zzda zzda, ConditionalUserProperty conditionalUserProperty) {
        this.zzare = zzda;
        this.zzarl = conditionalUserProperty;
    }

    public final void run() {
        this.zzare.zzb(this.zzarl);
    }
}
