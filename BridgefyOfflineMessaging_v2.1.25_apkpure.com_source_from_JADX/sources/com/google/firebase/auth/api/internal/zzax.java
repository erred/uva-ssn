package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzax implements RemoteCall {
    private final zzaw zzkj;

    zzax(zzaw zzaw) {
        this.zzkj = zzaw;
    }

    public final void accept(Object obj, Object obj2) {
        zzaw zzaw = this.zzkj;
        zzdq zzdq = (zzdq) obj;
        zzaw.zzng = new zzew(zzaw, (TaskCompletionSource) obj2);
        if (zzaw.zznr) {
            zzdq.zzdh().zzc(zzaw.zzki.getEmail(), zzaw.zzki.getPassword(), (zzdx) zzaw.zznc);
        } else {
            zzdq.zzdh().zza(zzaw.zzki, (zzdx) zzaw.zznc);
        }
    }
}
