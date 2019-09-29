package p136d;

import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import p091b.C1590aa;
import p091b.C1590aa.C1591a;
import p091b.C1592ab;
import p091b.C1637q.C1638a;
import p091b.C1640s;
import p091b.C1642t;
import p091b.C1642t.C1643a;
import p091b.C1647v;
import p091b.C1648w;
import p091b.C1648w.C1649a;
import p091b.C1648w.C1650b;
import p102c.C1672c;
import p102c.C1675d;

/* renamed from: d.k */
/* compiled from: RequestBuilder */
final class C3443k {

    /* renamed from: a */
    private static final char[] f8876a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private final String f8877b;

    /* renamed from: c */
    private final C1642t f8878c;

    /* renamed from: d */
    private String f8879d;

    /* renamed from: e */
    private C1643a f8880e;

    /* renamed from: f */
    private final C1591a f8881f = new C1591a();

    /* renamed from: g */
    private C1647v f8882g;

    /* renamed from: h */
    private final boolean f8883h;

    /* renamed from: i */
    private C1649a f8884i;

    /* renamed from: j */
    private C1638a f8885j;

    /* renamed from: k */
    private C1592ab f8886k;

    /* renamed from: d.k$a */
    /* compiled from: RequestBuilder */
    private static class C3444a extends C1592ab {

        /* renamed from: a */
        private final C1592ab f8887a;

        /* renamed from: b */
        private final C1647v f8888b;

        C3444a(C1592ab abVar, C1647v vVar) {
            this.f8887a = abVar;
            this.f8888b = vVar;
        }

        /* renamed from: b */
        public C1647v mo6475b() {
            return this.f8888b;
        }

        /* renamed from: c */
        public long mo6476c() throws IOException {
            return this.f8887a.mo6476c();
        }

        /* renamed from: a */
        public void mo6474a(C1675d dVar) throws IOException {
            this.f8887a.mo6474a(dVar);
        }
    }

    C3443k(String str, C1642t tVar, String str2, C1640s sVar, C1647v vVar, boolean z, boolean z2, boolean z3) {
        this.f8877b = str;
        this.f8878c = tVar;
        this.f8879d = str2;
        this.f8882g = vVar;
        this.f8883h = z;
        if (sVar != null) {
            this.f8881f.mo6466a(sVar);
        }
        if (z2) {
            this.f8885j = new C1638a();
        } else if (z3) {
            this.f8884i = new C1649a();
            this.f8884i.mo6702a(C1648w.f5191e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28264a(Object obj) {
        if (obj != null) {
            this.f8879d = obj.toString();
            return;
        }
        throw new NullPointerException("@Url parameter is null.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28265a(String str, String str2) {
        if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            C1647v a = C1647v.m6791a(str2);
            if (a != null) {
                this.f8882g = a;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed content type: ");
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        }
        this.f8881f.mo6473b(str, str2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28266a(String str, String str2, boolean z) {
        if (this.f8879d != null) {
            String str3 = this.f8879d;
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(str);
            sb.append("}");
            this.f8879d = str3.replace(sb.toString(), m9967a(str2, z));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private static String m9967a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                C1672c cVar = new C1672c();
                cVar.mo6814a(str, 0, i);
                m9968a(cVar, str, i, length, z);
                return cVar.mo6866q();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    /* renamed from: a */
    private static void m9968a(C1672c cVar, String str, int i, int i2, boolean z) {
        C1672c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new C1672c();
                    }
                    cVar2.mo6810a(codePointAt);
                    while (!cVar2.mo6844f()) {
                        byte i3 = cVar2.mo6852i() & UnsignedBytes.MAX_VALUE;
                        cVar.mo6854i(37);
                        cVar.mo6854i((int) f8876a[(i3 >> 4) & 15]);
                        cVar.mo6854i((int) f8876a[i3 & Ascii.f6734SI]);
                    }
                } else {
                    cVar.mo6810a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28267b(String str, String str2, boolean z) {
        if (this.f8879d != null) {
            this.f8880e = this.f8878c.mo6665d(this.f8879d);
            if (this.f8880e != null) {
                this.f8879d = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.f8878c);
                sb.append(", Relative: ");
                sb.append(this.f8879d);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (z) {
            this.f8880e.mo6689b(str, str2);
        } else {
            this.f8880e.mo6686a(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo28268c(String str, String str2, boolean z) {
        if (z) {
            this.f8885j.mo6636b(str, str2);
        } else {
            this.f8885j.mo6634a(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28262a(C1640s sVar, C1592ab abVar) {
        this.f8884i.mo6701a(sVar, abVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28263a(C1650b bVar) {
        this.f8884i.mo6703a(bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28261a(C1592ab abVar) {
        this.f8886k = abVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1590aa mo28260a() {
        C1642t tVar;
        C1643a aVar = this.f8880e;
        if (aVar != null) {
            tVar = aVar.mo6691c();
        } else {
            tVar = this.f8878c.mo6663c(this.f8879d);
            if (tVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.f8878c);
                sb.append(", Relative: ");
                sb.append(this.f8879d);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        C1592ab abVar = this.f8886k;
        if (abVar == null) {
            if (this.f8885j != null) {
                abVar = this.f8885j.mo6635a();
            } else if (this.f8884i != null) {
                abVar = this.f8884i.mo6704a();
            } else if (this.f8883h) {
                abVar = C1592ab.m6496a((C1647v) null, new byte[0]);
            }
        }
        C1647v vVar = this.f8882g;
        if (vVar != null) {
            if (abVar != null) {
                abVar = new C3444a(abVar, vVar);
            } else {
                this.f8881f.mo6473b(HttpHeaders.CONTENT_TYPE, vVar.toString());
            }
        }
        return this.f8881f.mo6467a(tVar).mo6469a(this.f8877b, abVar).mo6471a();
    }
}
