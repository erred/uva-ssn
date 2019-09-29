package com.google.android.gms.internal.measurement;

import java.util.Arrays;

final class zzyk {
    final int tag;
    final byte[] zzbtx;

    zzyk(int i, byte[] bArr) {
        this.tag = i;
        this.zzbtx = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyk)) {
            return false;
        }
        zzyk zzyk = (zzyk) obj;
        return this.tag == zzyk.tag && Arrays.equals(this.zzbtx, zzyk.zzbtx);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbtx);
    }
}
