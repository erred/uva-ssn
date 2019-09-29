package com.twitter.sdk.android.core.internal.oauth;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.twitter.sdk.android.core.internal.oauth.a */
/* compiled from: GuestAuthToken */
public class C3194a extends C3198e {
    @SerializedName("guest_token")

    /* renamed from: b */
    private final String f8368b;

    public C3194a(String str, String str2, String str3) {
        super(str, str2);
        this.f8368b = str3;
    }

    /* renamed from: a */
    public String mo27729a() {
        return this.f8368b;
    }

    /* renamed from: b */
    public boolean mo27730b() {
        return System.currentTimeMillis() >= this.f8159a + 10800000;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C3194a aVar = (C3194a) obj;
        return this.f8368b == null ? aVar.f8368b == null : this.f8368b.equals(aVar.f8368b);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.f8368b != null ? this.f8368b.hashCode() : 0);
    }
}
