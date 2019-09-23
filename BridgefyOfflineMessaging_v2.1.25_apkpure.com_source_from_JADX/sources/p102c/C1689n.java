package p102c;

import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: c.n */
/* compiled from: RealBufferedSource */
final class C1689n implements C1676e {

    /* renamed from: a */
    public final C1672c f5319a = new C1672c();

    /* renamed from: b */
    public final C1695s f5320b;

    /* renamed from: c */
    boolean f5321c;

    C1689n(C1695s sVar) {
        if (sVar != null) {
            this.f5320b = sVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: c */
    public C1672c mo6829c() {
        return this.f5319a;
    }

    /* renamed from: a */
    public long mo6185a(C1672c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f5321c) {
            throw new IllegalStateException("closed");
        } else if (this.f5319a.f5290b == 0 && this.f5320b.mo6185a(this.f5319a, 8192) == -1) {
            return -1;
        } else {
            return this.f5319a.mo6185a(cVar, Math.min(j, this.f5319a.f5290b));
        }
    }

    /* renamed from: f */
    public boolean mo6844f() throws IOException {
        if (!this.f5321c) {
            return this.f5319a.mo6844f() && this.f5320b.mo6185a(this.f5319a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public void mo6818a(long j) throws IOException {
        if (!mo6927b(j)) {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public boolean mo6927b(long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f5321c) {
            while (this.f5319a.f5290b < j) {
                if (this.f5320b.mo6185a(this.f5319a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: i */
    public byte mo6852i() throws IOException {
        mo6818a(1);
        return this.f5319a.mo6852i();
    }

    /* renamed from: c */
    public C1677f mo6833c(long j) throws IOException {
        mo6818a(j);
        return this.f5319a.mo6833c(j);
    }

    /* renamed from: s */
    public byte[] mo6869s() throws IOException {
        this.f5319a.mo6809a(this.f5320b);
        return this.f5319a.mo6869s();
    }

    /* renamed from: g */
    public byte[] mo6847g(long j) throws IOException {
        mo6818a(j);
        return this.f5319a.mo6847g(j);
    }

    /* renamed from: a */
    public void mo6819a(byte[] bArr) throws IOException {
        try {
            mo6818a((long) bArr.length);
            this.f5319a.mo6819a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f5319a.f5290b > 0) {
                int a = this.f5319a.mo6805a(bArr, i, (int) this.f5319a.f5290b);
                if (a != -1) {
                    i += a;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f5319a.f5290b == 0 && this.f5320b.mo6185a(this.f5319a, 8192) == -1) {
            return -1;
        }
        return this.f5319a.read(byteBuffer);
    }

    /* renamed from: a */
    public long mo6808a(C1694r rVar) throws IOException {
        if (rVar != null) {
            long j = 0;
            while (this.f5320b.mo6185a(this.f5319a, 8192) != -1) {
                long h = this.f5319a.mo6848h();
                if (h > 0) {
                    j += h;
                    rVar.mo6217a_(this.f5319a, h);
                }
            }
            if (this.f5319a.mo6823b() <= 0) {
                return j;
            }
            long b = j + this.f5319a.mo6823b();
            rVar.mo6217a_(this.f5319a, this.f5319a.mo6823b());
            return b;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public String mo6817a(Charset charset) throws IOException {
        if (charset != null) {
            this.f5319a.mo6809a(this.f5320b);
            return this.f5319a.mo6817a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: r */
    public String mo6867r() throws IOException {
        return mo6840e(Long.MAX_VALUE);
    }

    /* renamed from: e */
    public String mo6840e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a = mo6925a(10, 0, j2);
            if (a != -1) {
                return this.f5319a.mo6843f(a);
            }
            if (j2 < Long.MAX_VALUE && mo6927b(j2) && this.f5319a.mo6822b(j2 - 1) == 13 && mo6927b(1 + j2) && this.f5319a.mo6822b(j2) == 10) {
                return this.f5319a.mo6843f(j2);
            }
            C1672c cVar = new C1672c();
            this.f5319a.mo6811a(cVar, 0, Math.min(32, this.f5319a.mo6823b()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(this.f5319a.mo6823b(), j));
            sb.append(" content=");
            sb.append(cVar.mo6865p().mo6900f());
            sb.append(8230);
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* renamed from: j */
    public short mo6857j() throws IOException {
        mo6818a(2);
        return this.f5319a.mo6857j();
    }

    /* renamed from: l */
    public short mo6861l() throws IOException {
        mo6818a(2);
        return this.f5319a.mo6861l();
    }

    /* renamed from: k */
    public int mo6858k() throws IOException {
        mo6818a(4);
        return this.f5319a.mo6858k();
    }

    /* renamed from: m */
    public int mo6862m() throws IOException {
        mo6818a(4);
        return this.f5319a.mo6862m();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo6863n() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.mo6818a(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.mo6927b(r3)
            if (r3 == 0) goto L_0x0040
            c.c r3 = r6.f5319a
            long r4 = (long) r1
            byte r3 = r3.mo6822b(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            c.c r0 = r6.f5319a
            long r0 = r0.mo6863n()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p102c.C1689n.mo6863n():long");
    }

    /* renamed from: o */
    public long mo6864o() throws IOException {
        mo6818a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo6927b((long) i2)) {
                break;
            }
            byte b = this.f5319a.mo6822b((long) i);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
            }
        }
        return this.f5319a.mo6864o();
    }

    /* renamed from: h */
    public void mo6850h(long j) throws IOException {
        if (!this.f5321c) {
            while (j > 0) {
                if (this.f5319a.f5290b == 0 && this.f5320b.mo6185a(this.f5319a, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f5319a.mo6823b());
                this.f5319a.mo6850h(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo6806a(byte b) throws IOException {
        return mo6925a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo6925a(byte b, long j, long j2) throws IOException {
        if (this.f5321c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f5319a.mo6807a(b, j, j2);
                if (a != -1) {
                    return a;
                }
                long j3 = this.f5319a.f5290b;
                if (j3 >= j2 || this.f5320b.mo6185a(this.f5319a, 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, j3);
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean mo6820a(long j, C1677f fVar) throws IOException {
        return mo6926a(j, fVar, 0, fVar.mo6902h());
    }

    /* renamed from: a */
    public boolean mo6926a(long j, C1677f fVar, int i, int i2) throws IOException {
        if (this.f5321c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || fVar.mo6902h() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!mo6927b(1 + j2) || this.f5319a.mo6822b(j2) != fVar.mo6886a(i + i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: g */
    public InputStream mo6846g() {
        return new InputStream() {
            public int read() throws IOException {
                if (C1689n.this.f5321c) {
                    throw new IOException("closed");
                } else if (C1689n.this.f5319a.f5290b == 0 && C1689n.this.f5320b.mo6185a(C1689n.this.f5319a, 8192) == -1) {
                    return -1;
                } else {
                    return C1689n.this.f5319a.mo6852i() & UnsignedBytes.MAX_VALUE;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!C1689n.this.f5321c) {
                    C1698u.m7136a((long) bArr.length, (long) i, (long) i2);
                    if (C1689n.this.f5319a.f5290b == 0 && C1689n.this.f5320b.mo6185a(C1689n.this.f5319a, 8192) == -1) {
                        return -1;
                    }
                    return C1689n.this.f5319a.mo6805a(bArr, i, i2);
                }
                throw new IOException("closed");
            }

            public int available() throws IOException {
                if (!C1689n.this.f5321c) {
                    return (int) Math.min(C1689n.this.f5319a.f5290b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                C1689n.this.close();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(C1689n.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    public boolean isOpen() {
        return !this.f5321c;
    }

    public void close() throws IOException {
        if (!this.f5321c) {
            this.f5321c = true;
            this.f5320b.close();
            this.f5319a.mo6870t();
        }
    }

    /* renamed from: a */
    public C1696t mo6186a() {
        return this.f5320b.mo6186a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f5320b);
        sb.append(")");
        return sb.toString();
    }
}
