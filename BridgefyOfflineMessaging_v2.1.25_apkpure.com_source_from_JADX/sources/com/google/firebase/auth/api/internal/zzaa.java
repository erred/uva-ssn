package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.internal.zzq;

final class zzaa implements zzez<Void> {
    private final /* synthetic */ zzdp zzir;

    zzaa(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzir.zzdg();
    }
}
