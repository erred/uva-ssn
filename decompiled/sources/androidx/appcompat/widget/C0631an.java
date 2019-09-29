package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.C0440a.C0443c;
import androidx.appcompat.view.C0504a;
import androidx.appcompat.widget.C0616ah.C0617a;
import com.google.common.primitives.Ints;

/* renamed from: androidx.appcompat.widget.an */
/* compiled from: ScrollingTabContainerView */
public class C0631an extends HorizontalScrollView implements OnItemSelectedListener {

    /* renamed from: j */
    private static final Interpolator f1801j = new DecelerateInterpolator();

    /* renamed from: a */
    Runnable f1802a;

    /* renamed from: b */
    C0616ah f1803b;

    /* renamed from: c */
    int f1804c;

    /* renamed from: d */
    int f1805d;

    /* renamed from: e */
    private C0634b f1806e;

    /* renamed from: f */
    private Spinner f1807f;

    /* renamed from: g */
    private boolean f1808g;

    /* renamed from: h */
    private int f1809h;

    /* renamed from: i */
    private int f1810i;

    /* renamed from: androidx.appcompat.widget.an$a */
    /* compiled from: ScrollingTabContainerView */
    private class C0633a extends BaseAdapter {
        public long getItemId(int i) {
            return (long) i;
        }

        C0633a() {
        }

