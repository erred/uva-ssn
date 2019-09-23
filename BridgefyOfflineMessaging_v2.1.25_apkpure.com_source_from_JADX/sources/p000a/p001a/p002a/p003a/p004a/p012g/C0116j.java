package p000a.p001a.p002a.p003a.p004a.p012g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;

/* renamed from: a.a.a.a.a.g.j */
/* compiled from: DefaultSettingsController */
class C0116j implements C0127s {

    /* renamed from: a */
    private final C0131w f250a;

    /* renamed from: b */
    private final C0130v f251b;

    /* renamed from: c */
    private final C0025k f252c;

    /* renamed from: d */
    private final C0113g f253d;

    /* renamed from: e */
    private final C0132x f254e;

    /* renamed from: f */
    private final C0146i f255f;

    /* renamed from: g */
    private final C0105c f256g = new C0106d(this.f255f);

    public C0116j(C0146i iVar, C0131w wVar, C0025k kVar, C0130v vVar, C0113g gVar, C0132x xVar) {
        this.f255f = iVar;
        this.f250a = wVar;
        this.f252c = kVar;
        this.f251b = vVar;
        this.f253d = gVar;
        this.f254e = xVar;
    }

    /* renamed from: a */
    public C0128t mo253a() {
        return mo254a(C0126r.USE_CACHE);
    }

    /* renamed from: a */
    public C0128t mo254a(C0126r rVar) {
        C0128t tVar = null;
        try {
            if (!C0135c.m450i() && !mo258d()) {
                tVar = m388b(rVar);
            }
            if (tVar == null) {
                JSONObject a = this.f254e.mo261a(this.f250a);
                if (a != null) {
                    C0128t a2 = this.f251b.mo259a(this.f252c, a);
                    try {
                        this.f253d.mo252a(a2.f294g, a);
                        m387a(a, "Loaded settings: ");
                        mo255a(mo256b());
                        tVar = a2;
                    } catch (Exception e) {
                        e = e;
                        tVar = a2;
                        C0135c.m449h().mo280e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
                        return tVar;
                    }
                }
            }
            if (tVar == null) {
                return m388b(C0126r.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e2) {
            e = e2;
            C0135c.m449h().mo280e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
            return tVar;
        }
        return tVar;
    }

    /* renamed from: b */
    private C0128t m388b(C0126r rVar) {
        C0128t tVar = null;
        try {
            if (C0126r.SKIP_CACHE_LOOKUP.equals(rVar)) {
                return null;
            }
            JSONObject a = this.f253d.mo251a();
            if (a != null) {
                C0128t a2 = this.f251b.mo259a(this.f252c, a);
                if (a2 != null) {
                    m387a(a, "Loaded cached settings: ");
                    long a3 = this.f252c.mo49a();
                    if (!C0126r.IGNORE_CACHE_EXPIRATION.equals(rVar)) {
                        if (a2.mo267a(a3)) {
                            C0135c.m449h().mo270a("Fabric", "Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        C0135c.m449h().mo270a("Fabric", "Returning cached settings.");
                        return a2;
                    } catch (Exception e) {
                        e = e;
                        tVar = a2;
                        C0135c.m449h().mo280e("Fabric", "Failed to get cached settings", e);
                        return tVar;
                    }
                } else {
                    C0135c.m449h().mo280e("Fabric", "Failed to transform cached settings data.", null);
                    return null;
                }
            } else {
                C0135c.m449h().mo270a("Fabric", "No cached settings data found.");
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            C0135c.m449h().mo280e("Fabric", "Failed to get cached settings", e);
            return tVar;
        }
    }

    /* renamed from: a */
    private void m387a(JSONObject jSONObject, String str) throws JSONException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jSONObject.toString());
        C0135c.m449h().mo270a("Fabric", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo256b() {
        return C0020i.m65a(C0020i.m92m(this.f255f.mo320q()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo257c() {
        return this.f256g.mo245a().getString("existing_instance_identifier", "");
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public boolean mo255a(String str) {
        Editor b = this.f256g.mo247b();
        b.putString("existing_instance_identifier", str);
        return this.f256g.mo246a(b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo258d() {
        return !mo257c().equals(mo256b());
    }
}
