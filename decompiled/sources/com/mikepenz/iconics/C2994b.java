package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.mikepenz.iconics.p129b.C2995a;
import com.mikepenz.iconics.p129b.C2996b;

/* renamed from: com.mikepenz.iconics.b */
/* compiled from: IconicsDrawable */
public class C2994b extends Drawable {

    /* renamed from: A */
    private float f7802A = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: B */
    private float f7803B = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: C */
    private int f7804C = 0;

    /* renamed from: D */
    private C2995a f7805D;

    /* renamed from: E */
    private String f7806E;

    /* renamed from: F */
    private ColorStateList f7807F;

    /* renamed from: G */
    private Mode f7808G = Mode.SRC_IN;

    /* renamed from: H */
    private ColorFilter f7809H;

    /* renamed from: I */
    private ColorFilter f7810I;

    /* renamed from: a */
    private Context f7811a;

    /* renamed from: b */
    private int f7812b = -1;

    /* renamed from: c */
    private int f7813c = -1;

    /* renamed from: d */
    private boolean f7814d = false;

    /* renamed from: e */
    private ColorStateList f7815e;

    /* renamed from: f */
    private Paint f7816f;

    /* renamed from: g */
    private int f7817g;

    /* renamed from: h */
    private int f7818h;

    /* renamed from: i */
    private Paint f7819i;

    /* renamed from: j */
    private int f7820j;

    /* renamed from: k */
    private Paint f7821k;

    /* renamed from: l */
    private Paint f7822l;

    /* renamed from: m */
    private int f7823m = -1;

    /* renamed from: n */
    private int f7824n = -1;

    /* renamed from: o */
    private Rect f7825o;

    /* renamed from: p */
    private RectF f7826p;

    /* renamed from: q */
    private Path f7827q;

    /* renamed from: r */
    private int f7828r;

    /* renamed from: s */
    private int f7829s;

    /* renamed from: t */
    private int f7830t;

    /* renamed from: u */
    private int f7831u = 0;

    /* renamed from: v */
    private int f7832v = 0;

    /* renamed from: w */
    private int f7833w = 255;

    /* renamed from: x */
    private boolean f7834x;

    /* renamed from: y */
    private boolean f7835y;

    /* renamed from: z */
    private float f7836z = BitmapDescriptorFactory.HUE_RED;

    public boolean isStateful() {
        return true;
    }

    public C2994b(Context context) {
        this.f7811a = context.getApplicationContext();
        m8823b();
        mo27345a(Character.valueOf(' '));
    }

    /* renamed from: a */
    public C2994b clone() {
        C2994b a = new C2994b(this.f7811a).mo27352c(this.f7828r).mo27367j(this.f7823m).mo27368k(this.f7824n).mo27357e(this.f7812b).mo27358f(this.f7813c).mo27341a(this.f7831u).mo27349b(this.f7832v).mo27364h(this.f7818h).mo27370m(this.f7829s).mo27340a(this.f7836z, this.f7802A, this.f7803B, this.f7804C).mo27365i(this.f7820j).mo27359g(this.f7817g).mo27371n(this.f7830t).mo27342a(this.f7815e).mo27372o(this.f7833w).mo27348a(this.f7834x).mo27351b(this.f7835y).mo27343a(this.f7816f.getTypeface());
        if (this.f7805D != null) {
            a.mo27344a(this.f7805D);
        } else if (this.f7806E != null) {
            a.mo27350b(this.f7806E);
        }
        return a;
    }

    /* renamed from: a */
    public C2994b mo27346a(String str) {
        try {
            C2996b a = C2981a.m8783a(this.f7811a, str.substring(0, 3));
            String replace = str.replace("-", "_");
            try {
                mo27344a(a.getIcon(replace));
            } catch (Exception unused) {
                str = replace;
            }
        } catch (Exception unused2) {
            String str2 = C2981a.f7762a;
            StringBuilder sb = new StringBuilder();
            sb.append("Wrong icon name: ");
            sb.append(str);
            Log.e(str2, sb.toString());
            return this;
        }
        return this;
    }

    /* renamed from: a */
    public C2994b mo27345a(Character ch) {
        return mo27347a(ch.toString(), (Typeface) null);
    }

    /* renamed from: b */
    public C2994b mo27350b(String str) {
        return mo27347a(str, (Typeface) null);
    }

    /* renamed from: a */
    public C2994b mo27347a(String str, Typeface typeface) {
        this.f7806E = str;
        this.f7805D = null;
        Paint paint = this.f7816f;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        paint.setTypeface(typeface);
        invalidateSelf();
        return this;
    }

    /* renamed from: a */
    public C2994b mo27344a(C2995a aVar) {
        this.f7805D = aVar;
        this.f7806E = null;
        this.f7816f.setTypeface(aVar.mo27306b().getTypeface(this.f7811a));
        invalidateSelf();
        return this;
    }

