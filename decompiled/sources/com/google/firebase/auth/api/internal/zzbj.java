package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbj implements RemoteCall {
    private final zzbi zzks;

    zzbj(zzbi zzbi) {
        this.zzks = zzbi;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzks.zzh((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
