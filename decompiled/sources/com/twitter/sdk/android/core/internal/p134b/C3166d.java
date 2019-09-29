package com.twitter.sdk.android.core.internal.p134b;

import android.annotation.SuppressLint;

/* renamed from: com.twitter.sdk.android.core.internal.b.d */
/* compiled from: PreferenceStoreStrategy */
public class C3166d<T> {

    /* renamed from: a */
    private final C3164b f8316a;

    /* renamed from: b */
    private final C3167e<T> f8317b;

    /* renamed from: c */
    private final String f8318c;

    public C3166d(C3164b bVar, C3167e<T> eVar, String str) {
        this.f8316a = bVar;
        this.f8317b = eVar;
        this.f8318c = str;
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public void mo27687a(T t) {
        this.f8316a.mo27684a(this.f8316a.mo27685b().putString(this.f8318c, this.f8317b.mo27616a(t)));
    }

    /* renamed from: a */
    public T mo27686a() {
        return this.f8317b.mo27617b(this.f8316a.mo27683a().getString(this.f8318c, null));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void mo27688b() {
        this.f8316a.mo27685b().remove(this.f8318c).commit();
    }
}
