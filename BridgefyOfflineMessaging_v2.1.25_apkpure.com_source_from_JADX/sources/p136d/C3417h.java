package p136d;

import java.io.IOException;
import p091b.C1596ac;
import p091b.C1598ad;
import p091b.C1614e;
import p091b.C1616f;
import p091b.C1647v;
import p102c.C1672c;
import p102c.C1676e;
import p102c.C1679h;
import p102c.C1683l;
import p102c.C1695s;

/* renamed from: d.h */
/* compiled from: OkHttpCall */
final class C3417h<T> implements C3380b<T> {

    /* renamed from: a */
    private final C3449n<T> f8835a;

    /* renamed from: b */
    private final Object[] f8836b;

    /* renamed from: c */
    private volatile boolean f8837c;

    /* renamed from: d */
    private C1614e f8838d;

    /* renamed from: e */
    private Throwable f8839e;

    /* renamed from: f */
    private boolean f8840f;

    /* renamed from: d.h$a */
    /* compiled from: OkHttpCall */
    static final class C3419a extends C1598ad {

        /* renamed from: a */
        IOException f8843a;

        /* renamed from: b */
        private final C1598ad f8844b;

        C3419a(C1598ad adVar) {
            this.f8844b = adVar;
        }

        /* renamed from: a */
        public C1647v mo6290a() {
            return this.f8844b.mo6290a();
        }

        /* renamed from: b */
        public long mo6291b() {
            return this.f8844b.mo6291b();
        }

        /* renamed from: c */
        public C1676e mo6292c() {
            return C1683l.m7033a((C1695s) new C1679h(this.f8844b.mo6292c()) {
                /* renamed from: a */
                public long mo6185a(C1672c cVar, long j) throws IOException {
                    try {
                        return super.mo6185a(cVar, j);
                    } catch (IOException e) {
                        C3419a.this.f8843a = e;
                        throw e;
                    }
                }
            });
        }

        public void close() {
            this.f8844b.close();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo28244g() throws IOException {
            if (this.f8843a != null) {
                throw this.f8843a;
            }
        }
    }

    /* renamed from: d.h$b */
    /* compiled from: OkHttpCall */
    static final class C3421b extends C1598ad {

        /* renamed from: a */
        private final C1647v f8846a;

        /* renamed from: b */
        private final long f8847b;

        C3421b(C1647v vVar, long j) {
            this.f8846a = vVar;
            this.f8847b = j;
        }

        /* renamed from: a */
        public C1647v mo6290a() {
            return this.f8846a;
        }

        /* renamed from: b */
        public long mo6291b() {
            return this.f8847b;
        }

        /* renamed from: c */
        public C1676e mo6292c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    C3417h(C3449n<T> nVar, Object[] objArr) {
        this.f8835a = nVar;
        this.f8836b = objArr;
    }

    /* renamed from: d */
    public C3417h<T> clone() {
        return new C3417h<>(this.f8835a, this.f8836b);
    }

    /* renamed from: a */
    public void mo28207a(final C3406d<T> dVar) {
        C1614e eVar;
        Throwable th;
        if (dVar != null) {
            synchronized (this) {
                if (!this.f8840f) {
                    this.f8840f = true;
                    eVar = this.f8838d;
                    th = this.f8839e;
                    if (eVar == null && th == null) {
                        try {
                            C1614e e = m9913e();
                            this.f8838d = e;
                            eVar = e;
                        } catch (Throwable th2) {
                            th = th2;
                            this.f8839e = th;
                        }
                    }
                } else {
                    throw new IllegalStateException("Already executed.");
                }
            }
            if (th != null) {
                dVar.mo27604a((C3380b<T>) this, th);
                return;
            }
            if (this.f8837c) {
                eVar.mo6554b();
            }
            eVar.mo6553a(new C1616f() {
                /* renamed from: a */
                public void mo6556a(C1614e eVar, C1596ac acVar) throws IOException {
                    try {
                        m9920a(C3417h.this.mo28241a(acVar));
                    } catch (Throwable th) {
                        m9921a(th);
                    }
                }

                /* renamed from: a */
                public void mo6557a(C1614e eVar, IOException iOException) {
                    try {
                        dVar.mo27604a((C3380b<T>) C3417h.this, (Throwable) iOException);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                /* renamed from: a */
                private void m9921a(Throwable th) {
                    try {
                        dVar.mo27604a((C3380b<T>) C3417h.this, th);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }

                /* renamed from: a */
                private void m9920a(C3445l<T> lVar) {
                    try {
                        dVar.mo27603a((C3380b<T>) C3417h.this, lVar);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        throw new NullPointerException("callback == null");
    }

    /* renamed from: a */
    public C3445l<T> mo28206a() throws IOException {
        C1614e eVar;
        synchronized (this) {
            if (!this.f8840f) {
                this.f8840f = true;
                if (this.f8839e == null) {
                    eVar = this.f8838d;
                    if (eVar == null) {
                        try {
                            eVar = m9913e();
                            this.f8838d = eVar;
                        } catch (IOException | RuntimeException e) {
                            this.f8839e = e;
                            throw e;
                        }
                    }
                } else if (this.f8839e instanceof IOException) {
                    throw ((IOException) this.f8839e);
                } else {
                    throw ((RuntimeException) this.f8839e);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f8837c) {
            eVar.mo6554b();
        }
        return mo28241a(eVar.mo6552a());
    }

    /* renamed from: e */
    private C1614e m9913e() throws IOException {
        C1614e a = this.f8835a.f8911c.mo6555a(this.f8835a.mo28292a(this.f8836b));
        if (a != null) {
            return a;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3445l<T> mo28241a(C1596ac acVar) throws IOException {
        C1598ad h = acVar.mo6487h();
        C1596ac a = acVar.mo6488i().mo6500a((C1598ad) new C3421b(h.mo6290a(), h.mo6291b())).mo6506a();
        int c = a.mo6481c();
        if (c < 200 || c >= 300) {
            try {
                return C3445l.m9981a(C3451o.m10025a(h), a);
            } finally {
                h.close();
            }
        } else if (c == 204 || c == 205) {
            return C3445l.m9982a(null, a);
        } else {
            C3419a aVar = new C3419a(h);
            try {
                return C3445l.m9982a(this.f8835a.mo28293a((C1598ad) aVar), a);
            } catch (RuntimeException e) {
                aVar.mo28244g();
                throw e;
            }
        }
    }

    /* renamed from: b */
    public boolean mo28208b() {
        return this.f8837c;
    }
}
