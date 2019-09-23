package p000a.p013b.p037g;

import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.p020e.p035j.C0311a;
import p000a.p013b.p020e.p035j.C0318g;

/* renamed from: a.b.g.b */
/* compiled from: SerializedProcessor */
final class C0327b<T> extends C0326a<T> {

    /* renamed from: b */
    final C0326a<T> f695b;

    /* renamed from: c */
    boolean f696c;

    /* renamed from: d */
    C0311a<Object> f697d;

    /* renamed from: e */
    volatile boolean f698e;

    C0327b(C0326a<T> aVar) {
        this.f695b = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo419b(C3683c<? super T> cVar) {
        this.f695b.mo538a(cVar);
    }

    public void onSubscribe(C3684d dVar) {
        boolean z = true;
        if (!this.f698e) {
            synchronized (this) {
                if (!this.f698e) {
                    if (this.f696c) {
                        C0311a<Object> aVar = this.f697d;
                        if (aVar == null) {
                            aVar = new C0311a<>(4);
                            this.f697d = aVar;
                        }
                        aVar.mo512a(C0318g.m861a(dVar));
                        return;
                    }
                    this.f696c = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.mo407a();
        } else {
            this.f695b.onSubscribe(dVar);
            mo529d();
        }
    }

    public void onNext(T t) {
        if (!this.f698e) {
            synchronized (this) {
                if (!this.f698e) {
                    if (this.f696c) {
                        C0311a<Object> aVar = this.f697d;
                        if (aVar == null) {
                            aVar = new C0311a<>(4);
                            this.f697d = aVar;
                        }
                        aVar.mo512a(C0318g.m859a(t));
                        return;
                    }
                    this.f696c = true;
                    this.f695b.onNext(t);
                    mo529d();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r0 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        p000a.p013b.p036f.C0324a.m885a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r2.f695b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f698e
            if (r0 == 0) goto L_0x0008
            p000a.p013b.p036f.C0324a.m885a(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f698e     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x002e
        L_0x0010:
            r2.f698e = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f696c     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002b
            a.b.e.j.a<java.lang.Object> r0 = r2.f697d     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0022
            a.b.e.j.a r0 = new a.b.e.j.a     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f697d = r0     // Catch:{ all -> 0x003b }
        L_0x0022:
            java.lang.Object r3 = p000a.p013b.p020e.p035j.C0318g.m860a(r3)     // Catch:{ all -> 0x003b }
            r0.mo514b(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002b:
            r0 = 0
            r2.f696c = r1     // Catch:{ all -> 0x003b }
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0035
            p000a.p013b.p036f.C0324a.m885a(r3)
            return
        L_0x0035:
            a.b.g.a<T> r0 = r2.f695b
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p013b.p037g.C0327b.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f698e) {
            synchronized (this) {
                if (!this.f698e) {
                    this.f698e = true;
                    if (this.f696c) {
                        C0311a<Object> aVar = this.f697d;
                        if (aVar == null) {
                            aVar = new C0311a<>(4);
                            this.f697d = aVar;
                        }
                        aVar.mo512a(C0318g.m858a());
                        return;
                    }
                    this.f696c = true;
                    this.f695b.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo529d() {
        C0311a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f697d;
                if (aVar == null) {
                    this.f696c = false;
                    return;
                }
                this.f697d = null;
            }
            aVar.mo513a((C3683c<? super U>) this.f695b);
        }
        while (true) {
        }
    }
}
