package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.appcompat.app.C0440a.C0442b;
import androidx.appcompat.view.C0504a;
import androidx.appcompat.view.C0505b;
import androidx.appcompat.view.C0505b.C0506a;
import androidx.appcompat.view.C0512g;
import androidx.appcompat.view.C0515h;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0533h.C0534a;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout.C0565a;
import androidx.appcompat.widget.C0606ac;
import androidx.appcompat.widget.C0631an;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0969v;
import androidx.core.p070g.C0973w;
import androidx.core.p070g.C0974x;
import androidx.core.p070g.C0975y;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.app.n */
/* compiled from: WindowDecorActionBar */
public class C0483n extends C0440a implements C0565a {

    /* renamed from: s */
    static final /* synthetic */ boolean f1101s = (!C0483n.class.desiredAssertionStatus());

    /* renamed from: t */
    private static final Interpolator f1102t = new AccelerateInterpolator();

    /* renamed from: u */
    private static final Interpolator f1103u = new DecelerateInterpolator();

    /* renamed from: A */
    private boolean f1104A;

    /* renamed from: B */
    private boolean f1105B;

    /* renamed from: C */
    private ArrayList<C0442b> f1106C = new ArrayList<>();

    /* renamed from: D */
    private boolean f1107D;

    /* renamed from: E */
    private int f1108E = 0;

    /* renamed from: F */
    private boolean f1109F;

    /* renamed from: G */
    private boolean f1110G = true;

    /* renamed from: H */
    private boolean f1111H;

    /* renamed from: a */
    Context f1112a;

    /* renamed from: b */
    ActionBarOverlayLayout f1113b;

    /* renamed from: c */
    ActionBarContainer f1114c;

    /* renamed from: d */
    C0606ac f1115d;

    /* renamed from: e */
    ActionBarContextView f1116e;

    /* renamed from: f */
    View f1117f;

    /* renamed from: g */
    C0631an f1118g;

    /* renamed from: h */
    C0487a f1119h;

    /* renamed from: i */
    C0505b f1120i;

    /* renamed from: j */
    C0506a f1121j;

    /* renamed from: k */
    boolean f1122k = true;

    /* renamed from: l */
    boolean f1123l;

    /* renamed from: m */
    boolean f1124m;

    /* renamed from: n */
    C0515h f1125n;

    /* renamed from: o */
    boolean f1126o;

    /* renamed from: p */
    final C0973w f1127p = new C0974x() {
        /* renamed from: b */
        public void mo1029b(View view) {
            if (C0483n.this.f1122k && C0483n.this.f1117f != null) {
                C0483n.this.f1117f.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                C0483n.this.f1114c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            }
            C0483n.this.f1114c.setVisibility(8);
            C0483n.this.f1114c.setTransitioning(false);
            C0483n.this.f1125n = null;
            C0483n.this.mo1085h();
            if (C0483n.this.f1113b != null) {
                C0962r.m3595r(C0483n.this.f1113b);
            }
        }
    };

    /* renamed from: q */
    final C0973w f1128q = new C0974x() {
        /* renamed from: b */
        public void mo1029b(View view) {
            C0483n.this.f1125n = null;
            C0483n.this.f1114c.requestLayout();
        }
    };

    /* renamed from: r */
    final C0975y f1129r = new C0975y() {
        /* renamed from: a */
        public void mo1095a(View view) {
            ((View) C0483n.this.f1114c.getParent()).invalidate();
        }
    };

    /* renamed from: v */
    private Context f1130v;

    /* renamed from: w */
    private Activity f1131w;

    /* renamed from: x */
    private Dialog f1132x;

    /* renamed from: y */
    private ArrayList<Object> f1133y = new ArrayList<>();

    /* renamed from: z */
    private int f1134z = -1;

    /* renamed from: androidx.appcompat.app.n$a */
    /* compiled from: WindowDecorActionBar */
    public class C0487a extends C0505b implements C0534a {

        /* renamed from: b */
        private final Context f1139b;

        /* renamed from: c */
        private final C0533h f1140c;

        /* renamed from: d */
        private C0506a f1141d;

        /* renamed from: e */
        private WeakReference<View> f1142e;

        public C0487a(Context context, C0506a aVar) {
            this.f1139b = context;
            this.f1141d = aVar;
            this.f1140c = new C0533h(context).setDefaultShowAsAction(1);
            this.f1140c.setCallback(this);
        }

        /* renamed from: a */
        public MenuInflater mo1096a() {
            return new C0512g(this.f1139b);
        }

        /* renamed from: b */
        public Menu mo1101b() {
            return this.f1140c;
        }

