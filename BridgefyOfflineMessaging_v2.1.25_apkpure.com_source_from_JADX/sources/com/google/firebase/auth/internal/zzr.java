package com.google.firebase.auth.internal;

import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.List;

public final class zzr implements SignInMethodQueryResult {
    private final List<String> zzop;

    public zzr(List<String> list) {
        this.zzop = list;
    }

    public final List<String> getSignInMethods() {
        return this.zzop;
    }
}
