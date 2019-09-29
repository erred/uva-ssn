package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: androidx.appcompat.view.b */
/* compiled from: ActionMode */
public abstract class C0505b {

    /* renamed from: a */
    private Object f1213a;

    /* renamed from: b */
    private boolean f1214b;

    /* renamed from: androidx.appcompat.view.b$a */
    /* compiled from: ActionMode */
    public interface C0506a {
        /* renamed from: a */
        void mo1032a(C0505b bVar);

        /* renamed from: a */
        boolean mo1033a(C0505b bVar, Menu menu);

        /* renamed from: a */
        boolean mo1034a(C0505b bVar, MenuItem menuItem);

        /* renamed from: b */
        boolean mo1035b(C0505b bVar, Menu menu);
    }

    /* renamed from: a */
    public abstract MenuInflater mo1096a();

    /* renamed from: a */
    public abstract void mo1097a(int i);

    /* renamed from: a */
    public abstract void mo1098a(View view);

    /* renamed from: a */
    public abstract void mo1099a(CharSequence charSequence);

    /* renamed from: b */
    public abstract Menu mo1101b();

    /* renamed from: b */
    public abstract void mo1102b(int i);

    /* renamed from: b */
    public abstract void mo1103b(CharSequence charSequence);

    /* renamed from: c */
    public abstract void mo1104c();

    /* renamed from: d */
    public abstract void mo1105d();

    /* renamed from: f */
    public abstract CharSequence mo1107f();

    /* renamed from: g */
    public abstract CharSequence mo1108g();

    /* renamed from: h */
    public boolean mo1109h() {
        return false;
    }

    /* renamed from: i */
    public abstract View mo1110i();

    /* renamed from: a */
    public void mo1249a(Object obj) {
        this.f1213a = obj;
    }

    /* renamed from: j */
    public Object mo1250j() {
        return this.f1213a;
    }

    /* renamed from: a */
    public void mo1100a(boolean z) {
        this.f1214b = z;
    }

    /* renamed from: k */
    public boolean mo1251k() {
        return this.f1214b;
    }
}
