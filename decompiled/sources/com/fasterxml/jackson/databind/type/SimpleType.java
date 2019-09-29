package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.util.Collection;
import java.util.Map;

public class SimpleType extends TypeBase {
    private static final long serialVersionUID = 1;

    public boolean hasContentType() {
        return false;
    }

    public boolean isContainerType() {
        return false;
    }

    public JavaType refine(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    protected SimpleType(Class<?> cls) {
        this(cls, TypeBindings.emptyBindings(), null, null);
    }

    protected SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        this(cls, typeBindings, javaType, javaTypeArr, null, null, false);
    }

    protected SimpleType(TypeBase typeBase) {
        super(typeBase);
    }

    protected SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, Object obj, Object obj2, boolean z) {
        super(cls, typeBindings, javaType, javaTypeArr, 0, obj, obj2, z);
    }

    protected SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i, Object obj, Object obj2, boolean z) {
        super(cls, typeBindings, javaType, javaTypeArr, i, obj, obj2, z);
    }

    public static SimpleType constructUnsafe(Class<?> cls) {
        SimpleType simpleType = new SimpleType(cls, null, null, null, null, null, false);
        return simpleType;
    }

    @Deprecated
    public static SimpleType construct(Class<?> cls) {
        if (Map.class.isAssignableFrom(cls)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not construct SimpleType for a Map (class: ");
            sb.append(cls.getName());
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        } else if (Collection.class.isAssignableFrom(cls)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can not construct SimpleType for a Collection (class: ");
            sb2.append(cls.getName());
            sb2.append(")");
            throw new IllegalArgumentException(sb2.toString());
        } else if (!cls.isArray()) {
            TypeBindings emptyBindings = TypeBindings.emptyBindings();
            SimpleType simpleType = new SimpleType(cls, emptyBindings, _buildSuperClass(cls.getSuperclass(), emptyBindings), null, null, null, false);
            return simpleType;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Can not construct SimpleType for an array (class: ");
            sb3.append(cls.getName());
            sb3.append(")");
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JavaType _narrow(Class<?> cls) {
        if (this._class == cls) {
            return this;
        }
        if (!this._class.isAssignableFrom(cls)) {
            SimpleType simpleType = new SimpleType(cls, this._bindings, this, this._superInterfaces, this._valueHandler, this._typeHandler, this._asStatic);
            return simpleType;
        }
        Class superclass = cls.getSuperclass();
        if (superclass == this._class) {
            SimpleType simpleType2 = new SimpleType(cls, this._bindings, this, this._superInterfaces, this._valueHandler, this._typeHandler, this._asStatic);
            return simpleType2;
        } else if (superclass == null || !this._class.isAssignableFrom(superclass)) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (i < length) {
                Class cls2 = interfaces[i];
                if (cls2 == this._class) {
                    SimpleType simpleType3 = new SimpleType(cls, this._bindings, null, new JavaType[]{this}, this._valueHandler, this._typeHandler, this._asStatic);
                    return simpleType3;
                } else if (this._class.isAssignableFrom(cls2)) {
                    JavaType _narrow = _narrow(cls2);
                    SimpleType simpleType4 = new SimpleType(cls, this._bindings, null, new JavaType[]{_narrow}, this._valueHandler, this._typeHandler, this._asStatic);
                    return simpleType4;
                } else {
                    i++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error: Can not resolve sub-type for Class ");
            sb.append(cls.getName());
            sb.append(" to ");
            sb.append(this._class.getName());
            throw new IllegalArgumentException(sb.toString());
        } else {
            Class<?> cls3 = cls;
            SimpleType simpleType5 = new SimpleType(cls3, this._bindings, _narrow(superclass), null, this._valueHandler, this._typeHandler, this._asStatic);
            return simpleType5;
        }
    }

    public JavaType withContentType(JavaType javaType) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContentType()");
    }

    public SimpleType withTypeHandler(Object obj) {
        if (this._typeHandler == obj) {
            return this;
        }
        SimpleType simpleType = new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, obj, this._asStatic);
        return simpleType;
    }

    public JavaType withContentTypeHandler(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
    }

    public SimpleType withValueHandler(Object obj) {
        if (obj == this._valueHandler) {
            return this;
        }
        SimpleType simpleType = new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, obj, this._typeHandler, this._asStatic);
        return simpleType;
    }

    public SimpleType withContentValueHandler(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; can not call withContenValueHandler()");
    }

    public SimpleType withStaticTyping() {
        if (this._asStatic) {
            return this;
        }
        SimpleType simpleType = new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, this._typeHandler, true);
        return simpleType;
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        int size = this._bindings.size();
        if (size > 0) {
            sb.append('<');
            for (int i = 0; i < size; i++) {
                JavaType containedType = containedType(i);
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(containedType.toCanonical());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    public StringBuilder getErasedSignature(StringBuilder sb) {
        return _classSignature(this._class, sb, true);
    }

    public StringBuilder getGenericSignature(StringBuilder sb) {
        _classSignature(this._class, sb, false);
        int size = this._bindings.size();
        if (size > 0) {
            sb.append('<');
            for (int i = 0; i < size; i++) {
                sb = containedType(i).getGenericSignature(sb);
            }
            sb.append('>');
        }
        sb.append(';');
        return sb;
    }

    private static JavaType _buildSuperClass(Class<?> cls, TypeBindings typeBindings) {
        if (cls == null) {
            return null;
        }
        if (cls == Object.class) {
            return TypeFactory.unknownType();
        }
        SimpleType simpleType = new SimpleType(cls, typeBindings, _buildSuperClass(cls.getSuperclass(), typeBindings), null, null, null, false);
        return simpleType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(buildCanonicalName());
        sb.append(']');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        SimpleType simpleType = (SimpleType) obj;
        if (simpleType._class != this._class) {
            return false;
        }
        return this._bindings.equals(simpleType._bindings);
    }
}
