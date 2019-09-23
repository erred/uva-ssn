package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzia extends zzhz<FieldDescriptorType, Object> {
    zzia(int i) {
        super(i, null);
    }

    public final void zzev() {
        if (!isImmutable()) {
            for (int i = 0; i < zzjf(); i++) {
                Entry zzbc = zzbc(i);
                if (((zzfm) zzbc.getKey()).zzha()) {
                    zzbc.setValue(Collections.unmodifiableList((List) zzbc.getValue()));
                }
            }
            for (Entry entry : zzjg()) {
                if (((zzfm) entry.getKey()).zzha()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzev();
    }
}
