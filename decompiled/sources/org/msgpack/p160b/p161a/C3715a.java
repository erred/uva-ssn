package org.msgpack.p160b.p161a;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageStringCodingException;
import org.msgpack.p160b.C3749f;
import org.msgpack.p160b.C3750g;
import org.msgpack.p160b.C3751h;
import org.msgpack.p160b.C3752i;
import org.msgpack.p160b.C3753j;
import org.msgpack.p160b.C3754k;
import org.msgpack.p160b.C3755l;
import org.msgpack.p160b.C3758o;
import org.msgpack.p160b.C3759p;

/* renamed from: org.msgpack.b.a.a */
/* compiled from: AbstractImmutableRawValue */
public abstract class C3715a extends C3716b implements C3758o {

    /* renamed from: d */
    private static final char[] f9830d = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    protected final byte[] f9831a;

    /* renamed from: b */
    private volatile String f9832b;

    /* renamed from: c */
    private volatile CharacterCodingException f9833c;

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

    /* renamed from: z */
    public /* bridge */ /* synthetic */ C3749f mo31946z() {
        return super.mo31952v();
    }

    public C3715a(byte[] bArr) {
        this.f9831a = bArr;
    }

    /* renamed from: a */
    public byte[] mo31930a() {
        return Arrays.copyOf(this.f9831a, this.f9831a.length);
    }

    /* renamed from: b */
    public ByteBuffer mo31931b() {
        return ByteBuffer.wrap(this.f9831a).asReadOnlyBuffer();
    }

    /* renamed from: y */
    public String mo31945y() {
        StringBuilder sb = new StringBuilder();
        m11024a(sb, toString());
        return sb.toString();
    }

    /* renamed from: F */
    private void mo31973F() {
        synchronized (this.f9831a) {
            if (this.f9832b == null) {
                try {
                    this.f9832b = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(mo31931b()).toString();
                } catch (CharacterCodingException e) {
                    throw new MessageStringCodingException(e);
                } catch (CharacterCodingException e2) {
                    this.f9832b = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(mo31931b()).toString();
                    this.f9833c = e2;
                }
            }
        }
    }

    public String toString() {
        if (this.f9832b == null) {
            mo31973F();
        }
        return this.f9832b;
    }

    /* renamed from: a */
    static void m11024a(StringBuilder sb, String str) {
        sb.append("\"");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ') {
                switch (charAt) {
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        m11023a(sb, (int) charAt);
                        break;
                }
            } else if (charAt <= 127) {
                if (charAt == '\"') {
                    sb.append("\\\"");
                } else if (charAt != '\\') {
                    sb.append(charAt);
                } else {
                    sb.append("\\\\");
                }
            } else if (charAt < 55296 || charAt > 57343) {
                sb.append(charAt);
            } else {
                m11023a(sb, (int) charAt);
            }
        }
        sb.append("\"");
    }

    /* renamed from: a */
    private static void m11023a(StringBuilder sb, int i) {
        sb.append("\\u");
        sb.append(f9830d[(i >> 12) & 15]);
        sb.append(f9830d[(i >> 8) & 15]);
        sb.append(f9830d[(i >> 4) & 15]);
        sb.append(f9830d[i & 15]);
    }
}
