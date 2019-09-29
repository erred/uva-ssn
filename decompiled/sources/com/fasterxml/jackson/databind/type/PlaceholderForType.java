package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public class PlaceholderForType extends TypeBase {
    private static final long serialVersionUID = 1;
    protected JavaType _actualType;
    protected final int _ordinal;

    public boolean equals(Object obj) {
        return obj == this;
    }

    public boolean isContainerType() {
        return false;
    }

    public PlaceholderForType(int i) {
        super(Object.class, TypeBindings.emptyBindings(), TypeFactory.unknownType(), null, 1, null, null, false);
        this._ordinal = i;
    }

    public JavaType actualType() {
        return this._actualType;
    }

    public void actualType(JavaType javaType) {
        this._actualType = javaType;
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        return toString();
    }

    public StringBuilder getGenericSignature(StringBuilder sb) {
        return getErasedSignature(sb);
    }

    public StringBuilder getErasedSignature(StringBuilder sb) {
        sb.append('$');
        sb.append(this._ordinal + 1);
        return sb;
    }

    public JavaType withTypeHandler(Object obj) {
        return (JavaType) _unsupported();
    }

    public JavaType withContentTypeHandler(Object obj) {
        return (JavaType) _unsupported();
    }

    public JavaType withValueHandler(Object obj) {
        return (JavaType) _unsupported();
    }

    public JavaType withContentValueHandler(Object obj) {
        return (JavaType) _unsupported();
    }

    public JavaType withContentType(JavaType javaType) {
        return (JavaType) _unsupported();
    }

    public JavaType withStaticTyping() {
        return (JavaType) _unsupported();
    }

    public JavaType refine(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return (JavaType) _unsupported();
    }

    /* access modifiers changed from: protected */
    public JavaType _narrow(Class<?> cls) {
        return (JavaType) _unsupported();
    }

    public String toString() {
        return getErasedSignature(new StringBuilder()).toString();
    }

    private <T> T _unsupported() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operation should not be attempted on ");
        sb.append(getClass().getName());
        throw new UnsupportedOperationException(sb.toString());
    }
}
