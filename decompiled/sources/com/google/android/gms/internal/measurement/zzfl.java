package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfl extends zzyc<zzfl> {
    public Integer zzavu;
    public Boolean zzavv;
    public String zzavw;
    public String zzavx;
    public String zzavy;

    public zzfl() {
        this.zzavu = null;
        this.zzavv = null;
        this.zzavw = null;
        this.zzavx = null;
        this.zzavy = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfl)) {
            return false;
        }
        zzfl zzfl = (zzfl) obj;
        if (this.zzavu == null) {
            if (zzfl.zzavu != null) {
                return false;
            }
        } else if (!this.zzavu.equals(zzfl.zzavu)) {
            return false;
        }
        if (this.zzavv == null) {
            if (zzfl.zzavv != null) {
                return false;
            }
        } else if (!this.zzavv.equals(zzfl.zzavv)) {
            return false;
        }
        if (this.zzavw == null) {
            if (zzfl.zzavw != null) {
                return false;
            }
        } else if (!this.zzavw.equals(zzfl.zzavw)) {
            return false;
        }
        if (this.zzavx == null) {
            if (zzfl.zzavx != null) {
                return false;
            }
        } else if (!this.zzavx.equals(zzfl.zzavx)) {
            return false;
        }
        if (this.zzavy == null) {
            if (zzfl.zzavy != null) {
                return false;
            }
        } else if (!this.zzavy.equals(zzfl.zzavy)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfl.zzcet == null || zzfl.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfl.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzavu == null ? 0 : this.zzavu.intValue())) * 31) + (this.zzavv == null ? 0 : this.zzavv.hashCode())) * 31) + (this.zzavw == null ? 0 : this.zzavw.hashCode())) * 31) + (this.zzavx == null ? 0 : this.zzavx.hashCode())) * 31) + (this.zzavy == null ? 0 : this.zzavy.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzavu != null) {
            zzya.zzd(1, this.zzavu.intValue());
        }
        if (this.zzavv != null) {
            zzya.zzb(2, this.zzavv.booleanValue());
        }
        if (this.zzavw != null) {
            zzya.zzb(3, this.zzavw);
        }
        if (this.zzavx != null) {
            zzya.zzb(4, this.zzavx);
        }
        if (this.zzavy != null) {
            zzya.zzb(5, this.zzavy);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzavu != null) {
            zzf += zzya.zzh(1, this.zzavu.intValue());
        }
        if (this.zzavv != null) {
            this.zzavv.booleanValue();
            zzf += zzya.zzbd(2) + 1;
        }
        if (this.zzavw != null) {
            zzf += zzya.zzc(3, this.zzavw);
        }
        if (this.zzavx != null) {
            zzf += zzya.zzc(4, this.zzavx);
        }
        return this.zzavy != null ? zzf + zzya.zzc(5, this.zzavy) : zzf;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzfl zza(zzxz zzxz) throws IOException {
        int zzvb;
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                try {
                    zzvb = zzxz.zzvb();
                    if (zzvb < 0 || zzvb > 4) {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append(zzvb);
                        sb.append(" is not a valid enum ComparisonType");
                    } else {
                        this.zzavu = Integer.valueOf(zzvb);
                    }
                } catch (IllegalArgumentException unused) {
                    zzxz.zzcb(zzxz.getPosition());
                    zza(zzxz, zzuj);
                }
            } else if (zzuj == 16) {
                this.zzavv = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 26) {
                this.zzavw = zzxz.readString();
            } else if (zzuj == 34) {
                this.zzavx = zzxz.readString();
            } else if (zzuj == 42) {
                this.zzavy = zzxz.readString();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append(zzvb);
        sb2.append(" is not a valid enum ComparisonType");
        throw new IllegalArgumentException(sb2.toString());
    }
}
