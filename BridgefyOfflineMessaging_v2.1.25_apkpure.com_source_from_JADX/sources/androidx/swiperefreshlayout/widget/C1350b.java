package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.p069f.C0930e;
import androidx.p076e.p077a.p078a.C1046b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.swiperefreshlayout.widget.b */
/* compiled from: CircularProgressDrawable */
public class C1350b extends Drawable implements Animatable {

    /* renamed from: c */
    private static final Interpolator f4055c = new LinearInterpolator();

    /* renamed from: d */
    private static final Interpolator f4056d = new C1046b();

    /* renamed from: e */
    private static final int[] f4057e = {-16777216};

    /* renamed from: a */
    float f4058a;

    /* renamed from: b */
    boolean f4059b;

    /* renamed from: f */
    private final C1353a f4060f = new C1353a();

    /* renamed from: g */
    private float f4061g;

    /* renamed from: h */
    private Resources f4062h;

    /* renamed from: i */
    private Animator f4063i;

    /* renamed from: androidx.swiperefreshlayout.widget.b$a */
    /* compiled from: CircularProgressDrawable */
    private static class C1353a {

        /* renamed from: a */
        final RectF f4068a = new RectF();

        /* renamed from: b */
        final Paint f4069b = new Paint();

        /* renamed from: c */
        final Paint f4070c = new Paint();

        /* renamed from: d */
        final Paint f4071d = new Paint();

        /* renamed from: e */
        float f4072e = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: f */
        float f4073f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g */
        float f4074g = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: h */
        float f4075h = 5.0f;

        /* renamed from: i */
        int[] f4076i;

        /* renamed from: j */
        int f4077j;

        /* renamed from: k */
        float f4078k;

        /* renamed from: l */
        float f4079l;

        /* renamed from: m */
        float f4080m;

        /* renamed from: n */
        boolean f4081n;

        /* renamed from: o */
        Path f4082o;

        /* renamed from: p */
        float f4083p = 1.0f;

        /* renamed from: q */
        float f4084q;

        /* renamed from: r */
        int f4085r;

        /* renamed from: s */
        int f4086s;

        /* renamed from: t */
        int f4087t = 255;

        /* renamed from: u */
        int f4088u;

