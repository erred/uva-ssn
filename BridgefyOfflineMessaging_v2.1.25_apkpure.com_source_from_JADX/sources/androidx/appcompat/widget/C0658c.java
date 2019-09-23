package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.R;
import androidx.appcompat.view.C0504a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView.C0519b;
import androidx.appcompat.view.menu.C0521b;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0547n;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.view.menu.C0551p;
import androidx.appcompat.view.menu.C0551p.C0552a;
import androidx.appcompat.view.menu.C0555s;
import androidx.appcompat.view.menu.C0559u;
import androidx.appcompat.widget.ActionMenuView.C0567a;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p070g.C0943b;
import androidx.core.p070g.C0943b.C0944a;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.c */
/* compiled from: ActionMenuPresenter */
class C0658c extends C0521b implements C0944a {

    /* renamed from: A */
    private C0660b f1909A;

    /* renamed from: g */
    C0662d f1910g;

    /* renamed from: h */
    C0664e f1911h;

    /* renamed from: i */
    C0659a f1912i;

    /* renamed from: j */
    C0661c f1913j;

    /* renamed from: k */
    final C0665f f1914k = new C0665f();

    /* renamed from: l */
    int f1915l;

    /* renamed from: m */
    private Drawable f1916m;

    /* renamed from: n */
    private boolean f1917n;

    /* renamed from: o */
    private boolean f1918o;

    /* renamed from: p */
    private boolean f1919p;

    /* renamed from: q */
    private int f1920q;

    /* renamed from: r */
    private int f1921r;

    /* renamed from: s */
    private int f1922s;

    /* renamed from: t */
    private boolean f1923t;

    /* renamed from: u */
    private boolean f1924u;

    /* renamed from: v */
    private boolean f1925v;

    /* renamed from: w */
    private boolean f1926w;

    /* renamed from: x */
    private int f1927x;

    /* renamed from: y */
    private final SparseBooleanArray f1928y = new SparseBooleanArray();

    /* renamed from: z */
    private View f1929z;

