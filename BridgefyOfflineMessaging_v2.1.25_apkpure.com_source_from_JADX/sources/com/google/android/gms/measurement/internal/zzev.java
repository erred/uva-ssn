package com.google.android.gms.measurement.internal;

final class zzev implements Runnable {
    private final /* synthetic */ zzes zzasr;
    private final /* synthetic */ zzaj zzass;

    zzev(zzes zzes, zzaj zzaj) {
        this.zzasr = zzes;
        this.zzass = zzaj;
    }

    public final void run() {
        synchronized (this.zzasr) {
            this.zzasr.zzaso = false;
            if (!this.zzasr.zzasi.isConnected()) {
                this.zzasr.zzasi.zzgt().zzjn().zzby("Connected to remote service");
                this.zzasr.zzasi.zza(this.zzass);
            }
        }
    }
}
