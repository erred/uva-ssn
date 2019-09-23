package com.mikepenz.iconics.p128a;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.mikepenz.iconics.a.f */
/* compiled from: ReflectionUtils */
class C2993f {

    /* renamed from: a */
    private static final String f7801a = "f";

    C2993f() {
    }

    /* renamed from: a */
    static Field m8817a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static Object m8816a(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static void m8819a(Field field, Object obj, Object obj2) {
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException unused) {
        }
    }

    /* renamed from: b */
    static Method m8820b(Class cls, String str) {
        Method[] methods;
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    /* renamed from: a */
    static void m8818a(Object obj, Method method, Object... objArr) {
        if (method != null) {
            try {
                method.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                Log.d(f7801a, "Can't invoke method using reflection", e);
            } catch (InvocationTargetException e2) {
                Log.d(f7801a, "Can't invoke method using reflection (InvocationTargetException)", e2);
            }
        }
    }
}
