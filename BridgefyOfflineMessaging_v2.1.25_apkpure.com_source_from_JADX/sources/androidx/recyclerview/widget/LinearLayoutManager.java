package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.p073b.C1024a;
import androidx.recyclerview.widget.RecyclerView.C1254i;
import androidx.recyclerview.widget.RecyclerView.C1254i.C1257a;
import androidx.recyclerview.widget.RecyclerView.C1254i.C1258b;
import androidx.recyclerview.widget.RecyclerView.C1259j;
import androidx.recyclerview.widget.RecyclerView.C1266p;
import androidx.recyclerview.widget.RecyclerView.C1271t;
import androidx.recyclerview.widget.RecyclerView.C1271t.C1273b;
import androidx.recyclerview.widget.RecyclerView.C1274u;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

public class LinearLayoutManager extends C1254i implements C1273b {

    /* renamed from: a */
    private C1234c f3650a;

    /* renamed from: b */
    private boolean f3651b;

    /* renamed from: c */
    private boolean f3652c;

    /* renamed from: d */
    private boolean f3653d;

    /* renamed from: e */
    private boolean f3654e;

    /* renamed from: f */
    private boolean f3655f;

    /* renamed from: g */
    private final C1233b f3656g;

    /* renamed from: h */
    private int f3657h;

    /* renamed from: i */
    int f3658i;

    /* renamed from: j */
    C1317i f3659j;

    /* renamed from: k */
    boolean f3660k;

    /* renamed from: l */
    int f3661l;

    /* renamed from: m */
    int f3662m;

    /* renamed from: n */
    C1235d f3663n;

    /* renamed from: o */
    final C1232a f3664o;

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$a */
    static class C1232a {

        /* renamed from: a */
        C1317i f3665a;

        /* renamed from: b */
        int f3666b;

        /* renamed from: c */
        int f3667c;

        /* renamed from: d */
        boolean f3668d;

        /* renamed from: e */
        boolean f3669e;

