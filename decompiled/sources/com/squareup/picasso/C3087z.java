package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3085y.C3086a;
import java.io.IOException;

/* renamed from: com.squareup.picasso.z */
/* compiled from: ResourceRequestHandler */
class C3087z extends C3085y {

    /* renamed from: a */
    private final Context f8124a;

    C3087z(Context context) {
        this.f8124a = context;
    }

    /* renamed from: a */
    public boolean mo27455a(C3081w wVar) {
        if (wVar.f8074e != 0) {
            return true;
        }
        return "android.resource".equals(wVar.f8073d.getScheme());
    }

    /* renamed from: a */
    public C3086a mo27454a(C3081w wVar, int i) throws IOException {
        Resources a = C3030af.m8934a(this.f8124a, wVar);
        return new C3086a(m9121a(a, C3030af.m8931a(a, wVar), wVar), C3074d.DISK);
    }

    /* renamed from: a */
    private static Bitmap m9121a(Resources resources, int i, C3081w wVar) {
        Options c = m9111c(wVar);
        if (m9110a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            m9109a(wVar.f8077h, wVar.f8078i, c, wVar);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }
}
