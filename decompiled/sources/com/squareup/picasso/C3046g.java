package com.squareup.picasso;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3085y.C3086a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p102c.C1683l;

/* renamed from: com.squareup.picasso.g */
/* compiled from: ContentStreamRequestHandler */
class C3046g extends C3085y {

    /* renamed from: a */
    final Context f7959a;

    C3046g(Context context) {
        this.f7959a = context;
    }

    /* renamed from: a */
    public boolean mo27455a(C3081w wVar) {
        return Param.CONTENT.equals(wVar.f8073d.getScheme());
    }

    /* renamed from: a */
    public C3086a mo27454a(C3081w wVar, int i) throws IOException {
        return new C3086a(C1683l.m7039a(mo27486b(wVar)), C3074d.DISK);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public InputStream mo27486b(C3081w wVar) throws FileNotFoundException {
        return this.f7959a.getContentResolver().openInputStream(wVar.f8073d);
    }
}
