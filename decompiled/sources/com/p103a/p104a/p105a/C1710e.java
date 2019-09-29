package com.p103a.p104a.p105a;

import android.annotation.SuppressLint;
import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;

/* renamed from: com.a.a.a.e */
/* compiled from: AnswersPreferenceManager */
class C1710e {

    /* renamed from: a */
    private final C0105c f5365a;

    /* renamed from: a */
    public static C1710e m7176a(Context context) {
        return new C1710e(new C0106d(context, "settings"));
    }

    C1710e(C0105c cVar) {
        this.f5365a = cVar;
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public void mo6961a() {
        this.f5365a.mo246a(this.f5365a.mo247b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public boolean mo6962b() {
        return this.f5365a.mo245a().getBoolean("analytics_launched", false);
    }
}
