package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    protected PropertySerializerMap _dynamicSerializers;
    protected final JsonSerializer<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final BeanProperty _property;
    protected final boolean _staticTyping;
    protected final Boolean _unwrapSingle;
    protected final TypeSerializer _valueTypeSerializer;

    /* access modifiers changed from: protected */
    public abstract void serializeContents(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public abstract AsArraySerializerBase<T> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool);

    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        boolean z2 = false;
        super(cls, false);
        this._elementType = javaType;
        if (z || (javaType != null && javaType.isFinal())) {
            z2 = true;
        }
        this._staticTyping = z2;
        this._valueTypeSerializer = typeSerializer;
        this._property = null;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
        this._unwrapSingle = null;
    }

    @Deprecated
    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        boolean z2 = false;
        super(cls, false);
        this._elementType = javaType;
        if (z || (javaType != null && javaType.isFinal())) {
            z2 = true;
        }
        this._staticTyping = z2;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
        this._unwrapSingle = null;
    }

    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super((ContainerSerializer<?>) asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = asArraySerializerBase._dynamicSerializers;
        this._unwrapSingle = bool;
    }

    @Deprecated
    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        this(asArraySerializerBase, beanProperty, typeSerializer, jsonSerializer, asArraySerializerBase._unwrapSingle);
    }

    @Deprecated
    public final AsArraySerializerBase<T> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        return withResolved(beanProperty, typeSerializer, jsonSerializer, this._unwrapSingle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r5, com.fasterxml.jackson.databind.BeanProperty r6) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r4 = this;
            com.fasterxml.jackson.databind.jsontype.TypeSerializer r0 = r4._valueTypeSerializer
            if (r0 == 0) goto L_0x0008
            com.fasterxml.jackson.databind.jsontype.TypeSerializer r0 = r0.forProperty(r6)
        L_0x0008:
            r1 = 0
            if (r6 == 0) goto L_0x0020
            com.fasterxml.jackson.databind.AnnotationIntrospector r2 = r5.getAnnotationIntrospector()
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r3 = r6.getMember()
            if (r3 == 0) goto L_0x0020
            java.lang.Object r2 = r2.findContentSerializer(r3)
            if (r2 == 0) goto L_0x0020
            com.fasterxml.jackson.databind.JsonSerializer r2 = r5.serializerInstance(r3, r2)
            goto L_0x0021
        L_0x0020:
            r2 = r1
        L_0x0021:
            java.lang.Class r3 = r4.handledType()
            com.fasterxml.jackson.annotation.JsonFormat$Value r3 = r4.findFormatOverrides(r5, r6, r3)
            if (r3 == 0) goto L_0x0031
            com.fasterxml.jackson.annotation.JsonFormat$Feature r1 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r1 = r3.getFeature(r1)
        L_0x0031:
            if (r2 != 0) goto L_0x0035
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r2 = r4._elementSerializer
        L_0x0035:
            com.fasterxml.jackson.databind.JsonSerializer r2 = r4.findConvertingContentSerializer(r5, r6, r2)
            if (r2 != 0) goto L_0x0052
            com.fasterxml.jackson.databind.JavaType r3 = r4._elementType
            if (r3 == 0) goto L_0x0056
            boolean r3 = r4._staticTyping
            if (r3 == 0) goto L_0x0056
            com.fasterxml.jackson.databind.JavaType r3 = r4._elementType
            boolean r3 = r3.isJavaLangObject()
            if (r3 != 0) goto L_0x0056
            com.fasterxml.jackson.databind.JavaType r2 = r4._elementType
            com.fasterxml.jackson.databind.JsonSerializer r2 = r5.findValueSerializer(r2, r6)
            goto L_0x0056
        L_0x0052:
            com.fasterxml.jackson.databind.JsonSerializer r2 = r5.handleSecondaryContextualization(r2, r6)
        L_0x0056:
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r5 = r4._elementSerializer
            if (r2 != r5) goto L_0x0068
            com.fasterxml.jackson.databind.BeanProperty r5 = r4._property
            if (r6 != r5) goto L_0x0068
            com.fasterxml.jackson.databind.jsontype.TypeSerializer r5 = r4._valueTypeSerializer
            if (r5 != r0) goto L_0x0068
            java.lang.Boolean r5 = r4._unwrapSingle
            if (r5 == r1) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            return r4
        L_0x0068:
            com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase r5 = r4.withResolved(r6, r0, r2, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    public JavaType getContentType() {
        return this._elementType;
    }

    public JsonSerializer<?> getContentSerializer() {
        return this._elementSerializer;
    }

    public void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (!serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) || !hasSingleElement(t)) {
            jsonGenerator.writeStartArray();
            jsonGenerator.setCurrentValue(t);
            serializeContents(t, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
            return;
        }
        serializeContents(t, jsonGenerator, serializerProvider);
    }

    public void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        typeSerializer.writeTypePrefixForArray(t, jsonGenerator);
        jsonGenerator.setCurrentValue(t);
        serializeContents(t, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForArray(t, jsonGenerator);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        ObjectNode createSchemaNode = createSchemaNode("array", true);
        JavaType javaType = this._elementType;
        if (javaType != null) {
            JsonNode jsonNode = null;
            if (javaType.getRawClass() != Object.class) {
                JsonSerializer findValueSerializer = serializerProvider.findValueSerializer(javaType, this._property);
                if (findValueSerializer instanceof SchemaAware) {
                    jsonNode = ((SchemaAware) findValueSerializer).getSchema(serializerProvider, null);
                }
            }
            if (jsonNode == null) {
                jsonNode = JsonSchema.getDefaultSchemaNode();
            }
            createSchemaNode.set("items", jsonNode);
        }
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = jsonFormatVisitorWrapper.getProvider().findValueSerializer(this._elementType, this._property);
        }
        visitArrayFormat(jsonFormatVisitorWrapper, javaType, jsonSerializer, this._elementType);
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(cls, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }
}
