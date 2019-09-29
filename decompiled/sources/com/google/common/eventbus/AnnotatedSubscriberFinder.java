package com.google.common.eventbus;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class AnnotatedSubscriberFinder implements SubscriberFindingStrategy {
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableList<Method>>() {
        public ImmutableList<Method> load(Class<?> cls) throws Exception {
            return AnnotatedSubscriberFinder.getAnnotatedMethodsInternal(cls);
        }
    });

    private static final class MethodIdentifier {
        private final String name;
        private final List<Class<?>> parameterTypes;

        MethodIdentifier(Method method) {
            this.name = method.getName();
            this.parameterTypes = Arrays.asList(method.getParameterTypes());
        }

        public int hashCode() {
            return Objects.hashCode(this.name, this.parameterTypes);
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof MethodIdentifier)) {
                return false;
            }
            MethodIdentifier methodIdentifier = (MethodIdentifier) obj;
            if (this.name.equals(methodIdentifier.name) && this.parameterTypes.equals(methodIdentifier.parameterTypes)) {
                z = true;
            }
            return z;
        }
    }

    AnnotatedSubscriberFinder() {
    }

    public Multimap<Class<?>, EventSubscriber> findAllSubscribers(Object obj) {
        HashMultimap create = HashMultimap.create();
        Iterator it = getAnnotatedMethods(obj.getClass()).iterator();
        while (it.hasNext()) {
            Method method = (Method) it.next();
            create.put(method.getParameterTypes()[0], makeSubscriber(obj, method));
        }
        return create;
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> cls) {
        try {
            return (ImmutableList) subscriberMethodsCache.getUnchecked(cls);
        } catch (UncheckedExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    /* access modifiers changed from: private */
    public static ImmutableList<Method> getAnnotatedMethodsInternal(Class<?> cls) {
        Set<Class> rawTypes = TypeToken.m8761of(cls).getTypes().rawTypes();
        HashMap newHashMap = Maps.newHashMap();
        for (Class methods : rawTypes) {
            Method[] methods2 = methods.getMethods();
            int length = methods2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Method method = methods2[i];
                    if (method.isAnnotationPresent(Subscribe.class)) {
                        Class[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            MethodIdentifier methodIdentifier = new MethodIdentifier(method);
                            if (!newHashMap.containsKey(methodIdentifier)) {
                                newHashMap.put(methodIdentifier, method);
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Method ");
                            sb.append(method);
                            sb.append(" has @Subscribe annotation, but requires ");
                            sb.append(parameterTypes.length);
                            sb.append(" arguments.  Event subscriber methods must require a single argument.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    i++;
                }
            }
        }
        return ImmutableList.copyOf(newHashMap.values());
    }

    private static EventSubscriber makeSubscriber(Object obj, Method method) {
        if (methodIsDeclaredThreadSafe(method)) {
            return new EventSubscriber(obj, method);
        }
        return new SynchronizedEventSubscriber(obj, method);
    }

    private static boolean methodIsDeclaredThreadSafe(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }
}
