package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzdd;
import com.google.firebase.auth.zzd;
import java.util.List;

final class zzi implements zzez<zzcr> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zzey zziu;
    private final /* synthetic */ String zziy;
    private final /* synthetic */ String zziz;
    private final /* synthetic */ Boolean zzja;
    private final /* synthetic */ zzd zzjb;
    private final /* synthetic */ zzcz zzjc;

    zzi(zza zza, zzey zzey, String str, String str2, Boolean bool, zzd zzd, zzdp zzdp, zzcz zzcz) {
        this.zziu = zzey;
        this.zziy = str;
        this.zziz = str2;
        this.zzja = bool;
        this.zzjb = zzd;
        this.zzir = zzdp;
        this.zzjc = zzcz;
    }

    public final void zzbp(String str) {
        this.zziu.zzbp(str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List zzdt = ((zzcr) obj).zzdt();
        if (zzdt == null || zzdt.isEmpty()) {
            this.zziu.zzbp("No users.");
            return;
        }
        boolean z = false;
        zzct zzct = (zzct) zzdt.get(0);
        zzdd zzdv = zzct.zzdv();
        List zzdu = zzdv != null ? zzdv.zzdu() : null;
        if (zzdu != null && !zzdu.isEmpty()) {
            if (!TextUtils.isEmpty(this.zziy)) {
                int i = 0;
                while (true) {
                    if (i >= zzdu.size()) {
                        break;
                    } else if (((zzdb) zzdu.get(i)).getProviderId().equals(this.zziy)) {
                        ((zzdb) zzdu.get(i)).zzcg(this.zziz);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                ((zzdb) zzdu.get(0)).zzcg(this.zziz);
            }
        }
        if (this.zzja != null) {
            zzct.zzo(this.zzja.booleanValue());
        } else {
            if (zzct.getLastSignInTimestamp() - zzct.getCreationTimestamp() < 1000) {
                z = true;
            }
            zzct.zzo(z);
        }
        zzct.zza(this.zzjb);
        this.zzir.zza(this.zzjc, zzct);
    }
}
