package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.C0875a;
import androidx.core.p070g.C0932a;
import androidx.core.p070g.C0959o;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0976z;
import androidx.core.p070g.p071a.C0935b;
import androidx.customview.p072a.C1021a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.common.primitives.Ints;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {

    /* renamed from: a */
    static final int[] f4353a = {16842931};

    /* renamed from: aj */
    private static final C1480j f4354aj = new C1480j();

    /* renamed from: e */
    private static final Comparator<C1471b> f4355e = new Comparator<C1471b>() {
        /* renamed from: a */
        public int compare(C1471b bVar, C1471b bVar2) {
            return bVar.f4418b - bVar2.f4418b;
        }
    };

    /* renamed from: f */
    private static final Interpolator f4356f = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: A */
    private int f4357A = 1;

    /* renamed from: B */
    private boolean f4358B;

    /* renamed from: C */
    private boolean f4359C;

    /* renamed from: D */
    private int f4360D;

    /* renamed from: E */
    private int f4361E;

    /* renamed from: F */
    private int f4362F;

    /* renamed from: G */
    private float f4363G;

    /* renamed from: H */
    private float f4364H;

    /* renamed from: I */
    private float f4365I;

    /* renamed from: J */
    private float f4366J;

    /* renamed from: K */
    private int f4367K = -1;

    /* renamed from: L */
    private VelocityTracker f4368L;

    /* renamed from: M */
    private int f4369M;

    /* renamed from: N */
    private int f4370N;

    /* renamed from: O */
    private int f4371O;

    /* renamed from: P */
    private int f4372P;

    /* renamed from: Q */
    private boolean f4373Q;

    /* renamed from: R */
    private long f4374R;

    /* renamed from: S */
    private EdgeEffect f4375S;

    /* renamed from: T */
    private EdgeEffect f4376T;

    /* renamed from: U */
    private boolean f4377U = true;

    /* renamed from: V */
    private boolean f4378V = false;

    /* renamed from: W */
    private boolean f4379W;

    /* renamed from: aa */
    private int f4380aa;

    /* renamed from: ab */
    private List<C1475f> f4381ab;

    /* renamed from: ac */
    private C1475f f4382ac;

    /* renamed from: ad */
    private C1475f f4383ad;

    /* renamed from: ae */
    private List<C1474e> f4384ae;

    /* renamed from: af */
    private C1476g f4385af;

    /* renamed from: ag */
    private int f4386ag;

    /* renamed from: ah */
    private int f4387ah;

    /* renamed from: ai */
    private ArrayList<View> f4388ai;

    /* renamed from: ak */
    private final Runnable f4389ak = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.mo6083c();
        }
    };

    /* renamed from: al */
    private int f4390al = 0;

    /* renamed from: b */
    C1481a f4391b;

    /* renamed from: c */
    int f4392c;

    /* renamed from: d */
    private int f4393d;

    /* renamed from: g */
    private final ArrayList<C1471b> f4394g = new ArrayList<>();

    /* renamed from: h */
    private final C1471b f4395h = new C1471b();

    /* renamed from: i */
    private final Rect f4396i = new Rect();

    /* renamed from: j */
    private int f4397j = -1;

    /* renamed from: k */
    private Parcelable f4398k = null;

    /* renamed from: l */
    private ClassLoader f4399l = null;

    /* renamed from: m */
    private Scroller f4400m;

    /* renamed from: n */
    private boolean f4401n;

    /* renamed from: o */
    private C1477h f4402o;

    /* renamed from: p */
    private int f4403p;

    /* renamed from: q */
    private Drawable f4404q;

    /* renamed from: r */
    private int f4405r;

    /* renamed from: s */
    private int f4406s;

    /* renamed from: t */
    private float f4407t = -3.4028235E38f;

    /* renamed from: u */
    private float f4408u = Float.MAX_VALUE;

    /* renamed from: v */
    private int f4409v;

    /* renamed from: w */
    private int f4410w;

    /* renamed from: x */
    private boolean f4411x;

    /* renamed from: y */
    private boolean f4412y;

    /* renamed from: z */
    private boolean f4413z;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.viewpager.widget.ViewPager$a */
    public @interface C1470a {
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$b */
    static class C1471b {

        /* renamed from: a */
        Object f4417a;

        /* renamed from: b */
        int f4418b;

        /* renamed from: c */
        boolean f4419c;

        /* renamed from: d */
        float f4420d;

        /* renamed from: e */
        float f4421e;

        C1471b() {
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$c */
    public static class C1472c extends LayoutParams {

        /* renamed from: a */
        public boolean f4422a;

        /* renamed from: b */
        public int f4423b;

        /* renamed from: c */
        float f4424c = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: d */
        boolean f4425d;

        /* renamed from: e */
        int f4426e;

        /* renamed from: f */
        int f4427f;

        public C1472c() {
            super(-1, -1);
        }

        public C1472c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f4353a);
            this.f4423b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$d */
    class C1473d extends C0932a {
        C1473d() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m5903a());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f4391b != null) {
                accessibilityEvent.setItemCount(ViewPager.this.f4391b.mo6151b());
                accessibilityEvent.setFromIndex(ViewPager.this.f4392c);
                accessibilityEvent.setToIndex(ViewPager.this.f4392c);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.mo3679b((CharSequence) ViewPager.class.getName());
            bVar.mo3703i(m5903a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                bVar.mo3669a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                bVar.mo3669a(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager.this.setCurrentItem(ViewPager.this.f4392c - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager.this.setCurrentItem(ViewPager.this.f4392c + 1);
                return true;
            }
        }

        /* renamed from: a */
        private boolean m5903a() {
            return ViewPager.this.f4391b != null && ViewPager.this.f4391b.mo6151b() > 1;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$e */
    public interface C1474e {
        void onAdapterChanged(ViewPager viewPager, C1481a aVar, C1481a aVar2);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$f */
    public interface C1475f {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$g */
    public interface C1476g {
        /* renamed from: a */
        void mo6134a(View view, float f);
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$h */
    private class C1477h extends DataSetObserver {
        C1477h() {
        }

        public void onChanged() {
            ViewPager.this.mo6079b();
        }

        public void onInvalidated() {
            ViewPager.this.mo6079b();
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$i */
    public static class C1478i extends C1021a {
        public static final Creator<C1478i> CREATOR = new ClassLoaderCreator<C1478i>() {
            /* renamed from: a */
            public C1478i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C1478i(parcel, classLoader);
            }

            /* renamed from: a */
            public C1478i createFromParcel(Parcel parcel) {
                return new C1478i(parcel, null);
            }

            /* renamed from: a */
            public C1478i[] newArray(int i) {
                return new C1478i[i];
            }
        };

        /* renamed from: a */
        int f4430a;

        /* renamed from: b */
        Parcelable f4431b;

        /* renamed from: c */
        ClassLoader f4432c;

        public C1478i(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4430a);
            parcel.writeParcelable(this.f4431b, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            sb.append(this.f4430a);
            sb.append("}");
            return sb.toString();
        }

        C1478i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f4430a = parcel.readInt();
            this.f4431b = parcel.readParcelable(classLoader);
            this.f4432c = classLoader;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$j */
    static class C1480j implements Comparator<View> {
        C1480j() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            C1472c cVar = (C1472c) view.getLayoutParams();
            C1472c cVar2 = (C1472c) view2.getLayoutParams();
            if (cVar.f4422a == cVar2.f4422a) {
                return cVar.f4426e - cVar2.f4426e;
            }
            return cVar.f4422a ? 1 : -1;
        }
    }

    public ViewPager(Context context) {
        super(context);
        mo6061a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo6061a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6061a() {
        setWillNotDraw(false);
        setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
        setFocusable(true);
        Context context = getContext();
        this.f4400m = new Scroller(context, f4356f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f4362F = viewConfiguration.getScaledPagingTouchSlop();
        this.f4369M = (int) (400.0f * f);
        this.f4370N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4375S = new EdgeEffect(context);
        this.f4376T = new EdgeEffect(context);
        this.f4371O = (int) (25.0f * f);
        this.f4372P = (int) (2.0f * f);
        this.f4360D = (int) (f * 16.0f);
        C0962r.m3559a((View) this, (C0932a) new C1473d());
        if (C0962r.m3577e(this) == 0) {
            C0962r.m3569b((View) this, 1);
        }
        C0962r.m3560a((View) this, (C0959o) new C0959o() {

            /* renamed from: b */
            private final Rect f4416b = new Rect();

            public C0976z onApplyWindowInsets(View view, C0976z zVar) {
                C0976z a = C0962r.m3549a(view, zVar);
                if (a.mo3783f()) {
                    return a;
                }
                Rect rect = this.f4416b;
                rect.left = a.mo3776a();
                rect.top = a.mo3778b();
                rect.right = a.mo3779c();
                rect.bottom = a.mo3780d();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    C0976z b = C0962r.m3568b(ViewPager.this.getChildAt(i), a);
                    rect.left = Math.min(b.mo3776a(), rect.left);
                    rect.top = Math.min(b.mo3778b(), rect.top);
                    rect.right = Math.min(b.mo3779c(), rect.right);
                    rect.bottom = Math.min(b.mo3780d(), rect.bottom);
                }
                return a.mo3777a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4389ak);
        if (this.f4400m != null && !this.f4400m.isFinished()) {
            this.f4400m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: 0000 */
    public void setScrollState(int i) {
        if (this.f4390al != i) {
            this.f4390al = i;
            if (this.f4385af != null) {
                m5861b(i != 0);
            }
            m5867f(i);
        }
    }

    public void setAdapter(C1481a aVar) {
        if (this.f4391b != null) {
            this.f4391b.mo6157c((DataSetObserver) null);
            this.f4391b.mo4501a((ViewGroup) this);
            for (int i = 0; i < this.f4394g.size(); i++) {
                C1471b bVar = (C1471b) this.f4394g.get(i);
                this.f4391b.mo4502a((ViewGroup) this, bVar.f4418b, bVar.f4417a);
            }
            this.f4391b.mo4505b((ViewGroup) this);
            this.f4394g.clear();
            m5868i();
            this.f4392c = 0;
            scrollTo(0, 0);
        }
        C1481a aVar2 = this.f4391b;
        this.f4391b = aVar;
        this.f4393d = 0;
        if (this.f4391b != null) {
            if (this.f4402o == null) {
                this.f4402o = new C1477h();
            }
            this.f4391b.mo6157c((DataSetObserver) this.f4402o);
            this.f4413z = false;
            boolean z = this.f4377U;
            this.f4377U = true;
            this.f4393d = this.f4391b.mo6151b();
            if (this.f4397j >= 0) {
                this.f4391b.mo4500a(this.f4398k, this.f4399l);
                mo6066a(this.f4397j, false, true);
                this.f4397j = -1;
                this.f4398k = null;
                this.f4399l = null;
            } else if (!z) {
                mo6083c();
            } else {
                requestLayout();
            }
        }
        if (this.f4384ae != null && !this.f4384ae.isEmpty()) {
            int size = this.f4384ae.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((C1474e) this.f4384ae.get(i2)).onAdapterChanged(this, aVar2, aVar);
            }
        }
    }

    /* renamed from: i */
    private void m5868i() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C1472c) getChildAt(i).getLayoutParams()).f4422a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public C1481a getAdapter() {
        return this.f4391b;
    }

    /* renamed from: a */
    public void mo6068a(C1474e eVar) {
        if (this.f4384ae == null) {
            this.f4384ae = new ArrayList();
        }
        this.f4384ae.add(eVar);
    }

    /* renamed from: b */
    public void mo6081b(C1474e eVar) {
        if (this.f4384ae != null) {
            this.f4384ae.remove(eVar);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.f4413z = false;
        mo6066a(i, !this.f4377U, false);
    }

    /* renamed from: a */
    public void mo6065a(int i, boolean z) {
        this.f4413z = false;
        mo6066a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f4392c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6066a(int i, boolean z, boolean z2) {
        mo6067a(i, z, z2, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6067a(int i, boolean z, boolean z2, int i2) {
        if (this.f4391b == null || this.f4391b.mo6151b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f4392c != i || this.f4394g.size() == 0) {
            boolean z3 = true;
            if (i < 0) {
                i = 0;
            } else if (i >= this.f4391b.mo6151b()) {
                i = this.f4391b.mo6151b() - 1;
            }
            int i3 = this.f4357A;
            if (i > this.f4392c + i3 || i < this.f4392c - i3) {
                for (int i4 = 0; i4 < this.f4394g.size(); i4++) {
                    ((C1471b) this.f4394g.get(i4)).f4419c = true;
                }
            }
            if (this.f4392c == i) {
                z3 = false;
            }
            if (this.f4377U) {
                this.f4392c = i;
                if (z3) {
                    m5866e(i);
                }
                requestLayout();
            } else {
                mo6062a(i);
                m5855a(i, z, i2, z3);
            }
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* renamed from: a */
    private void m5855a(int i, boolean z, int i2, boolean z2) {
        C1471b b = mo6077b(i);
        int clientWidth = b != null ? (int) (((float) getClientWidth()) * Math.max(this.f4407t, Math.min(b.f4421e, this.f4408u))) : 0;
        if (z) {
            mo6064a(clientWidth, 0, i2);
            if (z2) {
                m5866e(i);
                return;
            }
            return;
        }
        if (z2) {
            m5866e(i);
        }
        m5858a(false);
        scrollTo(clientWidth, 0);
        m5865d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(C1475f fVar) {
        this.f4382ac = fVar;
    }

    /* renamed from: a */
    public void mo6069a(C1475f fVar) {
        if (this.f4381ab == null) {
            this.f4381ab = new ArrayList();
        }
        this.f4381ab.add(fVar);
    }

    /* renamed from: b */
    public void mo6082b(C1475f fVar) {
        if (this.f4381ab != null) {
            this.f4381ab.remove(fVar);
        }
    }

    /* renamed from: a */
    public void mo6070a(boolean z, C1476g gVar) {
        mo6071a(z, gVar, 2);
    }

    /* renamed from: a */
    public void mo6071a(boolean z, C1476g gVar, int i) {
        int i2 = 1;
        boolean z2 = gVar != null;
        boolean z3 = z2 != (this.f4385af != null);
        this.f4385af = gVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.f4387ah = i2;
            this.f4386ag = i;
        } else {
            this.f4387ah = 0;
        }
        if (z3) {
            mo6083c();
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f4387ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C1472c) ((View) this.f4388ai.get(i2)).getLayoutParams()).f4427f;
    }

    public int getOffscreenPageLimit() {
        return this.f4357A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            Log.w("ViewPager", sb.toString());
            i = 1;
        }
        if (i != this.f4357A) {
            this.f4357A = i;
            mo6083c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f4403p;
        this.f4403p = i;
        int width = getWidth();
        m5854a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f4403p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f4404q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(C0875a.m3239a(getContext(), i));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4404q;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4404q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo6058a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6064a(int i, int i2, int i3) {
        int i4;
        int i5;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (this.f4400m != null && !this.f4400m.isFinished()) {
            i4 = this.f4401n ? this.f4400m.getCurrX() : this.f4400m.getStartX();
            this.f4400m.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i4 = getScrollX();
        }
        int i6 = i4;
        int scrollY = getScrollY();
        int i7 = i - i6;
        int i8 = i2 - scrollY;
        if (i7 == 0 && i8 == 0) {
            m5858a(false);
            mo6083c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i9 = clientWidth / 2;
        float f = (float) clientWidth;
        float f2 = (float) i9;
        float a = f2 + (mo6058a(Math.min(1.0f, (((float) Math.abs(i7)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i7)) / ((f * this.f4391b.mo6158d(this.f4392c)) + ((float) this.f4403p))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i5, 600);
        this.f4401n = false;
        this.f4400m.startScroll(i6, scrollY, i7, i8, min);
        C0962r.m3575d(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1471b mo6059a(int i, int i2) {
        C1471b bVar = new C1471b();
        bVar.f4418b = i;
        bVar.f4417a = this.f4391b.mo4499a((ViewGroup) this, i);
        bVar.f4420d = this.f4391b.mo6158d(i);
        if (i2 < 0 || i2 >= this.f4394g.size()) {
            this.f4394g.add(bVar);
        } else {
            this.f4394g.add(i2, bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6079b() {
        int b = this.f4391b.mo6151b();
        this.f4393d = b;
        boolean z = this.f4394g.size() < (this.f4357A * 2) + 1 && this.f4394g.size() < b;
        int i = this.f4392c;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f4394g.size()) {
            C1471b bVar = (C1471b) this.f4394g.get(i2);
            int a = this.f4391b.mo6146a(bVar.f4417a);
            if (a != -1) {
                if (a == -2) {
                    this.f4394g.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f4391b.mo4501a((ViewGroup) this);
                        z2 = true;
                    }
                    this.f4391b.mo4502a((ViewGroup) this, bVar.f4418b, bVar.f4417a);
                    if (this.f4392c == bVar.f4418b) {
                        i = Math.max(0, Math.min(this.f4392c, b - 1));
                    }
                } else if (bVar.f4418b != a) {
                    if (bVar.f4418b == this.f4392c) {
                        i = a;
                    }
                    bVar.f4418b = a;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f4391b.mo4505b((ViewGroup) this);
        }
        Collections.sort(this.f4394g, f4355e);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                C1472c cVar = (C1472c) getChildAt(i3).getLayoutParams();
                if (!cVar.f4422a) {
                    cVar.f4424c = BitmapDescriptorFactory.HUE_RED;
                }
            }
            mo6066a(i, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo6083c() {
        mo6062a(this.f4392c);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r8.f4418b == r0.f4392c) goto L_0x006d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6062a(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.f4392c
            if (r2 == r1) goto L_0x0011
            int r2 = r0.f4392c
            androidx.viewpager.widget.ViewPager$b r2 = r0.mo6077b(r2)
            r0.f4392c = r1
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            androidx.viewpager.widget.a r1 = r0.f4391b
            if (r1 != 0) goto L_0x001a
            r17.m5869j()
            return
        L_0x001a:
            boolean r1 = r0.f4413z
            if (r1 == 0) goto L_0x0022
            r17.m5869j()
            return
        L_0x0022:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0029
            return
        L_0x0029:
            androidx.viewpager.widget.a r1 = r0.f4391b
            r1.mo4501a(r0)
            int r1 = r0.f4357A
            int r4 = r0.f4392c
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.a r6 = r0.f4391b
            int r6 = r6.mo6151b()
            int r7 = r6 + -1
            int r8 = r0.f4392c
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.f4393d
            if (r6 != r7) goto L_0x0216
            r7 = 0
        L_0x004c:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r8 = r0.f4394g
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x006c
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r8 = r0.f4394g
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$b r8 = (androidx.viewpager.widget.ViewPager.C1471b) r8
            int r9 = r8.f4418b
            int r10 = r0.f4392c
            if (r9 < r10) goto L_0x0069
            int r9 = r8.f4418b
            int r10 = r0.f4392c
            if (r9 != r10) goto L_0x006c
            goto L_0x006d
        L_0x0069:
            int r7 = r7 + 1
            goto L_0x004c
        L_0x006c:
            r8 = 0
        L_0x006d:
            if (r8 != 0) goto L_0x0077
            if (r6 <= 0) goto L_0x0077
            int r8 = r0.f4392c
            androidx.viewpager.widget.ViewPager$b r8 = r0.mo6059a(r8, r7)
        L_0x0077:
            r9 = 0
            if (r8 == 0) goto L_0x01a3
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0087
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r11 = r0.f4394g
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$b r11 = (androidx.viewpager.widget.ViewPager.C1471b) r11
            goto L_0x0088
        L_0x0087:
            r11 = 0
        L_0x0088:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x0092
            r3 = 0
            goto L_0x009f
        L_0x0092:
            float r14 = r8.f4420d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r3 = r14 + r15
        L_0x009f:
            int r14 = r0.f4392c
            int r14 = r14 + -1
            r15 = r7
            r7 = 0
        L_0x00a5:
            if (r14 < 0) goto L_0x0105
            int r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00d3
            if (r14 >= r4) goto L_0x00d3
            if (r11 != 0) goto L_0x00b0
            goto L_0x0105
        L_0x00b0:
            int r5 = r11.f4418b
            if (r14 != r5) goto L_0x0101
            boolean r5 = r11.f4419c
            if (r5 != 0) goto L_0x0101
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            r5.remove(r10)
            androidx.viewpager.widget.a r5 = r0.f4391b
            java.lang.Object r11 = r11.f4417a
            r5.mo4502a(r0, r14, r11)
            int r10 = r10 + -1
            int r15 = r15 + -1
            if (r10 < 0) goto L_0x00ff
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.C1471b) r5
            goto L_0x0100
        L_0x00d3:
            if (r11 == 0) goto L_0x00e9
            int r5 = r11.f4418b
            if (r14 != r5) goto L_0x00e9
            float r5 = r11.f4420d
            float r7 = r7 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00ff
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.C1471b) r5
            goto L_0x0100
        L_0x00e9:
            int r5 = r10 + 1
            androidx.viewpager.widget.ViewPager$b r5 = r0.mo6059a(r14, r5)
            float r5 = r5.f4420d
            float r7 = r7 + r5
            int r15 = r15 + 1
            if (r10 < 0) goto L_0x00ff
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.C1471b) r5
            goto L_0x0100
        L_0x00ff:
            r5 = 0
        L_0x0100:
            r11 = r5
        L_0x0101:
            int r14 = r14 + -1
            r5 = 0
            goto L_0x00a5
        L_0x0105:
            float r3 = r8.f4420d
            int r4 = r15 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0197
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x011e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.C1471b) r5
            goto L_0x011f
        L_0x011e:
            r5 = 0
        L_0x011f:
            if (r12 > 0) goto L_0x0123
            r7 = 0
            goto L_0x012b
        L_0x0123:
            int r7 = r17.getPaddingRight()
            float r7 = (float) r7
            float r10 = (float) r12
            float r7 = r7 / r10
            float r7 = r7 + r13
        L_0x012b:
            int r10 = r0.f4392c
        L_0x012d:
            int r10 = r10 + 1
            if (r10 >= r6) goto L_0x0197
            int r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r11 < 0) goto L_0x0161
            if (r10 <= r1) goto L_0x0161
            if (r5 != 0) goto L_0x013a
            goto L_0x0197
        L_0x013a:
            int r11 = r5.f4418b
            if (r10 != r11) goto L_0x0196
            boolean r11 = r5.f4419c
            if (r11 != 0) goto L_0x0196
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r11 = r0.f4394g
            r11.remove(r4)
            androidx.viewpager.widget.a r11 = r0.f4391b
            java.lang.Object r5 = r5.f4417a
            r11.mo4502a(r0, r10, r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015f
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.C1471b) r5
            goto L_0x0196
        L_0x015f:
            r5 = 0
            goto L_0x0196
        L_0x0161:
            if (r5 == 0) goto L_0x017d
            int r11 = r5.f4418b
            if (r10 != r11) goto L_0x017d
            float r5 = r5.f4420d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015f
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.C1471b) r5
            goto L_0x0196
        L_0x017d:
            androidx.viewpager.widget.ViewPager$b r5 = r0.mo6059a(r10, r4)
            int r4 = r4 + 1
            float r5 = r5.f4420d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015f
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f4394g
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.C1471b) r5
        L_0x0196:
            goto L_0x012d
        L_0x0197:
            r0.m5857a(r8, r15, r2)
            androidx.viewpager.widget.a r1 = r0.f4391b
            int r2 = r0.f4392c
            java.lang.Object r3 = r8.f4417a
            r1.mo4506b(r0, r2, r3)
        L_0x01a3:
            androidx.viewpager.widget.a r1 = r0.f4391b
            r1.mo4505b(r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01ad:
            if (r2 >= r1) goto L_0x01d6
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r4 = (androidx.viewpager.widget.ViewPager.C1472c) r4
            r4.f4427f = r2
            boolean r5 = r4.f4422a
            if (r5 != 0) goto L_0x01d3
            float r5 = r4.f4424c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01d3
            androidx.viewpager.widget.ViewPager$b r3 = r0.mo6060a(r3)
            if (r3 == 0) goto L_0x01d3
            float r5 = r3.f4420d
            r4.f4424c = r5
            int r3 = r3.f4418b
            r4.f4426e = r3
        L_0x01d3:
            int r2 = r2 + 1
            goto L_0x01ad
        L_0x01d6:
            r17.m5869j()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x0215
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01ea
            androidx.viewpager.widget.ViewPager$b r3 = r0.mo6078b(r1)
            goto L_0x01eb
        L_0x01ea:
            r3 = 0
        L_0x01eb:
            if (r3 == 0) goto L_0x01f3
            int r1 = r3.f4418b
            int r2 = r0.f4392c
            if (r1 == r2) goto L_0x0215
        L_0x01f3:
            r1 = 0
        L_0x01f4:
            int r2 = r17.getChildCount()
            if (r1 >= r2) goto L_0x0215
            android.view.View r2 = r0.getChildAt(r1)
            androidx.viewpager.widget.ViewPager$b r3 = r0.mo6060a(r2)
            if (r3 == 0) goto L_0x0212
            int r3 = r3.f4418b
            int r4 = r0.f4392c
            if (r3 != r4) goto L_0x0212
            r3 = 2
            boolean r2 = r2.requestFocus(r3)
            if (r2 == 0) goto L_0x0212
            goto L_0x0215
        L_0x0212:
            int r1 = r1 + 1
            goto L_0x01f4
        L_0x0215:
            return
        L_0x0216:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0223 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0223 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0223 }
            goto L_0x022b
        L_0x0223:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x022b:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.f4393d
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.a r1 = r0.f4391b
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.mo6062a(int):void");
    }

    /* renamed from: j */
    private void m5869j() {
        if (this.f4387ah != 0) {
            if (this.f4388ai == null) {
                this.f4388ai = new ArrayList<>();
            } else {
                this.f4388ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f4388ai.add(getChildAt(i));
            }
            Collections.sort(this.f4388ai, f4354aj);
        }
    }

    /* renamed from: a */
    private void m5857a(C1471b bVar, int i, C1471b bVar2) {
        C1471b bVar3;
        C1471b bVar4;
        int b = this.f4391b.mo6151b();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.f4403p) / ((float) clientWidth) : BitmapDescriptorFactory.HUE_RED;
        if (bVar2 != null) {
            int i2 = bVar2.f4418b;
            if (i2 < bVar.f4418b) {
                float f2 = bVar2.f4421e + bVar2.f4420d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.f4418b && i4 < this.f4394g.size()) {
                    Object obj = this.f4394g.get(i4);
                    while (true) {
                        bVar4 = (C1471b) obj;
                        if (i3 > bVar4.f4418b && i4 < this.f4394g.size() - 1) {
                            i4++;
                            obj = this.f4394g.get(i4);
                        }
                    }
                    while (i3 < bVar4.f4418b) {
                        f2 += this.f4391b.mo6158d(i3) + f;
                        i3++;
                    }
                    bVar4.f4421e = f2;
                    f2 += bVar4.f4420d + f;
                    i3++;
                }
            } else if (i2 > bVar.f4418b) {
                int size = this.f4394g.size() - 1;
                float f3 = bVar2.f4421e;
                while (true) {
                    i2--;
                    if (i2 < bVar.f4418b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f4394g.get(size);
                    while (true) {
                        bVar3 = (C1471b) obj2;
                        if (i2 < bVar3.f4418b && size > 0) {
                            size--;
                            obj2 = this.f4394g.get(size);
                        }
                    }
                    while (i2 > bVar3.f4418b) {
                        f3 -= this.f4391b.mo6158d(i2) + f;
                        i2--;
                    }
                    f3 -= bVar3.f4420d + f;
                    bVar3.f4421e = f3;
                }
            }
        }
        int size2 = this.f4394g.size();
        float f4 = bVar.f4421e;
        int i5 = bVar.f4418b - 1;
        this.f4407t = bVar.f4418b == 0 ? bVar.f4421e : -3.4028235E38f;
        int i6 = b - 1;
        this.f4408u = bVar.f4418b == i6 ? (bVar.f4421e + bVar.f4420d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            C1471b bVar5 = (C1471b) this.f4394g.get(i7);
            while (i5 > bVar5.f4418b) {
                f4 -= this.f4391b.mo6158d(i5) + f;
                i5--;
            }
            f4 -= bVar5.f4420d + f;
            bVar5.f4421e = f4;
            if (bVar5.f4418b == 0) {
                this.f4407t = f4;
            }
            i7--;
            i5--;
        }
        float f5 = bVar.f4421e + bVar.f4420d + f;
        int i8 = bVar.f4418b + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            C1471b bVar6 = (C1471b) this.f4394g.get(i9);
            while (i8 < bVar6.f4418b) {
                f5 += this.f4391b.mo6158d(i8) + f;
                i8++;
            }
            if (bVar6.f4418b == i6) {
                this.f4408u = (bVar6.f4420d + f5) - 1.0f;
            }
            bVar6.f4421e = f5;
            f5 += bVar6.f4420d + f;
            i9++;
            i8++;
        }
        this.f4378V = false;
    }

    public Parcelable onSaveInstanceState() {
        C1478i iVar = new C1478i(super.onSaveInstanceState());
        iVar.f4430a = this.f4392c;
        if (this.f4391b != null) {
            iVar.f4431b = this.f4391b.mo4497a();
        }
        return iVar;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1478i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1478i iVar = (C1478i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        if (this.f4391b != null) {
            this.f4391b.mo4500a(iVar.f4431b, iVar.f4432c);
            mo6066a(iVar.f4430a, false, true);
        } else {
            this.f4397j = iVar.f4430a;
            this.f4398k = iVar.f4431b;
            this.f4399l = iVar.f4432c;
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C1472c cVar = (C1472c) layoutParams;
        cVar.f4422a |= m5864c(view);
        if (!this.f4411x) {
            super.addView(view, i, layoutParams);
        } else if (cVar == null || !cVar.f4422a) {
            cVar.f4425d = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* renamed from: c */
    private static boolean m5864c(View view) {
        return view.getClass().getAnnotation(C1470a.class) != null;
    }

    public void removeView(View view) {
        if (this.f4411x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1471b mo6060a(View view) {
        for (int i = 0; i < this.f4394g.size(); i++) {
            C1471b bVar = (C1471b) this.f4394g.get(i);
            if (this.f4391b.mo4503a(view, bVar.f4417a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C1471b mo6078b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo6060a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = (View) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C1471b mo6077b(int i) {
        for (int i2 = 0; i2 < this.f4394g.size(); i2++) {
            C1471b bVar = (C1471b) this.f4394g.get(i2);
            if (bVar.f4418b == i) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4377U = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r2 = r17
            int r2 = getDefaultSize(r1, r2)
            r3 = r18
            int r3 = getDefaultSize(r1, r3)
            r0.setMeasuredDimension(r2, r3)
            int r2 = r16.getMeasuredWidth()
            int r3 = r2 / 10
            int r4 = r0.f4360D
            int r3 = java.lang.Math.min(r3, r4)
            r0.f4361E = r3
            int r3 = r16.getPaddingLeft()
            int r2 = r2 - r3
            int r3 = r16.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r16.getMeasuredHeight()
            int r4 = r16.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r16.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r16.getChildCount()
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x003f:
            r6 = 8
            r7 = 1
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r4) goto L_0x00c6
            android.view.View r9 = r0.getChildAt(r2)
            int r10 = r9.getVisibility()
            if (r10 == r6) goto L_0x00c1
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r6 = (androidx.viewpager.widget.ViewPager.C1472c) r6
            if (r6 == 0) goto L_0x00c1
            boolean r10 = r6.f4422a
            if (r10 == 0) goto L_0x00c1
            int r10 = r6.f4423b
            r10 = r10 & 7
            int r11 = r6.f4423b
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 48
            if (r11 == r12) goto L_0x006f
            r12 = 80
            if (r11 != r12) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r11 = 0
            goto L_0x0070
        L_0x006f:
            r11 = 1
        L_0x0070:
            r12 = 3
            if (r10 == r12) goto L_0x0078
            r12 = 5
            if (r10 != r12) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x0081
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x007e:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0085
        L_0x0081:
            if (r7 == 0) goto L_0x007e
            r12 = 1073741824(0x40000000, float:2.0)
        L_0x0085:
            int r13 = r6.width
            r14 = -1
            r15 = -2
            if (r13 == r15) goto L_0x0097
            int r10 = r6.width
            if (r10 == r14) goto L_0x0093
            int r10 = r6.width
            r13 = r10
            goto L_0x0094
        L_0x0093:
            r13 = r3
        L_0x0094:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0098
        L_0x0097:
            r13 = r3
        L_0x0098:
            int r1 = r6.height
            if (r1 == r15) goto L_0x00a5
            int r1 = r6.height
            if (r1 == r14) goto L_0x00a3
            int r1 = r6.height
            goto L_0x00a7
        L_0x00a3:
            r1 = r5
            goto L_0x00a7
        L_0x00a5:
            r1 = r5
            r8 = r12
        L_0x00a7:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            r9.measure(r6, r1)
            if (r11 == 0) goto L_0x00ba
            int r1 = r9.getMeasuredHeight()
            int r5 = r5 - r1
            goto L_0x00c1
        L_0x00ba:
            if (r7 == 0) goto L_0x00c1
            int r1 = r9.getMeasuredWidth()
            int r3 = r3 - r1
        L_0x00c1:
            int r2 = r2 + 1
            r1 = 0
            goto L_0x003f
        L_0x00c6:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
            r0.f4409v = r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            r0.f4410w = r1
            r0.f4411x = r7
            r16.mo6083c()
            r1 = 0
            r0.f4411x = r1
            int r2 = r16.getChildCount()
        L_0x00de:
            if (r1 >= r2) goto L_0x0108
            android.view.View r4 = r0.getChildAt(r1)
            int r5 = r4.getVisibility()
            if (r5 == r6) goto L_0x0105
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r5 = (androidx.viewpager.widget.ViewPager.C1472c) r5
            if (r5 == 0) goto L_0x00f6
            boolean r7 = r5.f4422a
            if (r7 != 0) goto L_0x0105
        L_0x00f6:
            float r7 = (float) r3
            float r5 = r5.f4424c
            float r7 = r7 * r5
            int r5 = (int) r7
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r7 = r0.f4410w
            r4.measure(r5, r7)
        L_0x0105:
            int r1 = r1 + 1
            goto L_0x00de
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m5854a(i, i3, this.f4403p, this.f4403p);
        }
    }

    /* renamed from: a */
    private void m5854a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f4394g.isEmpty()) {
            C1471b b = mo6077b(this.f4392c);
            int min = (int) ((b != null ? Math.min(b.f4421e, this.f4408u) : BitmapDescriptorFactory.HUE_RED) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m5858a(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.f4400m.isFinished()) {
            this.f4400m.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3))), getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = paddingBottom;
        int i10 = 0;
        int i11 = paddingTop;
        int i12 = paddingLeft;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                C1472c cVar = (C1472c) childAt.getLayoutParams();
                if (cVar.f4422a) {
                    int i14 = cVar.f4423b & 7;
                    int i15 = cVar.f4423b & 112;
                    if (i14 == 1) {
                        i5 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, i12);
                    } else if (i14 == 3) {
                        i5 = i12;
                        i12 = childAt.getMeasuredWidth() + i12;
                    } else if (i14 != 5) {
                        i5 = i12;
                    } else {
                        i5 = (i7 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i15 == 16) {
                        i6 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, i11);
                    } else if (i15 == 48) {
                        i6 = i11;
                        i11 = childAt.getMeasuredHeight() + i11;
                    } else if (i15 != 80) {
                        i6 = i11;
                    } else {
                        i6 = (i8 - i9) - childAt.getMeasuredHeight();
                        i9 += childAt.getMeasuredHeight();
                    }
                    int i16 = i5 + scrollX;
                    childAt.layout(i16, i6, childAt.getMeasuredWidth() + i16, i6 + childAt.getMeasuredHeight());
                    i10++;
                }
            }
        }
        int i17 = (i7 - i12) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                C1472c cVar2 = (C1472c) childAt2.getLayoutParams();
                if (!cVar2.f4422a) {
                    C1471b a = mo6060a(childAt2);
                    if (a != null) {
                        float f = (float) i17;
                        int i19 = ((int) (a.f4421e * f)) + i12;
                        if (cVar2.f4425d) {
                            cVar2.f4425d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (f * cVar2.f4424c), Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec((i8 - i11) - i9, Ints.MAX_POWER_OF_TWO));
                        }
                        childAt2.layout(i19, i11, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + i11);
                    }
                }
            }
        }
        this.f4405r = i11;
        this.f4406s = i8 - i9;
        this.f4380aa = i10;
        if (this.f4377U) {
            z2 = false;
            m5855a(this.f4392c, false, 0, false);
        } else {
            z2 = false;
        }
        this.f4377U = z2;
    }

    public void computeScroll() {
        this.f4401n = true;
        if (this.f4400m.isFinished() || !this.f4400m.computeScrollOffset()) {
            m5858a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f4400m.getCurrX();
        int currY = this.f4400m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m5865d(currX)) {
                this.f4400m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C0962r.m3575d(this);
    }

    /* renamed from: d */
    private boolean m5865d(int i) {
        if (this.f4394g.size() != 0) {
            C1471b l = m5871l();
            int clientWidth = getClientWidth();
            int i2 = this.f4403p + clientWidth;
            float f = (float) clientWidth;
            float f2 = ((float) this.f4403p) / f;
            int i3 = l.f4418b;
            float f3 = ((((float) i) / f) - l.f4421e) / (l.f4420d + f2);
            int i4 = (int) (((float) i2) * f3);
            this.f4379W = false;
            mo6063a(i3, f3, i4);
            if (this.f4379W) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f4377U) {
            return false;
        } else {
            this.f4379W = false;
            mo6063a(0, (float) BitmapDescriptorFactory.HUE_RED, 0);
            if (this.f4379W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6063a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f4380aa
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r9 = (androidx.viewpager.widget.ViewPager.C1472c) r9
            boolean r10 = r9.f4422a
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.f4423b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            r12.m5860b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$g r13 = r12.f4385af
            if (r13 == 0) goto L_0x00a1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007c:
            if (r1 >= r14) goto L_0x00a1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r0 = (androidx.viewpager.widget.ViewPager.C1472c) r0
            boolean r0 = r0.f4422a
            if (r0 == 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$g r3 = r12.f4385af
            r3.mo6134a(r15, r0)
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x007c
        L_0x00a1:
            r12.f4379W = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.mo6063a(int, float, int):void");
    }

    /* renamed from: b */
    private void m5860b(int i, float f, int i2) {
        if (this.f4382ac != null) {
            this.f4382ac.onPageScrolled(i, f, i2);
        }
        if (this.f4381ab != null) {
            int size = this.f4381ab.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1475f fVar = (C1475f) this.f4381ab.get(i3);
                if (fVar != null) {
                    fVar.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.f4383ad != null) {
            this.f4383ad.onPageScrolled(i, f, i2);
        }
    }

    /* renamed from: e */
    private void m5866e(int i) {
        if (this.f4382ac != null) {
            this.f4382ac.onPageSelected(i);
        }
        if (this.f4381ab != null) {
            int size = this.f4381ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                C1475f fVar = (C1475f) this.f4381ab.get(i2);
                if (fVar != null) {
                    fVar.onPageSelected(i);
                }
            }
        }
        if (this.f4383ad != null) {
            this.f4383ad.onPageSelected(i);
        }
    }

    /* renamed from: f */
    private void m5867f(int i) {
        if (this.f4382ac != null) {
            this.f4382ac.onPageScrollStateChanged(i);
        }
        if (this.f4381ab != null) {
            int size = this.f4381ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                C1475f fVar = (C1475f) this.f4381ab.get(i2);
                if (fVar != null) {
                    fVar.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.f4383ad != null) {
            this.f4383ad.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: a */
    private void m5858a(boolean z) {
        boolean z2 = this.f4390al == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f4400m.isFinished()) {
                this.f4400m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4400m.getCurrX();
                int currY = this.f4400m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m5865d(currX);
                    }
                }
            }
        }
        this.f4413z = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f4394g.size(); i++) {
            C1471b bVar = (C1471b) this.f4394g.get(i);
            if (bVar.f4419c) {
                bVar.f4419c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            C0962r.m3562a((View) this, this.f4389ak);
        } else {
            this.f4389ak.run();
        }
    }

    /* renamed from: a */
    private boolean m5859a(float f, float f2) {
        return (f < ((float) this.f4361E) && f2 > BitmapDescriptorFactory.HUE_RED) || (f > ((float) (getWidth() - this.f4361E)) && f2 < BitmapDescriptorFactory.HUE_RED);
    }

    /* renamed from: b */
    private void m5861b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.f4386ag : 0, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m5870k();
            return false;
        }
        if (action != 0) {
            if (this.f4358B) {
                return true;
            }
            if (this.f4359C) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f4365I = x;
            this.f4363G = x;
            float y = motionEvent.getY();
            this.f4366J = y;
            this.f4364H = y;
            this.f4367K = motionEvent2.getPointerId(0);
            this.f4359C = false;
            this.f4401n = true;
            this.f4400m.computeScrollOffset();
            if (this.f4390al != 2 || Math.abs(this.f4400m.getFinalX() - this.f4400m.getCurrX()) <= this.f4372P) {
                m5858a(false);
                this.f4358B = false;
            } else {
                this.f4400m.abortAnimation();
                this.f4413z = false;
                mo6083c();
                this.f4358B = true;
                m5862c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f4367K;
            if (i != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i);
                float x2 = motionEvent2.getX(findPointerIndex);
                float f = x2 - this.f4363G;
                float abs = Math.abs(f);
                float y2 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.f4366J);
                int i2 = (f > BitmapDescriptorFactory.HUE_RED ? 1 : (f == BitmapDescriptorFactory.HUE_RED ? 0 : -1));
                if (i2 != 0 && !m5859a(this.f4363G, f)) {
                    if (mo6073a(this, false, (int) f, (int) x2, (int) y2)) {
                        this.f4363G = x2;
                        this.f4364H = y2;
                        this.f4359C = true;
                        return false;
                    }
                }
                if (abs > ((float) this.f4362F) && abs * 0.5f > abs2) {
                    this.f4358B = true;
                    m5862c(true);
                    setScrollState(1);
                    this.f4363G = i2 > 0 ? this.f4365I + ((float) this.f4362F) : this.f4365I - ((float) this.f4362F);
                    this.f4364H = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.f4362F)) {
                    this.f4359C = true;
                }
                if (this.f4358B && m5863c(x2)) {
                    C0962r.m3575d(this);
                }
            }
        } else if (action == 6) {
            m5856a(motionEvent);
        }
        if (this.f4368L == null) {
            this.f4368L = VelocityTracker.obtain();
        }
        this.f4368L.addMovement(motionEvent2);
        return this.f4358B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4373Q) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.f4391b == null || this.f4391b.mo6151b() == 0) {
            return false;
        }
        if (this.f4368L == null) {
            this.f4368L = VelocityTracker.obtain();
        }
        this.f4368L.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f4400m.abortAnimation();
                this.f4413z = false;
                mo6083c();
                float x = motionEvent.getX();
                this.f4365I = x;
                this.f4363G = x;
                float y = motionEvent.getY();
                this.f4366J = y;
                this.f4364H = y;
                this.f4367K = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.f4358B) {
                    VelocityTracker velocityTracker = this.f4368L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f4370N);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.f4367K);
                    this.f4413z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C1471b l = m5871l();
                    float f = (float) clientWidth;
                    mo6067a(m5852a(l.f4418b, ((((float) scrollX) / f) - l.f4421e) / (l.f4420d + (((float) this.f4403p) / f)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f4367K)) - this.f4365I)), true, true, xVelocity);
                    z = m5870k();
                    break;
                }
                break;
            case 2:
                if (!this.f4358B) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f4367K);
                    if (findPointerIndex == -1) {
                        z = m5870k();
                        break;
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.f4363G);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f4364H);
                        if (abs > ((float) this.f4362F) && abs > abs2) {
                            this.f4358B = true;
                            m5862c(true);
                            this.f4363G = x2 - this.f4365I > BitmapDescriptorFactory.HUE_RED ? this.f4365I + ((float) this.f4362F) : this.f4365I - ((float) this.f4362F);
                            this.f4364H = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f4358B) {
                    z = false | m5863c(motionEvent.getX(motionEvent.findPointerIndex(this.f4367K)));
                    break;
                }
                break;
            case 3:
                if (this.f4358B) {
                    m5855a(this.f4392c, true, 0, false);
                    z = m5870k();
                    break;
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.f4363G = motionEvent.getX(actionIndex);
                this.f4367K = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                m5856a(motionEvent);
                this.f4363G = motionEvent.getX(motionEvent.findPointerIndex(this.f4367K));
                break;
        }
        if (z) {
            C0962r.m3575d(this);
        }
        return true;
    }

    /* renamed from: k */
    private boolean m5870k() {
        this.f4367K = -1;
        m5872m();
        this.f4375S.onRelease();
        this.f4376T.onRelease();
        return this.f4375S.isFinished() || this.f4376T.isFinished();
    }

    /* renamed from: c */
    private void m5862c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: c */
    private boolean m5863c(float f) {
        boolean z;
        boolean z2;
        float f2 = this.f4363G - f;
        this.f4363G = f;
        float scrollX = ((float) getScrollX()) + f2;
        float clientWidth = (float) getClientWidth();
        float f3 = this.f4407t * clientWidth;
        float f4 = this.f4408u * clientWidth;
        boolean z3 = false;
        C1471b bVar = (C1471b) this.f4394g.get(0);
        C1471b bVar2 = (C1471b) this.f4394g.get(this.f4394g.size() - 1);
        if (bVar.f4418b != 0) {
            f3 = bVar.f4421e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f4418b != this.f4391b.mo6151b() - 1) {
            f4 = bVar2.f4421e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.f4375S.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f4376T.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f4363G += scrollX - ((float) i);
        scrollTo(i, getScrollY());
        m5865d(i);
        return z3;
    }

    /* renamed from: l */
    private C1471b m5871l() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : BitmapDescriptorFactory.HUE_RED;
        float f = clientWidth > 0 ? ((float) this.f4403p) / ((float) clientWidth) : BitmapDescriptorFactory.HUE_RED;
        C1471b bVar = null;
        int i = 0;
        boolean z = true;
        int i2 = -1;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        while (i < this.f4394g.size()) {
            C1471b bVar2 = (C1471b) this.f4394g.get(i);
            if (!z) {
                int i3 = i2 + 1;
                if (bVar2.f4418b != i3) {
                    bVar2 = this.f4395h;
                    bVar2.f4421e = f2 + f3 + f;
                    bVar2.f4418b = i3;
                    bVar2.f4420d = this.f4391b.mo6158d(bVar2.f4418b);
                    i--;
                }
            }
            f2 = bVar2.f4421e;
            float f4 = bVar2.f4420d + f2 + f;
            if (!z && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f4 || i == this.f4394g.size() - 1) {
                return bVar2;
            }
            i2 = bVar2.f4418b;
            f3 = bVar2.f4420d;
            i++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    /* renamed from: a */
    private int m5852a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f4371O || Math.abs(i2) <= this.f4369M) {
            i += (int) (f + (i >= this.f4392c ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f4394g.size() <= 0) {
            return i;
        }
        return Math.max(((C1471b) this.f4394g.get(0)).f4418b, Math.min(i, ((C1471b) this.f4394g.get(this.f4394g.size() - 1)).f4418b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f4391b != null && this.f4391b.mo6151b() > 1)) {
            if (!this.f4375S.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f4407t * ((float) width));
                this.f4375S.setSize(height, width);
                z = false | this.f4375S.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f4376T.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f4408u + 1.0f)) * ((float) width2));
                this.f4376T.setSize(height2, width2);
                z |= this.f4376T.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f4375S.finish();
            this.f4376T.finish();
        }
        if (z) {
            C0962r.m3575d(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f4403p > 0 && this.f4404q != null && this.f4394g.size() > 0 && this.f4391b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.f4403p) / f4;
            int i = 0;
            C1471b bVar = (C1471b) this.f4394g.get(0);
            float f6 = bVar.f4421e;
            int size = this.f4394g.size();
            int i2 = bVar.f4418b;
            int i3 = ((C1471b) this.f4394g.get(size - 1)).f4418b;
            while (i2 < i3) {
                while (i2 > bVar.f4418b && i < size) {
                    i++;
                    bVar = (C1471b) this.f4394g.get(i);
                }
                if (i2 == bVar.f4418b) {
                    f2 = (bVar.f4421e + bVar.f4420d) * f4;
                    f = bVar.f4421e + bVar.f4420d + f5;
                } else {
                    float d = this.f4391b.mo6158d(i2);
                    f = f6 + d + f5;
                    f2 = (f6 + d) * f4;
                }
                if (((float) this.f4403p) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.f4404q.setBounds(Math.round(f2), this.f4405r, Math.round(((float) this.f4403p) + f2), this.f4406s);
                    this.f4404q.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i2++;
                    f6 = f;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo6088d() {
        if (this.f4358B) {
            return false;
        }
        this.f4373Q = true;
        setScrollState(1);
        this.f4363G = BitmapDescriptorFactory.HUE_RED;
        this.f4365I = BitmapDescriptorFactory.HUE_RED;
        if (this.f4368L == null) {
            this.f4368L = VelocityTracker.obtain();
        } else {
            this.f4368L.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f4368L.addMovement(obtain);
        obtain.recycle();
        this.f4374R = uptimeMillis;
        return true;
    }

    /* renamed from: e */
    public void mo6093e() {
        if (this.f4373Q) {
            if (this.f4391b != null) {
                VelocityTracker velocityTracker = this.f4368L;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f4370N);
                int xVelocity = (int) velocityTracker.getXVelocity(this.f4367K);
                this.f4413z = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C1471b l = m5871l();
                mo6067a(m5852a(l.f4418b, ((((float) scrollX) / ((float) clientWidth)) - l.f4421e) / l.f4420d, xVelocity, (int) (this.f4363G - this.f4365I)), true, true, xVelocity);
            }
            m5872m();
            this.f4373Q = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    /* renamed from: b */
    public void mo6080b(float f) {
        if (!this.f4373Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.f4391b != null) {
            this.f4363G += f;
            float scrollX = ((float) getScrollX()) - f;
            float clientWidth = (float) getClientWidth();
            float f2 = this.f4407t * clientWidth;
            float f3 = this.f4408u * clientWidth;
            C1471b bVar = (C1471b) this.f4394g.get(0);
            C1471b bVar2 = (C1471b) this.f4394g.get(this.f4394g.size() - 1);
            if (bVar.f4418b != 0) {
                f2 = bVar.f4421e * clientWidth;
            }
            if (bVar2.f4418b != this.f4391b.mo6151b() - 1) {
                f3 = bVar2.f4421e * clientWidth;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.f4363G += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            m5865d(i);
            MotionEvent obtain = MotionEvent.obtain(this.f4374R, SystemClock.uptimeMillis(), 2, this.f4363G, BitmapDescriptorFactory.HUE_RED, 0);
            this.f4368L.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* renamed from: f */
    public boolean mo6094f() {
        return this.f4373Q;
    }

    /* renamed from: a */
    private void m5856a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4367K) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f4363G = motionEvent.getX(i);
            this.f4367K = motionEvent.getPointerId(i);
            if (this.f4368L != null) {
                this.f4368L.clear();
            }
        }
    }

    /* renamed from: m */
    private void m5872m() {
        this.f4358B = false;
        this.f4359C = false;
        if (this.f4368L != null) {
            this.f4368L.recycle();
            this.f4368L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f4412y != z) {
            this.f4412y = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = false;
        if (this.f4391b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.f4407t))) {
                z = true;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX < ((int) (((float) clientWidth) * this.f4408u))) {
                z = true;
            }
            return z;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6073a(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        boolean z2 = true;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i4 = i2 + scrollX;
                if (i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                        if (mo6073a(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i)) {
            z2 = false;
        }
        return z2;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo6072a(keyEvent);
    }

    /* renamed from: a */
    public boolean mo6072a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasModifiers(2)) {
                            return mo6095g();
                        }
                        return mo6084c(17);
                    case 22:
                        if (keyEvent.hasModifiers(2)) {
                            return mo6104h();
                        }
                        return mo6084c(66);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return mo6084c(2);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return mo6084c(1);
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo6084c(int i) {
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("arrowScroll tried to find focus based on non-child current focused view ");
                    sb2.append(sb.toString());
                    Log.e("ViewPager", sb2.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = m5853a(this.f4396i, findNextFocus).left;
                int i3 = m5853a(this.f4396i, view).left;
                if (view == null || i2 < i3) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = mo6095g();
                }
            } else if (i == 66) {
                int i4 = m5853a(this.f4396i, findNextFocus).left;
                int i5 = m5853a(this.f4396i, view).left;
                if (view == null || i4 > i5) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = mo6104h();
                }
            }
            z2 = requestFocus;
        } else if (i == 17 || i == 1) {
            z2 = mo6095g();
        } else if (i == 66 || i == 2) {
            z2 = mo6104h();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    /* renamed from: a */
    private Rect m5853a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo6095g() {
        if (this.f4392c <= 0) {
            return false;
        }
        mo6065a(this.f4392c - 1, true);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo6104h() {
        if (this.f4391b == null || this.f4392c >= this.f4391b.mo6151b() - 1) {
            return false;
        }
        mo6065a(this.f4392c + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C1471b a = mo6060a(childAt);
                    if (a != null && a.f4418b == this.f4392c) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C1471b a = mo6060a(childAt);
                if (a != null && a.f4418b == this.f4392c) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                C1471b a = mo6060a(childAt);
                if (a != null && a.f4418b == this.f4392c && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i3 += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C1471b a = mo6060a(childAt);
                if (a != null && a.f4418b == this.f4392c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new C1472c();
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C1472c) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1472c(getContext(), attributeSet);
    }
}
