package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class TypeBase extends JavaType implements JsonSerializable {
    private static final TypeBindings NO_BINDINGS = TypeBindings.emptyBindings();
    private static final JavaType[] NO_TYPES = new JavaType[0];
    private static final long serialVersionUID = 1;
    protected final TypeBindings _bindings;
    volatile transient String _canonicalName;
    protected final JavaType _superClass;
    protected final JavaType[] _superInterfaces;

    public abstract StringBuilder getErasedSignature(StringBuilder sb);

    public abstract StringBuilder getGenericSignature(StringBuilder sb);

    protected TypeBase(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i, Object obj, Object obj2, boolean z) {
        super(cls, i, obj, obj2, z);
        if (typeBindings == null) {
            typeBindings = NO_BINDINGS;
        }
        this._bindings = typeBindings;
        this._superClass = javaType;
        this._superInterfaces = javaTypeArr;
    }

    protected TypeBase(TypeBase typeBase) {
        super(typeBase);
        this._superClass = typeBase._superClass;
        this._superInterfaces = typeBase._superInterfaces;
        this._bindings = typeBase._bindings;
    }

    public String toCanonical() {
        String str = this._canonicalName;
        return str == null ? buildCanonicalName() : str;
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        return this._class.getName();
    }

    public TypeBindings getBindings() {
        return this._bindings;
    }

    public int containedTypeCount() {
        return this._bindings.size();
    }

    public JavaType containedType(int i) {
        return this._bindings.getBoundType(i);
    }

    @Deprecated
    public String containedTypeName(int i) {
        return this._bindings.getBoundName(i);
    }

    public JavaType getSuperClass() {
        return this._superClass;
    }

    public List<JavaType> getInterfaces() {
        if (this._superInterfaces == null) {
            return Collections.emptyList();
        }
        switch (this._superInterfaces.length) {
            case 0:
                return Collections.emptyList();
            case 1:
                return Collections.singletonList(this._superInterfaces[0]);
            default:
                return Arrays.asList(this._superInterfaces);
        }
    }

    public final JavaType findSuperType(Class<?> cls) {
        if (cls == this._class) {
            return this;
        }
        if (cls.isInterface() && this._superInterfaces != null) {
            for (JavaType findSuperType : this._superInterfaces) {
                JavaType findSuperType2 = findSuperType.findSuperType(cls);
                if (findSuperType2 != null) {
                    return findSuperType2;
                }
            }
        }
        if (this._superClass != null) {
            JavaType findSuperType3 = this._superClass.findSuperType(cls);
            if (findSuperType3 != null) {
                return findSuperType3;
            }
        }
        return null;
    }

    public JavaType[] findTypeParameters(Class<?> cls) {
        JavaType findSuperType = findSuperType(cls);
        if (findSuperType == null) {
            return NO_TYPES;
        }
        return findSuperType.getBindings().typeParameterArray();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        typeSerializer.writeTypePrefixForScalar(this, jsonGenerator);
        serialize(jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForScalar(this, jsonGenerator);
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(toCanonical());
    }

    protected static StringBuilder _classSignature(Class<?> cls, StringBuilder sb, boolean z) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char charAt = name.charAt(i);
                if (charAt == '.') {
                    charAt = '/';
                }
                sb.append(charAt);
            }
            if (z) {
                sb.append(';');
            }
        } else if (cls == Boolean.TYPE) {
            sb.append('Z');
        } else if (cls == Byte.TYPE) {
            sb.append('B');
        } else if (cls == Short.TYPE) {
            sb.append('S');
        } else if (cls == Character.TYPE) {
            sb.append('C');
        } else if (cls == Integer.TYPE) {
            sb.append('I');
        } else if (cls == Long.TYPE) {
            sb.append('J');
        } else if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append('D');
        } else if (cls == Void.TYPE) {
            sb.append('V');
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unrecognized primitive type: ");
            sb2.append(cls.getName());
            throw new IllegalStateException(sb2.toString());
        }
        return sb;
    }

    protected static JavaType _bogusSuperClass(Class<?> cls) {
        if (cls.getSuperclass() == null) {
            return null;
        }
        return TypeFactory.unknownType();
    }
}
