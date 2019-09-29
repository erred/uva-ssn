package com.squareup.p131a;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.squareup.a.b */
/* compiled from: Bus */
public class C3007b {

    /* renamed from: a */
    private final ConcurrentMap<Class<?>, Set<C3012d>> f7851a;

    /* renamed from: b */
    private final ConcurrentMap<Class<?>, C3013e> f7852b;

    /* renamed from: c */
    private final String f7853c;

    /* renamed from: d */
    private final C3018i f7854d;

    /* renamed from: e */
    private final C3014f f7855e;

    /* renamed from: f */
    private final ThreadLocal<ConcurrentLinkedQueue<C3010a>> f7856f;

    /* renamed from: g */
    private final ThreadLocal<Boolean> f7857g;

    /* renamed from: h */
    private final ConcurrentMap<Class<?>, Set<Class<?>>> f7858h;

    /* renamed from: com.squareup.a.b$a */
    /* compiled from: Bus */
    static class C3010a {

        /* renamed from: a */
        final Object f7861a;

        /* renamed from: b */
        final C3012d f7862b;

        public C3010a(Object obj, C3012d dVar) {
            this.f7861a = obj;
            this.f7862b = dVar;
        }
    }

    public C3007b() {
        this("default");
    }

    public C3007b(String str) {
        this(C3018i.f7875b, str);
    }

    public C3007b(C3018i iVar) {
        this(iVar, "default");
    }

    public C3007b(C3018i iVar, String str) {
        this(iVar, str, C3014f.f7873a);
    }

