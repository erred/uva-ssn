package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.internal.p134b.C3164b;
import com.twitter.sdk.android.core.internal.p134b.C3166d;
import com.twitter.sdk.android.core.internal.p134b.C3167e;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.twitter.sdk.android.core.i */
/* compiled from: PersistedSessionManager */
public class C3136i<T extends C3254k> implements C3255l<T> {

    /* renamed from: a */
    private final C3164b f8269a;

    /* renamed from: b */
    private final C3167e<T> f8270b;

    /* renamed from: c */
    private final ConcurrentHashMap<Long, T> f8271c;

    /* renamed from: d */
    private final ConcurrentHashMap<Long, C3166d<T>> f8272d;

    /* renamed from: e */
    private final C3166d<T> f8273e;

    /* renamed from: f */
    private final AtomicReference<T> f8274f;

    /* renamed from: g */
    private final String f8275g;

    /* renamed from: h */
    private volatile boolean f8276h;

    public C3136i(C3164b bVar, C3167e<T> eVar, String str, String str2) {
        this(bVar, eVar, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new C3166d(bVar, eVar, str), str2);
    }

    C3136i(C3164b bVar, C3167e<T> eVar, ConcurrentHashMap<Long, T> concurrentHashMap, ConcurrentHashMap<Long, C3166d<T>> concurrentHashMap2, C3166d<T> dVar, String str) {
        this.f8276h = true;
        this.f8269a = bVar;
        this.f8270b = eVar;
        this.f8271c = concurrentHashMap;
        this.f8272d = concurrentHashMap2;
        this.f8273e = dVar;
        this.f8274f = new AtomicReference<>();
        this.f8275g = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27623a() {
        if (this.f8276h) {
            m9173d();
        }
    }

    /* renamed from: d */
    private synchronized void m9173d() {
        if (this.f8276h) {
            m9175f();
            m9174e();
            this.f8276h = false;
        }
    }

    /* renamed from: e */
    private void m9174e() {
        for (Entry entry : this.f8269a.mo27683a().getAll().entrySet()) {
            if (mo27625a((String) entry.getKey())) {
                C3254k kVar = (C3254k) this.f8270b.mo27617b((String) entry.getValue());
                if (kVar != null) {
                    m9172a(kVar.mo27850b(), kVar, false);
                }
            }
        }
    }

    /* renamed from: f */
    private void m9175f() {
        C3254k kVar = (C3254k) this.f8273e.mo27686a();
        if (kVar != null) {
            m9172a(kVar.mo27850b(), kVar, false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo27625a(String str) {
        return str.startsWith(this.f8275g);
    }

    /* renamed from: b */
    public T mo27626b() {
        mo27623a();
        return (C3254k) this.f8274f.get();
    }

    /* renamed from: a */
    public void mo27624a(T t) {
        if (t != null) {
            mo27623a();
            m9172a(t.mo27850b(), t, true);
            return;
        }
        throw new IllegalArgumentException("Session must not be null!");
    }

    /* renamed from: a */
    public T mo27622a(long j) {
        mo27623a();
        return (C3254k) this.f8271c.get(Long.valueOf(j));
    }

    /* renamed from: c */
    public Map<Long, T> mo27628c() {
        mo27623a();
        return Collections.unmodifiableMap(this.f8271c);
    }

    /* renamed from: a */
    private void m9172a(long j, T t, boolean z) {
        this.f8271c.put(Long.valueOf(j), t);
        C3166d dVar = (C3166d) this.f8272d.get(Long.valueOf(j));
        if (dVar == null) {
            dVar = new C3166d(this.f8269a, this.f8270b, mo27627b(j));
            this.f8272d.putIfAbsent(Long.valueOf(j), dVar);
        }
        dVar.mo27687a(t);
        C3254k kVar = (C3254k) this.f8274f.get();
        if (kVar == null || kVar.mo27850b() == j || z) {
            synchronized (this) {
                this.f8274f.compareAndSet(kVar, t);
                this.f8273e.mo27687a(t);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo27627b(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8275g);
        sb.append("_");
        sb.append(j);
        return sb.toString();
    }

    /* renamed from: c */
    public void mo27629c(long j) {
        mo27623a();
        if (this.f8274f.get() != null && ((C3254k) this.f8274f.get()).mo27850b() == j) {
            synchronized (this) {
                this.f8274f.set(null);
                this.f8273e.mo27688b();
            }
        }
        this.f8271c.remove(Long.valueOf(j));
        C3166d dVar = (C3166d) this.f8272d.remove(Long.valueOf(j));
        if (dVar != null) {
            dVar.mo27688b();
        }
    }
}
