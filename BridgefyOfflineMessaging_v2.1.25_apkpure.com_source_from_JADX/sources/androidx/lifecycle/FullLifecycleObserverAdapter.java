package androidx.lifecycle;

import androidx.lifecycle.C1172e.C1173a;

class FullLifecycleObserverAdapter implements C1171d {

    /* renamed from: a */
    private final C1169b f3537a;

    FullLifecycleObserverAdapter(C1169b bVar) {
        this.f3537a = bVar;
    }

    /* renamed from: a */
    public void mo4573a(C1176g gVar, C1173a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f3537a.mo4594a(gVar);
                return;
            case ON_START:
                this.f3537a.mo4595b(gVar);
                return;
            case ON_RESUME:
                this.f3537a.mo4596c(gVar);
                return;
            case ON_PAUSE:
                this.f3537a.mo4597d(gVar);
                return;
            case ON_STOP:
                this.f3537a.mo4598e(gVar);
                return;
            case ON_DESTROY:
                this.f3537a.mo4599f(gVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
