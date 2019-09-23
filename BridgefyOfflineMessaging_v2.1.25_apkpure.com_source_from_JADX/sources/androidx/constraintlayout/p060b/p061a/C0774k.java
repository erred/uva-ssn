package androidx.constraintlayout.p060b.p061a;

import java.util.Arrays;

/* renamed from: androidx.constraintlayout.b.a.k */
/* compiled from: HelperWidget */
public class C0774k extends C0766f implements C0773j {

    /* renamed from: af */
    protected C0766f[] f2342af = new C0766f[4];

    /* renamed from: ag */
    protected int f2343ag = 0;

    /* renamed from: a */
    public void mo3146a(C0766f fVar) {
        if (this.f2343ag + 1 > this.f2342af.length) {
            this.f2342af = (C0766f[]) Arrays.copyOf(this.f2342af, this.f2342af.length * 2);
        }
        this.f2342af[this.f2343ag] = fVar;
        this.f2343ag++;
    }

    /* renamed from: a_ */
    public void mo3147a_() {
        this.f2343ag = 0;
    }
}
