package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth.AuthStateListener;

final class zzl implements Runnable {
    private final /* synthetic */ FirebaseAuth zzhc;

    zzl(FirebaseAuth firebaseAuth) {
        this.zzhc = firebaseAuth;
    }

    public final void run() {
        for (AuthStateListener onAuthStateChanged : this.zzhc.zzgp) {
            onAuthStateChanged.onAuthStateChanged(this.zzhc);
        }
    }
}
