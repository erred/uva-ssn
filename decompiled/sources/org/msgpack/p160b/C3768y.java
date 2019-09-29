package org.msgpack.p160b;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.msgpack.p160b.p161a.C3717c;
import org.msgpack.p160b.p161a.C3719d;
import org.msgpack.p160b.p161a.C3720e;
import org.msgpack.p160b.p161a.C3721f;
import org.msgpack.p160b.p161a.C3722g;
import org.msgpack.p160b.p161a.C3723h;
import org.msgpack.p160b.p161a.C3724i;
import org.msgpack.p160b.p161a.C3725j;
import org.msgpack.p160b.p161a.C3729k;
import org.msgpack.p160b.p161a.C3730l;

/* renamed from: org.msgpack.b.y */
/* compiled from: ValueFactory */
public final class C3768y {
    /* renamed from: a */
    public static C3756m m11451a() {
        return C3729k.m11269a();
    }

    /* renamed from: a */
    public static C3751h m11445a(boolean z) {
        return z ? C3721f.f9847a : C3721f.f9848b;
    }

    /* renamed from: a */
    public static C3754k m11448a(long j) {
        return new C3724i(j);
    }

    /* renamed from: a */
    public static C3754k m11449a(BigInteger bigInteger) {
        return new C3719d(bigInteger);
    }

    /* renamed from: a */
    public static C3753j m11447a(double d) {
        return new C3722g(d);
    }

    /* renamed from: a */
    public static C3750g m11443a(byte[] bArr) {
        return m11444a(bArr, false);
    }

    /* renamed from: a */
    public static C3750g m11444a(byte[] bArr, boolean z) {
        if (z) {
            return new C3720e(bArr);
        }
        return new C3720e(Arrays.copyOf(bArr, bArr.length));
    }

    /* renamed from: b */
    public static C3759p m11453b(byte[] bArr) {
        return new C3730l(bArr);
    }

    /* renamed from: b */
    public static C3759p m11454b(byte[] bArr, boolean z) {
        if (z) {
            return new C3730l(bArr);
        }
        return new C3730l(Arrays.copyOf(bArr, bArr.length));
    }

    /* renamed from: a */
    public static C3749f m11441a(List<? extends C3767x> list) {
        if (list.isEmpty()) {
            return C3717c.m11073b();
        }
        return new C3717c((C3767x[]) list.toArray(new C3767x[list.size()]));
    }

    /* renamed from: a */
    public static C3749f m11442a(C3767x[] xVarArr, boolean z) {
        if (xVarArr.length == 0) {
            return C3717c.m11073b();
        }
        if (z) {
            return new C3717c(xVarArr);
        }
        return new C3717c((C3767x[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    /* renamed from: a */
    public static <K extends C3767x, V extends C3767x> C3755l m11450a(Map<K, V> map) {
        C3767x[] xVarArr = new C3767x[(map.size() * 2)];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            xVarArr[i] = (C3767x) entry.getKey();
            int i2 = i + 1;
            xVarArr[i2] = (C3767x) entry.getValue();
            i = i2 + 1;
        }
        return new C3725j(xVarArr);
    }

    /* renamed from: b */
    public static C3755l m11452b(C3767x[] xVarArr, boolean z) {
        if (xVarArr.length == 0) {
            return C3725j.m11241b();
        }
        if (z) {
            return new C3725j(xVarArr);
        }
        return new C3725j((C3767x[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    /* renamed from: a */
    public static C3752i m11446a(byte b, byte[] bArr) {
        return new C3723h(b, bArr);
    }
}
