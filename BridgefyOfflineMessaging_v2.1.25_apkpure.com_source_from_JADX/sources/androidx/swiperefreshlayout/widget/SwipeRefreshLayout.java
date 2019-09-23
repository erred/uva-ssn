package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.C0875a;
import androidx.core.p070g.C0953i;
import androidx.core.p070g.C0955k;
import androidx.core.p070g.C0956l;
import androidx.core.p070g.C0958n;
import androidx.core.p070g.C0962r;
import androidx.core.widget.C1011g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.primitives.Ints;

public class SwipeRefreshLayout extends ViewGroup implements C0953i, C0956l {

    /* renamed from: E */
    private static final int[] f3998E = {16842766};

    /* renamed from: n */
    private static final String f3999n = "SwipeRefreshLayout";

    /* renamed from: A */
    private boolean f4000A;

    /* renamed from: B */
    private int f4001B;

    /* renamed from: C */
    private boolean f4002C;

    /* renamed from: D */
    private final DecelerateInterpolator f4003D;

    /* renamed from: F */
    private int f4004F;

    /* renamed from: G */
    private Animation f4005G;

    /* renamed from: H */
    private Animation f4006H;

    /* renamed from: I */
    private Animation f4007I;

    /* renamed from: J */
    private Animation f4008J;

    /* renamed from: K */
    private Animation f4009K;

    /* renamed from: L */
    private int f4010L;

    /* renamed from: M */
    private C1346a f4011M;

    /* renamed from: N */
    private AnimationListener f4012N;

    /* renamed from: O */
    private final Animation f4013O;

    /* renamed from: P */
    private final Animation f4014P;

    /* renamed from: a */
    C1347b f4015a;

    /* renamed from: b */
    boolean f4016b;

    /* renamed from: c */
    int f4017c;

    /* renamed from: d */
    boolean f4018d;

    /* renamed from: e */
    C1348a f4019e;

    /* renamed from: f */
    protected int f4020f;

    /* renamed from: g */
    float f4021g;

    /* renamed from: h */
    protected int f4022h;

    /* renamed from: i */
    int f4023i;

    /* renamed from: j */
    int f4024j;

    /* renamed from: k */
    C1350b f4025k;

    /* renamed from: l */
    boolean f4026l;

    /* renamed from: m */
    boolean f4027m;

    /* renamed from: o */
    private View f4028o;

    /* renamed from: p */
    private int f4029p;

    /* renamed from: q */
    private float f4030q;

    /* renamed from: r */
    private float f4031r;

    /* renamed from: s */
    private final C0958n f4032s;

    /* renamed from: t */
    private final C0955k f4033t;

    /* renamed from: u */
    private final int[] f4034u;

    /* renamed from: v */
    private final int[] f4035v;

    /* renamed from: w */
    private boolean f4036w;

    /* renamed from: x */
    private int f4037x;

    /* renamed from: y */
    private float f4038y;

    /* renamed from: z */
    private float f4039z;

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$a */
    public interface C1346a {
        /* renamed from: a */
        boolean mo5638a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$b */
    public interface C1347b {
        void onRefresh();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5588a() {
        this.f4019e.clearAnimation();
        this.f4025k.stop();
        this.f4019e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f4018d) {
            setAnimationProgress(BitmapDescriptorFactory.HUE_RED);
        } else {
            setTargetOffsetTopAndBottom(this.f4022h - this.f4017c);
        }
        this.f4017c = this.f4019e.getTop();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            mo5588a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo5588a();
    }

    private void setColorViewAlpha(int i) {
        this.f4019e.getBackground().setAlpha(i);
        this.f4025k.setAlpha(i);
    }

    public int getProgressViewStartOffset() {
        return this.f4022h;
    }

    public int getProgressViewEndOffset() {
        return this.f4023i;
    }

