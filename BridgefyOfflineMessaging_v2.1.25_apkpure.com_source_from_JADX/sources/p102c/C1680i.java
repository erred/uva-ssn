package p102c;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: c.i */
/* compiled from: ForwardingTimeout */
public class C1680i extends C1696t {

    /* renamed from: a */
    private C1696t f5300a;

    public C1680i(C1696t tVar) {
        if (tVar != null) {
            this.f5300a = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final C1696t mo6910a() {
        return this.f5300a;
    }

    /* renamed from: a */
    public final C1680i mo6909a(C1696t tVar) {
        if (tVar != null) {
            this.f5300a = tVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public C1696t mo6912a(long j, TimeUnit timeUnit) {
        return this.f5300a.mo6912a(j, timeUnit);
    }

    /* renamed from: h_ */
    public long mo6916h_() {
        return this.f5300a.mo6916h_();
    }

    /* renamed from: i_ */
    public boolean mo6917i_() {
        return this.f5300a.mo6917i_();
    }

    /* renamed from: d */
    public long mo6913d() {
        return this.f5300a.mo6913d();
    }

    /* renamed from: a */
    public C1696t mo6911a(long j) {
        return this.f5300a.mo6911a(j);
    }

    /* renamed from: j_ */
    public C1696t mo6918j_() {
        return this.f5300a.mo6918j_();
    }

    /* renamed from: f */
    public C1696t mo6914f() {
        return this.f5300a.mo6914f();
    }

    /* renamed from: g */
    public void mo6915g() throws IOException {
        this.f5300a.mo6915g();
    }
}
