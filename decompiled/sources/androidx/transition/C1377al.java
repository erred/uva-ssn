package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* renamed from: androidx.transition.al */
/* compiled from: WindowIdApi18 */
class C1377al implements C1378am {

    /* renamed from: a */
    private final WindowId f4131a;

    C1377al(View view) {
        this.f4131a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1377al) && ((C1377al) obj).f4131a.equals(this.f4131a);
    }

    public int hashCode() {
        return this.f4131a.hashCode();
    }
}
