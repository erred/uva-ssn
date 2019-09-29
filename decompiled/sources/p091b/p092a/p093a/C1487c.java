package p091b.p092a.p093a;

import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1596ac.C1597a;
import p091b.C1612d;
import p091b.C1640s;
import p091b.C1640s.C1641a;
import p091b.p092a.C1483a;
import p091b.p092a.p095c.C1515d;
import p091b.p092a.p095c.C1517e;

/* renamed from: b.a.a.c */
/* compiled from: CacheStrategy */
public final class C1487c {

    /* renamed from: a */
    public final C1590aa f4453a;

    /* renamed from: b */
    public final C1596ac f4454b;

    /* renamed from: b.a.a.c$a */
    /* compiled from: CacheStrategy */
    public static class C1488a {

        /* renamed from: a */
        final long f4455a;

        /* renamed from: b */
        final C1590aa f4456b;

        /* renamed from: c */
        final C1596ac f4457c;

        /* renamed from: d */
        private Date f4458d;

        /* renamed from: e */
        private String f4459e;

        /* renamed from: f */
        private Date f4460f;

        /* renamed from: g */
        private String f4461g;

        /* renamed from: h */
        private Date f4462h;

        /* renamed from: i */
        private long f4463i;

        /* renamed from: j */
        private long f4464j;

        /* renamed from: k */
        private String f4465k;

        /* renamed from: l */
        private int f4466l = -1;

        public C1488a(long j, C1590aa aaVar, C1596ac acVar) {
            this.f4455a = j;
            this.f4456b = aaVar;
            this.f4457c = acVar;
            if (acVar != null) {
                this.f4463i = acVar.mo6493n();
                this.f4464j = acVar.mo6494o();
                C1640s g = acVar.mo6486g();
                int a = g.mo6643a();
                for (int i = 0; i < a; i++) {
                    String a2 = g.mo6644a(i);
                    String b = g.mo6647b(i);
                    if (HttpHeaders.DATE.equalsIgnoreCase(a2)) {
                        this.f4458d = C1515d.m6111a(b);
                        this.f4459e = b;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(a2)) {
                        this.f4462h = C1515d.m6111a(b);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(a2)) {
                        this.f4460f = C1515d.m6111a(b);
                        this.f4461g = b;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(a2)) {
                        this.f4465k = b;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(a2)) {
                        this.f4466l = C1517e.m6121b(b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        public C1487c mo6190a() {
            C1487c b = m5964b();
            return (b.f4453a == null || !this.f4456b.mo6461f().mo6544i()) ? b : new C1487c(null, null);
        }

        /* renamed from: b */
        private C1487c m5964b() {
            String str;
            String str2;
            if (this.f4457c == null) {
                return new C1487c(this.f4456b, null);
            }
            if (this.f4456b.mo6462g() && this.f4457c.mo6485f() == null) {
                return new C1487c(this.f4456b, null);
            }
            if (!C1487c.m5962a(this.f4457c, this.f4456b)) {
                return new C1487c(this.f4456b, null);
            }
            C1612d f = this.f4456b.mo6461f();
            if (f.mo6536a() || m5963a(this.f4456b)) {
                return new C1487c(this.f4456b, null);
            }
            C1612d m = this.f4457c.mo6492m();
            if (m.mo6545j()) {
                return new C1487c(null, this.f4457c);
            }
            long d = m5966d();
            long c = m5965c();
            if (f.mo6538c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis((long) f.mo6538c()));
            }
            long j = 0;
            long millis = f.mo6543h() != -1 ? TimeUnit.SECONDS.toMillis((long) f.mo6543h()) : 0;
            if (!m.mo6541f() && f.mo6542g() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) f.mo6542g());
            }
            if (!m.mo6536a()) {
                long j2 = millis + d;
                if (j2 < j + c) {
                    C1597a i = this.f4457c.mo6488i();
                    if (j2 >= c) {
                        i.mo6505a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d > 86400000 && m5967e()) {
                        i.mo6505a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new C1487c(null, i.mo6506a());
                }
            }
            if (this.f4465k != null) {
                str2 = HttpHeaders.IF_NONE_MATCH;
                str = this.f4465k;
            } else if (this.f4460f != null) {
                str2 = HttpHeaders.IF_MODIFIED_SINCE;
                str = this.f4461g;
            } else if (this.f4458d == null) {
                return new C1487c(this.f4456b, null);
            } else {
                str2 = HttpHeaders.IF_MODIFIED_SINCE;
                str = this.f4459e;
            }
            C1641a b = this.f4456b.mo6458c().mo6646b();
            C1483a.f4446a.mo6180a(b, str2, str);
            return new C1487c(this.f4456b.mo6460e().mo6466a(b.mo6654a()).mo6471a(), this.f4457c);
        }

        /* renamed from: c */
        private long m5965c() {
            long j;
            long j2;
            C1612d m = this.f4457c.mo6492m();
            if (m.mo6538c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) m.mo6538c());
            }
            long j3 = 0;
            if (this.f4462h != null) {
                if (this.f4458d != null) {
                    j2 = this.f4458d.getTime();
                } else {
                    j2 = this.f4464j;
                }
                long time = this.f4462h.getTime() - j2;
                if (time > 0) {
                    j3 = time;
                }
                return j3;
            } else if (this.f4460f == null || this.f4457c.mo6477a().mo6454a().mo6676l() != null) {
                return 0;
            } else {
                if (this.f4458d != null) {
                    j = this.f4458d.getTime();
                } else {
                    j = this.f4463i;
                }
                long time2 = j - this.f4460f.getTime();
                if (time2 > 0) {
                    j3 = time2 / 10;
                }
                return j3;
            }
        }

        /* renamed from: d */
        private long m5966d() {
            long j = 0;
            if (this.f4458d != null) {
                j = Math.max(0, this.f4464j - this.f4458d.getTime());
            }
            if (this.f4466l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f4466l));
            }
            return j + (this.f4464j - this.f4463i) + (this.f4455a - this.f4464j);
        }

