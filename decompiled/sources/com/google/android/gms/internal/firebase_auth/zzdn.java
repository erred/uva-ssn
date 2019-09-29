package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzn;
import com.google.android.gms.internal.firebase_auth.zzj.zzn.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdn implements zzff<zzn> {
    private String zzgh;
    private String zzgi;
    private String zzgw;
    private String zzhw;

    public zzdn(String str) {
        this.zzgw = str;
    }

    public zzdn(String str, String str2, String str3, String str4) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        this.zzgi = Preconditions.checkNotEmpty(str2);
        this.zzhw = null;
        this.zzgw = str4;
    }

    public final /* synthetic */ zzhc zzds() {
        zza zzap = zzn.zzap();
        if (this.zzgh != null) {
            zzap.zzau(this.zzgh);
        }
        if (this.zzgi != null) {
            zzap.zzav(this.zzgi);
        }
        if (this.zzgw != null) {
            zzap.zzaw(this.zzgw);
        }
        return (zzn) ((zzft) zzap.zzhn());
    }
}
