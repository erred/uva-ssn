package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.p070g.p071a.C0935b.C0938c;
import androidx.recyclerview.widget.RecyclerView.C1254i.C1257a;
import androidx.recyclerview.widget.RecyclerView.C1259j;
import androidx.recyclerview.widget.RecyclerView.C1266p;
import androidx.recyclerview.widget.RecyclerView.C1274u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.primitives.Ints;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a */
    boolean f3638a = false;

    /* renamed from: b */
    int f3639b = -1;

    /* renamed from: c */
    int[] f3640c;

    /* renamed from: d */
    View[] f3641d;

    /* renamed from: e */
    final SparseIntArray f3642e = new SparseIntArray();

    /* renamed from: f */
    final SparseIntArray f3643f = new SparseIntArray();

    /* renamed from: g */
    C1231c f3644g = new C1229a();

    /* renamed from: h */
    final Rect f3645h = new Rect();

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$a */
    public static final class C1229a extends C1231c {
        /* renamed from: a */
        public int mo4751a(int i) {
            return 1;
        }

        /* renamed from: a */
        public int mo4752a(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$b */
    public static class C1230b extends C1259j {

        /* renamed from: a */
        int f3646a = -1;

        /* renamed from: b */
        int f3647b = 0;

        public C1230b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C1230b(int i, int i2) {
            super(i, i2);
        }

        public C1230b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1230b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int mo4753a() {
            return this.f3646a;
        }

        /* renamed from: b */
        public int mo4754b() {
            return this.f3647b;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$c */
    public static abstract class C1231c {

        /* renamed from: a */
        final SparseIntArray f3648a = new SparseIntArray();

        /* renamed from: b */
        private boolean f3649b = false;

        /* renamed from: a */
        public abstract int mo4751a(int i);

        /* renamed from: a */
        public void mo4755a() {
            this.f3648a.clear();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo4757b(int i, int i2) {
            if (!this.f3649b) {
                return mo4752a(i, i2);
            }
            int i3 = this.f3648a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int a = mo4752a(i, i2);
            this.f3648a.put(i, a);
            return a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[RETURN] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo4752a(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.mo4751a(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f3649b
                if (r2 == 0) goto L_0x0028
                android.util.SparseIntArray r2 = r5.f3648a
                int r2 = r2.size()
                if (r2 <= 0) goto L_0x0028
                int r2 = r5.mo4756b(r6)
                if (r2 < 0) goto L_0x0028
                android.util.SparseIntArray r3 = r5.f3648a
                int r3 = r3.get(r2)
                int r4 = r5.mo4751a(r2)
                int r3 = r3 + r4
                int r2 = r2 + 1
                goto L_0x002a
            L_0x0028:
                r2 = 0
                r3 = 0
            L_0x002a:
                if (r2 >= r6) goto L_0x003b
                int r4 = r5.mo4751a(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x0035
                r3 = 0
                goto L_0x0038
            L_0x0035:
                if (r3 <= r7) goto L_0x0038
                r3 = r4
            L_0x0038:
                int r2 = r2 + 1
                goto L_0x002a
            L_0x003b:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x003f
                return r3
            L_0x003f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.C1231c.mo4752a(int, int):int");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo4756b(int i) {
            int size = this.f3648a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f3648a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f3648a.size()) {
                return -1;
            }
            return this.f3648a.keyAt(i4);
        }

        /* renamed from: c */
        public int mo4758c(int i, int i2) {
            int a = mo4751a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a2 = mo4751a(i5);
                i3 += a2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a2;
                }
            }
            return i3 + a > i2 ? i4 + 1 : i4;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo4733a(m4784a(context, attributeSet, i, i2).f3726b);
    }

    /* renamed from: a */
    public void mo4744a(boolean z) {
        if (!z) {
            super.mo4744a(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    /* renamed from: a */
    public int mo4727a(C1266p pVar, C1274u uVar) {
        if (this.f3658i == 0) {
            return this.f3639b;
        }
        if (uVar.mo5291e() < 1) {
            return 0;
        }
        return m4568a(pVar, uVar, uVar.mo5291e() - 1) + 1;
    }

    /* renamed from: b */
    public int mo4747b(C1266p pVar, C1274u uVar) {
        if (this.f3658i == 1) {
            return this.f3639b;
        }
        if (uVar.mo5291e() < 1) {
            return 0;
        }
        return m4568a(pVar, uVar, uVar.mo5291e() - 1) + 1;
    }

    /* renamed from: a */
    public void mo4735a(C1266p pVar, C1274u uVar, View view, C0935b bVar) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C1230b)) {
            super.mo5116a(view, bVar);
            return;
        }
        C1230b bVar2 = (C1230b) layoutParams;
        int a = m4568a(pVar, uVar, bVar2.mo5199f());
        if (this.f3658i == 0) {
            bVar.mo3680b((Object) C0938c.m3471a(bVar2.mo4753a(), bVar2.mo4754b(), a, 1, this.f3639b > 1 && bVar2.mo4754b() == this.f3639b, false));
        } else {
            bVar.mo3680b((Object) C0938c.m3471a(a, 1, bVar2.mo4753a(), bVar2.mo4754b(), this.f3639b > 1 && bVar2.mo4754b() == this.f3639b, false));
        }
    }

    /* renamed from: c */
    public void mo4750c(C1266p pVar, C1274u uVar) {
        if (uVar.mo5287a()) {
            m4565M();
        }
        super.mo4750c(pVar, uVar);
        m4564L();
    }

    /* renamed from: a */
    public void mo4738a(C1274u uVar) {
        super.mo4738a(uVar);
        this.f3638a = false;
    }

    /* renamed from: L */
    private void m4564L() {
        this.f3642e.clear();
        this.f3643f.clear();
    }

    /* renamed from: M */
    private void m4565M() {
        int w = mo5186w();
        for (int i = 0; i < w; i++) {
            C1230b bVar = (C1230b) mo5169i(i).getLayoutParams();
            int f = bVar.mo5199f();
            this.f3642e.put(f, bVar.mo4754b());
            this.f3643f.put(f, bVar.mo4753a());
        }
    }

    /* renamed from: a */
    public void mo4741a(RecyclerView recyclerView, int i, int i2) {
        this.f3644g.mo4755a();
    }

    /* renamed from: a */
    public void mo4740a(RecyclerView recyclerView) {
        this.f3644g.mo4755a();
    }

    /* renamed from: b */
    public void mo4748b(RecyclerView recyclerView, int i, int i2) {
        this.f3644g.mo4755a();
    }

    /* renamed from: a */
    public void mo4743a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f3644g.mo4755a();
    }

    /* renamed from: a */
    public void mo4742a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f3644g.mo4755a();
    }

    /* renamed from: a */
    public C1259j mo4730a() {
        if (this.f3658i == 0) {
            return new C1230b(-2, -1);
        }
        return new C1230b(-1, -2);
    }

    /* renamed from: a */
    public C1259j mo4731a(Context context, AttributeSet attributeSet) {
        return new C1230b(context, attributeSet);
    }

    /* renamed from: a */
    public C1259j mo4732a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C1230b((MarginLayoutParams) layoutParams);
        }
        return new C1230b(layoutParams);
    }

    /* renamed from: a */
    public boolean mo4745a(C1259j jVar) {
        return jVar instanceof C1230b;
    }

    /* renamed from: N */
    private void m4566N() {
        int i;
        if (mo4785g() == 1) {
            i = (mo5189z() - mo5101D()) - mo5099B();
        } else {
            i = (mo5098A() - mo5102E()) - mo5100C();
        }
        m4577m(i);
    }

    /* renamed from: a */
    public void mo4734a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f3640c == null) {
            super.mo4734a(rect, i, i2);
        }
        int B = mo5099B() + mo5101D();
        int C = mo5100C() + mo5102E();
        if (this.f3658i == 1) {
            i4 = m4782a(i2, rect.height() + C, mo5105H());
            i3 = m4782a(i, this.f3640c[this.f3640c.length - 1] + B, mo5104G());
        } else {
            i3 = m4782a(i, rect.width() + B, mo5104G());
            i4 = m4782a(i2, this.f3640c[this.f3640c.length - 1] + C, mo5105H());
        }
        mo5162f(i3, i4);
    }

    /* renamed from: m */
    private void m4577m(int i) {
        this.f3640c = m4573a(this.f3640c, this.f3639b, i);
    }

    /* renamed from: a */
    static int[] m4573a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo4725a(int i, int i2) {
        if (this.f3658i != 1 || !mo4788h()) {
            return this.f3640c[i2 + i] - this.f3640c[i];
        }
        return this.f3640c[this.f3639b - i] - this.f3640c[(this.f3639b - i) - i2];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4736a(C1266p pVar, C1274u uVar, C1232a aVar, int i) {
        super.mo4736a(pVar, uVar, aVar, i);
        m4566N();
        if (uVar.mo5291e() > 0 && !uVar.mo5287a()) {
            m4575b(pVar, uVar, aVar, i);
        }
        m4567O();
    }

    /* renamed from: O */
    private void m4567O() {
        if (this.f3641d == null || this.f3641d.length != this.f3639b) {
            this.f3641d = new View[this.f3639b];
        }
    }

    /* renamed from: a */
    public int mo4726a(int i, C1266p pVar, C1274u uVar) {
        m4566N();
        m4567O();
        return super.mo4726a(i, pVar, uVar);
    }

    /* renamed from: b */
    public int mo4746b(int i, C1266p pVar, C1274u uVar) {
        m4566N();
        m4567O();
        return super.mo4746b(i, pVar, uVar);
    }

    /* renamed from: b */
    private void m4575b(C1266p pVar, C1274u uVar, C1232a aVar, int i) {
        boolean z = i == 1;
        int b = m4574b(pVar, uVar, aVar.f3666b);
        if (z) {
            while (b > 0 && aVar.f3666b > 0) {
                aVar.f3666b--;
                b = m4574b(pVar, uVar, aVar.f3666b);
            }
            return;
        }
        int e = uVar.mo5291e() - 1;
        int i2 = aVar.f3666b;
        while (i2 < e) {
            int i3 = i2 + 1;
            int b2 = m4574b(pVar, uVar, i3);
            if (b2 <= b) {
                break;
            }
            i2 = i3;
            b = b2;
        }
        aVar.f3666b = i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo4729a(C1266p pVar, C1274u uVar, int i, int i2, int i3) {
        mo4789i();
        int c = this.f3659j.mo5535c();
        int d = this.f3659j.mo5537d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View i5 = mo5169i(i);
            int d2 = mo5152d(i5);
            if (d2 >= 0 && d2 < i3 && m4574b(pVar, uVar, d2) == 0) {
                if (((C1259j) i5.getLayoutParams()).mo5197d()) {
                    if (view2 == null) {
                        view2 = i5;
                    }
                } else if (this.f3659j.mo5530a(i5) < d && this.f3659j.mo5534b(i5) >= c) {
                    return i5;
                } else {
                    if (view == null) {
                        view = i5;
                    }
                }
            }
            i += i4;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    /* renamed from: a */
    private int m4568a(C1266p pVar, C1274u uVar, int i) {
        if (!uVar.mo5287a()) {
            return this.f3644g.mo4758c(i, this.f3639b);
        }
        int b = pVar.mo5232b(i);
        if (b != -1) {
            return this.f3644g.mo4758c(b, this.f3639b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. ");
        sb.append(i);
        Log.w("GridLayoutManager", sb.toString());
        return 0;
    }

    /* renamed from: b */
    private int m4574b(C1266p pVar, C1274u uVar, int i) {
        if (!uVar.mo5287a()) {
            return this.f3644g.mo4757b(i, this.f3639b);
        }
        int i2 = this.f3643f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = pVar.mo5232b(i);
        if (b != -1) {
            return this.f3644g.mo4757b(b, this.f3639b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i);
        Log.w("GridLayoutManager", sb.toString());
        return 0;
    }

    /* renamed from: c */
    private int m4576c(C1266p pVar, C1274u uVar, int i) {
        if (!uVar.mo5287a()) {
            return this.f3644g.mo4751a(i);
        }
        int i2 = this.f3642e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b = pVar.mo5232b(i);
        if (b != -1) {
            return this.f3644g.mo4751a(b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i);
        Log.w("GridLayoutManager", sb.toString());
        return 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4739a(C1274u uVar, C1234c cVar, C1257a aVar) {
        int i = this.f3639b;
        for (int i2 = 0; i2 < this.f3639b && cVar.mo4806a(uVar) && i > 0; i2++) {
            int i3 = cVar.f3677d;
            aVar.mo5195b(i3, Math.max(0, cVar.f3680g));
            i -= this.f3644g.mo4751a(i3);
            cVar.f3677d += cVar.f3678e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4737a(C1266p pVar, C1274u uVar, C1234c cVar, C1233b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        C1266p pVar2 = pVar;
        C1274u uVar2 = uVar;
        C1234c cVar2 = cVar;
        C1233b bVar2 = bVar;
        int i9 = this.f3659j.mo5545i();
        boolean z2 = i9 != 1073741824;
        int i10 = mo5186w() > 0 ? this.f3640c[this.f3639b] : 0;
        if (z2) {
            m4566N();
        }
        boolean z3 = cVar2.f3678e == 1;
        int i11 = this.f3639b;
        if (!z3) {
            i11 = m4574b(pVar2, uVar2, cVar2.f3677d) + m4576c(pVar2, uVar2, cVar2.f3677d);
        }
        int i12 = 0;
        int i13 = 0;
        while (i13 < this.f3639b && cVar2.mo4806a(uVar2) && i11 > 0) {
            int i14 = cVar2.f3677d;
            int c = m4576c(pVar2, uVar2, i14);
            if (c <= this.f3639b) {
                i11 -= c;
                if (i11 < 0) {
                    break;
                }
                View a = cVar2.mo4803a(pVar2);
                if (a == null) {
                    break;
                }
                i12 += c;
                this.f3641d[i13] = a;
                i13++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Item at position ");
                sb.append(i14);
                sb.append(" requires ");
                sb.append(c);
                sb.append(" spans but GridLayoutManager has only ");
                sb.append(this.f3639b);
                sb.append(" spans.");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (i13 == 0) {
            bVar2.f3671b = true;
            return;
        }
        float f = BitmapDescriptorFactory.HUE_RED;
        int i15 = i13;
        m4572a(pVar, uVar, i13, i12, z3);
        int i16 = 0;
        for (int i17 = 0; i17 < i15; i17++) {
            View view = this.f3641d[i17];
            if (cVar2.f3684k != null) {
                z = false;
                if (z3) {
                    mo5110a(view);
                } else {
                    mo5111a(view, 0);
                }
            } else if (z3) {
                mo5138b(view);
                z = false;
            } else {
                z = false;
                mo5139b(view, 0);
            }
            mo5140b(view, this.f3645h);
            m4571a(view, i9, z);
            int e = this.f3659j.mo5540e(view);
            if (e > i16) {
                i16 = e;
            }
            float f2 = (((float) this.f3659j.mo5542f(view)) * 1.0f) / ((float) ((C1230b) view.getLayoutParams()).f3647b);
            if (f2 > f) {
                f = f2;
            }
        }
        if (z2) {
            m4569a(f, i10);
            i16 = 0;
            for (int i18 = 0; i18 < i15; i18++) {
                View view2 = this.f3641d[i18];
                m4571a(view2, (int) Ints.MAX_POWER_OF_TWO, true);
                int e2 = this.f3659j.mo5540e(view2);
                if (e2 > i16) {
                    i16 = e2;
                }
            }
        }
        for (int i19 = 0; i19 < i15; i19++) {
            View view3 = this.f3641d[i19];
            if (this.f3659j.mo5540e(view3) != i16) {
                C1230b bVar3 = (C1230b) view3.getLayoutParams();
                Rect rect = bVar3.f3730d;
                int i20 = rect.top + rect.bottom + bVar3.topMargin + bVar3.bottomMargin;
                int i21 = rect.left + rect.right + bVar3.leftMargin + bVar3.rightMargin;
                int a2 = mo4725a(bVar3.f3646a, bVar3.f3647b);
                if (this.f3658i == 1) {
                    i8 = m4783a(a2, (int) Ints.MAX_POWER_OF_TWO, i21, bVar3.width, false);
                    i7 = MeasureSpec.makeMeasureSpec(i16 - i20, Ints.MAX_POWER_OF_TWO);
                } else {
                    int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i16 - i21, Ints.MAX_POWER_OF_TWO);
                    i7 = m4783a(a2, (int) Ints.MAX_POWER_OF_TWO, i20, bVar3.height, false);
                    i8 = makeMeasureSpec;
                }
                m4570a(view3, i8, i7, true);
            }
        }
        int i22 = 0;
        bVar2.f3670a = i16;
        if (this.f3658i == 1) {
            if (cVar2.f3679f == -1) {
                int i23 = cVar2.f3675b;
                i = i23;
                i2 = i23 - i16;
            } else {
                int i24 = cVar2.f3675b;
                i2 = i24;
                i = i16 + i24;
            }
            i4 = 0;
            i3 = 0;
        } else if (cVar2.f3679f == -1) {
            int i25 = cVar2.f3675b;
            i2 = 0;
            i = 0;
            int i26 = i25 - i16;
            i3 = i25;
            i4 = i26;
        } else {
            i4 = cVar2.f3675b;
            i3 = i16 + i4;
            i2 = 0;
            i = 0;
        }
        while (i22 < i15) {
            View view4 = this.f3641d[i22];
            C1230b bVar4 = (C1230b) view4.getLayoutParams();
            if (this.f3658i != 1) {
                i2 = mo5100C() + this.f3640c[bVar4.f3646a];
                i = this.f3659j.mo5542f(view4) + i2;
            } else if (mo4788h()) {
                int B = mo5099B() + this.f3640c[this.f3639b - bVar4.f3646a];
                i5 = B;
                i6 = B - this.f3659j.mo5542f(view4);
                int i27 = i2;
                int i28 = i;
                mo5113a(view4, i6, i27, i5, i28);
                if (!bVar4.mo5197d() || bVar4.mo5198e()) {
                    bVar2.f3672c = true;
                }
                bVar2.f3673d |= view4.hasFocusable();
                i22++;
                i4 = i6;
                i2 = i27;
                i3 = i5;
                i = i28;
            } else {
                i4 = mo5099B() + this.f3640c[bVar4.f3646a];
                i3 = this.f3659j.mo5542f(view4) + i4;
            }
            i6 = i4;
            i5 = i3;
            int i272 = i2;
            int i282 = i;
            mo5113a(view4, i6, i272, i5, i282);
            if (!bVar4.mo5197d()) {
            }
            bVar2.f3672c = true;
            bVar2.f3673d |= view4.hasFocusable();
            i22++;
            i4 = i6;
            i2 = i272;
            i3 = i5;
            i = i282;
        }
        Arrays.fill(this.f3641d, null);
    }

    /* renamed from: a */
    private void m4571a(View view, int i, boolean z) {
        int i2;
        int i3;
        C1230b bVar = (C1230b) view.getLayoutParams();
        Rect rect = bVar.f3730d;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a = mo4725a(bVar.f3646a, bVar.f3647b);
        if (this.f3658i == 1) {
            i2 = m4783a(a, i, i5, bVar.width, false);
            i3 = m4783a(this.f3659j.mo5541f(), mo5188y(), i4, bVar.height, true);
        } else {
            int a2 = m4783a(a, i, i4, bVar.height, false);
            int a3 = m4783a(this.f3659j.mo5541f(), mo5187x(), i5, bVar.width, true);
            i3 = a2;
            i2 = a3;
        }
        m4570a(view, i2, i3, z);
    }

    /* renamed from: a */
    private void m4569a(float f, int i) {
        m4577m(Math.max(Math.round(f * ((float) this.f3639b)), i));
    }

    /* renamed from: a */
    private void m4570a(View view, int i, int i2, boolean z) {
        boolean z2;
        C1259j jVar = (C1259j) view.getLayoutParams();
        if (z) {
            z2 = mo5127a(view, i, i2, jVar);
        } else {
            z2 = mo5145b(view, i, i2, jVar);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    private void m4572a(C1266p pVar, C1274u uVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = 0;
        if (z) {
            i5 = i;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View view = this.f3641d[i4];
            C1230b bVar = (C1230b) view.getLayoutParams();
            bVar.f3647b = m4576c(pVar, uVar, mo5152d(view));
            bVar.f3646a = i6;
            i6 += bVar.f3647b;
            i4 += i3;
        }
    }

    /* renamed from: a */
    public void mo4733a(int i) {
        if (i != this.f3639b) {
            this.f3638a = true;
            if (i >= 1) {
                this.f3639b = i;
                this.f3644g.mo4755a();
                mo5179p();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Span count should be at least 1. Provided ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d8, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f5, code lost:
        if (r13 == r10) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo4728a(android.view.View r26, int r27, androidx.recyclerview.widget.RecyclerView.C1266p r28, androidx.recyclerview.widget.RecyclerView.C1274u r29) {
        /*
            r25 = this;
            r0 = r25
            r1 = r28
            r2 = r29
            android.view.View r3 = r25.mo5157e(r26)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.C1230b) r5
            int r6 = r5.f3646a
            int r7 = r5.f3646a
            int r5 = r5.f3647b
            int r7 = r7 + r5
            android.view.View r5 = super.mo4728a(r26, r27, r28, r29)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r27
            int r5 = r0.mo4782f(r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.f3660k
            if (r5 == r10) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r25.mo5186w()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0047
        L_0x0040:
            int r5 = r25.mo5186w()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0047:
            int r13 = r0.f3658i
            if (r13 != r9) goto L_0x0053
            boolean r13 = r25.mo4788h()
            if (r13 == 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.m4568a(r1, r2, r5)
            r10 = r4
            r8 = -1
            r15 = 0
            r17 = 0
            r18 = -1
        L_0x005f:
            if (r5 == r11) goto L_0x0146
            int r9 = r0.m4568a(r1, r2, r5)
            android.view.View r1 = r0.mo5169i(r5)
            if (r1 != r3) goto L_0x006d
            goto L_0x0146
        L_0x006d:
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x0087
            if (r9 == r14) goto L_0x0087
            if (r4 == 0) goto L_0x0079
            goto L_0x0146
        L_0x0079:
            r21 = r3
            r23 = r8
            r24 = r10
            r22 = r11
            r8 = r17
            r11 = r18
            goto L_0x0132
        L_0x0087:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.C1230b) r9
            int r2 = r9.f3646a
            r21 = r3
            int r3 = r9.f3646a
            r22 = r11
            int r11 = r9.f3647b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a3
            if (r2 != r6) goto L_0x00a3
            if (r3 != r7) goto L_0x00a3
            return r1
        L_0x00a3:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00ab
            if (r4 == 0) goto L_0x00b3
        L_0x00ab:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00be
            if (r10 != 0) goto L_0x00be
        L_0x00b3:
            r23 = r8
            r24 = r10
            r8 = r17
        L_0x00b9:
            r11 = r18
        L_0x00bb:
            r19 = 1
            goto L_0x0102
        L_0x00be:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00db
            if (r11 <= r15) goto L_0x00d1
            goto L_0x00b3
        L_0x00d1:
            if (r11 != r15) goto L_0x00f8
            if (r2 <= r8) goto L_0x00d7
            r11 = 1
            goto L_0x00d8
        L_0x00d7:
            r11 = 0
        L_0x00d8:
            if (r13 != r11) goto L_0x00f8
            goto L_0x00b3
        L_0x00db:
            if (r4 != 0) goto L_0x00f8
            r23 = r8
            r24 = r10
            r8 = 1
            r10 = 0
            boolean r16 = r0.mo5129a(r1, r10, r8)
            if (r16 == 0) goto L_0x00fc
            r8 = r17
            if (r11 <= r8) goto L_0x00ee
            goto L_0x00b9
        L_0x00ee:
            if (r11 != r8) goto L_0x00fe
            r11 = r18
            if (r2 <= r11) goto L_0x00f5
            r10 = 1
        L_0x00f5:
            if (r13 != r10) goto L_0x0100
            goto L_0x00bb
        L_0x00f8:
            r23 = r8
            r24 = r10
        L_0x00fc:
            r8 = r17
        L_0x00fe:
            r11 = r18
        L_0x0100:
            r19 = 0
        L_0x0102:
            if (r19 == 0) goto L_0x0132
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x011f
            int r4 = r9.f3646a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r15 = r3
            r17 = r8
            r18 = r11
            r10 = r24
            r8 = r4
            r4 = r1
            goto L_0x013a
        L_0x011f:
            int r8 = r9.f3646a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r17 = r3
            r18 = r8
            r8 = r23
            goto L_0x013a
        L_0x0132:
            r17 = r8
            r18 = r11
            r8 = r23
            r10 = r24
        L_0x013a:
            int r5 = r5 + r12
            r3 = r21
            r11 = r22
            r1 = r28
            r2 = r29
            r9 = 1
            goto L_0x005f
        L_0x0146:
            r24 = r10
            if (r4 == 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r4 = r24
        L_0x014d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.mo4728a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u):android.view.View");
    }

    /* renamed from: b */
    public boolean mo4749b() {
        return this.f3663n == null && !this.f3638a;
    }
}
