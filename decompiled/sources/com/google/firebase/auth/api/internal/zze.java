package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzcm;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzq;

final class zze implements zzez<zzcz> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;
    private final /* synthetic */ EmailAuthCredential zzit;

    zze(zza zza, EmailAuthCredential emailAuthCredential, zzdp zzdp) {
        this.zzis = zza;
        this.zzit = emailAuthCredential;
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzis.zza(new zzcm(this.zzit, ((zzcz) obj).zzdw()), this.zzir);
    }
}
