package p000a.p013b.p020e.p025e.p027b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3682b;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0330h;
import p000a.p013b.C0344k;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p018c.C0172c;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p023c.C0209d;
import p000a.p013b.p020e.p023c.C0211f;
import p000a.p013b.p020e.p023c.C0212g;
import p000a.p013b.p020e.p031f.C0278a;
import p000a.p013b.p020e.p031f.C0279b;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p020e.p035j.C0312b;
import p000a.p013b.p020e.p035j.C0313c;
import p000a.p013b.p020e.p035j.C0315e;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.e.b.e */
/* compiled from: FlowableFlatMap */
public final class C0244e<T, U> extends C0232a<T, U> {

    /* renamed from: c */
    final C0181e<? super T, ? extends C3682b<? extends U>> f458c;

    /* renamed from: d */
    final boolean f459d;

    /* renamed from: e */
    final int f460e;

    /* renamed from: f */
    final int f461f;

    /* renamed from: a.b.e.e.b.e$a */
    /* compiled from: FlowableFlatMap */
    static final class C0245a<T, U> extends AtomicReference<C3684d> implements C0161b, C0344k<U> {

        /* renamed from: a */
        final long f462a;

        /* renamed from: b */
        final C0246b<T, U> f463b;

        /* renamed from: c */
        final int f464c = (this.f465d >> 2);

        /* renamed from: d */
        final int f465d;

        /* renamed from: e */
        volatile boolean f466e;

        /* renamed from: f */
        volatile C0212g<U> f467f;

        /* renamed from: g */
        long f468g;

        /* renamed from: h */
        int f469h;

        C0245a(C0246b<T, U> bVar, long j) {
            this.f462a = j;
            this.f463b = bVar;
            this.f465d = bVar.f476e;
        }

        public void onSubscribe(C3684d dVar) {
            if (C0310e.m833a((AtomicReference<C3684d>) this, dVar)) {
                if (dVar instanceof C0209d) {
                    C0209d dVar2 = (C0209d) dVar;
                    int a = dVar2.mo382a(7);
                    if (a == 1) {
                        this.f469h = a;
                        this.f467f = dVar2;
                        this.f466e = true;
                        this.f463b.mo441c();
                        return;
                    } else if (a == 2) {
                        this.f469h = a;
                        this.f467f = dVar2;
                    }
                }
                dVar.mo408a((long) this.f465d);
            }
        }

        public void onNext(U u) {
            if (this.f469h != 2) {
                this.f463b.mo436a(u, this);
            } else {
                this.f463b.mo441c();
            }
        }

        public void onError(Throwable th) {
            lazySet(C0310e.CANCELLED);
            this.f463b.mo434a(this, th);
        }

        public void onComplete() {
            this.f466e = true;
            this.f463b.mo441c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo433a(long j) {
            if (this.f469h != 1) {
                long j2 = this.f468g + j;
                if (j2 >= ((long) this.f464c)) {
                    this.f468g = 0;
                    ((C3684d) get()).mo408a(j2);
                    return;
                }
                this.f468g = j2;
            }
        }

        public void dispose() {
            C0310e.m831a((AtomicReference<C3684d>) this);
        }
    }

    /* renamed from: a.b.e.e.b.e$b */
    /* compiled from: FlowableFlatMap */
    static final class C0246b<T, U> extends AtomicInteger implements C0344k<T>, C3684d {

        /* renamed from: k */
        static final C0245a<?, ?>[] f470k = new C0245a[0];

        /* renamed from: l */
        static final C0245a<?, ?>[] f471l = new C0245a[0];

        /* renamed from: a */
        final C3683c<? super U> f472a;

        /* renamed from: b */
        final C0181e<? super T, ? extends C3682b<? extends U>> f473b;

        /* renamed from: c */
        final boolean f474c;

        /* renamed from: d */
        final int f475d;

        /* renamed from: e */
        final int f476e;

        /* renamed from: f */
        volatile C0211f<U> f477f;

        /* renamed from: g */
        volatile boolean f478g;

        /* renamed from: h */
        final C0312b f479h = new C0312b();

        /* renamed from: i */
        volatile boolean f480i;

        /* renamed from: j */
        final AtomicReference<C0245a<?, ?>[]> f481j = new AtomicReference<>();

        /* renamed from: m */
        final AtomicLong f482m = new AtomicLong();

