package androidx.p043a.p044a.p046b;

import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: androidx.a.a.b.a */
/* compiled from: FastSafeIterableMap */
public class C0412a<K, V> extends C0413b<K, V> {

    /* renamed from: b */
    private HashMap<K, C0416c<K, V>> f834b = new HashMap<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0416c<K, V> mo772a(K k) {
        return (C0416c) this.f834b.get(k);
    }

    /* renamed from: a */
    public V mo773a(K k, V v) {
        C0416c a = mo772a(k);
        if (a != null) {
            return a.f840b;
        }
        this.f834b.put(k, mo778b(k, v));
        return null;
    }

    /* renamed from: b */
    public V mo774b(K k) {
        V b = super.mo774b(k);
        this.f834b.remove(k);
        return b;
    }

    /* renamed from: c */
    public boolean mo775c(K k) {
        return this.f834b.containsKey(k);
    }

    /* renamed from: d */
    public Entry<K, V> mo776d(K k) {
        if (mo775c(k)) {
            return ((C0416c) this.f834b.get(k)).f842d;
        }
        return null;
    }
}
