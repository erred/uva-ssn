package com.p103a.p104a.p107c;

import android.content.Context;
import android.util.Log;
import com.p103a.p104a.p107c.p108a.C1747a;
import com.p103a.p104a.p107c.p108a.p109a.C1751d;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0028n;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p007c.C0062d;
import p000a.p001a.p002a.p003a.p004a.p007c.C0063e;
import p000a.p001a.p002a.p003a.p004a.p007c.C0067g;
import p000a.p001a.p002a.p003a.p004a.p007c.C0073l;
import p000a.p001a.p002a.p003a.p004a.p007c.C0074m;
import p000a.p001a.p002a.p003a.p004a.p010e.C0087b;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0100g;
import p000a.p001a.p002a.p003a.p004a.p011f.C0104b;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;
import p000a.p001a.p002a.p003a.p004a.p012g.C0123q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0128t;

@C0062d(mo131a = {C1747a.class})
/* renamed from: com.a.a.c.i */
/* compiled from: CrashlyticsCore */
public class C1814i extends C0146i<Void> {

    /* renamed from: a */
    private final long f5623a;

    /* renamed from: b */
    private final ConcurrentHashMap<String, String> f5624b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1821j f5625c;

    /* renamed from: d */
    private C1821j f5626d;

    /* renamed from: k */
    private C1822k f5627k;

    /* renamed from: l */
    private C1791h f5628l;

    /* renamed from: m */
    private String f5629m;

    /* renamed from: n */
    private String f5630n;

    /* renamed from: o */
    private String f5631o;

    /* renamed from: p */
    private float f5632p;

    /* renamed from: q */
    private boolean f5633q;

    /* renamed from: r */
    private final C1755aa f5634r;

    /* renamed from: s */
    private C0098e f5635s;

    /* renamed from: t */
    private C1788g f5636t;

    /* renamed from: u */
    private C1747a f5637u;

    /* renamed from: com.a.a.c.i$a */
    /* compiled from: CrashlyticsCore */
    private static final class C1819a implements Callable<Boolean> {

        /* renamed from: a */
        private final C1821j f5642a;

