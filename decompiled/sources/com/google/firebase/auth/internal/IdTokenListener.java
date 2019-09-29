package com.google.firebase.auth.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.internal.InternalTokenResult;

@KeepForSdk
public interface IdTokenListener {
    @KeepForSdk
    void onIdTokenChanged(InternalTokenResult internalTokenResult);
}
