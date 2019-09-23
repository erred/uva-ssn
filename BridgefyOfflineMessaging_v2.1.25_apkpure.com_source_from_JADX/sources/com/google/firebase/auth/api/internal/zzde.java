package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzak;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzde extends zzeo<Void, zza> {
    private final String zzgi;

    public zzde(String str) {
        super(2);
        this.zzgi = Preconditions.checkNotEmpty(str, "password cannot be null or empty");
    }

    public final String zzda() {
        return "updatePassword";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzdf(this)).build();
    }

    public final void zzdd() {
        ((zza) this.zzne).zza(this.zznk, zzao.zza(this.zzgm, this.zznl));
        zzc(null);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzad(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zzb(this.zznd.zzch(), this.zzgi, (zzdx) this.zznc);
        } else {
            zzdq.zzdh().zza(new zzak(this.zznd.zzch(), this.zzgi), (zzdx) this.zznc);
        }
    }
}
