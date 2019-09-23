package p091b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.concurrent.TimeUnit;

/* renamed from: b.d */
/* compiled from: CacheControl */
public final class C1612d {

    /* renamed from: a */
    public static final C1612d f4954a = new C1613a().mo6547a().mo6551d();

    /* renamed from: b */
    public static final C1612d f4955b = new C1613a().mo6550c().mo6548a(BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.SECONDS).mo6551d();

    /* renamed from: c */
    String f4956c;

    /* renamed from: d */
    private final boolean f4957d;

    /* renamed from: e */
    private final boolean f4958e;

    /* renamed from: f */
    private final int f4959f;

    /* renamed from: g */
    private final int f4960g;

    /* renamed from: h */
    private final boolean f4961h;

    /* renamed from: i */
    private final boolean f4962i;

    /* renamed from: j */
    private final boolean f4963j;

    /* renamed from: k */
    private final int f4964k;

    /* renamed from: l */
    private final int f4965l;

    /* renamed from: m */
    private final boolean f4966m;

    /* renamed from: n */
    private final boolean f4967n;

    /* renamed from: o */
    private final boolean f4968o;

    /* renamed from: b.d$a */
    /* compiled from: CacheControl */
    public static final class C1613a {

        /* renamed from: a */
        boolean f4969a;

        /* renamed from: b */
        boolean f4970b;

        /* renamed from: c */
        int f4971c = -1;

        /* renamed from: d */
        int f4972d = -1;

        /* renamed from: e */
        int f4973e = -1;

        /* renamed from: f */
        boolean f4974f;

        /* renamed from: g */
        boolean f4975g;

        /* renamed from: h */
        boolean f4976h;

        /* renamed from: a */
        public C1613a mo6547a() {
            this.f4969a = true;
            return this;
        }

        /* renamed from: b */
        public C1613a mo6549b() {
            this.f4970b = true;
            return this;
        }

        /* renamed from: a */
        public C1613a mo6548a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f4972d = seconds > 2147483647L ? BaseClientBuilder.API_PRIORITY_OTHER : (int) seconds;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("maxStale < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: c */
        public C1613a mo6550c() {
            this.f4974f = true;
            return this;
        }

        /* renamed from: d */
        public C1612d mo6551d() {
            return new C1612d(this);
        }
    }

    private C1612d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f4957d = z;
        this.f4958e = z2;
        this.f4959f = i;
        this.f4960g = i2;
        this.f4961h = z3;
        this.f4962i = z4;
        this.f4963j = z5;
        this.f4964k = i3;
        this.f4965l = i4;
        this.f4966m = z6;
        this.f4967n = z7;
        this.f4968o = z8;
        this.f4956c = str;
    }

    C1612d(C1613a aVar) {
        this.f4957d = aVar.f4969a;
        this.f4958e = aVar.f4970b;
        this.f4959f = aVar.f4971c;
        this.f4960g = -1;
        this.f4961h = false;
        this.f4962i = false;
        this.f4963j = false;
        this.f4964k = aVar.f4972d;
        this.f4965l = aVar.f4973e;
        this.f4966m = aVar.f4974f;
        this.f4967n = aVar.f4975g;
        this.f4968o = aVar.f4976h;
    }

    /* renamed from: a */
    public boolean mo6536a() {
        return this.f4957d;
    }

    /* renamed from: b */
    public boolean mo6537b() {
        return this.f4958e;
    }

    /* renamed from: c */
    public int mo6538c() {
        return this.f4959f;
    }

    /* renamed from: d */
    public boolean mo6539d() {
        return this.f4961h;
    }

    /* renamed from: e */
    public boolean mo6540e() {
        return this.f4962i;
    }

    /* renamed from: f */
    public boolean mo6541f() {
        return this.f4963j;
    }

    /* renamed from: g */
    public int mo6542g() {
        return this.f4964k;
    }

    /* renamed from: h */
    public int mo6543h() {
        return this.f4965l;
    }

    /* renamed from: i */
    public boolean mo6544i() {
        return this.f4966m;
    }

