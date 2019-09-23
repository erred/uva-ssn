package p091b.p092a.p097e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p091b.p092a.C1498b;
import p091b.p092a.C1508c;
import p102c.C1672c;
import p102c.C1675d;
import p102c.C1676e;
import p102c.C1677f;

/* renamed from: b.a.e.g */
/* compiled from: Http2Connection */
public final class C1543g implements Closeable {

    /* renamed from: r */
    static final /* synthetic */ boolean f4699r = (!C1543g.class.desiredAssertionStatus());
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static final ExecutorService f4700s;

    /* renamed from: a */
    final boolean f4701a;

    /* renamed from: b */
    final C1551b f4702b;

    /* renamed from: c */
    final Map<Integer, C1561i> f4703c = new LinkedHashMap();

    /* renamed from: d */
    final String f4704d;

    /* renamed from: e */
    int f4705e;

    /* renamed from: f */
    int f4706f;

    /* renamed from: g */
    boolean f4707g;

    /* renamed from: h */
    final C1568l f4708h;

    /* renamed from: i */
    long f4709i = 0;

    /* renamed from: j */
    long f4710j;

    /* renamed from: k */
    C1570m f4711k = new C1570m();

    /* renamed from: l */
    final C1570m f4712l = new C1570m();

    /* renamed from: m */
    boolean f4713m = false;

    /* renamed from: n */
    final Socket f4714n;

    /* renamed from: o */
    final C1565j f4715o;

    /* renamed from: p */
    final C1554d f4716p;

    /* renamed from: q */
    final Set<Integer> f4717q = new LinkedHashSet();
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final ScheduledExecutorService f4718t;

    /* renamed from: u */
    private final ExecutorService f4719u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f4720v;

    /* renamed from: b.a.e.g$a */
    /* compiled from: Http2Connection */
    public static class C1550a {

        /* renamed from: a */
        Socket f4742a;

        /* renamed from: b */
        String f4743b;

        /* renamed from: c */
        C1676e f4744c;

        /* renamed from: d */
        C1675d f4745d;

        /* renamed from: e */
        C1551b f4746e = C1551b.f4750f;

        /* renamed from: f */
        C1568l f4747f = C1568l.f4813a;

        /* renamed from: g */
        boolean f4748g;

        /* renamed from: h */
        int f4749h;

        public C1550a(boolean z) {
            this.f4748g = z;
        }

        /* renamed from: a */
        public C1550a mo6342a(Socket socket, String str, C1676e eVar, C1675d dVar) {
            this.f4742a = socket;
            this.f4743b = str;
            this.f4744c = eVar;
            this.f4745d = dVar;
            return this;
        }

        /* renamed from: a */
        public C1550a mo6341a(C1551b bVar) {
            this.f4746e = bVar;
            return this;
        }

        /* renamed from: a */
        public C1550a mo6340a(int i) {
            this.f4749h = i;
            return this;
        }

        /* renamed from: a */
        public C1543g mo6343a() {
            return new C1543g(this);
        }
    }

    /* renamed from: b.a.e.g$b */
    /* compiled from: Http2Connection */
    public static abstract class C1551b {

        /* renamed from: f */
        public static final C1551b f4750f = new C1551b() {
            /* renamed from: a */
            public void mo6234a(C1561i iVar) throws IOException {
                iVar.mo6359a(C1535b.REFUSED_STREAM);
            }
        };

        /* renamed from: a */
        public void mo6233a(C1543g gVar) {
        }

        /* renamed from: a */
        public abstract void mo6234a(C1561i iVar) throws IOException;
    }

    /* renamed from: b.a.e.g$c */
    /* compiled from: Http2Connection */
    final class C1553c extends C1498b {

        /* renamed from: a */
        final boolean f4751a;

        /* renamed from: c */
        final int f4752c;

        /* renamed from: d */
        final int f4753d;

        C1553c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", C1543g.this.f4704d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f4751a = z;
            this.f4752c = i;
            this.f4753d = i2;
        }

