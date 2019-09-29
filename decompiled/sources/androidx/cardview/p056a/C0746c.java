package androidx.cardview.p056a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: androidx.cardview.a.c */
/* compiled from: CardViewApi21Impl */
class C0746c implements C0750f {
    /* renamed from: a */
    public void mo2961a() {
    }

    C0746c() {
    }

    /* renamed from: a */
    public void mo2965a(C0749e eVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        eVar.mo2956a(new C0751g(colorStateList, f));
        View d = eVar.mo2960d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        mo2968b(eVar, f3);
    }

    /* renamed from: a */
    public void mo2964a(C0749e eVar, float f) {
        m2610j(eVar).mo2978a(f);
    }

    /* renamed from: b */
    public void mo2968b(C0749e eVar, float f) {
        m2610j(eVar).mo2979a(f, eVar.mo2957a(), eVar.mo2958b());
        mo2973f(eVar);
    }

    /* renamed from: a */
    public float mo2963a(C0749e eVar) {
        return m2610j(eVar).mo2977a();
    }

    /* renamed from: b */
    public float mo2967b(C0749e eVar) {
        return mo2971d(eVar) * 2.0f;
    }

    /* renamed from: c */
    public float mo2969c(C0749e eVar) {
        return mo2971d(eVar) * 2.0f;
    }

    /* renamed from: d */
    public float mo2971d(C0749e eVar) {
        return m2610j(eVar).mo2981b();
    }

    /* renamed from: c */
    public void mo2970c(C0749e eVar, float f) {
        eVar.mo2960d().setElevation(f);
    }

    /* renamed from: e */
    public float mo2972e(C0749e eVar) {
        return eVar.mo2960d().getElevation();
    }

    /* renamed from: f */
    public void mo2973f(C0749e eVar) {
        if (!eVar.mo2957a()) {
            eVar.mo2955a(0, 0, 0, 0);
            return;
        }
        float a = mo2963a(eVar);
        float d = mo2971d(eVar);
        int ceil = (int) Math.ceil((double) C0752h.m2678b(a, d, eVar.mo2958b()));
        int ceil2 = (int) Math.ceil((double) C0752h.m2675a(a, d, eVar.mo2958b()));
        eVar.mo2955a(ceil, ceil2, ceil, ceil2);
    }

    /* renamed from: g */
    public void mo2974g(C0749e eVar) {
        mo2968b(eVar, mo2963a(eVar));
    }

    /* renamed from: h */
    public void mo2975h(C0749e eVar) {
        mo2968b(eVar, mo2963a(eVar));
    }

    /* renamed from: a */
    public void mo2966a(C0749e eVar, ColorStateList colorStateList) {
        m2610j(eVar).mo2980a(colorStateList);
    }

    /* renamed from: i */
    public ColorStateList mo2976i(C0749e eVar) {
        return m2610j(eVar).mo2982c();
    }

    /* renamed from: j */
    private C0751g m2610j(C0749e eVar) {
        return (C0751g) eVar.mo2959c();
    }
}
