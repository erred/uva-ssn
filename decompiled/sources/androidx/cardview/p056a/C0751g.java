package androidx.cardview.p056a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.cardview.a.g */
/* compiled from: RoundRectDrawable */
class C0751g extends Drawable {

    /* renamed from: a */
    private float f2134a;

    /* renamed from: b */
    private final Paint f2135b;

    /* renamed from: c */
    private final RectF f2136c;

    /* renamed from: d */
    private final Rect f2137d;

    /* renamed from: e */
    private float f2138e;

    /* renamed from: f */
    private boolean f2139f = false;

    /* renamed from: g */
    private boolean f2140g = true;

    /* renamed from: h */
    private ColorStateList f2141h;

    /* renamed from: i */
    private PorterDuffColorFilter f2142i;

    /* renamed from: j */
    private ColorStateList f2143j;

    /* renamed from: k */
    private Mode f2144k = Mode.SRC_IN;

    public int getOpacity() {
        return -3;
    }

    C0751g(ColorStateList colorStateList, float f) {
        this.f2134a = f;
        this.f2135b = new Paint(5);
        m2668b(colorStateList);
        this.f2136c = new RectF();
        this.f2137d = new Rect();
    }

    /* renamed from: b */
    private void m2668b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2141h = colorStateList;
        this.f2135b.setColor(this.f2141h.getColorForState(getState(), this.f2141h.getDefaultColor()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2979a(float f, boolean z, boolean z2) {
        if (f != this.f2138e || this.f2139f != z || this.f2140g != z2) {
            this.f2138e = f;
            this.f2139f = z;
            this.f2140g = z2;
            m2667a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo2977a() {
        return this.f2138e;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f2135b;
        if (this.f2142i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f2142i);
            z = true;
        }
        canvas.drawRoundRect(this.f2136c, this.f2134a, this.f2134a, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    /* renamed from: a */
    private void m2667a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2136c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f2137d.set(rect);
        if (this.f2139f) {
            float a = C0752h.m2675a(this.f2138e, this.f2134a, this.f2140g);
            this.f2137d.inset((int) Math.ceil((double) C0752h.m2678b(this.f2138e, this.f2134a, this.f2140g)), (int) Math.ceil((double) a));
            this.f2136c.set(this.f2137d);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m2667a(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2137d, this.f2134a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2978a(float f) {
        if (f != this.f2134a) {
            this.f2134a = f;
            m2667a((Rect) null);
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        this.f2135b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2135b.setColorFilter(colorFilter);
    }

    /* renamed from: b */
    public float mo2981b() {
        return this.f2134a;
    }

    /* renamed from: a */
    public void mo2980a(ColorStateList colorStateList) {
        m2668b(colorStateList);
        invalidateSelf();
    }

    /* renamed from: c */
    public ColorStateList mo2982c() {
        return this.f2141h;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2143j = colorStateList;
        this.f2142i = m2666a(this.f2143j, this.f2144k);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f2144k = mode;
        this.f2142i = m2666a(this.f2143j, this.f2144k);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.f2141h.getColorForState(iArr, this.f2141h.getDefaultColor());
        boolean z = colorForState != this.f2135b.getColor();
        if (z) {
            this.f2135b.setColor(colorForState);
        }
        if (this.f2143j == null || this.f2144k == null) {
            return z;
        }
        this.f2142i = m2666a(this.f2143j, this.f2144k);
        return true;
    }

    public boolean isStateful() {
        return (this.f2143j != null && this.f2143j.isStateful()) || (this.f2141h != null && this.f2141h.isStateful()) || super.isStateful();
    }

    /* renamed from: a */
    private PorterDuffColorFilter m2666a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
