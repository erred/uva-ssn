package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzjm.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcp implements zzff<zza> {
    private String zzow;
    private String zzox;
    private final String zzoy;

    public zzcp(String str) {
        this(str, null);
    }

    private zzcp(String str, String str2) {
        this.zzow = zzco.REFRESH_TOKEN.toString();
        this.zzox = Preconditions.checkNotEmpty(str);
        this.zzoy = null;
    }

    public final /* synthetic */ zzhc zzds() {
        return (zza) ((zzft) zza.zzka().zzdf(this.zzow).zzdg(this.zzox).zzhn());
    }
}
