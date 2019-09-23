package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

@VisibleForTesting
final class zzbp extends zzbq {

    /* renamed from: ID */
    private static final String f6675ID = zza.EVENT.toString();
    private final zzfb zzazq;

    public zzbp(zzfb zzfb) {
        super(f6675ID, new String[0]);
        this.zzazq = zzfb;
    }

    public final boolean zznk() {
        return false;
    }

    public final zzp zzc(Map<String, zzp> map) {
        String zzpt = this.zzazq.zzpt();
        if (zzpt == null) {
            return zzgj.zzqq();
        }
        return zzgj.zzj(zzpt);
    }
}
