package p000a.p013b.p020e.p025e.p027b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0151a;
import p000a.p013b.C0330h;
import p000a.p013b.C0340i;
import p000a.p013b.C0343j;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p018c.C0172c;
import p000a.p013b.p020e.p021a.C0189e;
import p000a.p013b.p020e.p031f.C0279b;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p020e.p035j.C0313c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.e.b.b */
/* compiled from: FlowableCreate */
public final class C0233b<T> extends C0330h<T> {

    /* renamed from: b */
    final C0343j<T> f443b;

    /* renamed from: c */
    final C0151a f444c;

    /* renamed from: a.b.e.e.b.b$a */
    /* compiled from: FlowableCreate */
    static abstract class C0235a<T> extends AtomicLong implements C0340i<T>, C3684d {

        /* renamed from: a */
        final C3683c<? super T> f446a;

        /* renamed from: b */
        final C0189e f447b = new C0189e();

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo423c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo426e() {
        }

        C0235a(C3683c<? super T> cVar) {
            this.f446a = cVar;
        }

        /* renamed from: f_ */
        public void mo427f_() {
            mo421b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo421b() {
            if (!mo425d()) {
                try {
                    this.f446a.onComplete();
                } finally {
                    this.f447b.dispose();
                }
            }
        }

        /* renamed from: a */
        public final void mo420a(Throwable th) {
            if (!mo422b(th)) {
                C0324a.m885a(th);
            }
        }

        /* renamed from: b */
        public boolean mo422b(Throwable th) {
            return mo424c(th);
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        /* renamed from: c */
        public boolean mo424c(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (mo425d()) {
                return false;
            }
            try {
                this.f446a.onError(th);
                this.f447b.dispose();
                return true;
            } catch (Throwable th2) {
                this.f447b.dispose();
                throw th2;
            }
        }

        /* renamed from: a */
        public final void mo407a() {
            this.f447b.dispose();
            mo423c();
        }

        /* renamed from: d */
        public final boolean mo425d() {
            return this.f447b.mo388a();
        }

        /* renamed from: a */
        public final void mo408a(long j) {
            if (C0310e.m837b(j)) {
                C0313c.m847a((AtomicLong) this, j);
                mo426e();
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    /* renamed from: a.b.e.e.b.b$b */
    /* compiled from: FlowableCreate */
    static final class C0236b<T> extends C0235a<T> {

        /* renamed from: c */
        final C0279b<T> f448c;

        /* renamed from: d */
        Throwable f449d;

        /* renamed from: e */
        volatile boolean f450e;

        /* renamed from: f */
        final AtomicInteger f451f = new AtomicInteger();

        C0236b(C3683c<? super T> cVar, int i) {
            super(cVar);
            this.f448c = new C0279b<>(i);
        }

        /* renamed from: a */
        public void mo429a(T t) {
            if (!this.f450e && !mo425d()) {
                if (t == null) {
                    mo420a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f448c.mo383a(t);
                mo430f();
            }
        }

        /* renamed from: b */
        public boolean mo422b(Throwable th) {
            if (this.f450e || mo425d()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f449d = th;
            this.f450e = true;
            mo430f();
            return true;
        }

        /* renamed from: f_ */
        public void mo427f_() {
            this.f450e = true;
            mo430f();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo426e() {
            mo430f();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo423c() {
            if (this.f451f.getAndIncrement() == 0) {
                this.f448c.mo385c();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo430f() {
            int i;
            if (this.f451f.getAndIncrement() == 0) {
                C3683c cVar = this.f446a;
                C0279b<T> bVar = this.f448c;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (mo425d()) {
                            bVar.mo385c();
                            return;
                        } else {
                            boolean z = this.f450e;
                            Object e_ = bVar.mo386e_();
                            boolean z2 = e_ == null;
                            if (z && z2) {
                                Throwable th = this.f449d;
                                if (th != null) {
                                    mo424c(th);
                                } else {
                                    mo421b();
                                }
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                cVar.onNext(e_);
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (mo425d()) {
                            bVar.mo385c();
                            return;
                        }
                        boolean z3 = this.f450e;
                        boolean b = bVar.mo384b();
                        if (z3 && b) {
                            Throwable th2 = this.f449d;
                            if (th2 != null) {
                                mo424c(th2);
                            } else {
                                mo421b();
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        C0313c.m848b(this, j2);
                    }
                    i2 = this.f451f.addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    /* renamed from: a.b.e.e.b.b$c */
    /* compiled from: FlowableCreate */
    static final class C0237c<T> extends C0241g<T> {
        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo431f() {
        }

        C0237c(C3683c<? super T> cVar) {
            super(cVar);
        }
    }

    /* renamed from: a.b.e.e.b.b$d */
    /* compiled from: FlowableCreate */
    static final class C0238d<T> extends C0241g<T> {
        C0238d(C3683c<? super T> cVar) {
            super(cVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo431f() {
            mo420a((Throwable) new C0172c("create: could not emit value due to lack of requests"));
        }
    }

    /* renamed from: a.b.e.e.b.b$e */
    /* compiled from: FlowableCreate */
    static final class C0239e<T> extends C0235a<T> {

        /* renamed from: c */
        final AtomicReference<T> f452c = new AtomicReference<>();

        /* renamed from: d */
        Throwable f453d;

        /* renamed from: e */
        volatile boolean f454e;

        /* renamed from: f */
        final AtomicInteger f455f = new AtomicInteger();

        C0239e(C3683c<? super T> cVar) {
            super(cVar);
        }

        /* renamed from: a */
        public void mo429a(T t) {
            if (!this.f454e && !mo425d()) {
                if (t == null) {
                    mo420a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f452c.set(t);
                mo432f();
            }
        }

        /* renamed from: b */
        public boolean mo422b(Throwable th) {
            if (this.f454e || mo425d()) {
                return false;
            }
            if (th == null) {
                mo420a((Throwable) new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f453d = th;
            this.f454e = true;
            mo432f();
            return true;
        }

        /* renamed from: f_ */
        public void mo427f_() {
            this.f454e = true;
            mo432f();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo426e() {
            mo432f();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo423c() {
            if (this.f455f.getAndIncrement() == 0) {
                this.f452c.lazySet(null);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo432f() {
            boolean z;
            int i;
            if (this.f455f.getAndIncrement() == 0) {
                C3683c cVar = this.f446a;
                AtomicReference<T> atomicReference = this.f452c;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (mo425d()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z2 = this.f454e;
                            Object andSet = atomicReference.getAndSet(null);
                            boolean z3 = andSet == null;
                            if (z2 && z3) {
                                Throwable th = this.f453d;
                                if (th != null) {
                                    mo424c(th);
                                } else {
                                    mo421b();
                                }
                                return;
                            } else if (z3) {
                                break;
                            } else {
                                cVar.onNext(andSet);
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (mo425d()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z4 = this.f454e;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable th2 = this.f453d;
                            if (th2 != null) {
                                mo424c(th2);
                            } else {
                                mo421b();
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        C0313c.m848b(this, j2);
                    }
                    i2 = this.f455f.addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    /* renamed from: a.b.e.e.b.b$f */
    /* compiled from: FlowableCreate */
    static final class C0240f<T> extends C0235a<T> {
        C0240f(C3683c<? super T> cVar) {
            super(cVar);
        }

        /* renamed from: a */
        public void mo429a(T t) {
            long j;
            if (!mo425d()) {
                if (t != null) {
                    this.f446a.onNext(t);
                    do {
                        j = get();
                        if (j == 0) {
                            break;
                        }
                    } while (!compareAndSet(j, j - 1));
                    return;
                }
                mo420a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    /* renamed from: a.b.e.e.b.b$g */
    /* compiled from: FlowableCreate */
    static abstract class C0241g<T> extends C0235a<T> {
        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public abstract void mo431f();

        C0241g(C3683c<? super T> cVar) {
            super(cVar);
        }

        /* renamed from: a */
        public final void mo429a(T t) {
            if (!mo425d()) {
                if (t == null) {
                    mo420a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                if (get() != 0) {
                    this.f446a.onNext(t);
                    C0313c.m848b(this, 1);
                } else {
                    mo431f();
                }
            }
        }
    }

    public C0233b(C0343j<T> jVar, C0151a aVar) {
        this.f443b = jVar;
        this.f444c = aVar;
    }

    /* renamed from: b */
    public void mo419b(C3683c<? super T> cVar) {
        C0235a aVar;
        switch (this.f444c) {
            case MISSING:
                aVar = new C0240f(cVar);
                break;
            case ERROR:
                aVar = new C0238d(cVar);
                break;
            case DROP:
                aVar = new C0237c(cVar);
                break;
            case LATEST:
                aVar = new C0239e(cVar);
                break;
            default:
                aVar = new C0236b(cVar, m911a());
                break;
        }
        cVar.onSubscribe(aVar);
        try {
            this.f443b.subscribe(aVar);
        } catch (Throwable th) {
            C0171b.m584b(th);
            aVar.mo420a(th);
        }
    }
}
