package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth.IdTokenListener;

final class zzi implements Runnable {
    private final /* synthetic */ IdTokenListener zzhb;
    private final /* synthetic */ FirebaseAuth zzhc;

    zzi(FirebaseAuth firebaseAuth, IdTokenListener idTokenListener) {
        this.zzhc = firebaseAuth;
        this.zzhb = idTokenListener;
    }

    public final void run() {
        this.zzhb.onIdTokenChanged(this.zzhc);
    }
}
