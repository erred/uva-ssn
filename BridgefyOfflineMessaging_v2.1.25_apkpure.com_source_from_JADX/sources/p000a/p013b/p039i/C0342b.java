package p000a.p013b.p039i;

import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0344k;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p020e.p035j.C0311a;
import p000a.p013b.p020e.p035j.C0318g;

/* renamed from: a.b.i.b */
/* compiled from: SerializedSubscriber */
public final class C0342b<T> implements C0344k<T>, C3684d {

    /* renamed from: a */
    final C3683c<? super T> f721a;

    /* renamed from: b */
    final boolean f722b;

    /* renamed from: c */
    C3684d f723c;

    /* renamed from: d */
    boolean f724d;

    /* renamed from: e */
    C0311a<Object> f725e;

    /* renamed from: f */
    volatile boolean f726f;

    public C0342b(C3683c<? super T> cVar) {
        this(cVar, false);
    }

    public C0342b(C3683c<? super T> cVar, boolean z) {
        this.f721a = cVar;
        this.f722b = z;
    }

    public void onSubscribe(C3684d dVar) {
        if (C0310e.m835a(this.f723c, dVar)) {
            this.f723c = dVar;
            this.f721a.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        if (!this.f726f) {
            if (t == null) {
                this.f723c.mo407a();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f726f) {
                    if (this.f724d) {
                        C0311a<Object> aVar = this.f725e;
                        if (aVar == null) {
                            aVar = new C0311a<>(4);
                            this.f725e = aVar;
                        }
                        aVar.mo512a(C0318g.m859a(t));
                        return;
                    }
                    this.f724d = true;
                    this.f721a.onNext(t);
                    mo552b();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        p000a.p013b.p036f.C0324a.m885a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f721a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f726f
            if (r0 == 0) goto L_0x0008
            p000a.p013b.p036f.C0324a.m885a(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f726f     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f724d     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f726f = r1     // Catch:{ all -> 0x0044 }
            a.b.e.j.a<java.lang.Object> r0 = r2.f725e     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            a.b.e.j.a r0 = new a.b.e.j.a     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f725e = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = p000a.p013b.p020e.p035j.C0318g.m860a(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f722b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.mo512a(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.mo514b(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f726f = r1     // Catch:{ all -> 0x0044 }
            r2.f724d = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            p000a.p013b.p036f.C0324a.m885a(r3)
            return
        L_0x003e:
            org.a.c<? super T> r0 = r2.f721a
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p013b.p039i.C0342b.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f726f) {
            synchronized (this) {
                if (!this.f726f) {
                    if (this.f724d) {
                        C0311a<Object> aVar = this.f725e;
                        if (aVar == null) {
                            aVar = new C0311a<>(4);
                            this.f725e = aVar;
                        }
                        aVar.mo512a(C0318g.m858a());
                        return;
                    }
                    this.f726f = true;
                    this.f724d = true;
                    this.f721a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo552b() {
        C0311a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f725e;
                if (aVar == null) {
                    this.f724d = false;
                    return;
                }
                this.f725e = null;
            }
        } while (!aVar.mo513a(this.f721a));
    }

    /* renamed from: a */
    public void mo408a(long j) {
        this.f723c.mo408a(j);
    }

    /* renamed from: a */
    public void mo407a() {
        this.f723c.mo407a();
    }
}
