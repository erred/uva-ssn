package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzai;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzdc extends zzeo<Void, zza> {
    private final String zzgh;

    public zzdc(String str) {
        super(2);
        this.zzgh = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
    }

    public final String zzda() {
        return "updateEmail";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzdd(this)).build();
    }

    public final void zzdd() {
        ((zza) this.zzne).zza(this.zznk, zzao.zza(this.zzgm, this.zznl));
        zzc(null);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzac(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zznd.zzch(), this.zzgh, (zzdx) this.zznc);
        } else {
            zzdq.zzdh().zza(new zzai(this.zznd.zzch(), this.zzgh), (zzdx) this.zznc);
        }
    }
}
