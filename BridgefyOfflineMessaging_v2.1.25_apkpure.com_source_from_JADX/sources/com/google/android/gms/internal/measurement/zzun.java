package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;

final class zzun implements zzvu {
    private static final zzun zzbyc = new zzun();

    private zzun() {
    }

    public static zzun zzwe() {
        return zzbyc;
    }

    public final boolean zze(Class<?> cls) {
        return zzuo.class.isAssignableFrom(cls);
    }

    public final zzvt zzf(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzvt) zzuo.zzg(cls.asSubclass(zzuo.class)).zza(zze.zzbym, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
