package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.squareup.picasso.i */
/* compiled from: Dispatcher */
class C3048i {

    /* renamed from: a */
    final C3051b f7963a = new C3051b();

    /* renamed from: b */
    final Context f7964b;

    /* renamed from: c */
    final ExecutorService f7965c;

    /* renamed from: d */
    final C3053j f7966d;

    /* renamed from: e */
    final Map<String, C3035c> f7967e;

    /* renamed from: f */
    final Map<Object, C3021a> f7968f;

    /* renamed from: g */
    final Map<Object, C3021a> f7969g;

    /* renamed from: h */
    final Set<Object> f7970h;

    /* renamed from: i */
    final Handler f7971i;

    /* renamed from: j */
    final Handler f7972j;

    /* renamed from: k */
    final C3042d f7973k;

    /* renamed from: l */
    final C3023aa f7974l;

    /* renamed from: m */
    final List<C3035c> f7975m;

    /* renamed from: n */
    final C3052c f7976n;

    /* renamed from: o */
    final boolean f7977o;

    /* renamed from: p */
    boolean f7978p;

    /* renamed from: com.squareup.picasso.i$a */
    /* compiled from: Dispatcher */
    private static class C3049a extends Handler {

        /* renamed from: a */
        private final C3048i f7979a;

        C3049a(Looper looper, C3048i iVar) {
            super(looper);
            this.f7979a = iVar;
        }

