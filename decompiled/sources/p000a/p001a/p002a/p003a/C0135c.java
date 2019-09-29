package p000a.p001a.p002a.p003a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002a.p003a.C0000a.C0003b;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p007c.C0062d;
import p000a.p001a.p002a.p003a.p004a.p007c.C0071k;
import p000a.p001a.p002a.p003a.p004a.p007c.C0073l;
import p000a.p001a.p002a.p003a.p004a.p007c.C0074m;

/* renamed from: a.a.a.a.c */
/* compiled from: Fabric */
public class C0135c {

    /* renamed from: a */
    static volatile C0135c f311a;

    /* renamed from: b */
    static final C0149l f312b = new C0134b();

    /* renamed from: c */
    final C0149l f313c;

    /* renamed from: d */
    final boolean f314d;

    /* renamed from: e */
    private final Context f315e;

    /* renamed from: f */
    private final Map<Class<? extends C0146i>, C0146i> f316f;

    /* renamed from: g */
    private final ExecutorService f317g;

    /* renamed from: h */
    private final Handler f318h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C0141f<C0135c> f319i;

    /* renamed from: j */
    private final C0141f<?> f320j;

    /* renamed from: k */
    private final C0032o f321k;

    /* renamed from: l */
    private C0000a f322l;

    /* renamed from: m */
    private WeakReference<Activity> f323m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AtomicBoolean f324n = new AtomicBoolean(false);

    /* renamed from: a.a.a.a.c$a */
    /* compiled from: Fabric */
    public static class C0138a {

        /* renamed from: a */
        private final Context f329a;

        /* renamed from: b */
        private C0146i[] f330b;

        /* renamed from: c */
        private C0071k f331c;

        /* renamed from: d */
        private Handler f332d;

        /* renamed from: e */
        private C0149l f333e;

        /* renamed from: f */
        private boolean f334f;

        /* renamed from: g */
        private String f335g;

        /* renamed from: h */
        private String f336h;

        /* renamed from: i */
        private C0141f<C0135c> f337i;

