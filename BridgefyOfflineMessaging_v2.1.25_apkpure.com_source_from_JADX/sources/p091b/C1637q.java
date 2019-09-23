package p091b;

import com.google.api.client.http.UrlEncodedParser;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import p091b.p092a.C1508c;
import p102c.C1672c;
import p102c.C1675d;

/* renamed from: b.q */
/* compiled from: FormBody */
public final class C1637q extends C1592ab {

    /* renamed from: a */
    private static final C1647v f5145a = C1647v.m6791a(UrlEncodedParser.CONTENT_TYPE);

    /* renamed from: b */
    private final List<String> f5146b;

    /* renamed from: c */
    private final List<String> f5147c;

    /* renamed from: b.q$a */
    /* compiled from: FormBody */
    public static final class C1638a {

        /* renamed from: a */
        private final List<String> f5148a;

        /* renamed from: b */
        private final List<String> f5149b;

        /* renamed from: c */
        private final Charset f5150c;

        public C1638a() {
            this(null);
        }

        public C1638a(Charset charset) {
            this.f5148a = new ArrayList();
            this.f5149b = new ArrayList();
            this.f5150c = charset;
        }

        /* renamed from: a */
        public C1638a mo6634a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.f5148a.add(C1642t.m6732a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f5150c));
                this.f5149b.add(C1642t.m6732a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f5150c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        /* renamed from: b */
        public C1638a mo6636b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.f5148a.add(C1642t.m6732a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f5150c));
                this.f5149b.add(C1642t.m6732a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f5150c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        /* renamed from: a */
        public C1637q mo6635a() {
            return new C1637q(this.f5148a, this.f5149b);
        }
    }

    C1637q(List<String> list, List<String> list2) {
        this.f5146b = C1508c.m6078a(list);
        this.f5147c = C1508c.m6078a(list2);
    }

    /* renamed from: a */
    public int mo6630a() {
        return this.f5146b.size();
    }

    /* renamed from: a */
    public String mo6631a(int i) {
        return (String) this.f5146b.get(i);
    }

    /* renamed from: b */
    public String mo6632b(int i) {
        return (String) this.f5147c.get(i);
    }

    /* renamed from: c */
    public String mo6633c(int i) {
        return C1642t.m6733a(mo6632b(i), true);
    }

    /* renamed from: b */
    public C1647v mo6475b() {
        return f5145a;
    }

    /* renamed from: c */
    public long mo6476c() {
        return m6695a(null, true);
    }

    /* renamed from: a */
    public void mo6474a(C1675d dVar) throws IOException {
        m6695a(dVar, false);
    }

    /* renamed from: a */
    private long m6695a(C1675d dVar, boolean z) {
        C1672c cVar;
        if (z) {
            cVar = new C1672c();
        } else {
            cVar = dVar.mo6829c();
        }
        int size = this.f5146b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cVar.mo6854i(38);
            }
            cVar.mo6828b((String) this.f5146b.get(i));
            cVar.mo6854i(61);
            cVar.mo6828b((String) this.f5147c.get(i));
        }
        if (!z) {
            return 0;
        }
        long b = cVar.mo6823b();
        cVar.mo6870t();
        return b;
    }
}
