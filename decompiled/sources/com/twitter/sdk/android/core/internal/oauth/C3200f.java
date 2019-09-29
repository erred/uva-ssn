package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.twitter.sdk.android.core.C3262s;

/* renamed from: com.twitter.sdk.android.core.internal.oauth.f */
/* compiled from: OAuthResponse */
public class C3200f implements Parcelable {
    public static final Creator<C3200f> CREATOR = new Creator<C3200f>() {
        /* renamed from: a */
        public C3200f createFromParcel(Parcel parcel) {
            return new C3200f(parcel);
        }

        /* renamed from: a */
        public C3200f[] newArray(int i) {
            return new C3200f[i];
        }
    };

    /* renamed from: a */
    public final C3262s f8379a;

    /* renamed from: b */
    public final String f8380b;

    /* renamed from: c */
    public final long f8381c;

    public int describeContents() {
        return 0;
    }

    public C3200f(C3262s sVar, String str, long j) {
        this.f8379a = sVar;
        this.f8380b = str;
        this.f8381c = j;
    }

    private C3200f(Parcel parcel) {
        this.f8379a = (C3262s) parcel.readParcelable(C3262s.class.getClassLoader());
        this.f8380b = parcel.readString();
        this.f8381c = parcel.readLong();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("authToken=");
        sb.append(this.f8379a);
        sb.append(",userName=");
        sb.append(this.f8380b);
        sb.append(",userId=");
        sb.append(this.f8381c);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8379a, i);
        parcel.writeString(this.f8380b);
        parcel.writeLong(this.f8381c);
    }
}