        public C0138a(Context context) {
            if (context != null) {
                this.f329a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C0138a mo294a(C0146i... iVarArr) {
            if (this.f330b == null) {
                this.f330b = iVarArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        /* renamed from: a */
        public C0135c mo295a() {
            Map a;
            if (this.f331c == null) {
                this.f331c = C0071k.m232a();
            }
            if (this.f332d == null) {
                this.f332d = new Handler(Looper.getMainLooper());
            }
            if (this.f333e == null) {
                if (this.f334f) {
                    this.f333e = new C0134b(3);
                } else {
                    this.f333e = new C0134b();
                }
            }
            if (this.f336h == null) {
                this.f336h = this.f329a.getPackageName();
            }
            if (this.f337i == null) {
                this.f337i = C0141f.f341d;
            }
            if (this.f330b == null) {
                a = new HashMap();
            } else {
                a = C0135c.m445b((Collection<? extends C0146i>) Arrays.asList(this.f330b));
            }
            Map map = a;
            Context applicationContext = this.f329a.getApplicationContext();
            C0135c cVar = new C0135c(applicationContext, map, this.f331c, this.f332d, this.f333e, this.f334f, this.f337i, new C0032o(applicationContext, this.f336h, this.f335g, map.values()), C0135c.m448d(this.f329a));
            return cVar;
        }
    }

    /* renamed from: c */
    public String mo287c() {
        return "1.3.17.dev";
    }

    /* renamed from: d */
    public String mo288d() {
        return "io.fabric.sdk.android:fabric";
    }

    /* renamed from: a */
    static C0135c m438a() {
        if (f311a != null) {
            return f311a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C0135c(Context context, Map<Class<? extends C0146i>, C0146i> map, C0071k kVar, Handler handler, C0149l lVar, boolean z, C0141f fVar, C0032o oVar, Activity activity) {
        this.f315e = context;
        this.f316f = map;
        this.f317g = kVar;
        this.f318h = handler;
        this.f313c = lVar;
        this.f314d = z;
        this.f319i = fVar;
        this.f320j = mo282a(map.size());
        this.f321k = oVar;
        mo281a(activity);
    }

    /* renamed from: a */
    public static C0135c m439a(Context context, C0146i... iVarArr) {
        if (f311a == null) {
            synchronized (C0135c.class) {
                if (f311a == null) {
                    m447c(new C0138a(context).mo294a(iVarArr).mo295a());
                }
            }
        }
        return f311a;
    }

    /* renamed from: c */
    private static void m447c(C0135c cVar) {
        f311a = cVar;
        cVar.m451j();
    }

    /* renamed from: a */
    public C0135c mo281a(Activity activity) {
        this.f323m = new WeakReference<>(activity);
        return this;
    }

    /* renamed from: b */
    public Activity mo285b() {
        if (this.f323m != null) {
            return (Activity) this.f323m.get();
        }
        return null;
    }

    /* renamed from: j */
    private void m451j() {
        this.f322l = new C0000a(this.f315e);
        this.f322l.mo2a(new C0003b() {
            /* renamed from: a */
            public void mo11a(Activity activity, Bundle bundle) {
                C0135c.this.mo281a(activity);
            }

            /* renamed from: a */
            public void mo10a(Activity activity) {
                C0135c.this.mo281a(activity);
            }

            /* renamed from: b */
            public void mo12b(Activity activity) {
                C0135c.this.mo281a(activity);
            }
        });
        mo283a(this.f315e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo283a(Context context) {
        StringBuilder sb;
        Future b = mo286b(context);
        Collection g = mo291g();
        C0150m mVar = new C0150m(b, g);
        ArrayList<C0146i> arrayList = new ArrayList<>(g);
        Collections.sort(arrayList);
        mVar.mo310a(context, this, C0141f.f341d, this.f321k);
        for (C0146i a : arrayList) {
            a.mo310a(context, this, this.f320j, this.f321k);
        }
        mVar.mo318o();
        if (m449h().mo272a("Fabric", 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(mo288d());
            sb.append(" [Version: ");
            sb.append(mo287c());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (C0146i iVar : arrayList) {
            iVar.f344f.mo106c((C0073l) mVar.f344f);
            mo284a(this.f316f, iVar);
            iVar.mo318o();
            if (sb != null) {
                sb.append(iVar.mo312b());
                sb.append(" [Version: ");
                sb.append(iVar.mo309a());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            m449h().mo270a("Fabric", sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo284a(Map<Class<? extends C0146i>, C0146i> map, C0146i iVar) {
        Class[] a;
        C0062d dVar = iVar.f348j;
        if (dVar != null) {
            for (Class cls : dVar.mo131a()) {
                if (cls.isInterface()) {
                    for (C0146i iVar2 : map.values()) {
                        if (cls.isAssignableFrom(iVar2.getClass())) {
                            iVar.f344f.mo106c((C0073l) iVar2.f344f);
                        }
                    }
                } else if (((C0146i) map.get(cls)) != null) {
                    iVar.f344f.mo106c((C0073l) ((C0146i) map.get(cls)).f344f);
                } else {
                    throw new C0074m("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Activity m448d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    /* renamed from: e */
    public C0000a mo289e() {
        return this.f322l;
    }

    /* renamed from: f */
    public ExecutorService mo290f() {
        return this.f317g;
    }

    /* renamed from: g */
    public Collection<C0146i> mo291g() {
        return this.f316f.values();
    }

    /* renamed from: a */
    public static <T extends C0146i> T m440a(Class<T> cls) {
        return (C0146i) m438a().f316f.get(cls);
    }

    /* renamed from: h */
    public static C0149l m449h() {
        if (f311a == null) {
            return f312b;
        }
        return f311a.f313c;
    }

    /* renamed from: i */
    public static boolean m450i() {
        if (f311a == null) {
            return false;
        }
        return f311a.f314d;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Map<Class<? extends C0146i>, C0146i> m445b(Collection<? extends C0146i> collection) {
        HashMap hashMap = new HashMap(collection.size());
        m443a((Map<Class<? extends C0146i>, C0146i>) hashMap, collection);
        return hashMap;
    }

    /* renamed from: a */
    private static void m443a(Map<Class<? extends C0146i>, C0146i> map, Collection<? extends C0146i> collection) {
        for (C0146i iVar : collection) {
            map.put(iVar.getClass(), iVar);
            if (iVar instanceof C0147j) {
                m443a(map, ((C0147j) iVar).mo325c());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0141f<?> mo282a(final int i) {
        return new C0141f() {

            /* renamed from: a */
            final CountDownLatch f326a = new CountDownLatch(i);

            /* renamed from: a */
            public void mo293a(Object obj) {
                this.f326a.countDown();
                if (this.f326a.getCount() == 0) {
                    C0135c.this.f324n.set(true);
                    C0135c.this.f319i.mo293a(C0135c.this);
                }
            }

            /* renamed from: a */
            public void mo292a(Exception exc) {
                C0135c.this.f319i.mo292a(exc);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Future<Map<String, C0148k>> mo286b(Context context) {
        return mo290f().submit(new C0140e(context.getPackageCodePath()));
    }
}
