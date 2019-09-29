package p000a.p001a.p002a.p003a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0026l;
import p000a.p001a.p002a.p003a.p004a.p010e.C0087b;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;
import p000a.p001a.p002a.p003a.p004a.p012g.C0110d;
import p000a.p001a.p002a.p003a.p004a.p012g.C0111e;
import p000a.p001a.p002a.p003a.p004a.p012g.C0114h;
import p000a.p001a.p002a.p003a.p004a.p012g.C0120n;
import p000a.p001a.p002a.p003a.p004a.p012g.C0123q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0128t;
import p000a.p001a.p002a.p003a.p004a.p012g.C0133y;

/* renamed from: a.a.a.a.m */
/* compiled from: Onboarding */
class C0150m extends C0146i<Boolean> {

    /* renamed from: a */
    private final C0098e f352a = new C0087b();

    /* renamed from: b */
    private PackageManager f353b;

    /* renamed from: c */
    private String f354c;

    /* renamed from: d */
    private PackageInfo f355d;

    /* renamed from: k */
    private String f356k;

    /* renamed from: l */
    private String f357l;

    /* renamed from: m */
    private String f358m;

    /* renamed from: n */
    private String f359n;

    /* renamed from: o */
    private String f360o;

    /* renamed from: p */
    private final Future<Map<String, C0148k>> f361p;

    /* renamed from: q */
    private final Collection<C0146i> f362q;

    /* renamed from: a */
    public String mo309a() {
        return "1.3.17.dev";
    }

    /* renamed from: b */
    public String mo312b() {
        return "io.fabric.sdk.android:fabric";
    }

    public C0150m(Future<Map<String, C0148k>> future, Collection<C0146i> collection) {
        this.f361p = future;
        this.f362q = collection;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b_ */
    public boolean mo315b_() {
        try {
            this.f358m = mo319p().mo63j();
            this.f353b = mo320q().getPackageManager();
            this.f354c = mo320q().getPackageName();
            this.f355d = this.f353b.getPackageInfo(this.f354c, 0);
            this.f356k = Integer.toString(this.f355d.versionCode);
            this.f357l = this.f355d.versionName == null ? "0.0" : this.f355d.versionName;
            this.f359n = this.f353b.getApplicationLabel(mo320q().getApplicationInfo()).toString();
            this.f360o = Integer.toString(mo320q().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (NameNotFoundException e) {
            C0135c.m449h().mo280e("Fabric", "Failed init", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Boolean mo317e() {
        boolean z;
        Map map;
        String k = C0020i.m90k(mo320q());
        C0128t g = m521g();
        if (g != null) {
            try {
                if (this.f361p != null) {
                    map = (Map) this.f361p.get();
                } else {
                    map = new HashMap();
                }
                z = m518a(k, g.f288a, mo329a(map, this.f362q).values());
            } catch (Exception e) {
                C0135c.m449h().mo280e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }

    /* renamed from: g */
    private C0128t m521g() {
        try {
            C0123q.m412a().mo263a(this, this.f347i, this.f352a, this.f356k, this.f357l, mo331f()).mo265c();
            return C0123q.m412a().mo264b();
        } catch (Exception e) {
            C0135c.m449h().mo280e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Map<String, C0148k> mo329a(Map<String, C0148k> map, Collection<C0146i> collection) {
        for (C0146i iVar : collection) {
            if (!map.containsKey(iVar.mo312b())) {
                map.put(iVar.mo312b(), new C0148k(iVar.mo312b(), iVar.mo309a(), "binary"));
            }
        }
        return map;
    }

    /* renamed from: a */
    private boolean m518a(String str, C0111e eVar, Collection<C0148k> collection) {
        if ("new".equals(eVar.f242b)) {
            if (m519b(str, eVar, collection)) {
                return C0123q.m412a().mo266d();
            }
            C0135c.m449h().mo280e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(eVar.f242b)) {
            return C0123q.m412a().mo266d();
        } else {
            if (eVar.f245e) {
                C0135c.m449h().mo270a("Fabric", "Server says an update is required - forcing a full App update.");
                m520c(str, eVar, collection);
            }
            return true;
        }
    }

    /* renamed from: b */
    private boolean m519b(String str, C0111e eVar, Collection<C0148k> collection) {
        return new C0114h(this, mo331f(), eVar.f243c, this.f352a).mo249a(m516a(C0120n.m411a(mo320q(), str), collection));
    }

    /* renamed from: c */
    private boolean m520c(String str, C0111e eVar, Collection<C0148k> collection) {
        return m517a(eVar, C0120n.m411a(mo320q(), str), collection);
    }

    /* renamed from: a */
    private boolean m517a(C0111e eVar, C0120n nVar, Collection<C0148k> collection) {
        return new C0133y(this, mo331f(), eVar.f243c, this.f352a).mo249a(m516a(nVar, collection));
    }

    /* renamed from: a */
    private C0110d m516a(C0120n nVar, Collection<C0148k> collection) {
        Context q = mo320q();
        C0110d dVar = new C0110d(new C0018g().mo40a(q), mo319p().mo56c(), this.f357l, this.f356k, C0020i.m65a(C0020i.m92m(q)), this.f359n, C0026l.m99a(this.f358m).mo50a(), this.f360o, "0", nVar, collection);
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo331f() {
        return C0020i.m77b(mo320q(), "com.crashlytics.ApiEndpoint");
    }
}
