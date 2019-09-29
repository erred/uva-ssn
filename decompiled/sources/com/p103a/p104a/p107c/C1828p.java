package com.p103a.p104a.p107c;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import java.io.File;
import java.util.Map.Entry;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0008a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0041r;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;

/* renamed from: com.a.a.c.p */
/* compiled from: DefaultCreateReportSpiCall */
class C1828p extends C0008a implements C1827o {
    public C1828p(C0146i iVar, String str, String str2, C0098e eVar) {
        super(iVar, str, str2, eVar, C0089c.POST);
    }

    /* renamed from: a */
    public boolean mo7156a(C1826n nVar) {
        C0090d a = m7537a(m7538a(mo23b(), nVar), nVar.f5650b);
        StringBuilder sb = new StringBuilder();
        sb.append("Sending report to: ");
        sb.append(mo22a());
        C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
        int b = a.mo199b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Create report request ID: ");
        sb2.append(a.mo201b("X-REQUEST-ID"));
        C0135c.m449h().mo270a("CrashlyticsCore", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Result was: ");
        sb3.append(b);
        C0135c.m449h().mo270a("CrashlyticsCore", sb3.toString());
        return C0041r.m157a(b) == 0;
    }

    /* renamed from: a */
    private C0090d m7538a(C0090d dVar, C1826n nVar) {
        C0090d a = dVar.mo189a("X-CRASHLYTICS-API-KEY", nVar.f5649a).mo189a("X-CRASHLYTICS-API-CLIENT-TYPE", BleHandshake.DEVICE_TYPE).mo189a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f9a.mo309a());
        for (Entry a2 : nVar.f5650b.mo7026e().entrySet()) {
            a = a.mo195a(a2);
        }
        return a;
    }

    /* renamed from: a */
    private C0090d m7537a(C0090d dVar, C1760ae aeVar) {
        File[] d;
        dVar.mo209e("report[identifier]", aeVar.mo7023b());
        if (aeVar.mo7025d().length == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Adding single file ");
            sb.append(aeVar.mo7022a());
            sb.append(" to report ");
            sb.append(aeVar.mo7023b());
            C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
            return dVar.mo192a("report[file]", aeVar.mo7022a(), "application/octet-stream", aeVar.mo7024c());
        }
        int i = 0;
        for (File file : aeVar.mo7025d()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Adding file ");
            sb2.append(file.getName());
            sb2.append(" to report ");
            sb2.append(aeVar.mo7023b());
            C0135c.m449h().mo270a("CrashlyticsCore", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("report[file");
            sb3.append(i);
            sb3.append("]");
            dVar.mo192a(sb3.toString(), file.getName(), "application/octet-stream", file);
            i++;
        }
        return dVar;
    }
}
