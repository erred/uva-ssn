package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zzp;

final class zzfh {
    private zzdz<zzp> zzbfp;
    private zzp zzbfq;

    public zzfh(zzdz<zzp> zzdz, zzp zzp) {
        this.zzbfp = zzdz;
        this.zzbfq = zzp;
    }

    public final zzdz<zzp> zzpv() {
        return this.zzbfp;
    }

    public final zzp zzpw() {
        return this.zzbfq;
    }

    public final int getSize() {
        return ((zzp) this.zzbfp.getObject()).zzzh() + (this.zzbfq == null ? 0 : this.zzbfq.zzzh());
    }
}
