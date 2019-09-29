package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.C1951As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.C1952Id;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.lang.reflect.Type;
import java.util.Collection;

public class StdTypeResolverBuilder implements TypeResolverBuilder<StdTypeResolverBuilder> {
    protected TypeIdResolver _customIdResolver;
    protected Class<?> _defaultImpl;
    protected C1952Id _idType;
    protected C1951As _includeAs;
    protected boolean _typeIdVisible = false;
    protected String _typeProperty;

    public static StdTypeResolverBuilder noTypeInfoBuilder() {
        return new StdTypeResolverBuilder().init(C1952Id.NONE, (TypeIdResolver) null);
    }

    public StdTypeResolverBuilder init(C1952Id id, TypeIdResolver typeIdResolver) {
        if (id != null) {
            this._idType = id;
            this._customIdResolver = typeIdResolver;
            this._typeProperty = id.getDefaultPropertyName();
            return this;
        }
        throw new IllegalArgumentException("idType can not be null");
    }

    public TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this._idType == C1952Id.NONE || javaType.isPrimitive()) {
            return null;
        }
        TypeIdResolver idResolver = idResolver(serializationConfig, javaType, collection, true, false);
        switch (this._includeAs) {
            case WRAPPER_ARRAY:
                return new AsArrayTypeSerializer(idResolver, null);
            case PROPERTY:
                return new AsPropertyTypeSerializer(idResolver, null, this._typeProperty);
            case WRAPPER_OBJECT:
                return new AsWrapperTypeSerializer(idResolver, null);
            case EXTERNAL_PROPERTY:
                return new AsExternalTypeSerializer(idResolver, null, this._typeProperty);
            case EXISTING_PROPERTY:
                return new AsExistingPropertyTypeSerializer(idResolver, null, this._typeProperty);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Do not know how to construct standard type serializer for inclusion type: ");
                sb.append(this._includeAs);
                throw new IllegalStateException(sb.toString());
        }
    }

    public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection) {
        JavaType javaType2 = null;
        if (this._idType == C1952Id.NONE || javaType.isPrimitive()) {
            return null;
        }
        TypeIdResolver idResolver = idResolver(deserializationConfig, javaType, collection, false, true);
        if (this._defaultImpl == null) {
            JavaType javaType3 = javaType;
        } else if (this._defaultImpl == Void.class || this._defaultImpl == NoClass.class) {
            JavaType javaType4 = javaType;
            javaType2 = deserializationConfig.getTypeFactory().constructType((Type) this._defaultImpl);
        } else {
            javaType2 = deserializationConfig.getTypeFactory().constructSpecializedType(javaType, this._defaultImpl);
        }
        JavaType javaType5 = javaType2;
        switch (this._includeAs) {
            case WRAPPER_ARRAY:
                AsArrayTypeDeserializer asArrayTypeDeserializer = new AsArrayTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, javaType5);
                return asArrayTypeDeserializer;
            case PROPERTY:
            case EXISTING_PROPERTY:
                AsPropertyTypeDeserializer asPropertyTypeDeserializer = new AsPropertyTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, javaType5, this._includeAs);
                return asPropertyTypeDeserializer;
            case WRAPPER_OBJECT:
                AsWrapperTypeDeserializer asWrapperTypeDeserializer = new AsWrapperTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, javaType5);
                return asWrapperTypeDeserializer;
            case EXTERNAL_PROPERTY:
                AsExternalTypeDeserializer asExternalTypeDeserializer = new AsExternalTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, javaType5);
                return asExternalTypeDeserializer;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Do not know how to construct standard type serializer for inclusion type: ");
                sb.append(this._includeAs);
                throw new IllegalStateException(sb.toString());
        }
    }

    public StdTypeResolverBuilder inclusion(C1951As as) {
        if (as != null) {
            this._includeAs = as;
            return this;
        }
        throw new IllegalArgumentException("includeAs can not be null");
    }

    public StdTypeResolverBuilder typeProperty(String str) {
        if (str == null || str.length() == 0) {
            str = this._idType.getDefaultPropertyName();
        }
        this._typeProperty = str;
        return this;
    }

    public StdTypeResolverBuilder defaultImpl(Class<?> cls) {
        this._defaultImpl = cls;
        return this;
    }

    public StdTypeResolverBuilder typeIdVisibility(boolean z) {
        this._typeIdVisible = z;
        return this;
    }

    public Class<?> getDefaultImpl() {
        return this._defaultImpl;
    }

    public String getTypeProperty() {
        return this._typeProperty;
    }

    public boolean isTypeIdVisible() {
        return this._typeIdVisible;
    }

    /* access modifiers changed from: protected */
    public TypeIdResolver idResolver(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        if (this._customIdResolver != null) {
            return this._customIdResolver;
        }
        if (this._idType != null) {
            switch (this._idType) {
                case CLASS:
                    return new ClassNameIdResolver(javaType, mapperConfig.getTypeFactory());
                case MINIMAL_CLASS:
                    return new MinimalClassNameIdResolver(javaType, mapperConfig.getTypeFactory());
                case NAME:
                    return TypeNameIdResolver.construct(mapperConfig, javaType, collection, z, z2);
                case NONE:
                    return null;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Do not know how to construct standard type id resolver for idType: ");
                    sb.append(this._idType);
                    throw new IllegalStateException(sb.toString());
            }
        } else {
            throw new IllegalStateException("Can not build, 'init()' not yet called");
        }
    }
}
