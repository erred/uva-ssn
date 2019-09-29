package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0784c;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.b.a.r */
/* compiled from: WidgetContainer */
public class C0782r extends C0766f {

    /* renamed from: aw */
    protected ArrayList<C0766f> f2371aw = new ArrayList<>();

    /* renamed from: g */
    public void mo3095g() {
        this.f2371aw.clear();
        super.mo3095g();
    }

    /* renamed from: b */
    public void mo3174b(C0766f fVar) {
        this.f2371aw.add(fVar);
        if (fVar.mo3103k() != null) {
            ((C0782r) fVar.mo3103k()).mo3175c(fVar);
        }
        fVar.mo3076a_(this);
    }

    /* renamed from: c */
    public void mo3175c(C0766f fVar) {
        this.f2371aw.remove(fVar);
        fVar.mo3076a_(null);
    }

    /* renamed from: T */
    public C0769g mo3172T() {
        C0766f k = mo3103k();
        C0769g gVar = this instanceof C0769g ? (C0769g) this : null;
        while (k != null) {
            C0766f k2 = k.mo3103k();
            if (k instanceof C0769g) {
                gVar = (C0769g) k;
            }
            k = k2;
        }
        return gVar;
    }

    /* renamed from: b */
    public void mo3078b(int i, int i2) {
        super.mo3078b(i, i2);
        int size = this.f2371aw.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C0766f) this.f2371aw.get(i3)).mo3078b(mo3121v(), mo3122w());
        }
    }

    /* renamed from: E */
    public void mo3057E() {
        super.mo3057E();
        if (this.f2371aw != null) {
            int size = this.f2371aw.size();
            for (int i = 0; i < size; i++) {
                C0766f fVar = (C0766f) this.f2371aw.get(i);
                fVar.mo3078b(mo3118t(), mo3120u());
                if (!(fVar instanceof C0769g)) {
                    fVar.mo3057E();
                }
            }
        }
    }

    /* renamed from: N */
    public void mo3129N() {
        mo3057E();
        if (this.f2371aw != null) {
            int size = this.f2371aw.size();
            for (int i = 0; i < size; i++) {
                C0766f fVar = (C0766f) this.f2371aw.get(i);
                if (fVar instanceof C0782r) {
                    ((C0782r) fVar).mo3129N();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3072a(C0784c cVar) {
        super.mo3072a(cVar);
        int size = this.f2371aw.size();
        for (int i = 0; i < size; i++) {
            ((C0766f) this.f2371aw.get(i)).mo3072a(cVar);
        }
    }

    /* renamed from: U */
    public void mo3173U() {
        this.f2371aw.clear();
    }
}
