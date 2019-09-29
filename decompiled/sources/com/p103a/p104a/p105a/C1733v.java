package com.p103a.p104a.p105a;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o.C0033a;

/* renamed from: com.a.a.a.v */
/* compiled from: SessionMetadataCollector */
class C1733v {

    /* renamed from: a */
    private final Context f5439a;

    /* renamed from: b */
    private final C0032o f5440b;

    /* renamed from: c */
    private final String f5441c;

    /* renamed from: d */
    private final String f5442d;

    public C1733v(Context context, C0032o oVar, String str, String str2) {
        this.f5439a = context;
        this.f5440b = oVar;
        this.f5441c = str;
        this.f5442d = str2;
    }

    /* renamed from: a */
    public C1731t mo6995a() {
        Map i = this.f5440b.mo62i();
        C1731t tVar = new C1731t(this.f5440b.mo56c(), UUID.randomUUID().toString(), this.f5440b.mo55b(), (String) i.get(C0033a.ANDROID_ID), (String) i.get(C0033a.ANDROID_ADVERTISING_ID), this.f5440b.mo65l(), (String) i.get(C0033a.FONT_TOKEN), C0020i.m92m(this.f5439a), this.f5440b.mo57d(), this.f5440b.mo60g(), this.f5441c, this.f5442d);
        return tVar;
    }
}
