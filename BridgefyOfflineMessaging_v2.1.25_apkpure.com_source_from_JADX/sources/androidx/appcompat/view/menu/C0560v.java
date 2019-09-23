package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.p062a.p063a.C0838c;

/* renamed from: androidx.appcompat.view.menu.v */
/* compiled from: SubMenuWrapperICS */
class C0560v extends C0554r implements SubMenu {
    C0560v(Context context, C0838c cVar) {
        super(context, cVar);
    }

    /* renamed from: b */
    public C0838c mo1748b() {
        return (C0838c) this.f1352b;
    }

    public SubMenu setHeaderTitle(int i) {
        mo1748b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        mo1748b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        mo1748b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        mo1748b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        mo1748b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        mo1748b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        mo1748b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        mo1748b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return mo1428a(mo1748b().getItem());
    }
}
