package com.google.android.gms.measurement.internal;

final class zzet implements Runnable {
    private final /* synthetic */ zzaj zzasq;
    private final /* synthetic */ zzes zzasr;

    zzet(zzes zzes, zzaj zzaj) {
        this.zzasr = zzes;
        this.zzasq = zzaj;
    }

    public final void run() {
        synchronized (this.zzasr) {
            this.zzasr.zzaso = false;
            if (!this.zzasr.zzasi.isConnected()) {
                this.zzasr.zzasi.zzgt().zzjo().zzby("Connected to service");
                this.zzasr.zzasi.zza(this.zzasq);
            }
        }
    }
}
