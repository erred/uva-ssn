package p091b.p092a.p097e;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import p102c.C1667a;
import p102c.C1672c;
import p102c.C1676e;
import p102c.C1694r;
import p102c.C1695s;
import p102c.C1696t;

/* renamed from: b.a.e.i */
/* compiled from: Http2Stream */
public final class C1561i {

    /* renamed from: i */
    static final /* synthetic */ boolean f4773i = (!C1561i.class.desiredAssertionStatus());

    /* renamed from: a */
    long f4774a = 0;

    /* renamed from: b */
    long f4775b;

    /* renamed from: c */
    final int f4776c;

    /* renamed from: d */
    final C1543g f4777d;

    /* renamed from: e */
    final C1562a f4778e;

    /* renamed from: f */
    final C1564c f4779f = new C1564c();

    /* renamed from: g */
    final C1564c f4780g = new C1564c();

    /* renamed from: h */
    C1535b f4781h = null;

    /* renamed from: j */
    private final List<C1536c> f4782j;

    /* renamed from: k */
    private List<C1536c> f4783k;

    /* renamed from: l */
    private boolean f4784l;

    /* renamed from: m */
    private final C1563b f4785m;

    /* renamed from: b.a.e.i$a */
    /* compiled from: Http2Stream */
    final class C1562a implements C1694r {

        /* renamed from: c */
        static final /* synthetic */ boolean f4786c = (!C1561i.class.desiredAssertionStatus());

        /* renamed from: a */
        boolean f4787a;

        /* renamed from: b */
        boolean f4788b;

        /* renamed from: e */
        private final C1672c f4790e = new C1672c();

        C1562a() {
        }

