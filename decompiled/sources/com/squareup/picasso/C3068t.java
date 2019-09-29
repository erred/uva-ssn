package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.squareup.picasso.t */
/* compiled from: Picasso */
public class C3068t {

    /* renamed from: a */
    static final Handler f8019a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                if (i == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i2 < size) {
                        C3035c cVar = (C3035c) list.get(i2);
                        cVar.f7933b.mo27539a(cVar);
                        i2++;
                    }
                } else if (i == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i2 < size2) {
                        C3021a aVar = (C3021a) list2.get(i2);
                        aVar.f7877a.mo27543c(aVar);
                        i2++;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown handler message received: ");
                    sb.append(message.what);
                    throw new AssertionError(sb.toString());
                }
            } else {
                C3021a aVar2 = (C3021a) message.obj;
                if (aVar2.mo27428i().f8030l) {
                    C3030af.m8945a("Main", "canceled", aVar2.f7878b.mo27558a(), "target got garbage collected");
                }
                aVar2.f7877a.mo27540a(aVar2.mo27422c());
            }
        }
    };
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    static volatile C3068t f8020b = null;

    /* renamed from: c */
    final Context f8021c;

    /* renamed from: d */
    final C3048i f8022d;

    /* renamed from: e */
    final C3042d f8023e;

    /* renamed from: f */
    final C3023aa f8024f;

    /* renamed from: g */
    final Map<Object, C3021a> f8025g;

    /* renamed from: h */
    final Map<ImageView, C3047h> f8026h;

    /* renamed from: i */
    final ReferenceQueue<Object> f8027i;

    /* renamed from: j */
    final Config f8028j;

    /* renamed from: k */
    boolean f8029k;

    /* renamed from: l */
    volatile boolean f8030l;

    /* renamed from: m */
    boolean f8031m;

    /* renamed from: n */
    private final C3073c f8032n;

    /* renamed from: o */
    private final C3076f f8033o;

    /* renamed from: p */
    private final C3071b f8034p;

    /* renamed from: q */
    private final List<C3085y> f8035q;

    /* renamed from: com.squareup.picasso.t$a */
    /* compiled from: Picasso */
    public static class C3070a {

        /* renamed from: a */
        private final Context f8036a;

        /* renamed from: b */
        private C3053j f8037b;

        /* renamed from: c */
        private ExecutorService f8038c;

        /* renamed from: d */
        private C3042d f8039d;

        /* renamed from: e */
        private C3073c f8040e;

        /* renamed from: f */
        private C3076f f8041f;

        /* renamed from: g */
        private List<C3085y> f8042g;

        /* renamed from: h */
        private Config f8043h;

        /* renamed from: i */
        private boolean f8044i;

        /* renamed from: j */
        private boolean f8045j;

        public C3070a(Context context) {
            if (context != null) {
                this.f8036a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C3068t mo27545a() {
            Context context = this.f8036a;
            if (this.f8037b == null) {
                this.f8037b = new C3067s(context);
            }
            if (this.f8039d == null) {
                this.f8039d = new C3056m(context);
            }
            if (this.f8038c == null) {
                this.f8038c = new C3079v();
            }
            if (this.f8041f == null) {
                this.f8041f = C3076f.f8059a;
            }
            C3023aa aaVar = new C3023aa(this.f8039d);
            Context context2 = context;
            C3048i iVar = new C3048i(context2, this.f8038c, C3068t.f8019a, this.f8037b, this.f8039d, aaVar);
            C3068t tVar = new C3068t(context2, iVar, this.f8039d, this.f8040e, this.f8041f, this.f8042g, aaVar, this.f8043h, this.f8044i, this.f8045j);
            return tVar;
        }
    }

    /* renamed from: com.squareup.picasso.t$b */
    /* compiled from: Picasso */
    private static class C3071b extends Thread {

        /* renamed from: a */
        private final ReferenceQueue<Object> f8046a;

        /* renamed from: b */
        private final Handler f8047b;

        C3071b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f8046a = referenceQueue;
            this.f8047b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    C3022a aVar = (C3022a) this.f8046a.remove(1000);
                    Message obtainMessage = this.f8047b.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f7889a;
                        this.f8047b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.f8047b.post(new Runnable() {
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* renamed from: com.squareup.picasso.t$c */
    /* compiled from: Picasso */
    public interface C3073c {
        /* renamed from: a */
        void mo27548a(C3068t tVar, Uri uri, Exception exc);
    }

    /* renamed from: com.squareup.picasso.t$d */
    /* compiled from: Picasso */
    public enum C3074d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        

        /* renamed from: d */
        final int f8054d;

        private C3074d(int i) {
            this.f8054d = i;
        }
    }

    /* renamed from: com.squareup.picasso.t$e */
    /* compiled from: Picasso */
    public enum C3075e {
        LOW,
        NORMAL,
        HIGH
    }

    /* renamed from: com.squareup.picasso.t$f */
    /* compiled from: Picasso */
    public interface C3076f {

        /* renamed from: a */
        public static final C3076f f8059a = new C3076f() {
            /* renamed from: a */
            public C3081w mo27549a(C3081w wVar) {
                return wVar;
            }
        };

        /* renamed from: a */
        C3081w mo27549a(C3081w wVar);
    }

    C3068t(Context context, C3048i iVar, C3042d dVar, C3073c cVar, C3076f fVar, List<C3085y> list, C3023aa aaVar, Config config, boolean z, boolean z2) {
        this.f8021c = context;
        this.f8022d = iVar;
        this.f8023e = dVar;
        this.f8032n = cVar;
        this.f8033o = fVar;
        this.f8028j = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new C3087z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C3045f(context));
        arrayList.add(new C3060o(context));
        arrayList.add(new C3046g(context));
        arrayList.add(new C3034b(context));
        arrayList.add(new C3054k(context));
        arrayList.add(new C3064r(iVar.f7966d, aaVar));
        this.f8035q = Collections.unmodifiableList(arrayList);
        this.f8024f = aaVar;
        this.f8025g = new WeakHashMap();
        this.f8026h = new WeakHashMap();
        this.f8029k = z;
        this.f8030l = z2;
        this.f8027i = new ReferenceQueue<>();
        this.f8034p = new C3071b(this.f8027i, f8019a);
        this.f8034p.start();
    }

    /* renamed from: a */
    public void mo27535a(ImageView imageView) {
        if (imageView != null) {
            mo27540a((Object) imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    /* renamed from: a */
    public void mo27538a(C3027ac acVar) {
        if (acVar != null) {
            mo27540a((Object) acVar);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    /* renamed from: a */
    public C3084x mo27532a(Uri uri) {
        return new C3084x(this, uri, 0);
    }

    /* renamed from: a */
    public C3084x mo27533a(String str) {
        if (str == null) {
            return new C3084x(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return mo27532a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C3085y> mo27534a() {
        return this.f8035q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3081w mo27531a(C3081w wVar) {
        C3081w a = this.f8033o.mo27549a(wVar);
        if (a != null) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Request transformer ");
        sb.append(this.f8033o.getClass().getCanonicalName());
        sb.append(" returned null for ");
        sb.append(wVar);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27536a(ImageView imageView, C3047h hVar) {
        if (this.f8026h.containsKey(imageView)) {
            mo27540a((Object) imageView);
        }
        this.f8026h.put(imageView, hVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27537a(C3021a aVar) {
        Object c = aVar.mo27422c();
        if (!(c == null || this.f8025g.get(c) == aVar)) {
            mo27540a(c);
            this.f8025g.put(c, aVar);
        }
        mo27542b(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27542b(C3021a aVar) {
        this.f8022d.mo27493a(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Bitmap mo27541b(String str) {
        Bitmap a = this.f8023e.mo27481a(str);
        if (a != null) {
            this.f8024f.mo27431a();
        } else {
            this.f8024f.mo27435b();
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27539a(C3035c cVar) {
        C3021a i = cVar.mo27467i();
        List k = cVar.mo27469k();
        boolean z = true;
        boolean z2 = k != null && !k.isEmpty();
        if (i == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = cVar.mo27466h().f8073d;
            Exception l = cVar.mo27470l();
            Bitmap e = cVar.mo27463e();
            C3074d m = cVar.mo27471m();
            if (i != null) {
                m9057a(e, m, i, l);
            }
            if (z2) {
                int size = k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m9057a(e, m, (C3021a) k.get(i2), l);
                }
            }
            if (!(this.f8032n == null || l == null)) {
                this.f8032n.mo27548a(this, uri, l);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo27543c(C3021a aVar) {
        Bitmap b = C3062p.m9045a(aVar.f7881e) ? mo27541b(aVar.mo27423d()) : null;
        if (b != null) {
            m9057a(b, C3074d.MEMORY, aVar, null);
            if (this.f8030l) {
                String a = aVar.f7878b.mo27558a();
                StringBuilder sb = new StringBuilder();
                sb.append("from ");
                sb.append(C3074d.MEMORY);
                C3030af.m8945a("Main", "completed", a, sb.toString());
                return;
            }
            return;
        }
        mo27537a(aVar);
        if (this.f8030l) {
            C3030af.m8944a("Main", "resumed", aVar.f7878b.mo27558a());
        }
    }

    /* renamed from: a */
    private void m9057a(Bitmap bitmap, C3074d dVar, C3021a aVar, Exception exc) {
        if (!aVar.mo27424e()) {
            if (!aVar.mo27425f()) {
                this.f8025g.remove(aVar.mo27422c());
            }
            if (bitmap == null) {
                aVar.mo27420a(exc);
                if (this.f8030l) {
                    C3030af.m8945a("Main", "errored", aVar.f7878b.mo27558a(), exc.getMessage());
                }
            } else if (dVar != null) {
                aVar.mo27419a(bitmap, dVar);
                if (this.f8030l) {
                    String a = aVar.f7878b.mo27558a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("from ");
                    sb.append(dVar);
                    C3030af.m8945a("Main", "completed", a, sb.toString());
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27540a(Object obj) {
        C3030af.m8942a();
        C3021a aVar = (C3021a) this.f8025g.remove(obj);
        if (aVar != null) {
            aVar.mo27418a();
            this.f8022d.mo27500b(aVar);
        }
        if (obj instanceof ImageView) {
            C3047h hVar = (C3047h) this.f8026h.remove((ImageView) obj);
            if (hVar != null) {
                hVar.mo27487a();
            }
        }
    }

    /* renamed from: b */
    public static C3068t m9058b() {
        if (f8020b == null) {
            synchronized (C3068t.class) {
                if (f8020b == null) {
                    if (PicassoProvider.f7876a != null) {
                        f8020b = new C3070a(PicassoProvider.f7876a).mo27545a();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return f8020b;
    }
}
