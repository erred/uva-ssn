package p136d;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p091b.C1592ab;
import p091b.C1598ad;
import p136d.C3407e.C3408a;
import p136d.p139b.C3402v;

/* renamed from: d.a */
/* compiled from: BuiltInConverters */
final class C3370a extends C3408a {

    /* renamed from: d.a$a */
    /* compiled from: BuiltInConverters */
    static final class C3371a implements C3407e<C1598ad, C1598ad> {

        /* renamed from: a */
        static final C3371a f8808a = new C3371a();

        C3371a() {
        }

        /* renamed from: a */
        public C1598ad mo28198a(C1598ad adVar) throws IOException {
            try {
                return C3451o.m10025a(adVar);
            } finally {
                adVar.close();
            }
        }
    }

    /* renamed from: d.a$b */
    /* compiled from: BuiltInConverters */
    static final class C3372b implements C3407e<C1592ab, C1592ab> {

        /* renamed from: a */
        static final C3372b f8809a = new C3372b();

        /* renamed from: a */
        public C1592ab mo28198a(C1592ab abVar) throws IOException {
            return abVar;
        }

        C3372b() {
        }
    }

    /* renamed from: d.a$c */
    /* compiled from: BuiltInConverters */
    static final class C3373c implements C3407e<C1598ad, C1598ad> {

        /* renamed from: a */
        static final C3373c f8810a = new C3373c();

        /* renamed from: a */
        public C1598ad mo28198a(C1598ad adVar) throws IOException {
            return adVar;
        }

        C3373c() {
        }
    }

    /* renamed from: d.a$d */
    /* compiled from: BuiltInConverters */
    static final class C3374d implements C3407e<String, String> {

        /* renamed from: a */
        static final C3374d f8811a = new C3374d();

        /* renamed from: a */
        public String mo28198a(String str) throws IOException {
            return str;
        }

        C3374d() {
        }
    }

    /* renamed from: d.a$e */
    /* compiled from: BuiltInConverters */
    static final class C3375e implements C3407e<Object, String> {

        /* renamed from: a */
        static final C3375e f8812a = new C3375e();

        C3375e() {
        }

        /* renamed from: b */
        public String mo28198a(Object obj) {
            return obj.toString();
        }
    }

    /* renamed from: d.a$f */
    /* compiled from: BuiltInConverters */
    static final class C3376f implements C3407e<C1598ad, Void> {

        /* renamed from: a */
        static final C3376f f8813a = new C3376f();

        C3376f() {
        }

        /* renamed from: a */
        public Void mo28198a(C1598ad adVar) throws IOException {
            adVar.close();
            return null;
        }
    }

    C3370a() {
    }

    /* renamed from: a */
    public C3407e<C1598ad, ?> mo28194a(Type type, Annotation[] annotationArr, C3446m mVar) {
        if (type == C1598ad.class) {
            if (C3451o.m10036a(annotationArr, C3402v.class)) {
                return C3373c.f8810a;
            }
            return C3371a.f8808a;
        } else if (type == Void.class) {
            return C3376f.f8813a;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public C3407e<?, C1592ab> mo28195a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C3446m mVar) {
        if (C1592ab.class.isAssignableFrom(C3451o.m10026a(type))) {
            return C3372b.f8809a;
        }
        return null;
    }

    /* renamed from: b */
    public C3407e<?, String> mo28196b(Type type, Annotation[] annotationArr, C3446m mVar) {
        if (type == String.class) {
            return C3374d.f8811a;
        }
        return null;
    }
}
