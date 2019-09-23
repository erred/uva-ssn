package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.C1951As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;

public class AsWrapperTypeDeserializer extends TypeDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;

    public AsWrapperTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, JavaType javaType2) {
        super(javaType, typeIdResolver, str, z, javaType2);
    }

    protected AsWrapperTypeDeserializer(AsWrapperTypeDeserializer asWrapperTypeDeserializer, BeanProperty beanProperty) {
        super(asWrapperTypeDeserializer, beanProperty);
    }

    public TypeDeserializer forProperty(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsWrapperTypeDeserializer(this, beanProperty);
    }

    public C1951As getTypeInclusion() {
        return C1951As.WRAPPER_OBJECT;
    }

    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    public Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.canReadTypeId()) {
            Object typeId = jsonParser.getTypeId();
            if (typeId != null) {
                return _deserializeWithNativeTypeId(jsonParser, deserializationContext, typeId);
            }
        }
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            if (jsonParser.nextToken() != JsonToken.FIELD_NAME) {
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                StringBuilder sb = new StringBuilder();
                sb.append("need JSON String that contains type id (for subtype of ");
                sb.append(baseTypeName());
                sb.append(")");
                deserializationContext.reportWrongTokenException(jsonParser, jsonToken, sb.toString(), new Object[0]);
            }
        } else if (currentToken != JsonToken.FIELD_NAME) {
            JsonToken jsonToken2 = JsonToken.START_OBJECT;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("need JSON Object to contain As.WRAPPER_OBJECT type information for class ");
            sb2.append(baseTypeName());
            deserializationContext.reportWrongTokenException(jsonParser, jsonToken2, sb2.toString(), new Object[0]);
        }
        String text = jsonParser.getText();
        JsonDeserializer _findDeserializer = _findDeserializer(deserializationContext, text);
        jsonParser.nextToken();
        if (this._typeIdVisible && jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
            TokenBuffer tokenBuffer = new TokenBuffer((ObjectCodec) null, false);
            tokenBuffer.writeStartObject();
            tokenBuffer.writeFieldName(this._typePropertyName);
            tokenBuffer.writeString(text);
            jsonParser.clearCurrentToken();
            jsonParser = JsonParserSequence.createFlattened(false, tokenBuffer.asParser(jsonParser), jsonParser);
            jsonParser.nextToken();
        }
        Object deserialize = _findDeserializer.deserialize(jsonParser, deserializationContext);
        if (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            deserializationContext.reportWrongTokenException(jsonParser, JsonToken.END_OBJECT, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        }
        return deserialize;
    }
}
