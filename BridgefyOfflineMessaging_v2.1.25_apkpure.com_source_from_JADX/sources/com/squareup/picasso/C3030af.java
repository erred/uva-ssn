package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import p102c.C1676e;
import p102c.C1677f;

/* renamed from: com.squareup.picasso.af */
/* compiled from: Utils */
final class C3030af {

    /* renamed from: a */
    static final StringBuilder f7921a = new StringBuilder();

    /* renamed from: b */
    private static final C1677f f7922b = C1677f.m6985a("RIFF");

    /* renamed from: c */
    private static final C1677f f7923c = C1677f.m6985a("WEBP");

    /* renamed from: com.squareup.picasso.af$a */
    /* compiled from: Utils */
    private static class C3032a extends Thread {
        C3032a(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: com.squareup.picasso.af$b */
    /* compiled from: Utils */
    static class C3033b implements ThreadFactory {
        C3033b() {
        }

        public Thread newThread(Runnable runnable) {
            return new C3032a(runnable);
        }
    }

    /* renamed from: a */
    static int m8932a(Bitmap bitmap) {
        int allocationByteCount = VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Negative size: ");
        sb.append(bitmap);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    static <T> T m8937a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static void m8942a() {
        if (!m8948b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* renamed from: b */
    static boolean m8948b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: a */
    static String m8938a(C3035c cVar) {
        return m8939a(cVar, "");
    }

    /* renamed from: a */
    static String m8939a(C3035c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        C3021a i = cVar.mo27467i();
        if (i != null) {
            sb.append(i.f7878b.mo27558a());
        }
        List k = cVar.mo27469k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || i != null) {
                    sb.append(", ");
                }
                sb.append(((C3021a) k.get(i2)).f7878b.mo27558a());
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    static void m8944a(String str, String str2, String str3) {
        m8945a(str, str2, str3, "");
    }

    /* renamed from: a */
    static void m8945a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    /* renamed from: a */
    static String m8940a(C3081w wVar) {
        String a = m8941a(wVar, f7921a);
        f7921a.setLength(0);
        return a;
    }

    /* renamed from: a */
    static String m8941a(C3081w wVar, StringBuilder sb) {
        if (wVar.f8075f != null) {
            sb.ensureCapacity(wVar.f8075f.length() + 50);
            sb.append(wVar.f8075f);
        } else if (wVar.f8073d != null) {
            String uri = wVar.f8073d.toString();
            sb.ensureCapacity(uri.length() + 50);
            sb.append(uri);
        } else {
            sb.ensureCapacity(50);
            sb.append(wVar.f8074e);
        }
        sb.append(10);
        if (wVar.f8083n != BitmapDescriptorFactory.HUE_RED) {
            sb.append("rotation:");
            sb.append(wVar.f8083n);
            if (wVar.f8086q) {
                sb.append('@');
                sb.append(wVar.f8084o);
                sb.append('x');
                sb.append(wVar.f8085p);
            }
            sb.append(10);
        }
        if (wVar.mo27561d()) {
            sb.append("resize:");
            sb.append(wVar.f8077h);
            sb.append('x');
            sb.append(wVar.f8078i);
            sb.append(10);
        }
        if (wVar.f8079j) {
            sb.append("centerCrop:");
            sb.append(wVar.f8080k);
            sb.append(10);
        } else if (wVar.f8081l) {
            sb.append("centerInside");
            sb.append(10);
        }
        if (wVar.f8076g != null) {
            int size = wVar.f8076g.size();
            for (int i = 0; i < size; i++) {
                sb.append(((C3029ae) wVar.f8076g.get(i)).mo27450a());
                sb.append(10);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    static File m8935a(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @TargetApi(18)
    /* renamed from: a */
    static long m8933a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = ((VERSION.SDK_INT < 18 ? (long) statFs.getBlockCount() : statFs.getBlockCountLong()) * (VERSION.SDK_INT < 18 ? (long) statFs.getBlockSize() : statFs.getBlockSizeLong())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }

    /* renamed from: b */
    static int m8947b(Context context) {
        ActivityManager activityManager = (ActivityManager) m8936a(context, "activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576) / 7);
    }

    /* renamed from: c */
    static boolean m8950c(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = false;
        try {
            if (VERSION.SDK_INT < 17) {
                if (System.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                    z = true;
                }
                return z;
            }
            if (Global.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                z = true;
            }
            return z;
        } catch (NullPointerException unused) {
            return false;
        } catch (SecurityException unused2) {
            return false;
        }
    }

    /* renamed from: a */
    static <T> T m8936a(Context context, String str) {
        return context.getSystemService(str);
    }

    /* renamed from: b */
    static boolean m8949b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: a */
    static boolean m8946a(C1676e eVar) throws IOException {
        return eVar.mo6820a(0, f7922b) && eVar.mo6820a(8, f7923c);
    }

    /* renamed from: a */
    static int m8931a(Resources resources, C3081w wVar) throws FileNotFoundException {
        int i;
        if (wVar.f8074e != 0 || wVar.f8073d == null) {
            return wVar.f8074e;
        }
        String authority = wVar.f8073d.getAuthority();
        if (authority != null) {
            List pathSegments = wVar.f8073d.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("No path segments: ");
                sb.append(wVar.f8073d);
                throw new FileNotFoundException(sb.toString());
            }
            if (pathSegments.size() == 1) {
                try {
                    i = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Last path segment is not a resource ID: ");
                    sb2.append(wVar.f8073d);
                    throw new FileNotFoundException(sb2.toString());
                }
            } else if (pathSegments.size() == 2) {
                i = resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("More than two path segments: ");
                sb3.append(wVar.f8073d);
                throw new FileNotFoundException(sb3.toString());
            }
            return i;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("No package provided: ");
        sb4.append(wVar.f8073d);
        throw new FileNotFoundException(sb4.toString());
    }

    /* renamed from: a */
    static Resources m8934a(Context context, C3081w wVar) throws FileNotFoundException {
        if (wVar.f8074e != 0 || wVar.f8073d == null) {
            return context.getResources();
        }
        String authority = wVar.f8073d.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (NameNotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to obtain resources for package: ");
                sb.append(wVar.f8073d);
                throw new FileNotFoundException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No package provided: ");
            sb2.append(wVar.f8073d);
            throw new FileNotFoundException(sb2.toString());
        }
    }

    /* renamed from: a */
    static void m8943a(Looper looper) {
        C30311 r0 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        r0.sendMessageDelayed(r0.obtainMessage(), 1000);
    }
}
