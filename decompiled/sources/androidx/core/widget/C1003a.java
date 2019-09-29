package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.core.widget.a */
/* compiled from: AutoScrollHelper */
public abstract class C1003a implements OnTouchListener {

    /* renamed from: r */
    private static final int f3116r = ViewConfiguration.getTapTimeout();

    /* renamed from: a */
    final C1004a f3117a = new C1004a();

    /* renamed from: b */
    final View f3118b;

    /* renamed from: c */
    boolean f3119c;

    /* renamed from: d */
    boolean f3120d;

    /* renamed from: e */
    boolean f3121e;

    /* renamed from: f */
    private final Interpolator f3122f = new AccelerateInterpolator();

    /* renamed from: g */
    private Runnable f3123g;

    /* renamed from: h */
    private float[] f3124h = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: i */
    private float[] f3125i = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: j */
    private int f3126j;

    /* renamed from: k */
    private int f3127k;

    /* renamed from: l */
    private float[] f3128l = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: m */
    private float[] f3129m = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: n */
    private float[] f3130n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: o */
    private boolean f3131o;

    /* renamed from: p */
    private boolean f3132p;

    /* renamed from: q */
    private boolean f3133q;

    /* renamed from: androidx.core.widget.a$a */
    /* compiled from: AutoScrollHelper */
    private static class C1004a {

        /* renamed from: a */
        private int f3134a;

        /* renamed from: b */
        private int f3135b;

        /* renamed from: c */
        private float f3136c;

        /* renamed from: d */
        private float f3137d;

        /* renamed from: e */
        private long f3138e = Long.MIN_VALUE;

        /* renamed from: f */
        private long f3139f = 0;

        /* renamed from: g */
        private int f3140g = 0;

        /* renamed from: h */
        private int f3141h = 0;

        /* renamed from: i */
        private long f3142i = -1;

        /* renamed from: j */
        private float f3143j;

        /* renamed from: k */
        private int f3144k;

        /* renamed from: a */
        private float m3830a(float f) {
            return (-4.0f * f * f) + (f * 4.0f);
        }

        C1004a() {
        }

        /* renamed from: a */
        public void mo3943a(int i) {
            this.f3134a = i;
        }

        /* renamed from: b */
        public void mo3945b(int i) {
            this.f3135b = i;
        }

        /* renamed from: a */
        public void mo3941a() {
            this.f3138e = AnimationUtils.currentAnimationTimeMillis();
            this.f3142i = -1;
            this.f3139f = this.f3138e;
            this.f3143j = 0.5f;
            this.f3140g = 0;
            this.f3141h = 0;
        }

        /* renamed from: b */
        public void mo3944b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f3144k = C1003a.m3811a((int) (currentAnimationTimeMillis - this.f3138e), 0, this.f3135b);
            this.f3143j = m3831a(currentAnimationTimeMillis);
            this.f3142i = currentAnimationTimeMillis;
        }

        /* renamed from: c */
        public boolean mo3946c() {
            return this.f3142i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f3142i + ((long) this.f3144k);
        }

        /* renamed from: a */
        private float m3831a(long j) {
            if (j < this.f3138e) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            if (this.f3142i < 0 || j < this.f3142i) {
                return C1003a.m3808a(((float) (j - this.f3138e)) / ((float) this.f3134a), (float) BitmapDescriptorFactory.HUE_RED, 1.0f) * 0.5f;
            }
            return (1.0f - this.f3143j) + (this.f3143j * C1003a.m3808a(((float) (j - this.f3142i)) / ((float) this.f3144k), (float) BitmapDescriptorFactory.HUE_RED, 1.0f));
        }

