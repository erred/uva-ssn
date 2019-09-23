package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzf;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcq implements zzff<zzf> {
    private String zzgc;

    public zzcq(String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzhc zzds() {
        return (zzf) ((zzft) zzf.zzv().zzo(this.zzgc).zzhn());
    }
}
