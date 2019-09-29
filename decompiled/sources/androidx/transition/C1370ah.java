package androidx.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.transition.ah */
/* compiled from: ViewUtilsApi22 */
class C1370ah extends C1369ag {

    /* renamed from: a */
    private static Method f4111a;

    /* renamed from: b */
    private static boolean f4112b;

    C1370ah() {
    }

    /* renamed from: a */
    public void mo5725a(View view, int i, int i2, int i3, int i4) {
        m5579a();
        if (f4111a != null) {
            try {
                f4111a.invoke(view, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: a */
    private void m5579a() {
        if (!f4112b) {
            try {
                f4111a = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f4111a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
            }
            f4112b = true;
        }
    }
}
