package com.bridgefy.sdk.framework.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.Gson;
import java.util.List;

@JsonSerialize(using = ForwardTransactionSerializer.class)
public class ForwardTransaction implements Parcelable {
    public static final Creator<ForwardTransaction> CREATOR = new Creator<ForwardTransaction>() {
        /* renamed from: a */
        public ForwardTransaction createFromParcel(Parcel parcel) {
            return new ForwardTransaction(parcel);
        }

        /* renamed from: a */
        public ForwardTransaction[] newArray(int i) {
            return new ForwardTransaction[i];
        }
    };
    @JsonProperty("dump")

    /* renamed from: a */
    Boolean dump = Boolean.valueOf(false);
    @JsonProperty("sender")

    /* renamed from: b */
    String sender;
    @JsonProperty("mesh_reach")

    /* renamed from: c */
    String mesh_reach;
    @JsonProperty("mesh")

    /* renamed from: d */
    List<ForwardPacket> mesh;

    public int describeContents() {
        return 0;
    }

    public ForwardTransaction() {
    }

    public ForwardTransaction(boolean z, String str, List<ForwardPacket> list) {
        this.dump = Boolean.valueOf(z);
        this.sender = str;
        this.mesh = list;
    }

    protected ForwardTransaction(Parcel parcel) {
        boolean z = false;
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.dump = Boolean.valueOf(z);
        this.sender = parcel.readString();
        this.mesh_reach = parcel.readString();
        this.mesh = parcel.createTypedArrayList(ForwardPacket.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.dump.booleanValue() ? (byte) 1 : 0);
        parcel.writeString(this.sender);
        parcel.writeString(this.mesh_reach);
        parcel.writeTypedList(this.mesh);
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    @JsonProperty("dump")
    public Boolean isDump() {
        return this.dump;
    }

    public void setDump(Boolean bool) {
        this.dump = bool;
    }

    @JsonProperty("sender")
    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    @JsonProperty("mesh")
    public List<ForwardPacket> getMesh() {
        return this.mesh;
    }

    public void setMesh(List<ForwardPacket> list) {
        this.mesh = list;
    }

    @JsonProperty("mesh_reach")
    public String getMesh_reach() {
        return this.mesh_reach;
    }

    public void setMesh_reach(String str) {
        this.mesh_reach = str;
    }
}
