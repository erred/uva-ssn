package com.p103a.p104a.p105a;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p009d.C0080d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* renamed from: com.a.a.a.b */
/* compiled from: AnswersEventsHandler */
class C1701b implements C0080d {

    /* renamed from: a */
    final ScheduledExecutorService f5344a;

    /* renamed from: b */
    C1726r f5345b = new C1715h();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0146i f5346c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f5347d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C1708c f5348e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C1733v f5349f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C0098e f5350g;

    public C1701b(C0146i iVar, Context context, C1708c cVar, C1733v vVar, C0098e eVar, ScheduledExecutorService scheduledExecutorService) {
        this.f5346c = iVar;
        this.f5347d = context;
        this.f5348e = cVar;
        this.f5349f = vVar;
        this.f5350g = eVar;
        this.f5344a = scheduledExecutorService;
    }

    /* renamed from: a */
    public void mo6948a(C1729a aVar) {
        mo6949a(aVar, false, false);
    }

    /* renamed from: b */
    public void mo6951b(C1729a aVar) {
        mo6949a(aVar, false, true);
    }

    /* renamed from: c */
    public void mo6953c(C1729a aVar) {
        mo6949a(aVar, true, false);
    }

    /* renamed from: a */
    public void mo6947a(final C0108b bVar, final String str) {
        m7155b((Runnable) new Runnable() {
            public void run() {
                try {
                    C1701b.this.f5345b.mo6970a(bVar, str);
                } catch (Exception e) {
                    C0135c.m449h().mo280e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo6946a() {
        m7155b((Runnable) new Runnable() {
            public void run() {
                try {
                    C1726r rVar = C1701b.this.f5345b;
                    C1701b.this.f5345b = new C1715h();
                    rVar.mo6972b();
                } catch (Exception e) {
                    C0135c.m449h().mo280e("Answers", "Failed to disable events", e);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo177a(String str) {
        m7155b((Runnable) new Runnable() {
            public void run() {
                try {
                    C1701b.this.f5345b.mo6969a();
                } catch (Exception e) {
                    C0135c.m449h().mo280e("Answers", "Failed to send events files", e);
                }
            }
        });
    }

    /* renamed from: b */
    public void mo6950b() {
        m7155b((Runnable) new Runnable() {
            public void run() {
                try {
                    C1731t a = C1701b.this.f5349f.mo6995a();
                    C1723o a2 = C1701b.this.f5348e.mo6960a();
                    a2.mo157a((C0080d) C1701b.this);
                    C1701b bVar = C1701b.this;
                    C1716i iVar = new C1716i(C1701b.this.f5346c, C1701b.this.f5347d, C1701b.this.f5344a, a2, C1701b.this.f5350g, a);
                    bVar.f5345b = iVar;
                } catch (Exception e) {
                    C0135c.m449h().mo280e("Answers", "Failed to enable events", e);
                }
            }
        });
    }

    /* renamed from: c */
    public void mo6952c() {
        m7155b((Runnable) new Runnable() {
            public void run() {
                try {
                    C1701b.this.f5345b.mo178c();
                } catch (Exception e) {
                    C0135c.m449h().mo280e("Answers", "Failed to flush events", e);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6949a(final C1729a aVar, boolean z, final boolean z2) {
        C17076 r0 = new Runnable() {
            public void run() {
                try {
                    C1701b.this.f5345b.mo6971a(aVar);
                    if (z2) {
                        C1701b.this.f5345b.mo178c();
                    }
                } catch (Exception e) {
                    C0135c.m449h().mo280e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            m7153a((Runnable) r0);
        } else {
            m7155b((Runnable) r0);
        }
    }

    /* renamed from: a */
    private void m7153a(Runnable runnable) {
        try {
            this.f5344a.submit(runnable).get();
        } catch (Exception e) {
            C0135c.m449h().mo280e("Answers", "Failed to run events task", e);
        }
    }

    /* renamed from: b */
    private void m7155b(Runnable runnable) {
        try {
            this.f5344a.submit(runnable);
        } catch (Exception e) {
            C0135c.m449h().mo280e("Answers", "Failed to submit events task", e);
        }
    }
}
