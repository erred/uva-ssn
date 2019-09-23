package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.internal.p134b.C3167e;

/* renamed from: com.twitter.sdk.android.core.y */
/* compiled from: TwitterSession */
public class C3274y extends C3254k<C3262s> {
    @SerializedName("user_name")

    /* renamed from: a */
    private final String f8578a;

    /* renamed from: com.twitter.sdk.android.core.y$a */
    /* compiled from: TwitterSession */
    static class C3275a implements C3167e<C3274y> {

        /* renamed from: a */
        private final Gson f8579a = new Gson();

        /* renamed from: a */
        public String mo27616a(C3274y yVar) {
            if (!(yVar == null || yVar.mo27849a() == null)) {
                try {
                    return this.f8579a.toJson((Object) yVar);
                } catch (Exception e) {
                    C3256m.m9537g().mo27607a("Twitter", e.getMessage());
                }
            }
            return "";
        }

        /* renamed from: a */
        public C3274y mo27617b(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return (C3274y) this.f8579a.fromJson(str, C3274y.class);
                } catch (Exception e) {
                    C3256m.m9537g().mo27607a("Twitter", e.getMessage());
                }
            }
            return null;
        }
    }

    public C3274y(C3262s sVar, long j, String str) {
        super(sVar, j);
        this.f8578a = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C3274y yVar = (C3274y) obj;
        if (this.f8578a != null) {
            z = this.f8578a.equals(yVar.f8578a);
        } else if (yVar.f8578a != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.f8578a != null ? this.f8578a.hashCode() : 0);
    }
}
