package com.p103a.p104a.p106b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p000a.p001a.p002a.p003a.p004a.p005a.C0007d;

/* renamed from: com.a.a.b.h */
/* compiled from: DeviceTokenLoader */
public class C1743h implements C0007d<String> {
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005b */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[SYNTHETIC, Splitter:B:24:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[SYNTHETIC, Splitter:B:30:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068 A[SYNTHETIC, Splitter:B:35:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a6 A[SYNTHETIC, Splitter:B:42:0x00a6] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0038=Splitter:B:21:0x0038, B:27:0x004a=Splitter:B:27:0x004a, B:32:0x005b=Splitter:B:32:0x005b} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo20b(android.content.Context r9) throws java.lang.Exception {
        /*
            r8 = this;
            long r0 = java.lang.System.nanoTime()
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = "io.crash.air"
            java.util.zip.ZipInputStream r9 = r8.mo7011a(r9, r4)     // Catch:{ NameNotFoundException -> 0x005b, FileNotFoundException -> 0x0049, IOException -> 0x0037 }
            java.lang.String r3 = r8.mo7010a(r9)     // Catch:{ NameNotFoundException -> 0x0033, FileNotFoundException -> 0x002e, IOException -> 0x0029, all -> 0x0025 }
            if (r9 == 0) goto L_0x0023
            r9.close()     // Catch:{ IOException -> 0x0017 }
            goto L_0x0023
        L_0x0017:
            r9 = move-exception
            a.a.a.a.l r2 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r4 = "Beta"
            java.lang.String r5 = "Failed to close the APK file"
            r2.mo280e(r4, r5, r9)
        L_0x0023:
            r2 = r3
            goto L_0x0078
        L_0x0025:
            r0 = move-exception
            r3 = r9
            goto L_0x00a4
        L_0x0029:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x0038
        L_0x002e:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x004a
        L_0x0033:
            r3 = r9
            goto L_0x005b
        L_0x0035:
            r0 = move-exception
            goto L_0x00a4
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            a.a.a.a.l r4 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "Beta"
            java.lang.String r6 = "Failed to read the APK file"
            r4.mo280e(r5, r6, r9)     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0078
        L_0x0049:
            r9 = move-exception
        L_0x004a:
            a.a.a.a.l r4 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "Beta"
            java.lang.String r6 = "Failed to find the APK file"
            r4.mo280e(r5, r6, r9)     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0078
        L_0x005b:
            a.a.a.a.l r9 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x0035 }
            java.lang.String r4 = "Beta"
            java.lang.String r5 = "Beta by Crashlytics app is not installed"
            r9.mo270a(r4, r5)     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0078
        L_0x006c:
            r9 = move-exception
            a.a.a.a.l r3 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r4 = "Beta"
            java.lang.String r5 = "Failed to close the APK file"
            r3.mo280e(r4, r5, r9)
        L_0x0078:
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r0
            double r0 = (double) r3
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r3
            a.a.a.a.l r9 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r3 = "Beta"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Beta device token load took "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = "ms"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r9.mo270a(r3, r0)
            return r2
        L_0x00a4:
            if (r3 == 0) goto L_0x00b6
            r3.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00b6
        L_0x00aa:
            r9 = move-exception
            a.a.a.a.l r1 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r2 = "Beta"
            java.lang.String r3 = "Failed to close the APK file"
            r1.mo280e(r2, r3, r9)
        L_0x00b6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p103a.p104a.p106b.C1743h.mo20b(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ZipInputStream mo7011a(Context context, String str) throws NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo7010a(ZipInputStream zipInputStream) throws IOException {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=")) {
                return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
            }
        }
        return "";
    }
}
