package p136d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p136d.C3404c.C3405a;

/* renamed from: d.f */
/* compiled from: DefaultCallAdapterFactory */
final class C3409f extends C3405a {

    /* renamed from: a */
    static final C3405a f8821a = new C3409f();

    C3409f() {
    }

    /* renamed from: a */
    public C3404c<?> mo28235a(Type type, Annotation[] annotationArr, C3446m mVar) {
        if (m9891a(type) != C3380b.class) {
            return null;
        }
        final Type e = C3451o.m10041e(type);
        return new C3404c<C3380b<?>>() {
            /* renamed from: b */
            public <R> C3380b<R> mo28233a(C3380b<R> bVar) {
                return bVar;
            }

            /* renamed from: a */
            public Type mo28234a() {
                return e;
            }
        };
    }
}