        /* renamed from: d */
        public void mo3947d() {
            if (this.f3139f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a = m3830a(m3831a(currentAnimationTimeMillis));
                long j = currentAnimationTimeMillis - this.f3139f;
                this.f3139f = currentAnimationTimeMillis;
                float f = ((float) j) * a;
                this.f3140g = (int) (this.f3136c * f);
                this.f3141h = (int) (f * this.f3137d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        /* renamed from: a */
        public void mo3942a(float f, float f2) {
            this.f3136c = f;
            this.f3137d = f2;
        }

        /* renamed from: e */
        public int mo3948e() {
            return (int) (this.f3136c / Math.abs(this.f3136c));
        }

        /* renamed from: f */
        public int mo3949f() {
            return (int) (this.f3137d / Math.abs(this.f3137d));
        }

        /* renamed from: g */
        public int mo3950g() {
            return this.f3140g;
        }

        /* renamed from: h */
        public int mo3951h() {
            return this.f3141h;
        }
    }

    /* renamed from: androidx.core.widget.a$b */
    /* compiled from: AutoScrollHelper */
    private class C1005b implements Runnable {
        C1005b() {
        }

        public void run() {
            if (C1003a.this.f3121e) {
                if (C1003a.this.f3119c) {
                    C1003a.this.f3119c = false;
                    C1003a.this.f3117a.mo3941a();
                }
                C1004a aVar = C1003a.this.f3117a;
                if (aVar.mo3946c() || !C1003a.this.mo3929a()) {
                    C1003a.this.f3121e = false;
                    return;
                }
                if (C1003a.this.f3120d) {
                    C1003a.this.f3120d = false;
                    C1003a.this.mo3932b();
                }
                aVar.mo3947d();
                C1003a.this.mo3928a(aVar.mo3950g(), aVar.mo3951h());
                C0962r.m3562a(C1003a.this.f3118b, (Runnable) this);
            }
        }
    }

    /* renamed from: a */
    static float m3808a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: a */
    static int m3811a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: a */
    public abstract void mo3928a(int i, int i2);

    /* renamed from: e */
    public abstract boolean mo3938e(int i);

    /* renamed from: f */
    public abstract boolean mo3939f(int i);

    public C1003a(View view) {
        this.f3118b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        mo3925a(f, f);
        float f2 = (float) i2;
        mo3930b(f2, f2);
        mo3926a(1);
        mo3937e(Float.MAX_VALUE, Float.MAX_VALUE);
        mo3935d(0.2f, 0.2f);
        mo3933c(1.0f, 1.0f);
        mo3931b(f3116r);
        mo3934c(500);
        mo3936d(500);
    }

    /* renamed from: a */
    public C1003a mo3927a(boolean z) {
        if (this.f3132p && !z) {
            m3813d();
        }
        this.f3132p = z;
        return this;
    }

    /* renamed from: a */
    public C1003a mo3925a(float f, float f2) {
        this.f3130n[0] = f / 1000.0f;
        this.f3130n[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: b */
    public C1003a mo3930b(float f, float f2) {
        this.f3129m[0] = f / 1000.0f;
        this.f3129m[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: c */
    public C1003a mo3933c(float f, float f2) {
        this.f3128l[0] = f / 1000.0f;
        this.f3128l[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: a */
    public C1003a mo3926a(int i) {
        this.f3126j = i;
        return this;
    }

    /* renamed from: d */
    public C1003a mo3935d(float f, float f2) {
        this.f3124h[0] = f;
        this.f3124h[1] = f2;
        return this;
    }

    /* renamed from: e */
    public C1003a mo3937e(float f, float f2) {
        this.f3125i[0] = f;
        this.f3125i[1] = f2;
        return this;
    }

    /* renamed from: b */
    public C1003a mo3931b(int i) {
        this.f3127k = i;
        return this;
    }

    /* renamed from: c */
    public C1003a mo3934c(int i) {
        this.f3117a.mo3943a(i);
        return this;
    }

    /* renamed from: d */
    public C1003a mo3936d(int i) {
        this.f3117a.mo3945b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (!this.f3132p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f3120d = true;
                this.f3131o = false;
                break;
            case 1:
            case 3:
                m3813d();
                break;
            case 2:
                break;
        }
        this.f3117a.mo3942a(m3810a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f3118b.getWidth()), m3810a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f3118b.getHeight()));
        if (!this.f3121e && mo3929a()) {
            m3812c();
        }
        if (this.f3133q && this.f3121e) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo3929a() {
        C1004a aVar = this.f3117a;
        int f = aVar.mo3949f();
        int e = aVar.mo3948e();
        return (f != 0 && mo3939f(f)) || (e != 0 && mo3938e(e));
    }

    /* renamed from: c */
    private void m3812c() {
        if (this.f3123g == null) {
            this.f3123g = new C1005b();
        }
        this.f3121e = true;
        this.f3119c = true;
        if (this.f3131o || this.f3127k <= 0) {
            this.f3123g.run();
        } else {
            C0962r.m3563a(this.f3118b, this.f3123g, (long) this.f3127k);
        }
        this.f3131o = true;
    }

    /* renamed from: d */
    private void m3813d() {
        if (this.f3119c) {
            this.f3121e = false;
        } else {
            this.f3117a.mo3944b();
        }
    }

    /* renamed from: a */
    private float m3810a(int i, float f, float f2, float f3) {
        float a = m3809a(this.f3124h[i], f2, this.f3125i[i], f);
        int i2 = (a > BitmapDescriptorFactory.HUE_RED ? 1 : (a == BitmapDescriptorFactory.HUE_RED ? 0 : -1));
        if (i2 == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f4 = this.f3128l[i];
        float f5 = this.f3129m[i];
        float f6 = this.f3130n[i];
        float f7 = f4 * f3;
        if (i2 > 0) {
            return m3808a(a * f7, f5, f6);
        }
        return -m3808a((-a) * f7, f5, f6);
    }

    /* renamed from: a */
    private float m3809a(float f, float f2, float f3, float f4) {
        float f5;
        float a = m3808a(f * f2, (float) BitmapDescriptorFactory.HUE_RED, f3);
        float f6 = m3814f(f2 - f4, a) - m3814f(f4, a);
        if (f6 < BitmapDescriptorFactory.HUE_RED) {
            f5 = -this.f3122f.getInterpolation(-f6);
        } else if (f6 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        } else {
            f5 = this.f3122f.getInterpolation(f6);
        }
        return m3808a(f5, -1.0f, 1.0f);
    }

    /* renamed from: f */
    private float m3814f(float f, float f2) {
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        switch (this.f3126j) {
            case 0:
            case 1:
                if (f < f2) {
                    if (f >= BitmapDescriptorFactory.HUE_RED) {
                        return 1.0f - (f / f2);
                    }
                    if (!this.f3121e || this.f3126j != 1) {
                        return BitmapDescriptorFactory.HUE_RED;
                    }
                    return 1.0f;
                }
                break;
            case 2:
                if (f < BitmapDescriptorFactory.HUE_RED) {
                    return f / (-f2);
                }
                break;
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo3932b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f3118b.onTouchEvent(obtain);
        obtain.recycle();
    }
}
