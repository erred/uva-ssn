package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbt implements RemoteCall {
    private final zzbs zzkz;

    zzbt(zzbs zzbs) {
        this.zzkz = zzbs;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkz.zzm((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
