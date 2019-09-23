package com.bridgefy.sdk.logging.entities;

import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.bridgefy.sdk.logging.entities.LogEntity.LogType;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CommunicationLog extends LogEntity {

    /* renamed from: a */
    BleHandshake f6091a;

    /* renamed from: b */
    String f6092b = "";

    public enum CommunicationErrorEvent {
        BFCommunicationErrorTypeConnectionFailed,
        BFCommunicationErrorTypePeerDisconnected,
        BFCommunicationErrorTypePeripheralConnectionFailed,
        BFCommunicationErrorTypePeripheralDisconnection
    }

    public enum CommunicationEvent {
        BFCommunicationTypePeerDetected,
        BFCommunicationTypeEstablishingConnection,
        BFCommunicationTypePeerConnected,
        BFCommunicationTypePeerDisconnected,
        BFCommunicationTypeStartingHandshake,
        BFCommunicationTypeWaitingForHandshake,
        BFCommunicationTypeSentHandshakePacket,
        BFCommunicationTypeReceivedHandshakePacket,
        BFCommunicationTypeHandshakeFinished,
        BFCommunicationTypePeripheralInitialConnection,
        BFCommunicationTypePeerLost
    }

    public CommunicationLog(Antenna antenna, String str, CommunicationEvent communicationEvent, long j) {
        super(LogType.COMMUNICATION, communicationEvent.ordinal(), j, antenna);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6107h);
        sb.append(": ");
        sb.append(str);
        this.f6107h = sb.toString();
    }

    public CommunicationLog(Antenna antenna, String str, BleHandshake bleHandshake, CommunicationEvent communicationEvent, long j) {
        super(LogType.COMMUNICATION, communicationEvent.ordinal(), j, antenna);
        this.f6091a = bleHandshake;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6107h);
        sb.append(": ");
        sb.append(str);
        this.f6107h = sb.toString();
    }

    public CommunicationLog(Antenna antenna, String str, CommunicationErrorEvent communicationErrorEvent, long j, String str2) {
        super(LogType.COMMUNICATION_ERROR, communicationErrorEvent.ordinal(), j, antenna);
        this.f6108i = str2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6107h);
        sb.append(": ");
        sb.append(str);
        this.f6107h = sb.toString();
    }

    public void setComment(String str) {
        this.f6092b = str;
    }

    public String getMessage() {
        if (this.f6107h == null) {
            if (this.f6108i != null) {
                this.f6107h = CommunicationErrorEvent.values()[this.f6103d].name();
            } else {
                this.f6107h = CommunicationEvent.values()[this.f6103d].name();
            }
        }
        return this.f6107h;
    }

    public String serialize() {
        return new Gson().toJson((Object) this);
    }

    public static CommunicationLog create(String str) throws JsonSyntaxException {
        return (CommunicationLog) new Gson().fromJson(str, CommunicationLog.class);
    }
}
