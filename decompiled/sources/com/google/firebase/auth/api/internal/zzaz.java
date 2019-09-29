package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzaz implements RemoteCall {
    private final zzay zzkk;

    zzaz(zzay zzay) {
        this.zzkk = zzay;
    }

    public final void accept(Object obj, Object obj2) {
        zzay zzay = this.zzkk;
        zzdq zzdq = (zzdq) obj;
        zzay.zzng = new zzew(zzay, (TaskCompletionSource) obj2);
        if (zzay.zznr) {
            zzdq.zzdh().zzg(zzay.zznd.zzch(), zzay.zznc);
        } else {
            zzdq.zzdh().zza(new zzas(zzay.zznd.zzch()), (zzdx) zzay.zznc);
        }
    }
}
