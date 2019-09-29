package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: a.a.a.a.a.c.j */
/* compiled from: PriorityTask */
public class C0070j implements C0060b<C0073l>, C0069i, C0073l {

    /* renamed from: a */
    private final List<C0073l> f150a = new ArrayList();

    /* renamed from: b */
    private final AtomicBoolean f151b = new AtomicBoolean(false);

    /* renamed from: c */
    private final AtomicReference<Throwable> f152c = new AtomicReference<>(null);

    /* renamed from: c */
    public synchronized Collection<C0073l> mo105c() {
        return Collections.unmodifiableCollection(this.f150a);
    }

    /* renamed from: a */
    public synchronized void mo106c(C0073l lVar) {
        this.f150a.add(lVar);
    }

    /* renamed from: d */
    public boolean mo107d() {
        for (C0073l f : mo105c()) {
            if (!f.mo138f()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public synchronized void mo136b(boolean z) {
        this.f151b.set(z);
    }

    /* renamed from: f */
    public boolean mo138f() {
        return this.f151b.get();
    }

    /* renamed from: b */
    public C0063e mo135b() {
        return C0063e.NORMAL;
    }

    /* renamed from: a */
    public void mo133a(Throwable th) {
        this.f152c.set(th);
    }

    public int compareTo(Object obj) {
        return C0063e.m199a(this, obj);
    }

    /* renamed from: a */
    public static boolean m223a(Object obj) {
        boolean z = false;
        try {
            C0060b bVar = (C0060b) obj;
            C0073l lVar = (C0073l) obj;
            C0069i iVar = (C0069i) obj;
            if (!(bVar == null || lVar == null || iVar == null)) {
                z = true;
            }
            return z;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
