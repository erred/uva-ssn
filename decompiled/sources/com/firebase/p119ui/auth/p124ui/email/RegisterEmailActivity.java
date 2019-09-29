package com.firebase.p119ui.auth.p124ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.p081a.C1104o;
import com.firebase.p119ui.auth.C2034c.C2036a;
import com.firebase.p119ui.auth.C2037d;
import com.firebase.p119ui.auth.p124ui.C2040a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.accountlink.WelcomeBackIdpPrompt;
import com.firebase.p119ui.auth.p124ui.accountlink.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: com.firebase.ui.auth.ui.email.RegisterEmailActivity */
public class RegisterEmailActivity extends C2040a implements C2061a {
    /* renamed from: a */
    public static Intent m8300a(Context context, C2048b bVar) {
        return m8301a(context, bVar, null);
    }

    /* renamed from: a */
    public static Intent m8301a(Context context, C2048b bVar, String str) {
        return C2051d.m8287a(context, RegisterEmailActivity.class, bVar).putExtra("extra_email", str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_activity_register_email);
        if (bundle == null) {
            getSupportFragmentManager().mo4370a().mo4079b(R.id.fragment_register_email, C2057a.m8307a(mo11886b(), getIntent().getExtras().getString("extra_email")), "CheckEmailFragment").mo4065a().mo4084c();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 17:
            case 18:
                mo11883a(i2, intent);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo11892a(C2037d dVar) {
        startActivityForResult(WelcomeBackPasswordPrompt.m8269a(this, mo11886b(), new C2036a(dVar).mo11848a()), 17);
        m8302a();
    }

    /* renamed from: b */
    public void mo11893b(C2037d dVar) {
        startActivityForResult(WelcomeBackIdpPrompt.m8260a(this, mo11886b(), dVar, null), 18);
        m8302a();
    }

    /* renamed from: c */
    public void mo11894c(C2037d dVar) {
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.email_layout);
        if (mo11886b().f6322g) {
            C1104o b = getSupportFragmentManager().mo4370a().mo4079b(R.id.fragment_register_email, C2070d.m8331a(mo11886b(), dVar), "RegisterEmailFragment");
            if (textInputLayout != null) {
                b.mo4067a((View) textInputLayout, "email_field");
            }
            b.mo4065a().mo4084c();
            return;
        }
        textInputLayout.setError(getString(R.string.fui_error_email_does_not_exist));
    }

    /* renamed from: a */
    private void m8302a() {
        overridePendingTransition(R.anim.fui_slide_in_right, R.anim.fui_slide_out_left);
    }
}
