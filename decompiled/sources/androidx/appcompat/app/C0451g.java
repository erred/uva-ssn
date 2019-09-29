package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.C0444b.C0445a;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.view.C0505b;
import androidx.appcompat.view.C0505b.C0506a;
import androidx.appcompat.view.C0508d;
import androidx.appcompat.view.C0510f.C0511a;
import androidx.appcompat.view.C0512g;
import androidx.appcompat.view.C0517i;
import androidx.appcompat.view.menu.C0530f;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0533h.C0534a;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.view.menu.C0551p;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0605ab;
import androidx.appcompat.widget.C0611af;
import androidx.appcompat.widget.C0611af.C0612a;
import androidx.appcompat.widget.C0645av;
import androidx.appcompat.widget.C0655ba;
import androidx.appcompat.widget.C0656bb;
import androidx.appcompat.widget.C0680k;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout.C0574a;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.C0852e;
import androidx.core.p070g.C0947d;
import androidx.core.p070g.C0947d.C0948a;
import androidx.core.p070g.C0949e;
import androidx.core.p070g.C0959o;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0969v;
import androidx.core.p070g.C0973w;
import androidx.core.p070g.C0974x;
import androidx.core.p070g.C0976z;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.appcompat.app.g */
/* compiled from: AppCompatDelegateImpl */
class C0451g extends C0450f implements Factory2, C0534a {

    /* renamed from: u */
    private static final boolean f977u = (VERSION.SDK_INT < 21);

    /* renamed from: v */
    private static final int[] f978v = {16842836};

    /* renamed from: w */
    private static boolean f979w = true;

    /* renamed from: A */
    private C0469h f980A;

    /* renamed from: B */
    private boolean f981B = true;

    /* renamed from: C */
    private boolean f982C;

    /* renamed from: D */
    private ViewGroup f983D;

    /* renamed from: E */
    private TextView f984E;

    /* renamed from: F */
    private View f985F;

    /* renamed from: G */
    private boolean f986G;

    /* renamed from: H */
    private boolean f987H;

    /* renamed from: I */
    private boolean f988I;

    /* renamed from: J */
    private C0468g[] f989J;

    /* renamed from: K */
    private C0468g f990K;

    /* renamed from: L */
    private boolean f991L;

    /* renamed from: M */
    private int f992M = -100;

    /* renamed from: N */
    private boolean f993N;

    /* renamed from: O */
    private C0465e f994O;

    /* renamed from: P */
    private final Runnable f995P = new Runnable() {
        public void run() {
            if ((C0451g.this.f1019t & 1) != 0) {
                C0451g.this.mo1005g(0);
            }
            if ((C0451g.this.f1019t & 4096) != 0) {
                C0451g.this.mo1005g(108);
            }
            C0451g.this.f1018s = false;
            C0451g.this.f1019t = 0;
        }
    };

    /* renamed from: Q */
    private boolean f996Q;

    /* renamed from: R */
    private Rect f997R;

    /* renamed from: S */
    private Rect f998S;

    /* renamed from: T */
    private AppCompatViewInflater f999T;

    /* renamed from: a */
    final Context f1000a;

    /* renamed from: b */
    final Window f1001b;

    /* renamed from: c */
    final Callback f1002c;

    /* renamed from: d */
    final Callback f1003d;

    /* renamed from: e */
    final C0449e f1004e;

    /* renamed from: f */
    C0440a f1005f;

    /* renamed from: g */
    MenuInflater f1006g;

    /* renamed from: h */
    C0505b f1007h;

    /* renamed from: i */
    ActionBarContextView f1008i;

    /* renamed from: j */
    PopupWindow f1009j;

    /* renamed from: k */
    Runnable f1010k;

    /* renamed from: l */
    C0969v f1011l = null;

    /* renamed from: m */
    boolean f1012m;

    /* renamed from: n */
    boolean f1013n;

    /* renamed from: o */
    boolean f1014o;

    /* renamed from: p */
    boolean f1015p;

    /* renamed from: q */
    boolean f1016q;

    /* renamed from: r */
    boolean f1017r;

    /* renamed from: s */
    boolean f1018s;

    /* renamed from: t */
    int f1019t;

    /* renamed from: x */
    private CharSequence f1020x;

    /* renamed from: y */
    private C0605ab f1021y;

    /* renamed from: z */
    private C0461b f1022z;

    /* renamed from: androidx.appcompat.app.g$a */
    /* compiled from: AppCompatDelegateImpl */
    private class C0460a implements C0445a {
        C0460a() {
        }
    }

    /* renamed from: androidx.appcompat.app.g$b */
    /* compiled from: AppCompatDelegateImpl */
    private final class C0461b implements C0550a {
        C0461b() {
        }

        /* renamed from: a */
        public boolean mo1031a(C0533h hVar) {
            Callback m = C0451g.this.mo1009m();
            if (m != null) {
                m.onMenuOpened(108, hVar);
            }
            return true;
        }

        /* renamed from: a */
        public void mo1030a(C0533h hVar, boolean z) {
            C0451g.this.mo996a(hVar);
        }
    }

    /* renamed from: androidx.appcompat.app.g$c */
    /* compiled from: AppCompatDelegateImpl */
    class C0462c implements C0506a {

        /* renamed from: b */
        private C0506a f1034b;

        public C0462c(C0506a aVar) {
            this.f1034b = aVar;
        }

        /* renamed from: a */
        public boolean mo1033a(C0505b bVar, Menu menu) {
            return this.f1034b.mo1033a(bVar, menu);
        }

        /* renamed from: b */
        public boolean mo1035b(C0505b bVar, Menu menu) {
            return this.f1034b.mo1035b(bVar, menu);
        }

        /* renamed from: a */
        public boolean mo1034a(C0505b bVar, MenuItem menuItem) {
            return this.f1034b.mo1034a(bVar, menuItem);
        }

