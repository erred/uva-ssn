package p091b;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p091b.p092a.C1508c;
import p102c.C1672c;

/* renamed from: b.t */
/* compiled from: HttpUrl */
public final class C1642t {

    /* renamed from: d */
    private static final char[] f5157d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    final String f5158a;

    /* renamed from: b */
    final String f5159b;

    /* renamed from: c */
    final int f5160c;

    /* renamed from: e */
    private final String f5161e;

    /* renamed from: f */
    private final String f5162f;

    /* renamed from: g */
    private final List<String> f5163g;

    /* renamed from: h */
    private final List<String> f5164h;

    /* renamed from: i */
    private final String f5165i;

    /* renamed from: j */
    private final String f5166j;

    /* renamed from: b.t$a */
    /* compiled from: HttpUrl */
    public static final class C1643a {

        /* renamed from: a */
        String f5167a;

        /* renamed from: b */
        String f5168b = "";

        /* renamed from: c */
        String f5169c = "";

        /* renamed from: d */
        String f5170d;

        /* renamed from: e */
        int f5171e = -1;

        /* renamed from: f */
        final List<String> f5172f = new ArrayList();

        /* renamed from: g */
        List<String> f5173g;

        /* renamed from: h */
        String f5174h;

        /* renamed from: b.t$a$a */
        /* compiled from: HttpUrl */
        enum C1644a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C1643a() {
            this.f5172f.add("");
        }