        C1232a() {
            mo4796a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4796a() {
            this.f3666b = -1;
            this.f3667c = C1024a.INVALID_ID;
            this.f3668d = false;
            this.f3669e = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4799b() {
            int i;
            if (this.f3668d) {
                i = this.f3665a.mo5537d();
            } else {
                i = this.f3665a.mo5535c();
            }
            this.f3667c = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnchorInfo{mPosition=");
            sb.append(this.f3666b);
            sb.append(", mCoordinate=");
            sb.append(this.f3667c);
            sb.append(", mLayoutFromEnd=");
            sb.append(this.f3668d);
            sb.append(", mValid=");
            sb.append(this.f3669e);
            sb.append('}');
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4798a(View view, C1274u uVar) {
            C1259j jVar = (C1259j) view.getLayoutParams();
            return !jVar.mo5197d() && jVar.mo5199f() >= 0 && jVar.mo5199f() < uVar.mo5291e();
        }

        /* renamed from: a */
        public void mo4797a(View view, int i) {
            int b = this.f3665a.mo5533b();
            if (b >= 0) {
                mo4800b(view, i);
                return;
            }
            this.f3666b = i;
            if (this.f3668d) {
                int d = (this.f3665a.mo5537d() - b) - this.f3665a.mo5534b(view);
                this.f3667c = this.f3665a.mo5537d() - d;
                if (d > 0) {
                    int e = this.f3667c - this.f3665a.mo5540e(view);
                    int c = this.f3665a.mo5535c();
                    int min = e - (c + Math.min(this.f3665a.mo5530a(view) - c, 0));
                    if (min < 0) {
                        this.f3667c += Math.min(d, -min);
                    }
                }
            } else {
                int a = this.f3665a.mo5530a(view);
                int c2 = a - this.f3665a.mo5535c();
                this.f3667c = a;
                if (c2 > 0) {
                    int d2 = (this.f3665a.mo5537d() - Math.min(0, (this.f3665a.mo5537d() - b) - this.f3665a.mo5534b(view))) - (a + this.f3665a.mo5540e(view));
                    if (d2 < 0) {
                        this.f3667c -= Math.min(c2, -d2);
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo4800b(View view, int i) {
            if (this.f3668d) {
                this.f3667c = this.f3665a.mo5534b(view) + this.f3665a.mo5533b();
            } else {
                this.f3667c = this.f3665a.mo5530a(view);
            }
            this.f3666b = i;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$b */
    protected static class C1233b {

        /* renamed from: a */
        public int f3670a;

        /* renamed from: b */
        public boolean f3671b;

        /* renamed from: c */
        public boolean f3672c;

        /* renamed from: d */
        public boolean f3673d;

        protected C1233b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4802a() {
            this.f3670a = 0;
            this.f3671b = false;
            this.f3672c = false;
            this.f3673d = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$c */
    static class C1234c {

        /* renamed from: a */
        boolean f3674a = true;

        /* renamed from: b */
        int f3675b;

        /* renamed from: c */
        int f3676c;

        /* renamed from: d */
        int f3677d;

        /* renamed from: e */
        int f3678e;

        /* renamed from: f */
        int f3679f;

        /* renamed from: g */
        int f3680g;

        /* renamed from: h */
        int f3681h = 0;

        /* renamed from: i */
        boolean f3682i = false;

        /* renamed from: j */
        int f3683j;

        /* renamed from: k */
        List<C1277x> f3684k = null;

        /* renamed from: l */
        boolean f3685l;

        C1234c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4806a(C1274u uVar) {
            return this.f3677d >= 0 && this.f3677d < uVar.mo5291e();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public View mo4803a(C1266p pVar) {
            if (this.f3684k != null) {
                return m4700b();
            }
            View c = pVar.mo5238c(this.f3677d);
            this.f3677d += this.f3678e;
            return c;
        }

        /* renamed from: b */
        private View m4700b() {
            int size = this.f3684k.size();
            for (int i = 0; i < size; i++) {
                View view = ((C1277x) this.f3684k.get(i)).itemView;
                C1259j jVar = (C1259j) view.getLayoutParams();
                if (!jVar.mo5197d() && this.f3677d == jVar.mo5199f()) {
                    mo4805a(view);
                    return view;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void mo4804a() {
            mo4805a((View) null);
        }

        /* renamed from: a */
        public void mo4805a(View view) {
            View b = mo4807b(view);
            if (b == null) {
                this.f3677d = -1;
            } else {
                this.f3677d = ((C1259j) b.getLayoutParams()).mo5199f();
            }
        }

        /* renamed from: b */
        public View mo4807b(View view) {
            int size = this.f3684k.size();
            View view2 = null;
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((C1277x) this.f3684k.get(i2)).itemView;
                C1259j jVar = (C1259j) view3.getLayoutParams();
                if (view3 != view && !jVar.mo5197d()) {
                    int f = (jVar.mo5199f() - this.f3677d) * this.f3678e;
                    if (f >= 0 && f < i) {
                        if (f == 0) {
                            return view3;
                        }
                        view2 = view3;
                        i = f;
                    }
                }
            }
            return view2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$d */
    public static class C1235d implements Parcelable {
        public static final Creator<C1235d> CREATOR = new Creator<C1235d>() {
            /* renamed from: a */
            public C1235d createFromParcel(Parcel parcel) {
                return new C1235d(parcel);
            }

            /* renamed from: a */
            public C1235d[] newArray(int i) {
                return new C1235d[i];
            }
        };

        /* renamed from: a */
        int f3686a;

        /* renamed from: b */
        int f3687b;

        /* renamed from: c */
        boolean f3688c;

        public int describeContents() {
            return 0;
        }

        public C1235d() {
        }

        C1235d(Parcel parcel) {
            this.f3686a = parcel.readInt();
            this.f3687b = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f3688c = z;
        }

        public C1235d(C1235d dVar) {
            this.f3686a = dVar.f3686a;
            this.f3687b = dVar.f3687b;
            this.f3688c = dVar.f3688c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4808a() {
            return this.f3686a >= 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4809b() {
            this.f3686a = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3686a);
            parcel.writeInt(this.f3687b);
            parcel.writeInt(this.f3688c ? 1 : 0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4736a(C1266p pVar, C1274u uVar, C1232a aVar, int i) {
    }

    /* renamed from: c */
    public boolean mo4775c() {
        return true;
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f3658i = 1;
        this.f3652c = false;
        this.f3660k = false;
        this.f3653d = false;
        this.f3654e = true;
        this.f3661l = -1;
        this.f3662m = C1024a.INVALID_ID;
        this.f3663n = null;
        this.f3664o = new C1232a();
        this.f3656g = new C1233b();
        this.f3657h = 2;
        mo4770b(i);
        mo4771b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f3658i = 1;
        this.f3652c = false;
        this.f3660k = false;
        this.f3653d = false;
        this.f3654e = true;
        this.f3661l = -1;
        this.f3662m = C1024a.INVALID_ID;
        this.f3663n = null;
        this.f3664o = new C1232a();
        this.f3656g = new C1233b();
        this.f3657h = 2;
        C1258b a = m4784a(context, attributeSet, i, i2);
        mo4770b(a.f3725a);
        mo4771b(a.f3727c);
        mo4744a(a.f3728d);
    }

    /* renamed from: a */
    public C1259j mo4730a() {
        return new C1259j(-2, -2);
    }

    /* renamed from: a */
    public void mo4765a(RecyclerView recyclerView, C1266p pVar) {
        super.mo4765a(recyclerView, pVar);
        if (this.f3655f) {
            mo5149c(pVar);
            pVar.mo5222a();
        }
    }

    /* renamed from: a */
    public void mo4764a(AccessibilityEvent accessibilityEvent) {
        super.mo4764a(accessibilityEvent);
        if (mo5186w() > 0) {
            accessibilityEvent.setFromIndex(mo4793m());
            accessibilityEvent.setToIndex(mo4795o());
        }
    }

    /* renamed from: d */
    public Parcelable mo4778d() {
        if (this.f3663n != null) {
            return new C1235d(this.f3663n);
        }
        C1235d dVar = new C1235d();
        if (mo5186w() > 0) {
            mo4789i();
            boolean z = this.f3651b ^ this.f3660k;
            dVar.f3688c = z;
            if (z) {
                View N = m4616N();
                dVar.f3687b = this.f3659j.mo5537d() - this.f3659j.mo5534b(N);
                dVar.f3686a = mo5152d(N);
            } else {
                View M = m4615M();
                dVar.f3686a = mo5152d(M);
                dVar.f3687b = this.f3659j.mo5530a(M) - this.f3659j.mo5535c();
            }
        } else {
            dVar.mo4809b();
        }
        return dVar;
    }

    /* renamed from: a */
    public void mo4763a(Parcelable parcelable) {
        if (parcelable instanceof C1235d) {
            this.f3663n = (C1235d) parcelable;
            mo5179p();
        }
    }

    /* renamed from: e */
    public boolean mo4781e() {
        return this.f3658i == 0;
    }

    /* renamed from: f */
    public boolean mo4784f() {
        return this.f3658i == 1;
    }

    /* renamed from: a */
    public void mo4744a(boolean z) {
        mo4767a((String) null);
        if (this.f3653d != z) {
            this.f3653d = z;
            mo5179p();
        }
    }

    /* renamed from: g */
    public int mo4785g() {
        return this.f3658i;
    }

    /* renamed from: b */
    public void mo4770b(int i) {
        if (i == 0 || i == 1) {
            mo4767a((String) null);
            if (i != this.f3658i || this.f3659j == null) {
                this.f3659j = C1317i.m5359a(this, i);
                this.f3664o.f3665a = this.f3659j;
                this.f3658i = i;
                mo5179p();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invalid orientation:");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: L */
    private void m4614L() {
        if (this.f3658i == 1 || !mo4788h()) {
            this.f3660k = this.f3652c;
        } else {
            this.f3660k = !this.f3652c;
        }
    }

    /* renamed from: b */
    public void mo4771b(boolean z) {
        mo4767a((String) null);
        if (z != this.f3652c) {
            this.f3652c = z;
            mo5179p();
        }
    }

    /* renamed from: c */
    public View mo4774c(int i) {
        int w = mo5186w();
        if (w == 0) {
            return null;
        }
        int d = i - mo5152d(mo5169i(0));
        if (d >= 0 && d < w) {
            View i2 = mo5169i(d);
            if (mo5152d(i2) == i) {
                return i2;
            }
        }
        return super.mo4774c(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo4768b(C1274u uVar) {
        if (uVar.mo5290d()) {
            return this.f3659j.mo5541f();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo4766a(RecyclerView recyclerView, C1274u uVar, int i) {
        C1314g gVar = new C1314g(recyclerView.getContext());
        gVar.mo5272c(i);
        mo5125a((C1271t) gVar);
    }

    /* renamed from: d */
    public PointF mo4777d(int i) {
        if (mo5186w() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < mo5152d(mo5169i(0))) {
            z = true;
        }
        if (z != this.f3660k) {
            i2 = -1;
        }
        if (this.f3658i == 0) {
            return new PointF((float) i2, BitmapDescriptorFactory.HUE_RED);
        }
        return new PointF(BitmapDescriptorFactory.HUE_RED, (float) i2);
    }

    /* renamed from: c */
    public void mo4750c(C1266p pVar, C1274u uVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = -1;
        if (!(this.f3663n == null && this.f3661l == -1) && uVar.mo5291e() == 0) {
            mo5149c(pVar);
            return;
        }
        if (this.f3663n != null && this.f3663n.mo4808a()) {
            this.f3661l = this.f3663n.f3686a;
        }
        mo4789i();
        this.f3650a.f3674a = false;
        m4614L();
        View F = mo5103F();
        if (!this.f3664o.f3669e || this.f3661l != -1 || this.f3663n != null) {
            this.f3664o.mo4796a();
            this.f3664o.f3668d = this.f3660k ^ this.f3653d;
            m4625a(pVar, uVar, this.f3664o);
            this.f3664o.f3669e = true;
        } else if (F != null && (this.f3659j.mo5530a(F) >= this.f3659j.mo5537d() || this.f3659j.mo5534b(F) <= this.f3659j.mo5535c())) {
            this.f3664o.mo4797a(F, mo5152d(F));
        }
        int b = mo4768b(uVar);
        if (this.f3650a.f3683j >= 0) {
            i = b;
            b = 0;
        } else {
            i = 0;
        }
        int c = b + this.f3659j.mo5535c();
        int g = i + this.f3659j.mo5543g();
        if (!(!uVar.mo5287a() || this.f3661l == -1 || this.f3662m == Integer.MIN_VALUE)) {
            View c2 = mo4774c(this.f3661l);
            if (c2 != null) {
                if (this.f3660k) {
                    i4 = (this.f3659j.mo5537d() - this.f3659j.mo5534b(c2)) - this.f3662m;
                } else {
                    i4 = this.f3662m - (this.f3659j.mo5530a(c2) - this.f3659j.mo5535c());
                }
                if (i4 > 0) {
                    c += i4;
                } else {
                    g -= i4;
                }
            }
        }
        if (!this.f3664o.f3668d ? !this.f3660k : this.f3660k) {
            i5 = 1;
        }
        mo4736a(pVar, uVar, this.f3664o, i5);
        mo5121a(pVar);
        this.f3650a.f3685l = mo4791k();
        this.f3650a.f3682i = uVar.mo5287a();
        if (this.f3664o.f3668d) {
            m4629b(this.f3664o);
            this.f3650a.f3681h = c;
            mo4759a(pVar, this.f3650a, uVar, false);
            i3 = this.f3650a.f3675b;
            int i6 = this.f3650a.f3677d;
            if (this.f3650a.f3676c > 0) {
                g += this.f3650a.f3676c;
            }
            m4621a(this.f3664o);
            this.f3650a.f3681h = g;
            this.f3650a.f3677d += this.f3650a.f3678e;
            mo4759a(pVar, this.f3650a, uVar, false);
            i2 = this.f3650a.f3675b;
            if (this.f3650a.f3676c > 0) {
                int i7 = this.f3650a.f3676c;
                m4635g(i6, i3);
                this.f3650a.f3681h = i7;
                mo4759a(pVar, this.f3650a, uVar, false);
                i3 = this.f3650a.f3675b;
            }
        } else {
            m4621a(this.f3664o);
            this.f3650a.f3681h = g;
            mo4759a(pVar, this.f3650a, uVar, false);
            i2 = this.f3650a.f3675b;
            int i8 = this.f3650a.f3677d;
            if (this.f3650a.f3676c > 0) {
                c += this.f3650a.f3676c;
            }
            m4629b(this.f3664o);
            this.f3650a.f3681h = c;
            this.f3650a.f3677d += this.f3650a.f3678e;
            mo4759a(pVar, this.f3650a, uVar, false);
            i3 = this.f3650a.f3675b;
            if (this.f3650a.f3676c > 0) {
                int i9 = this.f3650a.f3676c;
                mo4725a(i8, i2);
                this.f3650a.f3681h = i9;
                mo4759a(pVar, this.f3650a, uVar, false);
                i2 = this.f3650a.f3675b;
            }
        }
        if (mo5186w() > 0) {
            if (this.f3660k ^ this.f3653d) {
                int a = m4617a(i2, pVar, uVar, true);
                int i10 = i3 + a;
                int i11 = i2 + a;
                int b2 = m4627b(i10, pVar, uVar, false);
                i3 = i10 + b2;
                i2 = i11 + b2;
            } else {
                int b3 = m4627b(i3, pVar, uVar, true);
                int i12 = i3 + b3;
                int i13 = i2 + b3;
                int a2 = m4617a(i13, pVar, uVar, false);
                i3 = i12 + a2;
                i2 = i13 + a2;
            }
        }
        m4631b(pVar, uVar, i3, i2);
        if (!uVar.mo5287a()) {
            this.f3659j.mo5531a();
        } else {
            this.f3664o.mo4796a();
        }
        this.f3651b = this.f3653d;
    }

    /* renamed from: a */
    public void mo4738a(C1274u uVar) {
        super.mo4738a(uVar);
        this.f3663n = null;
        this.f3661l = -1;
        this.f3662m = C1024a.INVALID_ID;
        this.f3664o.mo4796a();
    }

    /* renamed from: b */
    private void m4631b(C1266p pVar, C1274u uVar, int i, int i2) {
        C1266p pVar2 = pVar;
        C1274u uVar2 = uVar;
        if (uVar.mo5288b() && mo5186w() != 0 && !uVar.mo5287a() && mo4749b()) {
            List<C1277x> c = pVar.mo5239c();
            int size = c.size();
            int d = mo5152d(mo5169i(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                C1277x xVar = (C1277x) c.get(i5);
                if (!xVar.isRemoved()) {
                    char c2 = 1;
                    if ((xVar.getLayoutPosition() < d) != this.f3660k) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i3 += this.f3659j.mo5540e(xVar.itemView);
                    } else {
                        i4 += this.f3659j.mo5540e(xVar.itemView);
                    }
                }
            }
            this.f3650a.f3684k = c;
            if (i3 > 0) {
                m4635g(mo5152d(m4615M()), i);
                this.f3650a.f3681h = i3;
                this.f3650a.f3676c = 0;
                this.f3650a.mo4804a();
                mo4759a(pVar2, this.f3650a, uVar2, false);
            }
            if (i4 > 0) {
                mo4725a(mo5152d(m4616N()), i2);
                this.f3650a.f3681h = i4;
                this.f3650a.f3676c = 0;
                this.f3650a.mo4804a();
                mo4759a(pVar2, this.f3650a, uVar2, false);
            }
            this.f3650a.f3684k = null;
        }
    }

    /* renamed from: a */
    private void m4625a(C1266p pVar, C1274u uVar, C1232a aVar) {
        if (!m4626a(uVar, aVar) && !m4632b(pVar, uVar, aVar)) {
            aVar.mo4799b();
            aVar.f3666b = this.f3653d ? uVar.mo5291e() - 1 : 0;
        }
    }

    /* renamed from: b */
    private boolean m4632b(C1266p pVar, C1274u uVar, C1232a aVar) {
        View view;
        int i;
        boolean z = false;
        if (mo5186w() == 0) {
            return false;
        }
        View F = mo5103F();
        if (F != null && aVar.mo4798a(F, uVar)) {
            aVar.mo4797a(F, mo5152d(F));
            return true;
        } else if (this.f3651b != this.f3653d) {
            return false;
        } else {
            if (aVar.f3668d) {
                view = m4633f(pVar, uVar);
            } else {
                view = m4634g(pVar, uVar);
            }
            if (view == null) {
                return false;
            }
            aVar.mo4800b(view, mo5152d(view));
            if (!uVar.mo5287a() && mo4749b()) {
                if (this.f3659j.mo5530a(view) >= this.f3659j.mo5537d() || this.f3659j.mo5534b(view) < this.f3659j.mo5535c()) {
                    z = true;
                }
                if (z) {
                    if (aVar.f3668d) {
                        i = this.f3659j.mo5537d();
                    } else {
                        i = this.f3659j.mo5535c();
                    }
                    aVar.f3667c = i;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private boolean m4626a(C1274u uVar, C1232a aVar) {
        int i;
        boolean z = false;
        if (uVar.mo5287a() || this.f3661l == -1) {
            return false;
        }
        if (this.f3661l < 0 || this.f3661l >= uVar.mo5291e()) {
            this.f3661l = -1;
            this.f3662m = C1024a.INVALID_ID;
            return false;
        }
        aVar.f3666b = this.f3661l;
        if (this.f3663n != null && this.f3663n.mo4808a()) {
            aVar.f3668d = this.f3663n.f3688c;
            if (aVar.f3668d) {
                aVar.f3667c = this.f3659j.mo5537d() - this.f3663n.f3687b;
            } else {
                aVar.f3667c = this.f3659j.mo5535c() + this.f3663n.f3687b;
            }
            return true;
        } else if (this.f3662m == Integer.MIN_VALUE) {
            View c = mo4774c(this.f3661l);
            if (c == null) {
                if (mo5186w() > 0) {
                    if ((this.f3661l < mo5152d(mo5169i(0))) == this.f3660k) {
                        z = true;
                    }
                    aVar.f3668d = z;
                }
                aVar.mo4799b();
            } else if (this.f3659j.mo5540e(c) > this.f3659j.mo5541f()) {
                aVar.mo4799b();
                return true;
            } else if (this.f3659j.mo5530a(c) - this.f3659j.mo5535c() < 0) {
                aVar.f3667c = this.f3659j.mo5535c();
                aVar.f3668d = false;
                return true;
            } else if (this.f3659j.mo5537d() - this.f3659j.mo5534b(c) < 0) {
                aVar.f3667c = this.f3659j.mo5537d();
                aVar.f3668d = true;
                return true;
            } else {
                if (aVar.f3668d) {
                    i = this.f3659j.mo5534b(c) + this.f3659j.mo5533b();
                } else {
                    i = this.f3659j.mo5530a(c);
                }
                aVar.f3667c = i;
            }
            return true;
        } else {
            aVar.f3668d = this.f3660k;
            if (this.f3660k) {
                aVar.f3667c = this.f3659j.mo5537d() - this.f3662m;
            } else {
                aVar.f3667c = this.f3659j.mo5535c() + this.f3662m;
            }
            return true;
        }
    }

    /* renamed from: a */
    private int m4617a(int i, C1266p pVar, C1274u uVar, boolean z) {
        int d = this.f3659j.mo5537d() - i;
        if (d <= 0) {
            return 0;
        }
        int i2 = -mo4772c(-d, pVar, uVar);
        int i3 = i + i2;
        if (z) {
            int d2 = this.f3659j.mo5537d() - i3;
            if (d2 > 0) {
                this.f3659j.mo5532a(d2);
                return d2 + i2;
            }
        }
        return i2;
    }

    /* renamed from: b */
    private int m4627b(int i, C1266p pVar, C1274u uVar, boolean z) {
        int c = i - this.f3659j.mo5535c();
        if (c <= 0) {
            return 0;
        }
        int i2 = -mo4772c(c, pVar, uVar);
        int i3 = i + i2;
        if (z) {
            int c2 = i3 - this.f3659j.mo5535c();
            if (c2 > 0) {
                this.f3659j.mo5532a(-c2);
                return i2 - c2;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private void m4621a(C1232a aVar) {
        mo4725a(aVar.f3666b, aVar.f3667c);
    }

    /* renamed from: a */
    private void mo4725a(int i, int i2) {
        this.f3650a.f3676c = this.f3659j.mo5537d() - i2;
        this.f3650a.f3678e = this.f3660k ? -1 : 1;
        this.f3650a.f3677d = i;
        this.f3650a.f3679f = 1;
        this.f3650a.f3675b = i2;
        this.f3650a.f3680g = C1024a.INVALID_ID;
    }

    /* renamed from: b */
    private void m4629b(C1232a aVar) {
        m4635g(aVar.f3666b, aVar.f3667c);
    }

    /* renamed from: g */
    private void m4635g(int i, int i2) {
        this.f3650a.f3676c = i2 - this.f3659j.mo5535c();
        this.f3650a.f3677d = i;
        this.f3650a.f3678e = this.f3660k ? 1 : -1;
        this.f3650a.f3679f = -1;
        this.f3650a.f3675b = i2;
        this.f3650a.f3680g = C1024a.INVALID_ID;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo4788h() {
        return mo5184u() == 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo4789i() {
        if (this.f3650a == null) {
            this.f3650a = mo4790j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public C1234c mo4790j() {
        return new C1234c();
    }

    /* renamed from: e */
    public void mo4780e(int i) {
        this.f3661l = i;
        this.f3662m = C1024a.INVALID_ID;
        if (this.f3663n != null) {
            this.f3663n.mo4809b();
        }
        mo5179p();
    }

    /* renamed from: a */
    public int mo4726a(int i, C1266p pVar, C1274u uVar) {
        if (this.f3658i == 1) {
            return 0;
        }
        return mo4772c(i, pVar, uVar);
    }

    /* renamed from: b */
    public int mo4746b(int i, C1266p pVar, C1274u uVar) {
        if (this.f3658i == 0) {
            return 0;
        }
        return mo4772c(i, pVar, uVar);
    }

    /* renamed from: c */
    public int mo4773c(C1274u uVar) {
        return m4637i(uVar);
    }

    /* renamed from: d */
    public int mo4776d(C1274u uVar) {
        return m4637i(uVar);
    }

    /* renamed from: e */
    public int mo4779e(C1274u uVar) {
        return m4639j(uVar);
    }

    /* renamed from: f */
    public int mo4783f(C1274u uVar) {
        return m4639j(uVar);
    }

    /* renamed from: g */
    public int mo4786g(C1274u uVar) {
        return m4641k(uVar);
    }

    /* renamed from: h */
    public int mo4787h(C1274u uVar) {
        return m4641k(uVar);
    }

    /* renamed from: i */
    private int m4637i(C1274u uVar) {
        if (mo5186w() == 0) {
            return 0;
        }
        mo4789i();
        C1317i iVar = this.f3659j;
        View a = m4618a(!this.f3654e, true);
        return C1322k.m5406a(uVar, iVar, a, m4628b(!this.f3654e, true), this, this.f3654e, this.f3660k);
    }

    /* renamed from: j */
    private int m4639j(C1274u uVar) {
        if (mo5186w() == 0) {
            return 0;
        }
        mo4789i();
        C1317i iVar = this.f3659j;
        View a = m4618a(!this.f3654e, true);
        return C1322k.m5405a(uVar, iVar, a, m4628b(!this.f3654e, true), this, this.f3654e);
    }

    /* renamed from: k */
    private int m4641k(C1274u uVar) {
        if (mo5186w() == 0) {
            return 0;
        }
        mo4789i();
        C1317i iVar = this.f3659j;
        View a = m4618a(!this.f3654e, true);
        return C1322k.m5407b(uVar, iVar, a, m4628b(!this.f3654e, true), this, this.f3654e);
    }

    /* renamed from: a */
    private void m4620a(int i, int i2, boolean z, C1274u uVar) {
        int i3;
        this.f3650a.f3685l = mo4791k();
        this.f3650a.f3681h = mo4768b(uVar);
        this.f3650a.f3679f = i;
        int i4 = -1;
        if (i == 1) {
            this.f3650a.f3681h += this.f3659j.mo5543g();
            View N = m4616N();
            C1234c cVar = this.f3650a;
            if (!this.f3660k) {
                i4 = 1;
            }
            cVar.f3678e = i4;
            this.f3650a.f3677d = mo5152d(N) + this.f3650a.f3678e;
            this.f3650a.f3675b = this.f3659j.mo5534b(N);
            i3 = this.f3659j.mo5534b(N) - this.f3659j.mo5537d();
        } else {
            View M = m4615M();
            this.f3650a.f3681h += this.f3659j.mo5535c();
            C1234c cVar2 = this.f3650a;
            if (this.f3660k) {
                i4 = 1;
            }
            cVar2.f3678e = i4;
            this.f3650a.f3677d = mo5152d(M) + this.f3650a.f3678e;
            this.f3650a.f3675b = this.f3659j.mo5530a(M);
            i3 = (-this.f3659j.mo5530a(M)) + this.f3659j.mo5535c();
        }
        this.f3650a.f3676c = i2;
        if (z) {
            this.f3650a.f3676c -= i3;
        }
        this.f3650a.f3680g = i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public boolean mo4791k() {
        return this.f3659j.mo5544h() == 0 && this.f3659j.mo5539e() == 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4739a(C1274u uVar, C1234c cVar, C1257a aVar) {
        int i = cVar.f3677d;
        if (i >= 0 && i < uVar.mo5291e()) {
            aVar.mo5195b(i, Math.max(0, cVar.f3680g));
        }
    }

    /* renamed from: a */
    public void mo4762a(int i, C1257a aVar) {
        int i2;
        boolean z;
        int i3 = -1;
        if (this.f3663n == null || !this.f3663n.mo4808a()) {
            m4614L();
            z = this.f3660k;
            i2 = this.f3661l == -1 ? z ? i - 1 : 0 : this.f3661l;
        } else {
            z = this.f3663n.f3688c;
            i2 = this.f3663n.f3686a;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.f3657h && i2 >= 0 && i2 < i; i4++) {
            aVar.mo5195b(i2, 0);
            i2 += i3;
        }
    }

    /* renamed from: a */
    public void mo4761a(int i, int i2, C1274u uVar, C1257a aVar) {
        if (this.f3658i != 0) {
            i = i2;
        }
        if (mo5186w() != 0 && i != 0) {
            mo4789i();
            m4620a(i > 0 ? 1 : -1, Math.abs(i), true, uVar);
            mo4739a(uVar, this.f3650a, aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo4772c(int i, C1266p pVar, C1274u uVar) {
        if (mo5186w() == 0 || i == 0) {
            return 0;
        }
        this.f3650a.f3674a = true;
        mo4789i();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m4620a(i2, abs, true, uVar);
        int a = this.f3650a.f3680g + mo4759a(pVar, this.f3650a, uVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f3659j.mo5532a(-i);
        this.f3650a.f3683j = i;
        return i;
    }

    /* renamed from: a */
    public void mo4767a(String str) {
        if (this.f3663n == null) {
            super.mo4767a(str);
        }
    }

    /* renamed from: a */
    private void m4623a(C1266p pVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    mo5109a(i3, pVar);
                }
            } else {
                while (i > i2) {
                    mo5109a(i, pVar);
                    i--;
                }
            }
        }
    }

    /* renamed from: a */
    private void m4622a(C1266p pVar, int i) {
        if (i >= 0) {
            int w = mo5186w();
            if (this.f3660k) {
                int i2 = w - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    View i4 = mo5169i(i3);
                    if (this.f3659j.mo5534b(i4) > i || this.f3659j.mo5536c(i4) > i) {
                        m4623a(pVar, i2, i3);
                        return;
                    }
                }
            } else {
                for (int i5 = 0; i5 < w; i5++) {
                    View i6 = mo5169i(i5);
                    if (this.f3659j.mo5534b(i6) > i || this.f3659j.mo5536c(i6) > i) {
                        m4623a(pVar, 0, i5);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m4630b(C1266p pVar, int i) {
        int w = mo5186w();
        if (i >= 0) {
            int e = this.f3659j.mo5539e() - i;
            if (this.f3660k) {
                for (int i2 = 0; i2 < w; i2++) {
                    View i3 = mo5169i(i2);
                    if (this.f3659j.mo5530a(i3) < e || this.f3659j.mo5538d(i3) < e) {
                        m4623a(pVar, 0, i2);
                        return;
                    }
                }
            } else {
                int i4 = w - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View i6 = mo5169i(i5);
                    if (this.f3659j.mo5530a(i6) < e || this.f3659j.mo5538d(i6) < e) {
                        m4623a(pVar, i4, i5);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m4624a(C1266p pVar, C1234c cVar) {
        if (cVar.f3674a && !cVar.f3685l) {
            if (cVar.f3679f == -1) {
                m4630b(pVar, cVar.f3680g);
            } else {
                m4622a(pVar, cVar.f3680g);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo4759a(C1266p pVar, C1234c cVar, C1274u uVar, boolean z) {
        int i = cVar.f3676c;
        if (cVar.f3680g != Integer.MIN_VALUE) {
            if (cVar.f3676c < 0) {
                cVar.f3680g += cVar.f3676c;
            }
            m4624a(pVar, cVar);
        }
        int i2 = cVar.f3676c + cVar.f3681h;
        C1233b bVar = this.f3656g;
        while (true) {
            if ((!cVar.f3685l && i2 <= 0) || !cVar.mo4806a(uVar)) {
                break;
            }
            bVar.mo4802a();
            mo4737a(pVar, uVar, cVar, bVar);
            if (!bVar.f3671b) {
                cVar.f3675b += bVar.f3670a * cVar.f3679f;
                if (!bVar.f3672c || this.f3650a.f3684k != null || !uVar.mo5287a()) {
                    cVar.f3676c -= bVar.f3670a;
                    i2 -= bVar.f3670a;
                }
                if (cVar.f3680g != Integer.MIN_VALUE) {
                    cVar.f3680g += bVar.f3670a;
                    if (cVar.f3676c < 0) {
                        cVar.f3680g += cVar.f3676c;
                    }
                    m4624a(pVar, cVar);
                }
                if (z && bVar.f3673d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f3676c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4737a(C1266p pVar, C1274u uVar, C1234c cVar, C1233b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a = cVar.mo4803a(pVar);
        if (a == null) {
            bVar.f3671b = true;
            return;
        }
        C1259j jVar = (C1259j) a.getLayoutParams();
        if (cVar.f3684k == null) {
            if (this.f3660k == (cVar.f3679f == -1)) {
                mo5138b(a);
            } else {
                mo5139b(a, 0);
            }
        } else {
            if (this.f3660k == (cVar.f3679f == -1)) {
                mo5110a(a);
            } else {
                mo5111a(a, 0);
            }
        }
        mo5112a(a, 0, 0);
        bVar.f3670a = this.f3659j.mo5540e(a);
        if (this.f3658i == 1) {
            if (mo4788h()) {
                i5 = mo5189z() - mo5101D();
                i4 = i5 - this.f3659j.mo5542f(a);
            } else {
                i4 = mo5099B();
                i5 = this.f3659j.mo5542f(a) + i4;
            }
            if (cVar.f3679f == -1) {
                i3 = cVar.f3675b - bVar.f3670a;
                i2 = i5;
                i = cVar.f3675b;
            } else {
                i = cVar.f3675b + bVar.f3670a;
                i2 = i5;
                i3 = cVar.f3675b;
            }
        } else {
            int C = mo5100C();
            int f = this.f3659j.mo5542f(a) + C;
            if (cVar.f3679f == -1) {
                i3 = C;
                i2 = cVar.f3675b;
                i = f;
                i4 = cVar.f3675b - bVar.f3670a;
            } else {
                i2 = cVar.f3675b + bVar.f3670a;
                i3 = C;
                i = f;
                i4 = cVar.f3675b;
            }
        }
        mo5113a(a, i4, i3, i2, i);
        if (jVar.mo5197d() || jVar.mo5198e()) {
            bVar.f3672c = true;
        }
        bVar.f3673d = a.hasFocusable();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo4792l() {
        return (mo5188y() == 1073741824 || mo5187x() == 1073741824 || !mo5108K()) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo4782f(int i) {
        int i2 = -1;
        int i3 = C1024a.INVALID_ID;
        if (i == 17) {
            if (this.f3658i != 0) {
                i2 = C1024a.INVALID_ID;
            }
            return i2;
        } else if (i == 33) {
            if (this.f3658i != 1) {
                i2 = C1024a.INVALID_ID;
            }
            return i2;
        } else if (i == 66) {
            if (this.f3658i == 0) {
                i3 = 1;
            }
            return i3;
        } else if (i != 130) {
            switch (i) {
                case 1:
                    return (this.f3658i != 1 && mo4788h()) ? 1 : -1;
                case 2:
                    return (this.f3658i != 1 && mo4788h()) ? -1 : 1;
                default:
                    return C1024a.INVALID_ID;
            }
        } else {
            if (this.f3658i == 1) {
                i3 = 1;
            }
            return i3;
        }
    }

    /* renamed from: M */
    private View m4615M() {
        return mo5169i(this.f3660k ? mo5186w() - 1 : 0);
    }

    /* renamed from: N */
    private View m4616N() {
        return mo5169i(this.f3660k ? 0 : mo5186w() - 1);
    }

    /* renamed from: a */
    private View m4618a(boolean z, boolean z2) {
        if (this.f3660k) {
            return mo4760a(mo5186w() - 1, -1, z, z2);
        }
        return mo4760a(0, mo5186w(), z, z2);
    }

    /* renamed from: b */
    private View m4628b(boolean z, boolean z2) {
        if (this.f3660k) {
            return mo4760a(0, mo5186w(), z, z2);
        }
        return mo4760a(mo5186w() - 1, -1, z, z2);
    }

    /* renamed from: f */
    private View m4633f(C1266p pVar, C1274u uVar) {
        if (this.f3660k) {
            return m4636h(pVar, uVar);
        }
        return m4638i(pVar, uVar);
    }

    /* renamed from: g */
    private View m4634g(C1266p pVar, C1274u uVar) {
        if (this.f3660k) {
            return m4638i(pVar, uVar);
        }
        return m4636h(pVar, uVar);
    }

    /* renamed from: h */
    private View m4636h(C1266p pVar, C1274u uVar) {
        return mo4729a(pVar, uVar, 0, mo5186w(), uVar.mo5291e());
    }

    /* renamed from: i */
    private View m4638i(C1266p pVar, C1274u uVar) {
        return mo4729a(pVar, uVar, mo5186w() - 1, -1, uVar.mo5291e());
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
            if (d2 >= 0 && d2 < i3) {
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

    /* renamed from: j */
    private View m4640j(C1266p pVar, C1274u uVar) {
        if (this.f3660k) {
            return m4643l(pVar, uVar);
        }
        return m4644m(pVar, uVar);
    }

    /* renamed from: k */
    private View m4642k(C1266p pVar, C1274u uVar) {
        if (this.f3660k) {
            return m4644m(pVar, uVar);
        }
        return m4643l(pVar, uVar);
    }

    /* renamed from: l */
    private View m4643l(C1266p pVar, C1274u uVar) {
        return mo4769b(0, mo5186w());
    }

    /* renamed from: m */
    private View m4644m(C1266p pVar, C1274u uVar) {
        return mo4769b(mo5186w() - 1, -1);
    }

    /* renamed from: m */
    public int mo4793m() {
        View a = mo4760a(0, mo5186w(), false, true);
        if (a == null) {
            return -1;
        }
        return mo5152d(a);
    }

    /* renamed from: n */
    public int mo4794n() {
        View a = mo4760a(0, mo5186w(), true, false);
        if (a == null) {
            return -1;
        }
        return mo5152d(a);
    }

    /* renamed from: o */
    public int mo4795o() {
        View a = mo4760a(mo5186w() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return mo5152d(a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo4760a(int i, int i2, boolean z, boolean z2) {
        mo4789i();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        if (this.f3658i == 0) {
            return this.f3715r.mo5565a(i, i2, i4, i3);
        }
        return this.f3716s.mo5565a(i, i2, i4, i3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public View mo4769b(int i, int i2) {
        int i3;
        int i4;
        View view;
        mo4789i();
        char c = i2 > i ? 1 : i2 < i ? (char) 65535 : 0;
        if (c == 0) {
            return mo5169i(i);
        }
        if (this.f3659j.mo5530a(mo5169i(i)) < this.f3659j.mo5535c()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.f3658i == 0) {
            view = this.f3715r.mo5565a(i, i2, i4, i3);
        } else {
            view = this.f3716s.mo5565a(i, i2, i4, i3);
        }
        return view;
    }

    /* renamed from: a */
    public View mo4728a(View view, int i, C1266p pVar, C1274u uVar) {
        View view2;
        View view3;
        m4614L();
        if (mo5186w() == 0) {
            return null;
        }
        int f = mo4782f(i);
        if (f == Integer.MIN_VALUE) {
            return null;
        }
        mo4789i();
        mo4789i();
        m4620a(f, (int) (((float) this.f3659j.mo5541f()) * 0.33333334f), false, uVar);
        this.f3650a.f3680g = C1024a.INVALID_ID;
        this.f3650a.f3674a = false;
        mo4759a(pVar, this.f3650a, uVar, true);
        if (f == -1) {
            view2 = m4642k(pVar, uVar);
        } else {
            view2 = m4640j(pVar, uVar);
        }
        if (f == -1) {
            view3 = m4615M();
        } else {
            view3 = m4616N();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    /* renamed from: b */
    public boolean mo4749b() {
        return this.f3663n == null && this.f3651b == this.f3653d;
    }
}
