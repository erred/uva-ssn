package com.mikepenz.iconics.p128a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* renamed from: com.mikepenz.iconics.a.c */
/* compiled from: IconicsContextWrapper */
public class C2986c extends ContextWrapper {

    /* renamed from: a */
    private LayoutInflater f7788a;

    private C2986c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static ContextWrapper m8809a(Context context) {
        return new C2986c(context);
    }

    public Resources getResources() {
        return super.getResources();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.f7788a == null) {
            this.f7788a = new C2989e(LayoutInflater.from(getBaseContext()), this, false);
        }
        return this.f7788a;
    }
}
