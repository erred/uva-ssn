package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.squareup.picasso.n */
/* compiled from: MarkableInputStream */
final class C3059n extends InputStream {

    /* renamed from: a */
    private final InputStream f7988a;

    /* renamed from: b */
    private long f7989b;

    /* renamed from: c */
    private long f7990c;

    /* renamed from: d */
    private long f7991d;

    /* renamed from: e */
    private long f7992e;

    /* renamed from: f */
    private boolean f7993f;

    /* renamed from: g */
    private int f7994g;

    C3059n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    C3059n(InputStream inputStream, int i) {
        this(inputStream, i, 1024);
    }

    private C3059n(InputStream inputStream, int i, int i2) {
        this.f7992e = -1;
        this.f7993f = true;
        this.f7994g = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, i);
        }
        this.f7988a = inputStream;
        this.f7994g = i2;
    }

    public void mark(int i) {
        this.f7992e = mo27516a(i);
    }

    /* renamed from: a */
    public long mo27516a(int i) {
        long j = this.f7989b + ((long) i);
        if (this.f7991d < j) {
            m9037b(j);
        }
        return this.f7989b;
    }

    /* renamed from: a */
    public void mo27518a(boolean z) {
        this.f7993f = z;
    }

    /* renamed from: b */
    private void m9037b(long j) {
        try {
            if (this.f7990c >= this.f7989b || this.f7989b > this.f7991d) {
                this.f7990c = this.f7989b;
                this.f7988a.mark((int) (j - this.f7989b));
            } else {
                this.f7988a.reset();
                this.f7988a.mark((int) (j - this.f7990c));
                m9036a(this.f7990c, this.f7989b);
            }
            this.f7991d = j;
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to mark: ");
            sb.append(e);
            throw new IllegalStateException(sb.toString());
        }
    }

    public void reset() throws IOException {
        mo27517a(this.f7992e);
    }

    /* renamed from: a */
    public void mo27517a(long j) throws IOException {
        if (this.f7989b > this.f7991d || j < this.f7990c) {
            throw new IOException("Cannot reset");
        }
        this.f7988a.reset();
        m9036a(this.f7990c, j);
        this.f7989b = j;
    }

    /* renamed from: a */
    private void m9036a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f7988a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public int read() throws IOException {
        if (!this.f7993f && this.f7989b + 1 > this.f7991d) {
            m9037b(this.f7991d + ((long) this.f7994g));
        }
        int read = this.f7988a.read();
        if (read != -1) {
            this.f7989b++;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        if (!this.f7993f && this.f7989b + ((long) bArr.length) > this.f7991d) {
            m9037b(this.f7989b + ((long) bArr.length) + ((long) this.f7994g));
        }
        int read = this.f7988a.read(bArr);
        if (read != -1) {
            this.f7989b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f7993f) {
            long j = (long) i2;
            if (this.f7989b + j > this.f7991d) {
                m9037b(this.f7989b + j + ((long) this.f7994g));
            }
        }
        int read = this.f7988a.read(bArr, i, i2);
        if (read != -1) {
            this.f7989b += (long) read;
        }
        return read;
    }

    public long skip(long j) throws IOException {
        if (!this.f7993f && this.f7989b + j > this.f7991d) {
            m9037b(this.f7989b + j + ((long) this.f7994g));
        }
        long skip = this.f7988a.skip(j);
        this.f7989b += skip;
        return skip;
    }

    public int available() throws IOException {
        return this.f7988a.available();
    }

    public void close() throws IOException {
        this.f7988a.close();
    }

    public boolean markSupported() {
        return this.f7988a.markSupported();
    }
}
