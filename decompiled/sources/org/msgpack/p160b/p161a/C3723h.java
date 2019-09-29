package org.msgpack.p160b.p161a;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.p160b.C3747d;
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

/* renamed from: org.msgpack.b.a.h */
/* compiled from: ImmutableExtensionValueImpl */
public class C3723h extends C3716b implements C3752i {

    /* renamed from: a */
    private final byte f9851a;

    /* renamed from: b */
    private final byte[] f9852b;

    /* renamed from: F */
    public C3752i mo31959f() {
        return this;
    }

    /* renamed from: c */
    public C3752i mo31954x() {
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

    /* renamed from: E */
    public /* bridge */ /* synthetic */ C3751h mo31929E() {
        return super.mo31947q();
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

    public C3723h(byte b, byte[] bArr) {
        this.f9851a = b;
        this.f9852b = bArr;
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return C3769z.EXTENSION;
    }

    /* renamed from: a */
    public byte mo31983a() {
        return this.f9851a;
    }

    /* renamed from: b */
    public byte[] mo31984b() {
        return this.f9852b;
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        messagePacker.packExtensionTypeHeader(this.f9851a, this.f9852b.length);
        messagePacker.writePayload(this.f9852b);
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
        if (!xVar.mo31943p()) {
            return false;
        }
        C3747d x = xVar.mo31954x();
        if (this.f9851a != x.mo31983a() || !Arrays.equals(this.f9852b, x.mo31984b())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.f9851a + Ascii.f6737US;
        for (byte b : this.f9852b) {
            i = (i * 31) + b;
        }
        return i;
    }

    /* renamed from: y */
    public String mo31945y() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(Byte.toString(this.f9851a));
        sb.append(",\"");
        for (byte num : this.f9852b) {
            sb.append(Integer.toString(num, 16));
        }
        sb.append("\"]");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(Byte.toString(this.f9851a));
        sb.append(",0x");
        for (byte num : this.f9852b) {
            sb.append(Integer.toString(num, 16));
        }
        sb.append(")");
        return sb.toString();
    }
}
