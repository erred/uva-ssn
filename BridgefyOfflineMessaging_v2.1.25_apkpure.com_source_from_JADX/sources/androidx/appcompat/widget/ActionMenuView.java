package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0533h.C0534a;
import androidx.appcompat.view.menu.C0533h.C0535b;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.view.menu.C0551p;
import androidx.appcompat.widget.C0616ah.C0617a;
import androidx.customview.p073b.C1024a;
import com.google.common.primitives.Ints;

public class ActionMenuView extends C0616ah implements C0535b, C0551p {

    /* renamed from: a */
    C0534a f1543a;

    /* renamed from: b */
    C0571e f1544b;

    /* renamed from: c */
    private C0533h f1545c;

    /* renamed from: d */
    private Context f1546d;

    /* renamed from: e */
    private int f1547e;

    /* renamed from: f */
    private boolean f1548f;

    /* renamed from: g */
    private C0658c f1549g;

    /* renamed from: h */
    private C0550a f1550h;

    /* renamed from: i */
    private boolean f1551i;

    /* renamed from: j */
    private int f1552j;

    /* renamed from: k */
    private int f1553k;

    /* renamed from: l */
    private int f1554l;

    /* renamed from: androidx.appcompat.widget.ActionMenuView$a */
    public interface C0567a {
        /* renamed from: b */
        boolean mo1313b();

        /* renamed from: c */
        boolean mo1314c();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$b */
    private static class C0568b implements C0550a {
        /* renamed from: a */
        public void mo1030a(C0533h hVar, boolean z) {
        }

        /* renamed from: a */
        public boolean mo1031a(C0533h hVar) {
            return false;
        }

