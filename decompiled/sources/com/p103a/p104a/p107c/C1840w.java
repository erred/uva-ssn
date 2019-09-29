package com.p103a.p104a.p107c;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;

/* renamed from: com.a.a.c.w */
/* compiled from: MetaDataStore */
class C1840w {

    /* renamed from: a */
    private static final Charset f5672a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final File f5673b;

    public C1840w(File file) {
        this.f5673b = file;
    }

    /* renamed from: a */
    public C1772al mo7171a(String str) {
        File c = m7573c(str);
        if (!c.exists()) {
            return C1772al.f5537a;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(c);
            try {
                C1772al e = m7575e(C0020i.m59a((InputStream) fileInputStream2));
                C0020i.m70a((Closeable) fileInputStream2, "Failed to close user metadata file.");
                return e;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    C0135c.m449h().mo280e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    return C1772al.f5537a;
                } catch (Throwable th) {
                    th = th;
                    C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            C0135c.m449h().mo280e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
            return C1772al.f5537a;
        }
    }

    /* renamed from: b */
    public Map<String, String> mo7172b(String str) {
        File d = m7574d(str);
        if (!d.exists()) {
            return Collections.emptyMap();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(d);
            try {
                Map<String, String> f = m7576f(C0020i.m59a((InputStream) fileInputStream2));
                C0020i.m70a((Closeable) fileInputStream2, "Failed to close user metadata file.");
                return f;
            } catch (Exception e) {
                e = e;
                fileInputStream = fileInputStream2;
                try {
                    C0135c.m449h().mo280e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    th = th;
                    C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            C0135c.m449h().mo280e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C0020i.m70a((Closeable) fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        }
    }

    /* renamed from: c */
    private File m7573c(String str) {
        File file = this.f5673b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("user");
        sb.append(".meta");
        return new File(file, sb.toString());
    }

    /* renamed from: d */
    private File m7574d(String str) {
        File file = this.f5673b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("keys");
        sb.append(".meta");
        return new File(file, sb.toString());
    }

    /* renamed from: e */
    private static C1772al m7575e(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new C1772al(m7572a(jSONObject, "userId"), m7572a(jSONObject, "userName"), m7572a(jSONObject, "userEmail"));
    }

    /* renamed from: f */
    private static Map<String, String> m7576f(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, m7572a(jSONObject, str2));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static String m7572a(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, null);
        }
        return null;
    }
}
