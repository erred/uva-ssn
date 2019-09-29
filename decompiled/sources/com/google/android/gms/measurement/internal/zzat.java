package com.google.android.gms.measurement.internal;

final class zzat implements Runnable {
    private final /* synthetic */ int zzamd;
    private final /* synthetic */ String zzame;
    private final /* synthetic */ Object zzamf;
    private final /* synthetic */ Object zzamg;
    private final /* synthetic */ Object zzamh;
    private final /* synthetic */ zzas zzami;

    zzat(zzas zzas, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzami = zzas;
        this.zzamd = i;
        this.zzame = str;
        this.zzamf = obj;
        this.zzamg = obj2;
        this.zzamh = obj3;
    }

    public final void run() {
        zzbd zzgu = this.zzami.zzada.zzgu();
        if (!zzgu.isInitialized()) {
            this.zzami.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzami.zzals == 0) {
            if (this.zzami.zzgv().zzdw()) {
                zzas zzas = this.zzami;
                this.zzami.zzgw();
                zzas.zzals = 'C';
            } else {
                zzas zzas2 = this.zzami;
                this.zzami.zzgw();
                zzas2.zzals = 'c';
            }
        }
        if (this.zzami.zzade < 0) {
            this.zzami.zzade = this.zzami.zzgv().zzhh();
        }
        char charAt = "01VDIWEA?".charAt(this.zzamd);
        char zza = this.zzami.zzals;
        long zzb = this.zzami.zzade;
        String zza2 = zzas.zza(true, this.zzame, this.zzamf, this.zzamg, this.zzamh);
        StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(zza);
        sb.append(zzb);
        sb.append(":");
        sb.append(zza2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.zzame.substring(0, 1024);
        }
        zzgu.zzamz.zzc(sb2, 1);
    }
}
