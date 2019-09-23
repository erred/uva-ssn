package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.io.IOException;
import java.util.Iterator;

@JacksonStdImpl
public class IterableSerializer extends AsArraySerializerBase<Iterable<?>> {
    public IterableSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer) {
        super(Iterable.class, javaType, z, typeSerializer, null);
    }

    public IterableSerializer(IterableSerializer iterableSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super((AsArraySerializerBase<?>) iterableSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
        IterableSerializer iterableSerializer = new IterableSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
        return iterableSerializer;
    }

    public IterableSerializer withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        IterableSerializer iterableSerializer = new IterableSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
        return iterableSerializer;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Iterable<?> iterable) {
        return iterable == null || !iterable.iterator().hasNext();
    }

    public boolean hasSingleElement(Iterable<?> iterable) {
        if (iterable != null) {
            Iterator it = iterable.iterator();
            if (it.hasNext()) {
                it.next();
                if (!it.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void serialize(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (((this._unwrapSingle != null || !serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this._unwrapSingle != Boolean.TRUE) || !hasSingleElement(iterable)) {
            jsonGenerator.writeStartArray();
            serializeContents(iterable, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
            return;
        }
        serializeContents(iterable, jsonGenerator, serializerProvider);
    }

    public void serializeContents(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Class cls;
        JsonSerializer jsonSerializer;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            Class cls2 = null;
            JsonSerializer jsonSerializer2 = null;
            do {
                Object next = it.next();
                if (next == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else {
                    JsonSerializer jsonSerializer3 = this._elementSerializer;
                    if (jsonSerializer3 == null) {
                        cls = next.getClass();
                        if (cls == cls2) {
                            cls = cls2;
                        } else {
                            jsonSerializer2 = serializerProvider.findValueSerializer(cls, this._property);
                        }
                        jsonSerializer = jsonSerializer2;
                    } else {
                        JsonSerializer jsonSerializer4 = jsonSerializer3;
                        cls = cls2;
                        jsonSerializer = jsonSerializer2;
                        jsonSerializer2 = jsonSerializer4;
                    }
                    if (typeSerializer == null) {
                        jsonSerializer2.serialize(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer2.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    jsonSerializer2 = jsonSerializer;
                    cls2 = cls;
                }
            } while (it.hasNext());
        }
    }
}
