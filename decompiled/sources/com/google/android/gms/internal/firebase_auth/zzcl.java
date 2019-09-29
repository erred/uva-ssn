package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzc;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcl implements zzff<zzc> {
    private String zzgc;

    public zzcl(String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzhc zzds() {
        return (zzc) ((zzft) zzc.zzn().zzh(this.zzgc).zzhn());
    }
}
