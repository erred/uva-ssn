package com.p103a.p104a.p106b;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0008a;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;

/* renamed from: com.a.a.b.e */
/* compiled from: CheckForUpdatesRequest */
class C1740e extends C0008a {

    /* renamed from: b */
    private final C1742g f5465b;

    /* renamed from: a */
    static String m7263a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("3:");
        sb.append(str);
        return sb.toString();
    }

    public C1740e(C0146i iVar, String str, String str2, C0098e eVar, C1742g gVar) {
        super(iVar, str, str2, eVar, C0089c.GET);
        this.f5465b = gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.p103a.p104a.p106b.C1741f mo7007a(java.lang.String r5, java.lang.String r6, com.p103a.p104a.p106b.C1739d r7) {
        /*
            r4 = this;
            r0 = 0
            java.util.Map r7 = r4.m7264a(r7)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            a.a.a.a.a.e.d r1 = r4.mo21a(r7)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            a.a.a.a.a.e.d r5 = r4.m7262a(r1, r5, r6)     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            a.a.a.a.l r6 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = "Beta"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r2.<init>()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r3 = "Checking for updates from "
            r2.append(r3)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r3 = r4.mo22a()     // Catch:{ Exception -> 0x00ba }
            r2.append(r3)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ba }
            r6.mo270a(r1, r2)     // Catch:{ Exception -> 0x00ba }
            a.a.a.a.l r6 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = "Beta"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r2.<init>()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r3 = "Checking for updates query params are: "
            r2.append(r3)     // Catch:{ Exception -> 0x00ba }
            r2.append(r7)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x00ba }
            r6.mo270a(r1, r7)     // Catch:{ Exception -> 0x00ba }
            boolean r6 = r5.mo205c()     // Catch:{ Exception -> 0x00ba }
            if (r6 == 0) goto L_0x0088
            a.a.a.a.l r6 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r7 = "Beta"
            java.lang.String r1 = "Checking for updates was successful"
            r6.mo270a(r7, r1)     // Catch:{ Exception -> 0x00ba }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ba }
            java.lang.String r7 = r5.mo210e()     // Catch:{ Exception -> 0x00ba }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00ba }
            com.a.a.b.g r7 = r4.f5465b     // Catch:{ Exception -> 0x00ba }
            com.a.a.b.f r6 = r7.mo7008a(r6)     // Catch:{ Exception -> 0x00ba }
            if (r5 == 0) goto L_0x0087
            java.lang.String r7 = "X-REQUEST-ID"
            java.lang.String r5 = r5.mo201b(r7)
            a.a.a.a.l r7 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r0 = "Fabric"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Checking for updates request ID: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r7.mo270a(r0, r5)
        L_0x0087:
            return r6
        L_0x0088:
            a.a.a.a.l r6 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r7 = "Beta"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r1.<init>()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r2 = "Checking for updates failed. Response code: "
            r1.append(r2)     // Catch:{ Exception -> 0x00ba }
            int r2 = r5.mo199b()     // Catch:{ Exception -> 0x00ba }
            r1.append(r2)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ba }
            r6.mo279e(r7, r1)     // Catch:{ Exception -> 0x00ba }
            if (r5 == 0) goto L_0x0107
            java.lang.String r6 = "X-REQUEST-ID"
            java.lang.String r5 = r5.mo201b(r6)
            a.a.a.a.l r6 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r7 = "Fabric"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x00f8
        L_0x00ba:
            r6 = move-exception
            goto L_0x00c7
        L_0x00bc:
            r6 = move-exception
            r5 = r1
            goto L_0x0109
        L_0x00bf:
            r6 = move-exception
            r5 = r1
            goto L_0x00c7
        L_0x00c2:
            r6 = move-exception
            r5 = r0
            goto L_0x0109
        L_0x00c5:
            r6 = move-exception
            r5 = r0
        L_0x00c7:
            a.a.a.a.l r7 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = "Beta"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r2.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = "Error while checking for updates from "
            r2.append(r3)     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = r4.mo22a()     // Catch:{ all -> 0x0108 }
            r2.append(r3)     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0108 }
            r7.mo280e(r1, r2, r6)     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x0107
            java.lang.String r6 = "X-REQUEST-ID"
            java.lang.String r5 = r5.mo201b(r6)
            a.a.a.a.l r6 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r7 = "Fabric"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x00f8:
            java.lang.String r2 = "Checking for updates request ID: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r6.mo270a(r7, r5)
        L_0x0107:
            return r0
        L_0x0108:
            r6 = move-exception
        L_0x0109:
            if (r5 == 0) goto L_0x012b
            java.lang.String r7 = "X-REQUEST-ID"
            java.lang.String r5 = r5.mo201b(r7)
            a.a.a.a.l r7 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Checking for updates request ID: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Fabric"
            r7.mo270a(r0, r5)
        L_0x012b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p103a.p104a.p106b.C1740e.mo7007a(java.lang.String, java.lang.String, com.a.a.b.d):com.a.a.b.f");
    }

    /* renamed from: a */
    private C0090d m7262a(C0090d dVar, String str, String str2) {
        C0090d a = dVar.mo189a(HttpHeaders.ACCEPT, "application/json");
        String str3 = HttpHeaders.USER_AGENT;
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Android SDK/");
        sb.append(this.f9a.mo309a());
        return a.mo189a(str3, sb.toString()).mo189a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").mo189a("X-CRASHLYTICS-API-CLIENT-TYPE", BleHandshake.DEVICE_TYPE).mo189a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f9a.mo309a()).mo189a("X-CRASHLYTICS-API-KEY", str).mo189a("X-CRASHLYTICS-BETA-TOKEN", m7263a(str2));
    }

    /* renamed from: a */
    private Map<String, String> m7264a(C1739d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", dVar.f5461a);
        hashMap.put("display_version", dVar.f5462b);
        hashMap.put("instance", dVar.f5463c);
        hashMap.put(Param.SOURCE, "3");
        return hashMap;
    }
}
