package com.p103a.p104a.p105a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.p103a.p104a.p105a.C1712g.C1714a;
import java.util.concurrent.ScheduledExecutorService;
import p000a.p001a.p002a.p003a.C0000a;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0028n;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p010e.C0087b;
import p000a.p001a.p002a.p003a.p004a.p011f.C0104b;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* renamed from: com.a.a.a.q */
/* compiled from: SessionAnalyticsManager */
class C1725q implements C1714a {

    /* renamed from: a */
    final C1701b f5396a;

    /* renamed from: b */
    final C0000a f5397b;

    /* renamed from: c */
    final C1712g f5398c;

    /* renamed from: d */
    final C1710e f5399d;

    /* renamed from: e */
    private final long f5400e;

    /* renamed from: a */
    public static C1725q m7215a(C0146i iVar, Context context, C0032o oVar, String str, String str2, long j) {
        Context context2 = context;
        C0032o oVar2 = oVar;
        C1733v vVar = new C1733v(context, oVar, str, str2);
        C0146i iVar2 = iVar;
        C1708c cVar = new C1708c(context, new C0104b(iVar));
        C0087b bVar = new C0087b(C0135c.m449h());
        C0000a aVar = new C0000a(context);
        ScheduledExecutorService b = C0028n.m105b("Answers Events Handler");
        C1712g gVar = new C1712g(b);
        C1701b bVar2 = new C1701b(iVar2, context, cVar, vVar, bVar, b);
        C1725q qVar = new C1725q(bVar2, aVar, gVar, C1710e.m7176a(context), j);
        return qVar;
    }

    C1725q(C1701b bVar, C0000a aVar, C1712g gVar, C1710e eVar, long j) {
        this.f5396a = bVar;
        this.f5397b = aVar;
        this.f5398c = gVar;
        this.f5399d = eVar;
        this.f5400e = j;
    }

    /* renamed from: b */
    public void mo6985b() {
        this.f5396a.mo6950b();
        this.f5397b.mo2a(new C1709d(this, this.f5398c));
        this.f5398c.mo6964a((C1714a) this);
        if (mo6987d()) {
            mo6981a(this.f5400e);
            this.f5399d.mo6961a();
        }
    }

    /* renamed from: c */
    public void mo6986c() {
        this.f5397b.mo1a();
        this.f5396a.mo6946a();
    }

    /* renamed from: a */
    public void mo6984a(String str, String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C0135c.m449h().mo270a("Answers", "Logged crash");
            this.f5396a.mo6953c(C1727s.m7231a(str, str2));
            return;
        }
        throw new IllegalStateException("onCrash called from main thread!!!");
    }

    /* renamed from: a */
    public void mo6981a(long j) {
        C0135c.m449h().mo270a("Answers", "Logged install");
        this.f5396a.mo6951b(C1727s.m7228a(j));
    }

    /* renamed from: a */
    public void mo6983a(Activity activity, C1730b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Logged lifecycle event: ");
        sb.append(bVar.name());
        C0135c.m449h().mo270a("Answers", sb.toString());
        this.f5396a.mo6948a(C1727s.m7229a(bVar, activity));
    }

    /* renamed from: a */
    public void mo6968a() {
        C0135c.m449h().mo270a("Answers", "Flush events when app is backgrounded");
        this.f5396a.mo6952c();
    }

    /* renamed from: a */
    public void mo6982a(C0108b bVar, String str) {
        this.f5398c.mo6965a(bVar.f225h);
        this.f5396a.mo6947a(bVar, str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo6987d() {
        return !this.f5399d.mo6962b();
    }
}
