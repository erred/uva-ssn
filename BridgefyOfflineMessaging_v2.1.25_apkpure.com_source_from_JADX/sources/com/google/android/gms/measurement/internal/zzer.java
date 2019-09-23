package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzer implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzfv zzaqn;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ boolean zzasl;

    zzer(zzeb zzeb, boolean z, zzfv zzfv, zzk zzk) {
        this.zzasi = zzeb;
        this.zzasl = z;
        this.zzaqn = zzfv;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzaj zzd = this.zzasi.zzasc;
        if (zzd == null) {
            this.zzasi.zzgt().zzjg().zzby("Discarding data. Failed to set user attribute");
            return;
        }
        this.zzasi.zza(zzd, (AbstractSafeParcelable) this.zzasl ? null : this.zzaqn, this.zzaqk);
        this.zzasi.zzcy();
    }
}
