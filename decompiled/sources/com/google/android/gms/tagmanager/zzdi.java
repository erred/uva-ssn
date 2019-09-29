package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
public final class zzdi {
    @VisibleForTesting
    private static zzdj zzbdm = new zzba();
    static int zzyn;

    public static void setLogLevel(int i) {
        zzyn = i;
        zzbdm.setLogLevel(i);
    }

    /* renamed from: e */
    public static void m8600e(String str) {
        zzbdm.mo17959e(str);
    }

    public static void zza(String str, Throwable th) {
        zzbdm.zza(str, th);
    }

    public static void zzab(String str) {
        zzbdm.zzab(str);
    }

    public static void zzb(String str, Throwable th) {
        zzbdm.zzb(str, th);
    }

    public static void zzdm(String str) {
        zzbdm.zzdm(str);
    }

    public static void zzdn(String str) {
        zzbdm.zzdn(str);
    }

    /* renamed from: v */
    public static void m8601v(String str) {
        zzbdm.mo17961v(str);
    }
}
