package p091b.p092a.p095c;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1627l;
import p091b.C1628m;
import p091b.C1640s;
import p091b.C1640s.C1641a;
import p091b.C1642t;
import p091b.p092a.C1508c;

/* renamed from: b.a.c.e */
/* compiled from: HttpHeaders */
public final class C1517e {

    /* renamed from: a */
    private static final Pattern f4586a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* renamed from: a */
    public static long m6115a(C1596ac acVar) {
        return m6116a(acVar.mo6486g());
    }

    /* renamed from: a */
    public static long m6116a(C1640s sVar) {
        return m6117a(sVar.mo6645a(HttpHeaders.CONTENT_LENGTH));
    }

    /* renamed from: a */
    private static long m6117a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static boolean m6120a(C1596ac acVar, C1640s sVar, C1590aa aaVar) {
        for (String str : m6127e(acVar)) {
            if (!C1508c.m6086a((Object) sVar.mo6648b(str), (Object) aaVar.mo6457b(str))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m6122b(C1596ac acVar) {
        return m6123b(acVar.mo6486g());
    }

    /* renamed from: b */
    public static boolean m6123b(C1640s sVar) {
        return m6125c(sVar).contains("*");
    }

    /* renamed from: e */
    private static Set<String> m6127e(C1596ac acVar) {
        return m6125c(acVar.mo6486g());
    }

    /* renamed from: c */
    public static Set<String> m6125c(C1640s sVar) {
        Set emptySet = Collections.emptySet();
        int a = sVar.mo6643a();
        Set set = emptySet;
        for (int i = 0; i < a; i++) {
            if (HttpHeaders.VARY.equalsIgnoreCase(sVar.mo6644a(i))) {
                String b = sVar.mo6647b(i);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    /* renamed from: c */
    public static C1640s m6124c(C1596ac acVar) {
        return m6118a(acVar.mo6489j().mo6477a().mo6458c(), acVar.mo6486g());
    }

    /* renamed from: a */
    public static C1640s m6118a(C1640s sVar, C1640s sVar2) {
        Set c = m6125c(sVar2);
        if (c.isEmpty()) {
            return new C1641a().mo6654a();
        }
        C1641a aVar = new C1641a();
        int a = sVar.mo6643a();
        for (int i = 0; i < a; i++) {
            String a2 = sVar.mo6644a(i);
            if (c.contains(a2)) {
                aVar.mo6653a(a2, sVar.mo6647b(i));
            }
        }
        return aVar.mo6654a();
    }

    /* renamed from: a */
    public static void m6119a(C1628m mVar, C1642t tVar, C1640s sVar) {
        if (mVar != C1628m.f5134a) {
            List a = C1627l.m6651a(tVar, sVar);
            if (!a.isEmpty()) {
                mVar.mo6601a(tVar, a);
            }
        }
    }

    /* renamed from: d */
    public static boolean m6126d(C1596ac acVar) {
        if (acVar.mo6477a().mo6456b().equals(HttpMethods.HEAD)) {
            return false;
        }
        int c = acVar.mo6481c();
        if (((c >= 100 && c < 200) || c == 204 || c == 304) && m6115a(acVar) == -1 && !"chunked".equalsIgnoreCase(acVar.mo6478a(HttpHeaders.TRANSFER_ENCODING))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static int m6114a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m6113a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != 9) {
                break;
            }
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m6121b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
