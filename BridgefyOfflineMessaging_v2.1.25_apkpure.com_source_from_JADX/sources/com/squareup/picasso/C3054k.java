package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import androidx.p074d.p075a.C1036a;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3085y.C3086a;
import java.io.IOException;
import p102c.C1683l;

/* renamed from: com.squareup.picasso.k */
/* compiled from: FileRequestHandler */
class C3054k extends C3046g {
    C3054k(Context context) {
        super(context);
    }

    /* renamed from: a */
    public boolean mo27455a(C3081w wVar) {
        return "file".equals(wVar.f8073d.getScheme());
    }

    /* renamed from: a */
    public C3086a mo27454a(C3081w wVar, int i) throws IOException {
        return new C3086a(null, C1683l.m7039a(mo27486b(wVar)), C3074d.DISK, m9025a(wVar.f8073d));
    }

    /* renamed from: a */
    static int m9025a(Uri uri) throws IOException {
        return new C1036a(uri.getPath()).mo4024a("Orientation", 1);
    }
}
