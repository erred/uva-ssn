package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.customview.p073b.C1024a;
import androidx.recyclerview.widget.RecyclerView.C1254i;
import androidx.recyclerview.widget.RecyclerView.C1259j;

/* renamed from: androidx.recyclerview.widget.i */
/* compiled from: OrientationHelper */
public abstract class C1317i {

    /* renamed from: a */
    protected final C1254i f3980a;

    /* renamed from: b */
    final Rect f3981b;

    /* renamed from: c */
    private int f3982c;

    /* renamed from: a */
    public abstract int mo5530a(View view);

    /* renamed from: a */
    public abstract void mo5532a(int i);

    /* renamed from: b */
    public abstract int mo5534b(View view);

    /* renamed from: c */
    public abstract int mo5535c();

    /* renamed from: c */
    public abstract int mo5536c(View view);

    /* renamed from: d */
    public abstract int mo5537d();

    /* renamed from: d */
    public abstract int mo5538d(View view);

    /* renamed from: e */
    public abstract int mo5539e();

    /* renamed from: e */
    public abstract int mo5540e(View view);

    /* renamed from: f */
    public abstract int mo5541f();

    /* renamed from: f */
    public abstract int mo5542f(View view);

    /* renamed from: g */
    public abstract int mo5543g();

    /* renamed from: h */
    public abstract int mo5544h();

    /* renamed from: i */
    public abstract int mo5545i();

    private C1317i(C1254i iVar) {
        this.f3982c = C1024a.INVALID_ID;
        this.f3981b = new Rect();
        this.f3980a = iVar;
    }

    /* renamed from: a */
    public void mo5531a() {
        this.f3982c = mo5541f();
    }

    /* renamed from: b */
    public int mo5533b() {
        if (Integer.MIN_VALUE == this.f3982c) {
            return 0;
        }
        return mo5541f() - this.f3982c;
    }

    /* renamed from: a */
    public static C1317i m5359a(C1254i iVar, int i) {
        switch (i) {
            case 0:
                return m5358a(iVar);
            case 1:
                return m5360b(iVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* renamed from: a */
    public static C1317i m5358a(C1254i iVar) {
        return new C1317i(iVar) {
            /* renamed from: d */
            public int mo5537d() {
                return this.f3980a.mo5189z() - this.f3980a.mo5101D();
            }

            /* renamed from: e */
            public int mo5539e() {
                return this.f3980a.mo5189z();
            }

            /* renamed from: a */
            public void mo5532a(int i) {
                this.f3980a.mo5171j(i);
            }

            /* renamed from: c */
            public int mo5535c() {
                return this.f3980a.mo5099B();
            }

            /* renamed from: e */
            public int mo5540e(View view) {
                C1259j jVar = (C1259j) view.getLayoutParams();
                return this.f3980a.mo5161f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            /* renamed from: f */
            public int mo5542f(View view) {
                C1259j jVar = (C1259j) view.getLayoutParams();
                return this.f3980a.mo5164g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            /* renamed from: b */
            public int mo5534b(View view) {
                return this.f3980a.mo5170j(view) + ((C1259j) view.getLayoutParams()).rightMargin;
            }

            /* renamed from: a */
            public int mo5530a(View view) {
                return this.f3980a.mo5166h(view) - ((C1259j) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: c */
            public int mo5536c(View view) {
                this.f3980a.mo5118a(view, true, this.f3981b);
                return this.f3981b.right;
            }

            /* renamed from: d */
            public int mo5538d(View view) {
                this.f3980a.mo5118a(view, true, this.f3981b);
                return this.f3981b.left;
            }

            /* renamed from: f */
            public int mo5541f() {
                return (this.f3980a.mo5189z() - this.f3980a.mo5099B()) - this.f3980a.mo5101D();
            }

            /* renamed from: g */
            public int mo5543g() {
                return this.f3980a.mo5101D();
            }

            /* renamed from: h */
            public int mo5544h() {
                return this.f3980a.mo5187x();
            }

            /* renamed from: i */
            public int mo5545i() {
                return this.f3980a.mo5188y();
            }
        };
    }

    /* renamed from: b */
    public static C1317i m5360b(C1254i iVar) {
        return new C1317i(iVar) {
            /* renamed from: d */
            public int mo5537d() {
                return this.f3980a.mo5098A() - this.f3980a.mo5102E();
            }

            /* renamed from: e */
            public int mo5539e() {
                return this.f3980a.mo5098A();
            }

            /* renamed from: a */
            public void mo5532a(int i) {
                this.f3980a.mo5173k(i);
            }

            /* renamed from: c */
            public int mo5535c() {
                return this.f3980a.mo5100C();
            }

            /* renamed from: e */
            public int mo5540e(View view) {
                C1259j jVar = (C1259j) view.getLayoutParams();
                return this.f3980a.mo5164g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            /* renamed from: f */
            public int mo5542f(View view) {
                C1259j jVar = (C1259j) view.getLayoutParams();
                return this.f3980a.mo5161f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            /* renamed from: b */
            public int mo5534b(View view) {
                return this.f3980a.mo5172k(view) + ((C1259j) view.getLayoutParams()).bottomMargin;
            }

            /* renamed from: a */
            public int mo5530a(View view) {
                return this.f3980a.mo5168i(view) - ((C1259j) view.getLayoutParams()).topMargin;
            }

            /* renamed from: c */
            public int mo5536c(View view) {
                this.f3980a.mo5118a(view, true, this.f3981b);
                return this.f3981b.bottom;
            }

            /* renamed from: d */
            public int mo5538d(View view) {
                this.f3980a.mo5118a(view, true, this.f3981b);
                return this.f3981b.top;
            }

            /* renamed from: f */
            public int mo5541f() {
                return (this.f3980a.mo5098A() - this.f3980a.mo5100C()) - this.f3980a.mo5102E();
            }

            /* renamed from: g */
            public int mo5543g() {
                return this.f3980a.mo5102E();
            }

            /* renamed from: h */
            public int mo5544h() {
                return this.f3980a.mo5188y();
            }

            /* renamed from: i */
            public int mo5545i() {
                return this.f3980a.mo5187x();
            }
        };
    }
}
