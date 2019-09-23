package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzde extends zzdy {

    /* renamed from: ID */
    private static final String f6683ID = zza.LESS_EQUALS.toString();

    public zzde() {
        super(f6683ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzgi zzgi, zzgi zzgi2, Map<String, zzp> map) {
        return zzgi.compareTo(zzgi2) <= 0;
    }
}
