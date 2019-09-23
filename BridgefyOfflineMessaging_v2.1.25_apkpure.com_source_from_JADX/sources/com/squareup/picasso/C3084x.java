package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.widget.ImageView;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3081w.C3083a;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.squareup.picasso.x */
/* compiled from: RequestCreator */
public class C3084x {

    /* renamed from: a */
    private static final AtomicInteger f8107a = new AtomicInteger();

    /* renamed from: b */
    private final C3068t f8108b;

    /* renamed from: c */
    private final C3083a f8109c;

    /* renamed from: d */
    private boolean f8110d;

    /* renamed from: e */
    private boolean f8111e;

    /* renamed from: f */
    private boolean f8112f;

    /* renamed from: g */
    private int f8113g;

    /* renamed from: h */
    private int f8114h;

    /* renamed from: i */
    private int f8115i;

    /* renamed from: j */
    private int f8116j;

    /* renamed from: k */
    private Drawable f8117k;

    /* renamed from: l */
    private Drawable f8118l;

    /* renamed from: m */
    private Object f8119m;

    C3084x(C3068t tVar, Uri uri, int i) {
        this.f8112f = true;
        if (!tVar.f8031m) {
            this.f8108b = tVar;
            this.f8109c = new C3083a(uri, i, tVar.f8028j);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    C3084x() {
        this.f8112f = true;
        this.f8108b = null;
        this.f8109c = new C3083a(null, 0, null);
    }

    /* renamed from: a */
    public C3084x mo27572a(int i) {
        if (!this.f8112f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.f8117k == null) {
            this.f8113g = i;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    /* renamed from: a */
    public C3084x mo27574a(Drawable drawable) {
        if (!this.f8112f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.f8113g == 0) {
            this.f8117k = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    /* renamed from: b */
    public C3084x mo27579b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.f8118l == null) {
            this.f8114h = i;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    /* renamed from: a */
    public C3084x mo27571a() {
        this.f8111e = true;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3084x mo27578b() {
        this.f8111e = false;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C3084x mo27580c() {
        this.f8119m = null;
        return this;
    }

    /* renamed from: a */
    public C3084x mo27573a(int i, int i2) {
        this.f8109c.mo27567a(i, i2);
        return this;
    }

    /* renamed from: d */
    public C3084x mo27581d() {
        this.f8109c.mo27566a(17);
        return this;
    }

    /* renamed from: a */
    public void mo27577a(C3027ac acVar) {
        long nanoTime = System.nanoTime();
        C3030af.m8942a();
        if (acVar == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f8111e) {
            Drawable drawable = null;
            if (!this.f8109c.mo27568a()) {
                this.f8108b.mo27538a(acVar);
                if (this.f8112f) {
                    drawable = m9096e();
                }
                acVar.mo27447a(drawable);
                return;
            }
            C3081w a = m9095a(nanoTime);
            String a2 = C3030af.m8940a(a);
            if (C3062p.m9045a(this.f8115i)) {
                Bitmap b = this.f8108b.mo27541b(a2);
                if (b != null) {
                    this.f8108b.mo27538a(acVar);
                    acVar.mo27446a(b, C3074d.MEMORY);
                    return;
                }
            }
            if (this.f8112f) {
                drawable = m9096e();
            }
            acVar.mo27447a(drawable);
            C3028ad adVar = new C3028ad(this.f8108b, acVar, a, this.f8115i, this.f8116j, this.f8118l, a2, this.f8119m, this.f8114h);
            this.f8108b.mo27537a((C3021a) adVar);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    /* renamed from: a */
    public void mo27575a(ImageView imageView) {
        mo27576a(imageView, (C3044e) null);
    }

    /* renamed from: a */
    public void mo27576a(ImageView imageView, C3044e eVar) {
        ImageView imageView2 = imageView;
        C3044e eVar2 = eVar;
        long nanoTime = System.nanoTime();
        C3030af.m8942a();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f8109c.mo27568a()) {
            this.f8108b.mo27535a(imageView2);
            if (this.f8112f) {
                C3078u.m9079a(imageView2, m9096e());
            }
        } else {
            if (this.f8111e) {
                if (!this.f8109c.mo27569b()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f8112f) {
                            C3078u.m9079a(imageView2, m9096e());
                        }
                        this.f8108b.mo27536a(imageView2, new C3047h(this, imageView2, eVar2));
                        return;
                    }
                    this.f8109c.mo27567a(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            C3081w a = m9095a(nanoTime);
            String a2 = C3030af.m8940a(a);
            if (C3062p.m9045a(this.f8115i)) {
                Bitmap b = this.f8108b.mo27541b(a2);
                if (b != null) {
                    this.f8108b.mo27535a(imageView2);
                    C3078u.m9078a(imageView, this.f8108b.f8021c, b, C3074d.MEMORY, this.f8110d, this.f8108b.f8029k);
                    if (this.f8108b.f8030l) {
                        String b2 = a.mo27559b();
                        StringBuilder sb = new StringBuilder();
                        sb.append("from ");
                        sb.append(C3074d.MEMORY);
                        C3030af.m8945a("Main", "completed", b2, sb.toString());
                    }
                    if (eVar2 != null) {
                        eVar.mo27484a();
                    }
                    return;
                }
            }
            if (this.f8112f) {
                C3078u.m9079a(imageView2, m9096e());
            }
            C3055l lVar = new C3055l(this.f8108b, imageView, a, this.f8115i, this.f8116j, this.f8114h, this.f8118l, a2, this.f8119m, eVar, this.f8110d);
            this.f8108b.mo27537a((C3021a) lVar);
        }
    }

    /* renamed from: e */
    private Drawable m9096e() {
        if (this.f8113g == 0) {
            return this.f8117k;
        }
        if (VERSION.SDK_INT >= 21) {
            return this.f8108b.f8021c.getDrawable(this.f8113g);
        }
        if (VERSION.SDK_INT >= 16) {
            return this.f8108b.f8021c.getResources().getDrawable(this.f8113g);
        }
        TypedValue typedValue = new TypedValue();
        this.f8108b.f8021c.getResources().getValue(this.f8113g, typedValue, true);
        return this.f8108b.f8021c.getResources().getDrawable(typedValue.resourceId);
    }

    /* renamed from: a */
    private C3081w m9095a(long j) {
        int andIncrement = f8107a.getAndIncrement();
        C3081w c = this.f8109c.mo27570c();
        c.f8070a = andIncrement;
        c.f8071b = j;
        boolean z = this.f8108b.f8030l;
        if (z) {
            C3030af.m8945a("Main", "created", c.mo27559b(), c.toString());
        }
        C3081w a = this.f8108b.mo27531a(c);
        if (a != c) {
            a.f8070a = andIncrement;
            a.f8071b = j;
            if (z) {
                String a2 = a.mo27558a();
                StringBuilder sb = new StringBuilder();
                sb.append("into ");
                sb.append(a);
                C3030af.m8945a("Main", "changed", a2, sb.toString());
            }
        }
        return a;
    }
}
