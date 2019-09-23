package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzem implements Runnable {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ boolean zzask;
    private final /* synthetic */ boolean zzasl;

    zzem(zzeb zzeb, boolean z, boolean z2, zzag zzag, zzk zzk, String str) {
        this.zzasi = zzeb;
        this.zzask = z;
        this.zzasl = z2;
        this.zzagi = zzag;
        this.zzaqk = zzk;
        this.zzagj = str;
    }

    public final void run() {
        zzaj zzd = this.zzasi.zzasc;
        if (zzd == null) {
            this.zzasi.zzgt().zzjg().zzby("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zzask) {
            this.zzasi.zza(zzd, (AbstractSafeParcelable) this.zzasl ? null : this.zzagi, this.zzaqk);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzagj)) {
                    zzd.zza(this.zzagi, this.zzaqk);
                } else {
                    zzd.zza(this.zzagi, this.zzagj, this.zzasi.zzgt().zzjq());
                }
            } catch (RemoteException e) {
                this.zzasi.zzgt().zzjg().zzg("Failed to send event to the service", e);
            }
        }
        this.zzasi.zzcy();
    }
}
