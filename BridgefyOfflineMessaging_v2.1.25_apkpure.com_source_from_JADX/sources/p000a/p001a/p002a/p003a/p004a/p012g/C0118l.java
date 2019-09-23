package p000a.p001a.p002a.p003a.p004a.p012g;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0008a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;

/* renamed from: a.a.a.a.a.g.l */
/* compiled from: DefaultSettingsSpiCall */
class C0118l extends C0008a implements C0132x {
    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo262a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    public C0118l(C0146i iVar, String str, String str2, C0098e eVar) {
        this(iVar, str, str2, eVar, C0089c.GET);
    }

    C0118l(C0146i iVar, String str, String str2, C0098e eVar, C0089c cVar) {
        super(iVar, str, str2, eVar, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject mo261a(p000a.p001a.p002a.p003a.p004a.p012g.C0131w r8) {
        /*
            r7 = this;
            r0 = 0
            java.util.Map r1 = r7.m407b(r8)     // Catch:{ c -> 0x007a, all -> 0x0075 }
            a.a.a.a.a.e.d r2 = r7.mo21a(r1)     // Catch:{ c -> 0x007a, all -> 0x0075 }
            a.a.a.a.a.e.d r8 = r7.m404a(r2, r8)     // Catch:{ c -> 0x0072, all -> 0x006f }
            a.a.a.a.l r2 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ c -> 0x006d }
            java.lang.String r3 = "Fabric"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ c -> 0x006d }
            r4.<init>()     // Catch:{ c -> 0x006d }
            java.lang.String r5 = "Requesting settings from "
            r4.append(r5)     // Catch:{ c -> 0x006d }
            java.lang.String r5 = r7.mo22a()     // Catch:{ c -> 0x006d }
            r4.append(r5)     // Catch:{ c -> 0x006d }
            java.lang.String r4 = r4.toString()     // Catch:{ c -> 0x006d }
            r2.mo270a(r3, r4)     // Catch:{ c -> 0x006d }
            a.a.a.a.l r2 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ c -> 0x006d }
            java.lang.String r3 = "Fabric"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ c -> 0x006d }
            r4.<init>()     // Catch:{ c -> 0x006d }
            java.lang.String r5 = "Settings query params were: "
            r4.append(r5)     // Catch:{ c -> 0x006d }
            r4.append(r1)     // Catch:{ c -> 0x006d }
            java.lang.String r1 = r4.toString()     // Catch:{ c -> 0x006d }
            r2.mo270a(r3, r1)     // Catch:{ c -> 0x006d }
            org.json.JSONObject r1 = r7.mo260a(r8)     // Catch:{ c -> 0x006d }
            if (r8 == 0) goto L_0x006b
            a.a.a.a.l r0 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r2 = "Fabric"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Settings request ID: "
            r3.append(r4)
            java.lang.String r4 = "X-REQUEST-ID"
            java.lang.String r8 = r8.mo201b(r4)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r0.mo270a(r2, r8)
        L_0x006b:
            r0 = r1
            goto L_0x00a9
        L_0x006d:
            r1 = move-exception
            goto L_0x007c
        L_0x006f:
            r0 = move-exception
            r8 = r2
            goto L_0x00ab
        L_0x0072:
            r1 = move-exception
            r8 = r2
            goto L_0x007c
        L_0x0075:
            r8 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto L_0x00ab
        L_0x007a:
            r1 = move-exception
            r8 = r0
        L_0x007c:
            a.a.a.a.l r2 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x00aa }
            java.lang.String r3 = "Fabric"
            java.lang.String r4 = "Settings request failed."
            r2.mo280e(r3, r4, r1)     // Catch:{ all -> 0x00aa }
            if (r8 == 0) goto L_0x00a9
            a.a.a.a.l r1 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r2 = "Fabric"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Settings request ID: "
            r3.append(r4)
            java.lang.String r4 = "X-REQUEST-ID"
            java.lang.String r8 = r8.mo201b(r4)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r1.mo270a(r2, r8)
        L_0x00a9:
            return r0
        L_0x00aa:
            r0 = move-exception
        L_0x00ab:
            if (r8 == 0) goto L_0x00cd
            a.a.a.a.l r1 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Settings request ID: "
            r2.append(r3)
            java.lang.String r3 = "X-REQUEST-ID"
            java.lang.String r8 = r8.mo201b(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.lang.String r2 = "Fabric"
            r1.mo270a(r2, r8)
        L_0x00cd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p012g.C0118l.mo261a(a.a.a.a.a.g.w):org.json.JSONObject");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo260a(C0090d dVar) {
        int b = dVar.mo199b();
        StringBuilder sb = new StringBuilder();
        sb.append("Settings result was: ");
        sb.append(b);
        C0135c.m449h().mo270a("Fabric", sb.toString());
        if (mo262a(b)) {
            return m405a(dVar.mo210e());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to retrieve settings from ");
        sb2.append(mo22a());
        C0135c.m449h().mo279e("Fabric", sb2.toString());
        return null;
    }

    /* renamed from: a */
    private JSONObject m405a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse settings JSON from ");
            sb.append(mo22a());
            C0135c.m449h().mo271a("Fabric", sb.toString(), (Throwable) e);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Settings response ");
            sb2.append(str);
            C0135c.m449h().mo270a("Fabric", sb2.toString());
            return null;
        }
    }

    /* renamed from: b */
    private Map<String, String> m407b(C0131w wVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", wVar.f307j);
        hashMap.put("display_version", wVar.f306i);
        hashMap.put(Param.SOURCE, Integer.toString(wVar.f308k));
        if (wVar.f309l != null) {
            hashMap.put("icon_hash", wVar.f309l);
        }
        String str = wVar.f305h;
        if (!C0020i.m82c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    /* renamed from: a */
    private C0090d m404a(C0090d dVar, C0131w wVar) {
        m406a(dVar, "X-CRASHLYTICS-API-KEY", wVar.f298a);
        m406a(dVar, "X-CRASHLYTICS-API-CLIENT-TYPE", BleHandshake.DEVICE_TYPE);
        m406a(dVar, "X-CRASHLYTICS-API-CLIENT-VERSION", this.f9a.mo309a());
        m406a(dVar, HttpHeaders.ACCEPT, "application/json");
        m406a(dVar, "X-CRASHLYTICS-DEVICE-MODEL", wVar.f299b);
        m406a(dVar, "X-CRASHLYTICS-OS-BUILD-VERSION", wVar.f300c);
        m406a(dVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", wVar.f301d);
        m406a(dVar, "X-CRASHLYTICS-ADVERTISING-TOKEN", wVar.f302e);
        m406a(dVar, "X-CRASHLYTICS-INSTALLATION-ID", wVar.f303f);
        m406a(dVar, "X-CRASHLYTICS-ANDROID-ID", wVar.f304g);
        return dVar;
    }

    /* renamed from: a */
    private void m406a(C0090d dVar, String str, String str2) {
        if (str2 != null) {
            dVar.mo189a(str, str2);
        }
    }
}
