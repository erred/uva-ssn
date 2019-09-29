package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.p049b.p050a.C0500c;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p070g.C0969v;
import androidx.core.widget.C1010f;
import com.google.common.primitives.Ints;
import java.lang.reflect.Field;

/* renamed from: androidx.appcompat.widget.ae */
/* compiled from: DropDownListView */
class C0608ae extends ListView {

    /* renamed from: a */
    C0610b f1714a;

    /* renamed from: b */
    private final Rect f1715b = new Rect();

    /* renamed from: c */
    private int f1716c = 0;

    /* renamed from: d */
    private int f1717d = 0;

    /* renamed from: e */
    private int f1718e = 0;

    /* renamed from: f */
    private int f1719f = 0;

    /* renamed from: g */
    private int f1720g;

    /* renamed from: h */
    private Field f1721h;

    /* renamed from: i */
    private C0609a f1722i;

    /* renamed from: j */
    private boolean f1723j;

    /* renamed from: k */
    private boolean f1724k;

    /* renamed from: l */
    private boolean f1725l;

    /* renamed from: m */
    private C0969v f1726m;

    /* renamed from: n */
    private C1010f f1727n;

    /* renamed from: androidx.appcompat.widget.ae$a */
    /* compiled from: DropDownListView */
    private static class C0609a extends C0500c {

        /* renamed from: a */
        private boolean f1728a = true;

        C0609a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo2201a(boolean z) {
            this.f1728a = z;
        }

        public boolean setState(int[] iArr) {
            if (this.f1728a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f1728a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f1728a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1728a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1728a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ae$b */
    /* compiled from: DropDownListView */
    private class C0610b implements Runnable {
        C0610b() {
        }

        public void run() {
            C0608ae.this.f1714a = null;
            C0608ae.this.drawableStateChanged();
        }

        /* renamed from: a */
        public void mo2202a() {
            C0608ae.this.f1714a = null;
            C0608ae.this.removeCallbacks(this);
        }

        /* renamed from: b */
        public void mo2203b() {
            C0608ae.this.post(this);
        }
    }

    C0608ae(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f1724k = z;
        setCacheColorHint(0);
        try {
            this.f1721h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1721h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public boolean isInTouchMode() {
        return (this.f1724k && this.f1723j) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.f1724k || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1724k || super.isFocused();
    }

    public boolean hasFocus() {
        return this.f1724k || super.hasFocus();
    }

    public void setSelector(Drawable drawable) {
        this.f1722i = drawable != null ? new C0609a(drawable) : null;
        super.setSelector(this.f1722i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1716c = rect.left;
        this.f1717d = rect.top;
        this.f1718e = rect.right;
        this.f1719f = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1714a == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m2107a();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m2110a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1720g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f1714a != null) {
            this.f1714a.mo2202a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    public int mo2188a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i7 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i8 = i7;
        View view = null;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < count; i11++) {
            int itemViewType = adapter.getItemViewType(i11);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i11, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                i6 = MeasureSpec.makeMeasureSpec(layoutParams.height, Ints.MAX_POWER_OF_TWO);
            } else {
                i6 = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, i6);
            view.forceLayout();
            if (i11 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 >= i4) {
                if (i5 >= 0 && i11 > i5 && i10 > 0 && i8 != i4) {
                    i4 = i10;
                }
                return i4;
            }
            if (i5 >= 0 && i11 >= i5) {
                i10 = i8;
            }
        }
        return i8;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.f1722i != null) {
            this.f1722i.mo2201a(z);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1714a == null) {
            this.f1714a = new C0610b();
            this.f1714a.mo2203b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                m2107a();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1714a = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo2189a(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L_0x0011;
                case 2: goto L_0x000f;
                case 3: goto L_0x000c;
                default: goto L_0x0009;
            }
        L_0x0009:
            r9 = 0
            r3 = 1
            goto L_0x0041
        L_0x000c:
            r9 = 0
            r3 = 0
            goto L_0x0041
        L_0x000f:
            r3 = 1
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x0019
            goto L_0x000c
        L_0x0019:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x002c
            r9 = 1
            goto L_0x0041
        L_0x002c:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m2112a(r3, r5, r4, r9)
            if (r0 != r2) goto L_0x0009
            r7.m2111a(r3, r5)
            goto L_0x0009
        L_0x0041:
            if (r3 == 0) goto L_0x0045
            if (r9 == 0) goto L_0x0048
        L_0x0045:
            r7.m2113b()
        L_0x0048:
            if (r3 == 0) goto L_0x0060
            androidx.core.widget.f r9 = r7.f1727n
            if (r9 != 0) goto L_0x0055
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f1727n = r9
        L_0x0055:
            androidx.core.widget.f r9 = r7.f1727n
            r9.mo3927a(r2)
            androidx.core.widget.f r9 = r7.f1727n
            r9.onTouch(r7, r8)
            goto L_0x0069
        L_0x0060:
            androidx.core.widget.f r8 = r7.f1727n
            if (r8 == 0) goto L_0x0069
            androidx.core.widget.f r8 = r7.f1727n
            r8.mo3927a(r1)
        L_0x0069:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0608ae.mo2189a(android.view.MotionEvent, int):boolean");
    }

    /* renamed from: a */
    private void m2111a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* access modifiers changed from: 0000 */
    public void setListSelectionHidden(boolean z) {
        this.f1723j = z;
    }

    /* renamed from: a */
    private void m2107a() {
        Drawable selector = getSelector();
        if (selector != null && m2115c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    private void m2110a(Canvas canvas) {
        if (!this.f1715b.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f1715b);
                selector.draw(canvas);
            }
        }
    }

    /* renamed from: a */
    private void m2109a(int i, View view, float f, float f2) {
        m2108a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0983a.m3695a(selector, f, f2);
        }
    }

    /* renamed from: a */
    private void m2108a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m2114b(i, view);
        if (z2) {
            Rect rect = this.f1715b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0983a.m3695a(selector, exactCenterX, exactCenterY);
        }
    }

    /* renamed from: b */
    private void m2114b(int i, View view) {
        Rect rect = this.f1715b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1716c;
        rect.top -= this.f1717d;
        rect.right += this.f1718e;
        rect.bottom += this.f1719f;
        try {
            boolean z = this.f1721h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1721h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m2113b() {
        this.f1725l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1720g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f1726m != null) {
            this.f1726m.mo3770b();
            this.f1726m = null;
        }
    }

    /* renamed from: a */
    private void m2112a(View view, int i, float f, float f2) {
        this.f1725l = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f1720g != -1) {
            View childAt = getChildAt(this.f1720g - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f1720g = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m2109a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: c */
    private boolean m2115c() {
        return this.f1725l;
    }
}
