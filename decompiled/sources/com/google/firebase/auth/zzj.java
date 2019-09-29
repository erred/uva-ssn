package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth.AuthStateListener;

final class zzj implements Runnable {
    private final /* synthetic */ FirebaseAuth zzhc;
    private final /* synthetic */ AuthStateListener zzhd;

    zzj(FirebaseAuth firebaseAuth, AuthStateListener authStateListener) {
        this.zzhc = firebaseAuth;
        this.zzhd = authStateListener;
    }

    public final void run() {
        this.zzhd.onAuthStateChanged(this.zzhc);
    }
}
