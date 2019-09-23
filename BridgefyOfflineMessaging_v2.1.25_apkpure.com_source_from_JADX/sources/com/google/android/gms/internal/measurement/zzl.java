package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzc.zza;
import com.google.android.gms.internal.measurement.zzc.zza.C3782zza;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;

public final class zzl extends zzyc<zzl> {
    public String version;
    private String[] zzos;
    public String[] zzot;
    public zzp[] zzou;
    public zzk[] zzov;
    public zzh[] zzow;
    public zzh[] zzox;
    public zzh[] zzoy;
    public zzm[] zzoz;
    private String zzpa;
    private String zzpb;
    private String zzpc;
    private zza zzpd;
    private float zzpe;
    private boolean zzpf;
    private String[] zzpg;
    public int zzph;

    public zzl() {
        this.zzos = zzyl.zzcfm;
        this.zzot = zzyl.zzcfm;
        this.zzou = zzp.zzk();
        this.zzov = zzk.zzh();
        this.zzow = zzh.zze();
        this.zzox = zzh.zze();
        this.zzoy = zzh.zze();
        this.zzoz = zzm.zzi();
        this.zzpa = "";
        this.zzpb = "";
        this.zzpc = "0";
        this.version = "";
        this.zzpd = null;
        this.zzpe = BitmapDescriptorFactory.HUE_RED;
        this.zzpf = false;
        this.zzpg = zzyl.zzcfm;
        this.zzph = 0;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzl = (zzl) obj;
        if (!zzyg.equals((Object[]) this.zzos, (Object[]) zzl.zzos) || !zzyg.equals((Object[]) this.zzot, (Object[]) zzl.zzot) || !zzyg.equals((Object[]) this.zzou, (Object[]) zzl.zzou) || !zzyg.equals((Object[]) this.zzov, (Object[]) zzl.zzov) || !zzyg.equals((Object[]) this.zzow, (Object[]) zzl.zzow) || !zzyg.equals((Object[]) this.zzox, (Object[]) zzl.zzox) || !zzyg.equals((Object[]) this.zzoy, (Object[]) zzl.zzoy) || !zzyg.equals((Object[]) this.zzoz, (Object[]) zzl.zzoz)) {
            return false;
        }
        if (this.zzpa == null) {
            if (zzl.zzpa != null) {
                return false;
            }
        } else if (!this.zzpa.equals(zzl.zzpa)) {
            return false;
        }
        if (this.zzpb == null) {
            if (zzl.zzpb != null) {
                return false;
            }
        } else if (!this.zzpb.equals(zzl.zzpb)) {
            return false;
        }
        if (this.zzpc == null) {
            if (zzl.zzpc != null) {
                return false;
            }
        } else if (!this.zzpc.equals(zzl.zzpc)) {
            return false;
        }
        if (this.version == null) {
            if (zzl.version != null) {
                return false;
            }
        } else if (!this.version.equals(zzl.version)) {
            return false;
        }
        if (this.zzpd == null) {
            if (zzl.zzpd != null) {
                return false;
            }
        } else if (!this.zzpd.equals(zzl.zzpd)) {
            return false;
        }
        if (Float.floatToIntBits(this.zzpe) != Float.floatToIntBits(zzl.zzpe) || this.zzpf != zzl.zzpf || !zzyg.equals((Object[]) this.zzpg, (Object[]) zzl.zzpg) || this.zzph != zzl.zzph) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzl.zzcet == null || zzl.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzl.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode((Object[]) this.zzos)) * 31) + zzyg.hashCode((Object[]) this.zzot)) * 31) + zzyg.hashCode((Object[]) this.zzou)) * 31) + zzyg.hashCode((Object[]) this.zzov)) * 31) + zzyg.hashCode((Object[]) this.zzow)) * 31) + zzyg.hashCode((Object[]) this.zzox)) * 31) + zzyg.hashCode((Object[]) this.zzoy)) * 31) + zzyg.hashCode((Object[]) this.zzoz)) * 31) + (this.zzpa == null ? 0 : this.zzpa.hashCode())) * 31) + (this.zzpb == null ? 0 : this.zzpb.hashCode())) * 31) + (this.zzpc == null ? 0 : this.zzpc.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode());
        zza zza = this.zzpd;
        int i3 = hashCode * 31;
        if (zza == null) {
            i = 0;
        } else {
            i = zza.hashCode();
        }
        int floatToIntBits = (((((((((i3 + i) * 31) + Float.floatToIntBits(this.zzpe)) * 31) + (this.zzpf ? 1231 : 1237)) * 31) + zzyg.hashCode((Object[]) this.zzpg)) * 31) + this.zzph) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i2 = this.zzcet.hashCode();
        }
        return floatToIntBits + i2;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzot != null && this.zzot.length > 0) {
            for (String str : this.zzot) {
                if (str != null) {
                    zzya.zzb(1, str);
                }
            }
        }
        if (this.zzou != null && this.zzou.length > 0) {
            for (zzp zzp : this.zzou) {
                if (zzp != null) {
                    zzya.zza(2, (zzyi) zzp);
                }
            }
        }
        if (this.zzov != null && this.zzov.length > 0) {
            for (zzk zzk : this.zzov) {
                if (zzk != null) {
                    zzya.zza(3, (zzyi) zzk);
                }
            }
        }
        if (this.zzow != null && this.zzow.length > 0) {
            for (zzh zzh : this.zzow) {
                if (zzh != null) {
                    zzya.zza(4, (zzyi) zzh);
                }
            }
        }
        if (this.zzox != null && this.zzox.length > 0) {
            for (zzh zzh2 : this.zzox) {
                if (zzh2 != null) {
                    zzya.zza(5, (zzyi) zzh2);
                }
            }
        }
        if (this.zzoy != null && this.zzoy.length > 0) {
            for (zzh zzh3 : this.zzoy) {
                if (zzh3 != null) {
                    zzya.zza(6, (zzyi) zzh3);
                }
            }
        }
        if (this.zzoz != null && this.zzoz.length > 0) {
            for (zzm zzm : this.zzoz) {
                if (zzm != null) {
                    zzya.zza(7, (zzyi) zzm);
                }
            }
        }
        if (this.zzpa != null && !this.zzpa.equals("")) {
            zzya.zzb(9, this.zzpa);
        }
        if (this.zzpb != null && !this.zzpb.equals("")) {
            zzya.zzb(10, this.zzpb);
        }
        if (this.zzpc != null && !this.zzpc.equals("0")) {
            zzya.zzb(12, this.zzpc);
        }
        if (this.version != null && !this.version.equals("")) {
            zzya.zzb(13, this.version);
        }
        if (this.zzpd != null) {
            zzya.zze(14, this.zzpd);
        }
        if (Float.floatToIntBits(this.zzpe) != Float.floatToIntBits(BitmapDescriptorFactory.HUE_RED)) {
            zzya.zza(15, this.zzpe);
        }
        if (this.zzpg != null && this.zzpg.length > 0) {
            for (String str2 : this.zzpg) {
                if (str2 != null) {
                    zzya.zzb(16, str2);
                }
            }
        }
        if (this.zzph != 0) {
            zzya.zzd(17, this.zzph);
        }
        if (this.zzpf) {
            zzya.zzb(18, this.zzpf);
        }
        if (this.zzos != null && this.zzos.length > 0) {
            for (String str3 : this.zzos) {
                if (str3 != null) {
                    zzya.zzb(19, str3);
                }
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzot != null && this.zzot.length > 0) {
            int i = 0;
            int i2 = 0;
            for (String str : this.zzot) {
                if (str != null) {
                    i2++;
                    i += zzya.zzgc(str);
                }
            }
            zzf = zzf + i + (i2 * 1);
        }
        if (this.zzou != null && this.zzou.length > 0) {
            int i3 = zzf;
            for (zzp zzp : this.zzou) {
                if (zzp != null) {
                    i3 += zzya.zzb(2, (zzyi) zzp);
                }
            }
            zzf = i3;
        }
        if (this.zzov != null && this.zzov.length > 0) {
            int i4 = zzf;
            for (zzk zzk : this.zzov) {
                if (zzk != null) {
                    i4 += zzya.zzb(3, (zzyi) zzk);
                }
            }
            zzf = i4;
        }
        if (this.zzow != null && this.zzow.length > 0) {
            int i5 = zzf;
            for (zzh zzh : this.zzow) {
                if (zzh != null) {
                    i5 += zzya.zzb(4, (zzyi) zzh);
                }
            }
            zzf = i5;
        }
        if (this.zzox != null && this.zzox.length > 0) {
            int i6 = zzf;
            for (zzh zzh2 : this.zzox) {
                if (zzh2 != null) {
                    i6 += zzya.zzb(5, (zzyi) zzh2);
                }
            }
            zzf = i6;
        }
        if (this.zzoy != null && this.zzoy.length > 0) {
            int i7 = zzf;
            for (zzh zzh3 : this.zzoy) {
                if (zzh3 != null) {
                    i7 += zzya.zzb(6, (zzyi) zzh3);
                }
            }
            zzf = i7;
        }
        if (this.zzoz != null && this.zzoz.length > 0) {
            int i8 = zzf;
            for (zzm zzm : this.zzoz) {
                if (zzm != null) {
                    i8 += zzya.zzb(7, (zzyi) zzm);
                }
            }
            zzf = i8;
        }
        if (this.zzpa != null && !this.zzpa.equals("")) {
            zzf += zzya.zzc(9, this.zzpa);
        }
        if (this.zzpb != null && !this.zzpb.equals("")) {
            zzf += zzya.zzc(10, this.zzpb);
        }
        if (this.zzpc != null && !this.zzpc.equals("0")) {
            zzf += zzya.zzc(12, this.zzpc);
        }
        if (this.version != null && !this.version.equals("")) {
            zzf += zzya.zzc(13, this.version);
        }
        if (this.zzpd != null) {
            zzf += zztv.zzc(14, (zzvv) this.zzpd);
        }
        if (Float.floatToIntBits(this.zzpe) != Float.floatToIntBits(BitmapDescriptorFactory.HUE_RED)) {
            zzf += zzya.zzbd(15) + 4;
        }
        if (this.zzpg != null && this.zzpg.length > 0) {
            int i9 = 0;
            int i10 = 0;
            for (String str2 : this.zzpg) {
                if (str2 != null) {
                    i10++;
                    i9 += zzya.zzgc(str2);
                }
            }
            zzf = zzf + i9 + (i10 * 2);
        }
        if (this.zzph != 0) {
            zzf += zzya.zzh(17, this.zzph);
        }
        if (this.zzpf) {
            zzf += zzya.zzbd(18) + 1;
        }
        if (this.zzos == null || this.zzos.length <= 0) {
            return zzf;
        }
        int i11 = 0;
        int i12 = 0;
        for (String str3 : this.zzos) {
            if (str3 != null) {
                i12++;
                i11 += zzya.zzgc(str3);
            }
        }
        return zzf + i11 + (i12 * 2);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    return this;
                case 10:
                    int zzb = zzyl.zzb(zzxz, 10);
                    int length = this.zzot == null ? 0 : this.zzot.length;
                    String[] strArr = new String[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzot, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzxz.readString();
                        zzxz.zzuj();
                        length++;
                    }
                    strArr[length] = zzxz.readString();
                    this.zzot = strArr;
                    break;
                case 18:
                    int zzb2 = zzyl.zzb(zzxz, 18);
                    int length2 = this.zzou == null ? 0 : this.zzou.length;
                    zzp[] zzpArr = new zzp[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzou, 0, zzpArr, 0, length2);
                    }
                    while (length2 < zzpArr.length - 1) {
                        zzpArr[length2] = new zzp();
                        zzxz.zza((zzyi) zzpArr[length2]);
                        zzxz.zzuj();
                        length2++;
                    }
                    zzpArr[length2] = new zzp();
                    zzxz.zza((zzyi) zzpArr[length2]);
                    this.zzou = zzpArr;
                    break;
                case 26:
                    int zzb3 = zzyl.zzb(zzxz, 26);
                    int length3 = this.zzov == null ? 0 : this.zzov.length;
                    zzk[] zzkArr = new zzk[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzov, 0, zzkArr, 0, length3);
                    }
                    while (length3 < zzkArr.length - 1) {
                        zzkArr[length3] = new zzk();
                        zzxz.zza((zzyi) zzkArr[length3]);
                        zzxz.zzuj();
                        length3++;
                    }
                    zzkArr[length3] = new zzk();
                    zzxz.zza((zzyi) zzkArr[length3]);
                    this.zzov = zzkArr;
                    break;
                case 34:
                    int zzb4 = zzyl.zzb(zzxz, 34);
                    int length4 = this.zzow == null ? 0 : this.zzow.length;
                    zzh[] zzhArr = new zzh[(zzb4 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzow, 0, zzhArr, 0, length4);
                    }
                    while (length4 < zzhArr.length - 1) {
                        zzhArr[length4] = new zzh();
                        zzxz.zza((zzyi) zzhArr[length4]);
                        zzxz.zzuj();
                        length4++;
                    }
                    zzhArr[length4] = new zzh();
                    zzxz.zza((zzyi) zzhArr[length4]);
                    this.zzow = zzhArr;
                    break;
                case 42:
                    int zzb5 = zzyl.zzb(zzxz, 42);
                    int length5 = this.zzox == null ? 0 : this.zzox.length;
                    zzh[] zzhArr2 = new zzh[(zzb5 + length5)];
                    if (length5 != 0) {
                        System.arraycopy(this.zzox, 0, zzhArr2, 0, length5);
                    }
                    while (length5 < zzhArr2.length - 1) {
                        zzhArr2[length5] = new zzh();
                        zzxz.zza((zzyi) zzhArr2[length5]);
                        zzxz.zzuj();
                        length5++;
                    }
                    zzhArr2[length5] = new zzh();
                    zzxz.zza((zzyi) zzhArr2[length5]);
                    this.zzox = zzhArr2;
                    break;
                case 50:
                    int zzb6 = zzyl.zzb(zzxz, 50);
                    int length6 = this.zzoy == null ? 0 : this.zzoy.length;
                    zzh[] zzhArr3 = new zzh[(zzb6 + length6)];
                    if (length6 != 0) {
                        System.arraycopy(this.zzoy, 0, zzhArr3, 0, length6);
                    }
                    while (length6 < zzhArr3.length - 1) {
                        zzhArr3[length6] = new zzh();
                        zzxz.zza((zzyi) zzhArr3[length6]);
                        zzxz.zzuj();
                        length6++;
                    }
                    zzhArr3[length6] = new zzh();
                    zzxz.zza((zzyi) zzhArr3[length6]);
                    this.zzoy = zzhArr3;
                    break;
                case 58:
                    int zzb7 = zzyl.zzb(zzxz, 58);
                    int length7 = this.zzoz == null ? 0 : this.zzoz.length;
                    zzm[] zzmArr = new zzm[(zzb7 + length7)];
                    if (length7 != 0) {
                        System.arraycopy(this.zzoz, 0, zzmArr, 0, length7);
                    }
                    while (length7 < zzmArr.length - 1) {
                        zzmArr[length7] = new zzm();
                        zzxz.zza((zzyi) zzmArr[length7]);
                        zzxz.zzuj();
                        length7++;
                    }
                    zzmArr[length7] = new zzm();
                    zzxz.zza((zzyi) zzmArr[length7]);
                    this.zzoz = zzmArr;
                    break;
                case 74:
                    this.zzpa = zzxz.readString();
                    break;
                case 82:
                    this.zzpb = zzxz.readString();
                    break;
                case 98:
                    this.zzpc = zzxz.readString();
                    break;
                case 106:
                    this.version = zzxz.readString();
                    break;
                case 114:
                    zza zza = (zza) zzxz.zza(zza.zza());
                    if (this.zzpd != null) {
                        zza = (zza) ((zzuo) ((C3782zza) ((C3782zza) this.zzpd.zzwf()).zza(zza)).zzwo());
                    }
                    this.zzpd = zza;
                    break;
                case 125:
                    this.zzpe = Float.intBitsToFloat(zzxz.zzvd());
                    break;
                case 130:
                    int zzb8 = zzyl.zzb(zzxz, 130);
                    int length8 = this.zzpg == null ? 0 : this.zzpg.length;
                    String[] strArr2 = new String[(zzb8 + length8)];
                    if (length8 != 0) {
                        System.arraycopy(this.zzpg, 0, strArr2, 0, length8);
                    }
                    while (length8 < strArr2.length - 1) {
                        strArr2[length8] = zzxz.readString();
                        zzxz.zzuj();
                        length8++;
                    }
                    strArr2[length8] = zzxz.readString();
                    this.zzpg = strArr2;
                    break;
                case 136:
                    this.zzph = zzxz.zzvb();
                    break;
                case 144:
                    this.zzpf = zzxz.zzup();
                    break;
                case 154:
                    int zzb9 = zzyl.zzb(zzxz, 154);
                    int length9 = this.zzos == null ? 0 : this.zzos.length;
                    String[] strArr3 = new String[(zzb9 + length9)];
                    if (length9 != 0) {
                        System.arraycopy(this.zzos, 0, strArr3, 0, length9);
                    }
                    while (length9 < strArr3.length - 1) {
                        strArr3[length9] = zzxz.readString();
                        zzxz.zzuj();
                        length9++;
                    }
                    strArr3[length9] = zzxz.readString();
                    this.zzos = strArr3;
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
