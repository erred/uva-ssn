package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbn implements RemoteCall {
    private final zzbm zzku;

    zzbn(zzbm zzbm) {
        this.zzku = zzbm;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzku.zzj((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
