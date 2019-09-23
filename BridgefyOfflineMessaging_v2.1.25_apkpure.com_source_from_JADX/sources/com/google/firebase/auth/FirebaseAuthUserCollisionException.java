package com.google.firebase.auth;

public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {
    private String zzgh;
    private AuthCredential zzhi;

    public FirebaseAuthUserCollisionException(String str, String str2) {
        super(str, str2);
    }

    public final FirebaseAuthUserCollisionException zzbo(String str) {
        this.zzgh = str;
        return this;
    }

    public final FirebaseAuthUserCollisionException zza(AuthCredential authCredential) {
        this.zzhi = authCredential;
        return this;
    }

    public final AuthCredential getUpdatedCredential() {
        return this.zzhi;
    }
}
