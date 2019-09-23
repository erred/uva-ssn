package p102c;

import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: c.m */
/* compiled from: RealBufferedSink */
final class C1688m implements C1675d {

    /* renamed from: a */
    public final C1672c f5316a = new C1672c();

    /* renamed from: b */
    public final C1694r f5317b;

    /* renamed from: c */
    boolean f5318c;

    C1688m(C1694r rVar) {
        if (rVar != null) {
            this.f5317b = rVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: c */
    public C1672c mo6829c() {
        return this.f5316a;
    }

    /* renamed from: a_ */
    public void mo6217a_(C1672c cVar, long j) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6217a_(cVar, j);
            mo6874w();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public C1675d mo6827b(C1677f fVar) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6827b(fVar);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public C1675d mo6828b(String str) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6828b(str);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public C1675d mo6831c(byte[] bArr) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6831c(bArr);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public C1675d mo6832c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6832c(bArr, i, i2);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f5318c) {
            int write = this.f5316a.write(byteBuffer);
            mo6874w();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo6809a(C1695s sVar) throws IOException {
        if (sVar != null) {
            long j = 0;
            while (true) {
                long a = sVar.mo6185a(this.f5316a, 8192);
                if (a == -1) {
                    return j;
                }
                j += a;
                mo6874w();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: i */
    public C1675d mo6854i(int i) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6854i(i);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: h */
    public C1675d mo6849h(int i) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6849h(i);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: g */
    public C1675d mo6845g(int i) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6845g(i);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: l */
    public C1675d mo6860l(long j) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6860l(j);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: k */
    public C1675d mo6859k(long j) throws IOException {
        if (!this.f5318c) {
            this.f5316a.mo6859k(j);
            return mo6874w();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: w */
    public C1675d mo6874w() throws IOException {
        if (!this.f5318c) {
            long h = this.f5316a.mo6848h();
            if (h > 0) {
                this.f5317b.mo6217a_(this.f5316a, h);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.f5318c) {
            if (this.f5316a.f5290b > 0) {
                this.f5317b.mo6217a_(this.f5316a, this.f5316a.f5290b);
            }
            this.f5317b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f5318c;
    }

    public void close() throws IOException {
        if (!this.f5318c) {
            Throwable th = null;
            try {
                if (this.f5316a.f5290b > 0) {
                    this.f5317b.mo6217a_(this.f5316a, this.f5316a.f5290b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f5317b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f5318c = true;
            if (th != null) {
                C1698u.m7137a(th);
            }
        }
    }

    /* renamed from: a */
    public C1696t mo6306a() {
        return this.f5317b.mo6306a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f5317b);
        sb.append(")");
        return sb.toString();
    }
}
