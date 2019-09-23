package p136d;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import p091b.C1592ab;
import p091b.C1598ad;
import p091b.C1614e.C1615a;
import p091b.C1642t;
import p091b.C1651x;
import p136d.C3404c.C3405a;
import p136d.C3407e.C3408a;

/* renamed from: d.m */
/* compiled from: Retrofit */
public final class C3446m {

    /* renamed from: a */
    private final Map<Method, C3449n> f8892a = new LinkedHashMap();

    /* renamed from: b */
    private final C1615a f8893b;

    /* renamed from: c */
    private final C1642t f8894c;

    /* renamed from: d */
    private final List<C3408a> f8895d;

    /* renamed from: e */
    private final List<C3405a> f8896e;

    /* renamed from: f */
    private final Executor f8897f;

    /* renamed from: g */
    private final boolean f8898g;

    /* renamed from: d.m$a */
    /* compiled from: Retrofit */
    public static final class C3448a {

        /* renamed from: a */
        private C3437j f8902a;

        /* renamed from: b */
        private C1615a f8903b;

        /* renamed from: c */
        private C1642t f8904c;

        /* renamed from: d */
        private List<C3408a> f8905d;

        /* renamed from: e */
        private List<C3405a> f8906e;

        /* renamed from: f */
        private Executor f8907f;

        /* renamed from: g */
        private boolean f8908g;

        C3448a(C3437j jVar) {
            this.f8905d = new ArrayList();
            this.f8906e = new ArrayList();
            this.f8902a = jVar;
            this.f8905d.add(new C3370a());
        }

        public C3448a() {
            this(C3437j.m9955a());
        }

        /* renamed from: a */
        public C3448a mo28288a(C1651x xVar) {
            return mo28286a((C1615a) C3451o.m10028a(xVar, "client == null"));
        }

        /* renamed from: a */
        public C3448a mo28286a(C1615a aVar) {
            this.f8903b = (C1615a) C3451o.m10028a(aVar, "factory == null");
            return this;
        }

