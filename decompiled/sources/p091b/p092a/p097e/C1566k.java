package p091b.p092a.p097e;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import net.sqlcipher.database.SQLiteDatabase;
import p102c.C1677f;

/* renamed from: b.a.e.k */
/* compiled from: Huffman */
class C1566k {

    /* renamed from: a */
    private static final int[] f4806a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, SQLiteDatabase.MAX_SQL_CACHE_SIZE, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b */
    private static final byte[] f4807b = {Ascii.f6725CR, Ascii.ETB, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.CAN, Ascii.f6733RS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6733RS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6733RS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, Ascii.f6728FS, 6, 10, 10, Ascii.f6727FF, Ascii.f6725CR, 6, 8, Ascii.f6738VT, 10, 10, 8, Ascii.f6738VT, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.f6734SI, 6, Ascii.f6727FF, 10, Ascii.f6725CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.f6725CR, 19, Ascii.f6725CR, Ascii.f6735SO, 6, Ascii.f6734SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.f6734SI, Ascii.f6738VT, Ascii.f6735SO, Ascii.f6725CR, Ascii.f6728FS, Ascii.DC4, Ascii.SYN, Ascii.DC4, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.SYN, Ascii.NAK, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.CAN, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SUB, Ascii.SUB, Ascii.DC4, 19, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.f6726EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.f6726EM, 19, Ascii.NAK, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SUB, Ascii.SUB, Ascii.f6728FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.DC4, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.f6726EM, Ascii.f6726EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ETB, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.f6728FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};

    /* renamed from: c */
    private static final C1566k f4808c = new C1566k();

    /* renamed from: d */
    private final C1567a f4809d = new C1567a();

    /* renamed from: b.a.e.k$a */
    /* compiled from: Huffman */
    private static final class C1567a {

        /* renamed from: a */
        final C1567a[] f4810a;

        /* renamed from: b */
        final int f4811b;

        /* renamed from: c */
        final int f4812c;

        C1567a() {
            this.f4810a = new C1567a[256];
            this.f4811b = 0;
            this.f4812c = 0;
        }

        C1567a(int i, int i2) {
            this.f4810a = null;
            this.f4811b = i;
            int i3 = i2 & 7;
            if (i3 == 0) {
                i3 = 8;
            }
            this.f4812c = i3;
        }
    }

    /* renamed from: a */
    public static C1566k m6363a() {
        return f4808c;
    }

    private C1566k() {
        m6365b();
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [int] */
    /* JADX WARNING: type inference failed for: r3v4, types: [long, int] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6396a(p102c.C1677f r9, p102c.C1675d r10) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r3 = 0
        L_0x0004:
            int r4 = r9.mo6902h()
            r5 = 8
            r6 = 255(0xff, float:3.57E-43)
            if (r0 >= r4) goto L_0x002d
            byte r4 = r9.mo6886a(r0)
            r4 = r4 & r6
            int[] r6 = f4806a
            r6 = r6[r4]
            byte[] r7 = f4807b
            byte r4 = r7[r4]
            long r1 = r1 << r4
            long r6 = (long) r6
            long r1 = r1 | r6
            int r3 = r3 + r4
        L_0x001f:
            if (r3 < r5) goto L_0x002a
            int r3 = r3 + -8
            long r6 = r1 >> r3
            int r4 = (int) r6
            r10.mo6854i(r4)
            goto L_0x001f
        L_0x002a:
            int r0 = r0 + 1
            goto L_0x0004
        L_0x002d:
            if (r3 <= 0) goto L_0x003a
            int r5 = r5 - r3
            long r0 = r1 << r5
            int r9 = r6 >>> r3
            long r2 = (long) r9
            long r0 = r0 | r2
            int r9 = (int) r0
            r10.mo6854i(r9)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1566k.mo6396a(c.f, c.d):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo6395a(C1677f fVar) {
        long j = 0;
        for (int i = 0; i < fVar.mo6902h(); i++) {
            j += (long) f4807b[fVar.mo6886a(i) & UnsignedBytes.MAX_VALUE];
        }
        return (int) ((j + 7) >> 3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public byte[] mo6397a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1567a aVar = this.f4809d;
        byte b = 0;
        int i = 0;
        for (byte b2 : bArr) {
            b = (b << 8) | (b2 & UnsignedBytes.MAX_VALUE);
            i += 8;
            while (i >= 8) {
                aVar = aVar.f4810a[(b >>> (i - 8)) & 255];
                if (aVar.f4810a == null) {
                    byteArrayOutputStream.write(aVar.f4811b);
                    i -= aVar.f4812c;
                    aVar = this.f4809d;
                } else {
                    i -= 8;
                }
            }
        }
        while (i > 0) {
            C1567a aVar2 = aVar.f4810a[(b << (8 - i)) & 255];
            if (aVar2.f4810a != null || aVar2.f4812c > i) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f4811b);
            i -= aVar2.f4812c;
            aVar = this.f4809d;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private void m6365b() {
        for (int i = 0; i < f4807b.length; i++) {
            m6364a(i, f4806a[i], f4807b[i]);
        }
    }

    /* renamed from: a */
    private void m6364a(int i, int i2, byte b) {
        C1567a aVar = new C1567a(i, b);
        C1567a aVar2 = this.f4809d;
        while (b > 8) {
            b = (byte) (b - 8);
            int i3 = (i2 >>> b) & 255;
            if (aVar2.f4810a != null) {
                if (aVar2.f4810a[i3] == null) {
                    aVar2.f4810a[i3] = new C1567a();
                }
                aVar2 = aVar2.f4810a[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            aVar2.f4810a[i7] = aVar;
        }
    }
}
