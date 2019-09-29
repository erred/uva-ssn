package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.view.menu.C0520a;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0533h.C0534a;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.widget.Toolbar.C0597b;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0969v;
import androidx.core.p070g.C0973w;
import androidx.core.p070g.C0974x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.appcompat.widget.aw */
/* compiled from: ToolbarWidgetWrapper */
public class C0646aw implements C0606ac {

    /* renamed from: a */
    Toolbar f1863a;

    /* renamed from: b */
    CharSequence f1864b;

    /* renamed from: c */
    Callback f1865c;

    /* renamed from: d */
    boolean f1866d;

    /* renamed from: e */
    private int f1867e;

    /* renamed from: f */
    private View f1868f;

    /* renamed from: g */
    private View f1869g;

    /* renamed from: h */
    private Drawable f1870h;

    /* renamed from: i */
    private Drawable f1871i;

    /* renamed from: j */
    private Drawable f1872j;

    /* renamed from: k */
    private boolean f1873k;

    /* renamed from: l */
    private CharSequence f1874l;

    /* renamed from: m */
    private CharSequence f1875m;

    /* renamed from: n */
    private C0658c f1876n;

    /* renamed from: o */
    private int f1877o;

    /* renamed from: p */
    private int f1878p;

    /* renamed from: q */
    private Drawable f1879q;

    /* renamed from: b */
    public void mo2170b(boolean z) {
    }

