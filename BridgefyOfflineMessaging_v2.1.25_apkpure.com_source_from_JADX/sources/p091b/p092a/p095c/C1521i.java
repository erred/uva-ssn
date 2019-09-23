package p091b.p092a.p095c;

import java.net.Proxy.Type;
import p091b.C1590aa;
import p091b.C1642t;

/* renamed from: b.a.c.i */
/* compiled from: RequestLine */
public final class C1521i {
    /* renamed from: a */
    public static String m6147a(C1590aa aaVar, Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(aaVar.mo6456b());
        sb.append(' ');
        if (m6149b(aaVar, type)) {
            sb.append(aaVar.mo6454a());
        } else {
            sb.append(m6148a(aaVar.mo6454a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m6149b(C1590aa aaVar, Type type) {
        return !aaVar.mo6462g() && type == Type.HTTP;
    }

    /* renamed from: a */
    public static String m6148a(C1642t tVar) {
        String h = tVar.mo6671h();
        String k = tVar.mo6675k();
        if (k == null) {
            return h;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(h);
        sb.append('?');
        sb.append(k);
        return sb.toString();
    }
}