        /* renamed from: c */
        public void mo1104c() {
            if (C0483n.this.f1119h == this) {
                if (!C0483n.m1497a(C0483n.this.f1123l, C0483n.this.f1124m, false)) {
                    C0483n.this.f1120i = this;
                    C0483n.this.f1121j = this.f1141d;
                } else {
                    this.f1141d.mo1032a(this);
                }
                this.f1141d = null;
                C0483n.this.mo1092k(false);
                C0483n.this.f1116e.mo1779b();
                C0483n.this.f1115d.mo2157a().sendAccessibilityEvent(32);
                C0483n.this.f1113b.setHideOnContentScrollEnabled(C0483n.this.f1126o);
                C0483n.this.f1119h = null;
            }
        }

        /* renamed from: d */
        public void mo1105d() {
            if (C0483n.this.f1119h == this) {
                this.f1140c.stopDispatchingItemsChanged();
                try {
                    this.f1141d.mo1035b(this, this.f1140c);
                } finally {
                    this.f1140c.startDispatchingItemsChanged();
                }
            }
        }

        /* renamed from: e */
        public boolean mo1106e() {
            this.f1140c.stopDispatchingItemsChanged();
            try {
                return this.f1141d.mo1033a((C0505b) this, (Menu) this.f1140c);
            } finally {
                this.f1140c.startDispatchingItemsChanged();
            }
        }

        /* renamed from: a */
        public void mo1098a(View view) {
            C0483n.this.f1116e.setCustomView(view);
            this.f1142e = new WeakReference<>(view);
        }

        /* renamed from: a */
        public void mo1099a(CharSequence charSequence) {
            C0483n.this.f1116e.setSubtitle(charSequence);
        }

        /* renamed from: b */
        public void mo1103b(CharSequence charSequence) {
            C0483n.this.f1116e.setTitle(charSequence);
        }

        /* renamed from: a */
        public void mo1097a(int i) {
            mo1103b((CharSequence) C0483n.this.f1112a.getResources().getString(i));
        }

        /* renamed from: b */
        public void mo1102b(int i) {
            mo1099a((CharSequence) C0483n.this.f1112a.getResources().getString(i));
        }

        /* renamed from: f */
        public CharSequence mo1107f() {
            return C0483n.this.f1116e.getTitle();
        }

        /* renamed from: g */
        public CharSequence mo1108g() {
            return C0483n.this.f1116e.getSubtitle();
        }

        /* renamed from: a */
        public void mo1100a(boolean z) {
            super.mo1100a(z);
            C0483n.this.f1116e.setTitleOptional(z);
        }

        /* renamed from: h */
        public boolean mo1109h() {
            return C0483n.this.f1116e.mo1781d();
        }

        /* renamed from: i */
        public View mo1110i() {
            if (this.f1142e != null) {
                return (View) this.f1142e.get();
            }
            return null;
        }

