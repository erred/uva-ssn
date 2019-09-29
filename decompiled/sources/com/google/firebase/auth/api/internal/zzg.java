package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdl;
import java.util.List;

final class zzg implements zzez<zzcr> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;
    private final /* synthetic */ zzey zziu;
    private final /* synthetic */ zzcz zziv;
    private final /* synthetic */ zzdl zziw;

    zzg(zza zza, zzey zzey, zzdp zzdp, zzcz zzcz, zzdl zzdl) {
        this.zzis = zza;
        this.zziu = zzey;
        this.zzir = zzdp;
        this.zziv = zzcz;
        this.zziw = zzdl;
    }

    public final void zzbp(String str) {
        this.zziu.zzbp(str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List zzdt = ((zzcr) obj).zzdt();
        if (zzdt == null || zzdt.isEmpty()) {
            this.zziu.zzbp("No users");
        } else {
            this.zzis.zza(this.zzir, this.zziv, (zzct) zzdt.get(0), this.zziw, this.zziu);
        }
    }
}
