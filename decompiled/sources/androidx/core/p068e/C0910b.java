package androidx.core.p068e;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: androidx.core.e.b */
/* compiled from: ICUCompat */
public final class C0910b {

    /* renamed from: a */
    private static Method f2917a;

    /* renamed from: b */
    private static Method f2918b;

    static {
        if (VERSION.SDK_INT >= 21) {
            try {
                f2918b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            try {
                Class cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f2917a = cls.getMethod("getScript", new Class[]{String.class});
                    f2918b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
                }
            } catch (Exception e2) {
                f2917a = null;
                f2918b = null;
                Log.w("ICUCompat", e2);
            }
        }
    }

    /* renamed from: a */
    public static String m3366a(Locale locale) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f2918b.invoke(null, new Object[]{locale})).getScript();
            } catch (InvocationTargetException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (IllegalAccessException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        } else {
            String b = m3367b(locale);
            if (b != null) {
                return m3365a(b);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static String m3365a(String str) {
        try {
            if (f2917a != null) {
                return (String) f2917a.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    /* renamed from: b */
    private static String m3367b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f2918b != null) {
                return (String) f2918b.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return locale2;
    }
}
