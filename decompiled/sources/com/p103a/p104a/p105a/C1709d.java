package com.p103a.p104a.p105a;

import android.app.Activity;
import android.os.Bundle;
import p000a.p001a.p002a.p003a.C0000a.C0003b;

/* renamed from: com.a.a.a.d */
/* compiled from: AnswersLifecycleCallbacks */
class C1709d extends C0003b {

    /* renamed from: a */
    private final C1725q f5363a;

    /* renamed from: b */
    private final C1712g f5364b;

    /* renamed from: a */
    public void mo11a(Activity activity, Bundle bundle) {
    }

    /* renamed from: b */
    public void mo13b(Activity activity, Bundle bundle) {
    }

    /* renamed from: e */
    public void mo16e(Activity activity) {
    }

    public C1709d(C1725q qVar, C1712g gVar) {
        this.f5363a = qVar;
        this.f5364b = gVar;
    }

    /* renamed from: a */
    public void mo10a(Activity activity) {
        this.f5363a.mo6983a(activity, C1730b.START);
    }

    /* renamed from: b */
    public void mo12b(Activity activity) {
        this.f5363a.mo6983a(activity, C1730b.RESUME);
        this.f5364b.mo6963a();
    }

    /* renamed from: c */
    public void mo14c(Activity activity) {
        this.f5363a.mo6983a(activity, C1730b.PAUSE);
        this.f5364b.mo6966b();
    }

    /* renamed from: d */
    public void mo15d(Activity activity) {
        this.f5363a.mo6983a(activity, C1730b.STOP);
    }
}
