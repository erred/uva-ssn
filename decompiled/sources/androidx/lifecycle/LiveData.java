package androidx.lifecycle;

import androidx.lifecycle.C1172e.C1173a;
import androidx.lifecycle.C1172e.C1174b;
import androidx.p043a.p044a.p045a.C0406a;
import androidx.p043a.p044a.p046b.C0413b;
import java.util.Map.Entry;

public abstract class LiveData<T> {

    /* renamed from: b */
    static final Object f3539b = new Object();

    /* renamed from: a */
    final Object f3540a = new Object();

    /* renamed from: c */
    int f3541c = 0;

    /* renamed from: d */
    volatile Object f3542d = f3539b;

    /* renamed from: e */
    private C0413b<C1184m<? super T>, C1165a> f3543e = new C0413b<>();

    /* renamed from: f */
    private volatile Object f3544f = f3539b;

    /* renamed from: g */
    private int f3545g = -1;

    /* renamed from: h */
    private boolean f3546h;

    /* renamed from: i */
    private boolean f3547i;

    /* renamed from: j */
    private final Runnable f3548j = new Runnable() {
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3540a) {
                obj = LiveData.this.f3542d;
                LiveData.this.f3542d = LiveData.f3539b;
            }
            LiveData.this.mo4580b(obj);
        }
    };

    class LifecycleBoundObserver extends C1165a implements C1171d {

        /* renamed from: a */
        final C1176g f3550a;

        LifecycleBoundObserver(C1176g gVar, C1184m<? super T> mVar) {
            super(mVar);
            this.f3550a = gVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4584a() {
            return this.f3550a.getLifecycle().mo4601a().mo4604a(C1174b.STARTED);
        }

        /* renamed from: a */
        public void mo4573a(C1176g gVar, C1173a aVar) {
            if (this.f3550a.getLifecycle().mo4601a() == C1174b.DESTROYED) {
                LiveData.this.mo4577a(this.f3552c);
            } else {
                mo4587a(mo4584a());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4585a(C1176g gVar) {
            return this.f3550a == gVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4586b() {
            this.f3550a.getLifecycle().mo4603b(this);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$a */
    private abstract class C1165a {

        /* renamed from: c */
        final C1184m<? super T> f3552c;

        /* renamed from: d */
        boolean f3553d;

        /* renamed from: e */
        int f3554e = -1;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract boolean mo4584a();

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4585a(C1176g gVar) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4586b() {
        }

        C1165a(C1184m<? super T> mVar) {
            this.f3552c = mVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4587a(boolean z) {
            if (z != this.f3553d) {
                this.f3553d = z;
                int i = 1;
                boolean z2 = LiveData.this.f3541c == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.f3541c;
                if (!this.f3553d) {
                    i = -1;
                }
                liveData.f3541c = i2 + i;
                if (z2 && this.f3553d) {
                    LiveData.this.mo4579b();
                }
                if (LiveData.this.f3541c == 0 && !this.f3553d) {
                    LiveData.this.mo4581c();
                }
                if (this.f3553d) {
                    LiveData.this.mo4575a(this);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4579b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4581c() {
    }

    /* renamed from: b */
    private void m4421b(C1165a aVar) {
        if (aVar.f3553d) {
            if (!aVar.mo4584a()) {
                aVar.mo4587a(false);
            } else if (aVar.f3554e < this.f3545g) {
                aVar.f3554e = this.f3545g;
                aVar.f3552c.mo4609a(this.f3544f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4575a(C1165a aVar) {
        if (this.f3546h) {
            this.f3547i = true;
            return;
        }
        this.f3546h = true;
        do {
            this.f3547i = false;
            if (aVar == null) {
                C0417d c = this.f3543e.mo780c();
                while (c.hasNext()) {
                    m4421b((C1165a) ((Entry) c.next()).getValue());
                    if (this.f3547i) {
                        break;
                    }
                }
            } else {
                m4421b(aVar);
                aVar = null;
            }
        } while (this.f3547i);
        this.f3546h = false;
    }

    /* renamed from: a */
    public void mo4576a(C1176g gVar, C1184m<? super T> mVar) {
        m4420a("observe");
        if (gVar.getLifecycle().mo4601a() != C1174b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
            C1165a aVar = (C1165a) this.f3543e.mo773a(mVar, lifecycleBoundObserver);
            if (aVar != null && !aVar.mo4585a(gVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (aVar == null) {
                gVar.getLifecycle().mo4602a(lifecycleBoundObserver);
            }
        }
    }

    /* renamed from: a */
    public void mo4577a(C1184m<? super T> mVar) {
        m4420a("removeObserver");
        C1165a aVar = (C1165a) this.f3543e.mo774b(mVar);
        if (aVar != null) {
            aVar.mo4586b();
            aVar.mo4587a(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4578a(T t) {
        boolean z;
        synchronized (this.f3540a) {
            z = this.f3542d == f3539b;
            this.f3542d = t;
        }
        if (z) {
            C0406a.m1231a().mo767b(this.f3548j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4580b(T t) {
        m4420a("setValue");
        this.f3545g++;
        this.f3544f = t;
        mo4575a(null);
    }

    /* renamed from: a */
    public T mo4574a() {
        T t = this.f3544f;
        if (t != f3539b) {
            return t;
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo4582d() {
        return this.f3541c > 0;
    }

    /* renamed from: a */
    private static void m4420a(String str) {
        if (!C0406a.m1231a().mo768b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot invoke ");
            sb.append(str);
            sb.append(" on a background");
            sb.append(" thread");
            throw new IllegalStateException(sb.toString());
        }
    }
}
