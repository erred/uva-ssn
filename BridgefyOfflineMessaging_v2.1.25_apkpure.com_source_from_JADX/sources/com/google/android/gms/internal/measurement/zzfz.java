package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfz extends zzyc<zzfz> {
    private static volatile zzfz[] zzayt;
    public String name;
    public String zzaml;
    private Float zzaum;
    public Double zzaun;
    public Long zzaxe;
    public Long zzayu;

    public static zzfz[] zznd() {
        if (zzayt == null) {
            synchronized (zzyg.zzcfc) {
                if (zzayt == null) {
                    zzayt = new zzfz[0];
                }
            }
        }
        return zzayt;
    }

    public zzfz() {
        this.zzayu = null;
        this.name = null;
        this.zzaml = null;
        this.zzaxe = null;
        this.zzaum = null;
        this.zzaun = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfz)) {
            return false;
        }
        zzfz zzfz = (zzfz) obj;
        if (this.zzayu == null) {
            if (zzfz.zzayu != null) {
                return false;
            }
        } else if (!this.zzayu.equals(zzfz.zzayu)) {
            return false;
        }
        if (this.name == null) {
            if (zzfz.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzfz.name)) {
            return false;
        }
        if (this.zzaml == null) {
            if (zzfz.zzaml != null) {
                return false;
            }
        } else if (!this.zzaml.equals(zzfz.zzaml)) {
            return false;
        }
        if (this.zzaxe == null) {
            if (zzfz.zzaxe != null) {
                return false;
            }
        } else if (!this.zzaxe.equals(zzfz.zzaxe)) {
            return false;
        }
        if (this.zzaum == null) {
            if (zzfz.zzaum != null) {
                return false;
            }
        } else if (!this.zzaum.equals(zzfz.zzaum)) {
            return false;
        }
        if (this.zzaun == null) {
            if (zzfz.zzaun != null) {
                return false;
            }
        } else if (!this.zzaun.equals(zzfz.zzaun)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfz.zzcet == null || zzfz.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfz.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzayu == null ? 0 : this.zzayu.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzaml == null ? 0 : this.zzaml.hashCode())) * 31) + (this.zzaxe == null ? 0 : this.zzaxe.hashCode())) * 31) + (this.zzaum == null ? 0 : this.zzaum.hashCode())) * 31) + (this.zzaun == null ? 0 : this.zzaun.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzayu != null) {
            zzya.zzi(1, this.zzayu.longValue());
        }
        if (this.name != null) {
            zzya.zzb(2, this.name);
        }
        if (this.zzaml != null) {
            zzya.zzb(3, this.zzaml);
        }
        if (this.zzaxe != null) {
            zzya.zzi(4, this.zzaxe.longValue());
        }
        if (this.zzaum != null) {
            zzya.zza(5, this.zzaum.floatValue());
        }
        if (this.zzaun != null) {
            zzya.zza(6, this.zzaun.doubleValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzayu != null) {
            zzf += zzya.zzd(1, this.zzayu.longValue());
        }
        if (this.name != null) {
            zzf += zzya.zzc(2, this.name);
        }
        if (this.zzaml != null) {
            zzf += zzya.zzc(3, this.zzaml);
        }
        if (this.zzaxe != null) {
            zzf += zzya.zzd(4, this.zzaxe.longValue());
        }
        if (this.zzaum != null) {
            this.zzaum.floatValue();
            zzf += zzya.zzbd(5) + 4;
        }
        if (this.zzaun == null) {
            return zzf;
        }
        this.zzaun.doubleValue();
        return zzf + zzya.zzbd(6) + 8;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzayu = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 18) {
                this.name = zzxz.readString();
            } else if (zzuj == 26) {
                this.zzaml = zzxz.readString();
            } else if (zzuj == 32) {
                this.zzaxe = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 45) {
                this.zzaum = Float.valueOf(Float.intBitsToFloat(zzxz.zzvd()));
            } else if (zzuj == 49) {
                this.zzaun = Double.valueOf(Double.longBitsToDouble(zzxz.zzve()));
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