    /* renamed from: a */
    public C2994b mo27342a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f7815e = colorStateList;
            m8825c();
        }
        return this;
    }

    /* renamed from: a */
    public C2994b mo27341a(int i) {
        this.f7831u = i;
        invalidateSelf();
        return this;
    }

    /* renamed from: b */
    public C2994b mo27349b(int i) {
        this.f7832v = i;
        invalidateSelf();
        return this;
    }

    /* renamed from: c */
    public C2994b mo27352c(int i) {
        if (this.f7828r != i) {
            this.f7828r = i;
            if (this.f7834x) {
                this.f7828r += this.f7829s;
            }
            if (this.f7835y) {
                this.f7828r += this.f7830t;
            }
            invalidateSelf();
        }
        return this;
    }

    /* renamed from: d */
    public C2994b mo27355d(int i) {
        this.f7813c = i;
        this.f7812b = i;
        setBounds(0, 0, this.f7812b, this.f7813c);
        invalidateSelf();
        return this;
    }

    /* renamed from: e */
    public C2994b mo27357e(int i) {
        this.f7812b = i;
        setBounds(0, 0, this.f7812b, this.f7813c);
        invalidateSelf();
        return this;
    }

    /* renamed from: f */
    public C2994b mo27358f(int i) {
        this.f7813c = i;
        setBounds(0, 0, this.f7812b, this.f7813c);
        invalidateSelf();
        return this;
    }

    /* renamed from: g */
    public C2994b mo27359g(int i) {
        this.f7822l.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.f7822l.setAlpha(Color.alpha(i));
        this.f7817g = i;
        invalidateSelf();
        return this;
    }

    /* renamed from: h */
    public C2994b mo27364h(int i) {
        this.f7819i.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.f7819i.setAlpha(Color.alpha(i));
        this.f7818h = i;
        invalidateSelf();
        return this;
    }

    /* renamed from: i */
    public C2994b mo27365i(int i) {
        this.f7821k.setColor(i);
        this.f7820j = i;
        if (this.f7823m == -1) {
            this.f7823m = 0;
        }
        if (this.f7824n == -1) {
            this.f7824n = 0;
        }
        invalidateSelf();
        return this;
    }

    /* renamed from: j */
    public C2994b mo27367j(int i) {
        this.f7823m = i;
        invalidateSelf();
        return this;
    }

    /* renamed from: k */
    public C2994b mo27368k(int i) {
        this.f7824n = i;
        invalidateSelf();
        return this;
    }

    /* renamed from: l */
    public C2994b mo27369l(int i) {
        this.f7824n = i;
        this.f7823m = i;
        invalidateSelf();
        return this;
    }

    /* renamed from: m */
    public C2994b mo27370m(int i) {
        this.f7829s = i;
        this.f7819i.setStrokeWidth((float) this.f7829s);
        mo27348a(true);
        invalidateSelf();
        return this;
    }

    /* renamed from: a */
    public C2994b mo27340a(float f, float f2, float f3, int i) {
        this.f7836z = f;
        this.f7802A = f2;
        this.f7803B = f3;
        this.f7804C = i;
        this.f7816f.setShadowLayer(f, f2, f3, i);
        invalidateSelf();
        return this;
    }

    /* renamed from: n */
    public C2994b mo27371n(int i) {
        this.f7830t = i;
        this.f7822l.setStrokeWidth((float) this.f7830t);
        mo27351b(true);
        invalidateSelf();
        return this;
    }

    /* renamed from: a */
    public C2994b mo27348a(boolean z) {
        if (this.f7834x != z) {
            this.f7834x = z;
            this.f7828r += (this.f7834x ? 1 : -1) * this.f7829s;
            invalidateSelf();
        }
        return this;
    }

    /* renamed from: b */
    public C2994b mo27351b(boolean z) {
        if (this.f7835y != z) {
            this.f7835y = z;
            this.f7828r += (this.f7835y ? 1 : -1) * this.f7830t * 2;
            invalidateSelf();
        }
        return this;
    }

    /* renamed from: o */
    public C2994b mo27372o(int i) {
        setAlpha(i);
        return this;
    }

    /* renamed from: a */
    public C2994b mo27343a(Typeface typeface) {
        this.f7816f.setTypeface(typeface);
        invalidateSelf();
        return this;
    }

    public void draw(Canvas canvas) {
        if (this.f7805D != null || this.f7806E != null) {
            Rect bounds = getBounds();
            m8822a(bounds);
            m8824b(bounds);
            m8826c(bounds);
            if (this.f7821k != null && this.f7824n > -1 && this.f7823m > -1) {
                if (!this.f7835y || this.f7822l == null) {
                    canvas.drawRoundRect(new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) bounds.width(), (float) bounds.height()), (float) this.f7823m, (float) this.f7824n, this.f7821k);
                } else {
                    float f = (float) (this.f7830t / 2);
                    RectF rectF = new RectF(f, f, ((float) bounds.width()) - f, ((float) bounds.height()) - f);
                    canvas.drawRoundRect(rectF, (float) this.f7823m, (float) this.f7824n, this.f7821k);
                    canvas.drawRoundRect(rectF, (float) this.f7823m, (float) this.f7824n, this.f7822l);
                }
            }
            try {
                this.f7827q.close();
            } catch (Exception unused) {
            }
            if (this.f7834x) {
                canvas.drawPath(this.f7827q, this.f7819i);
            }
            this.f7816f.setAlpha(this.f7833w);
            this.f7816f.setColorFilter(this.f7810I == null ? this.f7809H : this.f7810I);
            canvas.drawPath(this.f7827q, this.f7816f);
        }
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f7807F = colorStateList;
        this.f7809H = m8821a(colorStateList, this.f7808G);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f7808G = mode;
        this.f7809H = m8821a(this.f7807F, mode);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        m8826c(rect);
        try {
            this.f7827q.close();
        } catch (Exception unused) {
        }
        super.onBoundsChange(rect);
    }

    public boolean setState(int[] iArr) {
        return super.setState(iArr) || !((this.f7815e == null || !this.f7815e.isStateful()) && this.f7810I == null && this.f7809H == null);
    }

    public int getOpacity() {
        if (this.f7809H != null || this.f7816f.getColorFilter() != null) {
            return -3;
        }
        int alpha = getAlpha();
        if (alpha == 0) {
            return -2;
        }
        if (alpha != 255) {
            return -3;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z;
        if (this.f7815e == null || !this.f7815e.isStateful()) {
            z = false;
        } else {
            m8825c();
            z = true;
        }
        if (this.f7807F == null || this.f7808G == null) {
            return z;
        }
        this.f7809H = m8821a(this.f7807F, this.f7808G);
        invalidateSelf();
        return true;
    }

    public int getIntrinsicWidth() {
        return this.f7812b;
    }

    public int getIntrinsicHeight() {
        return this.f7813c;
    }

    public void setAlpha(int i) {
        this.f7816f.setAlpha(i);
        this.f7833w = i;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f7833w;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7810I = colorFilter;
        invalidateSelf();
    }

    public void clearColorFilter() {
        this.f7810I = null;
        invalidateSelf();
    }

    /* renamed from: b */
    private void m8823b() {
        this.f7816f = new TextPaint(1);
        this.f7816f.setStyle(Style.FILL);
        this.f7816f.setTextAlign(Align.CENTER);
        this.f7816f.setUnderlineText(false);
        this.f7816f.setAntiAlias(true);
        this.f7821k = new Paint(1);
        this.f7819i = new Paint(1);
        this.f7819i.setStyle(Style.STROKE);
        this.f7822l = new Paint(1);
        this.f7822l.setStyle(Style.STROKE);
        this.f7827q = new Path();
        this.f7826p = new RectF();
        this.f7825o = new Rect();
    }

    /* renamed from: a */
    private void m8822a(Rect rect) {
        if (this.f7828r >= 0 && this.f7828r * 2 <= rect.width() && this.f7828r * 2 <= rect.height()) {
            this.f7825o.set(rect.left + this.f7828r, rect.top + this.f7828r, rect.right - this.f7828r, rect.bottom - this.f7828r);
        }
    }

    /* renamed from: b */
    private void m8824b(Rect rect) {
        float height = ((float) rect.height()) * ((float) (this.f7814d ? 1 : 2));
        this.f7816f.setTextSize(height);
        String valueOf = this.f7805D != null ? String.valueOf(this.f7805D.mo27305a()) : String.valueOf(this.f7806E);
        this.f7816f.getTextPath(valueOf, 0, valueOf.length(), BitmapDescriptorFactory.HUE_RED, (float) rect.height(), this.f7827q);
        this.f7827q.computeBounds(this.f7826p, true);
        if (!this.f7814d) {
            float width = ((float) this.f7825o.width()) / this.f7826p.width();
            float height2 = ((float) this.f7825o.height()) / this.f7826p.height();
            if (width >= height2) {
                width = height2;
            }
            this.f7816f.setTextSize(height * width);
            this.f7816f.getTextPath(valueOf, 0, valueOf.length(), BitmapDescriptorFactory.HUE_RED, (float) rect.height(), this.f7827q);
            this.f7827q.computeBounds(this.f7826p, true);
        }
    }

    /* renamed from: c */
    private void m8826c(Rect rect) {
        this.f7827q.offset(((((float) rect.centerX()) - (this.f7826p.width() / 2.0f)) - this.f7826p.left) + ((float) this.f7831u), ((((float) rect.centerY()) - (this.f7826p.height() / 2.0f)) - this.f7826p.top) + ((float) this.f7832v));
    }

    /* renamed from: c */
    private void m8825c() {
        boolean z;
        int colorForState = this.f7815e.getColorForState(getState(), this.f7815e.getDefaultColor());
        int rgb = Color.rgb(Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState));
        if (rgb != this.f7816f.getColor()) {
            this.f7816f.setColor(rgb);
            z = true;
        } else {
            z = false;
        }
        int alpha = Color.alpha(colorForState);
        if (alpha != 255 && alpha != this.f7833w) {
            setAlpha(alpha);
        } else if (z) {
            invalidateSelf();
        }
    }

    /* renamed from: a */
    private PorterDuffColorFilter m8821a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
