package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.firebase.auth.FirebaseAuth;

public final class zzz {
    private static final zzz zzrq = new zzz();
    private final zzac zzro;
    private final zzx zzrp;

    private zzz() {
        this(zzac.zzen(), zzx.zzek());
    }

    private zzz(zzac zzac, zzx zzx) {
        this.zzro = zzac;
        this.zzrp = zzx;
    }

    public static zzz zzem() {
        return zzrq;
    }

    public final void zzg(FirebaseAuth firebaseAuth) {
        this.zzro.zzh(firebaseAuth);
    }

    public final void zza(Context context) {
        this.zzro.zza(context);
    }
}
