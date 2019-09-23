package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbb implements RemoteCall {
    private final zzba zzkm;

    zzbb(zzba zzba) {
        this.zzkm = zzba;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkm.zzd((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