        public C1819a(C1821j jVar) {
            this.f5642a = jVar;
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            if (!this.f5642a.mo7152b()) {
                return Boolean.FALSE;
            }
            C0135c.m449h().mo270a("CrashlyticsCore", "Found previous crash marker.");
            this.f5642a.mo7153c();
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.a.a.c.i$b */
    /* compiled from: CrashlyticsCore */
    private static final class C1820b implements C1822k {
        /* renamed from: a */
        public void mo7150a() {
        }

        private C1820b() {
        }
    }

    /* renamed from: a */
    public String mo309a() {
        return "2.3.17.dev";
    }

    /* renamed from: b */
    public String mo312b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public C1814i() {
        this(1.0f, null, null, false);
    }

    C1814i(float f, C1822k kVar, C1755aa aaVar, boolean z) {
        this(f, kVar, aaVar, z, C0028n.m102a("Crashlytics Exception Handler"));
    }

    C1814i(float f, C1822k kVar, C1755aa aaVar, boolean z, ExecutorService executorService) {
        this.f5629m = null;
        this.f5630n = null;
        this.f5631o = null;
        this.f5632p = f;
        if (kVar == null) {
            kVar = new C1820b();
        }
        this.f5627k = kVar;
        this.f5634r = aaVar;
        this.f5633q = z;
        this.f5636t = new C1788g(executorService);
        this.f5624b = new ConcurrentHashMap<>();
        this.f5623a = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b_ */
    public boolean mo315b_() {
        return mo7129a(super.mo320q());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7129a(Context context) {
        Context context2 = context;
        if (this.f5633q) {
            return false;
        }
        String a = new C0018g().mo40a(context2);
        if (a == null) {
            return false;
        }
        String m = C0020i.m92m(context);
        if (m7500a(m, C0020i.m73a(context2, "com.crashlytics.RequireBuildId", true))) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("Initializing Crashlytics ");
                sb.append(mo309a());
                C0135c.m449h().mo275c("CrashlyticsCore", sb.toString());
                C0104b bVar = new C0104b(this);
                this.f5626d = new C1821j("crash_marker", bVar);
                this.f5625c = new C1821j("initialization_marker", bVar);
                C1756ab a2 = C1756ab.m7277a(new C0106d(mo320q(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                C0100g lVar = this.f5634r != null ? new C1823l(this.f5634r) : null;
                this.f5635s = new C0087b(C0135c.m449h());
                this.f5635s.mo184a(lVar);
                C0032o p = mo319p();
                C1746a a3 = C1746a.m7272a(context2, p, a, m);
                C1839v vVar = new C1839v(context2, a3.f5475d);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Installer package name is: ");
                sb2.append(a3.f5474c);
                C0135c.m449h().mo270a("CrashlyticsCore", sb2.toString());
                C1791h hVar = new C1791h(this, this.f5636t, this.f5635s, p, a2, bVar, a3, vVar);
                this.f5628l = hVar;
                boolean l = mo7137l();
                m7502w();
                this.f5628l.mo7092a(Thread.getDefaultUncaughtExceptionHandler());
                if (!l || !C0020i.m93n(context)) {
                    C0135c.m449h().mo270a("CrashlyticsCore", "Exception handling initialization successful");
                    return true;
                }
                C0135c.m449h().mo270a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                m7501v();
                return false;
            } catch (Exception e) {
                C0135c.m449h().mo280e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e);
                this.f5628l = null;
                return false;
            }
        } else {
            throw new C0074m("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Void mo317e() {
        mo7135j();
        C1751d m = mo7138m();
        if (m != null) {
            this.f5628l.mo7091a(m);
        }
        this.f5628l.mo7099d();
        try {
            C0128t b = C0123q.m412a().mo264b();
            if (b == null) {
                C0135c.m449h().mo277d("CrashlyticsCore", "Received null settings, skipping report submission!");
                mo7136k();
                return null;
            } else if (!b.f291d.f259c) {
                C0135c.m449h().mo270a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                mo7136k();
                return null;
            } else {
                if (!this.f5628l.mo7095a(b.f289b)) {
                    C0135c.m449h().mo270a("CrashlyticsCore", "Could not finalize previous sessions.");
                }
                this.f5628l.mo7089a(this.f5632p, b);
                mo7136k();
                return null;
            }
        } catch (Exception e) {
            C0135c.m449h().mo280e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } catch (Throwable th) {
            mo7136k();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Map<String, String> mo7131f() {
        return Collections.unmodifiableMap(this.f5624b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo7132g() {
        if (mo319p().mo54a()) {
            return this.f5629m;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public String mo7133h() {
        if (mo319p().mo54a()) {
            return this.f5630n;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public String mo7134i() {
        if (mo319p().mo54a()) {
            return this.f5631o;
        }
        return null;
    }

    /* renamed from: v */
    private void m7501v() {
        C18151 r0 = new C0067g<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                return C1814i.this.mo317e();
            }

            /* renamed from: b */
            public C0063e mo135b() {
                return C0063e.IMMEDIATE;
            }
        };
        for (C0073l a : mo324u()) {
            r0.mo106c(a);
        }
        Future submit = mo321r().mo290f().submit(r0);
        C0135c.m449h().mo270a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C0135c.m449h().mo280e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            C0135c.m449h().mo280e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            C0135c.m449h().mo280e("CrashlyticsCore", "Crashlytics timed out during initialization.", e3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo7135j() {
        this.f5636t.mo7083a((Callable<T>) new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                C1814i.this.f5625c.mo7151a();
                C0135c.m449h().mo270a("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo7136k() {
        this.f5636t.mo7085b(new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    boolean c = C1814i.this.f5625c.mo7153c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Initialization marker file removed: ");
                    sb.append(c);
                    C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
                    return Boolean.valueOf(c);
                } catch (Exception e) {
                    C0135c.m449h().mo280e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                    return Boolean.valueOf(false);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo7137l() {
        return ((Boolean) this.f5636t.mo7083a((Callable<T>) new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(C1814i.this.f5625c.mo7152b());
            }
        })).booleanValue();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public C1751d mo7138m() {
        if (this.f5637u != null) {
            return this.f5637u.mo7012a();
        }
        return null;
    }

    /* renamed from: w */
    private void m7502w() {
        if (Boolean.TRUE.equals((Boolean) this.f5636t.mo7083a((Callable<T>) new C1819a<T>(this.f5626d)))) {
            try {
                this.f5627k.mo7150a();
            } catch (Exception e) {
                C0135c.m449h().mo280e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public void mo7139n() {
        this.f5626d.mo7151a();
    }

    /* renamed from: a */
    static boolean m7500a(String str, boolean z) {
        if (!z) {
            C0135c.m449h().mo270a("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        } else if (!C0020i.m82c(str)) {
            return true;
        } else {
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            return false;
        }
    }
}
