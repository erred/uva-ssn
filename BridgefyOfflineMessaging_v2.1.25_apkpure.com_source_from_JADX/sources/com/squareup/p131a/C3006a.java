package com.squareup.p131a;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.squareup.a.a */
/* compiled from: AnnotatedHandlerFinder */
final class C3006a {

    /* renamed from: a */
    private static final ConcurrentMap<Class<?>, Map<Class<?>, Method>> f7849a = new ConcurrentHashMap();

    /* renamed from: b */
    private static final ConcurrentMap<Class<?>, Map<Class<?>, Set<Method>>> f7850b = new ConcurrentHashMap();

    /* renamed from: a */
    private static void m8866a(Class<?> cls, Map<Class<?>, Method> map) {
        m8867a(cls, map, new HashMap());
    }

    /* renamed from: b */
    private static void m8869b(Class<?> cls, Map<Class<?>, Set<Method>> map) {
        m8867a(cls, new HashMap(), map);
    }

    /* renamed from: a */
    private static void m8867a(Class<?> cls, Map<Class<?>, Method> map, Map<Class<?>, Set<Method>> map2) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            if (!method.isBridge()) {
                if (method.isAnnotationPresent(C3017h.class)) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        Class cls2 = parameterTypes[0];
                        if (cls2.isInterface()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Method ");
                            sb.append(method);
                            sb.append(" has @Subscribe annotation on ");
                            sb.append(cls2);
                            sb.append(" which is an interface.  Subscription must be on a concrete class type.");
                            throw new IllegalArgumentException(sb.toString());
                        } else if ((1 & method.getModifiers()) != 0) {
                            Set set = (Set) map2.get(cls2);
                            if (set == null) {
                                set = new HashSet();
                                map2.put(cls2, set);
                            }
                            set.add(method);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Method ");
                            sb2.append(method);
                            sb2.append(" has @Subscribe annotation on ");
                            sb2.append(cls2);
                            sb2.append(" but is not 'public'.");
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Method ");
                        sb3.append(method);
                        sb3.append(" has @Subscribe annotation but requires ");
                        sb3.append(parameterTypes.length);
                        sb3.append(" arguments.  Methods must require a single argument.");
                        throw new IllegalArgumentException(sb3.toString());
                    }
                } else if (method.isAnnotationPresent(C3016g.class)) {
                    Class[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes2.length != 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Method ");
                        sb4.append(method);
                        sb4.append("has @Produce annotation but requires ");
                        sb4.append(parameterTypes2.length);
                        sb4.append(" arguments.  Methods must require zero arguments.");
                        throw new IllegalArgumentException(sb4.toString());
                    } else if (method.getReturnType() != Void.class) {
                        Class returnType = method.getReturnType();
                        if (returnType.isInterface()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Method ");
                            sb5.append(method);
                            sb5.append(" has @Produce annotation on ");
                            sb5.append(returnType);
                            sb5.append(" which is an interface.  Producers must return a concrete class type.");
                            throw new IllegalArgumentException(sb5.toString());
                        } else if (returnType.equals(Void.TYPE)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Method ");
                            sb6.append(method);
                            sb6.append(" has @Produce annotation but has no return type.");
                            throw new IllegalArgumentException(sb6.toString());
                        } else if ((1 & method.getModifiers()) == 0) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Method ");
                            sb7.append(method);
                            sb7.append(" has @Produce annotation on ");
                            sb7.append(returnType);
                            sb7.append(" but is not 'public'.");
                            throw new IllegalArgumentException(sb7.toString());
                        } else if (!map.containsKey(returnType)) {
                            map.put(returnType, method);
                        } else {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("Producer for type ");
                            sb8.append(returnType);
                            sb8.append(" has already been registered.");
                            throw new IllegalArgumentException(sb8.toString());
                        }
                    } else {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("Method ");
                        sb9.append(method);
                        sb9.append(" has a return type of void.  Must declare a non-void type.");
                        throw new IllegalArgumentException(sb9.toString());
                    }
                } else {
                    continue;
                }
            }
        }
        f7849a.put(cls, map);
        f7850b.put(cls, map2);
    }

    /* renamed from: a */
    static Map<Class<?>, C3013e> m8865a(Object obj) {
        Class cls = obj.getClass();
        HashMap hashMap = new HashMap();
        Map map = (Map) f7849a.get(cls);
        if (map == null) {
            map = new HashMap();
            m8866a(cls, map);
        }
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new C3013e(obj, (Method) entry.getValue()));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    static Map<Class<?>, Set<C3012d>> m8868b(Object obj) {
        Class cls = obj.getClass();
        HashMap hashMap = new HashMap();
        Map map = (Map) f7850b.get(cls);
        if (map == null) {
            map = new HashMap();
            m8869b(cls, map);
        }
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                HashSet hashSet = new HashSet();
                for (Method dVar : (Set) entry.getValue()) {
                    hashSet.add(new C3012d(obj, dVar));
                }
                hashMap.put(entry.getKey(), hashSet);
            }
        }
        return hashMap;
    }
}
