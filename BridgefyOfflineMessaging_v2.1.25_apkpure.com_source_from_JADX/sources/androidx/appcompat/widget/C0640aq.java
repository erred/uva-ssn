package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.C0977a;

/* renamed from: androidx.appcompat.widget.aq */
/* compiled from: ThemeUtils */
class C0640aq {

    /* renamed from: a */
    static final int[] f1841a = {-16842910};

    /* renamed from: b */
    static final int[] f1842b = {16842908};

    /* renamed from: c */
    static final int[] f1843c = {16843518};

    /* renamed from: d */
    static final int[] f1844d = {16842919};

    /* renamed from: e */
    static final int[] f1845e = {16842912};

    /* renamed from: f */
    static final int[] f1846f = {16842913};

    /* renamed from: g */
    static final int[] f1847g = {-16842919, -16842908};

    /* renamed from: h */
    static final int[] f1848h = new int[0];

    /* renamed from: i */
    private static final ThreadLocal<TypedValue> f1849i = new ThreadLocal<>();

    /* renamed from: j */
    private static final int[] f1850j = new int[1];

    /* renamed from: a */
    public static int m2218a(Context context, int i) {
        f1850j[0] = i;
        C0645av a = C0645av.m2229a(context, (AttributeSet) null, f1850j);
        try {
            return a.mo2453b(0, 0);
        } finally {
            a.mo2450a();
        }
    }

    /* renamed from: b */
    public static ColorStateList m2221b(Context context, int i) {
        f1850j[0] = i;
        C0645av a = C0645av.m2229a(context, (AttributeSet) null, f1850j);
        try {
            return a.mo2460e(0);
        } finally {
            a.mo2450a();
        }
    }

    /* renamed from: c */
    public static int m2222c(Context context, int i) {
        ColorStateList b = m2221b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1841a, b.getDefaultColor());
        }
        TypedValue a = m2220a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m2219a(context, i, a.getFloat());
    }

    /* renamed from: a */
    private static TypedValue m2220a() {
        TypedValue typedValue = (TypedValue) f1849i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1849i.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: a */
    static int m2219a(Context context, int i, float f) {
        int a = m2218a(context, i);
        return C0977a.m3660b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
