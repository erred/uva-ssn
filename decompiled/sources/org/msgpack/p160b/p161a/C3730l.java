package org.msgpack.p160b.p161a;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.p160b.C3759p;
import org.msgpack.p160b.C3767x;
import org.msgpack.p160b.C3769z;

/* renamed from: org.msgpack.b.a.l */
/* compiled from: ImmutableStringValueImpl */
public class C3730l extends C3715a implements C3759p {
    /* renamed from: A */
    public C3759p mo31951u() {
        return this;
    }

    /* renamed from: F */
    public C3759p mo31959f() {
        return this;
    }

    public C3730l(byte[] bArr) {
        super(bArr);
    }

    /* renamed from: e */
    public C3769z mo31957e() {
        return C3769z.STRING;
    }

    /* renamed from: a */
    public void mo31956a(MessagePacker messagePacker) throws IOException {
        messagePacker.packRawStringHeader(this.f9831a.length);
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
        if (!xVar.mo31940m()) {
            return false;
        }
        if (!(xVar instanceof C3730l)) {
            return Arrays.equals(this.f9831a, xVar.mo31951u().mo31930a());
        }
        return Arrays.equals(this.f9831a, ((C3730l) xVar).f9831a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f9831a);
    }
}
