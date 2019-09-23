package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.android.gms.internal.firebase_auth.zzdm;
import java.util.ArrayList;
import java.util.List;

final class zzh implements zzez<zzdm> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;
    private final /* synthetic */ zzey zziu;
    private final /* synthetic */ zzcz zziv;
    private final /* synthetic */ zzdl zziw;
    private final /* synthetic */ zzct zzix;

    zzh(zza zza, zzdl zzdl, zzct zzct, zzdp zzdp, zzcz zzcz, zzey zzey) {
        this.zzis = zza;
        this.zziw = zzdl;
        this.zzix = zzct;
        this.zzir = zzdp;
        this.zziv = zzcz;
        this.zziu = zzey;
    }

    public final void zzbp(String str) {
        this.zziu.zzbp(str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdm zzdm = (zzdm) obj;
        if (this.zziw.zzch("EMAIL")) {
            this.zzix.zzbx(null);
        } else if (this.zziw.getEmail() != null) {
            this.zzix.zzbx(this.zziw.getEmail());
        }
        if (this.zziw.zzch("DISPLAY_NAME")) {
            this.zzix.zzby(null);
        } else if (this.zziw.getDisplayName() != null) {
            this.zzix.zzby(this.zziw.getDisplayName());
        }
        if (this.zziw.zzch("PHOTO_URL")) {
            this.zzix.zzbz(null);
        } else if (this.zziw.zzal() != null) {
            this.zzix.zzbz(this.zziw.zzal());
        }
        if (!TextUtils.isEmpty(this.zziw.getPassword())) {
            this.zzix.zzca(Base64Utils.encode("redacted".getBytes()));
        }
        List zzdu = zzdm.zzdu();
        if (zzdu == null) {
            zzdu = new ArrayList();
        }
        this.zzix.zzb(zzdu);
        this.zzir.zza(zza.zza(this.zziv, zzdm), this.zzix);
    }
}
