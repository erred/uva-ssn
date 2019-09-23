package androidx.appcompat.widget;

import androidx.customview.p073b.C1024a;

/* renamed from: androidx.appcompat.widget.am */
/* compiled from: RtlSpacingHelper */
class C0630am {

    /* renamed from: a */
    private int f1793a = 0;

    /* renamed from: b */
    private int f1794b = 0;

    /* renamed from: c */
    private int f1795c = C1024a.INVALID_ID;

    /* renamed from: d */
    private int f1796d = C1024a.INVALID_ID;

    /* renamed from: e */
    private int f1797e = 0;

    /* renamed from: f */
    private int f1798f = 0;

    /* renamed from: g */
    private boolean f1799g = false;

    /* renamed from: h */
    private boolean f1800h = false;

    C0630am() {
    }

    /* renamed from: a */
    public int mo2340a() {
        return this.f1793a;
    }

    /* renamed from: b */
    public int mo2343b() {
        return this.f1794b;
    }

    /* renamed from: c */
    public int mo2345c() {
        return this.f1799g ? this.f1794b : this.f1793a;
    }

    /* renamed from: d */
    public int mo2346d() {
        return this.f1799g ? this.f1793a : this.f1794b;
    }

    /* renamed from: a */
    public void mo2341a(int i, int i2) {
        this.f1795c = i;
        this.f1796d = i2;
        this.f1800h = true;
        if (this.f1799g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1793a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1794b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1793a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1794b = i2;
        }
    }

    /* renamed from: b */
    public void mo2344b(int i, int i2) {
        this.f1800h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1797e = i;
            this.f1793a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1798f = i2;
            this.f1794b = i2;
        }
    }

    /* renamed from: a */
    public void mo2342a(boolean z) {
        if (z != this.f1799g) {
            this.f1799g = z;
            if (!this.f1800h) {
                this.f1793a = this.f1797e;
                this.f1794b = this.f1798f;
            } else if (z) {
                this.f1793a = this.f1796d != Integer.MIN_VALUE ? this.f1796d : this.f1797e;
                this.f1794b = this.f1795c != Integer.MIN_VALUE ? this.f1795c : this.f1798f;
            } else {
                this.f1793a = this.f1795c != Integer.MIN_VALUE ? this.f1795c : this.f1797e;
                this.f1794b = this.f1796d != Integer.MIN_VALUE ? this.f1796d : this.f1798f;
            }
        }
    }
}
