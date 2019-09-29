package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzdj implements RemoteCall {
    private final zzdi zzmc;

    zzdj(zzdi zzdi) {
        this.zzmc = zzdi;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzmc.zzaf((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
