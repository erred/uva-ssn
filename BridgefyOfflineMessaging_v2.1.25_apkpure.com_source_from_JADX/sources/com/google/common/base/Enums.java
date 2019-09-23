package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@GwtCompatible(emulated = true)
@Beta
public final class Enums {
    @GwtIncompatible("java.lang.ref.WeakReference")
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = new WeakHashMap();

    private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        StringConverter(Class<T> cls) {
            this.enumClass = (Class) Preconditions.checkNotNull(cls);
        }

        /* access modifiers changed from: protected */
        public T doForward(String str) {
            return Enum.valueOf(this.enumClass, str);
        }

        /* access modifiers changed from: protected */
        public String doBackward(T t) {
            return t.name();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            return this.enumClass.equals(((StringConverter) obj).enumClass);
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Enums.stringConverter(");
            sb.append(this.enumClass.getName());
            sb.append(".class)");
            return sb.toString();
        }
    }

    private static final class ValueOfFunction<T extends Enum<T>> implements Function<String, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        private ValueOfFunction(Class<T> cls) {
            this.enumClass = (Class) Preconditions.checkNotNull(cls);
        }

        public T apply(String str) {
            try {
                return Enum.valueOf(this.enumClass, str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ValueOfFunction) && this.enumClass.equals(((ValueOfFunction) obj).enumClass);
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Enums.valueOf(");
            sb.append(this.enumClass);
            sb.append(")");
            return sb.toString();
        }
    }

    private Enums() {
    }

    @GwtIncompatible("reflection")
    public static Field getField(Enum<?> enumR) {
        try {
            return enumR.getDeclaringClass().getDeclaredField(enumR.name());
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    @Deprecated
    public static <T extends Enum<T>> Function<String, T> valueOfFunction(Class<T> cls) {
        return new ValueOfFunction(cls);
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> cls, String str) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        return Platform.getEnumIfPresent(cls, str);
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> cls) {
        HashMap hashMap = new HashMap();
        Iterator it = EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            hashMap.put(enumR.name(), new WeakReference(enumR));
        }
        enumConstantCache.put(cls, hashMap);
        return hashMap;
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> map;
        synchronized (enumConstantCache) {
            map = (Map) enumConstantCache.get(cls);
            if (map == null) {
                map = populateCache(cls);
            }
        }
        return map;
    }

    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> cls) {
        return new StringConverter(cls);
    }
}
