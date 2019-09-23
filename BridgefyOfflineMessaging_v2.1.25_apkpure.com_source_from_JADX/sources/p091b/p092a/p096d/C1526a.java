package p091b.p092a.p096d;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1596ac.C1597a;
import p091b.C1598ad;
import p091b.C1640s;
import p091b.C1640s.C1641a;
import p091b.C1642t;
import p091b.C1651x;
import p091b.p092a.C1483a;
import p091b.p092a.C1508c;
import p091b.p092a.p094b.C1501c;
import p091b.p092a.p094b.C1506g;
import p091b.p092a.p095c.C1514c;
import p091b.p092a.p095c.C1517e;
import p091b.p092a.p095c.C1520h;
import p091b.p092a.p095c.C1521i;
import p091b.p092a.p095c.C1523k;
import p102c.C1672c;
import p102c.C1675d;
import p102c.C1676e;
import p102c.C1680i;
import p102c.C1683l;
import p102c.C1694r;
import p102c.C1695s;
import p102c.C1696t;

/* renamed from: b.a.d.a */
/* compiled from: Http1Codec */
public final class C1526a implements C1514c {

    /* renamed from: a */
    final C1651x f4610a;

    /* renamed from: b */
    final C1506g f4611b;

    /* renamed from: c */
    final C1676e f4612c;

    /* renamed from: d */
    final C1675d f4613d;

    /* renamed from: e */
    int f4614e = 0;

    /* renamed from: f */
    private long f4615f = 262144;

    /* renamed from: b.a.d.a$a */
    /* compiled from: Http1Codec */
    private abstract class C1528a implements C1695s {

        /* renamed from: a */
        protected final C1680i f4616a;

        /* renamed from: b */
        protected boolean f4617b;

        /* renamed from: c */
        protected long f4618c;

        private C1528a() {
            this.f4616a = new C1680i(C1526a.this.f4612c.mo6186a());
            this.f4618c = 0;
        }

        /* renamed from: a */
        public C1696t mo6186a() {
            return this.f4616a;
        }

