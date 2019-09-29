package com.firebase.p119ui.auth.p120a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.firebase.p119ui.auth.C2001a.C2003a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.phone.PhoneVerificationActivity;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.a.e */
/* compiled from: PhoneProvider */
public class C2010e implements C2011f {

    /* renamed from: a */
    private Activity f6205a;

    /* renamed from: b */
    private C2048b f6206b;

    public C2010e(Activity activity, C2048b bVar) {
        this.f6205a = activity;
        this.f6206b = bVar;
    }

    /* renamed from: a */
    public String mo11802a(Context context) {
        return context.getString(R.string.fui_provider_name_phone);
    }

    /* renamed from: a */
    public int mo11801a() {
        return R.layout.fui_provider_button_phone;
    }

    /* renamed from: a */
    public void mo11804a(Activity activity) {
        Bundle bundle = null;
        for (C2003a aVar : this.f6206b.f6317b) {
            if (aVar.mo11789a().equals("phone")) {
                bundle = aVar.mo11791c();
            }
        }
        activity.startActivityForResult(PhoneVerificationActivity.m8367a((Context) activity, this.f6206b, bundle), 4);
    }

    /* renamed from: a */
    public void mo11803a(int i, int i2, Intent intent) {
        if (i == 4 && i2 == -1) {
            this.f6205a.setResult(-1, intent);
            this.f6205a.finish();
        }
    }
}
