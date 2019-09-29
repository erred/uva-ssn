package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p062a.p063a.C0836a;
import androidx.core.p062a.p063a.C0837b;
import androidx.core.p062a.p063a.C0838c;

/* renamed from: androidx.appcompat.view.menu.q */
/* compiled from: MenuWrapperFactory */
public final class C0553q {
    /* renamed from: a */
    public static Menu m1861a(Context context, C0836a aVar) {
        return new C0554r(context, aVar);
    }

    /* renamed from: a */
    public static MenuItem m1862a(Context context, C0837b bVar) {
        if (VERSION.SDK_INT >= 16) {
            return new C0544l(context, bVar);
        }
        return new C0539k(context, bVar);
    }

    /* renamed from: a */
    public static SubMenu m1863a(Context context, C0838c cVar) {
        return new C0560v(context, cVar);
    }
}
