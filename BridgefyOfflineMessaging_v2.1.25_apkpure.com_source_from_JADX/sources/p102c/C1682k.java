package p102c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: c.k */
/* compiled from: InflaterSource */
public final class C1682k implements C1695s {

    /* renamed from: a */
    private final C1676e f5306a;

    /* renamed from: b */
    private final Inflater f5307b;

    /* renamed from: c */
    private int f5308c;

    /* renamed from: d */
    private boolean f5309d;

    C1682k(C1676e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f5306a = eVar;
            this.f5307b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    /* renamed from: a */
    public long mo6185a(C1672c cVar, long j) throws IOException {
        C1691o e;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f5309d) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean b = mo6919b();
                try {
                    e = cVar.mo6839e(1);
                    int inflate = this.f5307b.inflate(e.f5323a, e.f5325c, (int) Math.min(j, (long) (8192 - e.f5325c)));
                    if (inflate > 0) {
                        e.f5325c += inflate;
                        long j2 = (long) inflate;
                        cVar.f5290b += j2;
                        return j2;
                    } else if (this.f5307b.finished()) {
                        break;
                    } else if (this.f5307b.needsDictionary()) {
                        break;
                    } else if (b) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            m7028c();
            if (e.f5324b == e.f5325c) {
                cVar.f5289a = e.mo6940b();
                C1692p.m7102a(e);
            }
            return -1;
        }
    }

    /* renamed from: b */
    public boolean mo6919b() throws IOException {
        if (!this.f5307b.needsInput()) {
            return false;
        }
        m7028c();
        if (this.f5307b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f5306a.mo6844f()) {
            return true;
        } else {
            C1691o oVar = this.f5306a.mo6829c().f5289a;
            this.f5308c = oVar.f5325c - oVar.f5324b;
            this.f5307b.setInput(oVar.f5323a, oVar.f5324b, this.f5308c);
            return false;
        }
    }

    /* renamed from: c */
    private void m7028c() throws IOException {
        if (this.f5308c != 0) {
            int remaining = this.f5308c - this.f5307b.getRemaining();
            this.f5308c -= remaining;
            this.f5306a.mo6850h((long) remaining);
        }
    }

    /* renamed from: a */
    public C1696t mo6186a() {
        return this.f5306a.mo6186a();
    }

    public void close() throws IOException {
        if (!this.f5309d) {
            this.f5307b.end();
            this.f5309d = true;
            this.f5306a.close();
        }
    }
}
