package org.msgpack.p160b.p161a;

import java.io.IOException;
import java.math.BigInteger;
import org.msgpack.core.MessagePacker;
import org.msgpack.p160b.C3749f;
import org.msgpack.p160b.C3750g;
import org.msgpack.p160b.C3751h;
import org.msgpack.p160b.C3752i;
import org.msgpack.p160b.C3753j;
import org.msgpack.p160b.C3754k;
import org.msgpack.p160b.C3755l;
import org.msgpack.p160b.C3759p;
import org.msgpack.p160b.C3761r;
import org.msgpack.p160b.C3767x;
import org.msgpack.p160b.C3769z;

/* renamed from: org.msgpack.b.a.i */
/* compiled from: ImmutableLongValueImpl */
public class C3724i extends C3716b implements C3754k {

    /* renamed from: a */
    private final long f9853a;

    /* renamed from: D */
    public C3754k mo31948r() {
        return this;
    }

    /* renamed from: F */
    public C3754k mo31959f() {
        return this;
    }

    /* renamed from: a */
    public boolean mo31967a() {
        return true;
    }

    /* renamed from: A */
    public /* bridge */ /* synthetic */ C3759p mo31925A() {
        return super.mo31951u();
    }

    /* renamed from: B */
    public /* bridge */ /* synthetic */ C3750g mo31926B() {
        return super.mo31950t();
    }

    /* renamed from: C */
    public /* bridge */ /* synthetic */ C3753j mo31927C() {
        return super.mo31949s();
    }

    /* renamed from: E */
    public /* bridge */ /* synthetic */ C3751h mo31929E() {
        return super.mo31947q();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ C3752i mo31932c() {
        return super.mo31954x();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ C3755l mo31933d() {
        return super.mo31953w();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ boolean mo31934g() {
        return super.mo31934g();
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ boolean mo31935h() {
        return super.mo31935h();
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ boolean mo31936i() {
        return super.mo31936i();
    }

    /* renamed from: j */
    public /* bridge */ /* synthetic */ boolean mo31937j() {
        return super.mo31937j();
    }

    /* renamed from: k */
    public /* bridge */ /* synthetic */ boolean mo31938k() {
        return super.mo31938k();
    }

    /* renamed from: l */
    public /* bridge */ /* synthetic */ boolean mo31939l() {
        return super.mo31939l();
    }

    /* renamed from: m */
    public /* bridge */ /* synthetic */ boolean mo31940m() {
        return super.mo31940m();
    }

    /* renamed from: n */
    public /* bridge */ /* synthetic */ boolean mo31941n() {
        return super.mo31941n();
    }

    /* renamed from: o */
    public /* bridge */ /* synthetic */ boolean mo31942o() {
        return super.mo31942o();
    }

    /* renamed from: p */
    public /* bridge */ /* synthetic */ boolean mo31943p() {
        return super.mo31943p();
    }

    /* renamed from: z */
    public /* bridge */ /* synthetic */ C3749f mo31946z() {
        return super.mo31952v();
    }

    public C3724i(long j) {
        this.f9853a = j;
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return C3769z.INTEGER;
    }

    /* renamed from: b */
    public long mo31968b() {
        return this.f9853a;
    }

    /* renamed from: l_ */
    public BigInteger mo31970l_() {
        return BigInteger.valueOf(this.f9853a);
    }

    /* renamed from: m_ */
    public double mo31971m_() {
        return (double) this.f9853a;
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        messagePacker.packLong(this.f9853a);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3767x)) {
            return false;
        }
        C3767x xVar = (C3767x) obj;
        if (!xVar.mo31936i()) {
            return false;
        }
        C3761r r = xVar.mo31948r();
        if (!r.mo31967a()) {
            return false;
        }
        if (this.f9853a != r.mo31968b()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        if (-2147483648L > this.f9853a || this.f9853a > 2147483647L) {
            return (int) (this.f9853a ^ (this.f9853a >>> 32));
        }
        return (int) this.f9853a;
    }

    /* renamed from: y */
    public String mo31945y() {
        return Long.toString(this.f9853a);
    }

    public String toString() {
        return mo31945y();
    }
}
