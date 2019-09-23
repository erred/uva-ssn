package p000a.p001a.p002a.p003a.p004a.p012g;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.api.client.http.HttpMethods;
import java.util.Locale;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.C0148k;
import p000a.p001a.p002a.p003a.p004a.p006b.C0008a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0041r;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;

/* renamed from: a.a.a.a.a.g.a */
/* compiled from: AbstractAppSpiCall */
abstract class C0107a extends C0008a {
    public C0107a(C0146i iVar, String str, String str2, C0098e eVar, C0089c cVar) {
        super(iVar, str, str2, eVar, cVar);
    }

    /* renamed from: a */
    public boolean mo249a(C0110d dVar) {
        C0090d b = m378b(m377a(mo23b(), dVar), dVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Sending app info to ");
        sb.append(mo22a());
        C0135c.m449h().mo270a("Fabric", sb.toString());
        if (dVar.f239j != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("App icon hash is ");
            sb2.append(dVar.f239j.f261a);
            C0135c.m449h().mo270a("Fabric", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("App icon size is ");
            sb3.append(dVar.f239j.f263c);
            sb3.append("x");
            sb3.append(dVar.f239j.f264d);
            C0135c.m449h().mo270a("Fabric", sb3.toString());
        }
        int b2 = b.mo199b();
        String str = HttpMethods.POST.equals(b.mo223p()) ? "Create" : "Update";
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(" app request ID: ");
        sb4.append(b.mo201b("X-REQUEST-ID"));
        C0135c.m449h().mo270a("Fabric", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Result was ");
        sb5.append(b2);
        C0135c.m449h().mo270a("Fabric", sb5.toString());
        return C0041r.m157a(b2) == 0;
    }

    /* renamed from: a */
    private C0090d m377a(C0090d dVar, C0110d dVar2) {
        return dVar.mo189a("X-CRASHLYTICS-API-KEY", dVar2.f230a).mo189a("X-CRASHLYTICS-API-CLIENT-TYPE", BleHandshake.DEVICE_TYPE).mo189a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f9a.mo309a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ca  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p000a.p001a.p002a.p003a.p004a.p010e.C0090d m378b(p000a.p001a.p002a.p003a.p004a.p010e.C0090d r8, p000a.p001a.p002a.p003a.p004a.p012g.C0110d r9) {
        /*
            r7 = this;
            java.lang.String r0 = "app[identifier]"
            java.lang.String r1 = r9.f231b
            a.a.a.a.a.e.d r8 = r8.mo209e(r0, r1)
            java.lang.String r0 = "app[name]"
            java.lang.String r1 = r9.f235f
            a.a.a.a.a.e.d r8 = r8.mo209e(r0, r1)
            java.lang.String r0 = "app[display_version]"
            java.lang.String r1 = r9.f232c
            a.a.a.a.a.e.d r8 = r8.mo209e(r0, r1)
            java.lang.String r0 = "app[build_version]"
            java.lang.String r1 = r9.f233d
            a.a.a.a.a.e.d r8 = r8.mo209e(r0, r1)
            java.lang.String r0 = "app[source]"
            int r1 = r9.f236g
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            a.a.a.a.a.e.d r8 = r8.mo188a(r0, r1)
            java.lang.String r0 = "app[minimum_sdk_version]"
            java.lang.String r1 = r9.f237h
            a.a.a.a.a.e.d r8 = r8.mo209e(r0, r1)
            java.lang.String r0 = "app[built_sdk_version]"
            java.lang.String r1 = r9.f238i
            a.a.a.a.a.e.d r8 = r8.mo209e(r0, r1)
            java.lang.String r0 = r9.f234e
            boolean r0 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m82c(r0)
            if (r0 != 0) goto L_0x004b
            java.lang.String r0 = "app[instance_identifier]"
            java.lang.String r1 = r9.f234e
            r8.mo209e(r0, r1)
        L_0x004b:
            a.a.a.a.a.g.n r0 = r9.f239j
            if (r0 == 0) goto L_0x00c6
            r0 = 0
            a.a.a.a.i r1 = r7.f9a     // Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
            android.content.Context r1 = r1.mo320q()     // Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
            a.a.a.a.a.g.n r2 = r9.f239j     // Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
            int r2 = r2.f262b     // Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
            java.lang.String r0 = "app[icon][hash]"
            a.a.a.a.a.g.n r2 = r9.f239j     // Catch:{ NotFoundException -> 0x0092 }
            java.lang.String r2 = r2.f261a     // Catch:{ NotFoundException -> 0x0092 }
            a.a.a.a.a.e.d r0 = r8.mo209e(r0, r2)     // Catch:{ NotFoundException -> 0x0092 }
            java.lang.String r2 = "app[icon][data]"
            java.lang.String r3 = "icon.png"
            java.lang.String r4 = "application/octet-stream"
            a.a.a.a.a.e.d r0 = r0.mo193a(r2, r3, r4, r1)     // Catch:{ NotFoundException -> 0x0092 }
            java.lang.String r2 = "app[icon][width]"
            a.a.a.a.a.g.n r3 = r9.f239j     // Catch:{ NotFoundException -> 0x0092 }
            int r3 = r3.f263c     // Catch:{ NotFoundException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ NotFoundException -> 0x0092 }
            a.a.a.a.a.e.d r0 = r0.mo188a(r2, r3)     // Catch:{ NotFoundException -> 0x0092 }
            java.lang.String r2 = "app[icon][height]"
            a.a.a.a.a.g.n r3 = r9.f239j     // Catch:{ NotFoundException -> 0x0092 }
            int r3 = r3.f264d     // Catch:{ NotFoundException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ NotFoundException -> 0x0092 }
            r0.mo188a(r2, r3)     // Catch:{ NotFoundException -> 0x0092 }
            goto L_0x00b9
        L_0x0092:
            r0 = move-exception
            goto L_0x009b
        L_0x0094:
            r8 = move-exception
            r1 = r0
            goto L_0x00c0
        L_0x0097:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x009b:
            a.a.a.a.l r2 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = "Fabric"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r4.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = "Failed to find app icon with resource ID: "
            r4.append(r5)     // Catch:{ all -> 0x00bf }
            a.a.a.a.a.g.n r5 = r9.f239j     // Catch:{ all -> 0x00bf }
            int r5 = r5.f262b     // Catch:{ all -> 0x00bf }
            r4.append(r5)     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00bf }
            r2.mo280e(r3, r4, r0)     // Catch:{ all -> 0x00bf }
        L_0x00b9:
            java.lang.String r0 = "Failed to close app icon InputStream."
            p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m70a(r1, r0)
            goto L_0x00c6
        L_0x00bf:
            r8 = move-exception
        L_0x00c0:
            java.lang.String r9 = "Failed to close app icon InputStream."
            p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m70a(r1, r9)
            throw r8
        L_0x00c6:
            java.util.Collection<a.a.a.a.k> r0 = r9.f240k
            if (r0 == 0) goto L_0x00f3
            java.util.Collection<a.a.a.a.k> r9 = r9.f240k
            java.util.Iterator r9 = r9.iterator()
        L_0x00d0:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00f3
            java.lang.Object r0 = r9.next()
            a.a.a.a.k r0 = (p000a.p001a.p002a.p003a.C0148k) r0
            java.lang.String r1 = r7.mo248a(r0)
            java.lang.String r2 = r0.mo327b()
            r8.mo209e(r1, r2)
            java.lang.String r1 = r7.mo250b(r0)
            java.lang.String r0 = r0.mo328c()
            r8.mo209e(r1, r0)
            goto L_0x00d0
        L_0x00f3:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p012g.C0107a.m378b(a.a.a.a.a.e.d, a.a.a.a.a.g.d):a.a.a.a.a.e.d");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo248a(C0148k kVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kVar.mo326a()});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo250b(C0148k kVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kVar.mo326a()});
    }
}
