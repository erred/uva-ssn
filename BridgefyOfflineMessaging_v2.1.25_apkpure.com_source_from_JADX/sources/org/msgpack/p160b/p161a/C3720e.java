package org.msgpack.p160b.p161a;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.p160b.C3750g;
import org.msgpack.p160b.C3767x;
import org.msgpack.p160b.C3769z;

/* renamed from: org.msgpack.b.a.e */
/* compiled from: ImmutableBinaryValueImpl */
public class C3720e extends C3715a implements C3750g {
    /* renamed from: B */
    public C3750g mo31950t() {
        return this;
    }

    /* renamed from: F */
    public C3750g mo31959f() {
        return this;
    }

    public C3720e(byte[] bArr) {
        super(bArr);
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return C3769z.BINARY;
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        messagePacker.packBinaryHeader(this.f9831a.length);
        messagePacker.writePayload(this.f9831a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3767x)) {
            return false;
        }
        C3767x xVar = (C3767x) obj;
        if (!xVar.mo31939l()) {
            return false;
        }
        if (!(xVar instanceof C3720e)) {
            return Arrays.equals(this.f9831a, xVar.mo31950t().mo31930a());
        }
        return Arrays.equals(this.f9831a, ((C3720e) xVar).f9831a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f9831a);
    }
}
