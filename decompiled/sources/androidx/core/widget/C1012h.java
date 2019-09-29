package androidx.core.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.p070g.C0946c;
import androidx.core.p070g.C0962r;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: androidx.core.widget.h */
/* compiled from: PopupWindowCompat */
public final class C1012h {

    /* renamed from: a */
    private static Method f3150a;

    /* renamed from: b */
    private static boolean f3151b;

    /* renamed from: c */
    private static Field f3152c;

    /* renamed from: d */
    private static boolean f3153d;

    /* renamed from: a */
    public static void m3858a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((C0946c.m3493a(i3, C0962r.m3579f(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    /* renamed from: a */
    public static void m3859a(PopupWindow popupWindow, boolean z) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (VERSION.SDK_INT >= 21) {
            if (!f3153d) {
                try {
                    f3152c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f3152c.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                f3153d = true;
            }
            if (f3152c != null) {
                try {
                    f3152c.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m3857a(PopupWindow popupWindow, int i) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!f3151b) {
            try {
                f3150a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f3150a.setAccessible(true);
            } catch (Exception unused) {
            }
            f3151b = true;
        }
        if (f3150a != null) {
            try {
                f3150a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception unused2) {
            }
        }
    }
}
