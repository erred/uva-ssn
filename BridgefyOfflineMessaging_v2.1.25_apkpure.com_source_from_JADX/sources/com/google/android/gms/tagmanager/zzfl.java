package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

final class zzfl implements zzej {
    private final long zzabb;
    private final int zzabc;
    private double zzabd;
    private final Object zzabf;
    private long zzbfw;
    private final Clock zzrz;

    private zzfl(int i, long j) {
        this.zzabf = new Object();
        this.zzabc = 60;
        this.zzabd = (double) this.zzabc;
        this.zzabb = 2000;
        this.zzrz = DefaultClock.getInstance();
    }

    public zzfl() {
        this(60, 2000);
    }

    public final boolean zzew() {
        synchronized (this.zzabf) {
            long currentTimeMillis = this.zzrz.currentTimeMillis();
            if (this.zzabd < ((double) this.zzabc)) {
                double d = ((double) (currentTimeMillis - this.zzbfw)) / ((double) this.zzabb);
                if (d > 0.0d) {
                    this.zzabd = Math.min((double) this.zzabc, this.zzabd + d);
                }
            }
            this.zzbfw = currentTimeMillis;
            if (this.zzabd >= 1.0d) {
                this.zzabd -= 1.0d;
                return true;
            }
            zzdi.zzab("No more tokens available.");
            return false;
        }
    }
}
