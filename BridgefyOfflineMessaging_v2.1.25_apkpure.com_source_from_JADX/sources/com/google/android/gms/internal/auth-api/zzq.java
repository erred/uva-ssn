package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public final class zzq {
    public static PendingIntent zzc(Context context, AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest) {
        Preconditions.checkNotNull(context, "context must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", null);
        SafeParcelableSerializer.serializeToIntentExtra(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, putExtra, 134217728);
    }
}
