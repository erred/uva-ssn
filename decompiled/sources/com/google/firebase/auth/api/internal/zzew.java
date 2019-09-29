package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzew<ResultT, CallbackT> implements zzen<ResultT> {
    private final zzeo<ResultT, CallbackT> zzod;
    private final TaskCompletionSource<ResultT> zzoe;

    public zzew(zzeo<ResultT, CallbackT> zzeo, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zzod = zzeo;
        this.zzoe = taskCompletionSource;
    }

    public final void zza(ResultT resultt, Status status) {
        Preconditions.checkNotNull(this.zzoe, "completion source cannot be null");
        if (status == null) {
            this.zzoe.setResult(resultt);
        } else if (this.zzod.zznp != null) {
            this.zzoe.setException(zzds.zza(status, this.zzod.zznp, this.zzod.zznq));
        } else {
            this.zzoe.setException(zzds.zzb(status));
        }
    }
}