        /* renamed from: a */
        public long mo6185a(C1672c cVar, long j) throws IOException {
            try {
                long a = C1526a.this.f4612c.mo6185a(cVar, j);
                if (a > 0) {
                    this.f4618c += a;
                }
                return a;
            } catch (IOException e) {
                mo6305a(false, e);
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo6305a(boolean z, IOException iOException) throws IOException {
            if (C1526a.this.f4614e != 6) {
                if (C1526a.this.f4614e == 5) {
                    C1526a.this.mo6300a(this.f4616a);
                    C1526a.this.f4614e = 6;
                    if (C1526a.this.f4611b != null) {
                        C1526a.this.f4611b.mo6259a(!z, C1526a.this, this.f4618c, iOException);
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(C1526a.this.f4614e);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    /* renamed from: b.a.d.a$b */
    /* compiled from: Http1Codec */
    private final class C1529b implements C1694r {

        /* renamed from: b */
        private final C1680i f4621b = new C1680i(C1526a.this.f4613d.mo6306a());

        /* renamed from: c */
        private boolean f4622c;

        C1529b() {
        }

        /* renamed from: a */
        public C1696t mo6306a() {
            return this.f4621b;
        }

        /* renamed from: a_ */
        public void mo6217a_(C1672c cVar, long j) throws IOException {
            if (this.f4622c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                C1526a.this.f4613d.mo6859k(j);
                C1526a.this.f4613d.mo6828b("\r\n");
                C1526a.this.f4613d.mo6217a_(cVar, j);
                C1526a.this.f4613d.mo6828b("\r\n");
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f4622c) {
                C1526a.this.f4613d.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f4622c) {
                this.f4622c = true;
                C1526a.this.f4613d.mo6828b("0\r\n\r\n");
                C1526a.this.mo6300a(this.f4621b);
                C1526a.this.f4614e = 3;
            }
        }
    }

    /* renamed from: b.a.d.a$c */
    /* compiled from: Http1Codec */
    private class C1530c extends C1528a {

        /* renamed from: f */
        private final C1642t f4624f;

        /* renamed from: g */
        private long f4625g = -1;

        /* renamed from: h */
        private boolean f4626h = true;

        C1530c(C1642t tVar) {
            super();
            this.f4624f = tVar;
        }

        /* renamed from: a */
        public long mo6185a(C1672c cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f4617b) {
                throw new IllegalStateException("closed");
            } else if (!this.f4626h) {
                return -1;
            } else {
                if (this.f4625g == 0 || this.f4625g == -1) {
                    m6183b();
                    if (!this.f4626h) {
                        return -1;
                    }
                }
                long a = super.mo6185a(cVar, Math.min(j, this.f4625g));
                if (a != -1) {
                    this.f4625g -= a;
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo6305a(false, (IOException) protocolException);
                throw protocolException;
            }
        }

        /* renamed from: b */
        private void m6183b() throws IOException {
            if (this.f4625g != -1) {
                C1526a.this.f4612c.mo6867r();
            }
            try {
                this.f4625g = C1526a.this.f4612c.mo6864o();
                String trim = C1526a.this.f4612c.mo6867r().trim();
                if (this.f4625g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected chunk size and optional extensions but was \"");
                    sb.append(this.f4625g);
                    sb.append(trim);
                    sb.append("\"");
                    throw new ProtocolException(sb.toString());
                } else if (this.f4625g == 0) {
                    this.f4626h = false;
                    C1517e.m6119a(C1526a.this.f4610a.mo6711g(), this.f4624f, C1526a.this.mo6302d());
                    mo6305a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.f4617b) {
                if (this.f4626h && !C1508c.m6084a((C1695s) this, 100, TimeUnit.MILLISECONDS)) {
                    mo6305a(false, (IOException) null);
                }
                this.f4617b = true;
            }
        }
    }

    /* renamed from: b.a.d.a$d */
    /* compiled from: Http1Codec */
    private final class C1531d implements C1694r {

        /* renamed from: b */
        private final C1680i f4628b = new C1680i(C1526a.this.f4613d.mo6306a());

        /* renamed from: c */
        private boolean f4629c;

        /* renamed from: d */
        private long f4630d;

        C1531d(long j) {
            this.f4630d = j;
        }

        /* renamed from: a */
        public C1696t mo6306a() {
            return this.f4628b;
        }

        /* renamed from: a_ */
        public void mo6217a_(C1672c cVar, long j) throws IOException {
            if (!this.f4629c) {
                C1508c.m6081a(cVar.mo6823b(), 0, j);
                if (j <= this.f4630d) {
                    C1526a.this.f4613d.mo6217a_(cVar, j);
                    this.f4630d -= j;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.f4630d);
                sb.append(" bytes but received ");
                sb.append(j);
                throw new ProtocolException(sb.toString());
            }
            throw new IllegalStateException("closed");
        }

        public void flush() throws IOException {
            if (!this.f4629c) {
                C1526a.this.f4613d.flush();
            }
        }

        public void close() throws IOException {
            if (!this.f4629c) {
                this.f4629c = true;
                if (this.f4630d <= 0) {
                    C1526a.this.mo6300a(this.f4628b);
                    C1526a.this.f4614e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    /* renamed from: b.a.d.a$e */
    /* compiled from: Http1Codec */
    private class C1532e extends C1528a {

        /* renamed from: f */
        private long f4632f;

        C1532e(long j) throws IOException {
            super();
            this.f4632f = j;
            if (this.f4632f == 0) {
                mo6305a(true, (IOException) null);
            }
        }

        /* renamed from: a */
        public long mo6185a(C1672c cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f4617b) {
                throw new IllegalStateException("closed");
            } else if (this.f4632f == 0) {
                return -1;
            } else {
                long a = super.mo6185a(cVar, Math.min(this.f4632f, j));
                if (a != -1) {
                    this.f4632f -= a;
                    if (this.f4632f == 0) {
                        mo6305a(true, (IOException) null);
                    }
                    return a;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo6305a(false, (IOException) protocolException);
                throw protocolException;
            }
        }

        public void close() throws IOException {
            if (!this.f4617b) {
                if (this.f4632f != 0 && !C1508c.m6084a((C1695s) this, 100, TimeUnit.MILLISECONDS)) {
                    mo6305a(false, (IOException) null);
                }
                this.f4617b = true;
            }
        }
    }

    /* renamed from: b.a.d.a$f */
    /* compiled from: Http1Codec */
    private class C1533f extends C1528a {

        /* renamed from: f */
        private boolean f4634f;

        C1533f() {
            super();
        }

        /* renamed from: a */
        public long mo6185a(C1672c cVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f4617b) {
                throw new IllegalStateException("closed");
            } else if (this.f4634f) {
                return -1;
            } else {
                long a = super.mo6185a(cVar, j);
                if (a != -1) {
                    return a;
                }
                this.f4634f = true;
                mo6305a(true, (IOException) null);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.f4617b) {
                if (!this.f4634f) {
                    mo6305a(false, (IOException) null);
                }
                this.f4617b = true;
            }
        }
    }

    public C1526a(C1651x xVar, C1506g gVar, C1676e eVar, C1675d dVar) {
        this.f4610a = xVar;
        this.f4611b = gVar;
        this.f4612c = eVar;
        this.f4613d = dVar;
    }

    /* renamed from: a */
    public C1694r mo6272a(C1590aa aaVar, long j) {
        if ("chunked".equalsIgnoreCase(aaVar.mo6455a(HttpHeaders.TRANSFER_ENCODING))) {
            return mo6303e();
        }
        if (j != -1) {
            return mo6297a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: c */
    public void mo6276c() {
        C1501c c = this.f4611b.mo6261c();
        if (c != null) {
            c.mo6238b();
        }
    }

    /* renamed from: a */
    public void mo6274a(C1590aa aaVar) throws IOException {
        mo6299a(aaVar.mo6458c(), C1521i.m6147a(aaVar, this.f4611b.mo6261c().mo6231a().mo6517b().type()));
    }

    /* renamed from: a */
    public C1598ad mo6271a(C1596ac acVar) throws IOException {
        this.f4611b.f4547c.mo6627f(this.f4611b.f4546b);
        String a = acVar.mo6478a(HttpHeaders.CONTENT_TYPE);
        if (!C1517e.m6126d(acVar)) {
            return new C1520h(a, 0, C1683l.m7033a(mo6301b(0)));
        }
        if ("chunked".equalsIgnoreCase(acVar.mo6478a(HttpHeaders.TRANSFER_ENCODING))) {
            return new C1520h(a, -1, C1683l.m7033a(mo6298a(acVar.mo6477a().mo6454a())));
        }
        long a2 = C1517e.m6115a(acVar);
        if (a2 != -1) {
            return new C1520h(a, a2, C1683l.m7033a(mo6301b(a2)));
        }
        return new C1520h(a, -1, C1683l.m7033a(mo6304f()));
    }

    /* renamed from: a */
    public void mo6273a() throws IOException {
        this.f4613d.flush();
    }

    /* renamed from: b */
    public void mo6275b() throws IOException {
        this.f4613d.flush();
    }

    /* renamed from: a */
    public void mo6299a(C1640s sVar, String str) throws IOException {
        if (this.f4614e == 0) {
            this.f4613d.mo6828b(str).mo6828b("\r\n");
            int a = sVar.mo6643a();
            for (int i = 0; i < a; i++) {
                this.f4613d.mo6828b(sVar.mo6644a(i)).mo6828b(": ").mo6828b(sVar.mo6647b(i)).mo6828b("\r\n");
            }
            this.f4613d.mo6828b("\r\n");
            this.f4614e = 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f4614e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C1597a mo6270a(boolean z) throws IOException {
        if (this.f4614e == 1 || this.f4614e == 3) {
            try {
                C1523k a = C1523k.m6160a(m6162g());
                C1597a a2 = new C1597a().mo6503a(a.f4607a).mo6496a(a.f4608b).mo6504a(a.f4609c).mo6502a(mo6302d());
                if (z && a.f4608b == 100) {
                    return null;
                }
                if (a.f4608b == 100) {
                    this.f4614e = 3;
                    return a2;
                }
                this.f4614e = 4;
                return a2;
            } catch (EOFException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected end of stream on ");
                sb.append(this.f4611b);
                IOException iOException = new IOException(sb.toString());
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("state: ");
            sb2.append(this.f4614e);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* renamed from: g */
    private String m6162g() throws IOException {
        String e = this.f4612c.mo6840e(this.f4615f);
        this.f4615f -= (long) e.length();
        return e;
    }

    /* renamed from: d */
    public C1640s mo6302d() throws IOException {
        C1641a aVar = new C1641a();
        while (true) {
            String g = m6162g();
            if (g.length() == 0) {
                return aVar.mo6654a();
            }
            C1483a.f4446a.mo6179a(aVar, g);
        }
    }

    /* renamed from: e */
    public C1694r mo6303e() {
        if (this.f4614e == 1) {
            this.f4614e = 2;
            return new C1529b();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f4614e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C1694r mo6297a(long j) {
        if (this.f4614e == 1) {
            this.f4614e = 2;
            return new C1531d(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f4614e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public C1695s mo6301b(long j) throws IOException {
        if (this.f4614e == 4) {
            this.f4614e = 5;
            return new C1532e(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f4614e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public C1695s mo6298a(C1642t tVar) throws IOException {
        if (this.f4614e == 4) {
            this.f4614e = 5;
            return new C1530c(tVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.f4614e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: f */
    public C1695s mo6304f() throws IOException {
        if (this.f4614e != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.f4614e);
            throw new IllegalStateException(sb.toString());
        } else if (this.f4611b != null) {
            this.f4614e = 5;
            this.f4611b.mo6263e();
            return new C1533f();
        } else {
            throw new IllegalStateException("streamAllocation == null");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6300a(C1680i iVar) {
        C1696t a = iVar.mo6910a();
        iVar.mo6909a(C1696t.f5334c);
        a.mo6914f();
        a.mo6918j_();
    }
}
