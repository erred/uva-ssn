package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzfx {
    final String name;
    final String origin;
    final Object value;
    final long zzauk;
    final String zztt;

    zzfx(String str, String str2, String str3, long j, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.zztt = str;
        this.origin = str2;
        this.name = str3;
        this.zzauk = j;
        this.value = obj;
    }
}
