package p102c;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: c.f */
/* compiled from: ByteString */
public class C1677f implements Serializable, Comparable<C1677f> {

    /* renamed from: a */
    static final char[] f5293a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final C1677f f5294b = m6986a(new byte[0]);

    /* renamed from: c */
    final byte[] f5295c;

    /* renamed from: d */
    transient int f5296d;

    /* renamed from: e */
    transient String f5297e;

    C1677f(byte[] bArr) {
        this.f5295c = bArr;
    }

    /* renamed from: a */
    public static C1677f m6986a(byte... bArr) {
        if (bArr != null) {
            return new C1677f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: a */
    public static C1677f m6987a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            C1698u.m7136a((long) bArr.length, (long) i, (long) i2);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new C1677f(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: a */
    public static C1677f m6985a(String str) {
        if (str != null) {
            C1677f fVar = new C1677f(str.getBytes(C1698u.f5338a));
            fVar.f5297e = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: a */
    public String mo6888a() {
        String str = this.f5297e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f5295c, C1698u.f5338a);
        this.f5297e = str2;
        return str2;
    }

    /* renamed from: b */
    public String mo6894b() {
        return C1671b.m6879a(this.f5295c);
    }

    /* renamed from: c */
    public C1677f mo6895c() {
        return m6990d("MD5");
    }

    /* renamed from: d */
    public C1677f mo6897d() {
        return m6990d("SHA-1");
    }

    /* renamed from: e */
    public C1677f mo6898e() {
        return m6990d("SHA-256");
    }

    /* renamed from: d */
    private C1677f m6990d(String str) {
        try {
            return m6986a(MessageDigest.getInstance(str).digest(this.f5295c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static C1677f m6988b(String str) {
        if (str != null) {
            byte[] a = C1671b.m6881a(str);
            if (a != null) {
                return new C1677f(a);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    /* renamed from: f */
    public String mo6900f() {
        byte[] bArr;
        char[] cArr = new char[(this.f5295c.length * 2)];
        int i = 0;
        for (byte b : this.f5295c) {
            int i2 = i + 1;
            cArr[i] = f5293a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f5293a[b & Ascii.f6734SI];
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public static C1677f m6989c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((m6983a(str.charAt(i2)) << 4) + m6983a(str.charAt(i2 + 1)));
            }
            return m6986a(bArr);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected hex string: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private static int m6983a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected hex digit: ");
        sb.append(c);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: g */
    public C1677f mo6901g() {
        int i = 0;
        while (i < this.f5295c.length) {
            byte b = this.f5295c[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f5295c.clone();
                bArr[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b2 = bArr[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr[i2] = (byte) (b2 + 32);
                    }
                }
                return new C1677f(bArr);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C1677f mo6887a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 <= this.f5295c.length) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f5295c.length) {
                return this;
            } else {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f5295c, i, bArr, 0, i3);
                return new C1677f(bArr);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("endIndex > length(");
            sb.append(this.f5295c.length);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public byte mo6886a(int i) {
        return this.f5295c[i];
    }

    /* renamed from: h */
    public int mo6902h() {
        return this.f5295c.length;
    }

    /* renamed from: i */
    public byte[] mo6904i() {
        return (byte[]) this.f5295c.clone();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6889a(C1672c cVar) {
        cVar.mo6832c(this.f5295c, 0, this.f5295c.length);
    }

    /* renamed from: a */
    public boolean mo6890a(int i, C1677f fVar, int i2, int i3) {
        return fVar.mo6891a(i2, this.f5295c, i, i3);
    }

    /* renamed from: a */
    public boolean mo6891a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f5295c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C1698u.m7138a(this.f5295c, i, bArr, i2, i3);
    }

    /* renamed from: a */
    public final boolean mo6892a(C1677f fVar) {
        return mo6890a(0, fVar, 0, fVar.mo6902h());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r5.mo6891a(0, r4.f5295c, 0, r4.f5295c.length) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof p102c.C1677f
            r2 = 0
            if (r1 == 0) goto L_0x0020
            c.f r5 = (p102c.C1677f) r5
            int r1 = r5.mo6902h()
            byte[] r3 = r4.f5295c
            int r3 = r3.length
            if (r1 != r3) goto L_0x0020
            byte[] r1 = r4.f5295c
            byte[] r3 = r4.f5295c
            int r3 = r3.length
            boolean r5 = r5.mo6891a(r2, r1, r2, r3)
            if (r5 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p102c.C1677f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = this.f5296d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f5295c);
        this.f5296d = hashCode;
        return hashCode;
    }

    /* renamed from: b */
    public int compareTo(C1677f fVar) {
        int h = mo6902h();
        int h2 = fVar.mo6902h();
        int min = Math.min(h, h2);
        int i = 0;
        while (true) {
            int i2 = -1;
            if (i < min) {
                byte a = mo6886a(i) & UnsignedBytes.MAX_VALUE;
                byte a2 = fVar.mo6886a(i) & UnsignedBytes.MAX_VALUE;
                if (a == a2) {
                    i++;
                } else {
                    if (a >= a2) {
                        i2 = 1;
                    }
                    return i2;
                }
            } else if (h == h2) {
                return 0;
            } else {
                if (h >= h2) {
                    i2 = 1;
                }
                return i2;
            }
        }
    }

    public String toString() {
        String str;
        String str2;
        if (this.f5295c.length == 0) {
            return "[size=0]";
        }
        String a = mo6888a();
        int a2 = m6984a(a, 64);
        if (a2 == -1) {
            if (this.f5295c.length <= 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[hex=");
                sb.append(mo6900f());
                sb.append("]");
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(this.f5295c.length);
                sb2.append(" hex=");
                sb2.append(mo6887a(0, 64).mo6900f());
                sb2.append("…]");
                str2 = sb2.toString();
            }
            return str2;
        }
        String replace = a.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a2 < a.length()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[size=");
            sb3.append(this.f5295c.length);
            sb3.append(" text=");
            sb3.append(replace);
            sb3.append("…]");
            str = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[text=");
            sb4.append(replace);
            sb4.append("]");
            str = sb4.toString();
        }
        return str;
    }

    /* renamed from: a */
    static int m6984a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
