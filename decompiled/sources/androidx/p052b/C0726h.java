package androidx.p052b;

/* renamed from: androidx.b.h */
/* compiled from: SparseArrayCompat */
public class C0726h<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f2098a = new Object();

    /* renamed from: b */
    private boolean f2099b;

    /* renamed from: c */
    private int[] f2100c;

    /* renamed from: d */
    private Object[] f2101d;

    /* renamed from: e */
    private int f2102e;

    public C0726h() {
        this(10);
    }

    public C0726h(int i) {
        this.f2099b = false;
        if (i == 0) {
            this.f2100c = C0716c.f2068a;
            this.f2101d = C0716c.f2070c;
        } else {
            int a = C0716c.m2513a(i);
            this.f2100c = new int[a];
            this.f2101d = new Object[a];
        }
        this.f2102e = 0;
    }

    /* renamed from: a */
    public C0726h<E> clone() {
        try {
            C0726h<E> hVar = (C0726h) super.clone();
            hVar.f2100c = (int[]) this.f2100c.clone();
            hVar.f2101d = (Object[]) this.f2101d.clone();
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public E mo2895a(int i) {
        return mo2896a(i, null);
    }

    /* renamed from: a */
    public E mo2896a(int i, E e) {
        int a = C0716c.m2514a(this.f2100c, this.f2102e, i);
        return (a < 0 || this.f2101d[a] == f2098a) ? e : this.f2101d[a];
    }

    /* renamed from: b */
    public void mo2898b(int i) {
        int a = C0716c.m2514a(this.f2100c, this.f2102e, i);
        if (a >= 0 && this.f2101d[a] != f2098a) {
            this.f2101d[a] = f2098a;
            this.f2099b = true;
        }
    }

    /* renamed from: c */
    public void mo2901c(int i) {
        mo2898b(i);
    }

    /* renamed from: d */
    private void m2565d() {
        int i = this.f2102e;
        int[] iArr = this.f2100c;
        Object[] objArr = this.f2101d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2098a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f2099b = false;
        this.f2102e = i2;
    }

    /* renamed from: b */
    public void mo2899b(int i, E e) {
        int a = C0716c.m2514a(this.f2100c, this.f2102e, i);
        if (a >= 0) {
            this.f2101d[a] = e;
        } else {
            int i2 = ~a;
            if (i2 >= this.f2102e || this.f2101d[i2] != f2098a) {
                if (this.f2099b && this.f2102e >= this.f2100c.length) {
                    m2565d();
                    i2 = ~C0716c.m2514a(this.f2100c, this.f2102e, i);
                }
                if (this.f2102e >= this.f2100c.length) {
                    int a2 = C0716c.m2513a(this.f2102e + 1);
                    int[] iArr = new int[a2];
                    Object[] objArr = new Object[a2];
                    System.arraycopy(this.f2100c, 0, iArr, 0, this.f2100c.length);
                    System.arraycopy(this.f2101d, 0, objArr, 0, this.f2101d.length);
                    this.f2100c = iArr;
                    this.f2101d = objArr;
                }
                if (this.f2102e - i2 != 0) {
                    int i3 = i2 + 1;
                    System.arraycopy(this.f2100c, i2, this.f2100c, i3, this.f2102e - i2);
                    System.arraycopy(this.f2101d, i2, this.f2101d, i3, this.f2102e - i2);
                }
                this.f2100c[i2] = i;
                this.f2101d[i2] = e;
                this.f2102e++;
            } else {
                this.f2100c[i2] = i;
                this.f2101d[i2] = e;
            }
        }
    }

    /* renamed from: b */
    public int mo2897b() {
        if (this.f2099b) {
            m2565d();
        }
        return this.f2102e;
    }

    /* renamed from: d */
    public int mo2904d(int i) {
        if (this.f2099b) {
            m2565d();
        }
        return this.f2100c[i];
    }

    /* renamed from: e */
    public E mo2905e(int i) {
        if (this.f2099b) {
            m2565d();
        }
        return this.f2101d[i];
    }

    /* renamed from: f */
    public int mo2906f(int i) {
        if (this.f2099b) {
            m2565d();
        }
        return C0716c.m2514a(this.f2100c, this.f2102e, i);
    }

    /* renamed from: a */
    public int mo2893a(E e) {
        if (this.f2099b) {
            m2565d();
        }
        for (int i = 0; i < this.f2102e; i++) {
            if (this.f2101d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public void mo2900c() {
        int i = this.f2102e;
        Object[] objArr = this.f2101d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f2102e = 0;
        this.f2099b = false;
    }

    /* renamed from: c */
    public void mo2902c(int i, E e) {
        if (this.f2102e == 0 || i > this.f2100c[this.f2102e - 1]) {
            if (this.f2099b && this.f2102e >= this.f2100c.length) {
                m2565d();
            }
            int i2 = this.f2102e;
            if (i2 >= this.f2100c.length) {
                int a = C0716c.m2513a(i2 + 1);
                int[] iArr = new int[a];
                Object[] objArr = new Object[a];
                System.arraycopy(this.f2100c, 0, iArr, 0, this.f2100c.length);
                System.arraycopy(this.f2101d, 0, objArr, 0, this.f2101d.length);
                this.f2100c = iArr;
                this.f2101d = objArr;
            }
            this.f2100c[i2] = i;
            this.f2101d[i2] = e;
            this.f2102e = i2 + 1;
            return;
        }
        mo2899b(i, e);
    }

    public String toString() {
        if (mo2897b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2102e * 28);
        sb.append('{');
        for (int i = 0; i < this.f2102e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo2904d(i));
            sb.append('=');
            Object e = mo2905e(i);
            if (e != this) {
                sb.append(e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