    /* renamed from: androidx.appcompat.widget.c$a */
    /* compiled from: ActionMenuPresenter */
    private class C0659a extends C0547n {
        public C0659a(Context context, C0559u uVar, View view) {
            super(context, uVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((C0537j) uVar.getItem()).mo1600j()) {
                mo1699a(C0658c.this.f1910g == null ? (View) C0658c.this.f1344f : C0658c.this.f1910g);
            }
            mo1701a((C0550a) C0658c.this.f1914k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void mo1707e() {
            C0658c.this.f1912i = null;
            C0658c.this.f1915l = 0;
            super.mo1707e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$b */
    /* compiled from: ActionMenuPresenter */
    private class C0660b extends C0519b {
        C0660b() {
        }

        /* renamed from: a */
        public C0555s mo1333a() {
            if (C0658c.this.f1912i != null) {
                return C0658c.this.f1912i.mo1704b();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c */
    /* compiled from: ActionMenuPresenter */
    private class C0661c implements Runnable {

        /* renamed from: b */
        private C0664e f1933b;

        public C0661c(C0664e eVar) {
            this.f1933b = eVar;
        }

        public void run() {
            if (C0658c.this.f1341c != null) {
                C0658c.this.f1341c.changeMenuMode();
            }
            View view = (View) C0658c.this.f1344f;
            if (!(view == null || view.getWindowToken() == null || !this.f1933b.mo1705c())) {
                C0658c.this.f1911h = this.f1933b;
            }
            C0658c.this.f1913j = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$d */
    /* compiled from: ActionMenuPresenter */
    private class C0662d extends C0690p implements C0567a {

        /* renamed from: b */
        private final float[] f1935b = new float[2];

        /* renamed from: b */
        public boolean mo1313b() {
            return false;
        }

        /* renamed from: c */
        public boolean mo1314c() {
            return false;
        }

        public C0662d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0649ax.m2296a(this, getContentDescription());
            setOnTouchListener(new C0613ag(this, C0658c.this) {
                /* renamed from: a */
                public C0555s mo1331a() {
                    if (C0658c.this.f1911h == null) {
                        return null;
                    }
                    return C0658c.this.f1911h.mo1704b();
                }

                /* renamed from: b */
                public boolean mo1332b() {
                    C0658c.this.mo2499c();
                    return true;
                }

                /* renamed from: c */
                public boolean mo2205c() {
                    if (C0658c.this.f1913j != null) {
                        return false;
                    }
                    C0658c.this.mo2500d();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0658c.this.mo2499c();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0983a.m3697a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$e */
    /* compiled from: ActionMenuPresenter */
    private class C0664e extends C0547n {
        public C0664e(Context context, C0533h hVar, View view, boolean z) {
            super(context, hVar, view, z, R.attr.actionOverflowMenuStyle);
            mo1698a(8388613);
            mo1701a((C0550a) C0658c.this.f1914k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void mo1707e() {
            if (C0658c.this.f1341c != null) {
                C0658c.this.f1341c.close();
            }
            C0658c.this.f1911h = null;
            super.mo1707e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$f */
    /* compiled from: ActionMenuPresenter */
    private class C0665f implements C0550a {
        C0665f() {
        }

        /* renamed from: a */
        public boolean mo1031a(C0533h hVar) {
            boolean z = false;
            if (hVar == null) {
                return false;
            }
            C0658c.this.f1915l = ((C0559u) hVar).getItem().getItemId();
            C0550a a = C0658c.this.mo1411a();
            if (a != null) {
                z = a.mo1031a(hVar);
            }
            return z;
        }

        /* renamed from: a */
        public void mo1030a(C0533h hVar, boolean z) {
            if (hVar instanceof C0559u) {
                hVar.getRootMenu().close(false);
            }
            C0550a a = C0658c.this.mo1411a();
            if (a != null) {
                a.mo1030a(hVar, z);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.c$g */
    /* compiled from: ActionMenuPresenter */
    private static class C0666g implements Parcelable {
        public static final Creator<C0666g> CREATOR = new Creator<C0666g>() {
            /* renamed from: a */
            public C0666g createFromParcel(Parcel parcel) {
                return new C0666g(parcel);
            }

            /* renamed from: a */
            public C0666g[] newArray(int i) {
                return new C0666g[i];
            }
        };

        /* renamed from: a */
        public int f1940a;

        public int describeContents() {
            return 0;
        }

        C0666g() {
        }

        C0666g(Parcel parcel) {
            this.f1940a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1940a);
        }
    }

    public C0658c(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    public void initForMenu(Context context, C0533h hVar) {
        super.initForMenu(context, hVar);
        Resources resources = context.getResources();
        C0504a a = C0504a.m1633a(context);
        if (!this.f1919p) {
            this.f1918o = a.mo1243b();
        }
        if (!this.f1925v) {
            this.f1920q = a.mo1244c();
        }
        if (!this.f1923t) {
            this.f1922s = a.mo1242a();
        }
        int i = this.f1920q;
        if (this.f1918o) {
            if (this.f1910g == null) {
                this.f1910g = new C0662d(this.f1339a);
                if (this.f1917n) {
                    this.f1910g.setImageDrawable(this.f1916m);
                    this.f1916m = null;
                    this.f1917n = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f1910g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1910g.getMeasuredWidth();
        } else {
            this.f1910g = null;
        }
        this.f1921r = i;
        this.f1927x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f1929z = null;
    }

    /* renamed from: a */
    public void mo2492a(Configuration configuration) {
        if (!this.f1923t) {
            this.f1922s = C0504a.m1633a(this.f1340b).mo1242a();
        }
        if (this.f1341c != null) {
            this.f1341c.onItemsChanged(true);
        }
    }

    /* renamed from: a */
    public void mo2495a(boolean z) {
        this.f1918o = z;
        this.f1919p = true;
    }

    /* renamed from: b */
    public void mo2497b(boolean z) {
        this.f1926w = z;
    }

    /* renamed from: a */
    public void mo2493a(Drawable drawable) {
        if (this.f1910g != null) {
            this.f1910g.setImageDrawable(drawable);
            return;
        }
        this.f1917n = true;
        this.f1916m = drawable;
    }

    /* renamed from: b */
    public Drawable mo2496b() {
        if (this.f1910g != null) {
            return this.f1910g.getDrawable();
        }
        if (this.f1917n) {
            return this.f1916m;
        }
        return null;
    }

    /* renamed from: a */
    public C0551p mo1412a(ViewGroup viewGroup) {
        C0551p pVar = this.f1344f;
        C0551p a = super.mo1412a(viewGroup);
        if (pVar != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    /* renamed from: a */
    public View mo1410a(C0537j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.mo1604n()) {
            actionView = super.mo1410a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    /* renamed from: a */
    public void mo1415a(C0537j jVar, C0552a aVar) {
        aVar.initialize(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1344f);
        if (this.f1909A == null) {
            this.f1909A = new C0660b();
        }
        actionMenuItemView.setPopupCallback(this.f1909A);
    }

    /* renamed from: a */
    public boolean mo1416a(int i, C0537j jVar) {
        return jVar.mo1600j();
    }

    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.f1344f).requestLayout();
        boolean z2 = false;
        if (this.f1341c != null) {
            ArrayList actionItems = this.f1341c.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                C0943b a = ((C0537j) actionItems.get(i)).mo1353a();
                if (a != null) {
                    a.mo3732a((C0944a) this);
                }
            }
        }
        ArrayList nonActionItems = this.f1341c != null ? this.f1341c.getNonActionItems() : null;
        if (this.f1918o && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !((C0537j) nonActionItems.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f1910g == null) {
                this.f1910g = new C0662d(this.f1339a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1910g.getParent();
            if (viewGroup != this.f1344f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1910g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1344f;
                actionMenuView.addView(this.f1910g, actionMenuView.mo1861c());
            }
        } else if (this.f1910g != null && this.f1910g.getParent() == this.f1344f) {
            ((ViewGroup) this.f1344f).removeView(this.f1910g);
        }
        ((ActionMenuView) this.f1344f).setOverflowReserved(this.f1918o);
    }

    /* renamed from: a */
    public boolean mo1417a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1910g) {
            return false;
        }
        return super.mo1417a(viewGroup, i);
    }

    public boolean onSubMenuSelected(C0559u uVar) {
        boolean z = false;
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        C0559u uVar2 = uVar;
        while (uVar2.getParentMenu() != this.f1341c) {
            uVar2 = (C0559u) uVar2.getParentMenu();
        }
        View a = m2317a(uVar2.getItem());
        if (a == null) {
            return false;
        }
        this.f1915l = uVar.getItem().getItemId();
        int size = uVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = uVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.f1912i = new C0659a(this.f1340b, uVar, a);
        this.f1912i.mo1702a(z);
        this.f1912i.mo1697a();
        super.onSubMenuSelected(uVar);
        return true;
    }

    /* renamed from: a */
    private View m2317a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1344f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0552a) && ((C0552a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: c */
    public boolean mo2499c() {
        if (!this.f1918o || mo2503g() || this.f1341c == null || this.f1344f == null || this.f1913j != null || this.f1341c.getNonActionItems().isEmpty()) {
            return false;
        }
        C0664e eVar = new C0664e(this.f1340b, this.f1341c, this.f1910g, true);
        this.f1913j = new C0661c(eVar);
        ((View) this.f1344f).post(this.f1913j);
        super.onSubMenuSelected(null);
        return true;
    }

    /* renamed from: d */
    public boolean mo2500d() {
        if (this.f1913j == null || this.f1344f == null) {
            C0664e eVar = this.f1911h;
            if (eVar == null) {
                return false;
            }
            eVar.mo1706d();
            return true;
        }
        ((View) this.f1344f).removeCallbacks(this.f1913j);
        this.f1913j = null;
        return true;
    }

    /* renamed from: e */
    public boolean mo2501e() {
        return mo2500d() | mo2502f();
    }

    /* renamed from: f */
    public boolean mo2502f() {
        if (this.f1912i == null) {
            return false;
        }
        this.f1912i.mo1706d();
        return true;
    }

    /* renamed from: g */
    public boolean mo2503g() {
        return this.f1911h != null && this.f1911h.mo1708f();
    }

    /* renamed from: h */
    public boolean mo2504h() {
        return this.f1913j != null || mo2503g();
    }

    public boolean flagActionItems() {
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        boolean z;
        C0658c cVar = this;
        int i5 = 0;
        if (cVar.f1341c != null) {
            arrayList = cVar.f1341c.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.f1922s;
        int i7 = cVar.f1921r;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f1344f;
        int i8 = i6;
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            C0537j jVar = (C0537j) arrayList.get(i11);
            if (jVar.mo1602l()) {
                i9++;
            } else if (jVar.mo1601k()) {
                i10++;
            } else {
                z2 = true;
            }
            if (cVar.f1926w && jVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (cVar.f1918o && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = cVar.f1928y;
        sparseBooleanArray.clear();
        if (cVar.f1924u) {
            i3 = i7 / cVar.f1927x;
            i2 = ((i7 % cVar.f1927x) / i3) + cVar.f1927x;
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i13 = i7;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i) {
            C0537j jVar2 = (C0537j) arrayList.get(i14);
            if (jVar2.mo1602l()) {
                View a = cVar.mo1410a(jVar2, cVar.f1929z, viewGroup);
                if (cVar.f1929z == null) {
                    cVar.f1929z = a;
                }
                if (cVar.f1924u) {
                    i3 -= ActionMenuView.m1919a(a, i2, i3, makeMeasureSpec, i5);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i15 != 0) {
                    measuredWidth = i15;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                jVar2.mo1576d(z);
                i4 = i;
                i15 = measuredWidth;
            } else if (jVar2.mo1601k()) {
                int groupId2 = jVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i13 > 0 && (!cVar.f1924u || i3 > 0);
                if (z4) {
                    boolean z5 = z4;
                    View a2 = cVar.mo1410a(jVar2, cVar.f1929z, viewGroup);
                    i4 = i;
                    if (cVar.f1929z == null) {
                        cVar.f1929z = a2;
                    }
                    if (cVar.f1924u) {
                        int a3 = ActionMenuView.m1919a(a2, i2, i3, makeMeasureSpec, 0);
                        i3 -= a3;
                        if (a3 == 0) {
                            z5 = false;
                        }
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a2.getMeasuredWidth();
                    i13 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    if (cVar.f1924u) {
                        z4 = z5 & (i13 >= 0);
                    } else {
                        z4 = z5 & (i13 + i15 > 0);
                    }
                } else {
                    boolean z6 = z4;
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i16 = 0;
                    while (i16 < i14) {
                        C0537j jVar3 = (C0537j) arrayList.get(i16);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.mo1600j()) {
                                i12++;
                            }
                            jVar3.mo1576d(false);
                        }
                        i16++;
                    }
                }
                if (z4) {
                    i12--;
                }
                jVar2.mo1576d(z4);
            } else {
                i4 = i;
                jVar2.mo1576d(false);
                i14++;
                i = i4;
                cVar = this;
                i5 = 0;
            }
            i14++;
            i = i4;
            cVar = this;
            i5 = 0;
        }
        return true;
    }

    public void onCloseMenu(C0533h hVar, boolean z) {
        mo2501e();
        super.onCloseMenu(hVar, z);
    }

    public Parcelable onSaveInstanceState() {
        C0666g gVar = new C0666g();
        gVar.f1940a = this.f1915l;
        return gVar;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0666g) {
            C0666g gVar = (C0666g) parcelable;
            if (gVar.f1940a > 0) {
                MenuItem findItem = this.f1341c.findItem(gVar.f1940a);
                if (findItem != null) {
                    onSubMenuSelected((C0559u) findItem.getSubMenu());
                }
            }
        }
    }

    /* renamed from: c */
    public void mo2498c(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.f1341c != null) {
            this.f1341c.close(false);
        }
    }

    /* renamed from: a */
    public void mo2494a(ActionMenuView actionMenuView) {
        this.f1344f = actionMenuView;
        actionMenuView.initialize(this.f1341c);
    }
}
