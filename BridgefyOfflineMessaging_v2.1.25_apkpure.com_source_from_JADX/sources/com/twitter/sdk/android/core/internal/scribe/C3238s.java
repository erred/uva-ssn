package com.twitter.sdk.android.core.internal.scribe;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.s */
/* compiled from: ScribeEvent */
public class C3238s {
    @SerializedName("event_namespace")

    /* renamed from: a */
    final C3215e f8491a;
    @SerializedName("ts")

    /* renamed from: b */
    final String f8492b;
    @SerializedName("format_version")

    /* renamed from: c */
    final String f8493c = "2";
    @SerializedName("_category_")

    /* renamed from: d */
    final String f8494d;
    @SerializedName("items")

    /* renamed from: e */
    final List<C3243w> f8495e;

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.s$a */
    /* compiled from: ScribeEvent */
    public static class C3239a implements C3217f<C3238s> {

        /* renamed from: a */
        private final Gson f8496a;

        public C3239a(Gson gson) {
            this.f8496a = gson;
        }

        /* renamed from: a */
        public byte[] mo27790a(C3238s sVar) throws IOException {
            return this.f8496a.toJson((Object) sVar).getBytes("UTF-8");
        }
    }

    public C3238s(String str, C3215e eVar, long j, List<C3243w> list) {
        this.f8494d = str;
        this.f8491a = eVar;
        this.f8492b = String.valueOf(j);
        this.f8495e = Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("event_namespace=");
        sb.append(this.f8491a);
        sb.append(", ts=");
        sb.append(this.f8492b);
        sb.append(", format_version=");
        sb.append(this.f8493c);
        sb.append(", _category_=");
        sb.append(this.f8494d);
        sb.append(", items=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(TextUtils.join(", ", this.f8495e));
        sb2.append("]");
        sb.append(sb2.toString());
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3238s sVar = (C3238s) obj;
        if (this.f8494d == null ? sVar.f8494d != null : !this.f8494d.equals(sVar.f8494d)) {
            return false;
        }
        if (this.f8491a == null ? sVar.f8491a != null : !this.f8491a.equals(sVar.f8491a)) {
            return false;
        }
        if (this.f8493c == null ? sVar.f8493c != null : !this.f8493c.equals(sVar.f8493c)) {
            return false;
        }
        if (this.f8492b == null ? sVar.f8492b == null : this.f8492b.equals(sVar.f8492b)) {
            return this.f8495e == null ? sVar.f8495e == null : this.f8495e.equals(sVar.f8495e);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((this.f8491a != null ? this.f8491a.hashCode() : 0) * 31) + (this.f8492b != null ? this.f8492b.hashCode() : 0)) * 31) + (this.f8493c != null ? this.f8493c.hashCode() : 0)) * 31) + (this.f8494d != null ? this.f8494d.hashCode() : 0)) * 31;
        if (this.f8495e != null) {
            i = this.f8495e.hashCode();
        }
        return hashCode + i;
    }
}
