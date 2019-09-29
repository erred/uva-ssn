package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfv extends zzyc<zzfv> {
    public zzfw[] zzaxf;

    public zzfv() {
        this.zzaxf = zzfw.zznb();
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfv = (zzfv) obj;
        if (!zzyg.equals((Object[]) this.zzaxf, (Object[]) zzfv.zzaxf)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfv.zzcet == null || zzfv.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfv.zzcet);
    }

    public final int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode((Object[]) this.zzaxf)) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzaxf != null && this.zzaxf.length > 0) {
            for (zzfw zzfw : this.zzaxf) {
                if (zzfw != null) {
                    zzya.zza(1, (zzyi) zzfw);
                }
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzaxf != null && this.zzaxf.length > 0) {
            for (zzfw zzfw : this.zzaxf) {
                if (zzfw != null) {
                    zzf += zzya.zzb(1, (zzyi) zzfw);
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
                int length = this.zzaxf == null ? 0 : this.zzaxf.length;
                zzfw[] zzfwArr = new zzfw[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzaxf, 0, zzfwArr, 0, length);
                }
                while (length < zzfwArr.length - 1) {
                    zzfwArr[length] = new zzfw();
                    zzxz.zza((zzyi) zzfwArr[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfwArr[length] = new zzfw();
                zzxz.zza((zzyi) zzfwArr[length]);
                this.zzaxf = zzfwArr;
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
