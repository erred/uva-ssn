package org.msgpack.p160b.p161a;

import java.io.IOException;
import org.msgpack.core.MessagePacker;
import org.msgpack.p160b.C3749f;
import org.msgpack.p160b.C3750g;
import org.msgpack.p160b.C3751h;
import org.msgpack.p160b.C3752i;
import org.msgpack.p160b.C3753j;
import org.msgpack.p160b.C3754k;
import org.msgpack.p160b.C3755l;
import org.msgpack.p160b.C3759p;
import org.msgpack.p160b.C3767x;
import org.msgpack.p160b.C3769z;

/* renamed from: org.msgpack.b.a.f */
/* compiled from: ImmutableBooleanValueImpl */
public class C3721f extends C3716b implements C3751h {

    /* renamed from: a */
    public static final C3751h f9847a = new C3721f(true);

    /* renamed from: b */
    public static final C3751h f9848b = new C3721f(false);

    /* renamed from: c */
    private final boolean f9849c;

    /* renamed from: E */
    public C3751h mo31947q() {
        return this;
    }

    /* renamed from: b */
    public C3751h mo31959f() {
        return this;
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

    /* renamed from: D */
    public /* bridge */ /* synthetic */ C3754k mo31928D() {
        return super.mo31948r();
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

    private C3721f(boolean z) {
        this.f9849c = z;
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return C3769z.BOOLEAN;
    }

    /* renamed from: a */
    public boolean mo31975a() {
        return this.f9849c;
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        messagePacker.packBoolean(this.f9849c);
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
        if (!xVar.mo31935h()) {
            return false;
        }
        if (this.f9849c != xVar.mo31947q().mo31975a()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f9849c ? 1231 : 1237;
    }

    /* renamed from: y */
    public String mo31945y() {
        return Boolean.toString(this.f9849c);
    }

    public String toString() {
        return mo31945y();
    }
}
