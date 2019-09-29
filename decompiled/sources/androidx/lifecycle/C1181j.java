package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.j */
/* compiled from: Lifecycling */
public class C1181j {

    /* renamed from: a */
    private static Map<Class, Integer> f3583a = new HashMap();

    /* renamed from: b */
    private static Map<Class, List<Constructor<? extends C1170c>>> f3584b = new HashMap();

    /* renamed from: a */
    static C1171d m4481a(Object obj) {
        if (obj instanceof C1169b) {
            return new FullLifecycleObserverAdapter((C1169b) obj);
        }
        if (obj instanceof C1171d) {
            return (C1171d) obj;
        }
        Class cls = obj.getClass();
        if (m4484b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f3584b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m4480a((Constructor) list.get(0), obj));
        }
        C1170c[] cVarArr = new C1170c[list.size()];
        for (int i = 0; i < list.size(); i++) {
            cVarArr[i] = m4480a((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    /* renamed from: a */
    private static C1170c m4480a(Constructor<? extends C1170c> constructor, Object obj) {
        try {
            return (C1170c) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: a */
    private static Constructor<? extends C1170c> m4483a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a = m4482a(canonicalName);
            if (!name.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(name);
                sb.append(".");
                sb.append(a);
                a = sb.toString();
            }
            Constructor<? extends C1170c> declaredConstructor = Class.forName(a).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private static int m4484b(Class<?> cls) {
        if (f3583a.containsKey(cls)) {
            return ((Integer) f3583a.get(cls)).intValue();
        }
        int c = m4485c(cls);
        f3583a.put(cls, Integer.valueOf(c));
        return c;
    }

    /* renamed from: c */
    private static int m4485c(Class<?> cls) {
        Class[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor a = m4483a(cls);
        if (a != null) {
            f3584b.put(cls, Collections.singletonList(a));
            return 2;
        } else if (C1166a.f3559a.mo4588a(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (m4486d(superclass)) {
                if (m4484b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList((Collection) f3584b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (m4486d(cls2)) {
                    if (m4484b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll((Collection) f3584b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f3584b.put(cls, arrayList);
            return 2;
        }
    }

    /* renamed from: d */
    private static boolean m4486d(Class<?> cls) {
        return cls != null && C1175f.class.isAssignableFrom(cls);
    }

    /* renamed from: a */
    public static String m4482a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.replace(".", "_"));
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }
}
