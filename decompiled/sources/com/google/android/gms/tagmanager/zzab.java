package com.google.android.gms.tagmanager;

final class zzab implements zzac {
    private final /* synthetic */ zzy zzbas;
    private Long zzbat;
    private final /* synthetic */ boolean zzbau;

    zzab(zzy zzy, boolean z) {
        this.zzbas = zzy;
        this.zzbau = z;
    }

    public final boolean zzb(Container container) {
        if (!this.zzbau) {
            return !container.isDefault();
        }
        long lastRefreshTime = container.getLastRefreshTime();
        if (this.zzbat == null) {
            this.zzbat = Long.valueOf(this.zzbas.zzbaj.zznz());
        }
        return lastRefreshTime + this.zzbat.longValue() >= this.zzbas.zzrz.currentTimeMillis();
    }
}
