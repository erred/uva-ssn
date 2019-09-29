package androidx.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* renamed from: androidx.transition.y */
/* compiled from: ViewGroupUtils */
class C1429y {
    /* renamed from: a */
    static C1428x m5724a(ViewGroup viewGroup) {
        if (VERSION.SDK_INT >= 18) {
            return new C1427w(viewGroup);
        }
        return C1426v.m5715a(viewGroup);
    }

    /* renamed from: a */
    static void m5725a(ViewGroup viewGroup, boolean z) {
        if (VERSION.SDK_INT >= 18) {
            C1360aa.m5539a(viewGroup, z);
        } else {
            C1430z.m5727a(viewGroup, z);
        }
    }
}
