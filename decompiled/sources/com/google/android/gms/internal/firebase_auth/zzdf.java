package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzi;
import com.google.android.gms.internal.firebase_auth.zzj.zzi.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdf implements zzff<zzi> {
    private final String zzgw;
    private final String zzib;
    private final String zzic;

    public zzdf(String str, String str2, String str3) {
        this.zzib = Preconditions.checkNotEmpty(str);
        this.zzic = str2;
        this.zzgw = str3;
    }

    public final /* synthetic */ zzhc zzds() {
        zza zzaf = zzi.zzab().zzaf(this.zzib);
        if (this.zzic != null) {
            zzaf.zzag(this.zzic);
        }
        if (this.zzgw != null) {
            zzaf.zzah(this.zzgw);
        }
        return (zzi) ((zzft) zzaf.zzhn());
    }
}
