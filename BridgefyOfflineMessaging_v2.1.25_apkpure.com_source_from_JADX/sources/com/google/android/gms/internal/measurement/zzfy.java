package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfy extends zzyc<zzfy> {
    private static volatile zzfy[] zzayr;
    public Integer zzawx;
    public long[] zzays;

    public static zzfy[] zznc() {
        if (zzayr == null) {
            synchronized (zzyg.zzcfc) {
                if (zzayr == null) {
                    zzayr = new zzfy[0];
                }
            }
        }
        return zzayr;
    }

    public zzfy() {
        this.zzawx = null;
        this.zzays = zzyl.zzcfi;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfy = (zzfy) obj;
        if (this.zzawx == null) {
            if (zzfy.zzawx != null) {
                return false;
            }
        } else if (!this.zzawx.equals(zzfy.zzawx)) {
            return false;
        }
        if (!zzyg.equals(this.zzays, zzfy.zzays)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfy.zzcet == null || zzfy.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfy.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.zzawx == null ? 0 : this.zzawx.hashCode())) * 31) + zzyg.hashCode(this.zzays)) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzawx != null) {
            zzya.zzd(1, this.zzawx.intValue());
        }
        if (this.zzays != null && this.zzays.length > 0) {
            for (long zzi : this.zzays) {
                zzya.zzi(2, zzi);
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzawx != null) {
            zzf += zzya.zzh(1, this.zzawx.intValue());
        }
        if (this.zzays == null || this.zzays.length <= 0) {
            return zzf;
        }
        int i = 0;
        for (long zzbg : this.zzays) {
            i += zzya.zzbg(zzbg);
        }
        return zzf + i + (this.zzays.length * 1);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzawx = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 16) {
                int zzb = zzyl.zzb(zzxz, 16);
                int length = this.zzays == null ? 0 : this.zzays.length;
                long[] jArr = new long[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzays, 0, jArr, 0, length);
                }
                while (length < jArr.length - 1) {
                    jArr[length] = zzxz.zzvc();
                    zzxz.zzuj();
                    length++;
                }
                jArr[length] = zzxz.zzvc();
                this.zzays = jArr;
            } else if (zzuj == 18) {
                int zzas = zzxz.zzas(zzxz.zzvb());
                int position = zzxz.getPosition();
                int i = 0;
                while (zzxz.zzyy() > 0) {
                    zzxz.zzvc();
                    i++;
                }
                zzxz.zzcb(position);
                int length2 = this.zzays == null ? 0 : this.zzays.length;
                long[] jArr2 = new long[(i + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzays, 0, jArr2, 0, length2);
                }
                while (length2 < jArr2.length) {
                    jArr2[length2] = zzxz.zzvc();
                    length2++;
                }
                this.zzays = jArr2;
                zzxz.zzat(zzas);
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