    public C0646aw(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public C0646aw(Toolbar toolbar, boolean z, int i, int i2) {
        this.f1877o = 0;
        this.f1878p = 0;
        this.f1863a = toolbar;
        this.f1864b = toolbar.getTitle();
        this.f1874l = toolbar.getSubtitle();
        this.f1873k = this.f1864b != null;
        this.f1872j = toolbar.getNavigationIcon();
        C0645av a = C0645av.m2230a(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f1879q = a.mo2449a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.mo2456c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                mo2466b(c);
            }
            CharSequence c2 = a.mo2456c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c2)) {
                mo2468c(c2);
            }
            Drawable a2 = a.mo2449a(R.styleable.ActionBar_logo);
            if (a2 != null) {
                mo2467c(a2);
            }
            Drawable a3 = a.mo2449a(R.styleable.ActionBar_icon);
            if (a3 != null) {
                mo2160a(a3);
            }
            if (this.f1872j == null && this.f1879q != null) {
                mo2169b(this.f1879q);
            }
            mo2171c(a.mo2447a(R.styleable.ActionBar_displayOptions, 0));
            int g = a.mo2463g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                mo2465a(LayoutInflater.from(this.f1863a.getContext()).inflate(g, this.f1863a, false));
                mo2171c(this.f1867e | 16);
            }
            int f = a.mo2461f(R.styleable.ActionBar_height, 0);
            if (f > 0) {
                LayoutParams layoutParams = this.f1863a.getLayoutParams();
                layoutParams.height = f;
                this.f1863a.setLayoutParams(layoutParams);
            }
            int d = a.mo2457d(R.styleable.ActionBar_contentInsetStart, -1);
            int d2 = a.mo2457d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (d >= 0 || d2 >= 0) {
                this.f1863a.setContentInsetsRelative(Math.max(d, 0), Math.max(d2, 0));
            }
            int g2 = a.mo2463g(R.styleable.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                this.f1863a.setTitleTextAppearance(this.f1863a.getContext(), g2);
            }
            int g3 = a.mo2463g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                this.f1863a.setSubtitleTextAppearance(this.f1863a.getContext(), g3);
            }
            int g4 = a.mo2463g(R.styleable.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f1863a.setPopupTheme(g4);
            }
        } else {
            this.f1867e = m2251r();
        }
        a.mo2450a();
        mo2470e(i);
        this.f1875m = this.f1863a.getNavigationContentDescription();
        this.f1863a.setNavigationOnClickListener(new OnClickListener() {

            /* renamed from: a */
            final C0520a f1880a;

            {
                C0520a aVar = new C0520a(C0646aw.this.f1863a.getContext(), 0, 16908332, 0, 0, C0646aw.this.f1864b);
                this.f1880a = aVar;
            }

            public void onClick(View view) {
                if (C0646aw.this.f1865c != null && C0646aw.this.f1866d) {
                    C0646aw.this.f1865c.onMenuItemSelected(0, this.f1880a);
                }
            }
        });
    }

    /* renamed from: e */
    public void mo2470e(int i) {
        if (i != this.f1878p) {
            this.f1878p = i;
            if (TextUtils.isEmpty(this.f1863a.getNavigationContentDescription())) {
                mo2471f(this.f1878p);
            }
        }
    }

    /* renamed from: r */
    private int m2251r() {
        if (this.f1863a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1879q = this.f1863a.getNavigationIcon();
        return 15;
    }

    /* renamed from: a */
    public ViewGroup mo2157a() {
        return this.f1863a;
    }

    /* renamed from: b */
    public Context mo2167b() {
        return this.f1863a.getContext();
    }

    /* renamed from: c */
    public boolean mo2172c() {
        return this.f1863a.hasExpandedActionView();
    }

    /* renamed from: d */
    public void mo2173d() {
        this.f1863a.collapseActionView();
    }

    /* renamed from: a */
    public void mo2162a(Callback callback) {
        this.f1865c = callback;
    }

    /* renamed from: a */
    public void mo2165a(CharSequence charSequence) {
        if (!this.f1873k) {
            m2250e(charSequence);
        }
    }

    /* renamed from: e */
    public CharSequence mo2175e() {
        return this.f1863a.getTitle();
    }

    /* renamed from: b */
    public void mo2466b(CharSequence charSequence) {
        this.f1873k = true;
        m2250e(charSequence);
    }

    /* renamed from: e */
    private void m2250e(CharSequence charSequence) {
        this.f1864b = charSequence;
        if ((this.f1867e & 8) != 0) {
            this.f1863a.setTitle(charSequence);
        }
    }

    /* renamed from: c */
    public void mo2468c(CharSequence charSequence) {
        this.f1874l = charSequence;
        if ((this.f1867e & 8) != 0) {
            this.f1863a.setSubtitle(charSequence);
        }
    }

    /* renamed from: f */
    public void mo2176f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: g */
    public void mo2177g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: a */
    public void mo2159a(int i) {
        mo2160a(i != 0 ? C0424a.m1270b(mo2167b(), i) : null);
    }

    /* renamed from: a */
    public void mo2160a(Drawable drawable) {
        this.f1870h = drawable;
        m2252s();
    }

    /* renamed from: b */
    public void mo2168b(int i) {
        mo2467c(i != 0 ? C0424a.m1270b(mo2167b(), i) : null);
    }

    /* renamed from: c */
    public void mo2467c(Drawable drawable) {
        this.f1871i = drawable;
        m2252s();
    }

    /* renamed from: s */
    private void m2252s() {
        Drawable drawable = (this.f1867e & 2) != 0 ? (this.f1867e & 1) != 0 ? this.f1871i != null ? this.f1871i : this.f1870h : this.f1870h : null;
        this.f1863a.setLogo(drawable);
    }

    /* renamed from: h */
    public boolean mo2178h() {
        return this.f1863a.canShowOverflowMenu();
    }

    /* renamed from: i */
    public boolean mo2179i() {
        return this.f1863a.isOverflowMenuShowing();
    }

    /* renamed from: j */
    public boolean mo2180j() {
        return this.f1863a.isOverflowMenuShowPending();
    }

    /* renamed from: k */
    public boolean mo2181k() {
        return this.f1863a.showOverflowMenu();
    }

    /* renamed from: l */
    public boolean mo2182l() {
        return this.f1863a.hideOverflowMenu();
    }

    /* renamed from: m */
    public void mo2183m() {
        this.f1866d = true;
    }

    /* renamed from: a */
    public void mo2161a(Menu menu, C0550a aVar) {
        if (this.f1876n == null) {
            this.f1876n = new C0658c(this.f1863a.getContext());
            this.f1876n.mo1413a(R.id.action_menu_presenter);
        }
        this.f1876n.setCallback(aVar);
        this.f1863a.setMenu((C0533h) menu, this.f1876n);
    }

    /* renamed from: n */
    public void mo2184n() {
        this.f1863a.dismissPopupMenus();
    }

    /* renamed from: o */
    public int mo2185o() {
        return this.f1867e;
    }

    /* renamed from: c */
    public void mo2171c(int i) {
        int i2 = this.f1867e ^ i;
        this.f1867e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m2254u();
                }
                m2253t();
            }
            if ((i2 & 3) != 0) {
                m2252s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1863a.setTitle(this.f1864b);
                    this.f1863a.setSubtitle(this.f1874l);
                } else {
                    this.f1863a.setTitle((CharSequence) null);
                    this.f1863a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.f1869g != null) {
                if ((i & 16) != 0) {
                    this.f1863a.addView(this.f1869g);
                } else {
                    this.f1863a.removeView(this.f1869g);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2164a(C0631an anVar) {
        if (this.f1868f != null && this.f1868f.getParent() == this.f1863a) {
            this.f1863a.removeView(this.f1868f);
        }
        this.f1868f = anVar;
        if (anVar != null && this.f1877o == 2) {
            this.f1863a.addView(this.f1868f, 0);
            C0597b bVar = (C0597b) this.f1868f.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.f973a = 8388691;
            anVar.setAllowCollapse(true);
        }
    }

    /* renamed from: a */
    public void mo2166a(boolean z) {
        this.f1863a.setCollapsible(z);
    }

    /* renamed from: p */
    public int mo2186p() {
        return this.f1877o;
    }

    /* renamed from: a */
    public void mo2465a(View view) {
        if (!(this.f1869g == null || (this.f1867e & 16) == 0)) {
            this.f1863a.removeView(this.f1869g);
        }
        this.f1869g = view;
        if (view != null && (this.f1867e & 16) != 0) {
            this.f1863a.addView(this.f1869g);
        }
    }

    /* renamed from: a */
    public C0969v mo2158a(final int i, long j) {
        return C0962r.m3591n(this.f1863a).mo3763a(i == 0 ? 1.0f : BitmapDescriptorFactory.HUE_RED).mo3764a(j).mo3766a((C0973w) new C0974x() {

            /* renamed from: c */
            private boolean f1884c = false;

            /* renamed from: a */
            public void mo1028a(View view) {
                C0646aw.this.f1863a.setVisibility(0);
            }

            /* renamed from: b */
            public void mo1029b(View view) {
                if (!this.f1884c) {
                    C0646aw.this.f1863a.setVisibility(i);
                }
            }

            /* renamed from: c */
            public void mo2144c(View view) {
                this.f1884c = true;
            }
        });
    }

    /* renamed from: b */
    public void mo2169b(Drawable drawable) {
        this.f1872j = drawable;
        m2253t();
    }

    /* renamed from: t */
    private void m2253t() {
        if ((this.f1867e & 4) != 0) {
            this.f1863a.setNavigationIcon(this.f1872j != null ? this.f1872j : this.f1879q);
        } else {
            this.f1863a.setNavigationIcon((Drawable) null);
        }
    }

    /* renamed from: d */
    public void mo2469d(CharSequence charSequence) {
        this.f1875m = charSequence;
        m2254u();
    }

    /* renamed from: f */
    public void mo2471f(int i) {
        mo2469d((CharSequence) i == 0 ? null : mo2167b().getString(i));
    }

    /* renamed from: u */
    private void m2254u() {
        if ((this.f1867e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1875m)) {
            this.f1863a.setNavigationContentDescription(this.f1878p);
        } else {
            this.f1863a.setNavigationContentDescription(this.f1875m);
        }
    }

    /* renamed from: d */
    public void mo2174d(int i) {
        this.f1863a.setVisibility(i);
    }

    /* renamed from: a */
    public void mo2163a(C0550a aVar, C0534a aVar2) {
        this.f1863a.setMenuCallbacks(aVar, aVar2);
    }

    /* renamed from: q */
    public Menu mo2187q() {
        return this.f1863a.getMenu();
    }
}
