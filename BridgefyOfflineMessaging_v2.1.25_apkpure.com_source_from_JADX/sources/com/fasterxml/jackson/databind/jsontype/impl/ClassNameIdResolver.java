package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.C1952Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

public class ClassNameIdResolver extends TypeIdResolverBase {
    private static final String JAVA_UTIL_PKG = "java.util.";

    public String getDescForKnownTypeIds() {
        return "class name used as type id";
    }

    public void registerSubtype(Class<?> cls, String str) {
    }

    public ClassNameIdResolver(JavaType javaType, TypeFactory typeFactory) {
        super(javaType, typeFactory);
    }

    public C1952Id getMechanism() {
        return C1952Id.CLASS;
    }

    public String idFromValue(Object obj) {
        return _idFrom(obj, obj.getClass(), this._typeFactory);
    }

    public String idFromValueAndType(Object obj, Class<?> cls) {
        return _idFrom(obj, cls, this._typeFactory);
    }

    public JavaType typeFromId(DatabindContext databindContext, String str) throws IOException {
        return _typeFromId(str, databindContext);
    }

    /* access modifiers changed from: protected */
    public JavaType _typeFromId(String str, DatabindContext databindContext) throws IOException {
        TypeFactory typeFactory = databindContext.getTypeFactory();
        if (str.indexOf(60) > 0) {
            JavaType constructFromCanonical = typeFactory.constructFromCanonical(str);
            if (constructFromCanonical.isTypeOrSubTypeOf(this._baseType.getRawClass())) {
                return constructFromCanonical;
            }
            throw new IllegalArgumentException(String.format("Class %s not subtype of %s", new Object[]{constructFromCanonical.getRawClass().getName(), this._baseType}));
        }
        try {
            return typeFactory.constructSpecializedType(this._baseType, typeFactory.findClass(str));
        } catch (ClassNotFoundException unused) {
            if (databindContext instanceof DeserializationContext) {
                return ((DeserializationContext) databindContext).handleUnknownTypeId(this._baseType, str, this, "no such class found");
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid type id '");
            sb.append(str);
            sb.append("' (for id type 'Id.class'): ");
            sb.append(e.getMessage());
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: protected */
    public String _idFrom(Object obj, Class<?> cls, TypeFactory typeFactory) {
        String name;
        if (Enum.class.isAssignableFrom(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name2 = cls.getName();
        if (!name2.startsWith(JAVA_UTIL_PKG)) {
            return (name2.indexOf(36) < 0 || ClassUtil.getOuterClass(cls) == null || ClassUtil.getOuterClass(this._baseType.getRawClass()) != null) ? name2 : this._baseType.getRawClass().getName();
        }
        if (obj instanceof EnumSet) {
            return typeFactory.constructCollectionType(EnumSet.class, ClassUtil.findEnumType((EnumSet) obj)).toCanonical();
        } else if (obj instanceof EnumMap) {
            return typeFactory.constructMapType(EnumMap.class, ClassUtil.findEnumType((EnumMap) obj), Object.class).toCanonical();
        } else {
            String substring = name2.substring(JAVA_UTIL_PKG.length());
            if (isJavaUtilCollectionClass(substring, "List")) {
                name = ArrayList.class.getName();
            } else if (isJavaUtilCollectionClass(substring, "Map")) {
                name = HashMap.class.getName();
            } else if (!isJavaUtilCollectionClass(substring, "Set")) {
                return name2;
            } else {
                name = HashSet.class.getName();
            }
            return name;
        }
    }

    private static boolean isJavaUtilCollectionClass(String str, String str2) {
        boolean z = true;
        if (str.startsWith("Collections$")) {
            if (str.indexOf(str2) <= 0 || str.contains("Unmodifiable")) {
                z = false;
            }
            return z;
        } else if (!str.startsWith("Arrays$")) {
            return false;
        } else {
            if (str.indexOf(str2) <= 0) {
                z = false;
            }
            return z;
        }
    }
}
