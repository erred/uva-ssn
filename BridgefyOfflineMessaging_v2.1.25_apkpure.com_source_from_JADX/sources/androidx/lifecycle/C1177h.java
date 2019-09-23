package androidx.lifecycle;

import android.util.Log;
import androidx.lifecycle.C1172e.C1173a;
import androidx.lifecycle.C1172e.C1174b;
import androidx.p043a.p044a.p046b.C0412a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: androidx.lifecycle.h */
/* compiled from: LifecycleRegistry */
public class C1177h extends C1172e {

    /* renamed from: a */
    private C0412a<C1175f, C1179a> f3572a = new C0412a<>();

    /* renamed from: b */
    private C1174b f3573b;

    /* renamed from: c */
    private final WeakReference<C1176g> f3574c;

    /* renamed from: d */
    private int f3575d = 0;

    /* renamed from: e */
    private boolean f3576e = false;

    /* renamed from: f */
    private boolean f3577f = false;

    /* renamed from: g */
    private ArrayList<C1174b> f3578g = new ArrayList<>();

    /* renamed from: androidx.lifecycle.h$a */
    /* compiled from: LifecycleRegistry */
    static class C1179a {

        /* renamed from: a */
        C1174b f3581a;

        /* renamed from: b */
        C1171d f3582b;

        C1179a(C1175f fVar, C1174b bVar) {
            this.f3582b = C1181j.m4481a((Object) fVar);
            this.f3581a = bVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4607a(C1176g gVar, C1173a aVar) {
            C1174b b = C1177h.m4463b(aVar);
            this.f3581a = C1177h.m4461a(this.f3581a, b);
            this.f3582b.mo4573a(gVar, aVar);
            this.f3581a = b;
        }
    }

    public C1177h(C1176g gVar) {
        this.f3574c = new WeakReference<>(gVar);
        this.f3573b = C1174b.INITIALIZED;
    }

    /* renamed from: a */
    public void mo4606a(C1174b bVar) {
        m4464b(bVar);
    }

    /* renamed from: a */
    public void mo4605a(C1173a aVar) {
        m4464b(m4463b(aVar));
    }

    /* renamed from: b */
    private void m4464b(C1174b bVar) {
        if (this.f3573b != bVar) {
            this.f3573b = bVar;
            if (this.f3576e || this.f3575d != 0) {
                this.f3577f = true;
                return;
            }
            this.f3576e = true;
            m4471d();
            this.f3576e = false;
        }
    }

    /* renamed from: b */
    private boolean m4466b() {
        boolean z = true;
        if (this.f3572a.mo777a() == 0) {
            return true;
        }
        C1174b bVar = ((C1179a) this.f3572a.mo781d().getValue()).f3581a;
        C1174b bVar2 = ((C1179a) this.f3572a.mo782e().getValue()).f3581a;
        if (!(bVar == bVar2 && this.f3573b == bVar2)) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private C1174b m4467c(C1175f fVar) {
        Entry d = this.f3572a.mo776d(fVar);
        C1174b bVar = null;
        C1174b bVar2 = d != null ? ((C1179a) d.getValue()).f3581a : null;
        if (!this.f3578g.isEmpty()) {
            bVar = (C1174b) this.f3578g.get(this.f3578g.size() - 1);
        }
        return m4461a(m4461a(this.f3573b, bVar2), bVar);
    }

    /* renamed from: a */
    public void mo4602a(C1175f fVar) {
        C1179a aVar = new C1179a(fVar, this.f3573b == C1174b.DESTROYED ? C1174b.DESTROYED : C1174b.INITIALIZED);
        if (((C1179a) this.f3572a.mo773a(fVar, aVar)) == null) {
            C1176g gVar = (C1176g) this.f3574c.get();
            if (gVar != null) {
                boolean z = this.f3575d != 0 || this.f3576e;
                C1174b c = m4467c(fVar);
                this.f3575d++;
                while (aVar.f3581a.compareTo(c) < 0 && this.f3572a.mo775c(fVar)) {
                    m4469c(aVar.f3581a);
                    aVar.mo4607a(gVar, m4472e(aVar.f3581a));
                    m4468c();
                    c = m4467c(fVar);
                }
                if (!z) {
                    m4471d();
                }
                this.f3575d--;
            }
        }
    }

    /* renamed from: c */
    private void m4468c() {
        this.f3578g.remove(this.f3578g.size() - 1);
    }

    /* renamed from: c */
    private void m4469c(C1174b bVar) {
        this.f3578g.add(bVar);
    }

    /* renamed from: b */
    public void mo4603b(C1175f fVar) {
        this.f3572a.mo774b(fVar);
    }

    /* renamed from: a */
    public C1174b mo4601a() {
        return this.f3573b;
    }

    /* renamed from: b */
    static C1174b m4463b(C1173a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return C1174b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return C1174b.STARTED;
            case ON_RESUME:
                return C1174b.RESUMED;
            case ON_DESTROY:
                return C1174b.DESTROYED;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected event value ");
                sb.append(aVar);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: d */
    private static C1173a m4470d(C1174b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return C1173a.ON_DESTROY;
            case STARTED:
                return C1173a.ON_STOP;
            case RESUMED:
                return C1173a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(bVar);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: e */
    private static C1173a m4472e(C1174b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return C1173a.ON_CREATE;
            case CREATED:
                return C1173a.ON_START;
            case STARTED:
                return C1173a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(bVar);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private void m4462a(C1176g gVar) {
        C0417d c = this.f3572a.mo780c();
        while (c.hasNext() && !this.f3577f) {
            Entry entry = (Entry) c.next();
            C1179a aVar = (C1179a) entry.getValue();
            while (aVar.f3581a.compareTo(this.f3573b) < 0 && !this.f3577f && this.f3572a.mo775c(entry.getKey())) {
                m4469c(aVar.f3581a);
                aVar.mo4607a(gVar, m4472e(aVar.f3581a));
                m4468c();
            }
        }
    }

    /* renamed from: b */
    private void m4465b(C1176g gVar) {
        Iterator b = this.f3572a.mo779b();
        while (b.hasNext() && !this.f3577f) {
            Entry entry = (Entry) b.next();
            C1179a aVar = (C1179a) entry.getValue();
            while (aVar.f3581a.compareTo(this.f3573b) > 0 && !this.f3577f && this.f3572a.mo775c(entry.getKey())) {
                C1173a d = m4470d(aVar.f3581a);
                m4469c(m4463b(d));
                aVar.mo4607a(gVar, d);
                m4468c();
            }
        }
    }

    /* renamed from: d */
    private void m4471d() {
        C1176g gVar = (C1176g) this.f3574c.get();
        if (gVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m4466b()) {
            this.f3577f = false;
            if (this.f3573b.compareTo(((C1179a) this.f3572a.mo781d().getValue()).f3581a) < 0) {
                m4465b(gVar);
            }
            Entry e = this.f3572a.mo782e();
            if (!this.f3577f && e != null && this.f3573b.compareTo(((C1179a) e.getValue()).f3581a) > 0) {
                m4462a(gVar);
            }
        }
        this.f3577f = false;
    }

    /* renamed from: a */
    static C1174b m4461a(C1174b bVar, C1174b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
