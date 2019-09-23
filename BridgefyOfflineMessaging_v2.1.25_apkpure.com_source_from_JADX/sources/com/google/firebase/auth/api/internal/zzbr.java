package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbr implements RemoteCall {
    private final zzbq zzkx;

    zzbr(zzbq zzbq) {
        this.zzkx = zzbq;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkx.zzl((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
