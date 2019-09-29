package p102c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: c.j */
/* compiled from: GzipSource */
public final class C1681j implements C1695s {

    /* renamed from: a */
    private int f5301a = 0;

    /* renamed from: b */
    private final C1676e f5302b;

    /* renamed from: c */
    private final Inflater f5303c;

    /* renamed from: d */
    private final C1682k f5304d;

    /* renamed from: e */
    private final CRC32 f5305e = new CRC32();

    public C1681j(C1695s sVar) {
        if (sVar != null) {
            this.f5303c = new Inflater(true);
            this.f5302b = C1683l.m7033a(sVar);
            this.f5304d = new C1682k(this.f5302b, this.f5303c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo6185a(C1672c cVar, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f5301a == 0) {
                m7024b();
                this.f5301a = 1;
            }
            if (this.f5301a == 1) {
                long j2 = cVar.f5290b;
                long a = this.f5304d.mo6185a(cVar, j);
                if (a != -1) {
                    m7022a(cVar, j2, a);
                    return a;
                }
                this.f5301a = 2;
            }
            if (this.f5301a == 2) {
                m7025c();
                this.f5301a = 3;
                if (!this.f5302b.mo6844f()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    private void m7024b() throws IOException {
        this.f5302b.mo6818a(10);
        byte b = this.f5302b.mo6829c().mo6822b(3);
        boolean z = ((b >> 1) & 1) == 1;
        if (z) {
            m7022a(this.f5302b.mo6829c(), 0, 10);
        }
        m7023a("ID1ID2", 8075, (int) this.f5302b.mo6857j());
        this.f5302b.mo6850h(8);
        if (((b >> 2) & 1) == 1) {
            this.f5302b.mo6818a(2);
            if (z) {
                m7022a(this.f5302b.mo6829c(), 0, 2);
            }
            long l = (long) this.f5302b.mo6829c().mo6861l();
            this.f5302b.mo6818a(l);
            if (z) {
                m7022a(this.f5302b.mo6829c(), 0, l);
            }
            this.f5302b.mo6850h(l);
        }
        if (((b >> 3) & 1) == 1) {
            long a = this.f5302b.mo6806a(0);
            if (a != -1) {
                if (z) {
                    m7022a(this.f5302b.mo6829c(), 0, a + 1);
                }
                this.f5302b.mo6850h(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b >> 4) & 1) == 1) {
            long a2 = this.f5302b.mo6806a(0);
            if (a2 != -1) {
                if (z) {
                    m7022a(this.f5302b.mo6829c(), 0, a2 + 1);
                }
                this.f5302b.mo6850h(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            m7023a("FHCRC", (int) this.f5302b.mo6861l(), (int) (short) ((int) this.f5305e.getValue()));
            this.f5305e.reset();
        }
    }

    /* renamed from: c */
    private void m7025c() throws IOException {
        m7023a("CRC", this.f5302b.mo6862m(), (int) this.f5305e.getValue());
        m7023a("ISIZE", this.f5302b.mo6862m(), (int) this.f5303c.getBytesWritten());
    }

    /* renamed from: a */
    public C1696t mo6186a() {
        return this.f5302b.mo6186a();
    }

    public void close() throws IOException {
        this.f5304d.close();
    }

    /* renamed from: a */
    private void m7022a(C1672c cVar, long j, long j2) {
        C1691o oVar = cVar.f5289a;
        while (j >= ((long) (oVar.f5325c - oVar.f5324b))) {
            j -= (long) (oVar.f5325c - oVar.f5324b);
            oVar = oVar.f5328f;
        }
        while (j2 > 0) {
            int i = (int) (((long) oVar.f5324b) + j);
            int min = (int) Math.min((long) (oVar.f5325c - i), j2);
            this.f5305e.update(oVar.f5323a, i, min);
            j2 -= (long) min;
            oVar = oVar.f5328f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m7023a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
