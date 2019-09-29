package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSerializer extends AsArraySerializerBase<Collection<?>> {
    private static final long serialVersionUID = 1;

    public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(Collection.class, javaType, z, typeSerializer, jsonSerializer);
    }

    @Deprecated
    public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        this(javaType, z, typeSerializer, jsonSerializer);
    }

    public CollectionSerializer(CollectionSerializer collectionSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super((AsArraySerializerBase<?>) collectionSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
        CollectionSerializer collectionSerializer = new CollectionSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
        return collectionSerializer;
    }

    public CollectionSerializer withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        CollectionSerializer collectionSerializer = new CollectionSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
        return collectionSerializer;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public boolean hasSingleElement(Collection<?> collection) {
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    public final void serialize(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        int size = collection.size();
        if (size != 1 || ((this._unwrapSingle != null || !serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this._unwrapSingle != Boolean.TRUE)) {
            jsonGenerator.writeStartArray(size);
            serializeContents(collection, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
            return;
        }
        serializeContents(collection, jsonGenerator, serializerProvider);
    }

    public void serializeContents(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer jsonSerializer;
        if (this._elementSerializer != null) {
            serializeContentsUsing(collection, jsonGenerator, serializerProvider, this._elementSerializer);
            return;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            int i = 0;
            do {
                try {
                    Object next = it.next();
                    if (next == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class cls = next.getClass();
                        JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                        if (serializerFor == null) {
                            if (this._elementType.hasGenericTypes()) {
                                jsonSerializer = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._elementType, cls), serializerProvider);
                            } else {
                                jsonSerializer = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                            }
                            serializerFor = jsonSerializer;
                            propertySerializerMap = this._dynamicSerializers;
                        }
                        if (typeSerializer == null) {
                            serializerFor.serialize(next, jsonGenerator, serializerProvider);
                        } else {
                            serializerFor.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                    i++;
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) collection, i);
                }
            } while (it.hasNext());
        }
    }

    public void serializeContentsUsing(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException, JsonGenerationException {
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            int i = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } catch (Exception e) {
                        wrapAndThrow(serializerProvider, (Throwable) e, (Object) collection, i);
                    }
                } else if (typeSerializer == null) {
                    jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            } while (it.hasNext());
        }
    }
}
