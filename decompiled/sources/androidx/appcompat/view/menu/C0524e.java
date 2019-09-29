package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.widget.C0626aj;
import androidx.appcompat.widget.C0627ak;
import androidx.core.p070g.C0946c;
import androidx.core.p070g.C0962r;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.appcompat.view.menu.e */
/* compiled from: CascadingMenuPopup */
final class C0524e extends C0546m implements OnKeyListener, OnDismissListener, C0549o {

    /* renamed from: g */
    private static final int f1353g = R.layout.abc_cascading_menu_item_layout;

    /* renamed from: A */
    private OnDismissListener f1354A;

    /* renamed from: a */
    final Handler f1355a;

    /* renamed from: b */
    final List<C0529a> f1356b = new ArrayList();

    /* renamed from: c */
    final OnGlobalLayoutListener f1357c = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (C0524e.this.mo1443c() && C0524e.this.f1356b.size() > 0 && !((C0529a) C0524e.this.f1356b.get(0)).f1387a.mo2270g()) {
                View view = C0524e.this.f1358d;
                if (view == null || !view.isShown()) {
                    C0524e.this.mo1439b();
                    return;
                }
                for (C0529a aVar : C0524e.this.f1356b) {
                    aVar.f1387a.mo1433a();
                }
            }
        }
    };

    /* renamed from: d */
    View f1358d;

    /* renamed from: e */
    ViewTreeObserver f1359e;

    /* renamed from: f */
    boolean f1360f;

    /* renamed from: h */
    private final Context f1361h;

    /* renamed from: i */
    private final int f1362i;

    /* renamed from: j */
    private final int f1363j;

    /* renamed from: k */
    private final int f1364k;

    /* renamed from: l */
    private final boolean f1365l;

    /* renamed from: m */
    private final List<C0533h> f1366m = new ArrayList();

    /* renamed from: n */
    private final OnAttachStateChangeListener f1367n = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (C0524e.this.f1359e != null) {
                if (!C0524e.this.f1359e.isAlive()) {
                    C0524e.this.f1359e = view.getViewTreeObserver();
                }
                C0524e.this.f1359e.removeGlobalOnLayoutListener(C0524e.this.f1357c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: o */
    private final C0626aj f1368o = new C0626aj() {
        /* renamed from: a */
        public void mo1453a(C0533h hVar, MenuItem menuItem) {
            C0524e.this.f1355a.removeCallbacksAndMessages(hVar);
        }

        /* renamed from: b */
        public void mo1454b(final C0533h hVar, final MenuItem menuItem) {
            final C0529a aVar = null;
            C0524e.this.f1355a.removeCallbacksAndMessages(null);
            int size = C0524e.this.f1356b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (hVar == ((C0529a) C0524e.this.f1356b.get(i)).f1388b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < C0524e.this.f1356b.size()) {
                    aVar = (C0529a) C0524e.this.f1356b.get(i2);
                }
                C0524e.this.f1355a.postAtTime(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            C0524e.this.f1360f = true;
                            aVar.f1388b.close(false);
                            C0524e.this.f1360f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.performItemAction(menuItem, 4);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };

    /* renamed from: p */
    private int f1369p = 0;

    /* renamed from: q */
    private int f1370q = 0;

    /* renamed from: r */
    private View f1371r;

    /* renamed from: s */
    private int f1372s;

    /* renamed from: t */
    private boolean f1373t;

    /* renamed from: u */
    private boolean f1374u;

    /* renamed from: v */
    private int f1375v;

    /* renamed from: w */
    private int f1376w;

    /* renamed from: x */
    private boolean f1377x;

    /* renamed from: y */
    private boolean f1378y;

    /* renamed from: z */
    private C0550a f1379z;

    /* renamed from: androidx.appcompat.view.menu.e$a */
    /* compiled from: CascadingMenuPopup */
    private static class C0529a {

        /* renamed from: a */
        public final C0627ak f1387a;

        /* renamed from: b */
        public final C0533h f1388b;

        /* renamed from: c */
        public final int f1389c;

        public C0529a(C0627ak akVar, C0533h hVar, int i) {
            this.f1387a = akVar;
            this.f1388b = hVar;
            this.f1389c = i;
        }

        /* renamed from: a */
        public ListView mo1456a() {
            return this.f1387a.mo1444d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo1445e() {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public C0524e(Context context, View view, int i, int i2, boolean z) {
        this.f1361h = context;
        this.f1371r = view;
        this.f1363j = i;
        this.f1364k = i2;
        this.f1365l = z;
        this.f1377x = false;
        this.f1372s = m1754h();
        Resources resources = context.getResources();
        this.f1362i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1355a = new Handler();
    }

    /* renamed from: a */
    public void mo1438a(boolean z) {
        this.f1377x = z;
    }

    /* renamed from: g */
    private C0627ak m1753g() {
        C0627ak akVar = new C0627ak(this.f1361h, null, this.f1363j, this.f1364k);
        akVar.mo2290a(this.f1368o);
        akVar.mo2258a((OnItemClickListener) this);
        akVar.mo2260a((OnDismissListener) this);
        akVar.mo2263b(this.f1371r);
        akVar.mo2267e(this.f1370q);
        akVar.mo2261a(true);
        akVar.mo2272h(2);
        return akVar;
    }

    /* renamed from: a */
    public void mo1433a() {
        if (!mo1443c()) {
            for (C0533h c : this.f1366m) {
                m1750c(c);
            }
            this.f1366m.clear();
            this.f1358d = this.f1371r;
            if (this.f1358d != null) {
                boolean z = this.f1359e == null;
                this.f1359e = this.f1358d.getViewTreeObserver();
                if (z) {
                    this.f1359e.addOnGlobalLayoutListener(this.f1357c);
                }
                this.f1358d.addOnAttachStateChangeListener(this.f1367n);
            }
        }
    }

    /* renamed from: b */
    public void mo1439b() {
        int size = this.f1356b.size();
        if (size > 0) {
            C0529a[] aVarArr = (C0529a[]) this.f1356b.toArray(new C0529a[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0529a aVar = aVarArr[i];
                if (aVar.f1387a.mo1443c()) {
                    aVar.f1387a.mo1439b();
                }
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo1439b();
        return true;
    }

    /* renamed from: h */
    private int m1754h() {
        return C0962r.m3579f(this.f1371r) == 1 ? 0 : 1;
    }

    /* renamed from: d */
    private int m1751d(int i) {
        ListView a = ((C0529a) this.f1356b.get(this.f1356b.size() - 1)).mo1456a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1358d.getWindowVisibleDisplayFrame(rect);
        if (this.f1372s == 1) {
            if (iArr[0] + a.getWidth() + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* renamed from: a */
    public void mo1437a(C0533h hVar) {
        hVar.addMenuPresenter(this, this.f1361h);
        if (mo1443c()) {
            m1750c(hVar);
        } else {
            this.f1366m.add(hVar);
        }
    }

    /* renamed from: c */
    private void m1750c(C0533h hVar) {
        View view;
        C0529a aVar;
        int i;
        int i2;
        LayoutInflater from = LayoutInflater.from(this.f1361h);
        C0532g gVar = new C0532g(hVar, from, this.f1365l, f1353g);
        if (!mo1443c() && this.f1377x) {
            gVar.mo1471a(true);
        } else if (mo1443c()) {
            gVar.mo1471a(C0546m.m1833b(hVar));
        }
        int a = m1831a(gVar, null, this.f1361h, this.f1362i);
        C0627ak g = m1753g();
        g.mo2259a((ListAdapter) gVar);
        g.mo2269g(a);
        g.mo2267e(this.f1370q);
        if (this.f1356b.size() > 0) {
            aVar = (C0529a) this.f1356b.get(this.f1356b.size() - 1);
            view = m1749a(aVar, hVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            g.mo2293c(false);
            g.mo2291a((Object) null);
            int d = m1751d(a);
            boolean z = d == 1;
            this.f1372s = d;
            if (VERSION.SDK_INT >= 26) {
                g.mo2263b(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f1371r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f1370q & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1371r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            int i3 = (this.f1370q & 5) == 5 ? z ? i + a : i - view.getWidth() : z ? i + view.getWidth() : i - a;
            g.mo2265c(i3);
            g.mo2264b(true);
            g.mo2266d(i2);
        } else {
            if (this.f1373t) {
                g.mo2265c(this.f1375v);
            }
            if (this.f1374u) {
                g.mo2266d(this.f1376w);
            }
            g.mo2256a(mo1695f());
        }
        this.f1356b.add(new C0529a(g, hVar, this.f1372s));
        g.mo1433a();
        ListView d2 = g.mo1444d();
        d2.setOnKeyListener(this);
        if (aVar == null && this.f1378y && hVar.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, d2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(hVar.getHeaderTitle());
            d2.addHeaderView(frameLayout, null, false);
            g.mo1433a();
        }
    }

    /* renamed from: a */
    private MenuItem m1748a(C0533h hVar, C0533h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: a */
    private View m1749a(C0529a aVar, C0533h hVar) {
        int i;
        C0532g gVar;
        MenuItem a = m1748a(aVar.f1388b, hVar);
        if (a == null) {
            return null;
        }
        ListView a2 = aVar.mo1456a();
        ListAdapter adapter = a2.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            gVar = (C0532g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (C0532g) adapter;
            i = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a == gVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1) {
            return null;
        }
        int firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= a2.getChildCount()) {
            return null;
        }
        return a2.getChildAt(firstVisiblePosition);
    }

    /* renamed from: c */
    public boolean mo1443c() {
        return this.f1356b.size() > 0 && ((C0529a) this.f1356b.get(0)).f1387a.mo1443c();
    }

    public void onDismiss() {
        C0529a aVar;
        int size = this.f1356b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = (C0529a) this.f1356b.get(i);
            if (!aVar.f1387a.mo1443c()) {
                break;
            }
            i++;
        }
        if (aVar != null) {
            aVar.f1388b.close(false);
        }
    }

    public void updateMenuView(boolean z) {
        for (C0529a a : this.f1356b) {
            m1832a(a.mo1456a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void setCallback(C0550a aVar) {
        this.f1379z = aVar;
    }

    public boolean onSubMenuSelected(C0559u uVar) {
        for (C0529a aVar : this.f1356b) {
            if (uVar == aVar.f1388b) {
                aVar.mo1456a().requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        mo1437a((C0533h) uVar);
        if (this.f1379z != null) {
            this.f1379z.mo1031a(uVar);
        }
        return true;
    }

    /* renamed from: d */
    private int m1752d(C0533h hVar) {
        int size = this.f1356b.size();
        for (int i = 0; i < size; i++) {
            if (hVar == ((C0529a) this.f1356b.get(i)).f1388b) {
                return i;
            }
        }
        return -1;
    }

    public void onCloseMenu(C0533h hVar, boolean z) {
        int d = m1752d(hVar);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.f1356b.size()) {
                ((C0529a) this.f1356b.get(i)).f1388b.close(false);
            }
            C0529a aVar = (C0529a) this.f1356b.remove(d);
            aVar.f1388b.removeMenuPresenter(this);
            if (this.f1360f) {
                aVar.f1387a.mo2292b(null);
                aVar.f1387a.mo2262b(0);
            }
            aVar.f1387a.mo1439b();
            int size = this.f1356b.size();
            if (size > 0) {
                this.f1372s = ((C0529a) this.f1356b.get(size - 1)).f1389c;
            } else {
                this.f1372s = m1754h();
            }
            if (size == 0) {
                mo1439b();
                if (this.f1379z != null) {
                    this.f1379z.mo1030a(hVar, true);
                }
                if (this.f1359e != null) {
                    if (this.f1359e.isAlive()) {
                        this.f1359e.removeGlobalOnLayoutListener(this.f1357c);
                    }
                    this.f1359e = null;
                }
                this.f1358d.removeOnAttachStateChangeListener(this.f1367n);
                this.f1354A.onDismiss();
            } else if (z) {
                ((C0529a) this.f1356b.get(0)).f1388b.close(false);
            }
        }
    }

    /* renamed from: a */
    public void mo1434a(int i) {
        if (this.f1369p != i) {
            this.f1369p = i;
            this.f1370q = C0946c.m3493a(i, C0962r.m3579f(this.f1371r));
        }
    }

    /* renamed from: a */
    public void mo1435a(View view) {
        if (this.f1371r != view) {
            this.f1371r = view;
            this.f1370q = C0946c.m3493a(this.f1369p, C0962r.m3579f(this.f1371r));
        }
    }

    /* renamed from: a */
    public void mo1436a(OnDismissListener onDismissListener) {
        this.f1354A = onDismissListener;
    }

    /* renamed from: d */
    public ListView mo1444d() {
        if (this.f1356b.isEmpty()) {
            return null;
        }
        return ((C0529a) this.f1356b.get(this.f1356b.size() - 1)).mo1456a();
    }

    /* renamed from: b */
    public void mo1440b(int i) {
        this.f1373t = true;
        this.f1375v = i;
    }

    /* renamed from: c */
    public void mo1442c(int i) {
        this.f1374u = true;
        this.f1376w = i;
    }

    /* renamed from: b */
    public void mo1441b(boolean z) {
        this.f1378y = z;
    }
}
