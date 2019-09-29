package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;

public final class zzfe {

    public static final class zza extends zzuo<zza, C3783zza> implements zzvx {
        /* access modifiers changed from: private */
        public static final zza zzauw = new zza();
        private static volatile zzwf<zza> zznw;
        private String zzauu = "";
        private long zzauv;
        private int zznr;

        /* renamed from: com.google.android.gms.internal.measurement.zzfe$zza$zza reason: collision with other inner class name */
        public static final class C3783zza extends com.google.android.gms.internal.measurement.zzuo.zza<zza, C3783zza> implements zzvx {
            private C3783zza() {
                super(zza.zzauw);
            }

            public final C3783zza zzda(String str) {
                zzwk();
                ((zza) this.zzbyh).setName(str);
                return this;
            }

            public final C3783zza zzan(long j) {
                zzwk();
                ((zza) this.zzbyh).zzam(j);
                return this;
            }

            /* synthetic */ C3783zza(zzff zzff) {
                this();
            }
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        public final void setName(String str) {
            if (str != null) {
                this.zznr |= 1;
                this.zzauu = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzam(long j) {
            this.zznr |= 2;
            this.zzauv = j;
        }

        public static C3783zza zzmn() {
            return (C3783zza) ((com.google.android.gms.internal.measurement.zzuo.zza) zzauw.zza(zze.zzbyo, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3783zza(null);
                case 3:
                    Object[] objArr = {"zznr", "zzauu", "zzauv"};
                    return zza((zzvv) zzauw, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", objArr);
                case 4:
                    return zzauw;
                case 5:
                    zzwf<zza> zzwf = zznw;
                    if (zzwf == null) {
                        synchronized (zza.class) {
                            zzwf = zznw;
                            if (zzwf == null) {
                                zzwf = new com.google.android.gms.internal.measurement.zzuo.zzb<>(zzauw);
                                zznw = zzwf;
                            }
                        }
                    }
                    return zzwf;
                case 6:
                    return Byte.valueOf(1);
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzuo.zza(zza.class, zzauw);
        }
    }

    public static final class zzb extends zzuo<zzb, zza> implements zzvx {
        /* access modifiers changed from: private */
        public static final zzb zzauz = new zzb();
        private static volatile zzwf<zzb> zznw;
        private int zzaux = 1;
        private zzuu<zza> zzauy = zzwg();
        private int zznr;

        public static final class zza extends com.google.android.gms.internal.measurement.zzuo.zza<zzb, zza> implements zzvx {
            private zza() {
                super(zzb.zzauz);
            }

            public final zza zzb(zza zza) {
                zzwk();
                ((zzb) this.zzbyh).zza(zza);
                return this;
            }

            /* synthetic */ zza(zzff zzff) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzfe$zzb$zzb reason: collision with other inner class name */
        public enum C3784zzb implements zzur {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzus<C3784zzb> zzoa = null;
            private final int value;

            public final int zzc() {
                return this.value;
            }

            public static C3784zzb zzt(int i) {
                switch (i) {
                    case 1:
                        return RADS;
                    case 2:
                        return PROVISIONING;
                    default:
                        return null;
                }
            }

            public static zzut zzd() {
                return zzfh.zzoc;
            }

            private C3784zzb(int i) {
                this.value = i;
            }

            static {
                zzoa = new zzfg();
            }
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            if (zza2 != null) {
                if (!this.zzauy.zztz()) {
                    zzuu<zza> zzuu = this.zzauy;
                    int size = zzuu.size();
                    this.zzauy = zzuu.zzal(size == 0 ? 10 : size << 1);
                }
                this.zzauy.add(zza2);
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzmp() {
            return (zza) ((com.google.android.gms.internal.measurement.zzuo.zza) zzauz.zza(zze.zzbyo, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    Object[] objArr = {"zznr", "zzaux", C3784zzb.zzd(), "zzauy", zza.class};
                    return zza((zzvv) zzauz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", objArr);
                case 4:
                    return zzauz;
                case 5:
                    zzwf<zzb> zzwf = zznw;
                    if (zzwf == null) {
                        synchronized (zzb.class) {
                            zzwf = zznw;
                            if (zzwf == null) {
                                zzwf = new com.google.android.gms.internal.measurement.zzuo.zzb<>(zzauz);
                                zznw = zzwf;
                            }
                        }
                    }
                    return zzwf;
                case 6:
                    return Byte.valueOf(1);
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzwf<zzb> zza() {
            return (zzwf) zzauz.zza(zze.zzbyq, (Object) null, (Object) null);
        }

        static {
            zzuo.zza(zzb.class, zzauz);
        }
    }
}
