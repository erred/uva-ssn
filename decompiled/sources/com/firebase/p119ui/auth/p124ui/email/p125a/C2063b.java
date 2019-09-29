package com.firebase.p119ui.auth.p124ui.email.p125a;

import android.util.Patterns;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: com.firebase.ui.auth.ui.email.a.b */
/* compiled from: EmailFieldValidator */
public class C2063b extends C2062a {
    public C2063b(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6349b = this.f6348a.getResources().getString(R.string.fui_invalid_email_address);
        this.f6350c = this.f6348a.getResources().getString(R.string.fui_missing_email_address);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11897a(CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
