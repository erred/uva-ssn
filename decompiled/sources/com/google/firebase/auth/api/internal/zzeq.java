package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzeq implements zzev {
    private final /* synthetic */ String zzny;

    zzeq(zzep zzep, String str) {
        this.zzny = str;
    }

    public final void zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zzny, ForceResendingToken.zzcj());
    }
}
