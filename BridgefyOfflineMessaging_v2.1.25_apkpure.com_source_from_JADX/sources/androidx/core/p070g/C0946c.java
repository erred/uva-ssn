package androidx.core.p070g;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* renamed from: androidx.core.g.c */
/* compiled from: GravityCompat */
public final class C0946c {
    /* renamed from: a */
    public static void m3494a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        if (VERSION.SDK_INT >= 17) {
            Gravity.apply(i, i2, i3, rect, rect2, i4);
        } else {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    /* renamed from: a */
    public static int m3493a(int i, int i2) {
        return VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i, i2) : i & -8388609;
    }
}
