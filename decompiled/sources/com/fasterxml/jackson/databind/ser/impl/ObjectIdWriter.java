package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p116io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;

public final class ObjectIdWriter {
    public final boolean alwaysAsId;
    public final ObjectIdGenerator<?> generator;
    public final JavaType idType;
    public final SerializableString propertyName;
    public final JsonSerializer<Object> serializer;

    protected ObjectIdWriter(JavaType javaType, SerializableString serializableString, ObjectIdGenerator<?> objectIdGenerator, JsonSerializer<?> jsonSerializer, boolean z) {
        this.idType = javaType;
        this.propertyName = serializableString;
        this.generator = objectIdGenerator;
        this.serializer = jsonSerializer;
        this.alwaysAsId = z;
    }

    public static ObjectIdWriter construct(JavaType javaType, PropertyName propertyName2, ObjectIdGenerator<?> objectIdGenerator, boolean z) {
        return construct(javaType, propertyName2 == null ? null : propertyName2.getSimpleName(), objectIdGenerator, z);
    }

    @Deprecated
    public static ObjectIdWriter construct(JavaType javaType, String str, ObjectIdGenerator<?> objectIdGenerator, boolean z) {
        ObjectIdWriter objectIdWriter = new ObjectIdWriter(javaType, str == null ? null : new SerializedString(str), objectIdGenerator, null, z);
        return objectIdWriter;
    }

    public ObjectIdWriter withSerializer(JsonSerializer<?> jsonSerializer) {
        ObjectIdWriter objectIdWriter = new ObjectIdWriter(this.idType, this.propertyName, this.generator, jsonSerializer, this.alwaysAsId);
        return objectIdWriter;
    }

    public ObjectIdWriter withAlwaysAsId(boolean z) {
        if (z == this.alwaysAsId) {
            return this;
        }
        ObjectIdWriter objectIdWriter = new ObjectIdWriter(this.idType, this.propertyName, this.generator, this.serializer, z);
        return objectIdWriter;
    }
}
