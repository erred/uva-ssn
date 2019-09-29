package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.C0505b.C0506a;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0533h.C0534a;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.view.e */
/* compiled from: StandaloneActionMode */
public class C0509e extends C0505b implements C0534a {

    /* renamed from: a */
    private Context f1220a;

    /* renamed from: b */
    private ActionBarContextView f1221b;

    /* renamed from: c */
    private C0506a f1222c;

    /* renamed from: d */
    private WeakReference<View> f1223d;

    /* renamed from: e */
    private boolean f1224e;

    /* renamed from: f */
    private boolean f1225f;

    /* renamed from: g */
    private C0533h f1226g;

    public C0509e(Context context, ActionBarContextView actionBarContextView, C0506a aVar, boolean z) {
        this.f1220a = context;
        this.f1221b = actionBarContextView;
        this.f1222c = aVar;
        this.f1226g = new C0533h(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f1226g.setCallback(this);
        this.f1225f = z;
    }

    /* renamed from: b */
    public void mo1103b(CharSequence charSequence) {
        this.f1221b.setTitle(charSequence);
    }

    /* renamed from: a */
    public void mo1099a(CharSequence charSequence) {
        this.f1221b.setSubtitle(charSequence);
    }

    /* renamed from: a */
    public void mo1097a(int i) {
        mo1103b((CharSequence) this.f1220a.getString(i));
    }

    /* renamed from: b */
    public void mo1102b(int i) {
        mo1099a((CharSequence) this.f1220a.getString(i));
    }

    /* renamed from: a */
    public void mo1100a(boolean z) {
        super.mo1100a(z);
        this.f1221b.setTitleOptional(z);
    }

    /* renamed from: h */
    public boolean mo1109h() {
        return this.f1221b.mo1781d();
    }

    /* renamed from: a */
    public void mo1098a(View view) {
        this.f1221b.setCustomView(view);
        this.f1223d = view != null ? new WeakReference<>(view) : null;
    }

    /* renamed from: d */
    public void mo1105d() {
        this.f1222c.mo1035b(this, this.f1226g);
    }

    /* renamed from: c */
    public void mo1104c() {
        if (!this.f1224e) {
            this.f1224e = true;
            this.f1221b.sendAccessibilityEvent(32);
            this.f1222c.mo1032a(this);
        }
    }

    /* renamed from: b */
    public Menu mo1101b() {
        return this.f1226g;
    }

    /* renamed from: f */
    public CharSequence mo1107f() {
        return this.f1221b.getTitle();
    }

    /* renamed from: g */
    public CharSequence mo1108g() {
        return this.f1221b.getSubtitle();
    }

    /* renamed from: i */
    public View mo1110i() {
        if (this.f1223d != null) {
            return (View) this.f1223d.get();
        }
        return null;
    }

    /* renamed from: a */
    public MenuInflater mo1096a() {
        return new C0512g(this.f1221b.getContext());
    }

    public boolean onMenuItemSelected(C0533h hVar, MenuItem menuItem) {
        return this.f1222c.mo1034a((C0505b) this, menuItem);
    }

    public void onMenuModeChange(C0533h hVar) {
        mo1105d();
        this.f1221b.mo1778a();
    }
}
