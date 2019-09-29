package com.p103a.p104a.p105a;

import android.content.Context;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.C0149l;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p009d.C0082f;
import p000a.p001a.p002a.p003a.p004a.p009d.C0085i;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* renamed from: com.a.a.a.i */
/* compiled from: EnabledSessionAnalyticsManagerStrategy */
class C1716i implements C1726r {

    /* renamed from: a */
    final C1731t f5374a;

    /* renamed from: b */
    C0082f f5375b;

    /* renamed from: c */
    C0018g f5376c = new C0018g();

    /* renamed from: d */
    C1717j f5377d = new C1718k();

    /* renamed from: e */
    boolean f5378e = true;

    /* renamed from: f */
    boolean f5379f = true;

    /* renamed from: g */
    volatile int f5380g = -1;

    /* renamed from: h */
    private final C0146i f5381h;

    /* renamed from: i */
    private final C0098e f5382i;

    /* renamed from: j */
    private final Context f5383j;

    /* renamed from: k */
    private final C1723o f5384k;

    /* renamed from: l */
    private final ScheduledExecutorService f5385l;

    /* renamed from: m */
    private final AtomicReference<ScheduledFuture<?>> f5386m = new AtomicReference<>();

    public C1716i(C0146i iVar, Context context, ScheduledExecutorService scheduledExecutorService, C1723o oVar, C0098e eVar, C1731t tVar) {
        this.f5381h = iVar;
        this.f5383j = context;
        this.f5385l = scheduledExecutorService;
        this.f5384k = oVar;
        this.f5382i = eVar;
        this.f5374a = tVar;
    }

    /* renamed from: a */
    public void mo6970a(C0108b bVar, String str) {
        C1724p pVar = new C1724p(this.f5381h, str, bVar.f218a, this.f5382i, this.f5376c.mo40a(this.f5383j));
        this.f5375b = C1711f.m7179a(pVar);
        this.f5384k.mo6980a(bVar);
        this.f5378e = bVar.f223f;
        C0149l h = C0135c.m449h();
        String str2 = "Answers";
        StringBuilder sb = new StringBuilder();
        sb.append("Custom event tracking ");
        sb.append(this.f5378e ? "enabled" : "disabled");
        h.mo270a(str2, sb.toString());
        this.f5379f = bVar.f224g;
        C0149l h2 = C0135c.m449h();
        String str3 = "Answers";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Predefined event tracking ");
        sb2.append(this.f5379f ? "enabled" : "disabled");
        h2.mo270a(str3, sb2.toString());
        if (bVar.f226i > 1) {
            C0135c.m449h().mo270a("Answers", "Event sampling enabled");
            this.f5377d = new C1721n(bVar.f226i);
        }
        this.f5380g = bVar.f219b;
        mo6973a(0, (long) this.f5380g);
    }

    /* renamed from: a */
    public void mo6971a(C1729a aVar) {
        C1727s a = aVar.mo6990a(this.f5374a);
        if (!this.f5378e && C1730b.CUSTOM.equals(a.f5403c)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Custom events tracking disabled - skipping event: ");
            sb.append(a);
            C0135c.m449h().mo270a("Answers", sb.toString());
        } else if (!this.f5379f && C1730b.PREDEFINED.equals(a.f5403c)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Predefined events tracking disabled - skipping event: ");
            sb2.append(a);
            C0135c.m449h().mo270a("Answers", sb2.toString());
        } else if (this.f5377d.mo6975a(a)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Skipping filtered event: ");
            sb3.append(a);
            C0135c.m449h().mo270a("Answers", sb3.toString());
        } else {
            try {
                this.f5384k.mo158a(a);
            } catch (IOException e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to write event: ");
                sb4.append(a);
                C0135c.m449h().mo280e("Answers", sb4.toString(), e);
            }
            mo6974e();
        }
    }

    /* renamed from: e */
    public void mo6974e() {
        if (this.f5380g != -1) {
            mo6973a((long) this.f5380g, (long) this.f5380g);
        }
    }

    /* renamed from: a */
    public void mo6969a() {
        if (this.f5375b == null) {
            C0020i.m67a(this.f5383j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C0020i.m67a(this.f5383j, "Sending all files");
        List e = this.f5384k.mo163e();
        int i = 0;
        while (true) {
            try {
                if (e.size() <= 0) {
                    break;
                }
                C0020i.m67a(this.f5383j, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e.size())}));
                boolean a = this.f5375b.mo180a(e);
                if (a) {
                    i += e.size();
                    this.f5384k.mo159a(e);
                }
                if (!a) {
                    break;
                }
                e = this.f5384k.mo163e();
            } catch (Exception e2) {
                Context context = this.f5383j;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to send batch of analytics files to server: ");
                sb.append(e2.getMessage());
                C0020i.m68a(context, sb.toString(), (Throwable) e2);
            }
        }
        if (i == 0) {
            this.f5384k.mo165g();
        }
    }

    /* renamed from: d */
    public void mo179d() {
        if (this.f5386m.get() != null) {
            C0020i.m67a(this.f5383j, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f5386m.get()).cancel(false);
            this.f5386m.set(null);
        }
    }

    /* renamed from: b */
    public void mo6972b() {
        this.f5384k.mo164f();
    }

    /* renamed from: c */
    public boolean mo178c() {
        try {
            return this.f5384k.mo162d();
        } catch (IOException e) {
            C0020i.m68a(this.f5383j, "Failed to roll file over.", (Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6973a(long j, long j2) {
        if (this.f5386m.get() == null) {
            C0085i iVar = new C0085i(this.f5383j, this);
            Context context = this.f5383j;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling time based file roll over every ");
            sb.append(j2);
            sb.append(" seconds");
            C0020i.m67a(context, sb.toString());
            try {
                this.f5386m.set(this.f5385l.scheduleAtFixedRate(iVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                C0020i.m68a(this.f5383j, "Failed to schedule time based file roll over", (Throwable) e);
            }
        }
    }
}
