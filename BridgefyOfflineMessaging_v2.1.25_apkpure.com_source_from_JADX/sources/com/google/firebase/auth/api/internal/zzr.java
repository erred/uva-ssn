package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzq;

final class zzr implements zzez<zzdt> {
    private final /* synthetic */ zzez zzjg;
    private final /* synthetic */ zzq zzjh;

    zzr(zzq zzq, zzez zzez) {
        this.zzjh = zzq;
        this.zzjg = zzez;
    }

    public final void zzbp(String str) {
        this.zzjg.zzbp(str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdt zzdt = (zzdt) obj;
        if (zzdt.zzed()) {
            Status status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            if (this.zzjh.zzis.zziq.zzdi().booleanValue()) {
                this.zzjh.zzir.zza(new zzcg(status, zzdt.zzcv(), zzdt.getEmail()));
                return;
            }
            this.zzjh.zzir.onFailure(status);
        } else if (!this.zzjh.zzis.zziq.zzdi().booleanValue() || TextUtils.isEmpty(zzdt.getErrorMessage())) {
            this.zzjh.zzis.zza(new zzcz(zzdt.zzr(), zzdt.getIdToken(), Long.valueOf(zzdt.zzs()), "Bearer"), zzdt.getRawUserInfo(), zzdt.getProviderId(), Boolean.valueOf(zzdt.isNewUser()), zzdt.zzcv(), this.zzjh.zzir, this.zzjg);
        } else {
            this.zzjh.zzir.zza(new zzcg(zzq.zzcu(zzdt.getErrorMessage()), zzdt.zzcv(), zzdt.getEmail()));
        }
    }
}
