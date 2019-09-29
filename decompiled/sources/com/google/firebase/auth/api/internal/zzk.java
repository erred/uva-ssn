package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.internal.zzq;

final class zzk implements zzez<Object> {
    private final /* synthetic */ zzdp zzir;

    zzk(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzir.zza((zzdg) null);
    }
}
