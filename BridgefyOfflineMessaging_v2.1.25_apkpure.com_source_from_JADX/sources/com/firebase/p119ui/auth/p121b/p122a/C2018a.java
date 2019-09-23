package com.firebase.p119ui.auth.p121b.p122a;

import android.net.Uri;
import android.text.TextUtils;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2037d;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest.Builder;

/* renamed from: com.firebase.ui.auth.b.a.a */
/* compiled from: ProfileMerger */
public class C2018a implements Continuation<AuthResult, Task<AuthResult>> {

    /* renamed from: a */
    private final C2034c f6250a;

    public C2018a(C2034c cVar) {
        this.f6250a = cVar;
    }

    /* renamed from: a */
    public Task<AuthResult> then(Task<AuthResult> task) throws Exception {
        final AuthResult authResult = (AuthResult) task.getResult();
        FirebaseUser user = authResult.getUser();
        String displayName = user.getDisplayName();
        Uri photoUrl = user.getPhotoUrl();
        if (!TextUtils.isEmpty(displayName) && photoUrl != null) {
            return Tasks.forResult(authResult);
        }
        C2037d b = this.f6250a.mo11836b();
        if (TextUtils.isEmpty(displayName)) {
            displayName = b.mo11852c();
        }
        if (photoUrl == null) {
            photoUrl = b.mo11853d();
        }
        return user.updateProfile(new Builder().setDisplayName(displayName).setPhotoUri(photoUrl).build()).addOnFailureListener(new C2077g("ProfileMerger", "Error updating profile")).continueWithTask(new Continuation<Void, Task<AuthResult>>() {
            /* renamed from: a */
            public Task<AuthResult> then(Task<Void> task) throws Exception {
                return Tasks.forResult(authResult);
            }
        });
    }
}
