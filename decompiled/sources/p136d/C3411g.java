package p136d;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import p136d.C3404c.C3405a;

/* renamed from: d.g */
/* compiled from: ExecutorCallAdapterFactory */
final class C3411g extends C3405a {

    /* renamed from: a */
    final Executor f8824a;

    /* renamed from: d.g$a */
    /* compiled from: ExecutorCallAdapterFactory */
    static final class C3413a<T> implements C3380b<T> {

        /* renamed from: a */
        final Executor f8827a;

        /* renamed from: b */
        final C3380b<T> f8828b;

        C3413a(Executor executor, C3380b<T> bVar) {
            this.f8827a = executor;
            this.f8828b = bVar;
        }

        /* renamed from: a */
        public void mo28207a(final C3406d<T> dVar) {
            if (dVar != null) {
                this.f8828b.mo28207a(new C3406d<T>() {
                    /* renamed from: a */
                    public void mo27603a(C3380b<T> bVar, final C3445l<T> lVar) {
                        C3413a.this.f8827a.execute(new Runnable() {
                            public void run() {
                                if (C3413a.this.f8828b.mo28208b()) {
                                    dVar.mo27604a((C3380b<T>) C3413a.this, (Throwable) new IOException("Canceled"));
                                } else {
                                    dVar.mo27603a((C3380b<T>) C3413a.this, lVar);
                                }
                            }
                        });
                    }

                    /* renamed from: a */
                    public void mo27604a(C3380b<T> bVar, final Throwable th) {
                        C3413a.this.f8827a.execute(new Runnable() {
                            public void run() {
                                dVar.mo27604a((C3380b<T>) C3413a.this, th);
                            }
                        });
                    }
                });
                return;
            }
            throw new NullPointerException("callback == null");
        }

        /* renamed from: a */
        public C3445l<T> mo28206a() throws IOException {
            return this.f8828b.mo28206a();
        }

        /* renamed from: b */
        public boolean mo28208b() {
            return this.f8828b.mo28208b();
        }

        /* renamed from: c */
        public C3380b<T> clone() {
            return new C3413a(this.f8827a, this.f8828b.mo28209c());
        }
    }

    C3411g(Executor executor) {
        this.f8824a = executor;
    }

    /* renamed from: a */
    public C3404c<C3380b<?>> mo28235a(Type type, Annotation[] annotationArr, C3446m mVar) {
        if (m9891a(type) != C3380b.class) {
            return null;
        }
        final Type e = C3451o.m10041e(type);
        return new C3404c<C3380b<?>>() {
            /* renamed from: a */
            public Type mo28234a() {
                return e;
            }

            /* renamed from: b */
            public <R> C3380b<R> mo28233a(C3380b<R> bVar) {
                return new C3413a(C3411g.this.f8824a, bVar);
            }
        };
    }
}
