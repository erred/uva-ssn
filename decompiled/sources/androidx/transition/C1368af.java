package androidx.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.transition.af */
/* compiled from: ViewUtilsApi19 */
class C1368af extends C1371ai {

    /* renamed from: a */
    private static Method f4103a;

    /* renamed from: b */
    private static boolean f4104b;

    /* renamed from: c */
    private static Method f4105c;

    /* renamed from: d */
    private static boolean f4106d;

    /* renamed from: b */
    public void mo5721b(View view) {
    }

    /* renamed from: c */
    public void mo5722c(View view) {
    }

    C1368af() {
    }

    /* renamed from: a */
    public void mo5720a(View view, float f) {
        m5569a();
        if (f4103a != null) {
            try {
                f4103a.invoke(view, new Object[]{Float.valueOf(f)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else {
            view.setAlpha(f);
        }
    }

    /* renamed from: a */
    public float mo5719a(View view) {
        m5570b();
        if (f4105c != null) {
            try {
                return ((Float) f4105c.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.mo5719a(view);
    }

    /* renamed from: a */
    private void m5569a() {
        if (!f4104b) {
            try {
                f4103a = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f4103a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
            }
            f4104b = true;
        }
    }

    /* renamed from: b */
    private void m5570b() {
        if (!f4106d) {
            try {
                f4105c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f4105c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
            }
            f4106d = true;
        }
    }
}
