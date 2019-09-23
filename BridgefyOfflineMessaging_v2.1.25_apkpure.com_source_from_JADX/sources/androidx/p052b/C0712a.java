package androidx.p052b;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: androidx.b.a */
/* compiled from: ArrayMap */
public class C0712a<K, V> extends C0725g<K, V> implements Map<K, V> {

    /* renamed from: a */
    C0719f<K, V> f2055a;

    public C0712a() {
    }

    public C0712a(int i) {
        super(i);
    }

    public C0712a(C0725g gVar) {
        super(gVar);
    }

    /* renamed from: b */
    private C0719f<K, V> m2484b() {
        if (this.f2055a == null) {
            this.f2055a = new C0719f<K, V>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2749a() {
                    return C0712a.this.f2097h;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Object mo2751a(int i, int i2) {
                    return C0712a.this.f2096g[(i << 1) + i2];
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2750a(Object obj) {
                    return C0712a.this.mo2873a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public int mo2755b(Object obj) {
                    return C0712a.this.mo2878b(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Map<K, V> mo2756b() {
                    return C0712a.this;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2754a(K k, V v) {
                    C0712a.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public V mo2752a(int i, V v) {
                    return C0712a.this.mo2875a(i, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2753a(int i) {
                    C0712a.this.mo2884d(i);
                }

                /* access modifiers changed from: protected */
                /* renamed from: c */
                public void mo2757c() {
                    C0712a.this.clear();
                }
            };
        }
        return this.f2055a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        mo2876a(this.f2097h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public boolean mo2744a(Collection<?> collection) {
        return C0719f.m2535c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m2484b().mo2812d();
    }

    public Set<K> keySet() {
        return m2484b().mo2813e();
    }

    public Collection<V> values() {
        return m2484b().mo2814f();
    }
}
