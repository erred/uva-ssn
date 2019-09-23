package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcr implements RemoteCall {
    private final zzcq zzlt;

    zzcr(zzcq zzcq) {
        this.zzlt = zzcq;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlt.zzx((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
