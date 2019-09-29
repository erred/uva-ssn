package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcx implements RemoteCall {
    private final zzcw zzlw;

    zzcx(zzcw zzcw) {
        this.zzlw = zzcw;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlw.zzaa((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
