package androidx.appcompat.p047a.p048a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0680k;
import androidx.core.content.C0875a;
import androidx.core.content.p066a.C0876a;
import java.util.WeakHashMap;

/* renamed from: androidx.appcompat.a.a.a */
/* compiled from: AppCompatResources */
public final class C0424a {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f848a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<C0425a>> f849b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f850c = new Object();

    /* renamed from: androidx.appcompat.a.a.a$a */
    /* compiled from: AppCompatResources */
    private static class C0425a {

        /* renamed from: a */
        final ColorStateList f851a;

        /* renamed from: b */
        final Configuration f852b;

        C0425a(ColorStateList colorStateList, Configuration configuration) {
            this.f851a = colorStateList;
            this.f852b = configuration;
        }
    }

    /* renamed from: a */
    public static ColorStateList m1267a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = m1272d(context, i);
        if (d != null) {
            return d;
        }
        ColorStateList c = m1271c(context, i);
        if (c == null) {
            return C0875a.m3246b(context, i);
        }
        m1269a(context, i, c);
        return c;
    }

    /* renamed from: b */
    public static Drawable m1270b(Context context, int i) {
        return C0680k.m2397a().mo2590a(context, i);
    }

    /* renamed from: c */
    private static ColorStateList m1271c(Context context, int i) {
        if (m1273e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return C0876a.m3251a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        return null;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m1272d(android.content.Context r4, int r5) {
        /*
            java.lang.Object r0 = f850c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.a.a.a$a>> r1 = f849b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            androidx.appcompat.a.a.a$a r2 = (androidx.appcompat.p047a.p048a.C0424a.C0425a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f852b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f851a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p047a.p048a.C0424a.m1272d(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* renamed from: a */
    private static void m1269a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f850c) {
            SparseArray sparseArray = (SparseArray) f849b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f849b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0425a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: e */
    private static boolean m1273e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = m1268a();
        resources.getValue(i, a, true);
        if (a.type < 28 || a.type > 31) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static TypedValue m1268a() {
        TypedValue typedValue = (TypedValue) f848a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f848a.set(typedValue2);
        return typedValue2;
    }
}
