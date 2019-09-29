package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcv implements RemoteCall {
    private final zzcu zzlv;

    zzcv(zzcu zzcu) {
        this.zzlv = zzcu;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlv.zzz((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
