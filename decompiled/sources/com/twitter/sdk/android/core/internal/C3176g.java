package com.twitter.sdk.android.core.internal;

import android.content.Context;
import android.content.res.Resources;
import com.twitter.sdk.android.core.C3256m;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.twitter.sdk.android.core.internal.g */
/* compiled from: CommonUtils */
public class C3176g {

    /* renamed from: a */
    private static Boolean f8328a;

    /* renamed from: a */
    public static void m9306a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m9304a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m9305a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C3256m.m9537g().mo27613c("Twitter", str, e);
            }
        }
    }

    /* renamed from: a */
    static String m9300a(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    /* renamed from: a */
    static int m9299a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m9300a(context));
    }

    /* renamed from: a */
    public static boolean m9307a(Context context, String str, boolean z) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int a = m9299a(context, str, "bool");
                if (a > 0) {
                    return resources.getBoolean(a);
                }
                int a2 = m9299a(context, str, "string");
                if (a2 > 0) {
                    return Boolean.parseBoolean(context.getString(a2));
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public static String m9308b(Context context, String str, String str2) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int a = m9299a(context, str, "string");
                if (a > 0) {
                    return resources.getString(a);
                }
            }
        }
        return str2;
    }

    /* renamed from: b */
    static boolean m9309b(Context context) {
        if (f8328a == null) {
            f8328a = Boolean.valueOf(m9307a(context, "com.twitter.sdk.android.TRACE_ENABLED", false));
        }
        return f8328a.booleanValue();
    }

    /* renamed from: a */
    public static void m9302a(Context context, String str) {
        if (m9309b(context)) {
            C3256m.m9537g().mo27607a("Twitter", str);
        }
    }

    /* renamed from: a */
    public static void m9303a(Context context, String str, Throwable th) {
        if (m9309b(context)) {
            C3256m.m9537g().mo27612c("Twitter", str);
        }
    }

    /* renamed from: a */
    public static void m9301a(Context context, int i, String str, String str2) {
        if (m9309b(context)) {
            C3256m.m9537g().mo27605a(i, "Twitter", str2);
        }
    }
}
