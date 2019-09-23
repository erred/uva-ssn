package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@JacksonStdImpl
public class SerializableSerializer extends StdSerializer<JsonSerializable> {
    private static final AtomicReference<ObjectMapper> _mapperReference = new AtomicReference<>();
    public static final SerializableSerializer instance = new SerializableSerializer();

    protected SerializableSerializer() {
        super(JsonSerializable.class);
    }

    public boolean isEmpty(SerializerProvider serializerProvider, JsonSerializable jsonSerializable) {
        if (jsonSerializable instanceof Base) {
            return ((Base) jsonSerializable).isEmpty(serializerProvider);
        }
        return false;
    }

    public void serialize(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonSerializable.serialize(jsonGenerator, serializerProvider);
    }

    public final void serializeWithType(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonSerializable.serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonNode getSchema(com.fasterxml.jackson.databind.SerializerProvider r7, java.lang.reflect.Type r8) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r6 = this;
            com.fasterxml.jackson.databind.node.ObjectNode r0 = r6.createObjectNode()
            java.lang.String r1 = "any"
            r2 = 0
            if (r8 == 0) goto L_0x0044
            java.lang.Class r8 = com.fasterxml.jackson.databind.type.TypeFactory.rawClass(r8)
            java.lang.Class<com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema> r3 = com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema.class
            boolean r3 = r8.isAnnotationPresent(r3)
            if (r3 == 0) goto L_0x0044
            java.lang.Class<com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema> r1 = com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema.class
            java.lang.annotation.Annotation r8 = r8.getAnnotation(r1)
            com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema r8 = (com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema) r8
            java.lang.String r1 = r8.schemaType()
            java.lang.String r3 = "##irrelevant"
            java.lang.String r4 = r8.schemaObjectPropertiesDefinition()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0032
            java.lang.String r3 = r8.schemaObjectPropertiesDefinition()
            goto L_0x0033
        L_0x0032:
            r3 = r2
        L_0x0033:
            java.lang.String r4 = "##irrelevant"
            java.lang.String r5 = r8.schemaItemDefinition()
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0045
            java.lang.String r2 = r8.schemaItemDefinition()
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            java.lang.String r8 = "type"
            r0.put(r8, r1)
            r8 = 0
            if (r3 == 0) goto L_0x0062
            java.lang.String r1 = "properties"
            com.fasterxml.jackson.databind.ObjectMapper r4 = _getObjectMapper()     // Catch:{ IOException -> 0x005b }
            com.fasterxml.jackson.databind.JsonNode r3 = r4.readTree(r3)     // Catch:{ IOException -> 0x005b }
            r0.set(r1, r3)     // Catch:{ IOException -> 0x005b }
            goto L_0x0062
        L_0x005b:
            java.lang.String r1 = "Failed to parse @JsonSerializableSchema.schemaObjectPropertiesDefinition value"
            java.lang.Object[] r3 = new java.lang.Object[r8]
            r7.reportMappingProblem(r1, r3)
        L_0x0062:
            if (r2 == 0) goto L_0x0079
            java.lang.String r1 = "items"
            com.fasterxml.jackson.databind.ObjectMapper r3 = _getObjectMapper()     // Catch:{ IOException -> 0x0072 }
            com.fasterxml.jackson.databind.JsonNode r2 = r3.readTree(r2)     // Catch:{ IOException -> 0x0072 }
            r0.set(r1, r2)     // Catch:{ IOException -> 0x0072 }
            goto L_0x0079
        L_0x0072:
            java.lang.String r1 = "Failed to parse @JsonSerializableSchema.schemaItemDefinition value"
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r7.reportMappingProblem(r1, r8)
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.SerializableSerializer.getSchema(com.fasterxml.jackson.databind.SerializerProvider, java.lang.reflect.Type):com.fasterxml.jackson.databind.JsonNode");
    }

    private static final synchronized ObjectMapper _getObjectMapper() {
        ObjectMapper objectMapper;
        synchronized (SerializableSerializer.class) {
            objectMapper = (ObjectMapper) _mapperReference.get();
            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
                _mapperReference.set(objectMapper);
            }
        }
        return objectMapper;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        jsonFormatVisitorWrapper.expectAnyFormat(javaType);
    }
}
