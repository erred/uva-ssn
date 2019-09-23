package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzj extends zzyc<zzj> {
    public zzp[] zzoo;
    public zzp[] zzop;
    public zzi[] zzoq;

    public zzj() {
        this.zzoo = zzp.zzk();
        this.zzop = zzp.zzk();
        this.zzoq = zzi.zzg();
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        if (!zzyg.equals((Object[]) this.zzoo, (Object[]) zzj.zzoo) || !zzyg.equals((Object[]) this.zzop, (Object[]) zzj.zzop) || !zzyg.equals((Object[]) this.zzoq, (Object[]) zzj.zzoq)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzj.zzcet == null || zzj.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzj.zzcet);
    }

    public final int hashCode() {
        return ((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode((Object[]) this.zzoo)) * 31) + zzyg.hashCode((Object[]) this.zzop)) * 31) + zzyg.hashCode((Object[]) this.zzoq)) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzoo != null && this.zzoo.length > 0) {
            for (zzp zzp : this.zzoo) {
                if (zzp != null) {
                    zzya.zza(1, (zzyi) zzp);
                }
            }
        }
        if (this.zzop != null && this.zzop.length > 0) {
            for (zzp zzp2 : this.zzop) {
                if (zzp2 != null) {
                    zzya.zza(2, (zzyi) zzp2);
                }
            }
        }
        if (this.zzoq != null && this.zzoq.length > 0) {
            for (zzi zzi : this.zzoq) {
                if (zzi != null) {
                    zzya.zza(3, (zzyi) zzi);
                }
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzoo != null && this.zzoo.length > 0) {
            int i = zzf;
            for (zzp zzp : this.zzoo) {
                if (zzp != null) {
                    i += zzya.zzb(1, (zzyi) zzp);
                }
            }
            zzf = i;
        }
        if (this.zzop != null && this.zzop.length > 0) {
            int i2 = zzf;
            for (zzp zzp2 : this.zzop) {
                if (zzp2 != null) {
                    i2 += zzya.zzb(2, (zzyi) zzp2);
                }
            }
            zzf = i2;
        }
        if (this.zzoq != null && this.zzoq.length > 0) {
            for (zzi zzi : this.zzoq) {
                if (zzi != null) {
                    zzf += zzya.zzb(3, (zzyi) zzi);
                }
            }
        }
        return zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                int zzb = zzyl.zzb(zzxz, 10);
                int length = this.zzoo == null ? 0 : this.zzoo.length;
                zzp[] zzpArr = new zzp[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzoo, 0, zzpArr, 0, length);
                }
                while (length < zzpArr.length - 1) {
                    zzpArr[length] = new zzp();
                    zzxz.zza((zzyi) zzpArr[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzpArr[length] = new zzp();
                zzxz.zza((zzyi) zzpArr[length]);
                this.zzoo = zzpArr;
            } else if (zzuj == 18) {
                int zzb2 = zzyl.zzb(zzxz, 18);
                int length2 = this.zzop == null ? 0 : this.zzop.length;
                zzp[] zzpArr2 = new zzp[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzop, 0, zzpArr2, 0, length2);
                }
                while (length2 < zzpArr2.length - 1) {
                    zzpArr2[length2] = new zzp();
                    zzxz.zza((zzyi) zzpArr2[length2]);
                    zzxz.zzuj();
                    length2++;
                }
                zzpArr2[length2] = new zzp();
                zzxz.zza((zzyi) zzpArr2[length2]);
                this.zzop = zzpArr2;
            } else if (zzuj == 26) {
                int zzb3 = zzyl.zzb(zzxz, 26);
                int length3 = this.zzoq == null ? 0 : this.zzoq.length;
                zzi[] zziArr = new zzi[(zzb3 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzoq, 0, zziArr, 0, length3);
                }
                while (length3 < zziArr.length - 1) {
                    zziArr[length3] = new zzi();
                    zzxz.zza((zzyi) zziArr[length3]);
                    zzxz.zzuj();
                    length3++;
                }
                zziArr[length3] = new zzi();
                zzxz.zza((zzyi) zziArr[length3]);
                this.zzoq = zziArr;
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
