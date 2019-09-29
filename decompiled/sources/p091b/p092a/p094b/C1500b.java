package p091b.p092a.p094b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import p091b.C1625k;
import p091b.p092a.C1483a;

/* renamed from: b.a.b.b */
/* compiled from: ConnectionSpecSelector */
public final class C1500b {

    /* renamed from: a */
    private final List<C1625k> f4513a;

    /* renamed from: b */
    private int f4514b = 0;

    /* renamed from: c */
    private boolean f4515c;

    /* renamed from: d */
    private boolean f4516d;

    public C1500b(List<C1625k> list) {
        this.f4513a = list;
    }

    /* renamed from: a */
    public C1625k mo6228a(SSLSocket sSLSocket) throws IOException {
        C1625k kVar;
        int i = this.f4514b;
        int size = this.f4513a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = (C1625k) this.f4513a.get(i);
            if (kVar.mo6581a(sSLSocket)) {
                this.f4514b = i + 1;
                break;
            }
            i++;
        }
        if (kVar != null) {
            this.f4515c = m6010b(sSLSocket);
            C1483a.f4446a.mo6178a(kVar, sSLSocket, this.f4516d);
            return kVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f4516d);
        sb.append(", modes=");
        sb.append(this.f4513a);
        sb.append(", supported protocols=");
        sb.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(sb.toString());
    }

    /* renamed from: a */
    public boolean mo6229a(IOException iOException) {
        boolean z = true;
        this.f4516d = true;
        if (!this.f4515c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z2 = iOException instanceof SSLHandshakeException;
        if ((z2 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (!z2 && !(iOException instanceof SSLProtocolException)) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m6010b(SSLSocket sSLSocket) {
        for (int i = this.f4514b; i < this.f4513a.size(); i++) {
            if (((C1625k) this.f4513a.get(i)).mo6581a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
