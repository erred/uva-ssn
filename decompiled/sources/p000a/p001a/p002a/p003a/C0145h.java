package p000a.p001a.p002a.p003a;

import p000a.p001a.p002a.p003a.p004a.p006b.C0043t;
import p000a.p001a.p002a.p003a.p004a.p007c.C0063e;
import p000a.p001a.p002a.p003a.p004a.p007c.C0064f;
import p000a.p001a.p002a.p003a.p004a.p007c.C0074m;

/* renamed from: a.a.a.a.h */
/* compiled from: InitializationTask */
class C0145h<Result> extends C0064f<Void, Void, Result> {

    /* renamed from: a */
    final C0146i<Result> f342a;

    public C0145h(C0146i<Result> iVar) {
        this.f342a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo86a() {
        super.mo86a();
        C0043t a = m479a("onPreExecute");
        try {
            boolean b_ = this.f342a.mo315b_();
            a.mo83b();
            if (b_) {
                return;
            }
        } catch (C0074m e) {
            throw e;
        } catch (Exception e2) {
            C0135c.m449h().mo280e("Fabric", "Failure onPreExecute()", e2);
            a.mo83b();
        } catch (Throwable th) {
            a.mo83b();
            mo88a(true);
            throw th;
        }
        mo88a(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Result mo85a(Void... voidArr) {
        C0043t a = m479a("doInBackground");
        Result e = !mo93e() ? this.f342a.mo317e() : null;
        a.mo83b();
        return e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo87a(Result result) {
        this.f342a.mo311a(result);
        this.f342a.f346h.mo293a(result);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo89b(Result result) {
        this.f342a.mo313b(result);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f342a.mo312b());
        sb.append(" Initialization was cancelled");
        this.f342a.f346h.mo292a((Exception) new C0144g(sb.toString()));
    }

    /* renamed from: b */
    public C0063e mo135b() {
        return C0063e.HIGH;
    }

    /* renamed from: a */
    private C0043t m479a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f342a.mo312b());
        sb.append(".");
        sb.append(str);
        C0043t tVar = new C0043t(sb.toString(), "KitInitialization");
        tVar.mo82a();
        return tVar;
    }
}
