package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.C3130e.C3131a;
import com.twitter.sdk.android.core.internal.C3182k;
import com.twitter.sdk.android.core.internal.C3188n;
import com.twitter.sdk.android.core.internal.C3189o;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.p134b.C3165c;
import com.twitter.sdk.android.core.internal.scribe.C3211aa;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.twitter.sdk.android.core.v */
/* compiled from: TwitterCore */
public class C3270v {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    static volatile C3270v f8566a;

    /* renamed from: b */
    C3255l<C3274y> f8567b;

    /* renamed from: c */
    C3255l<C3130e> f8568c;

    /* renamed from: d */
    C3182k<C3274y> f8569d;

    /* renamed from: e */
    private final C3259p f8570e;

    /* renamed from: f */
    private final ConcurrentHashMap<C3254k, C3257n> f8571f;

    /* renamed from: g */
    private final Context f8572g;

    /* renamed from: h */
    private volatile C3257n f8573h;

    /* renamed from: i */
    private volatile C3132f f8574i;

    /* renamed from: b */
    public String mo27913b() {
        return "3.1.0.8";
    }

    /* renamed from: e */
    public String mo27916e() {
        return "com.twitter.sdk.android:twitter-core";
    }

    C3270v(C3259p pVar) {
        this(pVar, new ConcurrentHashMap(), null);
    }

    C3270v(C3259p pVar, ConcurrentHashMap<C3254k, C3257n> concurrentHashMap, C3257n nVar) {
        this.f8570e = pVar;
        this.f8571f = concurrentHashMap;
        this.f8573h = nVar;
        this.f8572g = C3256m.m9535b().mo27853a(mo27916e());
        this.f8567b = new C3136i(new C3165c(this.f8572g, "session_store"), new C3275a(), "active_twittersession", "twittersession");
        this.f8568c = new C3136i(new C3165c(this.f8572g, "session_store"), new C3131a(), "active_guestsession", "guestsession");
        this.f8569d = new C3182k<>(this.f8567b, C3256m.m9535b().mo27856e(), new C3189o());
    }

    /* renamed from: a */
    public static C3270v m9566a() {
        if (f8566a == null) {
            synchronized (C3270v.class) {
                if (f8566a == null) {
                    f8566a = new C3270v(C3256m.m9535b().mo27855d());
                    C3256m.m9535b().mo27856e().execute(new Runnable() {
                        public void run() {
                            C3270v.f8566a.mo27915d();
                        }
                    });
                }
            }
        }
        return f8566a;
    }

    /* renamed from: c */
    public C3259p mo27914c() {
        return this.f8570e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo27915d() {
        this.f8567b.mo27626b();
        this.f8568c.mo27626b();
        mo27918g();
        m9567j();
        this.f8569d.mo27705a(C3256m.m9535b().mo27857f());
    }

    /* renamed from: j */
    private void m9567j() {
        C3211aa.m9413a(this.f8572g, mo27917f(), mo27918g(), C3256m.m9535b().mo27854c(), "TwitterCore", mo27913b());
    }

    /* renamed from: f */
    public C3255l<C3274y> mo27917f() {
        return this.f8567b;
    }

    /* renamed from: g */
    public C3132f mo27918g() {
        if (this.f8574i == null) {
            m9568k();
        }
        return this.f8574i;
    }

    /* renamed from: k */
    private synchronized void m9568k() {
        if (this.f8574i == null) {
            this.f8574i = new C3132f(new OAuth2Service(this, new C3188n()), this.f8568c);
        }
    }

    /* renamed from: h */
    public C3257n mo27919h() {
        C3274y yVar = (C3274y) this.f8567b.mo27626b();
        if (yVar == null) {
            return mo27920i();
        }
        return mo27912a(yVar);
    }

    /* renamed from: a */
    public C3257n mo27912a(C3274y yVar) {
        if (!this.f8571f.containsKey(yVar)) {
            this.f8571f.putIfAbsent(yVar, new C3257n(yVar));
        }
        return (C3257n) this.f8571f.get(yVar);
    }

    /* renamed from: i */
    public C3257n mo27920i() {
        if (this.f8573h == null) {
            m9569l();
        }
        return this.f8573h;
    }

    /* renamed from: l */
    private synchronized void m9569l() {
        if (this.f8573h == null) {
            this.f8573h = new C3257n();
        }
    }
}
