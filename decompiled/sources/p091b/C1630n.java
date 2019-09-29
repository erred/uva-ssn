package p091b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p091b.p092a.C1508c;

/* renamed from: b.n */
/* compiled from: Dispatcher */
public final class C1630n {

    /* renamed from: a */
    private int f5135a = 64;

    /* renamed from: b */
    private int f5136b = 5;

    /* renamed from: c */
    private Runnable f5137c;

    /* renamed from: d */
    private ExecutorService f5138d;

    /* renamed from: e */
    private final Deque<C1656a> f5139e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<C1656a> f5140f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<C1655z> f5141g = new ArrayDeque();

    /* renamed from: a */
    public synchronized ExecutorService mo6602a() {
        if (this.f5138d == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1508c.m6080a("OkHttp Dispatcher", false));
            this.f5138d = threadPoolExecutor;
        }
        return this.f5138d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo6603a(C1656a aVar) {
        if (this.f5140f.size() >= this.f5135a || m6662c(aVar) >= this.f5136b) {
            this.f5139e.add(aVar);
        } else {
            this.f5140f.add(aVar);
            mo6602a().execute(aVar);
        }
    }

    /* renamed from: c */
    private void m6663c() {
        if (this.f5140f.size() < this.f5135a && !this.f5139e.isEmpty()) {
            Iterator it = this.f5139e.iterator();
            while (it.hasNext()) {
                C1656a aVar = (C1656a) it.next();
                if (m6662c(aVar) < this.f5136b) {
                    it.remove();
                    this.f5140f.add(aVar);
                    mo6602a().execute(aVar);
                }
                if (this.f5140f.size() >= this.f5135a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m6662c(C1656a aVar) {
        int i = 0;
        for (C1656a aVar2 : this.f5140f) {
            if (!aVar2.mo6745b().f5271d && aVar2.mo6744a().equals(aVar.mo6744a())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo6604a(C1655z zVar) {
        this.f5141g.add(zVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6606b(C1656a aVar) {
        m6661a(this.f5140f, aVar, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6607b(C1655z zVar) {
        m6661a(this.f5141g, zVar, false);
    }

    /* renamed from: a */
    private <T> void m6661a(Deque<T> deque, T t, boolean z) {
        int b;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m6663c();
                }
                b = mo6605b();
                runnable = this.f5137c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b == 0 && runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: b */
    public synchronized int mo6605b() {
        return this.f5140f.size() + this.f5141g.size();
    }
}
