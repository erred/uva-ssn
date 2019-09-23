package androidx.cardview.p056a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.cardview.a.h */
/* compiled from: RoundRectDrawableWithShadow */
class C0752h extends Drawable {

    /* renamed from: a */
    static C0753a f2145a;

    /* renamed from: b */
    private static final double f2146b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    private final int f2147c;

    /* renamed from: d */
    private Paint f2148d;

    /* renamed from: e */
    private Paint f2149e;

    /* renamed from: f */
    private Paint f2150f;

    /* renamed from: g */
    private final RectF f2151g;

    /* renamed from: h */
    private float f2152h;

    /* renamed from: i */
    private Path f2153i;

    /* renamed from: j */
    private float f2154j;

    /* renamed from: k */
    private float f2155k;

    /* renamed from: l */
    private float f2156l;

    /* renamed from: m */
    private ColorStateList f2157m;

    /* renamed from: n */
    private boolean f2158n = true;

    /* renamed from: o */
    private final int f2159o;

    /* renamed from: p */
    private final int f2160p;

    /* renamed from: q */
    private boolean f2161q = true;

    /* renamed from: r */
    private boolean f2162r = false;

    /* renamed from: androidx.cardview.a.h$a */
    /* compiled from: RoundRectDrawableWithShadow */
    interface C0753a {
        /* renamed from: a */
        void mo2962a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return -3;
    }

    C0752h(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f2159o = resources.getColor(R.color.cardview_shadow_start_color);
        this.f2160p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f2147c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.f2148d = new Paint(5);
        m2679b(colorStateList);
        this.f2149e = new Paint(5);
        this.f2149e.setStyle(Style.FILL);
        this.f2152h = (float) ((int) (f + 0.5f));
        this.f2151g = new RectF();
        this.f2150f = new Paint(this.f2149e);
        this.f2150f.setAntiAlias(false);
        m2676a(f2, f3);
    }

