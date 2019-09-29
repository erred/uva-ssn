package androidx.core.p070g;

import android.view.View;
import android.view.ViewParent;

/* renamed from: androidx.core.g.k */
/* compiled from: NestedScrollingChildHelper */
public class C0955k {

    /* renamed from: a */
    private ViewParent f3004a;

    /* renamed from: b */
    private ViewParent f3005b;

    /* renamed from: c */
    private final View f3006c;

    /* renamed from: d */
    private boolean f3007d;

    /* renamed from: e */
    private int[] f3008e;

    public C0955k(View view) {
        this.f3006c = view;
    }

    /* renamed from: a */
    public void mo3738a(boolean z) {
        if (this.f3007d) {
            C0962r.m3602y(this.f3006c);
        }
        this.f3007d = z;
    }

    /* renamed from: a */
    public boolean mo3739a() {
        return this.f3007d;
    }

    /* renamed from: b */
    public boolean mo3748b() {
        return mo3742a(0);
    }

    /* renamed from: a */
    public boolean mo3742a(int i) {
        return m3519d(i) != null;
    }

    /* renamed from: b */
    public boolean mo3749b(int i) {
        return mo3743a(i, 0);
    }

    /* renamed from: a */
    public boolean mo3743a(int i, int i2) {
        if (mo3742a(i2)) {
            return true;
        }
        if (mo3739a()) {
            View view = this.f3006c;
            for (ViewParent parent = this.f3006c.getParent(); parent != null; parent = parent.getParent()) {
                if (C0968u.m3624a(parent, view, this.f3006c, i, i2)) {
                    m3518a(i2, parent);
                    C0968u.m3626b(parent, view, this.f3006c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void mo3750c() {
        mo3751c(0);
    }

    /* renamed from: c */
    public void mo3751c(int i) {
        ViewParent d = m3519d(i);
        if (d != null) {
            C0968u.m3619a(d, this.f3006c, i);
            m3518a(i, (ViewParent) null);
        }
    }

    /* renamed from: a */
    public boolean mo3744a(int i, int i2, int i3, int i4, int[] iArr) {
        return mo3745a(i, i2, i3, i4, iArr, 0);
    }

    /* renamed from: a */
    public boolean mo3745a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        int i6;
        int i7;
        int[] iArr2 = iArr;
        if (mo3739a()) {
            ViewParent d = m3519d(i5);
            if (d == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                if (iArr2 != null) {
                    this.f3006c.getLocationInWindow(iArr2);
                    i7 = iArr2[0];
                    i6 = iArr2[1];
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                C0968u.m3620a(d, this.f3006c, i, i2, i3, i4, i5);
                if (iArr2 != null) {
                    this.f3006c.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i7;
                    iArr2[1] = iArr2[1] - i6;
                }
                return true;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo3746a(int i, int i2, int[] iArr, int[] iArr2) {
        return mo3747a(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: a */
    public boolean mo3747a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        int i4;
        int i5;
        if (mo3739a()) {
            ViewParent d = m3519d(i3);
            if (d == null) {
                return false;
            }
            boolean z = true;
            if (i != 0 || i2 != 0) {
                if (iArr2 != null) {
                    this.f3006c.getLocationInWindow(iArr2);
                    i5 = iArr2[0];
                    i4 = iArr2[1];
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                if (iArr == null) {
                    if (this.f3008e == null) {
                        this.f3008e = new int[2];
                    }
                    iArr = this.f3008e;
                }
                iArr[0] = 0;
                iArr[1] = 0;
                C0968u.m3621a(d, this.f3006c, i, i2, iArr, i3);
                if (iArr2 != null) {
                    this.f3006c.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i5;
                    iArr2[1] = iArr2[1] - i4;
                }
                if (iArr[0] == 0 && iArr[1] == 0) {
                    z = false;
                }
                return z;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo3741a(float f, float f2, boolean z) {
        if (mo3739a()) {
            ViewParent d = m3519d(0);
            if (d != null) {
                return C0968u.m3623a(d, this.f3006c, f, f2, z);
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo3740a(float f, float f2) {
        if (mo3739a()) {
            ViewParent d = m3519d(0);
            if (d != null) {
                return C0968u.m3622a(d, this.f3006c, f, f2);
            }
        }
        return false;
    }

    /* renamed from: d */
    private ViewParent m3519d(int i) {
        switch (i) {
            case 0:
                return this.f3004a;
            case 1:
                return this.f3005b;
            default:
                return null;
        }
    }

    /* renamed from: a */
    private void m3518a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f3004a = viewParent;
                return;
            case 1:
                this.f3005b = viewParent;
                return;
            default:
                return;
        }
    }
}
