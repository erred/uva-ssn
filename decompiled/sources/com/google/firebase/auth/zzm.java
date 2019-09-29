package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzw;

final class zzm implements zza, zzw {
    private final /* synthetic */ FirebaseAuth zzhc;

    zzm(FirebaseAuth firebaseAuth) {
        this.zzhc = firebaseAuth;
    }

    public final void zza(zzcz zzcz, FirebaseUser firebaseUser) {
        this.zzhc.zza(firebaseUser, zzcz, true);
    }

    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zzhc.signOut();
        }
    }
}
