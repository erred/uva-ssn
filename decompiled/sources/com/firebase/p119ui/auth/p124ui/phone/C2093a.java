package com.firebase.p119ui.auth.p124ui.phone;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Collections;

/* renamed from: com.firebase.ui.auth.ui.phone.a */
/* compiled from: BucketedTextChangeListener */
final class C2093a implements TextWatcher {

    /* renamed from: a */
    private final EditText f6430a;

    /* renamed from: b */
    private final C2094a f6431b;

    /* renamed from: c */
    private final String[] f6432c;

    /* renamed from: d */
    private final String f6433d;

    /* renamed from: e */
    private final int f6434e;

    /* renamed from: com.firebase.ui.auth.ui.phone.a$a */
    /* compiled from: BucketedTextChangeListener */
    interface C2094a {
        /* renamed from: a */
        void mo11939a();

        /* renamed from: b */
        void mo11940b();
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C2093a(EditText editText, int i, String str, C2094a aVar) {
        this.f6430a = editText;
        this.f6434e = i;
        this.f6432c = m8399a(str, i);
        this.f6431b = aVar;
        this.f6433d = str;
    }

    @SuppressLint({"SetTextI18n"})
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String replaceAll = charSequence.toString().replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "").replaceAll(this.f6433d, "");
        int min = Math.min(replaceAll.length(), this.f6434e);
        String substring = replaceAll.substring(0, min);
        this.f6430a.removeTextChangedListener(this);
        EditText editText = this.f6430a;
        StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append(this.f6432c[this.f6434e - min]);
        editText.setText(sb.toString());
        this.f6430a.setSelection(min);
        this.f6430a.addTextChangedListener(this);
        if (min == this.f6434e && this.f6431b != null) {
            this.f6431b.mo11939a();
        } else if (this.f6431b != null) {
            this.f6431b.mo11940b();
        }
    }

    /* renamed from: a */
    private String[] m8399a(CharSequence charSequence, int i) {
        String[] strArr = new String[(i + 1)];
        for (int i2 = 0; i2 <= i; i2++) {
            strArr[i2] = TextUtils.join("", Collections.nCopies(i2, charSequence));
        }
        return strArr;
    }
}
