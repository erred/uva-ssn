package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zzb;

public final class zzh extends zzft<zzh, zza> implements zzhe {
    /* access modifiers changed from: private */
    public static final zzh zzl = new zzh();
    private static volatile zzhm<zzh> zzm;
    private int zzi;
    private String zzj = "";
    private String zzk = "";

    public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzh, zza> implements zzhe {
        private zza() {
            super(zzh.zzl);
        }

        /* synthetic */ zza(zzi zzi) {
            this();
        }
    }

    private zzh() {
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzi.zzn[i - 1]) {
            case 1:
                return new zzh();
            case 2:
                return new zza(null);
            case 3:
                Object[] objArr = {"zzi", "zzj", "zzk"};
                return zza((zzhc) zzl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", objArr);
            case 4:
                return zzl;
            case 5:
                zzhm<zzh> zzhm = zzm;
                if (zzhm == null) {
                    synchronized (zzh.class) {
                        zzhm = zzm;
                        if (zzhm == null) {
                            zzhm = new zzb<>(zzl);
                            zzm = zzhm;
                        }
                    }
                }
                return zzhm;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzft.zza(zzh.class, zzl);
    }
}
