package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;

final class zzfs implements zzhb {
    private static final zzfs zzwx = new zzfs();

    private zzfs() {
    }

    public static zzfs zzhd() {
        return zzwx;
    }

    public final boolean zzb(Class<?> cls) {
        return zzft.class.isAssignableFrom(cls);
    }

    public final zzha zzc(Class<?> cls) {
        if (!zzft.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzha) zzft.zzd(cls.asSubclass(zzft.class)).zza(zze.zzxh, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
