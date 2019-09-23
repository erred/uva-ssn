package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;

public abstract class ReferenceTypeSerializer<T> extends StdSerializer<T> implements ContextualSerializer {
    private static final long serialVersionUID = 1;
    protected final Include _contentInclusion;
    protected transient PropertySerializerMap _dynamicSerializers;
    protected final BeanProperty _property;
    protected final JavaType _referredType;
    protected final NameTransformer _unwrapper;
    protected final JsonSerializer<Object> _valueSerializer;
    protected final TypeSerializer _valueTypeSerializer;

    /* access modifiers changed from: protected */
    public abstract Object _getReferenced(T t);

    /* access modifiers changed from: protected */
    public abstract Object _getReferencedIfPresent(T t);

    /* access modifiers changed from: protected */
    public abstract boolean _isValueEmpty(T t);

    /* access modifiers changed from: protected */
    public abstract ReferenceTypeSerializer<T> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer nameTransformer, Include include);

    public ReferenceTypeSerializer(ReferenceType referenceType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super((JavaType) referenceType);
        this._referredType = referenceType.getReferencedType();
        this._property = null;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._unwrapper = null;
        this._contentInclusion = null;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
    }

    protected ReferenceTypeSerializer(ReferenceTypeSerializer<?> referenceTypeSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer nameTransformer, Include include) {
        super((StdSerializer<?>) referenceTypeSerializer);
        this._referredType = referenceTypeSerializer._referredType;
        this._dynamicSerializers = referenceTypeSerializer._dynamicSerializers;
        this._property = beanProperty;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._unwrapper = nameTransformer;
        if (include == Include.USE_DEFAULTS || include == Include.ALWAYS) {
            this._contentInclusion = null;
        } else {
            this._contentInclusion = include;
        }
    }

    public JsonSerializer<T> unwrappingSerializer(NameTransformer nameTransformer) {
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer != null) {
            jsonSerializer = jsonSerializer.unwrappingSerializer(nameTransformer);
        }
        JsonSerializer<Object> jsonSerializer2 = jsonSerializer;
        if (this._unwrapper != null) {
            nameTransformer = NameTransformer.chainedTransformer(nameTransformer, this._unwrapper);
        }
        return withResolved(this._property, this._valueTypeSerializer, jsonSerializer2, nameTransformer, this._contentInclusion);
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        if (typeSerializer != null) {
            typeSerializer = typeSerializer.forProperty(beanProperty);
        }
        TypeSerializer typeSerializer2 = typeSerializer;
        JsonSerializer<Object> findAnnotatedContentSerializer = findAnnotatedContentSerializer(serializerProvider, beanProperty);
        if (findAnnotatedContentSerializer == null) {
            findAnnotatedContentSerializer = this._valueSerializer;
            if (findAnnotatedContentSerializer != null) {
                findAnnotatedContentSerializer = serializerProvider.handlePrimaryContextualization(findAnnotatedContentSerializer, beanProperty);
            } else if (_useStatic(serializerProvider, beanProperty, this._referredType)) {
                findAnnotatedContentSerializer = _findSerializer(serializerProvider, this._referredType, beanProperty);
            }
        }
        JsonSerializer<Object> jsonSerializer = findAnnotatedContentSerializer;
        Include include = this._contentInclusion;
        Include contentInclusion = findIncludeOverrides(serializerProvider, beanProperty, handledType()).getContentInclusion();
        return withResolved(beanProperty, typeSerializer2, jsonSerializer, this._unwrapper, (contentInclusion == include || contentInclusion == Include.USE_DEFAULTS) ? include : contentInclusion);
    }

    /* access modifiers changed from: protected */
    public boolean _useStatic(SerializerProvider serializerProvider, BeanProperty beanProperty, JavaType javaType) {
        if (javaType.isJavaLangObject()) {
            return false;
        }
        if (javaType.isFinal() || javaType.useStaticType()) {
            return true;
        }
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        if (!(annotationIntrospector == null || beanProperty == null || beanProperty.getMember() == null)) {
            Typing findSerializationTyping = annotationIntrospector.findSerializationTyping(beanProperty.getMember());
            if (findSerializationTyping == Typing.STATIC) {
                return true;
            }
            if (findSerializationTyping == Typing.DYNAMIC) {
                return false;
            }
        }
        return serializerProvider.isEnabled(MapperFeature.USE_STATIC_TYPING);
    }

    public boolean isEmpty(SerializerProvider serializerProvider, T t) {
        if (t == null || _isValueEmpty(t)) {
            return true;
        }
        if (this._contentInclusion == null) {
            return false;
        }
        Object _getReferenced = _getReferenced(t);
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer == null) {
            try {
                jsonSerializer = _findCachedSerializer(serializerProvider, _getReferenced.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        return jsonSerializer.isEmpty(serializerProvider, _getReferenced);
    }

    public boolean isUnwrappingSerializer() {
        return this._unwrapper != null;
    }

    public void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object _getReferencedIfPresent = _getReferencedIfPresent(t);
        if (_getReferencedIfPresent == null) {
            if (this._unwrapper == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            }
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = _findCachedSerializer(serializerProvider, _getReferencedIfPresent.getClass());
        }
        if (this._valueTypeSerializer != null) {
            jsonSerializer.serializeWithType(_getReferencedIfPresent, jsonGenerator, serializerProvider, this._valueTypeSerializer);
        } else {
            jsonSerializer.serialize(_getReferencedIfPresent, jsonGenerator, serializerProvider);
        }
    }

    public void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Object _getReferencedIfPresent = _getReferencedIfPresent(t);
        if (_getReferencedIfPresent == null) {
            if (this._unwrapper == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            }
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = _findCachedSerializer(serializerProvider, _getReferencedIfPresent.getClass());
        }
        jsonSerializer.serializeWithType(_getReferencedIfPresent, jsonGenerator, serializerProvider, typeSerializer);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = _findSerializer(jsonFormatVisitorWrapper.getProvider(), this._referredType, this._property);
            if (this._unwrapper != null) {
                jsonSerializer = jsonSerializer.unwrappingSerializer(this._unwrapper);
            }
        }
        jsonSerializer.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, this._referredType);
    }

    private final JsonSerializer<Object> _findCachedSerializer(SerializerProvider serializerProvider, Class<?> cls) throws JsonMappingException {
        JsonSerializer<Object> serializerFor = this._dynamicSerializers.serializerFor(cls);
        if (serializerFor != null) {
            return serializerFor;
        }
        JsonSerializer _findSerializer = _findSerializer(serializerProvider, cls, this._property);
        if (this._unwrapper != null) {
            _findSerializer = _findSerializer.unwrappingSerializer(this._unwrapper);
        }
        JsonSerializer jsonSerializer = _findSerializer;
        this._dynamicSerializers = this._dynamicSerializers.newWith(cls, jsonSerializer);
        return jsonSerializer;
    }

    private final JsonSerializer<Object> _findSerializer(SerializerProvider serializerProvider, Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        return serializerProvider.findValueSerializer(cls, beanProperty);
    }

    private final JsonSerializer<Object> _findSerializer(SerializerProvider serializerProvider, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return serializerProvider.findValueSerializer(javaType, beanProperty);
    }
}
