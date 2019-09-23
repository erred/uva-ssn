package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcd implements RemoteCall {
    private final zzcc zzlg;

    zzcd(zzcc zzcc) {
        this.zzlg = zzcc;
    }

    public final void accept(Object obj, Object obj2) {
        this.zzlg.zzr((zzdq) obj, (TaskCompletionSource) obj2);
    }
}
