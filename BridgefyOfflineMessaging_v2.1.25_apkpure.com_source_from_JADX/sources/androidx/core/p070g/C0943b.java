package androidx.core.p070g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.g.b */
/* compiled from: ActionProvider */
public abstract class C0943b {

    /* renamed from: a */
    private final Context f2995a;

    /* renamed from: b */
    private C0944a f2996b;

    /* renamed from: c */
    private C0945b f2997c;

    /* renamed from: androidx.core.g.b$a */
    /* compiled from: ActionProvider */
    public interface C0944a {
        /* renamed from: c */
        void mo2498c(boolean z);
    }

    /* renamed from: androidx.core.g.b$b */
    /* compiled from: ActionProvider */
    public interface C0945b {
        /* renamed from: a */
        void mo1624a(boolean z);
    }

    /* renamed from: a */
    public abstract View mo1681a();

    /* renamed from: a */
    public void mo1682a(SubMenu subMenu) {
    }

    /* renamed from: b */
    public boolean mo1683b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo1684c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo1691d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo1692e() {
        return true;
    }

    public C0943b(Context context) {
        this.f2995a = context;
    }

    /* renamed from: a */
    public View mo1689a(MenuItem menuItem) {
        return mo1681a();
    }

    /* renamed from: a */
    public void mo3733a(boolean z) {
        if (this.f2996b != null) {
            this.f2996b.mo2498c(z);
        }
    }

    /* renamed from: a */
    public void mo3732a(C0944a aVar) {
        this.f2996b = aVar;
    }

    /* renamed from: a */
    public void mo1690a(C0945b bVar) {
        if (!(this.f2997c == null || bVar == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", sb.toString());
        }
        this.f2997c = bVar;
    }

    /* renamed from: f */
    public void mo3734f() {
        this.f2997c = null;
        this.f2996b = null;
    }
}
