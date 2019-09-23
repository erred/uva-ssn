package com.firebase.p119ui.auth.p124ui.accountlink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.p119ui.auth.C2001a.C2003a;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2037d;
import com.firebase.p119ui.auth.p120a.C2006b;
import com.firebase.p119ui.auth.p120a.C2007c;
import com.firebase.p119ui.auth.p120a.C2008d;
import com.firebase.p119ui.auth.p120a.C2008d.C2009a;
import com.firebase.p119ui.auth.p120a.C2012g;
import com.firebase.p119ui.auth.p120a.C2014h;
import com.firebase.p119ui.auth.p124ui.C2040a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.firebase.ui.auth.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

/* renamed from: com.firebase.ui.auth.ui.accountlink.WelcomeBackIdpPrompt */
public class WelcomeBackIdpPrompt extends C2040a implements C2009a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2008d f6297a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AuthCredential f6298b;

    /* renamed from: com.firebase.ui.auth.ui.accountlink.WelcomeBackIdpPrompt$a */
    private class C2044a implements OnCompleteListener<AuthResult> {

        /* renamed from: b */
        private final C2034c f6304b;

        C2044a(C2034c cVar) {
            this.f6304b = cVar;
        }

        public void onComplete(Task task) {
            WelcomeBackIdpPrompt.this.mo11883a(-1, this.f6304b.mo11835a());
        }
    }

    /* renamed from: a */
    public static Intent m8260a(Context context, C2048b bVar, C2037d dVar, C2034c cVar) {
        return C2051d.m8287a(context, WelcomeBackIdpPrompt.class, bVar).putExtra("extra_user", dVar).putExtra("extra_idp_response", cVar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_welcome_back_idp_prompt_layout);
        C2034c a = C2034c.m8235a(getIntent());
        if (a != null) {
            this.f6298b = C2012g.m8175a(a);
        }
        C2037d a2 = C2037d.m8247a(getIntent());
        String a3 = a2.mo11850a();
        for (C2003a aVar : mo11886b().f6317b) {
            if (a3.equals(aVar.mo11789a())) {
                char c = 65535;
                int hashCode = a3.hashCode();
                if (hashCode != -1830313082) {
                    if (hashCode != -1536293812) {
                        if (hashCode == -364826023 && a3.equals("facebook.com")) {
                            c = 1;
                        }
                    } else if (a3.equals("google.com")) {
                        c = 0;
                    }
                } else if (a3.equals("twitter.com")) {
                    c = 2;
                }
                switch (c) {
                    case 0:
                        this.f6297a = new C2007c(this, aVar, a2.mo11851b());
                        break;
                    case 1:
                        this.f6297a = new C2006b(aVar, mo11886b().f6318c);
                        break;
                    case 2:
                        this.f6297a = new C2014h(this);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown provider: ");
                        sb.append(a3);
                        Log.w("WelcomeBackIdpPrompt", sb.toString());
                        mo11883a(0, C2034c.m8234a(20));
                        return;
                }
            }
        }
        if (this.f6297a == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Firebase login unsuccessful. Account linking failed due to provider not enabled by application: ");
            sb2.append(a3);
            Log.w("WelcomeBackIdpPrompt", sb2.toString());
            mo11883a(0, C2034c.m8234a(20));
            return;
        }
        ((TextView) findViewById(R.id.welcome_back_idp_prompt)).setText(m8262a(a2.mo11851b()));
        this.f6297a.mo11805a(this);
        findViewById(R.id.welcome_back_idp_button).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelcomeBackIdpPrompt.this.mo11888d().mo11908a(R.string.fui_progress_dialog_signing_in);
                WelcomeBackIdpPrompt.this.f6297a.mo11804a((Activity) WelcomeBackIdpPrompt.this);
            }
        });
    }

    /* renamed from: a */
    private String m8262a(String str) {
        return getString(R.string.fui_welcome_back_idp_prompt, new Object[]{str, this.f6297a.mo11802a((Context) this)});
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f6297a.mo11803a(i, i2, intent);
    }

    /* renamed from: a */
    public void mo11809a(final C2034c cVar) {
        AuthCredential a = C2012g.m8175a(cVar);
        if (a == null) {
            Log.e("WelcomeBackIdpPrompt", "No credential returned");
            mo11883a(0, C2034c.m8234a(20));
            return;
        }
        FirebaseUser c = mo11887c().mo11817c();
        if (c == null) {
            Task addOnFailureListener = mo11887c().mo11815a().signInWithCredential(a).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                /* renamed from: a */
                public void onSuccess(AuthResult authResult) {
                    if (WelcomeBackIdpPrompt.this.f6298b != null) {
                        Task linkWithCredential = authResult.getUser().linkWithCredential(WelcomeBackIdpPrompt.this.f6298b);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error signing in with previous credential ");
                        sb.append(cVar.mo11837c());
                        linkWithCredential.addOnFailureListener(new C2077g("WelcomeBackIdpPrompt", sb.toString())).addOnCompleteListener(new C2044a(cVar));
                        return;
                    }
                    WelcomeBackIdpPrompt.this.mo11883a(-1, cVar.mo11835a());
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    WelcomeBackIdpPrompt.this.m8265e();
                }
            });
            StringBuilder sb = new StringBuilder();
            sb.append("Error signing in with new credential ");
            sb.append(cVar.mo11837c());
            addOnFailureListener.addOnFailureListener(new C2077g("WelcomeBackIdpPrompt", sb.toString()));
        } else {
            Task linkWithCredential = c.linkWithCredential(a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error linking with credential ");
            sb2.append(cVar.mo11837c());
            linkWithCredential.addOnFailureListener(new C2077g("WelcomeBackIdpPrompt", sb2.toString())).addOnCompleteListener(new C2044a(cVar));
        }
    }

    /* renamed from: a */
    public void mo11808a() {
        m8265e();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8265e() {
        Toast.makeText(this, R.string.fui_general_error, 1).show();
        mo11883a(0, C2034c.m8234a(20));
    }
}
