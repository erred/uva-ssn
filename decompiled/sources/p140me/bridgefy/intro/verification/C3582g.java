package p140me.bridgefy.intro.verification;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/* renamed from: me.bridgefy.intro.verification.g */
/* compiled from: PhoneNumber */
public final class C3582g {

    /* renamed from: a */
    private static final C3582g f9440a = new C3582g(null, "", "-1");

    /* renamed from: b */
    private final String f9441b;

    /* renamed from: c */
    private final String f9442c;

    /* renamed from: d */
    private final String f9443d;

    public C3582g(String str, String str2, String str3) {
        this.f9441b = str;
        this.f9442c = str2;
        this.f9443d = str3;
    }

    public C3582g(String str, String str2) {
        this.f9441b = str2;
        this.f9443d = str;
        this.f9442c = null;
    }

    /* renamed from: a */
    public static C3582g m10522a() {
        return f9440a;
    }

    /* renamed from: a */
    public static boolean m10524a(C3582g gVar) {
        return gVar != null && !f9440a.equals(gVar) && !TextUtils.isEmpty(gVar.mo29499c()) && !TextUtils.isEmpty(gVar.mo29498b()) && !TextUtils.isEmpty(gVar.mo29500d());
    }

    /* renamed from: b */
    public static boolean m10525b(C3582g gVar) {
        return gVar != null && !f9440a.equals(gVar) && !TextUtils.isEmpty(gVar.mo29498b()) && !TextUtils.isEmpty(gVar.mo29500d());
    }

    /* renamed from: b */
    public String mo29498b() {
        return this.f9443d;
    }

    /* renamed from: c */
    public String mo29499c() {
        return this.f9441b;
    }

    /* renamed from: d */
    public String mo29500d() {
        return this.f9442c;
    }

    public String toString() {
        if (equals(f9440a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        sb.append(this.f9443d);
        sb.append(this.f9441b);
        return sb.toString();
    }

    /* renamed from: e */
    public String mo29501e() {
        return new Gson().toJson((Object) this);
    }

    /* renamed from: a */
    public static C3582g m10523a(String str) throws JsonSyntaxException {
        return (C3582g) new Gson().fromJson(str, C3582g.class);
    }
}
