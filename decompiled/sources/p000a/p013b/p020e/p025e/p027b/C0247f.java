package p000a.p013b.p020e.p025e.p027b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3682b;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0330h;
import p000a.p013b.C0344k;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p034i.C0307b;
import p000a.p013b.p020e.p034i.C0309d;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p037g.C0326a;
import p000a.p013b.p037g.C0328c;
import p000a.p013b.p039i.C0342b;

/* renamed from: a.b.e.e.b.f */
/* compiled from: FlowableRepeatWhen */
public final class C0247f<T> extends C0232a<T, T> {

    /* renamed from: c */
    final C0181e<? super C0330h<Object>, ? extends C3682b<?>> f489c;

    /* renamed from: a.b.e.e.b.f$a */
    /* compiled from: FlowableRepeatWhen */
    static final class C0248a<T> extends C0250c<T, Object> {
        C0248a(C3683c<? super T> cVar, C0326a<Object> aVar, C3684d dVar) {
            super(cVar, aVar, dVar);
        }

        public void onError(Throwable th) {
            this.f496c.mo407a();
            this.f494a.onError(th);
        }

        public void onComplete() {
            mo446a(Integer.valueOf(0));
        }
    }

    /* renamed from: a.b.e.e.b.f$b */
    /* compiled from: FlowableRepeatWhen */
    static final class C0249b<T, U> extends AtomicInteger implements C0344k<Object>, C3684d {

        /* renamed from: a */
        final C3682b<T> f490a;

        /* renamed from: b */
        final AtomicReference<C3684d> f491b = new AtomicReference<>();

        /* renamed from: c */
        final AtomicLong f492c = new AtomicLong();

        /* renamed from: d */
        C0250c<T, U> f493d;

        C0249b(C3682b<T> bVar) {
            this.f490a = bVar;
        }

        public void onSubscribe(C3684d dVar) {
            C0310e.m832a(this.f491b, this.f492c, dVar);
        }

        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (!C0310e.m834a((C3684d) this.f491b.get())) {
                    this.f490a.mo538a(this.f493d);
                    if (decrementAndGet() == 0) {
                    }
                }
            }
        }

        public void onError(Throwable th) {
            this.f493d.mo407a();
            this.f493d.f494a.onError(th);
        }

        public void onComplete() {
            this.f493d.mo407a();
            this.f493d.f494a.onComplete();
        }

        /* renamed from: a */
        public void mo408a(long j) {
            C0310e.m830a(this.f491b, this.f492c, j);
        }

        /* renamed from: a */
        public void mo407a() {
            C0310e.m831a(this.f491b);
        }
    }

    /* renamed from: a.b.e.e.b.f$c */
    /* compiled from: FlowableRepeatWhen */
    static abstract class C0250c<T, U> extends C0309d implements C0344k<T> {

        /* renamed from: a */
        protected final C3683c<? super T> f494a;

        /* renamed from: b */
        protected final C0326a<U> f495b;

        /* renamed from: c */
        protected final C3684d f496c;

        /* renamed from: k */
        private long f497k;

        C0250c(C3683c<? super T> cVar, C0326a<U> aVar, C3684d dVar) {
            this.f494a = cVar;
            this.f495b = aVar;
            this.f496c = dVar;
        }

        public final void onSubscribe(C3684d dVar) {
            mo508a(dVar);
        }

        public final void onNext(T t) {
            this.f497k++;
            this.f494a.onNext(t);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo446a(U u) {
            long j = this.f497k;
            if (j != 0) {
                this.f497k = 0;
                mo510b(j);
            }
            this.f496c.mo408a(1);
            this.f495b.onNext(u);
        }

        /* renamed from: a */
        public final void mo407a() {
            super.mo407a();
            this.f496c.mo407a();
        }
    }

    /* renamed from: b */
    public void mo419b(C3683c<? super T> cVar) {
        C0342b bVar = new C0342b(cVar);
        C0326a c = C0328c.m898a(8).mo528c();
        try {
            C3682b bVar2 = (C3682b) C0204b.m615a(this.f489c.apply(c), "handler returned a null Publisher");
            C0249b bVar3 = new C0249b(this.f442b);
            C0248a aVar = new C0248a(bVar, c, bVar3);
            bVar3.f493d = aVar;
            cVar.onSubscribe(aVar);
            bVar2.mo538a(bVar3);
            bVar3.onNext(Integer.valueOf(0));
        } catch (Throwable th) {
            C0171b.m584b(th);
            C0307b.m808a(th, cVar);
        }
    }
}
