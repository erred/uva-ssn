package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.p070g.C0932a;
import androidx.core.p070g.C0954j;
import androidx.core.p070g.C0955k;
import androidx.core.p070g.C0957m;
import androidx.core.p070g.C0958n;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.p070g.p071a.C0942d;
import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.common.primitives.Ints;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements C0954j, C0957m {

    /* renamed from: w */
    private static final C0999a f3087w = new C0999a();

    /* renamed from: x */
    private static final int[] f3088x = {16843130};

    /* renamed from: A */
    private float f3089A;

    /* renamed from: B */
    private C1000b f3090B;

    /* renamed from: a */
    private long f3091a;

    /* renamed from: b */
    private final Rect f3092b;

    /* renamed from: c */
    private OverScroller f3093c;

    /* renamed from: d */
    private EdgeEffect f3094d;

    /* renamed from: e */
    private EdgeEffect f3095e;

    /* renamed from: f */
    private int f3096f;

    /* renamed from: g */
    private boolean f3097g;

    /* renamed from: h */
    private boolean f3098h;

    /* renamed from: i */
    private View f3099i;

    /* renamed from: j */
    private boolean f3100j;

    /* renamed from: k */
    private VelocityTracker f3101k;

    /* renamed from: l */
    private boolean f3102l;

    /* renamed from: m */
    private boolean f3103m;

    /* renamed from: n */
    private int f3104n;

    /* renamed from: o */
    private int f3105o;

    /* renamed from: p */
    private int f3106p;

    /* renamed from: q */
    private int f3107q;

    /* renamed from: r */
    private final int[] f3108r;

    /* renamed from: s */
    private final int[] f3109s;

    /* renamed from: t */
    private int f3110t;

    /* renamed from: u */
    private int f3111u;

    /* renamed from: v */
    private C1001c f3112v;

    /* renamed from: y */
    private final C0958n f3113y;

    /* renamed from: z */
    private final C0955k f3114z;

    /* renamed from: androidx.core.widget.NestedScrollView$a */
    static class C0999a extends C0932a {
        C0999a() {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i == 4096) {
                int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.mo3871c(0, min);
                return true;
            } else if (i != 8192) {
                return false;
            } else {
                int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (max == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.mo3871c(0, max);
                return true;
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.mo3679b((CharSequence) ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    bVar.mo3703i(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        bVar.mo3669a(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        bVar.mo3669a(4096);
                    }
                }
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C0942d.m3477a(accessibilityEvent, nestedScrollView.getScrollX());
            C0942d.m3479b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$b */
    public interface C1000b {
        /* renamed from: a */
        void mo816a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* renamed from: androidx.core.widget.NestedScrollView$c */
    static class C1001c extends BaseSavedState {
        public static final Creator<C1001c> CREATOR = new Creator<C1001c>() {
            /* renamed from: a */
            public C1001c createFromParcel(Parcel parcel) {
                return new C1001c(parcel);
            }

            /* renamed from: a */
            public C1001c[] newArray(int i) {
                return new C1001c[i];
            }
        };

        /* renamed from: a */
        public int f3115a;

        C1001c(Parcelable parcelable) {
            super(parcelable);
        }

        C1001c(Parcel parcel) {
            super(parcel);
            this.f3115a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3115a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            sb.append(this.f3115a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: b */
    private static int m3781b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3092b = new Rect();
        this.f3097g = true;
        this.f3098h = false;
        this.f3099i = null;
        this.f3100j = false;
        this.f3103m = true;
        this.f3107q = -1;
        this.f3108r = new int[2];
        this.f3109s = new int[2];
        m3774a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3088x, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f3113y = new C0958n(this);
        this.f3114z = new C0955k(this);
        setNestedScrollingEnabled(true);
        C0962r.m3559a((View) this, (C0932a) f3087w);
    }

    /* renamed from: a */
    public boolean mo3860a(int i, int i2) {
        return this.f3114z.mo3743a(i, i2);
    }

    public void stopNestedScroll(int i) {
        this.f3114z.mo3751c(i);
    }

    /* renamed from: a */
    public boolean mo3859a(int i) {
        return this.f3114z.mo3742a(i);
    }

    /* renamed from: a */
    public boolean mo3862a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.f3114z.mo3745a(i, i2, i3, i4, iArr, i5);
    }

    /* renamed from: a */
    public boolean mo3863a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f3114z.mo3747a(i, i2, iArr, iArr2, i3);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f3114z.mo3738a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f3114z.mo3739a();
    }

    public boolean startNestedScroll(int i) {
        return mo3860a(i, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean hasNestedScrollingParent() {
        return mo3859a(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return mo3862a(i, i2, i3, i4, iArr, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return mo3863a(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f3114z.mo3741a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f3114z.mo3740a(f, f2);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.f3113y.mo3756a(view, view2, i, i2);
        mo3860a(2, i2);
    }

    public void onStopNestedScroll(View view, int i) {
        this.f3113y.mo3754a(view, i);
        stopNestedScroll(i);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        mo3862a(0, scrollY2, 0, i4 - scrollY2, null, i5);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        mo3863a(i, i2, iArr, null, i3);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m3791g((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.f3113y.mo3752a();
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    /* renamed from: a */
    private void m3774a() {
        this.f3093c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3104n = viewConfiguration.getScaledTouchSlop();
        this.f3105o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3106p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(C1000b bVar) {
        this.f3090B = bVar;
    }

    /* renamed from: b */
    private boolean m3783b() {
        boolean z = false;
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            z = true;
        }
        return z;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f3102l) {
            this.f3102l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f3103m = z;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f3090B != null) {
            this.f3090B.mo816a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3102l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), MeasureSpec.makeMeasureSpec(measuredHeight, Ints.MAX_POWER_OF_TWO));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo3864a(keyEvent);
    }

    /* renamed from: a */
    public boolean mo3864a(KeyEvent keyEvent) {
        this.f3092b.setEmpty();
        boolean z = false;
        int i = 130;
        if (m3783b()) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 62) {
                    switch (keyCode) {
                        case 19:
                            if (keyEvent.isAltPressed()) {
                                z = mo3872c(33);
                                break;
                            } else {
                                z = mo3880d(33);
                                break;
                            }
                        case 20:
                            if (keyEvent.isAltPressed()) {
                                z = mo3872c(130);
                                break;
                            } else {
                                z = mo3880d(130);
                                break;
                            }
                    }
                } else {
                    if (keyEvent.isShiftPressed()) {
                        i = 33;
                    }
                    mo3870b(i);
                }
            }
            return z;
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (!(findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130))) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: d */
    private boolean m3786d(int i, int i2) {
        boolean z = false;
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight()) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    private void m3784c() {
        if (this.f3101k == null) {
            this.f3101k = VelocityTracker.obtain();
        } else {
            this.f3101k.clear();
        }
    }

    /* renamed from: d */
    private void m3785d() {
        if (this.f3101k == null) {
            this.f3101k = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m3787e() {
        if (this.f3101k != null) {
            this.f3101k.recycle();
            this.f3101k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m3787e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f3100j) {
            return true;
        }
        int i = action & 255;
        if (i != 6) {
            switch (i) {
                case 0:
                    int y = (int) motionEvent.getY();
                    if (m3786d((int) motionEvent.getX(), y)) {
                        this.f3096f = y;
                        this.f3107q = motionEvent.getPointerId(0);
                        m3784c();
                        this.f3101k.addMovement(motionEvent);
                        this.f3093c.computeScrollOffset();
                        this.f3100j = !this.f3093c.isFinished();
                        mo3860a(2, 0);
                        break;
                    } else {
                        this.f3100j = false;
                        m3787e();
                        break;
                    }
                case 1:
                case 3:
                    this.f3100j = false;
                    this.f3107q = -1;
                    m3787e();
                    if (this.f3093c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        C0962r.m3575d(this);
                    }
                    stopNestedScroll(0);
                    break;
                case 2:
                    int i2 = this.f3107q;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex != -1) {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f3096f) > this.f3104n && (2 & getNestedScrollAxes()) == 0) {
                                this.f3100j = true;
                                this.f3096f = y2;
                                m3785d();
                                this.f3101k.addMovement(motionEvent);
                                this.f3110t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                    break;
                                }
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid pointerId=");
                            sb.append(i2);
                            sb.append(" in onInterceptTouchEvent");
                            Log.e("NestedScrollView", sb.toString());
                            break;
                        }
                    }
                    break;
            }
        } else {
            m3775a(motionEvent);
        }
        return this.f3100j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        m3785d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3110t = 0;
        }
        obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f3110t);
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f3093c.isFinished();
                    this.f3100j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f3093c.isFinished()) {
                        this.f3093c.abortAnimation();
                    }
                    this.f3096f = (int) motionEvent.getY();
                    this.f3107q = motionEvent2.getPointerId(0);
                    mo3860a(2, 0);
                    break;
                } else {
                    return false;
                }
            case 1:
                VelocityTracker velocityTracker = this.f3101k;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f3106p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f3107q);
                if (Math.abs(yVelocity) > this.f3105o) {
                    m3791g(-yVelocity);
                } else if (this.f3093c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0962r.m3575d(this);
                }
                this.f3107q = -1;
                m3788f();
                break;
            case 2:
                int findPointerIndex = motionEvent2.findPointerIndex(this.f3107q);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent2.getY(findPointerIndex);
                    int i = this.f3096f - y;
                    if (mo3863a(0, i, this.f3109s, this.f3108r, 0)) {
                        i -= this.f3109s[1];
                        obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f3108r[1]);
                        this.f3110t += this.f3108r[1];
                    }
                    if (!this.f3100j && Math.abs(i) > this.f3104n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3100j = true;
                        if (i > 0) {
                            i -= this.f3104n;
                        } else {
                            i += this.f3104n;
                        }
                    }
                    int i2 = i;
                    if (this.f3100j) {
                        this.f3096f = y - this.f3108r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        int i3 = scrollRange;
                        int i4 = i2;
                        int i5 = findPointerIndex;
                        if (mo3861a(0, i2, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !mo3859a(0)) {
                            this.f3101k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!mo3862a(0, scrollY2, 0, i4 - scrollY2, this.f3108r, 0)) {
                            if (z2) {
                                m3790g();
                                int i6 = scrollY + i4;
                                if (i6 < 0) {
                                    C1008d.m3847a(this.f3094d, ((float) i4) / ((float) getHeight()), motionEvent2.getX(i5) / ((float) getWidth()));
                                    if (!this.f3095e.isFinished()) {
                                        this.f3095e.onRelease();
                                    }
                                } else {
                                    int i7 = i5;
                                    if (i6 > i3) {
                                        C1008d.m3847a(this.f3095e, ((float) i4) / ((float) getHeight()), 1.0f - (motionEvent2.getX(i7) / ((float) getWidth())));
                                        if (!this.f3094d.isFinished()) {
                                            this.f3094d.onRelease();
                                        }
                                    }
                                }
                                if (this.f3094d != null && (!this.f3094d.isFinished() || !this.f3095e.isFinished())) {
                                    C0962r.m3575d(this);
                                    break;
                                }
                            }
                        } else {
                            this.f3096f -= this.f3108r[1];
                            obtain.offsetLocation(BitmapDescriptorFactory.HUE_RED, (float) this.f3108r[1]);
                            this.f3110t += this.f3108r[1];
                            break;
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid pointerId=");
                    sb.append(this.f3107q);
                    sb.append(" in onTouchEvent");
                    Log.e("NestedScrollView", sb.toString());
                    break;
                }
                break;
            case 3:
                if (this.f3100j && getChildCount() > 0 && this.f3093c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0962r.m3575d(this);
                }
                this.f3107q = -1;
                m3788f();
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.f3096f = (int) motionEvent2.getY(actionIndex);
                this.f3107q = motionEvent2.getPointerId(actionIndex);
                break;
            case 6:
                m3775a(motionEvent);
                this.f3096f = (int) motionEvent2.getY(motionEvent2.findPointerIndex(this.f3107q));
                break;
        }
        if (this.f3101k != null) {
            this.f3101k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* renamed from: a */
    private void m3775a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3107q) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f3096f = (int) motionEvent.getY(i);
            this.f3107q = motionEvent.getPointerId(i);
            if (this.f3101k != null) {
                this.f3101k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f3100j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != BitmapDescriptorFactory.HUE_RED) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    i = 0;
                } else if (i > scrollRange) {
                    i = scrollRange;
                }
                if (i != scrollY) {
                    super.scrollTo(getScrollX(), i);
                    return true;
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f3089A == BitmapDescriptorFactory.HUE_RED) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f3089A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f3089A;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3861a(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            if (r1 != r5) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            if (r1 != r5) goto L_0x0032
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r6 = 0
            goto L_0x0035
        L_0x0034:
            r6 = 1
        L_0x0035:
            int r1 = r15 + r13
            if (r2 != 0) goto L_0x003b
            r7 = 0
            goto L_0x003d
        L_0x003b:
            r7 = r19
        L_0x003d:
            int r2 = r16 + r14
            if (r6 != 0) goto L_0x0043
            r3 = 0
            goto L_0x0045
        L_0x0043:
            r3 = r20
        L_0x0045:
            int r6 = -r7
            int r7 = r7 + r17
            int r8 = -r3
            int r3 = r3 + r18
            if (r1 <= r7) goto L_0x0050
            r6 = r7
        L_0x004e:
            r1 = 1
            goto L_0x0055
        L_0x0050:
            if (r1 >= r6) goto L_0x0053
            goto L_0x004e
        L_0x0053:
            r6 = r1
            r1 = 0
        L_0x0055:
            if (r2 <= r3) goto L_0x005a
            r8 = r3
        L_0x0058:
            r2 = 1
            goto L_0x005f
        L_0x005a:
            if (r2 >= r8) goto L_0x005d
            goto L_0x0058
        L_0x005d:
            r8 = r2
            r2 = 0
        L_0x005f:
            if (r2 == 0) goto L_0x007e
            boolean r3 = r12.mo3859a(r5)
            if (r3 != 0) goto L_0x007e
            android.widget.OverScroller r3 = r0.f3093c
            r7 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r3
            r14 = r6
            r15 = r8
            r16 = r7
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L_0x007e:
            r12.onOverScrolled(r6, r8, r1, r2)
            if (r1 != 0) goto L_0x0085
            if (r2 == 0) goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.mo3861a(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    /* access modifiers changed from: 0000 */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* renamed from: a */
    private View m3773a(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (!z4) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    /* renamed from: b */
    public boolean mo3870b(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f3092b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.f3092b.top + height > bottom) {
                    this.f3092b.top = bottom - height;
                }
            }
        } else {
            this.f3092b.top = getScrollY() - height;
            if (this.f3092b.top < 0) {
                this.f3092b.top = 0;
            }
        }
        this.f3092b.bottom = this.f3092b.top + height;
        return m3776a(i, this.f3092b.top, this.f3092b.bottom);
    }

    /* renamed from: c */
    public boolean mo3872c(int i) {
        boolean z = i == 130;
        int height = getHeight();
        this.f3092b.top = 0;
        this.f3092b.bottom = height;
        if (z) {
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                this.f3092b.bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                this.f3092b.top = this.f3092b.bottom - height;
            }
        }
        return m3776a(i, this.f3092b.top, this.f3092b.bottom);
    }

    /* renamed from: a */
    private boolean m3776a(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View a = m3773a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m3789f(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo3880d(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m3779a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m3789f(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f3092b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f3092b);
            m3789f(mo3858a(this.f3092b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m3778a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m3778a(View view) {
        return !m3779a(view, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m3779a(View view, int i, int i2) {
        view.getDrawingRect(this.f3092b);
        offsetDescendantRectToMyCoords(view, this.f3092b);
        return this.f3092b.bottom + i >= getScrollY() && this.f3092b.top - i <= getScrollY() + i2;
    }

    /* renamed from: f */
    private void m3789f(int i) {
        if (i == 0) {
            return;
        }
        if (this.f3103m) {
            mo3869b(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    /* renamed from: b */
    public final void mo3869b(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f3091a > 250) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                int max = Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY;
                this.f3111u = getScrollY();
                this.f3093c.startScroll(getScrollX(), scrollY, 0, max);
                C0962r.m3575d(this);
            } else {
                if (!this.f3093c.isFinished()) {
                    this.f3093c.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.f3091a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    /* renamed from: c */
    public final void mo3871c(int i, int i2) {
        mo3869b(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void computeScroll() {
        if (this.f3093c.computeScrollOffset()) {
            this.f3093c.getCurrX();
            int currY = this.f3093c.getCurrY();
            int i = currY - this.f3111u;
            if (mo3863a(0, i, this.f3109s, null, 1)) {
                i -= this.f3109s[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY;
                mo3861a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - i3;
                if (!mo3862a(0, scrollY2, 0, i2 - scrollY2, null, 1)) {
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                        m3790g();
                        if (currY <= 0 && i3 > 0) {
                            this.f3094d.onAbsorb((int) this.f3093c.getCurrVelocity());
                        } else if (currY >= scrollRange && i3 < scrollRange) {
                            this.f3095e.onAbsorb((int) this.f3093c.getCurrVelocity());
                        }
                    }
                }
            }
            this.f3111u = currY;
            C0962r.m3575d(this);
            return;
        }
        if (mo3859a(1)) {
            stopNestedScroll(1);
        }
        this.f3111u = 0;
    }

    /* renamed from: b */
    private void m3782b(View view) {
        view.getDrawingRect(this.f3092b);
        offsetDescendantRectToMyCoords(view, this.f3092b);
        int a = mo3858a(this.f3092b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    /* renamed from: a */
    private boolean m3777a(Rect rect, boolean z) {
        int a = mo3858a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                mo3869b(0, a);
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo3858a(Rect rect) {
        int i;
        int i2;
        int i3 = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        if (rect.bottom > i5 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = (rect.top - scrollY) + 0;
            } else {
                i2 = (rect.bottom - i5) + 0;
            }
            i3 = Math.min(i2, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        } else if (rect.top < scrollY && rect.bottom < i5) {
            if (rect.height() > height) {
                i = 0 - (i5 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            i3 = Math.max(i, -getScrollY());
        }
        return i3;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f3097g) {
            m3782b(view2);
        } else {
            this.f3099i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View view;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (view != null && !m3778a(view)) {
            return view.requestFocus(i, rect);
        }
        return false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m3777a(rect, z);
    }

    public void requestLayout() {
        this.f3097g = true;
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.f3097g = false;
        if (this.f3099i != null && m3780a(this.f3099i, (View) this)) {
            m3782b(this.f3099i);
        }
        this.f3099i = null;
        if (!this.f3098h) {
            if (this.f3112v != null) {
                scrollTo(getScrollX(), this.f3112v.f3115a);
                this.f3112v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int b = m3781b(scrollY, paddingTop, i5);
            if (b != scrollY) {
                scrollTo(getScrollX(), b);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3098h = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3098h = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (!(findFocus == null || this == findFocus || !m3779a(findFocus, 0, i4))) {
            findFocus.getDrawingRect(this.f3092b);
            offsetDescendantRectToMyCoords(findFocus, this.f3092b);
            m3789f(mo3858a(this.f3092b));
        }
    }

    /* renamed from: a */
    private static boolean m3780a(View view, View view2) {
        boolean z = true;
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !m3780a((View) parent, view2)) {
            z = false;
        }
        return z;
    }

    /* renamed from: e */
    public void mo3887e(int i) {
        if (getChildCount() > 0) {
            mo3860a(2, 1);
            this.f3093c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, C1024a.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, 0, 0);
            this.f3111u = getScrollY();
            C0962r.m3575d(this);
        }
    }

    /* renamed from: g */
    private void m3791g(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        float f = (float) i;
        if (!dispatchNestedPreFling(BitmapDescriptorFactory.HUE_RED, f)) {
            dispatchNestedFling(BitmapDescriptorFactory.HUE_RED, f, z);
            mo3887e(i);
        }
    }

    /* renamed from: f */
    private void m3788f() {
        this.f3100j = false;
        m3787e();
        stopNestedScroll(0);
        if (this.f3094d != null) {
            this.f3094d.onRelease();
            this.f3095e.onRelease();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int width = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int b = m3781b(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), width);
            int b2 = m3781b(i2, height, height2);
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    /* renamed from: g */
    private void m3790g() {
        if (getOverScrollMode() == 2) {
            this.f3094d = null;
            this.f3095e = null;
        } else if (this.f3094d == null) {
            Context context = getContext();
            this.f3094d = new EdgeEffect(context);
            this.f3095e = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f3094d != null) {
            int scrollY = getScrollY();
            int i2 = 0;
            if (!this.f3094d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = getPaddingLeft() + 0;
                } else {
                    i = 0;
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i, (float) min);
                this.f3094d.setSize(width, height);
                if (this.f3094d.draw(canvas)) {
                    C0962r.m3575d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f3095e.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i2 = 0 + getPaddingLeft();
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i2 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, BitmapDescriptorFactory.HUE_RED);
                this.f3095e.setSize(width2, height2);
                if (this.f3095e.draw(canvas)) {
                    C0962r.m3575d(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1001c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1001c cVar = (C1001c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f3112v = cVar;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C1001c cVar = new C1001c(super.onSaveInstanceState());
        cVar.f3115a = getScrollY();
        return cVar;
    }
}
