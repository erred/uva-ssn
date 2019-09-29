package p091b.p092a.p097e;

import java.io.IOException;
import p091b.p092a.C1508c;
import p102c.C1677f;

/* renamed from: b.a.e.e */
/* compiled from: Http2 */
public final class C1540e {

    /* renamed from: a */
    static final C1677f f4677a = C1677f.m6985a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    static final String[] f4678b = new String[64];

    /* renamed from: c */
    static final String[] f4679c = new String[256];

    /* renamed from: d */
    private static final String[] f4680d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int[] iArr;
        for (int i = 0; i < f4679c.length; i++) {
            f4679c[i] = C1508c.m6075a("%8s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        f4678b[0] = "";
        f4678b[1] = "END_STREAM";
        int[] iArr2 = {1};
        f4678b[8] = "PADDED";
        for (int i2 : iArr2) {
            String[] strArr = f4678b;
            int i3 = i2 | 8;
            StringBuilder sb = new StringBuilder();
            sb.append(f4678b[i2]);
            sb.append("|PADDED");
            strArr[i3] = sb.toString();
        }
        f4678b[4] = "END_HEADERS";
        f4678b[32] = "PRIORITY";
        f4678b[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr2) {
                String[] strArr2 = f4678b;
                int i6 = i5 | i4;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f4678b[i5]);
                sb2.append('|');
                sb2.append(f4678b[i4]);
                strArr2[i6] = sb2.toString();
                String[] strArr3 = f4678b;
                int i7 = i6 | 8;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f4678b[i5]);
                sb3.append('|');
                sb3.append(f4678b[i4]);
                sb3.append("|PADDED");
                strArr3[i7] = sb3.toString();
            }
        }
        for (int i8 = 0; i8 < f4678b.length; i8++) {
            if (f4678b[i8] == null) {
                f4678b[i8] = f4679c[i8];
            }
        }
    }

    private C1540e() {
    }

    /* renamed from: a */
    static IllegalArgumentException m6217a(String str, Object... objArr) {
        throw new IllegalArgumentException(C1508c.m6075a(str, objArr));
    }

    /* renamed from: b */
    static IOException m6220b(String str, Object... objArr) throws IOException {
        throw new IOException(C1508c.m6075a(str, objArr));
    }

    /* renamed from: a */
    static String m6219a(boolean z, int i, int i2, byte b, byte b2) {
        String a = b < f4680d.length ? f4680d[b] : C1508c.m6075a("0x%02x", Byte.valueOf(b));
        String a2 = m6218a(b, b2);
        String str = "%s 0x%08x %5d %-13s %s";
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a;
        objArr[4] = a2;
        return C1508c.m6075a(str, objArr);
    }

    /* renamed from: a */
    static String m6218a(byte b, byte b2) {
        String str;
        if (b2 == 0) {
            return "";
        }
        switch (b) {
            case 2:
            case 3:
            case 7:
            case 8:
                return f4679c[b2];
            case 4:
            case 6:
                return b2 == 1 ? "ACK" : f4679c[b2];
            default:
                if (b2 < f4678b.length) {
                    str = f4678b[b2];
                } else {
                    str = f4679c[b2];
                }
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
        }
    }
}
