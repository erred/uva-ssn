package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzaa;

@VisibleForTesting
final class zzbe extends zzeo<GetTokenResult, zza> {
    private final zzau zzko;

    public zzbe(String str) {
        super(1);
        Preconditions.checkNotEmpty(str, "refresh token cannot be null");
        this.zzko = new zzau(str);
    }

    public final String zzda() {
        return "getAccessToken";
    }

    public final TaskApiCall<zzdq, GetTokenResult> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzbf(this)).build();
    }

    public final void zzdd() {
        if (TextUtils.isEmpty(this.zznk.zzr())) {
            this.zznk.zzce(this.zzko.zzr());
        }
        ((zza) this.zzne).zza(this.zznk, this.zznd);
        zzc(zzaa.zzcv(this.zznk.zzdw()));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzf(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzko.zzr(), (zzdx) this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzko, (zzdx) this.zznc);
        }
    }
}
