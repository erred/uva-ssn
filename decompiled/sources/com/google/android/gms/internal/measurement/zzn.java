package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzn extends zzyc<zzn> {
    private static volatile zzn[] zzqc;
    public String name;
    private zzp zzqd;
    public zzj zzqe;

    public static zzn[] zzj() {
        if (zzqc == null) {
            synchronized (zzyg.zzcfc) {
                if (zzqc == null) {
                    zzqc = new zzn[0];
                }
            }
        }
        return zzqc;
    }

    public zzn() {
        this.name = "";
        this.zzqd = null;
        this.zzqe = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zzn = (zzn) obj;
        if (this.name == null) {
            if (zzn.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzn.name)) {
            return false;
        }
        if (this.zzqd == null) {
            if (zzn.zzqd != null) {
                return false;
            }
        } else if (!this.zzqd.equals(zzn.zzqd)) {
            return false;
        }
        if (this.zzqe == null) {
            if (zzn.zzqe != null) {
                return false;
            }
        } else if (!this.zzqe.equals(zzn.zzqe)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzn.zzcet == null || zzn.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzn.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (this.name == null ? 0 : this.name.hashCode());
        zzp zzp = this.zzqd;
        int i4 = hashCode * 31;
        if (zzp == null) {
            i = 0;
        } else {
            i = zzp.hashCode();
        }
        int i5 = i4 + i;
        zzj zzj = this.zzqe;
        int i6 = i5 * 31;
        if (zzj == null) {
            i2 = 0;
        } else {
            i2 = zzj.hashCode();
        }
        int i7 = (i6 + i2) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i3 = this.zzcet.hashCode();
        }
        return i7 + i3;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.name != null && !this.name.equals("")) {
            zzya.zzb(1, this.name);
        }
        if (this.zzqd != null) {
            zzya.zza(2, (zzyi) this.zzqd);
        }
        if (this.zzqe != null) {
            zzya.zza(3, (zzyi) this.zzqe);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.name != null && !this.name.equals("")) {
            zzf += zzya.zzc(1, this.name);
        }
        if (this.zzqd != null) {
            zzf += zzya.zzb(2, (zzyi) this.zzqd);
        }
        return this.zzqe != null ? zzf + zzya.zzb(3, (zzyi) this.zzqe) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                this.name = zzxz.readString();
            } else if (zzuj == 18) {
                if (this.zzqd == null) {
                    this.zzqd = new zzp();
                }
                zzxz.zza((zzyi) this.zzqd);
            } else if (zzuj == 26) {
                if (this.zzqe == null) {
                    this.zzqe = new zzj();
                }
                zzxz.zza((zzyi) this.zzqe);
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
