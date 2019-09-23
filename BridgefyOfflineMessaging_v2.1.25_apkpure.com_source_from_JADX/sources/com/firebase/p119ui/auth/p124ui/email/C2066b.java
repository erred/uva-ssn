package com.firebase.p119ui.auth.p124ui.email;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.browser.p053a.C0731a;
import androidx.browser.p053a.C0731a.C0732a;
import androidx.core.content.C0875a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.ui.email.b */
/* compiled from: PreambleHandler */
public class C2066b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f6352a;

    /* renamed from: b */
    private final C2048b f6353b;

    /* renamed from: c */
    private final int f6354c;

    /* renamed from: d */
    private final ForegroundColorSpan f6355d = new ForegroundColorSpan(C0875a.m3248c(this.f6352a, R.color.fui_linkColor));

    /* renamed from: e */
    private SpannableStringBuilder f6356e;

    /* renamed from: com.firebase.ui.auth.ui.email.b$a */
    /* compiled from: PreambleHandler */
    private class C2067a extends ClickableSpan {

        /* renamed from: b */
        private final String f6358b;

        /* renamed from: c */
        private final C0731a f6359c;

        public C2067a(String str) {
            this.f6358b = str;
            TypedValue typedValue = new TypedValue();
            C2066b.this.f6352a.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            this.f6359c = new C0732a().mo2909a(typedValue.data).mo2910a(true).mo2911a();
        }

        public void onClick(View view) {
            this.f6359c.mo2908a(C2066b.this.f6352a, Uri.parse(this.f6358b));
        }
    }

    public C2066b(Context context, C2048b bVar, int i) {
        this.f6352a = context;
        this.f6353b = bVar;
        this.f6354c = i;
        m8323a();
    }

    /* renamed from: a */
    public void mo11899a(TextView textView) {
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(this.f6356e);
    }

    /* renamed from: a */
    private void m8323a() {
        String b = m8326b();
        if (b != null) {
            this.f6356e = new SpannableStringBuilder(b);
            m8324a("%BTN%", this.f6354c);
            m8325a("%TOS%", R.string.fui_terms_of_service, this.f6353b.f6320e);
            m8325a("%PP%", R.string.fui_privacy_policy, this.f6353b.f6321f);
        }
    }

    /* renamed from: a */
    private void m8324a(String str, int i) {
        int indexOf = this.f6356e.toString().indexOf(str);
        if (indexOf != -1) {
            this.f6356e.replace(indexOf, str.length() + indexOf, this.f6352a.getString(i));
        }
    }

    /* renamed from: a */
    private void m8325a(String str, int i, String str2) {
        int indexOf = this.f6356e.toString().indexOf(str);
        if (indexOf != -1) {
            String string = this.f6352a.getString(i);
            this.f6356e.replace(indexOf, str.length() + indexOf, string);
            int length = string.length() + indexOf;
            this.f6356e.setSpan(this.f6355d, indexOf, length, 0);
            this.f6356e.setSpan(new C2067a(str2), indexOf, length, 0);
        }
    }

    /* renamed from: b */
    private String m8326b() {
        boolean z = !TextUtils.isEmpty(this.f6353b.f6320e);
        boolean z2 = !TextUtils.isEmpty(this.f6353b.f6321f);
        if (z && z2) {
            return this.f6352a.getString(R.string.fui_create_account_preamble_tos_and_pp, new Object[]{"%BTN%", "%TOS%", "%PP%"});
        } else if (z) {
            return this.f6352a.getString(R.string.fui_create_account_preamble_tos_only, new Object[]{"%BTN%", "%TOS%"});
        } else if (!z2) {
            return null;
        } else {
            return this.f6352a.getString(R.string.fui_create_account_preamble_pp_only, new Object[]{"%BTN%", "%PP%"});
        }
    }
}
