package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.p066a.C0878c.C0880b;
import androidx.core.content.p066a.C0878c.C0881c;
import androidx.core.p067d.C0893b.C0899b;
import androidx.p052b.C0725g;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: androidx.core.graphics.e */
/* compiled from: TypefaceCompatApi24Impl */
class C0991e extends C0994h {

    /* renamed from: a */
    private static final Class f3074a;

    /* renamed from: b */
    private static final Constructor f3075b;

    /* renamed from: c */
    private static final Method f3076c;

    /* renamed from: d */
    private static final Method f3077d;

    C0991e() {
    }

    static {
        Method method;
        Method method2;
        Class cls;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        f3075b = constructor;
        f3074a = cls;
        f3076c = method;
        f3077d = method2;
    }

    /* renamed from: a */
    public static boolean m3725a() {
        if (f3076c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f3076c != null;
    }

    /* renamed from: b */
    private static Object m3727b() {
        try {
            return f3075b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m3726a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f3076c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static Typeface m3724a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f3074a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f3077d.invoke(null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public Typeface mo3787a(Context context, CancellationSignal cancellationSignal, C0899b[] bVarArr, int i) {
        Object b = m3727b();
        C0725g gVar = new C0725g();
        for (C0899b bVar : bVarArr) {
            Uri a = bVar.mo3596a();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(a);
            if (byteBuffer == null) {
                byteBuffer = C0998i.m3768a(context, cancellationSignal, a);
                gVar.put(a, byteBuffer);
            }
            if (!m3726a(b, byteBuffer, bVar.mo3597b(), bVar.mo3598c(), bVar.mo3599d())) {
                return null;
            }
        }
        return Typeface.create(m3724a(b), i);
    }

    /* renamed from: a */
    public Typeface mo3840a(Context context, C0880b bVar, Resources resources, int i) {
        C0881c[] a;
        Object b = m3727b();
        for (C0881c cVar : bVar.mo3566a()) {
            ByteBuffer a2 = C0998i.m3767a(context, resources, cVar.mo3572f());
            if (a2 == null || !m3726a(b, a2, cVar.mo3571e(), cVar.mo3568b(), cVar.mo3569c())) {
                return null;
            }
        }
        return m3724a(b);
    }
}
