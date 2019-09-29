package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzam;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzc;

@VisibleForTesting
final class zzas extends zzeo<ActionCodeResult, zza> {
    private final zzam zzke;

    public zzas(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzke = new zzam(str, str2);
    }

    public final String zzda() {
        return "checkActionCode";
    }

    public final TaskApiCall<zzdq, ActionCodeResult> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzat(this)).build();
    }

    public final void zzdd() {
        zzc(new zzc(this.zznn));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(zzdq zzdq, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zzi(this.zzke.zzcm(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzke, (zzdx) this.zznc);
        }
    }
}
