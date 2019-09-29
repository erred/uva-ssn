package p102c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: c.t */
/* compiled from: Timeout */
public class C1696t {

    /* renamed from: c */
    public static final C1696t f5334c = new C1696t() {
        /* renamed from: a */
        public C1696t mo6911a(long j) {
            return this;
        }

        /* renamed from: a */
        public C1696t mo6912a(long j, TimeUnit timeUnit) {
            return this;
        }

        /* renamed from: g */
        public void mo6915g() throws IOException {
        }
    };

    /* renamed from: a */
    private boolean f5335a;

    /* renamed from: b */
    private long f5336b;

    /* renamed from: d */
    private long f5337d;

    /* renamed from: a */
    public C1696t mo6912a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            this.f5337d = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    /* renamed from: h_ */
    public long mo6916h_() {
        return this.f5337d;
    }

    /* renamed from: i_ */
    public boolean mo6917i_() {
        return this.f5335a;
    }

    /* renamed from: d */
    public long mo6913d() {
        if (this.f5335a) {
            return this.f5336b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: a */
    public C1696t mo6911a(long j) {
        this.f5335a = true;
        this.f5336b = j;
        return this;
    }

    /* renamed from: j_ */
    public C1696t mo6918j_() {
        this.f5337d = 0;
        return this;
    }

    /* renamed from: f */
    public C1696t mo6914f() {
        this.f5335a = false;
        return this;
    }

    /* renamed from: g */
    public void mo6915g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f5335a && this.f5336b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
