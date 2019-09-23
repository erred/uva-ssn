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
    Boolean f6053a = Boolean.valueOf(false);
    @JsonProperty("sender")

    /* renamed from: b */
    String f6054b;
    @JsonProperty("mesh_reach")

    /* renamed from: c */
    String f6055c;
    @JsonProperty("mesh")

    /* renamed from: d */
    List<ForwardPacket> f6056d;

    public int describeContents() {
        return 0;
    }

    public ForwardTransaction() {
    }

    public ForwardTransaction(boolean z, String str, List<ForwardPacket> list) {
        this.f6053a = Boolean.valueOf(z);
        this.f6054b = str;
        this.f6056d = list;
    }

    protected ForwardTransaction(Parcel parcel) {
        boolean z = false;
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.f6053a = Boolean.valueOf(z);
        this.f6054b = parcel.readString();
        this.f6055c = parcel.readString();
        this.f6056d = parcel.createTypedArrayList(ForwardPacket.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f6053a.booleanValue() ? (byte) 1 : 0);
        parcel.writeString(this.f6054b);
        parcel.writeString(this.f6055c);
        parcel.writeTypedList(this.f6056d);
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    @JsonProperty("dump")
    public Boolean isDump() {
        return this.f6053a;
    }

    public void setDump(Boolean bool) {
        this.f6053a = bool;
    }

    @JsonProperty("sender")
    public String getSender() {
        return this.f6054b;
    }

    public void setSender(String str) {
        this.f6054b = str;
    }

    @JsonProperty("mesh")
    public List<ForwardPacket> getMesh() {
        return this.f6056d;
    }

    public void setMesh(List<ForwardPacket> list) {
        this.f6056d = list;
    }

    @JsonProperty("mesh_reach")
    public String getMesh_reach() {
        return this.f6055c;
    }

    public void setMesh_reach(String str) {
        this.f6055c = str;
    }
}
