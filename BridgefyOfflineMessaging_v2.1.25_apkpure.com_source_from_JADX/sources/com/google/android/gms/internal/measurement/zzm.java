package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzm extends zzyc<zzm> {
    private static volatile zzm[] zzpi;
    public int[] zzpj;
    public int[] zzpk;
    public int[] zzpl;
    public int[] zzpm;
    public int[] zzpn;
    public int[] zzpo;
    public int[] zzpp;
    public int[] zzpq;
    public int[] zzpr;
    public int[] zzps;

    public static zzm[] zzi() {
        if (zzpi == null) {
            synchronized (zzyg.zzcfc) {
                if (zzpi == null) {
                    zzpi = new zzm[0];
                }
            }
        }
        return zzpi;
    }

    public zzm() {
        this.zzpj = zzyl.zzcao;
        this.zzpk = zzyl.zzcao;
        this.zzpl = zzyl.zzcao;
        this.zzpm = zzyl.zzcao;
        this.zzpn = zzyl.zzcao;
        this.zzpo = zzyl.zzcao;
        this.zzpp = zzyl.zzcao;
        this.zzpq = zzyl.zzcao;
        this.zzpr = zzyl.zzcao;
        this.zzps = zzyl.zzcao;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzm = (zzm) obj;
        if (!zzyg.equals(this.zzpj, zzm.zzpj) || !zzyg.equals(this.zzpk, zzm.zzpk) || !zzyg.equals(this.zzpl, zzm.zzpl) || !zzyg.equals(this.zzpm, zzm.zzpm) || !zzyg.equals(this.zzpn, zzm.zzpn) || !zzyg.equals(this.zzpo, zzm.zzpo) || !zzyg.equals(this.zzpp, zzm.zzpp) || !zzyg.equals(this.zzpq, zzm.zzpq) || !zzyg.equals(this.zzpr, zzm.zzpr) || !zzyg.equals(this.zzps, zzm.zzps)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzm.zzcet == null || zzm.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzm.zzcet);
    }

    public final int hashCode() {
        return ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzpj)) * 31) + zzyg.hashCode(this.zzpk)) * 31) + zzyg.hashCode(this.zzpl)) * 31) + zzyg.hashCode(this.zzpm)) * 31) + zzyg.hashCode(this.zzpn)) * 31) + zzyg.hashCode(this.zzpo)) * 31) + zzyg.hashCode(this.zzpp)) * 31) + zzyg.hashCode(this.zzpq)) * 31) + zzyg.hashCode(this.zzpr)) * 31) + zzyg.hashCode(this.zzps)) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzpj != null && this.zzpj.length > 0) {
            for (int zzd : this.zzpj) {
                zzya.zzd(1, zzd);
            }
        }
        if (this.zzpk != null && this.zzpk.length > 0) {
            for (int zzd2 : this.zzpk) {
                zzya.zzd(2, zzd2);
            }
        }
        if (this.zzpl != null && this.zzpl.length > 0) {
            for (int zzd3 : this.zzpl) {
                zzya.zzd(3, zzd3);
            }
        }
        if (this.zzpm != null && this.zzpm.length > 0) {
            for (int zzd4 : this.zzpm) {
                zzya.zzd(4, zzd4);
            }
        }
        if (this.zzpn != null && this.zzpn.length > 0) {
            for (int zzd5 : this.zzpn) {
                zzya.zzd(5, zzd5);
            }
        }
        if (this.zzpo != null && this.zzpo.length > 0) {
            for (int zzd6 : this.zzpo) {
                zzya.zzd(6, zzd6);
            }
        }
        if (this.zzpp != null && this.zzpp.length > 0) {
            for (int zzd7 : this.zzpp) {
                zzya.zzd(7, zzd7);
            }
        }
        if (this.zzpq != null && this.zzpq.length > 0) {
            for (int zzd8 : this.zzpq) {
                zzya.zzd(8, zzd8);
            }
        }
        if (this.zzpr != null && this.zzpr.length > 0) {
            for (int zzd9 : this.zzpr) {
                zzya.zzd(9, zzd9);
            }
        }
        if (this.zzps != null && this.zzps.length > 0) {
            for (int zzd10 : this.zzps) {
                zzya.zzd(10, zzd10);
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzpj != null && this.zzpj.length > 0) {
            int i = 0;
            for (int zzbe : this.zzpj) {
                i += zzya.zzbe(zzbe);
            }
            zzf = zzf + i + (this.zzpj.length * 1);
        }
        if (this.zzpk != null && this.zzpk.length > 0) {
            int i2 = 0;
            for (int zzbe2 : this.zzpk) {
                i2 += zzya.zzbe(zzbe2);
            }
            zzf = zzf + i2 + (this.zzpk.length * 1);
        }
        if (this.zzpl != null && this.zzpl.length > 0) {
            int i3 = 0;
            for (int zzbe3 : this.zzpl) {
                i3 += zzya.zzbe(zzbe3);
            }
            zzf = zzf + i3 + (this.zzpl.length * 1);
        }
        if (this.zzpm != null && this.zzpm.length > 0) {
            int i4 = 0;
            for (int zzbe4 : this.zzpm) {
                i4 += zzya.zzbe(zzbe4);
            }
            zzf = zzf + i4 + (this.zzpm.length * 1);
        }
        if (this.zzpn != null && this.zzpn.length > 0) {
            int i5 = 0;
            for (int zzbe5 : this.zzpn) {
                i5 += zzya.zzbe(zzbe5);
            }
            zzf = zzf + i5 + (this.zzpn.length * 1);
        }
        if (this.zzpo != null && this.zzpo.length > 0) {
            int i6 = 0;
            for (int zzbe6 : this.zzpo) {
                i6 += zzya.zzbe(zzbe6);
            }
            zzf = zzf + i6 + (this.zzpo.length * 1);
        }
        if (this.zzpp != null && this.zzpp.length > 0) {
            int i7 = 0;
            for (int zzbe7 : this.zzpp) {
                i7 += zzya.zzbe(zzbe7);
            }
            zzf = zzf + i7 + (this.zzpp.length * 1);
        }
        if (this.zzpq != null && this.zzpq.length > 0) {
            int i8 = 0;
            for (int zzbe8 : this.zzpq) {
                i8 += zzya.zzbe(zzbe8);
            }
            zzf = zzf + i8 + (this.zzpq.length * 1);
        }
        if (this.zzpr != null && this.zzpr.length > 0) {
            int i9 = 0;
            for (int zzbe9 : this.zzpr) {
                i9 += zzya.zzbe(zzbe9);
            }
            zzf = zzf + i9 + (this.zzpr.length * 1);
        }
        if (this.zzps == null || this.zzps.length <= 0) {
            return zzf;
        }
        int i10 = 0;
        for (int zzbe10 : this.zzps) {
            i10 += zzya.zzbe(zzbe10);
        }
        return zzf + i10 + (this.zzps.length * 1);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    return this;
                case 8:
                    int zzb = zzyl.zzb(zzxz, 8);
                    int length = this.zzpj == null ? 0 : this.zzpj.length;
                    int[] iArr = new int[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpj, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = zzxz.zzvb();
                        zzxz.zzuj();
                        length++;
                    }
                    iArr[length] = zzxz.zzvb();
                    this.zzpj = iArr;
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
                    int length2 = this.zzpj == null ? 0 : this.zzpj.length;
                    int[] iArr2 = new int[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzpj, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = zzxz.zzvb();
                        length2++;
                    }
                    this.zzpj = iArr2;
                    zzxz.zzat(zzas);
                    break;
                case 16:
                    int zzb2 = zzyl.zzb(zzxz, 16);
                    int length3 = this.zzpk == null ? 0 : this.zzpk.length;
                    int[] iArr3 = new int[(zzb2 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzpk, 0, iArr3, 0, length3);
                    }
                    while (length3 < iArr3.length - 1) {
                        iArr3[length3] = zzxz.zzvb();
                        zzxz.zzuj();
                        length3++;
                    }
                    iArr3[length3] = zzxz.zzvb();
                    this.zzpk = iArr3;
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
                    int length4 = this.zzpk == null ? 0 : this.zzpk.length;
                    int[] iArr4 = new int[(i2 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzpk, 0, iArr4, 0, length4);
                    }
                    while (length4 < iArr4.length) {
                        iArr4[length4] = zzxz.zzvb();
                        length4++;
                    }
                    this.zzpk = iArr4;
                    zzxz.zzat(zzas2);
                    break;
                case 24:
                    int zzb3 = zzyl.zzb(zzxz, 24);
                    int length5 = this.zzpl == null ? 0 : this.zzpl.length;
                    int[] iArr5 = new int[(zzb3 + length5)];
                    if (length5 != 0) {
                        System.arraycopy(this.zzpl, 0, iArr5, 0, length5);
                    }
                    while (length5 < iArr5.length - 1) {
                        iArr5[length5] = zzxz.zzvb();
                        zzxz.zzuj();
                        length5++;
                    }
                    iArr5[length5] = zzxz.zzvb();
                    this.zzpl = iArr5;
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
                    int length6 = this.zzpl == null ? 0 : this.zzpl.length;
                    int[] iArr6 = new int[(i3 + length6)];
                    if (length6 != 0) {
                        System.arraycopy(this.zzpl, 0, iArr6, 0, length6);
                    }
                    while (length6 < iArr6.length) {
                        iArr6[length6] = zzxz.zzvb();
                        length6++;
                    }
                    this.zzpl = iArr6;
                    zzxz.zzat(zzas3);
                    break;
                case 32:
                    int zzb4 = zzyl.zzb(zzxz, 32);
                    int length7 = this.zzpm == null ? 0 : this.zzpm.length;
                    int[] iArr7 = new int[(zzb4 + length7)];
                    if (length7 != 0) {
                        System.arraycopy(this.zzpm, 0, iArr7, 0, length7);
                    }
                    while (length7 < iArr7.length - 1) {
                        iArr7[length7] = zzxz.zzvb();
                        zzxz.zzuj();
                        length7++;
                    }
                    iArr7[length7] = zzxz.zzvb();
                    this.zzpm = iArr7;
                    break;
                case 34:
                    int zzas4 = zzxz.zzas(zzxz.zzvb());
                    int position4 = zzxz.getPosition();
                    int i4 = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i4++;
                    }
                    zzxz.zzcb(position4);
                    int length8 = this.zzpm == null ? 0 : this.zzpm.length;
                    int[] iArr8 = new int[(i4 + length8)];
                    if (length8 != 0) {
                        System.arraycopy(this.zzpm, 0, iArr8, 0, length8);
                    }
                    while (length8 < iArr8.length) {
                        iArr8[length8] = zzxz.zzvb();
                        length8++;
                    }
                    this.zzpm = iArr8;
                    zzxz.zzat(zzas4);
                    break;
                case 40:
                    int zzb5 = zzyl.zzb(zzxz, 40);
                    int length9 = this.zzpn == null ? 0 : this.zzpn.length;
                    int[] iArr9 = new int[(zzb5 + length9)];
                    if (length9 != 0) {
                        System.arraycopy(this.zzpn, 0, iArr9, 0, length9);
                    }
                    while (length9 < iArr9.length - 1) {
                        iArr9[length9] = zzxz.zzvb();
                        zzxz.zzuj();
                        length9++;
                    }
                    iArr9[length9] = zzxz.zzvb();
                    this.zzpn = iArr9;
                    break;
                case 42:
                    int zzas5 = zzxz.zzas(zzxz.zzvb());
                    int position5 = zzxz.getPosition();
                    int i5 = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i5++;
                    }
                    zzxz.zzcb(position5);
                    int length10 = this.zzpn == null ? 0 : this.zzpn.length;
                    int[] iArr10 = new int[(i5 + length10)];
                    if (length10 != 0) {
                        System.arraycopy(this.zzpn, 0, iArr10, 0, length10);
                    }
                    while (length10 < iArr10.length) {
                        iArr10[length10] = zzxz.zzvb();
                        length10++;
                    }
                    this.zzpn = iArr10;
                    zzxz.zzat(zzas5);
                    break;
                case 48:
                    int zzb6 = zzyl.zzb(zzxz, 48);
                    int length11 = this.zzpo == null ? 0 : this.zzpo.length;
                    int[] iArr11 = new int[(zzb6 + length11)];
                    if (length11 != 0) {
                        System.arraycopy(this.zzpo, 0, iArr11, 0, length11);
                    }
                    while (length11 < iArr11.length - 1) {
                        iArr11[length11] = zzxz.zzvb();
                        zzxz.zzuj();
                        length11++;
                    }
                    iArr11[length11] = zzxz.zzvb();
                    this.zzpo = iArr11;
                    break;
                case 50:
                    int zzas6 = zzxz.zzas(zzxz.zzvb());
                    int position6 = zzxz.getPosition();
                    int i6 = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i6++;
                    }
                    zzxz.zzcb(position6);
                    int length12 = this.zzpo == null ? 0 : this.zzpo.length;
                    int[] iArr12 = new int[(i6 + length12)];
                    if (length12 != 0) {
                        System.arraycopy(this.zzpo, 0, iArr12, 0, length12);
                    }
                    while (length12 < iArr12.length) {
                        iArr12[length12] = zzxz.zzvb();
                        length12++;
                    }
                    this.zzpo = iArr12;
                    zzxz.zzat(zzas6);
                    break;
                case 56:
                    int zzb7 = zzyl.zzb(zzxz, 56);
                    int length13 = this.zzpp == null ? 0 : this.zzpp.length;
                    int[] iArr13 = new int[(zzb7 + length13)];
                    if (length13 != 0) {
                        System.arraycopy(this.zzpp, 0, iArr13, 0, length13);
                    }
                    while (length13 < iArr13.length - 1) {
                        iArr13[length13] = zzxz.zzvb();
                        zzxz.zzuj();
                        length13++;
                    }
                    iArr13[length13] = zzxz.zzvb();
                    this.zzpp = iArr13;
                    break;
                case 58:
                    int zzas7 = zzxz.zzas(zzxz.zzvb());
                    int position7 = zzxz.getPosition();
                    int i7 = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i7++;
                    }
                    zzxz.zzcb(position7);
                    int length14 = this.zzpp == null ? 0 : this.zzpp.length;
                    int[] iArr14 = new int[(i7 + length14)];
                    if (length14 != 0) {
                        System.arraycopy(this.zzpp, 0, iArr14, 0, length14);
                    }
                    while (length14 < iArr14.length) {
                        iArr14[length14] = zzxz.zzvb();
                        length14++;
                    }
                    this.zzpp = iArr14;
                    zzxz.zzat(zzas7);
                    break;
                case 64:
                    int zzb8 = zzyl.zzb(zzxz, 64);
                    int length15 = this.zzpq == null ? 0 : this.zzpq.length;
                    int[] iArr15 = new int[(zzb8 + length15)];
                    if (length15 != 0) {
                        System.arraycopy(this.zzpq, 0, iArr15, 0, length15);
                    }
                    while (length15 < iArr15.length - 1) {
                        iArr15[length15] = zzxz.zzvb();
                        zzxz.zzuj();
                        length15++;
                    }
                    iArr15[length15] = zzxz.zzvb();
                    this.zzpq = iArr15;
                    break;
                case 66:
                    int zzas8 = zzxz.zzas(zzxz.zzvb());
                    int position8 = zzxz.getPosition();
                    int i8 = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i8++;
                    }
                    zzxz.zzcb(position8);
                    int length16 = this.zzpq == null ? 0 : this.zzpq.length;
                    int[] iArr16 = new int[(i8 + length16)];
                    if (length16 != 0) {
                        System.arraycopy(this.zzpq, 0, iArr16, 0, length16);
                    }
                    while (length16 < iArr16.length) {
                        iArr16[length16] = zzxz.zzvb();
                        length16++;
                    }
                    this.zzpq = iArr16;
                    zzxz.zzat(zzas8);
                    break;
                case 72:
                    int zzb9 = zzyl.zzb(zzxz, 72);
                    int length17 = this.zzpr == null ? 0 : this.zzpr.length;
                    int[] iArr17 = new int[(zzb9 + length17)];
                    if (length17 != 0) {
                        System.arraycopy(this.zzpr, 0, iArr17, 0, length17);
                    }
                    while (length17 < iArr17.length - 1) {
                        iArr17[length17] = zzxz.zzvb();
                        zzxz.zzuj();
                        length17++;
                    }
                    iArr17[length17] = zzxz.zzvb();
                    this.zzpr = iArr17;
                    break;
                case 74:
                    int zzas9 = zzxz.zzas(zzxz.zzvb());
                    int position9 = zzxz.getPosition();
                    int i9 = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i9++;
                    }
                    zzxz.zzcb(position9);
                    int length18 = this.zzpr == null ? 0 : this.zzpr.length;
                    int[] iArr18 = new int[(i9 + length18)];
                    if (length18 != 0) {
                        System.arraycopy(this.zzpr, 0, iArr18, 0, length18);
                    }
                    while (length18 < iArr18.length) {
                        iArr18[length18] = zzxz.zzvb();
                        length18++;
                    }
                    this.zzpr = iArr18;
                    zzxz.zzat(zzas9);
                    break;
                case 80:
                    int zzb10 = zzyl.zzb(zzxz, 80);
                    int length19 = this.zzps == null ? 0 : this.zzps.length;
                    int[] iArr19 = new int[(zzb10 + length19)];
                    if (length19 != 0) {
                        System.arraycopy(this.zzps, 0, iArr19, 0, length19);
                    }
                    while (length19 < iArr19.length - 1) {
                        iArr19[length19] = zzxz.zzvb();
                        zzxz.zzuj();
                        length19++;
                    }
                    iArr19[length19] = zzxz.zzvb();
                    this.zzps = iArr19;
                    break;
                case 82:
                    int zzas10 = zzxz.zzas(zzxz.zzvb());
                    int position10 = zzxz.getPosition();
                    int i10 = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i10++;
                    }
                    zzxz.zzcb(position10);
                    int length20 = this.zzps == null ? 0 : this.zzps.length;
                    int[] iArr20 = new int[(i10 + length20)];
                    if (length20 != 0) {
                        System.arraycopy(this.zzps, 0, iArr20, 0, length20);
                    }
                    while (length20 < iArr20.length) {
                        iArr20[length20] = zzxz.zzvb();
                        length20++;
                    }
                    this.zzps = iArr20;
                    zzxz.zzat(zzas10);
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
