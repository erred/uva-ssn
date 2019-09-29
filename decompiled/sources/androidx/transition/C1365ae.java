package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.core.p070g.C0962r;
import java.lang.reflect.Field;

/* renamed from: androidx.transition.ae */
/* compiled from: ViewUtils */
class C1365ae {

    /* renamed from: a */
    static final Property<View, Float> f4098a = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(C1365ae.m5562c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f) {
            C1365ae.m5556a(view, f.floatValue());
        }
    };

    /* renamed from: b */
    static final Property<View, Rect> f4099b = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return C0962r.m3542B(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            C0962r.m3556a(view, rect);
        }
    };

    /* renamed from: c */
    private static final C1371ai f4100c;

    /* renamed from: d */
    private static Field f4101d;

    /* renamed from: e */
    private static boolean f4102e;

    static {
        if (VERSION.SDK_INT >= 22) {
            f4100c = new C1370ah();
        } else if (VERSION.SDK_INT >= 21) {
            f4100c = new C1369ag();
        } else if (VERSION.SDK_INT >= 19) {
            f4100c = new C1368af();
        } else {
            f4100c = new C1371ai();
        }
    }

    /* renamed from: a */
    static C1364ad m5554a(View view) {
        if (VERSION.SDK_INT >= 18) {
            return new C1363ac(view);
        }
        return C1361ab.m5541d(view);
    }

    /* renamed from: b */
    static C1378am m5560b(View view) {
        if (VERSION.SDK_INT >= 18) {
            return new C1377al(view);
        }
        return new C1376ak(view.getWindowToken());
    }

    /* renamed from: a */
    static void m5556a(View view, float f) {
        f4100c.mo5720a(view, f);
    }

    /* renamed from: c */
    static float m5562c(View view) {
        return f4100c.mo5719a(view);
    }

    /* renamed from: d */
    static void m5563d(View view) {
        f4100c.mo5721b(view);
    }

    /* renamed from: e */
    static void m5564e(View view) {
        f4100c.mo5722c(view);
    }

    /* renamed from: a */
    static void m5557a(View view, int i) {
        m5555a();
        if (f4101d != null) {
            try {
                f4101d.setInt(view, i | (f4101d.getInt(view) & -13));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* renamed from: a */
    static void m5559a(View view, Matrix matrix) {
        f4100c.mo5723a(view, matrix);
    }

    /* renamed from: b */
    static void m5561b(View view, Matrix matrix) {
        f4100c.mo5724b(view, matrix);
    }

    /* renamed from: a */
    static void m5558a(View view, int i, int i2, int i3, int i4) {
        f4100c.mo5725a(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    private static void m5555a() {
        if (!f4102e) {
            try {
                f4101d = View.class.getDeclaredField("mViewFlags");
                f4101d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f4102e = true;
        }
    }
}
