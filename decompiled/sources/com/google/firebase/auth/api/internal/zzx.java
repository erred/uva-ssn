package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzq;

final class zzx implements zzez<zzdt> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;

    zzx(zza zza, zzdp zzdp) {
        this.zzis = zza;
        this.zzir = zzdp;
    }

    public final void zzbp(String str) {
        this.zzir.onFailure(zzq.zzcu(str));
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdt zzdt = (zzdt) obj;
        if (zzdt.zzed()) {
            Status status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            if (this.zzis.zziq.zzdi().booleanValue()) {
                this.zzir.zza(new zzcg(status, zzdt.zzcv(), zzdt.getEmail()));
                return;
            }
            this.zzir.onFailure(status);
        } else if (!this.zzis.zziq.zzdi().booleanValue() || TextUtils.isEmpty(zzdt.getErrorMessage())) {
            this.zzis.zza(new zzcz(zzdt.zzr(), zzdt.getIdToken(), Long.valueOf(zzdt.zzs()), "Bearer"), zzdt.getRawUserInfo(), zzdt.getProviderId(), Boolean.valueOf(zzdt.isNewUser()), zzdt.zzcv(), this.zzir, this);
        } else {
            this.zzir.zza(new zzcg(zzq.zzcu(zzdt.getErrorMessage()), zzdt.zzcv(), zzdt.getEmail()));
        }
    }
}
