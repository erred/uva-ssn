package p000a.p001a.p002a.p003a.p004a.p010e;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: a.a.a.a.a.e.f */
/* compiled from: NetworkUtils */
public final class C0099f {
    /* renamed from: a */
    public static final SSLSocketFactory m354a(C0100g gVar) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{new C0101h(new C0102i(gVar.mo234a(), gVar.mo235b()), gVar)}, null);
        return instance.getSocketFactory();
    }
}
