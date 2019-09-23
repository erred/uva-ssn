package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import com.twitter.sdk.android.core.C3256m;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.twitter.sdk.android.core.identity.b */
/* compiled from: AuthState */
class C3138b {

    /* renamed from: a */
    final AtomicReference<C3137a> f8283a = new AtomicReference<>(null);

    C3138b() {
    }

    /* renamed from: a */
    public boolean mo27639a(Activity activity, C3137a aVar) {
        if (mo27640b()) {
            C3256m.m9537g().mo27610b("Twitter", "Authorize already in progress");
        } else if (aVar.mo27636a(activity)) {
            boolean compareAndSet = this.f8283a.compareAndSet(null, aVar);
            if (compareAndSet) {
                return compareAndSet;
            }
            C3256m.m9537g().mo27610b("Twitter", "Failed to update authHandler, authorize already in progress.");
            return compareAndSet;
        }
        return false;
    }

    /* renamed from: a */
    public void mo27638a() {
        this.f8283a.set(null);
    }

    /* renamed from: b */
    public boolean mo27640b() {
        return this.f8283a.get() != null;
    }

    /* renamed from: c */
    public C3137a mo27641c() {
        return (C3137a) this.f8283a.get();
    }
}
