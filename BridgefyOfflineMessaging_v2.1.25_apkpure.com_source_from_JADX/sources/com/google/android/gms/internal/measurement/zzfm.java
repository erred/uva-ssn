package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfm extends zzyc<zzfm> {
    private static volatile zzfm[] zzavz;
    public Boolean zzavh;
    public Boolean zzavi;
    public Integer zzavk;
    public String zzawa;
    public zzfk zzawb;

    public static zzfm[] zzmu() {
        if (zzavz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavz == null) {
                    zzavz = new zzfm[0];
                }
            }
        }
        return zzavz;
    }

    public zzfm() {
        this.zzavk = null;
        this.zzawa = null;
        this.zzawb = null;
        this.zzavh = null;
        this.zzavi = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfm)) {
            return false;
        }
        zzfm zzfm = (zzfm) obj;
        if (this.zzavk == null) {
            if (zzfm.zzavk != null) {
                return false;
            }
        } else if (!this.zzavk.equals(zzfm.zzavk)) {
            return false;
        }
        if (this.zzawa == null) {
            if (zzfm.zzawa != null) {
                return false;
            }
        } else if (!this.zzawa.equals(zzfm.zzawa)) {
            return false;
        }
        if (this.zzawb == null) {
            if (zzfm.zzawb != null) {
                return false;
            }
        } else if (!this.zzawb.equals(zzfm.zzawb)) {
            return false;
        }
        if (this.zzavh == null) {
            if (zzfm.zzavh != null) {
                return false;
            }
        } else if (!this.zzavh.equals(zzfm.zzavh)) {
            return false;
        }
        if (this.zzavi == null) {
            if (zzfm.zzavi != null) {
                return false;
            }
        } else if (!this.zzavi.equals(zzfm.zzavi)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfm.zzcet == null || zzfm.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfm.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((getClass().getName().hashCode() + 527) * 31) + (this.zzavk == null ? 0 : this.zzavk.hashCode())) * 31) + (this.zzawa == null ? 0 : this.zzawa.hashCode());
        zzfk zzfk = this.zzawb;
        int i3 = hashCode * 31;
        if (zzfk == null) {
            i = 0;
        } else {
            i = zzfk.hashCode();
        }
        int hashCode2 = (((((i3 + i) * 31) + (this.zzavh == null ? 0 : this.zzavh.hashCode())) * 31) + (this.zzavi == null ? 0 : this.zzavi.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i2 = this.zzcet.hashCode();
        }
        return hashCode2 + i2;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzavk != null) {
            zzya.zzd(1, this.zzavk.intValue());
        }
        if (this.zzawa != null) {
            zzya.zzb(2, this.zzawa);
        }
        if (this.zzawb != null) {
            zzya.zza(3, (zzyi) this.zzawb);
        }
        if (this.zzavh != null) {
            zzya.zzb(4, this.zzavh.booleanValue());
        }
        if (this.zzavi != null) {
            zzya.zzb(5, this.zzavi.booleanValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzavk != null) {
            zzf += zzya.zzh(1, this.zzavk.intValue());
        }
        if (this.zzawa != null) {
            zzf += zzya.zzc(2, this.zzawa);
        }
        if (this.zzawb != null) {
            zzf += zzya.zzb(3, (zzyi) this.zzawb);
        }
        if (this.zzavh != null) {
            this.zzavh.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavi == null) {
            return zzf;
        }
        this.zzavi.booleanValue();
        return zzf + zzya.zzbd(5) + 1;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzavk = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 18) {
                this.zzawa = zzxz.readString();
            } else if (zzuj == 26) {
                if (this.zzawb == null) {
                    this.zzawb = new zzfk();
                }
                zzxz.zza((zzyi) this.zzawb);
            } else if (zzuj == 32) {
                this.zzavh = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 40) {
                this.zzavi = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
