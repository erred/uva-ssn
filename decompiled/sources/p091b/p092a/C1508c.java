package p091b.p092a;

import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p091b.C1592ab;
import p091b.C1598ad;
import p091b.C1642t;
import p091b.C1647v;
import p102c.C1672c;
import p102c.C1676e;
import p102c.C1677f;
import p102c.C1695s;

/* renamed from: b.a.c */
/* compiled from: Util */
public final class C1508c {

    /* renamed from: a */
    public static final byte[] f4560a = new byte[0];

    /* renamed from: b */
    public static final String[] f4561b = new String[0];

    /* renamed from: c */
    public static final C1598ad f4562c = C1598ad.m6544a(null, f4560a);

    /* renamed from: d */
    public static final C1592ab f4563d = C1592ab.m6496a((C1647v) null, f4560a);

    /* renamed from: e */
    public static final Charset f4564e = Charset.forName("UTF-8");

    /* renamed from: f */
    public static final Charset f4565f = Charset.forName("ISO-8859-1");

    /* renamed from: g */
    public static final TimeZone f4566g = TimeZone.getTimeZone("GMT");

    /* renamed from: h */
    public static final Comparator<String> f4567h = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    /* renamed from: i */
    private static final C1677f f4568i = C1677f.m6989c("efbbbf");

    /* renamed from: j */
    private static final C1677f f4569j = C1677f.m6989c("feff");

    /* renamed from: k */
    private static final C1677f f4570k = C1677f.m6989c("fffe");

    /* renamed from: l */
    private static final C1677f f4571l = C1677f.m6989c("0000ffff");

    /* renamed from: m */
    private static final C1677f f4572m = C1677f.m6989c("ffff0000");

    /* renamed from: n */
    private static final Charset f4573n = Charset.forName("UTF-16BE");

    /* renamed from: o */
    private static final Charset f4574o = Charset.forName("UTF-16LE");

    /* renamed from: p */
    private static final Charset f4575p = Charset.forName("UTF-32BE");

    /* renamed from: q */
    private static final Charset f4576q = Charset.forName("UTF-32LE");

