package p091b.p092a.p094b;

import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.C1651x;
import p091b.p092a.p095c.C1519g;

/* renamed from: b.a.b.a */
/* compiled from: ConnectInterceptor */
public final class C1499a implements C1645u {

    /* renamed from: a */
    public final C1651x f4512a;

    public C1499a(C1651x xVar) {
        this.f4512a = xVar;
    }

    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C1519g gVar = (C1519g) aVar;
        C1590aa a = gVar.mo6279a();
        C1506g f = gVar.mo6286f();
        return gVar.mo6281a(a, f, f.mo6255a(this.f4512a, aVar, !a.mo6456b().equals(HttpMethods.GET)), f.mo6261c());
    }
}
