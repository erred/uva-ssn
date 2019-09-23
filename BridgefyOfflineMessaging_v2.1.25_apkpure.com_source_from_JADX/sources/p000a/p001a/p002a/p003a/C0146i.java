package p000a.p001a.p002a.p003a;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p007c.C0062d;
import p000a.p001a.p002a.p003a.p004a.p007c.C0073l;

/* renamed from: a.a.a.a.i */
/* compiled from: Kit */
public abstract class C0146i<Result> implements Comparable<C0146i> {

    /* renamed from: e */
    C0135c f343e;

    /* renamed from: f */
    C0145h<Result> f344f = new C0145h<>(this);

    /* renamed from: g */
    Context f345g;

    /* renamed from: h */
    C0141f<Result> f346h;

    /* renamed from: i */
    C0032o f347i;

    /* renamed from: j */
    final C0062d f348j = ((C0062d) getClass().getAnnotation(C0062d.class));

    /* renamed from: a */
    public abstract String mo309a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo311a(Result result) {
    }

    /* renamed from: b */
    public abstract String mo312b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo313b(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b_ */
    public boolean mo315b_() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract Result mo317e();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo310a(Context context, C0135c cVar, C0141f<Result> fVar, C0032o oVar) {
        this.f343e = cVar;
        this.f345g = new C0139d(context, mo312b(), mo322s());
        this.f346h = fVar;
        this.f347i = oVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final void mo318o() {
        this.f344f.mo134a(this.f343e.mo290f(), null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C0032o mo319p() {
        return this.f347i;
    }

    /* renamed from: q */
    public Context mo320q() {
        return this.f345g;
    }

    /* renamed from: r */
    public C0135c mo321r() {
        return this.f343e;
    }

    /* renamed from: s */
    public String mo322s() {
        StringBuilder sb = new StringBuilder();
        sb.append(".Fabric");
        sb.append(File.separator);
        sb.append(mo312b());
        return sb.toString();
    }

    /* renamed from: a */
    public int compareTo(C0146i iVar) {
        if (mo314b(iVar)) {
            return 1;
        }
        if (iVar.mo314b(this)) {
            return -1;
        }
        if (mo323t() && !iVar.mo323t()) {
            return 1;
        }
        if (mo323t() || !iVar.mo323t()) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo314b(C0146i iVar) {
        if (mo323t()) {
            for (Class isAssignableFrom : this.f348j.mo131a()) {
                if (isAssignableFrom.isAssignableFrom(iVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public boolean mo323t() {
        return this.f348j != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public Collection<C0073l> mo324u() {
        return this.f344f.mo105c();
    }
}
