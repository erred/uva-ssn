package com.twitter.sdk.android.core;

import p136d.C3380b;
import p136d.C3406d;
import p136d.C3445l;

/* renamed from: com.twitter.sdk.android.core.c */
/* compiled from: Callback */
public abstract class C3128c<T> implements C3406d<T> {
    /* renamed from: a */
    public abstract void mo11811a(C3253j<T> jVar);

    /* renamed from: a */
    public abstract void mo11812a(C3272w wVar);

    /* renamed from: a */
    public final void mo27603a(C3380b<T> bVar, C3445l<T> lVar) {
        if (lVar.mo28271c()) {
            mo11811a(new C3253j<>(lVar.mo28272d(), lVar));
        } else {
            mo11812a((C3272w) new C3258o(lVar));
        }
    }

    /* renamed from: a */
    public final void mo27604a(C3380b<T> bVar, Throwable th) {
        mo11812a(new C3272w("Request Failure", th));
    }
}
