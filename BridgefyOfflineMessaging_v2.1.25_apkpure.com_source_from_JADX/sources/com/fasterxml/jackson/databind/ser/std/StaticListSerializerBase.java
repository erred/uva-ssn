package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Type;
import java.util.Collection;

public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements ContextualSerializer {
    protected final JsonSerializer<String> _serializer;
    protected final Boolean _unwrapSingle;

    public abstract JsonSerializer<?> _withResolved(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, Boolean bool);

    /* access modifiers changed from: protected */
    public abstract void acceptContentVisitor(JsonArrayFormatVisitor jsonArrayFormatVisitor) throws JsonMappingException;

    /* access modifiers changed from: protected */
    public abstract JsonNode contentSchema();

    protected StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._serializer = null;
        this._unwrapSingle = null;
    }

    protected StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super((StdSerializer<?>) staticListSerializerBase);
        this._serializer = jsonSerializer;
        this._unwrapSingle = bool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r5, com.fasterxml.jackson.databind.BeanProperty r6) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r5.getAnnotationIntrospector()
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r6.getMember()
            if (r2 == 0) goto L_0x0018
            java.lang.Object r1 = r1.findContentSerializer(r2)
            if (r1 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.JsonSerializer r1 = r5.serializerInstance(r2, r1)
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.Class r2 = r4.handledType()
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = r4.findFormatOverrides(r5, r6, r2)
            if (r2 == 0) goto L_0x002a
            com.fasterxml.jackson.annotation.JsonFormat$Feature r3 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r2.getFeature(r3)
            goto L_0x002b
        L_0x002a:
            r2 = r0
        L_0x002b:
            if (r1 != 0) goto L_0x002f
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.String> r1 = r4._serializer
        L_0x002f:
            com.fasterxml.jackson.databind.JsonSerializer r1 = r4.findConvertingContentSerializer(r5, r6, r1)
            if (r1 != 0) goto L_0x003c
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            com.fasterxml.jackson.databind.JsonSerializer r5 = r5.findValueSerializer(r1, r6)
            goto L_0x0040
        L_0x003c:
            com.fasterxml.jackson.databind.JsonSerializer r5 = r5.handleSecondaryContextualization(r1, r6)
        L_0x0040:
            boolean r1 = r4.isDefaultSerializer(r5)
            if (r1 == 0) goto L_0x0047
            r5 = r0
        L_0x0047:
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.String> r0 = r4._serializer
            if (r5 != r0) goto L_0x0050
            java.lang.Boolean r0 = r4._unwrapSingle
            if (r2 != r0) goto L_0x0050
            return r4
        L_0x0050:
            com.fasterxml.jackson.databind.JsonSerializer r5 = r4._withResolved(r6, r5, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    @Deprecated
    public boolean isEmpty(T t) {
        return isEmpty((SerializerProvider) null, t);
    }

    public boolean isEmpty(SerializerProvider serializerProvider, T t) {
        return t == null || t.size() == 0;
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("array", true).set("items", contentSchema());
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        acceptContentVisitor(jsonFormatVisitorWrapper.expectArrayFormat(javaType));
    }
}
