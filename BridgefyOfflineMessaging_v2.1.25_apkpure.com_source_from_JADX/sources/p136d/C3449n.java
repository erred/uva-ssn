package p136d;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1598ad;
import p091b.C1614e.C1615a;
import p091b.C1640s;
import p091b.C1640s.C1641a;
import p091b.C1642t;
import p091b.C1647v;
import p091b.C1648w.C1650b;
import p136d.p139b.C3381a;
import p136d.p139b.C3382b;
import p136d.p139b.C3383c;
import p136d.p139b.C3384d;
import p136d.p139b.C3385e;
import p136d.p139b.C3386f;
import p136d.p139b.C3387g;
import p136d.p139b.C3388h;
import p136d.p139b.C3389i;
import p136d.p139b.C3390j;
import p136d.p139b.C3391k;
import p136d.p139b.C3392l;
import p136d.p139b.C3393m;
import p136d.p139b.C3394n;
import p136d.p139b.C3395o;
import p136d.p139b.C3396p;
import p136d.p139b.C3397q;
import p136d.p139b.C3398r;
import p136d.p139b.C3399s;
import p136d.p139b.C3400t;
import p136d.p139b.C3401u;
import p136d.p139b.C3403w;

/* renamed from: d.n */
/* compiled from: ServiceMethod */
final class C3449n<T> {

    /* renamed from: a */
    static final Pattern f8909a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: b */
    static final Pattern f8910b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: c */
    final C1615a f8911c;

    /* renamed from: d */
    final C3404c<?> f8912d;

    /* renamed from: e */
    private final C1642t f8913e;

    /* renamed from: f */
    private final C3407e<C1598ad, T> f8914f;

    /* renamed from: g */
    private final String f8915g;

    /* renamed from: h */
    private final String f8916h;

    /* renamed from: i */
    private final C1640s f8917i;

    /* renamed from: j */
    private final C1647v f8918j;

    /* renamed from: k */
    private final boolean f8919k;

    /* renamed from: l */
    private final boolean f8920l;

    /* renamed from: m */
    private final boolean f8921m;

    /* renamed from: n */
    private final C3422i<?>[] f8922n;

    /* renamed from: d.n$a */
    /* compiled from: ServiceMethod */
    static final class C3450a<T> {

        /* renamed from: a */
        final C3446m f8923a;

        /* renamed from: b */
        final Method f8924b;

        /* renamed from: c */
        final Annotation[] f8925c;

        /* renamed from: d */
        final Annotation[][] f8926d;

        /* renamed from: e */
        final Type[] f8927e;

        /* renamed from: f */
        Type f8928f;

        /* renamed from: g */
        boolean f8929g;

        /* renamed from: h */
        boolean f8930h;

        /* renamed from: i */
        boolean f8931i;

        /* renamed from: j */
        boolean f8932j;

        /* renamed from: k */
        boolean f8933k;

        /* renamed from: l */
        boolean f8934l;

        /* renamed from: m */
        String f8935m;

        /* renamed from: n */
        boolean f8936n;

        /* renamed from: o */
        boolean f8937o;

        /* renamed from: p */
        boolean f8938p;

        /* renamed from: q */
        String f8939q;

        /* renamed from: r */
        C1640s f8940r;

        /* renamed from: s */
        C1647v f8941s;

        /* renamed from: t */
        Set<String> f8942t;

        /* renamed from: u */
        C3422i<?>[] f8943u;

        /* renamed from: v */
        C3407e<C1598ad, T> f8944v;

        /* renamed from: w */
        C3404c<?> f8945w;

        public C3450a(C3446m mVar, Method method) {
            this.f8923a = mVar;
            this.f8924b = method;
            this.f8925c = method.getAnnotations();
            this.f8927e = method.getGenericParameterTypes();
            this.f8926d = method.getParameterAnnotations();
        }

