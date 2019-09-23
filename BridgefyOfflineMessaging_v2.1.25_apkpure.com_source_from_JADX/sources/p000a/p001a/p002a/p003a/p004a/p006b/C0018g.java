package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: a.a.a.a.a.b.g */
/* compiled from: ApiKey */
public class C0018g {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo39a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    /* renamed from: a */
    public String mo40a(Context context) {
        String b = mo41b(context);
        if (TextUtils.isEmpty(b)) {
            b = mo42c(context);
        }
        if (TextUtils.isEmpty(b)) {
            mo43d(context);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo41b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            if (string != null) {
                return string;
            }
            try {
                C0135c.m449h().mo270a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e) {
                e = e;
                str = string;
                StringBuilder sb = new StringBuilder();
                sb.append("Caught non-fatal exception while retrieving apiKey: ");
                sb.append(e);
                C0135c.m449h().mo270a("Fabric", sb.toString());
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Caught non-fatal exception while retrieving apiKey: ");
            sb2.append(e);
            C0135c.m449h().mo270a("Fabric", sb2.toString());
            return str;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo42c(Context context) {
        int a = C0020i.m53a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C0135c.m449h().mo270a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = C0020i.m53a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo43d(Context context) {
        if (C0135c.m450i() || C0020i.m88i(context)) {
            throw new IllegalArgumentException(mo39a());
        }
        C0135c.m449h().mo279e("Fabric", mo39a());
    }
}
