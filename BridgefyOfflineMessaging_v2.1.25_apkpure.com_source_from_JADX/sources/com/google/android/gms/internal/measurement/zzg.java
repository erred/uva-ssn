package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzg {

    public static final class zza extends zzyc<zza> {
        public static final zzyd<zzp, zza> zzpt = zzyd.zza(11, zza.class, 810);
        private static final zza[] zzpu = new zza[0];
        public int[] zzpv;
        public int[] zzpw;
        public int[] zzpx;
        private int zzpy;
        public int[] zzpz;
        public int zzqa;
        private int zzqb;

        public zza() {
            this.zzpv = zzyl.zzcao;
            this.zzpw = zzyl.zzcao;
            this.zzpx = zzyl.zzcao;
            this.zzpy = 0;
            this.zzpz = zzyl.zzcao;
            this.zzqa = 0;
            this.zzqb = 0;
            this.zzcet = null;
            this.zzcfd = -1;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!zzyg.equals(this.zzpv, zza.zzpv) || !zzyg.equals(this.zzpw, zza.zzpw) || !zzyg.equals(this.zzpx, zza.zzpx) || this.zzpy != zza.zzpy || !zzyg.equals(this.zzpz, zza.zzpz) || this.zzqa != zza.zzqa || this.zzqb != zza.zzqb) {
                return false;
            }
            if (this.zzcet == null || this.zzcet.isEmpty()) {
                return zza.zzcet == null || zza.zzcet.isEmpty();
            }
            return this.zzcet.equals(zza.zzcet);
        }

        public final int hashCode() {
            return ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzpv)) * 31) + zzyg.hashCode(this.zzpw)) * 31) + zzyg.hashCode(this.zzpx)) * 31) + this.zzpy) * 31) + zzyg.hashCode(this.zzpz)) * 31) + this.zzqa) * 31) + this.zzqb) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
        }

        public final void zza(zzya zzya) throws IOException {
            if (this.zzpv != null && this.zzpv.length > 0) {
                for (int zzd : this.zzpv) {
                    zzya.zzd(1, zzd);
                }
            }
            if (this.zzpw != null && this.zzpw.length > 0) {
                for (int zzd2 : this.zzpw) {
                    zzya.zzd(2, zzd2);
                }
            }
            if (this.zzpx != null && this.zzpx.length > 0) {
                for (int zzd3 : this.zzpx) {
                    zzya.zzd(3, zzd3);
                }
            }
            if (this.zzpy != 0) {
                zzya.zzd(4, this.zzpy);
            }
            if (this.zzpz != null && this.zzpz.length > 0) {
                for (int zzd4 : this.zzpz) {
                    zzya.zzd(5, zzd4);
                }
            }
            if (this.zzqa != 0) {
                zzya.zzd(6, this.zzqa);
            }
            if (this.zzqb != 0) {
                zzya.zzd(7, this.zzqb);
            }
            super.zza(zzya);
        }

        /* access modifiers changed from: protected */
        public final int zzf() {
            int zzf = super.zzf();
            if (this.zzpv != null && this.zzpv.length > 0) {
                int i = 0;
                for (int zzbe : this.zzpv) {
                    i += zzya.zzbe(zzbe);
                }
                zzf = zzf + i + (this.zzpv.length * 1);
            }
            if (this.zzpw != null && this.zzpw.length > 0) {
                int i2 = 0;
                for (int zzbe2 : this.zzpw) {
                    i2 += zzya.zzbe(zzbe2);
                }
                zzf = zzf + i2 + (this.zzpw.length * 1);
            }
            if (this.zzpx != null && this.zzpx.length > 0) {
                int i3 = 0;
                for (int zzbe3 : this.zzpx) {
                    i3 += zzya.zzbe(zzbe3);
                }
                zzf = zzf + i3 + (this.zzpx.length * 1);
            }
            if (this.zzpy != 0) {
                zzf += zzya.zzh(4, this.zzpy);
            }
            if (this.zzpz != null && this.zzpz.length > 0) {
                int i4 = 0;
                for (int zzbe4 : this.zzpz) {
                    i4 += zzya.zzbe(zzbe4);
                }
                zzf = zzf + i4 + (this.zzpz.length * 1);
            }
            if (this.zzqa != 0) {
                zzf += zzya.zzh(6, this.zzqa);
            }
            return this.zzqb != 0 ? zzf + zzya.zzh(7, this.zzqb) : zzf;
        }

        public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
            while (true) {
                int zzuj = zzxz.zzuj();
                switch (zzuj) {
                    case 0:
                        return this;
                    case 8:
                        int zzb = zzyl.zzb(zzxz, 8);
                        int length = this.zzpv == null ? 0 : this.zzpv.length;
                        int[] iArr = new int[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzpv, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzxz.zzvb();
                            zzxz.zzuj();
                            length++;
                        }
                        iArr[length] = zzxz.zzvb();
                        this.zzpv = iArr;
                        break;
                    case 10:
                        int zzas = zzxz.zzas(zzxz.zzvb());
                        int position = zzxz.getPosition();
                        int i = 0;
                        while (zzxz.zzyy() > 0) {
                            zzxz.zzvb();
                            i++;
                        }
                        zzxz.zzcb(position);
                        int length2 = this.zzpv == null ? 0 : this.zzpv.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzpv, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzxz.zzvb();
                            length2++;
                        }
                        this.zzpv = iArr2;
                        zzxz.zzat(zzas);
                        break;
                    case 16:
                        int zzb2 = zzyl.zzb(zzxz, 16);
                        int length3 = this.zzpw == null ? 0 : this.zzpw.length;
                        int[] iArr3 = new int[(zzb2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzpw, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzxz.zzvb();
                            zzxz.zzuj();
                            length3++;
                        }
                        iArr3[length3] = zzxz.zzvb();
                        this.zzpw = iArr3;
                        break;
                    case 18:
                        int zzas2 = zzxz.zzas(zzxz.zzvb());
                        int position2 = zzxz.getPosition();
                        int i2 = 0;
                        while (zzxz.zzyy() > 0) {
                            zzxz.zzvb();
                            i2++;
                        }
                        zzxz.zzcb(position2);
                        int length4 = this.zzpw == null ? 0 : this.zzpw.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzpw, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzxz.zzvb();
                            length4++;
                        }
                        this.zzpw = iArr4;
                        zzxz.zzat(zzas2);
                        break;
                    case 24:
                        int zzb3 = zzyl.zzb(zzxz, 24);
                        int length5 = this.zzpx == null ? 0 : this.zzpx.length;
                        int[] iArr5 = new int[(zzb3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzpx, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzxz.zzvb();
                            zzxz.zzuj();
                            length5++;
                        }
                        iArr5[length5] = zzxz.zzvb();
                        this.zzpx = iArr5;
                        break;
                    case 26:
                        int zzas3 = zzxz.zzas(zzxz.zzvb());
                        int position3 = zzxz.getPosition();
                        int i3 = 0;
                        while (zzxz.zzyy() > 0) {
                            zzxz.zzvb();
                            i3++;
                        }
                        zzxz.zzcb(position3);
                        int length6 = this.zzpx == null ? 0 : this.zzpx.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzpx, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzxz.zzvb();
                            length6++;
                        }
                        this.zzpx = iArr6;
                        zzxz.zzat(zzas3);
                        break;
                    case 32:
                        this.zzpy = zzxz.zzvb();
                        break;
                    case 40:
                        int zzb4 = zzyl.zzb(zzxz, 40);
                        int length7 = this.zzpz == null ? 0 : this.zzpz.length;
                        int[] iArr7 = new int[(zzb4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzpz, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzxz.zzvb();
                            zzxz.zzuj();
                            length7++;
                        }
                        iArr7[length7] = zzxz.zzvb();
                        this.zzpz = iArr7;
                        break;
                    case 42:
                        int zzas4 = zzxz.zzas(zzxz.zzvb());
                        int position4 = zzxz.getPosition();
                        int i4 = 0;
                        while (zzxz.zzyy() > 0) {
                            zzxz.zzvb();
                            i4++;
                        }
                        zzxz.zzcb(position4);
                        int length8 = this.zzpz == null ? 0 : this.zzpz.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzpz, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzxz.zzvb();
                            length8++;
                        }
                        this.zzpz = iArr8;
                        zzxz.zzat(zzas4);
                        break;
                    case 48:
                        this.zzqa = zzxz.zzvb();
                        break;
                    case 56:
                        this.zzqb = zzxz.zzvb();
                        break;
                    default:
                        if (super.zza(zzxz, zzuj)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }
    }
}
