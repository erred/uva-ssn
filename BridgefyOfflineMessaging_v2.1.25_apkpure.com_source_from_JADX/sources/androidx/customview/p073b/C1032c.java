package androidx.customview.p073b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

/* renamed from: androidx.customview.b.c */
/* compiled from: ViewDragHelper */
public class C1032c {

    /* renamed from: v */
    private static final Interpolator f3169v = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a */
    private int f3170a;

    /* renamed from: b */
    private int f3171b;

    /* renamed from: c */
    private int f3172c = -1;

    /* renamed from: d */
    private float[] f3173d;

    /* renamed from: e */
    private float[] f3174e;

    /* renamed from: f */
    private float[] f3175f;

    /* renamed from: g */
    private float[] f3176g;

    /* renamed from: h */
    private int[] f3177h;

    /* renamed from: i */
    private int[] f3178i;

    /* renamed from: j */
    private int[] f3179j;

    /* renamed from: k */
    private int f3180k;

    /* renamed from: l */
    private VelocityTracker f3181l;

    /* renamed from: m */
    private float f3182m;

    /* renamed from: n */
    private float f3183n;

    /* renamed from: o */
    private int f3184o;

    /* renamed from: p */
    private int f3185p;

    /* renamed from: q */
    private OverScroller f3186q;

    /* renamed from: r */
    private final C1035a f3187r;

    /* renamed from: s */
    private View f3188s;

    /* renamed from: t */
    private boolean f3189t;

    /* renamed from: u */
    private final ViewGroup f3190u;

    /* renamed from: w */
    private final Runnable f3191w = new Runnable() {
        public void run() {
            C1032c.this.mo4002b(0);
        }
    };

    /* renamed from: androidx.customview.b.c$a */
    /* compiled from: ViewDragHelper */
    public static abstract class C1035a {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    /* renamed from: a */
    public static C1032c m3918a(ViewGroup viewGroup, C1035a aVar) {
        return new C1032c(viewGroup.getContext(), viewGroup, aVar);
    }

    /* renamed from: a */
    public static C1032c m3917a(ViewGroup viewGroup, float f, C1035a aVar) {
        C1032c a = m3918a(viewGroup, aVar);
        a.f3171b = (int) (((float) a.f3171b) * (1.0f / f));
        return a;
    }

