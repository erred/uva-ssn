package com.p103a.p104a.p107c;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: com.a.a.c.ah */
/* compiled from: SessionReport */
class C1768ah implements C1760ae {

    /* renamed from: a */
    private final File f5530a;

    /* renamed from: b */
    private final File[] f5531b;

    /* renamed from: c */
    private final Map<String, String> f5532c;

    public C1768ah(File file) {
        this(file, Collections.emptyMap());
    }

    public C1768ah(File file, Map<String, String> map) {
        this.f5530a = file;
        this.f5531b = new File[]{file};
        this.f5532c = new HashMap(map);
        if (this.f5530a.length() == 0) {
            this.f5532c.putAll(C1761af.f5517a);
        }
    }

    /* renamed from: c */
    public File mo7024c() {
        return this.f5530a;
    }

    /* renamed from: d */
    public File[] mo7025d() {
        return this.f5531b;
    }

    /* renamed from: a */
    public String mo7022a() {
        return mo7024c().getName();
    }

    /* renamed from: b */
    public String mo7023b() {
        String a = mo7022a();
        return a.substring(0, a.lastIndexOf(46));
    }

    /* renamed from: e */
    public Map<String, String> mo7026e() {
        return Collections.unmodifiableMap(this.f5532c);
    }

    /* renamed from: f */
    public void mo7027f() {
        StringBuilder sb = new StringBuilder();
        sb.append("Removing report at ");
        sb.append(this.f5530a.getPath());
        C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
        this.f5530a.delete();
    }
}
