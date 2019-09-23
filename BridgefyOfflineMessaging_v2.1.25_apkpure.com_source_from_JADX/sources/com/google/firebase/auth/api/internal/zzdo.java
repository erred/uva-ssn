package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.Collections;
import java.util.concurrent.Callable;

final class zzdo implements Callable<zzai<zzef>> {
    private final Context zzjx;
    private final zzef zzjy;

    public zzdo(zzef zzef, Context context) {
        this.zzjy = zzef;
        this.zzjx = context;
    }

    private final GoogleApi<zzef> zza(boolean z, Context context) {
        zzef zzef = (zzef) this.zzjy.clone();
        zzef.zzjt = z;
        return new zzal(context, zzed.zzmn, zzef, new FirebaseExceptionMapper());
    }

    public final /* synthetic */ Object call() throws Exception {
        int localVersion = DynamiteModule.getLocalVersion(this.zzjx, "com.google.firebase.auth");
        GoogleApi googleApi = null;
        int i = 1;
        GoogleApi zza = localVersion != 0 ? zza(true, this.zzjx) : null;
        if (localVersion != 0) {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzjx, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                i = DynamiteModule.getRemoteVersion(this.zzjx, "com.google.android.gms.firebase_auth");
            } else {
                i = 0;
            }
        }
        if (i != 0) {
            googleApi = zza(false, this.zzjx);
        }
        return new zzai(googleApi, zza, new zzak(i, localVersion, Collections.emptyMap()));
    }
}
