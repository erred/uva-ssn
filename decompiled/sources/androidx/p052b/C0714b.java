package androidx.p052b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: androidx.b.b */
/* compiled from: ArraySet */
public final class C0714b<E> implements Collection<E>, Set<E> {

    /* renamed from: c */
    private static final int[] f2057c = new int[0];

    /* renamed from: d */
    private static final Object[] f2058d = new Object[0];

    /* renamed from: e */
    private static Object[] f2059e;

    /* renamed from: f */
    private static int f2060f;

    /* renamed from: g */
    private static Object[] f2061g;

    /* renamed from: h */
    private static int f2062h;

    /* renamed from: a */
    Object[] f2063a;

    /* renamed from: b */
    int f2064b;

    /* renamed from: i */
    private int[] f2065i;

    /* renamed from: j */
    private C0719f<E, E> f2066j;

    /* renamed from: a */
    private int m2496a(Object obj, int i) {
        int i2 = this.f2064b;
        if (i2 == 0) {
            return -1;
        }
        int a = C0716c.m2514a(this.f2065i, i2, i);
        if (a < 0 || obj.equals(this.f2063a[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f2065i[i3] == i) {
            if (obj.equals(this.f2063a[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f2065i[i4] == i) {
            if (obj.equals(this.f2063a[i4])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    /* renamed from: a */
    private int m2495a() {
        int i = this.f2064b;
        if (i == 0) {
            return -1;
        }
        int a = C0716c.m2514a(this.f2065i, i, 0);
        if (a < 0 || this.f2063a[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f2065i[i2] == 0) {
            if (this.f2063a[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f2065i[i3] == 0) {
            if (this.f2063a[i3] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    /* renamed from: d */
    private void m2499d(int i) {
        if (i == 8) {
            synchronized (C0714b.class) {
                if (f2061g != null) {
                    Object[] objArr = f2061g;
                    this.f2063a = objArr;
                    f2061g = (Object[]) objArr[0];
                    this.f2065i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2062h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0714b.class) {
                if (f2059e != null) {
                    Object[] objArr2 = f2059e;
                    this.f2063a = objArr2;
                    f2059e = (Object[]) objArr2[0];
                    this.f2065i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2060f--;
                    return;
                }
            }
        }
        this.f2065i = new int[i];
        this.f2063a = new Object[i];
    }

    /* renamed from: a */
    private static void m2497a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0714b.class) {
                if (f2062h < 10) {
                    objArr[0] = f2061g;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f2061g = objArr;
                    f2062h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0714b.class) {
                if (f2060f < 10) {
                    objArr[0] = f2059e;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2059e = objArr;
                    f2060f++;
                }
            }
        }
    }

    public C0714b() {
        this(0);
    }

    public C0714b(int i) {
        if (i == 0) {
            this.f2065i = f2057c;
            this.f2063a = f2058d;
        } else {
            m2499d(i);
        }
        this.f2064b = 0;
    }

    public void clear() {
        if (this.f2064b != 0) {
            m2497a(this.f2065i, this.f2063a, this.f2064b);
            this.f2065i = f2057c;
            this.f2063a = f2058d;
            this.f2064b = 0;
        }
    }

    /* renamed from: a */
    public void mo2759a(int i) {
        if (this.f2065i.length < i) {
            int[] iArr = this.f2065i;
            Object[] objArr = this.f2063a;
            m2499d(i);
            if (this.f2064b > 0) {
                System.arraycopy(iArr, 0, this.f2065i, 0, this.f2064b);
                System.arraycopy(objArr, 0, this.f2063a, 0, this.f2064b);
            }
            m2497a(iArr, objArr, this.f2064b);
        }
    }

    public boolean contains(Object obj) {
        return mo2758a(obj) >= 0;
    }

    /* renamed from: a */
    public int mo2758a(Object obj) {
        return obj == null ? m2495a() : m2496a(obj, obj.hashCode());
    }

    /* renamed from: b */
    public E mo2762b(int i) {
        return this.f2063a[i];
    }

    public boolean isEmpty() {
        return this.f2064b <= 0;
    }

    public boolean add(E e) {
        int i;
        int i2;
        if (e == null) {
            i2 = m2495a();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = m2496a(e, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = ~i2;
        if (this.f2064b >= this.f2065i.length) {
            int i4 = 4;
            if (this.f2064b >= 8) {
                i4 = (this.f2064b >> 1) + this.f2064b;
            } else if (this.f2064b >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f2065i;
            Object[] objArr = this.f2063a;
            m2499d(i4);
            if (this.f2065i.length > 0) {
                System.arraycopy(iArr, 0, this.f2065i, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2063a, 0, objArr.length);
            }
            m2497a(iArr, objArr, this.f2064b);
        }
        if (i3 < this.f2064b) {
            int i5 = i3 + 1;
            System.arraycopy(this.f2065i, i3, this.f2065i, i5, this.f2064b - i3);
            System.arraycopy(this.f2063a, i3, this.f2063a, i5, this.f2064b - i3);
        }
        this.f2065i[i3] = i;
        this.f2063a[i3] = e;
        this.f2064b++;
        return true;
    }

    public boolean remove(Object obj) {
        int a = mo2758a(obj);
        if (a < 0) {
            return false;
        }
        mo2763c(a);
        return true;
    }

    /* renamed from: c */
    public E mo2763c(int i) {
        E e = this.f2063a[i];
        if (this.f2064b <= 1) {
            m2497a(this.f2065i, this.f2063a, this.f2064b);
            this.f2065i = f2057c;
            this.f2063a = f2058d;
            this.f2064b = 0;
        } else {
            int i2 = 8;
            if (this.f2065i.length <= 8 || this.f2064b >= this.f2065i.length / 3) {
                this.f2064b--;
                if (i < this.f2064b) {
                    int i3 = i + 1;
                    System.arraycopy(this.f2065i, i3, this.f2065i, i, this.f2064b - i);
                    System.arraycopy(this.f2063a, i3, this.f2063a, i, this.f2064b - i);
                }
                this.f2063a[this.f2064b] = null;
            } else {
                if (this.f2064b > 8) {
                    i2 = (this.f2064b >> 1) + this.f2064b;
                }
                int[] iArr = this.f2065i;
                Object[] objArr = this.f2063a;
                m2499d(i2);
                this.f2064b--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f2065i, 0, i);
                    System.arraycopy(objArr, 0, this.f2063a, 0, i);
                }
                if (i < this.f2064b) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.f2065i, i, this.f2064b - i);
                    System.arraycopy(objArr, i4, this.f2063a, i, this.f2064b - i);
                }
            }
        }
        return e;
    }

    public int size() {
        return this.f2064b;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[this.f2064b];
        System.arraycopy(this.f2063a, 0, objArr, 0, this.f2064b);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f2064b) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2064b);
        }
        System.arraycopy(this.f2063a, 0, tArr, 0, this.f2064b);
        if (tArr.length > this.f2064b) {
            tArr[this.f2064b] = null;
        }
        return tArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f2064b) {
            try {
                if (!set.contains(mo2762b(i))) {
                    return false;
                }
                i++;
            } catch (NullPointerException unused) {
                return false;
            } catch (ClassCastException unused2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f2065i;
        int i = 0;
        for (int i2 = 0; i2 < this.f2064b; i2++) {
            i += iArr[i2];
        }
        return i;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2064b * 14);
        sb.append('{');
        for (int i = 0; i < this.f2064b; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b = mo2762b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: b */
    private C0719f<E, E> m2498b() {
        if (this.f2066j == null) {
            this.f2066j = new C0719f<E, E>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2749a() {
                    return C0714b.this.f2064b;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Object mo2751a(int i, int i2) {
                    return C0714b.this.f2063a[i];
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2750a(Object obj) {
                    return C0714b.this.mo2758a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public int mo2755b(Object obj) {
                    return C0714b.this.mo2758a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Map<E, E> mo2756b() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2754a(E e, E e2) {
                    C0714b.this.add(e);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public E mo2752a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2753a(int i) {
                    C0714b.this.mo2763c(i);
                }

                /* access modifiers changed from: protected */
                /* renamed from: c */
                public void mo2757c() {
                    C0714b.this.clear();
                }
            };
        }
        return this.f2066j;
    }

    public Iterator<E> iterator() {
        return m2498b().mo2813e().iterator();
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        mo2759a(this.f2064b + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f2064b - 1; i >= 0; i--) {
            if (!collection.contains(this.f2063a[i])) {
                mo2763c(i);
                z = true;
            }
        }
        return z;
    }
}
