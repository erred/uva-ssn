package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzp;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@VisibleForTesting
final class zzam extends zzbq {

    /* renamed from: ID */
    private static final String f6667ID = zza.FUNCTION_CALL.toString();
    private static final String zzazi = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzbax = zzb.FUNCTION_CALL_NAME.toString();
    private final zzan zzbay;

    public zzam(zzan zzan) {
        super(f6667ID, zzbax);
        this.zzbay = zzan;
    }

    public final boolean zznk() {
        return false;
    }

    public final zzp zzc(Map<String, zzp> map) {
        String zzc = zzgj.zzc((zzp) map.get(zzbax));
        HashMap hashMap = new HashMap();
        zzp zzp = (zzp) map.get(zzazi);
        if (zzp != null) {
            Object zzh = zzgj.zzh(zzp);
            if (!(zzh instanceof Map)) {
                zzdi.zzab("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzgj.zzqq();
            }
            for (Entry entry : ((Map) zzh).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzgj.zzj(this.zzbay.zza(zzc, hashMap));
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 34 + String.valueOf(message).length());
            sb.append("Custom macro/tag ");
            sb.append(zzc);
            sb.append(" threw exception ");
            sb.append(message);
            zzdi.zzab(sb.toString());
            return zzgj.zzqq();
        }
    }
}
