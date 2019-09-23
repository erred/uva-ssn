package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;

public abstract class zzyc<M extends zzyc<M>> extends zzyi {
    protected zzye zzcet;

    /* access modifiers changed from: protected */
    public int zzf() {
        if (this.zzcet == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzcet.size(); i2++) {
            i += this.zzcet.zzcf(i2).zzf();
        }
        return i;
    }

    public void zza(zzya zzya) throws IOException {
        if (this.zzcet != null) {
            for (int i = 0; i < this.zzcet.size(); i++) {
                this.zzcet.zzcf(i).zza(zzya);
            }
        }
    }

    public final <T> T zza(zzyd<M, T> zzyd) {
        if (this.zzcet == null) {
            return null;
        }
        zzyf zzce = this.zzcet.zzce(zzyd.tag >>> 3);
        if (zzce == null) {
            return null;
        }
        return zzce.zzb(zzyd);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzxz zzxz, int i) throws IOException {
        int position = zzxz.getPosition();
        if (!zzxz.zzaq(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzyk zzyk = new zzyk(i, zzxz.zzs(position, zzxz.getPosition() - position));
        zzyf zzyf = null;
        if (this.zzcet == null) {
            this.zzcet = new zzye();
        } else {
            zzyf = this.zzcet.zzce(i2);
        }
        if (zzyf == null) {
            zzyf = new zzyf();
            this.zzcet.zza(i2, zzyf);
        }
        zzyf.zza(zzyk);
        return true;
    }

    public final /* synthetic */ zzyi zzzb() throws CloneNotSupportedException {
        return (zzyc) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzyc zzyc = (zzyc) super.clone();
        zzyg.zza(this, zzyc);
        return zzyc;
    }
}
