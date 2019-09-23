package p000a.p001a.p002a.p003a.p004a.p010e;

import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p000a.p001a.p002a.p003a.C0134b;
import p000a.p001a.p002a.p003a.C0149l;

/* renamed from: a.a.a.a.a.e.b */
/* compiled from: DefaultHttpRequestFactory */
public class C0087b implements C0098e {

    /* renamed from: a */
    private final C0149l f175a;

    /* renamed from: b */
    private C0100g f176b;

    /* renamed from: c */
    private SSLSocketFactory f177c;

    /* renamed from: d */
    private boolean f178d;

    public C0087b() {
        this(new C0134b());
    }

    public C0087b(C0149l lVar) {
        this.f175a = lVar;
    }

    /* renamed from: a */
    public void mo184a(C0100g gVar) {
        if (this.f176b != gVar) {
            this.f176b = gVar;
            m281a();
        }
    }

    /* renamed from: a */
    private synchronized void m281a() {
        this.f178d = false;
        this.f177c = null;
    }

    /* renamed from: a */
    public C0090d mo183a(C0089c cVar, String str, Map<String, String> map) {
        C0090d dVar;
        switch (cVar) {
            case GET:
                dVar = C0090d.m288a((CharSequence) str, map, true);
                break;
            case POST:
                dVar = C0090d.m293b((CharSequence) str, map, true);
                break;
            case PUT:
                dVar = C0090d.m296d((CharSequence) str);
                break;
            case DELETE:
                dVar = C0090d.m297e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m282a(str) && this.f176b != null) {
            SSLSocketFactory b = m283b();
            if (b != null) {
                ((HttpsURLConnection) dVar.mo198a()).setSSLSocketFactory(b);
            }
        }
        return dVar;
    }

    /* renamed from: a */
    private boolean m282a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    /* renamed from: b */
    private synchronized SSLSocketFactory m283b() {
        if (this.f177c == null && !this.f178d) {
            this.f177c = m284c();
        }
        return this.f177c;
    }

    /* renamed from: c */
    private synchronized SSLSocketFactory m284c() {
        SSLSocketFactory a;
        this.f178d = true;
        try {
            a = C0099f.m354a(this.f176b);
            this.f175a.mo270a("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.f175a.mo280e("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return a;
    }
}
