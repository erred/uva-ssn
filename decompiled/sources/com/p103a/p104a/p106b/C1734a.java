package com.p103a.p104a.p106b;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o.C0033a;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p012g.C0112f;

/* renamed from: com.a.a.b.a */
/* compiled from: AbstractCheckForUpdatesController */
abstract class C1734a implements C1745j {

    /* renamed from: a */
    private final AtomicBoolean f5443a;

    /* renamed from: b */
    private final AtomicBoolean f5444b;

    /* renamed from: c */
    private Context f5445c;

    /* renamed from: d */
    private C1738c f5446d;

    /* renamed from: e */
    private C0032o f5447e;

    /* renamed from: f */
    private C0112f f5448f;

    /* renamed from: g */
    private C1739d f5449g;

    /* renamed from: h */
    private C0105c f5450h;

    /* renamed from: i */
    private C0025k f5451i;

    /* renamed from: j */
    private C0098e f5452j;

    /* renamed from: k */
    private long f5453k;

    public C1734a() {
        this(false);
    }

    public C1734a(boolean z) {
        this.f5443a = new AtomicBoolean();
        this.f5453k = 0;
        this.f5444b = new AtomicBoolean(z);
    }

    /* renamed from: a */
    public void mo6997a(Context context, C1738c cVar, C0032o oVar, C0112f fVar, C1739d dVar, C0105c cVar2, C0025k kVar, C0098e eVar) {
        this.f5445c = context;
        this.f5446d = cVar;
        this.f5447e = oVar;
        this.f5448f = fVar;
        this.f5449g = dVar;
        this.f5450h = cVar2;
        this.f5451i = kVar;
        this.f5452j = eVar;
        if (mo6999b()) {
            mo7000c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6998a() {
        this.f5444b.set(true);
        return this.f5443a.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo6999b() {
        this.f5443a.set(true);
        return this.f5444b.get();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: c */
    public void mo7000c() {
        synchronized (this.f5450h) {
            if (this.f5450h.mo245a().contains("last_update_check")) {
                this.f5450h.mo246a(this.f5450h.mo247b().remove("last_update_check"));
            }
        }
        long a = this.f5451i.mo49a();
        long j = ((long) this.f5448f.f248b) * 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("Check for updates delay: ");
        sb.append(j);
        C0135c.m449h().mo270a("Beta", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Check for updates last check time: ");
        sb2.append(mo7001d());
        C0135c.m449h().mo270a("Beta", sb2.toString());
        long d = mo7001d() + j;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Check for updates current time: ");
        sb3.append(a);
        sb3.append(", next check time: ");
        sb3.append(d);
        C0135c.m449h().mo270a("Beta", sb3.toString());
        if (a >= d) {
            try {
                m7239e();
            } finally {
                mo6996a(a);
            }
        } else {
            C0135c.m449h().mo270a("Beta", "Check for updates next check time was not passed");
        }
    }

    /* renamed from: e */
    private void m7239e() {
        C0135c.m449h().mo270a("Beta", "Performing update check");
        String a = new C0018g().mo40a(this.f5445c);
        String str = (String) this.f5447e.mo62i().get(C0033a.FONT_TOKEN);
        C1740e eVar = new C1740e(this.f5446d, this.f5446d.mo7006g(), this.f5448f.f247a, this.f5452j, new C1742g());
        eVar.mo7007a(a, str, this.f5449g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6996a(long j) {
        this.f5453k = j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public long mo7001d() {
        return this.f5453k;
    }
}
