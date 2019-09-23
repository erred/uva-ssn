package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.io.Serializable;

public class ObjectIdReader implements Serializable {
    private static final long serialVersionUID = 1;
    protected final JsonDeserializer<Object> _deserializer;
    protected final JavaType _idType;
    public final ObjectIdGenerator<?> generator;
    public final SettableBeanProperty idProperty;
    public final PropertyName propertyName;
    public final ObjectIdResolver resolver;

    protected ObjectIdReader(JavaType javaType, PropertyName propertyName2, ObjectIdGenerator<?> objectIdGenerator, JsonDeserializer<?> jsonDeserializer, SettableBeanProperty settableBeanProperty, ObjectIdResolver objectIdResolver) {
        this._idType = javaType;
        this.propertyName = propertyName2;
        this.generator = objectIdGenerator;
        this.resolver = objectIdResolver;
        this._deserializer = jsonDeserializer;
        this.idProperty = settableBeanProperty;
    }

    @Deprecated
    protected ObjectIdReader(JavaType javaType, PropertyName propertyName2, ObjectIdGenerator<?> objectIdGenerator, JsonDeserializer<?> jsonDeserializer, SettableBeanProperty settableBeanProperty) {
        this(javaType, propertyName2, objectIdGenerator, jsonDeserializer, settableBeanProperty, new SimpleObjectIdResolver());
    }

    public static ObjectIdReader construct(JavaType javaType, PropertyName propertyName2, ObjectIdGenerator<?> objectIdGenerator, JsonDeserializer<?> jsonDeserializer, SettableBeanProperty settableBeanProperty, ObjectIdResolver objectIdResolver) {
        ObjectIdReader objectIdReader = new ObjectIdReader(javaType, propertyName2, objectIdGenerator, jsonDeserializer, settableBeanProperty, objectIdResolver);
        return objectIdReader;
    }

    @Deprecated
    public static ObjectIdReader construct(JavaType javaType, PropertyName propertyName2, ObjectIdGenerator<?> objectIdGenerator, JsonDeserializer<?> jsonDeserializer, SettableBeanProperty settableBeanProperty) {
        return construct(javaType, propertyName2, objectIdGenerator, jsonDeserializer, settableBeanProperty, new SimpleObjectIdResolver());
    }

    public JsonDeserializer<Object> getDeserializer() {
        return this._deserializer;
    }

    public JavaType getIdType() {
        return this._idType;
    }

    public boolean maySerializeAsObject() {
        return this.generator.maySerializeAsObject();
    }

    public boolean isValidReferencePropertyName(String str, JsonParser jsonParser) {
        return this.generator.isValidReferencePropertyName(str, jsonParser);
    }

    public Object readObjectReference(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return this._deserializer.deserialize(jsonParser, deserializationContext);
    }
}
