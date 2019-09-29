package com.google.firebase.auth;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;

final class zzk implements Runnable {
    private final /* synthetic */ FirebaseAuth zzhc;
    private final /* synthetic */ InternalTokenResult zzhe;

    zzk(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zzhc = firebaseAuth;
        this.zzhe = internalTokenResult;
    }

    public final void run() {
        this.zzhc.zzgm.notifyIdTokenListeners(this.zzhe);
        for (IdTokenListener onIdTokenChanged : this.zzhc.zzgo) {
            onIdTokenChanged.onIdTokenChanged(this.zzhe);
        }
        for (FirebaseAuth.IdTokenListener onIdTokenChanged2 : this.zzhc.zzgn) {
            onIdTokenChanged2.onIdTokenChanged(this.zzhc);
        }
    }
}
