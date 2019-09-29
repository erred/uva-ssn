package androidx.lifecycle;

import androidx.lifecycle.C1172e.C1173a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: androidx.lifecycle.a */
/* compiled from: ClassesInfoCache */
class C1166a {

    /* renamed from: a */
    static C1166a f3559a = new C1166a();

    /* renamed from: b */
    private final Map<Class, C1167a> f3560b = new HashMap();

    /* renamed from: c */
    private final Map<Class, Boolean> f3561c = new HashMap();

    /* renamed from: androidx.lifecycle.a$a */
    /* compiled from: ClassesInfoCache */
    static class C1167a {

        /* renamed from: a */
        final Map<C1173a, List<C1168b>> f3562a = new HashMap();

        /* renamed from: b */
        final Map<C1168b, C1173a> f3563b;

        C1167a(Map<C1168b, C1173a> map) {
            this.f3563b = map;
            for (Entry entry : map.entrySet()) {
                C1173a aVar = (C1173a) entry.getValue();
                List list = (List) this.f3562a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f3562a.put(aVar, list);
                }
                list.add(entry.getKey());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4590a(C1176g gVar, C1173a aVar, Object obj) {
            m4446a((List) this.f3562a.get(aVar), gVar, aVar, obj);
            m4446a((List) this.f3562a.get(C1173a.ON_ANY), gVar, aVar, obj);
        }

        /* renamed from: a */
        private static void m4446a(List<C1168b> list, C1176g gVar, C1173a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C1168b) list.get(size)).mo4591a(gVar, aVar, obj);
                }
            }
        }
    }

    /* renamed from: androidx.lifecycle.a$b */
    /* compiled from: ClassesInfoCache */
    static class C1168b {

        /* renamed from: a */
        final int f3564a;

        /* renamed from: b */
        final Method f3565b;

        C1168b(int i, Method method) {
            this.f3564a = i;
            this.f3565b = method;
            this.f3565b.setAccessible(true);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4591a(C1176g gVar, C1173a aVar, Object obj) {
            try {
                switch (this.f3564a) {
                    case 0:
                        this.f3565b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f3565b.invoke(obj, new Object[]{gVar});
                        return;
                    case 2:
                        this.f3565b.invoke(obj, new Object[]{gVar, aVar});
                        return;
                    default:
                        return;
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1168b bVar = (C1168b) obj;
            if (this.f3564a != bVar.f3564a || !this.f3565b.getName().equals(bVar.f3565b.getName())) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.f3564a * 31) + this.f3565b.getName().hashCode();
        }
    }

    C1166a() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4588a(Class cls) {
        if (this.f3561c.containsKey(cls)) {
            return ((Boolean) this.f3561c.get(cls)).booleanValue();
        }
        Method[] c = m4443c(cls);
        for (Method annotation : c) {
            if (((C1185n) annotation.getAnnotation(C1185n.class)) != null) {
                m4441a(cls, c);
                return true;
            }
        }
        this.f3561c.put(cls, Boolean.valueOf(false));
        return false;
    }

    /* renamed from: c */
    private Method[] m4443c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C1167a mo4589b(Class cls) {
        C1167a aVar = (C1167a) this.f3560b.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return m4441a(cls, null);
    }

    /* renamed from: a */
    private void m4442a(Map<C1168b, C1173a> map, C1168b bVar, C1173a aVar, Class cls) {
        C1173a aVar2 = (C1173a) map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f3565b;
            StringBuilder sb = new StringBuilder();
            sb.append("Method ");
            sb.append(method.getName());
            sb.append(" in ");
            sb.append(cls.getName());
            sb.append(" already declared with different @OnLifecycleEvent value: previous");
            sb.append(" value ");
            sb.append(aVar2);
            sb.append(", new value ");
            sb.append(aVar);
            throw new IllegalArgumentException(sb.toString());
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    /* renamed from: a */
    private C1167a m4441a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            C1167a b = mo4589b(superclass);
            if (b != null) {
                hashMap.putAll(b.f3563b);
            }
        }
        for (Class b2 : cls.getInterfaces()) {
            for (Entry entry : mo4589b(b2).f3563b.entrySet()) {
                m4442a(hashMap, (C1168b) entry.getKey(), (C1173a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m4443c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            C1185n nVar = (C1185n) method.getAnnotation(C1185n.class);
            if (nVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(C1176g.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                C1173a a = nVar.mo4610a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(C1173a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a == C1173a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m4442a(hashMap, new C1168b(i, method), a, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C1167a aVar = new C1167a(hashMap);
        this.f3560b.put(cls, aVar);
        this.f3561c.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
