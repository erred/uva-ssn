package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzbt extends zzdy {

    /* renamed from: ID */
    private static final String f6677ID = zza.GREATER_THAN.toString();

    public zzbt() {
        super(f6677ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzgi zzgi, zzgi zzgi2, Map<String, zzp> map) {
        return zzgi.compareTo(zzgi2) > 0;
    }
}