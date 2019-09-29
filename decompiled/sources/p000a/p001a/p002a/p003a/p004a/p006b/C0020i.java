package p000a.p001a.p002a.p003a.p004a.p006b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: a.a.a.a.a.b.i */
/* compiled from: CommonUtils */
public class C0020i {

    /* renamed from: a */
    public static final Comparator<File> f25a = new Comparator<File>() {
        /* renamed from: a */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    };

    /* renamed from: b */
    private static Boolean f26b;

    /* renamed from: c */
    private static final char[] f27c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d */
    private static long f28d = -1;

    /* renamed from: a.a.a.a.a.b.i$a */
    /* compiled from: CommonUtils */
    enum C0022a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: k */
        private static final Map<String, C0022a> f39k = null;

        static {
            f39k = new HashMap(4);
            f39k.put("armeabi-v7a", ARMV7);
            f39k.put("armeabi", ARMV6);
            f39k.put("arm64-v8a", ARM64);
            f39k.put("x86", X86_32);
        }

        /* renamed from: a */
        static C0022a m95a() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                C0135c.m449h().mo270a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            C0022a aVar = (C0022a) f39k.get(str.toLowerCase(Locale.US));
            if (aVar == null) {
                aVar = UNKNOWN;
            }
            return aVar;
        }
    }

    /* renamed from: a */
    public static SharedPreferences m57a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* renamed from: a */
    public static String m58a(File file, String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            str2 = split[1];
                            break;
                        }
                    } catch (Exception e) {
                        e = e;
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Error parsing ");
                            sb.append(file);
                            C0135c.m449h().mo280e("Fabric", sb.toString(), e);
                            m70a((Closeable) bufferedReader, "Failed to close system file reader.");
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error parsing ");
                sb2.append(file);
                C0135c.m449h().mo280e("Fabric", sb2.toString(), e);
                m70a((Closeable) bufferedReader, "Failed to close system file reader.");
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                m70a((Closeable) bufferedReader, "Failed to close system file reader.");
                throw th;
            }
            m70a((Closeable) bufferedReader, "Failed to close system file reader.");
        }
        return str2;
    }

    /* renamed from: a */
    public static int m52a() {
        return C0022a.m95a().ordinal();
    }

    /* renamed from: b */
    public static synchronized long m74b() {
        long j;
        long a;
        synchronized (C0020i.class) {
            if (f28d == -1) {
                long j2 = 0;
                String a2 = m58a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a2)) {
                    String upperCase = a2.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            a = m55a(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            a = m55a(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            a = m55a(upperCase, "GB", (int) Ints.MAX_POWER_OF_TWO);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unexpected meminfo format while computing RAM: ");
                            sb.append(upperCase);
                            C0135c.m449h().mo270a("Fabric", sb.toString());
                        }
                        j2 = a;
                    } catch (NumberFormatException e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unexpected meminfo format while computing RAM: ");
                        sb2.append(upperCase);
                        C0135c.m449h().mo280e("Fabric", sb2.toString(), e);
                    }
                }
                f28d = j2;
            }
            j = f28d;
        }
        return j;
    }

    /* renamed from: a */
    static long m55a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    /* renamed from: a */
    public static RunningAppProcessInfo m56a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m59a(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    /* renamed from: a */
    public static String m61a(String str) {
        return m62a(str, "SHA-1");
    }

    /* renamed from: b */
    public static String m78b(InputStream inputStream) {
        return m60a(inputStream, "SHA-1");
    }

    /* renamed from: a */
    private static String m60a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return m63a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e) {
            C0135c.m449h().mo280e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    /* renamed from: a */
    private static String m64a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return m63a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create hashing algorithm: ");
            sb.append(str);
            sb.append(", returning empty string.");
            C0135c.m449h().mo280e("Fabric", sb.toString(), e);
            return "";
        }
    }

    /* renamed from: a */
    private static String m62a(String str, String str2) {
        return m64a(str.getBytes(), str2);
    }

    /* renamed from: a */
    public static String m65a(String... strArr) {
        String str = null;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : strArr) {
            if (str2 != null) {
                arrayList.add(str2.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String append : arrayList) {
            sb.append(append);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            str = m61a(sb2);
        }
        return str;
    }

    /* renamed from: b */
    public static long m75b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: b */
    public static long m76b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    /* renamed from: c */
    public static Float m79c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra(Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    /* renamed from: d */
    public static boolean m83d(Context context) {
        boolean z = false;
        if (m85f(context)) {
            return false;
        }
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static void m67a(Context context, String str) {
        if (m84e(context)) {
            C0135c.m449h().mo270a("Fabric", str);
        }
    }

    /* renamed from: a */
    public static void m68a(Context context, String str, Throwable th) {
        if (m84e(context)) {
            C0135c.m449h().mo279e("Fabric", str);
        }
    }

    /* renamed from: a */
    public static void m66a(Context context, int i, String str, String str2) {
        if (m84e(context)) {
            C0135c.m449h().mo268a(i, "Fabric", str2);
        }
    }

    /* renamed from: e */
    public static boolean m84e(Context context) {
        if (f26b == null) {
            f26b = Boolean.valueOf(m73a(context, "com.crashlytics.Trace", false));
        }
        return f26b.booleanValue();
    }

    /* renamed from: a */
    public static boolean m73a(Context context, String str, boolean z) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int a = m53a(context, str, "bool");
                if (a > 0) {
                    return resources.getBoolean(a);
                }
                int a2 = m53a(context, str, "string");
                if (a2 > 0) {
                    return Boolean.parseBoolean(context.getString(a2));
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public static int m53a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m89j(context));
    }

    /* renamed from: f */
    public static boolean m85f(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    /* renamed from: g */
    public static boolean m86g(Context context) {
        boolean f = m85f(context);
        String str = Build.TAGS;
        if ((!f && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (f || !file.exists()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m80c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    /* renamed from: h */
    public static int m87h(Context context) {
        int i = m85f(context) ? 1 : 0;
        if (m86g(context)) {
            i |= 2;
        }
        return m80c() ? i | 4 : i;
    }

    /* renamed from: a */
    public static int m54a(Context context, boolean z) {
        Float c = m79c(context);
        if (!z || c == null) {
            return 1;
        }
        if (((double) c.floatValue()) >= 99.0d) {
            return 3;
        }
        return ((double) c.floatValue()) < 99.0d ? 2 : 0;
    }

    /* renamed from: a */
    public static String m63a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
            int i2 = i * 2;
            cArr[i2] = f27c[b >>> 4];
            cArr[i2 + 1] = f27c[b & Ascii.f6734SI];
        }
        return new String(cArr);
    }

    /* renamed from: i */
    public static boolean m88i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: b */
    public static String m77b(Context context, String str) {
        int a = m53a(context, str, "string");
        return a > 0 ? context.getString(a) : "";
    }

    /* renamed from: a */
    public static void m70a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C0135c.m449h().mo280e("Fabric", str, e);
            }
        }
    }

    /* renamed from: a */
    public static void m71a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                C0135c.m449h().mo280e("Fabric", str, e);
            }
        }
    }

    /* renamed from: c */
    public static boolean m82c(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: j */
    public static String m89j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    /* renamed from: a */
    public static void m72a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: k */
    public static String m90k(Context context) {
        InputStream inputStream;
        String str = null;
        try {
            inputStream = context.getResources().openRawResource(m91l(context));
            try {
                String b = m78b(inputStream);
                if (!m82c(b)) {
                    str = b;
                }
                m70a((Closeable) inputStream, "Failed to close icon input stream.");
                return str;
            } catch (Exception e) {
                e = e;
                try {
                    C0135c.m449h().mo280e("Fabric", "Could not calculate hash for app icon.", e);
                    m70a((Closeable) inputStream, "Failed to close icon input stream.");
                    return null;
                } catch (Throwable th) {
                    th = th;
                    m70a((Closeable) inputStream, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
            C0135c.m449h().mo280e("Fabric", "Could not calculate hash for app icon.", e);
            m70a((Closeable) inputStream, "Failed to close icon input stream.");
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            m70a((Closeable) inputStream, "Failed to close icon input stream.");
            throw th;
        }
    }

    /* renamed from: l */
    public static int m91l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    /* renamed from: m */
    public static String m92m(Context context) {
        int a = m53a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = m53a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        StringBuilder sb = new StringBuilder();
        sb.append("Build ID is: ");
        sb.append(string);
        C0135c.m449h().mo270a("Fabric", sb.toString());
        return string;
    }

    /* renamed from: a */
    public static void m69a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public static boolean m81c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: n */
    public static boolean m93n(Context context) {
        boolean z = true;
        if (!m81c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            z = false;
        }
        return z;
    }
}