    /* renamed from: r */
    private static final Pattern f4577r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: a */
    public static int m6067a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 'A') + 10;
    }

    /* renamed from: a */
    public static void m6081a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m6086a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static void m6082a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m6083a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m6085a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m6084a(C1695s sVar, int i, TimeUnit timeUnit) {
        try {
            return m6092b(sVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m6092b(C1695s sVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long d = sVar.mo6186a().mo6917i_() ? sVar.mo6186a().mo6913d() - nanoTime : Long.MAX_VALUE;
        sVar.mo6186a().mo6911a(Math.min(d, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            C1672c cVar = new C1672c();
            while (sVar.mo6185a(cVar, 8192) != -1) {
                cVar.mo6870t();
            }
            if (d == Long.MAX_VALUE) {
                sVar.mo6186a().mo6914f();
            } else {
                sVar.mo6186a().mo6911a(nanoTime + d);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (d == Long.MAX_VALUE) {
                sVar.mo6186a().mo6914f();
            } else {
                sVar.mo6186a().mo6911a(nanoTime + d);
            }
            return false;
        } catch (Throwable th) {
            if (d == Long.MAX_VALUE) {
                sVar.mo6186a().mo6914f();
            } else {
                sVar.mo6186a().mo6911a(nanoTime + d);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static <T> List<T> m6078a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m6079a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m6080a(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* renamed from: a */
    public static String[] m6088a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public static boolean m6093b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String compare : strArr2) {
                if (comparator.compare(str, compare) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m6073a(C1642t tVar, boolean z) {
        String str;
        if (tVar.mo6669f().contains(":")) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(tVar.mo6669f());
            sb.append("]");
            str = sb.toString();
        } else {
            str = tVar.mo6669f();
        }
        if (!z && tVar.mo6670g() == C1642t.m6728a(tVar.mo6661b())) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(":");
        sb2.append(tVar.mo6670g());
        return sb2.toString();
    }

    /* renamed from: a */
    public static boolean m6085a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static int m6071a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m6089a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m6068a(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i++;
                default:
                    return i;
            }
        }
        return i2;
    }

    /* renamed from: b */
    public static int m6091b(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static String m6094c(String str, int i, int i2) {
        int a = m6068a(str, i, i2);
        return str.substring(a, m6091b(str, a, i2));
    }

    /* renamed from: a */
    public static int m6070a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m6069a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m6074a(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = m6096d(str, 0, str.length());
            } else {
                inetAddress = m6096d(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return m6076a(address);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid IPv6 address: '");
            sb.append(str);
            sb.append("'");
            throw new AssertionError(sb.toString());
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !m6097d(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static boolean m6097d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m6090b(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static boolean m6095c(String str) {
        return f4577r.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m6075a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m6077a(C1676e eVar, Charset charset) throws IOException {
        if (eVar.mo6820a(0, f4568i)) {
            eVar.mo6850h((long) f4568i.mo6902h());
            return f4564e;
        } else if (eVar.mo6820a(0, f4569j)) {
            eVar.mo6850h((long) f4569j.mo6902h());
            return f4573n;
        } else if (eVar.mo6820a(0, f4570k)) {
            eVar.mo6850h((long) f4570k.mo6902h());
            return f4574o;
        } else if (eVar.mo6820a(0, f4571l)) {
            eVar.mo6850h((long) f4571l.mo6902h());
            return f4575p;
        } else if (!eVar.mo6820a(0, f4572m)) {
            return charset;
        } else {
            eVar.mo6850h((long) f4572m.mo6902h());
            return f4576q;
        }
    }

    /* renamed from: a */
    public static AssertionError m6072a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* renamed from: d */
    private static InetAddress m6096d(String str, int i, int i2) {
        byte[] bArr = new byte[16];
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            if (i >= i2) {
                break;
            } else if (i3 == bArr.length) {
                return null;
            } else {
                int i6 = i + 2;
                if (i6 > i2 || !str.regionMatches(i, "::", 0, 2)) {
                    if (i3 != 0) {
                        if (str.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else if (!str.regionMatches(i, ".", 0, 1) || !m6087a(str, i5, i2, bArr, i3 - 2)) {
                            return null;
                        } else {
                            i3 += 2;
                        }
                    }
                    i5 = i;
                } else if (i4 != -1) {
                    return null;
                } else {
                    i3 += 2;
                    if (i6 == i2) {
                        i4 = i3;
                        break;
                    }
                    i4 = i3;
                    i5 = i6;
                }
                i = i5;
                int i7 = 0;
                while (i < i2) {
                    int a = m6067a(str.charAt(i));
                    if (a == -1) {
                        break;
                    }
                    i7 = (i7 << 4) + a;
                    i++;
                }
                int i8 = i - i5;
                if (i8 == 0 || i8 > 4) {
                    return null;
                }
                int i9 = i3 + 1;
                bArr[i3] = (byte) ((i7 >>> 8) & 255);
                i3 = i9 + 1;
                bArr[i9] = (byte) (i7 & 255);
            }
        }
        if (i3 != bArr.length) {
            if (i4 == -1) {
                return null;
            }
            int i10 = i3 - i4;
            System.arraycopy(bArr, i4, bArr, bArr.length - i10, i10);
            Arrays.fill(bArr, i4, (bArr.length - i3) + i4, 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private static boolean m6087a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if (i6 == 0 && i != i5) {
                    return false;
                } else {
                    i6 = ((i6 * 10) + charAt) - 48;
                    if (i6 > 255) {
                        return false;
                    }
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            int i7 = i4 + 1;
            bArr[i4] = (byte) i6;
            i4 = i7;
            i = i5;
        }
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static String m6076a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (i2 < bArr.length) {
            int i5 = i2;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i2;
            if (i6 > i3 && i6 >= 4) {
                i4 = i2;
                i3 = i6;
            }
            i2 = i5 + 2;
        }
        C1672c cVar = new C1672c();
        while (i < bArr.length) {
            if (i == i4) {
                cVar.mo6854i(58);
                i += i3;
                if (i == 16) {
                    cVar.mo6854i(58);
                }
            } else {
                if (i > 0) {
                    cVar.mo6854i(58);
                }
                cVar.mo6859k((long) (((bArr[i] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i + 1] & UnsignedBytes.MAX_VALUE)));
                i += 2;
            }
        }
        return cVar.mo6866q();
    }
}
