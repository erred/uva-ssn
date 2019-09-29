package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import androidx.appcompat.app.C0440a.C0442b;
import androidx.appcompat.view.C0517i;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0533h.C0534a;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.widget.C0606ac;
import androidx.appcompat.widget.C0646aw;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.C0598c;
import androidx.core.p070g.C0962r;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.app.k */
/* compiled from: ToolbarActionBar */
class C0474k extends C0440a {

    /* renamed from: a */
    C0606ac f1073a;

    /* renamed from: b */
    boolean f1074b;

    /* renamed from: c */
    Callback f1075c;

    /* renamed from: d */
    private boolean f1076d;

    /* renamed from: e */
    private boolean f1077e;

    /* renamed from: f */
    private ArrayList<C0442b> f1078f = new ArrayList<>();

    /* renamed from: g */
    private final Runnable f1079g = new Runnable() {
        public void run() {
            C0474k.this.mo1077i();
        }
    };

    /* renamed from: h */
    private final C0598c f1080h = new C0598c() {
        /* renamed from: a */
        public boolean mo1079a(MenuItem menuItem) {
            return C0474k.this.f1075c.onMenuItemSelected(0, menuItem);
        }
    };

    /* renamed from: androidx.appcompat.app.k$a */
    /* compiled from: ToolbarActionBar */
    private final class C0477a implements C0550a {

        /* renamed from: b */
        private boolean f1084b;

        C0477a() {
        }

        /* renamed from: a */
        public boolean mo1031a(C0533h hVar) {
            if (C0474k.this.f1075c == null) {
                return false;
            }
            C0474k.this.f1075c.onMenuOpened(108, hVar);
            return true;
        }

        /* renamed from: a */
        public void mo1030a(C0533h hVar, boolean z) {
            if (!this.f1084b) {
                this.f1084b = true;
                C0474k.this.f1073a.mo2184n();
                if (C0474k.this.f1075c != null) {
                    C0474k.this.f1075c.onPanelClosed(108, hVar);
                }
                this.f1084b = false;
            }
        }
    }

    /* renamed from: androidx.appcompat.app.k$b */
    /* compiled from: ToolbarActionBar */
    private final class C0478b implements C0534a {
        public boolean onMenuItemSelected(C0533h hVar, MenuItem menuItem) {
            return false;
        }

        C0478b() {
        }

        public void onMenuModeChange(C0533h hVar) {
            if (C0474k.this.f1075c == null) {
                return;
            }
            if (C0474k.this.f1073a.mo2179i()) {
                C0474k.this.f1075c.onPanelClosed(108, hVar);
            } else if (C0474k.this.f1075c.onPreparePanel(0, null, hVar)) {
                C0474k.this.f1075c.onMenuOpened(108, hVar);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.k$c */
    /* compiled from: ToolbarActionBar */
    private class C0479c extends C0517i {
        public C0479c(Callback callback) {
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !C0474k.this.f1074b) {
                C0474k.this.f1073a.mo2183m();
                C0474k.this.f1074b = true;
            }
            return onPreparePanel;
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(C0474k.this.f1073a.mo2167b());
            }
            return super.onCreatePanelView(i);
        }
    }

    /* renamed from: c */
    public void mo859c(boolean z) {
    }

    /* renamed from: e */
    public void mo863e(boolean z) {
    }

    /* renamed from: f */
    public void mo865f(boolean z) {
    }

    C0474k(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f1073a = new C0646aw(toolbar, false);
        this.f1075c = new C0479c(callback);
        this.f1073a.mo2162a(this.f1075c);
        toolbar.setOnMenuItemClickListener(this.f1080h);
        this.f1073a.mo2165a(charSequence);
    }

    /* renamed from: h */
    public Callback mo1076h() {
        return this.f1075c;
    }

    /* renamed from: a */
    public void mo850a(float f) {
        C0962r.m3550a((View) this.f1073a.mo2157a(), f);
    }

    /* renamed from: b */
    public Context mo857b() {
        return this.f1073a.mo2167b();
    }

    /* renamed from: a */
    public void mo852a(Drawable drawable) {
        this.f1073a.mo2169b(drawable);
    }

    /* renamed from: a */
    public void mo851a(Configuration configuration) {
        super.mo851a(configuration);
    }

    /* renamed from: a */
    public void mo853a(CharSequence charSequence) {
        this.f1073a.mo2165a(charSequence);
    }

    /* renamed from: a */
    public void mo1075a(int i, int i2) {
        this.f1073a.mo2171c((i & i2) | ((~i2) & this.f1073a.mo2185o()));
    }

    /* renamed from: a */
    public void mo854a(boolean z) {
        mo1075a(z ? 4 : 0, 4);
    }

    /* renamed from: b */
    public void mo858b(boolean z) {
        mo1075a(z ? 8 : 0, 8);
    }

    /* renamed from: a */
    public int mo848a() {
        return this.f1073a.mo2185o();
    }

    /* renamed from: c */
    public boolean mo860c() {
        return this.f1073a.mo2181k();
    }

    /* renamed from: d */
    public boolean mo862d() {
        return this.f1073a.mo2182l();
    }

    /* renamed from: e */
    public boolean mo864e() {
        this.f1073a.mo2157a().removeCallbacks(this.f1079g);
        C0962r.m3562a((View) this.f1073a.mo2157a(), this.f1079g);
        return true;
    }

    /* renamed from: f */
    public boolean mo866f() {
        if (!this.f1073a.mo2172c()) {
            return false;
        }
        this.f1073a.mo2173d();
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo1077i() {
        Menu j = m1462j();
        C0533h hVar = j instanceof C0533h ? (C0533h) j : null;
        if (hVar != null) {
            hVar.stopDispatchingItemsChanged();
        }
        try {
            j.clear();
            if (!this.f1075c.onCreatePanelMenu(0, j) || !this.f1075c.onPreparePanel(0, null, j)) {
                j.clear();
            }
            if (hVar != null) {
                hVar.startDispatchingItemsChanged();
            }
        } catch (Throwable th) {
            if (hVar != null) {
                hVar.startDispatchingItemsChanged();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public boolean mo856a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo860c();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo855a(int i, KeyEvent keyEvent) {
        Menu j = m1462j();
        if (j == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        j.setQwertyMode(z);
        return j.performShortcut(i, keyEvent, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo867g() {
        this.f1073a.mo2157a().removeCallbacks(this.f1079g);
    }

    /* renamed from: g */
    public void mo868g(boolean z) {
        if (z != this.f1077e) {
            this.f1077e = z;
            int size = this.f1078f.size();
            for (int i = 0; i < size; i++) {
                ((C0442b) this.f1078f.get(i)).mo869a(z);
            }
        }
    }

    /* renamed from: j */
    private Menu m1462j() {
        if (!this.f1076d) {
            this.f1073a.mo2163a((C0550a) new C0477a(), (C0534a) new C0478b());
            this.f1076d = true;
        }
        return this.f1073a.mo2187q();
    }
}
