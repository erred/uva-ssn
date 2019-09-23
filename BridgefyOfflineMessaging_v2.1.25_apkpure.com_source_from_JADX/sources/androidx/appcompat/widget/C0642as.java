package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.as */
/* compiled from: TintContextWrapper */
public class C0642as extends ContextWrapper {

    /* renamed from: a */
    private static final Object f1851a = new Object();

    /* renamed from: b */
    private static ArrayList<WeakReference<C0642as>> f1852b;

    /* renamed from: c */
    private final Resources f1853c;

    /* renamed from: d */
    private final Theme f1854d;

    /* renamed from: a */
    public static Context m2225a(Context context) {
        if (!m2226b(context)) {
            return context;
        }
        synchronized (f1851a) {
            if (f1852b == null) {
                f1852b = new ArrayList<>();
            } else {
                for (int size = f1852b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = (WeakReference) f1852b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1852b.remove(size);
                    }
                }
                for (int size2 = f1852b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = (WeakReference) f1852b.get(size2);
                    C0642as asVar = weakReference2 != null ? (C0642as) weakReference2.get() : null;
                    if (asVar != null && asVar.getBaseContext() == context) {
                        return asVar;
                    }
                }
            }
            C0642as asVar2 = new C0642as(context);
            f1852b.add(new WeakReference(asVar2));
            return asVar2;
        }
    }

    /* renamed from: b */
    private static boolean m2226b(Context context) {
        boolean z = false;
        if ((context instanceof C0642as) || (context.getResources() instanceof C0644au) || (context.getResources() instanceof C0655ba)) {
            return false;
        }
        if (VERSION.SDK_INT < 21 || C0655ba.m2310a()) {
            z = true;
        }
        return z;
    }

    private C0642as(Context context) {
        super(context);
        if (C0655ba.m2310a()) {
            this.f1853c = new C0655ba(this, context.getResources());
            this.f1854d = this.f1853c.newTheme();
            this.f1854d.setTo(context.getTheme());
            return;
        }
        this.f1853c = new C0644au(this, context.getResources());
        this.f1854d = null;
    }

    public Theme getTheme() {
        return this.f1854d == null ? super.getTheme() : this.f1854d;
    }

    public void setTheme(int i) {
        if (this.f1854d == null) {
            super.setTheme(i);
        } else {
            this.f1854d.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.f1853c;
    }

    public AssetManager getAssets() {
        return this.f1853c.getAssets();
    }
}
