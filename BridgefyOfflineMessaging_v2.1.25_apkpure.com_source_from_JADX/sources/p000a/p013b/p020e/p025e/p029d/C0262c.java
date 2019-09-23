package p000a.p013b.p020e.p025e.p029d;

import p000a.p013b.C0348o;
import p000a.p013b.C0349p;
import p000a.p013b.C0350q;
import p000a.p013b.C0350q.C0352b;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p020e.p023c.C0207b;
import p000a.p013b.p020e.p023c.C0212g;
import p000a.p013b.p020e.p024d.C0213a;
import p000a.p013b.p020e.p031f.C0279b;
import p000a.p013b.p020e.p032g.C0300k;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.e.d.c */
/* compiled from: ObservableObserveOn */
public final class C0262c<T> extends C0259a<T, T> {

    /* renamed from: b */
    final C0350q f513b;

    /* renamed from: c */
    final boolean f514c;

    /* renamed from: d */
    final int f515d;

    /* renamed from: a.b.e.e.d.c$a */
    /* compiled from: ObservableObserveOn */
    static final class C0263a<T> extends C0213a<T> implements C0349p<T>, Runnable {

        /* renamed from: a */
        final C0349p<? super T> f516a;

        /* renamed from: b */
        final C0352b f517b;

        /* renamed from: c */
        final boolean f518c;

        /* renamed from: d */
        final int f519d;

        /* renamed from: e */
        C0212g<T> f520e;

        /* renamed from: f */
        C0161b f521f;

        /* renamed from: g */
        Throwable f522g;

        /* renamed from: h */
        volatile boolean f523h;

        /* renamed from: i */
        volatile boolean f524i;

        /* renamed from: j */
        int f525j;

        /* renamed from: k */
        boolean f526k;

        C0263a(C0349p<? super T> pVar, C0352b bVar, boolean z, int i) {
            this.f516a = pVar;
            this.f517b = bVar;
            this.f518c = z;
            this.f519d = i;
        }

        public void onSubscribe(C0161b bVar) {
            if (C0186b.m591a(this.f521f, bVar)) {
                this.f521f = bVar;
                if (bVar instanceof C0207b) {
                    C0207b bVar2 = (C0207b) bVar;
                    int a = bVar2.mo382a(7);
                    if (a == 1) {
                        this.f525j = a;
                        this.f520e = bVar2;
                        this.f523h = true;
                        this.f516a.onSubscribe(this);
                        mo456d();
                        return;
                    } else if (a == 2) {
                        this.f525j = a;
                        this.f520e = bVar2;
                        this.f516a.onSubscribe(this);
                        return;
                    }
                }
                this.f520e = new C0279b(this.f519d);
                this.f516a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f523h) {
                if (this.f525j != 2) {
                    this.f520e.mo383a(t);
                }
                mo456d();
            }
        }

        public void onError(Throwable th) {
            if (this.f523h) {
                C0324a.m885a(th);
                return;
            }
            this.f522g = th;
            this.f523h = true;
            mo456d();
        }

        public void onComplete() {
            if (!this.f523h) {
                this.f523h = true;
                mo456d();
            }
        }

        public void dispose() {
            if (!this.f524i) {
                this.f524i = true;
                this.f521f.dispose();
                this.f517b.dispose();
                if (getAndIncrement() == 0) {
                    this.f520e.mo385c();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo456d() {
            if (getAndIncrement() == 0) {
                this.f517b.mo478a((Runnable) this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo457e() {
            C0212g<T> gVar = this.f520e;
            C0349p<? super T> pVar = this.f516a;
            int i = 1;
            while (!mo455a(this.f523h, gVar.mo384b(), pVar)) {
                while (true) {
                    boolean z = this.f523h;
                    try {
                        Object e_ = gVar.mo386e_();
                        boolean z2 = e_ == null;
                        if (!mo455a(z, z2, pVar)) {
                            if (z2) {
                                i = addAndGet(-i);
                                if (i == 0) {
                                    return;
                                }
                            } else {
                                pVar.onNext(e_);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        C0171b.m584b(th);
                        this.f524i = true;
                        this.f521f.dispose();
                        gVar.mo385c();
                        pVar.onError(th);
                        this.f517b.dispose();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo458f() {
            int i = 1;
            while (!this.f524i) {
                boolean z = this.f523h;
                Throwable th = this.f522g;
                if (this.f518c || !z || th == null) {
                    this.f516a.onNext(null);
                    if (z) {
                        this.f524i = true;
                        Throwable th2 = this.f522g;
                        if (th2 != null) {
                            this.f516a.onError(th2);
                        } else {
                            this.f516a.onComplete();
                        }
                        this.f517b.dispose();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    this.f524i = true;
                    this.f516a.onError(this.f522g);
                    this.f517b.dispose();
                    return;
                }
            }
        }

        public void run() {
            if (this.f526k) {
                mo458f();
            } else {
                mo457e();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo455a(boolean z, boolean z2, C0349p<? super T> pVar) {
            if (this.f524i) {
                this.f520e.mo385c();
                return true;
            }
            if (z) {
                Throwable th = this.f522g;
                if (this.f518c) {
                    if (z2) {
                        this.f524i = true;
                        if (th != null) {
                            pVar.onError(th);
                        } else {
                            pVar.onComplete();
                        }
                        this.f517b.dispose();
                        return true;
                    }
                } else if (th != null) {
                    this.f524i = true;
                    this.f520e.mo385c();
                    pVar.onError(th);
                    this.f517b.dispose();
                    return true;
                } else if (z2) {
                    this.f524i = true;
                    pVar.onComplete();
                    this.f517b.dispose();
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public int mo382a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f526k = true;
            return 2;
        }

        /* renamed from: e_ */
        public T mo386e_() throws Exception {
            return this.f520e.mo386e_();
        }

        /* renamed from: c */
        public void mo385c() {
            this.f520e.mo385c();
        }

        /* renamed from: b */
        public boolean mo384b() {
            return this.f520e.mo384b();
        }
    }

    public C0262c(C0348o<T> oVar, C0350q qVar, boolean z, int i) {
        super(oVar);
        this.f513b = qVar;
        this.f514c = z;
        this.f515d = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo449b(C0349p<? super T> pVar) {
        if (this.f513b instanceof C0300k) {
            this.f510a.mo556a(pVar);
            return;
        }
        this.f510a.mo556a(new C0263a(pVar, this.f513b.mo335a(), this.f514c, this.f515d));
    }
}
