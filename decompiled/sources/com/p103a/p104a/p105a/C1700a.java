package com.p103a.p104a.p105a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0023j.C0024a;
import p000a.p001a.p002a.p003a.p004a.p012g.C0123q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0128t;

/* renamed from: com.a.a.a.a */
/* compiled from: Answers */
public class C1700a extends C0146i<Boolean> {

    /* renamed from: a */
    C1725q f5343a;

    /* renamed from: a */
    public String mo309a() {
        return "1.3.13.dev";
    }

    /* renamed from: b */
    public String mo312b() {
        return "com.crashlytics.sdk.android:answers";
    }

    /* renamed from: a */
    public void mo6943a(C0024a aVar) {
        if (this.f5343a != null) {
            this.f5343a.mo6984a(aVar.mo47a(), aVar.mo48b());
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    /* renamed from: b_ */
    public boolean mo315b_() {
        long lastModified;
        try {
            Context q = mo320q();
            PackageManager packageManager = q.getPackageManager();
            String packageName = q.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                lastModified = packageInfo.firstInstallTime;
            } else {
                lastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f5343a = C1725q.m7215a(this, q, mo319p(), num, str, lastModified);
            this.f5343a.mo6985b();
            return true;
        } catch (Exception e) {
            C0135c.m449h().mo280e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Boolean mo317e() {
        try {
            C0128t b = C0123q.m412a().mo264b();
            if (b == null) {
                C0135c.m449h().mo279e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f291d.f260d) {
                C0135c.m449h().mo270a("Answers", "Analytics collection enabled");
                this.f5343a.mo6982a(b.f292e, mo6945f());
                return Boolean.valueOf(true);
            } else {
                C0135c.m449h().mo270a("Answers", "Analytics collection disabled");
                this.f5343a.mo6986c();
                return Boolean.valueOf(false);
            }
        } catch (Exception e) {
            C0135c.m449h().mo280e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo6945f() {
        return C0020i.m77b(mo320q(), "com.crashlytics.ApiEndpoint");
    }
}
