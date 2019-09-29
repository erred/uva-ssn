package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzav implements RemoteCall {
    private final zzau zzkh;

    zzav(zzau zzau) {
        this.zzkh = zzau;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkh.zzc((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
