package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.au */
/* compiled from: TintResources */
class C0644au extends C0629al {

    /* renamed from: a */
    private final WeakReference<Context> f1859a;

    public C0644au(Context context, Resources resources) {
        super(resources);
        this.f1859a = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1859a.get();
        if (!(drawable == null || context == null)) {
            C0680k.m2397a();
            C0680k.m2403a(context, i, drawable);
        }
        return drawable;
    }
}
