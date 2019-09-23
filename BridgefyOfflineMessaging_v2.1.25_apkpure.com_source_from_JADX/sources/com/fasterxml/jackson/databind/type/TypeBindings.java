package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TypeBindings implements Serializable {
    private static final TypeBindings EMPTY = new TypeBindings(NO_STRINGS, NO_TYPES, null);
    private static final String[] NO_STRINGS = new String[0];
    private static final JavaType[] NO_TYPES = new JavaType[0];
    private static final long serialVersionUID = 1;
    private final int _hashCode;
    private final String[] _names;
    private final JavaType[] _types;
    private final String[] _unboundVariables;

    static final class AsKey {
        private final int _hash;
        private final JavaType[] _params;
        private final Class<?> _raw;

        public AsKey(Class<?> cls, JavaType[] javaTypeArr, int i) {
            this._raw = cls;
            this._params = javaTypeArr;
            this._hash = i;
        }

        public int hashCode() {
            return this._hash;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            AsKey asKey = (AsKey) obj;
            if (this._hash == asKey._hash && this._raw == asKey._raw) {
                JavaType[] javaTypeArr = asKey._params;
                int length = this._params.length;
                if (length == javaTypeArr.length) {
                    for (int i = 0; i < length; i++) {
                        if (!this._params[i].equals(javaTypeArr[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this._raw.getName());
            sb.append(SimpleComparison.NOT_EQUAL_TO_OPERATION);
            return sb.toString();
        }
    }

    static class TypeParamStash {
        private static final TypeVariable<?>[] VARS_ABSTRACT_LIST = AbstractList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ARRAY_LIST = ArrayList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_COLLECTION = Collection.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_HASH_MAP = HashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ITERABLE = Iterable.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LINKED_HASH_MAP = LinkedHashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LIST = List.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_MAP = Map.class.getTypeParameters();

        TypeParamStash() {
        }

        public static TypeVariable<?>[] paramsFor1(Class<?> cls) {
            if (cls == Collection.class) {
                return VARS_COLLECTION;
            }
            if (cls == List.class) {
                return VARS_LIST;
            }
            if (cls == ArrayList.class) {
                return VARS_ARRAY_LIST;
            }
            if (cls == AbstractList.class) {
                return VARS_ABSTRACT_LIST;
            }
            if (cls == Iterable.class) {
                return VARS_ITERABLE;
            }
            return cls.getTypeParameters();
        }

        public static TypeVariable<?>[] paramsFor2(Class<?> cls) {
            if (cls == Map.class) {
                return VARS_MAP;
            }
            if (cls == HashMap.class) {
                return VARS_HASH_MAP;
            }
            if (cls == LinkedHashMap.class) {
                return VARS_LINKED_HASH_MAP;
            }
            return cls.getTypeParameters();
        }
    }

    private TypeBindings(String[] strArr, JavaType[] javaTypeArr, String[] strArr2) {
        if (strArr == null) {
            strArr = NO_STRINGS;
        }
        this._names = strArr;
        if (javaTypeArr == null) {
            javaTypeArr = NO_TYPES;
        }
        this._types = javaTypeArr;
        if (this._names.length == this._types.length) {
            int i = 1;
            for (JavaType hashCode : this._types) {
                i += hashCode.hashCode();
            }
            this._unboundVariables = strArr2;
            this._hashCode = i;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Mismatching names (");
        sb.append(this._names.length);
        sb.append("), types (");
        sb.append(this._types.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings emptyBindings() {
        return EMPTY;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        if (this._names == null || this._names.length == 0) {
            return EMPTY;
        }
        return this;
    }

    public static TypeBindings create(Class<?> cls, List<JavaType> list) {
        return create(cls, (list == null || list.isEmpty()) ? NO_TYPES : (JavaType[]) list.toArray(new JavaType[list.size()]));
    }

    public static TypeBindings create(Class<?> cls, JavaType[] javaTypeArr) {
        String[] strArr;
        if (javaTypeArr == null) {
            javaTypeArr = NO_TYPES;
        } else {
            switch (javaTypeArr.length) {
                case 1:
                    return create(cls, javaTypeArr[0]);
                case 2:
                    return create(cls, javaTypeArr[0], javaTypeArr[1]);
            }
        }
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = NO_STRINGS;
        } else {
            int length = typeParameters.length;
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = typeParameters[i].getName();
            }
        }
        if (strArr.length == javaTypeArr.length) {
            return new TypeBindings(strArr, javaTypeArr, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with ");
        sb.append(javaTypeArr.length);
        sb.append(" type parameter");
        sb.append(javaTypeArr.length == 1 ? "" : "s");
        sb.append(": class expects ");
        sb.append(strArr.length);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings create(Class<?> cls, JavaType javaType) {
        int i;
        TypeVariable[] paramsFor1 = TypeParamStash.paramsFor1(cls);
        if (paramsFor1 == null) {
            i = 0;
        } else {
            i = paramsFor1.length;
        }
        if (i == 1) {
            return new TypeBindings(new String[]{paramsFor1[0].getName()}, new JavaType[]{javaType}, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with 1 type parameter: class expects ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings create(Class<?> cls, JavaType javaType, JavaType javaType2) {
        int i;
        TypeVariable[] paramsFor2 = TypeParamStash.paramsFor2(cls);
        if (paramsFor2 == null) {
            i = 0;
        } else {
            i = paramsFor2.length;
        }
        if (i == 2) {
            return new TypeBindings(new String[]{paramsFor2[0].getName(), paramsFor2[1].getName()}, new JavaType[]{javaType, javaType2}, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with 2 type parameters: class expects ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings createIfNeeded(Class<?> cls, JavaType javaType) {
        int i;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null) {
            i = 0;
        } else {
            i = typeParameters.length;
        }
        if (i == 0) {
            return EMPTY;
        }
        if (i == 1) {
            return new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaType}, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with 1 type parameter: class expects ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings createIfNeeded(Class<?> cls, JavaType[] javaTypeArr) {
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            return EMPTY;
        }
        if (javaTypeArr == null) {
            javaTypeArr = NO_TYPES;
        }
        int length = typeParameters.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = typeParameters[i].getName();
        }
        if (strArr.length == javaTypeArr.length) {
            return new TypeBindings(strArr, javaTypeArr, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with ");
        sb.append(javaTypeArr.length);
        sb.append(" type parameter");
        sb.append(javaTypeArr.length == 1 ? "" : "s");
        sb.append(": class expects ");
        sb.append(strArr.length);
        throw new IllegalArgumentException(sb.toString());
    }

    public TypeBindings withUnboundVariable(String str) {
        int length = this._unboundVariables == null ? 0 : this._unboundVariables.length;
        String[] strArr = length == 0 ? new String[1] : (String[]) Arrays.copyOf(this._unboundVariables, length + 1);
        strArr[length] = str;
        return new TypeBindings(this._names, this._types, strArr);
    }

    public JavaType findBoundType(String str) {
        int length = this._names.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(this._names[i])) {
                JavaType javaType = this._types[i];
                if (javaType instanceof ResolvedRecursiveType) {
                    JavaType selfReferencedType = ((ResolvedRecursiveType) javaType).getSelfReferencedType();
                    if (selfReferencedType != null) {
                        javaType = selfReferencedType;
                    }
                }
                return javaType;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this._types.length == 0;
    }

    public int size() {
        return this._types.length;
    }

    public String getBoundName(int i) {
        if (i < 0 || i >= this._names.length) {
            return null;
        }
        return this._names[i];
    }

    public JavaType getBoundType(int i) {
        if (i < 0 || i >= this._types.length) {
            return null;
        }
        return this._types[i];
    }

    public List<JavaType> getTypeParameters() {
        if (this._types.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(this._types);
    }

    public boolean hasUnbound(String str) {
        if (this._unboundVariables != null) {
            int length = this._unboundVariables.length;
            do {
                length--;
                if (length >= 0) {
                }
            } while (!str.equals(this._unboundVariables[length]));
            return true;
        }
        return false;
    }

    public Object asKey(Class<?> cls) {
        return new AsKey(cls, this._types, this._hashCode);
    }

    public String toString() {
        if (this._types.length == 0) {
            return SimpleComparison.NOT_EQUAL_TO_OPERATION;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int length = this._types.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this._types[i].getGenericSignature());
        }
        sb.append('>');
        return sb.toString();
    }

    public int hashCode() {
        return this._hashCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        TypeBindings typeBindings = (TypeBindings) obj;
        int length = this._types.length;
        if (length != typeBindings.size()) {
            return false;
        }
        JavaType[] javaTypeArr = typeBindings._types;
        for (int i = 0; i < length; i++) {
            if (!javaTypeArr[i].equals(this._types[i])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public JavaType[] typeParameterArray() {
        return this._types;
    }
}
