package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.p066a.C0878c.C0880b;
import androidx.core.content.p066a.C0878c.C0881c;
import androidx.core.p067d.C0893b;
import androidx.core.p067d.C0893b.C0899b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* renamed from: androidx.core.graphics.f */
/* compiled from: TypefaceCompatApi26Impl */
public class C0992f extends C0982d {

    /* renamed from: a */
    protected final Class f3078a;

    /* renamed from: b */
    protected final Constructor f3079b;

    /* renamed from: c */
    protected final Method f3080c;

    /* renamed from: d */
    protected final Method f3081d;

    /* renamed from: e */
    protected final Method f3082e;

    /* renamed from: f */
    protected final Method f3083f;

    /* renamed from: g */
    protected final Method f3084g;

    public C0992f() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor constructor;
        Class cls = null;
        try {
            Class a = mo3843a();
            constructor = mo3844a(a);
            method5 = mo3845b(a);
            method4 = mo3846c(a);
            method3 = mo3847d(a);
            method2 = mo3848e(a);
            method = mo3849f(a);
            cls = a;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to collect necessary methods for class ");
            sb.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", sb.toString(), e);
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f3078a = cls;
        this.f3079b = constructor;
        this.f3080c = method5;
        this.f3081d = method4;
        this.f3082e = method3;
        this.f3083f = method2;
        this.f3084g = method;
    }

    /* renamed from: b */
    private boolean m3732b() {
        if (this.f3080c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f3080c != null;
    }

    /* renamed from: c */
    private Object m3734c() {
        try {
            return this.f3079b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private boolean m3730a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f3080c.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private boolean m3731a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.f3081d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3842a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f3078a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f3084g.invoke(null, new Object[]{newInstance, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private boolean m3733b(Object obj) {
        try {
            return ((Boolean) this.f3082e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private void m3735c(Object obj) {
        try {
            this.f3083f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public Typeface mo3840a(Context context, C0880b bVar, Resources resources, int i) {
        C0881c[] a;
        if (!m3732b()) {
            return super.mo3840a(context, bVar, resources, i);
        }
        Object c = m3734c();
        for (C0881c cVar : bVar.mo3566a()) {
            if (!m3730a(context, c, cVar.mo3567a(), cVar.mo3571e(), cVar.mo3568b(), cVar.mo3569c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.mo3570d()))) {
                m3735c(c);
                return null;
            }
        }
        if (!m3733b(c)) {
            return null;
        }
        return mo3842a(c);
    }

    /* renamed from: a */
    public Typeface mo3787a(Context context, CancellationSignal cancellationSignal, C0899b[] bVarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!m3732b()) {
            C0899b a = mo3851a(bVarArr, i);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(a.mo3596a(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(a.mo3598c()).setItalic(a.mo3599d()).build();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return build;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    th = r13;
                    th2 = th4;
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            Map a2 = C0893b.m3322a(context, bVarArr, cancellationSignal);
            Object c = m3734c();
            boolean z = false;
            for (C0899b bVar : bVarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) a2.get(bVar.mo3596a());
                if (byteBuffer != null) {
                    if (!m3731a(c, byteBuffer, bVar.mo3597b(), bVar.mo3598c(), bVar.mo3599d() ? 1 : 0)) {
                        m3735c(c);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                m3735c(c);
                return null;
            } else if (!m3733b(c)) {
                return null;
            } else {
                return Typeface.create(mo3842a(c), i);
            }
        }
        if (openFileDescriptor != null) {
            if (th != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th5) {
                    th.addSuppressed(th5);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th2;
        throw th2;
    }

    /* renamed from: a */
    public Typeface mo3841a(Context context, Resources resources, int i, String str, int i2) {
        if (!m3732b()) {
            return super.mo3841a(context, resources, i, str, i2);
        }
        Object c = m3734c();
        if (!m3730a(context, c, str, 0, -1, -1, null)) {
            m3735c(c);
            return null;
        } else if (!m3733b(c)) {
            return null;
        } else {
            return mo3842a(c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Class mo3843a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Constructor mo3844a(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Method mo3845b(Class cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Method mo3846c(Class cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Method mo3847d(Class cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Method mo3848e(Class cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Method mo3849f(Class cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
