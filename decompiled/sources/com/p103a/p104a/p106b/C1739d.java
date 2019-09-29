package com.p103a.p104a.p106b;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* renamed from: com.a.a.b.d */
/* compiled from: BuildProperties */
class C1739d {

    /* renamed from: a */
    public final String f5461a;

    /* renamed from: b */
    public final String f5462b;

    /* renamed from: c */
    public final String f5463c;

    /* renamed from: d */
    public final String f5464d;

    C1739d(String str, String str2, String str3, String str4) {
        this.f5461a = str;
        this.f5462b = str2;
        this.f5463c = str3;
        this.f5464d = str4;
    }

    /* renamed from: a */
    public static C1739d m7261a(Properties properties) {
        return new C1739d(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    /* renamed from: a */
    public static C1739d m7260a(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return m7261a(properties);
    }
}
