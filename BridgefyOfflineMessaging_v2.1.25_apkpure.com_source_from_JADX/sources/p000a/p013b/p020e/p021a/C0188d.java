package p000a.p013b.p020e.p021a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0166a;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p035j.C0315e;

/* renamed from: a.b.e.a.d */
/* compiled from: ListCompositeDisposable */
public final class C0188d implements C0161b, C0185a {

    /* renamed from: a */
    List<C0161b> f393a;

    /* renamed from: b */
    volatile boolean f394b;

    public void dispose() {
        if (!this.f394b) {
            synchronized (this) {
                if (!this.f394b) {
                    this.f394b = true;
                    List<C0161b> list = this.f393a;
                    this.f393a = null;
                    mo387a(list);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo353a(C0161b bVar) {
        C0204b.m615a(bVar, "d is null");
        if (!this.f394b) {
            synchronized (this) {
                if (!this.f394b) {
                    List list = this.f393a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f393a = list;
                    }
                    list.add(bVar);
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
            boolean r0 = r2.f394b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f394b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<a.b.b.b> r0 = r2.f393a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: p000a.p013b.p020e.p021a.C0188d.mo356c(a.b.b.b):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo387a(List<C0161b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (C0161b dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    C0171b.m584b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw C0315e.m852a((Throwable) arrayList.get(0));
            }
            throw new C0166a((Iterable<? extends Throwable>) arrayList);
        }
    }
}
