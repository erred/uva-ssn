package androidx.p052b;

/* renamed from: androidx.b.d */
/* compiled from: LongSparseArray */
public class C0717d<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f2071a = new Object();

    /* renamed from: b */
    private boolean f2072b;

    /* renamed from: c */
    private long[] f2073c;

    /* renamed from: d */
    private Object[] f2074d;

    /* renamed from: e */
    private int f2075e;

    public C0717d() {
        this(10);
    }

    public C0717d(int i) {
        this.f2072b = false;
        if (i == 0) {
            this.f2073c = C0716c.f2069b;
            this.f2074d = C0716c.f2070c;
        } else {
            int b = C0716c.m2517b(i);
            this.f2073c = new long[b];
            this.f2074d = new Object[b];
        }
        this.f2075e = 0;
    }

    /* renamed from: a */
    public C0717d<E> clone() {
        try {
            C0717d<E> dVar = (C0717d) super.clone();
            dVar.f2073c = (long[]) this.f2073c.clone();
            dVar.f2074d = (Object[]) this.f2074d.clone();
            return dVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public E mo2779a(long j) {
        return mo2780a(j, null);
    }

    /* renamed from: a */
    public E mo2780a(long j, E e) {
        int a = C0716c.m2515a(this.f2073c, this.f2075e, j);
        return (a < 0 || this.f2074d[a] == f2071a) ? e : this.f2074d[a];
    }

    /* renamed from: b */
    public void mo2784b(long j) {
        int a = C0716c.m2515a(this.f2073c, this.f2075e, j);
        if (a >= 0 && this.f2074d[a] != f2071a) {
            this.f2074d[a] = f2071a;
            this.f2072b = true;
        }
    }

    /* renamed from: a */
    public void mo2781a(int i) {
        if (this.f2074d[i] != f2071a) {
            this.f2074d[i] = f2071a;
            this.f2072b = true;
        }
    }

    /* renamed from: d */
    private void m2519d() {
        int i = this.f2075e;
        long[] jArr = this.f2073c;
        Object[] objArr = this.f2074d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2071a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f2072b = false;
        this.f2075e = i2;
    }

    /* renamed from: b */
    public void mo2785b(long j, E e) {
        int a = C0716c.m2515a(this.f2073c, this.f2075e, j);
        if (a >= 0) {
            this.f2074d[a] = e;
        } else {
            int i = ~a;
            if (i >= this.f2075e || this.f2074d[i] != f2071a) {
                if (this.f2072b && this.f2075e >= this.f2073c.length) {
                    m2519d();
                    i = ~C0716c.m2515a(this.f2073c, this.f2075e, j);
                }
                if (this.f2075e >= this.f2073c.length) {
                    int b = C0716c.m2517b(this.f2075e + 1);
                    long[] jArr = new long[b];
                    Object[] objArr = new Object[b];
                    System.arraycopy(this.f2073c, 0, jArr, 0, this.f2073c.length);
                    System.arraycopy(this.f2074d, 0, objArr, 0, this.f2074d.length);
                    this.f2073c = jArr;
                    this.f2074d = objArr;
                }
                if (this.f2075e - i != 0) {
                    int i2 = i + 1;
                    System.arraycopy(this.f2073c, i, this.f2073c, i2, this.f2075e - i);
                    System.arraycopy(this.f2074d, i, this.f2074d, i2, this.f2075e - i);
                }
                this.f2073c[i] = j;
                this.f2074d[i] = e;
                this.f2075e++;
            } else {
                this.f2073c[i] = j;
                this.f2074d[i] = e;
            }
        }
    }

    /* renamed from: b */
    public int mo2782b() {
        if (this.f2072b) {
            m2519d();
        }
        return this.f2075e;
    }

    /* renamed from: b */
    public long mo2783b(int i) {
        if (this.f2072b) {
            m2519d();
        }
        return this.f2073c[i];
    }

    /* renamed from: c */
    public E mo2787c(int i) {
        if (this.f2072b) {
            m2519d();
        }
        return this.f2074d[i];
    }

    /* renamed from: c */
    public int mo2786c(long j) {
        if (this.f2072b) {
            m2519d();
        }
        return C0716c.m2515a(this.f2073c, this.f2075e, j);
    }

    /* renamed from: c */
    public void mo2788c() {
        int i = this.f2075e;
        Object[] objArr = this.f2074d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f2075e = 0;
        this.f2072b = false;
    }

    /* renamed from: c */
    public void mo2789c(long j, E e) {
        if (this.f2075e == 0 || j > this.f2073c[this.f2075e - 1]) {
            if (this.f2072b && this.f2075e >= this.f2073c.length) {
                m2519d();
            }
            int i = this.f2075e;
            if (i >= this.f2073c.length) {
                int b = C0716c.m2517b(i + 1);
                long[] jArr = new long[b];
                Object[] objArr = new Object[b];
                System.arraycopy(this.f2073c, 0, jArr, 0, this.f2073c.length);
                System.arraycopy(this.f2074d, 0, objArr, 0, this.f2074d.length);
                this.f2073c = jArr;
                this.f2074d = objArr;
            }
            this.f2073c[i] = j;
            this.f2074d[i] = e;
            this.f2075e = i + 1;
            return;
        }
        mo2785b(j, e);
    }

    public String toString() {
        if (mo2782b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2075e * 28);
        sb.append('{');
        for (int i = 0; i < this.f2075e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo2783b(i));
            sb.append('=');
            Object c = mo2787c(i);
            if (c != this) {
                sb.append(c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
