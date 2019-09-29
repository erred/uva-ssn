package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbx implements RemoteCall {
    private final zzbw zzlc;

    zzbx(zzbw zzbw) {
        this.zzlc = zzbw;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlc.zzo((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
