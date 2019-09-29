package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcb implements RemoteCall {
    private final zzca zzlf;

    zzcb(zzca zzca) {
        this.zzlf = zzca;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlf.zzq((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
