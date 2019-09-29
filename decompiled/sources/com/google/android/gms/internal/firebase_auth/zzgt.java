package com.google.android.gms.internal.firebase_auth;

final class zzgt implements zzhb {
    private zzhb[] zzzb;

    zzgt(zzhb... zzhbArr) {
        this.zzzb = zzhbArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzhb zzb : this.zzzb) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzha zzc(Class<?> cls) {
        zzhb[] zzhbArr;
        for (zzhb zzhb : this.zzzb) {
            if (zzhb.zzb(cls)) {
                return zzhb.zzc(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
