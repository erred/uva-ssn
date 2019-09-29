package com.squareup.p131a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.squareup.a.e */
/* compiled from: EventProducer */
class C3013e {

    /* renamed from: a */
    final Object f7869a;

    /* renamed from: b */
    private final Method f7870b;

    /* renamed from: c */
    private final int f7871c;

    /* renamed from: d */
    private boolean f7872d = true;

    C3013e(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        } else if (method != null) {
            this.f7869a = obj;
            this.f7870b = method;
            method.setAccessible(true);
            this.f7871c = ((method.hashCode() + 31) * 31) + obj.hashCode();
        } else {
            throw new NullPointerException("EventProducer method cannot be null.");
        }
    }

    /* renamed from: a */
    public boolean mo27403a() {
        return this.f7872d;
    }

    /* renamed from: b */
    public void mo27404b() {
        this.f7872d = false;
    }

    /* renamed from: c */
    public Object mo27405c() throws InvocationTargetException {
        if (this.f7872d) {
            try {
                return this.f7870b.invoke(this.f7869a, new Object[0]);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                if (e2.getCause() instanceof Error) {
                    throw ((Error) e2.getCause());
                }
                throw e2;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(toString());
            sb.append(" has been invalidated and can no longer produce events.");
            throw new IllegalStateException(sb.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[EventProducer ");
        sb.append(this.f7870b);
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return this.f7871c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3013e eVar = (C3013e) obj;
        if (!this.f7870b.equals(eVar.f7870b) || this.f7869a != eVar.f7869a) {
            z = false;
        }
        return z;
    }
}
