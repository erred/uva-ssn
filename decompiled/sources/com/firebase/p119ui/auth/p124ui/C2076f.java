package com.firebase.p119ui.auth.p124ui;

import android.app.ProgressDialog;
import android.content.Context;

/* renamed from: com.firebase.ui.auth.ui.f */
/* compiled from: ProgressDialogHolder */
public class C2076f {

    /* renamed from: a */
    private Context f6382a;

    /* renamed from: b */
    private ProgressDialog f6383b;

    public C2076f(Context context) {
        this.f6382a = context;
    }

    /* renamed from: a */
    private void m8342a(String str) {
        mo11907a();
        if (this.f6383b == null) {
            this.f6383b = new ProgressDialog(this.f6382a);
            this.f6383b.setIndeterminate(true);
            this.f6383b.setTitle("");
        }
        this.f6383b.setMessage(str);
        this.f6383b.show();
    }

    /* renamed from: a */
    public void mo11908a(int i) {
        m8342a(this.f6382a.getString(i));
    }

    /* renamed from: a */
    public void mo11907a() {
        if (this.f6383b != null) {
            this.f6383b.dismiss();
            this.f6383b = null;
        }
    }

    /* renamed from: b */
    public boolean mo11909b() {
        return this.f6383b != null && this.f6383b.isShowing();
    }
}
