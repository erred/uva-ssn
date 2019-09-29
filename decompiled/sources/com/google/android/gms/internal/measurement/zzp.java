package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzp extends zzyc<zzp> {
    private static volatile zzp[] zzqi;
    public String string;
    public int type;
    public zzp[] zzqj;
    public zzp[] zzqk;
    public zzp[] zzql;
    public String zzqm;
    public String zzqn;
    public long zzqo;
    public boolean zzqp;
    public zzp[] zzqq;
    public int[] zzqr;
    public boolean zzqs;

    private static int zzc(int i) {
        if (i > 0 && i <= 17) {
            return i;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append(i);
        sb.append(" is not a valid enum Escaping");
        throw new IllegalArgumentException(sb.toString());
    }

    public static zzp[] zzk() {
        if (zzqi == null) {
            synchronized (zzyg.zzcfc) {
                if (zzqi == null) {
                    zzqi = new zzp[0];
                }
            }
        }
        return zzqi;
    }

    public zzp() {
        this.type = 1;
        this.string = "";
        this.zzqj = zzk();
        this.zzqk = zzk();
        this.zzql = zzk();
        this.zzqm = "";
        this.zzqn = "";
        this.zzqo = 0;
        this.zzqp = false;
        this.zzqq = zzk();
        this.zzqr = zzyl.zzcao;
        this.zzqs = false;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp zzp = (zzp) obj;
        if (this.type != zzp.type) {
            return false;
        }
        if (this.string == null) {
            if (zzp.string != null) {
                return false;
            }
        } else if (!this.string.equals(zzp.string)) {
            return false;
        }
        if (!zzyg.equals((Object[]) this.zzqj, (Object[]) zzp.zzqj) || !zzyg.equals((Object[]) this.zzqk, (Object[]) zzp.zzqk) || !zzyg.equals((Object[]) this.zzql, (Object[]) zzp.zzql)) {
            return false;
        }
        if (this.zzqm == null) {
            if (zzp.zzqm != null) {
                return false;
            }
        } else if (!this.zzqm.equals(zzp.zzqm)) {
            return false;
        }
        if (this.zzqn == null) {
            if (zzp.zzqn != null) {
                return false;
            }
        } else if (!this.zzqn.equals(zzp.zzqn)) {
            return false;
        }
        if (this.zzqo != zzp.zzqo || this.zzqp != zzp.zzqp || !zzyg.equals((Object[]) this.zzqq, (Object[]) zzp.zzqq) || !zzyg.equals(this.zzqr, zzp.zzqr) || this.zzqs != zzp.zzqs) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzp.zzcet == null || zzp.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzp.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 1237;
        int hashCode = (((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + (this.string == null ? 0 : this.string.hashCode())) * 31) + zzyg.hashCode((Object[]) this.zzqj)) * 31) + zzyg.hashCode((Object[]) this.zzqk)) * 31) + zzyg.hashCode((Object[]) this.zzql)) * 31) + (this.zzqm == null ? 0 : this.zzqm.hashCode())) * 31) + (this.zzqn == null ? 0 : this.zzqn.hashCode())) * 31) + ((int) (this.zzqo ^ (this.zzqo >>> 32)))) * 31) + (this.zzqp ? 1231 : 1237)) * 31) + zzyg.hashCode((Object[]) this.zzqq)) * 31) + zzyg.hashCode(this.zzqr)) * 31;
        if (this.zzqs) {
            i2 = 1231;
        }
        int i3 = (hashCode + i2) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return i3 + i;
    }

    public final void zza(zzya zzya) throws IOException {
        zzya.zzd(1, this.type);
        if (this.string != null && !this.string.equals("")) {
            zzya.zzb(2, this.string);
        }
        if (this.zzqj != null && this.zzqj.length > 0) {
            for (zzp zzp : this.zzqj) {
                if (zzp != null) {
                    zzya.zza(3, (zzyi) zzp);
                }
            }
        }
        if (this.zzqk != null && this.zzqk.length > 0) {
            for (zzp zzp2 : this.zzqk) {
                if (zzp2 != null) {
                    zzya.zza(4, (zzyi) zzp2);
                }
            }
        }
        if (this.zzql != null && this.zzql.length > 0) {
            for (zzp zzp3 : this.zzql) {
                if (zzp3 != null) {
                    zzya.zza(5, (zzyi) zzp3);
                }
            }
        }
        if (this.zzqm != null && !this.zzqm.equals("")) {
            zzya.zzb(6, this.zzqm);
        }
        if (this.zzqn != null && !this.zzqn.equals("")) {
            zzya.zzb(7, this.zzqn);
        }
        if (this.zzqo != 0) {
            zzya.zzi(8, this.zzqo);
        }
        if (this.zzqs) {
            zzya.zzb(9, this.zzqs);
        }
        if (this.zzqr != null && this.zzqr.length > 0) {
            for (int zzd : this.zzqr) {
                zzya.zzd(10, zzd);
            }
        }
        if (this.zzqq != null && this.zzqq.length > 0) {
            for (zzp zzp4 : this.zzqq) {
                if (zzp4 != null) {
                    zzya.zza(11, (zzyi) zzp4);
                }
            }
        }
        if (this.zzqp) {
            zzya.zzb(12, this.zzqp);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf() + zzya.zzh(1, this.type);
        if (this.string != null && !this.string.equals("")) {
            zzf += zzya.zzc(2, this.string);
        }
        if (this.zzqj != null && this.zzqj.length > 0) {
            int i = zzf;
            for (zzp zzp : this.zzqj) {
                if (zzp != null) {
                    i += zzya.zzb(3, (zzyi) zzp);
                }
            }
            zzf = i;
        }
        if (this.zzqk != null && this.zzqk.length > 0) {
            int i2 = zzf;
            for (zzp zzp2 : this.zzqk) {
                if (zzp2 != null) {
                    i2 += zzya.zzb(4, (zzyi) zzp2);
                }
            }
            zzf = i2;
        }
        if (this.zzql != null && this.zzql.length > 0) {
            int i3 = zzf;
            for (zzp zzp3 : this.zzql) {
                if (zzp3 != null) {
                    i3 += zzya.zzb(5, (zzyi) zzp3);
                }
            }
            zzf = i3;
        }
        if (this.zzqm != null && !this.zzqm.equals("")) {
            zzf += zzya.zzc(6, this.zzqm);
        }
        if (this.zzqn != null && !this.zzqn.equals("")) {
            zzf += zzya.zzc(7, this.zzqn);
        }
        if (this.zzqo != 0) {
            zzf += zzya.zzd(8, this.zzqo);
        }
        if (this.zzqs) {
            zzf += zzya.zzbd(9) + 1;
        }
        if (this.zzqr != null && this.zzqr.length > 0) {
            int i4 = 0;
            for (int zzbe : this.zzqr) {
                i4 += zzya.zzbe(zzbe);
            }
            zzf = zzf + i4 + (this.zzqr.length * 1);
        }
        if (this.zzqq != null && this.zzqq.length > 0) {
            for (zzp zzp4 : this.zzqq) {
                if (zzp4 != null) {
                    zzf += zzya.zzb(11, (zzyi) zzp4);
                }
            }
        }
        return this.zzqp ? zzf + zzya.zzbd(12) + 1 : zzf;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzp zza(zzxz zzxz) throws IOException {
        int zzvb;
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    return this;
                case 8:
                    try {
                        zzvb = zzxz.zzvb();
                        if (zzvb > 0 && zzvb <= 8) {
                            this.type = zzvb;
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(36);
                            sb.append(zzvb);
                            sb.append(" is not a valid enum Type");
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzxz.zzcb(zzxz.getPosition());
                        zza(zzxz, zzuj);
                        break;
                    }
                    break;
                case 18:
                    this.string = zzxz.readString();
                    break;
                case 26:
                    int zzb = zzyl.zzb(zzxz, 26);
                    int length = this.zzqj == null ? 0 : this.zzqj.length;
                    zzp[] zzpArr = new zzp[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzqj, 0, zzpArr, 0, length);
                    }
                    while (length < zzpArr.length - 1) {
                        zzpArr[length] = new zzp();
                        zzxz.zza((zzyi) zzpArr[length]);
                        zzxz.zzuj();
                        length++;
                    }
                    zzpArr[length] = new zzp();
                    zzxz.zza((zzyi) zzpArr[length]);
                    this.zzqj = zzpArr;
                    break;
                case 34:
                    int zzb2 = zzyl.zzb(zzxz, 34);
                    int length2 = this.zzqk == null ? 0 : this.zzqk.length;
                    zzp[] zzpArr2 = new zzp[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzqk, 0, zzpArr2, 0, length2);
                    }
                    while (length2 < zzpArr2.length - 1) {
                        zzpArr2[length2] = new zzp();
                        zzxz.zza((zzyi) zzpArr2[length2]);
                        zzxz.zzuj();
                        length2++;
                    }
                    zzpArr2[length2] = new zzp();
                    zzxz.zza((zzyi) zzpArr2[length2]);
                    this.zzqk = zzpArr2;
                    break;
                case 42:
                    int zzb3 = zzyl.zzb(zzxz, 42);
                    int length3 = this.zzql == null ? 0 : this.zzql.length;
                    zzp[] zzpArr3 = new zzp[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzql, 0, zzpArr3, 0, length3);
                    }
                    while (length3 < zzpArr3.length - 1) {
                        zzpArr3[length3] = new zzp();
                        zzxz.zza((zzyi) zzpArr3[length3]);
                        zzxz.zzuj();
                        length3++;
                    }
                    zzpArr3[length3] = new zzp();
                    zzxz.zza((zzyi) zzpArr3[length3]);
                    this.zzql = zzpArr3;
                    break;
                case 50:
                    this.zzqm = zzxz.readString();
                    break;
                case 58:
                    this.zzqn = zzxz.readString();
                    break;
                case 64:
                    this.zzqo = zzxz.zzvc();
                    break;
                case 72:
                    this.zzqs = zzxz.zzup();
                    break;
                case 80:
                    int zzb4 = zzyl.zzb(zzxz, 80);
                    int[] iArr = new int[zzb4];
                    int i = 0;
                    for (int i2 = 0; i2 < zzb4; i2++) {
                        if (i2 != 0) {
                            zzxz.zzuj();
                        }
                        int position = zzxz.getPosition();
                        try {
                            iArr[i] = zzc(zzxz.zzvb());
                            i++;
                        } catch (IllegalArgumentException unused2) {
                            zzxz.zzcb(position);
                            zza(zzxz, zzuj);
                        }
                    }
                    if (i != 0) {
                        int length4 = this.zzqr == null ? 0 : this.zzqr.length;
                        if (length4 != 0 || i != iArr.length) {
                            int[] iArr2 = new int[(length4 + i)];
                            if (length4 != 0) {
                                System.arraycopy(this.zzqr, 0, iArr2, 0, length4);
                            }
                            System.arraycopy(iArr, 0, iArr2, length4, i);
                            this.zzqr = iArr2;
                            break;
                        } else {
                            this.zzqr = iArr;
                            break;
                        }
                    } else {
                        break;
                    }
                case 82:
                    int zzas = zzxz.zzas(zzxz.zzvb());
                    int position2 = zzxz.getPosition();
                    int i3 = 0;
                    while (zzxz.zzyy() > 0) {
                        try {
                            zzc(zzxz.zzvb());
                            i3++;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    if (i3 != 0) {
                        zzxz.zzcb(position2);
                        int length5 = this.zzqr == null ? 0 : this.zzqr.length;
                        int[] iArr3 = new int[(i3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzqr, 0, iArr3, 0, length5);
                        }
                        while (zzxz.zzyy() > 0) {
                            int position3 = zzxz.getPosition();
                            try {
                                iArr3[length5] = zzc(zzxz.zzvb());
                                length5++;
                            } catch (IllegalArgumentException unused4) {
                                zzxz.zzcb(position3);
                                zza(zzxz, 80);
                            }
                        }
                        this.zzqr = iArr3;
                    }
                    zzxz.zzat(zzas);
                    break;
                case 90:
                    int zzb5 = zzyl.zzb(zzxz, 90);
                    int length6 = this.zzqq == null ? 0 : this.zzqq.length;
                    zzp[] zzpArr4 = new zzp[(zzb5 + length6)];
                    if (length6 != 0) {
                        System.arraycopy(this.zzqq, 0, zzpArr4, 0, length6);
                    }
                    while (length6 < zzpArr4.length - 1) {
                        zzpArr4[length6] = new zzp();
                        zzxz.zza((zzyi) zzpArr4[length6]);
                        zzxz.zzuj();
                        length6++;
                    }
                    zzpArr4[length6] = new zzp();
                    zzxz.zza((zzyi) zzpArr4[length6]);
                    this.zzqq = zzpArr4;
                    break;
                case 96:
                    this.zzqp = zzxz.zzup();
                    break;
                default:
                    if (super.zza(zzxz, zzuj)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
        StringBuilder sb2 = new StringBuilder(36);
        sb2.append(zzvb);
        sb2.append(" is not a valid enum Type");
        throw new IllegalArgumentException(sb2.toString());
    }
}
