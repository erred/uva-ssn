package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.p070g.C0962r;
import androidx.recyclerview.widget.RecyclerView.C1253h;
import androidx.recyclerview.widget.RecyclerView.C1262m;
import androidx.recyclerview.widget.RecyclerView.C1263n;
import androidx.recyclerview.widget.RecyclerView.C1274u;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.recyclerview.widget.d */
/* compiled from: FastScroller */
class C1304d extends C1253h implements C1262m {

    /* renamed from: k */
    private static final int[] f3913k = {16842919};

    /* renamed from: l */
    private static final int[] f3914l = new int[0];

    /* renamed from: A */
    private int f3915A = 0;

    /* renamed from: B */
    private final int[] f3916B = new int[2];

    /* renamed from: C */
    private final int[] f3917C = new int[2];

    /* renamed from: D */
    private final Runnable f3918D = new Runnable() {
        public void run() {
            C1304d.this.mo5497b(500);
        }
    };

    /* renamed from: E */
    private final C1263n f3919E = new C1263n() {
        /* renamed from: a */
        public void mo5207a(RecyclerView recyclerView, int i, int i2) {
            C1304d.this.mo5493a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    /* renamed from: a */
    final StateListDrawable f3920a;

    /* renamed from: b */
    final Drawable f3921b;

    /* renamed from: c */
    int f3922c;

    /* renamed from: d */
    int f3923d;

    /* renamed from: e */
    float f3924e;

    /* renamed from: f */
    int f3925f;

    /* renamed from: g */
    int f3926g;

    /* renamed from: h */
    float f3927h;

    /* renamed from: i */
    final ValueAnimator f3928i = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});

    /* renamed from: j */
    int f3929j = 0;

    /* renamed from: m */
    private final int f3930m;

    /* renamed from: n */
    private final int f3931n;

    /* renamed from: o */
    private final int f3932o;

    /* renamed from: p */
    private final int f3933p;

    /* renamed from: q */
    private final StateListDrawable f3934q;

    /* renamed from: r */
    private final Drawable f3935r;

    /* renamed from: s */
    private final int f3936s;

    /* renamed from: t */
    private final int f3937t;

    /* renamed from: u */
    private int f3938u = 0;

    /* renamed from: v */
    private int f3939v = 0;

    /* renamed from: w */
    private RecyclerView f3940w;

    /* renamed from: x */
    private boolean f3941x = false;

    /* renamed from: y */
    private boolean f3942y = false;

    /* renamed from: z */
    private int f3943z = 0;

    /* renamed from: androidx.recyclerview.widget.d$a */
    /* compiled from: FastScroller */
    private class C1307a extends AnimatorListenerAdapter {

        /* renamed from: b */
        private boolean f3947b = false;

        C1307a() {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f3947b) {
                this.f3947b = false;
                return;
            }
            if (((Float) C1304d.this.f3928i.getAnimatedValue()).floatValue() == BitmapDescriptorFactory.HUE_RED) {
                C1304d.this.f3929j = 0;
                C1304d.this.mo5492a(0);
            } else {
                C1304d.this.f3929j = 2;
                C1304d.this.mo5491a();
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f3947b = true;
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$b */
    /* compiled from: FastScroller */
    private class C1308b implements AnimatorUpdateListener {
        C1308b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C1304d.this.f3920a.setAlpha(floatValue);
            C1304d.this.f3921b.setAlpha(floatValue);
            C1304d.this.mo5491a();
        }
    }

    /* renamed from: a */
    public void mo5203a(boolean z) {
    }

    C1304d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f3920a = stateListDrawable;
        this.f3921b = drawable;
        this.f3934q = stateListDrawable2;
        this.f3935r = drawable2;
        this.f3932o = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f3933p = Math.max(i, drawable.getIntrinsicWidth());
        this.f3936s = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f3937t = Math.max(i, drawable2.getIntrinsicWidth());
        this.f3930m = i2;
        this.f3931n = i3;
        this.f3920a.setAlpha(255);
        this.f3921b.setAlpha(255);
        this.f3928i.addListener(new C1307a());
        this.f3928i.addUpdateListener(new C1308b());
        mo5494a(recyclerView);
    }

    /* renamed from: a */
    public void mo5494a(RecyclerView recyclerView) {
        if (this.f3940w != recyclerView) {
            if (this.f3940w != null) {
                m5299d();
            }
            this.f3940w = recyclerView;
            if (this.f3940w != null) {
                m5297c();
            }
        }
    }