        /* renamed from: a */
        public void mo1032a(C0505b bVar) {
            this.f1034b.mo1032a(bVar);
            if (C0451g.this.f1009j != null) {
                C0451g.this.f1001b.getDecorView().removeCallbacks(C0451g.this.f1010k);
            }
            if (C0451g.this.f1008i != null) {
                C0451g.this.mo1018r();
                C0451g.this.f1011l = C0962r.m3591n(C0451g.this.f1008i).mo3763a((float) BitmapDescriptorFactory.HUE_RED);
                C0451g.this.f1011l.mo3766a((C0973w) new C0974x() {
                    /* renamed from: b */
                    public void mo1029b(View view) {
                        C0451g.this.f1008i.setVisibility(8);
                        if (C0451g.this.f1009j != null) {
                            C0451g.this.f1009j.dismiss();
                        } else if (C0451g.this.f1008i.getParent() instanceof View) {
                            C0962r.m3595r((View) C0451g.this.f1008i.getParent());
                        }
                        C0451g.this.f1008i.removeAllViews();
                        C0451g.this.f1011l.mo3766a((C0973w) null);
                        C0451g.this.f1011l = null;
                    }
                });
            }
            if (C0451g.this.f1004e != null) {
                C0451g.this.f1004e.onSupportActionModeFinished(C0451g.this.f1007h);
            }
            C0451g.this.f1007h = null;
        }
    }

    /* renamed from: androidx.appcompat.app.g$d */
    /* compiled from: AppCompatDelegateImpl */
    class C0464d extends C0517i {
        public void onContentChanged() {
        }

