package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: androidx.transition.ac */
/* compiled from: ViewOverlayApi18 */
class C1363ac implements C1364ad {

    /* renamed from: a */
    private final ViewOverlay f4097a;

    C1363ac(View view) {
        this.f4097a = view.getOverlay();
    }

    /* renamed from: a */
    public void mo5698a(Drawable drawable) {
        this.f4097a.add(drawable);
    }

    /* renamed from: b */
    public void mo5699b(Drawable drawable) {
        this.f4097a.remove(drawable);
    }
}
