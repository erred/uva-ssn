package p091b;

import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import p091b.p092a.C1508c;
import p102c.C1675d;
import p102c.C1677f;

/* renamed from: b.w */
/* compiled from: MultipartBody */
public final class C1648w extends C1592ab {

    /* renamed from: a */
    public static final C1647v f5187a = C1647v.m6791a("multipart/mixed");

    /* renamed from: b */
    public static final C1647v f5188b = C1647v.m6791a("multipart/alternative");

    /* renamed from: c */
    public static final C1647v f5189c = C1647v.m6791a("multipart/digest");

    /* renamed from: d */
    public static final C1647v f5190d = C1647v.m6791a("multipart/parallel");

    /* renamed from: e */
    public static final C1647v f5191e = C1647v.m6791a("multipart/form-data");

    /* renamed from: f */
    private static final byte[] f5192f = {58, 32};

    /* renamed from: g */
    private static final byte[] f5193g = {Ascii.f6725CR, 10};

    /* renamed from: h */
    private static final byte[] f5194h = {45, 45};

    /* renamed from: i */
    private final C1677f f5195i;

    /* renamed from: j */
    private final C1647v f5196j;

    /* renamed from: k */
    private final C1647v f5197k;

    /* renamed from: l */
    private final List<C1650b> f5198l;

    /* renamed from: m */
    private long f5199m = -1;

    /* renamed from: b.w$a */
    /* compiled from: MultipartBody */
    public static final class C1649a {

        /* renamed from: a */
        private final C1677f f5200a;

        /* renamed from: b */
        private C1647v f5201b;

        /* renamed from: c */
        private final List<C1650b> f5202c;

        public C1649a() {
            this(UUID.randomUUID().toString());
        }

        public C1649a(String str) {
            this.f5201b = C1648w.f5187a;
            this.f5202c = new ArrayList();
            this.f5200a = C1677f.m6985a(str);
        }

        /* renamed from: a */
        public C1649a mo6702a(C1647v vVar) {
            if (vVar == null) {
                throw new NullPointerException("type == null");
            } else if (vVar.mo6696a().equals("multipart")) {
                this.f5201b = vVar;
                return this;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("multipart != ");
                sb.append(vVar);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* renamed from: a */
        public C1649a mo6701a(C1640s sVar, C1592ab abVar) {
            return mo6703a(C1650b.m6802a(sVar, abVar));
        }

        /* renamed from: a */
        public C1649a mo6703a(C1650b bVar) {
            if (bVar != null) {
                this.f5202c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        /* renamed from: a */
        public C1648w mo6704a() {
            if (!this.f5202c.isEmpty()) {
                return new C1648w(this.f5200a, this.f5201b, this.f5202c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* renamed from: b.w$b */
    /* compiled from: MultipartBody */
    public static final class C1650b {

        /* renamed from: a */
        final C1640s f5203a;

        /* renamed from: b */
        final C1592ab f5204b;

        /* renamed from: a */
        public static C1650b m6802a(C1640s sVar, C1592ab abVar) {
            if (abVar == null) {
                throw new NullPointerException("body == null");
            } else if (sVar != null && sVar.mo6645a(HttpHeaders.CONTENT_TYPE) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (sVar == null || sVar.mo6645a(HttpHeaders.CONTENT_LENGTH) == null) {
                return new C1650b(sVar, abVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        private C1650b(C1640s sVar, C1592ab abVar) {
            this.f5203a = sVar;
            this.f5204b = abVar;
        }
    }

    C1648w(C1677f fVar, C1647v vVar, List<C1650b> list) {
        this.f5195i = fVar;
        this.f5196j = vVar;
        StringBuilder sb = new StringBuilder();
        sb.append(vVar);
        sb.append("; boundary=");
        sb.append(fVar.mo6888a());
        this.f5197k = C1647v.m6791a(sb.toString());
        this.f5198l = C1508c.m6078a(list);
    }

    /* renamed from: b */
    public C1647v mo6475b() {
        return this.f5197k;
    }

    /* renamed from: c */
    public long mo6476c() throws IOException {
        long j = this.f5199m;
        if (j != -1) {
            return j;
        }
        long a = m6794a(null, true);
        this.f5199m = a;
        return a;
    }

    /* renamed from: a */
    public void mo6474a(C1675d dVar) throws IOException {
        m6794a(dVar, false);
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [c.d] */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r13v3, types: [c.c] */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long m6794a(p102c.C1675d r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            c.c r13 = new c.c
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<b.w$b> r1 = r12.f5198l
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x00a7
            java.util.List<b.w$b> r6 = r12.f5198l
            java.lang.Object r6 = r6.get(r3)
            b.w$b r6 = (p091b.C1648w.C1650b) r6
            b.s r7 = r6.f5203a
            b.ab r6 = r6.f5204b
            byte[] r8 = f5194h
            r13.mo6831c(r8)
            c.f r8 = r12.f5195i
            r13.mo6827b(r8)
            byte[] r8 = f5193g
            r13.mo6831c(r8)
            if (r7 == 0) goto L_0x0059
            int r8 = r7.mo6643a()
            r9 = 0
        L_0x0039:
            if (r9 >= r8) goto L_0x0059
            java.lang.String r10 = r7.mo6644a(r9)
            c.d r10 = r13.mo6828b(r10)
            byte[] r11 = f5192f
            c.d r10 = r10.mo6831c(r11)
            java.lang.String r11 = r7.mo6647b(r9)
            c.d r10 = r10.mo6828b(r11)
            byte[] r11 = f5193g
            r10.mo6831c(r11)
            int r9 = r9 + 1
            goto L_0x0039
        L_0x0059:
            b.v r7 = r6.mo6475b()
            if (r7 == 0) goto L_0x0072
            java.lang.String r8 = "Content-Type: "
            c.d r8 = r13.mo6828b(r8)
            java.lang.String r7 = r7.toString()
            c.d r7 = r8.mo6828b(r7)
            byte[] r8 = f5193g
            r7.mo6831c(r8)
        L_0x0072:
            long r7 = r6.mo6476c()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008c
            java.lang.String r9 = "Content-Length: "
            c.d r9 = r13.mo6828b(r9)
            c.d r9 = r9.mo6860l(r7)
            byte[] r10 = f5193g
            r9.mo6831c(r10)
            goto L_0x0092
        L_0x008c:
            if (r14 == 0) goto L_0x0092
            r0.mo6870t()
            return r9
        L_0x0092:
            byte[] r9 = f5193g
            r13.mo6831c(r9)
            if (r14 == 0) goto L_0x009b
            long r4 = r4 + r7
            goto L_0x009e
        L_0x009b:
            r6.mo6474a(r13)
        L_0x009e:
            byte[] r6 = f5193g
            r13.mo6831c(r6)
            int r3 = r3 + 1
            goto L_0x0015
        L_0x00a7:
            byte[] r1 = f5194h
            r13.mo6831c(r1)
            c.f r1 = r12.f5195i
            r13.mo6827b(r1)
            byte[] r1 = f5194h
            r13.mo6831c(r1)
            byte[] r1 = f5193g
            r13.mo6831c(r1)
            if (r14 == 0) goto L_0x00c5
            long r13 = r0.mo6823b()
            long r4 = r4 + r13
            r0.mo6870t()
        L_0x00c5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.C1648w.m6794a(c.d, boolean):long");
    }
}
