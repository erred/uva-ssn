package com.p103a.p104a.p106b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p005a.C0005b;
import p000a.p001a.p002a.p003a.p004a.p005a.C0007d;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0027m;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o.C0033a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0042s;
import p000a.p001a.p002a.p003a.p004a.p010e.C0087b;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;
import p000a.p001a.p002a.p003a.p004a.p012g.C0112f;
import p000a.p001a.p002a.p003a.p004a.p012g.C0123q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0128t;

/* renamed from: com.a.a.b.c */
/* compiled from: Beta */
public class C1738c extends C0146i<Boolean> implements C0027m {

    /* renamed from: a */
    private final C0005b<String> f5458a = new C0005b<>();

    /* renamed from: b */
    private final C1743h f5459b = new C1743h();

    /* renamed from: c */
    private C1745j f5460c;

    /* renamed from: a */
    public String mo309a() {
        return "1.2.5.dev";
    }

    /* renamed from: b */
    public String mo312b() {
        return "com.crashlytics.sdk.android:beta";
    }

    /* access modifiers changed from: protected */
    @TargetApi(14)
    /* renamed from: b_ */
    public boolean mo315b_() {
        this.f5460c = mo7003a(VERSION.SDK_INT, (Application) mo320q().getApplicationContext());
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Boolean mo317e() {
        C0135c.m449h().mo270a("Beta", "Beta kit initializing...");
        Context q = mo320q();
        C0032o p = mo319p();
        if (TextUtils.isEmpty(m7249a(q, p.mo63j()))) {
            C0135c.m449h().mo270a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C0135c.m449h().mo270a("Beta", "Beta device token is present, checking for app updates.");
        C0112f h = m7250h();
        C1739d a = m7248a(q);
        if (mo7004a(h, a)) {
            this.f5460c.mo6997a(q, this, p, h, a, new C0106d(this), new C0042s(), new C0087b(C0135c.m449h()));
        }
        return Boolean.valueOf(true);
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(14)
    /* renamed from: a */
    public C1745j mo7003a(int i, Application application) {
        if (i >= 14) {
            return new C1735b(mo321r().mo289e(), mo321r().mo290f());
        }
        return new C1744i();
    }

    /* renamed from: f */
    public Map<C0033a, String> mo52f() {
        String a = m7249a(mo320q(), mo319p().mo63j());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(C0033a.FONT_TOKEN, a);
        }
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7004a(C0112f fVar, C1739d dVar) {
        return (fVar == null || TextUtils.isEmpty(fVar.f247a) || dVar == null) ? false : true;
    }

    /* renamed from: a */
    private String m7249a(Context context, String str) {
        String str2 = null;
        try {
            String str3 = (String) this.f5458a.mo18a(context, (C0007d<T>) this.f5459b);
            if (!"".equals(str3)) {
                str2 = str3;
            }
        } catch (Exception e) {
            C0135c.m449h().mo280e("Beta", "Failed to load the Beta device token", e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Beta device token present: ");
        sb.append(!TextUtils.isEmpty(str2));
        C0135c.m449h().mo270a("Beta", sb.toString());
        return str2;
    }

    /* renamed from: h */
    private C0112f m7250h() {
        C0128t b = C0123q.m412a().mo264b();
        if (b != null) {
            return b.f293f;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078 A[SYNTHETIC, Splitter:B:24:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d A[SYNTHETIC, Splitter:B:31:0x008d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.p103a.p104a.p106b.C1739d m7248a(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 0
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            java.lang.String r1 = "crashlytics-build.properties"
            java.io.InputStream r7 = r7.open(r1)     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            if (r7 == 0) goto L_0x004f
            com.a.a.b.d r1 = com.p103a.p104a.p106b.C1739d.m7260a(r7)     // Catch:{ Exception -> 0x004a }
            a.a.a.a.l r0 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r2 = "Beta"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048 }
            r3.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = r1.f5464d     // Catch:{ Exception -> 0x0048 }
            r3.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = " build properties: "
            r3.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = r1.f5462b     // Catch:{ Exception -> 0x0048 }
            r3.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = " ("
            r3.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = r1.f5461a     // Catch:{ Exception -> 0x0048 }
            r3.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = ") - "
            r3.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = r1.f5463c     // Catch:{ Exception -> 0x0048 }
            r3.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0048 }
            r0.mo270a(r2, r3)     // Catch:{ Exception -> 0x0048 }
            r0 = r1
            goto L_0x004f
        L_0x0048:
            r0 = move-exception
            goto L_0x006b
        L_0x004a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x006b
        L_0x004f:
            if (r7 == 0) goto L_0x0089
            r7.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0089
        L_0x0055:
            r7 = move-exception
            a.a.a.a.l r1 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r2 = "Beta"
            java.lang.String r3 = "Error closing Beta build properties asset"
            r1.mo280e(r2, r3, r7)
            goto L_0x0089
        L_0x0062:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x008b
        L_0x0067:
            r7 = move-exception
            r1 = r0
            r0 = r7
            r7 = r1
        L_0x006b:
            a.a.a.a.l r2 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x008a }
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error reading Beta build properties"
            r2.mo280e(r3, r4, r0)     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x0088
            r7.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0088
        L_0x007c:
            r7 = move-exception
            a.a.a.a.l r0 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r2 = "Beta"
            java.lang.String r3 = "Error closing Beta build properties asset"
            r0.mo280e(r2, r3, r7)
        L_0x0088:
            r0 = r1
        L_0x0089:
            return r0
        L_0x008a:
            r0 = move-exception
        L_0x008b:
            if (r7 == 0) goto L_0x009d
            r7.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x009d
        L_0x0091:
            r7 = move-exception
            a.a.a.a.l r1 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r2 = "Beta"
            java.lang.String r3 = "Error closing Beta build properties asset"
            r1.mo280e(r2, r3, r7)
        L_0x009d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p103a.p104a.p106b.C1738c.m7248a(android.content.Context):com.a.a.b.d");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo7006g() {
        return C0020i.m77b(mo320q(), "com.crashlytics.ApiEndpoint");
    }
}
