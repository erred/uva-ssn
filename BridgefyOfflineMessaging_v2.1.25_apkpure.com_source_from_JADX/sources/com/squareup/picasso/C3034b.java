package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3085y.C3086a;
import java.io.IOException;
import p102c.C1683l;

/* renamed from: com.squareup.picasso.b */
/* compiled from: AssetRequestHandler */
class C3034b extends C3085y {

    /* renamed from: a */
    private static final int f7924a = "file:///android_asset/".length();

    /* renamed from: b */
    private final Context f7925b;

    /* renamed from: c */
    private final Object f7926c = new Object();

    /* renamed from: d */
    private AssetManager f7927d;

    C3034b(Context context) {
        this.f7925b = context;
    }

    /* renamed from: a */
    public boolean mo27455a(C3081w wVar) {
        Uri uri = wVar.f8073d;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public C3086a mo27454a(C3081w wVar, int i) throws IOException {
        if (this.f7927d == null) {
            synchronized (this.f7926c) {
                if (this.f7927d == null) {
                    this.f7927d = this.f7925b.getAssets();
                }
            }
        }
        return new C3086a(C1683l.m7039a(this.f7927d.open(m8951b(wVar))), C3074d.DISK);
    }

    /* renamed from: b */
    static String m8951b(C3081w wVar) {
        return wVar.f8073d.toString().substring(f7924a);
    }
}
