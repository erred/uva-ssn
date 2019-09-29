package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzec implements zzfw {
    private final /* synthetic */ zzeb zzbdv;

    zzec(zzeb zzeb) {
        this.zzbdv = zzeb;
    }

    public final void zza(zzbw zzbw) {
        this.zzbdv.zze(zzbw.zzov());
    }

    public final void zzb(zzbw zzbw) {
        this.zzbdv.zze(zzbw.zzov());
        long zzov = zzbw.zzov();
        StringBuilder sb = new StringBuilder(57);
        sb.append("Permanent failure dispatching hitId: ");
        sb.append(zzov);
        zzdi.m8601v(sb.toString());
    }

    public final void zzc(zzbw zzbw) {
        long zzow = zzbw.zzow();
        if (zzow == 0) {
            this.zzbdv.zze(zzbw.zzov(), this.zzbdv.zzrz.currentTimeMillis());
            return;
        }
        if (zzow + 14400000 < this.zzbdv.zzrz.currentTimeMillis()) {
            this.zzbdv.zze(zzbw.zzov());
            long zzov = zzbw.zzov();
            StringBuilder sb = new StringBuilder(47);
            sb.append("Giving up on failed hitId: ");
            sb.append(zzov);
            zzdi.m8601v(sb.toString());
        }
    }
}
