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
    private HashMap f5816a;

    /* renamed from: b */
    // receiver ID
    private String f5817b;

    /* renamed from: c */
    // sender ID
    private String f5818c;

    /* renamed from: d */
    // random UUID
    private String f5819d;

    /* renamed from: e */
    // Timestamp milliseconds
    private long f5820e;

    /* renamed from: f */
    private byte[] f5821f;

    /* renamed from: g */
    // isMesh
    private boolean is_mesh;

    /* renamed from: h */
    // hop (current)
    private int f5823h;

    /* renamed from: i */
    // hops
    private int hops = 0;

    public static class Builder {

        /* renamed from: a */
        private HashMap<String, Object> f5825a;

        /* renamed from: b */
        private String f5826b;

        /* renamed from: c */
        private byte[] f5827c;

        public Builder setContent(HashMap hashMap) {
            this.f5825a = hashMap;
            return this;
        }

        public Builder setReceiverId(String str) {
            this.f5826b = str;
            return this;
        }

        public Builder setData(byte[] bArr) {
            this.f5827c = bArr;
            return this;
        }

        public Message build() {
            return new Message(this.f5825a, this.f5826b, Bridgefy.getInstance().getBridgefyClient().getUserUuid(), this.f5827c);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Message(HashMap<String, Object> hashMap, String str, String str2) {
        this.f5816a = hashMap;
        this.f5817b = str;
        this.f5818c = str2;
        this.f5820e = System.currentTimeMillis();
        this.f5819d = UUID.randomUUID().toString();
    }

    public Message(HashMap<String, Object> hashMap, String str, String str2, boolean z, int i) {
        this.f5816a = hashMap;
        this.f5817b = str;
        this.f5818c = str2;
        this.f5820e = System.currentTimeMillis();
        this.f5819d = UUID.randomUUID().toString();
        this.is_mesh = z;
        this.f5823h = i;
    }

    public Message(HashMap<String, Object> hashMap, String str, String str2, byte[] bArr) {
        this.f5816a = hashMap;
        this.f5817b = str;
        this.f5818c = str2;
        this.f5820e = System.currentTimeMillis();
        this.f5819d = UUID.randomUUID().toString();
        this.f5821f = bArr;
    }

    protected Message(Parcel parcel) {
        boolean z = false;
        this.f5817b = parcel.readString();
        this.f5818c = parcel.readString();
        this.f5819d = parcel.readString();
        this.f5820e = parcel.readLong();
        this.f5821f = parcel.createByteArray();
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.is_mesh = z;
        this.f5823h = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5817b);
        parcel.writeString(this.f5818c);
        parcel.writeString(this.f5819d);
        parcel.writeLong(this.f5820e);
        parcel.writeByteArray(this.f5821f);
        parcel.writeByte(this.is_mesh ? (byte) 1 : 0);
        parcel.writeInt(this.f5823h);
    }

    public HashMap getContent() {
        return this.f5816a;
    }

    public void setContent(HashMap hashMap) {
        this.f5816a = hashMap;
    }

    public long getDateSent() {
        return this.f5820e;
    }

    public void setDateSent(long j) {
        this.f5820e = j;
    }

    public String getReceiverId() {
        return this.f5817b;
    }

    public void setReceiverId(String str) {
        this.f5817b = str;
    }

    public String getSenderId() {
        return this.f5818c;
    }

    public void setSenderId(String str) {
        this.f5818c = str;
    }

    public String getUuid() {
        return this.f5819d;
    }

    public void setUuid(String str) {
        this.f5819d = str;
    }

    public byte[] getData() {
        return this.f5821f;
    }

    public void setData(byte[] bArr) {
        this.f5821f = bArr;
    }

    public int getHop() {
        return this.f5823h;
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