        public boolean onMenuItemSelected(C0533h hVar, MenuItem menuItem) {
            if (this.f1141d != null) {
                return this.f1141d.mo1034a((C0505b) this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(C0533h hVar) {
            if (this.f1141d != null) {
                mo1105d();
                C0483n.this.f1116e.mo1778a();
            }
        }
    }

    /* renamed from: a */
    static boolean m1497a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    /* renamed from: m */
    public void mo1094m() {
    }

    public C0483n(Activity activity, boolean z) {
        this.f1131w = activity;
        View decorView = activity.getWindow().getDecorView();
        m1496a(decorView);
        if (!z) {
            this.f1117f = decorView.findViewById(16908290);
        }
    }

    public C0483n(Dialog dialog) {
        this.f1132x = dialog;
        m1496a(dialog.getWindow().getDecorView());
    }

    /* renamed from: a */
    private void m1496a(View view) {
        this.f1113b = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        if (this.f1113b != null) {
            this.f1113b.setActionBarVisibilityCallback(this);
        }
        this.f1115d = m1498b(view.findViewById(R.id.action_bar));
        this.f1116e = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.f1114c = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        if (this.f1115d == null || this.f1116e == null || this.f1114c == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" can only be used ");
            sb.append("with a compatible window decor layout");
            throw new IllegalStateException(sb.toString());
        }
        this.f1112a = this.f1115d.mo2167b();
        boolean z = (this.f1115d.mo2185o() & 4) != 0;
        if (z) {
            this.f1104A = true;
        }
        C0504a a = C0504a.m1633a(this.f1112a);
        mo859c(a.mo1247f() || z);
        m1499l(a.mo1245d());
        TypedArray obtainStyledAttributes = this.f1112a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            mo861d(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo850a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private C0606ac m1498b(View view) {
        if (view instanceof C0606ac) {
            return (C0606ac) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public void mo850a(float f) {
        C0962r.m3550a((View) this.f1114c, f);
    }

    /* renamed from: a */
    public void mo851a(Configuration configuration) {
        m1499l(C0504a.m1633a(this.f1112a).mo1245d());
    }

    /* renamed from: l */
    private void m1499l(boolean z) {
        this.f1107D = z;
        if (!this.f1107D) {
            this.f1115d.mo2164a((C0631an) null);
            this.f1114c.setTabContainer(this.f1118g);
        } else {
            this.f1114c.setTabContainer(null);
            this.f1115d.mo2164a(this.f1118g);
        }
        boolean z2 = true;
        boolean z3 = mo1087i() == 2;
        if (this.f1118g != null) {
            if (z3) {
                this.f1118g.setVisibility(0);
                if (this.f1113b != null) {
                    C0962r.m3595r(this.f1113b);
                }
            } else {
                this.f1118g.setVisibility(8);
            }
        }
        this.f1115d.mo2166a(!this.f1107D && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1113b;
        if (this.f1107D || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo1085h() {
        if (this.f1121j != null) {
            this.f1121j.mo1032a(this.f1120i);
            this.f1120i = null;
            this.f1121j = null;
        }
    }

    /* renamed from: a */
    public void mo1083a(int i) {
        this.f1108E = i;
    }

    /* renamed from: f */
    public void mo865f(boolean z) {
        this.f1111H = z;
        if (!z && this.f1125n != null) {
            this.f1125n.mo1296c();
        }
    }

    /* renamed from: g */
    public void mo868g(boolean z) {
        if (z != this.f1105B) {
            this.f1105B = z;
            int size = this.f1106C.size();
            for (int i = 0; i < size; i++) {
                ((C0442b) this.f1106C.get(i)).mo869a(z);
            }
        }
    }

    /* renamed from: a */
    public void mo854a(boolean z) {
        mo1084a(z ? 4 : 0, 4);
    }

    /* renamed from: b */
    public void mo858b(boolean z) {
        mo1084a(z ? 8 : 0, 8);
    }

    /* renamed from: c */
    public void mo859c(boolean z) {
        this.f1115d.mo2170b(z);
    }

    /* renamed from: a */
    public void mo853a(CharSequence charSequence) {
        this.f1115d.mo2165a(charSequence);
    }

    /* renamed from: a */
    public void mo1084a(int i, int i2) {
        int o = this.f1115d.mo2185o();
        if ((i2 & 4) != 0) {
            this.f1104A = true;
        }
        this.f1115d.mo2171c((i & i2) | ((~i2) & o));
    }

    /* renamed from: i */
    public int mo1087i() {
        return this.f1115d.mo2186p();
    }

    /* renamed from: a */
    public int mo848a() {
        return this.f1115d.mo2185o();
    }

    /* renamed from: a */
    public C0505b mo849a(C0506a aVar) {
        if (this.f1119h != null) {
            this.f1119h.mo1104c();
        }
        this.f1113b.setHideOnContentScrollEnabled(false);
        this.f1116e.mo1780c();
        C0487a aVar2 = new C0487a(this.f1116e.getContext(), aVar);
        if (!aVar2.mo1106e()) {
            return null;
        }
        this.f1119h = aVar2;
        aVar2.mo1105d();
        this.f1116e.mo1777a(aVar2);
        mo1092k(true);
        this.f1116e.sendAccessibilityEvent(32);
        return aVar2;
    }

    /* renamed from: h */
    public void mo1086h(boolean z) {
        this.f1122k = z;
    }

    /* renamed from: n */
    private void m1501n() {
        if (!this.f1109F) {
            this.f1109F = true;
            if (this.f1113b != null) {
                this.f1113b.setShowingForActionMode(true);
            }
            m1500m(false);
        }
    }

    /* renamed from: j */
    public void mo1089j() {
        if (this.f1124m) {
            this.f1124m = false;
            m1500m(true);
        }
    }

    /* renamed from: o */
    private void m1502o() {
        if (this.f1109F) {
            this.f1109F = false;
            if (this.f1113b != null) {
                this.f1113b.setShowingForActionMode(false);
            }
            m1500m(false);
        }
    }

    /* renamed from: k */
    public void mo1091k() {
        if (!this.f1124m) {
            this.f1124m = true;
            m1500m(true);
        }
    }

    /* renamed from: d */
    public void mo861d(boolean z) {
        if (!z || this.f1113b.mo1805a()) {
            this.f1126o = z;
            this.f1113b.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* renamed from: m */
    private void m1500m(boolean z) {
        if (m1497a(this.f1123l, this.f1124m, this.f1109F)) {
            if (!this.f1110G) {
                this.f1110G = true;
                mo1088i(z);
            }
        } else if (this.f1110G) {
            this.f1110G = false;
            mo1090j(z);
        }
    }

    /* renamed from: i */
    public void mo1088i(boolean z) {
        if (this.f1125n != null) {
            this.f1125n.mo1296c();
        }
        this.f1114c.setVisibility(0);
        if (this.f1108E != 0 || (!this.f1111H && !z)) {
            this.f1114c.setAlpha(1.0f);
            this.f1114c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            if (this.f1122k && this.f1117f != null) {
                this.f1117f.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            }
            this.f1128q.mo1029b(null);
        } else {
            this.f1114c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            float f = (float) (-this.f1114c.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f1114c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.f1114c.setTranslationY(f);
            C0515h hVar = new C0515h();
            C0969v b = C0962r.m3591n(this.f1114c).mo3768b((float) BitmapDescriptorFactory.HUE_RED);
            b.mo3767a(this.f1129r);
            hVar.mo1291a(b);
            if (this.f1122k && this.f1117f != null) {
                this.f1117f.setTranslationY(f);
                hVar.mo1291a(C0962r.m3591n(this.f1117f).mo3768b((float) BitmapDescriptorFactory.HUE_RED));
            }
            hVar.mo1290a(f1103u);
            hVar.mo1289a(250);
            hVar.mo1293a(this.f1128q);
            this.f1125n = hVar;
            hVar.mo1294a();
        }
        if (this.f1113b != null) {
            C0962r.m3595r(this.f1113b);
        }
    }

    /* renamed from: j */
    public void mo1090j(boolean z) {
        if (this.f1125n != null) {
            this.f1125n.mo1296c();
        }
        if (this.f1108E != 0 || (!this.f1111H && !z)) {
            this.f1127p.mo1029b(null);
            return;
        }
        this.f1114c.setAlpha(1.0f);
        this.f1114c.setTransitioning(true);
        C0515h hVar = new C0515h();
        float f = (float) (-this.f1114c.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f1114c.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        C0969v b = C0962r.m3591n(this.f1114c).mo3768b(f);
        b.mo3767a(this.f1129r);
        hVar.mo1291a(b);
        if (this.f1122k && this.f1117f != null) {
            hVar.mo1291a(C0962r.m3591n(this.f1117f).mo3768b(f));
        }
        hVar.mo1290a(f1102t);
        hVar.mo1289a(250);
        hVar.mo1293a(this.f1127p);
        this.f1125n = hVar;
        hVar.mo1294a();
    }

    /* renamed from: k */
    public void mo1092k(boolean z) {
        C0969v vVar;
        C0969v vVar2;
        if (z) {
            m1501n();
        } else {
            m1502o();
        }
        if (m1503p()) {
            if (z) {
                vVar = this.f1115d.mo2158a(4, 100);
                vVar2 = this.f1116e.mo1776a(0, 200);
            } else {
                vVar2 = this.f1115d.mo2158a(0, 200);
                vVar = this.f1116e.mo1776a(8, 100);
            }
            C0515h hVar = new C0515h();
            hVar.mo1292a(vVar, vVar2);
            hVar.mo1294a();
        } else if (z) {
            this.f1115d.mo2174d(4);
            this.f1116e.setVisibility(0);
        } else {
            this.f1115d.mo2174d(0);
            this.f1116e.setVisibility(8);
        }
    }

    /* renamed from: p */
    private boolean m1503p() {
        return C0962r.m3603z(this.f1114c);
    }

    /* renamed from: b */
    public Context mo857b() {
        if (this.f1130v == null) {
            TypedValue typedValue = new TypedValue();
            this.f1112a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1130v = new ContextThemeWrapper(this.f1112a, i);
            } else {
                this.f1130v = this.f1112a;
            }
        }
        return this.f1130v;
    }

    /* renamed from: a */
    public void mo852a(Drawable drawable) {
        this.f1115d.mo2169b(drawable);
    }

    /* renamed from: l */
    public void mo1093l() {
        if (this.f1125n != null) {
            this.f1125n.mo1296c();
            this.f1125n = null;
        }
    }

    /* renamed from: f */
    public boolean mo866f() {
        if (this.f1115d == null || !this.f1115d.mo2172c()) {
            return false;
        }
        this.f1115d.mo2173d();
        return true;
    }

    /* renamed from: e */
    public void mo863e(boolean z) {
        if (!this.f1104A) {
            mo854a(z);
        }
    }

    /* renamed from: a */
    public boolean mo855a(int i, KeyEvent keyEvent) {
        if (this.f1119h == null) {
            return false;
        }
        Menu b = this.f1119h.mo1101b();
        if (b == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        b.setQwertyMode(z);
        return b.performShortcut(i, keyEvent, 0);
    }
}
