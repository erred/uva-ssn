package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzb;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

@VisibleForTesting
final class zzbq extends zzeo<AuthResult, zza> {
    private final com.google.android.gms.internal.firebase_auth.zzbq zzkv;

    public zzbq(AuthCredential authCredential, String str) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zzkv = new com.google.android.gms.internal.firebase_auth.zzbq(zzb.zza(authCredential, str).zzp(false));
    }

    public final String zzda() {
        return "reauthenticateWithCredentialWithData";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzbr(this)).build();
    }

    public final void zzdd() {
        zzl zza = zzao.zza(this.zzgm, this.zznl);
        if (this.zznd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zza) this.zzne).zza(this.zznk, zza);
            zzc(new zzf(zza));
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzl(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzkv.zzco(), (zzdx) this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzkv, (zzdx) this.zznc);
        }
    }
}
