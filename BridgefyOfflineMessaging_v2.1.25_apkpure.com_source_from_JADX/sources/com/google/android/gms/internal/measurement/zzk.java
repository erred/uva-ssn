package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzk extends zzyc<zzk> {
    private static volatile zzk[] zzor;
    public int key;
    public int value;

    public static zzk[] zzh() {
        if (zzor == null) {
            synchronized (zzyg.zzcfc) {
                if (zzor == null) {
                    zzor = new zzk[0];
                }
            }
        }
        return zzor;
    }

    public zzk() {
        this.key = 0;
        this.value = 0;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzk)) {
            return false;
        }
        zzk zzk = (zzk) obj;
        if (this.key != zzk.key || this.value != zzk.value) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzk.zzcet == null || zzk.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzk.zzcet);
    }

    public final int hashCode() {
        return ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    public final void zza(zzya zzya) throws IOException {
        zzya.zzd(1, this.key);
        zzya.zzd(2, this.value);
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        return super.zzf() + zzya.zzh(1, this.key) + zzya.zzh(2, this.value);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.key = zzxz.zzvb();
            } else if (zzuj == 16) {
                this.value = zzxz.zzvb();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
