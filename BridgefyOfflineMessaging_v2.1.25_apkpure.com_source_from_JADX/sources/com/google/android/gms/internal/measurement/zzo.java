package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzo extends zzyc<zzo> {
    public zzn[] zzqf;
    public zzl zzqg;
    public String zzqh;

    public zzo() {
        this.zzqf = zzn.zzj();
        this.zzqg = null;
        this.zzqh = "";
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzo = (zzo) obj;
        if (!zzyg.equals((Object[]) this.zzqf, (Object[]) zzo.zzqf)) {
            return false;
        }
        if (this.zzqg == null) {
            if (zzo.zzqg != null) {
                return false;
            }
        } else if (!this.zzqg.equals(zzo.zzqg)) {
            return false;
        }
        if (this.zzqh == null) {
            if (zzo.zzqh != null) {
                return false;
            }
        } else if (!this.zzqh.equals(zzo.zzqh)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzo.zzcet == null || zzo.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzo.zzcet);
    }

    public final int hashCode() {
        int i;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode((Object[]) this.zzqf);
        zzl zzl = this.zzqg;
        int i2 = hashCode * 31;
        int i3 = 0;
        if (zzl == null) {
            i = 0;
        } else {
            i = zzl.hashCode();
        }
        int hashCode2 = (((i2 + i) * 31) + (this.zzqh == null ? 0 : this.zzqh.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i3 = this.zzcet.hashCode();
        }
        return hashCode2 + i3;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzqf != null && this.zzqf.length > 0) {
            for (zzn zzn : this.zzqf) {
                if (zzn != null) {
                    zzya.zza(1, (zzyi) zzn);
                }
            }
        }
        if (this.zzqg != null) {
            zzya.zza(2, (zzyi) this.zzqg);
        }
        if (this.zzqh != null && !this.zzqh.equals("")) {
            zzya.zzb(3, this.zzqh);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzqf != null && this.zzqf.length > 0) {
            for (zzn zzn : this.zzqf) {
                if (zzn != null) {
                    zzf += zzya.zzb(1, (zzyi) zzn);
                }
            }
        }
        if (this.zzqg != null) {
            zzf += zzya.zzb(2, (zzyi) this.zzqg);
        }
        return (this.zzqh == null || this.zzqh.equals("")) ? zzf : zzf + zzya.zzc(3, this.zzqh);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                int zzb = zzyl.zzb(zzxz, 10);
                int length = this.zzqf == null ? 0 : this.zzqf.length;
                zzn[] zznArr = new zzn[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzqf, 0, zznArr, 0, length);
                }
                while (length < zznArr.length - 1) {
                    zznArr[length] = new zzn();
                    zzxz.zza((zzyi) zznArr[length]);
                    zzxz.zzuj();
                    length++;
                }
                zznArr[length] = new zzn();
                zzxz.zza((zzyi) zznArr[length]);
                this.zzqf = zznArr;
            } else if (zzuj == 18) {
                if (this.zzqg == null) {
                    this.zzqg = new zzl();
                }
                zzxz.zza((zzyi) this.zzqg);
            } else if (zzuj == 26) {
                this.zzqh = zzxz.readString();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
