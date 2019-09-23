package com.firebase.p119ui.auth.p124ui.email.p125a;

import com.google.android.material.textfield.TextInputLayout;

/* renamed from: com.firebase.ui.auth.ui.email.a.a */
/* compiled from: BaseValidator */
public class C2062a {

    /* renamed from: a */
    protected TextInputLayout f6348a;

    /* renamed from: b */
    protected String f6349b = "";

    /* renamed from: c */
    protected String f6350c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11897a(CharSequence charSequence) {
        return true;
    }

    public C2062a(TextInputLayout textInputLayout) {
        this.f6348a = textInputLayout;
    }

    /* renamed from: b */
    public boolean mo11898b(CharSequence charSequence) {
        if (this.f6350c != null && (charSequence == null || charSequence.length() == 0)) {
            this.f6348a.setError(this.f6350c);
            return false;
        } else if (mo11897a(charSequence)) {
            this.f6348a.setError("");
            return true;
        } else {
            this.f6348a.setError(this.f6349b);
            return false;
        }
    }
}
