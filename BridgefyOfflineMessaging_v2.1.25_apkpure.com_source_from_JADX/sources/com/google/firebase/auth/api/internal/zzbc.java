package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzr;

@VisibleForTesting
final class zzbc extends zzeo<SignInMethodQueryResult, zza> {
    private final zzaw zzkl;

    public zzbc(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzkl = new zzaw(str, str2);
    }

    public final String zzda() {
        return "fetchSignInMethodsForEmail";
    }

    public final TaskApiCall<zzdq, SignInMethodQueryResult> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzbd(this)).build();
    }

    public final void zzdd() {
        zzc(new zzr(this.zznm.getSignInMethods()));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zze(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zzc(this.zzkl.getEmail(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzkl, (zzdx) this.zznc);
        }
    }
}
