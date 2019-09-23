package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcj implements RemoteCall {
    private final zzci zzlm;

    zzcj(zzci zzci) {
        this.zzlm = zzci;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlm.zzt((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