        /* renamed from: c */
        public void mo6226c() {
            C1543g.this.mo6331a(this.f4751a, this.f4752c, this.f4753d);
        }
    }

    /* renamed from: b.a.e.g$d */
    /* compiled from: Http2Connection */
    class C1554d extends C1498b implements C1560b {

        /* renamed from: a */
        final C1558h f4755a;

        /* renamed from: a */
        public void mo6344a() {
        }

        /* renamed from: a */
        public void mo6345a(int i, int i2, int i3, boolean z) {
        }

        C1554d(C1558h hVar) {
            super("OkHttp %s", C1543g.this.f4704d);
            this.f4755a = hVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:12|11|14|15|(7:16|17|18|19|20|21|23)) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001e */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo6226c() {
            /*
                r5 = this;
                b.a.e.b r0 = p091b.p092a.p097e.C1535b.INTERNAL_ERROR
                b.a.e.b r1 = p091b.p092a.p097e.C1535b.INTERNAL_ERROR
                b.a.e.h r2 = r5.f4755a     // Catch:{ IOException -> 0x001e }
                r2.mo6354a(r5)     // Catch:{ IOException -> 0x001e }
            L_0x0009:
                b.a.e.h r2 = r5.f4755a     // Catch:{ IOException -> 0x001e }
                r3 = 0
                boolean r2 = r2.mo6355a(r3, r5)     // Catch:{ IOException -> 0x001e }
                if (r2 == 0) goto L_0x0013
                goto L_0x0009
            L_0x0013:
                b.a.e.b r2 = p091b.p092a.p097e.C1535b.NO_ERROR     // Catch:{ IOException -> 0x001e }
                b.a.e.b r0 = p091b.p092a.p097e.C1535b.CANCEL     // Catch:{ IOException -> 0x001a }
                b.a.e.g r1 = p091b.p092a.p097e.C1543g.this     // Catch:{ IOException -> 0x0027 }
                goto L_0x0024
            L_0x001a:
                r0 = r2
                goto L_0x001e
            L_0x001c:
                r2 = move-exception
                goto L_0x0031
            L_0x001e:
                b.a.e.b r2 = p091b.p092a.p097e.C1535b.PROTOCOL_ERROR     // Catch:{ all -> 0x001c }
                b.a.e.b r0 = p091b.p092a.p097e.C1535b.PROTOCOL_ERROR     // Catch:{ all -> 0x002d }
                b.a.e.g r1 = p091b.p092a.p097e.C1543g.this     // Catch:{ IOException -> 0x0027 }
            L_0x0024:
                r1.mo6329a(r2, r0)     // Catch:{ IOException -> 0x0027 }
            L_0x0027:
                b.a.e.h r0 = r5.f4755a
                p091b.p092a.C1508c.m6082a(r0)
                return
            L_0x002d:
                r0 = move-exception
                r4 = r2
                r2 = r0
                r0 = r4
            L_0x0031:
                b.a.e.g r3 = p091b.p092a.p097e.C1543g.this     // Catch:{ IOException -> 0x0036 }
                r3.mo6329a(r0, r1)     // Catch:{ IOException -> 0x0036 }
            L_0x0036:
                b.a.e.h r0 = r5.f4755a
                p091b.p092a.C1508c.m6082a(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1543g.C1554d.mo6226c():void");
        }

        /* renamed from: a */
        public void mo6352a(boolean z, int i, C1676e eVar, int i2) throws IOException {
            if (C1543g.this.mo6337c(i)) {
                C1543g.this.mo6323a(i, eVar, i2, z);
                return;
            }
            C1561i a = C1543g.this.mo6319a(i);
            if (a == null) {
                C1543g.this.mo6322a(i, C1535b.PROTOCOL_ERROR);
                eVar.mo6850h((long) i2);
                return;
            }
            a.mo6360a(eVar, i2);
            if (z) {
                a.mo6371i();
            }
        }

        /* JADX INFO: used method not loaded: b.a.e.i.a(java.util.List):null, types can be incorrect */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
            r0.mo6361a((java.util.List) r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
            if (r10 == false) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
            r0.mo6371i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo6351a(boolean r10, int r11, int r12, java.util.List<p091b.p092a.p097e.C1536c> r13) {
            /*
                r9 = this;
                b.a.e.g r12 = p091b.p092a.p097e.C1543g.this
                boolean r12 = r12.mo6337c(r11)
                if (r12 == 0) goto L_0x000e
                b.a.e.g r12 = p091b.p092a.p097e.C1543g.this
                r12.mo6325a(r11, r13, r10)
                return
            L_0x000e:
                b.a.e.g r12 = p091b.p092a.p097e.C1543g.this
                monitor-enter(r12)
                b.a.e.g r0 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                b.a.e.i r0 = r0.mo6319a(r11)     // Catch:{ all -> 0x007a }
                if (r0 != 0) goto L_0x0070
                b.a.e.g r0 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                boolean r0 = r0.f4707g     // Catch:{ all -> 0x007a }
                if (r0 == 0) goto L_0x0021
                monitor-exit(r12)     // Catch:{ all -> 0x007a }
                return
            L_0x0021:
                b.a.e.g r0 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                int r0 = r0.f4705e     // Catch:{ all -> 0x007a }
                if (r11 > r0) goto L_0x0029
                monitor-exit(r12)     // Catch:{ all -> 0x007a }
                return
            L_0x0029:
                int r0 = r11 % 2
                b.a.e.g r1 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                int r1 = r1.f4706f     // Catch:{ all -> 0x007a }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x0035
                monitor-exit(r12)     // Catch:{ all -> 0x007a }
                return
            L_0x0035:
                b.a.e.i r0 = new b.a.e.i     // Catch:{ all -> 0x007a }
                b.a.e.g r5 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                r6 = 0
                r3 = r0
                r4 = r11
                r7 = r10
                r8 = r13
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007a }
                b.a.e.g r10 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                r10.f4705e = r11     // Catch:{ all -> 0x007a }
                b.a.e.g r10 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                java.util.Map<java.lang.Integer, b.a.e.i> r10 = r10.f4703c     // Catch:{ all -> 0x007a }
                java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007a }
                r10.put(r13, r0)     // Catch:{ all -> 0x007a }
                java.util.concurrent.ExecutorService r10 = p091b.p092a.p097e.C1543g.f4700s     // Catch:{ all -> 0x007a }
                b.a.e.g$d$1 r13 = new b.a.e.g$d$1     // Catch:{ all -> 0x007a }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007a }
                r3 = 0
                b.a.e.g r4 = p091b.p092a.p097e.C1543g.this     // Catch:{ all -> 0x007a }
                java.lang.String r4 = r4.f4704d     // Catch:{ all -> 0x007a }
                r2[r3] = r4     // Catch:{ all -> 0x007a }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007a }
                r2[r3] = r11     // Catch:{ all -> 0x007a }
                r13.<init>(r1, r2, r0)     // Catch:{ all -> 0x007a }
                r10.execute(r13)     // Catch:{ all -> 0x007a }
                monitor-exit(r12)     // Catch:{ all -> 0x007a }
                return
            L_0x0070:
                monitor-exit(r12)     // Catch:{ all -> 0x007a }
                r0.mo6361a(r13)
                if (r10 == 0) goto L_0x0079
                r0.mo6371i()
            L_0x0079:
                return
            L_0x007a:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x007a }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1543g.C1554d.mo6351a(boolean, int, int, java.util.List):void");
        }

        /* renamed from: a */
        public void mo6348a(int i, C1535b bVar) {
            if (C1543g.this.mo6337c(i)) {
                C1543g.this.mo6336c(i, bVar);
                return;
            }
            C1561i b = C1543g.this.mo6332b(i);
            if (b != null) {
                b.mo6364c(bVar);
            }
        }

        /* renamed from: a */
        public void mo6353a(boolean z, C1570m mVar) {
            C1561i[] iVarArr;
            long j;
            int i;
            synchronized (C1543g.this) {
                int d = C1543g.this.f4712l.mo6410d();
                if (z) {
                    C1543g.this.f4712l.mo6403a();
                }
                C1543g.this.f4712l.mo6404a(mVar);
                m6273a(mVar);
                int d2 = C1543g.this.f4712l.mo6410d();
                iVarArr = null;
                if (d2 == -1 || d2 == d) {
                    j = 0;
                } else {
                    j = (long) (d2 - d);
                    if (!C1543g.this.f4713m) {
                        C1543g.this.mo6327a(j);
                        C1543g.this.f4713m = true;
                    }
                    if (!C1543g.this.f4703c.isEmpty()) {
                        iVarArr = (C1561i[]) C1543g.this.f4703c.values().toArray(new C1561i[C1543g.this.f4703c.size()]);
                    }
                }
                C1543g.f4700s.execute(new C1498b("OkHttp %s settings", C1543g.this.f4704d) {
                    /* renamed from: c */
                    public void mo6226c() {
                        C1543g.this.f4702b.mo6233a(C1543g.this);
                    }
                });
            }
            if (iVarArr != null && j != 0) {
                for (C1561i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.mo6358a(j);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m6273a(final C1570m mVar) {
            try {
                C1543g.this.f4718t.execute(new C1498b("OkHttp %s ACK Settings", new Object[]{C1543g.this.f4704d}) {
                    /* renamed from: c */
                    public void mo6226c() {
                        try {
                            C1543g.this.f4715o.mo6386a(mVar);
                        } catch (IOException unused) {
                            C1543g.this.m6237f();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* renamed from: a */
        public void mo6350a(boolean z, int i, int i2) {
            if (z) {
                synchronized (C1543g.this) {
                    C1543g.this.f4720v = false;
                    C1543g.this.notifyAll();
                }
                return;
            }
            try {
                C1543g.this.f4718t.execute(new C1553c(true, i, i2));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* renamed from: a */
        public void mo6349a(int i, C1535b bVar, C1677f fVar) {
            C1561i[] iVarArr;
            fVar.mo6902h();
            synchronized (C1543g.this) {
                iVarArr = (C1561i[]) C1543g.this.f4703c.values().toArray(new C1561i[C1543g.this.f4703c.size()]);
                C1543g.this.f4707g = true;
            }
            for (C1561i iVar : iVarArr) {
                if (iVar.mo6357a() > i && iVar.mo6365c()) {
                    iVar.mo6364c(C1535b.REFUSED_STREAM);
                    C1543g.this.mo6332b(iVar.mo6357a());
                }
            }
        }

        /* renamed from: a */
        public void mo6347a(int i, long j) {
            if (i == 0) {
                synchronized (C1543g.this) {
                    C1543g.this.f4710j += j;
                    C1543g.this.notifyAll();
                }
                return;
            }
            C1561i a = C1543g.this.mo6319a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo6358a(j);
                }
            }
        }

        /* renamed from: a */
        public void mo6346a(int i, int i2, List<C1536c> list) {
            C1543g.this.mo6324a(i2, list);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo6337c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1508c.m6080a("OkHttp Http2Connection", true));
        f4700s = threadPoolExecutor;
    }

    C1543g(C1550a aVar) {
        C1550a aVar2 = aVar;
        this.f4708h = aVar2.f4747f;
        this.f4701a = aVar2.f4748g;
        this.f4702b = aVar2.f4746e;
        this.f4706f = aVar2.f4748g ? 1 : 2;
        if (aVar2.f4748g) {
            this.f4706f += 2;
        }
        if (aVar2.f4748g) {
            this.f4711k.mo6402a(7, 16777216);
        }
        this.f4704d = aVar2.f4743b;
        this.f4718t = new ScheduledThreadPoolExecutor(1, C1508c.m6080a(C1508c.m6075a("OkHttp %s Writer", this.f4704d), false));
        if (aVar2.f4749h != 0) {
            this.f4718t.scheduleAtFixedRate(new C1553c(false, 0, 0), (long) aVar2.f4749h, (long) aVar2.f4749h, TimeUnit.MILLISECONDS);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C1508c.m6080a(C1508c.m6075a("OkHttp %s Push Observer", this.f4704d), true));
        this.f4719u = threadPoolExecutor;
        this.f4712l.mo6402a(7, 65535);
        this.f4712l.mo6402a(5, 16384);
        this.f4710j = (long) this.f4712l.mo6410d();
        this.f4714n = aVar2.f4742a;
        this.f4715o = new C1565j(aVar2.f4745d, this.f4701a);
        this.f4716p = new C1554d(new C1558h(aVar2.f4744c, this.f4701a));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized C1561i mo6319a(int i) {
        return (C1561i) this.f4703c.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized C1561i mo6332b(int i) {
        C1561i iVar;
        iVar = (C1561i) this.f4703c.remove(Integer.valueOf(i));
        notifyAll();
        return iVar;
    }

    /* renamed from: a */
    public synchronized int mo6318a() {
        return this.f4712l.mo6409c(BaseClientBuilder.API_PRIORITY_OTHER);
    }

    /* renamed from: a */
    public C1561i mo6320a(List<C1536c> list, boolean z) throws IOException {
        return m6234b(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p091b.p092a.p097e.C1561i m6234b(int r11, java.util.List<p091b.p092a.p097e.C1536c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            b.a.e.j r7 = r10.f4715o
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0078 }
            int r0 = r10.f4706f     // Catch:{ all -> 0x0075 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            b.a.e.b r0 = p091b.p092a.p097e.C1535b.REFUSED_STREAM     // Catch:{ all -> 0x0075 }
            r10.mo6328a(r0)     // Catch:{ all -> 0x0075 }
        L_0x0013:
            boolean r0 = r10.f4707g     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x006f
            int r8 = r10.f4706f     // Catch:{ all -> 0x0075 }
            int r0 = r10.f4706f     // Catch:{ all -> 0x0075 }
            int r0 = r0 + 2
            r10.f4706f = r0     // Catch:{ all -> 0x0075 }
            b.a.e.i r9 = new b.a.e.i     // Catch:{ all -> 0x0075 }
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
            if (r13 == 0) goto L_0x003c
            long r0 = r10.f4710j     // Catch:{ all -> 0x0075 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003c
            long r0 = r9.f4775b     // Catch:{ all -> 0x0075 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x003d
        L_0x003c:
            r13 = 1
        L_0x003d:
            boolean r0 = r9.mo6363b()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, b.a.e.i> r0 = r10.f4703c     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0075 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0075 }
        L_0x004c:
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0055
            b.a.e.j r0 = r10.f4715o     // Catch:{ all -> 0x0078 }
            r0.mo6388a(r6, r8, r11, r12)     // Catch:{ all -> 0x0078 }
            goto L_0x005e
        L_0x0055:
            boolean r0 = r10.f4701a     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0067
            b.a.e.j r0 = r10.f4715o     // Catch:{ all -> 0x0078 }
            r0.mo6382a(r11, r8, r12)     // Catch:{ all -> 0x0078 }
        L_0x005e:
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0066
            b.a.e.j r11 = r10.f4715o
            r11.mo6391b()
        L_0x0066:
            return r9
        L_0x0067:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x006f:
            b.a.e.a r11 = new b.a.e.a     // Catch:{ all -> 0x0075 }
            r11.<init>()     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1543g.m6234b(int, java.util.List, boolean):b.a.e.i");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f4710j), r8.f4715o.mo6393c());
        r6 = (long) r3;
        r8.f4710j -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6326a(int r9, boolean r10, p102c.C1672c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            b.a.e.j r12 = r8.f4715o
            r12.mo6389a(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0063
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f4710j     // Catch:{ InterruptedException -> 0x005b }
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, b.a.e.i> r3 = r8.f4703c     // Catch:{ InterruptedException -> 0x005b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005b }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005b }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005b }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005b }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005b }
            throw r9     // Catch:{ InterruptedException -> 0x005b }
        L_0x0030:
            long r3 = r8.f4710j     // Catch:{ all -> 0x0059 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0059 }
            int r3 = (int) r3     // Catch:{ all -> 0x0059 }
            b.a.e.j r4 = r8.f4715o     // Catch:{ all -> 0x0059 }
            int r4 = r4.mo6393c()     // Catch:{ all -> 0x0059 }
            int r3 = java.lang.Math.min(r3, r4)     // Catch:{ all -> 0x0059 }
            long r4 = r8.f4710j     // Catch:{ all -> 0x0059 }
            long r6 = (long) r3     // Catch:{ all -> 0x0059 }
            long r4 = r4 - r6
            r8.f4710j = r4     // Catch:{ all -> 0x0059 }
            monitor-exit(r8)     // Catch:{ all -> 0x0059 }
            r4 = 0
            long r12 = r12 - r6
            b.a.e.j r4 = r8.f4715o
            if (r10 == 0) goto L_0x0054
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0054
            r5 = 1
            goto L_0x0055
        L_0x0054:
            r5 = 0
        L_0x0055:
            r4.mo6389a(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0059:
            r9 = move-exception
            goto L_0x0061
        L_0x005b:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0059 }
            r9.<init>()     // Catch:{ all -> 0x0059 }
            throw r9     // Catch:{ all -> 0x0059 }
        L_0x0061:
            monitor-exit(r8)     // Catch:{ all -> 0x0059 }
            throw r9
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1543g.mo6326a(int, boolean, c.c, long):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6327a(long j) {
        this.f4710j += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6322a(int i, C1535b bVar) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f4718t;
            final int i2 = i;
            final C1535b bVar2 = bVar;
            C15441 r1 = new C1498b("OkHttp %s stream %d", new Object[]{this.f4704d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo6226c() {
                    try {
                        C1543g.this.mo6334b(i2, bVar2);
                    } catch (IOException unused) {
                        C1543g.this.m6237f();
                    }
                }
            };
            scheduledExecutorService.execute(r1);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6334b(int i, C1535b bVar) throws IOException {
        this.f4715o.mo6384a(i, bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6321a(int i, long j) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f4718t;
            final int i2 = i;
            final long j2 = j;
            C15452 r1 = new C1498b("OkHttp Window Update %s stream %d", new Object[]{this.f4704d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo6226c() {
                    try {
                        C1543g.this.f4715o.mo6383a(i2, j2);
                    } catch (IOException unused) {
                        C1543g.this.m6237f();
                    }
                }
            };
            scheduledExecutorService.execute(r1);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6331a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f4720v;
                this.f4720v = true;
            }
            if (z2) {
                m6237f();
                return;
            }
        }
        try {
            this.f4715o.mo6387a(z, i, i2);
        } catch (IOException unused) {
            m6237f();
        }
    }

    /* renamed from: b */
    public void mo6333b() throws IOException {
        this.f4715o.mo6391b();
    }

    /* renamed from: a */
    public void mo6328a(C1535b bVar) throws IOException {
        synchronized (this.f4715o) {
            synchronized (this) {
                if (!this.f4707g) {
                    this.f4707g = true;
                    int i = this.f4705e;
                    this.f4715o.mo6385a(i, bVar, C1508c.f4560a);
                }
            }
        }
    }

    public void close() throws IOException {
        mo6329a(C1535b.NO_ERROR, C1535b.CANCEL);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6329a(C1535b bVar, C1535b bVar2) throws IOException {
        if (f4699r || !Thread.holdsLock(this)) {
            C1561i[] iVarArr = null;
            try {
                mo6328a(bVar);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.f4703c.isEmpty()) {
                    iVarArr = (C1561i[]) this.f4703c.values().toArray(new C1561i[this.f4703c.size()]);
                    this.f4703c.clear();
                }
            }
            if (iVarArr != null) {
                for (C1561i a : iVarArr) {
                    try {
                        a.mo6359a(bVar2);
                    } catch (IOException e2) {
                        if (e != null) {
                            e = e2;
                        }
                    }
                }
            }
            try {
                this.f4715o.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.f4714n.close();
            } catch (IOException e4) {
                e = e4;
            }
            this.f4718t.shutdown();
            this.f4719u.shutdown();
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m6237f() {
        try {
            mo6329a(C1535b.PROTOCOL_ERROR, C1535b.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    /* renamed from: c */
    public void mo6335c() throws IOException {
        mo6330a(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6330a(boolean z) throws IOException {
        if (z) {
            this.f4715o.mo6379a();
            this.f4715o.mo6392b(this.f4711k);
            int d = this.f4711k.mo6410d();
            if (d != 65535) {
                this.f4715o.mo6383a(0, (long) (d - 65535));
            }
        }
        new Thread(this.f4716p).start();
    }

    /* renamed from: d */
    public synchronized boolean mo6339d() {
        return this.f4707g;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = r8.f4719u;
        r2 = r8;
        r5 = r9;
        r6 = r10;
        r1 = new p091b.p092a.p097e.C1543g.C15463(r2, "OkHttp %s Push Request[%s]", new java.lang.Object[]{r8.f4704d, java.lang.Integer.valueOf(r9)});
        r0.execute(r1);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6324a(int r9, java.util.List<p091b.p092a.p097e.C1536c> r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Set<java.lang.Integer> r0 = r8.f4717q     // Catch:{ all -> 0x003e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x003e }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0014
            b.a.e.b r10 = p091b.p092a.p097e.C1535b.PROTOCOL_ERROR     // Catch:{ all -> 0x003e }
            r8.mo6322a(r9, r10)     // Catch:{ all -> 0x003e }
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            return
        L_0x0014:
            java.util.Set<java.lang.Integer> r0 = r8.f4717q     // Catch:{ all -> 0x003e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            java.util.concurrent.ExecutorService r0 = r8.f4719u     // Catch:{ RejectedExecutionException -> 0x003d }
            b.a.e.g$3 r7 = new b.a.e.g$3     // Catch:{ RejectedExecutionException -> 0x003d }
            java.lang.String r3 = "OkHttp %s Push Request[%s]"
            r1 = 2
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ RejectedExecutionException -> 0x003d }
            r1 = 0
            java.lang.String r2 = r8.f4704d     // Catch:{ RejectedExecutionException -> 0x003d }
            r4[r1] = r2     // Catch:{ RejectedExecutionException -> 0x003d }
            r1 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)     // Catch:{ RejectedExecutionException -> 0x003d }
            r4[r1] = r2     // Catch:{ RejectedExecutionException -> 0x003d }
            r1 = r7
            r2 = r8
            r5 = r9
            r6 = r10
            r1.<init>(r3, r4, r5, r6)     // Catch:{ RejectedExecutionException -> 0x003d }
            r0.execute(r7)     // Catch:{ RejectedExecutionException -> 0x003d }
        L_0x003d:
            return
        L_0x003e:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x003e }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1543g.mo6324a(int, java.util.List):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6325a(int i, List<C1536c> list, boolean z) {
        try {
            ExecutorService executorService = this.f4719u;
            final int i2 = i;
            final List<C1536c> list2 = list;
            final boolean z2 = z;
            C15474 r1 = new C1498b("OkHttp %s Push Headers[%s]", new Object[]{this.f4704d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo6226c() {
                    boolean a = C1543g.this.f4708h.mo6401a(i2, list2, z2);
                    if (a) {
                        try {
                            C1543g.this.f4715o.mo6384a(i2, C1535b.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (a || z2) {
                        synchronized (C1543g.this) {
                            C1543g.this.f4717q.remove(Integer.valueOf(i2));
                        }
                    }
                }
            };
            executorService.execute(r1);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6323a(int i, C1676e eVar, int i2, boolean z) throws IOException {
        final C1672c cVar = new C1672c();
        long j = (long) i2;
        eVar.mo6818a(j);
        eVar.mo6185a(cVar, j);
        if (cVar.mo6823b() == j) {
            ExecutorService executorService = this.f4719u;
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            C15485 r0 = new C1498b("OkHttp %s Push Data[%s]", new Object[]{this.f4704d, Integer.valueOf(i)}) {
                /* renamed from: c */
                public void mo6226c() {
                    try {
                        boolean a = C1543g.this.f4708h.mo6399a(i3, cVar, i4, z2);
                        if (a) {
                            C1543g.this.f4715o.mo6384a(i3, C1535b.CANCEL);
                        }
                        if (a || z2) {
                            synchronized (C1543g.this) {
                                C1543g.this.f4717q.remove(Integer.valueOf(i3));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            };
            executorService.execute(r0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.mo6823b());
        sb.append(" != ");
        sb.append(i2);
        throw new IOException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo6336c(int i, C1535b bVar) {
        ExecutorService executorService = this.f4719u;
        final int i2 = i;
        final C1535b bVar2 = bVar;
        C15496 r1 = new C1498b("OkHttp %s Push Reset[%s]", new Object[]{this.f4704d, Integer.valueOf(i)}) {
            /* renamed from: c */
            public void mo6226c() {
                C1543g.this.f4708h.mo6398a(i2, bVar2);
                synchronized (C1543g.this) {
                    C1543g.this.f4717q.remove(Integer.valueOf(i2));
                }
            }
        };
        executorService.execute(r1);
    }
}
