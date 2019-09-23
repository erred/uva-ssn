package p091b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p091b.p092a.C1508c;

/* renamed from: b.s */
/* compiled from: Headers */
public final class C1640s {

    /* renamed from: a */
    private final String[] f5155a;

    /* renamed from: b.s$a */
    /* compiled from: Headers */
    public static final class C1641a {

        /* renamed from: a */
        final List<String> f5156a = new ArrayList(20);

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1641a mo6652a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return mo6656b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return mo6656b("", str.substring(1));
            }
            return mo6656b("", str);
        }

        /* renamed from: a */
        public C1641a mo6653a(String str, String str2) {
            m6720d(str, str2);
            return mo6656b(str, str2);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1641a mo6656b(String str, String str2) {
            this.f5156a.add(str);
            this.f5156a.add(str2.trim());
            return this;
        }

        /* renamed from: b */
        public C1641a mo6655b(String str) {
            int i = 0;
            while (i < this.f5156a.size()) {
                if (str.equalsIgnoreCase((String) this.f5156a.get(i))) {
                    this.f5156a.remove(i);
                    this.f5156a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public C1641a mo6657c(String str, String str2) {
            m6720d(str, str2);
            mo6655b(str);
            mo6656b(str, str2);
            return this;
        }

        /* renamed from: d */
        private void m6720d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(C1508c.m6075a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    int i2 = 0;
                    while (i2 < length2) {
                        char charAt2 = str2.charAt(i2);
                        if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                            i2++;
                        } else {
                            throw new IllegalArgumentException(C1508c.m6075a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                        }
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("value for name ");
                sb.append(str);
                sb.append(" == null");
                throw new NullPointerException(sb.toString());
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        /* renamed from: c */
        public String mo6658c(String str) {
            for (int size = this.f5156a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f5156a.get(size))) {
                    return (String) this.f5156a.get(size + 1);
                }
            }
            return null;
        }

        /* renamed from: a */
        public C1640s mo6654a() {
            return new C1640s(this);
        }
    }

    C1640s(C1641a aVar) {
        this.f5155a = (String[]) aVar.f5156a.toArray(new String[aVar.f5156a.size()]);
    }

    private C1640s(String[] strArr) {
        this.f5155a = strArr;
    }

    /* renamed from: a */
    public String mo6645a(String str) {
        return m6713a(this.f5155a, str);
    }

    /* renamed from: a */
    public int mo6643a() {
        return this.f5155a.length / 2;
    }

    /* renamed from: a */
    public String mo6644a(int i) {
        return this.f5155a[i * 2];
    }

    /* renamed from: b */
    public String mo6647b(int i) {
        return this.f5155a[(i * 2) + 1];
    }

    /* renamed from: b */
    public List<String> mo6648b(String str) {
        int a = mo6643a();
        ArrayList arrayList = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(mo6644a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(mo6647b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    public C1641a mo6646b() {
        C1641a aVar = new C1641a();
        Collections.addAll(aVar.f5156a, this.f5155a);
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1640s) && Arrays.equals(((C1640s) obj).f5155a, this.f5155a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5155a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a = mo6643a();
        for (int i = 0; i < a; i++) {
            sb.append(mo6644a(i));
            sb.append(": ");
            sb.append(mo6647b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m6713a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C1640s m6712a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i = 0;
            while (i < strArr2.length) {
                if (strArr2[i] != null) {
                    strArr2[i] = strArr2[i].trim();
                    i++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            int i2 = 0;
            while (i2 < strArr2.length) {
                String str = strArr2[i2];
                String str2 = strArr2[i2 + 1];
                if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                    i2 += 2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected header: ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            return new C1640s(strArr2);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }
}
