package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdo;
import com.google.firebase.auth.internal.zzq;

final class zzc implements zzez<zzdo> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;

    zzc(zza zza, zzdp zzdp) {
        this.zzis = zza;
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdo zzdo = (zzdo) obj;
        this.zzis.zza(new zzcz(zzdo.zzr(), zzdo.getIdToken(), Long.valueOf(zzdo.zzs()), "Bearer"), null, null, Boolean.valueOf(true), null, this.zzir, this);
    }
}
