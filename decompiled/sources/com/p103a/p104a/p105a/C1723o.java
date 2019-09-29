package com.p103a.p104a.p105a;

import android.content.Context;
import java.io.IOException;
import java.util.UUID;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;
import p000a.p001a.p002a.p003a.p004a.p009d.C0076b;
import p000a.p001a.p002a.p003a.p004a.p009d.C0079c;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* renamed from: com.a.a.a.o */
/* compiled from: SessionAnalyticsFilesManager */
class C1723o extends C0076b<C1727s> {

    /* renamed from: g */
    private C0108b f5394g;

    C1723o(Context context, C1732u uVar, C0025k kVar, C0079c cVar) throws IOException {
        super(context, uVar, kVar, cVar, 100);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo156a() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append("sa");
        sb.append("_");
        sb.append(randomUUID.toString());
        sb.append("_");
        sb.append(this.f159c.mo49a());
        sb.append(".tap");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo160b() {
        return this.f5394g == null ? super.mo160b() : this.f5394g.f222e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo161c() {
        return this.f5394g == null ? super.mo161c() : this.f5394g.f220c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6980a(C0108b bVar) {
        this.f5394g = bVar;
    }
}