    /* renamed from: j */
    public boolean mo6545j() {
        return this.f4968o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p091b.C1612d m6590a(p091b.C1640s r23) {
        /*
            r0 = r23
            int r1 = r23.mo6643a()
            r6 = 0
            r7 = 1
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = -1
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x001b:
            if (r6 >= r1) goto L_0x014c
            java.lang.String r9 = r0.mo6644a(r6)
            java.lang.String r2 = r0.mo6647b(r6)
            java.lang.String r4 = "Cache-Control"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0033
            if (r8 == 0) goto L_0x0031
        L_0x002f:
            r7 = 0
            goto L_0x003c
        L_0x0031:
            r8 = r2
            goto L_0x003c
        L_0x0033:
            java.lang.String r4 = "Pragma"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0145
            goto L_0x002f
        L_0x003c:
            r4 = 0
        L_0x003d:
            int r9 = r2.length()
            if (r4 >= r9) goto L_0x0145
            java.lang.String r9 = "=,;"
            int r9 = p091b.p092a.p095c.C1517e.m6114a(r2, r4, r9)
            java.lang.String r4 = r2.substring(r4, r9)
            java.lang.String r4 = r4.trim()
            int r3 = r2.length()
            if (r9 == r3) goto L_0x009e
            char r3 = r2.charAt(r9)
            r5 = 44
            if (r3 == r5) goto L_0x009e
            char r3 = r2.charAt(r9)
            r5 = 59
            if (r3 != r5) goto L_0x0068
            goto L_0x009e
        L_0x0068:
            int r9 = r9 + 1
            int r3 = p091b.p092a.p095c.C1517e.m6113a(r2, r9)
            int r5 = r2.length()
            if (r3 >= r5) goto L_0x008d
            char r5 = r2.charAt(r3)
            r9 = 34
            if (r5 != r9) goto L_0x008d
            int r3 = r3 + 1
            java.lang.String r5 = "\""
            int r5 = p091b.p092a.p095c.C1517e.m6114a(r2, r3, r5)
            java.lang.String r3 = r2.substring(r3, r5)
            r22 = 1
            int r5 = r5 + 1
            goto L_0x00a4
        L_0x008d:
            r22 = 1
            java.lang.String r5 = ",;"
            int r5 = p091b.p092a.p095c.C1517e.m6114a(r2, r3, r5)
            java.lang.String r3 = r2.substring(r3, r5)
            java.lang.String r3 = r3.trim()
            goto L_0x00a4
        L_0x009e:
            r22 = 1
            int r9 = r9 + 1
            r5 = r9
            r3 = 0
        L_0x00a4:
            java.lang.String r9 = "no-cache"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00b0
            r9 = -1
            r10 = 1
            goto L_0x0142
        L_0x00b0:
            java.lang.String r9 = "no-store"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00bc
            r9 = -1
            r11 = 1
            goto L_0x0142
        L_0x00bc:
            java.lang.String r9 = "max-age"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00cc
            r9 = -1
            int r3 = p091b.p092a.p095c.C1517e.m6121b(r3, r9)
            r12 = r3
            goto L_0x0142
        L_0x00cc:
            java.lang.String r9 = "s-maxage"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00dc
            r9 = -1
            int r3 = p091b.p092a.p095c.C1517e.m6121b(r3, r9)
            r13 = r3
            goto L_0x0142
        L_0x00dc:
            java.lang.String r9 = "private"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00e7
            r9 = -1
            r14 = 1
            goto L_0x0142
        L_0x00e7:
            java.lang.String r9 = "public"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00f2
            r9 = -1
            r15 = 1
            goto L_0x0142
        L_0x00f2:
            java.lang.String r9 = "must-revalidate"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00fe
            r9 = -1
            r16 = 1
            goto L_0x0142
        L_0x00fe:
            java.lang.String r9 = "max-stale"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x0111
            r4 = 2147483647(0x7fffffff, float:NaN)
            int r3 = p091b.p092a.p095c.C1517e.m6121b(r3, r4)
            r17 = r3
            r9 = -1
            goto L_0x0142
        L_0x0111:
            java.lang.String r9 = "min-fresh"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x0121
            r9 = -1
            int r3 = p091b.p092a.p095c.C1517e.m6121b(r3, r9)
            r18 = r3
            goto L_0x0142
        L_0x0121:
            r9 = -1
            java.lang.String r3 = "only-if-cached"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x012d
            r19 = 1
            goto L_0x0142
        L_0x012d:
            java.lang.String r3 = "no-transform"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0138
            r20 = 1
            goto L_0x0142
        L_0x0138:
            java.lang.String r3 = "immutable"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0142
            r21 = 1
        L_0x0142:
            r4 = r5
            goto L_0x003d
        L_0x0145:
            r9 = -1
            r22 = 1
            int r6 = r6 + 1
            goto L_0x001b
        L_0x014c:
            if (r7 != 0) goto L_0x0151
            r22 = 0
            goto L_0x0153
        L_0x0151:
            r22 = r8
        L_0x0153:
            b.d r0 = new b.d
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.C1612d.m6590a(b.s):b.d");
    }

    public String toString() {
        String str = this.f4956c;
        if (str != null) {
            return str;
        }
        String k = m6591k();
        this.f4956c = k;
        return k;
    }

    /* renamed from: k */
    private String m6591k() {
        StringBuilder sb = new StringBuilder();
        if (this.f4957d) {
            sb.append("no-cache, ");
        }
        if (this.f4958e) {
            sb.append("no-store, ");
        }
        if (this.f4959f != -1) {
            sb.append("max-age=");
            sb.append(this.f4959f);
            sb.append(", ");
        }
        if (this.f4960g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f4960g);
            sb.append(", ");
        }
        if (this.f4961h) {
            sb.append("private, ");
        }
        if (this.f4962i) {
            sb.append("public, ");
        }
        if (this.f4963j) {
            sb.append("must-revalidate, ");
        }
        if (this.f4964k != -1) {
            sb.append("max-stale=");
            sb.append(this.f4964k);
            sb.append(", ");
        }
        if (this.f4965l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f4965l);
            sb.append(", ");
        }
        if (this.f4966m) {
            sb.append("only-if-cached, ");
        }
        if (this.f4967n) {
            sb.append("no-transform, ");
        }
        if (this.f4968o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
