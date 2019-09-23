package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: androidx.appcompat.app.j */
/* compiled from: ResourcesFlusher */
class C0473j {

    /* renamed from: a */
    private static Field f1065a;

    /* renamed from: b */
    private static boolean f1066b;

    /* renamed from: c */
    private static Class f1067c;

    /* renamed from: d */
    private static boolean f1068d;

    /* renamed from: e */
    private static Field f1069e;

    /* renamed from: f */
    private static boolean f1070f;

    /* renamed from: g */
    private static Field f1071g;

    /* renamed from: h */
    private static boolean f1072h;

    /* renamed from: a */
    static void m1457a(Resources resources) {
        if (VERSION.SDK_INT < 28) {
            if (VERSION.SDK_INT >= 24) {
                m1461d(resources);
            } else if (VERSION.SDK_INT >= 23) {
                m1460c(resources);
            } else if (VERSION.SDK_INT >= 21) {
                m1459b(resources);
            }
        }
    }

    /* renamed from: b */
    private static void m1459b(Resources resources) {
        Map map;
        if (!f1066b) {
            try {
                f1065a = Resources.class.getDeclaredField("mDrawableCache");
                f1065a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1066b = true;
        }
        if (f1065a != null) {
            try {
                map = (Map) f1065a.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m1460c(android.content.res.Resources r4) {
        /*
            boolean r0 = f1066b
            if (r0 != 0) goto L_0x001f
            r0 = 1
            java.lang.Class<android.content.res.Resources> r1 = android.content.res.Resources.class
            java.lang.String r2 = "mDrawableCache"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0015 }
            f1065a = r1     // Catch:{ NoSuchFieldException -> 0x0015 }
            java.lang.reflect.Field r1 = f1065a     // Catch:{ NoSuchFieldException -> 0x0015 }
            r1.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0015 }
            goto L_0x001d
        L_0x0015:
            r1 = move-exception
            java.lang.String r2 = "ResourcesFlusher"
            java.lang.String r3 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r2, r3, r1)
        L_0x001d:
            f1066b = r0
        L_0x001f:
            r0 = 0
            java.lang.reflect.Field r1 = f1065a
            if (r1 == 0) goto L_0x0033
            java.lang.reflect.Field r1 = f1065a     // Catch:{ IllegalAccessException -> 0x002b }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ IllegalAccessException -> 0x002b }
            goto L_0x0034
        L_0x002b:
            r4 = move-exception
            java.lang.String r1 = "ResourcesFlusher"
            java.lang.String r2 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r1, r2, r4)
        L_0x0033:
            r4 = r0
        L_0x0034:
            if (r4 != 0) goto L_0x0037
            return
        L_0x0037:
            m1458a(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0473j.m1460c(android.content.res.Resources):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m1461d(android.content.res.Resources r5) {
        /*
            boolean r0 = f1072h
            r1 = 1
            if (r0 != 0) goto L_0x001f
            java.lang.Class<android.content.res.Resources> r0 = android.content.res.Resources.class
            java.lang.String r2 = "mResourcesImpl"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0015 }
            f1071g = r0     // Catch:{ NoSuchFieldException -> 0x0015 }
            java.lang.reflect.Field r0 = f1071g     // Catch:{ NoSuchFieldException -> 0x0015 }
            r0.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x0015 }
            goto L_0x001d
        L_0x0015:
            r0 = move-exception
            java.lang.String r2 = "ResourcesFlusher"
            java.lang.String r3 = "Could not retrieve Resources#mResourcesImpl field"
            android.util.Log.e(r2, r3, r0)
        L_0x001d:
            f1072h = r1
        L_0x001f:
            java.lang.reflect.Field r0 = f1071g
            if (r0 != 0) goto L_0x0024
            return
        L_0x0024:
            r0 = 0
            java.lang.reflect.Field r2 = f1071g     // Catch:{ IllegalAccessException -> 0x002c }
            java.lang.Object r5 = r2.get(r5)     // Catch:{ IllegalAccessException -> 0x002c }
            goto L_0x0035
        L_0x002c:
            r5 = move-exception
            java.lang.String r2 = "ResourcesFlusher"
            java.lang.String r3 = "Could not retrieve value from Resources#mResourcesImpl"
            android.util.Log.e(r2, r3, r5)
            r5 = r0
        L_0x0035:
            if (r5 != 0) goto L_0x0038
            return
        L_0x0038:
            boolean r2 = f1066b
            if (r2 != 0) goto L_0x0058
            java.lang.Class r2 = r5.getClass()     // Catch:{ NoSuchFieldException -> 0x004e }
            java.lang.String r3 = "mDrawableCache"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x004e }
            f1065a = r2     // Catch:{ NoSuchFieldException -> 0x004e }
            java.lang.reflect.Field r2 = f1065a     // Catch:{ NoSuchFieldException -> 0x004e }
            r2.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x004e }
            goto L_0x0056
        L_0x004e:
            r2 = move-exception
            java.lang.String r3 = "ResourcesFlusher"
            java.lang.String r4 = "Could not retrieve ResourcesImpl#mDrawableCache field"
            android.util.Log.e(r3, r4, r2)
        L_0x0056:
            f1066b = r1
        L_0x0058:
            java.lang.reflect.Field r1 = f1065a
            if (r1 == 0) goto L_0x006b
            java.lang.reflect.Field r1 = f1065a     // Catch:{ IllegalAccessException -> 0x0063 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ IllegalAccessException -> 0x0063 }
            goto L_0x006c
        L_0x0063:
            r5 = move-exception
            java.lang.String r1 = "ResourcesFlusher"
            java.lang.String r2 = "Could not retrieve value from ResourcesImpl#mDrawableCache"
            android.util.Log.e(r1, r2, r5)
        L_0x006b:
            r5 = r0
        L_0x006c:
            if (r5 == 0) goto L_0x0071
            m1458a(r5)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0473j.m1461d(android.content.res.Resources):void");
    }

    /* renamed from: a */
    private static void m1458a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f1068d) {
            try {
                f1067c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f1068d = true;
        }
        if (f1067c != null) {
            if (!f1070f) {
                try {
                    f1069e = f1067c.getDeclaredField("mUnthemedEntries");
                    f1069e.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                f1070f = true;
            }
            if (f1069e != null) {
                try {
                    longSparseArray = (LongSparseArray) f1069e.get(obj);
                } catch (IllegalAccessException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
