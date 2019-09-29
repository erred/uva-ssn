package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzi extends zzyc<zzi> {
    private static volatile zzi[] zzoi;
    public String zzoj;
    public long zzok;
    public long zzol;
    public boolean zzom;
    public long zzon;

    public static zzi[] zzg() {
        if (zzoi == null) {
            synchronized (zzyg.zzcfc) {
                if (zzoi == null) {
                    zzoi = new zzi[0];
                }
            }
        }
        return zzoi;
    }

    public zzi() {
        this.zzoj = "";
        this.zzok = 0;
        this.zzol = 2147483647L;
        this.zzom = false;
        this.zzon = 0;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zzi = (zzi) obj;
        if (this.zzoj == null) {
            if (zzi.zzoj != null) {
                return false;
            }
        } else if (!this.zzoj.equals(zzi.zzoj)) {
            return false;
        }
        if (this.zzok != zzi.zzok || this.zzol != zzi.zzol || this.zzom != zzi.zzom || this.zzon != zzi.zzon) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzi.zzcet == null || zzi.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzi.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzoj == null ? 0 : this.zzoj.hashCode())) * 31) + ((int) (this.zzok ^ (this.zzok >>> 32)))) * 31) + ((int) (this.zzol ^ (this.zzol >>> 32)))) * 31) + (this.zzom ? 1231 : 1237)) * 31) + ((int) (this.zzon ^ (this.zzon >>> 32)))) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzoj != null && !this.zzoj.equals("")) {
            zzya.zzb(1, this.zzoj);
        }
        if (this.zzok != 0) {
            zzya.zzi(2, this.zzok);
        }
        if (this.zzol != 2147483647L) {
            zzya.zzi(3, this.zzol);
        }
        if (this.zzom) {
            zzya.zzb(4, this.zzom);
        }
        if (this.zzon != 0) {
            zzya.zzi(5, this.zzon);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzoj != null && !this.zzoj.equals("")) {
            zzf += zzya.zzc(1, this.zzoj);
        }
        if (this.zzok != 0) {
            zzf += zzya.zzd(2, this.zzok);
        }
        if (this.zzol != 2147483647L) {
            zzf += zzya.zzd(3, this.zzol);
        }
        if (this.zzom) {
            zzf += zzya.zzbd(4) + 1;
        }
        return this.zzon != 0 ? zzf + zzya.zzd(5, this.zzon) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                this.zzoj = zzxz.readString();
            } else if (zzuj == 16) {
                this.zzok = zzxz.zzvc();
            } else if (zzuj == 24) {
                this.zzol = zzxz.zzvc();
            } else if (zzuj == 32) {
                this.zzom = zzxz.zzup();
            } else if (zzuj == 40) {
                this.zzon = zzxz.zzvc();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
