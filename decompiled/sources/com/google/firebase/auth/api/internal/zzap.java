package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzap implements Continuation<ResultT, Task<ResultT>> {
    private final /* synthetic */ zzam zzka;
    private final /* synthetic */ zzao zzkb;

    zzap(zzao zzao, zzam zzam) {
        this.zzkb = zzao;
        this.zzka = zzam;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        return task.getException() instanceof UnsupportedApiCallException ? this.zzkb.zza(this.zzka.zzdc()) : task;
    }
}
