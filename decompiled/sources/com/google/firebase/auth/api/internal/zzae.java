package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.firebase.auth.internal.zzq;

final class zzae implements zzez<zzcz> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;
    private final /* synthetic */ String zzje;

    zzae(zza zza, String str, zzdp zzdp) {
        this.zzis = zza;
        this.zzje = str;
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcz zzcz = (zzcz) obj;
        String zzdw = zzcz.zzdw();
        zzdl zzdl = new zzdl();
        zzdl.zzci(zzdw).zzck(this.zzje);
        this.zzis.zza(this.zzir, zzcz, zzdl, (zzey) this);
    }
}
