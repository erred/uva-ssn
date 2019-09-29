package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.twitter.sdk.android.core.s */
/* compiled from: TwitterAuthToken */
public class C3262s extends C3102a implements Parcelable {
    public static final Creator<C3262s> CREATOR = new Creator<C3262s>() {
        /* renamed from: a */
        public C3262s createFromParcel(Parcel parcel) {
            return new C3262s(parcel);
        }

        /* renamed from: a */
        public C3262s[] newArray(int i) {
            return new C3262s[i];
        }
    };
    @SerializedName("token")

    /* renamed from: b */
    public final String f8544b;
    @SerializedName("secret")

    /* renamed from: c */
    public final String f8545c;

    public int describeContents() {
        return 0;
    }

    public C3262s(String str, String str2) {
        this.f8544b = str;
        this.f8545c = str2;
    }

    private C3262s(Parcel parcel) {
        this.f8544b = parcel.readString();
        this.f8545c = parcel.readString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("token=");
        sb.append(this.f8544b);
        sb.append(",secret=");
        sb.append(this.f8545c);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8544b);
        parcel.writeString(this.f8545c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3262s)) {
            return false;
        }
        C3262s sVar = (C3262s) obj;
        if (this.f8545c == null ? sVar.f8545c == null : this.f8545c.equals(sVar.f8545c)) {
            return this.f8544b == null ? sVar.f8544b == null : this.f8544b.equals(sVar.f8544b);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f8544b != null ? this.f8544b.hashCode() : 0) * 31;
        if (this.f8545c != null) {
            i = this.f8545c.hashCode();
        }
        return hashCode + i;
    }
}
