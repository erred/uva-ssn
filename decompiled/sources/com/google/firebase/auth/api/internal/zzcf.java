package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzbe;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcf implements RemoteCall {
    private final zzce zzlh;

    zzcf(zzce zzce) {
        this.zzlh = zzce;
    }

    public final void accept(Object obj, Object obj2) {
        zzce zzce = this.zzlh;
        zzdq zzdq = (zzdq) obj;
        zzce.zzng = new zzew(zzce, (TaskCompletionSource) obj2);
        if (zzce.zznr) {
            zzdq.zzdh().zzf(zzce.zznd.zzch(), zzce.zznc);
        } else {
            zzdq.zzdh().zza(new zzbe(zzce.zznd.zzch()), (zzdx) zzce.zznc);
        }
    }
}
