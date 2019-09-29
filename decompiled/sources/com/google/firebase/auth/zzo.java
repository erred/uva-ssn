package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzv;

final class zzo implements zzv {
    private final /* synthetic */ FirebaseAuth zzhc;
    private final /* synthetic */ FirebaseUser zzhg;

    zzo(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zzhc = firebaseAuth;
        this.zzhg = firebaseUser;
    }

    public final void zzcd() {
        if (this.zzhc.zzgr.getUid().equalsIgnoreCase(this.zzhg.getUid())) {
            this.zzhc.zzca();
        }
    }

    public final void zza(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.zzhc.signOut();
        }
    }
}
