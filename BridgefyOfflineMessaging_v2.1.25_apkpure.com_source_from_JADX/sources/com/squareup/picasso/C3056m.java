package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/* renamed from: com.squareup.picasso.m */
/* compiled from: LruCache */
public final class C3056m implements C3042d {

    /* renamed from: b */
    final LruCache<String, C3058a> f7984b;

    /* renamed from: com.squareup.picasso.m$a */
    /* compiled from: LruCache */
    static final class C3058a {

        /* renamed from: a */
        final Bitmap f7986a;

        /* renamed from: b */
        final int f7987b;

        C3058a(Bitmap bitmap, int i) {
            this.f7986a = bitmap;
            this.f7987b = i;
        }
    }

    public C3056m(Context context) {
        this(C3030af.m8947b(context));
    }

    public C3056m(int i) {
        this.f7984b = new LruCache<String, C3058a>(i) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int sizeOf(String str, C3058a aVar) {
                return aVar.f7987b;
            }
        };
    }

    /* renamed from: a */
    public Bitmap mo27481a(String str) {
        C3058a aVar = (C3058a) this.f7984b.get(str);
        if (aVar != null) {
            return aVar.f7986a;
        }
        return null;
    }

    /* renamed from: a */
    public void mo27482a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int a = C3030af.m8932a(bitmap);
        if (a > mo27483b()) {
            this.f7984b.remove(str);
        } else {
            this.f7984b.put(str, new C3058a(bitmap, a));
        }
    }

    /* renamed from: a */
    public int mo27480a() {
        return this.f7984b.size();
    }

    /* renamed from: b */
    public int mo27483b() {
        return this.f7984b.maxSize();
    }
}
