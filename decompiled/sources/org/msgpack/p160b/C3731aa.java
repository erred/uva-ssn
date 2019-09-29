package org.msgpack.p160b;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageStringCodingException;
import org.msgpack.core.MessageTypeCastException;

/* renamed from: org.msgpack.b.aa */
/* compiled from: Variable */
public class C3731aa implements C3767x {

    /* renamed from: o */
    private static final BigInteger f9861o = BigInteger.valueOf(Long.MIN_VALUE);

    /* renamed from: p */
    private static final BigInteger f9862p = BigInteger.valueOf(Long.MAX_VALUE);

    /* renamed from: a */
    private final C3742k f9863a;

    /* renamed from: b */
    private final C3737f f9864b;

    /* renamed from: c */
    private final C3740i f9865c;

    /* renamed from: d */
    private final C3739h f9866d;

    /* renamed from: e */
    private final C3736e f9867e;

    /* renamed from: f */
    private final C3743l f9868f;

    /* renamed from: g */
    private final C3735d f9869g;

    /* renamed from: h */
    private final C3741j f9870h;

    /* renamed from: i */
    private final C3738g f9871i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C3744m f9872j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f9873k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public double f9874l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Object f9875m;

    /* renamed from: n */
    private C3734c f9876n;

    /* renamed from: org.msgpack.b.aa$a */
    /* compiled from: Variable */
    private abstract class C3732a extends C3734c implements C3764u {

        /* renamed from: a */
        final /* synthetic */ C3731aa f9877a;

        /* renamed from: b */
        public long mo31968b() {
            if (this.f9877a.f9872j == C3744m.BIG_INTEGER) {
                return ((BigInteger) this.f9877a.f9875m).longValue();
            }
            return this.f9877a.f9873k;
        }

        /* renamed from: l_ */
        public BigInteger mo31970l_() {
            if (this.f9877a.f9872j == C3744m.BIG_INTEGER) {
                return (BigInteger) this.f9877a.f9875m;
            }
            if (this.f9877a.f9872j == C3744m.DOUBLE) {
                return new BigDecimal(this.f9877a.f9874l).toBigInteger();
            }
            return BigInteger.valueOf(this.f9877a.f9873k);
        }

        /* renamed from: m_ */
        public double mo31971m_() {
            if (this.f9877a.f9872j == C3744m.BIG_INTEGER) {
                return ((BigInteger) this.f9877a.f9875m).doubleValue();
            }
            if (this.f9877a.f9872j == C3744m.DOUBLE) {
                return this.f9877a.f9874l;
            }
            return (double) this.f9877a.f9873k;
        }
    }

    /* renamed from: org.msgpack.b.aa$b */
    /* compiled from: Variable */
    private abstract class C3733b extends C3734c implements C3765v {

        /* renamed from: a */
        final /* synthetic */ C3731aa f9878a;

        /* renamed from: a */
        public byte[] mo31930a() {
            return (byte[]) this.f9878a.f9875m;
        }

        public String toString() {
            try {
                return MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(ByteBuffer.wrap((byte[]) this.f9878a.f9875m)).toString();
            } catch (CharacterCodingException e) {
                throw new MessageStringCodingException(e);
            }
        }
    }

    /* renamed from: org.msgpack.b.aa$c */
    /* compiled from: Variable */
    private abstract class C3734c implements C3767x {

        /* renamed from: b */
        final /* synthetic */ C3731aa f9879b;

        /* renamed from: g */
        public boolean mo31934g() {
            return mo31957e().mo32030a();
        }

        /* renamed from: h */
        public boolean mo31935h() {
            return mo31957e().mo32031b();
        }

        /* renamed from: i */
        public boolean mo31936i() {
            return mo31957e().mo32032c();
        }

        /* renamed from: j */
        public boolean mo31937j() {
            return mo31957e().mo32033d();
        }

        /* renamed from: k */
        public boolean mo31938k() {
            return mo31957e().mo32034e();
        }

        /* renamed from: l */
        public boolean mo31939l() {
            return mo31957e().mo32036g();
        }

        /* renamed from: m */
        public boolean mo31940m() {
            return mo31957e().mo32035f();
        }

        /* renamed from: n */
        public boolean mo31941n() {
            return mo31957e().mo32037h();
        }

        /* renamed from: o */
        public boolean mo31942o() {
            return mo31957e().mo32038i();
        }

        /* renamed from: p */
        public boolean mo31943p() {
            return mo31957e().mo32039j();
        }

        /* renamed from: q */
        public C3746c mo31947q() {
            throw new MessageTypeCastException();
        }

