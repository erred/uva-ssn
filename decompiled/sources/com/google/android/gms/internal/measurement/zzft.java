package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzft extends zzyc<zzft> {
    private static volatile zzft[] zzawz;
    public Integer count;
    public String name;
    public zzfu[] zzaxa;
    public Long zzaxb;
    public Long zzaxc;

    public static zzft[] zzmz() {
        if (zzawz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawz == null) {
                    zzawz = new zzft[0];
                }
            }
        }
        return zzawz;
    }

    public zzft() {
        this.zzaxa = zzfu.zzna();
        this.name = null;
        this.zzaxb = null;
        this.zzaxc = null;
        this.count = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzft = (zzft) obj;
        if (!zzyg.equals((Object[]) this.zzaxa, (Object[]) zzft.zzaxa)) {
            return false;
        }
        if (this.name == null) {
            if (zzft.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzft.name)) {
            return false;
        }
        if (this.zzaxb == null) {
            if (zzft.zzaxb != null) {
                return false;
            }
        } else if (!this.zzaxb.equals(zzft.zzaxb)) {
            return false;
        }
        if (this.zzaxc == null) {
            if (zzft.zzaxc != null) {
                return false;
            }
        } else if (!this.zzaxc.equals(zzft.zzaxc)) {
            return false;
        }
        if (this.count == null) {
            if (zzft.count != null) {
                return false;
            }
        } else if (!this.count.equals(zzft.count)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzft.zzcet == null || zzft.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzft.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode((Object[]) this.zzaxa)) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzaxb == null ? 0 : this.zzaxb.hashCode())) * 31) + (this.zzaxc == null ? 0 : this.zzaxc.hashCode())) * 31) + (this.count == null ? 0 : this.count.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzaxa != null && this.zzaxa.length > 0) {
            for (zzfu zzfu : this.zzaxa) {
                if (zzfu != null) {
                    zzya.zza(1, (zzyi) zzfu);
                }
            }
        }
        if (this.name != null) {
            zzya.zzb(2, this.name);
        }
        if (this.zzaxb != null) {
            zzya.zzi(3, this.zzaxb.longValue());
        }
        if (this.zzaxc != null) {
            zzya.zzi(4, this.zzaxc.longValue());
        }
        if (this.count != null) {
            zzya.zzd(5, this.count.intValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzaxa != null && this.zzaxa.length > 0) {
            for (zzfu zzfu : this.zzaxa) {
                if (zzfu != null) {
                    zzf += zzya.zzb(1, (zzyi) zzfu);
                }
            }
        }
        if (this.name != null) {
            zzf += zzya.zzc(2, this.name);
        }
        if (this.zzaxb != null) {
            zzf += zzya.zzd(3, this.zzaxb.longValue());
        }
        if (this.zzaxc != null) {
            zzf += zzya.zzd(4, this.zzaxc.longValue());
        }
        return this.count != null ? zzf + zzya.zzh(5, this.count.intValue()) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                int zzb = zzyl.zzb(zzxz, 10);
                int length = this.zzaxa == null ? 0 : this.zzaxa.length;
                zzfu[] zzfuArr = new zzfu[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzaxa, 0, zzfuArr, 0, length);
                }
                while (length < zzfuArr.length - 1) {
                    zzfuArr[length] = new zzfu();
                    zzxz.zza((zzyi) zzfuArr[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfuArr[length] = new zzfu();
                zzxz.zza((zzyi) zzfuArr[length]);
                this.zzaxa = zzfuArr;
            } else if (zzuj == 18) {
                this.name = zzxz.readString();
            } else if (zzuj == 24) {
                this.zzaxb = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 32) {
                this.zzaxc = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 40) {
                this.count = Integer.valueOf(zzxz.zzvb());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
