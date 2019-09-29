package androidx.core.p070g;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* renamed from: androidx.core.g.e */
/* compiled from: LayoutInflaterCompat */
public final class C0949e {

    /* renamed from: a */
    private static Field f3002a;

    /* renamed from: b */
    private static boolean f3003b;

    /* renamed from: b */
    private static void m3502b(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f3003b) {
            try {
                f3002a = LayoutInflater.class.getDeclaredField("mFactory2");
                f3002a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sb.append(LayoutInflater.class.getName());
                sb.append("; inflation may have unexpected results.");
                Log.e("LayoutInflaterCompatHC", sb.toString(), e);
            }
            f3003b = true;
        }
        if (f3002a != null) {
            try {
                f3002a.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb2.append(layoutInflater);
                sb2.append("; inflation may have unexpected results.");
                Log.e("LayoutInflaterCompatHC", sb2.toString(), e2);
            }
        }
    }

    /* renamed from: a */
    public static void m3501a(LayoutInflater layoutInflater, Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (VERSION.SDK_INT < 21) {
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                m3502b(layoutInflater, (Factory2) factory);
            } else {
                m3502b(layoutInflater, factory2);
            }
        }
    }
}
