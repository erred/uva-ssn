package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfk extends zzyc<zzfk> {
    private static volatile zzfk[] zzavp;
    public zzfn zzavq;
    public zzfl zzavr;
    public Boolean zzavs;
    public String zzavt;

    public static zzfk[] zzmt() {
        if (zzavp == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavp == null) {
                    zzavp = new zzfk[0];
                }
            }
        }
        return zzavp;
    }

    public zzfk() {
        this.zzavq = null;
        this.zzavr = null;
        this.zzavs = null;
        this.zzavt = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return false;
        }
        zzfk zzfk = (zzfk) obj;
        if (this.zzavq == null) {
            if (zzfk.zzavq != null) {
                return false;
            }
        } else if (!this.zzavq.equals(zzfk.zzavq)) {
            return false;
        }
        if (this.zzavr == null) {
            if (zzfk.zzavr != null) {
                return false;
            }
        } else if (!this.zzavr.equals(zzfk.zzavr)) {
            return false;
        }
        if (this.zzavs == null) {
            if (zzfk.zzavs != null) {
                return false;
            }
        } else if (!this.zzavs.equals(zzfk.zzavs)) {
            return false;
        }
        if (this.zzavt == null) {
            if (zzfk.zzavt != null) {
                return false;
            }
        } else if (!this.zzavt.equals(zzfk.zzavt)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfk.zzcet == null || zzfk.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfk.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = getClass().getName().hashCode() + 527;
        zzfn zzfn = this.zzavq;
        int i3 = hashCode * 31;
        int i4 = 0;
        if (zzfn == null) {
            i = 0;
        } else {
            i = zzfn.hashCode();
        }
        int i5 = i3 + i;
        zzfl zzfl = this.zzavr;
        int i6 = i5 * 31;
        if (zzfl == null) {
            i2 = 0;
        } else {
            i2 = zzfl.hashCode();
        }
        int hashCode2 = (((((i6 + i2) * 31) + (this.zzavs == null ? 0 : this.zzavs.hashCode())) * 31) + (this.zzavt == null ? 0 : this.zzavt.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i4 = this.zzcet.hashCode();
        }
        return hashCode2 + i4;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzavq != null) {
            zzya.zza(1, (zzyi) this.zzavq);
        }
        if (this.zzavr != null) {
            zzya.zza(2, (zzyi) this.zzavr);
        }
        if (this.zzavs != null) {
            zzya.zzb(3, this.zzavs.booleanValue());
        }
        if (this.zzavt != null) {
            zzya.zzb(4, this.zzavt);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzavq != null) {
            zzf += zzya.zzb(1, (zzyi) this.zzavq);
        }
        if (this.zzavr != null) {
            zzf += zzya.zzb(2, (zzyi) this.zzavr);
        }
        if (this.zzavs != null) {
            this.zzavs.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        return this.zzavt != null ? zzf + zzya.zzc(4, this.zzavt) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                if (this.zzavq == null) {
                    this.zzavq = new zzfn();
                }
                zzxz.zza((zzyi) this.zzavq);
            } else if (zzuj == 18) {
                if (this.zzavr == null) {
                    this.zzavr = new zzfl();
                }
                zzxz.zza((zzyi) this.zzavr);
            } else if (zzuj == 24) {
                this.zzavs = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 34) {
                this.zzavt = zzxz.readString();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