    /* renamed from: b */
    private void m2679b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2157m = colorStateList;
        this.f2148d.setColor(this.f2157m.getColorForState(getState(), this.f2157m.getDefaultColor()));
    }

    /* renamed from: d */
    private int m2681d(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2997a(boolean z) {
        this.f2161q = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f2148d.setAlpha(i);
        this.f2149e.setAlpha(i);
        this.f2150f.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2158n = true;
    }

    /* renamed from: a */
    private void m2676a(float f, float f2) {
        if (f < BitmapDescriptorFactory.HUE_RED) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid shadow size ");
            sb.append(f);
            sb.append(". Must be >= 0");
            throw new IllegalArgumentException(sb.toString());
        } else if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            float d = (float) m2681d(f);
            float d2 = (float) m2681d(f2);
            if (d > d2) {
                if (!this.f2162r) {
                    this.f2162r = true;
                }
                d = d2;
            }
            if (this.f2156l != d || this.f2154j != d2) {
                this.f2156l = d;
                this.f2154j = d2;
                this.f2155k = (float) ((int) ((d * 1.5f) + ((float) this.f2147c) + 0.5f));
                this.f2158n = true;
                invalidateSelf();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid max shadow size ");
            sb2.append(f2);
            sb2.append(". Must be >= 0");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m2675a(this.f2154j, this.f2152h, this.f2161q));
        int ceil2 = (int) Math.ceil((double) m2678b(this.f2154j, this.f2152h, this.f2161q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* renamed from: a */
    static float m2675a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f2146b) * ((double) f2))) : f * 1.5f;
    }

    /* renamed from: b */
    static float m2678b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f2146b) * ((double) f2))) : f;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.f2157m.getColorForState(iArr, this.f2157m.getDefaultColor());
        if (this.f2148d.getColor() == colorForState) {
            return false;
        }
        this.f2148d.setColor(colorForState);
        this.f2158n = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        return (this.f2157m != null && this.f2157m.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2148d.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2994a(float f) {
        if (f >= BitmapDescriptorFactory.HUE_RED) {
            float f2 = (float) ((int) (f + 0.5f));
            if (this.f2152h != f2) {
                this.f2152h = f2;
                this.f2158n = true;
                invalidateSelf();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid radius ");
        sb.append(f);
        sb.append(". Must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    public void draw(Canvas canvas) {
        if (this.f2158n) {
            m2680b(getBounds());
            this.f2158n = false;
        }
        canvas.translate(BitmapDescriptorFactory.HUE_RED, this.f2156l / 2.0f);
        m2677a(canvas);
        canvas.translate(BitmapDescriptorFactory.HUE_RED, (-this.f2156l) / 2.0f);
        f2145a.mo2962a(canvas, this.f2151g, this.f2152h, this.f2148d);
    }

    /* renamed from: a */
    private void m2677a(Canvas canvas) {
        float f = (-this.f2152h) - this.f2155k;
        float f2 = this.f2152h + ((float) this.f2147c) + (this.f2156l / 2.0f);
        float f3 = f2 * 2.0f;
        boolean z = this.f2151g.width() - f3 > BitmapDescriptorFactory.HUE_RED;
        boolean z2 = this.f2151g.height() - f3 > BitmapDescriptorFactory.HUE_RED;
        int save = canvas.save();
        canvas.translate(this.f2151g.left + f2, this.f2151g.top + f2);
        canvas.drawPath(this.f2153i, this.f2149e);
        if (z) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f, this.f2151g.width() - f3, -this.f2152h, this.f2150f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f2151g.right - f2, this.f2151g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f2153i, this.f2149e);
        if (z) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f, this.f2151g.width() - f3, (-this.f2152h) + this.f2155k, this.f2150f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f2151g.left + f2, this.f2151g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f2153i, this.f2149e);
        if (z2) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f, this.f2151g.height() - f3, -this.f2152h, this.f2150f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.f2151g.right - f2, this.f2151g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2153i, this.f2149e);
        if (z2) {
            canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f, this.f2151g.height() - f3, -this.f2152h, this.f2150f);
        }
        canvas.restoreToCount(save4);
    }

    /* renamed from: g */
    private void m2682g() {
        RectF rectF = new RectF(-this.f2152h, -this.f2152h, this.f2152h, this.f2152h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f2155k, -this.f2155k);
        if (this.f2153i == null) {
            this.f2153i = new Path();
        } else {
            this.f2153i.reset();
        }
        this.f2153i.setFillType(FillType.EVEN_ODD);
        this.f2153i.moveTo(-this.f2152h, BitmapDescriptorFactory.HUE_RED);
        this.f2153i.rLineTo(-this.f2155k, BitmapDescriptorFactory.HUE_RED);
        this.f2153i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f2153i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f2153i.close();
        float f = this.f2152h / (this.f2152h + this.f2155k);
        Paint paint = this.f2149e;
        RadialGradient radialGradient = new RadialGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.f2152h + this.f2155k, new int[]{this.f2159o, this.f2159o, this.f2160p}, new float[]{0.0f, f, 1.0f}, TileMode.CLAMP);
        paint.setShader(radialGradient);
        Paint paint2 = this.f2150f;
        LinearGradient linearGradient = new LinearGradient(BitmapDescriptorFactory.HUE_RED, (-this.f2152h) + this.f2155k, BitmapDescriptorFactory.HUE_RED, (-this.f2152h) - this.f2155k, new int[]{this.f2159o, this.f2159o, this.f2160p}, new float[]{BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f}, TileMode.CLAMP);
        paint2.setShader(linearGradient);
        this.f2150f.setAntiAlias(false);
    }

    /* renamed from: b */
    private void m2680b(Rect rect) {
        float f = this.f2154j * 1.5f;
        this.f2151g.set(((float) rect.left) + this.f2154j, ((float) rect.top) + f, ((float) rect.right) - this.f2154j, ((float) rect.bottom) - f);
        m2682g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo2993a() {
        return this.f2152h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2996a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo2999b(float f) {
        m2676a(f, this.f2154j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo3001c(float f) {
        m2676a(this.f2156l, f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo2998b() {
        return this.f2156l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo3000c() {
        return this.f2154j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public float mo3002d() {
        return (Math.max(this.f2154j, this.f2152h + ((float) this.f2147c) + (this.f2154j / 2.0f)) * 2.0f) + ((this.f2154j + ((float) this.f2147c)) * 2.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public float mo3004e() {
        return (Math.max(this.f2154j, this.f2152h + ((float) this.f2147c) + ((this.f2154j * 1.5f) / 2.0f)) * 2.0f) + (((this.f2154j * 1.5f) + ((float) this.f2147c)) * 2.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2995a(ColorStateList colorStateList) {
        m2679b(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public ColorStateList mo3005f() {
        return this.f2157m;
    }
}
