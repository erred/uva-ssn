package p091b.p092a.p101i;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import p091b.p092a.C1508c;

/* renamed from: b.a.i.d */
/* compiled from: OkHostnameVerifier */
public final class C1588d implements HostnameVerifier {

    /* renamed from: a */
    public static final C1588d f4856a = new C1588d();

    private C1588d() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return mo6452a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo6452a(String str, X509Certificate x509Certificate) {
        if (C1508c.m6095c(str)) {
            return m6470b(str, x509Certificate);
        }
        return m6471c(str, x509Certificate);
    }

    /* renamed from: b */
    private boolean m6470b(String str, X509Certificate x509Certificate) {
        List a = m6469a(x509Certificate, 7);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m6471c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        for (String a : m6469a(x509Certificate, 2)) {
            if (mo6451a(lowerCase, a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static List<String> m6468a(X509Certificate x509Certificate) {
        List a = m6469a(x509Certificate, 7);
        List a2 = m6469a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m6469a(X509Certificate x509Certificate, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null) {
                    if (list.size() >= 2) {
                        Integer num = (Integer) list.get(0);
                        if (num != null) {
                            if (num.intValue() == i) {
                                String str = (String) list.get(1);
                                if (str != null) {
                                    arrayList.add(str);
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public boolean mo6451a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('.');
            str = sb.toString();
        }
        if (!str2.endsWith(".")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append('.');
            str2 = sb2.toString();
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains("*")) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String substring = lowerCase.substring(1);
        if (!str.endsWith(substring)) {
            return false;
        }
        int length = str.length() - substring.length();
        if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
            return true;
        }
        return false;
    }
}
