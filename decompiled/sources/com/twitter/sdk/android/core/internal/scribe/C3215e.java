package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.e */
/* compiled from: EventNamespace */
public class C3215e {
    @SerializedName("client")

    /* renamed from: a */
    public final String f8423a;
    @SerializedName("page")

    /* renamed from: b */
    public final String f8424b;
    @SerializedName("section")

    /* renamed from: c */
    public final String f8425c;
    @SerializedName("component")

    /* renamed from: d */
    public final String f8426d;
    @SerializedName("element")

    /* renamed from: e */
    public final String f8427e;
    @SerializedName("action")

    /* renamed from: f */
    public final String f8428f;

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.e$a */
    /* compiled from: EventNamespace */
    public static class C3216a {

        /* renamed from: a */
        private String f8429a;

        /* renamed from: b */
        private String f8430b;

        /* renamed from: c */
        private String f8431c;

        /* renamed from: d */
        private String f8432d;

        /* renamed from: e */
        private String f8433e;

        /* renamed from: f */
        private String f8434f;

        /* renamed from: a */
        public C3216a mo27783a(String str) {
            this.f8429a = str;
            return this;
        }

        /* renamed from: b */
        public C3216a mo27785b(String str) {
            this.f8430b = str;
            return this;
        }

        /* renamed from: c */
        public C3216a mo27786c(String str) {
            this.f8431c = str;
            return this;
        }

        /* renamed from: d */
        public C3216a mo27787d(String str) {
            this.f8432d = str;
            return this;
        }

        /* renamed from: e */
        public C3216a mo27788e(String str) {
            this.f8433e = str;
            return this;
        }

        /* renamed from: f */
        public C3216a mo27789f(String str) {
            this.f8434f = str;
            return this;
        }

        /* renamed from: a */
        public C3215e mo27784a() {
            C3215e eVar = new C3215e(this.f8429a, this.f8430b, this.f8431c, this.f8432d, this.f8433e, this.f8434f);
            return eVar;
        }
    }

    public C3215e(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f8423a = str;
        this.f8424b = str2;
        this.f8425c = str3;
        this.f8426d = str4;
        this.f8427e = str5;
        this.f8428f = str6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("client=");
        sb.append(this.f8423a);
        sb.append(", page=");
        sb.append(this.f8424b);
        sb.append(", section=");
        sb.append(this.f8425c);
        sb.append(", component=");
        sb.append(this.f8426d);
        sb.append(", element=");
        sb.append(this.f8427e);
        sb.append(", action=");
        sb.append(this.f8428f);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3215e eVar = (C3215e) obj;
        if (this.f8428f == null ? eVar.f8428f != null : !this.f8428f.equals(eVar.f8428f)) {
            return false;
        }
        if (this.f8423a == null ? eVar.f8423a != null : !this.f8423a.equals(eVar.f8423a)) {
            return false;
        }
        if (this.f8426d == null ? eVar.f8426d != null : !this.f8426d.equals(eVar.f8426d)) {
            return false;
        }
        if (this.f8427e == null ? eVar.f8427e != null : !this.f8427e.equals(eVar.f8427e)) {
            return false;
        }
        if (this.f8424b == null ? eVar.f8424b == null : this.f8424b.equals(eVar.f8424b)) {
            return this.f8425c == null ? eVar.f8425c == null : this.f8425c.equals(eVar.f8425c);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((this.f8423a != null ? this.f8423a.hashCode() : 0) * 31) + (this.f8424b != null ? this.f8424b.hashCode() : 0)) * 31) + (this.f8425c != null ? this.f8425c.hashCode() : 0)) * 31) + (this.f8426d != null ? this.f8426d.hashCode() : 0)) * 31) + (this.f8427e != null ? this.f8427e.hashCode() : 0)) * 31;
        if (this.f8428f != null) {
            i = this.f8428f.hashCode();
        }
        return hashCode + i;
    }
}
