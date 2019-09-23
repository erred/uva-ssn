package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbd implements RemoteCall {
    private final zzbc zzkn;

    zzbd(zzbc zzbc) {
        this.zzkn = zzbc;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkn.zze((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
