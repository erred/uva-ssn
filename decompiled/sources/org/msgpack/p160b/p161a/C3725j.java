package org.msgpack.p160b.p161a;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
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

/* renamed from: org.msgpack.b.a.j */
/* compiled from: ImmutableMapValueImpl */
public class C3725j extends C3716b implements C3755l {

    /* renamed from: a */
    private static final C3725j f9854a = new C3725j(new C3767x[0]);

    /* renamed from: b */
    private final C3767x[] f9855b;

    /* renamed from: org.msgpack.b.a.j$a */
    /* compiled from: ImmutableMapValueImpl */
    private static class C3726a extends AbstractSet<Entry<C3767x, C3767x>> {

        /* renamed from: a */
        private final C3767x[] f9856a;

        C3726a(C3767x[] xVarArr) {
            this.f9856a = xVarArr;
        }

        public int size() {
            return this.f9856a.length / 2;
        }

        public Iterator<Entry<C3767x, C3767x>> iterator() {
            return new C3727b(this.f9856a);
        }
    }

    /* renamed from: org.msgpack.b.a.j$b */
    /* compiled from: ImmutableMapValueImpl */
    private static class C3727b implements Iterator<Entry<C3767x, C3767x>> {

        /* renamed from: a */
        private final C3767x[] f9857a;

        /* renamed from: b */
        private int f9858b = 0;

        C3727b(C3767x[] xVarArr) {
            this.f9857a = xVarArr;
        }

        public boolean hasNext() {
            return this.f9858b < this.f9857a.length;
        }

        /* renamed from: a */
        public Entry<C3767x, C3767x> next() {
            if (this.f9858b < this.f9857a.length) {
                SimpleImmutableEntry simpleImmutableEntry = new SimpleImmutableEntry(this.f9857a[this.f9858b], this.f9857a[this.f9858b + 1]);
                this.f9858b += 2;
                return simpleImmutableEntry;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: org.msgpack.b.a.j$c */
    /* compiled from: ImmutableMapValueImpl */
    private static class C3728c extends AbstractMap<C3767x, C3767x> {

        /* renamed from: a */
        private final C3767x[] f9859a;

        public C3728c(C3767x[] xVarArr) {
            this.f9859a = xVarArr;
        }

        public Set<Entry<C3767x, C3767x>> entrySet() {
            return new C3726a(this.f9859a);
        }
    }

    /* renamed from: F */
    public C3755l mo31959f() {
        return this;
    }

    /* renamed from: d */
    public C3755l mo31953w() {
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

    /* renamed from: b */
    public static C3755l m11241b() {
        return f9854a;
    }

    public C3725j(C3767x[] xVarArr) {
        this.f9855b = xVarArr;
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return C3769z.MAP;
    }

    /* renamed from: a */
    public Map<C3767x, C3767x> mo31991a() {
        return new C3728c(this.f9855b);
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        messagePacker.packMapHeader(this.f9855b.length / 2);
        for (C3767x a : this.f9855b) {
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
        if (!xVar.mo31942o()) {
            return false;
        }
        return mo31991a().equals(xVar.mo31953w().mo31991a());
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.f9855b.length; i2 += 2) {
            i += this.f9855b[i2].hashCode() ^ this.f9855b[i2 + 1].hashCode();
        }
        return i;
    }

    /* renamed from: y */
    public String mo31945y() {
        if (this.f9855b.length == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        m11240a(sb, this.f9855b[0]);
        sb.append(":");
        sb.append(this.f9855b[1].mo31945y());
        for (int i = 2; i < this.f9855b.length; i += 2) {
            sb.append(",");
            m11240a(sb, this.f9855b[i]);
            sb.append(":");
            sb.append(this.f9855b[i + 1].mo31945y());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    private static void m11240a(StringBuilder sb, C3767x xVar) {
        if (xVar.mo31938k()) {
            sb.append(xVar.mo31945y());
        } else {
            C3730l.m11024a(sb, xVar.toString());
        }
    }

    public String toString() {
        if (this.f9855b.length == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        m11242b(sb, this.f9855b[0]);
        sb.append(":");
        m11242b(sb, this.f9855b[1]);
        for (int i = 2; i < this.f9855b.length; i += 2) {
            sb.append(",");
            m11242b(sb, this.f9855b[i]);
            sb.append(":");
            m11242b(sb, this.f9855b[i + 1]);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: b */
    private static void m11242b(StringBuilder sb, C3767x xVar) {
        if (xVar.mo31938k()) {
            sb.append(xVar.mo31945y());
        } else {
            sb.append(xVar.toString());
        }
    }
}
