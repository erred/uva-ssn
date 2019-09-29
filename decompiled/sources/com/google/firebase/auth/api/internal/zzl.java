package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.internal.zzq;

final class zzl implements zzez<Object> {
    private final /* synthetic */ zzdp zzir;

    zzl(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzir.zzdf();
    }
}
