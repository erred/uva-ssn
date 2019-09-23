package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Collection;

public abstract class JsonDeserializer<T> {

    public static abstract class None extends JsonDeserializer<Object> {
        private None() {
        }
    }

    public abstract T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException;

    public JsonDeserializer<?> getDelegatee() {
        return null;
    }

    public Collection<Object> getKnownPropertyNames() {
        return null;
    }

    @Deprecated
    public T getNullValue() {
        return null;
    }

    public ObjectIdReader getObjectIdReader() {
        return null;
    }

    public Class<?> handledType() {
        return null;
    }

    public boolean isCachable() {
        return false;
    }

    public JsonDeserializer<T> unwrappingDeserializer(NameTransformer nameTransformer) {
        return this;
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, T t) throws IOException, JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        sb.append("Can not update object of type ");
        sb.append(t.getClass().getName());
        sb.append(" (by deserializer of type ");
        sb.append(getClass().getName());
        sb.append(")");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public JsonDeserializer<?> replaceDelegatee(JsonDeserializer<?> jsonDeserializer) {
        throw new UnsupportedOperationException();
    }

    public T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return getNullValue();
    }

    public T getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return getEmptyValue();
    }

    public SettableBeanProperty findBackReference(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Can not handle managed/back reference '");
        sb.append(str);
        sb.append("': type: value deserializer of type ");
        sb.append(getClass().getName());
        sb.append(" does not support them");
        throw new IllegalArgumentException(sb.toString());
    }

    @Deprecated
    public T getEmptyValue() {
        return getNullValue();
    }
}
