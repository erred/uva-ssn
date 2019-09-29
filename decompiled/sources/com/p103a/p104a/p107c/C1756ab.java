package com.p103a.p104a.p107c;

import android.annotation.SuppressLint;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;

@SuppressLint({"CommitPrefEdits"})
/* renamed from: com.a.a.c.ab */
/* compiled from: PreferenceManager */
class C1756ab {

    /* renamed from: a */
    private final C0105c f5509a;

    /* renamed from: a */
    public static C1756ab m7277a(C0105c cVar, C1814i iVar) {
        if (!cVar.mo245a().getBoolean("preferences_migration_complete", false)) {
            C0106d dVar = new C0106d(iVar);
            if (!cVar.mo245a().contains("always_send_reports_opt_in") && dVar.mo245a().contains("always_send_reports_opt_in")) {
                cVar.mo246a(cVar.mo247b().putBoolean("always_send_reports_opt_in", dVar.mo245a().getBoolean("always_send_reports_opt_in", false)));
            }
            cVar.mo246a(cVar.mo247b().putBoolean("preferences_migration_complete", true));
        }
        return new C1756ab(cVar);
    }

    public C1756ab(C0105c cVar) {
        this.f5509a = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7016a(boolean z) {
        this.f5509a.mo246a(this.f5509a.mo247b().putBoolean("always_send_reports_opt_in", z));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7017a() {
        return this.f5509a.mo245a().getBoolean("always_send_reports_opt_in", false);
    }
}
