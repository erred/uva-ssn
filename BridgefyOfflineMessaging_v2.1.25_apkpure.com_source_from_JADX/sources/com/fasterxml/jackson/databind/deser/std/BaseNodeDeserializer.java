package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

/* compiled from: JsonNodeDeserializer */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    public boolean isCachable() {
        return true;
    }

    public BaseNodeDeserializer(Class<T> cls) {
        super(cls);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void _reportProblem(JsonParser jsonParser, String str) throws JsonMappingException {
        throw JsonMappingException.from(jsonParser, str);
    }

    /* access modifiers changed from: protected */
    public void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws JsonProcessingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            deserializationContext.reportMappingException("Duplicate field '%s' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled", str);
        }
    }

    /* access modifiers changed from: protected */
    public final ObjectNode deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        String currentName;
        JsonNode deserializeObject;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        if (jsonParser.isExpectedStartObjectToken()) {
            currentName = jsonParser.nextFieldName();
        } else {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.END_OBJECT) {
                return objectNode;
            }
            if (currentToken != JsonToken.FIELD_NAME) {
                return (ObjectNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
            }
            currentName = jsonParser.getCurrentName();
        }
        String str = currentName;
        while (str != null) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken != null) {
                switch (nextToken.mo8239id()) {
                    case 1:
                        deserializeObject = deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                    case 3:
                        deserializeObject = deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                    case 6:
                        deserializeObject = jsonNodeFactory.textNode(jsonParser.getText());
                        break;
                    case 7:
                        deserializeObject = _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                    case 9:
                        deserializeObject = jsonNodeFactory.booleanNode(true);
                        break;
                    case 10:
                        deserializeObject = jsonNodeFactory.booleanNode(false);
                        break;
                    case 11:
                        deserializeObject = jsonNodeFactory.nullNode();
                        break;
                    case 12:
                        deserializeObject = _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                    default:
                        deserializeObject = deserializeAny(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                }
                JsonNode jsonNode = deserializeObject;
                JsonNode replace = objectNode.replace(str, jsonNode);
                if (replace != null) {
                    _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, str, objectNode, replace, jsonNode);
                }
                str = jsonParser.nextFieldName();
            } else {
                throw deserializationContext.mappingException("Unexpected end-of-input when binding data into ObjectNode");
            }
        }
        return objectNode;
    }

    /* access modifiers changed from: protected */
    public final ArrayNode deserializeArray(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
        while (true) {
            switch (jsonParser.nextToken().mo8239id()) {
                case 1:
                    arrayNode.add((JsonNode) deserializeObject(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 3:
                    arrayNode.add((JsonNode) deserializeArray(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 4:
                    return arrayNode;
                case 6:
                    arrayNode.add((JsonNode) jsonNodeFactory.textNode(jsonParser.getText()));
                    break;
                case 7:
                    arrayNode.add(_fromInt(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 9:
                    arrayNode.add((JsonNode) jsonNodeFactory.booleanNode(true));
                    break;
                case 10:
                    arrayNode.add((JsonNode) jsonNodeFactory.booleanNode(false));
                    break;
                case 11:
                    arrayNode.add((JsonNode) jsonNodeFactory.nullNode());
                    break;
                case 12:
                    arrayNode.add(_fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                default:
                    arrayNode.add(deserializeAny(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final JsonNode deserializeAny(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        switch (jsonParser.getCurrentTokenId()) {
            case 1:
            case 2:
            case 5:
                return deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            case 3:
                return deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            case 6:
                return jsonNodeFactory.textNode(jsonParser.getText());
            case 7:
                return _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
            case 9:
                return jsonNodeFactory.booleanNode(true);
            case 10:
                return jsonNodeFactory.booleanNode(false);
            case 11:
                return jsonNodeFactory.nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
            default:
                return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
    }

    /* access modifiers changed from: protected */
    public final JsonNode _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        NumberType numberType;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if ((F_MASK_INT_COERCIONS & deserializationFeatures) == 0) {
            numberType = jsonParser.getNumberType();
        } else if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
            numberType = NumberType.BIG_INTEGER;
        } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
            numberType = NumberType.LONG;
        } else {
            numberType = jsonParser.getNumberType();
        }
        if (numberType == NumberType.INT) {
            return jsonNodeFactory.numberNode(jsonParser.getIntValue());
        }
        if (numberType == NumberType.LONG) {
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }

    /* access modifiers changed from: protected */
    public final JsonNode _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        NumberType numberType = jsonParser.getNumberType();
        if (numberType == NumberType.BIG_DECIMAL) {
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        }
        if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            double doubleValue = jsonParser.getDoubleValue();
            if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                return jsonNodeFactory.numberNode(doubleValue);
            }
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        } else if (numberType == NumberType.FLOAT) {
            return jsonNodeFactory.numberNode(jsonParser.getFloatValue());
        } else {
            return jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
        }
    }

    /* access modifiers changed from: protected */
    public final JsonNode _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        Object embeddedObject = jsonParser.getEmbeddedObject();
        if (embeddedObject == null) {
            return jsonNodeFactory.nullNode();
        }
        if (embeddedObject.getClass() == byte[].class) {
            return jsonNodeFactory.binaryNode((byte[]) embeddedObject);
        }
        if (embeddedObject instanceof RawValue) {
            return jsonNodeFactory.rawValueNode((RawValue) embeddedObject);
        }
        if (embeddedObject instanceof JsonNode) {
            return (JsonNode) embeddedObject;
        }
        return jsonNodeFactory.pojoNode(embeddedObject);
    }
}
