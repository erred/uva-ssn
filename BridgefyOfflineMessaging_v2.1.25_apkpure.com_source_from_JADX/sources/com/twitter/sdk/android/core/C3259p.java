package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.twitter.sdk.android.core.p */
/* compiled from: TwitterAuthConfig */
public class C3259p implements Parcelable {
    public static final Creator<C3259p> CREATOR = new Creator<C3259p>() {
        /* renamed from: a */
        public C3259p createFromParcel(Parcel parcel) {
            return new C3259p(parcel);
        }

        /* renamed from: a */
        public C3259p[] newArray(int i) {
            return new C3259p[i];
        }
    };

    /* renamed from: a */
    private final String f8542a;

    /* renamed from: b */
    private final String f8543b;

    /* renamed from: c */
    public int mo27866c() {
        return 140;
    }

    public int describeContents() {
        return 0;
    }

    public C3259p(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("TwitterAuthConfig must not be created with null consumer key or secret.");
        }
        this.f8542a = m9556a(str);
        this.f8543b = m9556a(str2);
    }

    private C3259p(Parcel parcel) {
        this.f8542a = parcel.readString();
        this.f8543b = parcel.readString();
    }

    /* renamed from: a */
    public String mo27864a() {
        return this.f8542a;
    }

    /* renamed from: b */
    public String mo27865b() {
        return this.f8543b;
    }

    /* renamed from: a */
    static String m9556a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8542a);
        parcel.writeString(this.f8543b);
    }
}