        /* renamed from: a */
        public C3449n mo28294a() {
            this.f8945w = m10020b();
            this.f8928f = this.f8945w.mo28234a();
            if (this.f8928f == C3445l.class || this.f8928f == C1596ac.class) {
                StringBuilder sb = new StringBuilder();
                sb.append("'");
                sb.append(C3451o.m10026a(this.f8928f).getName());
                sb.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw m10014a(sb.toString(), new Object[0]);
            }
            this.f8944v = m10021c();
            for (Annotation a : this.f8925c) {
                m10019a(a);
            }
            if (this.f8935m != null) {
                if (!this.f8936n) {
                    if (this.f8938p) {
                        throw m10014a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.f8937o) {
                        throw m10014a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f8926d.length;
                this.f8943u = new C3422i[length];
                int i = 0;
                while (i < length) {
                    Type type = this.f8927e[i];
                    if (!C3451o.m10040d(type)) {
                        Annotation[] annotationArr = this.f8926d[i];
                        if (annotationArr != null) {
                            this.f8943u[i] = m10011a(i, type, annotationArr);
                            i++;
                        } else {
                            throw m10013a(i, "No Retrofit annotation found.", new Object[0]);
                        }
                    } else {
                        throw m10013a(i, "Parameter type must not include a type variable or wildcard: %s", type);
                    }
                }
                if (this.f8939q == null && !this.f8934l) {
                    throw m10014a("Missing either @%s URL or @Url parameter.", this.f8935m);
                } else if (!this.f8937o && !this.f8938p && !this.f8936n && this.f8931i) {
                    throw m10014a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.f8937o && !this.f8929g) {
                    throw m10014a("Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.f8938p || this.f8930h) {
                    return new C3449n(this);
                } else {
                    throw m10014a("Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw m10014a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        /* renamed from: b */
        private C3404c<?> m10020b() {
            Type genericReturnType = this.f8924b.getGenericReturnType();
            if (C3451o.m10040d(genericReturnType)) {
                throw m10014a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            } else if (genericReturnType != Void.TYPE) {
                try {
                    return this.f8923a.mo28276a(genericReturnType, this.f8924b.getAnnotations());
                } catch (RuntimeException e) {
                    throw m10016a((Throwable) e, "Unable to create call adapter for %s", genericReturnType);
                }
            } else {
                throw m10014a("Service methods cannot return void.", new Object[0]);
            }
        }

        /* renamed from: a */
        private void m10019a(Annotation annotation) {
            if (annotation instanceof C3382b) {
                m10018a(HttpMethods.DELETE, ((C3382b) annotation).mo28210a(), false);
            } else if (annotation instanceof C3386f) {
                m10018a(HttpMethods.GET, ((C3386f) annotation).mo28214a(), false);
            } else if (annotation instanceof C3387g) {
                m10018a(HttpMethods.HEAD, ((C3387g) annotation).mo28215a(), false);
                if (!Void.class.equals(this.f8928f)) {
                    throw m10014a("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof C3394n) {
                m10018a(HttpMethods.PATCH, ((C3394n) annotation).mo28222a(), true);
            } else if (annotation instanceof C3395o) {
                m10018a(HttpMethods.POST, ((C3395o) annotation).mo28223a(), true);
            } else if (annotation instanceof C3396p) {
                m10018a(HttpMethods.PUT, ((C3396p) annotation).mo28224a(), true);
            } else if (annotation instanceof C3393m) {
                m10018a(HttpMethods.OPTIONS, ((C3393m) annotation).mo28221a(), false);
            } else if (annotation instanceof C3388h) {
                C3388h hVar = (C3388h) annotation;
                m10018a(hVar.mo28216a(), hVar.mo28217b(), hVar.mo28218c());
            } else if (annotation instanceof C3391k) {
                String[] a = ((C3391k) annotation).mo28220a();
                if (a.length != 0) {
                    this.f8940r = m10010a(a);
                } else {
                    throw m10014a("@Headers annotation is empty.", new Object[0]);
                }
            } else if (annotation instanceof C3392l) {
                if (!this.f8937o) {
                    this.f8938p = true;
                } else {
                    throw m10014a("Only one encoding annotation is allowed.", new Object[0]);
                }
            } else if (!(annotation instanceof C3385e)) {
            } else {
                if (!this.f8938p) {
                    this.f8937o = true;
                } else {
                    throw m10014a("Only one encoding annotation is allowed.", new Object[0]);
                }
            }
        }

        /* renamed from: a */
        private void m10018a(String str, String str2, boolean z) {
            if (this.f8935m == null) {
                this.f8935m = str;
                this.f8936n = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (C3449n.f8909a.matcher(substring).find()) {
                            throw m10014a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.f8939q = str2;
                    this.f8942t = C3449n.m10007a(str2);
                    return;
                }
                return;
            }
            throw m10014a("Only one HTTP method is allowed. Found: %s and %s.", this.f8935m, str);
        }

        /* renamed from: a */
        private C1640s m10010a(String[] strArr) {
            C1641a aVar = new C1641a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw m10014a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    C1647v a = C1647v.m6791a(trim);
                    if (a != null) {
                        this.f8941s = a;
                    } else {
                        throw m10014a("Malformed content type: %s", trim);
                    }
                } else {
                    aVar.mo6653a(substring, trim);
                }
            }
            return aVar.mo6654a();
        }

        /* renamed from: a */
        private C3422i<?> m10011a(int i, Type type, Annotation[] annotationArr) {
            C3422i<?> iVar = null;
            for (Annotation a : annotationArr) {
                C3422i<?> a2 = m10012a(i, type, annotationArr, a);
                if (a2 != null) {
                    if (iVar == null) {
                        iVar = a2;
                    } else {
                        throw m10013a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                }
            }
            if (iVar != null) {
                return iVar;
            }
            throw m10013a(i, "No Retrofit annotation found.", new Object[0]);
        }

        /* renamed from: a */
        private C3422i<?> m10012a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof C3403w) {
                if (this.f8934l) {
                    throw m10013a(i, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.f8932j) {
                    throw m10013a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.f8933k) {
                    throw m10013a(i, "A @Url parameter must not come after a @Query", new Object[0]);
                } else if (this.f8939q == null) {
                    this.f8934l = true;
                    if (type == C1642t.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new C3436l();
                    }
                    throw m10013a(i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw m10013a(i, "@Url cannot be used with @%s URL", this.f8935m);
                }
            } else if (annotation instanceof C3399s) {
                if (this.f8933k) {
                    throw m10013a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.f8934l) {
                    throw m10013a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.f8939q != null) {
                    this.f8932j = true;
                    C3399s sVar = (C3399s) annotation;
                    String a = sVar.mo28228a();
                    m10017a(i, a);
                    return new C3432h(a, this.f8923a.mo28284c(type, annotationArr), sVar.mo28229b());
                } else {
                    throw m10013a(i, "@Path can only be used with relative url on @%s", this.f8935m);
                }
            } else if (annotation instanceof C3400t) {
                C3400t tVar = (C3400t) annotation;
                String a2 = tVar.mo28230a();
                boolean b = tVar.mo28231b();
                Class a3 = C3451o.m10026a(type);
                this.f8933k = true;
                if (Iterable.class.isAssignableFrom(a3)) {
                    if (type instanceof ParameterizedType) {
                        return new C3433i(a2, this.f8923a.mo28284c(C3451o.m10029a(0, (ParameterizedType) type), annotationArr), b).mo28245a();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(a3.getSimpleName());
                    sb.append(" must include generic type (e.g., ");
                    sb.append(a3.getSimpleName());
                    sb.append("<String>)");
                    throw m10013a(i, sb.toString(), new Object[0]);
                } else if (!a3.isArray()) {
                    return new C3433i(a2, this.f8923a.mo28284c(type, annotationArr), b);
                } else {
                    return new C3433i(a2, this.f8923a.mo28284c(C3449n.m10006a(a3.getComponentType()), annotationArr), b).mo28247b();
                }
            } else if (annotation instanceof C3401u) {
                Class a4 = C3451o.m10026a(type);
                if (Map.class.isAssignableFrom(a4)) {
                    Type b2 = C3451o.m10038b(type, a4, Map.class);
                    if (b2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) b2;
                        Type a5 = C3451o.m10029a(0, parameterizedType);
                        if (String.class == a5) {
                            return new C3434j(this.f8923a.mo28284c(C3451o.m10029a(1, parameterizedType), annotationArr), ((C3401u) annotation).mo28232a());
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("@QueryMap keys must be of type String: ");
                        sb2.append(a5);
                        throw m10013a(i, sb2.toString(), new Object[0]);
                    }
                    throw m10013a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw m10013a(i, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof C3389i) {
                String a6 = ((C3389i) annotation).mo28219a();
                Class a7 = C3451o.m10026a(type);
                if (Iterable.class.isAssignableFrom(a7)) {
                    if (type instanceof ParameterizedType) {
                        return new C3428d(a6, this.f8923a.mo28284c(C3451o.m10029a(0, (ParameterizedType) type), annotationArr)).mo28245a();
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(a7.getSimpleName());
                    sb3.append(" must include generic type (e.g., ");
                    sb3.append(a7.getSimpleName());
                    sb3.append("<String>)");
                    throw m10013a(i, sb3.toString(), new Object[0]);
                } else if (!a7.isArray()) {
                    return new C3428d(a6, this.f8923a.mo28284c(type, annotationArr));
                } else {
                    return new C3428d(a6, this.f8923a.mo28284c(C3449n.m10006a(a7.getComponentType()), annotationArr)).mo28247b();
                }
            } else if (annotation instanceof C3390j) {
                Class a8 = C3451o.m10026a(type);
                if (Map.class.isAssignableFrom(a8)) {
                    Type b3 = C3451o.m10038b(type, a8, Map.class);
                    if (b3 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) b3;
                        Type a9 = C3451o.m10029a(0, parameterizedType2);
                        if (String.class == a9) {
                            return new C3429e(this.f8923a.mo28284c(C3451o.m10029a(1, parameterizedType2), annotationArr));
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("@HeaderMap keys must be of type String: ");
                        sb4.append(a9);
                        throw m10013a(i, sb4.toString(), new Object[0]);
                    }
                    throw m10013a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw m10013a(i, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof C3383c) {
                if (this.f8937o) {
                    C3383c cVar = (C3383c) annotation;
                    String a10 = cVar.mo28211a();
                    boolean b4 = cVar.mo28212b();
                    this.f8929g = true;
                    Class a11 = C3451o.m10026a(type);
                    if (Iterable.class.isAssignableFrom(a11)) {
                        if (type instanceof ParameterizedType) {
                            return new C3426b(a10, this.f8923a.mo28284c(C3451o.m10029a(0, (ParameterizedType) type), annotationArr), b4).mo28245a();
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(a11.getSimpleName());
                        sb5.append(" must include generic type (e.g., ");
                        sb5.append(a11.getSimpleName());
                        sb5.append("<String>)");
                        throw m10013a(i, sb5.toString(), new Object[0]);
                    } else if (!a11.isArray()) {
                        return new C3426b(a10, this.f8923a.mo28284c(type, annotationArr), b4);
                    } else {
                        return new C3426b(a10, this.f8923a.mo28284c(C3449n.m10006a(a11.getComponentType()), annotationArr), b4).mo28247b();
                    }
                } else {
                    throw m10013a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
            } else if (annotation instanceof C3384d) {
                if (this.f8937o) {
                    Class a12 = C3451o.m10026a(type);
                    if (Map.class.isAssignableFrom(a12)) {
                        Type b5 = C3451o.m10038b(type, a12, Map.class);
                        if (b5 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) b5;
                            Type a13 = C3451o.m10029a(0, parameterizedType3);
                            if (String.class == a13) {
                                C3407e c = this.f8923a.mo28284c(C3451o.m10029a(1, parameterizedType3), annotationArr);
                                this.f8929g = true;
                                return new C3427c(c, ((C3384d) annotation).mo28213a());
                            }
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("@FieldMap keys must be of type String: ");
                            sb6.append(a13);
                            throw m10013a(i, sb6.toString(), new Object[0]);
                        }
                        throw m10013a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m10013a(i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw m10013a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof C3397q) {
                if (this.f8938p) {
                    C3397q qVar = (C3397q) annotation;
                    this.f8930h = true;
                    String a14 = qVar.mo28225a();
                    Class a15 = C3451o.m10026a(type);
                    if (!a14.isEmpty()) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("form-data; name=\"");
                        sb7.append(a14);
                        sb7.append("\"");
                        C1640s a16 = C1640s.m6712a(HttpHeaders.CONTENT_DISPOSITION, sb7.toString(), "Content-Transfer-Encoding", qVar.mo28226b());
                        if (Iterable.class.isAssignableFrom(a15)) {
                            if (type instanceof ParameterizedType) {
                                Type a17 = C3451o.m10029a(0, (ParameterizedType) type);
                                if (!C1650b.class.isAssignableFrom(C3451o.m10026a(a17))) {
                                    return new C3430f(a16, this.f8923a.mo28279a(a17, annotationArr, this.f8925c)).mo28245a();
                                }
                                throw m10013a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(a15.getSimpleName());
                            sb8.append(" must include generic type (e.g., ");
                            sb8.append(a15.getSimpleName());
                            sb8.append("<String>)");
                            throw m10013a(i, sb8.toString(), new Object[0]);
                        } else if (a15.isArray()) {
                            Class a18 = C3449n.m10006a(a15.getComponentType());
                            if (!C1650b.class.isAssignableFrom(a18)) {
                                return new C3430f(a16, this.f8923a.mo28279a((Type) a18, annotationArr, this.f8925c)).mo28247b();
                            }
                            throw m10013a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!C1650b.class.isAssignableFrom(a15)) {
                            return new C3430f(a16, this.f8923a.mo28279a(type, annotationArr, this.f8925c));
                        } else {
                            throw m10013a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(a15)) {
                        if (!(type instanceof ParameterizedType)) {
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(a15.getSimpleName());
                            sb9.append(" must include generic type (e.g., ");
                            sb9.append(a15.getSimpleName());
                            sb9.append("<String>)");
                            throw m10013a(i, sb9.toString(), new Object[0]);
                        } else if (C1650b.class.isAssignableFrom(C3451o.m10026a(C3451o.m10029a(0, (ParameterizedType) type)))) {
                            return C3435k.f8871a.mo28245a();
                        } else {
                            throw m10013a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (a15.isArray()) {
                        if (C1650b.class.isAssignableFrom(a15.getComponentType())) {
                            return C3435k.f8871a.mo28247b();
                        }
                        throw m10013a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (C1650b.class.isAssignableFrom(a15)) {
                        return C3435k.f8871a;
                    } else {
                        throw m10013a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else {
                    throw m10013a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
            } else if (annotation instanceof C3398r) {
                if (this.f8938p) {
                    this.f8930h = true;
                    Class a19 = C3451o.m10026a(type);
                    if (Map.class.isAssignableFrom(a19)) {
                        Type b6 = C3451o.m10038b(type, a19, Map.class);
                        if (b6 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) b6;
                            Type a20 = C3451o.m10029a(0, parameterizedType4);
                            if (String.class == a20) {
                                Type a21 = C3451o.m10029a(1, parameterizedType4);
                                if (!C1650b.class.isAssignableFrom(C3451o.m10026a(a21))) {
                                    return new C3431g(this.f8923a.mo28279a(a21, annotationArr, this.f8925c), ((C3398r) annotation).mo28227a());
                                }
                                throw m10013a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append("@PartMap keys must be of type String: ");
                            sb10.append(a20);
                            throw m10013a(i, sb10.toString(), new Object[0]);
                        }
                        throw m10013a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m10013a(i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw m10013a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (!(annotation instanceof C3381a)) {
                return null;
            } else {
                if (this.f8937o || this.f8938p) {
                    throw m10013a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                } else if (!this.f8931i) {
                    try {
                        C3407e a22 = this.f8923a.mo28279a(type, annotationArr, this.f8925c);
                        this.f8931i = true;
                        return new C3425a(a22);
                    } catch (RuntimeException e) {
                        throw m10015a((Throwable) e, i, "Unable to create @Body converter for %s", type);
                    }
                } else {
                    throw m10013a(i, "Multiple @Body method annotations found.", new Object[0]);
                }
            }
        }

        /* renamed from: a */
        private void m10017a(int i, String str) {
            if (!C3449n.f8910b.matcher(str).matches()) {
                throw m10013a(i, "@Path parameter name must match %s. Found: %s", C3449n.f8909a.pattern(), str);
            } else if (!this.f8942t.contains(str)) {
                throw m10013a(i, "URL \"%s\" does not contain \"{%s}\".", this.f8939q, str);
            }
        }

        /* renamed from: c */
        private C3407e<C1598ad, T> m10021c() {
            try {
                return this.f8923a.mo28283b(this.f8928f, this.f8924b.getAnnotations());
            } catch (RuntimeException e) {
                throw m10016a((Throwable) e, "Unable to create converter for %s", this.f8928f);
            }
        }

        /* renamed from: a */
        private RuntimeException m10014a(String str, Object... objArr) {
            return m10016a((Throwable) null, str, objArr);
        }

        /* renamed from: a */
        private RuntimeException m10016a(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            StringBuilder sb = new StringBuilder();
            sb.append(format);
            sb.append("\n    for method ");
            sb.append(this.f8924b.getDeclaringClass().getSimpleName());
            sb.append(".");
            sb.append(this.f8924b.getName());
            return new IllegalArgumentException(sb.toString(), th);
        }

        /* renamed from: a */
        private RuntimeException m10015a(Throwable th, int i, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i + 1);
            sb.append(")");
            return m10016a(th, sb.toString(), objArr);
        }

        /* renamed from: a */
        private RuntimeException m10013a(int i, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i + 1);
            sb.append(")");
            return m10014a(sb.toString(), objArr);
        }
    }

    C3449n(C3450a<T> aVar) {
        this.f8911c = aVar.f8923a.mo28274a();
        this.f8912d = aVar.f8945w;
        this.f8913e = aVar.f8923a.mo28282b();
        this.f8914f = aVar.f8944v;
        this.f8915g = aVar.f8935m;
        this.f8916h = aVar.f8939q;
        this.f8917i = aVar.f8940r;
        this.f8918j = aVar.f8941s;
        this.f8919k = aVar.f8936n;
        this.f8920l = aVar.f8937o;
        this.f8921m = aVar.f8938p;
        this.f8922n = aVar.f8943u;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1590aa mo28292a(Object... objArr) throws IOException {
        C3443k kVar = new C3443k(this.f8915g, this.f8913e, this.f8916h, this.f8917i, this.f8918j, this.f8919k, this.f8920l, this.f8921m);
        C3422i[] iVarArr = (C3422i[]) this.f8922n;
        int length = objArr != null ? objArr.length : 0;
        if (length == iVarArr.length) {
            for (int i = 0; i < length; i++) {
                iVarArr[i].mo28246a(kVar, objArr[i]);
            }
            return kVar.mo28260a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument count (");
        sb.append(length);
        sb.append(") doesn't match expected count (");
        sb.append(iVarArr.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public T mo28293a(C1598ad adVar) throws IOException {
        return this.f8914f.mo28198a(adVar);
    }

    /* renamed from: a */
    static Set<String> m10007a(String str) {
        Matcher matcher = f8909a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    static Class<?> m10006a(Class<?> cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }
}