        /* renamed from: r */
        public C3761r mo31948r() {
            throw new MessageTypeCastException();
        }

        /* renamed from: s */
        public C3748e mo31949s() {
            throw new MessageTypeCastException();
        }

        /* renamed from: t */
        public C3745b mo31950t() {
            throw new MessageTypeCastException();
        }

        /* renamed from: u */
        public C3766w mo31951u() {
            throw new MessageTypeCastException();
        }

        /* renamed from: v */
        public C3714a mo31952v() {
            throw new MessageTypeCastException();
        }

        /* renamed from: w */
        public C3762s mo31953w() {
            throw new MessageTypeCastException();
        }

        /* renamed from: x */
        public C3747d mo31954x() {
            throw new MessageTypeCastException();
        }

        public boolean equals(Object obj) {
            return this.f9879b.equals(obj);
        }

        public int hashCode() {
            return this.f9879b.hashCode();
        }

        /* renamed from: y */
        public String mo31945y() {
            return this.f9879b.mo31945y();
        }

        public String toString() {
            return this.f9879b.toString();
        }
    }

    /* renamed from: org.msgpack.b.aa$d */
    /* compiled from: Variable */
    private class C3735d extends C3734c implements C3714a {

        /* renamed from: a */
        final /* synthetic */ C3731aa f9880a;

        /* renamed from: v */
        public C3714a mo31952v() {
            return this;
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.ARRAY;
        }

        /* renamed from: b */
        public C3749f mo31959f() {
            return C3768y.m11441a(mo32020c());
        }

        /* renamed from: a */
        public int mo31923a() {
            return mo32020c().size();
        }

        public Iterator<C3767x> iterator() {
            return mo32020c().iterator();
        }

        /* renamed from: c */
        public List<C3767x> mo32020c() {
            return (List) this.f9880a.f9875m;
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            List<C3767x> c = mo32020c();
            messagePacker.packArrayHeader(c.size());
            for (C3767x a : c) {
                a.mo31956a(messagePacker);
            }
        }
    }

    /* renamed from: org.msgpack.b.aa$e */
    /* compiled from: Variable */
    private class C3736e extends C3733b implements C3745b {

        /* renamed from: c */
        final /* synthetic */ C3731aa f9881c;

        /* renamed from: t */
        public C3745b mo31950t() {
            return this;
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.BINARY;
        }

        /* renamed from: b */
        public C3750g mo31959f() {
            return C3768y.m11443a(mo31930a());
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            byte[] bArr = (byte[]) this.f9881c.f9875m;
            messagePacker.packBinaryHeader(bArr.length);
            messagePacker.writePayload(bArr);
        }
    }

    /* renamed from: org.msgpack.b.aa$f */
    /* compiled from: Variable */
    private class C3737f extends C3734c implements C3746c {

        /* renamed from: a */
        final /* synthetic */ C3731aa f9882a;

        /* renamed from: q */
        public C3746c mo31947q() {
            return this;
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.BOOLEAN;
        }

        /* renamed from: b */
        public C3751h mo31959f() {
            return C3768y.m11445a(mo31975a());
        }

        /* renamed from: a */
        public boolean mo31975a() {
            return this.f9882a.f9873k == 1;
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            messagePacker.packBoolean(this.f9882a.f9873k == 1);
        }
    }

    /* renamed from: org.msgpack.b.aa$g */
    /* compiled from: Variable */
    private class C3738g extends C3734c implements C3747d {

        /* renamed from: a */
        final /* synthetic */ C3731aa f9883a;

        /* renamed from: x */
        public C3747d mo31954x() {
            return this;
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.EXTENSION;
        }

        /* renamed from: c */
        public C3752i mo31959f() {
            return (C3752i) this.f9883a.f9875m;
        }

        /* renamed from: a */
        public byte mo31983a() {
            return ((C3752i) this.f9883a.f9875m).mo31983a();
        }

        /* renamed from: b */
        public byte[] mo31984b() {
            return ((C3752i) this.f9883a.f9875m).mo31984b();
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            ((C3752i) this.f9883a.f9875m).mo31956a(messagePacker);
        }
    }

    /* renamed from: org.msgpack.b.aa$h */
    /* compiled from: Variable */
    private class C3739h extends C3732a implements C3748e {

        /* renamed from: c */
        final /* synthetic */ C3731aa f9884c;

        /* renamed from: s */
        public C3748e mo31949s() {
            return this;
        }

        /* renamed from: a */
        public C3753j mo31959f() {
            return C3768y.m11447a(this.f9884c.f9874l);
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.FLOAT;
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            messagePacker.packDouble(this.f9884c.f9874l);
        }
    }

