package com.p103a.p104a.p107c;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.a.a.c.e */
/* compiled from: CodedOutputStream */
final class C1780e implements Flushable {

    /* renamed from: a */
    private final byte[] f5556a;

    /* renamed from: b */
    private final int f5557b;

    /* renamed from: c */
    private int f5558c = 0;

    /* renamed from: d */
    private final OutputStream f5559d;

    /* renamed from: com.a.a.c.e$a */
    /* compiled from: CodedOutputStream */
    static class C1781a extends IOException {
        C1781a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    /* renamed from: b */
    public static int m7364b(float f) {
        return 4;
    }

    /* renamed from: b */
    public static int m7371b(boolean z) {
        return 1;
    }

    /* renamed from: d */
    public static int m7373d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: l */
    public static int m7381l(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: n */
    public static int m7382n(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private C1780e(OutputStream outputStream, byte[] bArr) {
        this.f5559d = outputStream;
        this.f5556a = bArr;
        this.f5557b = bArr.length;
    }

    /* renamed from: a */
    public static C1780e m7361a(OutputStream outputStream) {
        return m7362a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C1780e m7362a(OutputStream outputStream, int i) {
        return new C1780e(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public void mo7050a(int i, float f) throws IOException {
        mo7069g(i, 5);
        mo7048a(f);
    }

    /* renamed from: a */
    public void mo7052a(int i, long j) throws IOException {
        mo7069g(i, 0);
        mo7055a(j);
    }

    /* renamed from: a */
    public void mo7054a(int i, boolean z) throws IOException {
        mo7069g(i, 0);
        mo7058a(z);
    }

    /* renamed from: a */
    public void mo7053a(int i, C1776b bVar) throws IOException {
        mo7069g(i, 2);
        mo7056a(bVar);
    }

    /* renamed from: a */
    public void mo7051a(int i, int i2) throws IOException {
        mo7069g(i, 0);
        mo7061b(i2);
    }

    /* renamed from: b */
    public void mo7062b(int i, int i2) throws IOException {
        mo7069g(i, 0);
        mo7063c(i2);
    }

    /* renamed from: c */
    public void mo7064c(int i, int i2) throws IOException {
        mo7069g(i, 0);
        mo7067d(i2);
    }

    /* renamed from: a */
    public void mo7048a(float f) throws IOException {
        mo7072m(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public void mo7055a(long j) throws IOException {
        mo7065c(j);
    }

    /* renamed from: a */
    public void mo7049a(int i) throws IOException {
        if (i >= 0) {
            mo7071k(i);
        } else {
            mo7065c((long) i);
        }
    }

    /* renamed from: a */
    public void mo7058a(boolean z) throws IOException {
        mo7070i(z ? 1 : 0);
    }

    /* renamed from: a */
    public void mo7056a(C1776b bVar) throws IOException {
        mo7071k(bVar.mo7038a());
        mo7066c(bVar);
    }

    /* renamed from: b */
    public void mo7061b(int i) throws IOException {
        mo7071k(i);
    }

    /* renamed from: c */
    public void mo7063c(int i) throws IOException {
        mo7049a(i);
    }

    /* renamed from: d */
    public void mo7067d(int i) throws IOException {
        mo7071k(m7382n(i));
    }

    /* renamed from: b */
    public static int m7365b(int i, float f) {
        return m7380j(i) + m7364b(f);
    }

    /* renamed from: b */
    public static int m7366b(int i, long j) {
        return m7380j(i) + m7369b(j);
    }

    /* renamed from: b */
    public static int m7368b(int i, boolean z) {
        return m7380j(i) + m7371b(z);
    }

    /* renamed from: b */
    public static int m7367b(int i, C1776b bVar) {
        return m7380j(i) + m7370b(bVar);
    }

    /* renamed from: d */
    public static int m7372d(int i, int i2) {
        return m7380j(i) + m7376f(i2);
    }

    /* renamed from: e */
    public static int m7375e(int i, int i2) {
        return m7380j(i) + m7378g(i2);
    }

    /* renamed from: f */
    public static int m7377f(int i, int i2) {
        return m7380j(i) + m7379h(i2);
    }

    /* renamed from: b */
    public static int m7369b(long j) {
        return m7373d(j);
    }

    /* renamed from: e */
    public static int m7374e(int i) {
        if (i >= 0) {
            return m7381l(i);
        }
        return 10;
    }

    /* renamed from: b */
    public static int m7370b(C1776b bVar) {
        return m7381l(bVar.mo7038a()) + bVar.mo7038a();
    }

    /* renamed from: f */
    public static int m7376f(int i) {
        return m7381l(i);
    }

    /* renamed from: g */
    public static int m7378g(int i) {
        return m7374e(i);
    }

    /* renamed from: h */
    public static int m7379h(int i) {
        return m7381l(m7382n(i));
    }

    /* renamed from: a */
    private void m7363a() throws IOException {
        if (this.f5559d != null) {
            this.f5559d.write(this.f5556a, 0, this.f5558c);
            this.f5558c = 0;
            return;
        }
        throw new C1781a();
    }

    public void flush() throws IOException {
        if (this.f5559d != null) {
            m7363a();
        }
    }

    /* renamed from: a */
    public void mo7047a(byte b) throws IOException {
        if (this.f5558c == this.f5557b) {
            m7363a();
        }
        byte[] bArr = this.f5556a;
        int i = this.f5558c;
        this.f5558c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: i */
    public void mo7070i(int i) throws IOException {
        mo7047a((byte) i);
    }

    /* renamed from: c */
    public void mo7066c(C1776b bVar) throws IOException {
        mo7057a(bVar, 0, bVar.mo7038a());
    }

    /* renamed from: a */
    public void mo7059a(byte[] bArr) throws IOException {
        mo7060a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo7060a(byte[] bArr, int i, int i2) throws IOException {
        if (this.f5557b - this.f5558c >= i2) {
            System.arraycopy(bArr, i, this.f5556a, this.f5558c, i2);
            this.f5558c += i2;
            return;
        }
        int i3 = this.f5557b - this.f5558c;
        System.arraycopy(bArr, i, this.f5556a, this.f5558c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f5558c = this.f5557b;
        m7363a();
        if (i5 <= this.f5557b) {
            System.arraycopy(bArr, i4, this.f5556a, 0, i5);
            this.f5558c = i5;
            return;
        }
        this.f5559d.write(bArr, i4, i5);
    }

    /* renamed from: a */
    public void mo7057a(C1776b bVar, int i, int i2) throws IOException {
        if (this.f5557b - this.f5558c >= i2) {
            bVar.mo7039a(this.f5556a, i, this.f5558c, i2);
            this.f5558c += i2;
            return;
        }
        int i3 = this.f5557b - this.f5558c;
        bVar.mo7039a(this.f5556a, i, this.f5558c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f5558c = this.f5557b;
        m7363a();
        if (i5 <= this.f5557b) {
            bVar.mo7039a(this.f5556a, i4, 0, i5);
            this.f5558c = i5;
            return;
        }
        InputStream b = bVar.mo7040b();
        long j = (long) i4;
        if (j == b.skip(j)) {
            while (i5 > 0) {
                int min = Math.min(i5, this.f5557b);
                int read = b.read(this.f5556a, 0, min);
                if (read == min) {
                    this.f5559d.write(this.f5556a, 0, read);
                    i5 -= read;
                } else {
                    throw new IllegalStateException("Read failed.");
                }
            }
            return;
        }
        throw new IllegalStateException("Skip failed.");
    }

    /* renamed from: g */
    public void mo7069g(int i, int i2) throws IOException {
        mo7071k(C1775an.m7349a(i, i2));
    }

    /* renamed from: j */
    public static int m7380j(int i) {
        return m7381l(C1775an.m7349a(i, 0));
    }

    /* renamed from: k */
    public void mo7071k(int i) throws IOException {
        while ((i & -128) != 0) {
            mo7070i((i & 127) | 128);
            i >>>= 7;
        }
        mo7070i(i);
    }

    /* renamed from: c */
    public void mo7065c(long j) throws IOException {
        while ((-128 & j) != 0) {
            mo7070i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        mo7070i((int) j);
    }

    /* renamed from: m */
    public void mo7072m(int i) throws IOException {
        mo7070i(i & 255);
        mo7070i((i >> 8) & 255);
        mo7070i((i >> 16) & 255);
        mo7070i((i >> 24) & 255);
    }
}
