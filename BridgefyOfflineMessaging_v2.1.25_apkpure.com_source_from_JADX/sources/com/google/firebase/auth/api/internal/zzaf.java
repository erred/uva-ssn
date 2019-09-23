package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzdm;
import com.google.firebase.auth.internal.zzq;

final class zzaf implements zzez<zzdm> {
    private final /* synthetic */ zzdp zzir;

    zzaf(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzir.zzbs(((zzdm) obj).getEmail());
    }
}
