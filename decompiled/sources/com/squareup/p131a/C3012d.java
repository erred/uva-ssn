package com.squareup.p131a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.squareup.a.d */
/* compiled from: EventHandler */
class C3012d {

    /* renamed from: a */
    private final Object f7865a;

    /* renamed from: b */
    private final Method f7866b;

    /* renamed from: c */
    private final int f7867c;

    /* renamed from: d */
    private boolean f7868d = true;

    C3012d(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventHandler target cannot be null.");
        } else if (method != null) {
            this.f7865a = obj;
            this.f7866b = method;
            method.setAccessible(true);
            this.f7867c = ((method.hashCode() + 31) * 31) + obj.hashCode();
        } else {
            throw new NullPointerException("EventHandler method cannot be null.");
        }
    }

    /* renamed from: a */
    public boolean mo27398a() {
        return this.f7868d;
    }

    /* renamed from: b */
    public void mo27399b() {
        this.f7868d = false;
    }

    /* renamed from: a */
    public void mo27397a(Object obj) throws InvocationTargetException {
        if (this.f7868d) {
            try {
                this.f7866b.invoke(this.f7865a, new Object[]{obj});
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
            sb.append(" has been invalidated and can no longer handle events.");
            throw new IllegalStateException(sb.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[EventHandler ");
        sb.append(this.f7866b);
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return this.f7867c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3012d dVar = (C3012d) obj;
        if (!this.f7866b.equals(dVar.f7866b) || this.f7865a != dVar.f7865a) {
            z = false;
        }
        return z;
    }
}