        /* renamed from: n */
        C3684d f483n;

        /* renamed from: o */
        long f484o;

        /* renamed from: p */
        long f485p;

        /* renamed from: q */
        int f486q;

        /* renamed from: r */
        int f487r;

        /* renamed from: s */
        final int f488s;

        C0246b(C3683c<? super U> cVar, C0181e<? super T, ? extends C3682b<? extends U>> eVar, boolean z, int i, int i2) {
            this.f472a = cVar;
            this.f473b = eVar;
            this.f474c = z;
            this.f475d = i;
            this.f476e = i2;
            this.f488s = Math.max(1, i >> 1);
            this.f481j.lazySet(f470k);
        }

        public void onSubscribe(C3684d dVar) {
            if (C0310e.m835a(this.f483n, dVar)) {
                this.f483n = dVar;
                this.f472a.onSubscribe(this);
                if (this.f480i) {
                    return;
                }
                if (this.f475d == Integer.MAX_VALUE) {
                    dVar.mo408a(Long.MAX_VALUE);
                } else {
                    dVar.mo408a((long) this.f475d);
                }
            }
        }

        public void onNext(T t) {
            if (!this.f478g) {
                try {
                    C3682b bVar = (C3682b) C0204b.m615a(this.f473b.apply(t), "The mapper returned a null Publisher");
                    if (bVar instanceof Callable) {
                        try {
                            Object call = ((Callable) bVar).call();
                            if (call != null) {
                                mo435a((U) call);
                            } else if (this.f475d != Integer.MAX_VALUE && !this.f480i) {
                                int i = this.f487r + 1;
                                this.f487r = i;
                                if (i == this.f488s) {
                                    this.f487r = 0;
                                    this.f483n.mo408a((long) this.f488s);
                                }
                            }
                        } catch (Throwable th) {
                            C0171b.m584b(th);
                            this.f479h.mo516a(th);
                            mo441c();
                        }
                    } else {
                        long j = this.f484o;
                        this.f484o = 1 + j;
                        C0245a aVar = new C0245a(this, j);
                        if (mo437a(aVar)) {
                            bVar.mo538a(aVar);
                        }
                    }
                } catch (Throwable th2) {
                    C0171b.m584b(th2);
                    this.f483n.mo407a();
                    onError(th2);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo437a(C0245a<T, U> aVar) {
            C0245a<?, ?>[] aVarArr;
            C0245a[] aVarArr2;
            do {
                aVarArr = (C0245a[]) this.f481j.get();
                if (aVarArr == f471l) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new C0245a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f481j.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo439b(C0245a<T, U> aVar) {
            C0245a<T, U>[] aVarArr;
            Object obj;
            do {
                aVarArr = (C0245a[]) this.f481j.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (aVarArr[i2] == aVar) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = f470k;
                        } else {
                            C0245a[] aVarArr2 = new C0245a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                            System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                            obj = aVarArr2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f481j.compareAndSet(aVarArr, obj));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C0212g<U> mo438b() {
            C0211f<U> fVar = this.f477f;
            if (fVar == null) {
                if (this.f475d == Integer.MAX_VALUE) {
                    fVar = new C0279b<>(this.f476e);
                } else {
                    fVar = new C0278a<>(this.f475d);
                }
                this.f477f = fVar;
            }
            return fVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo435a(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.f482m.get();
                C0212g gVar = this.f477f;
                if (j == 0 || (gVar != null && !gVar.mo384b())) {
                    if (gVar == null) {
                        gVar = mo438b();
                    }
                    if (!gVar.mo383a(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.f472a.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.f482m.decrementAndGet();
                    }
                    if (this.f475d != Integer.MAX_VALUE && !this.f480i) {
                        int i = this.f487r + 1;
                        this.f487r = i;
                        if (i == this.f488s) {
                            this.f487r = 0;
                            this.f483n.mo408a((long) this.f488s);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!mo438b().mo383a(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            mo442d();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public C0212g<U> mo440c(C0245a<T, U> aVar) {
            C0212g<U> gVar = aVar.f467f;
            if (gVar != null) {
                return gVar;
            }
            C0278a aVar2 = new C0278a(this.f476e);
            aVar.f467f = aVar2;
            return aVar2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo436a(U u, C0245a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                C0212g gVar = aVar.f467f;
                if (gVar == null) {
                    gVar = new C0278a(this.f476e);
                    aVar.f467f = gVar;
                }
                if (!gVar.mo383a(u)) {
                    onError(new C0172c("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j = this.f482m.get();
                C0212g<U> gVar2 = aVar.f467f;
                if (j == 0 || (gVar2 != null && !gVar2.mo384b())) {
                    if (gVar2 == null) {
                        gVar2 = mo440c(aVar);
                    }
                    if (!gVar2.mo383a(u)) {
                        onError(new C0172c("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.f472a.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.f482m.decrementAndGet();
                    }
                    aVar.mo433a(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            mo442d();
        }

        public void onError(Throwable th) {
            if (this.f478g) {
                C0324a.m885a(th);
                return;
            }
            if (this.f479h.mo516a(th)) {
                this.f478g = true;
                mo441c();
            } else {
                C0324a.m885a(th);
            }
        }

        public void onComplete() {
            if (!this.f478g) {
                this.f478g = true;
                mo441c();
            }
        }

        /* renamed from: a */
        public void mo408a(long j) {
            if (C0310e.m837b(j)) {
                C0313c.m847a(this.f482m, j);
                mo441c();
            }
        }

        /* renamed from: a */
        public void mo407a() {
            if (!this.f480i) {
                this.f480i = true;
                this.f483n.mo407a();
                mo445g();
                if (getAndIncrement() == 0) {
                    C0211f<U> fVar = this.f477f;
                    if (fVar != null) {
                        fVar.mo385c();
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo441c() {
            if (getAndIncrement() == 0) {
                mo442d();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo442d() {
            long j;
            long j2;
            int i;
            long j3;
            boolean z;
            C0245a[] aVarArr;
            int i2;
            int i3;
            C3683c<? super U> cVar = this.f472a;
            int i4 = 1;
            while (!mo443e()) {
                C0211f<U> fVar = this.f477f;
                long j4 = this.f482m.get();
                boolean z2 = j4 == Long.MAX_VALUE;
                if (fVar != null) {
                    j = 0;
                    while (true) {
                        long j5 = 0;
                        Object obj = null;
                        while (true) {
                            if (j4 == 0) {
                                break;
                            }
                            Object e_ = fVar.mo386e_();
                            if (!mo443e()) {
                                if (e_ == null) {
                                    obj = e_;
                                    break;
                                }
                                cVar.onNext(e_);
                                j++;
                                j5++;
                                j4--;
                                obj = e_;
                            } else {
                                return;
                            }
                        }
                        if (j5 != 0) {
                            if (z2) {
                                j4 = Long.MAX_VALUE;
                            } else {
                                j4 = this.f482m.addAndGet(-j5);
                            }
                        }
                        if (j4 == 0 || obj == null) {
                            break;
                        }
                    }
                } else {
                    j = 0;
                }
                boolean z3 = this.f478g;
                C0211f<U> fVar2 = this.f477f;
                C0245a[] aVarArr2 = (C0245a[]) this.f481j.get();
                int length = aVarArr2.length;
                if (!z3 || ((fVar2 != null && !fVar2.mo384b()) || length != 0)) {
                    if (length != 0) {
                        i = i4;
                        long j6 = this.f485p;
                        int i5 = this.f486q;
                        if (length <= i5 || aVarArr2[i5].f462a != j6) {
                            if (length <= i5) {
                                i5 = 0;
                            }
                            int i6 = i5;
                            for (int i7 = 0; i7 < length && aVarArr2[i6].f462a != j6; i7++) {
                                i6++;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                            }
                            this.f486q = i6;
                            this.f485p = aVarArr2[i6].f462a;
                            i5 = i6;
                        }
                        int i8 = i5;
                        z = false;
                        int i9 = 0;
                        while (true) {
                            if (i9 >= length) {
                                aVarArr = aVarArr2;
                                break;
                            } else if (!mo443e()) {
                                C0245a aVar = aVarArr2[i8];
                                Object obj2 = null;
                                while (!mo443e()) {
                                    C0212g<U> gVar = aVar.f467f;
                                    if (gVar == null) {
                                        aVarArr = aVarArr2;
                                        i2 = length;
                                    } else {
                                        aVarArr = aVarArr2;
                                        i2 = length;
                                        long j7 = 0;
                                        while (j2 != 0) {
                                            try {
                                                obj2 = gVar.mo386e_();
                                                if (obj2 == null) {
                                                    break;
                                                }
                                                cVar.onNext(obj2);
                                                if (!mo443e()) {
                                                    j2--;
                                                    j7++;
                                                } else {
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                Throwable th2 = th;
                                                C0171b.m584b(th2);
                                                aVar.dispose();
                                                this.f479h.mo516a(th2);
                                                if (!this.f474c) {
                                                    this.f483n.mo407a();
                                                }
                                                if (!mo443e()) {
                                                    mo439b(aVar);
                                                    i9++;
                                                    i3 = i2;
                                                    z = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        if (j7 != 0) {
                                            j2 = !z2 ? this.f482m.addAndGet(-j7) : Long.MAX_VALUE;
                                            aVar.mo433a(j7);
                                        }
                                        if (!(j2 == 0 || obj2 == null)) {
                                            aVarArr2 = aVarArr;
                                            length = i2;
                                        }
                                    }
                                    boolean z4 = aVar.f466e;
                                    C0212g<U> gVar2 = aVar.f467f;
                                    if (z4 && (gVar2 == null || gVar2.mo384b())) {
                                        mo439b(aVar);
                                        if (!mo443e()) {
                                            j++;
                                            z = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j2 == 0) {
                                        break;
                                    }
                                    int i10 = i8 + 1;
                                    i3 = i2;
                                    i8 = i10 == i3 ? 0 : i10;
                                    i9++;
                                    length = i3;
                                    aVarArr2 = aVarArr;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        this.f486q = i8;
                        this.f485p = aVarArr[i8].f462a;
                        j3 = j;
                    } else {
                        i = i4;
                        j3 = j;
                        z = false;
                    }
                    if (j3 != 0 && !this.f480i) {
                        this.f483n.mo408a(j3);
                    }
                    if (z) {
                        i4 = i;
                    } else {
                        i4 = addAndGet(-i);
                        if (i4 == 0) {
                            return;
                        }
                    }
                } else {
                    Throwable a = this.f479h.mo515a();
                    if (a != C0315e.f669a) {
                        if (a == null) {
                            cVar.onComplete();
                        } else {
                            cVar.onError(a);
                        }
                    }
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public boolean mo443e() {
            if (this.f480i) {
                mo444f();
                return true;
            } else if (this.f474c || this.f479h.get() == null) {
                return false;
            } else {
                mo444f();
                Throwable a = this.f479h.mo515a();
                if (a != C0315e.f669a) {
                    this.f472a.onError(a);
                }
                return true;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo444f() {
            C0211f<U> fVar = this.f477f;
            if (fVar != null) {
                fVar.mo385c();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo445g() {
            if (((C0245a[]) this.f481j.get()) != f471l) {
                C0245a<?, ?>[] aVarArr = (C0245a[]) this.f481j.getAndSet(f471l);
                if (aVarArr != f471l) {
                    for (C0245a<?, ?> dispose : aVarArr) {
                        dispose.dispose();
                    }
                    Throwable a = this.f479h.mo515a();
                    if (a != null && a != C0315e.f669a) {
                        C0324a.m885a(a);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo434a(C0245a<T, U> aVar, Throwable th) {
            if (this.f479h.mo516a(th)) {
                aVar.f466e = true;
                if (!this.f474c) {
                    this.f483n.mo407a();
                    for (C0245a dispose : (C0245a[]) this.f481j.getAndSet(f471l)) {
                        dispose.dispose();
                    }
                }
                mo441c();
                return;
            }
            C0324a.m885a(th);
        }
    }

    public C0244e(C0330h<T> hVar, C0181e<? super T, ? extends C3682b<? extends U>> eVar, boolean z, int i, int i2) {
        super(hVar);
        this.f458c = eVar;
        this.f459d = z;
        this.f460e = i;
        this.f461f = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo419b(C3683c<? super U> cVar) {
        if (!C0253h.m697a(this.f442b, cVar, this.f458c)) {
            this.f442b.mo537a(m673a(cVar, this.f458c, this.f459d, this.f460e, this.f461f));
        }
    }

    /* renamed from: a */
    public static <T, U> C0344k<T> m673a(C3683c<? super U> cVar, C0181e<? super T, ? extends C3682b<? extends U>> eVar, boolean z, int i, int i2) {
        C0246b bVar = new C0246b(cVar, eVar, z, i, i2);
        return bVar;
    }
}
