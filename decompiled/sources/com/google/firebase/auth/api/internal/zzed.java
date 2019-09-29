package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;

public final class zzed {
    private static final ClientKey<zzdq> CLIENT_KEY = new ClientKey<>();
    private static final AbstractClientBuilder<zzdq, zzef> zzmm = new zzee();
    public static final Api<zzef> zzmn = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzmm, CLIENT_KEY);

    public static zzao zza(Context context, zzef zzef) {
        return new zzao(context, zzef);
    }
}
