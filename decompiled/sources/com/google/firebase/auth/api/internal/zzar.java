package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzar implements RemoteCall {
    private final zzaq zzkd;

    zzar(zzaq zzaq) {
        this.zzkd = zzaq;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkd.zza((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