        C1353a() {
            this.f4069b.setStrokeCap(Cap.SQUARE);
            this.f4069b.setAntiAlias(true);
            this.f4069b.setStyle(Style.STROKE);
            this.f4070c.setStyle(Style.FILL);
            this.f4070c.setAntiAlias(true);
            this.f4071d.setColor(0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5671a(float f, float f2) {
            this.f4085r = (int) f;
            this.f4086s = (int) f2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5674a(Canvas canvas, Rect rect) {
            RectF rectF = this.f4068a;
            float f = this.f4084q + (this.f4075h / 2.0f);
            if (this.f4084q <= BitmapDescriptorFactory.HUE_RED) {
                f = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f4085r) * this.f4083p) / 2.0f, this.f4075h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f, ((float) rect.centerY()) - f, ((float) rect.centerX()) + f, ((float) rect.centerY()) + f);
            float f2 = (this.f4072e + this.f4074g) * 360.0f;
            float f3 = ((this.f4073f + this.f4074g) * 360.0f) - f2;
            this.f4069b.setColor(this.f4088u);
            this.f4069b.setAlpha(this.f4087t);
            float f4 = this.f4075h / 2.0f;
            rectF.inset(f4, f4);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f4071d);
            float f5 = -f4;
            rectF.inset(f5, f5);
            canvas.drawArc(rectF, f2, f3, false, this.f4069b);
            mo5673a(canvas, f2, f3, rectF);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5673a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.f4081n) {
                if (this.f4082o == null) {
                    this.f4082o = new Path();
                    this.f4082o.setFillType(FillType.EVEN_ODD);
                } else {
                    this.f4082o.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (((float) this.f4085r) * this.f4083p) / 2.0f;
                this.f4082o.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                this.f4082o.lineTo(((float) this.f4085r) * this.f4083p, BitmapDescriptorFactory.HUE_RED);
                this.f4082o.lineTo((((float) this.f4085r) * this.f4083p) / 2.0f, ((float) this.f4086s) * this.f4083p);
                this.f4082o.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.f4075h / 2.0f));
                this.f4082o.close();
                this.f4070c.setColor(this.f4088u);
                this.f4070c.setAlpha(this.f4087t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f4082o, this.f4070c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5677a(int[] iArr) {
            this.f4076i = iArr;
            mo5680b(0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5672a(int i) {
            this.f4088u = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5680b(int i) {
            this.f4077j = i;
            this.f4088u = this.f4076i[this.f4077j];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo5669a() {
            return this.f4076i[mo5678b()];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo5678b() {
            return (this.f4077j + 1) % this.f4076i.length;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5681c() {
            mo5680b(mo5678b());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5675a(ColorFilter colorFilter) {
            this.f4069b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5683c(int i) {
            this.f4087t = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo5684d() {
            return this.f4087t;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5670a(float f) {
            this.f4075h = f;
            this.f4069b.setStrokeWidth(f);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5679b(float f) {
            this.f4072e = f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public float mo5686e() {
            return this.f4072e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public float mo5688f() {
            return this.f4078k;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public float mo5690g() {
            return this.f4079l;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public int mo5691h() {
            return this.f4076i[this.f4077j];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5682c(float f) {
            this.f4073f = f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: i */
        public float mo5692i() {
            return this.f4073f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo5685d(float f) {
            this.f4074g = f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo5687e(float f) {
            this.f4084q = f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5676a(boolean z) {
            if (this.f4081n != z) {
                this.f4081n = z;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo5689f(float f) {
            if (f != this.f4083p) {
                this.f4083p = f;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: j */
        public float mo5693j() {
            return this.f4080m;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: k */
        public void mo5694k() {
            this.f4078k = this.f4072e;
            this.f4079l = this.f4073f;
            this.f4080m = this.f4074g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: l */
        public void mo5695l() {
            this.f4078k = BitmapDescriptorFactory.HUE_RED;
            this.f4079l = BitmapDescriptorFactory.HUE_RED;
            this.f4080m = BitmapDescriptorFactory.HUE_RED;
            mo5679b((float) BitmapDescriptorFactory.HUE_RED);
            mo5682c((float) BitmapDescriptorFactory.HUE_RED);
            mo5685d(BitmapDescriptorFactory.HUE_RED);
        }
    }

    /* renamed from: a */
    private int m5494a(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f))) << 16) | ((i5 + ((int) (((float) (((i2 >> 8) & 255) - i5)) * f))) << 8) | (i6 + ((int) (f * ((float) ((i2 & 255) - i6)))));
    }

    public int getOpacity() {
        return -3;
    }

    public C1350b(Context context) {
        this.f4062h = ((Context) C0930e.m3403a(context)).getResources();
        this.f4060f.mo5677a(f4057e);
        mo5647a(2.5f);
        m5495a();
    }

    /* renamed from: a */
    private void m5496a(float f, float f2, float f3, float f4) {
        C1353a aVar = this.f4060f;
        float f5 = this.f4062h.getDisplayMetrics().density;
        aVar.mo5670a(f2 * f5);
        aVar.mo5687e(f * f5);
        aVar.mo5680b(0);
        aVar.mo5671a(f3 * f5, f4 * f5);
    }

    /* renamed from: a */
    public void mo5651a(int i) {
        if (i == 0) {
            m5496a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m5496a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5647a(float f) {
        this.f4060f.mo5670a(f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5652a(boolean z) {
        this.f4060f.mo5676a(z);
        invalidateSelf();
    }

    /* renamed from: b */
    public void mo5654b(float f) {
        this.f4060f.mo5689f(f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5648a(float f, float f2) {
        this.f4060f.mo5679b(f);
        this.f4060f.mo5682c(f2);
        invalidateSelf();
    }

    /* renamed from: c */
    public void mo5655c(float f) {
        this.f4060f.mo5685d(f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo5653a(int... iArr) {
        this.f4060f.mo5677a(iArr);
        this.f4060f.mo5680b(0);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f4061g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f4060f.mo5674a(canvas, bounds);
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.f4060f.mo5683c(i);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f4060f.mo5684d();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4060f.mo5675a(colorFilter);
        invalidateSelf();
    }

    /* renamed from: d */
    private void m5498d(float f) {
        this.f4061g = f;
    }

    public boolean isRunning() {
        return this.f4063i.isRunning();
    }

    public void start() {
        this.f4063i.cancel();
        this.f4060f.mo5694k();
        if (this.f4060f.mo5692i() != this.f4060f.mo5686e()) {
            this.f4059b = true;
            this.f4063i.setDuration(666);
            this.f4063i.start();
            return;
        }
        this.f4060f.mo5680b(0);
        this.f4060f.mo5695l();
        this.f4063i.setDuration(1332);
        this.f4063i.start();
    }

    public void stop() {
        this.f4063i.cancel();
        m5498d(BitmapDescriptorFactory.HUE_RED);
        this.f4060f.mo5676a(false);
        this.f4060f.mo5680b(0);
        this.f4060f.mo5695l();
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5649a(float f, C1353a aVar) {
        if (f > 0.75f) {
            aVar.mo5672a(m5494a((f - 0.75f) / 0.25f, aVar.mo5691h(), aVar.mo5669a()));
        } else {
            aVar.mo5672a(aVar.mo5691h());
        }
    }

    /* renamed from: b */
    private void m5497b(float f, C1353a aVar) {
        mo5649a(f, aVar);
        float floor = (float) (Math.floor((double) (aVar.mo5693j() / 0.8f)) + 1.0d);
        aVar.mo5679b(aVar.mo5688f() + (((aVar.mo5690g() - 0.01f) - aVar.mo5688f()) * f));
        aVar.mo5682c(aVar.mo5690g());
        aVar.mo5685d(aVar.mo5693j() + ((floor - aVar.mo5693j()) * f));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5650a(float f, C1353a aVar, boolean z) {
        float f2;
        float f3;
        if (this.f4059b) {
            m5497b(f, aVar);
        } else if (f != 1.0f || z) {
            float j = aVar.mo5693j();
            if (f < 0.5f) {
                float f4 = f / 0.5f;
                float f5 = aVar.mo5688f();
                float f6 = f5;
                f2 = (f4056d.getInterpolation(f4) * 0.79f) + 0.01f + f5;
                f3 = f6;
            } else {
                f2 = aVar.mo5688f() + 0.79f;
                f3 = f2 - (((1.0f - f4056d.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float f7 = j + (0.20999998f * f);
            float f8 = (f + this.f4058a) * 216.0f;
            aVar.mo5679b(f3);
            aVar.mo5682c(f2);
            aVar.mo5685d(f7);
            m5498d(f8);
        }
    }

    /* renamed from: a */
    private void m5495a() {
        final C1353a aVar = this.f4060f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C1350b.this.mo5649a(floatValue, aVar);
                C1350b.this.mo5650a(floatValue, aVar, false);
                C1350b.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f4055c);
        ofFloat.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                C1350b.this.f4058a = BitmapDescriptorFactory.HUE_RED;
            }

            public void onAnimationRepeat(Animator animator) {
                C1350b.this.mo5650a(1.0f, aVar, true);
                aVar.mo5694k();
                aVar.mo5681c();
                if (C1350b.this.f4059b) {
                    C1350b.this.f4059b = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    aVar.mo5676a(false);
                    return;
                }
                C1350b.this.f4058a += 1.0f;
            }
        });
        this.f4063i = ofFloat;
    }
}
