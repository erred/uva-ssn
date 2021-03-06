package com.bridgefy.sdk.framework.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonDeserialize(using = BleEntityDeserializer.class)
public class BleEntity<T> implements Parcelable {
    public static final Creator<BleEntity> CREATOR = new Creator<BleEntity>() {
        /* renamed from: a */
        public BleEntity createFromParcel(Parcel parcel) {
            return new BleEntity(parcel);
        }

        /* renamed from: a */
        public BleEntity[] newArray(int i) {
            return new BleEntity[i];
        }
    };
    @Deprecated
    public static final int ENTITY_MESH_REACH = 4;
    public static final int ENTITY_TYPE_BINARY = 2;
    public static final int ENTITY_TYPE_FILE = 5;
    public static final int ENTITY_TYPE_HANDSHAKE = 0;
    public static final int ENTITY_TYPE_MESH = 3;
    public static final int ENTITY_TYPE_MESSAGE = 1;
    @JsonProperty("id")

    /* renamed from: a */
    private String id;
    @JsonProperty("et")

    /* renamed from: b */
    private int et;
    @JsonProperty("ct")

    /* renamed from: c */
    private T ct;
    @JsonIgnore

    /* renamed from: d */
    private byte[] message_data;
    @JsonIgnore

    /* renamed from: e */
    private byte[] message_uuid;

    public int describeContents() {
        return 0;
    }

    public BleEntity() {
    }

    public BleEntity(int i) {
        this.et = i;
    }

    public BleEntity(int i, T t) {
        this.et = i;
        this.ct = t;
        this.id = UUID.randomUUID().toString();
    }

    public BleEntity(int i, T t, byte[] bArr, String str) {
        this.et = i;
        this.ct = t;
        this.id = str;
        this.message_uuid = bArr;
    }

    protected BleEntity(Parcel parcel) {
        this.id = parcel.readString();
        this.et = parcel.readInt();
        this.message_data = new byte[parcel.readInt()];
        parcel.readByteArray(this.message_data);
        this.message_uuid = new byte[parcel.readInt()];
        parcel.readByteArray(this.message_uuid);
        if (parcel.dataPosition() < parcel.dataSize()) {
            this.ct = parcel.readParcelable(ForwardTransaction.class.getClassLoader());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeInt(this.et);
        parcel.writeInt(this.message_data.length);
        parcel.writeByteArray(this.message_data);
        parcel.writeInt(this.message_uuid.length);
        parcel.writeByteArray(this.message_uuid);
        if (this.ct instanceof ForwardTransaction) {
            parcel.writeParcelable((ForwardTransaction) this.ct, i);
        }
    }

    public static BleEntity message(Message message) {
        if (message.getData() == null || message.getData().length <= 0) {
            return new BleEntity(1, new BleEntityContent(message.getContent(), message.getUuid()));
        }
        return new BleEntity(1, new BleEntityContent(message.getContent(), message.getUuid()), message.getData(), message.getUuid());
    }

    public static BleEntity<ForwardTransaction> meshMessage(boolean z, ArrayList<ForwardPacket> arrayList, String str) {
        return new BleEntity<>(3, new ForwardTransaction(z, str, arrayList));
    }

    public static BleEntity<ForwardTransaction> meshReach(String str) {
        ForwardTransaction forwardTransaction = new ForwardTransaction();
        forwardTransaction.setMesh_reach(str);
        forwardTransaction.setDump(Boolean.valueOf(false));
        forwardTransaction.setMesh(null);
        return new BleEntity<>(3, forwardTransaction);
    }

    public static BleEntity generateHandShake() {
        return new BleEntity(0, new BleHandshake(Integer.valueOf(0), ResponseJson.ResponseTypeGeneral(Bridgefy.getInstance().getBridgefyClient().getUserUuid(), Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getPublicKey()), "1.0.6", "1.0.6")));
    }

    public static BleEntity generateHandShake(BleHandshake bleHandshake) {
        return new BleEntity(0, bleHandshake);
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    @JsonProperty("et")
    public int getEt() {
        return this.et;
    }

    public void setEt(int i) {
        this.et = i;
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @JsonProperty("ct")
    public T getCt() {
        return this.ct;
    }

    public void setCt(T t) {
        this.ct = t;
    }

    public void setBinaryPart(byte[] bArr) {
        this.message_data = bArr;
    }

    public byte[] getBinaryPart() {
        return this.message_data;
    }

    public byte[] getData() {
        return this.message_uuid;
    }

    public void setData(byte[] bArr) {
        this.message_uuid = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object can't be null");
        } else if (obj instanceof BleEntity) {
            BleEntity bleEntity = (BleEntity) obj;
            return bleEntity.getId() != null && bleEntity.getId().trim().equalsIgnoreCase(getId().trim());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(obj.getClass().getName());
            sb.append(" isn't a BleEntity.");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
