package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3068t.C3075e;
import com.squareup.picasso.C3085y.C3086a;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import p102c.C1676e;
import p102c.C1683l;
import p102c.C1695s;

/* renamed from: com.squareup.picasso.c */
/* compiled from: BitmapHunter */
class C3035c implements Runnable {

    /* renamed from: t */
    private static final Object f7928t = new Object();

    /* renamed from: u */
    private static final ThreadLocal<StringBuilder> f7929u = new ThreadLocal<StringBuilder>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };

    /* renamed from: v */
    private static final AtomicInteger f7930v = new AtomicInteger();

    /* renamed from: w */
    private static final C3085y f7931w = new C3085y() {
        /* renamed from: a */
        public boolean mo27455a(C3081w wVar) {
            return true;
        }

        /* renamed from: a */
        public C3086a mo27454a(C3081w wVar, int i) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized type of request: ");
            sb.append(wVar);
            throw new IllegalStateException(sb.toString());
        }
    };

    /* renamed from: a */
    final int f7932a = f7930v.incrementAndGet();

    /* renamed from: b */
    final C3068t f7933b;

    /* renamed from: c */
    final C3048i f7934c;

    /* renamed from: d */
    final C3042d f7935d;

    /* renamed from: e */
    final C3023aa f7936e;

    /* renamed from: f */
    final String f7937f;

    /* renamed from: g */
    final C3081w f7938g;

    /* renamed from: h */
    final int f7939h;

    /* renamed from: i */
    int f7940i;

    /* renamed from: j */
    final C3085y f7941j;

    /* renamed from: k */
    C3021a f7942k;

    /* renamed from: l */
    List<C3021a> f7943l;

    /* renamed from: m */
    Bitmap f7944m;

    /* renamed from: n */
    Future<?> f7945n;

    /* renamed from: o */
    C3074d f7946o;

    /* renamed from: p */
    Exception f7947p;

    /* renamed from: q */
    int f7948q;

    /* renamed from: r */
    int f7949r;

    /* renamed from: s */
    C3075e f7950s;

    /* renamed from: a */
    static int m8954a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    private static boolean m8960a(boolean z, int i, int i2, int i3, int i4) {
        return !z || (i3 != 0 && i > i3) || (i4 != 0 && i2 > i4);
    }

    /* renamed from: b */
    static int m8961b(int i) {
        if (!(i == 2 || i == 7)) {
            switch (i) {
                case 4:
                case 5:
                    break;
                default:
                    return 1;
            }
        }
        return -1;
    }

    C3035c(C3068t tVar, C3048i iVar, C3042d dVar, C3023aa aaVar, C3021a aVar, C3085y yVar) {
        this.f7933b = tVar;
        this.f7934c = iVar;
        this.f7935d = dVar;
        this.f7936e = aaVar;
        this.f7942k = aVar;
        this.f7937f = aVar.mo27423d();
        this.f7938g = aVar.mo27421b();
        this.f7950s = aVar.mo27429j();
        this.f7939h = aVar.mo27426g();
        this.f7940i = aVar.mo27427h();
        this.f7941j = yVar;
        this.f7949r = yVar.mo27528a();
    }

    /* renamed from: a */
    static Bitmap m8955a(C1695s sVar, C3081w wVar) throws IOException {
        C1676e a = C1683l.m7033a(sVar);
        boolean a2 = C3030af.m8946a(a);
        boolean z = wVar.f8087r && VERSION.SDK_INT < 21;
        Options c = C3085y.m9111c(wVar);
        boolean a3 = C3085y.m9110a(c);
        if (a2 || z) {
            byte[] s = a.mo6869s();
            if (a3) {
                BitmapFactory.decodeByteArray(s, 0, s.length, c);
                C3085y.m9109a(wVar.f8077h, wVar.f8078i, c, wVar);
            }
            return BitmapFactory.decodeByteArray(s, 0, s.length, c);
        }
        InputStream g = a.mo6846g();
        if (a3) {
            C3059n nVar = new C3059n(g);
            nVar.mo27518a(false);
            long a4 = nVar.mo27516a(1024);
            BitmapFactory.decodeStream(nVar, null, c);
            C3085y.m9109a(wVar.f8077h, wVar.f8078i, c, wVar);
            nVar.mo27517a(a4);
            nVar.mo27518a(true);
            g = nVar;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(g, null, c);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public void run() {
        try {
            m8959a(this.f7938g);
            if (this.f7933b.f8030l) {
                C3030af.m8944a("Hunter", "executing", C3030af.m8938a(this));
            }
            this.f7944m = mo27456a();
            if (this.f7944m == null) {
                this.f7934c.mo27505c(this);
            } else {
                this.f7934c.mo27495a(this);
            }
        } catch (C3066b e) {
            if (!C3063q.m9049c(e.f8015b) || e.f8014a != 504) {
                this.f7947p = e;
            }
            this.f7934c.mo27505c(this);
        } catch (IOException e2) {
            this.f7947p = e2;
            this.f7934c.mo27501b(this);
        } catch (OutOfMemoryError e3) {
            StringWriter stringWriter = new StringWriter();
            this.f7936e.mo27441e().mo27444a(new PrintWriter(stringWriter));
            this.f7947p = new RuntimeException(stringWriter.toString(), e3);
            this.f7934c.mo27505c(this);
        } catch (Exception e4) {
            this.f7947p = e4;
            this.f7934c.mo27505c(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Bitmap mo27456a() throws IOException {
        Bitmap bitmap;
        if (C3062p.m9045a(this.f7939h)) {
            bitmap = this.f7935d.mo27481a(this.f7937f);
            if (bitmap != null) {
                this.f7936e.mo27431a();
                this.f7946o = C3074d.MEMORY;
                if (this.f7933b.f8030l) {
                    C3030af.m8945a("Hunter", "decoded", this.f7938g.mo27558a(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        this.f7940i = this.f7949r == 0 ? C3063q.OFFLINE.f8011d : this.f7940i;
        C3086a a = this.f7941j.mo27454a(this.f7938g, this.f7940i);
        if (a != null) {
            this.f7946o = a.mo27584c();
            this.f7948q = a.mo27585d();
            bitmap = a.mo27582a();
            if (bitmap == null) {
                C1695s b = a.mo27583b();
                try {
                    bitmap = m8955a(b, this.f7938g);
                } finally {
                    try {
                        b.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.f7933b.f8030l) {
                C3030af.m8944a("Hunter", "decoded", this.f7938g.mo27558a());
            }
            this.f7936e.mo27433a(bitmap);
            if (this.f7938g.mo27562e() || this.f7948q != 0) {
                synchronized (f7928t) {
                    if (this.f7938g.mo27563f() || this.f7948q != 0) {
                        bitmap = m8956a(this.f7938g, bitmap, this.f7948q);
                        if (this.f7933b.f8030l) {
                            C3030af.m8944a("Hunter", "transformed", this.f7938g.mo27558a());
                        }
                    }
                    if (this.f7938g.mo27564g()) {
                        bitmap = m8957a(this.f7938g.f8076g, bitmap);
                        if (this.f7933b.f8030l) {
                            C3030af.m8945a("Hunter", "transformed", this.f7938g.mo27558a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f7936e.mo27437b(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27457a(C3021a aVar) {
        boolean z = this.f7933b.f8030l;
        C3081w wVar = aVar.f7878b;
        if (this.f7942k == null) {
            this.f7942k = aVar;
            if (z) {
                if (this.f7943l == null || this.f7943l.isEmpty()) {
                    C3030af.m8945a("Hunter", "joined", wVar.mo27558a(), "to empty hunter");
                } else {
                    C3030af.m8945a("Hunter", "joined", wVar.mo27558a(), C3030af.m8939a(this, "to "));
                }
            }
            return;
        }
        if (this.f7943l == null) {
            this.f7943l = new ArrayList(3);
        }
        this.f7943l.add(aVar);
        if (z) {
            C3030af.m8945a("Hunter", "joined", wVar.mo27558a(), C3030af.m8939a(this, "to "));
        }
        C3075e j = aVar.mo27429j();
        if (j.ordinal() > this.f7950s.ordinal()) {
            this.f7950s = j;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27459b(C3021a aVar) {
        boolean z;
        if (this.f7942k == aVar) {
            this.f7942k = null;
            z = true;
        } else {
            z = this.f7943l != null ? this.f7943l.remove(aVar) : false;
        }
        if (z && aVar.mo27429j() == this.f7950s) {
            this.f7950s = m8962o();
        }
        if (this.f7933b.f8030l) {
            C3030af.m8945a("Hunter", "removed", aVar.f7878b.mo27558a(), C3030af.m8939a(this, "from "));
        }
    }

    /* renamed from: o */
    private C3075e m8962o() {
        C3075e eVar = C3075e.LOW;
        boolean z = true;
        boolean z2 = this.f7943l != null && !this.f7943l.isEmpty();
        if (this.f7942k == null && !z2) {
            z = false;
        }
        if (!z) {
            return eVar;
        }
        if (this.f7942k != null) {
            eVar = this.f7942k.mo27429j();
        }
        if (z2) {
            int size = this.f7943l.size();
            for (int i = 0; i < size; i++) {
                C3075e j = ((C3021a) this.f7943l.get(i)).mo27429j();
                if (j.ordinal() > eVar.ordinal()) {
                    eVar = j;
                }
            }
        }
        return eVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo27460b() {
        if (this.f7942k != null) {
            return false;
        }
        if ((this.f7943l == null || this.f7943l.isEmpty()) && this.f7945n != null && this.f7945n.cancel(false)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo27461c() {
        return this.f7945n != null && this.f7945n.isCancelled();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo27458a(boolean z, NetworkInfo networkInfo) {
        if (!(this.f7949r > 0)) {
            return false;
        }
        this.f7949r--;
        return this.f7941j.mo27529a(z, networkInfo);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo27462d() {
        return this.f7941j.mo27530b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public Bitmap mo27463e() {
        return this.f7944m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo27464f() {
        return this.f7937f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo27465g() {
        return this.f7939h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C3081w mo27466h() {
        return this.f7938g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C3021a mo27467i() {
        return this.f7942k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public C3068t mo27468j() {
        return this.f7933b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public List<C3021a> mo27469k() {
        return this.f7943l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public Exception mo27470l() {
        return this.f7947p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public C3074d mo27471m() {
        return this.f7946o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public C3075e mo27472n() {
        return this.f7950s;
    }

    /* renamed from: a */
    static void m8959a(C3081w wVar) {
        String c = wVar.mo27560c();
        StringBuilder sb = (StringBuilder) f7929u.get();
        sb.ensureCapacity("Picasso-".length() + c.length());
        sb.replace("Picasso-".length(), sb.length(), c);
        Thread.currentThread().setName(sb.toString());
    }

    /* renamed from: a */
    static C3035c m8958a(C3068t tVar, C3048i iVar, C3042d dVar, C3023aa aaVar, C3021a aVar) {
        C3081w b = aVar.mo27421b();
        List a = tVar.mo27534a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            C3085y yVar = (C3085y) a.get(i);
            if (yVar.mo27455a(b)) {
                C3035c cVar = new C3035c(tVar, iVar, dVar, aaVar, aVar, yVar);
                return cVar;
            }
        }
        C3035c cVar2 = new C3035c(tVar, iVar, dVar, aaVar, aVar, f7931w);
        return cVar2;
    }

    /* renamed from: a */
    static Bitmap m8957a(List<C3029ae> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final C3029ae aeVar = (C3029ae) list.get(i);
            try {
                Bitmap a = aeVar.mo27449a(bitmap);
                if (a == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(aeVar.mo27450a());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (C3029ae a2 : list) {
                        sb.append(a2.mo27450a());
                        sb.append(10);
                    }
                    C3068t.f8019a.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                } else if (a == bitmap && bitmap.isRecycled()) {
                    C3068t.f8019a.post(new Runnable() {
                        public void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Transformation ");
                            sb.append(aeVar.mo27450a());
                            sb.append(" returned input Bitmap but recycled it.");
                            throw new IllegalStateException(sb.toString());
                        }
                    });
                    return null;
                } else if (a == bitmap || bitmap.isRecycled()) {
                    i++;
                    bitmap = a;
                } else {
                    C3068t.f8019a.post(new Runnable() {
                        public void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Transformation ");
                            sb.append(aeVar.mo27450a());
                            sb.append(" mutated input Bitmap but failed to recycle the original.");
                            throw new IllegalStateException(sb.toString());
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e) {
                C3068t.f8019a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Transformation ");
                        sb.append(aeVar.mo27450a());
                        sb.append(" crashed with exception.");
                        throw new RuntimeException(sb.toString(), e);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0285  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap m8956a(com.squareup.picasso.C3081w r31, android.graphics.Bitmap r32, int r33) {
        /*
            r0 = r31
            int r2 = r32.getWidth()
            int r3 = r32.getHeight()
            boolean r4 = r0.f8082m
            android.graphics.Matrix r10 = new android.graphics.Matrix
            r10.<init>()
            boolean r5 = r31.mo27563f()
            if (r5 != 0) goto L_0x001f
            if (r33 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            r4 = r3
            r1 = r10
            r3 = r2
            goto L_0x0271
        L_0x001f:
            int r5 = r0.f8077h
            int r7 = r0.f8078i
            float r8 = r0.f8083n
            r9 = 0
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 == 0) goto L_0x015d
            double r11 = (double) r8
            double r13 = java.lang.Math.toRadians(r11)
            double r13 = java.lang.Math.cos(r13)
            double r11 = java.lang.Math.toRadians(r11)
            double r11 = java.lang.Math.sin(r11)
            boolean r5 = r0.f8086q
            if (r5 == 0) goto L_0x00e4
            float r5 = r0.f8084o
            float r7 = r0.f8085p
            r10.setRotate(r8, r5, r7)
            float r5 = r0.f8084o
            double r7 = (double) r5
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r15 = r15 - r13
            double r7 = r7 * r15
            float r5 = r0.f8085p
            double r5 = (double) r5
            double r5 = r5 * r11
            double r7 = r7 + r5
            float r5 = r0.f8085p
            double r5 = (double) r5
            double r5 = r5 * r15
            float r9 = r0.f8084o
            r18 = r3
            r19 = r4
            double r3 = (double) r9
            double r3 = r3 * r11
            double r5 = r5 - r3
            int r3 = r0.f8077h
            double r3 = (double) r3
            double r3 = r3 * r13
            double r3 = r3 + r7
            int r9 = r0.f8077h
            r20 = r2
            double r1 = (double) r9
            double r1 = r1 * r11
            double r1 = r1 + r5
            int r9 = r0.f8077h
            r21 = r10
            double r9 = (double) r9
            double r9 = r9 * r13
            double r9 = r9 + r7
            int r15 = r0.f8078i
            r22 = r1
            double r1 = (double) r15
            double r1 = r1 * r11
            double r9 = r9 - r1
            int r1 = r0.f8077h
            double r1 = (double) r1
            double r1 = r1 * r11
            double r1 = r1 + r5
            int r15 = r0.f8078i
            r24 = r9
            double r9 = (double) r15
            double r9 = r9 * r13
            double r1 = r1 + r9
            int r9 = r0.f8078i
            double r9 = (double) r9
            double r9 = r9 * r11
            double r9 = r7 - r9
            int r11 = r0.f8078i
            double r11 = (double) r11
            double r11 = r11 * r13
            double r11 = r11 + r5
            double r13 = java.lang.Math.max(r7, r3)
            r26 = r11
            r11 = r24
            double r13 = java.lang.Math.max(r11, r13)
            double r13 = java.lang.Math.max(r9, r13)
            double r3 = java.lang.Math.min(r7, r3)
            double r3 = java.lang.Math.min(r11, r3)
            double r3 = java.lang.Math.min(r9, r3)
            r7 = r22
            double r9 = java.lang.Math.max(r5, r7)
            double r9 = java.lang.Math.max(r1, r9)
            r11 = r26
            double r9 = java.lang.Math.max(r11, r9)
            double r5 = java.lang.Math.min(r5, r7)
            double r1 = java.lang.Math.min(r1, r5)
            double r1 = java.lang.Math.min(r11, r1)
            double r13 = r13 - r3
            double r3 = java.lang.Math.floor(r13)
            int r5 = (int) r3
            double r9 = r9 - r1
            double r1 = java.lang.Math.floor(r9)
            int r7 = (int) r1
            r1 = r21
            goto L_0x0164
        L_0x00e4:
            r20 = r2
            r18 = r3
            r19 = r4
            r1 = r10
            r1.setRotate(r8)
            int r2 = r0.f8077h
            double r2 = (double) r2
            double r2 = r2 * r13
            int r4 = r0.f8077h
            double r4 = (double) r4
            double r4 = r4 * r11
            int r6 = r0.f8077h
            double r6 = (double) r6
            double r6 = r6 * r13
            int r8 = r0.f8078i
            double r8 = (double) r8
            double r8 = r8 * r11
            double r6 = r6 - r8
            int r8 = r0.f8077h
            double r8 = (double) r8
            double r8 = r8 * r11
            int r10 = r0.f8078i
            r28 = r4
            double r4 = (double) r10
            double r4 = r4 * r13
            double r8 = r8 + r4
            int r4 = r0.f8078i
            double r4 = (double) r4
            double r4 = r4 * r11
            double r4 = -r4
            int r10 = r0.f8078i
            double r10 = (double) r10
            double r10 = r10 * r13
            r12 = 0
            double r14 = java.lang.Math.max(r12, r2)
            double r14 = java.lang.Math.max(r6, r14)
            double r14 = java.lang.Math.max(r4, r14)
            double r2 = java.lang.Math.min(r12, r2)
            double r2 = java.lang.Math.min(r6, r2)
            double r2 = java.lang.Math.min(r4, r2)
            r4 = r28
            double r6 = java.lang.Math.max(r12, r4)
            double r6 = java.lang.Math.max(r8, r6)
            double r6 = java.lang.Math.max(r10, r6)
            double r4 = java.lang.Math.min(r12, r4)
            double r4 = java.lang.Math.min(r8, r4)
            double r4 = java.lang.Math.min(r10, r4)
            double r14 = r14 - r2
            double r2 = java.lang.Math.floor(r14)
            int r2 = (int) r2
            double r6 = r6 - r4
            double r3 = java.lang.Math.floor(r6)
            int r7 = (int) r3
            r5 = r2
            goto L_0x0164
        L_0x015d:
            r20 = r2
            r18 = r3
            r19 = r4
            r1 = r10
        L_0x0164:
            if (r33 == 0) goto L_0x018a
            int r3 = m8954a(r33)
            int r2 = m8961b(r33)
            if (r3 == 0) goto L_0x0181
            float r4 = (float) r3
            r1.preRotate(r4)
            r4 = 90
            if (r3 == r4) goto L_0x017c
            r4 = 270(0x10e, float:3.78E-43)
            if (r3 != r4) goto L_0x0181
        L_0x017c:
            r30 = r7
            r7 = r5
            r5 = r30
        L_0x0181:
            r3 = 1
            if (r2 == r3) goto L_0x018a
            float r2 = (float) r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r1.postScale(r2, r3)
        L_0x018a:
            boolean r2 = r0.f8079j
            if (r2 == 0) goto L_0x0222
            if (r5 == 0) goto L_0x0198
            float r2 = (float) r5
            r3 = r20
            float r4 = (float) r3
            float r2 = r2 / r4
            r4 = r18
            goto L_0x019f
        L_0x0198:
            r3 = r20
            float r2 = (float) r7
            r4 = r18
            float r6 = (float) r4
            float r2 = r2 / r6
        L_0x019f:
            if (r7 == 0) goto L_0x01a5
            float r6 = (float) r7
            float r8 = (float) r4
        L_0x01a3:
            float r6 = r6 / r8
            goto L_0x01a8
        L_0x01a5:
            float r6 = (float) r5
            float r8 = (float) r3
            goto L_0x01a3
        L_0x01a8:
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x01d8
            float r8 = (float) r4
            float r6 = r6 / r2
            float r8 = r8 * r6
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r6 = (int) r8
            int r8 = r0.f8080k
            r9 = 48
            r8 = r8 & r9
            if (r8 != r9) goto L_0x01bf
            r0 = 0
            goto L_0x01cd
        L_0x01bf:
            int r0 = r0.f8080k
            r8 = 80
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01c9
            int r0 = r4 - r6
            goto L_0x01cd
        L_0x01c9:
            int r0 = r4 - r6
            int r0 = r0 / 2
        L_0x01cd:
            float r8 = (float) r7
            float r9 = (float) r6
            float r8 = r8 / r9
            r9 = r3
            r10 = r6
            r17 = 0
            r6 = r2
            r2 = r19
            goto L_0x0213
        L_0x01d8:
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x020b
            float r8 = (float) r3
            float r2 = r2 / r6
            float r8 = r8 * r2
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            int r8 = r0.f8080k
            r9 = 3
            r8 = r8 & r9
            if (r8 != r9) goto L_0x01ee
            r0 = 0
            goto L_0x01fb
        L_0x01ee:
            int r0 = r0.f8080k
            r8 = 5
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01f7
            int r0 = r3 - r2
            goto L_0x01fb
        L_0x01f7:
            int r0 = r3 - r2
            int r0 = r0 / 2
        L_0x01fb:
            float r8 = (float) r5
            float r9 = (float) r2
            float r8 = r8 / r9
            r17 = r0
            r9 = r2
            r10 = r4
            r2 = r19
            r0 = 0
            r30 = r8
            r8 = r6
            r6 = r30
            goto L_0x0213
        L_0x020b:
            r9 = r3
            r10 = r4
            r8 = r6
            r2 = r19
            r0 = 0
            r17 = 0
        L_0x0213:
            boolean r2 = m8960a(r2, r3, r4, r5, r7)
            if (r2 == 0) goto L_0x021c
            r1.preScale(r6, r8)
        L_0x021c:
            r7 = r0
            r8 = r9
            r9 = r10
            r6 = r17
            goto L_0x0275
        L_0x0222:
            r4 = r18
            r2 = r19
            r3 = r20
            boolean r0 = r0.f8081l
            if (r0 == 0) goto L_0x024e
            if (r5 == 0) goto L_0x0232
            float r0 = (float) r5
            float r6 = (float) r3
        L_0x0230:
            float r0 = r0 / r6
            goto L_0x0235
        L_0x0232:
            float r0 = (float) r7
            float r6 = (float) r4
            goto L_0x0230
        L_0x0235:
            if (r7 == 0) goto L_0x023b
            float r6 = (float) r7
            float r8 = (float) r4
        L_0x0239:
            float r6 = r6 / r8
            goto L_0x023e
        L_0x023b:
            float r6 = (float) r5
            float r8 = (float) r3
            goto L_0x0239
        L_0x023e:
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0243
            goto L_0x0244
        L_0x0243:
            r0 = r6
        L_0x0244:
            boolean r2 = m8960a(r2, r3, r4, r5, r7)
            if (r2 == 0) goto L_0x0271
            r1.preScale(r0, r0)
            goto L_0x0271
        L_0x024e:
            if (r5 != 0) goto L_0x0252
            if (r7 == 0) goto L_0x0271
        L_0x0252:
            if (r5 != r3) goto L_0x0256
            if (r7 == r4) goto L_0x0271
        L_0x0256:
            if (r5 == 0) goto L_0x025c
            float r0 = (float) r5
            float r6 = (float) r3
        L_0x025a:
            float r0 = r0 / r6
            goto L_0x025f
        L_0x025c:
            float r0 = (float) r7
            float r6 = (float) r4
            goto L_0x025a
        L_0x025f:
            if (r7 == 0) goto L_0x0265
            float r6 = (float) r7
            float r8 = (float) r4
        L_0x0263:
            float r6 = r6 / r8
            goto L_0x0268
        L_0x0265:
            float r6 = (float) r5
            float r8 = (float) r3
            goto L_0x0263
        L_0x0268:
            boolean r2 = m8960a(r2, r3, r4, r5, r7)
            if (r2 == 0) goto L_0x0271
            r1.preScale(r0, r6)
        L_0x0271:
            r8 = r3
            r9 = r4
            r6 = 0
            r7 = 0
        L_0x0275:
            r11 = 1
            r5 = r32
            r10 = r1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)
            r1 = r32
            if (r0 == r1) goto L_0x0285
            r32.recycle()
            goto L_0x0286
        L_0x0285:
            r0 = r1
        L_0x0286:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C3035c.m8956a(com.squareup.picasso.w, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