    public void setSlingshotDistance(int i) {
        this.f4024j = i;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f4010L = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f4010L = (int) (displayMetrics.density * 40.0f);
            }
            this.f4019e.setImageDrawable(null);
            this.f4025k.mo5651a(i);
            this.f4019e.setImageDrawable(this.f4025k);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4016b = false;
        this.f4030q = -1.0f;
        this.f4034u = new int[2];
        this.f4035v = new int[2];
        this.f4001B = -1;
        this.f4004F = -1;
        this.f4012N = new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f4016b) {
                    SwipeRefreshLayout.this.f4025k.setAlpha(255);
                    SwipeRefreshLayout.this.f4025k.start();
                    if (SwipeRefreshLayout.this.f4026l && SwipeRefreshLayout.this.f4015a != null) {
                        SwipeRefreshLayout.this.f4015a.onRefresh();
                    }
                    SwipeRefreshLayout.this.f4017c = SwipeRefreshLayout.this.f4019e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.mo5588a();
            }
        };
        this.f4013O = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                int i;
                if (!SwipeRefreshLayout.this.f4027m) {
                    i = SwipeRefreshLayout.this.f4023i - Math.abs(SwipeRefreshLayout.this.f4022h);
                } else {
                    i = SwipeRefreshLayout.this.f4023i;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.f4020f + ((int) (((float) (i - SwipeRefreshLayout.this.f4020f)) * f))) - SwipeRefreshLayout.this.f4019e.getTop());
                SwipeRefreshLayout.this.f4025k.mo5654b(1.0f - f);
            }
        };
        this.f4014P = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.mo5589a(f);
            }
        };
        this.f4029p = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4037x = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f4003D = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f4010L = (int) (displayMetrics.density * 40.0f);
        m5480d();
        setChildrenDrawingOrderEnabled(true);
        this.f4023i = (int) (displayMetrics.density * 64.0f);
        this.f4030q = (float) this.f4023i;
        this.f4032s = new C0958n(this);
        this.f4033t = new C0955k(this);
        setNestedScrollingEnabled(true);
        int i = -this.f4010L;
        this.f4017c = i;
        this.f4022h = i;
        mo5589a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3998E);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f4004F < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f4004F;
        }
        return i2 >= this.f4004F ? i2 + 1 : i2;
    }

    /* renamed from: d */
    private void m5480d() {
        this.f4019e = new C1348a(getContext(), -328966);
        this.f4025k = new C1350b(getContext());
        this.f4025k.mo5651a(1);
        this.f4019e.setImageDrawable(this.f4025k);
        this.f4019e.setVisibility(8);
        addView(this.f4019e);
    }

    public void setOnRefreshListener(C1347b bVar) {
        this.f4015a = bVar;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (!z || this.f4016b == z) {
            m5473a(z, false);
            return;
        }
        this.f4016b = z;
        if (!this.f4027m) {
            i = this.f4023i + this.f4022h;
        } else {
            i = this.f4023i;
        }
        setTargetOffsetTopAndBottom(i - this.f4017c);
        this.f4026l = false;
        m5477b(this.f4012N);
    }

    /* renamed from: b */
    private void m5477b(AnimationListener animationListener) {
        this.f4019e.setVisibility(0);
        this.f4025k.setAlpha(255);
        this.f4005G = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.f4005G.setDuration((long) this.f4037x);
        if (animationListener != null) {
            this.f4019e.mo5640a(animationListener);
        }
        this.f4019e.clearAnimation();
        this.f4019e.startAnimation(this.f4005G);
    }

    /* access modifiers changed from: 0000 */
    public void setAnimationProgress(float f) {
        this.f4019e.setScaleX(f);
        this.f4019e.setScaleY(f);
    }

    /* renamed from: a */
    private void m5473a(boolean z, boolean z2) {
        if (this.f4016b != z) {
            this.f4026l = z2;
            m5484g();
            this.f4016b = z;
            if (this.f4016b) {
                m5471a(this.f4017c, this.f4012N);
            } else {
                mo5590a(this.f4012N);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5590a(AnimationListener animationListener) {
        this.f4006H = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.f4006H.setDuration(150);
        this.f4019e.mo5640a(animationListener);
        this.f4019e.clearAnimation();
        this.f4019e.startAnimation(this.f4006H);
    }

    /* renamed from: e */
    private void m5482e() {
        this.f4007I = m5470a(this.f4025k.getAlpha(), 76);
    }

    /* renamed from: f */
    private void m5483f() {
        this.f4008J = m5470a(this.f4025k.getAlpha(), 255);
    }

    /* renamed from: a */
    private Animation m5470a(final int i, final int i2) {
        C13414 r0 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.f4025k.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        r0.setDuration(300);
        this.f4019e.mo5640a(null);
        this.f4019e.clearAnimation();
        this.f4019e.startAnimation(r0);
        return r0;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(C0875a.m3248c(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f4019e.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = C0875a.m3248c(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m5484g();
        this.f4025k.mo5653a(iArr);
    }

    /* renamed from: b */
    public boolean mo5591b() {
        return this.f4016b;
    }

    /* renamed from: g */
    private void m5484g() {
        if (this.f4028o == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f4019e)) {
                    this.f4028o = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f4030q = (float) i;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f4028o == null) {
                m5484g();
            }
            if (this.f4028o != null) {
                View view = this.f4028o;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f4019e.getMeasuredWidth();
                int i5 = measuredWidth / 2;
                int i6 = measuredWidth2 / 2;
                this.f4019e.layout(i5 - i6, this.f4017c, i5 + i6, this.f4017c + this.f4019e.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f4028o == null) {
            m5484g();
        }
        if (this.f4028o != null) {
            this.f4028o.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), Ints.MAX_POWER_OF_TWO));
            this.f4019e.measure(MeasureSpec.makeMeasureSpec(this.f4010L, Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec(this.f4010L, Ints.MAX_POWER_OF_TWO));
            this.f4004F = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= getChildCount()) {
                    break;
                } else if (getChildAt(i3) == this.f4019e) {
                    this.f4004F = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f4010L;
    }

    /* renamed from: c */
    public boolean mo5592c() {
        if (this.f4011M != null) {
            return this.f4011M.mo5638a(this, this.f4028o);
        }
        if (this.f4028o instanceof ListView) {
            return C1011g.m3856b((ListView) this.f4028o, -1);
        }
        return this.f4028o.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(C1346a aVar) {
        this.f4011M = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m5484g();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f4002C && actionMasked == 0) {
            this.f4002C = false;
        }
        if (!isEnabled() || this.f4002C || mo5592c() || this.f4016b || this.f4036w) {
            return false;
        }
        if (actionMasked != 6) {
            switch (actionMasked) {
                case 0:
                    setTargetOffsetTopAndBottom(this.f4022h - this.f4019e.getTop());
                    this.f4001B = motionEvent.getPointerId(0);
                    this.f4000A = false;
                    int findPointerIndex = motionEvent.findPointerIndex(this.f4001B);
                    if (findPointerIndex >= 0) {
                        this.f4039z = motionEvent.getY(findPointerIndex);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                case 3:
                    this.f4000A = false;
                    this.f4001B = -1;
                    break;
                case 2:
                    if (this.f4001B != -1) {
                        int findPointerIndex2 = motionEvent.findPointerIndex(this.f4001B);
                        if (findPointerIndex2 >= 0) {
                            m5481d(motionEvent.getY(findPointerIndex2));
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        Log.e(f3999n, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
            }
        } else {
            m5472a(motionEvent);
        }
        return this.f4000A;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.f4028o instanceof AbsListView)) {
            return;
        }
        if (this.f4028o == null || C0962r.m3601x(this.f4028o)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return isEnabled() && !this.f4002C && !this.f4016b && (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f4032s.mo3755a(view, view2, i);
        startNestedScroll(i & 2);
        this.f4031r = BitmapDescriptorFactory.HUE_RED;
        this.f4036w = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f4031r > BitmapDescriptorFactory.HUE_RED) {
            float f = (float) i2;
            if (f > this.f4031r) {
                iArr[1] = i2 - ((int) this.f4031r);
                this.f4031r = BitmapDescriptorFactory.HUE_RED;
            } else {
                this.f4031r -= f;
                iArr[1] = i2;
            }
            m5475b(this.f4031r);
        }
        if (this.f4027m && i2 > 0 && this.f4031r == BitmapDescriptorFactory.HUE_RED && Math.abs(i2 - iArr[1]) > 0) {
            this.f4019e.setVisibility(8);
        }
        int[] iArr2 = this.f4034u;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f4032s.mo3752a();
    }

    public void onStopNestedScroll(View view) {
        this.f4032s.mo3753a(view);
        this.f4036w = false;
        if (this.f4031r > BitmapDescriptorFactory.HUE_RED) {
            m5478c(this.f4031r);
            this.f4031r = BitmapDescriptorFactory.HUE_RED;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f4035v);
        int i5 = i4 + this.f4035v[1];
        if (i5 < 0 && !mo5592c()) {
            this.f4031r += (float) Math.abs(i5);
            m5475b(this.f4031r);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f4033t.mo3738a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f4033t.mo3739a();
    }

    public boolean startNestedScroll(int i) {
        return this.f4033t.mo3749b(i);
    }

    public void stopNestedScroll() {
        this.f4033t.mo3750c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f4033t.mo3748b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f4033t.mo3744a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f4033t.mo3746a(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f4033t.mo3741a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f4033t.mo3740a(f, f2);
    }

    /* renamed from: a */
    private boolean m5474a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /* renamed from: b */
    private void m5475b(float f) {
        this.f4025k.mo5652a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f4030q));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f4030q;
        int i = this.f4024j > 0 ? this.f4024j : this.f4027m ? this.f4023i - this.f4022h : this.f4023i;
        float f2 = (float) i;
        double max2 = (double) (Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(abs, f2 * 2.0f) / f2) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i2 = this.f4022h + ((int) ((f2 * min) + (f2 * pow * 2.0f)));
        if (this.f4019e.getVisibility() != 0) {
            this.f4019e.setVisibility(0);
        }
        if (!this.f4018d) {
            this.f4019e.setScaleX(1.0f);
            this.f4019e.setScaleY(1.0f);
        }
        if (this.f4018d) {
            setAnimationProgress(Math.min(1.0f, f / this.f4030q));
        }
        if (f < this.f4030q) {
            if (this.f4025k.getAlpha() > 76 && !m5474a(this.f4007I)) {
                m5482e();
            }
        } else if (this.f4025k.getAlpha() < 255 && !m5474a(this.f4008J)) {
            m5483f();
        }
        this.f4025k.mo5648a((float) BitmapDescriptorFactory.HUE_RED, Math.min(0.8f, max * 0.8f));
        this.f4025k.mo5654b(Math.min(1.0f, max));
        this.f4025k.mo5655c((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i2 - this.f4017c);
    }

    /* renamed from: c */
    private void m5478c(float f) {
        if (f > this.f4030q) {
            m5473a(true, true);
            return;
        }
        this.f4016b = false;
        this.f4025k.mo5648a((float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED);
        C13425 r0 = null;
        if (!this.f4018d) {
            r0 = new AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.f4018d) {
                        SwipeRefreshLayout.this.mo5590a((AnimationListener) null);
                    }
                }
            };
        }
        m5476b(this.f4017c, r0);
        this.f4025k.mo5652a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f4002C && actionMasked == 0) {
            this.f4002C = false;
        }
        if (!isEnabled() || this.f4002C || mo5592c() || this.f4016b || this.f4036w) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.f4001B = motionEvent.getPointerId(0);
                this.f4000A = false;
                break;
            case 1:
                int findPointerIndex = motionEvent.findPointerIndex(this.f4001B);
                if (findPointerIndex < 0) {
                    Log.e(f3999n, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f4000A) {
                    float y = (motionEvent.getY(findPointerIndex) - this.f4038y) * 0.5f;
                    this.f4000A = false;
                    m5478c(y);
                }
                this.f4001B = -1;
                return false;
            case 2:
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f4001B);
                if (findPointerIndex2 < 0) {
                    Log.e(f3999n, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                m5481d(y2);
                if (this.f4000A) {
                    float f = (y2 - this.f4038y) * 0.5f;
                    if (f > BitmapDescriptorFactory.HUE_RED) {
                        m5475b(f);
                        break;
                    } else {
                        return false;
                    }
                }
                break;
            case 3:
                return false;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex >= 0) {
                    this.f4001B = motionEvent.getPointerId(actionIndex);
                    break;
                } else {
                    Log.e(f3999n, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
            case 6:
                m5472a(motionEvent);
                break;
        }
        return true;
    }

    /* renamed from: d */
    private void m5481d(float f) {
        if (f - this.f4039z > ((float) this.f4029p) && !this.f4000A) {
            this.f4038y = this.f4039z + ((float) this.f4029p);
            this.f4000A = true;
            this.f4025k.setAlpha(76);
        }
    }

    /* renamed from: a */
    private void m5471a(int i, AnimationListener animationListener) {
        this.f4020f = i;
        this.f4013O.reset();
        this.f4013O.setDuration(200);
        this.f4013O.setInterpolator(this.f4003D);
        if (animationListener != null) {
            this.f4019e.mo5640a(animationListener);
        }
        this.f4019e.clearAnimation();
        this.f4019e.startAnimation(this.f4013O);
    }

    /* renamed from: b */
    private void m5476b(int i, AnimationListener animationListener) {
        if (this.f4018d) {
            m5479c(i, animationListener);
            return;
        }
        this.f4020f = i;
        this.f4014P.reset();
        this.f4014P.setDuration(200);
        this.f4014P.setInterpolator(this.f4003D);
        if (animationListener != null) {
            this.f4019e.mo5640a(animationListener);
        }
        this.f4019e.clearAnimation();
        this.f4019e.startAnimation(this.f4014P);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5589a(float f) {
        setTargetOffsetTopAndBottom((this.f4020f + ((int) (((float) (this.f4022h - this.f4020f)) * f))) - this.f4019e.getTop());
    }

    /* renamed from: c */
    private void m5479c(int i, AnimationListener animationListener) {
        this.f4020f = i;
        this.f4021g = this.f4019e.getScaleX();
        this.f4009K = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f4021g + ((-SwipeRefreshLayout.this.f4021g) * f));
                SwipeRefreshLayout.this.mo5589a(f);
            }
        };
        this.f4009K.setDuration(150);
        if (animationListener != null) {
            this.f4019e.mo5640a(animationListener);
        }
        this.f4019e.clearAnimation();
        this.f4019e.startAnimation(this.f4009K);
    }

    /* access modifiers changed from: 0000 */
    public void setTargetOffsetTopAndBottom(int i) {
        this.f4019e.bringToFront();
        C0962r.m3580f(this.f4019e, i);
        this.f4017c = this.f4019e.getTop();
    }

    /* renamed from: a */
    private void m5472a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4001B) {
            this.f4001B = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
