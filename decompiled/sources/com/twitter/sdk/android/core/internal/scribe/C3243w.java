package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.internal.C3207q;
import com.twitter.sdk.android.core.p132a.C3107e;
import com.twitter.sdk.android.core.p132a.C3112j;
import com.twitter.sdk.android.core.p132a.C3119o;
import java.io.Serializable;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.w */
/* compiled from: ScribeItem */
public class C3243w implements Serializable {
    @SerializedName("item_type")

    /* renamed from: a */
    public final Integer f8497a;
    @SerializedName("id")

    /* renamed from: b */
    public final Long f8498b;
    @SerializedName("description")

    /* renamed from: c */
    public final String f8499c;
    @SerializedName("card_event")

    /* renamed from: d */
    public final C3246b f8500d;
    @SerializedName("media_details")

    /* renamed from: e */
    public final C3247c f8501e;

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.w$a */
    /* compiled from: ScribeItem */
    public static class C3245a {

        /* renamed from: a */
        private Integer f8502a;

        /* renamed from: b */
        private Long f8503b;

        /* renamed from: c */
        private String f8504c;

        /* renamed from: d */
        private C3246b f8505d;

        /* renamed from: e */
        private C3247c f8506e;

        /* renamed from: a */
        public C3245a mo27840a(int i) {
            this.f8502a = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public C3245a mo27841a(long j) {
            this.f8503b = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3245a mo27842a(C3247c cVar) {
            this.f8506e = cVar;
            return this;
        }

        /* renamed from: a */
        public C3243w mo27843a() {
            C3243w wVar = new C3243w(this.f8502a, this.f8503b, this.f8504c, this.f8505d, this.f8506e);
            return wVar;
        }
    }

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.w$b */
    /* compiled from: ScribeItem */
    public static class C3246b implements Serializable {
        @SerializedName("promotion_card_type")

        /* renamed from: a */
        final int f8507a;

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (this.f8507a != ((C3246b) obj).f8507a) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f8507a;
        }
    }

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.w$c */
    /* compiled from: ScribeItem */
    public static class C3247c implements Serializable {
        @SerializedName("content_id")

        /* renamed from: a */
        public final long f8508a;
        @SerializedName("media_type")

        /* renamed from: b */
        public final int f8509b;
        @SerializedName("publisher_id")

        /* renamed from: c */
        public final long f8510c;

        public C3247c(long j, int i, long j2) {
            this.f8508a = j;
            this.f8509b = i;
            this.f8510c = j2;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C3247c cVar = (C3247c) obj;
            if (this.f8508a != cVar.f8508a || this.f8509b != cVar.f8509b) {
                return false;
            }
            if (this.f8510c != cVar.f8510c) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (((((int) (this.f8508a ^ (this.f8508a >>> 32))) * 31) + this.f8509b) * 31) + ((int) (this.f8510c ^ (this.f8510c >>> 32)));
        }
    }

    private C3243w(Integer num, Long l, String str, C3246b bVar, C3247c cVar) {
        this.f8497a = num;
        this.f8498b = l;
        this.f8499c = str;
        this.f8500d = bVar;
        this.f8501e = cVar;
    }

    /* renamed from: a */
    public static C3243w m9519a(C3119o oVar) {
        return new C3245a().mo27840a(0).mo27841a(oVar.f8194i).mo27843a();
    }

    /* renamed from: a */
    public static C3243w m9517a(long j, C3107e eVar) {
        return new C3245a().mo27840a(0).mo27841a(j).mo27842a(m9520b(j, eVar)).mo27843a();
    }

    /* renamed from: a */
    public static C3243w m9518a(long j, C3112j jVar) {
        return new C3245a().mo27840a(0).mo27841a(j).mo27842a(m9521b(j, jVar)).mo27843a();
    }

    /* renamed from: b */
    static C3247c m9521b(long j, C3112j jVar) {
        C3247c cVar = new C3247c(j, m9516a(jVar), jVar.f8168a);
        return cVar;
    }

    /* renamed from: b */
    static C3247c m9520b(long j, C3107e eVar) {
        C3247c cVar = new C3247c(j, 4, Long.valueOf(C3207q.m9386b(eVar)).longValue());
        return cVar;
    }

    /* renamed from: a */
    static int m9516a(C3112j jVar) {
        return "animated_gif".equals(jVar.f8170c) ? 3 : 1;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3243w wVar = (C3243w) obj;
        if (this.f8497a == null ? wVar.f8497a != null : !this.f8497a.equals(wVar.f8497a)) {
            return false;
        }
        if (this.f8498b == null ? wVar.f8498b != null : !this.f8498b.equals(wVar.f8498b)) {
            return false;
        }
        if (this.f8499c == null ? wVar.f8499c != null : !this.f8499c.equals(wVar.f8499c)) {
            return false;
        }
        if (this.f8500d == null ? wVar.f8500d != null : !this.f8500d.equals(wVar.f8500d)) {
            return false;
        }
        if (this.f8501e == null ? wVar.f8501e != null : !this.f8501e.equals(wVar.f8501e)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((this.f8497a != null ? this.f8497a.hashCode() : 0) * 31) + (this.f8498b != null ? this.f8498b.hashCode() : 0)) * 31) + (this.f8499c != null ? this.f8499c.hashCode() : 0)) * 31) + (this.f8500d != null ? this.f8500d.hashCode() : 0)) * 31;
        if (this.f8501e != null) {
            i = this.f8501e.hashCode();
        }
        return hashCode + i;
    }
}
