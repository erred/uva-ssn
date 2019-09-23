package com.bridgefy.sdk.logging.entities;

import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.framework.entities.ForwardPacket;
import com.bridgefy.sdk.logging.entities.LogEntity.LogType;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;

public class MeshLog extends LogEntity {

    /* renamed from: a */
    String f6111a;

    /* renamed from: b */
    int f6112b;

    /* renamed from: j */
    ArrayList<Long> f6113j;

    /* renamed from: k */
    String f6114k;

    /* renamed from: l */
    int f6115l;

    /* renamed from: m */
    String[] f6116m;

    public enum MeshErrorEvent {
        BFErrorMeshTypeOverloadDiscard,
        BFErrorMeshTypeDiscardInvalidMessages,
        BFErrorMeshTypeSessionInvalid
    }

    public enum MeshEvent {
        BFMeshTypeMeshMessageSent,
        BFMeshTypePacketReceivedToForward,
        BFMeshTypePacketReceivedDuplicated,
        BFMeshTypePacketReceivedReached,
        BFMeshTypePacketReceivedBroadcast,
        BFMeshTypePacketsDumped,
        BFMeshTypePacketSentBroadcast
    }

    public MeshLog(MeshEvent meshEvent, ForwardPacket forwardPacket, Long l) {
        super(LogType.MESH, meshEvent.ordinal());
        this.f6111a = String.valueOf(forwardPacket.getId());
        this.f6112b = forwardPacket.getHops();
        this.f6113j = forwardPacket.getTrack();
        this.f6114k = String.valueOf(l);
    }

    public MeshLog(ForwardPacket forwardPacket) {
        super(LogType.MESH, MeshEvent.BFMeshTypeMeshMessageSent.ordinal());
        this.f6111a = String.valueOf(forwardPacket.getId());
        this.f6112b = forwardPacket.getHops();
        this.f6113j = forwardPacket.getTrack();
    }

    public MeshLog(int i) {
        super(LogType.MESH, MeshEvent.BFMeshTypePacketsDumped.ordinal());
        this.f6115l = i;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6107h);
        sb.append(": ");
        sb.append(i);
        this.f6107h = sb.toString();
    }

    public MeshLog(Message message) {
        super(LogType.MESH, MeshEvent.BFMeshTypePacketSentBroadcast.ordinal());
        this.f6111a = message.getUuid();
    }

    public MeshLog(MeshErrorEvent meshErrorEvent, ForwardPacket forwardPacket) {
        super(LogType.MESH_ERROR, meshErrorEvent.ordinal());
        this.f6111a = String.valueOf(forwardPacket.getId());
        this.f6112b = forwardPacket.getHops();
        this.f6113j = forwardPacket.getTrack();
        this.f6114k = String.valueOf(this.f6114k);
        this.f6108i = "Session was null or arrived without a valid userId";
    }

    public MeshLog(MeshErrorEvent meshErrorEvent, ArrayList<ForwardPacket> arrayList) {
        super(LogType.MESH_ERROR, meshErrorEvent.ordinal());
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr[i] = ((ForwardPacket) arrayList.get(i)).getId();
        }
        this.f6116m = strArr;
        this.f6108i = "";
    }

    public String getMessage() {
        if (this.f6107h == null) {
            if (this.f6108i != null) {
                this.f6107h = MeshErrorEvent.values()[this.f6103d].name();
            } else {
                this.f6107h = MeshEvent.values()[this.f6103d].name();
            }
        }
        return this.f6107h;
    }

    public String serialize() {
        return new Gson().toJson((Object) this);
    }

    public static MeshLog create(String str) throws JsonSyntaxException {
        return (MeshLog) new Gson().fromJson(str, MeshLog.class);
    }
}
