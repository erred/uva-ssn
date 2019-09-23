package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfq extends zzyc<zzfq> {
    private static volatile zzfq[] zzawr;
    public String value;
    public String zzoj;

    public static zzfq[] zzmw() {
        if (zzawr == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawr == null) {
                    zzawr = new zzfq[0];
                }
            }
        }
        return zzawr;
    }

    public zzfq() {
        this.zzoj = null;
        this.value = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfq)) {
            return false;
        }
        zzfq zzfq = (zzfq) obj;
        if (this.zzoj == null) {
            if (zzfq.zzoj != null) {
                return false;
            }
        } else if (!this.zzoj.equals(zzfq.zzoj)) {
            return false;
        }
        if (this.value == null) {
            if (zzfq.value != null) {
                return false;
            }
        } else if (!this.value.equals(zzfq.value)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfq.zzcet == null || zzfq.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfq.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.zzoj == null ? 0 : this.zzoj.hashCode())) * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzoj != null) {
            zzya.zzb(1, this.zzoj);
        }
        if (this.value != null) {
            zzya.zzb(2, this.value);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzoj != null) {
            zzf += zzya.zzc(1, this.zzoj);
        }
        return this.value != null ? zzf + zzya.zzc(2, this.value) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                this.zzoj = zzxz.readString();
            } else if (zzuj == 18) {
                this.value = zzxz.readString();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
