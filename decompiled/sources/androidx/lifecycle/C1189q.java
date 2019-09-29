package androidx.lifecycle;

/* renamed from: androidx.lifecycle.q */
/* compiled from: ViewModelProvider */
public class C1189q {

    /* renamed from: a */
    private final C1190a f3587a;

    /* renamed from: b */
    private final C1191r f3588b;

    /* renamed from: androidx.lifecycle.q$a */
    /* compiled from: ViewModelProvider */
    public interface C1190a {
        /* renamed from: a */
        <T extends C1188p> T mo4623a(Class<T> cls);
    }

    public C1189q(C1191r rVar, C1190a aVar) {
        this.f3587a = aVar;
        this.f3588b = rVar;
    }

    /* renamed from: a */
    public <T extends C1188p> T mo4621a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
            sb.append(canonicalName);
            return mo4622a(sb.toString(), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: a */
    public <T extends C1188p> T mo4622a(String str, Class<T> cls) {
        T a = this.f3588b.mo4624a(str);
        if (cls.isInstance(a)) {
            return a;
        }
        T a2 = this.f3587a.mo4623a(cls);
        this.f3588b.mo4626a(str, a2);
        return a2;
    }
}