        /* renamed from: a_ */
        public void mo6217a_(C1672c cVar, long j) throws IOException {
            if (f4786c || !Thread.holdsLock(C1561i.this)) {
                this.f4790e.mo6217a_(cVar, j);
                while (this.f4790e.mo6823b() >= 16384) {
                    m6335a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m6335a(boolean z) throws IOException {
            long min;
            synchronized (C1561i.this) {
                C1561i.this.f4780g.mo6800c();
                while (C1561i.this.f4775b <= 0 && !this.f4788b && !this.f4787a && C1561i.this.f4781h == null) {
                    try {
                        C1561i.this.mo6374l();
                    } catch (Throwable th) {
                        C1561i.this.f4780g.mo6378b();
                        throw th;
                    }
                }
                C1561i.this.f4780g.mo6378b();
                C1561i.this.mo6373k();
                min = Math.min(C1561i.this.f4775b, this.f4790e.mo6823b());
                C1561i.this.f4775b -= min;
            }
            C1561i.this.f4780g.mo6800c();
            try {
                C1561i.this.f4777d.mo6326a(C1561i.this.f4776c, z && min == this.f4790e.mo6823b(), this.f4790e, min);
            } finally {
                C1561i.this.f4780g.mo6378b();
            }
        }

        public void flush() throws IOException {
            if (f4786c || !Thread.holdsLock(C1561i.this)) {
                synchronized (C1561i.this) {
                    C1561i.this.mo6373k();
                }
                while (this.f4790e.mo6823b() > 0) {
                    m6335a(false);
                    C1561i.this.f4777d.mo6333b();
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public C1696t mo6306a() {
            return C1561i.this.f4780g;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f4789d.f4778e.f4788b != false) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
            if (r8.f4790e.mo6823b() <= 0) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r8.f4790e.mo6823b() <= 0) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            m6335a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f4789d.f4777d.mo6326a(r8.f4789d.f4776c, true, (p102c.C1672c) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
            r2 = r8.f4789d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f4787a = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            r8.f4789d.f4777d.mo6333b();
            r8.f4789d.mo6372j();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                boolean r0 = f4786c
                if (r0 != 0) goto L_0x0013
                b.a.e.i r0 = p091b.p092a.p097e.C1561i.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 != 0) goto L_0x000d
                goto L_0x0013
            L_0x000d:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0013:
                b.a.e.i r0 = p091b.p092a.p097e.C1561i.this
                monitor-enter(r0)
                boolean r1 = r8.f4787a     // Catch:{ all -> 0x0065 }
                if (r1 == 0) goto L_0x001c
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                return
            L_0x001c:
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                b.a.e.i r0 = p091b.p092a.p097e.C1561i.this
                b.a.e.i$a r0 = r0.f4778e
                boolean r0 = r0.f4788b
                r1 = 1
                if (r0 != 0) goto L_0x004f
                c.c r0 = r8.f4790e
                long r2 = r0.mo6823b()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0040
            L_0x0032:
                c.c r0 = r8.f4790e
                long r2 = r0.mo6823b()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x004f
                r8.m6335a(r1)
                goto L_0x0032
            L_0x0040:
                b.a.e.i r0 = p091b.p092a.p097e.C1561i.this
                b.a.e.g r2 = r0.f4777d
                b.a.e.i r0 = p091b.p092a.p097e.C1561i.this
                int r3 = r0.f4776c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.mo6326a(r3, r4, r5, r6)
            L_0x004f:
                b.a.e.i r2 = p091b.p092a.p097e.C1561i.this
                monitor-enter(r2)
                r8.f4787a = r1     // Catch:{ all -> 0x0062 }
                monitor-exit(r2)     // Catch:{ all -> 0x0062 }
                b.a.e.i r0 = p091b.p092a.p097e.C1561i.this
                b.a.e.g r0 = r0.f4777d
                r0.mo6333b()
                b.a.e.i r0 = p091b.p092a.p097e.C1561i.this
                r0.mo6372j()
                return
            L_0x0062:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0062 }
                throw r0
            L_0x0065:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1561i.C1562a.close():void");
        }
    }

    /* renamed from: b.a.e.i$b */
    /* compiled from: Http2Stream */
    private final class C1563b implements C1695s {

        /* renamed from: c */
        static final /* synthetic */ boolean f4791c = (!C1561i.class.desiredAssertionStatus());

        /* renamed from: a */
        boolean f4792a;

        /* renamed from: b */
        boolean f4793b;

        /* renamed from: e */
        private final C1672c f4795e = new C1672c();

        /* renamed from: f */
        private final C1672c f4796f = new C1672c();

        /* renamed from: g */
        private final long f4797g;

        C1563b(long j) {
            this.f4797g = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005e, code lost:
            r10 = r7.f4794d.f4777d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r7.f4794d.f4777d.f4709i += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0082, code lost:
            if (r7.f4794d.f4777d.f4709i < ((long) (r7.f4794d.f4777d.f4711k.mo6410d() / 2))) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
            r7.f4794d.f4777d.mo6321a(0, r7.f4794d.f4777d.f4709i);
            r7.f4794d.f4777d.f4709i = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0098, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0099, code lost:
            return r8;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo6185a(p102c.C1672c r8, long r9) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x00a0
                b.a.e.i r2 = p091b.p092a.p097e.C1561i.this
                monitor-enter(r2)
                r7.m6338b()     // Catch:{ all -> 0x009d }
                r7.m6339c()     // Catch:{ all -> 0x009d }
                c.c r3 = r7.f4796f     // Catch:{ all -> 0x009d }
                long r3 = r3.mo6823b()     // Catch:{ all -> 0x009d }
                int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r3 != 0) goto L_0x001d
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x009d }
                return r8
            L_0x001d:
                c.c r3 = r7.f4796f     // Catch:{ all -> 0x009d }
                c.c r4 = r7.f4796f     // Catch:{ all -> 0x009d }
                long r4 = r4.mo6823b()     // Catch:{ all -> 0x009d }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x009d }
                long r8 = r3.mo6185a(r8, r9)     // Catch:{ all -> 0x009d }
                b.a.e.i r10 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009d }
                long r3 = r10.f4774a     // Catch:{ all -> 0x009d }
                r5 = 0
                long r3 = r3 + r8
                r10.f4774a = r3     // Catch:{ all -> 0x009d }
                b.a.e.i r10 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009d }
                long r3 = r10.f4774a     // Catch:{ all -> 0x009d }
                b.a.e.i r10 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009d }
                b.a.e.g r10 = r10.f4777d     // Catch:{ all -> 0x009d }
                b.a.e.m r10 = r10.f4711k     // Catch:{ all -> 0x009d }
                int r10 = r10.mo6410d()     // Catch:{ all -> 0x009d }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x009d }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x005d
                b.a.e.i r10 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009d }
                b.a.e.g r10 = r10.f4777d     // Catch:{ all -> 0x009d }
                b.a.e.i r3 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009d }
                int r3 = r3.f4776c     // Catch:{ all -> 0x009d }
                b.a.e.i r4 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009d }
                long r4 = r4.f4774a     // Catch:{ all -> 0x009d }
                r10.mo6321a(r3, r4)     // Catch:{ all -> 0x009d }
                b.a.e.i r10 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009d }
                r10.f4774a = r0     // Catch:{ all -> 0x009d }
            L_0x005d:
                monitor-exit(r2)     // Catch:{ all -> 0x009d }
                b.a.e.i r10 = p091b.p092a.p097e.C1561i.this
                b.a.e.g r10 = r10.f4777d
                monitor-enter(r10)
                b.a.e.i r2 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009a }
                b.a.e.g r2 = r2.f4777d     // Catch:{ all -> 0x009a }
                long r3 = r2.f4709i     // Catch:{ all -> 0x009a }
                r5 = 0
                long r3 = r3 + r8
                r2.f4709i = r3     // Catch:{ all -> 0x009a }
                b.a.e.i r2 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009a }
                b.a.e.g r2 = r2.f4777d     // Catch:{ all -> 0x009a }
                long r2 = r2.f4709i     // Catch:{ all -> 0x009a }
                b.a.e.i r4 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009a }
                b.a.e.g r4 = r4.f4777d     // Catch:{ all -> 0x009a }
                b.a.e.m r4 = r4.f4711k     // Catch:{ all -> 0x009a }
                int r4 = r4.mo6410d()     // Catch:{ all -> 0x009a }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x009a }
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x0098
                b.a.e.i r2 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009a }
                b.a.e.g r2 = r2.f4777d     // Catch:{ all -> 0x009a }
                r3 = 0
                b.a.e.i r4 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009a }
                b.a.e.g r4 = r4.f4777d     // Catch:{ all -> 0x009a }
                long r4 = r4.f4709i     // Catch:{ all -> 0x009a }
                r2.mo6321a(r3, r4)     // Catch:{ all -> 0x009a }
                b.a.e.i r2 = p091b.p092a.p097e.C1561i.this     // Catch:{ all -> 0x009a }
                b.a.e.g r2 = r2.f4777d     // Catch:{ all -> 0x009a }
                r2.f4709i = r0     // Catch:{ all -> 0x009a }
            L_0x0098:
                monitor-exit(r10)     // Catch:{ all -> 0x009a }
                return r8
            L_0x009a:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x009a }
                throw r8
            L_0x009d:
                r8 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x009d }
                throw r8
            L_0x00a0:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p097e.C1561i.C1563b.mo6185a(c.c, long):long");
        }

        /* renamed from: b */
        private void m6338b() throws IOException {
            C1561i.this.f4779f.mo6800c();
            while (this.f4796f.mo6823b() == 0 && !this.f4793b && !this.f4792a && C1561i.this.f4781h == null) {
                try {
                    C1561i.this.mo6374l();
                } finally {
                    C1561i.this.f4779f.mo6378b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6375a(C1676e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (f4791c || !Thread.holdsLock(C1561i.this)) {
                while (j > 0) {
                    synchronized (C1561i.this) {
                        z = this.f4793b;
                        z2 = false;
                        z3 = this.f4796f.mo6823b() + j > this.f4797g;
                    }
                    if (z3) {
                        eVar.mo6850h(j);
                        C1561i.this.mo6362b(C1535b.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        eVar.mo6850h(j);
                        return;
                    } else {
                        long a = eVar.mo6185a(this.f4795e, j);
                        if (a != -1) {
                            j -= a;
                            synchronized (C1561i.this) {
                                if (this.f4796f.mo6823b() == 0) {
                                    z2 = true;
                                }
                                this.f4796f.mo6809a((C1695s) this.f4795e);
                                if (z2) {
                                    C1561i.this.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public C1696t mo6186a() {
            return C1561i.this.f4779f;
        }

        public void close() throws IOException {
            synchronized (C1561i.this) {
                this.f4792a = true;
                this.f4796f.mo6870t();
                C1561i.this.notifyAll();
            }
            C1561i.this.mo6372j();
        }

        /* renamed from: c */
        private void m6339c() throws IOException {
            if (this.f4792a) {
                throw new IOException("stream closed");
            } else if (C1561i.this.f4781h != null) {
                throw new C1571n(C1561i.this.f4781h);
            }
        }
    }

    /* renamed from: b.a.e.i$c */
    /* compiled from: Http2Stream */
    class C1564c extends C1667a {
        C1564c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6377a() {
            C1561i.this.mo6362b(C1535b.CANCEL);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public IOException mo6376a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: b */
        public void mo6378b() throws IOException {
            if (mo6801g_()) {
                throw mo6376a(null);
            }
        }
    }

    C1561i(int i, C1543g gVar, boolean z, boolean z2, List<C1536c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f4776c = i;
            this.f4777d = gVar;
            this.f4775b = (long) gVar.f4712l.mo6410d();
            this.f4785m = new C1563b((long) gVar.f4711k.mo6410d());
            this.f4778e = new C1562a();
            this.f4785m.f4793b = z2;
            this.f4778e.f4788b = z;
            this.f4782j = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    /* renamed from: a */
    public int mo6357a() {
        return this.f4776c;
    }

    /* renamed from: b */
    public synchronized boolean mo6363b() {
        if (this.f4781h != null) {
            return false;
        }
        if ((this.f4785m.f4793b || this.f4785m.f4792a) && ((this.f4778e.f4788b || this.f4778e.f4787a) && this.f4784l)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo6365c() {
        if (this.f4777d.f4701a == ((this.f4776c & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: d */
    public synchronized List<C1536c> mo6366d() throws IOException {
        List<C1536c> list;
        if (mo6365c()) {
            this.f4779f.mo6800c();
            while (this.f4783k == null && this.f4781h == null) {
                try {
                    mo6374l();
                } catch (Throwable th) {
                    this.f4779f.mo6378b();
                    throw th;
                }
            }
            this.f4779f.mo6378b();
            list = this.f4783k;
            if (list != null) {
                this.f4783k = null;
            } else {
                throw new C1571n(this.f4781h);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    /* renamed from: e */
    public C1696t mo6367e() {
        return this.f4779f;
    }

    /* renamed from: f */
    public C1696t mo6368f() {
        return this.f4780g;
    }

    /* renamed from: g */
    public C1695s mo6369g() {
        return this.f4785m;
    }

    /* renamed from: h */
    public C1694r mo6370h() {
        synchronized (this) {
            if (!this.f4784l) {
                if (!mo6365c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f4778e;
    }

    /* renamed from: a */
    public void mo6359a(C1535b bVar) throws IOException {
        if (m6316d(bVar)) {
            this.f4777d.mo6334b(this.f4776c, bVar);
        }
    }

    /* renamed from: b */
    public void mo6362b(C1535b bVar) {
        if (m6316d(bVar)) {
            this.f4777d.mo6322a(this.f4776c, bVar);
        }
    }

    /* renamed from: d */
    private boolean m6316d(C1535b bVar) {
        if (f4773i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f4781h != null) {
                    return false;
                }
                if (this.f4785m.f4793b && this.f4778e.f4788b) {
                    return false;
                }
                this.f4781h = bVar;
                notifyAll();
                this.f4777d.mo6332b(this.f4776c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6361a(List<C1536c> list) {
        boolean z;
        if (f4773i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = true;
                this.f4784l = true;
                if (this.f4783k == null) {
                    this.f4783k = list;
                    z = mo6363b();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f4783k);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.f4783k = arrayList;
                }
            }
            if (!z) {
                this.f4777d.mo6332b(this.f4776c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6360a(C1676e eVar, int i) throws IOException {
        if (f4773i || !Thread.holdsLock(this)) {
            this.f4785m.mo6375a(eVar, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo6371i() {
        boolean b;
        if (f4773i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.f4785m.f4793b = true;
                b = mo6363b();
                notifyAll();
            }
            if (!b) {
                this.f4777d.mo6332b(this.f4776c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public synchronized void mo6364c(C1535b bVar) {
        if (this.f4781h == null) {
            this.f4781h = bVar;
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo6372j() throws IOException {
        boolean z;
        boolean b;
        if (f4773i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f4785m.f4793b && this.f4785m.f4792a && (this.f4778e.f4788b || this.f4778e.f4787a);
                b = mo6363b();
            }
            if (z) {
                mo6359a(C1535b.CANCEL);
            } else if (!b) {
                this.f4777d.mo6332b(this.f4776c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6358a(long j) {
        this.f4775b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo6373k() throws IOException {
        if (this.f4778e.f4787a) {
            throw new IOException("stream closed");
        } else if (this.f4778e.f4788b) {
            throw new IOException("stream finished");
        } else if (this.f4781h != null) {
            throw new C1571n(this.f4781h);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo6374l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }
}
