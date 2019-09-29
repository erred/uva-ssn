package com.google.android.gms.measurement.internal;

final class zzdr implements Runnable {
    private final /* synthetic */ boolean zzaed;
    private final /* synthetic */ zzda zzare;

    zzdr(zzda zzda, boolean z) {
        this.zzare = zzda;
        this.zzaed = z;
    }

    public final void run() {
        boolean isEnabled = this.zzare.zzada.isEnabled();
        boolean zzks = this.zzare.zzada.zzks();
        this.zzare.zzada.zzd(this.zzaed);
        if (zzks == this.zzaed) {
            this.zzare.zzada.zzgt().zzjo().zzg("Default data collection state already set to", Boolean.valueOf(this.zzaed));
        }
        if (this.zzare.zzada.isEnabled() == isEnabled || this.zzare.zzada.isEnabled() != this.zzare.zzada.zzks()) {
            this.zzare.zzada.zzgt().zzjl().zze("Default data collection is different than actual status", Boolean.valueOf(this.zzaed), Boolean.valueOf(isEnabled));
        }
        this.zzare.zzlc();
    }
}
