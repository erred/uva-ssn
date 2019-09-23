package com.firebase.p119ui.auth.p121b.p123b;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.p081a.C1062d;
import androidx.fragment.p081a.C1071e;
import androidx.fragment.p081a.C1078i;
import com.firebase.p119ui.auth.C2001a.C2003a;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2034c.C2036a;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p121b.C2020b;
import com.firebase.p119ui.auth.p121b.C2030c;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.firebase.p119ui.auth.p124ui.email.RegisterEmailActivity;
import com.firebase.p119ui.auth.p124ui.idp.AuthMethodPickerActivity;
import com.firebase.ui.auth.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.IdentityProviders;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.firebase.ui.auth.b.b.c */
/* compiled from: SignInDelegate */
public class C2025c extends C2029d<CredentialRequestResult> {

    /* renamed from: b */
    private Credential f6268b;

    public void onConnected(Bundle bundle) {
    }

    /* renamed from: a */
    public static void m8212a(C1071e eVar, C2048b bVar) {
        C1078i supportFragmentManager = eVar.getSupportFragmentManager();
        if (!(supportFragmentManager.mo4369a("SignInDelegate") instanceof C2025c)) {
            C2025c cVar = new C2025c();
            cVar.setArguments(bVar.mo11872a());
            supportFragmentManager.mo4370a().mo4069a((C1062d) cVar, "SignInDelegate").mo4065a().mo4084c();
        }
    }

