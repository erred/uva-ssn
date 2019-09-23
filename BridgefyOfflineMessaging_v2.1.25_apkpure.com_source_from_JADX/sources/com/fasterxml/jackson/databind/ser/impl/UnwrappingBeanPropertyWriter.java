package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p116io.SerializedString;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    protected final NameTransformer _nameTransformer;

    public boolean isUnwrapping() {
        return true;
    }

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, NameTransformer nameTransformer) {
        super(beanPropertyWriter);
        this._nameTransformer = nameTransformer;
    }

    protected UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter unwrappingBeanPropertyWriter, NameTransformer nameTransformer, SerializedString serializedString) {
        super((BeanPropertyWriter) unwrappingBeanPropertyWriter, serializedString);
        this._nameTransformer = nameTransformer;
    }

    public UnwrappingBeanPropertyWriter rename(NameTransformer nameTransformer) {
        return _new(NameTransformer.chainedTransformer(nameTransformer, this._nameTransformer), new SerializedString(nameTransformer.transform(this._name.getValue())));
    }

    /* access modifiers changed from: protected */
    public UnwrappingBeanPropertyWriter _new(NameTransformer nameTransformer, SerializedString serializedString) {
        return new UnwrappingBeanPropertyWriter(this, nameTransformer, serializedString);
    }

    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object obj2 = get(obj);
        if (obj2 != null) {
            JsonSerializer jsonSerializer = this._serializer;
            if (jsonSerializer == null) {
                Class cls = obj2.getClass();
                PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                jsonSerializer = serializerFor == null ? _findAndAddDynamic(propertySerializerMap, cls, serializerProvider) : serializerFor;
            }
            if (this._suppressableValue != null) {
                if (MARKER_FOR_EMPTY == this._suppressableValue) {
                    if (jsonSerializer.isEmpty(serializerProvider, obj2)) {
                        return;
                    }
                } else if (this._suppressableValue.equals(obj2)) {
                    return;
                }
            }
            if (obj2 != obj || !_handleSelfReference(obj, jsonGenerator, serializerProvider, jsonSerializer)) {
                if (!jsonSerializer.isUnwrappingSerializer()) {
                    jsonGenerator.writeFieldName((SerializableString) this._name);
                }
                if (this._typeSerializer == null) {
                    jsonSerializer.serialize(obj2, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.serializeWithType(obj2, jsonGenerator, serializerProvider, this._typeSerializer);
                }
            }
        }
    }

    public void assignSerializer(JsonSerializer<Object> jsonSerializer) {
        super.assignSerializer(jsonSerializer);
        if (this._serializer != null) {
            NameTransformer nameTransformer = this._nameTransformer;
            if (this._serializer.isUnwrappingSerializer()) {
                nameTransformer = NameTransformer.chainedTransformer(nameTransformer, ((UnwrappingBeanSerializer) this._serializer)._nameTransformer);
            }
            this._serializer = this._serializer.unwrappingSerializer(nameTransformer);
        }
    }

    public void depositSchemaProperty(final JsonObjectFormatVisitor jsonObjectFormatVisitor, SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer unwrappingSerializer = serializerProvider.findValueSerializer(getType(), (BeanProperty) this).unwrappingSerializer(this._nameTransformer);
        if (unwrappingSerializer.isUnwrappingSerializer()) {
            unwrappingSerializer.acceptJsonFormatVisitor(new Base(serializerProvider) {
                public JsonObjectFormatVisitor expectObjectFormat(JavaType javaType) throws JsonMappingException {
                    return jsonObjectFormatVisitor;
                }
            }, getType());
        } else {
            super.depositSchemaProperty(jsonObjectFormatVisitor, serializerProvider);
        }
    }

    /* access modifiers changed from: protected */
    public void _depositSchemaProperty(ObjectNode objectNode, JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.get("properties");
        if (jsonNode2 != null) {
            Iterator fields = jsonNode2.fields();
            while (fields.hasNext()) {
                Entry entry = (Entry) fields.next();
                String str = (String) entry.getKey();
                if (this._nameTransformer != null) {
                    str = this._nameTransformer.transform(str);
                }
                objectNode.set(str, (JsonNode) entry.getValue());
            }
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer jsonSerializer;
        if (this._nonTrivialBaseType != null) {
            jsonSerializer = serializerProvider.findValueSerializer(serializerProvider.constructSpecializedType(this._nonTrivialBaseType, cls), (BeanProperty) this);
        } else {
            jsonSerializer = serializerProvider.findValueSerializer(cls, (BeanProperty) this);
        }
        NameTransformer nameTransformer = this._nameTransformer;
        if (jsonSerializer.isUnwrappingSerializer()) {
            nameTransformer = NameTransformer.chainedTransformer(nameTransformer, ((UnwrappingBeanSerializer) jsonSerializer)._nameTransformer);
        }
        JsonSerializer<Object> unwrappingSerializer = jsonSerializer.unwrappingSerializer(nameTransformer);
        this._dynamicSerializers = this._dynamicSerializers.newWith(cls, unwrappingSerializer);
        return unwrappingSerializer;
    }
}
