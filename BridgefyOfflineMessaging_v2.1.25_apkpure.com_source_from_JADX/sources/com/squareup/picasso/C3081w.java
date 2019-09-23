package com.squareup.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.picasso.C3068t.C3075e;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.squareup.picasso.w */
/* compiled from: Request */
public final class C3081w {

    /* renamed from: u */
    private static final long f8069u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a */
    int f8070a;

    /* renamed from: b */
    long f8071b;

    /* renamed from: c */
    int f8072c;

    /* renamed from: d */
    public final Uri f8073d;

    /* renamed from: e */
    public final int f8074e;

    /* renamed from: f */
    public final String f8075f;

    /* renamed from: g */
    public final List<C3029ae> f8076g;

    /* renamed from: h */
    public final int f8077h;

    /* renamed from: i */
    public final int f8078i;

    /* renamed from: j */
    public final boolean f8079j;

    /* renamed from: k */
    public final int f8080k;

    /* renamed from: l */
    public final boolean f8081l;

    /* renamed from: m */
    public final boolean f8082m;

    /* renamed from: n */
    public final float f8083n;

    /* renamed from: o */
    public final float f8084o;

    /* renamed from: p */
    public final float f8085p;

    /* renamed from: q */
    public final boolean f8086q;

    /* renamed from: r */
    public final boolean f8087r;

    /* renamed from: s */
    public final Config f8088s;

    /* renamed from: t */
    public final C3075e f8089t;

    /* renamed from: com.squareup.picasso.w$a */
    /* compiled from: Request */
    public static final class C3083a {

        /* renamed from: a */
        private Uri f8090a;

        /* renamed from: b */
        private int f8091b;

        /* renamed from: c */
        private String f8092c;

        /* renamed from: d */
        private int f8093d;

        /* renamed from: e */
        private int f8094e;

        /* renamed from: f */
        private boolean f8095f;

        /* renamed from: g */
        private int f8096g;

        /* renamed from: h */
        private boolean f8097h;

        /* renamed from: i */
        private boolean f8098i;

        /* renamed from: j */
        private float f8099j;

        /* renamed from: k */
        private float f8100k;

        /* renamed from: l */
        private float f8101l;

        /* renamed from: m */
        private boolean f8102m;

        /* renamed from: n */
        private boolean f8103n;

        /* renamed from: o */
        private List<C3029ae> f8104o;

        /* renamed from: p */
        private Config f8105p;

        /* renamed from: q */
        private C3075e f8106q;

        C3083a(Uri uri, int i, Config config) {
            this.f8090a = uri;
            this.f8091b = i;
            this.f8105p = config;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo27568a() {
            return (this.f8090a == null && this.f8091b == 0) ? false : true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo27569b() {
            return (this.f8093d == 0 && this.f8094e == 0) ? false : true;
        }

        /* renamed from: a */
        public C3083a mo27567a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f8093d = i;
                this.f8094e = i2;
                return this;
            }
        }

        /* renamed from: a */
        public C3083a mo27566a(int i) {
            if (!this.f8097h) {
                this.f8095f = true;
                this.f8096g = i;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        /* renamed from: c */
        public C3081w mo27570c() {
            if (this.f8097h && this.f8095f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f8095f && this.f8093d == 0 && this.f8094e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (this.f8097h && this.f8093d == 0 && this.f8094e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.f8106q == null) {
                    this.f8106q = C3075e.NORMAL;
                }
                C3081w wVar = r2;
                C3081w wVar2 = new C3081w(this.f8090a, this.f8091b, this.f8092c, this.f8104o, this.f8093d, this.f8094e, this.f8095f, this.f8097h, this.f8096g, this.f8098i, this.f8099j, this.f8100k, this.f8101l, this.f8102m, this.f8103n, this.f8105p, this.f8106q);
                return wVar;
            }
        }
    }

    private C3081w(Uri uri, int i, String str, List<C3029ae> list, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, float f, float f2, float f3, boolean z4, boolean z5, Config config, C3075e eVar) {
        this.f8073d = uri;
        this.f8074e = i;
        this.f8075f = str;
        if (list == null) {
            this.f8076g = null;
        } else {
            this.f8076g = Collections.unmodifiableList(list);
        }
        this.f8077h = i2;
        this.f8078i = i3;
        this.f8079j = z;
        this.f8081l = z2;
        this.f8080k = i4;
        this.f8082m = z3;
        this.f8083n = f;
        this.f8084o = f2;
        this.f8085p = f3;
        this.f8086q = z4;
        this.f8087r = z5;
        this.f8088s = config;
        this.f8089t = eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        if (this.f8074e > 0) {
            sb.append(this.f8074e);
        } else {
            sb.append(this.f8073d);
        }
        if (this.f8076g != null && !this.f8076g.isEmpty()) {
            for (C3029ae aeVar : this.f8076g) {
                sb.append(' ');
                sb.append(aeVar.mo27450a());
            }
        }
        if (this.f8075f != null) {
            sb.append(" stableKey(");
            sb.append(this.f8075f);
            sb.append(')');
        }
        if (this.f8077h > 0) {
            sb.append(" resize(");
            sb.append(this.f8077h);
            sb.append(',');
            sb.append(this.f8078i);
            sb.append(')');
        }
        if (this.f8079j) {
            sb.append(" centerCrop");
        }
        if (this.f8081l) {
            sb.append(" centerInside");
        }
        if (this.f8083n != BitmapDescriptorFactory.HUE_RED) {
            sb.append(" rotation(");
            sb.append(this.f8083n);
            if (this.f8086q) {
                sb.append(" @ ");
                sb.append(this.f8084o);
                sb.append(',');
                sb.append(this.f8085p);
            }
            sb.append(')');
        }
        if (this.f8087r) {
            sb.append(" purgeable");
        }
        if (this.f8088s != null) {
            sb.append(' ');
            sb.append(this.f8088s);
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27558a() {
        long nanoTime = System.nanoTime() - this.f8071b;
        if (nanoTime > f8069u) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo27559b());
            sb.append('+');
            sb.append(TimeUnit.NANOSECONDS.toSeconds(nanoTime));
            sb.append('s');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo27559b());
        sb2.append('+');
        sb2.append(TimeUnit.NANOSECONDS.toMillis(nanoTime));
        sb2.append("ms");
        return sb2.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo27559b() {
        StringBuilder sb = new StringBuilder();
        sb.append("[R");
        sb.append(this.f8070a);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo27560c() {
        if (this.f8073d != null) {
            return String.valueOf(this.f8073d.getPath());
        }
        return Integer.toHexString(this.f8074e);
    }

    /* renamed from: d */
    public boolean mo27561d() {
        return (this.f8077h == 0 && this.f8078i == 0) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo27562e() {
        return mo27563f() || mo27564g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo27563f() {
        return mo27561d() || this.f8083n != BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo27564g() {
        return this.f8076g != null;
    }
}
