package androidx.p052b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: androidx.b.f */
/* compiled from: MapCollections */
abstract class C0719f<K, V> {

    /* renamed from: b */
    C0721b f2076b;

    /* renamed from: c */
    C0722c f2077c;

    /* renamed from: d */
    C0724e f2078d;

    /* renamed from: androidx.b.f$a */
    /* compiled from: MapCollections */
    final class C0720a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f2079a;

        /* renamed from: b */
        int f2080b;

        /* renamed from: c */
        int f2081c;

        /* renamed from: d */
        boolean f2082d = false;

        C0720a(int i) {
            this.f2079a = i;
            this.f2080b = C0719f.this.mo2749a();
        }

        public boolean hasNext() {
            return this.f2081c < this.f2080b;
        }

        public T next() {
            if (hasNext()) {
                T a = C0719f.this.mo2751a(this.f2081c, this.f2079a);
                this.f2081c++;
                this.f2082d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f2082d) {
                this.f2081c--;
                this.f2080b--;
                this.f2082d = false;
                C0719f.this.mo2753a(this.f2081c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: androidx.b.f$b */
    /* compiled from: MapCollections */
    final class C0721b implements Set<Entry<K, V>> {
        C0721b() {
        }

        /* renamed from: a */
        public boolean add(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = C0719f.this.mo2749a();
            for (Entry entry : collection) {
                C0719f.this.mo2754a(entry.getKey(), entry.getValue());
            }
            return a != C0719f.this.mo2749a();
        }

        public void clear() {
            C0719f.this.mo2757c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = C0719f.this.mo2750a(entry.getKey());
            if (a < 0) {
                return false;
            }
            return C0716c.m2516a(C0719f.this.mo2751a(a, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return C0719f.this.mo2749a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0723d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return C0719f.this.mo2749a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C0719f.m2533a((Set<T>) this, obj);
        }

        public int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int a = C0719f.this.mo2749a() - 1; a >= 0; a--) {
                Object a2 = C0719f.this.mo2751a(a, 0);
                Object a3 = C0719f.this.mo2751a(a, 1);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.hashCode();
                }
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }
    }

    /* renamed from: androidx.b.f$c */
    /* compiled from: MapCollections */
    final class C0722c implements Set<K> {
        C0722c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C0719f.this.mo2757c();
        }

        public boolean contains(Object obj) {
            return C0719f.this.mo2750a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0719f.m2532a(C0719f.this.mo2756b(), collection);
        }

        public boolean isEmpty() {
            return C0719f.this.mo2749a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0720a(0);
        }

        public boolean remove(Object obj) {
            int a = C0719f.this.mo2750a(obj);
            if (a < 0) {
                return false;
            }
            C0719f.this.mo2753a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0719f.m2534b(C0719f.this.mo2756b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0719f.m2535c(C0719f.this.mo2756b(), collection);
        }

        public int size() {
            return C0719f.this.mo2749a();
        }

        public Object[] toArray() {
            return C0719f.this.mo2811b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return C0719f.this.mo2810a(tArr, 0);
        }

        public boolean equals(Object obj) {
            return C0719f.m2533a((Set<T>) this, obj);
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            for (int a = C0719f.this.mo2749a() - 1; a >= 0; a--) {
                Object a2 = C0719f.this.mo2751a(a, 0);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.hashCode();
                }
                i2 += i;
            }
            return i2;
        }
    }

    /* renamed from: androidx.b.f$d */
    /* compiled from: MapCollections */
    final class C0723d implements Iterator<Entry<K, V>>, Entry<K, V> {

        /* renamed from: a */
        int f2086a;

        /* renamed from: b */
        int f2087b;

        /* renamed from: c */
        boolean f2088c = false;

        C0723d() {
            this.f2086a = C0719f.this.mo2749a() - 1;
            this.f2087b = -1;
        }

        public boolean hasNext() {
            return this.f2087b < this.f2086a;
        }

        /* renamed from: a */
        public Entry<K, V> next() {
            if (hasNext()) {
                this.f2087b++;
                this.f2088c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f2088c) {
                C0719f.this.mo2753a(this.f2087b);
                this.f2087b--;
                this.f2086a--;
                this.f2088c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f2088c) {
                return C0719f.this.mo2751a(this.f2087b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f2088c) {
                return C0719f.this.mo2751a(this.f2087b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f2088c) {
                return C0719f.this.mo2752a(this.f2087b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean equals(Object obj) {
            if (this.f2088c) {
                boolean z = false;
                if (!(obj instanceof Entry)) {
                    return false;
                }
                Entry entry = (Entry) obj;
                if (C0716c.m2516a(entry.getKey(), C0719f.this.mo2751a(this.f2087b, 0)) && C0716c.m2516a(entry.getValue(), C0719f.this.mo2751a(this.f2087b, 1))) {
                    z = true;
                }
                return z;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public int hashCode() {
            int i;
            if (this.f2088c) {
                int i2 = 0;
                Object a = C0719f.this.mo2751a(this.f2087b, 0);
                Object a2 = C0719f.this.mo2751a(this.f2087b, 1);
                if (a == null) {
                    i = 0;
                } else {
                    i = a.hashCode();
                }
                if (a2 != null) {
                    i2 = a2.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* renamed from: androidx.b.f$e */
    /* compiled from: MapCollections */
    final class C0724e implements Collection<V> {
        C0724e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C0719f.this.mo2757c();
        }

        public boolean contains(Object obj) {
            return C0719f.this.mo2755b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return C0719f.this.mo2749a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0720a(1);
        }

        public boolean remove(Object obj) {
            int b = C0719f.this.mo2755b(obj);
            if (b < 0) {
                return false;
            }
            C0719f.this.mo2753a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a = C0719f.this.mo2749a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (collection.contains(C0719f.this.mo2751a(i, 1))) {
                    C0719f.this.mo2753a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int a = C0719f.this.mo2749a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (!collection.contains(C0719f.this.mo2751a(i, 1))) {
                    C0719f.this.mo2753a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return C0719f.this.mo2749a();
        }

        public Object[] toArray() {
            return C0719f.this.mo2811b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return C0719f.this.mo2810a(tArr, 1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo2749a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo2750a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo2751a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract V mo2752a(int i, V v);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo2753a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo2754a(K k, V v);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo2755b(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> mo2756b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo2757c();

    C0719f() {
    }

    /* renamed from: a */
    public static <K, V> boolean m2532a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m2534b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m2535c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: b */
    public Object[] mo2811b(int i) {
        int a = mo2749a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo2751a(i2, i);
        }
        return objArr;
    }

    /* renamed from: a */
    public <T> T[] mo2810a(T[] tArr, int i) {
        int a = mo2749a();
        if (tArr.length < a) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr[i2] = mo2751a(i2, i);
        }
        if (tArr.length > a) {
            tArr[a] = null;
        }
        return tArr;
    }

    /* renamed from: a */
    public static <T> boolean m2533a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                z = false;
            }
            return z;
        } catch (NullPointerException unused) {
            return false;
        } catch (ClassCastException unused2) {
            return false;
        }
    }

    /* renamed from: d */
    public Set<Entry<K, V>> mo2812d() {
        if (this.f2076b == null) {
            this.f2076b = new C0721b<>();
        }
        return this.f2076b;
    }

    /* renamed from: e */
    public Set<K> mo2813e() {
        if (this.f2077c == null) {
            this.f2077c = new C0722c<>();
        }
        return this.f2077c;
    }

    /* renamed from: f */
    public Collection<V> mo2814f() {
        if (this.f2078d == null) {
            this.f2078d = new C0724e<>();
        }
        return this.f2078d;
    }
}
