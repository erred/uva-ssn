package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.internal.zzq;

final class zzb implements zzez<zzcz> {
    private final /* synthetic */ zzdp zzir;

    zzb(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzir.zzb((zzcz) obj);
    }
}