    /* renamed from: c */
    private void m5297c() {
        this.f3940w.addItemDecoration(this);
        this.f3940w.addOnItemTouchListener(this);
        this.f3940w.addOnScrollListener(this.f3919E);
    }

    /* renamed from: d */
    private void m5299d() {
        this.f3940w.removeItemDecoration(this);
        this.f3940w.removeOnItemTouchListener(this);
        this.f3940w.removeOnScrollListener(this.f3919E);
        m5301f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5491a() {
        this.f3940w.invalidate();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5492a(int i) {
        if (i == 2 && this.f3943z != 2) {
            this.f3920a.setState(f3913k);
            m5301f();
        }
        if (i == 0) {
            mo5491a();
        } else {
            mo5496b();
        }
        if (this.f3943z == 2 && i != 2) {
            this.f3920a.setState(f3914l);
            m5298c(1200);
        } else if (i == 1) {
            m5298c(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f3943z = i;
    }

    /* renamed from: e */
    private boolean m5300e() {
        return C0962r.m3579f(this.f3940w) == 1;
    }

    /* renamed from: b */
    public void mo5496b() {
        int i = this.f3929j;
        if (i != 0) {
            if (i == 3) {
                this.f3928i.cancel();
            } else {
                return;
            }
        }
        this.f3929j = 1;
        this.f3928i.setFloatValues(new float[]{((Float) this.f3928i.getAnimatedValue()).floatValue(), 1.0f});
        this.f3928i.setDuration(500);
        this.f3928i.setStartDelay(0);
        this.f3928i.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5497b(int i) {
        switch (this.f3929j) {
            case 1:
                this.f3928i.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.f3929j = 3;
        this.f3928i.setFloatValues(new float[]{((Float) this.f3928i.getAnimatedValue()).floatValue(), 0.0f});
        this.f3928i.setDuration((long) i);
        this.f3928i.start();
    }

    /* renamed from: f */
    private void m5301f() {
        this.f3940w.removeCallbacks(this.f3918D);
    }

    /* renamed from: c */
    private void m5298c(int i) {
        m5301f();
        this.f3940w.postDelayed(this.f3918D, (long) i);
    }

    /* renamed from: a */
    public void mo5093a(Canvas canvas, RecyclerView recyclerView, C1274u uVar) {
        if (this.f3938u == this.f3940w.getWidth() && this.f3939v == this.f3940w.getHeight()) {
            if (this.f3929j != 0) {
                if (this.f3941x) {
                    m5294a(canvas);
                }
                if (this.f3942y) {
                    m5296b(canvas);
                }
            }
            return;
        }
        this.f3938u = this.f3940w.getWidth();
        this.f3939v = this.f3940w.getHeight();
        mo5492a(0);
    }

    /* renamed from: a */
    private void m5294a(Canvas canvas) {
        int i = this.f3938u - this.f3932o;
        int i2 = this.f3923d - (this.f3922c / 2);
        this.f3920a.setBounds(0, 0, this.f3932o, this.f3922c);
        this.f3921b.setBounds(0, 0, this.f3933p, this.f3939v);
        if (m5300e()) {
            this.f3921b.draw(canvas);
            canvas.translate((float) this.f3932o, (float) i2);
            canvas.scale(-1.0f, 1.0f);
            this.f3920a.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f3932o), (float) (-i2));
            return;
        }
        canvas.translate((float) i, BitmapDescriptorFactory.HUE_RED);
        this.f3921b.draw(canvas);
        canvas.translate(BitmapDescriptorFactory.HUE_RED, (float) i2);
        this.f3920a.draw(canvas);
        canvas.translate((float) (-i), (float) (-i2));
    }

    /* renamed from: b */
    private void m5296b(Canvas canvas) {
        int i = this.f3939v - this.f3936s;
        int i2 = this.f3926g - (this.f3925f / 2);
        this.f3934q.setBounds(0, 0, this.f3925f, this.f3936s);
        this.f3935r.setBounds(0, 0, this.f3938u, this.f3937t);
        canvas.translate(BitmapDescriptorFactory.HUE_RED, (float) i);
        this.f3935r.draw(canvas);
        canvas.translate((float) i2, BitmapDescriptorFactory.HUE_RED);
        this.f3934q.draw(canvas);
        canvas.translate((float) (-i2), (float) (-i));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5493a(int i, int i2) {
        int computeVerticalScrollRange = this.f3940w.computeVerticalScrollRange();
        int i3 = this.f3939v;
        this.f3941x = computeVerticalScrollRange - i3 > 0 && this.f3939v >= this.f3930m;
        int computeHorizontalScrollRange = this.f3940w.computeHorizontalScrollRange();
        int i4 = this.f3938u;
        this.f3942y = computeHorizontalScrollRange - i4 > 0 && this.f3938u >= this.f3930m;
        if (this.f3941x || this.f3942y) {
            if (this.f3941x) {
                float f = (float) i3;
                this.f3923d = (int) ((f * (((float) i2) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f3922c = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (this.f3942y) {
                float f2 = (float) i4;
                this.f3926g = (int) ((f2 * (((float) i) + (f2 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f3925f = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            if (this.f3943z == 0 || this.f3943z == 1) {
                mo5492a(1);
            }
            return;
        }
        if (this.f3943z != 0) {
            mo5492a(0);
        }
    }

    /* renamed from: a */
    public boolean mo5204a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3943z == 1) {
            boolean a = mo5495a(motionEvent.getX(), motionEvent.getY());
            boolean b = mo5498b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!a && !b) {
                return false;
            }
            if (b) {
                this.f3915A = 1;
                this.f3927h = (float) ((int) motionEvent.getX());
            } else if (a) {
                this.f3915A = 2;
                this.f3924e = (float) ((int) motionEvent.getY());
            }
            mo5492a(2);
        } else if (this.f3943z != 2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void mo5205b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3943z != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a = mo5495a(motionEvent.getX(), motionEvent.getY());
                boolean b = mo5498b(motionEvent.getX(), motionEvent.getY());
                if (a || b) {
                    if (b) {
                        this.f3915A = 1;
                        this.f3927h = (float) ((int) motionEvent.getX());
                    } else if (a) {
                        this.f3915A = 2;
                        this.f3924e = (float) ((int) motionEvent.getY());
                    }
                    mo5492a(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f3943z == 2) {
                this.f3924e = BitmapDescriptorFactory.HUE_RED;
                this.f3927h = BitmapDescriptorFactory.HUE_RED;
                mo5492a(1);
                this.f3915A = 0;
            } else if (motionEvent.getAction() == 2 && this.f3943z == 2) {
                mo5496b();
                if (this.f3915A == 1) {
                    m5295b(motionEvent.getX());
                }
                if (this.f3915A == 2) {
                    m5293a(motionEvent.getY());
                }
            }
        }
    }

    /* renamed from: a */
    private void m5293a(float f) {
        int[] g = m5302g();
        float max = Math.max((float) g[0], Math.min((float) g[1], f));
        if (Math.abs(((float) this.f3923d) - max) >= 2.0f) {
            int a = m5292a(this.f3924e, max, g, this.f3940w.computeVerticalScrollRange(), this.f3940w.computeVerticalScrollOffset(), this.f3939v);
            if (a != 0) {
                this.f3940w.scrollBy(0, a);
            }
            this.f3924e = max;
        }
    }

    /* renamed from: b */
    private void m5295b(float f) {
        int[] h = m5303h();
        float max = Math.max((float) h[0], Math.min((float) h[1], f));
        if (Math.abs(((float) this.f3926g) - max) >= 2.0f) {
            int a = m5292a(this.f3927h, max, h, this.f3940w.computeHorizontalScrollRange(), this.f3940w.computeHorizontalScrollOffset(), this.f3938u);
            if (a != 0) {
                this.f3940w.scrollBy(a, 0);
            }
            this.f3927h = max;
        }
    }

    /* renamed from: a */
    private int m5292a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5495a(float f, float f2) {
        if (!m5300e() ? f >= ((float) (this.f3938u - this.f3932o)) : f <= ((float) (this.f3932o / 2))) {
            if (f2 >= ((float) (this.f3923d - (this.f3922c / 2))) && f2 <= ((float) (this.f3923d + (this.f3922c / 2)))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo5498b(float f, float f2) {
        return f2 >= ((float) (this.f3939v - this.f3936s)) && f >= ((float) (this.f3926g - (this.f3925f / 2))) && f <= ((float) (this.f3926g + (this.f3925f / 2)));
    }

    /* renamed from: g */
    private int[] m5302g() {
        this.f3916B[0] = this.f3931n;
        this.f3916B[1] = this.f3939v - this.f3931n;
        return this.f3916B;
    }

    /* renamed from: h */
    private int[] m5303h() {
        this.f3917C[0] = this.f3931n;
        this.f3917C[1] = this.f3938u - this.f3931n;
        return this.f3917C;
    }
}
