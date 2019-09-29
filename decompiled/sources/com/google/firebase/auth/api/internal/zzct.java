package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzct implements RemoteCall {
    private final zzcs zzlu;

    zzct(zzcs zzcs) {
        this.zzlu = zzcs;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlu.zzy((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