    private C1032c(Context context, ViewGroup viewGroup, C1035a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar != null) {
            this.f3190u = viewGroup;
            this.f3187r = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f3184o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f3171b = viewConfiguration.getScaledTouchSlop();
            this.f3182m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f3183n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f3186q = new OverScroller(context, f3169v);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: a */
    public int mo3994a() {
        return this.f3170a;
    }

    /* renamed from: a */
    public void mo3995a(View view, int i) {
        if (view.getParent() == this.f3190u) {
            this.f3188s = view;
            this.f3172c = i;
            this.f3187r.onViewCaptured(view, i);
            mo4002b(1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        sb.append(this.f3190u);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public int mo4001b() {
        return this.f3171b;
    }

    /* renamed from: c */
    public void mo4008c() {
        this.f3172c = -1;
        m3930d();
        if (this.f3181l != null) {
            this.f3181l.recycle();
            this.f3181l = null;
        }
    }

    /* renamed from: a */
    public boolean mo3999a(View view, int i, int i2) {
        this.f3188s = view;
        this.f3172c = -1;
        boolean a = m3922a(i, i2, 0, 0);
        if (!a && this.f3170a == 0 && this.f3188s != null) {
            this.f3188s = null;
        }
        return a;
    }

    /* renamed from: a */
    public boolean mo3997a(int i, int i2) {
        if (this.f3189t) {
            return m3922a(i, i2, (int) this.f3181l.getXVelocity(this.f3172c), (int) this.f3181l.getYVelocity(this.f3172c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: a */
    private boolean m3922a(int i, int i2, int i3, int i4) {
        int left = this.f3188s.getLeft();
        int top = this.f3188s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f3186q.abortAnimation();
            mo4002b(0);
            return false;
        }
        this.f3186q.startScroll(left, top, i5, i6, m3916a(this.f3188s, i5, i6, i3, i4));
        mo4002b(2);
        return true;
    }

    /* renamed from: a */
    private int m3916a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int b = m3924b(i3, (int) this.f3183n, (int) this.f3182m);
        int b2 = m3924b(i4, (int) this.f3183n, (int) this.f3182m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (b != 0) {
            f = (float) abs3;
            f2 = (float) i5;
        } else {
            f = (float) abs;
            f2 = (float) i6;
        }
        float f5 = f / f2;
        if (b2 != 0) {
            f3 = (float) abs4;
            f4 = (float) i5;
        } else {
            f3 = (float) abs2;
            f4 = (float) i6;
        }
        float f6 = f3 / f4;
        return (int) ((((float) m3915a(i, b, this.f3187r.getViewHorizontalDragRange(view))) * f5) + (((float) m3915a(i2, b2, this.f3187r.getViewVerticalDragRange(view))) * f6));
    }

    /* renamed from: a */
    private int m3915a(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.f3190u.getWidth();
        float f = (float) (width / 2);
        float a = f + (m3913a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(i4, 600);
    }

    /* renamed from: b */
    private int m3924b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            i3 = -i3;
        }
        return i3;
    }

    /* renamed from: a */
    private float m3914a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            f3 = -f3;
        }
        return f3;
    }

    /* renamed from: a */
    private float m3913a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* renamed from: a */
    public boolean mo4000a(boolean z) {
        if (this.f3170a == 2) {
            boolean computeScrollOffset = this.f3186q.computeScrollOffset();
            int currX = this.f3186q.getCurrX();
            int currY = this.f3186q.getCurrY();
            int left = currX - this.f3188s.getLeft();
            int top = currY - this.f3188s.getTop();
            if (left != 0) {
                C0962r.m3582g(this.f3188s, left);
            }
            if (top != 0) {
                C0962r.m3580f(this.f3188s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f3187r.onViewPositionChanged(this.f3188s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f3186q.getFinalX() && currY == this.f3186q.getFinalY()) {
                this.f3186q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f3190u.post(this.f3191w);
                } else {
                    mo4002b(0);
                }
            }
        }
        if (this.f3170a == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m3919a(float f, float f2) {
        this.f3189t = true;
        this.f3187r.onViewReleased(this.f3188s, f, f2);
        this.f3189t = false;
        if (this.f3170a == 1) {
            mo4002b(0);
        }
    }

    /* renamed from: d */
    private void m3930d() {
        if (this.f3173d != null) {
            Arrays.fill(this.f3173d, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f3174e, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f3175f, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f3176g, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f3177h, 0);
            Arrays.fill(this.f3178i, 0);
            Arrays.fill(this.f3179j, 0);
            this.f3180k = 0;
        }
    }

    /* renamed from: c */
    private void m3927c(int i) {
        if (this.f3173d != null && mo3996a(i)) {
            this.f3173d[i] = 0.0f;
            this.f3174e[i] = 0.0f;
            this.f3175f[i] = 0.0f;
            this.f3176g[i] = 0.0f;
            this.f3177h[i] = 0;
            this.f3178i[i] = 0;
            this.f3179j[i] = 0;
            this.f3180k = (~(1 << i)) & this.f3180k;
        }
    }

    /* renamed from: d */
    private void m3931d(int i) {
        if (this.f3173d == null || this.f3173d.length <= i) {
            int i2 = i + 1;
            float[] fArr = new float[i2];
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (this.f3173d != null) {
                System.arraycopy(this.f3173d, 0, fArr, 0, this.f3173d.length);
                System.arraycopy(this.f3174e, 0, fArr2, 0, this.f3174e.length);
                System.arraycopy(this.f3175f, 0, fArr3, 0, this.f3175f.length);
                System.arraycopy(this.f3176g, 0, fArr4, 0, this.f3176g.length);
                System.arraycopy(this.f3177h, 0, iArr, 0, this.f3177h.length);
                System.arraycopy(this.f3178i, 0, iArr2, 0, this.f3178i.length);
                System.arraycopy(this.f3179j, 0, iArr3, 0, this.f3179j.length);
            }
            this.f3173d = fArr;
            this.f3174e = fArr2;
            this.f3175f = fArr3;
            this.f3176g = fArr4;
            this.f3177h = iArr;
            this.f3178i = iArr2;
            this.f3179j = iArr3;
        }
    }

    /* renamed from: a */
    private void m3920a(float f, float f2, int i) {
        m3931d(i);
        float[] fArr = this.f3173d;
        this.f3175f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f3174e;
        this.f3176g[i] = f2;
        fArr2[i] = f2;
        this.f3177h[i] = m3929d((int) f, (int) f2);
        this.f3180k |= 1 << i;
    }

    /* renamed from: c */
    private void m3928c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m3933e(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f3175f[pointerId] = x;
                this.f3176g[pointerId] = y;
            }
        }
    }

    /* renamed from: a */
    public boolean mo3996a(int i) {
        return ((1 << i) & this.f3180k) != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4002b(int i) {
        this.f3190u.removeCallbacks(this.f3191w);
        if (this.f3170a != i) {
            this.f3170a = i;
            this.f3187r.onViewDragStateChanged(i);
            if (this.f3170a == 0) {
                this.f3188s = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo4005b(View view, int i) {
        if (view == this.f3188s && this.f3172c == i) {
            return true;
        }
        if (view == null || !this.f3187r.tryCaptureView(view, i)) {
            return false;
        }
        this.f3172c = i;
        mo3995a(view, i);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d4, code lost:
        if (r12 != r11) goto L_0x00dd;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3998a(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.mo4008c()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f3181l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f3181l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f3181l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            switch(r2) {
                case 0: goto L_0x00fb;
                case 1: goto L_0x00f6;
                case 2: goto L_0x0067;
                case 3: goto L_0x00f6;
                case 4: goto L_0x0025;
                case 5: goto L_0x0030;
                case 6: goto L_0x0028;
                default: goto L_0x0025;
            }
        L_0x0025:
            r5 = 0
            goto L_0x012d
        L_0x0028:
            int r1 = r1.getPointerId(r3)
            r0.m3927c(r1)
            goto L_0x0025
        L_0x0030:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.m3920a(r7, r1, r2)
            int r3 = r0.f3170a
            if (r3 != 0) goto L_0x0055
            int[] r1 = r0.f3177h
            r1 = r1[r2]
            int r3 = r0.f3185p
            r3 = r3 & r1
            if (r3 == 0) goto L_0x0025
            androidx.customview.b.c$a r3 = r0.f3187r
            int r4 = r0.f3185p
            r1 = r1 & r4
            r3.onEdgeTouched(r1, r2)
            goto L_0x0025
        L_0x0055:
            int r3 = r0.f3170a
            if (r3 != r4) goto L_0x0025
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.mo4007c(r3, r1)
            android.view.View r3 = r0.f3188s
            if (r1 != r3) goto L_0x0025
            r0.mo4005b(r1, r2)
            goto L_0x0025
        L_0x0067:
            float[] r2 = r0.f3173d
            if (r2 == 0) goto L_0x0025
            float[] r2 = r0.f3174e
            if (r2 != 0) goto L_0x0070
            goto L_0x0025
        L_0x0070:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x0075:
            if (r3 >= r2) goto L_0x00f1
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.m3933e(r4)
            if (r7 != 0) goto L_0x0083
            goto L_0x00ee
        L_0x0083:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f3173d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f3174e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.mo4007c(r7, r8)
            if (r7 == 0) goto L_0x00a7
            boolean r8 = r0.m3923a(r7, r9, r10)
            if (r8 == 0) goto L_0x00a7
            r8 = 1
            goto L_0x00a8
        L_0x00a7:
            r8 = 0
        L_0x00a8:
            if (r8 == 0) goto L_0x00dd
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.b.c$a r14 = r0.f3187r
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.b.c$a r5 = r0.f3187r
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.b.c$a r14 = r0.f3187r
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.b.c$a r15 = r0.f3187r
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00d6
            if (r14 <= 0) goto L_0x00dd
            if (r12 != r11) goto L_0x00dd
        L_0x00d6:
            if (r15 == 0) goto L_0x00f1
            if (r15 <= 0) goto L_0x00dd
            if (r5 != r13) goto L_0x00dd
            goto L_0x00f1
        L_0x00dd:
            r0.m3925b(r9, r10, r4)
            int r5 = r0.f3170a
            if (r5 != r6) goto L_0x00e5
            goto L_0x00f1
        L_0x00e5:
            if (r8 == 0) goto L_0x00ee
            boolean r4 = r0.mo4005b(r7, r4)
            if (r4 == 0) goto L_0x00ee
            goto L_0x00f1
        L_0x00ee:
            int r3 = r3 + 1
            goto L_0x0075
        L_0x00f1:
            r16.m3928c(r17)
            goto L_0x0025
        L_0x00f6:
            r16.mo4008c()
            goto L_0x0025
        L_0x00fb:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.m3920a(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.mo4007c(r2, r3)
            android.view.View r3 = r0.f3188s
            if (r2 != r3) goto L_0x011c
            int r3 = r0.f3170a
            if (r3 != r4) goto L_0x011c
            r0.mo4005b(r2, r1)
        L_0x011c:
            int[] r2 = r0.f3177h
            r2 = r2[r1]
            int r3 = r0.f3185p
            r3 = r3 & r2
            if (r3 == 0) goto L_0x012d
            androidx.customview.b.c$a r3 = r0.f3187r
            int r4 = r0.f3185p
            r2 = r2 & r4
            r3.onEdgeTouched(r2, r1)
        L_0x012d:
            int r1 = r0.f3170a
            if (r1 != r6) goto L_0x0132
            r5 = 1
        L_0x0132:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.p073b.C1032c.mo3998a(android.view.MotionEvent):boolean");
    }

    /* renamed from: b */
    public void mo4003b(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            mo4008c();
        }
        if (this.f3181l == null) {
            this.f3181l = VelocityTracker.obtain();
        }
        this.f3181l.addMovement(motionEvent);
        int i2 = 0;
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View c = mo4007c((int) x, (int) y);
                m3920a(x, y, pointerId);
                mo4005b(c, pointerId);
                int i3 = this.f3177h[pointerId];
                if ((this.f3185p & i3) != 0) {
                    this.f3187r.onEdgeTouched(i3 & this.f3185p, pointerId);
                    return;
                }
                return;
            case 1:
                if (this.f3170a == 1) {
                    m3932e();
                }
                mo4008c();
                return;
            case 2:
                if (this.f3170a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (m3933e(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.f3173d[pointerId2];
                            float f2 = y2 - this.f3174e[pointerId2];
                            m3925b(f, f2, pointerId2);
                            if (this.f3170a != 1) {
                                View c2 = mo4007c((int) x2, (int) y2);
                                if (m3923a(c2, f, f2) && mo4005b(c2, pointerId2)) {
                                }
                            }
                            m3928c(motionEvent);
                            return;
                        }
                        i2++;
                    }
                    m3928c(motionEvent);
                    return;
                } else if (m3933e(this.f3172c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f3172c);
                    float x3 = motionEvent.getX(findPointerIndex);
                    int i4 = (int) (x3 - this.f3175f[this.f3172c]);
                    int y3 = (int) (motionEvent.getY(findPointerIndex) - this.f3176g[this.f3172c]);
                    m3926b(this.f3188s.getLeft() + i4, this.f3188s.getTop() + y3, i4, y3);
                    m3928c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f3170a == 1) {
                    m3919a((float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED);
                }
                mo4008c();
                return;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                m3920a(x4, y4, pointerId3);
                if (this.f3170a == 0) {
                    mo4005b(mo4007c((int) x4, (int) y4), pointerId3);
                    int i5 = this.f3177h[pointerId3];
                    if ((this.f3185p & i5) != 0) {
                        this.f3187r.onEdgeTouched(i5 & this.f3185p, pointerId3);
                        return;
                    }
                    return;
                } else if (mo4004b((int) x4, (int) y4)) {
                    mo4005b(this.f3188s, pointerId3);
                    return;
                } else {
                    return;
                }
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f3170a == 1 && pointerId4 == this.f3172c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 < pointerCount2) {
                            int pointerId5 = motionEvent.getPointerId(i2);
                            if (pointerId5 != this.f3172c) {
                                if (mo4007c((int) motionEvent.getX(i2), (int) motionEvent.getY(i2)) == this.f3188s && mo4005b(this.f3188s, pointerId5)) {
                                    i = this.f3172c;
                                }
                            }
                            i2++;
                        } else {
                            i = -1;
                        }
                    }
                    if (i == -1) {
                        m3932e();
                    }
                }
                m3927c(pointerId4);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m3925b(float f, float f2, int i) {
        int i2 = 1;
        if (!m3921a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m3921a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m3921a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m3921a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f3178i;
            iArr[i] = iArr[i] | i2;
            this.f3187r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m3921a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        boolean z = false;
        if ((this.f3177h[i] & i2) != i2 || (this.f3185p & i2) == 0 || (this.f3179j[i] & i2) == i2 || (this.f3178i[i] & i2) == i2 || (abs <= ((float) this.f3171b) && abs2 <= ((float) this.f3171b))) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f3187r.onEdgeLock(i2)) {
            if ((this.f3178i[i] & i2) == 0 && abs > ((float) this.f3171b)) {
                z = true;
            }
            return z;
        }
        int[] iArr = this.f3179j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: a */
    private boolean m3923a(View view, float f, float f2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        boolean z2 = this.f3187r.getViewHorizontalDragRange(view) > 0;
        boolean z3 = this.f3187r.getViewVerticalDragRange(view) > 0;
        if (z2 && z3) {
            if ((f * f) + (f2 * f2) > ((float) (this.f3171b * this.f3171b))) {
                z = true;
            }
            return z;
        } else if (z2) {
            if (Math.abs(f) > ((float) this.f3171b)) {
                z = true;
            }
            return z;
        } else if (!z3) {
            return false;
        } else {
            if (Math.abs(f2) > ((float) this.f3171b)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: e */
    private void m3932e() {
        this.f3181l.computeCurrentVelocity(1000, this.f3182m);
        m3919a(m3914a(this.f3181l.getXVelocity(this.f3172c), this.f3183n, this.f3182m), m3914a(this.f3181l.getYVelocity(this.f3172c), this.f3183n, this.f3182m));
    }

    /* renamed from: b */
    private void m3926b(int i, int i2, int i3, int i4) {
        int left = this.f3188s.getLeft();
        int top = this.f3188s.getTop();
        if (i3 != 0) {
            i = this.f3187r.clampViewPositionHorizontal(this.f3188s, i, i3);
            C0962r.m3582g(this.f3188s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f3187r.clampViewPositionVertical(this.f3188s, i2, i4);
            C0962r.m3580f(this.f3188s, i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f3187r.onViewPositionChanged(this.f3188s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: b */
    public boolean mo4004b(int i, int i2) {
        return mo4006b(this.f3188s, i, i2);
    }

    /* renamed from: b */
    public boolean mo4006b(View view, int i, int i2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public View mo4007c(int i, int i2) {
        for (int childCount = this.f3190u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f3190u.getChildAt(this.f3187r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: d */
    private int m3929d(int i, int i2) {
        int i3 = i < this.f3190u.getLeft() + this.f3184o ? 1 : 0;
        if (i2 < this.f3190u.getTop() + this.f3184o) {
            i3 |= 4;
        }
        if (i > this.f3190u.getRight() - this.f3184o) {
            i3 |= 2;
        }
        return i2 > this.f3190u.getBottom() - this.f3184o ? i3 | 8 : i3;
    }

    /* renamed from: e */
    private boolean m3933e(int i) {
        if (mo3996a(i)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Ignoring pointerId=");
        sb.append(i);
        sb.append(" because ACTION_DOWN was not received ");
        sb.append("for this pointer before ACTION_MOVE. It likely happened because ");
        sb.append(" ViewDragHelper did not receive all the events in the event stream.");
        Log.e("ViewDragHelper", sb.toString());
        return false;
    }
}
