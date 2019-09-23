package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzdb implements RemoteCall {
    private final zzda zzly;

    zzdb(zzda zzda) {
        this.zzly = zzda;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzly.zzab((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
