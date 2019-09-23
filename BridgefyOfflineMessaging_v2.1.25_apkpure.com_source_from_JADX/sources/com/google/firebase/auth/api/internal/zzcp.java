package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcp implements RemoteCall {
    private final zzco zzlr;

    zzcp(zzco zzco) {
        this.zzlr = zzco;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlr.zzw((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
