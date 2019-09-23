package com.firebase.p119ui.auth.p124ui.email.p125a;

import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: com.firebase.ui.auth.ui.email.a.d */
/* compiled from: RequiredFieldValidator */
public class C2065d extends C2062a {
    public C2065d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6349b = this.f6348a.getResources().getString(R.string.fui_required_field);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11897a(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }
}
