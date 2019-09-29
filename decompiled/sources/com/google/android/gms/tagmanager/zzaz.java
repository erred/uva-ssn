package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzp;
import java.util.List;
import java.util.Map;

final class zzaz extends zzgh {

    /* renamed from: ID */
    private static final String f6669ID = zza.DATA_LAYER_WRITE.toString();
    private static final String VALUE = zzb.VALUE.toString();
    private static final String zzbbt = zzb.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzazp;

    public zzaz(DataLayer dataLayer) {
        super(f6669ID, VALUE);
        this.zzazp = dataLayer;
    }

    public final void zze(Map<String, zzp> map) {
        zzp zzp = (zzp) map.get(VALUE);
        if (!(zzp == null || zzp == zzgj.zzqk())) {
            Object zzh = zzgj.zzh(zzp);
            if (zzh instanceof List) {
                for (Object next : (List) zzh) {
                    if (next instanceof Map) {
                        this.zzazp.push((Map) next);
                    }
                }
            }
        }
        zzp zzp2 = (zzp) map.get(zzbbt);
        if (zzp2 != null && zzp2 != zzgj.zzqk()) {
            String zzc = zzgj.zzc(zzp2);
            if (zzc != zzgj.zzqp()) {
                this.zzazp.zzdh(zzc);
            }
        }
    }
}
