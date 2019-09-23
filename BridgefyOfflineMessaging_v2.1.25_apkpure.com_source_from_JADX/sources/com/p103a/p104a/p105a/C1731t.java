package com.p103a.p104a.p105a;

/* renamed from: com.a.a.a.t */
/* compiled from: SessionEventMetadata */
final class C1731t {

    /* renamed from: a */
    public final String f5426a;

    /* renamed from: b */
    public final String f5427b;

    /* renamed from: c */
    public final String f5428c;

    /* renamed from: d */
    public final String f5429d;

    /* renamed from: e */
    public final String f5430e;

    /* renamed from: f */
    public final Boolean f5431f;

    /* renamed from: g */
    public final String f5432g;

    /* renamed from: h */
    public final String f5433h;

    /* renamed from: i */
    public final String f5434i;

    /* renamed from: j */
    public final String f5435j;

    /* renamed from: k */
    public final String f5436k;

    /* renamed from: l */
    public final String f5437l;

    /* renamed from: m */
    private String f5438m;

    public C1731t(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f5426a = str;
        this.f5427b = str2;
        this.f5428c = str3;
        this.f5429d = str4;
        this.f5430e = str5;
        this.f5431f = bool;
        this.f5432g = str6;
        this.f5433h = str7;
        this.f5434i = str8;
        this.f5435j = str9;
        this.f5436k = str10;
        this.f5437l = str11;
    }

    public String toString() {
        if (this.f5438m == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("appBundleId=");
            sb.append(this.f5426a);
            sb.append(", executionId=");
            sb.append(this.f5427b);
            sb.append(", installationId=");
            sb.append(this.f5428c);
            sb.append(", androidId=");
            sb.append(this.f5429d);
            sb.append(", advertisingId=");
            sb.append(this.f5430e);
            sb.append(", limitAdTrackingEnabled=");
            sb.append(this.f5431f);
            sb.append(", betaDeviceToken=");
            sb.append(this.f5432g);
            sb.append(", buildId=");
            sb.append(this.f5433h);
            sb.append(", osVersion=");
            sb.append(this.f5434i);
            sb.append(", deviceModel=");
            sb.append(this.f5435j);
            sb.append(", appVersionCode=");
            sb.append(this.f5436k);
            sb.append(", appVersionName=");
            sb.append(this.f5437l);
            this.f5438m = sb.toString();
        }
        return this.f5438m;
    }
}
