package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.firebase.auth.internal.zzv;

@VisibleForTesting
final class zzay extends zzeo<Void, zzv> {
    public zzay() {
        super(5);
    }

    public final String zzda() {
        return "delete";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        Feature[] featureArr;
        Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzaz(this)).build();
    }

    public final void zzdd() {
        ((zzv) this.zzne).zzcd();
        zzc(null);
    }
}
