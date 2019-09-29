package p000a.p001a.p002a.p003a.p004a.p006b;

import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;

/* renamed from: a.a.a.a.a.b.a */
/* compiled from: AbstractSpiCall */
public abstract class C0008a {

    /* renamed from: b */
    private static final Pattern f8b = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a */
    protected final C0146i f9a;

    /* renamed from: c */
    private final String f10c;

    /* renamed from: d */
    private final C0098e f11d;

    /* renamed from: e */
    private final C0089c f12e;

    /* renamed from: f */
    private final String f13f;

    public C0008a(C0146i iVar, String str, String str2, C0098e eVar, C0089c cVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (eVar != null) {
            this.f9a = iVar;
            this.f13f = str;
            this.f10c = m21a(str2);
            this.f11d = eVar;
            this.f12e = cVar;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo22a() {
        return this.f10c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0090d mo23b() {
        return mo21a(Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0090d mo21a(Map<String, String> map) {
        C0090d a = this.f11d.mo183a(this.f12e, mo22a(), map).mo196a(false).mo186a(10000);
        String str = HttpHeaders.USER_AGENT;
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Android SDK/");
        sb.append(this.f9a.mo309a());
        return a.mo189a(str, sb.toString()).mo189a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* renamed from: a */
    private String m21a(String str) {
        return !C0020i.m82c(this.f13f) ? f8b.matcher(str).replaceFirst(this.f13f) : str;
    }
}
