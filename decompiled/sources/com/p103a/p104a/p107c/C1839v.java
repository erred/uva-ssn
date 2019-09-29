package com.p103a.p104a.p107c;

import android.content.Context;
import android.os.Bundle;

/* renamed from: com.a.a.c.v */
/* compiled from: ManifestUnityVersionProvider */
class C1839v implements C1771ak {

    /* renamed from: a */
    private final Context f5670a;

    /* renamed from: b */
    private final String f5671b;

    public C1839v(Context context, String str) {
        this.f5670a = context;
        this.f5671b = str;
    }

    /* renamed from: a */
    public String mo7035a() {
        try {
            Bundle bundle = this.f5670a.getPackageManager().getApplicationInfo(this.f5671b, 128).metaData;
            if (bundle != null) {
                return bundle.getString("io.fabric.unity.crashlytics.version");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
