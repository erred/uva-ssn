package p102c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: c.a */
/* compiled from: AsyncTimeout */
public class C1667a extends C1696t {

    /* renamed from: a */
    private static final long f5276a = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: b */
    static C1667a f5277b;

    /* renamed from: d */
    private static final long f5278d = TimeUnit.MILLISECONDS.toNanos(f5276a);

    /* renamed from: e */
    private boolean f5279e;

    /* renamed from: f */
    private C1667a f5280f;

    /* renamed from: g */
    private long f5281g;

    /* renamed from: c.a$a */
    /* compiled from: AsyncTimeout */
    private static final class C1670a extends Thread {
        C1670a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.mo6377a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<c.a> r0 = p102c.C1667a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                c.a r1 = p102c.C1667a.m6866e()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                c.a r2 = p102c.C1667a.f5277b     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                p102c.C1667a.f5277b = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.mo6377a()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: p102c.C1667a.C1670a.run():void");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6377a() {
    }

    /* renamed from: c */
    public final void mo6800c() {
        if (!this.f5279e) {
            long h_ = mo6916h_();
            boolean i_ = mo6917i_();
            if (h_ != 0 || i_) {
                this.f5279e = true;
                m6863a(this, h_, i_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* renamed from: a */
    private static synchronized void m6863a(C1667a aVar, long j, boolean z) {
        synchronized (C1667a.class) {
            if (f5277b == null) {
                f5277b = new C1667a();
                new C1670a().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                aVar.f5281g = Math.min(j, aVar.mo6913d() - nanoTime) + nanoTime;
            } else if (i != 0) {
                aVar.f5281g = j + nanoTime;
            } else if (z) {
                aVar.f5281g = aVar.mo6913d();
            } else {
                throw new AssertionError();
            }
            long b = aVar.m6865b(nanoTime);
            C1667a aVar2 = f5277b;
            while (true) {
                if (aVar2.f5280f == null) {
                    break;
                } else if (b < aVar2.f5280f.m6865b(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.f5280f;
                }
            }
            aVar.f5280f = aVar2.f5280f;
            aVar2.f5280f = aVar;
            if (aVar2 == f5277b) {
                C1667a.class.notify();
            }
        }
    }

    /* renamed from: g_ */
    public final boolean mo6801g_() {
        if (!this.f5279e) {
            return false;
        }
        this.f5279e = false;
        return m6864a(this);
    }

    /* renamed from: a */
    private static synchronized boolean m6864a(C1667a aVar) {
        synchronized (C1667a.class) {
            for (C1667a aVar2 = f5277b; aVar2 != null; aVar2 = aVar2.f5280f) {
                if (aVar2.f5280f == aVar) {
                    aVar2.f5280f = aVar.f5280f;
                    aVar.f5280f = null;
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: b */
    private long m6865b(long j) {
        return this.f5281g - j;
    }

    /* renamed from: a */
    public final C1694r mo6796a(final C1694r rVar) {
        return new C1694r() {
            /* renamed from: a_ */
            public void mo6217a_(C1672c cVar, long j) throws IOException {
                C1698u.m7136a(cVar.f5290b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        C1691o oVar = cVar.f5289a;
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            j2 += (long) (oVar.f5325c - oVar.f5324b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            oVar = oVar.f5328f;
                        }
                        C1667a.this.mo6800c();
                        try {
                            rVar.mo6217a_(cVar, j2);
                            j -= j2;
                            C1667a.this.mo6798a(true);
                        } catch (IOException e) {
                            throw C1667a.this.mo6799b(e);
                        } catch (Throwable th) {
                            C1667a.this.mo6798a(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() throws IOException {
                C1667a.this.mo6800c();
                try {
                    rVar.flush();
                    C1667a.this.mo6798a(true);
                } catch (IOException e) {
                    throw C1667a.this.mo6799b(e);
                } catch (Throwable th) {
                    C1667a.this.mo6798a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                C1667a.this.mo6800c();
                try {
                    rVar.close();
                    C1667a.this.mo6798a(true);
                } catch (IOException e) {
                    throw C1667a.this.mo6799b(e);
                } catch (Throwable th) {
                    C1667a.this.mo6798a(false);
                    throw th;
                }
            }

            /* renamed from: a */
            public C1696t mo6306a() {
                return C1667a.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncTimeout.sink(");
                sb.append(rVar);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    /* renamed from: a */
    public final C1695s mo6797a(final C1695s sVar) {
        return new C1695s() {
            /* renamed from: a */
            public long mo6185a(C1672c cVar, long j) throws IOException {
                C1667a.this.mo6800c();
                try {
                    long a = sVar.mo6185a(cVar, j);
                    C1667a.this.mo6798a(true);
                    return a;
                } catch (IOException e) {
                    throw C1667a.this.mo6799b(e);
                } catch (Throwable th) {
                    C1667a.this.mo6798a(false);
                    throw th;
                }
            }

            public void close() throws IOException {
                try {
                    sVar.close();
                    C1667a.this.mo6798a(true);
                } catch (IOException e) {
                    throw C1667a.this.mo6799b(e);
                } catch (Throwable th) {
                    C1667a.this.mo6798a(false);
                    throw th;
                }
            }

            /* renamed from: a */
            public C1696t mo6186a() {
                return C1667a.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncTimeout.source(");
                sb.append(sVar);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo6798a(boolean z) throws IOException {
        if (mo6801g_() && z) {
            throw mo6376a((IOException) null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final IOException mo6799b(IOException iOException) throws IOException {
        if (!mo6801g_()) {
            return iOException;
        }
        return mo6376a(iOException);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IOException mo6376a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: e */
    static C1667a m6866e() throws InterruptedException {
        C1667a aVar = f5277b.f5280f;
        C1667a aVar2 = null;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            C1667a.class.wait(f5276a);
            if (f5277b.f5280f == null && System.nanoTime() - nanoTime >= f5278d) {
                aVar2 = f5277b;
            }
            return aVar2;
        }
        long b = aVar.m6865b(System.nanoTime());
        if (b > 0) {
            long j = b / 1000000;
            C1667a.class.wait(j, (int) (b - (1000000 * j)));
            return null;
        }
        f5277b.f5280f = aVar.f5280f;
        aVar.f5280f = null;
        return aVar;
    }
}
