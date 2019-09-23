package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zzb;
import java.util.List;

public final class zzr extends zzft<zzr, zza> implements zzhe {
    /* access modifiers changed from: private */
    public static final zzr zzfl = new zzr();
    private static volatile zzhm<zzr> zzm;
    private String zzao = "";
    private String zzat = "";
    private String zzby = "";
    private String zzcd = "";
    private zzgb<String> zzcf = zzft.zzhf();
    private boolean zzcg;
    private String zzcn = "";
    private long zzcs;
    private long zzct;
    private zzgb<zzm> zzcv = zzhf();
    private boolean zzcy;
    private String zzdp = "";
    private String zzdq = "";
    private String zzdr = "";
    private String zzei = "";
    private zzeh zzfe = zzeh.zzso;
    private zzeh zzff = zzeh.zzso;
    private int zzfg;
    private long zzfh;
    private long zzfi;
    private boolean zzfj;
    private String zzfk = "";
    private int zzi;

    public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzr, zza> implements zzhe {
        private zza() {
            super(zzr.zzfl);
        }

        /* synthetic */ zza(zzs zzs) {
            this();
        }
    }

    private zzr() {
    }

    public final String getLocalId() {
        return this.zzao;
    }

    public final String getEmail() {
        return this.zzat;
    }

    public final String getDisplayName() {
        return this.zzcd;
    }

    public final String zzal() {
        return this.zzcn;
    }

    public final boolean zzan() {
        return this.zzcg;
    }

    public final List<zzm> zzak() {
        return this.zzcv;
    }

    public final long zzbk() {
        return this.zzcs;
    }

    public final long zzbl() {
        return this.zzct;
    }

    public final String zzbm() {
        return this.zzfk;
    }

    public final String getPhoneNumber() {
        return this.zzby;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzs.zzn[i - 1]) {
            case 1:
                return new zzr();
            case 2:
                return new zza(null);
            case 3:
                Object[] objArr = {"zzi", "zzao", "zzat", "zzcd", "zzcf", "zzdp", "zzcn", "zzdq", "zzdr", "zzfe", "zzff", "zzfg", "zzcg", "zzfh", "zzcv", zzm.class, "zzfi", "zzcy", "zzcs", "zzct", "zzei", "zzfj", "zzfk", "zzby"};
                return zza((zzhc) zzfl, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u001a\u0005\b\u0003\u0006\b\u0004\u0007\b\u0005\b\b\u0006\t\n\u0007\n\n\b\u000b\u0004\t\f\u0007\n\r\u0002\u000b\u000e\u001b\u000f\u0002\f\u0010\u0007\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\b\u0013", objArr);
            case 4:
                return zzfl;
            case 5:
                zzhm<zzr> zzhm = zzm;
                if (zzhm == null) {
                    synchronized (zzr.class) {
                        zzhm = zzm;
                        if (zzhm == null) {
                            zzhm = new zzb<>(zzfl);
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
        zzft.zza(zzr.class, zzfl);
    }
}
