package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import java.util.List;

final class zzw implements zzez<zzcr> {
    private final /* synthetic */ zzez zzjg;
    private final /* synthetic */ zzcz zzjj;
    private final /* synthetic */ zzv zzjl;

    zzw(zzv zzv, zzez zzez, zzcz zzcz) {
        this.zzjl = zzv;
        this.zzjg = zzez;
        this.zzjj = zzcz;
    }

    public final void zzbp(String str) {
        this.zzjg.zzbp(str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List zzdt = ((zzcr) obj).zzdt();
        if (zzdt == null || zzdt.isEmpty()) {
            this.zzjg.zzbp("No users");
        } else {
            this.zzjl.zzir.zza(this.zzjj, (zzct) zzdt.get(0));
        }
    }
}
