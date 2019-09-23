package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzdd implements RemoteCall {
    private final zzdc zzlz;

    zzdd(zzdc zzdc) {
        this.zzlz = zzdc;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlz.zzac((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