    /* renamed from: org.msgpack.b.aa$i */
    /* compiled from: Variable */
    private class C3740i extends C3732a implements C3761r {

        /* renamed from: c */
        final /* synthetic */ C3731aa f9885c;

        /* renamed from: r */
        public C3761r mo31948r() {
            return this;
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.INTEGER;
        }

        /* renamed from: z */
        public C3754k mo31959f() {
            if (this.f9885c.f9872j == C3744m.BIG_INTEGER) {
                return C3768y.m11449a((BigInteger) this.f9885c.f9875m);
            }
            return C3768y.m11448a(this.f9885c.f9873k);
        }

        /* renamed from: a */
        public boolean mo31967a() {
            return this.f9885c.f9872j != C3744m.BIG_INTEGER;
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            if (this.f9885c.f9872j == C3744m.BIG_INTEGER) {
                messagePacker.packBigInteger((BigInteger) this.f9885c.f9875m);
            } else {
                messagePacker.packLong(this.f9885c.f9873k);
            }
        }
    }

    /* renamed from: org.msgpack.b.aa$j */
    /* compiled from: Variable */
    private class C3741j extends C3734c implements C3762s {

        /* renamed from: a */
        final /* synthetic */ C3731aa f9886a;

        /* renamed from: w */
        public C3762s mo31953w() {
            return this;
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.MAP;
        }

        /* renamed from: b */
        public C3755l mo31959f() {
            return C3768y.m11450a(mo31991a());
        }

        /* renamed from: a */
        public Map<C3767x, C3767x> mo31991a() {
            return (Map) this.f9886a.f9875m;
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            Map a = mo31991a();
            messagePacker.packArrayHeader(a.size());
            for (Entry entry : a.entrySet()) {
                ((C3767x) entry.getKey()).mo31956a(messagePacker);
                ((C3767x) entry.getValue()).mo31956a(messagePacker);
            }
        }
    }

    /* renamed from: org.msgpack.b.aa$k */
    /* compiled from: Variable */
    private class C3742k extends C3734c implements C3763t {
        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.NIL;
        }

