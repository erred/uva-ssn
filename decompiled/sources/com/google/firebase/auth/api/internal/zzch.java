package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzch implements RemoteCall {
    private final zzcg zzlj;

    zzch(zzcg zzcg) {
        this.zzlj = zzcg;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlj.zzs((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