        /* renamed from: e */
        private boolean m5967e() {
            return this.f4457c.mo6492m().mo6538c() == -1 && this.f4462h == null;
        }

        /* renamed from: a */
        private static boolean m5963a(C1590aa aaVar) {
            return (aaVar.mo6455a(HttpHeaders.IF_MODIFIED_SINCE) == null && aaVar.mo6455a(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }

    C1487c(C1590aa aaVar, C1596ac acVar) {
        this.f4453a = aaVar;
        this.f4454b = acVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r3.mo6492m().mo6537b() != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r4.mo6461f().mo6537b() != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r3.mo6492m().mo6539d() == false) goto L_0x0046;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m5962a(p091b.C1596ac r3, p091b.C1590aa r4) {
        /*
            int r0 = r3.mo6481c()
            r1 = 0
            switch(r0) {
                case 200: goto L_0x0030;
                case 203: goto L_0x0030;
                case 204: goto L_0x0030;
                case 300: goto L_0x0030;
                case 301: goto L_0x0030;
                case 302: goto L_0x0009;
                case 307: goto L_0x0009;
                case 308: goto L_0x0030;
                case 404: goto L_0x0030;
                case 405: goto L_0x0030;
                case 410: goto L_0x0030;
                case 414: goto L_0x0030;
                case 501: goto L_0x0030;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0046
        L_0x0009:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.mo6478a(r0)
            if (r0 != 0) goto L_0x0030
            b.d r0 = r3.mo6492m()
            int r0 = r0.mo6538c()
            r2 = -1
            if (r0 != r2) goto L_0x0030
            b.d r0 = r3.mo6492m()
            boolean r0 = r0.mo6540e()
            if (r0 != 0) goto L_0x0030
            b.d r0 = r3.mo6492m()
            boolean r0 = r0.mo6539d()
            if (r0 == 0) goto L_0x0046
        L_0x0030:
            b.d r3 = r3.mo6492m()
            boolean r3 = r3.mo6537b()
            if (r3 != 0) goto L_0x0045
            b.d r3 = r4.mo6461f()
            boolean r3 = r3.mo6537b()
            if (r3 != 0) goto L_0x0045
            r1 = 1
        L_0x0045:
            return r1
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p093a.C1487c.m5962a(b.ac, b.aa):boolean");
    }
}
