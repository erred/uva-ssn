package com.firebase.p119ui.auth.p121b;

import android.os.Bundle;
import androidx.fragment.p081a.C1071e;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.firebase.ui.auth.b.c */
/* compiled from: GoogleSignInHelper */
public class C2030c extends C2020b {
    private C2030c(C1071e eVar, Builder builder) {
        super(eVar, builder);
    }

    /* renamed from: a */
    public static C2030c m8228a(C1071e eVar) {
        return new C2030c(eVar, new Builder(eVar).addApi(Auth.CREDENTIALS_API).addApi(Auth.GOOGLE_SIGN_IN_API, GoogleSignInOptions.DEFAULT_SIGN_IN));
    }

    /* renamed from: a */
    public Task<Status> mo11833a(final Credential credential) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        mo11821b().addOnCompleteListener(new C2021a(taskCompletionSource, new OnSuccessListener<Bundle>() {
            /* renamed from: a */
            public void onSuccess(Bundle bundle) {
                Auth.CredentialsApi.delete(C2030c.this.f6254a, credential).setResultCallback(new C2022b(taskCompletionSource));
            }
        }));
        return taskCompletionSource.getTask();
    }
}
