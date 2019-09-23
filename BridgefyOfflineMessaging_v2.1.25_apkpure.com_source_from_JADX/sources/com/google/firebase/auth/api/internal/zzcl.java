package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcl implements RemoteCall {
    private final zzck zzlo;

    zzcl(zzck zzck) {
        this.zzlo = zzck;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlo.zzu((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
