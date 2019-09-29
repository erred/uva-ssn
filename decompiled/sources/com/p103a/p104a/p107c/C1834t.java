package com.p103a.p104a.p107c;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: com.a.a.c.t */
/* compiled from: InvalidSessionReport */
class C1834t implements C1760ae {

    /* renamed from: a */
    private final File[] f5663a;

    /* renamed from: b */
    private final Map<String, String> f5664b = new HashMap(C1761af.f5517a);

    /* renamed from: c */
    private final String f5665c;

    public C1834t(String str, File[] fileArr) {
        this.f5663a = fileArr;
        this.f5665c = str;
    }

    /* renamed from: a */
    public String mo7022a() {
        return this.f5663a[0].getName();
    }

    /* renamed from: b */
    public String mo7023b() {
        return this.f5665c;
    }

    /* renamed from: c */
    public File mo7024c() {
        return this.f5663a[0];
    }

    /* renamed from: d */
    public File[] mo7025d() {
        return this.f5663a;
    }

    /* renamed from: e */
    public Map<String, String> mo7026e() {
        return Collections.unmodifiableMap(this.f5664b);
    }

    /* renamed from: f */
    public void mo7027f() {
        File[] fileArr;
        for (File file : this.f5663a) {
            StringBuilder sb = new StringBuilder();
            sb.append("Removing invalid report file at ");
            sb.append(file.getPath());
            C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
            file.delete();
        }
    }
}
