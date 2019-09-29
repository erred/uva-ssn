package com.p103a.p104a.p105a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.a.a.a.s */
/* compiled from: SessionEvent */
final class C1727s {

    /* renamed from: a */
    public final C1731t f5401a;

    /* renamed from: b */
    public final long f5402b;

    /* renamed from: c */
    public final C1730b f5403c;

    /* renamed from: d */
    public final Map<String, String> f5404d;

    /* renamed from: e */
    public final String f5405e;

    /* renamed from: f */
    public final Map<String, Object> f5406f;

    /* renamed from: g */
    public final String f5407g;

    /* renamed from: h */
    public final Map<String, Object> f5408h;

    /* renamed from: i */
    private String f5409i;

    /* renamed from: com.a.a.a.s$a */
    /* compiled from: SessionEvent */
    static class C1729a {

        /* renamed from: a */
        final C1730b f5410a;

        /* renamed from: b */
        final long f5411b = System.currentTimeMillis();

        /* renamed from: c */
        Map<String, String> f5412c = null;

        /* renamed from: d */
        String f5413d = null;

        /* renamed from: e */
        Map<String, Object> f5414e = null;

        /* renamed from: f */
        String f5415f = null;

        /* renamed from: g */
        Map<String, Object> f5416g = null;

        public C1729a(C1730b bVar) {
            this.f5410a = bVar;
        }

        /* renamed from: a */
        public C1729a mo6989a(Map<String, String> map) {
            this.f5412c = map;
            return this;
        }

        /* renamed from: b */
        public C1729a mo6991b(Map<String, Object> map) {
            this.f5414e = map;
            return this;
        }

        /* renamed from: a */
        public C1727s mo6990a(C1731t tVar) {
            C1727s sVar = new C1727s(tVar, this.f5411b, this.f5410a, this.f5412c, this.f5413d, this.f5414e, this.f5415f, this.f5416g);
            return sVar;
        }
    }

    /* renamed from: com.a.a.a.s$b */
    /* compiled from: SessionEvent */
    enum C1730b {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    /* renamed from: a */
    public static C1729a m7229a(C1730b bVar, Activity activity) {
        return new C1729a(bVar).mo6989a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    /* renamed from: a */
    public static C1729a m7228a(long j) {
        return new C1729a(C1730b.INSTALL).mo6989a(Collections.singletonMap("installedAt", String.valueOf(j)));
    }

    /* renamed from: a */
    public static C1729a m7230a(String str) {
        return new C1729a(C1730b.CRASH).mo6989a(Collections.singletonMap("sessionId", str));
    }

    /* renamed from: a */
    public static C1729a m7231a(String str, String str2) {
        return m7230a(str).mo6991b(Collections.singletonMap("exceptionName", str2));
    }

    private C1727s(C1731t tVar, long j, C1730b bVar, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f5401a = tVar;
        this.f5402b = j;
        this.f5403c = bVar;
        this.f5404d = map;
        this.f5405e = str;
        this.f5406f = map2;
        this.f5407g = str2;
        this.f5408h = map3;
    }

    public String toString() {
        if (this.f5409i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(getClass().getSimpleName());
            sb.append(": ");
            sb.append("timestamp=");
            sb.append(this.f5402b);
            sb.append(", type=");
            sb.append(this.f5403c);
            sb.append(", details=");
            sb.append(this.f5404d);
            sb.append(", customType=");
            sb.append(this.f5405e);
            sb.append(", customAttributes=");
            sb.append(this.f5406f);
            sb.append(", predefinedType=");
            sb.append(this.f5407g);
            sb.append(", predefinedAttributes=");
            sb.append(this.f5408h);
            sb.append(", metadata=[");
            sb.append(this.f5401a);
            sb.append("]]");
            this.f5409i = sb.toString();
        }
        return this.f5409i;
    }
}