        C0568b() {
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$c */
    public static class C0569c extends C0617a {
        @ExportedProperty

        /* renamed from: a */
        public boolean f1555a;
        @ExportedProperty

        /* renamed from: b */
        public int f1556b;
        @ExportedProperty

        /* renamed from: c */
        public int f1557c;
        @ExportedProperty

        /* renamed from: d */
        public boolean f1558d;
        @ExportedProperty

        /* renamed from: e */
        public boolean f1559e;

        /* renamed from: f */
        boolean f1560f;

        public C0569c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0569c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0569c(C0569c cVar) {
            super(cVar);
            this.f1555a = cVar.f1555a;
        }

        public C0569c(int i, int i2) {
            super(i, i2);
            this.f1555a = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$d */
    private class C0570d implements C0534a {
        C0570d() {
        }

        public boolean onMenuItemSelected(C0533h hVar, MenuItem menuItem) {
            return ActionMenuView.this.f1544b != null && ActionMenuView.this.f1544b.mo1887a(menuItem);
        }

        public void onMenuModeChange(C0533h hVar) {
            if (ActionMenuView.this.f1543a != null) {
                ActionMenuView.this.f1543a.onMenuModeChange(hVar);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$e */
    public interface C0571e {
        /* renamed from: a */
        boolean mo1887a(MenuItem menuItem);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1553k = (int) (56.0f * f);
        this.f1554l = (int) (f * 4.0f);
        this.f1546d = context;
        this.f1547e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f1547e != i) {
            this.f1547e = i;
            if (i == 0) {
                this.f1546d = getContext();
            } else {
                this.f1546d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1547e;
    }

    public void setPresenter(C0658c cVar) {
        this.f1549g = cVar;
        this.f1549g.mo2494a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1549g != null) {
            this.f1549g.updateMenuView(false);
            if (this.f1549g.mo2503g()) {
                this.f1549g.mo2500d();
                this.f1549g.mo2499c();
            }
        }
    }

    public void setOnMenuItemClickListener(C0571e eVar) {
        this.f1544b = eVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z = this.f1551i;
        this.f1551i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1551i) {
            this.f1552j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1551i || this.f1545c == null || size == this.f1552j)) {
            this.f1552j = size;
            this.f1545c.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.f1551i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0569c cVar = (C0569c) getChildAt(i3).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m1920a(i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x024f A[LOOP:5: B:136:0x024f->B:141:0x0272, LOOP_START, PHI: r3 r32 
      PHI: (r3v5 int) = (r3v4 int), (r3v6 int) binds: [B:135:0x024d, B:141:0x0272] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r32v1 int) = (r32v0 int), (r32v2 int) binds: [B:135:0x024d, B:141:0x0272] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x027e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1920a(int r35, int r36) {
        /*
            r34 = this;
            r0 = r34
            int r1 = android.view.View.MeasureSpec.getMode(r36)
            int r2 = android.view.View.MeasureSpec.getSize(r35)
            int r3 = android.view.View.MeasureSpec.getSize(r36)
            int r4 = r34.getPaddingLeft()
            int r5 = r34.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r34.getPaddingTop()
            int r6 = r34.getPaddingBottom()
            int r5 = r5 + r6
            r6 = -2
            r7 = r36
            int r6 = getChildMeasureSpec(r7, r5, r6)
            int r2 = r2 - r4
            int r4 = r0.f1553k
            int r4 = r2 / r4
            int r7 = r0.f1553k
            int r7 = r2 % r7
            r8 = 0
            if (r4 != 0) goto L_0x0037
            r0.setMeasuredDimension(r2, r8)
            return
        L_0x0037:
            int r9 = r0.f1553k
            int r7 = r7 / r4
            int r9 = r9 + r7
            int r7 = r34.getChildCount()
            r14 = r4
            r4 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r19 = 0
        L_0x0049:
            if (r4 >= r7) goto L_0x00d6
            android.view.View r11 = r0.getChildAt(r4)
            int r8 = r11.getVisibility()
            r21 = r3
            r3 = 8
            if (r8 != r3) goto L_0x005d
            r23 = r2
            goto L_0x00cd
        L_0x005d:
            boolean r3 = r11 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            int r13 = r13 + 1
            if (r3 == 0) goto L_0x0070
            int r8 = r0.f1554l
            r22 = r13
            int r13 = r0.f1554l
            r23 = r2
            r2 = 0
            r11.setPadding(r8, r2, r13, r2)
            goto L_0x0075
        L_0x0070:
            r23 = r2
            r22 = r13
            r2 = 0
        L_0x0075:
            android.view.ViewGroup$LayoutParams r8 = r11.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r8 = (androidx.appcompat.widget.ActionMenuView.C0569c) r8
            r8.f1560f = r2
            r8.f1557c = r2
            r8.f1556b = r2
            r8.f1558d = r2
            r8.leftMargin = r2
            r8.rightMargin = r2
            if (r3 == 0) goto L_0x0094
            r2 = r11
            androidx.appcompat.view.menu.ActionMenuItemView r2 = (androidx.appcompat.view.menu.ActionMenuItemView) r2
            boolean r2 = r2.mo1312a()
            if (r2 == 0) goto L_0x0094
            r2 = 1
            goto L_0x0095
        L_0x0094:
            r2 = 0
        L_0x0095:
            r8.f1559e = r2
            boolean r2 = r8.f1555a
            if (r2 == 0) goto L_0x009d
            r2 = 1
            goto L_0x009e
        L_0x009d:
            r2 = r14
        L_0x009e:
            int r2 = m1919a(r11, r9, r2, r6, r5)
            int r3 = java.lang.Math.max(r15, r2)
            boolean r13 = r8.f1558d
            if (r13 == 0) goto L_0x00ac
            int r16 = r16 + 1
        L_0x00ac:
            boolean r8 = r8.f1555a
            if (r8 == 0) goto L_0x00b1
            r12 = 1
        L_0x00b1:
            int r14 = r14 - r2
            int r8 = r11.getMeasuredHeight()
            int r10 = java.lang.Math.max(r10, r8)
            r8 = 1
            if (r2 != r8) goto L_0x00c7
            int r2 = r8 << r4
            r24 = r3
            long r2 = (long) r2
            long r2 = r19 | r2
            r19 = r2
            goto L_0x00c9
        L_0x00c7:
            r24 = r3
        L_0x00c9:
            r13 = r22
            r15 = r24
        L_0x00cd:
            int r4 = r4 + 1
            r3 = r21
            r2 = r23
            r8 = 0
            goto L_0x0049
        L_0x00d6:
            r23 = r2
            r21 = r3
            r2 = 2
            if (r12 == 0) goto L_0x00e1
            if (r13 != r2) goto L_0x00e1
            r3 = 1
            goto L_0x00e2
        L_0x00e1:
            r3 = 0
        L_0x00e2:
            r4 = 0
        L_0x00e3:
            r24 = 1
            if (r16 <= 0) goto L_0x0182
            if (r14 <= 0) goto L_0x0182
            r5 = 2147483647(0x7fffffff, float:NaN)
            r5 = 0
            r8 = 0
            r11 = 2147483647(0x7fffffff, float:NaN)
            r26 = 0
        L_0x00f3:
            if (r5 >= r7) goto L_0x0123
            android.view.View r22 = r0.getChildAt(r5)
            android.view.ViewGroup$LayoutParams r22 = r22.getLayoutParams()
            r2 = r22
            androidx.appcompat.widget.ActionMenuView$c r2 = (androidx.appcompat.widget.ActionMenuView.C0569c) r2
            r28 = r4
            boolean r4 = r2.f1558d
            if (r4 != 0) goto L_0x0108
            goto L_0x011d
        L_0x0108:
            int r4 = r2.f1556b
            if (r4 >= r11) goto L_0x0113
            int r2 = r2.f1556b
            long r26 = r24 << r5
            r11 = r2
            r8 = 1
            goto L_0x011d
        L_0x0113:
            int r2 = r2.f1556b
            if (r2 != r11) goto L_0x011d
            long r29 = r24 << r5
            long r26 = r26 | r29
            int r8 = r8 + 1
        L_0x011d:
            int r5 = r5 + 1
            r4 = r28
            r2 = 2
            goto L_0x00f3
        L_0x0123:
            r28 = r4
            long r19 = r19 | r26
            if (r8 <= r14) goto L_0x0130
        L_0x0129:
            r32 = r6
            r33 = r7
            r31 = r10
            goto L_0x0185
        L_0x0130:
            int r11 = r11 + 1
            r2 = 0
        L_0x0133:
            if (r2 >= r7) goto L_0x017e
            android.view.View r4 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r5 = (androidx.appcompat.widget.ActionMenuView.C0569c) r5
            r31 = r10
            r8 = 1
            int r10 = r8 << r2
            r32 = r6
            r33 = r7
            long r6 = (long) r10
            long r24 = r26 & r6
            r17 = 0
            int r8 = (r24 > r17 ? 1 : (r24 == r17 ? 0 : -1))
            if (r8 != 0) goto L_0x0158
            int r4 = r5.f1556b
            if (r4 != r11) goto L_0x0175
            long r19 = r19 | r6
            goto L_0x0175
        L_0x0158:
            if (r3 == 0) goto L_0x016b
            boolean r6 = r5.f1559e
            if (r6 == 0) goto L_0x016b
            r6 = 1
            if (r14 != r6) goto L_0x016c
            int r7 = r0.f1554l
            int r7 = r7 + r9
            int r8 = r0.f1554l
            r10 = 0
            r4.setPadding(r7, r10, r8, r10)
            goto L_0x016c
        L_0x016b:
            r6 = 1
        L_0x016c:
            int r4 = r5.f1556b
            int r4 = r4 + r6
            r5.f1556b = r4
            r5.f1560f = r6
            int r14 = r14 + -1
        L_0x0175:
            int r2 = r2 + 1
            r10 = r31
            r6 = r32
            r7 = r33
            goto L_0x0133
        L_0x017e:
            r2 = 2
            r4 = 1
            goto L_0x00e3
        L_0x0182:
            r28 = r4
            goto L_0x0129
        L_0x0185:
            if (r12 != 0) goto L_0x018c
            r2 = 1
            if (r13 != r2) goto L_0x018d
            r3 = 1
            goto L_0x018e
        L_0x018c:
            r2 = 1
        L_0x018d:
            r3 = 0
        L_0x018e:
            if (r14 <= 0) goto L_0x0248
            r4 = 0
            int r6 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0248
            int r13 = r13 - r2
            if (r14 < r13) goto L_0x019d
            if (r3 != 0) goto L_0x019d
            if (r15 <= r2) goto L_0x0248
        L_0x019d:
            int r2 = java.lang.Long.bitCount(r19)
            float r2 = (float) r2
            if (r3 != 0) goto L_0x01de
            long r3 = r19 & r24
            r5 = 1056964608(0x3f000000, float:0.5)
            r6 = 0
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x01bf
            r3 = 0
            android.view.View r4 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r4 = (androidx.appcompat.widget.ActionMenuView.C0569c) r4
            boolean r4 = r4.f1559e
            if (r4 != 0) goto L_0x01c0
            float r2 = r2 - r5
            goto L_0x01c0
        L_0x01bf:
            r3 = 0
        L_0x01c0:
            int r7 = r33 + -1
            r4 = 1
            int r6 = r4 << r7
            long r10 = (long) r6
            long r10 = r19 & r10
            r12 = 0
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x01df
            android.view.View r4 = r0.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r4 = (androidx.appcompat.widget.ActionMenuView.C0569c) r4
            boolean r4 = r4.f1559e
            if (r4 != 0) goto L_0x01df
            float r2 = r2 - r5
            goto L_0x01df
        L_0x01de:
            r3 = 0
        L_0x01df:
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x01ea
            int r14 = r14 * r9
            float r4 = (float) r14
            float r4 = r4 / r2
            int r8 = (int) r4
            goto L_0x01eb
        L_0x01ea:
            r8 = 0
        L_0x01eb:
            r11 = r28
            r2 = r33
            r4 = 0
        L_0x01f0:
            if (r4 >= r2) goto L_0x0245
            r5 = 1
            int r6 = r5 << r4
            long r5 = (long) r6
            long r5 = r19 & r5
            r12 = 0
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x0201
            r5 = 1
            r7 = 2
            goto L_0x0242
        L_0x0201:
            android.view.View r5 = r0.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r6 = (androidx.appcompat.widget.ActionMenuView.C0569c) r6
            boolean r5 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r5 == 0) goto L_0x0224
            r6.f1557c = r8
            r5 = 1
            r6.f1560f = r5
            if (r4 != 0) goto L_0x0220
            boolean r5 = r6.f1559e
            if (r5 != 0) goto L_0x0220
            int r5 = -r8
            r7 = 2
            int r5 = r5 / r7
            r6.leftMargin = r5
            goto L_0x0221
        L_0x0220:
            r7 = 2
        L_0x0221:
            r5 = 1
        L_0x0222:
            r11 = 1
            goto L_0x0242
        L_0x0224:
            r7 = 2
            boolean r5 = r6.f1555a
            if (r5 == 0) goto L_0x0233
            r6.f1557c = r8
            r5 = 1
            r6.f1560f = r5
            int r10 = -r8
            int r10 = r10 / r7
            r6.rightMargin = r10
            goto L_0x0222
        L_0x0233:
            r5 = 1
            if (r4 == 0) goto L_0x023a
            int r10 = r8 / 2
            r6.leftMargin = r10
        L_0x023a:
            int r10 = r2 + -1
            if (r4 == r10) goto L_0x0242
            int r10 = r8 / 2
            r6.rightMargin = r10
        L_0x0242:
            int r4 = r4 + 1
            goto L_0x01f0
        L_0x0245:
            r28 = r11
            goto L_0x024b
        L_0x0248:
            r2 = r33
            r3 = 0
        L_0x024b:
            r4 = 1073741824(0x40000000, float:2.0)
            if (r28 == 0) goto L_0x0277
        L_0x024f:
            if (r3 >= r2) goto L_0x0277
            android.view.View r5 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r6 = (androidx.appcompat.widget.ActionMenuView.C0569c) r6
            boolean r7 = r6.f1560f
            if (r7 != 0) goto L_0x0262
            r7 = r32
            goto L_0x0272
        L_0x0262:
            int r7 = r6.f1556b
            int r7 = r7 * r9
            int r6 = r6.f1557c
            int r7 = r7 + r6
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r7 = r32
            r5.measure(r6, r7)
        L_0x0272:
            int r3 = r3 + 1
            r32 = r7
            goto L_0x024f
        L_0x0277:
            if (r1 == r4) goto L_0x027e
            r2 = r23
            r1 = r31
            goto L_0x0282
        L_0x027e:
            r1 = r21
            r2 = r23
        L_0x0282:
            r0.setMeasuredDimension(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.m1920a(int, int):void");
    }

    /* renamed from: a */
    static int m1919a(View view, int i, int i2, int i3, int i4) {
        C0569c cVar = (C0569c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.mo1312a();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i2 * i, C1024a.INVALID_ID), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (cVar.f1555a || !z2) {
            z = false;
        }
        cVar.f1558d = z;
        cVar.f1556b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i * i5, Ints.MAX_POWER_OF_TWO), makeMeasureSpec);
        return i5;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (!this.f1551i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i3 - i;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean a = C0656bb.m2314a(this);
        int i11 = paddingRight;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                C0569c cVar = (C0569c) childAt.getLayoutParams();
                if (cVar.f1555a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (mo1859a(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a) {
                        i7 = getPaddingLeft() + cVar.leftMargin;
                        i8 = i7 + measuredWidth;
                    } else {
                        i8 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i7 = i8 - measuredWidth;
                    }
                    int i15 = i9 - (measuredHeight / 2);
                    childAt.layout(i7, i15, i8, measuredHeight + i15);
                    i11 -= measuredWidth;
                    i12 = 1;
                } else {
                    i11 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    boolean a2 = mo1859a(i14);
                    i13++;
                }
            }
        }
        if (childCount == 1 && i12 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i16 = (i10 / 2) - (measuredWidth2 / 2);
            int i17 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i16, i17, measuredWidth2 + i16, measuredHeight2 + i17);
            return;
        }
        int i18 = i13 - (i12 ^ 1);
        if (i18 > 0) {
            i5 = i11 / i18;
            i6 = 0;
        } else {
            i6 = 0;
            i5 = 0;
        }
        int max = Math.max(i6, i5);
        if (a) {
            int width = getWidth() - getPaddingRight();
            while (i6 < childCount) {
                View childAt3 = getChildAt(i6);
                C0569c cVar2 = (C0569c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1555a) {
                    int i19 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width = i19 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i6++;
            }
        } else {
            int paddingLeft = getPaddingLeft();
            while (i6 < childCount) {
                View childAt4 = getChildAt(i6);
                C0569c cVar3 = (C0569c) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !cVar3.f1555a) {
                    int i21 = paddingLeft + cVar3.leftMargin;
                    int measuredWidth4 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i22 = i9 - (measuredHeight4 / 2);
                    childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                    paddingLeft = i21 + measuredWidth4 + cVar3.rightMargin + max;
                }
                i6++;
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo1876i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1549g.mo2493a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1549g.mo2496b();
    }

    /* renamed from: a */
    public boolean mo1858a() {
        return this.f1548f;
    }

    public void setOverflowReserved(boolean z) {
        this.f1548f = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0569c generateDefaultLayoutParams() {
        C0569c cVar = new C0569c(-2, -2);
        cVar.f1742h = 16;
        return cVar;
    }

    /* renamed from: a */
    public C0569c generateLayoutParams(AttributeSet attributeSet) {
        return new C0569c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0569c generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        C0569c cVar = layoutParams instanceof C0569c ? new C0569c((C0569c) layoutParams) : new C0569c(layoutParams);
        if (cVar.f1742h <= 0) {
            cVar.f1742h = 16;
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0569c);
    }

    /* renamed from: c */
    public C0569c mo1861c() {
        C0569c b = generateDefaultLayoutParams();
        b.f1555a = true;
        return b;
    }

    /* renamed from: a */
    public boolean mo1334a(C0537j jVar) {
        return this.f1545c.performItemAction(jVar, 0);
    }

    public void initialize(C0533h hVar) {
        this.f1545c = hVar;
    }

    public Menu getMenu() {
        if (this.f1545c == null) {
            Context context = getContext();
            this.f1545c = new C0533h(context);
            this.f1545c.setCallback(new C0570d());
            this.f1549g = new C0658c(context);
            this.f1549g.mo2495a(true);
            this.f1549g.setCallback(this.f1550h != null ? this.f1550h : new C0568b());
            this.f1545c.addMenuPresenter(this.f1549g, this.f1546d);
            this.f1549g.mo2494a(this);
        }
        return this.f1545c;
    }

    /* renamed from: a */
    public void mo1857a(C0550a aVar, C0534a aVar2) {
        this.f1550h = aVar;
        this.f1543a = aVar2;
    }

    /* renamed from: d */
    public C0533h mo1863d() {
        return this.f1545c;
    }

    /* renamed from: e */
    public boolean mo1865e() {
        return this.f1549g != null && this.f1549g.mo2499c();
    }

    /* renamed from: f */
    public boolean mo1866f() {
        return this.f1549g != null && this.f1549g.mo2500d();
    }

    /* renamed from: g */
    public boolean mo1867g() {
        return this.f1549g != null && this.f1549g.mo2503g();
    }

    /* renamed from: h */
    public boolean mo1875h() {
        return this.f1549g != null && this.f1549g.mo2504h();
    }

    /* renamed from: i */
    public void mo1876i() {
        if (this.f1549g != null) {
            this.f1549g.mo2501e();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo1859a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0567a)) {
            z = false | ((C0567a) childAt).mo1314c();
        }
        if (i > 0 && (childAt2 instanceof C0567a)) {
            z |= ((C0567a) childAt2).mo1313b();
        }
        return z;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1549g.mo2497b(z);
    }
}
