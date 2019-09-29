package com.google.android.gms.internal.firebase_auth;

final class zzff {
    private static final Class<?> zztt = zzgm();

    private static Class<?> zzgm() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzfg zzgn() {
        if (zztt != null) {
            try {
                return zzdc("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzfg.zztx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.firebase_auth.zzfg zzgo() {
        /*
            java.lang.Class<?> r0 = zztt
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.firebase_auth.zzfg r0 = zzdc(r0)     // Catch:{ Exception -> 0x000b }
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x0012
            com.google.android.gms.internal.firebase_auth.zzfg r0 = com.google.android.gms.internal.firebase_auth.zzfg.zzgo()
        L_0x0012:
            if (r0 != 0) goto L_0x0018
            com.google.android.gms.internal.firebase_auth.zzfg r0 = zzgn()
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzff.zzgo():com.google.android.gms.internal.firebase_auth.zzfg");
    }

    private static final zzfg zzdc(String str) throws Exception {
        return (zzfg) zztt.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
