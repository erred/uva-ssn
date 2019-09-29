package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.widget.C0627ak;
import androidx.core.p070g.C0962r;

/* renamed from: androidx.appcompat.view.menu.t */
/* compiled from: StandardMenuPopup */
final class C0556t extends C0546m implements OnKeyListener, OnItemClickListener, OnDismissListener, C0549o {

    /* renamed from: e */
    private static final int f1466e = R.layout.abc_popup_menu_item_layout;

    /* renamed from: a */
    final C0627ak f1467a;

    /* renamed from: b */
    final OnGlobalLayoutListener f1468b = new OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (C0556t.this.mo1443c() && !C0556t.this.f1467a.mo2270g()) {
                View view = C0556t.this.f1469c;
                if (view == null || !view.isShown()) {
                    C0556t.this.mo1439b();
                } else {
                    C0556t.this.f1467a.mo1433a();
                }
            }
        }
    };

    /* renamed from: c */
    View f1469c;

    /* renamed from: d */
    ViewTreeObserver f1470d;

    /* renamed from: f */
    private final Context f1471f;

    /* renamed from: g */
    private final C0533h f1472g;

    /* renamed from: h */
    private final C0532g f1473h;

    /* renamed from: i */
    private final boolean f1474i;

    /* renamed from: j */
    private final int f1475j;

    /* renamed from: k */
    private final int f1476k;

    /* renamed from: l */
    private final int f1477l;

    /* renamed from: m */
    private final OnAttachStateChangeListener f1478m = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (C0556t.this.f1470d != null) {
                if (!C0556t.this.f1470d.isAlive()) {
                    C0556t.this.f1470d = view.getViewTreeObserver();
                }
                C0556t.this.f1470d.removeGlobalOnLayoutListener(C0556t.this.f1468b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: n */
    private OnDismissListener f1479n;

    /* renamed from: o */
    private View f1480o;

    /* renamed from: p */
    private C0550a f1481p;

    /* renamed from: q */
    private boolean f1482q;

    /* renamed from: r */
    private boolean f1483r;

    /* renamed from: s */
    private int f1484s;

    /* renamed from: t */
    private int f1485t = 0;

    /* renamed from: u */
    private boolean f1486u;

    /* renamed from: a */
    public void mo1437a(C0533h hVar) {
    }

    public boolean flagActionItems() {
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public C0556t(Context context, C0533h hVar, View view, int i, int i2, boolean z) {
        this.f1471f = context;
        this.f1472g = hVar;
        this.f1474i = z;
        this.f1473h = new C0532g(hVar, LayoutInflater.from(context), this.f1474i, f1466e);
        this.f1476k = i;
        this.f1477l = i2;
        Resources resources = context.getResources();
        this.f1475j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1480o = view;
        this.f1467a = new C0627ak(this.f1471f, null, this.f1476k, this.f1477l);
        hVar.addMenuPresenter(this, context);
    }

    /* renamed from: a */
    public void mo1438a(boolean z) {
        this.f1473h.mo1471a(z);
    }

    /* renamed from: a */
    public void mo1434a(int i) {
        this.f1485t = i;
    }

    /* renamed from: g */
    private boolean m1868g() {
        if (mo1443c()) {
            return true;
        }
        if (this.f1482q || this.f1480o == null) {
            return false;
        }
        this.f1469c = this.f1480o;
        this.f1467a.mo2260a((OnDismissListener) this);
        this.f1467a.mo2258a((OnItemClickListener) this);
        this.f1467a.mo2261a(true);
        View view = this.f1469c;
        boolean z = this.f1470d == null;
        this.f1470d = view.getViewTreeObserver();
        if (z) {
            this.f1470d.addOnGlobalLayoutListener(this.f1468b);
        }
        view.addOnAttachStateChangeListener(this.f1478m);
        this.f1467a.mo2263b(view);
        this.f1467a.mo2267e(this.f1485t);
        if (!this.f1483r) {
            this.f1484s = m1831a(this.f1473h, null, this.f1471f, this.f1475j);
            this.f1483r = true;
        }
        this.f1467a.mo2269g(this.f1484s);
        this.f1467a.mo2272h(2);
        this.f1467a.mo2256a(mo1695f());
        this.f1467a.mo1433a();
        ListView d = this.f1467a.mo1444d();
        d.setOnKeyListener(this);
        if (this.f1486u && this.f1472g.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1471f).inflate(R.layout.abc_popup_menu_header_item_layout, d, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1472g.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            d.addHeaderView(frameLayout, null, false);
        }
        this.f1467a.mo2259a((ListAdapter) this.f1473h);
        this.f1467a.mo1433a();
        return true;
    }

    /* renamed from: a */
    public void mo1433a() {
        if (!m1868g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    /* renamed from: b */
    public void mo1439b() {
        if (mo1443c()) {
            this.f1467a.mo1439b();
        }
    }

    /* renamed from: c */
    public boolean mo1443c() {
        return !this.f1482q && this.f1467a.mo1443c();
    }

    public void onDismiss() {
        this.f1482q = true;
        this.f1472g.close();
        if (this.f1470d != null) {
            if (!this.f1470d.isAlive()) {
                this.f1470d = this.f1469c.getViewTreeObserver();
            }
            this.f1470d.removeGlobalOnLayoutListener(this.f1468b);
            this.f1470d = null;
        }
        this.f1469c.removeOnAttachStateChangeListener(this.f1478m);
        if (this.f1479n != null) {
            this.f1479n.onDismiss();
        }
    }

    public void updateMenuView(boolean z) {
        this.f1483r = false;
        if (this.f1473h != null) {
            this.f1473h.notifyDataSetChanged();
        }
    }

    public void setCallback(C0550a aVar) {
        this.f1481p = aVar;
    }

    public boolean onSubMenuSelected(C0559u uVar) {
        if (uVar.hasVisibleItems()) {
            C0547n nVar = new C0547n(this.f1471f, uVar, this.f1469c, this.f1474i, this.f1476k, this.f1477l);
            nVar.mo1701a(this.f1481p);
            nVar.mo1702a(C0546m.m1833b((C0533h) uVar));
            nVar.mo1700a(this.f1479n);
            this.f1479n = null;
            this.f1472g.close(false);
            int j = this.f1467a.mo2275j();
            int k = this.f1467a.mo2276k();
            if ((Gravity.getAbsoluteGravity(this.f1485t, C0962r.m3579f(this.f1480o)) & 7) == 5) {
                j += this.f1480o.getWidth();
            }
            if (nVar.mo1703a(j, k)) {
                if (this.f1481p != null) {
                    this.f1481p.mo1031a(uVar);
                }
                return true;
            }
        }
        return false;
    }

    public void onCloseMenu(C0533h hVar, boolean z) {
        if (hVar == this.f1472g) {
            mo1439b();
            if (this.f1481p != null) {
                this.f1481p.mo1030a(hVar, z);
            }
        }
    }

    /* renamed from: a */
    public void mo1435a(View view) {
        this.f1480o = view;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo1439b();
        return true;
    }

    /* renamed from: a */
    public void mo1436a(OnDismissListener onDismissListener) {
        this.f1479n = onDismissListener;
    }

    /* renamed from: d */
    public ListView mo1444d() {
        return this.f1467a.mo1444d();
    }

    /* renamed from: b */
    public void mo1440b(int i) {
        this.f1467a.mo2265c(i);
    }

    /* renamed from: c */
    public void mo1442c(int i) {
        this.f1467a.mo2266d(i);
    }

    /* renamed from: b */
    public void mo1441b(boolean z) {
        this.f1486u = z;
    }
}
