package com.google.android.gms.tagmanager;

import java.util.List;

final class zzap implements zzaq {
    private final /* synthetic */ DataLayer zzbbh;

    zzap(DataLayer dataLayer) {
        this.zzbbh = dataLayer;
    }

    public final void zze(List<zza> list) {
        for (zza zza : list) {
            this.zzbbh.zzf(DataLayer.zzk(zza.mKey, zza.mValue));
        }
        this.zzbbh.zzbbg.countDown();
    }
}
