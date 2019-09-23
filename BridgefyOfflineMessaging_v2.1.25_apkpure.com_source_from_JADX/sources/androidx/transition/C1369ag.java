package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.transition.ag */
/* compiled from: ViewUtilsApi21 */
class C1369ag extends C1368af {

    /* renamed from: a */
    private static Method f4107a;

    /* renamed from: b */
    private static boolean f4108b;

    /* renamed from: c */
    private static Method f4109c;

    /* renamed from: d */
    private static boolean f4110d;

    C1369ag() {
    }

    /* renamed from: a */
    public void mo5723a(View view, Matrix matrix) {
        m5575a();
        if (f4107a != null) {
            try {
                f4107a.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    /* renamed from: b */
    public void mo5724b(View view, Matrix matrix) {
        m5576b();
        if (f4109c != null) {
            try {
                f4109c.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    /* renamed from: a */
    private void m5575a() {
        if (!f4108b) {
            try {
                f4107a = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                f4107a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
            }
            f4108b = true;
        }
    }

    /* renamed from: b */
    private void m5576b() {
        if (!f4110d) {
            try {
                f4109c = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                f4109c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
            }
            f4110d = true;
        }
    }
}
