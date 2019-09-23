package com.firebase.p119ui.auth.p120a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.email.RegisterEmailActivity;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.a.a */
/* compiled from: EmailProvider */
public class C2005a implements C2011f {

    /* renamed from: a */
    private Activity f6195a;

    /* renamed from: b */
    private C2048b f6196b;

    public C2005a(Activity activity, C2048b bVar) {
        this.f6195a = activity;
        this.f6196b = bVar;
    }

    /* renamed from: a */
    public String mo11802a(Context context) {
        return context.getString(R.string.fui_provider_name_email);
    }

    /* renamed from: a */
    public int mo11801a() {
        return R.layout.fui_provider_button_email;
    }

    /* renamed from: a */
    public void mo11804a(Activity activity) {
        activity.startActivityForResult(RegisterEmailActivity.m8300a(activity, this.f6196b), 2);
    }

    /* renamed from: a */
    public void mo11803a(int i, int i2, Intent intent) {
        if (i == 2 && i2 == -1) {
            this.f6195a.setResult(-1, intent);
            this.f6195a.finish();
        }
    }
}
