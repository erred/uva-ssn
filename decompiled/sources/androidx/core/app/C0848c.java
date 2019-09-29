package androidx.core.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.app.c */
/* compiled from: BundleCompat */
public final class C0848c {

    /* renamed from: androidx.core.app.c$a */
    /* compiled from: BundleCompat */
    static class C0849a {

        /* renamed from: a */
        private static Method f2722a;

        /* renamed from: b */
        private static boolean f2723b;

        /* renamed from: c */
        private static Method f2724c;

        /* renamed from: d */
        private static boolean f2725d;

        /* renamed from: a */
        public static IBinder m3109a(Bundle bundle, String str) {
            if (!f2723b) {
                try {
                    f2722a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f2722a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f2723b = true;
            }
            if (f2722a != null) {
                try {
                    return (IBinder) f2722a.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f2722a = null;
                }
            }
            return null;
        }

        /* renamed from: a */
        public static void m3110a(Bundle bundle, String str, IBinder iBinder) {
            if (!f2725d) {
                try {
                    f2724c = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f2724c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                f2725d = true;
            }
            if (f2724c != null) {
                try {
                    f2724c.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    f2724c = null;
                }
            }
        }
    }

    /* renamed from: a */
    public static IBinder m3107a(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return C0849a.m3109a(bundle, str);
    }

    /* renamed from: a */
    public static void m3108a(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            C0849a.m3110a(bundle, str, iBinder);
        }
    }
}
