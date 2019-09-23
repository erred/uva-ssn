package androidx.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.transition.aa */
/* compiled from: ViewGroupUtilsApi18 */
class C1360aa {

    /* renamed from: a */
    private static Method f4089a;

    /* renamed from: b */
    private static boolean f4090b;

    /* renamed from: a */
    static void m5539a(ViewGroup viewGroup, boolean z) {
        m5538a();
        if (f4089a != null) {
            try {
                f4089a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    /* renamed from: a */
    private static void m5538a() {
        if (!f4090b) {
            try {
                f4089a = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f4089a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            f4090b = true;
        }
    }
}
