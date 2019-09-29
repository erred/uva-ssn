package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.content.p066a.C0886f;
import androidx.core.content.p066a.C0886f.C0887a;

/* renamed from: androidx.appcompat.widget.av */
/* compiled from: TintTypedArray */
public class C0645av {

    /* renamed from: a */
    private final Context f1860a;

    /* renamed from: b */
    private final TypedArray f1861b;

    /* renamed from: c */
    private TypedValue f1862c;

    /* renamed from: a */
    public static C0645av m2229a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0645av(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: a */
    public static C0645av m2230a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0645av(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: a */
    public static C0645av m2228a(Context context, int i, int[] iArr) {
        return new C0645av(context, context.obtainStyledAttributes(i, iArr));
    }

    private C0645av(Context context, TypedArray typedArray) {
        this.f1860a = context;
        this.f1861b = typedArray;
    }

    /* renamed from: a */
    public Drawable mo2449a(int i) {
        if (this.f1861b.hasValue(i)) {
            int resourceId = this.f1861b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0424a.m1270b(this.f1860a, resourceId);
            }
        }
        return this.f1861b.getDrawable(i);
    }

    /* renamed from: b */
    public Drawable mo2454b(int i) {
        if (this.f1861b.hasValue(i)) {
            int resourceId = this.f1861b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0680k.m2397a().mo2591a(this.f1860a, resourceId, true);
            }
        }
        return null;
    }

    /* renamed from: a */
    public Typeface mo2448a(int i, int i2, C0887a aVar) {
        int resourceId = this.f1861b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1862c == null) {
            this.f1862c = new TypedValue();
        }
        return C0886f.m3293a(this.f1860a, resourceId, this.f1862c, i2, aVar);
    }

    /* renamed from: c */
    public CharSequence mo2456c(int i) {
        return this.f1861b.getText(i);
    }

    /* renamed from: d */
    public String mo2458d(int i) {
        return this.f1861b.getString(i);
    }

    /* renamed from: a */
    public boolean mo2451a(int i, boolean z) {
        return this.f1861b.getBoolean(i, z);
    }

    /* renamed from: a */
    public int mo2447a(int i, int i2) {
        return this.f1861b.getInt(i, i2);
    }

    /* renamed from: a */
    public float mo2446a(int i, float f) {
        return this.f1861b.getFloat(i, f);
    }

    /* renamed from: b */
    public int mo2453b(int i, int i2) {
        return this.f1861b.getColor(i, i2);
    }

    /* renamed from: e */
    public ColorStateList mo2460e(int i) {
        if (this.f1861b.hasValue(i)) {
            int resourceId = this.f1861b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = C0424a.m1267a(this.f1860a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.f1861b.getColorStateList(i);
    }

    /* renamed from: c */
    public int mo2455c(int i, int i2) {
        return this.f1861b.getInteger(i, i2);
    }

    /* renamed from: b */
    public float mo2452b(int i, float f) {
        return this.f1861b.getDimension(i, f);
    }

    /* renamed from: d */
    public int mo2457d(int i, int i2) {
        return this.f1861b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: e */
    public int mo2459e(int i, int i2) {
        return this.f1861b.getDimensionPixelSize(i, i2);
    }

    /* renamed from: f */
    public int mo2461f(int i, int i2) {
        return this.f1861b.getLayoutDimension(i, i2);
    }

    /* renamed from: g */
    public int mo2463g(int i, int i2) {
        return this.f1861b.getResourceId(i, i2);
    }

    /* renamed from: f */
    public CharSequence[] mo2462f(int i) {
        return this.f1861b.getTextArray(i);
    }

    /* renamed from: g */
    public boolean mo2464g(int i) {
        return this.f1861b.hasValue(i);
    }

    /* renamed from: a */
    public void mo2450a() {
        this.f1861b.recycle();
    }
}
