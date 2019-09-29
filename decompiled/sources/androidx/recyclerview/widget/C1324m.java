package androidx.recyclerview.widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.m */
/* compiled from: ViewBoundsCheck */
class C1324m {

    /* renamed from: a */
    final C1326b f3985a;

    /* renamed from: b */
    C1325a f3986b = new C1325a();

    /* renamed from: androidx.recyclerview.widget.m$a */
    /* compiled from: ViewBoundsCheck */
    static class C1325a {

        /* renamed from: a */
        int f3987a = 0;

        /* renamed from: b */
        int f3988b;

        /* renamed from: c */
        int f3989c;

        /* renamed from: d */
        int f3990d;

        /* renamed from: e */
        int f3991e;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo5567a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        C1325a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5570a(int i, int i2, int i3, int i4) {
            this.f3988b = i;
            this.f3989c = i2;
            this.f3990d = i3;
            this.f3991e = i4;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5569a(int i) {
            this.f3987a = i | this.f3987a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5568a() {
            this.f3987a = 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo5571b() {
            if ((this.f3987a & 7) != 0 && (this.f3987a & (mo5567a(this.f3990d, this.f3988b) << 0)) == 0) {
                return false;
            }
            if ((this.f3987a & 112) != 0 && (this.f3987a & (mo5567a(this.f3990d, this.f3989c) << 4)) == 0) {
                return false;
            }
            if ((this.f3987a & 1792) != 0 && (this.f3987a & (mo5567a(this.f3991e, this.f3988b) << 8)) == 0) {
                return false;
            }
            if ((this.f3987a & 28672) == 0 || (this.f3987a & (mo5567a(this.f3991e, this.f3989c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.m$b */
    /* compiled from: ViewBoundsCheck */
    interface C1326b {
        /* renamed from: a */
        int mo5190a();

        /* renamed from: a */
        int mo5191a(View view);

        /* renamed from: a */
        View mo5192a(int i);

        /* renamed from: b */
        int mo5193b();

        /* renamed from: b */
        int mo5194b(View view);
    }

    C1324m(C1326b bVar) {
        this.f3985a = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo5565a(int i, int i2, int i3, int i4) {
        int a = this.f3985a.mo5190a();
        int b = this.f3985a.mo5193b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f3985a.mo5192a(i);
            this.f3986b.mo5570a(a, b, this.f3985a.mo5191a(a2), this.f3985a.mo5194b(a2));
            if (i3 != 0) {
                this.f3986b.mo5568a();
                this.f3986b.mo5569a(i3);
                if (this.f3986b.mo5571b()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.f3986b.mo5568a();
                this.f3986b.mo5569a(i4);
                if (this.f3986b.mo5571b()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5566a(View view, int i) {
        this.f3986b.mo5570a(this.f3985a.mo5190a(), this.f3985a.mo5193b(), this.f3985a.mo5191a(view), this.f3985a.mo5194b(view));
        if (i == 0) {
            return false;
        }
        this.f3986b.mo5568a();
        this.f3986b.mo5569a(i);
        return this.f3986b.mo5571b();
    }
}