        /* renamed from: a */
        public C3756m mo31959f() {
            return C3768y.m11451a();
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            messagePacker.packNil();
        }
    }

    /* renamed from: org.msgpack.b.aa$l */
    /* compiled from: Variable */
    private class C3743l extends C3733b implements C3766w {

        /* renamed from: c */
        final /* synthetic */ C3731aa f9887c;

        /* renamed from: u */
        public C3766w mo31951u() {
            return this;
        }

        /* renamed from: e */
        public C3769z mo31957e() {
            return C3769z.STRING;
        }

        /* renamed from: b */
        public C3759p mo31959f() {
            return C3768y.m11453b((byte[]) this.f9887c.f9875m);
        }

        /* renamed from: a */
        public void mo31956a(MessagePacker messagePacker) throws IOException {
            byte[] bArr = (byte[]) this.f9887c.f9875m;
            messagePacker.packRawStringHeader(bArr.length);
            messagePacker.writePayload(bArr);
        }
    }

    /* renamed from: org.msgpack.b.aa$m */
    /* compiled from: Variable */
    public enum C3744m {
        NULL(C3769z.NIL),
        BOOLEAN(C3769z.BOOLEAN),
        LONG(C3769z.INTEGER),
        BIG_INTEGER(C3769z.INTEGER),
        DOUBLE(C3769z.FLOAT),
        BYTE_ARRAY(C3769z.BINARY),
        RAW_STRING(C3769z.STRING),
        LIST(C3769z.ARRAY),
        MAP(C3769z.MAP),
        EXTENSION(C3769z.EXTENSION);
        

        /* renamed from: k */
        private final C3769z f9899k;

        private C3744m(C3769z zVar) {
            this.f9899k = zVar;
        }

        /* renamed from: a */
        public C3769z mo32029a() {
            return this.f9899k;
        }
    }

    /* renamed from: a */
    public C3731aa mo32005a() {
        this.f9872j = C3744m.NULL;
        this.f9876n = this.f9863a;
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32012a(boolean z) {
        this.f9872j = C3744m.BOOLEAN;
        this.f9876n = this.f9864b;
        this.f9873k = z ? 1 : 0;
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32008a(long j) {
        this.f9872j = C3744m.LONG;
        this.f9876n = this.f9865c;
        this.f9873k = j;
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32009a(BigInteger bigInteger) {
        if (bigInteger.compareTo(f9861o) < 0 || bigInteger.compareTo(f9862p) > 0) {
            this.f9872j = C3744m.BIG_INTEGER;
            this.f9876n = this.f9865c;
            this.f9875m = bigInteger;
        } else {
            this.f9872j = C3744m.LONG;
            this.f9876n = this.f9865c;
            this.f9873k = bigInteger.longValue();
        }
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32007a(double d) {
        this.f9872j = C3744m.DOUBLE;
        this.f9876n = this.f9866d;
        this.f9874l = d;
        this.f9873k = (long) d;
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32013a(byte[] bArr) {
        this.f9872j = C3744m.BYTE_ARRAY;
        this.f9876n = this.f9867e;
        this.f9875m = bArr;
        return this;
    }

    /* renamed from: b */
    public C3731aa mo32014b(byte[] bArr) {
        this.f9872j = C3744m.RAW_STRING;
        this.f9876n = this.f9868f;
        this.f9875m = bArr;
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32010a(List<C3767x> list) {
        this.f9872j = C3744m.LIST;
        this.f9876n = this.f9869g;
        this.f9875m = list;
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32011a(Map<C3767x, C3767x> map) {
        this.f9872j = C3744m.MAP;
        this.f9876n = this.f9870h;
        this.f9875m = map;
        return this;
    }

    /* renamed from: a */
    public C3731aa mo32006a(byte b, byte[] bArr) {
        this.f9872j = C3744m.EXTENSION;
        this.f9876n = this.f9871i;
        this.f9875m = C3768y.m11446a(b, bArr);
        return this;
    }

    /* renamed from: f */
    public C3760q mo31959f() {
        return this.f9876n.mo31959f();
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        this.f9876n.mo31956a(messagePacker);
    }

    public int hashCode() {
        return mo31959f().hashCode();
    }

    public boolean equals(Object obj) {
        return mo31959f().equals(obj);
    }

    /* renamed from: y */
    public String mo31945y() {
        return mo31959f().mo31945y();
    }

    public String toString() {
        return mo31959f().toString();
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return this.f9872j.mo32029a();
    }

    /* renamed from: g */
    public boolean mo31934g() {
        return mo31957e().mo32030a();
    }

    /* renamed from: h */
    public boolean mo31935h() {
        return mo31957e().mo32031b();
    }

    /* renamed from: i */
    public boolean mo31936i() {
        return mo31957e().mo32032c();
    }

    /* renamed from: j */
    public boolean mo31937j() {
        return mo31957e().mo32033d();
    }

    /* renamed from: k */
    public boolean mo31938k() {
        return mo31957e().mo32034e();
    }

    /* renamed from: l */
    public boolean mo31939l() {
        return mo31957e().mo32036g();
    }

    /* renamed from: m */
    public boolean mo31940m() {
        return mo31957e().mo32035f();
    }

    /* renamed from: n */
    public boolean mo31941n() {
        return mo31957e().mo32037h();
    }

    /* renamed from: o */
    public boolean mo31942o() {
        return mo31957e().mo32038i();
    }

    /* renamed from: p */
    public boolean mo31943p() {
        return mo31957e().mo32039j();
    }

    /* renamed from: q */
    public C3746c mo31947q() {
        if (mo31935h()) {
            return (C3746c) this.f9876n;
        }
        throw new MessageTypeCastException();
    }

    /* renamed from: r */
    public C3761r mo31948r() {
        if (mo31936i()) {
            return (C3761r) this.f9876n;
        }
        throw new MessageTypeCastException();
    }

    /* renamed from: s */
    public C3748e mo31949s() {
        if (mo31937j()) {
            return (C3748e) this.f9876n;
        }
        throw new MessageTypeCastException();
    }

    /* renamed from: t */
    public C3745b mo31950t() {
        if (mo31939l()) {
            return (C3745b) this.f9876n;
        }
        throw new MessageTypeCastException();
    }

    /* renamed from: u */
    public C3766w mo31951u() {
        if (mo31940m()) {
            return (C3766w) this.f9876n;
        }
        throw new MessageTypeCastException();
    }

    /* renamed from: v */
    public C3714a mo31952v() {
        if (mo31941n()) {
            return (C3714a) this.f9876n;
        }
        throw new MessageTypeCastException();
    }

    /* renamed from: w */
    public C3762s mo31953w() {
        if (mo31942o()) {
            return (C3762s) this.f9876n;
        }
        throw new MessageTypeCastException();
    }

    /* renamed from: x */
    public C3747d mo31954x() {
        if (mo31943p()) {
            return (C3747d) this.f9876n;
        }
        throw new MessageTypeCastException();
    }
}
