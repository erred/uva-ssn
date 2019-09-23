package p091b.p092a.p093a;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p091b.p092a.C1508c;
import p091b.p092a.p098f.C1572a;
import p091b.p092a.p099g.C1583f;
import p102c.C1675d;
import p102c.C1683l;
import p102c.C1694r;
import p102c.C1695s;

/* renamed from: b.a.a.d */
/* compiled from: DiskLruCache */
public final class C1489d implements Closeable, Flushable {

    /* renamed from: a */
    static final Pattern f4467a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: m */
    static final /* synthetic */ boolean f4468m = (!C1489d.class.desiredAssertionStatus());

    /* renamed from: b */
    final C1572a f4469b;

    /* renamed from: c */
    final File f4470c;

    /* renamed from: d */
    final int f4471d;

    /* renamed from: e */
    C1675d f4472e;

    /* renamed from: f */
    final LinkedHashMap<String, C1494b> f4473f = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: g */
    int f4474g;

    /* renamed from: h */
    boolean f4475h;

    /* renamed from: i */
    boolean f4476i;

    /* renamed from: j */
    boolean f4477j;

    /* renamed from: k */
    boolean f4478k;

    /* renamed from: l */
    boolean f4479l;

    /* renamed from: n */
    private final File f4480n;

    /* renamed from: o */
    private final File f4481o;

    /* renamed from: p */
    private final File f4482p;

    /* renamed from: q */
    private final int f4483q;

    /* renamed from: r */
    private long f4484r;

    /* renamed from: s */
    private long f4485s = 0;

    /* renamed from: t */
    private long f4486t = 0;

    /* renamed from: u */
    private final Executor f4487u;

