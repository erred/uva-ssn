package com.p103a.p104a.p107c;

import java.io.File;
import java.io.IOException;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;

/* renamed from: com.a.a.c.j */
/* compiled from: CrashlyticsFileMarker */
class C1821j {

    /* renamed from: a */
    private final String f5643a;

    /* renamed from: b */
    private final C0103a f5644b;

    public C1821j(String str, C0103a aVar) {
        this.f5643a = str;
        this.f5644b = aVar;
    }

    /* renamed from: a */
    public boolean mo7151a() {
        try {
            return m7525d().createNewFile();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating marker: ");
            sb.append(this.f5643a);
            C0135c.m449h().mo280e("CrashlyticsCore", sb.toString(), e);
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo7152b() {
        return m7525d().exists();
    }

    /* renamed from: c */
    public boolean mo7153c() {
        return m7525d().delete();
    }

    /* renamed from: d */
    private File m7525d() {
        return new File(this.f5644b.mo243a(), this.f5643a);
    }
}
