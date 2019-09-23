package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbl implements RemoteCall {
    private final zzbk zzkt;

    zzbl(zzbk zzbk) {
        this.zzkt = zzbk;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkt.zzi((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
