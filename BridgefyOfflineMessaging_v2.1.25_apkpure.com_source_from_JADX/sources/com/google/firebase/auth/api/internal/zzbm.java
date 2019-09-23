package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

@VisibleForTesting
final class zzbm extends zzeo<AuthResult, zza> {
    private final EmailAuthCredential zzij;

    public zzbm(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zzij = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
    }

    public final String zzda() {
        return "linkEmailAuthCredential";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzbn(this)).build();
    }

    public final void zzdd() {
        zzl zza = zzao.zza(this.zzgm, this.zznl);
        ((zza) this.zzne).zza(this.zznk, zza);
        zzc(new zzf(zza));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzj(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        zzbw zzbw = new zzbw(this.zzij.zza(this.zznd));
        if (this.zznr) {
            zzdq.zzdh().zza(zzbw.zzct(), (zzdx) this.zznc);
        } else {
            zzdq.zzdh().zza(zzbw, (zzdx) this.zznc);
        }
    }
}