        /* renamed from: a */
        public C3448a mo28290a(String str) {
            C3451o.m10028a(str, "baseUrl == null");
            C1642t e = C1642t.m6741e(str);
            if (e != null) {
                return mo28287a(e);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal URL: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: a */
        public C3448a mo28287a(C1642t tVar) {
            C3451o.m10028a(tVar, "baseUrl == null");
            List j = tVar.mo6674j();
            if ("".equals(j.get(j.size() - 1))) {
                this.f8904c = tVar;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("baseUrl must end in /: ");
            sb.append(tVar);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: a */
        public C3448a mo28289a(C3408a aVar) {
            this.f8905d.add(C3451o.m10028a(aVar, "factory == null"));
            return this;
        }

        /* renamed from: a */
        public C3446m mo28291a() {
            if (this.f8904c != null) {
                C1615a aVar = this.f8903b;
                if (aVar == null) {
                    aVar = new C1651x();
                }
                C1615a aVar2 = aVar;
                Executor executor = this.f8907f;
                if (executor == null) {
                    executor = this.f8902a.mo28257b();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f8906e);
                arrayList.add(this.f8902a.mo28254a(executor2));
                C3446m mVar = new C3446m(aVar2, this.f8904c, new ArrayList(this.f8905d), arrayList, executor2, this.f8908g);
                return mVar;
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    C3446m(C1615a aVar, C1642t tVar, List<C3408a> list, List<C3405a> list2, Executor executor, boolean z) {
        this.f8893b = aVar;
        this.f8894c = tVar;
        this.f8895d = Collections.unmodifiableList(list);
        this.f8896e = Collections.unmodifiableList(list2);
        this.f8897f = executor;
        this.f8898g = z;
    }

    /* renamed from: a */
    public <T> T mo28281a(final Class<T> cls) {
        C3451o.m10033a(cls);
        if (this.f8898g) {
            m9988b(cls);
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {

            /* renamed from: c */
            private final C3437j f8901c = C3437j.m9955a();

            public Object invoke(Object obj, Method method, Object... objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f8901c.mo28256a(method)) {
                    return this.f8901c.mo28255a(method, cls, obj, objArr);
                }
                C3449n a = C3446m.this.mo28280a(method);
                return a.f8912d.mo28233a(new C3417h(a, objArr));
            }
        });
    }

    /* renamed from: b */
    private void m9988b(Class<?> cls) {
        Method[] declaredMethods;
        C3437j a = C3437j.m9955a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!a.mo28256a(method)) {
                mo28280a(method);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3449n mo28280a(Method method) {
        C3449n nVar;
        synchronized (this.f8892a) {
            nVar = (C3449n) this.f8892a.get(method);
            if (nVar == null) {
                nVar = new C3450a(this, method).mo28294a();
                this.f8892a.put(method, nVar);
            }
        }
        return nVar;
    }

    /* renamed from: a */
    public C1615a mo28274a() {
        return this.f8893b;
    }

    /* renamed from: b */
    public C1642t mo28282b() {
        return this.f8894c;
    }

    /* renamed from: a */
    public C3404c<?> mo28276a(Type type, Annotation[] annotationArr) {
        return mo28275a((C3405a) null, type, annotationArr);
    }

    /* renamed from: a */
    public C3404c<?> mo28275a(C3405a aVar, Type type, Annotation[] annotationArr) {
        C3451o.m10028a(type, "returnType == null");
        C3451o.m10028a(annotationArr, "annotations == null");
        int indexOf = this.f8896e.indexOf(aVar) + 1;
        int size = this.f8896e.size();
        for (int i = indexOf; i < size; i++) {
            C3404c<?> a = ((C3405a) this.f8896e.get(i)).mo28235a(type, annotationArr, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(((C3405a) this.f8896e.get(i2)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f8896e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(((C3405a) this.f8896e.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public <T> C3407e<T, C1592ab> mo28279a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return mo28278a(null, type, annotationArr, annotationArr2);
    }

    /* renamed from: a */
    public <T> C3407e<T, C1592ab> mo28278a(C3408a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        C3451o.m10028a(type, "type == null");
        C3451o.m10028a(annotationArr, "parameterAnnotations == null");
        C3451o.m10028a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f8895d.indexOf(aVar) + 1;
        int size = this.f8895d.size();
        for (int i = indexOf; i < size; i++) {
            C3407e<T, C1592ab> a = ((C3408a) this.f8895d.get(i)).mo28195a(type, annotationArr, annotationArr2, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(((C3408a) this.f8895d.get(i2)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f8895d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(((C3408a) this.f8895d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public <T> C3407e<C1598ad, T> mo28283b(Type type, Annotation[] annotationArr) {
        return mo28277a((C3408a) null, type, annotationArr);
    }

    /* renamed from: a */
    public <T> C3407e<C1598ad, T> mo28277a(C3408a aVar, Type type, Annotation[] annotationArr) {
        C3451o.m10028a(type, "type == null");
        C3451o.m10028a(annotationArr, "annotations == null");
        int indexOf = this.f8895d.indexOf(aVar) + 1;
        int size = this.f8895d.size();
        for (int i = indexOf; i < size; i++) {
            C3407e<C1598ad, T> a = ((C3408a) this.f8895d.get(i)).mo28194a(type, annotationArr, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(((C3408a) this.f8895d.get(i2)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f8895d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(((C3408a) this.f8895d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: c */
    public <T> C3407e<T, String> mo28284c(Type type, Annotation[] annotationArr) {
        C3451o.m10028a(type, "type == null");
        C3451o.m10028a(annotationArr, "annotations == null");
        int size = this.f8895d.size();
        for (int i = 0; i < size; i++) {
            C3407e<T, String> b = ((C3408a) this.f8895d.get(i)).mo28196b(type, annotationArr, this);
            if (b != null) {
                return b;
            }
        }
        return C3375e.f8812a;
    }
}
