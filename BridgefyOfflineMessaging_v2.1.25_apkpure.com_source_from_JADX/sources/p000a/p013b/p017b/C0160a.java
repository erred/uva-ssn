package p000a.p013b.p017b;

import java.util.ArrayList;
import java.util.List;
import p000a.p013b.p018c.C0166a;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p021a.C0185a;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p035j.C0315e;
import p000a.p013b.p020e.p035j.C0321h;

/* renamed from: a.b.b.a */
/* compiled from: CompositeDisposable */
public final class C0160a implements C0161b, C0185a {

    /* renamed from: a */
    C0321h<C0161b> f381a;

    /* renamed from: b */
    volatile boolean f382b;

    public void dispose() {
        if (!this.f382b) {
            synchronized (this) {
                if (!this.f382b) {
                    this.f382b = true;
                    C0321h<C0161b> hVar = this.f381a;
                    this.f381a = null;
                    mo351a(hVar);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo352a() {
        return this.f382b;
    }

    /* renamed from: a */
    public boolean mo353a(C0161b bVar) {
        C0204b.m615a(bVar, "d is null");
        if (!this.f382b) {
            synchronized (this) {
                if (!this.f382b) {
                    C0321h<C0161b> hVar = this.f381a;
                    if (hVar == null) {
                        hVar = new C0321h<>();
                        this.f381a = hVar;
                    }
                    hVar.mo525a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    /* renamed from: b */
    public boolean mo355b(C0161b bVar) {
        if (!mo356c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo356c(p000a.p013b.p017b.C0161b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Disposable item is null"
            p000a.p013b.p020e.p022b.C0204b.m615a(r3, r0)
            boolean r0 = r2.f382b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f382b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            a.b.e.j.h<a.b.b.b> r0 = r2.f381a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.mo526b(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p013b.p017b.C0160a.mo356c(a.b.b.b):boolean");
    }

    /* renamed from: b */
    public void mo354b() {
        if (!this.f382b) {
            synchronized (this) {
                if (!this.f382b) {
                    C0321h<C0161b> hVar = this.f381a;
                    this.f381a = null;
                    mo351a(hVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo351a(C0321h<C0161b> hVar) {
        Object[] b;
        if (hVar != null) {
            List list = null;
            for (Object obj : hVar.mo527b()) {
                if (obj instanceof C0161b) {
                    try {
                        ((C0161b) obj).dispose();
                    } catch (Throwable th) {
                        C0171b.m584b(th);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(th);
                    }
                }
            }
            if (list == null) {
                return;
            }
            if (list.size() == 1) {
                throw C0315e.m852a((Throwable) list.get(0));
            }
            throw new C0166a((Iterable<? extends Throwable>) list);
        }
    }
}
