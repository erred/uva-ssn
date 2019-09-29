package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.firebase.auth.internal.zzq;

final class zzp implements zzez<zzcz> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;
    private final /* synthetic */ String zzjd;
    private final /* synthetic */ String zzje;

    zzp(zza zza, String str, String str2, zzdp zzdp) {
        this.zzis = zza;
        this.zzjd = str;
        this.zzje = str2;
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcz zzcz = (zzcz) obj;
        zzdl zzdl = new zzdl();
        zzdl.zzci(zzcz.zzdw()).zzcj(this.zzjd).zzck(this.zzje);
        this.zzis.zza(this.zzir, zzcz, zzdl, (zzey) this);
    }
}
