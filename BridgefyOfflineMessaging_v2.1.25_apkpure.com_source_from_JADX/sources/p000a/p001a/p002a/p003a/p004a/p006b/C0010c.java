package p000a.p001a.p002a.p003a.p004a.p006b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;

/* renamed from: a.a.a.a.a.b.c */
/* compiled from: AdvertisingInfoProvider */
class C0010c {

    /* renamed from: a */
    private final Context f16a;

    /* renamed from: b */
    private final C0105c f17b;

    public C0010c(Context context) {
        this.f16a = context.getApplicationContext();
        this.f17b = new C0106d(context, "TwitterAdvertisingInfoPreferences");
    }

    /* renamed from: a */
    public C0009b mo26a() {
        C0009b b = mo27b();
        if (m29c(b)) {
            C0135c.m449h().mo270a("Fabric", "Using AdvertisingInfo from Preference Store");
            m26a(b);
            return b;
        }
        C0009b e = m30e();
        m28b(e);
        return e;
    }

    /* renamed from: a */
    private void m26a(final C0009b bVar) {
        new Thread(new C0019h() {
            /* renamed from: a */
            public void mo30a() {
                C0009b a = C0010c.this.m30e();
                if (!bVar.equals(a)) {
                    C0135c.m449h().mo270a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    C0010c.this.m28b(a);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void m28b(C0009b bVar) {
        if (m29c(bVar)) {
            this.f17b.mo246a(this.f17b.mo247b().putString("advertising_id", bVar.f14a).putBoolean("limit_ad_tracking_enabled", bVar.f15b));
        } else {
            this.f17b.mo246a(this.f17b.mo247b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0009b mo27b() {
        return new C0009b(this.f17b.mo245a().getString("advertising_id", ""), this.f17b.mo245a().getBoolean("limit_ad_tracking_enabled", false));
    }

    /* renamed from: c */
    public C0017f mo28c() {
        return new C0012d(this.f16a);
    }

    /* renamed from: d */
    public C0017f mo29d() {
        return new C0013e(this.f16a);
    }

    /* renamed from: c */
    private boolean m29c(C0009b bVar) {
        return bVar != null && !TextUtils.isEmpty(bVar.f14a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public C0009b m30e() {
        C0009b a = mo28c().mo31a();
        if (!m29c(a)) {
            a = mo29d().mo31a();
            if (!m29c(a)) {
                C0135c.m449h().mo270a("Fabric", "AdvertisingInfo not present");
            } else {
                C0135c.m449h().mo270a("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            C0135c.m449h().mo270a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return a;
    }
}
