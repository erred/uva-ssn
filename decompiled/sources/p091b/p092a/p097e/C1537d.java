package p091b.p092a.p097e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.api.client.http.HttpMethods;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p091b.p092a.C1508c;
import p102c.C1672c;
import p102c.C1676e;
import p102c.C1677f;
import p102c.C1683l;
import p102c.C1695s;

/* renamed from: b.a.e.d */
/* compiled from: Hpack */
final class C1537d {

    /* renamed from: a */
    static final C1536c[] f4657a = {new C1536c(C1536c.f4653f, ""), new C1536c(C1536c.f4650c, HttpMethods.GET), new C1536c(C1536c.f4650c, HttpMethods.POST), new C1536c(C1536c.f4651d, "/"), new C1536c(C1536c.f4651d, "/index.html"), new C1536c(C1536c.f4652e, "http"), new C1536c(C1536c.f4652e, "https"), new C1536c(C1536c.f4649b, "200"), new C1536c(C1536c.f4649b, "204"), new C1536c(C1536c.f4649b, "206"), new C1536c(C1536c.f4649b, "304"), new C1536c(C1536c.f4649b, "400"), new C1536c(C1536c.f4649b, "404"), new C1536c(C1536c.f4649b, "500"), new C1536c("accept-charset", ""), new C1536c("accept-encoding", "gzip, deflate"), new C1536c("accept-language", ""), new C1536c("accept-ranges", ""), new C1536c("accept", ""), new C1536c("access-control-allow-origin", ""), new C1536c("age", ""), new C1536c("allow", ""), new C1536c("authorization", ""), new C1536c("cache-control", ""), new C1536c("content-disposition", ""), new C1536c("content-encoding", ""), new C1536c("content-language", ""), new C1536c("content-length", ""), new C1536c("content-location", ""), new C1536c("content-range", ""), new C1536c("content-type", ""), new C1536c("cookie", ""), new C1536c("date", ""), new C1536c("etag", ""), new C1536c("expect", ""), new C1536c("expires", ""), new C1536c("from", ""), new C1536c("host", ""), new C1536c("if-match", ""), new C1536c("if-modified-since", ""), new C1536c("if-none-match", ""), new C1536c("if-range", ""), new C1536c("if-unmodified-since", ""), new C1536c("last-modified", ""), new C1536c("link", ""), new C1536c(Param.LOCATION, ""), new C1536c("max-forwards", ""), new C1536c("proxy-authenticate", ""), new C1536c("proxy-authorization", ""), new C1536c("range", ""), new C1536c("referer", ""), new C1536c("refresh", ""), new C1536c("retry-after", ""), new C1536c("server", ""), new C1536c("set-cookie", ""), new C1536c("strict-transport-security", ""), new C1536c("transfer-encoding", ""), new C1536c("user-agent", ""), new C1536c("vary", ""), new C1536c("via", ""), new C1536c("www-authenticate", "")};

    /* renamed from: b */
    static final Map<C1677f, Integer> f4658b = m6191a();

    /* renamed from: b.a.e.d$a */
    /* compiled from: Hpack */
    static final class C1538a {

        /* renamed from: a */
        C1536c[] f4659a;

        /* renamed from: b */
        int f4660b;

        /* renamed from: c */
        int f4661c;

        /* renamed from: d */
        int f4662d;

        /* renamed from: e */
        private final List<C1536c> f4663e;

        /* renamed from: f */
        private final C1676e f4664f;

        /* renamed from: g */
        private final int f4665g;

        /* renamed from: h */
        private int f4666h;

        C1538a(int i, C1695s sVar) {
            this(i, i, sVar);
        }

        C1538a(int i, int i2, C1695s sVar) {
            this.f4663e = new ArrayList();
            this.f4659a = new C1536c[8];
            this.f4660b = this.f4659a.length - 1;
            this.f4661c = 0;
            this.f4662d = 0;
            this.f4665g = i;
            this.f4666h = i2;
            this.f4664f = C1683l.m7033a(sVar);
        }

        /* renamed from: d */
        private void m6196d() {
            if (this.f4666h >= this.f4662d) {
                return;
            }
            if (this.f4666h == 0) {
                m6198e();
            } else {
                m6192a(this.f4662d - this.f4666h);
            }
        }

