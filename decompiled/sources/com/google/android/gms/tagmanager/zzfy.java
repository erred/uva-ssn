package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzfy extends zzfz {

    /* renamed from: ID */
    private static final String f6697ID = zza.STARTS_WITH.toString();

    public zzfy() {
        super(f6697ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, String str2, Map<String, zzp> map) {
        return str.startsWith(str2);
    }
}
