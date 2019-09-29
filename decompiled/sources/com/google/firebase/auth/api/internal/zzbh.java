package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbh implements RemoteCall {
    private final zzbg zzkq;

    zzbh(zzbg zzbg) {
        this.zzkq = zzbg;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzkq.zzg((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
