package p000a.p001a.p002a.p003a.p004a.p012g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0026l;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0042s;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;

/* renamed from: a.a.a.a.a.g.q */
/* compiled from: Settings */
public class C0123q {

    /* renamed from: a */
    private final AtomicReference<C0128t> f279a;

    /* renamed from: b */
    private final CountDownLatch f280b;

    /* renamed from: c */
    private C0127s f281c;

    /* renamed from: d */
    private boolean f282d;

    /* renamed from: a.a.a.a.a.g.q$a */
    /* compiled from: Settings */
    static class C0125a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C0123q f283a = new C0123q();
    }

    /* renamed from: a */
    public static C0123q m412a() {
        return C0125a.f283a;
    }

    private C0123q() {
        this.f279a = new AtomicReference<>();
        this.f280b = new CountDownLatch(1);
        this.f282d = false;
    }

    /* renamed from: a */
    public synchronized C0123q mo263a(C0146i iVar, C0032o oVar, C0098e eVar, String str, String str2, String str3) {
        C0146i iVar2 = iVar;
        synchronized (this) {
            if (this.f282d) {
                return this;
            }
            if (this.f281c == null) {
                Context q = iVar.mo320q();
                String c = oVar.mo56c();
                String a = new C0018g().mo40a(q);
                String j = oVar.mo63j();
                C0042s sVar = new C0042s();
                C0117k kVar = new C0117k();
                C0115i iVar3 = new C0115i(iVar2);
                String k = C0020i.m90k(q);
                String str4 = str3;
                C0118l lVar = new C0118l(iVar2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), eVar);
                String g = oVar.mo60g();
                String f = oVar.mo59f();
                String str5 = f;
                String str6 = str2;
                String str7 = str;
                C0131w wVar = new C0131w(a, g, str5, oVar.mo58e(), oVar.mo66m(), oVar.mo55b(), oVar.mo67n(), C0020i.m65a(C0020i.m92m(q)), str6, str7, C0026l.m99a(j).mo50a(), k);
                C0116j jVar = new C0116j(iVar, wVar, sVar, kVar, iVar3, lVar);
                this.f281c = jVar;
            }
            this.f282d = true;
            return this;
        }
    }

    /* renamed from: b */
    public C0128t mo264b() {
        try {
            this.f280b.await();
            return (C0128t) this.f279a.get();
        } catch (InterruptedException unused) {
            C0135c.m449h().mo279e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /* renamed from: c */
    public synchronized boolean mo265c() {
        C0128t a;
        a = this.f281c.mo253a();
        m413a(a);
        return a != null;
    }

    /* renamed from: d */
    public synchronized boolean mo266d() {
        C0128t a;
        a = this.f281c.mo254a(C0126r.SKIP_CACHE_LOOKUP);
        m413a(a);
        if (a == null) {
            C0135c.m449h().mo280e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    /* renamed from: a */
    private void m413a(C0128t tVar) {
        this.f279a.set(tVar);
        this.f280b.countDown();
    }
}
