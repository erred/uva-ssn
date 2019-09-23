package com.firebase.p119ui.auth.p124ui.email;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.firebase.p119ui.auth.p124ui.C2040a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.firebase.p119ui.auth.p124ui.email.p125a.C2063b;
import com.firebase.ui.auth.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

/* renamed from: com.firebase.ui.auth.ui.email.RecoverPasswordActivity */
public class RecoverPasswordActivity extends C2040a implements OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f6332a;

    /* renamed from: b */
    private C2063b f6333b;

    /* renamed from: a */
    public static Intent m8296a(Context context, C2048b bVar, String str) {
        return C2051d.m8287a(context, RecoverPasswordActivity.class, bVar).putExtra("extra_email", str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_forgot_password_layout);
        this.f6333b = new C2063b((TextInputLayout) findViewById(R.id.email_layout));
        this.f6332a = (EditText) findViewById(R.id.email);
        String stringExtra = getIntent().getStringExtra("extra_email");
        if (stringExtra != null) {
            this.f6332a.setText(stringExtra);
        }
        findViewById(R.id.button_done).setOnClickListener(this);
    }

    /* renamed from: a */
    private void m8298a(final String str) {
        mo11887c().mo11815a().sendPasswordResetEmail(str).addOnFailureListener(new C2077g("RecoverPasswordActivity", "Error sending password reset email")).addOnSuccessListener(new OnSuccessListener<Void>() {
            /* renamed from: a */
            public void onSuccess(Void voidR) {
                RecoverPasswordActivity.this.mo11888d().mo11907a();
                C2068c.m8330a(str, RecoverPasswordActivity.this.getSupportFragmentManager());
            }
        }).addOnFailureListener((Activity) this, (OnFailureListener) new OnFailureListener() {
            public void onFailure(Exception exc) {
                RecoverPasswordActivity.this.mo11888d().mo11907a();
                if (exc instanceof FirebaseAuthInvalidUserException) {
                    RecoverPasswordActivity.this.f6332a.setError(RecoverPasswordActivity.this.getString(R.string.fui_error_email_does_not_exist));
                }
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button_done && this.f6333b.mo11898b(this.f6332a.getText())) {
            mo11888d().mo11908a(R.string.fui_progress_dialog_sending);
            m8298a(this.f6332a.getText().toString());
        }
    }
}
