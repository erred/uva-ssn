package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzak extends zzfz {

    /* renamed from: ID */
    private static final String f6666ID = zza.CONTAINS.toString();

    public zzak() {
        super(f6666ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, String str2, Map<String, zzp> map) {
        return str.contains(str2);
    }
}