package p000a.p001a.p002a.p003a.p004a.p005a;

import android.content.Context;

/* renamed from: a.a.a.a.a.a.a */
/* compiled from: AbstractValueCache */
public abstract class C0004a<T> implements C0006c<T> {

    /* renamed from: a */
    private final C0006c<T> f6a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo17a(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo19a(Context context, T t);

    public C0004a(C0006c<T> cVar) {
        this.f6a = cVar;
    }

    /* renamed from: a */
    public final synchronized T mo18a(Context context, C0007d<T> dVar) throws Exception {
        T a;
        a = mo17a(context);
        if (a == null) {
            a = this.f6a != null ? this.f6a.mo18a(context, dVar) : dVar.mo20b(context);
            m13b(context, a);
        }
        return a;
    }

    /* renamed from: b */
    private void m13b(Context context, T t) {
        if (t != null) {
            mo19a(context, t);
            return;
        }
        throw new NullPointerException();
    }
}