        C0464d(Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C0451g.this.mo998a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || C0451g.this.mo997a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0533h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0533h hVar = menu instanceof C0533h ? (C0533h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            C0451g.this.mo1003e(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            C0451g.this.mo1002d(i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (VERSION.SDK_INT >= 23) {
                return null;
            }
            if (C0451g.this.mo1017q()) {
                return mo1036a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final ActionMode mo1036a(ActionMode.Callback callback) {
            C0511a aVar = new C0511a(C0451g.this.f1000a, callback);
            C0505b a = C0451g.this.mo969a((C0506a) aVar);
            if (a != null) {
                return aVar.mo1279b(a);
            }
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!C0451g.this.mo1017q() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return mo1036a(callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C0468g a = C0451g.this.mo991a(0, true);
            if (a == null || a.f1053j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a.f1053j, i);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.g$e */
    /* compiled from: AppCompatDelegateImpl */
    final class C0465e {

        /* renamed from: b */
        private C0481m f1038b;

        /* renamed from: c */
        private boolean f1039c;

        /* renamed from: d */
        private BroadcastReceiver f1040d;

        /* renamed from: e */
        private IntentFilter f1041e;

        C0465e(C0481m mVar) {
            this.f1038b = mVar;
            this.f1039c = mVar.mo1082a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1047a() {
            this.f1039c = this.f1038b.mo1082a();
            return this.f1039c ? 2 : 1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo1048b() {
            boolean a = this.f1038b.mo1082a();
            if (a != this.f1039c) {
                this.f1039c = a;
                C0451g.this.mo989j();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo1049c() {
            mo1050d();
            if (this.f1040d == null) {
                this.f1040d = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        C0465e.this.mo1048b();
                    }
                };
            }
            if (this.f1041e == null) {
                this.f1041e = new IntentFilter();
                this.f1041e.addAction("android.intent.action.TIME_SET");
                this.f1041e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f1041e.addAction("android.intent.action.TIME_TICK");
            }
            C0451g.this.f1000a.registerReceiver(this.f1040d, this.f1041e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo1050d() {
            if (this.f1040d != null) {
                C0451g.this.f1000a.unregisterReceiver(this.f1040d);
                this.f1040d = null;
            }
        }
    }

    /* renamed from: androidx.appcompat.app.g$f */
    /* compiled from: AppCompatDelegateImpl */
    private class C0467f extends ContentFrameLayout {
        public C0467f(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C0451g.this.mo998a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m1450a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            C0451g.this.mo1004f(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0424a.m1270b(getContext(), i));
        }

        /* renamed from: a */
        private boolean m1450a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* renamed from: androidx.appcompat.app.g$g */
    /* compiled from: AppCompatDelegateImpl */
    protected static final class C0468g {

        /* renamed from: a */
        int f1044a;

        /* renamed from: b */
        int f1045b;

        /* renamed from: c */
        int f1046c;

        /* renamed from: d */
        int f1047d;

        /* renamed from: e */
        int f1048e;

        /* renamed from: f */
        int f1049f;

        /* renamed from: g */
        ViewGroup f1050g;

        /* renamed from: h */
        View f1051h;

        /* renamed from: i */
        View f1052i;

        /* renamed from: j */
        C0533h f1053j;

        /* renamed from: k */
        C0530f f1054k;

        /* renamed from: l */
        Context f1055l;

        /* renamed from: m */
        boolean f1056m;

        /* renamed from: n */
        boolean f1057n;

        /* renamed from: o */
        boolean f1058o;

        /* renamed from: p */
        public boolean f1059p;

        /* renamed from: q */
        boolean f1060q = false;

        /* renamed from: r */
        boolean f1061r;

        /* renamed from: s */
        Bundle f1062s;

        C0468g(int i) {
            this.f1044a = i;
        }

        /* renamed from: a */
        public boolean mo1058a() {
            boolean z = false;
            if (this.f1051h == null) {
                return false;
            }
            if (this.f1052i != null) {
                return true;
            }
            if (this.f1054k.mo1457a().getCount() > 0) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo1056a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            C0508d dVar = new C0508d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f1055l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f1045b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f1049f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo1057a(C0533h hVar) {
            if (hVar != this.f1053j) {
                if (this.f1053j != null) {
                    this.f1053j.removeMenuPresenter(this.f1054k);
                }
                this.f1053j = hVar;
                if (!(hVar == null || this.f1054k == null)) {
                    hVar.addMenuPresenter(this.f1054k);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0551p mo1055a(C0550a aVar) {
            if (this.f1053j == null) {
                return null;
            }
            if (this.f1054k == null) {
                this.f1054k = new C0530f(this.f1055l, R.layout.abc_list_menu_item_layout);
                this.f1054k.setCallback(aVar);
                this.f1053j.addMenuPresenter(this.f1054k);
            }
            return this.f1054k.mo1458a(this.f1050g);
        }
    }

    /* renamed from: androidx.appcompat.app.g$h */
    /* compiled from: AppCompatDelegateImpl */
    private final class C0469h implements C0550a {
        C0469h() {
        }

        /* renamed from: a */
        public void mo1030a(C0533h hVar, boolean z) {
            C0533h rootMenu = hVar.getRootMenu();
            boolean z2 = rootMenu != hVar;
            C0451g gVar = C0451g.this;
            if (z2) {
                hVar = rootMenu;
            }
            C0468g a = gVar.mo992a((Menu) hVar);
            if (a == null) {
                return;
            }
            if (z2) {
                C0451g.this.mo993a(a.f1044a, a, rootMenu);
                C0451g.this.mo995a(a, true);
                return;
            }
            C0451g.this.mo995a(a, z);
        }

        /* renamed from: a */
        public boolean mo1031a(C0533h hVar) {
            if (hVar == null && C0451g.this.f1012m) {
                Callback m = C0451g.this.mo1009m();
                if (m != null && !C0451g.this.f1017r) {
                    m.onMenuOpened(108, hVar);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo994a(ViewGroup viewGroup) {
    }

    static {
        if (f977u && !f979w) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    if (m1430a(th)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(th.getMessage());
                        sb.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        NotFoundException notFoundException = new NotFoundException(sb.toString());
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                /* renamed from: a */
                private boolean m1430a(Throwable th) {
                    boolean z = false;
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    if (message != null && (message.contains("drawable") || message.contains("Drawable"))) {
                        z = true;
                    }
                    return z;
                }
            });
        }
    }

    C0451g(Context context, Window window, C0449e eVar) {
        this.f1000a = context;
        this.f1001b = window;
        this.f1004e = eVar;
        this.f1002c = this.f1001b.getCallback();
        if (!(this.f1002c instanceof C0464d)) {
            this.f1003d = new C0464d(this.f1002c);
            this.f1001b.setCallback(this.f1003d);
            C0645av a = C0645av.m2229a(context, (AttributeSet) null, f978v);
            Drawable b = a.mo2454b(0);
            if (b != null) {
                this.f1001b.setBackgroundDrawable(b);
            }
            a.mo2450a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* renamed from: a */
    public void mo971a(Bundle bundle) {
        if (this.f1002c instanceof Activity) {
            String str = null;
            try {
                str = C0852e.m3114b((Activity) this.f1002c);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                C0440a l = mo1008l();
                if (l == null) {
                    this.f996Q = true;
                } else {
                    l.mo863e(true);
                }
            }
        }
        if (bundle != null && this.f992M == -100) {
            this.f992M = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* renamed from: b */
    public void mo978b(Bundle bundle) {
        m1375v();
    }

    /* renamed from: a */
    public C0440a mo968a() {
        m1374u();
        return this.f1005f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public final C0440a mo1008l() {
        return this.f1005f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public final Callback mo1009m() {
        return this.f1001b.getCallback();
    }

    /* renamed from: u */
    private void m1374u() {
        m1375v();
        if (this.f1012m && this.f1005f == null) {
            if (this.f1002c instanceof Activity) {
                this.f1005f = new C0483n((Activity) this.f1002c, this.f1013n);
            } else if (this.f1002c instanceof Dialog) {
                this.f1005f = new C0483n((Dialog) this.f1002c);
            }
            if (this.f1005f != null) {
                this.f1005f.mo863e(this.f996Q);
            }
        }
    }

    /* renamed from: a */
    public void mo974a(Toolbar toolbar) {
        if (this.f1002c instanceof Activity) {
            C0440a a = mo968a();
            if (!(a instanceof C0483n)) {
                this.f1006g = null;
                if (a != null) {
                    a.mo867g();
                }
                if (toolbar != null) {
                    C0474k kVar = new C0474k(toolbar, ((Activity) this.f1002c).getTitle(), this.f1003d);
                    this.f1005f = kVar;
                    this.f1001b.setCallback(kVar.mo1076h());
                } else {
                    this.f1005f = null;
                    this.f1001b.setCallback(this.f1003d);
                }
                mo985f();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final Context mo1010n() {
        C0440a a = mo968a();
        Context b = a != null ? a.mo857b() : null;
        return b == null ? this.f1000a : b;
    }

    /* renamed from: b */
    public MenuInflater mo976b() {
        if (this.f1006g == null) {
            m1374u();
            this.f1006g = new C0512g(this.f1005f != null ? this.f1005f.mo857b() : this.f1000a);
        }
        return this.f1006g;
    }

    /* renamed from: a */
    public <T extends View> T mo967a(int i) {
        m1375v();
        return this.f1001b.findViewById(i);
    }

    /* renamed from: a */
    public void mo970a(Configuration configuration) {
        if (this.f1012m && this.f982C) {
            C0440a a = mo968a();
            if (a != null) {
                a.mo851a(configuration);
            }
        }
        C0680k.m2397a().mo2593a(this.f1000a);
        mo989j();
    }

    /* renamed from: c */
    public void mo980c() {
        mo989j();
    }

    /* renamed from: d */
    public void mo983d() {
        C0440a a = mo968a();
        if (a != null) {
            a.mo865f(false);
        }
        if (this.f994O != null) {
            this.f994O.mo1050d();
        }
    }

    /* renamed from: e */
    public void mo984e() {
        C0440a a = mo968a();
        if (a != null) {
            a.mo865f(true);
        }
    }

    /* renamed from: a */
    public void mo972a(View view) {
        m1375v();
        ViewGroup viewGroup = (ViewGroup) this.f983D.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1002c.onContentChanged();
    }

    /* renamed from: b */
    public void mo977b(int i) {
        m1375v();
        ViewGroup viewGroup = (ViewGroup) this.f983D.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1000a).inflate(i, viewGroup);
        this.f1002c.onContentChanged();
    }

    /* renamed from: a */
    public void mo973a(View view, LayoutParams layoutParams) {
        m1375v();
        ViewGroup viewGroup = (ViewGroup) this.f983D.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1002c.onContentChanged();
    }

    /* renamed from: b */
    public void mo979b(View view, LayoutParams layoutParams) {
        m1375v();
        ((ViewGroup) this.f983D.findViewById(16908290)).addView(view, layoutParams);
        this.f1002c.onContentChanged();
    }

    /* renamed from: c */
    public void mo981c(Bundle bundle) {
        if (this.f992M != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f992M);
        }
    }

    /* renamed from: g */
    public void mo986g() {
        if (this.f1018s) {
            this.f1001b.getDecorView().removeCallbacks(this.f995P);
        }
        this.f1017r = true;
        if (this.f1005f != null) {
            this.f1005f.mo867g();
        }
        if (this.f994O != null) {
            this.f994O.mo1050d();
        }
    }

    /* renamed from: v */
    private void m1375v() {
        if (!this.f982C) {
            this.f983D = m1376w();
            CharSequence o = mo1011o();
            if (!TextUtils.isEmpty(o)) {
                if (this.f1021y != null) {
                    this.f1021y.setWindowTitle(o);
                } else if (mo1008l() != null) {
                    mo1008l().mo853a(o);
                } else if (this.f984E != null) {
                    this.f984E.setText(o);
                }
            }
            m1377x();
            mo994a(this.f983D);
            this.f982C = true;
            C0468g a = mo991a(0, false);
            if (this.f1017r) {
                return;
            }
            if (a == null || a.f1053j == null) {
                m1371j(108);
            }
        }
    }

    /* renamed from: w */
    private ViewGroup m1376w() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f1000a.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                mo982c(1);
            } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                mo982c(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                mo982c(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                mo982c(10);
            }
            this.f1015p = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f1001b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f1000a);
            if (this.f1016q) {
                if (this.f1014o) {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    C0962r.m3560a((View) viewGroup, (C0959o) new C0959o() {
                        public C0976z onApplyWindowInsets(View view, C0976z zVar) {
                            int b = zVar.mo3778b();
                            int h = C0451g.this.mo1006h(b);
                            if (b != h) {
                                zVar = zVar.mo3777a(zVar.mo3776a(), h, zVar.mo3779c(), zVar.mo3780d());
                            }
                            return C0962r.m3549a(view, zVar);
                        }
                    });
                } else {
                    ((C0611af) viewGroup).setOnFitSystemWindowsListener(new C0612a() {
                        /* renamed from: a */
                        public void mo1024a(Rect rect) {
                            rect.top = C0451g.this.mo1006h(rect.top);
                        }
                    });
                }
            } else if (this.f1015p) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, null);
                this.f1013n = false;
                this.f1012m = false;
            } else if (this.f1012m) {
                TypedValue typedValue = new TypedValue();
                this.f1000a.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new C0508d(this.f1000a, typedValue.resourceId);
                } else {
                    context = this.f1000a;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, null);
                this.f1021y = (C0605ab) viewGroup.findViewById(R.id.decor_content_parent);
                this.f1021y.setWindowCallback(mo1009m());
                if (this.f1013n) {
                    this.f1021y.mo1803a(109);
                }
                if (this.f986G) {
                    this.f1021y.mo1803a(2);
                }
                if (this.f987H) {
                    this.f1021y.mo1803a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.f1021y == null) {
                    this.f984E = (TextView) viewGroup.findViewById(R.id.title);
                }
                C0656bb.m2315b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f1001b.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f1001b.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new C0574a() {
                    /* renamed from: a */
                    public void mo1025a() {
                    }

                    /* renamed from: b */
                    public void mo1026b() {
                        C0451g.this.mo1020t();
                    }
                });
                return viewGroup;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AppCompat does not support the current theme features: { windowActionBar: ");
            sb.append(this.f1012m);
            sb.append(", windowActionBarOverlay: ");
            sb.append(this.f1013n);
            sb.append(", android:windowIsFloating: ");
            sb.append(this.f1015p);
            sb.append(", windowActionModeOverlay: ");
            sb.append(this.f1014o);
            sb.append(", windowNoTitle: ");
            sb.append(this.f1016q);
            sb.append(" }");
            throw new IllegalArgumentException(sb.toString());
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: x */
    private void m1377x() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f983D.findViewById(16908290);
        View decorView = this.f1001b.getDecorView();
        contentFrameLayout.mo1927a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f1000a.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: c */
    public boolean mo982c(int i) {
        int k = m1372k(i);
        if (this.f1016q && k == 108) {
            return false;
        }
        if (this.f1012m && k == 1) {
            this.f1012m = false;
        }
        switch (k) {
            case 1:
                m1378y();
                this.f1016q = true;
                return true;
            case 2:
                m1378y();
                this.f986G = true;
                return true;
            case 5:
                m1378y();
                this.f987H = true;
                return true;
            case 10:
                m1378y();
                this.f1014o = true;
                return true;
            case 108:
                m1378y();
                this.f1012m = true;
                return true;
            case 109:
                m1378y();
                this.f1013n = true;
                return true;
            default:
                return this.f1001b.requestFeature(k);
        }
    }

    /* renamed from: a */
    public final void mo975a(CharSequence charSequence) {
        this.f1020x = charSequence;
        if (this.f1021y != null) {
            this.f1021y.setWindowTitle(charSequence);
        } else if (mo1008l() != null) {
            mo1008l().mo853a(charSequence);
        } else if (this.f984E != null) {
            this.f984E.setText(charSequence);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final CharSequence mo1011o() {
        if (this.f1002c instanceof Activity) {
            return ((Activity) this.f1002c).getTitle();
        }
        return this.f1020x;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo1002d(int i) {
        if (i == 108) {
            C0440a a = mo968a();
            if (a != null) {
                a.mo868g(false);
            }
        } else if (i == 0) {
            C0468g a2 = mo991a(i, true);
            if (a2.f1058o) {
                mo995a(a2, false);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo1003e(int i) {
        if (i == 108) {
            C0440a a = mo968a();
            if (a != null) {
                a.mo868g(true);
            }
        }
    }

    public boolean onMenuItemSelected(C0533h hVar, MenuItem menuItem) {
        Callback m = mo1009m();
        if (m != null && !this.f1017r) {
            C0468g a = mo992a((Menu) hVar.getRootMenu());
            if (a != null) {
                return m.onMenuItemSelected(a.f1044a, menuItem);
            }
        }
        return false;
    }

    public void onMenuModeChange(C0533h hVar) {
        m1362a(hVar, true);
    }

    /* renamed from: a */
    public C0505b mo969a(C0506a aVar) {
        if (aVar != null) {
            if (this.f1007h != null) {
                this.f1007h.mo1104c();
            }
            C0462c cVar = new C0462c(aVar);
            C0440a a = mo968a();
            if (a != null) {
                this.f1007h = a.mo849a((C0506a) cVar);
                if (!(this.f1007h == null || this.f1004e == null)) {
                    this.f1004e.onSupportActionModeStarted(this.f1007h);
                }
            }
            if (this.f1007h == null) {
                this.f1007h = mo999b((C0506a) cVar);
            }
            return this.f1007h;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* renamed from: f */
    public void mo985f() {
        C0440a a = mo968a();
        if (a == null || !a.mo864e()) {
            m1371j(0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.C0505b mo999b(androidx.appcompat.view.C0505b.C0506a r8) {
        /*
            r7 = this;
            r7.mo1018r()
            androidx.appcompat.view.b r0 = r7.f1007h
            if (r0 == 0) goto L_0x000c
            androidx.appcompat.view.b r0 = r7.f1007h
            r0.mo1104c()
        L_0x000c:
            boolean r0 = r8 instanceof androidx.appcompat.app.C0451g.C0462c
            if (r0 != 0) goto L_0x0016
            androidx.appcompat.app.g$c r0 = new androidx.appcompat.app.g$c
            r0.<init>(r8)
            r8 = r0
        L_0x0016:
            androidx.appcompat.app.e r0 = r7.f1004e
            r1 = 0
            if (r0 == 0) goto L_0x0026
            boolean r0 = r7.f1017r
            if (r0 != 0) goto L_0x0026
            androidx.appcompat.app.e r0 = r7.f1004e     // Catch:{ AbstractMethodError -> 0x0026 }
            androidx.appcompat.view.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0026 }
            goto L_0x0027
        L_0x0026:
            r0 = r1
        L_0x0027:
            if (r0 == 0) goto L_0x002d
            r7.f1007h = r0
            goto L_0x016a
        L_0x002d:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f1008i
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00da
            boolean r0 = r7.f1015p
            if (r0 == 0) goto L_0x00bb
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f1000a
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x006c
            android.content.Context r5 = r7.f1000a
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.d r4 = new androidx.appcompat.view.d
            android.content.Context r6 = r7.f1000a
            r4.<init>(r6, r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006e
        L_0x006c:
            android.content.Context r4 = r7.f1000a
        L_0x006e:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f1008i = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f1009j = r5
            android.widget.PopupWindow r5 = r7.f1009j
            r6 = 2
            androidx.core.widget.C1012h.m3857a(r5, r6)
            android.widget.PopupWindow r5 = r7.f1009j
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f1008i
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f1009j
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f1008i
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f1009j
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.g$6 r0 = new androidx.appcompat.app.g$6
            r0.<init>()
            r7.f1010k = r0
            goto L_0x00da
        L_0x00bb:
            android.view.ViewGroup r0 = r7.f983D
            int r4 = androidx.appcompat.R.id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00da
            android.content.Context r4 = r7.mo1010n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.mo2127a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f1008i = r0
        L_0x00da:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f1008i
            if (r0 == 0) goto L_0x016a
            r7.mo1018r()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f1008i
            r0.mo1780c()
            androidx.appcompat.view.e r0 = new androidx.appcompat.view.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f1008i
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f1008i
            android.widget.PopupWindow r6 = r7.f1009j
            if (r6 != 0) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r3 = 0
        L_0x00f6:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.mo1101b()
            boolean r8 = r8.mo1033a(r0, r3)
            if (r8 == 0) goto L_0x0168
            r0.mo1105d()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            r8.mo1777a(r0)
            r7.f1007h = r0
            boolean r8 = r7.mo1016p()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x0132
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            androidx.core.g.v r8 = androidx.core.p070g.C0962r.m3591n(r8)
            androidx.core.g.v r8 = r8.mo3763a(r0)
            r7.f1011l = r8
            androidx.core.g.v r8 = r7.f1011l
            androidx.appcompat.app.g$7 r0 = new androidx.appcompat.app.g$7
            r0.<init>()
            r8.mo3766a(r0)
            goto L_0x0158
        L_0x0132:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0158
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f1008i
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.p070g.C0962r.m3595r(r8)
        L_0x0158:
            android.widget.PopupWindow r8 = r7.f1009j
            if (r8 == 0) goto L_0x016a
            android.view.Window r8 = r7.f1001b
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f1010k
            r8.post(r0)
            goto L_0x016a
        L_0x0168:
            r7.f1007h = r1
        L_0x016a:
            androidx.appcompat.view.b r8 = r7.f1007h
            if (r8 == 0) goto L_0x0179
            androidx.appcompat.app.e r8 = r7.f1004e
            if (r8 == 0) goto L_0x0179
            androidx.appcompat.app.e r8 = r7.f1004e
            androidx.appcompat.view.b r0 = r7.f1007h
            r8.onSupportActionModeStarted(r0)
        L_0x0179:
            androidx.appcompat.view.b r8 = r7.f1007h
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0451g.mo999b(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public final boolean mo1016p() {
        return this.f982C && this.f983D != null && C0962r.m3603z(this.f983D);
    }

    /* renamed from: q */
    public boolean mo1017q() {
        return this.f981B;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public void mo1018r() {
        if (this.f1011l != null) {
            this.f1011l.mo3770b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public boolean mo1019s() {
        if (this.f1007h != null) {
            this.f1007h.mo1104c();
            return true;
        }
        C0440a a = mo968a();
        if (a == null || !a.mo866f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo997a(int i, KeyEvent keyEvent) {
        C0440a a = mo968a();
        if (a != null && a.mo855a(i, keyEvent)) {
            return true;
        }
        if (this.f990K == null || !m1365a(this.f990K, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f990K == null) {
                C0468g a2 = mo991a(0, true);
                m1367b(a2, keyEvent);
                boolean a3 = m1365a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1056m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        if (this.f990K != null) {
            this.f990K.f1057n = true;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo998a(KeyEvent keyEvent) {
        boolean z = true;
        if ((this.f1002c instanceof C0948a) || (this.f1002c instanceof C0470h)) {
            View decorView = this.f1001b.getDecorView();
            if (decorView != null && C0947d.m3499a(decorView, keyEvent)) {
                return true;
            }
        }
        if (keyEvent.getKeyCode() == 82 && this.f1002c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo1001c(keyCode, keyEvent) : mo1000b(keyCode, keyEvent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo1000b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f991L;
            this.f991L = false;
            C0468g a = mo991a(0, false);
            if (a != null && a.f1058o) {
                if (!z) {
                    mo995a(a, true);
                }
                return true;
            } else if (mo1019s()) {
                return true;
            }
        } else if (i == 82) {
            m1370e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo1001c(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.f991L = z;
        } else if (i == 82) {
            m1369d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public View mo990a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.f999T == null) {
            String string = this.f1000a.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f999T = new AppCompatViewInflater();
            } else {
                try {
                    this.f999T = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    Log.i("AppCompatDelegate", sb.toString(), th);
                    this.f999T = new AppCompatViewInflater();
                }
            }
        }
        if (f977u) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = m1363a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.f999T.createView(view, str, context, attributeSet, z, f977u, true, C0655ba.m2310a());
    }

    /* renamed from: a */
    private boolean m1363a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1001b.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || C0962r.m3543C((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* renamed from: i */
    public void mo988i() {
        LayoutInflater from = LayoutInflater.from(this.f1000a);
        if (from.getFactory() == null) {
            C0949e.m3501a(from, this);
        } else if (!(from.getFactory2() instanceof C0451g)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return mo990a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* renamed from: a */
    private void m1361a(C0468g gVar, KeyEvent keyEvent) {
        int i;
        if (!gVar.f1058o && !this.f1017r) {
            if (gVar.f1044a == 0) {
                if ((this.f1000a.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Callback m = mo1009m();
            if (m == null || m.onMenuOpened(gVar.f1044a, gVar.f1053j)) {
                WindowManager windowManager = (WindowManager) this.f1000a.getSystemService("window");
                if (windowManager != null && m1367b(gVar, keyEvent)) {
                    if (gVar.f1050g == null || gVar.f1060q) {
                        if (gVar.f1050g == null) {
                            if (!m1364a(gVar) || gVar.f1050g == null) {
                                return;
                            }
                        } else if (gVar.f1060q && gVar.f1050g.getChildCount() > 0) {
                            gVar.f1050g.removeAllViews();
                        }
                        if (m1368c(gVar) && gVar.mo1058a()) {
                            LayoutParams layoutParams = gVar.f1051h.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams = new LayoutParams(-2, -2);
                            }
                            gVar.f1050g.setBackgroundResource(gVar.f1045b);
                            ViewParent parent = gVar.f1051h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(gVar.f1051h);
                            }
                            gVar.f1050g.addView(gVar.f1051h, layoutParams);
                            if (!gVar.f1051h.hasFocus()) {
                                gVar.f1051h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (gVar.f1052i != null) {
                        LayoutParams layoutParams2 = gVar.f1052i.getLayoutParams();
                        if (layoutParams2 != null && layoutParams2.width == -1) {
                            i = -1;
                            gVar.f1057n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, gVar.f1047d, gVar.f1048e, 1002, 8519680, -3);
                            layoutParams3.gravity = gVar.f1046c;
                            layoutParams3.windowAnimations = gVar.f1049f;
                            windowManager.addView(gVar.f1050g, layoutParams3);
                            gVar.f1058o = true;
                            return;
                        }
                    }
                    i = -2;
                    gVar.f1057n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, gVar.f1047d, gVar.f1048e, 1002, 8519680, -3);
                    layoutParams32.gravity = gVar.f1046c;
                    layoutParams32.windowAnimations = gVar.f1049f;
                    windowManager.addView(gVar.f1050g, layoutParams32);
                    gVar.f1058o = true;
                    return;
                }
                return;
            }
            mo995a(gVar, true);
        }
    }

    /* renamed from: a */
    private boolean m1364a(C0468g gVar) {
        gVar.mo1056a(mo1010n());
        gVar.f1050g = new C0467f(gVar.f1055l);
        gVar.f1046c = 81;
        return true;
    }

    /* renamed from: a */
    private void m1362a(C0533h hVar, boolean z) {
        if (this.f1021y == null || !this.f1021y.mo1811e() || (ViewConfiguration.get(this.f1000a).hasPermanentMenuKey() && !this.f1021y.mo1814g())) {
            C0468g a = mo991a(0, true);
            a.f1060q = true;
            mo995a(a, false);
            m1361a(a, (KeyEvent) null);
            return;
        }
        Callback m = mo1009m();
        if (this.f1021y.mo1812f() && z) {
            this.f1021y.mo1822i();
            if (!this.f1017r) {
                m.onPanelClosed(108, mo991a(0, true).f1053j);
            }
        } else if (m != null && !this.f1017r) {
            if (this.f1018s && (this.f1019t & 1) != 0) {
                this.f1001b.getDecorView().removeCallbacks(this.f995P);
                this.f995P.run();
            }
            C0468g a2 = mo991a(0, true);
            if (a2.f1053j != null && !a2.f1061r && m.onPreparePanel(0, a2.f1052i, a2.f1053j)) {
                m.onMenuOpened(108, a2.f1053j);
                this.f1021y.mo1821h();
            }
        }
    }

    /* renamed from: b */
    private boolean m1366b(C0468g gVar) {
        Context context = this.f1000a;
        if ((gVar.f1044a == 0 || gVar.f1044a == 108) && this.f1021y != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                Context dVar = new C0508d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        C0533h hVar = new C0533h(context);
        hVar.setCallback(this);
        gVar.mo1057a(hVar);
        return true;
    }

    /* renamed from: c */
    private boolean m1368c(C0468g gVar) {
        boolean z = true;
        if (gVar.f1052i != null) {
            gVar.f1051h = gVar.f1052i;
            return true;
        } else if (gVar.f1053j == null) {
            return false;
        } else {
            if (this.f980A == null) {
                this.f980A = new C0469h();
            }
            gVar.f1051h = (View) gVar.mo1055a((C0550a) this.f980A);
            if (gVar.f1051h == null) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b */
    private boolean m1367b(C0468g gVar, KeyEvent keyEvent) {
        if (this.f1017r) {
            return false;
        }
        if (gVar.f1056m) {
            return true;
        }
        if (!(this.f990K == null || this.f990K == gVar)) {
            mo995a(this.f990K, false);
        }
        Callback m = mo1009m();
        if (m != null) {
            gVar.f1052i = m.onCreatePanelView(gVar.f1044a);
        }
        boolean z = gVar.f1044a == 0 || gVar.f1044a == 108;
        if (z && this.f1021y != null) {
            this.f1021y.mo1823j();
        }
        if (gVar.f1052i == null && (!z || !(mo1008l() instanceof C0474k))) {
            if (gVar.f1053j == null || gVar.f1061r) {
                if (gVar.f1053j == null && (!m1366b(gVar) || gVar.f1053j == null)) {
                    return false;
                }
                if (z && this.f1021y != null) {
                    if (this.f1022z == null) {
                        this.f1022z = new C0461b();
                    }
                    this.f1021y.mo1804a(gVar.f1053j, this.f1022z);
                }
                gVar.f1053j.stopDispatchingItemsChanged();
                if (!m.onCreatePanelMenu(gVar.f1044a, gVar.f1053j)) {
                    gVar.mo1057a((C0533h) null);
                    if (z && this.f1021y != null) {
                        this.f1021y.mo1804a(null, this.f1022z);
                    }
                    return false;
                }
                gVar.f1061r = false;
            }
            gVar.f1053j.stopDispatchingItemsChanged();
            if (gVar.f1062s != null) {
                gVar.f1053j.restoreActionViewStates(gVar.f1062s);
                gVar.f1062s = null;
            }
            if (!m.onPreparePanel(0, gVar.f1052i, gVar.f1053j)) {
                if (z && this.f1021y != null) {
                    this.f1021y.mo1804a(null, this.f1022z);
                }
                gVar.f1053j.startDispatchingItemsChanged();
                return false;
            }
            gVar.f1059p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            gVar.f1053j.setQwertyMode(gVar.f1059p);
            gVar.f1053j.startDispatchingItemsChanged();
        }
        gVar.f1056m = true;
        gVar.f1057n = false;
        this.f990K = gVar;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo996a(C0533h hVar) {
        if (!this.f988I) {
            this.f988I = true;
            this.f1021y.mo1824k();
            Callback m = mo1009m();
            if (m != null && !this.f1017r) {
                m.onPanelClosed(108, hVar);
            }
            this.f988I = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo1004f(int i) {
        mo995a(mo991a(i, true), true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo995a(C0468g gVar, boolean z) {
        if (!z || gVar.f1044a != 0 || this.f1021y == null || !this.f1021y.mo1812f()) {
            WindowManager windowManager = (WindowManager) this.f1000a.getSystemService("window");
            if (!(windowManager == null || !gVar.f1058o || gVar.f1050g == null)) {
                windowManager.removeView(gVar.f1050g);
                if (z) {
                    mo993a(gVar.f1044a, gVar, null);
                }
            }
            gVar.f1056m = false;
            gVar.f1057n = false;
            gVar.f1058o = false;
            gVar.f1051h = null;
            gVar.f1060q = true;
            if (this.f990K == gVar) {
                this.f990K = null;
            }
            return;
        }
        mo996a(gVar.f1053j);
    }

    /* renamed from: d */
    private boolean m1369d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0468g a = mo991a(i, true);
            if (!a.f1058o) {
                return m1367b(a, keyEvent);
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m1370e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.view.b r0 = r3.f1007h
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.g$g r2 = r3.mo991a(r4, r0)
            if (r4 != 0) goto L_0x0045
            androidx.appcompat.widget.ab r4 = r3.f1021y
            if (r4 == 0) goto L_0x0045
            androidx.appcompat.widget.ab r4 = r3.f1021y
            boolean r4 = r4.mo1811e()
            if (r4 == 0) goto L_0x0045
            android.content.Context r4 = r3.f1000a
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0045
            androidx.appcompat.widget.ab r4 = r3.f1021y
            boolean r4 = r4.mo1812f()
            if (r4 != 0) goto L_0x003e
            boolean r4 = r3.f1017r
            if (r4 != 0) goto L_0x0065
            boolean r4 = r3.m1367b(r2, r5)
            if (r4 == 0) goto L_0x0065
            androidx.appcompat.widget.ab r4 = r3.f1021y
            boolean r4 = r4.mo1821h()
            goto L_0x006c
        L_0x003e:
            androidx.appcompat.widget.ab r4 = r3.f1021y
            boolean r4 = r4.mo1822i()
            goto L_0x006c
        L_0x0045:
            boolean r4 = r2.f1058o
            if (r4 != 0) goto L_0x0067
            boolean r4 = r2.f1057n
            if (r4 == 0) goto L_0x004e
            goto L_0x0067
        L_0x004e:
            boolean r4 = r2.f1056m
            if (r4 == 0) goto L_0x0065
            boolean r4 = r2.f1061r
            if (r4 == 0) goto L_0x005d
            r2.f1056m = r1
            boolean r4 = r3.m1367b(r2, r5)
            goto L_0x005e
        L_0x005d:
            r4 = 1
        L_0x005e:
            if (r4 == 0) goto L_0x0065
            r3.m1361a(r2, r5)
            r4 = 1
            goto L_0x006c
        L_0x0065:
            r4 = 0
            goto L_0x006c
        L_0x0067:
            boolean r4 = r2.f1058o
            r3.mo995a(r2, r0)
        L_0x006c:
            if (r4 == 0) goto L_0x0085
            android.content.Context r5 = r3.f1000a
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0085:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0451g.m1370e(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo993a(int i, C0468g gVar, Menu menu) {
        if (menu == null) {
            if (gVar == null && i >= 0 && i < this.f989J.length) {
                gVar = this.f989J[i];
            }
            if (gVar != null) {
                menu = gVar.f1053j;
            }
        }
        if ((gVar == null || gVar.f1058o) && !this.f1017r) {
            this.f1002c.onPanelClosed(i, menu);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0468g mo992a(Menu menu) {
        C0468g[] gVarArr = this.f989J;
        int length = gVarArr != null ? gVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0468g gVar = gVarArr[i];
            if (gVar != null && gVar.f1053j == menu) {
                return gVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0468g mo991a(int i, boolean z) {
        C0468g[] gVarArr = this.f989J;
        if (gVarArr == null || gVarArr.length <= i) {
            C0468g[] gVarArr2 = new C0468g[(i + 1)];
            if (gVarArr != null) {
                System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
            }
            this.f989J = gVarArr2;
            gVarArr = gVarArr2;
        }
        C0468g gVar = gVarArr[i];
        if (gVar != null) {
            return gVar;
        }
        C0468g gVar2 = new C0468g(i);
        gVarArr[i] = gVar2;
        return gVar2;
    }

    /* renamed from: a */
    private boolean m1365a(C0468g gVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((gVar.f1056m || m1367b(gVar, keyEvent)) && gVar.f1053j != null) {
            z = gVar.f1053j.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.f1021y == null) {
            mo995a(gVar, true);
        }
        return z;
    }

    /* renamed from: j */
    private void m1371j(int i) {
        this.f1019t = (1 << i) | this.f1019t;
        if (!this.f1018s) {
            C0962r.m3562a(this.f1001b.getDecorView(), this.f995P);
            this.f1018s = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo1005g(int i) {
        C0468g a = mo991a(i, true);
        if (a.f1053j != null) {
            Bundle bundle = new Bundle();
            a.f1053j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a.f1062s = bundle;
            }
            a.f1053j.stopDispatchingItemsChanged();
            a.f1053j.clear();
        }
        a.f1061r = true;
        a.f1060q = true;
        if ((i == 108 || i == 0) && this.f1021y != null) {
            C0468g a2 = mo991a(0, false);
            if (a2 != null) {
                a2.f1056m = false;
                m1367b(a2, (KeyEvent) null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo1006h(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        int i2 = 0;
        if (this.f1008i == null || !(this.f1008i.getLayoutParams() instanceof MarginLayoutParams)) {
            z = false;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1008i.getLayoutParams();
            z = true;
            if (this.f1008i.isShown()) {
                if (this.f997R == null) {
                    this.f997R = new Rect();
                    this.f998S = new Rect();
                }
                Rect rect = this.f997R;
                Rect rect2 = this.f998S;
                rect.set(0, i, 0, 0);
                C0656bb.m2313a(this.f983D, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f985F == null) {
                        this.f985F = new View(this.f1000a);
                        this.f985F.setBackgroundColor(this.f1000a.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.f983D.addView(this.f985F, -1, new LayoutParams(-1, i));
                    } else {
                        LayoutParams layoutParams = this.f985F.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f985F.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.f985F == null) {
                    z = false;
                }
                if (!this.f1014o && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z3 = true;
                } else {
                    z3 = false;
                }
                z = false;
            }
            if (z2) {
                this.f1008i.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.f985F != null) {
            View view = this.f985F;
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        return i;
    }

    /* renamed from: y */
    private void m1378y() {
        if (this.f982C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: k */
    private int m1372k(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public void mo1020t() {
        if (this.f1021y != null) {
            this.f1021y.mo1824k();
        }
        if (this.f1009j != null) {
            this.f1001b.getDecorView().removeCallbacks(this.f1010k);
            if (this.f1009j.isShowing()) {
                try {
                    this.f1009j.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f1009j = null;
        }
        mo1018r();
        C0468g a = mo991a(0, false);
        if (a != null && a.f1053j != null) {
            a.f1053j.close();
        }
    }

    /* renamed from: j */
    public boolean mo989j() {
        int z = m1379z();
        int i = mo1007i(z);
        boolean l = i != -1 ? m1373l(i) : false;
        if (z == 0) {
            m1359A();
            this.f994O.mo1049c();
        }
        this.f993N = true;
        return l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public int mo1007i(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        if (VERSION.SDK_INT >= 23 && ((UiModeManager) this.f1000a.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        m1359A();
        return this.f994O.mo1047a();
    }

    /* renamed from: z */
    private int m1379z() {
        return this.f992M != -100 ? this.f992M : m1335k();
    }

    /* renamed from: l */
    private boolean m1373l(int i) {
        Resources resources = this.f1000a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (m1360B()) {
            ((Activity) this.f1000a).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i3 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                C0473j.m1457a(resources);
            }
        }
        return true;
    }

    /* renamed from: A */
    private void m1359A() {
        if (this.f994O == null) {
            this.f994O = new C0465e(C0481m.m1491a(this.f1000a));
        }
    }

    /* renamed from: B */
    private boolean m1360B() {
        boolean z = false;
        if (!this.f993N || !(this.f1000a instanceof Activity)) {
            return false;
        }
        try {
            if ((this.f1000a.getPackageManager().getActivityInfo(new ComponentName(this.f1000a, this.f1000a.getClass()), 0).configChanges & 512) == 0) {
                z = true;
            }
            return z;
        } catch (NameNotFoundException e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    /* renamed from: h */
    public final C0445a mo987h() {
        return new C0460a();
    }
}
