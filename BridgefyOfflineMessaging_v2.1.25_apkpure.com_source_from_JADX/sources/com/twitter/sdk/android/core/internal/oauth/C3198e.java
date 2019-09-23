package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.C3102a;

/* renamed from: com.twitter.sdk.android.core.internal.oauth.e */
/* compiled from: OAuth2Token */
public class C3198e extends C3102a implements Parcelable {
    public static final Creator<C3198e> CREATOR = new Creator<C3198e>() {
        /* renamed from: a */
        public C3198e createFromParcel(Parcel parcel) {
            return new C3198e(parcel);
        }

        /* renamed from: a */
        public C3198e[] newArray(int i) {
            return new C3198e[i];
        }
    };
    @SerializedName("token_type")

    /* renamed from: b */
    private final String f8377b;
    @SerializedName("access_token")

    /* renamed from: c */
    private final String f8378c;

    /* renamed from: b */
    public boolean mo27730b() {
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public C3198e(String str, String str2) {
        this.f8377b = str;
        this.f8378c = str2;
    }

    private C3198e(Parcel parcel) {
        this.f8377b = parcel.readString();
        this.f8378c = parcel.readString();
    }

    /* renamed from: c */
    public String mo27739c() {
        return this.f8377b;
    }

    /* renamed from: d */
    public String mo27740d() {
        return this.f8378c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8377b);
        parcel.writeString(this.f8378c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3198e eVar = (C3198e) obj;
        if (this.f8378c == null ? eVar.f8378c == null : this.f8378c.equals(eVar.f8378c)) {
            return this.f8377b == null ? eVar.f8377b == null : this.f8377b.equals(eVar.f8377b);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f8377b != null ? this.f8377b.hashCode() : 0) * 31;
        if (this.f8378c != null) {
            i = this.f8378c.hashCode();
        }
        return hashCode + i;
    }
}
