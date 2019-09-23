package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;

public final class zzjm {

    public static final class zza extends zzft<zza, C3781zza> implements zzhe {
        /* access modifiers changed from: private */
        public static final zza zzaea = new zza();
        private static volatile zzhm<zza> zzm;
        private String zzadw = "";
        private String zzadx = "";
        private String zzady = "";
        private String zzadz = "";
        private String zzav = "";

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzjm$zza$zza reason: collision with other inner class name */
        public static final class C3781zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zza, C3781zza> implements zzhe {
            private C3781zza() {
                super(zza.zzaea);
            }

            public final C3781zza zzdf(String str) {
                zzhj();
                ((zza) this.zzxc).zzde(str);
                return this;
            }

            public final C3781zza zzdg(String str) {
                zzhj();
                ((zza) this.zzxc).zzce(str);
                return this;
            }

            /* synthetic */ C3781zza(zzjn zzjn) {
                this();
            }
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        public final void zzde(String str) {
            if (str != null) {
                this.zzadw = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzce(String str) {
            if (str != null) {
                this.zzav = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C3781zza zzka() {
            return (C3781zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzaea.zza(zze.zzxj, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzjn.zzn[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3781zza(null);
                case 3:
                    Object[] objArr = {"zzadw", "zzadx", "zzav", "zzady", "zzadz"};
                    return zza((zzhc) zzaea, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", objArr);
                case 4:
                    return zzaea;
                case 5:
                    zzhm<zza> zzhm = zzm;
                    if (zzhm == null) {
                        synchronized (zza.class) {
                            zzhm = zzm;
                            if (zzhm == null) {
                                zzhm = new com.google.android.gms.internal.firebase_auth.zzft.zzb<>(zzaea);
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
            zzft.zza(zza.class, zzaea);
        }
    }

    public static final class zzb extends zzft<zzb, zza> implements zzhe {
        /* access modifiers changed from: private */
        public static final zzb zzaef = new zzb();
        private static volatile zzhm<zzb> zzm;
        private String zzaeb = "";
        private String zzaec = "";
        private String zzaed = "";
        private long zzaee;
        private String zzaq = "";
        private String zzav = "";
        private long zzaw;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzb, zza> implements zzhe {
            private zza() {
                super(zzb.zzaef);
            }

            /* synthetic */ zza(zzjn zzjn) {
                this();
            }
        }

        private zzb() {
        }

        public final String zzdw() {
            return this.zzaeb;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String zzdx() {
            return this.zzaec;
        }

        public final String zzr() {
            return this.zzav;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzjn.zzn[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    Object[] objArr = {"zzaeb", "zzaw", "zzaec", "zzav", "zzaq", "zzaed", "zzaee"};
                    return zza((zzhc) zzaef, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002", objArr);
                case 4:
                    return zzaef;
                case 5:
                    zzhm<zzb> zzhm = zzm;
                    if (zzhm == null) {
                        synchronized (zzb.class) {
                            zzhm = zzm;
                            if (zzhm == null) {
                                zzhm = new com.google.android.gms.internal.firebase_auth.zzft.zzb<>(zzaef);
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

        public static zzhm<zzb> zzl() {
            return (zzhm) zzaef.zza(zze.zzxl, (Object) null, (Object) null);
        }

        static {
            zzft.zza(zzb.class, zzaef);
        }
    }
}
