package com.twitter.sdk.android.core.services.p135a;

/* renamed from: com.twitter.sdk.android.core.services.a.a */
/* compiled from: Geocode */
public class C3264a {

    /* renamed from: a */
    public final double f8546a;

    /* renamed from: b */
    public final double f8547b;

    /* renamed from: c */
    public final int f8548c;

    /* renamed from: d */
    public final C3265a f8549d;

    /* renamed from: com.twitter.sdk.android.core.services.a.a$a */
    /* compiled from: Geocode */
    public enum C3265a {
        MILES("mi"),
        KILOMETERS("km");
        

        /* renamed from: c */
        public final String f8553c;

        private C3265a(String str) {
            this.f8553c = str;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8546a);
        sb.append(",");
        sb.append(this.f8547b);
        sb.append(",");
        sb.append(this.f8548c);
        sb.append(this.f8549d.f8553c);
        return sb.toString();
    }
}
