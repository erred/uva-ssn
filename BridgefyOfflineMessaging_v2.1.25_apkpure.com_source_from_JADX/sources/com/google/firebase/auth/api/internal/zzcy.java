package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzl;

@VisibleForTesting
final class zzcy extends zzeo<AuthResult, zza> {
    public zzcy() {
        super(2);
    }

    public final String zzda() {
        return "unlinkEmailCredential";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzcz(this)).build();
    }

    public final void zzdd() {
        zzl zza = zzao.zza(this.zzgm, this.zznl);
        ((zza) this.zzne).zza(this.zznk, zza);
        zzc(new zzf(zza));
    }
}
