package com.firebase.p117a.p118a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* renamed from: com.firebase.a.a.c */
/* compiled from: StorageHelpers */
public class C1994c {

    /* renamed from: a */
    private final SharedPreferences f6177a;

    public C1994c(Context context) {
        this.f6177a = context.getApplicationContext().getSharedPreferences("com.digits.sdk.android:digits:session_store", 0);
    }

    /* renamed from: a */
    public String mo11773a() {
        if (this.f6177a == null) {
            return null;
        }
        return this.f6177a.getString("active_session", null);
    }

    /* renamed from: a */
    public String mo11774a(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString(str);
            }
            return null;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("not found in manifest. Add it maybe?");
            Log.w("DigitsMigrationhelpers", sb.toString());
            return null;
        }
    }

    /* renamed from: b */
    public void mo11776b() {
        if (this.f6177a != null) {
            this.f6177a.edit().clear().apply();
        }
    }

    /* renamed from: a */
    public String mo11775a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("eyJhbGciOiJub25lIn0=.");
        sb.append(Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 0));
        sb.append(".");
        return sb.toString();
    }
}