    /* renamed from: a */
    public static C2025c m8210a(C1071e eVar) {
        C1062d a = eVar.getSupportFragmentManager().mo4369a("SignInDelegate");
        if (a instanceof C2025c) {
            return (C2025c) a;
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            if (mo11880b().f6323h) {
                mo11882d().mo11908a(R.string.fui_progress_dialog_loading);
                this.f6273a = new Builder(getContext().getApplicationContext()).addConnectionCallbacks(this).addApi(Auth.CREDENTIALS_API).enableAutoManage(getActivity(), C2020b.m8200a(), this).build();
                this.f6273a.connect();
                mo11881c().mo11816b().request(this.f6273a, new CredentialRequest.Builder().setPasswordLoginSupported(true).setAccountTypes((String[]) m8211a().toArray(new String[0])).build()).setResultCallback(this);
            } else {
                m8221h();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    public void onResult(CredentialRequestResult credentialRequestResult) {
        Status status = credentialRequestResult.getStatus();
        if (status.isSuccess()) {
            m8214a(credentialRequestResult.getCredential());
            return;
        }
        if (status.hasResolution()) {
            try {
                if (status.getStatusCode() == 6) {
                    mo11879a(status.getResolution().getIntentSender(), 2);
                    return;
                }
            } catch (SendIntentException e) {
                Log.e("SignInDelegate", "Failed to send Credentials intent.", e);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Status message:\n");
            sb.append(status.getStatusMessage());
            Log.e("SignInDelegate", sb.toString());
        }
        m8221h();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 2:
                if (i2 == -1) {
                    m8214a((Credential) intent.getParcelableExtra(Credential.EXTRA_KEY));
                    return;
                } else {
                    m8221h();
                    return;
                }
            case 3:
            case 4:
            case 5:
            case 6:
                mo11832a(i2, intent);
                return;
            default:
                C2023a a = C2023a.m8202a(getActivity());
                if (a != null) {
                    a.onActivityResult(i, i2, intent);
                    return;
                }
                return;
        }
    }

    /* renamed from: a */
    private List<String> m8211a() {
        ArrayList arrayList = new ArrayList();
        for (C2003a a : mo11880b().f6317b) {
            String a2 = a.mo11789a();
            if (a2.equals("google.com") || a2.equals("facebook.com") || a2.equals("twitter.com")) {
                arrayList.add(m8225a(a2));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private String m8218e() {
        if (this.f6268b == null) {
            return null;
        }
        return this.f6268b.getId();
    }

    /* renamed from: f */
    private String m8219f() {
        if (this.f6268b == null) {
            return null;
        }
        return this.f6268b.getAccountType();
    }

    /* renamed from: g */
    private String m8220g() {
        if (this.f6268b == null) {
            return null;
        }
        return this.f6268b.getPassword();
    }

    /* renamed from: a */
    private void m8214a(Credential credential) {
        this.f6268b = credential;
        String e = m8218e();
        String g = m8220g();
        if (TextUtils.isEmpty(e)) {
            return;
        }
        if (TextUtils.isEmpty(g)) {
            m8217b(e, m8219f());
        } else {
            m8215a(e, g);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        if (r4.equals("password") == false) goto L_0x003b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8221h() {
        /*
            r8 = this;
            com.firebase.ui.auth.ui.b r0 = r8.mo11880b()
            java.util.List<com.firebase.ui.auth.a$a> r1 = r0.f6317b
            int r2 = r1.size()
            r3 = 1
            if (r2 != r3) goto L_0x0066
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.firebase.ui.auth.a$a r1 = (com.firebase.p119ui.auth.C2001a.C2003a) r1
            java.lang.String r4 = r1.mo11789a()
            r5 = -1
            int r6 = r4.hashCode()
            r7 = 106642798(0x65b3d6e, float:4.1234453E-35)
            if (r6 == r7) goto L_0x0031
            r3 = 1216985755(0x4889ba9b, float:282068.84)
            if (r6 == r3) goto L_0x0028
            goto L_0x003b
        L_0x0028:
            java.lang.String r3 = "password"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x003c
        L_0x0031:
            java.lang.String r2 = "phone"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x003b
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = -1
        L_0x003c:
            switch(r2) {
                case 0: goto L_0x0059;
                case 1: goto L_0x0048;
                default: goto L_0x003f;
            }
        L_0x003f:
            r0 = 0
            java.lang.String r1 = m8225a(r4)
            r8.m8217b(r0, r1)
            goto L_0x0072
        L_0x0048:
            android.os.Bundle r1 = r1.mo11791c()
            android.content.Context r2 = r8.getContext()
            android.content.Intent r0 = com.firebase.p119ui.auth.p124ui.phone.PhoneVerificationActivity.m8367a(r2, r0, r1)
            r1 = 6
            r8.startActivityForResult(r0, r1)
            goto L_0x0072
        L_0x0059:
            android.content.Context r1 = r8.getContext()
            android.content.Intent r0 = com.firebase.p119ui.auth.p124ui.email.RegisterEmailActivity.m8300a(r1, r0)
            r1 = 5
            r8.startActivityForResult(r0, r1)
            goto L_0x0072
        L_0x0066:
            android.content.Context r1 = r8.getContext()
            android.content.Intent r0 = com.firebase.p119ui.auth.p124ui.idp.AuthMethodPickerActivity.m8346a(r1, r0)
            r1 = 4
            r8.startActivityForResult(r0, r1)
        L_0x0072:
            com.firebase.ui.auth.ui.f r0 = r8.mo11882d()
            r0.mo11907a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.p119ui.auth.p121b.p123b.C2025c.m8221h():void");
    }

    /* renamed from: a */
    private void m8215a(String str, String str2) {
        final C2034c a = new C2036a(new C2039a("password", str).mo11865a()).mo11848a();
        mo11881c().mo11815a().signInWithEmailAndPassword(str, str2).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            /* renamed from: a */
            public void onSuccess(AuthResult authResult) {
                C2025c.this.mo11832a(-1, a.mo11835a());
            }
        }).addOnFailureListener(new C2077g("SignInDelegate", "Error signing in with email and password")).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                if ((exc instanceof FirebaseAuthInvalidUserException) || (exc instanceof FirebaseAuthInvalidCredentialsException)) {
                    C2025c.this.m8222i();
                } else {
                    C2025c.this.m8221h();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m8222i() {
        if (this.f6268b == null) {
            Log.w("SignInDelegate", "deleteCredentialAndRedirect: null credential");
            m8221h();
            return;
        }
        C2030c.m8228a(getActivity()).mo11833a(this.f6268b).addOnCompleteListener(new OnCompleteListener<Status>() {
            public void onComplete(Task<Status> task) {
                if (!task.isSuccessful()) {
                    Log.w("SignInDelegate", "deleteCredential:failure", task.getException());
                }
                C2025c.this.m8221h();
            }
        });
    }

    /* renamed from: b */
    private void m8217b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            startActivityForResult(RegisterEmailActivity.m8301a(getContext(), mo11880b(), str), 5);
            return;
        }
        if (str2.equals(IdentityProviders.GOOGLE) || str2.equals(IdentityProviders.FACEBOOK) || str2.equals(IdentityProviders.TWITTER)) {
            C2023a.m8203a(getActivity(), mo11880b(), new C2039a(C2029d.m8226b(str2), str).mo11865a());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown provider: ");
            sb.append(str2);
            Log.w("SignInDelegate", sb.toString());
            startActivityForResult(AuthMethodPickerActivity.m8346a(getContext(), mo11880b()), 3);
            mo11882d().mo11907a();
        }
    }
}
