package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;

final class zzgr implements zzhx {
    private static final zzhb zzza = new zzgs();
    private final zzhb zzyz;

    public zzgr() {
        this(new zzgt(zzfs.zzhd(), zzig()));
    }

    private zzgr(zzhb zzhb) {
        this.zzyz = (zzhb) zzfv.zza(zzhb, "messageInfoFactory");
    }

    public final <T> zzhw<T> zze(Class<T> cls) {
        zzhy.zzg(cls);
        zzha zzc = this.zzyz.zzc(cls);
        if (zzc.zzio()) {
            if (zzft.class.isAssignableFrom(cls)) {
                return zzhh.zza(zzhy.zzjc(), zzfj.zzgt(), zzc.zzip());
            }
            return zzhh.zza(zzhy.zzja(), zzfj.zzgu(), zzc.zzip());
        } else if (zzft.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzhg.zza(cls, zzc, zzhl.zzis(), zzgm.zzif(), zzhy.zzjc(), zzfj.zzgt(), zzgz.zzil());
            }
            return zzhg.zza(cls, zzc, zzhl.zzis(), zzgm.zzif(), zzhy.zzjc(), null, zzgz.zzil());
        } else if (zza(zzc)) {
            return zzhg.zza(cls, zzc, zzhl.zzir(), zzgm.zzie(), zzhy.zzja(), zzfj.zzgu(), zzgz.zzik());
        } else {
            return zzhg.zza(cls, zzc, zzhl.zzir(), zzgm.zzie(), zzhy.zzjb(), null, zzgz.zzik());
        }
    }

    private static boolean zza(zzha zzha) {
        return zzha.zzin() == zze.zzxn;
    }

    private static zzhb zzig() {
        try {
            return (zzhb) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzza;
        }
    }
}
