package p136d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* renamed from: d.c */
/* compiled from: CallAdapter */
public interface C3404c<T> {

    /* renamed from: d.c$a */
    /* compiled from: CallAdapter */
    public static abstract class C3405a {
        /* renamed from: a */
        public abstract C3404c<?> mo28235a(Type type, Annotation[] annotationArr, C3446m mVar);

        /* renamed from: a */
        protected static Class<?> m9891a(Type type) {
            return C3451o.m10026a(type);
        }
    }

    /* renamed from: a */
    <R> T mo28233a(C3380b<R> bVar);

    /* renamed from: a */
    Type mo28234a();
}
