package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import p140me.bridgefy.ormlite.entities.MessageDTO;

public class ForwardTransactionSerializer extends JsonSerializer<ForwardTransaction> {
    public void serialize(ForwardTransaction forwardTransaction, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeBooleanField("dump", forwardTransaction.f6053a.booleanValue());
        if (forwardTransaction.f6054b != null) {
            jsonGenerator.writeStringField(MessageDTO.SENDER, forwardTransaction.f6054b);
        }
        if (forwardTransaction.f6055c != null) {
            jsonGenerator.writeStringField("mesh_reach", forwardTransaction.f6055c);
        }
        if (forwardTransaction.getMesh() != null) {
            if (forwardTransaction.getMesh().size() == 1) {
                jsonGenerator.writeObjectField("mesh", forwardTransaction.getMesh().get(0));
            } else {
                jsonGenerator.writeArrayFieldStart("mesh");
                for (ForwardPacket writeObject : forwardTransaction.getMesh()) {
                    jsonGenerator.writeObject(writeObject);
                }
                jsonGenerator.writeEndArray();
            }
        }
        jsonGenerator.writeEndObject();
    }
}
