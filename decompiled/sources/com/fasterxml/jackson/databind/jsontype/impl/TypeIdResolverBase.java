package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;

public abstract class TypeIdResolverBase implements TypeIdResolver {
    protected final JavaType _baseType;
    protected final TypeFactory _typeFactory;

    public String getDescForKnownTypeIds() {
        return null;
    }

    public void init(JavaType javaType) {
    }

    protected TypeIdResolverBase() {
        this(null, null);
    }

    protected TypeIdResolverBase(JavaType javaType, TypeFactory typeFactory) {
        this._baseType = javaType;
        this._typeFactory = typeFactory;
    }

    public String idFromBaseType() {
        return idFromValueAndType(null, this._baseType.getRawClass());
    }

    public JavaType typeFromId(DatabindContext databindContext, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Sub-class ");
        sb.append(getClass().getName());
        sb.append(" MUST implement ");
        sb.append("`typeFromId(DatabindContext,String)");
        throw new IllegalStateException(sb.toString());
    }
}
