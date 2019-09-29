package org.msgpack.p160b.p161a;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.msgpack.core.MessagePacker;
import org.msgpack.p160b.C3714a;
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

/* renamed from: org.msgpack.b.a.c */
/* compiled from: ImmutableArrayValueImpl */
public class C3717c extends C3716b implements C3749f {

    /* renamed from: a */
    private static final C3717c f9834a = new C3717c(new C3767x[0]);

    /* renamed from: b */
    private final C3767x[] f9835b;

    /* renamed from: org.msgpack.b.a.c$a */
    /* compiled from: ImmutableArrayValueImpl */
    private static class C3718a implements Iterator<C3767x> {

        /* renamed from: a */
        private final C3767x[] f9836a;

        /* renamed from: b */
        private int f9837b = 0;

        public C3718a(C3767x[] xVarArr) {
            this.f9836a = xVarArr;
        }

        public boolean hasNext() {
            return this.f9837b != this.f9836a.length;
        }

        /* renamed from: a */
        public C3767x next() {
            int i = this.f9837b;
            if (i < this.f9836a.length) {
                this.f9837b = i + 1;
                return this.f9836a[i];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: F */
    public C3749f mo31959f() {
        return this;
    }

    /* renamed from: z */
    public C3749f mo31952v() {
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

    /* renamed from: b */
    public static C3749f m11073b() {
        return f9834a;
    }

    public C3717c(C3767x[] xVarArr) {
        this.f9835b = xVarArr;
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return C3769z.ARRAY;
    }

    /* renamed from: a */
    public int mo31923a() {
        return this.f9835b.length;
    }

    public Iterator<C3767x> iterator() {
        return new C3718a(this.f9835b);
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        messagePacker.packArrayHeader(this.f9835b.length);
        for (C3767x a : this.f9835b) {
            a.mo31956a(messagePacker);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3767x)) {
            return false;
        }
        C3767x xVar = (C3767x) obj;
        if (xVar instanceof C3717c) {
            return Arrays.equals(this.f9835b, ((C3717c) xVar).f9835b);
        } else if (!xVar.mo31941n()) {
            return false;
        } else {
            C3714a v = xVar.mo31952v();
            if (mo31923a() != v.mo31923a()) {
                return false;
            }
            Iterator it = v.iterator();
            for (C3767x equals : this.f9835b) {
                if (!it.hasNext() || !equals.equals(it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int i = 1;
        for (C3767x hashCode : this.f9835b) {
            i = (i * 31) + hashCode.hashCode();
        }
        return i;
    }

    /* renamed from: y */
    public String mo31945y() {
        if (this.f9835b.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.f9835b[0].mo31945y());
        for (int i = 1; i < this.f9835b.length; i++) {
            sb.append(",");
            sb.append(this.f9835b[i].mo31945y());
        }
        sb.append("]");
        return sb.toString();
    }

    public String toString() {
        if (this.f9835b.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        m11072a(sb, this.f9835b[0]);
        for (int i = 1; i < this.f9835b.length; i++) {
            sb.append(",");
            m11072a(sb, this.f9835b[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    private static void m11072a(StringBuilder sb, C3767x xVar) {
        if (xVar.mo31938k()) {
            sb.append(xVar.mo31945y());
        } else {
            sb.append(xVar.toString());
        }
    }
}
