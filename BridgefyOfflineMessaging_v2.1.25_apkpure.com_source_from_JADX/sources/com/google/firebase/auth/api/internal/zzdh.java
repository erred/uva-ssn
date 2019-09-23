package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzdh implements RemoteCall {
    private final zzdg zzmb;

    zzdh(zzdg zzdg) {
        this.zzmb = zzdg;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzmb.zzae((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
