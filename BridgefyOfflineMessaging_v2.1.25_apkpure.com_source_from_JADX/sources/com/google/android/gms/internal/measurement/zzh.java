package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzh extends zzyc<zzh> {
    private static volatile zzh[] zzod;
    private int name;
    public int[] zzoe;
    private int zzof;
    private boolean zzog;
    private boolean zzoh;

    public static zzh[] zze() {
        if (zzod == null) {
            synchronized (zzyg.zzcfc) {
                if (zzod == null) {
                    zzod = new zzh[0];
                }
            }
        }
        return zzod;
    }

    public zzh() {
        this.zzoe = zzyl.zzcao;
        this.zzof = 0;
        this.name = 0;
        this.zzog = false;
        this.zzoh = false;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzh = (zzh) obj;
        if (!zzyg.equals(this.zzoe, zzh.zzoe) || this.zzof != zzh.zzof || this.name != zzh.name || this.zzog != zzh.zzog || this.zzoh != zzh.zzoh) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzh.zzcet == null || zzh.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzh.zzcet);
    }

    public final int hashCode() {
        int i = 1237;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzoe)) * 31) + this.zzof) * 31) + this.name) * 31) + (this.zzog ? 1231 : 1237)) * 31;
        if (this.zzoh) {
            i = 1231;
        }
        return ((hashCode + i) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzoh) {
            zzya.zzb(1, this.zzoh);
        }
        zzya.zzd(2, this.zzof);
        if (this.zzoe != null && this.zzoe.length > 0) {
            for (int zzd : this.zzoe) {
                zzya.zzd(3, zzd);
            }
        }
        if (this.name != 0) {
            zzya.zzd(4, this.name);
        }
        if (this.zzog) {
            zzya.zzb(6, this.zzog);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzoh) {
            zzf += zzya.zzbd(1) + 1;
        }
        int zzh = zzf + zzya.zzh(2, this.zzof);
        if (this.zzoe != null && this.zzoe.length > 0) {
            int i = 0;
            for (int zzbe : this.zzoe) {
                i += zzya.zzbe(zzbe);
            }
            zzh = zzh + i + (this.zzoe.length * 1);
        }
        if (this.name != 0) {
            zzh += zzya.zzh(4, this.name);
        }
        return this.zzog ? zzh + zzya.zzbd(6) + 1 : zzh;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzoh = zzxz.zzup();
            } else if (zzuj == 16) {
                this.zzof = zzxz.zzvb();
            } else if (zzuj == 24) {
                int zzb = zzyl.zzb(zzxz, 24);
                int length = this.zzoe == null ? 0 : this.zzoe.length;
                int[] iArr = new int[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzoe, 0, iArr, 0, length);
                }
                while (length < iArr.length - 1) {
                    iArr[length] = zzxz.zzvb();
                    zzxz.zzuj();
                    length++;
                }
                iArr[length] = zzxz.zzvb();
                this.zzoe = iArr;
            } else if (zzuj == 26) {
                int zzas = zzxz.zzas(zzxz.zzvb());
                int position = zzxz.getPosition();
                int i = 0;
                while (zzxz.zzyy() > 0) {
                    zzxz.zzvb();
                    i++;
                }
                zzxz.zzcb(position);
                int length2 = this.zzoe == null ? 0 : this.zzoe.length;
                int[] iArr2 = new int[(i + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzoe, 0, iArr2, 0, length2);
                }
                while (length2 < iArr2.length) {
                    iArr2[length2] = zzxz.zzvb();
                    length2++;
                }
                this.zzoe = iArr2;
                zzxz.zzat(zzas);
            } else if (zzuj == 32) {
                this.name = zzxz.zzvb();
            } else if (zzuj == 48) {
                this.zzog = zzxz.zzup();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
