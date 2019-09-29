package p102c;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* renamed from: c.c */
/* compiled from: Buffer */
public final class C1672c implements C1675d, C1676e, Cloneable, ByteChannel {

    /* renamed from: c */
    private static final byte[] f5288c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a */
    C1691o f5289a;

    /* renamed from: b */
    long f5290b;

    /* renamed from: c */
    public C1672c mo6829c() {
        return this;
    }

    public void close() {
    }

    /* renamed from: e */
    public C1672c mo6874w() {
        return this;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: b */
    public long mo6823b() {
        return this.f5290b;
    }

    /* renamed from: d */
    public OutputStream mo6836d() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public void write(int i) {
                C1672c.this.mo6854i((int) (byte) i);
            }

            public void write(byte[] bArr, int i, int i2) {
                C1672c.this.mo6832c(bArr, i, i2);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(C1672c.this);
                sb.append(".outputStream()");
                return sb.toString();
            }
        };
    }

    /* renamed from: f */
    public boolean mo6844f() {
        return this.f5290b == 0;
    }

    /* renamed from: a */
    public void mo6818a(long j) throws EOFException {
        if (this.f5290b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: g */
    public InputStream mo6846g() {
        return new InputStream() {
            public void close() {
            }

            public int read() {
                if (C1672c.this.f5290b > 0) {
                    return C1672c.this.mo6852i() & UnsignedBytes.MAX_VALUE;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return C1672c.this.mo6805a(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(C1672c.this.f5290b, 2147483647L);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(C1672c.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    /* renamed from: a */
    public C1672c mo6811a(C1672c cVar, long j, long j2) {
        if (cVar != null) {
            C1698u.m7136a(this.f5290b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f5290b += j2;
            C1691o oVar = this.f5289a;
            while (j >= ((long) (oVar.f5325c - oVar.f5324b))) {
                j -= (long) (oVar.f5325c - oVar.f5324b);
                oVar = oVar.f5328f;
            }
            while (j2 > 0) {
                C1691o a = oVar.mo6936a();
                a.f5324b = (int) (((long) a.f5324b) + j);
                a.f5325c = Math.min(a.f5324b + ((int) j2), a.f5325c);
                if (cVar.f5289a == null) {
                    a.f5329g = a;
                    a.f5328f = a;
                    cVar.f5289a = a;
                } else {
                    cVar.f5289a.f5329g.mo6938a(a);
                }
                j2 -= (long) (a.f5325c - a.f5324b);
                oVar = oVar.f5328f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: h */
    public long mo6848h() {
        long j = this.f5290b;
        if (j == 0) {
            return 0;
        }
        C1691o oVar = this.f5289a.f5329g;
        if (oVar.f5325c < 8192 && oVar.f5327e) {
            j -= (long) (oVar.f5325c - oVar.f5324b);
        }
        return j;
    }

    /* renamed from: i */
    public byte mo6852i() {
        if (this.f5290b != 0) {
            C1691o oVar = this.f5289a;
            int i = oVar.f5324b;
            int i2 = oVar.f5325c;
            int i3 = i + 1;
            byte b = oVar.f5323a[i];
            this.f5290b--;
            if (i3 == i2) {
                this.f5289a = oVar.mo6940b();
                C1692p.m7102a(oVar);
            } else {
                oVar.f5324b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: b */
    public byte mo6822b(long j) {
        C1698u.m7136a(this.f5290b, j, 1);
        if (this.f5290b - j > j) {
            C1691o oVar = this.f5289a;
            while (true) {
                long j2 = (long) (oVar.f5325c - oVar.f5324b);
                if (j < j2) {
                    return oVar.f5323a[oVar.f5324b + ((int) j)];
                }
                j -= j2;
                oVar = oVar.f5328f;
            }
        } else {
            long j3 = j - this.f5290b;
            C1691o oVar2 = this.f5289a;
            do {
                oVar2 = oVar2.f5329g;
                j3 += (long) (oVar2.f5325c - oVar2.f5324b);
            } while (j3 < 0);
            return oVar2.f5323a[oVar2.f5324b + ((int) j3)];
        }
    }

    /* renamed from: j */
    public short mo6857j() {
        if (this.f5290b >= 2) {
            C1691o oVar = this.f5289a;
            int i = oVar.f5324b;
            int i2 = oVar.f5325c;
            if (i2 - i < 2) {
                return (short) (((mo6852i() & UnsignedBytes.MAX_VALUE) << 8) | (mo6852i() & UnsignedBytes.MAX_VALUE));
            }
            byte[] bArr = oVar.f5323a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i3] & UnsignedBytes.MAX_VALUE);
            this.f5290b -= 2;
            if (i4 == i2) {
                this.f5289a = oVar.mo6940b();
                C1692p.m7102a(oVar);
            } else {
                oVar.f5324b = i4;
            }
            return (short) b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 2: ");
        sb.append(this.f5290b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: k */
    public int mo6858k() {
        if (this.f5290b >= 4) {
            C1691o oVar = this.f5289a;
            int i = oVar.f5324b;
            int i2 = oVar.f5325c;
            if (i2 - i < 4) {
                return ((mo6852i() & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((mo6852i() & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((mo6852i() & UnsignedBytes.MAX_VALUE) << 8) | (mo6852i() & UnsignedBytes.MAX_VALUE);
            }
            byte[] bArr = oVar.f5323a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & UnsignedBytes.MAX_VALUE) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & UnsignedBytes.MAX_VALUE);
            this.f5290b -= 4;
            if (i6 == i2) {
                this.f5289a = oVar.mo6940b();
                C1692p.m7102a(oVar);
            } else {
                oVar.f5324b = i6;
            }
            return b3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 4: ");
        sb.append(this.f5290b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: l */
    public short mo6861l() {
        return C1698u.m7135a(mo6857j());
    }

    /* renamed from: m */
    public int mo6862m() {
        return C1698u.m7134a(mo6858k());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r5 != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r1.mo6852i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("Number too large: ");
        r3.append(r1.mo6866q());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        throw new java.lang.NumberFormatException(r3.toString());
     */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo6863n() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f5290b
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00b7
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x0010:
            c.o r10 = r0.f5289a
            byte[] r11 = r10.f5323a
            int r12 = r10.f5324b
            int r13 = r10.f5325c
        L_0x0018:
            if (r12 >= r13) goto L_0x0098
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006a
            r1 = 57
            if (r15 > r1) goto L_0x006a
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x003d
            if (r16 != 0) goto L_0x0036
            long r1 = (long) r14
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0036
            goto L_0x003d
        L_0x0036:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x0074
        L_0x003d:
            c.c r1 = new c.c
            r1.<init>()
            c.c r1 = r1.mo6860l(r3)
            c.c r1 = r1.mo6854i(r15)
            if (r5 != 0) goto L_0x004f
            r1.mo6852i()
        L_0x004f:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.mo6866q()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006a:
            r1 = 45
            if (r15 != r1) goto L_0x0079
            if (r7 != 0) goto L_0x0079
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L_0x0074:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L_0x0018
        L_0x0079:
            if (r7 == 0) goto L_0x007d
            r6 = 1
            goto L_0x0098
        L_0x007d:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0098:
            if (r12 != r13) goto L_0x00a4
            c.o r1 = r10.mo6940b()
            r0.f5289a = r1
            p102c.C1692p.m7102a(r10)
            goto L_0x00a6
        L_0x00a4:
            r10.f5324b = r12
        L_0x00a6:
            if (r6 != 0) goto L_0x00ac
            c.o r1 = r0.f5289a
            if (r1 != 0) goto L_0x0010
        L_0x00ac:
            long r1 = r0.f5290b
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.f5290b = r1
            if (r5 == 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            long r3 = -r3
        L_0x00b6:
            return r3
        L_0x00b7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p102c.C1672c.mo6863n():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        if (r8 != r9) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        r14.f5289a = r6.mo6940b();
        p102c.C1692p.m7102a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        r6.f5324b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        if (r1 != false) goto L_0x00a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077 A[SYNTHETIC] */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo6864o() {
        /*
            r14 = this;
            long r0 = r14.f5290b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00ad
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            c.o r6 = r14.f5289a
            byte[] r7 = r6.f5323a
            int r8 = r6.f5324b
            int r9 = r6.f5325c
        L_0x0013:
            if (r8 >= r9) goto L_0x0092
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003b
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
            int r11 = r11 + 10
            goto L_0x003b
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0073
            r11 = 70
            if (r10 > r11) goto L_0x0073
            int r11 = r10 + -65
            int r11 = r11 + 10
        L_0x003b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x004b
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004b:
            c.c r0 = new c.c
            r0.<init>()
            c.c r0 = r0.mo6859k(r4)
            c.c r0 = r0.mo6854i(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.mo6866q()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0073:
            if (r0 == 0) goto L_0x0077
            r1 = 1
            goto L_0x0092
        L_0x0077:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0092:
            if (r8 != r9) goto L_0x009e
            c.o r7 = r6.mo6940b()
            r14.f5289a = r7
            p102c.C1692p.m7102a(r6)
            goto L_0x00a0
        L_0x009e:
            r6.f5324b = r8
        L_0x00a0:
            if (r1 != 0) goto L_0x00a6
            c.o r6 = r14.f5289a
            if (r6 != 0) goto L_0x000b
        L_0x00a6:
            long r1 = r14.f5290b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f5290b = r1
            return r4
        L_0x00ad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p102c.C1672c.mo6864o():long");
    }

    /* renamed from: p */
    public C1677f mo6865p() {
        return new C1677f(mo6869s());
    }

    /* renamed from: c */
    public C1677f mo6833c(long j) throws EOFException {
        return new C1677f(mo6847g(j));
    }

    /* renamed from: a */
    public long mo6808a(C1694r rVar) throws IOException {
        long j = this.f5290b;
        if (j > 0) {
            rVar.mo6217a_(this, j);
        }
        return j;
    }

    /* renamed from: q */
    public String mo6866q() {
        try {
            return mo6816a(this.f5290b, C1698u.f5338a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: d */
    public String mo6837d(long j) throws EOFException {
        return mo6816a(j, C1698u.f5338a);
    }

    /* renamed from: a */
    public String mo6817a(Charset charset) {
        try {
            return mo6816a(this.f5290b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public String mo6816a(long j, Charset charset) throws EOFException {
        C1698u.m7136a(this.f5290b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
            return "";
        } else {
            C1691o oVar = this.f5289a;
            if (((long) oVar.f5324b) + j > ((long) oVar.f5325c)) {
                return new String(mo6847g(j), charset);
            }
            String str = new String(oVar.f5323a, oVar.f5324b, (int) j, charset);
            oVar.f5324b = (int) (((long) oVar.f5324b) + j);
            this.f5290b -= j;
            if (oVar.f5324b == oVar.f5325c) {
                this.f5289a = oVar.mo6940b();
                C1692p.m7102a(oVar);
            }
            return str;
        }
    }

    /* renamed from: r */
    public String mo6867r() throws EOFException {
        return mo6840e(Long.MAX_VALUE);
    }

    /* renamed from: e */
    public String mo6840e(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a = mo6807a(10, 0, j2);
            if (a != -1) {
                return mo6843f(a);
            }
            if (j2 < mo6823b() && mo6822b(j2 - 1) == 13 && mo6822b(j2) == 10) {
                return mo6843f(j2);
            }
            C1672c cVar = new C1672c();
            mo6811a(cVar, 0, Math.min(32, mo6823b()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(mo6823b(), j));
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

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo6843f(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (mo6822b(j2) == 13) {
                String d = mo6837d(j2);
                mo6850h(2);
                return d;
            }
        }
        String d2 = mo6837d(j);
        mo6850h(1);
        return d2;
    }

    /* renamed from: s */
    public byte[] mo6869s() {
        try {
            return mo6847g(this.f5290b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: g */
    public byte[] mo6847g(long j) throws EOFException {
        C1698u.m7136a(this.f5290b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            mo6819a(bArr);
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("byteCount > Integer.MAX_VALUE: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public void mo6819a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = mo6805a(bArr, i, bArr.length - i);
            if (a != -1) {
                i += a;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public int mo6805a(byte[] bArr, int i, int i2) {
        C1698u.m7136a((long) bArr.length, (long) i, (long) i2);
        C1691o oVar = this.f5289a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.f5325c - oVar.f5324b);
        System.arraycopy(oVar.f5323a, oVar.f5324b, bArr, i, min);
        oVar.f5324b += min;
        this.f5290b -= (long) min;
        if (oVar.f5324b == oVar.f5325c) {
            this.f5289a = oVar.mo6940b();
            C1692p.m7102a(oVar);
        }
        return min;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        C1691o oVar = this.f5289a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f5325c - oVar.f5324b);
        byteBuffer.put(oVar.f5323a, oVar.f5324b, min);
        oVar.f5324b += min;
        this.f5290b -= (long) min;
        if (oVar.f5324b == oVar.f5325c) {
            this.f5289a = oVar.mo6940b();
            C1692p.m7102a(oVar);
        }
        return min;
    }

    /* renamed from: t */
    public void mo6870t() {
        try {
            mo6850h(this.f5290b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: h */
    public void mo6850h(long j) throws EOFException {
        while (j > 0) {
            if (this.f5289a != null) {
                int min = (int) Math.min(j, (long) (this.f5289a.f5325c - this.f5289a.f5324b));
                long j2 = (long) min;
                this.f5290b -= j2;
                j -= j2;
                this.f5289a.f5324b += min;
                if (this.f5289a.f5324b == this.f5289a.f5325c) {
                    C1691o oVar = this.f5289a;
                    this.f5289a = oVar.mo6940b();
                    C1692p.m7102a(oVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public C1672c mo6827b(C1677f fVar) {
        if (fVar != null) {
            fVar.mo6889a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public C1672c mo6828b(String str) {
        return mo6814a(str, 0, str.length());
    }

    /* renamed from: a */
    public C1672c mo6814a(String str, int i, int i2) {
        char c;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(i2);
            sb2.append(" < ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    C1691o e = mo6839e(1);
                    byte[] bArr = e.f5323a;
                    int i3 = e.f5325c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        int i5 = i4 + 1;
                        bArr[i4 + i3] = (byte) charAt2;
                        i4 = i5;
                    }
                    int i6 = (i3 + i4) - e.f5325c;
                    e.f5325c += i6;
                    this.f5290b += (long) i6;
                    i = i4;
                } else if (charAt < 2048) {
                    mo6854i((charAt >> 6) | 192);
                    mo6854i((int) (charAt & '?') | 128);
                    i++;
                } else if (charAt < 55296 || charAt > 57343) {
                    mo6854i((charAt >> 12) | 224);
                    mo6854i(((charAt >> 6) & 63) | 128);
                    mo6854i((int) (charAt & '?') | 128);
                    i++;
                } else {
                    int i7 = i + 1;
                    if (i7 < i2) {
                        c = str.charAt(i7);
                    } else {
                        c = 0;
                    }
                    if (charAt > 56319 || c < 56320 || c > 57343) {
                        mo6854i(63);
                        i = i7;
                    } else {
                        int i8 = (((charAt & 10239) << 10) | (9215 & c)) + Ascii.MIN;
                        mo6854i((i8 >> 18) | 240);
                        mo6854i(((i8 >> 12) & 63) | 128);
                        mo6854i(((i8 >> 6) & 63) | 128);
                        mo6854i((i8 & 63) | 128);
                        i += 2;
                    }
                }
            }
            return this;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(i2);
            sb3.append(" > ");
            sb3.append(str.length());
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* renamed from: a */
    public C1672c mo6810a(int i) {
        if (i < 128) {
            mo6854i(i);
        } else if (i < 2048) {
            mo6854i((i >> 6) | 192);
            mo6854i((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                mo6854i((i >> 12) | 224);
                mo6854i(((i >> 6) & 63) | 128);
                mo6854i((i & 63) | 128);
            } else {
                mo6854i(63);
            }
        } else if (i <= 1114111) {
            mo6854i((i >> 18) | 240);
            mo6854i(((i >> 12) & 63) | 128);
            mo6854i(((i >> 6) & 63) | 128);
            mo6854i((i & 63) | 128);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected code point: ");
            sb.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb.toString());
        }
        return this;
    }

    /* renamed from: a */
    public C1672c mo6815a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(i);
            throw new IllegalAccessError(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(i2);
            sb2.append(" < ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i2 > str.length()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(i2);
            sb3.append(" > ");
            sb3.append(str.length());
            throw new IllegalArgumentException(sb3.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C1698u.f5338a)) {
            return mo6814a(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return mo6832c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: b */
    public C1672c mo6831c(byte[] bArr) {
        if (bArr != null) {
            return mo6832c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public C1672c mo6832c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C1698u.m7136a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                C1691o e = mo6839e(1);
                int min = Math.min(i3 - i, 8192 - e.f5325c);
                System.arraycopy(bArr, i, e.f5323a, e.f5325c, min);
                i += min;
                e.f5325c += min;
            }
            this.f5290b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                C1691o e = mo6839e(1);
                int min = Math.min(i, 8192 - e.f5325c);
                byteBuffer.get(e.f5323a, e.f5325c, min);
                i -= min;
                e.f5325c += min;
            }
            this.f5290b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo6809a(C1695s sVar) throws IOException {
        if (sVar != null) {
            long j = 0;
            while (true) {
                long a = sVar.mo6185a(this, 8192);
                if (a == -1) {
                    return j;
                }
                j += a;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: b */
    public C1672c mo6854i(int i) {
        C1691o e = mo6839e(1);
        byte[] bArr = e.f5323a;
        int i2 = e.f5325c;
        e.f5325c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f5290b++;
        return this;
    }

    /* renamed from: c */
    public C1672c mo6849h(int i) {
        C1691o e = mo6839e(2);
        byte[] bArr = e.f5323a;
        int i2 = e.f5325c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f5325c = i4;
        this.f5290b += 2;
        return this;
    }

    /* renamed from: d */
    public C1672c mo6845g(int i) {
        C1691o e = mo6839e(4);
        byte[] bArr = e.f5323a;
        int i2 = e.f5325c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i & 255);
        e.f5325c = i6;
        this.f5290b += 4;
        return this;
    }

    /* renamed from: i */
    public C1672c mo6860l(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return mo6854i(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return mo6828b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        C1691o e = mo6839e(i2);
        byte[] bArr = e.f5323a;
        int i3 = e.f5325c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f5288c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        e.f5325c += i2;
        this.f5290b += (long) i2;
        return this;
    }

    /* renamed from: j */
    public C1672c mo6859k(long j) {
        if (j == 0) {
            return mo6854i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C1691o e = mo6839e(numberOfTrailingZeros);
        byte[] bArr = e.f5323a;
        int i = e.f5325c;
        for (int i2 = (e.f5325c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f5288c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f5325c += numberOfTrailingZeros;
        this.f5290b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C1691o mo6839e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.f5289a == null) {
            this.f5289a = C1692p.m7101a();
            C1691o oVar = this.f5289a;
            C1691o oVar2 = this.f5289a;
            C1691o oVar3 = this.f5289a;
            oVar2.f5329g = oVar3;
            oVar.f5328f = oVar3;
            return oVar3;
        } else {
            C1691o oVar4 = this.f5289a.f5329g;
            if (oVar4.f5325c + i > 8192 || !oVar4.f5327e) {
                oVar4 = oVar4.mo6938a(C1692p.m7101a());
            }
            return oVar4;
        }
    }

    /* renamed from: a_ */
    public void mo6217a_(C1672c cVar, long j) {
        int i;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            C1698u.m7136a(cVar.f5290b, 0, j);
            while (j > 0) {
                if (j < ((long) (cVar.f5289a.f5325c - cVar.f5289a.f5324b))) {
                    C1691o oVar = this.f5289a != null ? this.f5289a.f5329g : null;
                    if (oVar != null && oVar.f5327e) {
                        long j2 = ((long) oVar.f5325c) + j;
                        if (oVar.f5326d) {
                            i = 0;
                        } else {
                            i = oVar.f5324b;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            cVar.f5289a.mo6939a(oVar, (int) j);
                            cVar.f5290b -= j;
                            this.f5290b += j;
                            return;
                        }
                    }
                    cVar.f5289a = cVar.f5289a.mo6937a((int) j);
                }
                C1691o oVar2 = cVar.f5289a;
                long j3 = (long) (oVar2.f5325c - oVar2.f5324b);
                cVar.f5289a = oVar2.mo6940b();
                if (this.f5289a == null) {
                    this.f5289a = oVar2;
                    C1691o oVar3 = this.f5289a;
                    C1691o oVar4 = this.f5289a;
                    C1691o oVar5 = this.f5289a;
                    oVar4.f5329g = oVar5;
                    oVar3.f5328f = oVar5;
                } else {
                    this.f5289a.f5329g.mo6938a(oVar2).mo6941c();
                }
                cVar.f5290b -= j3;
                this.f5290b += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    /* renamed from: a */
    public long mo6185a(C1672c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f5290b == 0) {
            return -1;
        } else {
            if (j > this.f5290b) {
                j = this.f5290b;
            }
            cVar.mo6217a_(this, j);
            return j;
        }
    }

    /* renamed from: a */
    public long mo6806a(byte b) {
        return mo6807a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo6807a(byte b, long j, long j2) {
        long j3;
        long j4 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f5290b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        if (j2 > this.f5290b) {
            j2 = this.f5290b;
        }
        if (j == j2) {
            return -1;
        }
        C1691o oVar = this.f5289a;
        if (oVar == null) {
            return -1;
        }
        if (this.f5290b - j >= j) {
            while (true) {
                long j5 = ((long) (oVar.f5325c - oVar.f5324b)) + j3;
                if (j5 >= j) {
                    break;
                }
                oVar = oVar.f5328f;
                j4 = j5;
            }
        } else {
            j3 = this.f5290b;
            while (j3 > j) {
                oVar = oVar.f5329g;
                j3 -= (long) (oVar.f5325c - oVar.f5324b);
            }
        }
        while (j3 < j2) {
            byte[] bArr = oVar.f5323a;
            int min = (int) Math.min((long) oVar.f5325c, (((long) oVar.f5324b) + j2) - j3);
            for (int i = (int) ((((long) oVar.f5324b) + j) - j3); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - oVar.f5324b)) + j3;
                }
            }
            j = ((long) (oVar.f5325c - oVar.f5324b)) + j3;
            oVar = oVar.f5328f;
            j3 = j;
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo6820a(long j, C1677f fVar) {
        return mo6821a(j, fVar, 0, fVar.mo6902h());
    }

    /* renamed from: a */
    public boolean mo6821a(long j, C1677f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f5290b - j < ((long) i2) || fVar.mo6902h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (mo6822b(((long) i3) + j) != fVar.mo6886a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public C1696t mo6306a() {
        return C1696t.f5334c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1672c)) {
            return false;
        }
        C1672c cVar = (C1672c) obj;
        if (this.f5290b != cVar.f5290b) {
            return false;
        }
        long j = 0;
        if (this.f5290b == 0) {
            return true;
        }
        C1691o oVar = this.f5289a;
        C1691o oVar2 = cVar.f5289a;
        int i = oVar.f5324b;
        int i2 = oVar2.f5324b;
        while (j < this.f5290b) {
            long min = (long) Math.min(oVar.f5325c - i, oVar2.f5325c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (oVar.f5323a[i4] != oVar2.f5323a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == oVar.f5325c) {
                oVar = oVar.f5328f;
                i = oVar.f5324b;
            } else {
                i = i4;
            }
            if (i3 == oVar2.f5325c) {
                oVar2 = oVar2.f5328f;
                i2 = oVar2.f5324b;
            } else {
                i2 = i3;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        C1691o oVar = this.f5289a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            for (int i2 = oVar.f5324b; i2 < oVar.f5325c; i2++) {
                i = (i * 31) + oVar.f5323a[i2];
            }
            oVar = oVar.f5328f;
        } while (oVar != this.f5289a);
        return i;
    }

    public String toString() {
        return mo6873v().toString();
    }

    /* renamed from: u */
    public C1672c clone() {
        C1672c cVar = new C1672c();
        if (this.f5290b == 0) {
            return cVar;
        }
        cVar.f5289a = this.f5289a.mo6936a();
        C1691o oVar = cVar.f5289a;
        C1691o oVar2 = cVar.f5289a;
        C1691o oVar3 = cVar.f5289a;
        oVar2.f5329g = oVar3;
        oVar.f5328f = oVar3;
        C1691o oVar4 = this.f5289a;
        while (true) {
            oVar4 = oVar4.f5328f;
            if (oVar4 != this.f5289a) {
                cVar.f5289a.f5329g.mo6938a(oVar4.mo6936a());
            } else {
                cVar.f5290b = this.f5290b;
                return cVar;
            }
        }
    }

    /* renamed from: v */
    public C1677f mo6873v() {
        if (this.f5290b <= 2147483647L) {
            return mo6842f((int) this.f5290b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.f5290b);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: f */
    public C1677f mo6842f(int i) {
        if (i == 0) {
            return C1677f.f5294b;
        }
        return new C1693q(this, i);
    }
}
