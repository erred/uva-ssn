package androidx.p052b;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: androidx.b.g */
/* compiled from: SimpleArrayMap */
public class C0725g<K, V> {

    /* renamed from: b */
    static Object[] f2091b;

    /* renamed from: c */
    static int f2092c;

    /* renamed from: d */
    static Object[] f2093d;

    /* renamed from: e */
    static int f2094e;

    /* renamed from: f */
    int[] f2095f;

    /* renamed from: g */
    Object[] f2096g;

    /* renamed from: h */
    int f2097h;

    /* renamed from: a */
    private static int m2552a(int[] iArr, int i, int i2) {
        try {
            return C0716c.m2514a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo2874a(Object obj, int i) {
        int i2 = this.f2097h;
        if (i2 == 0) {
            return -1;
        }
        int a = m2552a(this.f2095f, i2, i);
        if (a < 0 || obj.equals(this.f2096g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f2095f[i3] == i) {
            if (obj.equals(this.f2096g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f2095f[i4] == i) {
            if (obj.equals(this.f2096g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo2872a() {
        int i = this.f2097h;
        if (i == 0) {
            return -1;
        }
        int a = m2552a(this.f2095f, i, 0);
        if (a < 0 || this.f2096g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f2095f[i2] == 0) {
            if (this.f2096g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f2095f[i3] == 0) {
            if (this.f2096g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    /* renamed from: e */
    private void m2554e(int i) {
        if (i == 8) {
            synchronized (C0712a.class) {
                if (f2093d != null) {
                    Object[] objArr = f2093d;
                    this.f2096g = objArr;
                    f2093d = (Object[]) objArr[0];
                    this.f2095f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2094e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0712a.class) {
                if (f2091b != null) {
                    Object[] objArr2 = f2091b;
                    this.f2096g = objArr2;
                    f2091b = (Object[]) objArr2[0];
                    this.f2095f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2092c--;
                    return;
                }
            }
        }
        this.f2095f = new int[i];
        this.f2096g = new Object[(i << 1)];
    }

    /* renamed from: a */
    private static void m2553a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0712a.class) {
                if (f2094e < 10) {
                    objArr[0] = f2093d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f2093d = objArr;
                    f2094e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0712a.class) {
                if (f2092c < 10) {
                    objArr[0] = f2091b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2091b = objArr;
                    f2092c++;
                }
            }
        }
    }

    public C0725g() {
        this.f2095f = C0716c.f2068a;
        this.f2096g = C0716c.f2070c;
        this.f2097h = 0;
    }

    public C0725g(int i) {
        if (i == 0) {
            this.f2095f = C0716c.f2068a;
            this.f2096g = C0716c.f2070c;
        } else {
            m2554e(i);
        }
        this.f2097h = 0;
    }

    public C0725g(C0725g<K, V> gVar) {
        this();
        if (gVar != null) {
            mo2877a(gVar);
        }
    }

    public void clear() {
        if (this.f2097h > 0) {
            int[] iArr = this.f2095f;
            Object[] objArr = this.f2096g;
            int i = this.f2097h;
            this.f2095f = C0716c.f2068a;
            this.f2096g = C0716c.f2070c;
            this.f2097h = 0;
            m2553a(iArr, objArr, i);
        }
        if (this.f2097h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    public void mo2876a(int i) {
        int i2 = this.f2097h;
        if (this.f2095f.length < i) {
            int[] iArr = this.f2095f;
            Object[] objArr = this.f2096g;
            m2554e(i);
            if (this.f2097h > 0) {
                System.arraycopy(iArr, 0, this.f2095f, 0, i2);
                System.arraycopy(objArr, 0, this.f2096g, 0, i2 << 1);
            }
            m2553a(iArr, objArr, i2);
        }
        if (this.f2097h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return mo2873a(obj) >= 0;
    }

    /* renamed from: a */
    public int mo2873a(Object obj) {
        return obj == null ? mo2872a() : mo2874a(obj, obj.hashCode());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo2878b(Object obj) {
        int i = this.f2097h * 2;
        Object[] objArr = this.f2096g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
        } else {
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (obj.equals(objArr[i3])) {
                    return i3 >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return mo2878b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = mo2873a(obj);
        if (a >= 0) {
            return this.f2096g[(a << 1) + 1];
        }
        return null;
    }

    /* renamed from: b */
    public K mo2879b(int i) {
        return this.f2096g[i << 1];
    }

    /* renamed from: c */
    public V mo2880c(int i) {
        return this.f2096g[(i << 1) + 1];
    }

    /* renamed from: a */
    public V mo2875a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f2096g[i2];
        this.f2096g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f2097h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.f2097h;
        if (k == null) {
            i2 = mo2872a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = mo2874a((Object) k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V v2 = this.f2096g[i4];
            this.f2096g[i4] = v;
            return v2;
        }
        int i5 = ~i2;
        if (i3 >= this.f2095f.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f2095f;
            Object[] objArr = this.f2096g;
            m2554e(i6);
            if (i3 == this.f2097h) {
                if (this.f2095f.length > 0) {
                    System.arraycopy(iArr, 0, this.f2095f, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f2096g, 0, objArr.length);
                }
                m2553a(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int i7 = i5 + 1;
            System.arraycopy(this.f2095f, i5, this.f2095f, i7, i3 - i5);
            System.arraycopy(this.f2096g, i5 << 1, this.f2096g, i7 << 1, (this.f2097h - i5) << 1);
        }
        if (i3 != this.f2097h || i5 >= this.f2095f.length) {
            throw new ConcurrentModificationException();
        }
        this.f2095f[i5] = i;
        int i8 = i5 << 1;
        this.f2096g[i8] = k;
        this.f2096g[i8 + 1] = v;
        this.f2097h++;
        return null;
    }

    /* renamed from: a */
    public void mo2877a(C0725g<? extends K, ? extends V> gVar) {
        int i = gVar.f2097h;
        mo2876a(this.f2097h + i);
        if (this.f2097h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(gVar.mo2879b(i2), gVar.mo2880c(i2));
            }
        } else if (i > 0) {
            System.arraycopy(gVar.f2095f, 0, this.f2095f, 0, i);
            System.arraycopy(gVar.f2096g, 0, this.f2096g, 0, i << 1);
            this.f2097h = i;
        }
    }

    public V remove(Object obj) {
        int a = mo2873a(obj);
        if (a >= 0) {
            return mo2884d(a);
        }
        return null;
    }

    /* renamed from: d */
    public V mo2884d(int i) {
        int i2 = i << 1;
        V v = this.f2096g[i2 + 1];
        int i3 = this.f2097h;
        int i4 = 0;
        if (i3 <= 1) {
            m2553a(this.f2095f, this.f2096g, i3);
            this.f2095f = C0716c.f2068a;
            this.f2096g = C0716c.f2070c;
        } else {
            int i5 = i3 - 1;
            int i6 = 8;
            if (this.f2095f.length <= 8 || this.f2097h >= this.f2095f.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(this.f2095f, i7, this.f2095f, i, i8);
                    System.arraycopy(this.f2096g, i7 << 1, this.f2096g, i2, i8 << 1);
                }
                int i9 = i5 << 1;
                this.f2096g[i9] = null;
                this.f2096g[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                int[] iArr = this.f2095f;
                Object[] objArr = this.f2096g;
                m2554e(i6);
                if (i3 == this.f2097h) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.f2095f, 0, i);
                        System.arraycopy(objArr, 0, this.f2096g, 0, i2);
                    }
                    if (i < i5) {
                        int i10 = i + 1;
                        int i11 = i5 - i;
                        System.arraycopy(iArr, i10, this.f2095f, i, i11);
                        System.arraycopy(objArr, i10 << 1, this.f2096g, i2, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i4 = i5;
        }
        if (i3 == this.f2097h) {
            this.f2097h = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public int size() {
        return this.f2097h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0725g) {
            C0725g gVar = (C0725g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f2097h) {
                try {
                    Object b = mo2879b(i);
                    Object c = mo2880c(i);
                    Object obj2 = gVar.get(b);
                    if (c == null) {
                        if (obj2 != null || !gVar.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
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
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f2097h) {
                try {
                    Object b2 = mo2879b(i2);
                    Object c2 = mo2880c(i2);
                    Object obj3 = map.get(b2);
                    if (c2 == null) {
                        if (obj3 != null || !map.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (NullPointerException unused3) {
                    return false;
                } catch (ClassCastException unused4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.f2095f;
        Object[] objArr = this.f2096g;
        int i = this.f2097h;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < i) {
            Object obj = objArr[i3];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i3 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2097h * 28);
        sb.append('{');
        for (int i = 0; i < this.f2097h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b = mo2879b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c = mo2880c(i);
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
