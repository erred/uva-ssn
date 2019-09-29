package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class ClassInfo {
    private static final Map<Class<?>, ClassInfo> CACHE = new WeakHashMap();
    private static final Map<Class<?>, ClassInfo> CACHE_IGNORE_CASE = new WeakHashMap();
    private final Class<?> clazz;
    private final boolean ignoreCase;
    private final IdentityHashMap<String, FieldInfo> nameToFieldInfoMap = new IdentityHashMap<>();
    final List<String> names;

    /* renamed from: of */
    public static ClassInfo m8627of(Class<?> cls) {
        return m8628of(cls, false);
    }

    /* renamed from: of */
    public static ClassInfo m8628of(Class<?> cls, boolean z) {
        ClassInfo classInfo;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, ClassInfo> map = z ? CACHE_IGNORE_CASE : CACHE;
        synchronized (map) {
            classInfo = (ClassInfo) map.get(cls);
            if (classInfo == null) {
                classInfo = new ClassInfo(cls, z);
                map.put(cls, classInfo);
            }
        }
        return classInfo;
    }

    public Class<?> getUnderlyingClass() {
        return this.clazz;
    }

    public final boolean getIgnoreCase() {
        return this.ignoreCase;
    }

    public FieldInfo getFieldInfo(String str) {
        if (str != null) {
            if (this.ignoreCase) {
                str = str.toLowerCase();
            }
            str = str.intern();
        }
        return (FieldInfo) this.nameToFieldInfoMap.get(str);
    }

    public Field getField(String str) {
        FieldInfo fieldInfo = getFieldInfo(str);
        if (fieldInfo == null) {
            return null;
        }
        return fieldInfo.getField();
    }

    public boolean isEnum() {
        return this.clazz.isEnum();
    }

    public Collection<String> getNames() {
        return this.names;
    }

    private ClassInfo(Class<?> cls, boolean z) {
        Field[] declaredFields;
        boolean z2 = z;
        this.clazz = cls;
        this.ignoreCase = z2;
        boolean z3 = !z2 || !cls.isEnum();
        String valueOf = String.valueOf(String.valueOf(cls));
        StringBuilder sb = new StringBuilder(valueOf.length() + 31);
        sb.append("cannot ignore case on an enum: ");
        sb.append(valueOf);
        Preconditions.checkArgument(z3, sb.toString());
        TreeSet treeSet = new TreeSet(new Comparator<String>() {
            public int compare(String str, String str2) {
                if (str == str2) {
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                if (str2 == null) {
                    return 1;
                }
                return str.compareTo(str2);
            }
        });
        for (Field field : cls.getDeclaredFields()) {
            FieldInfo of = FieldInfo.m8630of(field);
            if (of != null) {
                String name = of.getName();
                if (z2) {
                    name = name.toLowerCase().intern();
                }
                FieldInfo fieldInfo = (FieldInfo) this.nameToFieldInfoMap.get(name);
                boolean z4 = fieldInfo == null;
                String str = "two fields have the same %sname <%s>: %s and %s";
                Object[] objArr = new Object[4];
                objArr[0] = z2 ? "case-insensitive " : "";
                objArr[1] = name;
                objArr[2] = field;
                objArr[3] = fieldInfo == null ? null : fieldInfo.getField();
                Preconditions.checkArgument(z4, str, objArr);
                this.nameToFieldInfoMap.put(name, of);
                treeSet.add(name);
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            ClassInfo of2 = m8628of(superclass, z2);
            treeSet.addAll(of2.names);
            for (Entry entry : of2.nameToFieldInfoMap.entrySet()) {
                String str2 = (String) entry.getKey();
                if (!this.nameToFieldInfoMap.containsKey(str2)) {
                    this.nameToFieldInfoMap.put(str2, entry.getValue());
                }
            }
        }
        this.names = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public Collection<FieldInfo> getFieldInfos() {
        return Collections.unmodifiableCollection(this.nameToFieldInfoMap.values());
    }
}
