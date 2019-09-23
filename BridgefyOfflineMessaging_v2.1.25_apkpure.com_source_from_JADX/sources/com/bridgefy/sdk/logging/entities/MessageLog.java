package com.bridgefy.sdk.logging.entities;

import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.framework.utils.Utils;
import com.bridgefy.sdk.logging.entities.LogEntity.LogType;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MessageLog extends LogEntity {

    /* renamed from: a */
    String f6119a;

    public enum MessageErrorEvent {
        BFMessageErrorTypeDirectMessageNotSent
    }

    public enum MessageEvent {
        BFMessageTypeDirectMessageSent,
        BFMessageTypeDirectMessageReceived,
        BFMessageGenerateCompressedChunk
    }

    public MessageLog(Antenna antenna, long j, Message message, MessageEvent messageEvent) {
        super(LogType.MESSAGE, messageEvent.ordinal(), j, antenna);
        this.f6119a = message.getUuid();
    }

    public MessageLog(Message message, String str) {
        super(LogType.MESSAGE_ERROR, MessageErrorEvent.BFMessageErrorTypeDirectMessageNotSent.ordinal(), Utils.getCrcFromKey(message.getReceiverId()), Antenna.UNREACHABLE);
        this.f6119a = message.getUuid();
        this.f6108i = str;
    }

    public String getMessage() {
        if (this.f6107h == null) {
            if (this.f6108i != null) {
                this.f6107h = MessageErrorEvent.values()[this.f6103d].name();
            } else {
                this.f6107h = MessageEvent.values()[this.f6103d].name();
            }
        }
        return this.f6107h;
    }

    public String serialize() {
        return new Gson().toJson((Object) this);
    }

    public static MessageLog create(String str) throws JsonSyntaxException {
        return (MessageLog) new Gson().fromJson(str, MessageLog.class);
    }
}
