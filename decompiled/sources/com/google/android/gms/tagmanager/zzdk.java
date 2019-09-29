package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzdk extends zzbq {

    /* renamed from: ID */
    private static final String f6685ID = zza.LOWERCASE_STRING.toString();
    private static final String zzbcd = zzb.ARG0.toString();

    public zzdk() {
        super(f6685ID, zzbcd);
    }

    public final boolean zznk() {
        return true;
    }

    public final zzp zzc(Map<String, zzp> map) {
        return zzgj.zzj(zzgj.zzc((zzp) map.get(zzbcd)).toLowerCase());
    }
}
