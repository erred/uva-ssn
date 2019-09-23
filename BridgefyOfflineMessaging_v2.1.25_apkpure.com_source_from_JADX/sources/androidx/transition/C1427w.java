package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* renamed from: androidx.transition.w */
/* compiled from: ViewGroupOverlayApi18 */
class C1427w implements C1428x {

    /* renamed from: a */
    private final ViewGroupOverlay f4240a;

    C1427w(ViewGroup viewGroup) {
        this.f4240a = viewGroup.getOverlay();
    }

    /* renamed from: a */
    public void mo5698a(Drawable drawable) {
        this.f4240a.add(drawable);
    }

    /* renamed from: b */
    public void mo5699b(Drawable drawable) {
        this.f4240a.remove(drawable);
    }

    /* renamed from: a */
    public void mo5877a(View view) {
        this.f4240a.add(view);
    }

    /* renamed from: b */
    public void mo5878b(View view) {
        this.f4240a.remove(view);
    }
}
