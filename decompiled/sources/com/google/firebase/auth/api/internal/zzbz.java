package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbz implements RemoteCall {
    private final zzby zzld;

    zzbz(zzby zzby) {
        this.zzld = zzby;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzld.zzp((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