    /* renamed from: v */
    private final Runnable f4488v = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r4.f4489a.f4479l = true;
            r4.f4489a.f4472e = p102c.C1683l.m7032a(p102c.C1683l.m7034a());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                b.a.a.d r0 = p091b.p092a.p093a.C1489d.this
                monitor-enter(r0)
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ all -> 0x0041 }
                boolean r1 = r1.f4476i     // Catch:{ all -> 0x0041 }
                r2 = 1
                r1 = r1 ^ r2
                b.a.a.d r3 = p091b.p092a.p093a.C1489d.this     // Catch:{ all -> 0x0041 }
                boolean r3 = r3.f4477j     // Catch:{ all -> 0x0041 }
                r1 = r1 | r3
                if (r1 == 0) goto L_0x0012
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                return
            L_0x0012:
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ IOException -> 0x0018 }
                r1.mo6202e()     // Catch:{ IOException -> 0x0018 }
                goto L_0x001c
            L_0x0018:
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ all -> 0x0041 }
                r1.f4478k = r2     // Catch:{ all -> 0x0041 }
            L_0x001c:
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ IOException -> 0x002f }
                boolean r1 = r1.mo6198c()     // Catch:{ IOException -> 0x002f }
                if (r1 == 0) goto L_0x003f
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ IOException -> 0x002f }
                r1.mo6197b()     // Catch:{ IOException -> 0x002f }
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ IOException -> 0x002f }
                r3 = 0
                r1.f4474g = r3     // Catch:{ IOException -> 0x002f }
                goto L_0x003f
            L_0x002f:
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ all -> 0x0041 }
                r1.f4479l = r2     // Catch:{ all -> 0x0041 }
                b.a.a.d r1 = p091b.p092a.p093a.C1489d.this     // Catch:{ all -> 0x0041 }
                c.r r2 = p102c.C1683l.m7034a()     // Catch:{ all -> 0x0041 }
                c.d r2 = p102c.C1683l.m7032a(r2)     // Catch:{ all -> 0x0041 }
                r1.f4472e = r2     // Catch:{ all -> 0x0041 }
            L_0x003f:
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                return
            L_0x0041:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p093a.C1489d.C14901.run():void");
        }
    };

    /* renamed from: b.a.a.d$a */
    /* compiled from: DiskLruCache */
    public final class C1492a {

        /* renamed from: a */
        final C1494b f4492a;

        /* renamed from: b */
        final boolean[] f4493b;

        /* renamed from: d */
        private boolean f4495d;

        C1492a(C1494b bVar) {
            this.f4492a = bVar;
            this.f4493b = bVar.f4501e ? null : new boolean[C1489d.this.f4471d];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6208a() {
            if (this.f4492a.f4502f == this) {
                for (int i = 0; i < C1489d.this.f4471d; i++) {
                    try {
                        C1489d.this.f4469b.mo6416d(this.f4492a.f4500d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f4492a.f4502f = null;
            }
        }

        /* renamed from: a */
        public C1694r mo6207a(int i) {
            synchronized (C1489d.this) {
                if (this.f4495d) {
                    throw new IllegalStateException();
                } else if (this.f4492a.f4502f != this) {
                    C1694r a = C1683l.m7034a();
                    return a;
                } else {
                    if (!this.f4492a.f4501e) {
                        this.f4493b[i] = true;
                    }
                    try {
                        C14931 r1 = new C1496e(C1489d.this.f4469b.mo6414b(this.f4492a.f4500d[i])) {
                            /* access modifiers changed from: protected */
                            /* renamed from: a */
                            public void mo6206a(IOException iOException) {
                                synchronized (C1489d.this) {
                                    C1492a.this.mo6208a();
                                }
                            }
                        };
                        return r1;
                    } catch (FileNotFoundException unused) {
                        return C1683l.m7034a();
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo6209b() throws IOException {
            synchronized (C1489d.this) {
                if (!this.f4495d) {
                    if (this.f4492a.f4502f == this) {
                        C1489d.this.mo6194a(this, true);
                    }
                    this.f4495d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* renamed from: c */
        public void mo6210c() throws IOException {
            synchronized (C1489d.this) {
                if (!this.f4495d) {
                    if (this.f4492a.f4502f == this) {
                        C1489d.this.mo6194a(this, false);
                    }
                    this.f4495d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* renamed from: b.a.a.d$b */
    /* compiled from: DiskLruCache */
    private final class C1494b {

        /* renamed from: a */
        final String f4497a;

        /* renamed from: b */
        final long[] f4498b;

        /* renamed from: c */
        final File[] f4499c;

        /* renamed from: d */
        final File[] f4500d;

        /* renamed from: e */
        boolean f4501e;

        /* renamed from: f */
        C1492a f4502f;

        /* renamed from: g */
        long f4503g;

        C1494b(String str) {
            this.f4497a = str;
            this.f4498b = new long[C1489d.this.f4471d];
            this.f4499c = new File[C1489d.this.f4471d];
            this.f4500d = new File[C1489d.this.f4471d];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < C1489d.this.f4471d; i++) {
                sb.append(i);
                this.f4499c[i] = new File(C1489d.this.f4470c, sb.toString());
                sb.append(".tmp");
                this.f4500d[i] = new File(C1489d.this.f4470c, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6213a(String[] strArr) throws IOException {
            if (strArr.length == C1489d.this.f4471d) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f4498b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw m5994b(strArr);
                    }
                }
                return;
            }
            throw m5994b(strArr);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6212a(C1675d dVar) throws IOException {
            for (long l : this.f4498b) {
                dVar.mo6854i(32).mo6860l(l);
            }
        }

        /* renamed from: b */
        private IOException m5994b(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1495c mo6211a() {
            if (Thread.holdsLock(C1489d.this)) {
                C1695s[] sVarArr = new C1695s[C1489d.this.f4471d];
                long[] jArr = (long[]) this.f4498b.clone();
                int i = 0;
                int i2 = 0;
                while (i2 < C1489d.this.f4471d) {
                    try {
                        sVarArr[i2] = C1489d.this.f4469b.mo6412a(this.f4499c[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (i < C1489d.this.f4471d && sVarArr[i] != null) {
                            C1508c.m6082a((Closeable) sVarArr[i]);
                            i++;
                        }
                        try {
                            C1489d.this.mo6195a(this);
                        } catch (IOException unused2) {
                        }
                        return null;
                    }
                }
                C1495c cVar = new C1495c(this.f4497a, this.f4503g, sVarArr, jArr);
                return cVar;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: b.a.a.d$c */
    /* compiled from: DiskLruCache */
    public final class C1495c implements Closeable {

        /* renamed from: b */
        private final String f4506b;

        /* renamed from: c */
        private final long f4507c;

        /* renamed from: d */
        private final C1695s[] f4508d;

        /* renamed from: e */
        private final long[] f4509e;

        C1495c(String str, long j, C1695s[] sVarArr, long[] jArr) {
            this.f4506b = str;
            this.f4507c = j;
            this.f4508d = sVarArr;
            this.f4509e = jArr;
        }

        /* renamed from: a */
        public C1492a mo6214a() throws IOException {
            return C1489d.this.mo6191a(this.f4506b, this.f4507c);
        }

        /* renamed from: a */
        public C1695s mo6215a(int i) {
            return this.f4508d[i];
        }

        public void close() {
            for (C1695s a : this.f4508d) {
                C1508c.m6082a((Closeable) a);
            }
        }
    }

    C1489d(C1572a aVar, File file, int i, int i2, long j, Executor executor) {
        this.f4469b = aVar;
        this.f4470c = file;
        this.f4483q = i;
        this.f4480n = new File(file, "journal");
        this.f4481o = new File(file, "journal.tmp");
        this.f4482p = new File(file, "journal.bkp");
        this.f4471d = i2;
        this.f4484r = j;
        this.f4487u = executor;
    }

    /* renamed from: a */
    public synchronized void mo6193a() throws IOException {
        if (!f4468m) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!this.f4476i) {
            if (this.f4469b.mo6417e(this.f4482p)) {
                if (this.f4469b.mo6417e(this.f4480n)) {
                    this.f4469b.mo6416d(this.f4482p);
                } else {
                    this.f4469b.mo6413a(this.f4482p, this.f4480n);
                }
            }
            if (this.f4469b.mo6417e(this.f4480n)) {
                try {
                    m5972g();
                    m5974i();
                    this.f4476i = true;
                    return;
                } catch (IOException e) {
                    C1583f c = C1583f.m6443c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(this.f4470c);
                    sb.append(" is corrupt: ");
                    sb.append(e.getMessage());
                    sb.append(", removing");
                    c.mo6423a(5, sb.toString(), (Throwable) e);
                    mo6203f();
                    this.f4477j = false;
                } catch (Throwable th) {
                    this.f4477j = false;
                    throw th;
                }
            }
            mo6197b();
            this.f4476i = true;
        }
    }

    /* renamed from: a */
    public static C1489d m5969a(C1572a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C1508c.m6080a("OkHttp DiskLruCache", true));
            C1489d dVar = new C1489d(aVar, file, i, i2, j, threadPoolExecutor);
            return dVar;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r8.f4474g = r1 - r8.f4473f.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        if (r0.mo6844f() == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        mo6197b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        r8.f4472e = m5973h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005b */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0078=Splitter:B:23:0x0078, B:16:0x005b=Splitter:B:16:0x005b} */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5972g() throws java.io.IOException {
        /*
            r8 = this;
            b.a.f.a r0 = r8.f4469b
            java.io.File r1 = r8.f4480n
            c.s r0 = r0.mo6412a(r1)
            c.e r0 = p102c.C1683l.m7033a(r0)
            java.lang.String r1 = r0.mo6867r()     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = r0.mo6867r()     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r0.mo6867r()     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = r0.mo6867r()     // Catch:{ all -> 0x00ac }
            java.lang.String r5 = r0.mo6867r()     // Catch:{ all -> 0x00ac }
            java.lang.String r6 = "libcore.io.DiskLruCache"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x0078
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x0078
            int r6 = r8.f4483q     // Catch:{ all -> 0x00ac }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x00ac }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x0078
            int r3 = r8.f4471d     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x00ac }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x0078
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x0078
            r1 = 0
        L_0x0051:
            java.lang.String r2 = r0.mo6867r()     // Catch:{ EOFException -> 0x005b }
            r8.m5970d(r2)     // Catch:{ EOFException -> 0x005b }
            int r1 = r1 + 1
            goto L_0x0051
        L_0x005b:
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r2 = r8.f4473f     // Catch:{ all -> 0x00ac }
            int r2 = r2.size()     // Catch:{ all -> 0x00ac }
            int r1 = r1 - r2
            r8.f4474g = r1     // Catch:{ all -> 0x00ac }
            boolean r1 = r0.mo6844f()     // Catch:{ all -> 0x00ac }
            if (r1 != 0) goto L_0x006e
            r8.mo6197b()     // Catch:{ all -> 0x00ac }
            goto L_0x0074
        L_0x006e:
            c.d r1 = r8.m5973h()     // Catch:{ all -> 0x00ac }
            r8.f4472e = r1     // Catch:{ all -> 0x00ac }
        L_0x0074:
            p091b.p092a.C1508c.m6082a(r0)
            return
        L_0x0078:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r6.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.String r7 = "unexpected journal header: ["
            r6.append(r7)     // Catch:{ all -> 0x00ac }
            r6.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x00ac }
            r6.append(r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x00ac }
            r6.append(r4)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x00ac }
            r6.append(r5)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "]"
            r6.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x00ac }
            r3.<init>(r1)     // Catch:{ all -> 0x00ac }
            throw r3     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r1 = move-exception
            p091b.p092a.C1508c.m6082a(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p093a.C1489d.m5972g():void");
    }

    /* renamed from: h */
    private C1675d m5973h() throws FileNotFoundException {
        return C1683l.m7032a((C1694r) new C1496e(this.f4469b.mo6415c(this.f4480n)) {

            /* renamed from: a */
            static final /* synthetic */ boolean f4490a = (!C1489d.class.desiredAssertionStatus());

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo6206a(IOException iOException) {
                if (f4490a || Thread.holdsLock(C1489d.this)) {
                    C1489d.this.f4475h = true;
                    return;
                }
                throw new AssertionError();
            }
        });
    }

    /* renamed from: d */
    private void m5970d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                    this.f4473f.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C1494b bVar = (C1494b) this.f4473f.get(str2);
            if (bVar == null) {
                bVar = new C1494b(str2);
                this.f4473f.put(str2, bVar);
            }
            if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                bVar.f4501e = true;
                bVar.f4502f = null;
                bVar.mo6213a(split);
            } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
                bVar.f4502f = new C1492a(bVar);
            } else if (!(indexOf2 == -1 && indexOf == "READ".length() && str.startsWith("READ"))) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal line: ");
                sb.append(str);
                throw new IOException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("unexpected journal line: ");
        sb2.append(str);
        throw new IOException(sb2.toString());
    }

    /* renamed from: i */
    private void m5974i() throws IOException {
        this.f4469b.mo6416d(this.f4481o);
        Iterator it = this.f4473f.values().iterator();
        while (it.hasNext()) {
            C1494b bVar = (C1494b) it.next();
            int i = 0;
            if (bVar.f4502f == null) {
                while (i < this.f4471d) {
                    this.f4485s += bVar.f4498b[i];
                    i++;
                }
            } else {
                bVar.f4502f = null;
                while (i < this.f4471d) {
                    this.f4469b.mo6416d(bVar.f4499c[i]);
                    this.f4469b.mo6416d(bVar.f4500d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo6197b() throws IOException {
        if (this.f4472e != null) {
            this.f4472e.close();
        }
        C1675d a = C1683l.m7032a(this.f4469b.mo6414b(this.f4481o));
        try {
            a.mo6828b("libcore.io.DiskLruCache").mo6854i(10);
            a.mo6828b("1").mo6854i(10);
            a.mo6860l((long) this.f4483q).mo6854i(10);
            a.mo6860l((long) this.f4471d).mo6854i(10);
            a.mo6854i(10);
            for (C1494b bVar : this.f4473f.values()) {
                if (bVar.f4502f != null) {
                    a.mo6828b("DIRTY").mo6854i(32);
                    a.mo6828b(bVar.f4497a);
                    a.mo6854i(10);
                } else {
                    a.mo6828b("CLEAN").mo6854i(32);
                    a.mo6828b(bVar.f4497a);
                    bVar.mo6212a(a);
                    a.mo6854i(10);
                }
            }
            a.close();
            if (this.f4469b.mo6417e(this.f4480n)) {
                this.f4469b.mo6413a(this.f4480n, this.f4482p);
            }
            this.f4469b.mo6413a(this.f4481o, this.f4480n);
            this.f4469b.mo6416d(this.f4482p);
            this.f4472e = m5973h();
            this.f4475h = false;
            this.f4479l = false;
        } catch (Throwable th) {
            a.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p091b.p092a.p093a.C1489d.C1495c mo6192a(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.mo6193a()     // Catch:{ all -> 0x0050 }
            r3.m5975j()     // Catch:{ all -> 0x0050 }
            r3.m5971e(r4)     // Catch:{ all -> 0x0050 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r0 = r3.f4473f     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
            b.a.a.d$b r0 = (p091b.p092a.p093a.C1489d.C1494b) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.f4501e     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            b.a.a.d$c r0 = r0.mo6211a()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.f4474g     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            r3.f4474g = r1     // Catch:{ all -> 0x0050 }
            c.d r1 = r3.f4472e     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "READ"
            c.d r1 = r1.mo6828b(r2)     // Catch:{ all -> 0x0050 }
            r2 = 32
            c.d r1 = r1.mo6854i(r2)     // Catch:{ all -> 0x0050 }
            c.d r4 = r1.mo6828b(r4)     // Catch:{ all -> 0x0050 }
            r1 = 10
            r4.mo6854i(r1)     // Catch:{ all -> 0x0050 }
            boolean r4 = r3.mo6198c()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x004c
            java.util.concurrent.Executor r4 = r3.f4487u     // Catch:{ all -> 0x0050 }
            java.lang.Runnable r1 = r3.f4488v     // Catch:{ all -> 0x0050 }
            r4.execute(r1)     // Catch:{ all -> 0x0050 }
        L_0x004c:
            monitor-exit(r3)
            return r0
        L_0x004e:
            monitor-exit(r3)
            return r1
        L_0x0050:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p093a.C1489d.mo6192a(java.lang.String):b.a.a.d$c");
    }

    /* renamed from: b */
    public C1492a mo6196b(String str) throws IOException {
        return mo6191a(str, -1);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p091b.p092a.p093a.C1489d.C1492a mo6191a(java.lang.String r5, long r6) throws java.io.IOException {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.mo6193a()     // Catch:{ all -> 0x0074 }
            r4.m5975j()     // Catch:{ all -> 0x0074 }
            r4.m5971e(r5)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r0 = r4.f4473f     // Catch:{ all -> 0x0074 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0074 }
            b.a.a.d$b r0 = (p091b.p092a.p093a.C1489d.C1494b) r0     // Catch:{ all -> 0x0074 }
            r1 = -1
            r3 = 0
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0021
            long r1 = r0.f4503g     // Catch:{ all -> 0x0074 }
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0023
        L_0x0021:
            monitor-exit(r4)
            return r3
        L_0x0023:
            if (r0 == 0) goto L_0x002b
            b.a.a.d$a r6 = r0.f4502f     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x002b
            monitor-exit(r4)
            return r3
        L_0x002b:
            boolean r6 = r4.f4478k     // Catch:{ all -> 0x0074 }
            if (r6 != 0) goto L_0x006b
            boolean r6 = r4.f4479l     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            c.d r6 = r4.f4472e     // Catch:{ all -> 0x0074 }
            java.lang.String r7 = "DIRTY"
            c.d r6 = r6.mo6828b(r7)     // Catch:{ all -> 0x0074 }
            r7 = 32
            c.d r6 = r6.mo6854i(r7)     // Catch:{ all -> 0x0074 }
            c.d r6 = r6.mo6828b(r5)     // Catch:{ all -> 0x0074 }
            r7 = 10
            r6.mo6854i(r7)     // Catch:{ all -> 0x0074 }
            c.d r6 = r4.f4472e     // Catch:{ all -> 0x0074 }
            r6.flush()     // Catch:{ all -> 0x0074 }
            boolean r6 = r4.f4475h     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0056
            monitor-exit(r4)
            return r3
        L_0x0056:
            if (r0 != 0) goto L_0x0062
            b.a.a.d$b r0 = new b.a.a.d$b     // Catch:{ all -> 0x0074 }
            r0.<init>(r5)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r6 = r4.f4473f     // Catch:{ all -> 0x0074 }
            r6.put(r5, r0)     // Catch:{ all -> 0x0074 }
        L_0x0062:
            b.a.a.d$a r5 = new b.a.a.d$a     // Catch:{ all -> 0x0074 }
            r5.<init>(r0)     // Catch:{ all -> 0x0074 }
            r0.f4502f = r5     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)
            return r5
        L_0x006b:
            java.util.concurrent.Executor r5 = r4.f4487u     // Catch:{ all -> 0x0074 }
            java.lang.Runnable r6 = r4.f4488v     // Catch:{ all -> 0x0074 }
            r5.execute(r6)     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)
            return r3
        L_0x0074:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p093a.C1489d.mo6191a(java.lang.String, long):b.a.a.d$a");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f5, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo6194a(p091b.p092a.p093a.C1489d.C1492a r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            b.a.a.d$b r0 = r10.f4492a     // Catch:{ all -> 0x00fc }
            b.a.a.d$a r1 = r0.f4502f     // Catch:{ all -> 0x00fc }
            if (r1 != r10) goto L_0x00f6
            r1 = 0
            if (r11 == 0) goto L_0x0047
            boolean r2 = r0.f4501e     // Catch:{ all -> 0x00fc }
            if (r2 != 0) goto L_0x0047
            r2 = 0
        L_0x000f:
            int r3 = r9.f4471d     // Catch:{ all -> 0x00fc }
            if (r2 >= r3) goto L_0x0047
            boolean[] r3 = r10.f4493b     // Catch:{ all -> 0x00fc }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fc }
            if (r3 == 0) goto L_0x002d
            b.a.f.a r3 = r9.f4469b     // Catch:{ all -> 0x00fc }
            java.io.File[] r4 = r0.f4500d     // Catch:{ all -> 0x00fc }
            r4 = r4[r2]     // Catch:{ all -> 0x00fc }
            boolean r3 = r3.mo6417e(r4)     // Catch:{ all -> 0x00fc }
            if (r3 != 0) goto L_0x002a
            r10.mo6210c()     // Catch:{ all -> 0x00fc }
            monitor-exit(r9)
            return
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002d:
            r10.mo6210c()     // Catch:{ all -> 0x00fc }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fc }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            r11.<init>()     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fc }
            r11.append(r2)     // Catch:{ all -> 0x00fc }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fc }
            r10.<init>(r11)     // Catch:{ all -> 0x00fc }
            throw r10     // Catch:{ all -> 0x00fc }
        L_0x0047:
            int r10 = r9.f4471d     // Catch:{ all -> 0x00fc }
            if (r1 >= r10) goto L_0x0080
            java.io.File[] r10 = r0.f4500d     // Catch:{ all -> 0x00fc }
            r10 = r10[r1]     // Catch:{ all -> 0x00fc }
            if (r11 == 0) goto L_0x0078
            b.a.f.a r2 = r9.f4469b     // Catch:{ all -> 0x00fc }
            boolean r2 = r2.mo6417e(r10)     // Catch:{ all -> 0x00fc }
            if (r2 == 0) goto L_0x007d
            java.io.File[] r2 = r0.f4499c     // Catch:{ all -> 0x00fc }
            r2 = r2[r1]     // Catch:{ all -> 0x00fc }
            b.a.f.a r3 = r9.f4469b     // Catch:{ all -> 0x00fc }
            r3.mo6413a(r10, r2)     // Catch:{ all -> 0x00fc }
            long[] r10 = r0.f4498b     // Catch:{ all -> 0x00fc }
            r3 = r10[r1]     // Catch:{ all -> 0x00fc }
            b.a.f.a r10 = r9.f4469b     // Catch:{ all -> 0x00fc }
            long r5 = r10.mo6418f(r2)     // Catch:{ all -> 0x00fc }
            long[] r10 = r0.f4498b     // Catch:{ all -> 0x00fc }
            r10[r1] = r5     // Catch:{ all -> 0x00fc }
            long r7 = r9.f4485s     // Catch:{ all -> 0x00fc }
            r10 = 0
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f4485s = r7     // Catch:{ all -> 0x00fc }
            goto L_0x007d
        L_0x0078:
            b.a.f.a r2 = r9.f4469b     // Catch:{ all -> 0x00fc }
            r2.mo6416d(r10)     // Catch:{ all -> 0x00fc }
        L_0x007d:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x0080:
            int r10 = r9.f4474g     // Catch:{ all -> 0x00fc }
            r1 = 1
            int r10 = r10 + r1
            r9.f4474g = r10     // Catch:{ all -> 0x00fc }
            r10 = 0
            r0.f4502f = r10     // Catch:{ all -> 0x00fc }
            boolean r10 = r0.f4501e     // Catch:{ all -> 0x00fc }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00bc
            r0.f4501e = r1     // Catch:{ all -> 0x00fc }
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            java.lang.String r1 = "CLEAN"
            c.d r10 = r10.mo6828b(r1)     // Catch:{ all -> 0x00fc }
            r10.mo6854i(r3)     // Catch:{ all -> 0x00fc }
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            java.lang.String r1 = r0.f4497a     // Catch:{ all -> 0x00fc }
            r10.mo6828b(r1)     // Catch:{ all -> 0x00fc }
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            r0.mo6212a(r10)     // Catch:{ all -> 0x00fc }
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            r10.mo6854i(r2)     // Catch:{ all -> 0x00fc }
            if (r11 == 0) goto L_0x00da
            long r10 = r9.f4486t     // Catch:{ all -> 0x00fc }
            r1 = 1
            long r1 = r1 + r10
            r9.f4486t = r1     // Catch:{ all -> 0x00fc }
            r0.f4503g = r10     // Catch:{ all -> 0x00fc }
            goto L_0x00da
        L_0x00bc:
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r10 = r9.f4473f     // Catch:{ all -> 0x00fc }
            java.lang.String r11 = r0.f4497a     // Catch:{ all -> 0x00fc }
            r10.remove(r11)     // Catch:{ all -> 0x00fc }
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            java.lang.String r11 = "REMOVE"
            c.d r10 = r10.mo6828b(r11)     // Catch:{ all -> 0x00fc }
            r10.mo6854i(r3)     // Catch:{ all -> 0x00fc }
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            java.lang.String r11 = r0.f4497a     // Catch:{ all -> 0x00fc }
            r10.mo6828b(r11)     // Catch:{ all -> 0x00fc }
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            r10.mo6854i(r2)     // Catch:{ all -> 0x00fc }
        L_0x00da:
            c.d r10 = r9.f4472e     // Catch:{ all -> 0x00fc }
            r10.flush()     // Catch:{ all -> 0x00fc }
            long r10 = r9.f4485s     // Catch:{ all -> 0x00fc }
            long r0 = r9.f4484r     // Catch:{ all -> 0x00fc }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00ed
            boolean r10 = r9.mo6198c()     // Catch:{ all -> 0x00fc }
            if (r10 == 0) goto L_0x00f4
        L_0x00ed:
            java.util.concurrent.Executor r10 = r9.f4487u     // Catch:{ all -> 0x00fc }
            java.lang.Runnable r11 = r9.f4488v     // Catch:{ all -> 0x00fc }
            r10.execute(r11)     // Catch:{ all -> 0x00fc }
        L_0x00f4:
            monitor-exit(r9)
            return
        L_0x00f6:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fc }
            r10.<init>()     // Catch:{ all -> 0x00fc }
            throw r10     // Catch:{ all -> 0x00fc }
        L_0x00fc:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p093a.C1489d.mo6194a(b.a.a.d$a, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo6198c() {
        return this.f4474g >= 2000 && this.f4474g >= this.f4473f.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r6;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo6199c(java.lang.String r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.mo6193a()     // Catch:{ all -> 0x0029 }
            r5.m5975j()     // Catch:{ all -> 0x0029 }
            r5.m5971e(r6)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r0 = r5.f4473f     // Catch:{ all -> 0x0029 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0029 }
            b.a.a.d$b r6 = (p091b.p092a.p093a.C1489d.C1494b) r6     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r6 != 0) goto L_0x0017
            monitor-exit(r5)
            return r0
        L_0x0017:
            boolean r6 = r5.mo6195a(r6)     // Catch:{ all -> 0x0029 }
            if (r6 == 0) goto L_0x0027
            long r1 = r5.f4485s     // Catch:{ all -> 0x0029 }
            long r3 = r5.f4484r     // Catch:{ all -> 0x0029 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0027
            r5.f4478k = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r5)
            return r6
        L_0x0029:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p093a.C1489d.mo6199c(java.lang.String):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6195a(C1494b bVar) throws IOException {
        if (bVar.f4502f != null) {
            bVar.f4502f.mo6208a();
        }
        for (int i = 0; i < this.f4471d; i++) {
            this.f4469b.mo6416d(bVar.f4499c[i]);
            this.f4485s -= bVar.f4498b[i];
            bVar.f4498b[i] = 0;
        }
        this.f4474g++;
        this.f4472e.mo6828b("REMOVE").mo6854i(32).mo6828b(bVar.f4497a).mo6854i(10);
        this.f4473f.remove(bVar.f4497a);
        if (mo6198c()) {
            this.f4487u.execute(this.f4488v);
        }
        return true;
    }

    /* renamed from: d */
    public synchronized boolean mo6201d() {
        return this.f4477j;
    }

    /* renamed from: j */
    private synchronized void m5975j() {
        if (mo6201d()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f4476i) {
            m5975j();
            mo6202e();
            this.f4472e.flush();
        }
    }

    public synchronized void close() throws IOException {
        C1494b[] bVarArr;
        if (this.f4476i) {
            if (!this.f4477j) {
                for (C1494b bVar : (C1494b[]) this.f4473f.values().toArray(new C1494b[this.f4473f.size()])) {
                    if (bVar.f4502f != null) {
                        bVar.f4502f.mo6210c();
                    }
                }
                mo6202e();
                this.f4472e.close();
                this.f4472e = null;
                this.f4477j = true;
                return;
            }
        }
        this.f4477j = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo6202e() throws IOException {
        while (this.f4485s > this.f4484r) {
            mo6195a((C1494b) this.f4473f.values().iterator().next());
        }
        this.f4478k = false;
    }

    /* renamed from: f */
    public void mo6203f() throws IOException {
        close();
        this.f4469b.mo6419g(this.f4470c);
    }

    /* renamed from: e */
    private void m5971e(String str) {
        if (!f4467a.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("keys must match regex [a-z0-9_-]{1,120}: \"");
            sb.append(str);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
