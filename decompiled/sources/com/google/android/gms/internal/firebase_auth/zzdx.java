package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzt;
import com.google.android.gms.internal.firebase_auth.zzj.zzt.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdx implements zzff<zzt> {
    private String zzgh;
    private String zzgi;
    private final String zzgw;
    private boolean zzpt = true;

    public zzdx(String str, String str2, String str3) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        this.zzgi = Preconditions.checkNotEmpty(str2);
        this.zzgw = str3;
    }

    public final /* synthetic */ zzhc zzds() {
        zza zzm = zzt.zzbd().zzbj(this.zzgh).zzbk(this.zzgi).zzm(this.zzpt);
        if (this.zzgw != null) {
            zzm.zzbl(this.zzgw);
        }
        return (zzt) ((zzft) zzm.zzhn());
    }
}
