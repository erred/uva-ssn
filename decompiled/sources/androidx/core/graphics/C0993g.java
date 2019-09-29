package androidx.core.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.graphics.g */
/* compiled from: TypefaceCompatApi28Impl */
public class C0993g extends C0992f {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3842a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f3078a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f3084g.invoke(null, new Object[]{newInstance, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Method mo3849f(Class cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
