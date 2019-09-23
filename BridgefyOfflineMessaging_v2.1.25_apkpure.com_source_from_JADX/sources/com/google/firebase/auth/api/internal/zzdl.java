package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzdl implements RemoteCall {
    private final zzdk zzmd;

    zzdl(zzdk zzdk) {
        this.zzmd = zzdk;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzmd.zzag((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
