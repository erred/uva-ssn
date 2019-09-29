package com.p103a.p104a.p105a;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import java.io.File;
import java.util.List;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0008a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0041r;
import p000a.p001a.p002a.p003a.p004a.p009d.C0082f;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;

/* renamed from: com.a.a.a.p */
/* compiled from: SessionAnalyticsFilesSender */
class C1724p extends C0008a implements C0082f {

    /* renamed from: b */
    private final String f5395b;

    public C1724p(C0146i iVar, String str, String str2, C0098e eVar, String str3) {
        super(iVar, str, str2, eVar, C0089c.POST);
        this.f5395b = str3;
    }

    /* renamed from: a */
    public boolean mo180a(List<File> list) {
        C0090d a = mo23b().mo189a("X-CRASHLYTICS-API-CLIENT-TYPE", BleHandshake.DEVICE_TYPE).mo189a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f9a.mo309a()).mo189a("X-CRASHLYTICS-API-KEY", this.f5395b);
        int i = 0;
        for (File file : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("session_analytics_file_");
            sb.append(i);
            a.mo192a(sb.toString(), file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending ");
        sb2.append(list.size());
        sb2.append(" analytics files to ");
        sb2.append(mo22a());
        C0135c.m449h().mo270a("Answers", sb2.toString());
        int b = a.mo199b();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Response code for analytics file send is ");
        sb3.append(b);
        C0135c.m449h().mo270a("Answers", sb3.toString());
        if (C0041r.m157a(b) == 0) {
            return true;
        }
        return false;
    }
}
