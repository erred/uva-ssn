package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcn implements RemoteCall {
    private final zzcm zzlq;

    zzcn(zzcm zzcm) {
        this.zzlq = zzcm;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlq.zzv((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
