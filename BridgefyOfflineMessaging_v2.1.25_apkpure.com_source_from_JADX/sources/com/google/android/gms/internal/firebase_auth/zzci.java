package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zza;
import com.google.android.gms.internal.firebase_auth.zzj.zza.C3779zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzci implements zzff<zza> {
    private final String zzgw;
    private String zzoj;
    private String zzok = "http://localhost";

    public zzci(String str, String str2) {
        this.zzoj = Preconditions.checkNotEmpty(str);
        this.zzgw = str2;
    }

    public final /* synthetic */ zzhc zzds() {
        C3779zza zze = zza.zzc().zzd(this.zzoj).zze(this.zzok);
        if (this.zzgw != null) {
            zze.zzf(this.zzgw);
        }
        return (zza) ((zzft) zze.zzhn());
    }
}
