package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbf implements RemoteCall {
    private final zzbe zzkp;

    zzbf(zzbe zzbe) {
        this.zzkp = zzbe;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkp.zzf((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