        public int getCount() {
            return C0631an.this.f1803b.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0635c) C0631an.this.f1803b.getChildAt(i)).mo2366b();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return C0631an.this.mo2347a((C0443c) getItem(i), true);
            }
            ((C0635c) view).mo2365a((C0443c) getItem(i));
            return view;
        }
    }

    /* renamed from: androidx.appcompat.widget.an$b */
    /* compiled from: ScrollingTabContainerView */
    private class C0634b implements OnClickListener {
        C0634b() {
        }

        public void onClick(View view) {
            ((C0635c) view).mo2366b().mo873d();
            int childCount = C0631an.this.f1803b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = C0631an.this.f1803b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.an$c */
    /* compiled from: ScrollingTabContainerView */
    private class C0635c extends LinearLayout {

        /* renamed from: b */
        private final int[] f1816b = {16842964};

        /* renamed from: c */
        private C0443c f1817c;

        /* renamed from: d */
        private TextView f1818d;

        /* renamed from: e */
        private ImageView f1819e;

        /* renamed from: f */
        private View f1820f;

        public C0635c(Context context, C0443c cVar, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.f1817c = cVar;
            C0645av a = C0645av.m2230a(context, null, this.f1816b, R.attr.actionBarTabStyle, 0);
            if (a.mo2464g(0)) {
                setBackgroundDrawable(a.mo2449a(0));
            }
            a.mo2450a();
            if (z) {
                setGravity(8388627);
            }
            mo2364a();
        }

        /* renamed from: a */
        public void mo2365a(C0443c cVar) {
            this.f1817c = cVar;
            mo2364a();
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0443c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0443c.class.getName());
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (C0631an.this.f1804c > 0 && getMeasuredWidth() > C0631an.this.f1804c) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(C0631an.this.f1804c, Ints.MAX_POWER_OF_TWO), i2);
            }
        }

        /* renamed from: a */
        public void mo2364a() {
            C0443c cVar = this.f1817c;
            View c = cVar.mo872c();
            CharSequence charSequence = null;
            if (c != null) {
                ViewParent parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c);
                    }
                    addView(c);
                }
                this.f1820f = c;
                if (this.f1818d != null) {
                    this.f1818d.setVisibility(8);
                }
                if (this.f1819e != null) {
                    this.f1819e.setVisibility(8);
                    this.f1819e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f1820f != null) {
                removeView(this.f1820f);
                this.f1820f = null;
            }
            Drawable a = cVar.mo870a();
            CharSequence b = cVar.mo871b();
            if (a != null) {
                if (this.f1819e == null) {
                    C0690p pVar = new C0690p(getContext());
                    LayoutParams layoutParams = new LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    pVar.setLayoutParams(layoutParams);
                    addView(pVar, 0);
                    this.f1819e = pVar;
                }
                this.f1819e.setImageDrawable(a);
                this.f1819e.setVisibility(0);
            } else if (this.f1819e != null) {
                this.f1819e.setVisibility(8);
                this.f1819e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.f1818d == null) {
                    C0707z zVar = new C0707z(getContext(), null, R.attr.actionBarTabTextStyle);
                    zVar.setEllipsize(TruncateAt.END);
                    LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.f1818d = zVar;
                }
                this.f1818d.setText(b);
                this.f1818d.setVisibility(0);
            } else if (this.f1818d != null) {
                this.f1818d.setVisibility(8);
                this.f1818d.setText(null);
            }
            if (this.f1819e != null) {
                this.f1819e.setContentDescription(cVar.mo874e());
            }
            if (!z) {
                charSequence = cVar.mo874e();
            }
            C0649ax.m2296a(this, charSequence);
        }

        /* renamed from: b */
        public C0443c mo2366b() {
            return this.f1817c;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f1803b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1804c = -1;
        } else {
            if (childCount > 2) {
                this.f1804c = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1804c = MeasureSpec.getSize(i) / 2;
            }
            this.f1804c = Math.min(this.f1804c, this.f1805d);
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1809h, Ints.MAX_POWER_OF_TWO);
        if (z2 || !this.f1808g) {
            z = false;
        }
        if (z) {
            this.f1803b.measure(0, makeMeasureSpec);
            if (this.f1803b.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m2185b();
            } else {
                m2186c();
            }
        } else {
            m2186c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1810i);
        }
    }

    /* renamed from: a */
    private boolean m2184a() {
        return this.f1807f != null && this.f1807f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f1808g = z;
    }

    /* renamed from: b */
    private void m2185b() {
        if (!m2184a()) {
            if (this.f1807f == null) {
                this.f1807f = m2187d();
            }
            removeView(this.f1803b);
            addView(this.f1807f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1807f.getAdapter() == null) {
                this.f1807f.setAdapter(new C0633a());
            }
            if (this.f1802a != null) {
                removeCallbacks(this.f1802a);
                this.f1802a = null;
            }
            this.f1807f.setSelection(this.f1810i);
        }
    }

    /* renamed from: c */
    private boolean m2186c() {
        if (!m2184a()) {
            return false;
        }
        removeView(this.f1807f);
        addView(this.f1803b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1807f.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.f1810i = i;
        int childCount = this.f1803b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1803b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                mo2348a(i);
            }
            i2++;
        }
        if (this.f1807f != null && i >= 0) {
            this.f1807f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f1809h = i;
        requestLayout();
    }

    /* renamed from: d */
    private Spinner m2187d() {
        C0698x xVar = new C0698x(getContext(), null, R.attr.actionDropDownStyle);
        xVar.setLayoutParams(new C0617a(-2, -1));
        xVar.setOnItemSelectedListener(this);
        return xVar;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0504a a = C0504a.m1633a(getContext());
        setContentHeight(a.mo1246e());
        this.f1805d = a.mo1248g();
    }

    /* renamed from: a */
    public void mo2348a(int i) {
        final View childAt = this.f1803b.getChildAt(i);
        if (this.f1802a != null) {
            removeCallbacks(this.f1802a);
        }
        this.f1802a = new Runnable() {
            public void run() {
                C0631an.this.smoothScrollTo(childAt.getLeft() - ((C0631an.this.getWidth() - childAt.getWidth()) / 2), 0);
                C0631an.this.f1802a = null;
            }
        };
        post(this.f1802a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1802a != null) {
            post(this.f1802a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1802a != null) {
            removeCallbacks(this.f1802a);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0635c mo2347a(C0443c cVar, boolean z) {
        C0635c cVar2 = new C0635c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1809h));
        } else {
            cVar2.setFocusable(true);
            if (this.f1806e == null) {
                this.f1806e = new C0634b();
            }
            cVar2.setOnClickListener(this.f1806e);
        }
        return cVar2;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0635c) view).mo2366b().mo873d();
    }
}
