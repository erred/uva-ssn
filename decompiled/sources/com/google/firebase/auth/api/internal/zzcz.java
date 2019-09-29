package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzca;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcz implements RemoteCall {
    private final zzcy zzlx;

    zzcz(zzcy zzcy) {
        this.zzlx = zzcy;
    }

    public final void accept(Object obj, Object obj2) {
        zzcy zzcy = this.zzlx;
        zzdq zzdq = (zzdq) obj;
        zzcy.zzng = new zzew(zzcy, (TaskCompletionSource) obj2);
        if (zzcy.zznr) {
            zzdq.zzdh().zze(zzcy.zznd.zzch(), zzcy.zznc);
        } else {
            zzdq.zzdh().zza(new zzca(zzcy.zznd.zzch()), (zzdx) zzcy.zznc);
        }
    }
}
