package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class NumberSerializers {

    /* renamed from: com.fasterxml.jackson.databind.ser.std.NumberSerializers$1 */
    static /* synthetic */ class C19821 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape = new int[Shape.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[Shape.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    protected static abstract class Base<T> extends StdScalarSerializer<T> implements ContextualSerializer {
        protected final boolean _isInt;
        protected final NumberType _numberType;
        protected final String _schemaType;

        protected Base(Class<?> cls, NumberType numberType, String str) {
            boolean z = false;
            super(cls, false);
            this._numberType = numberType;
            this._schemaType = str;
            if (numberType == NumberType.INT || numberType == NumberType.LONG || numberType == NumberType.BIG_INTEGER) {
                z = true;
            }
            this._isInt = z;
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(this._schemaType, true);
        }

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
            if (this._isInt) {
                visitIntFormat(jsonFormatVisitorWrapper, javaType, this._numberType);
            } else {
                visitFloatFormat(jsonFormatVisitorWrapper, javaType, this._numberType);
            }
        }

        public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            Value findFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, handledType());
            return (findFormatOverrides == null || C19821.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[findFormatOverrides.getShape().ordinal()] != 1) ? this : ToStringSerializer.instance;
        }
    }

    @JacksonStdImpl
    public static final class DoubleSerializer extends Base<Object> {
        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
        }

        public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            return super.createContextual(serializerProvider, beanProperty);
        }

        public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return super.getSchema(serializerProvider, type);
        }

        public DoubleSerializer(Class<?> cls) {
            super(cls, NumberType.DOUBLE, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(((Double) obj).doubleValue());
        }

        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
            serialize(obj, jsonGenerator, serializerProvider);
        }
    }

    @JacksonStdImpl
    public static final class FloatSerializer extends Base<Object> {
        static final FloatSerializer instance = new FloatSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
        }

        public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            return super.createContextual(serializerProvider, beanProperty);
        }

        public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return super.getSchema(serializerProvider, type);
        }

        public FloatSerializer() {
            super(Float.class, NumberType.FLOAT, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(((Float) obj).floatValue());
        }
    }

    @JacksonStdImpl
    public static final class IntLikeSerializer extends Base<Object> {
        static final IntLikeSerializer instance = new IntLikeSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
        }

        public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            return super.createContextual(serializerProvider, beanProperty);
        }

        public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return super.getSchema(serializerProvider, type);
        }

        public IntLikeSerializer() {
            super(Number.class, NumberType.INT, "integer");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(((Number) obj).intValue());
        }
    }

    @JacksonStdImpl
    public static final class IntegerSerializer extends Base<Object> {
        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
        }

        public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            return super.createContextual(serializerProvider, beanProperty);
        }

        public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return super.getSchema(serializerProvider, type);
        }

        public IntegerSerializer(Class<?> cls) {
            super(cls, NumberType.INT, "integer");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(((Integer) obj).intValue());
        }

        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
            serialize(obj, jsonGenerator, serializerProvider);
        }
    }

    @JacksonStdImpl
    public static final class LongSerializer extends Base<Object> {
        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
        }

        public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            return super.createContextual(serializerProvider, beanProperty);
        }

        public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return super.getSchema(serializerProvider, type);
        }

        public LongSerializer(Class<?> cls) {
            super(cls, NumberType.LONG, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(((Long) obj).longValue());
        }
    }

    @JacksonStdImpl
    public static final class ShortSerializer extends Base<Object> {
        static final ShortSerializer instance = new ShortSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
        }

        public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            return super.createContextual(serializerProvider, beanProperty);
        }

        public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return super.getSchema(serializerProvider, type);
        }

        public ShortSerializer() {
            super(Short.class, NumberType.INT, "number");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(((Short) obj).shortValue());
        }
    }

    protected NumberSerializers() {
    }

    public static void addAll(Map<String, JsonSerializer<?>> map) {
        map.put(Integer.class.getName(), new IntegerSerializer(Integer.class));
        map.put(Integer.TYPE.getName(), new IntegerSerializer(Integer.TYPE));
        map.put(Long.class.getName(), new LongSerializer(Long.class));
        map.put(Long.TYPE.getName(), new LongSerializer(Long.TYPE));
        map.put(Byte.class.getName(), IntLikeSerializer.instance);
        map.put(Byte.TYPE.getName(), IntLikeSerializer.instance);
        map.put(Short.class.getName(), ShortSerializer.instance);
        map.put(Short.TYPE.getName(), ShortSerializer.instance);
        map.put(Double.class.getName(), new DoubleSerializer(Double.class));
        map.put(Double.TYPE.getName(), new DoubleSerializer(Double.TYPE));
        map.put(Float.class.getName(), FloatSerializer.instance);
        map.put(Float.TYPE.getName(), FloatSerializer.instance);
    }
}
