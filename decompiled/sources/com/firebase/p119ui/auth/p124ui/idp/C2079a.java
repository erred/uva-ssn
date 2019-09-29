package com.firebase.p119ui.auth.p124ui.idp;

import android.util.Log;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p120a.C2012g;
import com.firebase.p119ui.auth.p121b.p123b.C2024b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.accountlink.WelcomeBackIdpPrompt;
import com.firebase.p119ui.auth.p124ui.accountlink.WelcomeBackPasswordPrompt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* renamed from: com.firebase.ui.auth.ui.idp.a */
/* compiled from: CredentialSignInHandler */
public class C2079a implements OnCompleteListener<AuthResult> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2051d f6390a;

    /* renamed from: b */
    private C2024b f6391b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C2034c f6392c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f6393d;

    /* renamed from: com.firebase.ui.auth.ui.idp.a$a */
    /* compiled from: CredentialSignInHandler */
    private class C2081a implements OnSuccessListener<String> {
        private C2081a() {
        }

        /* renamed from: a */
        public void onSuccess(String str) {
            C2079a.this.f6390a.mo11888d().mo11907a();
            if (str == null) {
                throw new IllegalStateException("No provider even though we received a FirebaseAuthUserCollisionException");
            } else if (str.equals("password")) {
                C2079a.this.f6390a.startActivityForResult(WelcomeBackPasswordPrompt.m8269a(C2079a.this.f6390a, C2079a.this.f6390a.mo11886b(), C2079a.this.f6392c), C2079a.this.f6393d);
            } else {
                C2079a.this.f6390a.startActivityForResult(WelcomeBackIdpPrompt.m8260a(C2079a.this.f6390a, C2079a.this.f6390a.mo11886b(), new C2039a(str, C2079a.this.f6392c.mo11838d()).mo11865a(), C2079a.this.f6392c), C2079a.this.f6393d);
            }
        }
    }

    public C2079a(C2051d dVar, C2024b bVar, int i, C2034c cVar) {
        this.f6390a = dVar;
        this.f6391b = bVar;
        this.f6392c = cVar;
        this.f6393d = i;
    }

    public void onComplete(Task<AuthResult> task) {
        if (task.isSuccessful()) {
            this.f6390a.mo11884a(this.f6391b, ((AuthResult) task.getResult()).getUser(), this.f6392c);
        } else {
            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                String d = this.f6392c.mo11838d();
                if (d != null) {
                    C2012g.m8174a(this.f6390a.mo11887c().mo11815a(), d).addOnSuccessListener(new C2081a()).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(Exception exc) {
                            C2079a.this.f6390a.mo11883a(0, C2034c.m8234a(20));
                        }
                    });
                    return;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected exception when signing in with credential ");
                sb.append(this.f6392c.mo11837c());
                sb.append(" unsuccessful. Visit https://console.firebase.google.com to enable it.");
                Log.e("CredentialSignInHandler", sb.toString(), task.getException());
            }
            this.f6390a.mo11888d().mo11907a();
        }
    }
}
