package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;

final class zzhq implements zzha {
    private final int flags;
    private final String info;
    private final Object[] zzzm;
    private final zzhc zzzp;

    zzhq(zzhc zzhc, String str, Object[] objArr) {
        this.zzzp = zzhc;
        this.info = str;
        this.zzzm = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zziw() {
        return this.info;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzix() {
        return this.zzzm;
    }

    public final zzhc zzip() {
        return this.zzzp;
    }

    public final int zzin() {
        return (this.flags & 1) == 1 ? zze.zzxn : zze.zzxo;
    }

    public final boolean zzio() {
        return (this.flags & 2) == 2;
    }
}
