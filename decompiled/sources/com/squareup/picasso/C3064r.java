package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3085y.C3086a;
import java.io.IOException;
import p091b.C1590aa;
import p091b.C1590aa.C1591a;
import p091b.C1596ac;
import p091b.C1598ad;
import p091b.C1612d;
import p091b.C1612d.C1613a;
import p102c.C1695s;

/* renamed from: com.squareup.picasso.r */
/* compiled from: NetworkRequestHandler */
class C3064r extends C3085y {

    /* renamed from: a */
    private final C3053j f8012a;

    /* renamed from: b */
    private final C3023aa f8013b;

    /* renamed from: com.squareup.picasso.r$a */
    /* compiled from: NetworkRequestHandler */
    static class C3065a extends IOException {
        C3065a(String str) {
            super(str);
        }
    }

    /* renamed from: com.squareup.picasso.r$b */
    /* compiled from: NetworkRequestHandler */
    static final class C3066b extends IOException {

        /* renamed from: a */
        final int f8014a;

        /* renamed from: b */
        final int f8015b;

        C3066b(int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("HTTP ");
            sb.append(i);
            super(sb.toString());
            this.f8014a = i;
            this.f8015b = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo27528a() {
        return 2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo27530b() {
        return true;
    }

    C3064r(C3053j jVar, C3023aa aaVar) {
        this.f8012a = jVar;
        this.f8013b = aaVar;
    }

    /* renamed from: a */
    public boolean mo27455a(C3081w wVar) {
        String scheme = wVar.f8073d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    /* renamed from: a */
    public C3086a mo27454a(C3081w wVar, int i) throws IOException {
        C1596ac a = this.f8012a.mo27513a(m9050b(wVar, i));
        C1598ad h = a.mo6487h();
        if (a.mo6483d()) {
            C3074d dVar = a.mo6490k() == null ? C3074d.NETWORK : C3074d.DISK;
            if (dVar == C3074d.DISK && h.mo6291b() == 0) {
                h.close();
                throw new C3065a("Received response with 0 content-length header.");
            }
            if (dVar == C3074d.NETWORK && h.mo6291b() > 0) {
                this.f8013b.mo27432a(h.mo6291b());
            }
            return new C3086a((C1695s) h.mo6292c(), dVar);
        }
        h.close();
        throw new C3066b(a.mo6481c(), wVar.f8072c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo27529a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* renamed from: b */
    private static C1590aa m9050b(C3081w wVar, int i) {
        C1612d dVar;
        if (i == 0) {
            dVar = null;
        } else if (C3063q.m9049c(i)) {
            dVar = C1612d.f4955b;
        } else {
            C1613a aVar = new C1613a();
            if (!C3063q.m9047a(i)) {
                aVar.mo6547a();
            }
            if (!C3063q.m9048b(i)) {
                aVar.mo6549b();
            }
            dVar = aVar.mo6551d();
        }
        C1591a a = new C1591a().mo6468a(wVar.f8073d.toString());
        if (dVar != null) {
            a.mo6465a(dVar);
        }
        return a.mo6471a();
    }
}
