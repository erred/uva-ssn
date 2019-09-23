package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedParameter extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final int _index;
    protected final AnnotatedWithParams _owner;
    protected final JavaType _type;

    public AnnotatedElement getAnnotated() {
        return null;
    }

    public String getName() {
        return "";
    }

    public AnnotatedParameter(AnnotatedWithParams annotatedWithParams, JavaType javaType, AnnotationMap annotationMap, int i) {
        super(annotatedWithParams == null ? null : annotatedWithParams.getTypeContext(), annotationMap);
        this._owner = annotatedWithParams;
        this._type = javaType;
        this._index = i;
    }

    public AnnotatedParameter withAnnotations(AnnotationMap annotationMap) {
        if (annotationMap == this._annotations) {
            return this;
        }
        return this._owner.replaceParameterAnnotations(this._index, annotationMap);
    }

    public int getModifiers() {
        return this._owner.getModifiers();
    }

    public Class<?> getRawType() {
        return this._type.getRawClass();
    }

    public JavaType getType() {
        return this._type;
    }

    @Deprecated
    public Type getGenericType() {
        return this._owner.getGenericParameterType(this._index);
    }

    public Class<?> getDeclaringClass() {
        return this._owner.getDeclaringClass();
    }

    public Member getMember() {
        return this._owner.getMember();
    }

    public void setValue(Object obj, Object obj2) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call setValue() on constructor parameter of ");
        sb.append(getDeclaringClass().getName());
        throw new UnsupportedOperationException(sb.toString());
    }

    public Object getValue(Object obj) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call getValue() on constructor parameter of ");
        sb.append(getDeclaringClass().getName());
        throw new UnsupportedOperationException(sb.toString());
    }

    public Type getParameterType() {
        return this._type;
    }

    public AnnotatedWithParams getOwner() {
        return this._owner;
    }

    public int getIndex() {
        return this._index;
    }

    public int hashCode() {
        return this._owner.hashCode() + this._index;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        AnnotatedParameter annotatedParameter = (AnnotatedParameter) obj;
        if (!annotatedParameter._owner.equals(this._owner) || annotatedParameter._index != this._index) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[parameter #");
        sb.append(getIndex());
        sb.append(", annotations: ");
        sb.append(this._annotations);
        sb.append("]");
        return sb.toString();
    }
}
