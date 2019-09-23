package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zze extends zzbq {

    /* renamed from: ID */
    private static final String f6687ID = zza.ADVERTISER_ID.toString();
    private final zza zzazf;

    public zze(Context context) {
        this(zza.zzo(context));
    }

    public final boolean zznk() {
        return false;
    }

    @VisibleForTesting
    private zze(zza zza) {
        super(f6687ID, new String[0]);
        this.zzazf = zza;
        this.zzazf.zzne();
    }

    public final zzp zzc(Map<String, zzp> map) {
        String zzne = this.zzazf.zzne();
        return zzne == null ? zzgj.zzqq() : zzgj.zzj(zzne);
    }
}
