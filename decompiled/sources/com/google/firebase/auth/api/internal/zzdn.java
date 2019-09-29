package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzdn implements RemoteCall {
    private final zzdm zzmf;

    zzdn(zzdm zzdm) {
        this.zzmf = zzdm;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzmf.zzah((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
