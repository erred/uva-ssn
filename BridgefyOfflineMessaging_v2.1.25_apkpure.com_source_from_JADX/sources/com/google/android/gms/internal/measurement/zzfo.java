package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfo extends zzyc<zzfo> {
    private static volatile zzfo[] zzawg;
    public String name;
    public Boolean zzawh;
    public Boolean zzawi;
    public Integer zzawj;

    public static zzfo[] zzmv() {
        if (zzawg == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawg == null) {
                    zzawg = new zzfo[0];
                }
            }
        }
        return zzawg;
    }

    public zzfo() {
        this.name = null;
        this.zzawh = null;
        this.zzawi = null;
        this.zzawj = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfo)) {
            return false;
        }
        zzfo zzfo = (zzfo) obj;
        if (this.name == null) {
            if (zzfo.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzfo.name)) {
            return false;
        }
        if (this.zzawh == null) {
            if (zzfo.zzawh != null) {
                return false;
            }
        } else if (!this.zzawh.equals(zzfo.zzawh)) {
            return false;
        }
        if (this.zzawi == null) {
            if (zzfo.zzawi != null) {
                return false;
            }
        } else if (!this.zzawi.equals(zzfo.zzawi)) {
            return false;
        }
        if (this.zzawj == null) {
            if (zzfo.zzawj != null) {
                return false;
            }
        } else if (!this.zzawj.equals(zzfo.zzawj)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfo.zzcet == null || zzfo.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfo.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzawh == null ? 0 : this.zzawh.hashCode())) * 31) + (this.zzawi == null ? 0 : this.zzawi.hashCode())) * 31) + (this.zzawj == null ? 0 : this.zzawj.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.name != null) {
            zzya.zzb(1, this.name);
        }
        if (this.zzawh != null) {
            zzya.zzb(2, this.zzawh.booleanValue());
        }
        if (this.zzawi != null) {
            zzya.zzb(3, this.zzawi.booleanValue());
        }
        if (this.zzawj != null) {
            zzya.zzd(4, this.zzawj.intValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.name != null) {
            zzf += zzya.zzc(1, this.name);
        }
        if (this.zzawh != null) {
            this.zzawh.booleanValue();
            zzf += zzya.zzbd(2) + 1;
        }
        if (this.zzawi != null) {
            this.zzawi.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        return this.zzawj != null ? zzf + zzya.zzh(4, this.zzawj.intValue()) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                this.name = zzxz.readString();
            } else if (zzuj == 16) {
                this.zzawh = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 24) {
                this.zzawi = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 32) {
                this.zzawj = Integer.valueOf(zzxz.zzvb());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
