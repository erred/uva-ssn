package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzre extends zzyc<zzre> {
    public long zzbqc;
    public zzo zzbqd;
    public zzl zzqg;

    public zzre() {
        this.zzbqc = 0;
        this.zzqg = null;
        this.zzbqd = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzre)) {
            return false;
        }
        zzre zzre = (zzre) obj;
        if (this.zzbqc != zzre.zzbqc) {
            return false;
        }
        if (this.zzqg == null) {
            if (zzre.zzqg != null) {
                return false;
            }
        } else if (!this.zzqg.equals(zzre.zzqg)) {
            return false;
        }
        if (this.zzbqd == null) {
            if (zzre.zzbqd != null) {
                return false;
            }
        } else if (!this.zzbqd.equals(zzre.zzbqd)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzre.zzcet == null || zzre.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzre.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbqc ^ (this.zzbqc >>> 32)));
        zzl zzl = this.zzqg;
        int i3 = hashCode * 31;
        int i4 = 0;
        if (zzl == null) {
            i = 0;
        } else {
            i = zzl.hashCode();
        }
        int i5 = i3 + i;
        zzo zzo = this.zzbqd;
        int i6 = i5 * 31;
        if (zzo == null) {
            i2 = 0;
        } else {
            i2 = zzo.hashCode();
        }
        int i7 = (i6 + i2) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i4 = this.zzcet.hashCode();
        }
        return i7 + i4;
    }

    public final void zza(zzya zzya) throws IOException {
        zzya.zzi(1, this.zzbqc);
        if (this.zzqg != null) {
            zzya.zza(2, (zzyi) this.zzqg);
        }
        if (this.zzbqd != null) {
            zzya.zza(3, (zzyi) this.zzbqd);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf() + zzya.zzd(1, this.zzbqc);
        if (this.zzqg != null) {
            zzf += zzya.zzb(2, (zzyi) this.zzqg);
        }
        return this.zzbqd != null ? zzf + zzya.zzb(3, (zzyi) this.zzbqd) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzbqc = zzxz.zzvc();
            } else if (zzuj == 18) {
                if (this.zzqg == null) {
                    this.zzqg = new zzl();
                }
                zzxz.zza((zzyi) this.zzqg);
            } else if (zzuj == 26) {
                if (this.zzbqd == null) {
                    this.zzbqd = new zzo();
                }
                zzxz.zza((zzyi) this.zzbqd);
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
