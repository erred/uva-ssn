package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p062a.p063a.C0837b;
import androidx.core.p062a.p063a.C0838c;
import androidx.p052b.C0712a;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.appcompat.view.menu.c */
/* compiled from: BaseMenuWrapper */
abstract class C0522c<T> extends C0523d<T> {

    /* renamed from: a */
    final Context f1349a;

    /* renamed from: c */
    private Map<C0837b, MenuItem> f1350c;

    /* renamed from: d */
    private Map<C0838c, SubMenu> f1351d;

    C0522c(Context context, T t) {
        super(t);
        this.f1349a = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final MenuItem mo1428a(MenuItem menuItem) {
        if (!(menuItem instanceof C0837b)) {
            return menuItem;
        }
        C0837b bVar = (C0837b) menuItem;
        if (this.f1350c == null) {
            this.f1350c = new C0712a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1350c.get(menuItem);
        if (menuItem2 == null) {
            menuItem2 = C0553q.m1862a(this.f1349a, bVar);
            this.f1350c.put(bVar, menuItem2);
        }
        return menuItem2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final SubMenu mo1429a(SubMenu subMenu) {
        if (!(subMenu instanceof C0838c)) {
            return subMenu;
        }
        C0838c cVar = (C0838c) subMenu;
        if (this.f1351d == null) {
            this.f1351d = new C0712a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1351d.get(cVar);
        if (subMenu2 == null) {
            subMenu2 = C0553q.m1863a(this.f1349a, cVar);
            this.f1351d.put(cVar, subMenu2);
        }
        return subMenu2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo1430a() {
        if (this.f1350c != null) {
            this.f1350c.clear();
        }
        if (this.f1351d != null) {
            this.f1351d.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo1431a(int i) {
        if (this.f1350c != null) {
            Iterator it = this.f1350c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo1432b(int i) {
        if (this.f1350c != null) {
            Iterator it = this.f1350c.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (i == ((MenuItem) it.next()).getItemId()) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
