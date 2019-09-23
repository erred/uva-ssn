package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.transition.z */
/* compiled from: ViewGroupUtilsApi14 */
class C1430z {

    /* renamed from: a */
    private static LayoutTransition f4241a;

    /* renamed from: b */
    private static Field f4242b;

    /* renamed from: c */
    private static boolean f4243c;

    /* renamed from: d */
    private static Method f4244d;

    /* renamed from: e */
    private static boolean f4245e;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m5727a(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = f4241a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x002a
            androidx.transition.z$1 r0 = new androidx.transition.z$1
            r0.<init>()
            f4241a = r0
            android.animation.LayoutTransition r0 = f4241a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = f4241a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = f4241a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = f4241a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = f4241a
            r4 = 4
            r0.setAnimator(r4, r3)
        L_0x002a:
            if (r6 == 0) goto L_0x004a
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L_0x0044
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L_0x003b
            m5726a(r6)
        L_0x003b:
            android.animation.LayoutTransition r0 = f4241a
            if (r6 == r0) goto L_0x0044
            int r0 = androidx.transition.R.id.transition_layout_save
            r5.setTag(r0, r6)
        L_0x0044:
            android.animation.LayoutTransition r6 = f4241a
            r5.setLayoutTransition(r6)
            goto L_0x009e
        L_0x004a:
            r5.setLayoutTransition(r3)
            boolean r6 = f4243c
            if (r6 != 0) goto L_0x006a
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r0 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0061 }
            f4242b = r6     // Catch:{ NoSuchFieldException -> 0x0061 }
            java.lang.reflect.Field r6 = f4242b     // Catch:{ NoSuchFieldException -> 0x0061 }
            r6.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x0061 }
            goto L_0x0068
        L_0x0061:
            java.lang.String r6 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r6, r0)
        L_0x0068:
            f4243c = r1
        L_0x006a:
            java.lang.reflect.Field r6 = f4242b
            if (r6 == 0) goto L_0x0087
            java.lang.reflect.Field r6 = f4242b     // Catch:{ IllegalAccessException -> 0x0080 }
            boolean r6 = r6.getBoolean(r5)     // Catch:{ IllegalAccessException -> 0x0080 }
            if (r6 == 0) goto L_0x007e
            java.lang.reflect.Field r0 = f4242b     // Catch:{ IllegalAccessException -> 0x007c }
            r0.setBoolean(r5, r2)     // Catch:{ IllegalAccessException -> 0x007c }
            goto L_0x007e
        L_0x007c:
            r2 = r6
            goto L_0x0080
        L_0x007e:
            r2 = r6
            goto L_0x0087
        L_0x0080:
            java.lang.String r6 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r6, r0)
        L_0x0087:
            if (r2 == 0) goto L_0x008c
            r5.requestLayout()
        L_0x008c:
            int r6 = androidx.transition.R.id.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L_0x009e
            int r0 = androidx.transition.R.id.transition_layout_save
            r5.setTag(r0, r3)
            r5.setLayoutTransition(r6)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.C1430z.m5727a(android.view.ViewGroup, boolean):void");
    }

    /* renamed from: a */
    private static void m5726a(LayoutTransition layoutTransition) {
        if (!f4245e) {
            try {
                f4244d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f4244d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f4245e = true;
        }
        if (f4244d != null) {
            try {
                f4244d.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
