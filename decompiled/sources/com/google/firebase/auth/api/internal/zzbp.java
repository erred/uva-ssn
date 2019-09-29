package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbp implements RemoteCall {
    private final zzbo zzkw;

    zzbp(zzbo zzbo) {
        this.zzkw = zzbo;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkw.zzk((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
