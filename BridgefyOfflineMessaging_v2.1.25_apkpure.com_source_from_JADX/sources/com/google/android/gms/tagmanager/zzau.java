package com.google.android.gms.tagmanager;

import java.util.List;

final class zzau implements Runnable {
    private final /* synthetic */ List zzbbn;
    private final /* synthetic */ long zzbbo;
    private final /* synthetic */ zzat zzbbp;

    zzau(zzat zzat, List list, long j) {
        this.zzbbp = zzat;
        this.zzbbn = list;
        this.zzbbo = j;
    }

    public final void run() {
        this.zzbbp.zzb(this.zzbbn, this.zzbbo);
    }
}
