package p000a.p013b.p037g;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p031f.C0279b;
import p000a.p013b.p020e.p034i.C0306a;
import p000a.p013b.p020e.p034i.C0307b;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p020e.p035j.C0313c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.g.c */
/* compiled from: UnicastProcessor */
public final class C0328c<T> extends C0326a<T> {

    /* renamed from: b */
    final C0279b<T> f699b;

    /* renamed from: c */
    final AtomicReference<Runnable> f700c;

    /* renamed from: d */
    final boolean f701d;

    /* renamed from: e */
    volatile boolean f702e;

    /* renamed from: f */
    Throwable f703f;

    /* renamed from: g */
    final AtomicReference<C3683c<? super T>> f704g;

    /* renamed from: h */
    volatile boolean f705h;

    /* renamed from: i */
    final AtomicBoolean f706i;

    /* renamed from: j */
    final C0306a<T> f707j;

    /* renamed from: k */
    final AtomicLong f708k;

    /* renamed from: l */
    boolean f709l;

    /* renamed from: a.b.g.c$a */
    /* compiled from: UnicastProcessor */
    final class C0329a extends C0306a<T> {
        C0329a() {
        }

        /* renamed from: e_ */
        public T mo386e_() {
            return C0328c.this.f699b.mo386e_();
        }

        /* renamed from: b */
        public boolean mo384b() {
            return C0328c.this.f699b.mo384b();
        }

        /* renamed from: c */
        public void mo385c() {
            C0328c.this.f699b.mo385c();
        }

        /* renamed from: a */
        public int mo382a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            C0328c.this.f709l = true;
            return 2;
        }

        /* renamed from: a */
        public void mo408a(long j) {
            if (C0310e.m837b(j)) {
                C0313c.m847a(C0328c.this.f708k, j);
                C0328c.this.mo534e();
            }
        }

        /* renamed from: a */
        public void mo407a() {
            if (!C0328c.this.f705h) {
                C0328c.this.f705h = true;
                C0328c.this.mo532d();
                if (!C0328c.this.f709l && C0328c.this.f707j.getAndIncrement() == 0) {
                    C0328c.this.f699b.mo385c();
                    C0328c.this.f704g.lazySet(null);
                }
            }
        }
    }

    /* renamed from: a */
    public static <T> C0328c<T> m898a(int i) {
        return new C0328c<>(i);
    }

    C0328c(int i) {
        this(i, null, true);
    }

    C0328c(int i, Runnable runnable, boolean z) {
        this.f699b = new C0279b<>(C0204b.m613a(i, "capacityHint"));
        this.f700c = new AtomicReference<>(runnable);
        this.f701d = z;
        this.f704g = new AtomicReference<>();
        this.f706i = new AtomicBoolean();
        this.f707j = new C0329a();
        this.f708k = new AtomicLong();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo532d() {
        Runnable runnable = (Runnable) this.f700c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo531c(C3683c<? super T> cVar) {
        int i;
        long j;
        C0279b<T> bVar = this.f699b;
        boolean z = !this.f701d;
        int i2 = 1;
        while (true) {
            long j2 = this.f708k.get();
            long j3 = 0;
            while (true) {
                i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.f702e;
                Object e_ = bVar.mo386e_();
                boolean z3 = e_ == null;
                Object obj = e_;
                j = j3;
                if (!mo530a(z, z2, z3, cVar, bVar)) {
                    if (z3) {
                        break;
                    }
                    cVar.onNext(obj);
                    j3 = 1 + j;
                } else {
                    return;
                }
            }
            C3683c<? super T> cVar2 = cVar;
            if (i == 0) {
                if (mo530a(z, this.f702e, bVar.mo384b(), cVar, bVar)) {
                    return;
                }
            }
            if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                this.f708k.addAndGet(-j);
            }
            i2 = this.f707j.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo533d(C3683c<? super T> cVar) {
        C0279b<T> bVar = this.f699b;
        int i = 1;
        boolean z = !this.f701d;
        while (!this.f705h) {
            boolean z2 = this.f702e;
            if (!z || !z2 || this.f703f == null) {
                cVar.onNext(null);
                if (z2) {
                    this.f704g.lazySet(null);
                    Throwable th = this.f703f;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    return;
                }
                i = this.f707j.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                bVar.mo385c();
                this.f704g.lazySet(null);
                cVar.onError(this.f703f);
                return;
            }
        }
        bVar.mo385c();
        this.f704g.lazySet(null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo534e() {
        if (this.f707j.getAndIncrement() == 0) {
            int i = 1;
            C3683c cVar = (C3683c) this.f704g.get();
            while (cVar == null) {
                i = this.f707j.addAndGet(-i);
                if (i != 0) {
                    cVar = (C3683c) this.f704g.get();
                } else {
                    return;
                }
            }
            if (this.f709l) {
                mo533d(cVar);
            } else {
                mo531c(cVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo530a(boolean z, boolean z2, boolean z3, C3683c<? super T> cVar, C0279b<T> bVar) {
        if (this.f705h) {
            bVar.mo385c();
            this.f704g.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.f703f != null) {
                bVar.mo385c();
                this.f704g.lazySet(null);
                cVar.onError(this.f703f);
                return true;
            } else if (z3) {
                Throwable th = this.f703f;
                this.f704g.lazySet(null);
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    public void onSubscribe(C3684d dVar) {
        if (this.f702e || this.f705h) {
            dVar.mo407a();
        } else {
            dVar.mo408a(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        C0204b.m615a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f702e && !this.f705h) {
            this.f699b.mo383a(t);
            mo534e();
        }
    }

    public void onError(Throwable th) {
        C0204b.m615a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f702e || this.f705h) {
            C0324a.m885a(th);
            return;
        }
        this.f703f = th;
        this.f702e = true;
        mo532d();
        mo534e();
    }

    public void onComplete() {
        if (!this.f702e && !this.f705h) {
            this.f702e = true;
            mo532d();
            mo534e();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo419b(C3683c<? super T> cVar) {
        if (this.f706i.get() || !this.f706i.compareAndSet(false, true)) {
            C0307b.m808a(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.onSubscribe(this.f707j);
        this.f704g.set(cVar);
        if (this.f705h) {
            this.f704g.lazySet(null);
        } else {
            mo534e();
        }
    }
}
