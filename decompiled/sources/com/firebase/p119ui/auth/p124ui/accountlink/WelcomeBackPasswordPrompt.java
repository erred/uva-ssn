package com.firebase.p119ui.auth.p124ui.accountlink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2034c.C2036a;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p120a.C2012g;
import com.firebase.p119ui.auth.p121b.p122a.C2018a;
import com.firebase.p119ui.auth.p121b.p123b.C2024b;
import com.firebase.p119ui.auth.p124ui.C2040a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.C2052e;
import com.firebase.p119ui.auth.p124ui.C2052e.C2054a;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.firebase.p119ui.auth.p124ui.email.RecoverPasswordActivity;
import com.firebase.ui.auth.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

/* renamed from: com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt */
public class WelcomeBackPasswordPrompt extends C2040a implements OnClickListener, C2054a {

    /* renamed from: a */
    private String f6305a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextInputLayout f6306b;

    /* renamed from: c */
    private EditText f6307c;

    /* renamed from: d */
    private C2034c f6308d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2024b f6309e;

    /* renamed from: a */
    public static Intent m8269a(Context context, C2048b bVar, C2034c cVar) {
        return C2051d.m8287a(context, WelcomeBackPasswordPrompt.class, bVar).putExtra("extra_idp_response", cVar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_welcome_back_password_prompt_layout);
        getWindow().setSoftInputMode(4);
        this.f6309e = mo11887c().mo11814a(this);
        this.f6308d = C2034c.m8235a(getIntent());
        this.f6305a = this.f6308d.mo11838d();
        this.f6306b = (TextInputLayout) findViewById(R.id.password_layout);
        this.f6307c = (EditText) findViewById(R.id.password);
        C2052e.m8294a(this.f6307c, this);
        String string = getString(R.string.fui_welcome_back_password_prompt_body, new Object[]{this.f6305a});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(this.f6305a);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, this.f6305a.length() + indexOf, 18);
        ((TextView) findViewById(R.id.welcome_back_password_body)).setText(spannableStringBuilder);
        findViewById(R.id.button_done).setOnClickListener(this);
        findViewById(R.id.trouble_signing_in).setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_done) {
            m8273e();
        } else if (id == R.id.trouble_signing_in) {
            startActivity(RecoverPasswordActivity.m8296a(this, mo11886b(), this.f6305a));
            mo11883a(0, C2034c.m8234a(20));
        }
    }

    /* renamed from: a */
    public void mo11808a() {
        m8273e();
    }

    /* renamed from: e */
    private void m8273e() {
        m8271a(this.f6305a, this.f6307c.getText().toString());
    }

    /* renamed from: a */
    private void m8271a(String str, final String str2) {
        final C2034c cVar;
        if (TextUtils.isEmpty(str2)) {
            this.f6306b.setError(getString(R.string.fui_required_field));
            return;
        }
        this.f6306b.setError(null);
        mo11888d().mo11908a(R.string.fui_progress_dialog_signing_in);
        final AuthCredential a = C2012g.m8175a(this.f6308d);
        if (a == null) {
            cVar = new C2036a(new C2039a("password", str).mo11865a()).mo11848a();
        } else {
            cVar = new C2036a(this.f6308d.mo11836b()).mo11847a(this.f6308d.mo11840e()).mo11849b(this.f6308d.mo11841f()).mo11848a();
        }
        mo11887c().mo11815a().signInWithEmailAndPassword(str, str2).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            /* renamed from: a */
            public void onSuccess(AuthResult authResult) {
                if (a == null) {
                    WelcomeBackPasswordPrompt.this.mo11885a(WelcomeBackPasswordPrompt.this.f6309e, authResult.getUser(), str2, cVar);
                    return;
                }
                Task continueWithTask = authResult.getUser().linkWithCredential(a).continueWithTask(new C2018a(cVar));
                StringBuilder sb = new StringBuilder();
                sb.append("Error signing in with credential ");
                sb.append(a.getProvider());
                continueWithTask.addOnFailureListener(new C2077g("WelcomeBackPassword", sb.toString())).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    /* renamed from: a */
                    public void onSuccess(AuthResult authResult) {
                        WelcomeBackPasswordPrompt.this.mo11884a(WelcomeBackPasswordPrompt.this.f6309e, authResult.getUser(), cVar);
                    }
                });
            }
        }).addOnFailureListener(new C2077g("WelcomeBackPassword", "Error signing in with email and password")).addOnFailureListener((Activity) this, (OnFailureListener) new OnFailureListener() {
            public void onFailure(Exception exc) {
                WelcomeBackPasswordPrompt.this.mo11888d().mo11907a();
                WelcomeBackPasswordPrompt.this.f6306b.setError(exc.getLocalizedMessage());
            }
        });
    }
}
