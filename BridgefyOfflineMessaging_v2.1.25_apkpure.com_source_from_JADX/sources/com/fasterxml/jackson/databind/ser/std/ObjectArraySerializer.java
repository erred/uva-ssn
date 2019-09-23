package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.type.ArrayType;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
public class ObjectArraySerializer extends ArraySerializerBase<Object[]> implements ContextualSerializer {
    protected PropertySerializerMap _dynamicSerializers;
    protected JsonSerializer<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final boolean _staticTyping;
    protected final TypeSerializer _valueTypeSerializer;

    public ObjectArraySerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(Object[].class);
        this._elementType = javaType;
        this._staticTyping = z;
        this._valueTypeSerializer = typeSerializer;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
        this._elementSerializer = jsonSerializer;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, TypeSerializer typeSerializer) {
        super((ArraySerializerBase<?>) objectArraySerializer);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = typeSerializer;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = objectArraySerializer._dynamicSerializers;
        this._elementSerializer = objectArraySerializer._elementSerializer;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(objectArraySerializer, beanProperty, bool);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = typeSerializer;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = objectArraySerializer._dynamicSerializers;
        this._elementSerializer = jsonSerializer;
    }

    public JsonSerializer<?> _withResolved(BeanProperty beanProperty, Boolean bool) {
        ObjectArraySerializer objectArraySerializer = new ObjectArraySerializer(this, beanProperty, this._valueTypeSerializer, this._elementSerializer, bool);
        return objectArraySerializer;
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
        return new ObjectArraySerializer(this._elementType, this._staticTyping, typeSerializer, this._elementSerializer);
    }

    public ObjectArraySerializer withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        if (this._property == beanProperty && jsonSerializer == this._elementSerializer && this._valueTypeSerializer == typeSerializer && this._unwrapSingle == bool) {
            return this;
        }
        ObjectArraySerializer objectArraySerializer = new ObjectArraySerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
        return objectArraySerializer;
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
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r6.getMember()
            com.fasterxml.jackson.databind.AnnotationIntrospector r3 = r5.getAnnotationIntrospector()
            if (r2 == 0) goto L_0x0020
            java.lang.Object r3 = r3.findContentSerializer(r2)
            if (r3 == 0) goto L_0x0020
            com.fasterxml.jackson.databind.JsonSerializer r2 = r5.serializerInstance(r2, r3)
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
            com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer r5 = r4.withResolved(r6, r0, r2, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    public JavaType getContentType() {
        return this._elementType;
    }

    public JsonSerializer<?> getContentSerializer() {
        return this._elementSerializer;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public boolean hasSingleElement(Object[] objArr) {
        return objArr.length == 1;
    }

    public final void serialize(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        int length = objArr.length;
        if (length != 1 || ((this._unwrapSingle != null || !serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this._unwrapSingle != Boolean.TRUE)) {
            jsonGenerator.writeStartArray(length);
            serializeContents(objArr, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
            return;
        }
        serializeContents(objArr, jsonGenerator, serializerProvider);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0066, code lost:
        throw ((java.lang.Error) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006b, code lost:
        throw com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r7, r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006d, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006c A[ExcHandler: IOException (r7v6 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:12:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void serializeContents(java.lang.Object[] r7, com.fasterxml.jackson.core.JsonGenerator r8, com.fasterxml.jackson.databind.SerializerProvider r9) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r7.length
            if (r0 != 0) goto L_0x0004
            return
        L_0x0004:
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r1 = r6._elementSerializer
            if (r1 == 0) goto L_0x000e
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r0 = r6._elementSerializer
            r6.serializeContentsUsing(r7, r8, r9, r0)
            return
        L_0x000e:
            com.fasterxml.jackson.databind.jsontype.TypeSerializer r1 = r6._valueTypeSerializer
            if (r1 == 0) goto L_0x0016
            r6.serializeTypedContents(r7, r8, r9)
            return
        L_0x0016:
            r1 = 0
            r2 = 0
            com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap r3 = r6._dynamicSerializers     // Catch:{ IOException -> 0x006c, Exception -> 0x004f }
        L_0x001a:
            if (r1 >= r0) goto L_0x004e
            r4 = r7[r1]     // Catch:{ IOException -> 0x006c, Exception -> 0x004f }
            if (r4 != 0) goto L_0x0026
            r9.defaultSerializeNull(r8)     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            goto L_0x004a
        L_0x0024:
            r7 = move-exception
            goto L_0x0051
        L_0x0026:
            java.lang.Class r2 = r4.getClass()     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            com.fasterxml.jackson.databind.JsonSerializer r5 = r3.serializerFor(r2)     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            if (r5 != 0) goto L_0x0047
            com.fasterxml.jackson.databind.JavaType r5 = r6._elementType     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            boolean r5 = r5.hasGenericTypes()     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            if (r5 == 0) goto L_0x0043
            com.fasterxml.jackson.databind.JavaType r5 = r6._elementType     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            com.fasterxml.jackson.databind.JavaType r2 = r9.constructSpecializedType(r5, r2)     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            com.fasterxml.jackson.databind.JsonSerializer r5 = r6._findAndAddDynamic(r3, r2, r9)     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
            goto L_0x0047
        L_0x0043:
            com.fasterxml.jackson.databind.JsonSerializer r5 = r6._findAndAddDynamic(r3, r2, r9)     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
        L_0x0047:
            r5.serialize(r4, r8, r9)     // Catch:{ IOException -> 0x006c, Exception -> 0x0024 }
        L_0x004a:
            int r1 = r1 + 1
            r2 = r4
            goto L_0x001a
        L_0x004e:
            return
        L_0x004f:
            r7 = move-exception
            r4 = r2
        L_0x0051:
            boolean r8 = r7 instanceof java.lang.reflect.InvocationTargetException
            if (r8 == 0) goto L_0x0060
            java.lang.Throwable r8 = r7.getCause()
            if (r8 == 0) goto L_0x0060
            java.lang.Throwable r7 = r7.getCause()
            goto L_0x0051
        L_0x0060:
            boolean r8 = r7 instanceof java.lang.Error
            if (r8 == 0) goto L_0x0067
            java.lang.Error r7 = (java.lang.Error) r7
            throw r7
        L_0x0067:
            com.fasterxml.jackson.databind.JsonMappingException r7 = com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r7, r4, r1)
            throw r7
        L_0x006c:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.serializeContents(java.lang.Object[], com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        throw ((java.lang.Error) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        throw com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r6, r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003c, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b A[ExcHandler: IOException (r6v6 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:2:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void serializeContentsUsing(java.lang.Object[] r6, com.fasterxml.jackson.core.JsonGenerator r7, com.fasterxml.jackson.databind.SerializerProvider r8, com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r9) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.length
            com.fasterxml.jackson.databind.jsontype.TypeSerializer r1 = r5._valueTypeSerializer
            r2 = 0
            r3 = 0
        L_0x0005:
            if (r2 >= r0) goto L_0x003d
            r4 = r6[r2]     // Catch:{ IOException -> 0x003b, Exception -> 0x001e }
            if (r4 != 0) goto L_0x0011
            r8.defaultSerializeNull(r7)     // Catch:{ IOException -> 0x003b, Exception -> 0x000f }
            goto L_0x001a
        L_0x000f:
            r6 = move-exception
            goto L_0x0020
        L_0x0011:
            if (r1 != 0) goto L_0x0017
            r9.serialize(r4, r7, r8)     // Catch:{ IOException -> 0x003b, Exception -> 0x000f }
            goto L_0x001a
        L_0x0017:
            r9.serializeWithType(r4, r7, r8, r1)     // Catch:{ IOException -> 0x003b, Exception -> 0x000f }
        L_0x001a:
            int r2 = r2 + 1
            r3 = r4
            goto L_0x0005
        L_0x001e:
            r6 = move-exception
            r4 = r3
        L_0x0020:
            boolean r7 = r6 instanceof java.lang.reflect.InvocationTargetException
            if (r7 == 0) goto L_0x002f
            java.lang.Throwable r7 = r6.getCause()
            if (r7 == 0) goto L_0x002f
            java.lang.Throwable r6 = r6.getCause()
            goto L_0x0020
        L_0x002f:
            boolean r7 = r6 instanceof java.lang.Error
            if (r7 == 0) goto L_0x0036
            java.lang.Error r6 = (java.lang.Error) r6
            throw r6
        L_0x0036:
            com.fasterxml.jackson.databind.JsonMappingException r6 = com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r6, r4, r2)
            throw r6
        L_0x003b:
            r6 = move-exception
            throw r6
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.serializeContentsUsing(java.lang.Object[], com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.JsonSerializer):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        throw ((java.lang.Error) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        throw com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r8, r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0047, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r8 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046 A[ExcHandler: IOException (r8v6 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void serializeTypedContents(java.lang.Object[] r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r8.length
            com.fasterxml.jackson.databind.jsontype.TypeSerializer r1 = r7._valueTypeSerializer
            r2 = 0
            r3 = 0
            com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap r4 = r7._dynamicSerializers     // Catch:{ IOException -> 0x0046, Exception -> 0x0029 }
        L_0x0007:
            if (r2 >= r0) goto L_0x0028
            r5 = r8[r2]     // Catch:{ IOException -> 0x0046, Exception -> 0x0029 }
            if (r5 != 0) goto L_0x0013
            r10.defaultSerializeNull(r9)     // Catch:{ IOException -> 0x0046, Exception -> 0x0011 }
            goto L_0x0024
        L_0x0011:
            r8 = move-exception
            goto L_0x002b
        L_0x0013:
            java.lang.Class r3 = r5.getClass()     // Catch:{ IOException -> 0x0046, Exception -> 0x0011 }
            com.fasterxml.jackson.databind.JsonSerializer r6 = r4.serializerFor(r3)     // Catch:{ IOException -> 0x0046, Exception -> 0x0011 }
            if (r6 != 0) goto L_0x0021
            com.fasterxml.jackson.databind.JsonSerializer r6 = r7._findAndAddDynamic(r4, r3, r10)     // Catch:{ IOException -> 0x0046, Exception -> 0x0011 }
        L_0x0021:
            r6.serializeWithType(r5, r9, r10, r1)     // Catch:{ IOException -> 0x0046, Exception -> 0x0011 }
        L_0x0024:
            int r2 = r2 + 1
            r3 = r5
            goto L_0x0007
        L_0x0028:
            return
        L_0x0029:
            r8 = move-exception
            r5 = r3
        L_0x002b:
            boolean r9 = r8 instanceof java.lang.reflect.InvocationTargetException
            if (r9 == 0) goto L_0x003a
            java.lang.Throwable r9 = r8.getCause()
            if (r9 == 0) goto L_0x003a
            java.lang.Throwable r8 = r8.getCause()
            goto L_0x002b
        L_0x003a:
            boolean r9 = r8 instanceof java.lang.Error
            if (r9 == 0) goto L_0x0041
            java.lang.Error r8 = (java.lang.Error) r8
            throw r8
        L_0x0041:
            com.fasterxml.jackson.databind.JsonMappingException r8 = com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r8, r5, r2)
            throw r8
        L_0x0046:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.serializeTypedContents(java.lang.Object[], com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        ObjectNode createSchemaNode = createSchemaNode("array", true);
        if (type != null) {
            JavaType constructType = serializerProvider.constructType(type);
            if (constructType.isArrayType()) {
                Class<Object> rawClass = ((ArrayType) constructType).getContentType().getRawClass();
                if (rawClass == Object.class) {
                    createSchemaNode.set("items", JsonSchema.getDefaultSchemaNode());
                } else {
                    JsonSerializer findValueSerializer = serializerProvider.findValueSerializer(rawClass, this._property);
                    createSchemaNode.set("items", findValueSerializer instanceof SchemaAware ? ((SchemaAware) findValueSerializer).getSchema(serializerProvider, null) : JsonSchema.getDefaultSchemaNode());
                }
            }
        }
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonArrayFormatVisitor expectArrayFormat = jsonFormatVisitorWrapper.expectArrayFormat(javaType);
        if (expectArrayFormat != null) {
            JavaType moreSpecificType = jsonFormatVisitorWrapper.getProvider().getTypeFactory().moreSpecificType(this._elementType, javaType.getContentType());
            if (moreSpecificType != null) {
                JsonSerializer<Object> jsonSerializer = this._elementSerializer;
                if (jsonSerializer == null) {
                    jsonSerializer = jsonFormatVisitorWrapper.getProvider().findValueSerializer(moreSpecificType, this._property);
                }
                expectArrayFormat.itemsFormat(jsonSerializer, moreSpecificType);
                return;
            }
            throw JsonMappingException.from(jsonFormatVisitorWrapper.getProvider(), "Could not resolve type");
        }
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
