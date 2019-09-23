package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.firebase.auth.internal.zzq;

final class zzj implements zzez<zzcj> {
    private final /* synthetic */ zzdp zzir;

    zzj(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzir.zza((zzcj) obj);
    }
}
