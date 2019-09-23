package p091b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p091b.p092a.C1508c;
import p091b.p092a.p094b.C1501c;
import p091b.p092a.p094b.C1502d;
import p091b.p092a.p094b.C1506g;
import p091b.p092a.p094b.C1506g.C1507a;
import p091b.p092a.p099g.C1583f;

/* renamed from: b.j */
/* compiled from: ConnectionPool */
public final class C1623j {

    /* renamed from: c */
    static final /* synthetic */ boolean f5100c = (!C1623j.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final Executor f5101d;

    /* renamed from: a */
    final C1502d f5102a;

    /* renamed from: b */
    boolean f5103b;

    /* renamed from: e */
    private final int f5104e;

    /* renamed from: f */
    private final long f5105f;

    /* renamed from: g */
    private final Runnable f5106g;

    /* renamed from: h */
    private final Deque<C1501c> f5107h;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1508c.m6080a("OkHttp ConnectionPool", true));
        f5101d = threadPoolExecutor;
    }

    public C1623j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public C1623j(int i, long j, TimeUnit timeUnit) {
        this.f5106g = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                L_0x0000:
                    b.j r0 = p091b.C1623j.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.mo6573a(r1)
                    r2 = -1
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r0 = r0 - r2
                    b.j r2 = p091b.C1623j.this
                    monitor-enter(r2)
                    b.j r3 = p091b.C1623j.this     // Catch:{ InterruptedException -> 0x002b }
                    int r0 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                    r3.wait(r4, r0)     // Catch:{ InterruptedException -> 0x002b }
                    goto L_0x002b
                L_0x0029:
                    r0 = move-exception
                    goto L_0x002d
                L_0x002b:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    goto L_0x0000
                L_0x002d:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p091b.C1623j.C16241.run():void");
            }
        };
        this.f5107h = new ArrayDeque();
        this.f5102a = new C1502d();
        this.f5104e = i;
        this.f5105f = timeUnit.toNanos(j);
        if (j <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("keepAliveDuration <= 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1501c mo6574a(C1482a aVar, C1506g gVar, C1601ae aeVar) {
        if (f5100c || Thread.holdsLock(this)) {
            for (C1501c cVar : this.f5107h) {
                if (cVar.mo6235a(aVar, aeVar)) {
                    gVar.mo6257a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Socket mo6575a(C1482a aVar, C1506g gVar) {
        if (f5100c || Thread.holdsLock(this)) {
            for (C1501c cVar : this.f5107h) {
                if (cVar.mo6235a(aVar, null) && cVar.mo6241e() && cVar != gVar.mo6261c()) {
                    return gVar.mo6256a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6576a(C1501c cVar) {
        if (f5100c || Thread.holdsLock(this)) {
            if (!this.f5103b) {
                this.f5103b = true;
                f5101d.execute(this.f5106g);
            }
            this.f5107h.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo6577b(C1501c cVar) {
        if (!f5100c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.f4517a || this.f5104e == 0) {
            this.f5107h.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo6573a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            C1501c cVar = null;
            int i = 0;
            int i2 = 0;
            for (C1501c cVar2 : this.f5107h) {
                if (m6627a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.f4521e;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f5105f) {
                if (i <= this.f5104e) {
                    if (i > 0) {
                        long j4 = this.f5105f - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f5105f;
                        return j5;
                    } else {
                        this.f5103b = false;
                        return -1;
                    }
                }
            }
            this.f5107h.remove(cVar);
            C1508c.m6083a(cVar.mo6239c());
            return 0;
        }
    }

    /* renamed from: a */
    private int m6627a(C1501c cVar, long j) {
        List<Reference<C1506g>> list = cVar.f4520d;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C1507a aVar = (C1507a) reference;
                StringBuilder sb = new StringBuilder();
                sb.append("A connection to ");
                sb.append(cVar.mo6231a().mo6516a().mo6159a());
                sb.append(" was leaked. Did you forget to close a response body?");
                C1583f.m6443c().mo6424a(sb.toString(), aVar.f4559a);
                list.remove(i);
                cVar.f4517a = true;
                if (list.isEmpty()) {
                    cVar.f4521e = j - this.f5105f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
