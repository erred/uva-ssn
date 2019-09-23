package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcq;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.internal.zzq;

final class zzt implements zzez<zzcz> {
    final /* synthetic */ zzdp zzir;
    final /* synthetic */ zza zzis;
    final /* synthetic */ String zzji;

    zzt(zza zza, String str, zzdp zzdp) {
        this.zzis = zza;
        this.zzji = str;
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcz zzcz = (zzcz) obj;
        this.zzis.zzip.zza(new zzcq(zzcz.zzdw()), (zzez<zzcr>) new zzu<zzcr>(this, this, zzcz));
    }
}
