package androidx.p043a.p044a.p046b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: androidx.a.a.b.b */
/* compiled from: SafeIterableMap */
public class C0413b<K, V> implements Iterable<Entry<K, V>> {

    /* renamed from: a */
    C0416c<K, V> f835a;

    /* renamed from: b */
    private C0416c<K, V> f836b;

    /* renamed from: c */
    private WeakHashMap<C0419f<K, V>, Boolean> f837c = new WeakHashMap<>();

    /* renamed from: d */
    private int f838d = 0;

    /* renamed from: androidx.a.a.b.b$a */
    /* compiled from: SafeIterableMap */
    static class C0414a<K, V> extends C0418e<K, V> {
        C0414a(C0416c<K, V> cVar, C0416c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0416c<K, V> mo787a(C0416c<K, V> cVar) {
            return cVar.f841c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C0416c<K, V> mo788b(C0416c<K, V> cVar) {
            return cVar.f842d;
        }
    }

    /* renamed from: androidx.a.a.b.b$b */
    /* compiled from: SafeIterableMap */
    private static class C0415b<K, V> extends C0418e<K, V> {
        C0415b(C0416c<K, V> cVar, C0416c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0416c<K, V> mo787a(C0416c<K, V> cVar) {
            return cVar.f842d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C0416c<K, V> mo788b(C0416c<K, V> cVar) {
            return cVar.f841c;
        }
    }

    /* renamed from: androidx.a.a.b.b$c */
    /* compiled from: SafeIterableMap */
    static class C0416c<K, V> implements Entry<K, V> {

        /* renamed from: a */
        final K f839a;

        /* renamed from: b */
        final V f840b;

        /* renamed from: c */
        C0416c<K, V> f841c;

        /* renamed from: d */
        C0416c<K, V> f842d;

        C0416c(K k, V v) {
            this.f839a = k;
            this.f840b = v;
        }

        public K getKey() {
            return this.f839a;
        }

        public V getValue() {
            return this.f840b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f839a);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(this.f840b);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0416c)) {
                return false;
            }
            C0416c cVar = (C0416c) obj;
            if (!this.f839a.equals(cVar.f839a) || !this.f840b.equals(cVar.f840b)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f839a.hashCode() ^ this.f840b.hashCode();
        }
    }

    /* renamed from: androidx.a.a.b.b$d */
    /* compiled from: SafeIterableMap */
    private class C0417d implements C0419f<K, V>, Iterator<Entry<K, V>> {

        /* renamed from: b */
        private C0416c<K, V> f844b;

        /* renamed from: c */
        private boolean f845c = true;

        C0417d() {
        }

        /* renamed from: a_ */
        public void mo796a_(C0416c<K, V> cVar) {
            if (cVar == this.f844b) {
                this.f844b = this.f844b.f842d;
                this.f845c = this.f844b == null;
            }
        }

        public boolean hasNext() {
            boolean z = false;
            if (this.f845c) {
                if (C0413b.this.f835a != null) {
                    z = true;
                }
                return z;
            }
            if (!(this.f844b == null || this.f844b.f841c == null)) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        public Entry<K, V> next() {
            if (this.f845c) {
                this.f845c = false;
                this.f844b = C0413b.this.f835a;
            } else {
                this.f844b = this.f844b != null ? this.f844b.f841c : null;
            }
            return this.f844b;
        }
    }

    /* renamed from: androidx.a.a.b.b$e */
    /* compiled from: SafeIterableMap */
    private static abstract class C0418e<K, V> implements C0419f<K, V>, Iterator<Entry<K, V>> {

        /* renamed from: a */
        C0416c<K, V> f846a;

        /* renamed from: b */
        C0416c<K, V> f847b;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract C0416c<K, V> mo787a(C0416c<K, V> cVar);

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public abstract C0416c<K, V> mo788b(C0416c<K, V> cVar);

        C0418e(C0416c<K, V> cVar, C0416c<K, V> cVar2) {
            this.f846a = cVar2;
            this.f847b = cVar;
        }

        public boolean hasNext() {
            return this.f847b != null;
        }

        /* renamed from: a_ */
        public void mo796a_(C0416c<K, V> cVar) {
            if (this.f846a == cVar && cVar == this.f847b) {
                this.f847b = null;
                this.f846a = null;
            }
            if (this.f846a == cVar) {
                this.f846a = mo788b(this.f846a);
            }
            if (this.f847b == cVar) {
                this.f847b = m1261b();
            }
        }

        /* renamed from: b */
        private C0416c<K, V> m1261b() {
            if (this.f847b == this.f846a || this.f846a == null) {
                return null;
            }
            return mo787a(this.f847b);
        }

        /* renamed from: a */
        public Entry<K, V> next() {
            C0416c<K, V> cVar = this.f847b;
            this.f847b = m1261b();
            return cVar;
        }
    }

    /* renamed from: androidx.a.a.b.b$f */
    /* compiled from: SafeIterableMap */
    interface C0419f<K, V> {
        /* renamed from: a_ */
        void mo796a_(C0416c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0416c<K, V> mo772a(K k) {
        C0416c<K, V> cVar = this.f835a;
        while (cVar != null && !cVar.f839a.equals(k)) {
            cVar = cVar.f841c;
        }
        return cVar;
    }

    /* renamed from: a */
    public V mo773a(K k, V v) {
        C0416c a = mo772a(k);
        if (a != null) {
            return a.f840b;
        }
        mo778b(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0416c<K, V> mo778b(K k, V v) {
        C0416c<K, V> cVar = new C0416c<>(k, v);
        this.f838d++;
        if (this.f836b == null) {
            this.f835a = cVar;
            this.f836b = this.f835a;
            return cVar;
        }
        this.f836b.f841c = cVar;
        cVar.f842d = this.f836b;
        this.f836b = cVar;
        return cVar;
    }

    /* renamed from: b */
    public V mo774b(K k) {
        C0416c a = mo772a(k);
        if (a == null) {
            return null;
        }
        this.f838d--;
        if (!this.f837c.isEmpty()) {
            for (C0419f a_ : this.f837c.keySet()) {
                a_.mo796a_(a);
            }
        }
        if (a.f842d != null) {
            a.f842d.f841c = a.f841c;
        } else {
            this.f835a = a.f841c;
        }
        if (a.f841c != null) {
            a.f841c.f842d = a.f842d;
        } else {
            this.f836b = a.f842d;
        }
        a.f841c = null;
        a.f842d = null;
        return a.f840b;
    }

    /* renamed from: a */
    public int mo777a() {
        return this.f838d;
    }

    public Iterator<Entry<K, V>> iterator() {
        C0414a aVar = new C0414a(this.f835a, this.f836b);
        this.f837c.put(aVar, Boolean.valueOf(false));
        return aVar;
    }

    /* renamed from: b */
    public Iterator<Entry<K, V>> mo779b() {
        C0415b bVar = new C0415b(this.f836b, this.f835a);
        this.f837c.put(bVar, Boolean.valueOf(false));
        return bVar;
    }

    /* renamed from: c */
    public C0417d mo780c() {
        C0417d dVar = new C0417d<>();
        this.f837c.put(dVar, Boolean.valueOf(false));
        return dVar;
    }

    /* renamed from: d */
    public Entry<K, V> mo781d() {
        return this.f835a;
    }

    /* renamed from: e */
    public Entry<K, V> mo782e() {
        return this.f836b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0413b)) {
            return false;
        }
        C0413b bVar = (C0413b) obj;
        if (mo777a() != bVar.mo777a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Entry) it.next()).hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
