package p091b;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p091b.p092a.C1508c;
import p091b.p092a.p095c.C1515d;

/* renamed from: b.l */
/* compiled from: Cookie */
public final class C1627l {

    /* renamed from: a */
    private static final Pattern f5121a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b */
    private static final Pattern f5122b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c */
    private static final Pattern f5123c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d */
    private static final Pattern f5124d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e */
    private final String f5125e;

    /* renamed from: f */
    private final String f5126f;

    /* renamed from: g */
    private final long f5127g;

    /* renamed from: h */
    private final String f5128h;

    /* renamed from: i */
    private final String f5129i;

    /* renamed from: j */
    private final boolean f5130j;

    /* renamed from: k */
    private final boolean f5131k;

    /* renamed from: l */
    private final boolean f5132l;

    /* renamed from: m */
    private final boolean f5133m;

    private C1627l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5125e = str;
        this.f5126f = str2;
        this.f5127g = j;
        this.f5128h = str3;
        this.f5129i = str4;
        this.f5130j = z;
        this.f5131k = z2;
        this.f5133m = z3;
        this.f5132l = z4;
    }

    /* renamed from: a */
    public String mo6594a() {
        return this.f5125e;
    }

    /* renamed from: b */
    public String mo6596b() {
        return this.f5126f;
    }

    /* renamed from: a */
    private static boolean m6652a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || C1508c.m6095c(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static C1627l m6650a(C1642t tVar, String str) {
        return m6649a(System.currentTimeMillis(), tVar, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static p091b.C1627l m6649a(long r25, p091b.C1642t r27, java.lang.String r28) {
        /*
            r2 = r28
            int r3 = r28.length()
            r4 = 59
            r5 = 0
            int r6 = p091b.p092a.C1508c.m6069a(r2, r5, r3, r4)
            r7 = 61
            int r8 = p091b.p092a.C1508c.m6069a(r2, r5, r6, r7)
            r9 = 0
            if (r8 != r6) goto L_0x0017
            return r9
        L_0x0017:
            java.lang.String r11 = p091b.p092a.C1508c.m6094c(r2, r5, r8)
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L_0x014e
            int r10 = p091b.p092a.C1508c.m6090b(r11)
            r12 = -1
            if (r10 == r12) goto L_0x002a
            goto L_0x014e
        L_0x002a:
            r10 = 1
            int r8 = r8 + r10
            java.lang.String r8 = p091b.p092a.C1508c.m6094c(r2, r8, r6)
            int r13 = p091b.p092a.C1508c.m6090b(r8)
            if (r13 == r12) goto L_0x0037
            return r9
        L_0x0037:
            int r6 = r6 + r10
            r12 = -1
            r14 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r10 = r9
            r21 = r10
            r16 = r12
            r22 = r14
            r18 = 0
            r19 = 0
            r20 = 1
            r24 = 0
        L_0x004e:
            if (r6 >= r3) goto L_0x00c3
            int r9 = p091b.p092a.C1508c.m6069a(r2, r6, r3, r4)
            int r4 = p091b.p092a.C1508c.m6069a(r2, r6, r9, r7)
            java.lang.String r6 = p091b.p092a.C1508c.m6094c(r2, r6, r4)
            if (r4 >= r9) goto L_0x0065
            int r4 = r4 + 1
            java.lang.String r4 = p091b.p092a.C1508c.m6094c(r2, r4, r9)
            goto L_0x0067
        L_0x0065:
            java.lang.String r4 = ""
        L_0x0067:
            java.lang.String r7 = "expires"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x007c
            int r6 = r4.length()     // Catch:{ IllegalArgumentException -> 0x00bb }
            long r6 = m6648a(r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x00bb }
            r22 = r6
        L_0x0079:
            r24 = 1
            goto L_0x00bb
        L_0x007c:
            java.lang.String r7 = "max-age"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x008b
            long r6 = m6647a(r4)     // Catch:{  }
            r16 = r6
            goto L_0x0079
        L_0x008b:
            java.lang.String r7 = "domain"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x009b
            java.lang.String r4 = m6653b(r4)     // Catch:{ IllegalArgumentException -> 0x00bb }
            r10 = r4
            r20 = 0
            goto L_0x00bb
        L_0x009b:
            java.lang.String r7 = "path"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00a6
            r21 = r4
            goto L_0x00bb
        L_0x00a6:
            java.lang.String r4 = "secure"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00b1
            r18 = 1
            goto L_0x00bb
        L_0x00b1:
            java.lang.String r4 = "httponly"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00bb
            r19 = 1
        L_0x00bb:
            int r6 = r9 + 1
            r4 = 59
            r7 = 61
            r9 = 0
            goto L_0x004e
        L_0x00c3:
            r2 = -9223372036854775808
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00cb
        L_0x00c9:
            r13 = r2
            goto L_0x00f1
        L_0x00cb:
            int r2 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x00ef
            r2 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x00dd
            r2 = 1000(0x3e8, double:4.94E-321)
            long r16 = r16 * r2
            goto L_0x00e2
        L_0x00dd:
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00e2:
            r2 = 0
            long r2 = r25 + r16
            int r0 = (r2 > r25 ? 1 : (r2 == r25 ? 0 : -1))
            if (r0 < 0) goto L_0x00ed
            int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c9
        L_0x00ed:
            r13 = r14
            goto L_0x00f1
        L_0x00ef:
            r13 = r22
        L_0x00f1:
            java.lang.String r0 = r27.mo6669f()
            if (r10 != 0) goto L_0x00fa
            r15 = r0
            r1 = 0
            goto L_0x0104
        L_0x00fa:
            boolean r1 = m6652a(r0, r10)
            if (r1 != 0) goto L_0x0102
            r1 = 0
            return r1
        L_0x0102:
            r1 = 0
            r15 = r10
        L_0x0104:
            int r0 = r0.length()
            int r2 = r15.length()
            if (r0 == r2) goto L_0x0119
            b.a.h.a r0 = p091b.p092a.p100h.C1584a.m6457a()
            java.lang.String r0 = r0.mo6446a(r15)
            if (r0 != 0) goto L_0x0119
            return r1
        L_0x0119:
            r9 = r21
            if (r9 == 0) goto L_0x0129
            java.lang.String r0 = "/"
            boolean r0 = r9.startsWith(r0)
            if (r0 != 0) goto L_0x0126
            goto L_0x0129
        L_0x0126:
            r16 = r9
            goto L_0x013e
        L_0x0129:
            java.lang.String r0 = r27.mo6671h()
            r1 = 47
            int r1 = r0.lastIndexOf(r1)
            if (r1 == 0) goto L_0x013a
            java.lang.String r0 = r0.substring(r5, r1)
            goto L_0x013c
        L_0x013a:
            java.lang.String r0 = "/"
        L_0x013c:
            r16 = r0
        L_0x013e:
            b.l r0 = new b.l
            r10 = r0
            r12 = r8
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r24
            r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x014e:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.C1627l.m6649a(long, b.t, java.lang.String):b.l");
    }

    /* renamed from: a */
    private static long m6648a(String str, int i, int i2) {
        int a = m6646a(str, i, i2, false);
        Matcher matcher = f5124d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = m6646a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i3 == -1 && matcher.usePattern(f5124d).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = parseInt2;
                i3 = parseInt;
            } else if (i5 == -1 && matcher.usePattern(f5123c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f5122b).matches()) {
                i6 = f5122b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f5121a).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a = m6646a(str, a2 + 1, i2, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(C1508c.f4566g);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private static int m6646a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static long m6647a(String str) {
        long j = Long.MIN_VALUE;
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                j = parseLong;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (!str.startsWith("-")) {
                    j = Long.MAX_VALUE;
                }
                return j;
            }
            throw e;
        }
    }

    /* renamed from: b */
    private static String m6653b(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a = C1508c.m6074a(str);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<C1627l> m6651a(C1642t tVar, C1640s sVar) {
        List b = sVar.mo6648b(HttpHeaders.SET_COOKIE);
        int size = b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            C1627l a = m6650a(tVar, (String) b.get(i));
            if (a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return mo6595a(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo6595a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5125e);
        sb.append('=');
        sb.append(this.f5126f);
        if (this.f5132l) {
            if (this.f5127g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(C1515d.m6110a(new Date(this.f5127g)));
            }
        }
        if (!this.f5133m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f5128h);
        }
        sb.append("; path=");
        sb.append(this.f5129i);
        if (this.f5130j) {
            sb.append("; secure");
        }
        if (this.f5131k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C1627l)) {
            return false;
        }
        C1627l lVar = (C1627l) obj;
        if (lVar.f5125e.equals(this.f5125e) && lVar.f5126f.equals(this.f5126f) && lVar.f5128h.equals(this.f5128h) && lVar.f5129i.equals(this.f5129i) && lVar.f5127g == this.f5127g && lVar.f5130j == this.f5130j && lVar.f5131k == this.f5131k && lVar.f5132l == this.f5132l && lVar.f5133m == this.f5133m) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f5125e.hashCode()) * 31) + this.f5126f.hashCode()) * 31) + this.f5128h.hashCode()) * 31) + this.f5129i.hashCode()) * 31) + ((int) (this.f5127g ^ (this.f5127g >>> 32)))) * 31) + (this.f5130j ^ true ? 1 : 0)) * 31) + (this.f5131k ^ true ? 1 : 0)) * 31) + (this.f5132l ^ true ? 1 : 0)) * 31) + (this.f5133m ^ true ? 1 : 0);
    }
}
