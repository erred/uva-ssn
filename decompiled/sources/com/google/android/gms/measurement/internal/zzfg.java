package com.google.android.gms.measurement.internal;

final class zzfg extends zzy {
    private final /* synthetic */ zzfd zzatd;

    zzfg(zzfd zzfd, zzct zzct) {
        this.zzatd = zzfd;
        super(zzct);
    }

    public final void run() {
        zzfd zzfd = this.zzatd;
        zzfd.zzaf();
        zzfd.zzgt().zzjo().zzby("Current session is expired, remove the session number and Id");
        if (zzfd.zzgv().zzbg(zzfd.zzgk().zzal())) {
            zzfd.zzgj().zza("auto", "_sid", (Object) null, zzfd.zzbx().currentTimeMillis());
        }
        if (zzfd.zzgv().zzbh(zzfd.zzgk().zzal())) {
            zzfd.zzgj().zza("auto", "_sno", (Object) null, zzfd.zzbx().currentTimeMillis());
        }
    }
}
