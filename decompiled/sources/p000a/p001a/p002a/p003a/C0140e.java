package p000a.p001a.p002a.p003a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;

/* renamed from: a.a.a.a.e */
/* compiled from: FabricKitsFinder */
class C0140e implements Callable<Map<String, C0148k>> {

    /* renamed from: a */
    final String f340a;

    C0140e(String str) {
        this.f340a = str;
    }

    /* renamed from: a */
    public Map<String, C0148k> call() throws Exception {
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.putAll(m471c());
        hashMap.putAll(m472d());
        StringBuilder sb = new StringBuilder();
        sb.append("finish scanning in ");
        sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
        C0135c.m449h().mo273b("Fabric", sb.toString());
        return hashMap;
    }

    /* renamed from: c */
    private Map<String, C0148k> m471c() {
        HashMap hashMap = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            C0148k kVar = new C0148k("com.google.firebase.firebase-ads", "0.0.0", "binary");
            hashMap.put(kVar.mo326a(), kVar);
            C0135c.m449h().mo273b("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* renamed from: d */
    private Map<String, C0148k> m472d() throws Exception {
        HashMap hashMap = new HashMap();
        ZipFile b = mo305b();
        Enumeration entries = b.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > "fabric/".length()) {
                C0148k a = m470a(zipEntry, b);
                if (a != null) {
                    hashMap.put(a.mo326a(), a);
                    C0135c.m449h().mo273b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.mo326a(), a.mo327b()}));
                }
            }
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException unused) {
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private C0148k m470a(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                String property = properties.getProperty("fabric-identifier");
                String property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid format of fabric file,");
                    sb.append(zipEntry.getName());
                    throw new IllegalStateException(sb.toString());
                }
                C0148k kVar = new C0148k(property, property2, property3);
                C0020i.m69a((Closeable) inputStream);
                return kVar;
            } catch (IOException e) {
                e = e;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error when parsing fabric properties ");
                    sb2.append(zipEntry.getName());
                    C0135c.m449h().mo280e("Fabric", sb2.toString(), e);
                    C0020i.m69a((Closeable) inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    C0020i.m69a((Closeable) inputStream);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Error when parsing fabric properties ");
            sb22.append(zipEntry.getName());
            C0135c.m449h().mo280e("Fabric", sb22.toString(), e);
            C0020i.m69a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            C0020i.m69a((Closeable) inputStream);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ZipFile mo305b() throws IOException {
        return new ZipFile(this.f340a);
    }
}
