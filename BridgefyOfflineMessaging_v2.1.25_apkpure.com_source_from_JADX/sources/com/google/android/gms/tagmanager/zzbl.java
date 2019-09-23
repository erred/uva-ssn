package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzbl extends zzfz {

    /* renamed from: ID */
    private static final String f6673ID = zza.ENDS_WITH.toString();

    public zzbl() {
        super(f6673ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, String str2, Map<String, zzp> map) {
        return str.endsWith(str2);
    }
}
