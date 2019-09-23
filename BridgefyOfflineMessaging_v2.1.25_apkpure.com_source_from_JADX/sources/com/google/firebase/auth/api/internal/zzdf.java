package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzdf implements RemoteCall {
    private final zzde zzma;

    zzdf(zzde zzde) {
        this.zzma = zzde;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzma.zzad((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
