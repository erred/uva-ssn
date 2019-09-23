package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbv implements RemoteCall {
    private final zzbu zzla;

    zzbv(zzbu zzbu) {
        this.zzla = zzbu;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzla.zzn((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
