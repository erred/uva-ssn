package com.bridgefy.sdk.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.UUID;

public class Message implements Parcelable {
    public static final Creator<Message> CREATOR = new Creator<Message>() {
        /* renamed from: a */
        public Message createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        /* renamed from: a */
        public Message[] newArray(int i) {
            return new Message[i];
        }
    };

    /* renamed from: a */
    // hashMap content
    private HashMap content;

    /* renamed from: b */
    // receiver ID
    private String receiver_id;

    /* renamed from: c */
    // sender ID
    private String sender_id;

    /* renamed from: d */
    // random UUID
    private String message_uuid;

    /* renamed from: e */
    // Timestamp milliseconds
    private long timestamp;

    /* renamed from: f */
    private byte[] data;

    /* renamed from: g */
    // isMesh
    private boolean is_mesh;

    /* renamed from: h */
    // hop (current)
    private int hop;

    /* renamed from: i */
    // hops
    private int hops = 0;

    public static class Builder {

        /* renamed from: a */
        private HashMap<String, Object> content;

        /* renamed from: b */
        private String receiver_id;

        /* renamed from: c */
        private byte[] data;

        public Builder setContent(HashMap hashMap) {
            this.content = hashMap;
            return this;
        }

        public Builder setReceiverId(String str) {
            this.receiver_id = str;
            return this;
        }

        public Builder setData(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Message build() {
            return new Message(this.content, this.receiver_id, Bridgefy.getInstance().getBridgefyClient().getUserUuid(), this.data);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Message(HashMap<String, Object> hashMap, String str, String str2) {
        this.content = hashMap;
        this.receiver_id = str;
        this.sender_id = str2;
        this.timestamp = System.currentTimeMillis();
        this.message_uuid = UUID.randomUUID().toString();
    }

    public Message(HashMap<String, Object> hashMap, String str, String str2, boolean z, int i) {
        this.content = hashMap;
        this.receiver_id = str;
        this.sender_id = str2;
        this.timestamp = System.currentTimeMillis();
        this.message_uuid = UUID.randomUUID().toString();
        this.is_mesh = z;
        this.hop = i;
    }

    public Message(HashMap<String, Object> hashMap, String str, String str2, byte[] bArr) {
        this.content = hashMap;
        this.receiver_id = str;
        this.sender_id = str2;
        this.timestamp = System.currentTimeMillis();
        this.message_uuid = UUID.randomUUID().toString();
        this.data = bArr;
    }

    protected Message(Parcel parcel) {
        boolean z = false;
        this.receiver_id = parcel.readString();
        this.sender_id = parcel.readString();
        this.message_uuid = parcel.readString();
        this.timestamp = parcel.readLong();
        this.data = parcel.createByteArray();
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.is_mesh = z;
        this.hop = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.receiver_id);
        parcel.writeString(this.sender_id);
        parcel.writeString(this.message_uuid);
        parcel.writeLong(this.timestamp);
        parcel.writeByteArray(this.data);
        parcel.writeByte(this.is_mesh ? (byte) 1 : 0);
        parcel.writeInt(this.hop);
    }

    public HashMap getContent() {
        return this.content;
    }

    public void setContent(HashMap hashMap) {
        this.content = hashMap;
    }

    public long getDateSent() {
        return this.timestamp;
    }

    public void setDateSent(long j) {
        this.timestamp = j;
    }

    public String getReceiverId() {
        return this.receiver_id;
    }

    public void setReceiverId(String str) {
        this.receiver_id = str;
    }

    public String getSenderId() {
        return this.sender_id;
    }

    public void setSenderId(String str) {
        this.sender_id = str;
    }

    public String getUuid() {
        return this.message_uuid;
    }

    public void setUuid(String str) {
        this.message_uuid = str;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public int getHop() {
        return this.hop;
    }

    public boolean isMesh() {
        return this.is_mesh;
    }

    public void setMesh(boolean z) {
        this.is_mesh = z;
    }

    public int getHops() {
        return this.hops;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Message)) {
            StringBuilder sb = new StringBuilder();
            sb.append(obj.getClass().getCanonicalName());
            sb.append(" is not a ");
            sb.append(Message.class.getName());
            sb.append(" class instance.");
            throw new IllegalArgumentException(sb.toString());
        }
        Message message = (Message) obj;
        return message.getUuid() != null && message.getUuid().trim().equalsIgnoreCase(getUuid().trim());
    }
}
