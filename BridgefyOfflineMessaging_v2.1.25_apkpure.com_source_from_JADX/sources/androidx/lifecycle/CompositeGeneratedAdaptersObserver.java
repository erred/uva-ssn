package androidx.lifecycle;

import androidx.lifecycle.C1172e.C1173a;

public class CompositeGeneratedAdaptersObserver implements C1171d {

    /* renamed from: a */
    private final C1170c[] f3536a;

    CompositeGeneratedAdaptersObserver(C1170c[] cVarArr) {
        this.f3536a = cVarArr;
    }

    /* renamed from: a */
    public void mo4573a(C1176g gVar, C1173a aVar) {
        C1182k kVar = new C1182k();
        for (C1170c a : this.f3536a) {
            a.mo4600a(gVar, aVar, false, kVar);
        }
        for (C1170c a2 : this.f3536a) {
            a2.mo4600a(gVar, aVar, true, kVar);
        }
    }
}
