package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0969v;
import androidx.core.p070g.C0973w;
import androidx.customview.p073b.C1024a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.appcompat.widget.a */
/* compiled from: AbsActionBarView */
abstract class C0602a extends ViewGroup {

    /* renamed from: a */
    protected final C0603a f1689a;

    /* renamed from: b */
    protected final Context f1690b;

    /* renamed from: c */
    protected ActionMenuView f1691c;

    /* renamed from: d */
    protected C0658c f1692d;

    /* renamed from: e */
    protected int f1693e;

    /* renamed from: f */
    protected C0969v f1694f;

    /* renamed from: g */
    private boolean f1695g;

    /* renamed from: h */
    private boolean f1696h;

    /* renamed from: androidx.appcompat.widget.a$a */
    /* compiled from: AbsActionBarView */
    protected class C0603a implements C0973w {

        /* renamed from: a */
        int f1697a;

        /* renamed from: c */
        private boolean f1699c = false;

        protected C0603a() {
        }

        /* renamed from: a */
        public C0603a mo2143a(C0969v vVar, int i) {
            C0602a.this.f1694f = vVar;
            this.f1697a = i;
            return this;
        }

        /* renamed from: a */
        public void mo1028a(View view) {
            C0602a.super.setVisibility(0);
            this.f1699c = false;
        }

        /* renamed from: b */
        public void mo1029b(View view) {
            if (!this.f1699c) {
                C0602a.this.f1694f = null;
                C0602a.super.setVisibility(this.f1697a);
            }
        }

        /* renamed from: c */
        public void mo2144c(View view) {
            this.f1699c = true;
        }
    }

    /* renamed from: a */
    protected static int m2025a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    C0602a(Context context) {
        this(context, null);
    }

    C0602a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0602a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1689a = new C0603a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1690b = context;
        } else {
            this.f1690b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1692d != null) {
            this.f1692d.mo2492a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1695g = false;
        }
        if (!this.f1695g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1695g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1695g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1696h = false;
        }
        if (!this.f1696h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1696h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1696h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1693e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1693e;
    }

    public int getAnimatedVisibility() {
        if (this.f1694f != null) {
            return this.f1689a.f1697a;
        }
        return getVisibility();
    }

    /* renamed from: a */
    public C0969v mo1776a(int i, long j) {
        if (this.f1694f != null) {
            this.f1694f.mo3770b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
            C0969v a = C0962r.m3591n(this).mo3763a(1.0f);
            a.mo3764a(j);
            a.mo3766a((C0973w) this.f1689a.mo2143a(a, i));
            return a;
        }
        C0969v a2 = C0962r.m3591n(this).mo3763a((float) BitmapDescriptorFactory.HUE_RED);
        a2.mo3764a(j);
        a2.mo3766a((C0973w) this.f1689a.mo2143a(a2, i));
        return a2;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1694f != null) {
                this.f1694f.mo3770b();
            }
            super.setVisibility(i);
        }
    }

    /* renamed from: a */
    public boolean mo1778a() {
        if (this.f1692d != null) {
            return this.f1692d.mo2499c();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2140a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, C1024a.INVALID_ID), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2141a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