        public void handleMessage(final Message message) {
            boolean z = false;
            switch (message.what) {
                case 1:
                    this.f7979a.mo27504c((C3021a) message.obj);
                    return;
                case 2:
                    this.f7979a.mo27506d((C3021a) message.obj);
                    return;
                case 4:
                    this.f7979a.mo27508e((C3035c) message.obj);
                    return;
                case 5:
                    this.f7979a.mo27507d((C3035c) message.obj);
                    return;
                case 6:
                    this.f7979a.mo27496a((C3035c) message.obj, false);
                    return;
                case 7:
                    this.f7979a.mo27491a();
                    return;
                case 9:
                    this.f7979a.mo27499b((NetworkInfo) message.obj);
                    return;
                case 10:
                    C3048i iVar = this.f7979a;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    iVar.mo27503b(z);
                    return;
                case 11:
                    this.f7979a.mo27497a(message.obj);
                    return;
                case 12:
                    this.f7979a.mo27502b(message.obj);
                    return;
                default:
                    C3068t.f8019a.post(new Runnable() {
                        public void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unknown handler message received: ");
                            sb.append(message.what);
                            throw new AssertionError(sb.toString());
                        }
                    });
                    return;
            }
        }
    }

    /* renamed from: com.squareup.picasso.i$b */
    /* compiled from: Dispatcher */
    static class C3051b extends HandlerThread {
        C3051b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* renamed from: com.squareup.picasso.i$c */
    /* compiled from: Dispatcher */
    static class C3052c extends BroadcastReceiver {

        /* renamed from: a */
        private final C3048i f7982a;

        C3052c(C3048i iVar) {
            this.f7982a = iVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo27511a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f7982a.f7977o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f7982a.f7964b.registerReceiver(this, intentFilter);
        }

        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f7982a.mo27498a(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f7982a.mo27492a(((ConnectivityManager) C3030af.m8936a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    C3048i(Context context, ExecutorService executorService, Handler handler, C3053j jVar, C3042d dVar, C3023aa aaVar) {
        this.f7963a.start();
        C3030af.m8943a(this.f7963a.getLooper());
        this.f7964b = context;
        this.f7965c = executorService;
        this.f7967e = new LinkedHashMap();
        this.f7968f = new WeakHashMap();
        this.f7969g = new WeakHashMap();
        this.f7970h = new LinkedHashSet();
        this.f7971i = new C3049a(this.f7963a.getLooper(), this);
        this.f7966d = jVar;
        this.f7972j = handler;
        this.f7973k = dVar;
        this.f7974l = aaVar;
        this.f7975m = new ArrayList(4);
        this.f7978p = C3030af.m8950c(this.f7964b);
        this.f7977o = C3030af.m8949b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f7976n = new C3052c(this);
        this.f7976n.mo27511a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27493a(C3021a aVar) {
        this.f7971i.sendMessage(this.f7971i.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27500b(C3021a aVar) {
        this.f7971i.sendMessage(this.f7971i.obtainMessage(2, aVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27495a(C3035c cVar) {
        this.f7971i.sendMessage(this.f7971i.obtainMessage(4, cVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27501b(C3035c cVar) {
        this.f7971i.sendMessageDelayed(this.f7971i.obtainMessage(5, cVar), 500);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo27505c(C3035c cVar) {
        this.f7971i.sendMessage(this.f7971i.obtainMessage(6, cVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27492a(NetworkInfo networkInfo) {
        this.f7971i.sendMessage(this.f7971i.obtainMessage(9, networkInfo));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27498a(boolean z) {
        this.f7971i.sendMessage(this.f7971i.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo27504c(C3021a aVar) {
        mo27494a(aVar, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27494a(C3021a aVar, boolean z) {
        if (this.f7970h.contains(aVar.mo27430k())) {
            this.f7969g.put(aVar.mo27422c(), aVar);
            if (aVar.mo27428i().f8030l) {
                String a = aVar.f7878b.mo27558a();
                StringBuilder sb = new StringBuilder();
                sb.append("because tag '");
                sb.append(aVar.mo27430k());
                sb.append("' is paused");
                C3030af.m8945a("Dispatcher", "paused", a, sb.toString());
            }
            return;
        }
        C3035c cVar = (C3035c) this.f7967e.get(aVar.mo27423d());
        if (cVar != null) {
            cVar.mo27457a(aVar);
        } else if (this.f7965c.isShutdown()) {
            if (aVar.mo27428i().f8030l) {
                C3030af.m8945a("Dispatcher", "ignored", aVar.f7878b.mo27558a(), "because shut down");
            }
        } else {
            C3035c a2 = C3035c.m8958a(aVar.mo27428i(), this, this.f7973k, this.f7974l, aVar);
            a2.f7945n = this.f7965c.submit(a2);
            this.f7967e.put(aVar.mo27423d(), a2);
            if (z) {
                this.f7968f.remove(aVar.mo27422c());
            }
            if (aVar.mo27428i().f8030l) {
                C3030af.m8944a("Dispatcher", "enqueued", aVar.f7878b.mo27558a());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo27506d(C3021a aVar) {
        String d = aVar.mo27423d();
        C3035c cVar = (C3035c) this.f7967e.get(d);
        if (cVar != null) {
            cVar.mo27459b(aVar);
            if (cVar.mo27460b()) {
                this.f7967e.remove(d);
                if (aVar.mo27428i().f8030l) {
                    C3030af.m8944a("Dispatcher", "canceled", aVar.mo27421b().mo27558a());
                }
            }
        }
        if (this.f7970h.contains(aVar.mo27430k())) {
            this.f7969g.remove(aVar.mo27422c());
            if (aVar.mo27428i().f8030l) {
                C3030af.m8945a("Dispatcher", "canceled", aVar.mo27421b().mo27558a(), "because paused request got canceled");
            }
        }
        C3021a aVar2 = (C3021a) this.f7968f.remove(aVar.mo27422c());
        if (aVar2 != null && aVar2.mo27428i().f8030l) {
            C3030af.m8945a("Dispatcher", "canceled", aVar2.mo27421b().mo27558a(), "from replaying");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27497a(Object obj) {
        if (this.f7970h.add(obj)) {
            Iterator it = this.f7967e.values().iterator();
            while (it.hasNext()) {
                C3035c cVar = (C3035c) it.next();
                boolean z = cVar.mo27468j().f8030l;
                C3021a i = cVar.mo27467i();
                List k = cVar.mo27469k();
                boolean z2 = k != null && !k.isEmpty();
                if (i != null || z2) {
                    if (i != null && i.mo27430k().equals(obj)) {
                        cVar.mo27459b(i);
                        this.f7969g.put(i.mo27422c(), i);
                        if (z) {
                            String a = i.f7878b.mo27558a();
                            StringBuilder sb = new StringBuilder();
                            sb.append("because tag '");
                            sb.append(obj);
                            sb.append("' was paused");
                            C3030af.m8945a("Dispatcher", "paused", a, sb.toString());
                        }
                    }
                    if (z2) {
                        for (int size = k.size() - 1; size >= 0; size--) {
                            C3021a aVar = (C3021a) k.get(size);
                            if (aVar.mo27430k().equals(obj)) {
                                cVar.mo27459b(aVar);
                                this.f7969g.put(aVar.mo27422c(), aVar);
                                if (z) {
                                    String a2 = aVar.f7878b.mo27558a();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("because tag '");
                                    sb2.append(obj);
                                    sb2.append("' was paused");
                                    C3030af.m8945a("Dispatcher", "paused", a2, sb2.toString());
                                }
                            }
                        }
                    }
                    if (cVar.mo27460b()) {
                        it.remove();
                        if (z) {
                            C3030af.m8945a("Dispatcher", "canceled", C3030af.m8938a(cVar), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27502b(Object obj) {
        if (this.f7970h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator it = this.f7969g.values().iterator();
            while (it.hasNext()) {
                C3021a aVar = (C3021a) it.next();
                if (aVar.mo27430k().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                    it.remove();
                }
            }
            if (arrayList != null) {
                this.f7972j.sendMessage(this.f7972j.obtainMessage(13, arrayList));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"MissingPermission"})
    /* renamed from: d */
    public void mo27507d(C3035c cVar) {
        if (!cVar.mo27461c()) {
            boolean z = false;
            if (this.f7965c.isShutdown()) {
                mo27496a(cVar, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.f7977o) {
                networkInfo = ((ConnectivityManager) C3030af.m8936a(this.f7964b, "connectivity")).getActiveNetworkInfo();
            }
            if (cVar.mo27458a(this.f7978p, networkInfo)) {
                if (cVar.mo27468j().f8030l) {
                    C3030af.m8944a("Dispatcher", "retrying", C3030af.m8938a(cVar));
                }
                if (cVar.mo27470l() instanceof C3065a) {
                    cVar.f7940i |= C3063q.NO_CACHE.f8011d;
                }
                cVar.f7945n = this.f7965c.submit(cVar);
            } else {
                if (this.f7977o && cVar.mo27462d()) {
                    z = true;
                }
                mo27496a(cVar, z);
                if (z) {
                    m9003f(cVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo27508e(C3035c cVar) {
        if (C3062p.m9046b(cVar.mo27465g())) {
            this.f7973k.mo27482a(cVar.mo27464f(), cVar.mo27463e());
        }
        this.f7967e.remove(cVar.mo27464f());
        m9004g(cVar);
        if (cVar.mo27468j().f8030l) {
            C3030af.m8945a("Dispatcher", "batched", C3030af.m8938a(cVar), "for completion");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27491a() {
        ArrayList arrayList = new ArrayList(this.f7975m);
        this.f7975m.clear();
        this.f7972j.sendMessage(this.f7972j.obtainMessage(8, arrayList));
        m9000a((List<C3035c>) arrayList);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27496a(C3035c cVar, boolean z) {
        if (cVar.mo27468j().f8030l) {
            String str = "Dispatcher";
            String str2 = "batched";
            String a = C3030af.m8938a(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            C3030af.m8945a(str, str2, a, sb.toString());
        }
        this.f7967e.remove(cVar.mo27464f());
        m9004g(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27503b(boolean z) {
        this.f7978p = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27499b(NetworkInfo networkInfo) {
        if (this.f7965c instanceof C3079v) {
            ((C3079v) this.f7965c).mo27554a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            m9001b();
        }
    }

    /* renamed from: b */
    private void m9001b() {
        if (!this.f7968f.isEmpty()) {
            Iterator it = this.f7968f.values().iterator();
            while (it.hasNext()) {
                C3021a aVar = (C3021a) it.next();
                it.remove();
                if (aVar.mo27428i().f8030l) {
                    C3030af.m8944a("Dispatcher", "replaying", aVar.mo27421b().mo27558a());
                }
                mo27494a(aVar, false);
            }
        }
    }

    /* renamed from: f */
    private void m9003f(C3035c cVar) {
        C3021a i = cVar.mo27467i();
        if (i != null) {
            m9002e(i);
        }
        List k = cVar.mo27469k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                m9002e((C3021a) k.get(i2));
            }
        }
    }

    /* renamed from: e */
    private void m9002e(C3021a aVar) {
        Object c = aVar.mo27422c();
        if (c != null) {
            aVar.f7887k = true;
            this.f7968f.put(c, aVar);
        }
    }

    /* renamed from: g */
    private void m9004g(C3035c cVar) {
        if (!cVar.mo27461c()) {
            if (cVar.f7944m != null) {
                cVar.f7944m.prepareToDraw();
            }
            this.f7975m.add(cVar);
            if (!this.f7971i.hasMessages(7)) {
                this.f7971i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    /* renamed from: a */
    private void m9000a(List<C3035c> list) {
        if (list != null && !list.isEmpty() && ((C3035c) list.get(0)).mo27468j().f8030l) {
            StringBuilder sb = new StringBuilder();
            for (C3035c cVar : list) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(C3030af.m8938a(cVar));
            }
            C3030af.m8944a("Dispatcher", "delivered", sb.toString());
        }
    }
}