    C3007b(C3018i iVar, String str, C3014f fVar) {
        this.f7851a = new ConcurrentHashMap();
        this.f7852b = new ConcurrentHashMap();
        this.f7856f = new ThreadLocal<ConcurrentLinkedQueue<C3010a>>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public ConcurrentLinkedQueue<C3010a> initialValue() {
                return new ConcurrentLinkedQueue<>();
            }
        };
        this.f7857g = new ThreadLocal<Boolean>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Boolean initialValue() {
                return Boolean.valueOf(false);
            }
        };
        this.f7858h = new ConcurrentHashMap();
        this.f7854d = iVar;
        this.f7853c = str;
        this.f7855e = fVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Bus \"");
        sb.append(this.f7853c);
        sb.append("\"]");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo27385a(Object obj) {
        if (obj != null) {
            this.f7854d.mo27411a(this);
            Map a = this.f7855e.mo27409a(obj);
            for (Class cls : a.keySet()) {
                C3013e eVar = (C3013e) a.get(cls);
                C3013e eVar2 = (C3013e) this.f7852b.putIfAbsent(cls, eVar);
                if (eVar2 == null) {
                    Set<C3012d> set = (Set) this.f7851a.get(cls);
                    if (set != null && !set.isEmpty()) {
                        for (C3012d a2 : set) {
                            m8870a(a2, eVar);
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Producer method for type ");
                    sb.append(cls);
                    sb.append(" found on type ");
                    sb.append(eVar.f7869a.getClass());
                    sb.append(", but already registered by type ");
                    sb.append(eVar2.f7869a.getClass());
                    sb.append(".");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            Map b = this.f7855e.mo27410b(obj);
            for (Class cls2 : b.keySet()) {
                Set set2 = (Set) this.f7851a.get(cls2);
                if (set2 == null) {
                    set2 = new CopyOnWriteArraySet();
                    Set set3 = (Set) this.f7851a.putIfAbsent(cls2, set2);
                    if (set3 != null) {
                        set2 = set3;
                    }
                }
                if (!set2.addAll((Set) b.get(cls2))) {
                    throw new IllegalArgumentException("Object already registered.");
                }
            }
            for (Entry entry : b.entrySet()) {
                C3013e eVar3 = (C3013e) this.f7852b.get((Class) entry.getKey());
                if (eVar3 != null && eVar3.mo27403a()) {
                    for (C3012d dVar : (Set) entry.getValue()) {
                        if (!eVar3.mo27403a()) {
                            break;
                        } else if (dVar.mo27398a()) {
                            m8870a(dVar, eVar3);
                        }
                    }
                }
            }
            return;
        }
        throw new NullPointerException("Object to register must not be null.");
    }

    /* renamed from: a */
    private void m8870a(C3012d dVar, C3013e eVar) {
        Object obj;
        try {
            obj = eVar.mo27405c();
        } catch (InvocationTargetException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Producer ");
            sb.append(eVar);
            sb.append(" threw an exception.");
            m8871a(sb.toString(), e);
            obj = null;
        }
        if (obj != null) {
            mo27389b(obj, dVar);
        }
    }

    /* renamed from: b */
    public void mo27388b(Object obj) {
        if (obj != null) {
            this.f7854d.mo27411a(this);
            for (Entry entry : this.f7855e.mo27409a(obj).entrySet()) {
                Class cls = (Class) entry.getKey();
                C3013e a = mo27383a(cls);
                C3013e eVar = (C3013e) entry.getValue();
                if (eVar == null || !eVar.equals(a)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Missing event producer for an annotated method. Is ");
                    sb.append(obj.getClass());
                    sb.append(" registered?");
                    throw new IllegalArgumentException(sb.toString());
                }
                ((C3013e) this.f7852b.remove(cls)).mo27404b();
            }
            for (Entry entry2 : this.f7855e.mo27410b(obj).entrySet()) {
                Set<C3012d> b = mo27387b((Class) entry2.getKey());
                Collection collection = (Collection) entry2.getValue();
                if (b == null || !b.containsAll(collection)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Missing event handler for an annotated method. Is ");
                    sb2.append(obj.getClass());
                    sb2.append(" registered?");
                    throw new IllegalArgumentException(sb2.toString());
                }
                for (C3012d dVar : b) {
                    if (collection.contains(dVar)) {
                        dVar.mo27399b();
                    }
                }
                b.removeAll(collection);
            }
            return;
        }
        throw new NullPointerException("Object to unregister must not be null.");
    }

    /* renamed from: c */
    public void mo27391c(Object obj) {
        if (obj != null) {
            this.f7854d.mo27411a(this);
            boolean z = false;
            for (Class b : mo27390c(obj.getClass())) {
                Set<C3012d> b2 = mo27387b(b);
                if (b2 != null && !b2.isEmpty()) {
                    z = true;
                    for (C3012d a : b2) {
                        mo27386a(obj, a);
                    }
                }
            }
            if (!z && !(obj instanceof C3011c)) {
                mo27391c((Object) new C3011c(this, obj));
            }
            mo27384a();
            return;
        }
        throw new NullPointerException("Event to post must not be null.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27386a(Object obj, C3012d dVar) {
        ((ConcurrentLinkedQueue) this.f7856f.get()).offer(new C3010a(obj, dVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27384a() {
        if (!((Boolean) this.f7857g.get()).booleanValue()) {
            this.f7857g.set(Boolean.valueOf(true));
            while (true) {
                try {
                    C3010a aVar = (C3010a) ((ConcurrentLinkedQueue) this.f7856f.get()).poll();
                    if (aVar != null) {
                        if (aVar.f7862b.mo27398a()) {
                            mo27389b(aVar.f7861a, aVar.f7862b);
                        }
                    } else {
                        return;
                    }
                } finally {
                    this.f7857g.set(Boolean.valueOf(false));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27389b(Object obj, C3012d dVar) {
        try {
            dVar.mo27397a(obj);
        } catch (InvocationTargetException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not dispatch event: ");
            sb.append(obj.getClass());
            sb.append(" to handler ");
            sb.append(dVar);
            m8871a(sb.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3013e mo27383a(Class<?> cls) {
        return (C3013e) this.f7852b.get(cls);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Set<C3012d> mo27387b(Class<?> cls) {
        return (Set) this.f7851a.get(cls);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Set<Class<?>> mo27390c(Class<?> cls) {
        Set<Class<?>> set = (Set) this.f7858h.get(cls);
        if (set != null) {
            return set;
        }
        Set<Class<?>> d = m8872d(cls);
        Set set2 = (Set) this.f7858h.putIfAbsent(cls, d);
        return set2 == null ? d : set2;
    }

    /* renamed from: d */
    private Set<Class<?>> m8872d(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            Class superclass = cls2.getSuperclass();
            if (superclass != null) {
                linkedList.add(superclass);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private static void m8871a(String str, InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": ");
            sb.append(cause.getMessage());
            throw new RuntimeException(sb.toString(), cause);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(": ");
        sb2.append(invocationTargetException.getMessage());
        throw new RuntimeException(sb2.toString(), invocationTargetException);
    }
}
