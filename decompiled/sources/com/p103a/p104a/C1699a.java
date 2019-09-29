package com.p103a.p104a;

import com.p103a.p104a.p105a.C1700a;
import com.p103a.p104a.p106b.C1738c;
import com.p103a.p104a.p107c.C1814i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.C0147j;

/* renamed from: com.a.a.a */
/* compiled from: Crashlytics */
public class C1699a extends C0146i<Void> implements C0147j {

    /* renamed from: a */
    public final C1700a f5339a;

    /* renamed from: b */
    public final C1738c f5340b;

    /* renamed from: c */
    public final C1814i f5341c;

    /* renamed from: d */
    public final Collection<? extends C0146i> f5342d;

    /* renamed from: a */
    public String mo309a() {
        return "2.6.8.dev";
    }

    /* renamed from: b */
    public String mo312b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Void mo317e() {
        return null;
    }

    public C1699a() {
        this(new C1700a(), new C1738c(), new C1814i());
    }

    C1699a(C1700a aVar, C1738c cVar, C1814i iVar) {
        this.f5339a = aVar;
        this.f5340b = cVar;
        this.f5341c = iVar;
        this.f5342d = Collections.unmodifiableCollection(Arrays.asList(new C0146i[]{aVar, cVar, iVar}));
    }

    /* renamed from: c */
    public Collection<? extends C0146i> mo325c() {
        return this.f5342d;
    }
}
