package androidx.core.p070g;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

/* renamed from: androidx.core.g.p */
/* compiled from: PointerIconCompat */
public final class C0960p {

    /* renamed from: a */
    private Object f3011a;

    private C0960p(Object obj) {
        this.f3011a = obj;
    }

    /* renamed from: a */
    public Object mo3757a() {
        return this.f3011a;
    }

    /* renamed from: a */
    public static C0960p m3539a(Context context, int i) {
        if (VERSION.SDK_INT >= 24) {
            return new C0960p(PointerIcon.getSystemIcon(context, i));
        }
        return new C0960p(null);
    }
}
