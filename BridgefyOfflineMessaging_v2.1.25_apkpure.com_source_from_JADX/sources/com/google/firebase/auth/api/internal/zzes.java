package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzes implements zzev {
    private final /* synthetic */ String zzny;

    zzes(zzep zzep, String str) {
        this.zzny = str;
    }

    public final void zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeAutoRetrievalTimeOut(this.zzny);
    }
}
