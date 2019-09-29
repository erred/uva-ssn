package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcl;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.internal.zzq;

final class zzy implements zzez<zzcz> {
    final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;

    zzy(zza zza, zzdp zzdp) {
        this.zzis = zza;
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzis.zzip.zza(new zzcl(((zzcz) obj).zzdw()), (zzez<Void>) new zzz<Void>(this, this));
    }
}
