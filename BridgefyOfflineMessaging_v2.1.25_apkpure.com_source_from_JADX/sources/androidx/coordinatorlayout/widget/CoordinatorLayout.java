package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.coordinatorlayout.R;
import androidx.core.content.C0875a;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p069f.C0925c;
import androidx.core.p069f.C0926d.C0927a;
import androidx.core.p069f.C0926d.C0929c;
import androidx.core.p070g.C0946c;
import androidx.core.p070g.C0957m;
import androidx.core.p070g.C0958n;
import androidx.core.p070g.C0959o;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0976z;
import androidx.customview.p072a.C1021a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C0957m {
    static final Class<?>[] CONSTRUCTOR_PARAMS = {Context.class, AttributeSet.class};
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<C0822b>>> sConstructors = new ThreadLocal<>();
    private static final C0927a<Rect> sRectPool = new C0929c(12);
    private C0959o mApplyWindowInsetsListener;
    private View mBehaviorTouchView;
    private final C0830a<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private C0976z mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final C0958n mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    OnHierarchyChangeListener mOnHierarchyChangeListener;
    private C0826f mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final int[] mTempIntPair;
    private final List<View> mTempList1;

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$a */
    public interface C0821a {
        C0822b getBehavior();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$b */
    public static abstract class C0822b<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public C0976z onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, C0976z zVar) {
            return zVar;
        }

        public void onAttachedToLayoutParams(C0825e eVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public C0822b() {
        }

        public C0822b(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > BitmapDescriptorFactory.HUE_RED;
        }

        public static void setTag(View view, Object obj) {
            ((C0825e) view.getLayoutParams()).f2702n = obj;
        }

        public static Object getTag(View view) {
            return ((C0825e) view.getLayoutParams()).f2702n;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$c */
    public @interface C0823c {
        /* renamed from: a */
        Class<? extends C0822b> mo3408a();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$d */
    private class C0824d implements OnHierarchyChangeListener {
        C0824d() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$e */
    public static class C0825e extends MarginLayoutParams {

        /* renamed from: a */
        C0822b f2689a;

        /* renamed from: b */
        boolean f2690b = false;

        /* renamed from: c */
        public int f2691c = 0;

        /* renamed from: d */
        public int f2692d = 0;

        /* renamed from: e */
        public int f2693e = -1;

        /* renamed from: f */
        int f2694f = -1;

        /* renamed from: g */
        public int f2695g = 0;

        /* renamed from: h */
        public int f2696h = 0;

        /* renamed from: i */
        int f2697i;

        /* renamed from: j */
        int f2698j;

        /* renamed from: k */
        View f2699k;

        /* renamed from: l */
        View f2700l;

        /* renamed from: m */
        final Rect f2701m = new Rect();

        /* renamed from: n */
        Object f2702n;

        /* renamed from: o */
        private boolean f2703o;

        /* renamed from: p */
        private boolean f2704p;

        /* renamed from: q */
        private boolean f2705q;

        /* renamed from: r */
        private boolean f2706r;

        public C0825e(int i, int i2) {
            super(i, i2);
        }

        C0825e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f2691c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2694f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2692d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2693e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2695g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2696h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f2690b = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f2690b) {
                this.f2689a = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.f2689a != null) {
                this.f2689a.onAttachedToLayoutParams(this);
            }
        }

        public C0825e(C0825e eVar) {
            super(eVar);
        }

        public C0825e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0825e(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int mo3411a() {
            return this.f2694f;
        }

        /* renamed from: b */
        public C0822b mo3420b() {
            return this.f2689a;
        }

        /* renamed from: a */
        public void mo3415a(C0822b bVar) {
            if (this.f2689a != bVar) {
                if (this.f2689a != null) {
                    this.f2689a.onDetachedFromLayoutParams();
                }
                this.f2689a = bVar;
                this.f2702n = null;
                this.f2690b = true;
                if (bVar != null) {
                    bVar.onAttachedToLayoutParams(this);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3414a(Rect rect) {
            this.f2701m.set(rect);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public Rect mo3422c() {
            return this.f2701m;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public boolean mo3423d() {
            return this.f2699k == null && this.f2694f != -1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public boolean mo3424e() {
            if (this.f2689a == null) {
                this.f2703o = false;
            }
            return this.f2703o;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3417a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2703o) {
                return true;
            }
            boolean blocksInteractionBelow = (this.f2689a != null ? this.f2689a.blocksInteractionBelow(coordinatorLayout, view) : false) | this.f2703o;
            this.f2703o = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo3425f() {
            this.f2703o = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3412a(int i) {
            mo3413a(i, false);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3413a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.f2704p = z;
                    return;
                case 1:
                    this.f2705q = z;
                    return;
                default:
                    return;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo3421b(int i) {
            switch (i) {
                case 0:
                    return this.f2704p;
                case 1:
                    return this.f2705q;
                default:
                    return false;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public boolean mo3426g() {
            return this.f2706r;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3416a(boolean z) {
            this.f2706r = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public void mo3427h() {
            this.f2706r = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3418a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f2700l || m3048a(view2, C0962r.m3579f(coordinatorLayout)) || (this.f2689a != null && this.f2689a.layoutDependsOn(coordinatorLayout, view, view2));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public View mo3419b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2694f == -1) {
                this.f2700l = null;
                this.f2699k = null;
                return null;
            }
            if (this.f2699k == null || !m3049b(view, coordinatorLayout)) {
                m3047a(view, coordinatorLayout);
            }
            return this.f2699k;
        }

        /* renamed from: a */
        private void m3047a(View view, CoordinatorLayout coordinatorLayout) {
            this.f2699k = coordinatorLayout.findViewById(this.f2694f);
            if (this.f2699k != null) {
                if (this.f2699k != coordinatorLayout) {
                    View view2 = this.f2699k;
                    ViewParent parent = this.f2699k.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f2700l = null;
                            this.f2699k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f2700l = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f2700l = null;
                    this.f2699k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f2700l = null;
                this.f2699k = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find CoordinatorLayout descendant view with id ");
                sb.append(coordinatorLayout.getResources().getResourceName(this.f2694f));
                sb.append(" to anchor view ");
                sb.append(view);
                throw new IllegalStateException(sb.toString());
            }
        }

        /* renamed from: b */
        private boolean m3049b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2699k.getId() != this.f2694f) {
                return false;
            }
            View view2 = this.f2699k;
            for (ViewParent parent = this.f2699k.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2700l = null;
                    this.f2699k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f2700l = view2;
            return true;
        }

        /* renamed from: a */
        private boolean m3048a(View view, int i) {
            int a = C0946c.m3493a(((C0825e) view.getLayoutParams()).f2695g, i);
            return a != 0 && (C0946c.m3493a(this.f2696h, i) & a) == a;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$f */
    class C0826f implements OnPreDrawListener {
        C0826f() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$g */
    protected static class C0827g extends C1021a {
        public static final Creator<C0827g> CREATOR = new ClassLoaderCreator<C0827g>() {
            /* renamed from: a */
            public C0827g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0827g(parcel, classLoader);
            }

            /* renamed from: a */
            public C0827g createFromParcel(Parcel parcel) {
                return new C0827g(parcel, null);
            }

            /* renamed from: a */
            public C0827g[] newArray(int i) {
                return new C0827g[i];
            }
        };

        /* renamed from: a */
        SparseArray<Parcelable> f2708a;

        public C0827g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2708a = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f2708a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public C0827g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f2708a != null ? this.f2708a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f2708a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f2708a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$h */
    static class C0829h implements Comparator<View> {
        C0829h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float A = C0962r.m3541A(view);
            float A2 = C0962r.m3541A(view2);
            if (A > A2) {
                return -1;
            }
            return A < A2 ? 1 : 0;
        }
    }

    private static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new C0829h();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
    }

    private static Rect acquireTempRect() {
        Rect rect = (Rect) sRectPool.mo3647a();
        return rect == null ? new Rect() : rect;
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.mo3648a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArray;
        super(context, attributeSet, i);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new C0830a<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mTempIntPair = new int[2];
        this.mNestedScrollingParentHelper = new C0958n(this);
        if (i == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, 0);
        }
        int resourceId = typedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mKeylines[i2] = (int) (((float) this.mKeylines[i2]) * f);
            }
        }
        this.mStatusBarBackground = typedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new C0824d());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new C0826f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && C0962r.m3596s(this)) {
            C0962r.m3595r(this);
        }
        this.mIsAttachedToWindow = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mNestedScrollingTarget != null) {
            onStopNestedScroll(this.mNestedScrollingTarget);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.mStatusBarBackground != drawable) {
            Drawable drawable2 = null;
            if (this.mStatusBarBackground != null) {
                this.mStatusBarBackground.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable2;
            if (this.mStatusBarBackground != null) {
                if (this.mStatusBarBackground.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                C0983a.m3704b(this.mStatusBarBackground, C0962r.m3579f(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            C0962r.m3575d(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.mStatusBarBackground != null && this.mStatusBarBackground.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0875a.m3239a(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    /* access modifiers changed from: 0000 */
    public final C0976z setWindowInsets(C0976z zVar) {
        if (C0925c.m3394a(this.mLastInsets, zVar)) {
            return zVar;
        }
        this.mLastInsets = zVar;
        boolean z = true;
        this.mDrawStatusBarBackground = zVar != null && zVar.mo3778b() > 0;
        if (this.mDrawStatusBarBackground || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        C0976z dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(zVar);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    public final C0976z getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0822b b = ((C0825e) childAt.getLayoutParams()).mo3420b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                if (z) {
                    b.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    b.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0825e) getChildAt(i2).getLayoutParams()).mo3425f();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (TOP_SORTED_CHILDREN_COMPARATOR != null) {
            Collections.sort(list, TOP_SORTED_CHILDREN_COMPARATOR);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) list.get(i2);
            C0825e eVar = (C0825e) view.getLayoutParams();
            C0822b b = eVar.mo3420b();
            if ((z || z2) && actionMasked != 0) {
                if (b != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                    }
                    switch (i) {
                        case 0:
                            b.onInterceptTouchEvent(this, view, motionEvent3);
                            break;
                        case 1:
                            b.onTouchEvent(this, view, motionEvent3);
                            break;
                    }
                }
            } else {
                if (!z && b != null) {
                    switch (i) {
                        case 0:
                            z = b.onInterceptTouchEvent(this, view, motionEvent2);
                            break;
                        case 1:
                            z = b.onTouchEvent(this, view, motionEvent2);
                            break;
                    }
                    if (z) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean e = eVar.mo3424e();
                boolean a = eVar.mo3417a(this, view);
                z2 = a && !e;
                if (a && !z2) {
                    list.clear();
                    return z;
                }
            }
        }
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0018;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0017
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            r6 = 0
            goto L_0x002c
        L_0x0017:
            r3 = 0
        L_0x0018:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0825e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r6 = r6.mo3420b()
            if (r6 == 0) goto L_0x0015
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
        L_0x002c:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.resetTouchBehaviors(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    private int getKeyline(int i) {
        if (this.mKeylines == null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i);
            Log.e(str, sb.toString());
            return 0;
        } else if (i >= 0 && i < this.mKeylines.length) {
            return this.mKeylines[i];
        } else {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Keyline index ");
            sb2.append(i);
            sb2.append(" out of range for ");
            sb2.append(this);
            Log.e(str2, sb2.toString());
            return 0;
        }
    }

    static C0822b parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(str);
            str = sb.toString();
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(WIDGET_PACKAGE_NAME);
            sb2.append('.');
            sb2.append(str);
            str = sb2.toString();
        }
        try {
            Map map = (Map) sConstructors.get();
            if (map == null) {
                map = new HashMap();
                sConstructors.set(map);
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0822b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not inflate Behavior subclass ");
            sb3.append(str);
            throw new RuntimeException(sb3.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    public C0825e getResolvedLayoutParams(View view) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        if (!eVar.f2690b) {
            if (view instanceof C0821a) {
                C0822b behavior = ((C0821a) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                eVar.mo3415a(behavior);
                eVar.f2690b = true;
            } else {
                C0823c cVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (C0823c) cls.getAnnotation(C0823c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.mo3415a((C0822b) cVar.mo3408a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        String str = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Default behavior class ");
                        sb.append(cVar.mo3408a().getName());
                        sb.append(" could not be instantiated. Did you forget");
                        sb.append(" a default constructor?");
                        Log.e(str, sb.toString(), e);
                    }
                }
                eVar.f2690b = true;
            }
        }
        return eVar;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.mo3437a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0825e resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.mo3419b(this, childAt);
            this.mChildDag.mo3438a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.mo3418a(this, childAt, childAt2)) {
                        if (!this.mChildDag.mo3441b(childAt2)) {
                            this.mChildDag.mo3438a(childAt2);
                        }
                        this.mChildDag.mo3439a(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.mo3440b());
        Collections.reverse(this.mDependencySortedChildren);
    }

    /* access modifiers changed from: 0000 */
    public void getDescendantRect(View view, Rect rect) {
        C0831b.m3084b(this, view, rect);
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0119, code lost:
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L_0x0128;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.prepareChildren()
            r30.ensurePreDrawListener()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.p070g.C0962r.m3579f(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = 1
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.g.z r3 = r7.mLastInsets
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.p070g.C0962r.m3596s(r30)
            if (r3 == 0) goto L_0x004b
            r19 = 1
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.mDependencySortedChildren
            int r6 = r2.size()
            r4 = r0
            r2 = r1
            r3 = 0
            r5 = 0
        L_0x0057:
            if (r5 >= r6) goto L_0x016e
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            java.lang.Object r0 = r0.get(r5)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0071
            r22 = r5
            r29 = r6
            goto L_0x0168
        L_0x0071:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0825e) r1
            int r0 = r1.f2693e
            if (r0 < 0) goto L_0x00ba
            if (r13 == 0) goto L_0x00ba
            int r0 = r1.f2693e
            int r0 = r7.getKeyline(r0)
            int r11 = r1.f2691c
            int r11 = resolveKeylineGravity(r11)
            int r11 = androidx.core.p070g.C0946c.m3493a(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r11 = 0
            goto L_0x00bf
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00bc
            if (r12 == 0) goto L_0x00bc
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bf
        L_0x00ba:
            r22 = r2
        L_0x00bc:
            r11 = 0
            r21 = 0
        L_0x00bf:
            if (r19 == 0) goto L_0x00f1
            boolean r0 = androidx.core.p070g.C0962r.m3596s(r20)
            if (r0 != 0) goto L_0x00f1
            androidx.core.g.z r0 = r7.mLastInsets
            int r0 = r0.mo3776a()
            androidx.core.g.z r2 = r7.mLastInsets
            int r2 = r2.mo3779c()
            int r0 = r0 + r2
            androidx.core.g.z r2 = r7.mLastInsets
            int r2 = r2.mo3778b()
            androidx.core.g.z r11 = r7.mLastInsets
            int r11 = r11.mo3780d()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f5
        L_0x00f1:
            r11 = r31
            r23 = r32
        L_0x00f5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r0 = r1.mo3420b()
            if (r0 == 0) goto L_0x011c
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r27 = r3
            r3 = r11
            r28 = r4
            r4 = r21
            r22 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.onMeasureChild(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0135
            goto L_0x0128
        L_0x011c:
            r26 = r1
            r27 = r3
            r28 = r4
            r29 = r6
            r25 = r22
            r22 = r5
        L_0x0128:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.onMeasureChild(r1, r2, r3, r4, r5)
        L_0x0135:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            r2 = r28
            int r0 = java.lang.Math.max(r2, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r25
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r27
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r4 = r0
            r3 = r2
            r2 = r1
        L_0x0168:
            int r5 = r22 + 1
            r6 = r29
            goto L_0x0057
        L_0x016e:
            r1 = r2
            r11 = r3
            r2 = r4
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r3 = r31
            int r0 = android.view.View.resolveSizeAndState(r2, r3, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    private C0976z dispatchApplyWindowInsetsToBehaviors(C0976z zVar) {
        if (zVar.mo3783f()) {
            return zVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (C0962r.m3596s(childAt)) {
                C0822b b = ((C0825e) childAt.getLayoutParams()).mo3420b();
                if (b != null) {
                    zVar = b.onApplyWindowInsets(this, childAt, zVar);
                    if (zVar.mo3783f()) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return zVar;
    }

    public void onLayoutChild(View view, int i) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        if (eVar.mo3423d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (eVar.f2699k != null) {
            layoutChildWithAnchor(view, eVar.f2699k, i);
        } else if (eVar.f2693e >= 0) {
            layoutChildWithKeyline(view, eVar.f2693e, i);
        } else {
            layoutChild(view, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int f = C0962r.m3579f(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8) {
                C0822b b = ((C0825e) view.getLayoutParams()).mo3420b();
                if (b == null || !b.onLayoutChild(this, view, f)) {
                    onLayoutChild(view, f);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            int b = this.mLastInsets != null ? this.mLastInsets.mo3778b() : 0;
            if (b > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), b);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    /* access modifiers changed from: 0000 */
    public void recordLastChildRect(View view, Rect rect) {
        ((C0825e) view.getLayoutParams()).mo3414a(rect);
    }

    /* access modifiers changed from: 0000 */
    public void getLastChildRect(View view, Rect rect) {
        rect.set(((C0825e) view.getLayoutParams()).mo3422c());
    }

    /* access modifiers changed from: 0000 */
    public void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
            return;
        }
        if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, C0825e eVar, int i2, int i3) {
        int i4;
        int i5;
        int a = C0946c.m3493a(resolveAnchoredChildGravity(eVar.f2691c), i);
        int a2 = C0946c.m3493a(resolveGravity(eVar.f2692d), i);
        int i6 = a & 7;
        int i7 = a & 112;
        int i8 = a2 & 7;
        int i9 = a2 & 112;
        if (i8 == 1) {
            i4 = rect.left + (rect.width() / 2);
        } else if (i8 != 5) {
            i4 = rect.left;
        } else {
            i4 = rect.right;
        }
        if (i9 == 16) {
            i5 = rect.top + (rect.height() / 2);
        } else if (i9 != 80) {
            i5 = rect.top;
        } else {
            i5 = rect.bottom;
        }
        if (i6 == 1) {
            i4 -= i2 / 2;
        } else if (i6 != 5) {
            i4 -= i2;
        }
        if (i7 == 16) {
            i5 -= i3 / 2;
        } else if (i7 != 80) {
            i5 -= i3;
        }
        rect2.set(i4, i5, i2 + i4, i3 + i5);
    }

    private void constrainChildRect(C0825e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - eVar.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    /* access modifiers changed from: 0000 */
    public void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        constrainChildRect(eVar, rect2, measuredWidth, measuredHeight);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        int a = C0946c.m3493a(resolveKeylineGravity(eVar.f2691c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void layoutChild(View view, int i) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (this.mLastInsets != null && C0962r.m3596s(this) && !C0962r.m3596s(view)) {
            acquireTempRect.left += this.mLastInsets.mo3776a();
            acquireTempRect.top += this.mLastInsets.mo3778b();
            acquireTempRect.right -= this.mLastInsets.mo3779c();
            acquireTempRect.bottom -= this.mLastInsets.mo3780d();
        }
        Rect acquireTempRect2 = acquireTempRect();
        C0946c.m3494a(resolveGravity(eVar.f2691c), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        if (eVar.f2689a != null) {
            float scrimOpacity = eVar.f2689a.getScrimOpacity(this, view);
            if (scrimOpacity > BitmapDescriptorFactory.HUE_RED) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(eVar.f2689a.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: 0000 */
    public final void onChildViewsChanged(int i) {
        boolean z;
        int i2 = i;
        int f = C0962r.m3579f(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.mDependencySortedChildren.get(i3);
            C0825e eVar = (C0825e) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (eVar.f2700l == ((View) this.mDependencySortedChildren.get(i4))) {
                        offsetChildToAnchor(view, f);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (eVar.f2695g != 0 && !acquireTempRect2.isEmpty()) {
                    int a = C0946c.m3493a(eVar.f2695g, f);
                    int i5 = a & 112;
                    if (i5 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i5 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i6 = a & 7;
                    if (i6 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i6 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (eVar.f2696h != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, f);
                }
                if (i2 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i7 = i3 + 1; i7 < size; i7++) {
                    View view2 = (View) this.mDependencySortedChildren.get(i7);
                    C0825e eVar2 = (C0825e) view2.getLayoutParams();
                    C0822b b = eVar2.mo3420b();
                    if (b != null && b.layoutDependsOn(this, view2, view)) {
                        if (i2 != 0 || !eVar2.mo3426g()) {
                            if (i2 != 2) {
                                z = b.onDependentViewChanged(this, view2, view);
                            } else {
                                b.onDependentViewRemoved(this, view2, view);
                                z = true;
                            }
                            if (i2 == 1) {
                                eVar2.mo3416a(z);
                            }
                        } else {
                            eVar2.mo3427h();
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void offsetChildByInset(android.view.View r9, android.graphics.Rect r10, int r11) {
        /*
            r8 = this;
            boolean r0 = androidx.core.p070g.C0962r.m3603z(r9)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            int r0 = r9.getWidth()
            if (r0 <= 0) goto L_0x0105
            int r0 = r9.getHeight()
            if (r0 > 0) goto L_0x0015
            goto L_0x0105
        L_0x0015:
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0825e) r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r1 = r0.mo3420b()
            android.graphics.Rect r2 = acquireTempRect()
            android.graphics.Rect r3 = acquireTempRect()
            int r4 = r9.getLeft()
            int r5 = r9.getTop()
            int r6 = r9.getRight()
            int r7 = r9.getBottom()
            r3.set(r4, r5, r6, r7)
            if (r1 == 0) goto L_0x0070
            boolean r1 = r1.getInsetDodgeRect(r8, r9, r2)
            if (r1 == 0) goto L_0x0070
            boolean r1 = r3.contains(r2)
            if (r1 == 0) goto L_0x0049
            goto L_0x0073
        L_0x0049:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Rect should be within the child's bounds. Rect:"
            r10.append(r11)
            java.lang.String r11 = r2.toShortString()
            r10.append(r11)
            java.lang.String r11 = " | Bounds:"
            r10.append(r11)
            java.lang.String r11 = r3.toShortString()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0070:
            r2.set(r3)
        L_0x0073:
            releaseTempRect(r3)
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x0080
            releaseTempRect(r2)
            return
        L_0x0080:
            int r1 = r0.f2696h
            int r11 = androidx.core.p070g.C0946c.m3493a(r1, r11)
            r1 = r11 & 48
            r3 = 48
            r4 = 1
            r5 = 0
            if (r1 != r3) goto L_0x00a2
            int r1 = r2.top
            int r3 = r0.topMargin
            int r1 = r1 - r3
            int r3 = r0.f2698j
            int r1 = r1 - r3
            int r3 = r10.top
            if (r1 >= r3) goto L_0x00a2
            int r3 = r10.top
            int r3 = r3 - r1
            r8.setInsetOffsetY(r9, r3)
            r1 = 1
            goto L_0x00a3
        L_0x00a2:
            r1 = 0
        L_0x00a3:
            r3 = r11 & 80
            r6 = 80
            if (r3 != r6) goto L_0x00c1
            int r3 = r8.getHeight()
            int r6 = r2.bottom
            int r3 = r3 - r6
            int r6 = r0.bottomMargin
            int r3 = r3 - r6
            int r6 = r0.f2698j
            int r3 = r3 + r6
            int r6 = r10.bottom
            if (r3 >= r6) goto L_0x00c1
            int r1 = r10.bottom
            int r3 = r3 - r1
            r8.setInsetOffsetY(r9, r3)
            r1 = 1
        L_0x00c1:
            if (r1 != 0) goto L_0x00c6
            r8.setInsetOffsetY(r9, r5)
        L_0x00c6:
            r1 = r11 & 3
            r3 = 3
            if (r1 != r3) goto L_0x00df
            int r1 = r2.left
            int r3 = r0.leftMargin
            int r1 = r1 - r3
            int r3 = r0.f2697i
            int r1 = r1 - r3
            int r3 = r10.left
            if (r1 >= r3) goto L_0x00df
            int r3 = r10.left
            int r3 = r3 - r1
            r8.setInsetOffsetX(r9, r3)
            r1 = 1
            goto L_0x00e0
        L_0x00df:
            r1 = 0
        L_0x00e0:
            r3 = 5
            r11 = r11 & r3
            if (r11 != r3) goto L_0x00fc
            int r11 = r8.getWidth()
            int r3 = r2.right
            int r11 = r11 - r3
            int r3 = r0.rightMargin
            int r11 = r11 - r3
            int r0 = r0.f2697i
            int r11 = r11 + r0
            int r0 = r10.right
            if (r11 >= r0) goto L_0x00fc
            int r10 = r10.right
            int r11 = r11 - r10
            r8.setInsetOffsetX(r9, r11)
            r1 = 1
        L_0x00fc:
            if (r1 != 0) goto L_0x0101
            r8.setInsetOffsetX(r9, r5)
        L_0x0101:
            releaseTempRect(r2)
            return
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.offsetChildByInset(android.view.View, android.graphics.Rect, int):void");
    }

    private void setInsetOffsetX(View view, int i) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        if (eVar.f2697i != i) {
            C0962r.m3582g(view, i - eVar.f2697i);
            eVar.f2697i = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        C0825e eVar = (C0825e) view.getLayoutParams();
        if (eVar.f2698j != i) {
            C0962r.m3580f(view, i - eVar.f2698j);
            eVar.f2698j = i;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        List c = this.mChildDag.mo3442c(view);
        if (c != null && !c.isEmpty()) {
            for (int i = 0; i < c.size(); i++) {
                View view2 = (View) c.get(i);
                C0822b b = ((C0825e) view2.getLayoutParams()).mo3420b();
                if (b != null) {
                    b.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public List<View> getDependencies(View view) {
        List d = this.mChildDag.mo3443d(view);
        this.mTempDependenciesList.clear();
        if (d != null) {
            this.mTempDependenciesList.addAll(d);
        }
        return this.mTempDependenciesList;
    }

    public List<View> getDependents(View view) {
        List c = this.mChildDag.mo3442c(view);
        this.mTempDependenciesList.clear();
        if (c != null) {
            this.mTempDependenciesList.addAll(c);
        }
        return this.mTempDependenciesList;
    }

    /* access modifiers changed from: 0000 */
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    /* access modifiers changed from: 0000 */
    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z == this.mNeedsPreDrawListener) {
            return;
        }
        if (z) {
            addPreDrawListener();
        } else {
            removePreDrawListener();
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.mo3444e(view);
    }

    /* access modifiers changed from: 0000 */
    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new C0826f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    /* access modifiers changed from: 0000 */
    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    /* access modifiers changed from: 0000 */
    public void offsetChildToAnchor(View view, int i) {
        View view2 = view;
        C0825e eVar = (C0825e) view.getLayoutParams();
        if (eVar.f2699k != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(eVar.f2699k, acquireTempRect);
            boolean z = false;
            getChildRect(view2, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i2 = measuredHeight;
            getDesiredAnchoredChildRectWithoutConstraints(view, i, acquireTempRect, acquireTempRect3, eVar, measuredWidth, measuredHeight);
            if (!(acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top)) {
                z = true;
            }
            constrainChildRect(eVar, acquireTempRect3, measuredWidth, i2);
            int i3 = acquireTempRect3.left - acquireTempRect2.left;
            int i4 = acquireTempRect3.top - acquireTempRect2.top;
            if (i3 != 0) {
                C0962r.m3582g(view2, i3);
            }
            if (i4 != 0) {
                C0962r.m3580f(view2, i4);
            }
            if (z) {
                C0822b b = eVar.mo3420b();
                if (b != null) {
                    b.onDependentViewChanged(this, view2, eVar.f2699k);
                }
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left && acquireTempRect.bottom >= acquireTempRect2.top) {
                z = true;
            }
            return z;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    public C0825e generateLayoutParams(AttributeSet attributeSet) {
        return new C0825e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0825e generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof C0825e) {
            return new C0825e((C0825e) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0825e((MarginLayoutParams) layoutParams);
        }
        return new C0825e(layoutParams);
    }

    /* access modifiers changed from: protected */
    public C0825e generateDefaultLayoutParams() {
        return new C0825e(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0825e) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0825e eVar = (C0825e) childAt.getLayoutParams();
                C0822b b = eVar.mo3420b();
                if (b != null) {
                    boolean onStartNestedScroll = b.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    boolean z2 = z | onStartNestedScroll;
                    eVar.mo3413a(i3, onStartNestedScroll);
                    z = z2;
                } else {
                    eVar.mo3413a(i3, false);
                }
            }
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mNestedScrollingParentHelper.mo3756a(view, view2, i, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0825e eVar = (C0825e) childAt.getLayoutParams();
            if (eVar.mo3421b(i2)) {
                C0822b b = eVar.mo3420b();
                if (b != null) {
                    b.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
                }
            }
        }
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.mo3754a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0825e eVar = (C0825e) childAt.getLayoutParams();
            if (eVar.mo3421b(i)) {
                C0822b b = eVar.mo3420b();
                if (b != null) {
                    b.onStopNestedScroll(this, childAt, view, i);
                }
                eVar.mo3412a(i);
                eVar.mo3427h();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                int i7 = i5;
            } else {
                C0825e eVar = (C0825e) childAt.getLayoutParams();
                if (eVar.mo3421b(i5)) {
                    C0822b b = eVar.mo3420b();
                    if (b != null) {
                        b.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5);
                        z = true;
                    }
                }
            }
        }
        if (z) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        int i5;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0825e eVar = (C0825e) childAt.getLayoutParams();
                if (eVar.mo3421b(i3)) {
                    C0822b b = eVar.mo3420b();
                    if (b != null) {
                        int[] iArr2 = this.mTempIntPair;
                        this.mTempIntPair[1] = 0;
                        iArr2[0] = 0;
                        b.onNestedPreScroll(this, childAt, view, i, i2, this.mTempIntPair, i3);
                        if (i > 0) {
                            i4 = Math.max(i6, this.mTempIntPair[0]);
                        } else {
                            i4 = Math.min(i6, this.mTempIntPair[0]);
                        }
                        if (i2 > 0) {
                            i5 = Math.max(i7, this.mTempIntPair[1]);
                        } else {
                            i5 = Math.min(i7, this.mTempIntPair[1]);
                        }
                        i6 = i4;
                        i7 = i5;
                        z = true;
                    }
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0825e eVar = (C0825e) childAt.getLayoutParams();
                if (eVar.mo3421b(0)) {
                    C0822b b = eVar.mo3420b();
                    if (b != null) {
                        z2 |= b.onNestedFling(this, childAt, view, f, f2, z);
                    }
                }
            }
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0825e eVar = (C0825e) childAt.getLayoutParams();
                if (eVar.mo3421b(0)) {
                    C0822b b = eVar.mo3420b();
                    if (b != null) {
                        z |= b.onNestedPreFling(this, childAt, view, f, f2);
                    }
                }
            }
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.mo3752a();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0827g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0827g gVar = (C0827g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        SparseArray<Parcelable> sparseArray = gVar.f2708a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0822b b = getResolvedLayoutParams(childAt).mo3420b();
            if (!(id == -1 || b == null)) {
                Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                if (parcelable2 != null) {
                    b.onRestoreInstanceState(this, childAt, parcelable2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0827g gVar = new C0827g(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0822b b = ((C0825e) childAt.getLayoutParams()).mo3420b();
            if (!(id == -1 || b == null)) {
                Parcelable onSaveInstanceState = b.onSaveInstanceState(this, childAt);
                if (onSaveInstanceState != null) {
                    sparseArray.append(id, onSaveInstanceState);
                }
            }
        }
        gVar.f2708a = sparseArray;
        return gVar;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        C0822b b = ((C0825e) view.getLayoutParams()).mo3420b();
        if (b == null || !b.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void setupForInsets() {
        if (VERSION.SDK_INT >= 21) {
            if (C0962r.m3596s(this)) {
                if (this.mApplyWindowInsetsListener == null) {
                    this.mApplyWindowInsetsListener = new C0959o() {
                        public C0976z onApplyWindowInsets(View view, C0976z zVar) {
                            return CoordinatorLayout.this.setWindowInsets(zVar);
                        }
                    };
                }
                C0962r.m3560a((View) this, this.mApplyWindowInsetsListener);
                setSystemUiVisibility(1280);
            } else {
                C0962r.m3560a((View) this, (C0959o) null);
            }
        }
    }
}