        /* renamed from: a */
        public C1643a mo6685a(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f5167a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f5167a = "https";
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unexpected scheme: ");
                    sb.append(str);
                    throw new IllegalArgumentException(sb.toString());
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        /* renamed from: b */
        public C1643a mo6688b(String str) {
            if (str != null) {
                this.f5168b = C1642t.m6731a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        /* renamed from: c */
        public C1643a mo6690c(String str) {
            if (str != null) {
                this.f5169c = C1642t.m6731a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        /* renamed from: d */
        public C1643a mo6692d(String str) {
            if (str != null) {
                String e = m6768e(str, 0, str.length());
                if (e != null) {
                    this.f5170d = e;
                    return this;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected host: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new NullPointerException("host == null");
        }

        /* renamed from: a */
        public C1643a mo6684a(int i) {
            if (i <= 0 || i > 65535) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected port: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f5171e = i;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo6682a() {
            return this.f5171e != -1 ? this.f5171e : C1642t.m6728a(this.f5167a);
        }

        /* renamed from: e */
        public C1643a mo6693e(String str) {
            List<String> list;
            if (str != null) {
                list = C1642t.m6739b(C1642t.m6731a(str, " \"'<>#", false, false, true, true));
            } else {
                list = null;
            }
            this.f5173g = list;
            return this;
        }

        /* renamed from: f */
        public C1643a mo6694f(String str) {
            List<String> list;
            if (str != null) {
                list = C1642t.m6739b(C1642t.m6731a(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.f5173g = list;
            return this;
        }

        /* renamed from: a */
        public C1643a mo6686a(String str, String str2) {
            String str3;
            if (str != null) {
                if (this.f5173g == null) {
                    this.f5173g = new ArrayList();
                }
                this.f5173g.add(C1642t.m6731a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                List<String> list = this.f5173g;
                if (str2 != null) {
                    str3 = C1642t.m6731a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        /* renamed from: b */
        public C1643a mo6689b(String str, String str2) {
            String str3;
            if (str != null) {
                if (this.f5173g == null) {
                    this.f5173g = new ArrayList();
                }
                this.f5173g.add(C1642t.m6731a(str, " \"'<>#&=", true, false, true, true));
                List<String> list = this.f5173g;
                if (str2 != null) {
                    str3 = C1642t.m6731a(str2, " \"'<>#&=", true, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1643a mo6687b() {
            int size = this.f5172f.size();
            for (int i = 0; i < size; i++) {
                this.f5172f.set(i, C1642t.m6731a((String) this.f5172f.get(i), "[]", true, true, false, true));
            }
            if (this.f5173g != null) {
                int size2 = this.f5173g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) this.f5173g.get(i2);
                    if (str != null) {
                        this.f5173g.set(i2, C1642t.m6731a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.f5174h != null) {
                this.f5174h = C1642t.m6731a(this.f5174h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: c */
        public C1642t mo6691c() {
            if (this.f5167a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f5170d != null) {
                return new C1642t(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5167a);
            sb.append("://");
            if (!this.f5168b.isEmpty() || !this.f5169c.isEmpty()) {
                sb.append(this.f5168b);
                if (!this.f5169c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5169c);
                }
                sb.append('@');
            }
            if (this.f5170d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f5170d);
                sb.append(']');
            } else {
                sb.append(this.f5170d);
            }
            int a = mo6682a();
            if (a != C1642t.m6728a(this.f5167a)) {
                sb.append(':');
                sb.append(a);
            }
            C1642t.m6737a(sb, this.f5172f);
            if (this.f5173g != null) {
                sb.append('?');
                C1642t.m6740b(sb, this.f5173g);
            }
            if (this.f5174h != null) {
                sb.append('#');
                sb.append(this.f5174h);
            }
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1644a mo6683a(C1642t tVar, String str) {
            int i;
            int a;
            int i2;
            C1642t tVar2 = tVar;
            String str2 = str;
            int a2 = C1508c.m6068a(str2, 0, str.length());
            int b = C1508c.m6091b(str2, a2, str.length());
            if (m6764b(str2, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.f5167a = "https";
                    a2 += "https:".length();
                } else {
                    if (!str.regionMatches(true, a2, "http:", 0, 5)) {
                        return C1644a.UNSUPPORTED_SCHEME;
                    }
                    this.f5167a = "http";
                    a2 += "http:".length();
                }
            } else if (tVar2 == null) {
                return C1644a.MISSING_SCHEME;
            } else {
                this.f5167a = tVar2.f5158a;
            }
            int c = m6765c(str2, a2, b);
            char c2 = '#';
            if (c >= 2 || tVar2 == null || !tVar2.f5158a.equals(this.f5167a)) {
                int i3 = a2 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = C1508c.m6070a(str2, i3, b, "@/\\?#");
                    char charAt = a != b ? str2.charAt(a) : 65535;
                    if (!(charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\')) {
                        switch (charAt) {
                            case '?':
                                break;
                            case '@':
                                if (!z) {
                                    int a3 = C1508c.m6069a(str2, i3, a, ':');
                                    int i4 = a3;
                                    i2 = a;
                                    String a4 = C1642t.m6729a(str, i3, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    if (z2) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(this.f5168b);
                                        sb.append("%40");
                                        sb.append(a4);
                                        a4 = sb.toString();
                                    }
                                    this.f5168b = a4;
                                    if (i4 != i2) {
                                        this.f5169c = C1642t.m6729a(str, i4 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                        z = true;
                                    }
                                    z2 = true;
                                } else {
                                    i2 = a;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(this.f5169c);
                                    sb2.append("%40");
                                    sb2.append(C1642t.m6729a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                                    this.f5169c = sb2.toString();
                                }
                                i3 = i2 + 1;
                                continue;
                        }
                    }
                    c2 = '#';
                }
                i = a;
                int d = m6766d(str2, i3, i);
                int i5 = d + 1;
                if (i5 < i) {
                    this.f5170d = m6768e(str2, i3, d);
                    this.f5171e = m6769f(str2, i5, i);
                    if (this.f5171e == -1) {
                        return C1644a.INVALID_PORT;
                    }
                } else {
                    this.f5170d = m6768e(str2, i3, d);
                    this.f5171e = C1642t.m6728a(this.f5167a);
                }
                if (this.f5170d == null) {
                    return C1644a.INVALID_HOST;
                }
            } else {
                this.f5168b = tVar.mo6666d();
                this.f5169c = tVar.mo6667e();
                this.f5170d = tVar2.f5159b;
                this.f5171e = tVar2.f5160c;
                this.f5172f.clear();
                this.f5172f.addAll(tVar.mo6673i());
                if (a2 == b || str2.charAt(a2) == '#') {
                    mo6694f(tVar.mo6675k());
                }
                i = a2;
            }
            int a5 = C1508c.m6070a(str2, i, b, "?#");
            m6762a(str2, i, a5);
            if (a5 < b && str2.charAt(a5) == '?') {
                int a6 = C1508c.m6069a(str2, a5, b, '#');
                this.f5173g = C1642t.m6739b(C1642t.m6729a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < b && str2.charAt(a5) == '#') {
                this.f5174h = C1642t.m6729a(str, 1 + a5, b, "", true, false, false, false, null);
            }
            return C1644a.SUCCESS;
        }

        /* renamed from: a */
        private void m6762a(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f5172f.clear();
                    this.f5172f.add("");
                    i++;
                } else {
                    this.f5172f.set(this.f5172f.size() - 1, "");
                }
                while (true) {
                    int i3 = r11;
                    if (i3 < i2) {
                        r11 = C1508c.m6070a(str, i3, i2, "/\\");
                        boolean z = r11 < i2;
                        m6763a(str, i3, r11, z, true);
                        if (z) {
                            r11++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        private void m6763a(String str, int i, int i2, boolean z, boolean z2) {
            String a = C1642t.m6729a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!m6770g(a)) {
                if (m6771h(a)) {
                    m6767d();
                    return;
                }
                if (((String) this.f5172f.get(this.f5172f.size() - 1)).isEmpty()) {
                    this.f5172f.set(this.f5172f.size() - 1, a);
                } else {
                    this.f5172f.add(a);
                }
                if (z) {
                    this.f5172f.add("");
                }
            }
        }

        /* renamed from: g */
        private boolean m6770g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: h */
        private boolean m6771h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: d */
        private void m6767d() {
            if (!((String) this.f5172f.remove(this.f5172f.size() - 1)).isEmpty() || this.f5172f.isEmpty()) {
                this.f5172f.add("");
            } else {
                this.f5172f.set(this.f5172f.size() - 1, "");
            }
        }

        /* renamed from: b */
        private static int m6764b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                char charAt2 = str.charAt(i);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    if (charAt2 == ':') {
                        return i;
                    }
                    return -1;
                }
            }
        }

        /* renamed from: c */
        private static int m6765c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: d */
        private static int m6766d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: e */
        private static String m6768e(String str, int i, int i2) {
            return C1508c.m6074a(C1642t.m6730a(str, i, i2, false));
        }

        /* renamed from: f */
        private static int m6769f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(C1642t.m6729a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
    }

    C1642t(C1643a aVar) {
        this.f5158a = aVar.f5167a;
        this.f5161e = m6733a(aVar.f5168b, false);
        this.f5162f = m6733a(aVar.f5169c, false);
        this.f5159b = aVar.f5170d;
        this.f5160c = aVar.mo6682a();
        this.f5163g = m6734a(aVar.f5172f, false);
        String str = null;
        this.f5164h = aVar.f5173g != null ? m6734a(aVar.f5173g, true) : null;
        if (aVar.f5174h != null) {
            str = m6733a(aVar.f5174h, false);
        }
        this.f5165i = str;
        this.f5166j = aVar.toString();
    }

    /* renamed from: a */
    public URI mo6660a() {
        String aVar = mo6680p().mo6687b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b */
    public String mo6661b() {
        return this.f5158a;
    }

    /* renamed from: c */
    public boolean mo6664c() {
        return this.f5158a.equals("https");
    }

    /* renamed from: d */
    public String mo6666d() {
        if (this.f5161e.isEmpty()) {
            return "";
        }
        int length = this.f5158a.length() + 3;
        return this.f5166j.substring(length, C1508c.m6070a(this.f5166j, length, this.f5166j.length(), ":@"));
    }

    /* renamed from: e */
    public String mo6667e() {
        if (this.f5162f.isEmpty()) {
            return "";
        }
        return this.f5166j.substring(this.f5166j.indexOf(58, this.f5158a.length() + 3) + 1, this.f5166j.indexOf(64));
    }

    /* renamed from: f */
    public String mo6669f() {
        return this.f5159b;
    }

    /* renamed from: g */
    public int mo6670g() {
        return this.f5160c;
    }

    /* renamed from: a */
    public static int m6728a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: h */
    public String mo6671h() {
        int indexOf = this.f5166j.indexOf(47, this.f5158a.length() + 3);
        return this.f5166j.substring(indexOf, C1508c.m6070a(this.f5166j, indexOf, this.f5166j.length(), "?#"));
    }

    /* renamed from: a */
    static void m6737a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append((String) list.get(i));
        }
    }

    /* renamed from: i */
    public List<String> mo6673i() {
        int indexOf = this.f5166j.indexOf(47, this.f5158a.length() + 3);
        int a = C1508c.m6070a(this.f5166j, indexOf, this.f5166j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            int a2 = C1508c.m6069a(this.f5166j, i, a, '/');
            arrayList.add(this.f5166j.substring(i, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    /* renamed from: j */
    public List<String> mo6674j() {
        return this.f5163g;
    }

    /* renamed from: k */
    public String mo6675k() {
        if (this.f5164h == null) {
            return null;
        }
        int indexOf = this.f5166j.indexOf(63) + 1;
        return this.f5166j.substring(indexOf, C1508c.m6069a(this.f5166j, indexOf, this.f5166j.length(), '#'));
    }

    /* renamed from: b */
    static void m6740b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: b */
    static List<String> m6739b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: l */
    public String mo6676l() {
        if (this.f5164h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m6740b(sb, this.f5164h);
        return sb.toString();
    }

    /* renamed from: m */
    public int mo6677m() {
        if (this.f5164h != null) {
            return this.f5164h.size() / 2;
        }
        return 0;
    }

    /* renamed from: a */
    public String mo6659a(int i) {
        if (this.f5164h != null) {
            return (String) this.f5164h.get(i * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: b */
    public String mo6662b(int i) {
        if (this.f5164h != null) {
            return (String) this.f5164h.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: n */
    public String mo6678n() {
        if (this.f5165i == null) {
            return null;
        }
        return this.f5166j.substring(this.f5166j.indexOf(35) + 1);
    }

    /* renamed from: o */
    public String mo6679o() {
        return mo6665d("/...").mo6688b("").mo6690c("").mo6691c().toString();
    }

    /* renamed from: c */
    public C1642t mo6663c(String str) {
        C1643a d = mo6665d(str);
        if (d != null) {
            return d.mo6691c();
        }
        return null;
    }

    /* renamed from: p */
    public C1643a mo6680p() {
        C1643a aVar = new C1643a();
        aVar.f5167a = this.f5158a;
        aVar.f5168b = mo6666d();
        aVar.f5169c = mo6667e();
        aVar.f5170d = this.f5159b;
        aVar.f5171e = this.f5160c != m6728a(this.f5158a) ? this.f5160c : -1;
        aVar.f5172f.clear();
        aVar.f5172f.addAll(mo6673i());
        aVar.mo6694f(mo6675k());
        aVar.f5174h = mo6678n();
        return aVar;
    }

    /* renamed from: d */
    public C1643a mo6665d(String str) {
        C1643a aVar = new C1643a();
        if (aVar.mo6683a(this, str) == C1644a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    /* renamed from: e */
    public static C1642t m6741e(String str) {
        C1643a aVar = new C1643a();
        if (aVar.mo6683a((C1642t) null, str) == C1644a.SUCCESS) {
            return aVar.mo6691c();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1642t) && ((C1642t) obj).f5166j.equals(this.f5166j);
    }

    public int hashCode() {
        return this.f5166j.hashCode();
    }

    public String toString() {
        return this.f5166j;
    }

    /* renamed from: a */
    static String m6733a(String str, boolean z) {
        return m6730a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m6734a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? m6733a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m6730a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                C1672c cVar = new C1672c();
                cVar.mo6814a(str, i, i3);
                m6736a(cVar, str, i3, i2, z);
                return cVar.mo6866q();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m6736a(C1672c cVar, String str, int i, int i2, boolean z) {
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37) {
                int i3 = i + 2;
                if (i3 < i2) {
                    int a = C1508c.m6067a(str.charAt(i + 1));
                    int a2 = C1508c.m6067a(str.charAt(i3));
                    if (!(a == -1 || a2 == -1)) {
                        cVar.mo6854i((a << 4) + a2);
                        i = i3;
                        i += Character.charCount(codePointAt);
                    }
                    cVar.mo6810a(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
            if (codePointAt == 43 && z) {
                cVar.mo6854i(32);
                i += Character.charCount(codePointAt);
            }
            cVar.mo6810a(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m6738a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || C1508c.m6067a(str.charAt(i + 1)) == -1 || C1508c.m6067a(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static String m6729a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m6738a(str, i4, i2)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            C1672c cVar = new C1672c();
            int i5 = i;
            cVar.mo6814a(str, i, i4);
            m6735a(cVar, str, i4, i2, str2, z, z2, z3, z4, charset);
            return cVar.mo6866q();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m6735a(C1672c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        C1672c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.mo6828b(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m6738a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new C1672c();
                    }
                    if (charset == null || charset.equals(C1508c.f4564e)) {
                        cVar2.mo6810a(codePointAt);
                    } else {
                        cVar2.mo6815a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!cVar2.mo6844f()) {
                        byte i3 = cVar2.mo6852i() & UnsignedBytes.MAX_VALUE;
                        cVar.mo6854i(37);
                        cVar.mo6854i((int) f5157d[(i3 >> 4) & 15]);
                        cVar.mo6854i((int) f5157d[i3 & Ascii.f6734SI]);
                    }
                } else {
                    cVar.mo6810a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static String m6732a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return m6729a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    /* renamed from: a */
    static String m6731a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m6729a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
