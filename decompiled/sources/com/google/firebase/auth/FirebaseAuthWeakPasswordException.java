package com.google.firebase.auth;

public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException {
    private final String zzhj;

    public FirebaseAuthWeakPasswordException(String str, String str2, String str3) {
        super(str, str2);
        this.zzhj = str3;
    }

    public final String getReason() {
        return this.zzhj;
    }
}
