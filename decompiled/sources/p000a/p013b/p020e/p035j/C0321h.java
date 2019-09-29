package p000a.p013b.p020e.p035j;

/* renamed from: a.b.e.j.h */
/* compiled from: OpenHashSet */
public final class C0321h<T> {

    /* renamed from: a */
    final float f674a;

    /* renamed from: b */
    int f675b;

    /* renamed from: c */
    int f676c;

    /* renamed from: d */
    int f677d;

    /* renamed from: e */
    T[] f678e;

    /* renamed from: a */
    static int m863a(int i) {
        int i2 = i * -1640531527;
        return i2 ^ (i2 >>> 16);
    }

    public C0321h() {
        this(16, 0.75f);
    }

    public C0321h(int i, float f) {
        this.f674a = f;
        int a = C0322i.m869a(i);
        this.f675b = a - 1;
        this.f677d = (int) (f * ((float) a));
        this.f678e = (Object[]) new Object[a];
    }

    /* renamed from: a */
    public boolean mo525a(T t) {
        T t2;
        T[] tArr = this.f678e;
        int i = this.f675b;
        int a = m863a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i;
                t2 = tArr[a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a] = t;
        int i2 = this.f676c + 1;
        this.f676c = i2;
        if (i2 >= this.f677d) {
            mo523a();
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo526b(T t) {
        T t2;
        T[] tArr = this.f678e;
        int i = this.f675b;
        int a = m863a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return mo524a(a, tArr, i);
        }
        do {
            a = (a + 1) & i;
            t2 = tArr[a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return mo524a(a, tArr, i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo524a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f676c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a = m863a(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= a || a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    if (i >= a && a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo523a() {
        T[] tArr = this.f678e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (Object[]) new Object[i];
        int i3 = this.f676c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int a = m863a(tArr[length].hashCode()) & i2;
                if (tArr2[a] != null) {
                    do {
                        a = (a + 1) & i2;
                    } while (tArr2[a] != null);
                }
                tArr2[a] = tArr[length];
                i3 = i4;
            } else {
                this.f675b = i2;
                this.f677d = (int) (((float) i) * this.f674a);
                this.f678e = tArr2;
                return;
            }
        }
    }

    /* renamed from: b */
    public Object[] mo527b() {
        return this.f678e;
    }
}