        /* renamed from: e */
        private void m6198e() {
            Arrays.fill(this.f4659a, null);
            this.f4660b = this.f4659a.length - 1;
            this.f4661c = 0;
            this.f4662d = 0;
        }

        /* renamed from: a */
        private int m6192a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f4659a.length;
                while (true) {
                    length--;
                    if (length < this.f4660b || i <= 0) {
                        System.arraycopy(this.f4659a, this.f4660b + 1, this.f4659a, this.f4660b + 1 + i2, this.f4661c);
                        this.f4660b += i2;
                    } else {
                        i -= this.f4659a[length].f4656i;
                        this.f4662d -= this.f4659a[length].f4656i;
                        this.f4661c--;
                        i2++;
                    }
                }
                System.arraycopy(this.f4659a, this.f4660b + 1, this.f4659a, this.f4660b + 1 + i2, this.f4661c);
                this.f4660b += i2;
            }
            return i2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6311a() throws IOException {
            while (!this.f4664f.mo6844f()) {
                byte i = this.f4664f.mo6852i() & UnsignedBytes.MAX_VALUE;
                if (i == 128) {
                    throw new IOException("index == 0");
                } else if ((i & 128) == 128) {
                    m6194b(mo6310a((int) i, 127) - 1);
                } else if (i == 64) {
                    m6202g();
                } else if ((i & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                    m6199e(mo6310a((int) i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.f4666h = mo6310a((int) i, 31);
                    if (this.f4666h < 0 || this.f4666h > this.f4665g) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid dynamic table size update ");
                        sb.append(this.f4666h);
                        throw new IOException(sb.toString());
                    }
                    m6196d();
                } else if (i == 16 || i == 0) {
                    m6201f();
                } else {
                    m6197d(mo6310a((int) i, 15) - 1);
                }
            }
        }

        /* renamed from: b */
        public List<C1536c> mo6312b() {
            ArrayList arrayList = new ArrayList(this.f4663e);
            this.f4663e.clear();
            return arrayList;
        }

        /* renamed from: b */
        private void m6194b(int i) throws IOException {
            if (m6203g(i)) {
                this.f4663e.add(C1537d.f4657a[i]);
                return;
            }
            int c = m6195c(i - C1537d.f4657a.length);
            if (c < 0 || c >= this.f4659a.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("Header index too large ");
                sb.append(i + 1);
                throw new IOException(sb.toString());
            }
            this.f4663e.add(this.f4659a[c]);
        }

        /* renamed from: c */
        private int m6195c(int i) {
            return this.f4660b + 1 + i;
        }

        /* renamed from: d */
        private void m6197d(int i) throws IOException {
            this.f4663e.add(new C1536c(m6200f(i), mo6313c()));
        }

        /* renamed from: f */
        private void m6201f() throws IOException {
            this.f4663e.add(new C1536c(C1537d.m6190a(mo6313c()), mo6313c()));
        }

        /* renamed from: e */
        private void m6199e(int i) throws IOException {
            m6193a(-1, new C1536c(m6200f(i), mo6313c()));
        }

        /* renamed from: g */
        private void m6202g() throws IOException {
            m6193a(-1, new C1536c(C1537d.m6190a(mo6313c()), mo6313c()));
        }

        /* renamed from: f */
        private C1677f m6200f(int i) throws IOException {
            if (m6203g(i)) {
                return C1537d.f4657a[i].f4654g;
            }
            int c = m6195c(i - C1537d.f4657a.length);
            if (c >= 0 && c < this.f4659a.length) {
                return this.f4659a[c].f4654g;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i + 1);
            throw new IOException(sb.toString());
        }

        /* renamed from: g */
        private boolean m6203g(int i) {
            return i >= 0 && i <= C1537d.f4657a.length - 1;
        }

        /* renamed from: a */
        private void m6193a(int i, C1536c cVar) {
            this.f4663e.add(cVar);
            int i2 = cVar.f4656i;
            if (i != -1) {
                i2 -= this.f4659a[m6195c(i)].f4656i;
            }
            if (i2 > this.f4666h) {
                m6198e();
                return;
            }
            int a = m6192a((this.f4662d + i2) - this.f4666h);
            if (i == -1) {
                if (this.f4661c + 1 > this.f4659a.length) {
                    C1536c[] cVarArr = new C1536c[(this.f4659a.length * 2)];
                    System.arraycopy(this.f4659a, 0, cVarArr, this.f4659a.length, this.f4659a.length);
                    this.f4660b = this.f4659a.length - 1;
                    this.f4659a = cVarArr;
                }
                int i3 = this.f4660b;
                this.f4660b = i3 - 1;
                this.f4659a[i3] = cVar;
                this.f4661c++;
            } else {
                this.f4659a[i + m6195c(i) + a] = cVar;
            }
            this.f4662d += i2;
        }

        /* renamed from: h */
        private int m6204h() throws IOException {
            return this.f4664f.mo6852i() & UnsignedBytes.MAX_VALUE;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo6310a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h = m6204h();
                if ((h & 128) == 0) {
                    return i2 + (h << i4);
                }
                i2 += (h & 127) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public C1677f mo6313c() throws IOException {
            int h = m6204h();
            boolean z = (h & 128) == 128;
            int a = mo6310a(h, 127);
            if (z) {
                return C1677f.m6986a(C1566k.m6363a().mo6397a(this.f4664f.mo6847g((long) a)));
            }
            return this.f4664f.mo6833c((long) a);
        }
    }

    /* renamed from: b.a.e.d$b */
    /* compiled from: Hpack */
    static final class C1539b {

        /* renamed from: a */
        int f4667a;

        /* renamed from: b */
        int f4668b;

        /* renamed from: c */
        C1536c[] f4669c;

        /* renamed from: d */
        int f4670d;

        /* renamed from: e */
        int f4671e;

        /* renamed from: f */
        int f4672f;

        /* renamed from: g */
        private final C1672c f4673g;

        /* renamed from: h */
        private final boolean f4674h;

        /* renamed from: i */
        private int f4675i;

        /* renamed from: j */
        private boolean f4676j;

        C1539b(C1672c cVar) {
            this(4096, true, cVar);
        }

        C1539b(int i, boolean z, C1672c cVar) {
            this.f4675i = BaseClientBuilder.API_PRIORITY_OTHER;
            this.f4669c = new C1536c[8];
            this.f4670d = this.f4669c.length - 1;
            this.f4671e = 0;
            this.f4672f = 0;
            this.f4667a = i;
            this.f4668b = i;
            this.f4674h = z;
            this.f4673g = cVar;
        }

        /* renamed from: a */
        private void m6209a() {
            Arrays.fill(this.f4669c, null);
            this.f4670d = this.f4669c.length - 1;
            this.f4671e = 0;
            this.f4672f = 0;
        }

        /* renamed from: b */
        private int m6211b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f4669c.length;
                while (true) {
                    length--;
                    if (length < this.f4670d || i <= 0) {
                        System.arraycopy(this.f4669c, this.f4670d + 1, this.f4669c, this.f4670d + 1 + i2, this.f4671e);
                        Arrays.fill(this.f4669c, this.f4670d + 1, this.f4670d + 1 + i2, null);
                        this.f4670d += i2;
                    } else {
                        i -= this.f4669c[length].f4656i;
                        this.f4672f -= this.f4669c[length].f4656i;
                        this.f4671e--;
                        i2++;
                    }
                }
                System.arraycopy(this.f4669c, this.f4670d + 1, this.f4669c, this.f4670d + 1 + i2, this.f4671e);
                Arrays.fill(this.f4669c, this.f4670d + 1, this.f4670d + 1 + i2, null);
                this.f4670d += i2;
            }
            return i2;
        }

        /* renamed from: a */
        private void m6210a(C1536c cVar) {
            int i = cVar.f4656i;
            if (i > this.f4668b) {
                m6209a();
                return;
            }
            m6211b((this.f4672f + i) - this.f4668b);
            if (this.f4671e + 1 > this.f4669c.length) {
                C1536c[] cVarArr = new C1536c[(this.f4669c.length * 2)];
                System.arraycopy(this.f4669c, 0, cVarArr, this.f4669c.length, this.f4669c.length);
                this.f4670d = this.f4669c.length - 1;
                this.f4669c = cVarArr;
            }
            int i2 = this.f4670d;
            this.f4670d = i2 - 1;
            this.f4669c[i2] = cVar;
            this.f4671e++;
            this.f4672f += i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6317a(List<C1536c> list) throws IOException {
            int i;
            int i2;
            if (this.f4676j) {
                if (this.f4675i < this.f4668b) {
                    mo6315a(this.f4675i, 31, 32);
                }
                this.f4676j = false;
                this.f4675i = BaseClientBuilder.API_PRIORITY_OTHER;
                mo6315a(this.f4668b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1536c cVar = (C1536c) list.get(i3);
                C1677f g = cVar.f4654g.mo6901g();
                C1677f fVar = cVar.f4655h;
                Integer num = (Integer) C1537d.f4658b.get(g);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (C1508c.m6086a((Object) C1537d.f4657a[i2 - 1].f4655h, (Object) fVar)) {
                            i = i2;
                        } else if (C1508c.m6086a((Object) C1537d.f4657a[i2].f4655h, (Object) fVar)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i4 = this.f4670d + 1;
                    int length = this.f4669c.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (C1508c.m6086a((Object) this.f4669c[i4].f4654g, (Object) g)) {
                            if (C1508c.m6086a((Object) this.f4669c[i4].f4655h, (Object) fVar)) {
                                i2 = C1537d.f4657a.length + (i4 - this.f4670d);
                                break;
                            } else if (i == -1) {
                                i = (i4 - this.f4670d) + C1537d.f4657a.length;
                            }
                        }
                        i4++;
                    }
                }
                if (i2 != -1) {
                    mo6315a(i2, 127, 128);
                } else if (i == -1) {
                    this.f4673g.mo6854i(64);
                    mo6316a(g);
                    mo6316a(fVar);
                    m6210a(cVar);
                } else if (!g.mo6892a(C1536c.f4648a) || C1536c.f4653f.equals(g)) {
                    mo6315a(i, 63, 64);
                    mo6316a(fVar);
                    m6210a(cVar);
                } else {
                    mo6315a(i, 15, 0);
                    mo6316a(fVar);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6315a(int i, int i2, int i3) {
            if (i < i2) {
                this.f4673g.mo6854i(i | i3);
                return;
            }
            this.f4673g.mo6854i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f4673g.mo6854i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f4673g.mo6854i(i4);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6316a(C1677f fVar) throws IOException {
            if (!this.f4674h || C1566k.m6363a().mo6395a(fVar) >= fVar.mo6902h()) {
                mo6315a(fVar.mo6902h(), 127, 0);
                this.f4673g.mo6827b(fVar);
                return;
            }
            C1672c cVar = new C1672c();
            C1566k.m6363a().mo6396a(fVar, cVar);
            C1677f p = cVar.mo6865p();
            mo6315a(p.mo6902h(), 127, 128);
            this.f4673g.mo6827b(p);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6314a(int i) {
            this.f4667a = i;
            int min = Math.min(i, 16384);
            if (this.f4668b != min) {
                if (min < this.f4668b) {
                    this.f4675i = Math.min(this.f4675i, min);
                }
                this.f4676j = true;
                this.f4668b = min;
                m6212b();
            }
        }

        /* renamed from: b */
        private void m6212b() {
            if (this.f4668b >= this.f4672f) {
                return;
            }
            if (this.f4668b == 0) {
                m6209a();
            } else {
                m6211b(this.f4672f - this.f4668b);
            }
        }
    }

    /* renamed from: a */
    private static Map<C1677f, Integer> m6191a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f4657a.length);
        for (int i = 0; i < f4657a.length; i++) {
            if (!linkedHashMap.containsKey(f4657a[i].f4654g)) {
                linkedHashMap.put(f4657a[i].f4654g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    static C1677f m6190a(C1677f fVar) throws IOException {
        int h = fVar.mo6902h();
        int i = 0;
        while (i < h) {
            byte a = fVar.mo6886a(i);
            if (a < 65 || a > 90) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                sb.append(fVar.mo6888a());
                throw new IOException(sb.toString());
            }
        }
        return fVar;
    }
}
