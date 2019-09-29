package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.core.p070g.C0956l;
import androidx.core.p070g.C0958n;
import androidx.core.p070g.C0962r;
import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ActionBarOverlayLayout extends ViewGroup implements C0605ab, C0956l {

    /* renamed from: e */
    static final int[] f1512e = {R.attr.actionBarSize, 16842841};

    /* renamed from: A */
    private final Runnable f1513A;

    /* renamed from: B */
    private final C0958n f1514B;

    /* renamed from: a */
    ActionBarContainer f1515a;

    /* renamed from: b */
    boolean f1516b;

    /* renamed from: c */
    ViewPropertyAnimator f1517c;

    /* renamed from: d */
    final AnimatorListenerAdapter f1518d;

    /* renamed from: f */
    private int f1519f;

    /* renamed from: g */
    private int f1520g;

    /* renamed from: h */
    private ContentFrameLayout f1521h;

    /* renamed from: i */
    private C0606ac f1522i;

    /* renamed from: j */
    private Drawable f1523j;

    /* renamed from: k */
    private boolean f1524k;

    /* renamed from: l */
    private boolean f1525l;

    /* renamed from: m */
    private boolean f1526m;

    /* renamed from: n */
    private boolean f1527n;

    /* renamed from: o */
    private int f1528o;

    /* renamed from: p */
    private int f1529p;

    /* renamed from: q */
    private final Rect f1530q;

    /* renamed from: r */
    private final Rect f1531r;

    /* renamed from: s */
    private final Rect f1532s;

    /* renamed from: t */
    private final Rect f1533t;

    /* renamed from: u */
    private final Rect f1534u;

    /* renamed from: v */
    private final Rect f1535v;

    /* renamed from: w */
    private final Rect f1536w;

    /* renamed from: x */
    private C0565a f1537x;

    /* renamed from: y */
    private OverScroller f1538y;

    /* renamed from: z */
    private final Runnable f1539z;

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$a */
    public interface C0565a {
        /* renamed from: a */
        void mo1083a(int i);

        /* renamed from: h */
        void mo1086h(boolean z);

        /* renamed from: j */
        void mo1089j();

        /* renamed from: k */
        void mo1091k();

        /* renamed from: l */
        void mo1093l();

        /* renamed from: m */
        void mo1094m();
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$b */
    public static class C0566b extends MarginLayoutParams {
        public C0566b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0566b(int i, int i2) {
            super(i, i2);
        }

        public C0566b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1520g = 0;
        this.f1530q = new Rect();
        this.f1531r = new Rect();
        this.f1532s = new Rect();
        this.f1533t = new Rect();
        this.f1534u = new Rect();
        this.f1535v = new Rect();
        this.f1536w = new Rect();
        this.f1518d = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.f1517c = null;
                ActionBarOverlayLayout.this.f1516b = false;
            }

            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.f1517c = null;
                ActionBarOverlayLayout.this.f1516b = false;
            }
        };
        this.f1539z = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.mo1809d();
                ActionBarOverlayLayout.this.f1517c = ActionBarOverlayLayout.this.f1515a.animate().translationY(BitmapDescriptorFactory.HUE_RED).setListener(ActionBarOverlayLayout.this.f1518d);
            }
        };
        this.f1513A = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.mo1809d();
                ActionBarOverlayLayout.this.f1517c = ActionBarOverlayLayout.this.f1515a.animate().translationY((float) (-ActionBarOverlayLayout.this.f1515a.getHeight())).setListener(ActionBarOverlayLayout.this.f1518d);
            }
        };
        m1892a(context);
        this.f1514B = new C0958n(this);
    }

    /* renamed from: a */
    private void m1892a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1512e);
        boolean z = false;
        this.f1519f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1523j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1523j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f1524k = z;
        this.f1538y = new OverScroller(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo1809d();
    }

    public void setActionBarVisibilityCallback(C0565a aVar) {
        this.f1537x = aVar;
        if (getWindowToken() != null) {
            this.f1537x.mo1083a(this.f1520g);
            if (this.f1529p != 0) {
                onWindowSystemUiVisibilityChanged(this.f1529p);
                C0962r.m3595r(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1525l = z;
        this.f1524k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* renamed from: a */
    public boolean mo1805a() {
        return this.f1525l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1526m = z;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1892a(getContext());
        C0962r.m3595r(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo1807c();
        int i2 = this.f1529p ^ i;
        this.f1529p = i;
        boolean z = false;
        boolean z2 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        }
        if (this.f1537x != null) {
            this.f1537x.mo1086h(!z);
            if (z2 || !z) {
                this.f1537x.mo1089j();
            } else {
                this.f1537x.mo1091k();
            }
        }
        if ((i2 & 256) != 0 && this.f1537x != null) {
            C0962r.m3595r(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1520g = i;
        if (this.f1537x != null) {
            this.f1537x.mo1083a(i);
        }
    }

    /* renamed from: a */
    private boolean m1894a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        C0566b bVar = (C0566b) view.getLayoutParams();
        if (!z || bVar.leftMargin == rect.left) {
            z5 = false;
        } else {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        mo1807c();
        int q = C0962r.m3594q(this) & 256;
        boolean a = m1894a(this.f1515a, rect, true, true, false, true);
        this.f1533t.set(rect);
        C0656bb.m2313a(this, this.f1533t, this.f1530q);
        if (!this.f1534u.equals(this.f1533t)) {
            this.f1534u.set(this.f1533t);
            a = true;
        }
        if (!this.f1531r.equals(this.f1530q)) {
            this.f1531r.set(this.f1530q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0566b generateDefaultLayoutParams() {
        return new C0566b(-1, -1);
    }

    /* renamed from: a */
    public C0566b generateLayoutParams(AttributeSet attributeSet) {
        return new C0566b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0566b(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0566b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        mo1807c();
        measureChildWithMargins(this.f1515a, i, 0, i2, 0);
        C0566b bVar = (C0566b) this.f1515a.getLayoutParams();
        int max = Math.max(0, this.f1515a.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, this.f1515a.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1515a.getMeasuredState());
        boolean z = (C0962r.m3594q(this) & 256) != 0;
        if (z) {
            i3 = this.f1519f;
            if (this.f1526m && this.f1515a.getTabContainer() != null) {
                i3 += this.f1519f;
            }
        } else {
            i3 = this.f1515a.getVisibility() != 8 ? this.f1515a.getMeasuredHeight() : 0;
        }
        this.f1532s.set(this.f1530q);
        this.f1535v.set(this.f1533t);
        if (this.f1525l || z) {
            this.f1535v.top += i3;
            this.f1535v.bottom += 0;
        } else {
            this.f1532s.top += i3;
            this.f1532s.bottom += 0;
        }
        m1894a(this.f1521h, this.f1532s, true, true, true, true);
        if (!this.f1536w.equals(this.f1535v)) {
            this.f1536w.set(this.f1535v);
            this.f1521h.mo1928a(this.f1535v);
        }
        measureChildWithMargins(this.f1521h, i, 0, i2, 0);
        C0566b bVar2 = (C0566b) this.f1521h.getLayoutParams();
        int max3 = Math.max(max, this.f1521h.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int max4 = Math.max(max2, this.f1521h.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1521h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0566b bVar = (C0566b) childAt.getLayoutParams();
                int i6 = bVar.leftMargin + paddingLeft;
                int i7 = bVar.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1523j != null && !this.f1524k) {
            int bottom = this.f1515a.getVisibility() == 0 ? (int) (((float) this.f1515a.getBottom()) + this.f1515a.getTranslationY() + 0.5f) : 0;
            this.f1523j.setBounds(0, bottom, getWidth(), this.f1523j.getIntrinsicHeight() + bottom);
            this.f1523j.draw(canvas);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1515a.getVisibility() != 0) {
            return false;
        }
        return this.f1527n;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1514B.mo3755a(view, view2, i);
        this.f1528o = getActionBarHideOffset();
        mo1809d();
        if (this.f1537x != null) {
            this.f1537x.mo1093l();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1528o += i2;
        setActionBarHideOffset(this.f1528o);
    }

    public void onStopNestedScroll(View view) {
        if (this.f1527n && !this.f1516b) {
            if (this.f1528o <= this.f1515a.getHeight()) {
                m1895l();
            } else {
                m1896m();
            }
        }
        if (this.f1537x != null) {
            this.f1537x.mo1094m();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1527n || !z) {
            return false;
        }
        if (m1893a(f, f2)) {
            m1898o();
        } else {
            m1897n();
        }
        this.f1516b = true;
        return true;
    }

    public int getNestedScrollAxes() {
        return this.f1514B.mo3752a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo1807c() {
        if (this.f1521h == null) {
            this.f1521h = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f1515a = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f1522i = m1891a(findViewById(R.id.action_bar));
        }
    }

    /* renamed from: a */
    private C0606ac m1891a(View view) {
        if (view instanceof C0606ac) {
            return (C0606ac) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view.getClass().getSimpleName());
        throw new IllegalStateException(sb.toString());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1527n) {
            this.f1527n = z;
            if (!z) {
                mo1809d();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        if (this.f1515a != null) {
            return -((int) this.f1515a.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        mo1809d();
        this.f1515a.setTranslationY((float) (-Math.max(0, Math.min(i, this.f1515a.getHeight()))));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo1809d() {
        removeCallbacks(this.f1539z);
        removeCallbacks(this.f1513A);
        if (this.f1517c != null) {
            this.f1517c.cancel();
        }
    }

    /* renamed from: l */
    private void m1895l() {
        mo1809d();
        postDelayed(this.f1539z, 600);
    }

    /* renamed from: m */
    private void m1896m() {
        mo1809d();
        postDelayed(this.f1513A, 600);
    }

    /* renamed from: n */
    private void m1897n() {
        mo1809d();
        this.f1539z.run();
    }

    /* renamed from: o */
    private void m1898o() {
        mo1809d();
        this.f1513A.run();
    }

    /* renamed from: a */
    private boolean m1893a(float f, float f2) {
        this.f1538y.fling(0, 0, 0, (int) f2, 0, 0, C1024a.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
        return this.f1538y.getFinalY() > this.f1515a.getHeight();
    }

    public void setWindowCallback(Callback callback) {
        mo1807c();
        this.f1522i.mo2162a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        mo1807c();
        this.f1522i.mo2165a(charSequence);
    }

    public CharSequence getTitle() {
        mo1807c();
        return this.f1522i.mo2175e();
    }

    /* renamed from: a */
    public void mo1803a(int i) {
        mo1807c();
        if (i == 2) {
            this.f1522i.mo2176f();
        } else if (i == 5) {
            this.f1522i.mo2177g();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public void setIcon(int i) {
        mo1807c();
        this.f1522i.mo2159a(i);
    }

    public void setIcon(Drawable drawable) {
        mo1807c();
        this.f1522i.mo2160a(drawable);
    }

    public void setLogo(int i) {
        mo1807c();
        this.f1522i.mo2168b(i);
    }

    /* renamed from: e */
    public boolean mo1811e() {
        mo1807c();
        return this.f1522i.mo2178h();
    }

    /* renamed from: f */
    public boolean mo1812f() {
        mo1807c();
        return this.f1522i.mo2179i();
    }

    /* renamed from: g */
    public boolean mo1814g() {
        mo1807c();
        return this.f1522i.mo2180j();
    }

    /* renamed from: h */
    public boolean mo1821h() {
        mo1807c();
        return this.f1522i.mo2181k();
    }

    /* renamed from: i */
    public boolean mo1822i() {
        mo1807c();
        return this.f1522i.mo2182l();
    }

    /* renamed from: j */
    public void mo1823j() {
        mo1807c();
        this.f1522i.mo2183m();
    }

    /* renamed from: a */
    public void mo1804a(Menu menu, C0550a aVar) {
        mo1807c();
        this.f1522i.mo2161a(menu, aVar);
    }

    /* renamed from: k */
    public void mo1824k() {
        mo1807c();
        this.f1522i.mo2184n();
    }
}
