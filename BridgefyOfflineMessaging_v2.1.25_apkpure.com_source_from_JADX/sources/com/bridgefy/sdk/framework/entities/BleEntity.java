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
    private String f6026a;
    @JsonProperty("et")

    /* renamed from: b */
    private int f6027b;
    @JsonProperty("ct")

    /* renamed from: c */
    private T f6028c;
    @JsonIgnore

    /* renamed from: d */
    private byte[] f6029d;
    @JsonIgnore

    /* renamed from: e */
    private byte[] f6030e;

    public int describeContents() {
        return 0;
    }

    public BleEntity() {
    }

    public BleEntity(int i) {
        this.f6027b = i;
    }

    public BleEntity(int i, T t) {
        this.f6027b = i;
        this.f6028c = t;
        this.f6026a = UUID.randomUUID().toString();
    }

    public BleEntity(int i, T t, byte[] bArr, String str) {
        this.f6027b = i;
        this.f6028c = t;
        this.f6026a = str;
        this.f6030e = bArr;
    }

    protected BleEntity(Parcel parcel) {
        this.f6026a = parcel.readString();
        this.f6027b = parcel.readInt();
        this.f6029d = new byte[parcel.readInt()];
        parcel.readByteArray(this.f6029d);
        this.f6030e = new byte[parcel.readInt()];
        parcel.readByteArray(this.f6030e);
        if (parcel.dataPosition() < parcel.dataSize()) {
            this.f6028c = parcel.readParcelable(ForwardTransaction.class.getClassLoader());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6026a);
        parcel.writeInt(this.f6027b);
        parcel.writeInt(this.f6029d.length);
        parcel.writeByteArray(this.f6029d);
        parcel.writeInt(this.f6030e.length);
        parcel.writeByteArray(this.f6030e);
        if (this.f6028c instanceof ForwardTransaction) {
            parcel.writeParcelable((ForwardTransaction) this.f6028c, i);
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
        return this.f6027b;
    }

    public void setEt(int i) {
        this.f6027b = i;
    }

    @JsonProperty("id")
    public String getId() {
        return this.f6026a;
    }

    public void setId(String str) {
        this.f6026a = str;
    }

    @JsonProperty("ct")
    public T getCt() {
        return this.f6028c;
    }

    public void setCt(T t) {
        this.f6028c = t;
    }

    public void setBinaryPart(byte[] bArr) {
        this.f6029d = bArr;
    }

    public byte[] getBinaryPart() {
        return this.f6029d;
    }

    public byte[] getData() {
        return this.f6030e;
    }

    public void setData(byte[] bArr) {
        this.f6030e = bArr;
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
