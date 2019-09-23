package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class BleEntityDeserializer extends JsonDeserializer<BleEntity> {
    public BleEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = (JsonNode) jsonParser.getCodec().readTree(jsonParser);
        int intValue = ((Integer) jsonNode.get("et").numberValue()).intValue();
        JsonNode jsonNode2 = jsonNode.get("ct");
        jsonNode2.fieldNames();
        if (intValue == 3) {
            return new BleEntity(intValue, new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY).treeToValue(jsonNode2, ForwardTransaction.class));
        }
        switch (intValue) {
            case 0:
                return new BleEntity(intValue, new ObjectMapper().treeToValue(jsonNode2, BleHandshake.class));
            case 1:
                return new BleEntity(intValue, new ObjectMapper().treeToValue(jsonNode2, BleEntityContent.class));
            default:
                return null;
        }
    }
}
