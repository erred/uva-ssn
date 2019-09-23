package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzat implements RemoteCall {
    private final zzas zzkf;

    zzat(zzas zzas) {
        this.zzkf = zzas;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkf.zzb((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
