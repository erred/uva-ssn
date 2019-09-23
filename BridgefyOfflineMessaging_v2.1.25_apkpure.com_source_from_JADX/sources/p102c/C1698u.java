package p102c;

import java.nio.charset.Charset;

/* renamed from: c.u */
/* compiled from: Util */
final class C1698u {

    /* renamed from: a */
    public static final Charset f5338a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m7134a(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: a */
    public static short m7135a(short s) {
        short s2 = s & 65535;
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    /* renamed from: a */
    public static void m7136a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static void m7137a(Throwable th) {
        m7139b(th);
    }

    /* renamed from: b */
    private static <T extends Throwable> void m7139b(Throwable th) throws Throwable {
        throw th;
    }

    /* renamed from: a */
    public static boolean m7138a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
