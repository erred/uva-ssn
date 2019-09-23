package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbk;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

@VisibleForTesting
final class zzdm extends zzeo<Void, OnVerificationStateChangedCallbacks> {
    private final zzbk zzme;

    public zzdm(zzdj zzdj) {
        super(8);
        Preconditions.checkNotNull(zzdj);
        this.zzme = new zzbk(zzdj);
    }

    public final String zzda() {
        return "verifyPhoneNumber";
    }

    public final void zzdd() {
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzdn(this)).build();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzah(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzme.zzcr(), (zzdx) this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzme, (zzdx) this.zznc);
        }
    }
}
