package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.ba */
/* compiled from: VectorEnabledTintResources */
public class C0655ba extends Resources {

    /* renamed from: a */
    private static boolean f1906a = false;

    /* renamed from: b */
    private final WeakReference<Context> f1907b;

    /* renamed from: a */
    public static boolean m2310a() {
        return m2311b() && VERSION.SDK_INT <= 20;
    }

    public C0655ba(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1907b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        Context context = (Context) this.f1907b.get();
        if (context != null) {
            return C0680k.m2397a().mo2592a(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Drawable mo2489a(int i) {
        return super.getDrawable(i);
    }

    /* renamed from: b */
    public static boolean m2311b() {
        return f1906a;
    }
}
