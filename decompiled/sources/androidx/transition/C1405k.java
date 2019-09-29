package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.transition.k */
/* compiled from: Scene */
public class C1405k {

    /* renamed from: a */
    private ViewGroup f4194a;

    /* renamed from: b */
    private Runnable f4195b;

    /* renamed from: a */
    public void mo5789a() {
        if (m5664a(this.f4194a) == this && this.f4195b != null) {
            this.f4195b.run();
        }
    }

    /* renamed from: a */
    static void m5665a(View view, C1405k kVar) {
        view.setTag(R.id.transition_current_scene, kVar);
    }

    /* renamed from: a */
    static C1405k m5664a(View view) {
        return (C1405k) view.getTag(R.id.transition_current_scene);
    }
}
