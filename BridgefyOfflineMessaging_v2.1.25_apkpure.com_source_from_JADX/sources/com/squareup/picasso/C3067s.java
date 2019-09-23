package com.squareup.picasso;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1605c;
import p091b.C1614e.C1615a;
import p091b.C1651x;
import p091b.C1651x.C1653a;

/* renamed from: com.squareup.picasso.s */
/* compiled from: OkHttp3Downloader */
public final class C3067s implements C3053j {

    /* renamed from: a */
    final C1615a f8016a;

    /* renamed from: b */
    private final C1605c f8017b;

    /* renamed from: c */
    private boolean f8018c;

    public C3067s(Context context) {
        this(C3030af.m8935a(context));
    }

    public C3067s(File file) {
        this(file, C3030af.m8933a(file));
    }

    public C3067s(File file, long j) {
        this(new C1653a().mo6732a(new C1605c(file, j)).mo6735a());
        this.f8018c = false;
    }

    public C3067s(C1651x xVar) {
        this.f8018c = true;
        this.f8016a = xVar;
        this.f8017b = xVar.mo6712h();
    }

    /* renamed from: a */
    public C1596ac mo27513a(C1590aa aaVar) throws IOException {
        return this.f8016a.mo6555a(aaVar).mo6552a();
    }
}
