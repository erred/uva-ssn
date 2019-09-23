package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzer implements zzev {
    private final /* synthetic */ PhoneAuthCredential zznz;

    zzer(zzep zzep, PhoneAuthCredential phoneAuthCredential) {
        this.zznz = phoneAuthCredential;
    }

    public final void zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zznz);
    }
}
