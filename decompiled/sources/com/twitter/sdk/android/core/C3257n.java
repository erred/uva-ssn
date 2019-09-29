package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.C3188n;
import com.twitter.sdk.android.core.internal.p133a.C3160e;
import com.twitter.sdk.android.core.p132a.C3105c;
import com.twitter.sdk.android.core.p132a.C3106d;
import com.twitter.sdk.android.core.p132a.C3115m;
import com.twitter.sdk.android.core.p132a.C3117n;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.concurrent.ConcurrentHashMap;
import p091b.C1651x;
import p136d.C3407e.C3408a;
import p136d.C3446m;
import p136d.C3446m.C3448a;
import p136d.p137a.p138a.C3377a;

/* renamed from: com.twitter.sdk.android.core.n */
/* compiled from: TwitterApiClient */
public class C3257n {

    /* renamed from: a */
    final ConcurrentHashMap<Class, Object> f8536a;

    /* renamed from: b */
    final C3446m f8537b;

    public C3257n() {
        this(C3160e.m9258a(C3270v.m9566a().mo27918g()), new C3188n());
    }

    public C3257n(C3274y yVar) {
        this(C3160e.m9259a((C3254k<? extends C3262s>) yVar, C3270v.m9566a().mo27914c()), new C3188n());
    }

    C3257n(C1651x xVar, C3188n nVar) {
        this.f8536a = m9545f();
        this.f8537b = m9543a(xVar, nVar);
    }

    /* renamed from: a */
    private C3446m m9543a(C1651x xVar, C3188n nVar) {
        return new C3448a().mo28288a(xVar).mo28290a(nVar.mo27712a()).mo28289a((C3408a) C3377a.m9855a(m9544e())).mo28291a();
    }

    /* renamed from: e */
    private Gson m9544e() {
        return new GsonBuilder().registerTypeAdapterFactory(new C3115m()).registerTypeAdapterFactory(new C3117n()).registerTypeAdapter(C3105c.class, new C3106d()).create();
    }

    /* renamed from: f */
    private ConcurrentHashMap m9545f() {
        return new ConcurrentHashMap();
    }

    /* renamed from: a */
    public AccountService mo27858a() {
        return (AccountService) mo27859a(AccountService.class);
    }

    /* renamed from: b */
    public FavoriteService mo27860b() {
        return (FavoriteService) mo27859a(FavoriteService.class);
    }

    /* renamed from: c */
    public StatusesService mo27861c() {
        return (StatusesService) mo27859a(StatusesService.class);
    }

    /* renamed from: d */
    public MediaService mo27862d() {
        return (MediaService) mo27859a(MediaService.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T> T mo27859a(Class<T> cls) {
        if (!this.f8536a.contains(cls)) {
            this.f8536a.putIfAbsent(cls, this.f8537b.mo28281a(cls));
        }
        return this.f8536a.get(cls);
    }
}
