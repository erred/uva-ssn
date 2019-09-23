package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3068t.C3075e;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.squareup.picasso.a */
/* compiled from: Action */
abstract class C3021a<T> {

    /* renamed from: a */
    final C3068t f7877a;

    /* renamed from: b */
    final C3081w f7878b;

    /* renamed from: c */
    final WeakReference<T> f7879c;

    /* renamed from: d */
    final boolean f7880d;

    /* renamed from: e */
    final int f7881e;

    /* renamed from: f */
    final int f7882f;

    /* renamed from: g */
    final int f7883g;

    /* renamed from: h */
    final Drawable f7884h;

    /* renamed from: i */
    final String f7885i;

    /* renamed from: j */
    final Object f7886j;

    /* renamed from: k */
    boolean f7887k;

    /* renamed from: l */
    boolean f7888l;

    /* renamed from: com.squareup.picasso.a$a */
    /* compiled from: Action */
    static class C3022a<M> extends WeakReference<M> {

        /* renamed from: a */
        final C3021a f7889a;

        C3022a(C3021a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f7889a = aVar;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo27419a(Bitmap bitmap, C3074d dVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo27420a(Exception exc);

    C3021a(C3068t tVar, T t, C3081w wVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        WeakReference<T> weakReference;
        this.f7877a = tVar;
        this.f7878b = wVar;
        if (t == null) {
            weakReference = null;
        } else {
            weakReference = new C3022a<>(this, t, tVar.f8027i);
        }
        this.f7879c = weakReference;
        this.f7881e = i;
        this.f7882f = i2;
        this.f7880d = z;
        this.f7883g = i3;
        this.f7884h = drawable;
        this.f7885i = str;
        if (obj == 0) {
            obj = this;
        }
        this.f7886j = obj;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27418a() {
        this.f7888l = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3081w mo27421b() {
        return this.f7878b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public T mo27422c() {
        if (this.f7879c == null) {
            return null;
        }
        return this.f7879c.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo27423d() {
        return this.f7885i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo27424e() {
        return this.f7888l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo27425f() {
        return this.f7887k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo27426g() {
        return this.f7881e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo27427h() {
        return this.f7882f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C3068t mo27428i() {
        return this.f7877a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public C3075e mo27429j() {
        return this.f7878b.f8089t;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public Object mo27430k() {
        return this.f7886j;
    }
}
