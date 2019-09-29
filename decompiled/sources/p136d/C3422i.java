package p136d;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import p091b.C1592ab;
import p091b.C1640s;
import p091b.C1648w.C1650b;

/* renamed from: d.i */
/* compiled from: ParameterHandler */
abstract class C3422i<T> {

    /* renamed from: d.i$a */
    /* compiled from: ParameterHandler */
    static final class C3425a<T> extends C3422i<T> {

        /* renamed from: a */
        private final C3407e<T, C1592ab> f8850a;

        C3425a(C3407e<T, C1592ab> eVar) {
            this.f8850a = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, T t) {
            if (t != null) {
                try {
                    kVar.mo28261a((C1592ab) this.f8850a.mo28198a(t));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(t);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }

    /* renamed from: d.i$b */
    /* compiled from: ParameterHandler */
    static final class C3426b<T> extends C3422i<T> {

        /* renamed from: a */
        private final String f8851a;

        /* renamed from: b */
        private final C3407e<T, String> f8852b;

        /* renamed from: c */
        private final boolean f8853c;

        C3426b(String str, C3407e<T, String> eVar, boolean z) {
            this.f8851a = (String) C3451o.m10028a(str, "name == null");
            this.f8852b = eVar;
            this.f8853c = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, T t) throws IOException {
            if (t != null) {
                kVar.mo28268c(this.f8851a, (String) this.f8852b.mo28198a(t), this.f8853c);
            }
        }
    }

    /* renamed from: d.i$c */
    /* compiled from: ParameterHandler */
    static final class C3427c<T> extends C3422i<Map<String, T>> {

        /* renamed from: a */
        private final C3407e<T, String> f8854a;

        /* renamed from: b */
        private final boolean f8855b;

        C3427c(C3407e<T, String> eVar, boolean z) {
            this.f8854a = eVar;
            this.f8855b = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            kVar.mo28268c(str, (String) this.f8854a.mo28198a(value), this.f8855b);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Field map contained null value for key '");
                            sb.append(str);
                            sb.append("'.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* renamed from: d.i$d */
    /* compiled from: ParameterHandler */
    static final class C3428d<T> extends C3422i<T> {

        /* renamed from: a */
        private final String f8856a;

        /* renamed from: b */
        private final C3407e<T, String> f8857b;

        C3428d(String str, C3407e<T, String> eVar) {
            this.f8856a = (String) C3451o.m10028a(str, "name == null");
            this.f8857b = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, T t) throws IOException {
            if (t != null) {
                kVar.mo28265a(this.f8856a, (String) this.f8857b.mo28198a(t));
            }
        }
    }

    /* renamed from: d.i$e */
    /* compiled from: ParameterHandler */
    static final class C3429e<T> extends C3422i<Map<String, T>> {

        /* renamed from: a */
        private final C3407e<T, String> f8858a;

        C3429e(C3407e<T, String> eVar) {
            this.f8858a = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            kVar.mo28265a(str, (String) this.f8858a.mo28198a(value));
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Header map contained null value for key '");
                            sb.append(str);
                            sb.append("'.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    /* renamed from: d.i$f */
    /* compiled from: ParameterHandler */
    static final class C3430f<T> extends C3422i<T> {

        /* renamed from: a */
        private final C1640s f8859a;

        /* renamed from: b */
        private final C3407e<T, C1592ab> f8860b;

        C3430f(C1640s sVar, C3407e<T, C1592ab> eVar) {
            this.f8859a = sVar;
            this.f8860b = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, T t) {
            if (t != null) {
                try {
                    kVar.mo28262a(this.f8859a, (C1592ab) this.f8860b.mo28198a(t));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(t);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e);
                }
            }
        }
    }

    /* renamed from: d.i$g */
    /* compiled from: ParameterHandler */
    static final class C3431g<T> extends C3422i<Map<String, T>> {

        /* renamed from: a */
        private final C3407e<T, C1592ab> f8861a;

        /* renamed from: b */
        private final String f8862b;

        C3431g(C3407e<T, C1592ab> eVar, String str) {
            this.f8861a = eVar;
            this.f8862b = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("form-data; name=\"");
                            sb.append(str);
                            sb.append("\"");
                            kVar.mo28262a(C1640s.m6712a(HttpHeaders.CONTENT_DISPOSITION, sb.toString(), "Content-Transfer-Encoding", this.f8862b), (C1592ab) this.f8861a.mo28198a(value));
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Part map contained null value for key '");
                            sb2.append(str);
                            sb2.append("'.");
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* renamed from: d.i$h */
    /* compiled from: ParameterHandler */
    static final class C3432h<T> extends C3422i<T> {

        /* renamed from: a */
        private final String f8863a;

        /* renamed from: b */
        private final C3407e<T, String> f8864b;

        /* renamed from: c */
        private final boolean f8865c;

        C3432h(String str, C3407e<T, String> eVar, boolean z) {
            this.f8863a = (String) C3451o.m10028a(str, "name == null");
            this.f8864b = eVar;
            this.f8865c = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, T t) throws IOException {
            if (t != null) {
                kVar.mo28266a(this.f8863a, (String) this.f8864b.mo28198a(t), this.f8865c);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Path parameter \"");
            sb.append(this.f8863a);
            sb.append("\" value must not be null.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: d.i$i */
    /* compiled from: ParameterHandler */
    static final class C3433i<T> extends C3422i<T> {

        /* renamed from: a */
        private final String f8866a;

        /* renamed from: b */
        private final C3407e<T, String> f8867b;

        /* renamed from: c */
        private final boolean f8868c;

        C3433i(String str, C3407e<T, String> eVar, boolean z) {
            this.f8866a = (String) C3451o.m10028a(str, "name == null");
            this.f8867b = eVar;
            this.f8868c = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, T t) throws IOException {
            if (t != null) {
                kVar.mo28267b(this.f8866a, (String) this.f8867b.mo28198a(t), this.f8868c);
            }
        }
    }

    /* renamed from: d.i$j */
    /* compiled from: ParameterHandler */
    static final class C3434j<T> extends C3422i<Map<String, T>> {

        /* renamed from: a */
        private final C3407e<T, String> f8869a;

        /* renamed from: b */
        private final boolean f8870b;

        C3434j(C3407e<T, String> eVar, boolean z) {
            this.f8869a = eVar;
            this.f8870b = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            kVar.mo28267b(str, (String) this.f8869a.mo28198a(value), this.f8870b);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Query map contained null value for key '");
                            sb.append(str);
                            sb.append("'.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* renamed from: d.i$k */
    /* compiled from: ParameterHandler */
    static final class C3435k extends C3422i<C1650b> {

        /* renamed from: a */
        static final C3435k f8871a = new C3435k();

        private C3435k() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, C1650b bVar) throws IOException {
            if (bVar != null) {
                kVar.mo28263a(bVar);
            }
        }
    }

    /* renamed from: d.i$l */
    /* compiled from: ParameterHandler */
    static final class C3436l extends C3422i<Object> {
        C3436l() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo28246a(C3443k kVar, Object obj) {
            kVar.mo28264a(obj);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28246a(C3443k kVar, T t) throws IOException;

    C3422i() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C3422i<Iterable<T>> mo28245a() {
        return new C3422i<Iterable<T>>() {
            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo28246a(C3443k kVar, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T a : iterable) {
                        C3422i.this.mo28246a(kVar, a);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final C3422i<Object> mo28247b() {
        return new C3422i<Object>() {
            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo28246a(C3443k kVar, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        C3422i.this.mo28246a(kVar, Array.get(obj, i));
                    }
                }
            }
        };
    }
}
