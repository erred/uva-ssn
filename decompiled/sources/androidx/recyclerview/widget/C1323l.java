package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.C1248f;
import androidx.recyclerview.widget.RecyclerView.C1248f.C1251c;
import androidx.recyclerview.widget.RecyclerView.C1277x;

/* renamed from: androidx.recyclerview.widget.l */
/* compiled from: SimpleItemAnimator */
public abstract class C1323l extends C1248f {

    /* renamed from: h */
    boolean f3984h = true;

    /* renamed from: a */
    public abstract boolean mo5468a(C1277x xVar);

    /* renamed from: a */
    public abstract boolean mo5469a(C1277x xVar, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public abstract boolean mo5470a(C1277x xVar, C1277x xVar2, int i, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract boolean mo5472b(C1277x xVar);

    /* renamed from: c */
    public void mo5551c(C1277x xVar, boolean z) {
    }

    /* renamed from: d */
    public void mo5552d(C1277x xVar, boolean z) {
    }

    /* renamed from: o */
    public void mo5559o(C1277x xVar) {
    }

    /* renamed from: p */
    public void mo5560p(C1277x xVar) {
    }

    /* renamed from: q */
    public void mo5561q(C1277x xVar) {
    }

    /* renamed from: r */
    public void mo5562r(C1277x xVar) {
    }

    /* renamed from: s */
    public void mo5563s(C1277x xVar) {
    }

    /* renamed from: t */
    public void mo5564t(C1277x xVar) {
    }

    /* renamed from: a */
    public void mo5549a(boolean z) {
        this.f3984h = z;
    }

    /* renamed from: h */
    public boolean mo5085h(C1277x xVar) {
        return !this.f3984h || xVar.isInvalid();
    }

    /* renamed from: a */
    public boolean mo5071a(C1277x xVar, C1251c cVar, C1251c cVar2) {
        int i = cVar.f3700a;
        int i2 = cVar.f3701b;
        View view = xVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3700a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3701b;
        if (xVar.isRemoved() || (i == left && i2 == top)) {
            return mo5468a(xVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo5469a(xVar, i, i2, left, top);
    }

    /* renamed from: b */
    public boolean mo5075b(C1277x xVar, C1251c cVar, C1251c cVar2) {
        if (cVar == null || (cVar.f3700a == cVar2.f3700a && cVar.f3701b == cVar2.f3701b)) {
            return mo5472b(xVar);
        }
        return mo5469a(xVar, cVar.f3700a, cVar.f3701b, cVar2.f3700a, cVar2.f3701b);
    }

    /* renamed from: c */
    public boolean mo5076c(C1277x xVar, C1251c cVar, C1251c cVar2) {
        if (cVar.f3700a == cVar2.f3700a && cVar.f3701b == cVar2.f3701b) {
            mo5554j(xVar);
            return false;
        }
        return mo5469a(xVar, cVar.f3700a, cVar.f3701b, cVar2.f3700a, cVar2.f3701b);
    }

    /* renamed from: a */
    public boolean mo5072a(C1277x xVar, C1277x xVar2, C1251c cVar, C1251c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f3700a;
        int i4 = cVar.f3701b;
        if (xVar2.shouldIgnore()) {
            int i5 = cVar.f3700a;
            i = cVar.f3701b;
            i2 = i5;
        } else {
            i2 = cVar2.f3700a;
            i = cVar2.f3701b;
        }
        return mo5470a(xVar, xVar2, i3, i4, i2, i);
    }

    /* renamed from: i */
    public final void mo5553i(C1277x xVar) {
        mo5560p(xVar);
        mo5081f(xVar);
    }

    /* renamed from: j */
    public final void mo5554j(C1277x xVar) {
        mo5564t(xVar);
        mo5081f(xVar);
    }

    /* renamed from: k */
    public final void mo5555k(C1277x xVar) {
        mo5562r(xVar);
        mo5081f(xVar);
    }

    /* renamed from: a */
    public final void mo5548a(C1277x xVar, boolean z) {
        mo5552d(xVar, z);
        mo5081f(xVar);
    }

    /* renamed from: l */
    public final void mo5556l(C1277x xVar) {
        mo5559o(xVar);
    }

    /* renamed from: m */
    public final void mo5557m(C1277x xVar) {
        mo5563s(xVar);
    }

    /* renamed from: n */
    public final void mo5558n(C1277x xVar) {
        mo5561q(xVar);
    }

    /* renamed from: b */
    public final void mo5550b(C1277x xVar, boolean z) {
        mo5551c(xVar, z);
    }
}
