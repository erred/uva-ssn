package com.firebase.p119ui.auth.p124ui.email.p125a;

import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: com.firebase.ui.auth.ui.email.a.c */
/* compiled from: PasswordFieldValidator */
public class C2064c extends C2062a {

    /* renamed from: d */
    private int f6351d;

    public C2064c(TextInputLayout textInputLayout, int i) {
        super(textInputLayout);
        this.f6351d = i;
        this.f6349b = this.f6348a.getResources().getQuantityString(R.plurals.fui_error_weak_password, this.f6351d, new Object[]{Integer.valueOf(this.f6351d)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11897a(CharSequence charSequence) {
        return charSequence.length() >= this.f6351d;
    }
}
